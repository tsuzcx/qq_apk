package com.tencent.mobileqq.mini.manager;

import NS_MINI_AD.MiniAppAd.SpecifiedAdsItem;
import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.OnDismissListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniLoadingAdManager
{
  private static final String DEFAULT_UNSUPPORT_VIA_LIST = "2054_1,2054_2,2054_3,2054_4,2054_5,2054_6,2054_7,2054_8,2054_9,2054_10,2054_11,2054_12,2054_13,2054_14,2054_15,2054_17,2054_18,2054_19";
  private static final String EXTRA_PRELOAD_INTERVAL_CHECK_PREFIX = "mini_loading_ad_extra_preload_interval_check_";
  public static final String KEY_APP_CONFIG = "app_config";
  public static final String KEY_UIN = "uin";
  public static final int LOADING_AD_LIMIT_TYPE_PRELOAD = 1;
  public static final int LOADING_AD_LIMIT_TYPE_SELECT = 0;
  private static final String PRELOAD_ADJSON_KEY_PREFEX = "mini_loading_ad_preload_adjson_key_";
  private static final String PRELOAD_PREFIX = "mini_loading_ad_preload_";
  private static final String SELECT_PREFIX = "mini_loading_ad_select_";
  public static final String TAG = "MiniLoadingAdManager";
  private static final String VIA_AD_PREFIX = "2054_";
  private static HashMap<Long, String> cachedAidFilePathMap = new HashMap();
  private static long maxAdCachedSize = 20971520L;
  private static volatile MiniLoadingAdManager sInstance;
  private int extraPreloadInterval = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_preload_interval", 0);
  private int maxPreloadCountForUin = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_user_preload_limit", 2147483647);
  private int maxPreloadCountForUinAndAppid = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_preload_limit", 5);
  private int maxSelectCountForUin = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_user_select_limit", 5);
  private int maxSelectCountForUinAndAppid = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_select_limit", 2);
  private String unsupportedViaList = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_unsupport_via_list", "2054_1,2054_2,2054_3,2054_4,2054_5,2054_6,2054_7,2054_8,2054_9,2054_10,2054_11,2054_12,2054_13,2054_14,2054_15,2054_17,2054_18,2054_19");
  
  private static void checkCacheFolder()
  {
    if (FileUtils.b(MiniAppFileManager.getLoadingAdCacheFolder()) > maxAdCachedSize)
    {
      QLog.d("MiniLoadingAdManager", 1, "checkCacheFolder size > maxAdCachedSize ");
      FileUtils.b(MiniAppFileManager.getLoadingAdCacheFolder());
    }
  }
  
  private boolean checkLoadingAdFrequencyLimitation(@NonNull String paramString1, @NonNull String paramString2, @MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt)
  {
    boolean bool2 = false;
    String str1 = getPrefix(paramInt) + paramString2;
    String str2 = str1 + "_times";
    paramString1 = getPrefix(paramInt) + paramString2 + "_" + paramString1;
    paramString2 = paramString1 + "_times";
    long l1 = StorageUtil.getPreference().getLong(str1, 0L);
    int i = StorageUtil.getPreference().getInt(str2, 0);
    long l2 = StorageUtil.getPreference().getLong(paramString1, 0L);
    int j = StorageUtil.getPreference().getInt(paramString2, 0);
    boolean bool1;
    if ((l1 != getCurZeroTimeMillis()) || (i < 1)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (i >= getLimit(paramInt, false));
      if ((l2 != getCurZeroTimeMillis()) || (j < 1)) {
        return true;
      }
      bool1 = bool2;
    } while (j >= getLimit(paramInt, true));
    return true;
  }
  
  private boolean checkSelectAdNecessity(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if ((paramMiniAppConfig == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("MiniLoadingAdManager", 1, "checkSelectAdNecessity 参数不合法");
      return false;
    }
    if ((paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramMiniAppConfig.config.appId)) || (!paramMiniAppConfig.config.enableLoadingAd))
    {
      QLog.d("MiniLoadingAdManager", 1, "checkSelectAdNecessity 没开广告位");
      return false;
    }
    if (isViaUnsupported(paramMiniAppConfig.config.via))
    {
      QLog.d("MiniLoadingAdManager", 1, "checkSelectAdNecessity via不支持");
      return false;
    }
    if (!checkLoadingAdFrequencyLimitation(paramMiniAppConfig.config.appId, paramString, 0))
    {
      QLog.d("MiniLoadingAdManager", 1, "checkSelectAdNecessity 频控限制");
      return false;
    }
    return true;
  }
  
  public static void downloadAndSaveLoadingAd(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("MiniLoadingAdManager", 1, "downloadAndSaveLoadingAd 预加载广告缓存逻辑start");
    Object localObject = "mini_loading_ad_preload_adjson_key_" + paramString2 + "_" + paramString3;
    StorageUtil.getPreference().edit().putString((String)localObject, new JSONObject().toString()).apply();
    checkCacheFolder();
    paramString1 = AdUtils.convertJson2GdtAds(paramString1);
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      QLog.d("MiniLoadingAdManager", 1, "downloadAndSaveLoadingAd 广告数据为空");
    }
    for (;;)
    {
      return;
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        localObject = new MiniLoadingAdManager.CachedAdInfo((GdtAd)paramString1.next(), paramString2, paramString3);
        if (((MiniLoadingAdManager.CachedAdInfo)localObject).isValid()) {
          ThreadPools.getNetworkIOThreadPool().execute(new MiniLoadingAdManager.6((MiniLoadingAdManager.CachedAdInfo)localObject));
        } else {
          QLog.d("MiniLoadingAdManager", 1, "downloadAndSaveLoadingAd 广告数据不合法或已经下载过");
        }
      }
    }
  }
  
  private boolean extraPreloadIntervalCheck(String paramString1, String paramString2)
  {
    paramString1 = "mini_loading_ad_extra_preload_interval_check__" + paramString2 + "_" + paramString1;
    long l = StorageUtil.getPreference().getLong(paramString1, -1L);
    return (l <= 0L) || ((System.currentTimeMillis() - l) / 1000L > this.extraPreloadInterval);
  }
  
  private static void extraPreloadIntervalUpdate(String paramString1, String paramString2)
  {
    paramString1 = "mini_loading_ad_extra_preload_interval_check__" + paramString2 + "_" + paramString1;
    StorageUtil.getPreference().edit().putLong(paramString1, System.currentTimeMillis()).apply();
  }
  
  private static MiniAppAd.StGetAdReq getAdReq(MiniAppConfig paramMiniAppConfig, String paramString, int paramInt)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.isEngineTypeMiniGame()))
    {
      i = 1;
      if (i != 0) {
        break label222;
      }
    }
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    String str1;
    int j;
    label222:
    for (int i = 14;; i = 15)
    {
      localObject3 = "";
      localObject4 = "";
      String str4 = "";
      String str2 = "";
      String str3 = "";
      localObject2 = localObject3;
      localObject1 = localObject4;
      str1 = str4;
      if (paramMiniAppConfig != null)
      {
        localObject2 = localObject3;
        localObject1 = localObject4;
        str1 = str4;
        if (paramMiniAppConfig.launchParam != null)
        {
          localObject2 = paramMiniAppConfig.launchParam.entryPath;
          localObject1 = paramMiniAppConfig.launchParam.reportData;
          str1 = String.valueOf(paramMiniAppConfig.launchParam.scene);
        }
      }
      localObject4 = str3;
      localObject3 = str2;
      if (paramMiniAppConfig != null)
      {
        localObject4 = str3;
        localObject3 = str2;
        if (paramMiniAppConfig.config != null)
        {
          localObject3 = paramMiniAppConfig.config.via;
          localObject4 = paramMiniAppConfig.config.appId;
        }
      }
      paramMiniAppConfig = AdUtils.getSpAdGdtCookie(i);
      j = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniGameShareRate", 53);
      if (paramInt != 0) {
        break label228;
      }
      return AdUtils.createAdRequest(BaseApplicationImpl.getContext(), Long.parseLong(paramString), "", (String)localObject4, j, i, 0, paramMiniAppConfig, (String)localObject2, (String)localObject1, str1, (String)localObject3, 1, 2, getCurCachedAdsList(paramString, (String)localObject4));
      i = 0;
      break;
    }
    label228:
    if (paramInt == 1) {
      return AdUtils.createAdRequest(BaseApplicationImpl.getContext(), Long.parseLong(paramString), "", (String)localObject4, j, i, 0, paramMiniAppConfig, (String)localObject2, (String)localObject1, str1, (String)localObject3, 1, 1, null);
    }
    return null;
  }
  
  public static ArrayList<MiniAppAd.SpecifiedAdsItem> getCurCachedAdsList(String paramString1, String paramString2)
  {
    cachedAidFilePathMap.clear();
    paramString1 = "mini_loading_ad_preload_adjson_key_" + paramString1 + "_" + paramString2;
    paramString1 = StorageUtil.getPreference().getString(paramString1, new JSONObject().toString());
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 == null) {
        return null;
      }
      paramString1 = paramString1.optJSONArray("adArray");
      if ((paramString1 != null) && (paramString1.length() >= 1))
      {
        paramString2 = new ArrayList();
        int i = 0;
        while (i < paramString1.length())
        {
          MiniAppAd.SpecifiedAdsItem localSpecifiedAdsItem = new MiniAppAd.SpecifiedAdsItem();
          JSONObject localJSONObject = paramString1.getJSONObject(i);
          if (localJSONObject != null)
          {
            String str = localJSONObject.getString("filePath");
            if (new File(str).exists())
            {
              long l = localJSONObject.getLong("aid");
              cachedAidFilePathMap.put(Long.valueOf(l), str);
              localSpecifiedAdsItem.aid.set(l);
              localSpecifiedAdsItem.creative_id.set(localJSONObject.getLong("creativeId"));
              paramString2.add(localSpecifiedAdsItem);
            }
          }
          i += 1;
        }
        return paramString2;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static long getCurZeroTimeMillis()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static MiniLoadingAdManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MiniLoadingAdManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private long getLimit(@MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return 0L;
    case 0: 
      if (paramBoolean) {
        return this.maxSelectCountForUinAndAppid;
      }
      return this.maxSelectCountForUin;
    }
    if (paramBoolean) {
      return this.maxPreloadCountForUinAndAppid;
    }
    return this.maxPreloadCountForUin;
  }
  
  private static String getPrefix(@MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "mini_loading_ad_select_";
    }
    return "mini_loading_ad_preload_";
  }
  
  private boolean isViaUnsupported(String paramString)
  {
    if ((TextUtils.isEmpty(this.unsupportedViaList)) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      try
      {
        String[] arrayOfString = this.unsupportedViaList.split(",");
        if (arrayOfString.length < 1) {
          continue;
        }
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramString.equals(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniLoadingAdManager", 1, "isViaUnsupported exception via:" + paramString, localThrowable);
      }
    }
  }
  
  public static void requestPreloadLoadingAd(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      return;
    }
    QLog.d("MiniLoadingAdManager", 1, "预加载接口调用");
    MiniAppAd.StGetAdReq localStGetAdReq = getAdReq(paramMiniAppConfig, paramString, 1);
    MiniProgramLpReportDC04239.reportMiniAppEvent(paramMiniAppConfig, MiniProgramLpReportDC04239.getAppType(paramMiniAppConfig), null, "ad", "ad_loading", "preload_call", null);
    long l = System.currentTimeMillis();
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(localStGetAdReq, new MiniLoadingAdManager.5(l, paramMiniAppConfig, paramString));
  }
  
  private static void updateLoadingAdFrequencyLimitationRecord(@NonNull String paramString1, @NonNull String paramString2, @MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt)
  {
    String str1 = getPrefix(paramInt) + paramString2;
    String str2 = str1 + "_times";
    paramString1 = getPrefix(paramInt) + paramString2 + "_" + paramString1;
    paramString2 = paramString1 + "_times";
    long l1 = StorageUtil.getPreference().getLong(str1, 0L);
    paramInt = StorageUtil.getPreference().getInt(str2, 0);
    long l2 = StorageUtil.getPreference().getLong(paramString1, 0L);
    int i = StorageUtil.getPreference().getInt(paramString2, 0);
    long l3 = getCurZeroTimeMillis();
    if (l1 != l3)
    {
      StorageUtil.getPreference().edit().putLong(str1, l3).apply();
      StorageUtil.getPreference().edit().putInt(str2, 1).apply();
    }
    while (l2 != l3)
    {
      StorageUtil.getPreference().edit().putLong(paramString1, l3).apply();
      StorageUtil.getPreference().edit().putInt(paramString2, 1).apply();
      return;
      StorageUtil.getPreference().edit().putInt(str2, paramInt + 1).apply();
    }
    StorageUtil.getPreference().edit().putInt(paramString2, i + 1).apply();
  }
  
  public MiniLoadingAdLayout getLoadingAdLayout(MiniAppConfig paramMiniAppConfig, Context paramContext, boolean paramBoolean, String paramString, GdtAd paramGdtAd)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = new MiniLoadingAdLayout(paramContext);
    } while (!paramContext.setupUI(paramMiniAppConfig, paramBoolean, paramString, paramGdtAd));
    return paramContext;
  }
  
  public void preloadLoadingAd(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if ((paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramMiniAppConfig.config.appId)) || (!paramMiniAppConfig.config.enableLoadingAd))
    {
      QLog.d("MiniLoadingAdManager", 1, "preloadLoadingAd 没开广告位");
      return;
    }
    if (!checkLoadingAdFrequencyLimitation(paramMiniAppConfig.config.appId, paramString, 1))
    {
      QLog.d("MiniLoadingAdManager", 1, "preloadLoadingAd 频控限制");
      return;
    }
    if (!extraPreloadIntervalCheck(paramMiniAppConfig.config.appId, paramString))
    {
      QLog.d("MiniLoadingAdManager", 1, "preloadLoadingAd 频控限制");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new MiniLoadingAdManager.4(this, paramMiniAppConfig, paramString));
  }
  
  public void processSelectAdWithUncachedAd(GdtAd paramGdtAd, String paramString1, String paramString2, @NonNull MiniLoadingAdManager.OnChooseAdEndListener paramOnChooseAdEndListener)
  {
    QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd 实时下载图片资源");
    paramString1 = new MiniLoadingAdManager.CachedAdInfo(paramGdtAd, paramString1, paramString2);
    paramString2 = new MiniLoadingAdManager.2(this, paramOnChooseAdEndListener, paramString1, paramGdtAd);
    if (new File(paramString1.filePath).exists())
    {
      QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd 之前的实时广告下载过 因实时广告不落地 导致的本地有图片但是没信息的情况 直接回调");
      paramOnChooseAdEndListener.onDownloadAdEnd(paramString1.filePath, paramGdtAd);
      return;
    }
    ThreadPools.getNetworkIOThreadPool().execute(new MiniLoadingAdManager.3(this, paramString1, paramString2));
  }
  
  public boolean selectAd(MiniAppConfig paramMiniAppConfig, String paramString, @NonNull MiniLoadingAdManager.OnChooseAdEndListener paramOnChooseAdEndListener)
  {
    if (!checkSelectAdNecessity(paramMiniAppConfig, paramString))
    {
      QLog.d("MiniLoadingAdManager", 1, "checkSelectAdNecessity fail");
      return false;
    }
    ThreadManager.getSubThreadHandler().post(new MiniLoadingAdManager.1(this, paramMiniAppConfig, paramString, paramOnChooseAdEndListener));
    return true;
  }
  
  public void show(MiniLoadingAdLayout paramMiniLoadingAdLayout, String paramString1, String paramString2, MiniLoadingAdLayout.OnDismissListener paramOnDismissListener)
  {
    paramMiniLoadingAdLayout.show(paramOnDismissListener);
    updateLoadingAdFrequencyLimitationRecord(paramString1, paramString2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager
 * JD-Core Version:    0.7.0.1
 */