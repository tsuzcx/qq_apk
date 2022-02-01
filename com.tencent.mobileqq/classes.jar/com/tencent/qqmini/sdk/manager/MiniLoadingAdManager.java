package com.tencent.qqmini.sdk.manager;

import NS_MINI_AD.MiniAppAd.SpecifiedAdsItem;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.AdUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniLoadingAdManager
{
  private static final String EXTRA_PRELOAD_INTERVAL_CHECK_PREFIX = "mini_loading_ad_extra_preload_interval_check_";
  public static final String KEY_APP_CONFIG = "app_config";
  public static final String KEY_UIN = "uin";
  private static final int LOADING_AD_LIMIT_TYPE_PRELOAD = 1;
  private static final int LOADING_AD_LIMIT_TYPE_SELECT = 0;
  private static final String PRELOAD_ADJSON_KEY_PREFEX = "mini_loading_ad_preload_adjson_key_";
  private static final String PRELOAD_PREFIX = "mini_loading_ad_preload_";
  private static final String SELECT_PREFIX = "mini_loading_ad_select_";
  public static final String TAG = "MiniLoadingAdManager";
  public static final int TYPE_CLICK_BAR = 1;
  public static final int TYPE_CLICK_IMG = 0;
  private static final String VIA_AD_PREFIX = "2054_";
  private static HashMap<Long, String> cachedAidFilePathMap = new HashMap();
  private static final String defaultViaListStr = "2054_1,2054_2,2054_3,2054_4,2054_5,2054_6,2054_7,2054_8,2054_9,2054_10,2054_11,2054_12,2054_13,2054_14,2054_15,2054_17,2054_18,2054_19,2014_31,4017_1,2016_72,2016_74";
  private static long maxAdCachedSize = 20971520L;
  private static volatile MiniLoadingAdManager sInstance;
  private int extraPreloadInterval = WnsConfig.getConfig("qqminiapp", "launch_adv_app_preload_interval", 0);
  private int maxPreloadCountForUin = WnsConfig.getConfig("qqminiapp", "launch_adv_user_preload_limit", 2147483647);
  private int maxPreloadCountForUinAndAppid = WnsConfig.getConfig("qqminiapp", "launch_adv_app_preload_limit", 5);
  private int maxSelectCountForUin = WnsConfig.getConfig("qqminiapp", "launch_adv_user_select_limit", 5);
  private int maxSelectCountForUinAndAppid = WnsConfig.getConfig("qqminiapp", "launch_adv_app_select_limit", 2);
  private long requestAdTimeStamp;
  private String unsupportedViaList = WnsConfig.getConfig("qqminiapp", "launch_adv_unsupport_via_list", "2054_1,2054_2,2054_3,2054_4,2054_5,2054_6,2054_7,2054_8,2054_9,2054_10,2054_11,2054_12,2054_13,2054_14,2054_15,2054_17,2054_18,2054_19,2014_31,4017_1,2016_72,2016_74");
  
  private static ArrayList<MiniAppAd.SpecifiedAdsItem> assembleCachedAidMap(String paramString1, String paramString2)
  {
    cachedAidFilePathMap.clear();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mini_loading_ad_preload_adjson_key_");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    paramString1 = ((StringBuilder)localObject).toString();
    paramString1 = StorageUtil.getPreference().getString(paramString1, new JSONObject().toString());
    try
    {
      paramString1 = new JSONObject(paramString1).optJSONArray("adArray");
      if (paramString1 != null)
      {
        if (paramString1.length() < 1) {
          return null;
        }
        paramString2 = new ArrayList();
        int i = 0;
        while (i < paramString1.length())
        {
          localObject = new MiniAppAd.SpecifiedAdsItem();
          JSONObject localJSONObject = paramString1.getJSONObject(i);
          if (localJSONObject != null)
          {
            String str = localJSONObject.getString("filePath");
            if (new File(str).exists())
            {
              long l = localJSONObject.getLong("aid");
              cachedAidFilePathMap.put(Long.valueOf(l), str);
              ((MiniAppAd.SpecifiedAdsItem)localObject).aid.set(l);
              ((MiniAppAd.SpecifiedAdsItem)localObject).creative_id.set(localJSONObject.getLong("creativeId"));
              paramString2.add(localObject);
            }
          }
          i += 1;
        }
        return paramString2;
      }
      return null;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private boolean checkLoadingAdFrequencyLimitation(@NonNull String paramString1, @NonNull String paramString2, @MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getPrefix(paramInt));
    ((StringBuilder)localObject1).append(paramString2);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("_times");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getPrefix(paramInt));
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_times");
    paramString2 = paramString2.toString();
    long l1 = StorageUtil.getPreference().getLong((String)localObject1, 0L);
    int i = StorageUtil.getPreference().getInt((String)localObject2, 0);
    long l2 = StorageUtil.getPreference().getLong(paramString1, 0L);
    int j = StorageUtil.getPreference().getInt(paramString2, 0);
    if (l1 == getCurZeroTimeMillis())
    {
      if (i < 1) {
        return true;
      }
      if (i >= getLimit(paramInt, false)) {
        return false;
      }
      if (l2 == getCurZeroTimeMillis())
      {
        if (j < 1) {
          return true;
        }
        if (j >= getLimit(paramInt, true)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean checkSelectAdNecessity(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (paramMiniAppInfo.enableLoadingAd))
      {
        if (isViaUnsupported(paramMiniAppInfo.via))
        {
          QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity via不支持");
          SDKMiniProgramLpReportDC04239.reportMiniAppEvent(paramMiniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(paramMiniAppInfo), null, "ad", "ad_loading", "request_shield", paramMiniAppInfo.via);
          return false;
        }
        if (!checkLoadingAdFrequencyLimitation(paramMiniAppInfo.appId, paramString, 0))
        {
          QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity 频控限制");
          return false;
        }
        return true;
      }
      QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity 没开广告位");
      return false;
    }
    QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity 参数不合法");
    return false;
  }
  
  private boolean extraPreloadIntervalCheck(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mini_loading_ad_extra_preload_interval_check__");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    long l = StorageUtil.getPreference().getLong(paramString1, -1L);
    return (l <= 0L) || ((System.currentTimeMillis() - l) / 1000L > this.extraPreloadInterval);
  }
  
  private static void extraPreloadIntervalUpdate(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mini_loading_ad_extra_preload_interval_check__");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    StorageUtil.getPreference().edit().putLong(paramString1, System.currentTimeMillis()).apply();
  }
  
  private static Bundle getAdReqBundle(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString, int paramInt)
  {
    String str1 = LoginManager.getInstance().getAccount();
    String str2 = paramMiniAppInfo.appId;
    int i;
    if (!(paramMiniAppInfo.isEngineTypeMiniApp() ^ true)) {
      i = 14;
    } else {
      i = 15;
    }
    String str3 = AdUtil.getSpAdGdtCookie(i);
    Object localObject1;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      if (paramMiniAppInfo.launchParam.entryPath != null) {
        paramContext = paramMiniAppInfo.launchParam.entryPath;
      } else {
        paramContext = "";
      }
      if (paramMiniAppInfo.launchParam != null) {
        paramString = paramMiniAppInfo.launchParam.reportData;
      } else {
        paramString = "";
      }
      localObject1 = String.valueOf(paramMiniAppInfo.launchParam.scene);
    }
    else
    {
      localObject2 = "";
      paramContext = (Context)localObject2;
      localObject1 = paramContext;
      paramString = paramContext;
      paramContext = (Context)localObject2;
    }
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.via != null)) {
      paramMiniAppInfo = paramMiniAppInfo.via;
    } else {
      paramMiniAppInfo = "";
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString(AdProxy.KEY_ACCOUNT, str1);
    ((Bundle)localObject2).putString(AdProxy.KEY_GDT_COOKIE, str3);
    ((Bundle)localObject2).putString(AdProxy.KEY_ENTRY_PATH, paramContext);
    ((Bundle)localObject2).putString(AdProxy.KEY_REPORT_DATA, paramString);
    ((Bundle)localObject2).putString(AdProxy.KEY_REFER, (String)localObject1);
    ((Bundle)localObject2).putString(AdProxy.KEY_VIA, paramMiniAppInfo);
    ((Bundle)localObject2).putString(AdProxy.KEY_POSID, "");
    ((Bundle)localObject2).putString(AdProxy.KEY_APPID, str2);
    ((Bundle)localObject2).putInt(AdProxy.KEY_AD_TYPE, i);
    ((Bundle)localObject2).putInt(AdProxy.KEY_ORIENTATION, 0);
    ((Bundle)localObject2).putInt(AdProxy.KEY_SHARE_RATE, 53);
    ((Bundle)localObject2).putInt(AdProxy.KEY_ADCOUNT, 1);
    ((Bundle)localObject2).putInt(AdProxy.KEY_MODE, paramInt);
    return localObject2;
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
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new MiniLoadingAdManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private long getLimit(@MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return 0L;
      }
      if (paramBoolean) {
        paramInt = this.maxPreloadCountForUinAndAppid;
      } else {
        paramInt = this.maxPreloadCountForUin;
      }
      return paramInt;
    }
    if (paramBoolean) {
      paramInt = this.maxSelectCountForUinAndAppid;
    } else {
      paramInt = this.maxSelectCountForUin;
    }
    return paramInt;
  }
  
  private static String getPrefix(@MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return "";
      }
      return "mini_loading_ad_preload_";
    }
    return "mini_loading_ad_select_";
  }
  
  private boolean isViaUnsupported(String paramString)
  {
    if (!TextUtils.isEmpty(this.unsupportedViaList))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      try
      {
        String[] arrayOfString = this.unsupportedViaList.split(",");
        if (arrayOfString != null)
        {
          if (arrayOfString.length < 1) {
            return false;
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
        }
        return false;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isViaUnsupported exception via:");
        localStringBuilder.append(paramString);
        QMLog.e("MiniLoadingAdManager", localStringBuilder.toString(), localThrowable);
      }
    }
    return false;
  }
  
  public static void requestPreloadLoadingAd(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    QMLog.d("MiniLoadingAdManager", "预加载接口调用");
    ThreadManager.getSubThreadHandler().post(new MiniLoadingAdManager.3(paramContext, paramMiniAppInfo, paramString));
  }
  
  private static void updateLoadingAdFrequencyLimitationRecord(@NonNull String paramString1, @NonNull String paramString2, @MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getPrefix(paramInt));
    ((StringBuilder)localObject1).append(paramString2);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("_times");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getPrefix(paramInt));
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_times");
    paramString2 = paramString2.toString();
    long l1 = StorageUtil.getPreference().getLong((String)localObject1, 0L);
    paramInt = StorageUtil.getPreference().getInt((String)localObject2, 0);
    long l2 = StorageUtil.getPreference().getLong(paramString1, 0L);
    int i = StorageUtil.getPreference().getInt(paramString2, 0);
    long l3 = getCurZeroTimeMillis();
    if (l1 != l3)
    {
      StorageUtil.getPreference().edit().putLong((String)localObject1, l3).apply();
      StorageUtil.getPreference().edit().putInt((String)localObject2, 1).apply();
    }
    else
    {
      StorageUtil.getPreference().edit().putInt((String)localObject2, paramInt + 1).apply();
    }
    if (l2 != l3)
    {
      StorageUtil.getPreference().edit().putLong(paramString1, l3).apply();
      StorageUtil.getPreference().edit().putInt(paramString2, 1).apply();
      return;
    }
    StorageUtil.getPreference().edit().putInt(paramString2, i + 1).apply();
  }
  
  public void preloadLoadingAd(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (paramMiniAppInfo.enableLoadingAd))
    {
      if (!checkLoadingAdFrequencyLimitation(paramMiniAppInfo.appId, str, 1))
      {
        QMLog.d("MiniLoadingAdManager", "preloadLoadingAd 频控限制");
        return;
      }
      if (!extraPreloadIntervalCheck(paramMiniAppInfo.appId, str))
      {
        QMLog.d("MiniLoadingAdManager", "preloadLoadingAd 频控限制");
        return;
      }
      requestPreloadLoadingAd(paramContext, paramMiniAppInfo, str);
      return;
    }
    QMLog.d("MiniLoadingAdManager", "preloadLoadingAd 没开广告位");
  }
  
  public void processSelectAdWithUncachedAd(String paramString1, String paramString2, String paramString3, @NonNull MiniLoadingAdManager.OnChooseAdEndListener paramOnChooseAdEndListener)
  {
    QMLog.d("MiniLoadingAdManager", "processSelectAdWithUncachedAd downloadRealTimeAdPic 实时下载图片资源");
    ((AdProxy)ProxyManager.get(AdProxy.class)).downloadRealTimeAdPic(paramString1, paramString2, paramString3, new MiniLoadingAdManager.2(this, paramOnChooseAdEndListener));
  }
  
  public boolean selectAd(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString, @NonNull MiniLoadingAdManager.OnChooseAdEndListener paramOnChooseAdEndListener)
  {
    if (!checkSelectAdNecessity(paramMiniAppInfo, paramString))
    {
      QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity fail");
      return false;
    }
    ThreadManager.getSubThreadHandler().post(new MiniLoadingAdManager.1(this, paramString, paramMiniAppInfo, paramContext, paramOnChooseAdEndListener));
    return true;
  }
  
  public void updateLoadingAdLayoutAndShow(MiniAppInfo paramMiniAppInfo, Activity paramActivity, boolean paramBoolean, String paramString, long paramLong1, long paramLong2, @NonNull MiniLoadingAdManager.OnDismissListener paramOnDismissListener)
  {
    if ((AdProxy)ProxyManager.get(AdProxy.class) == null)
    {
      QMLog.i("MiniLoadingAdManager", "start create, null");
      paramOnDismissListener.onDismiss();
      return;
    }
    String str = (String)cachedAidFilePathMap.get(Long.valueOf(paramLong1));
    if (TextUtils.isEmpty(str))
    {
      paramOnDismissListener.onDismiss();
      return;
    }
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(paramMiniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(paramMiniAppInfo), null, "ad", "ad_loading", "expo_call", null);
    ((AdProxy)ProxyManager.get(AdProxy.class)).updateLoadingAdLayoutAndShow(paramActivity, paramMiniAppInfo, paramBoolean, paramString, paramMiniAppInfo.name, paramMiniAppInfo.iconUrl, paramMiniAppInfo.developerDesc, str, paramLong2, this.requestAdTimeStamp, new MiniLoadingAdManager.4(this, paramMiniAppInfo, paramOnDismissListener, paramActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager
 * JD-Core Version:    0.7.0.1
 */