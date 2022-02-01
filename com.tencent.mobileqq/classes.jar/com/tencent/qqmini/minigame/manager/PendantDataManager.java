package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.minigame.action.OperatePendantAd;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo.Builder;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class PendantDataManager
{
  private static final String ACTION_CLK = "clk";
  private static final String ACTION_EXPO = "expo";
  private static final String AD_ABS_TIME_PENDANT_REMOVE = "pendant_duration_hr";
  private static final String AD_ABS_TIME_PENDANT_SHOW = "absTime_pendant_show";
  private static final String AD_ABS_TIME_WEBVIEW = "absTime_webview_popup";
  private static final String AD_ACTIVE_ID = "active_id";
  private static final String AD_AUTO_WEBVIEW = "autoPopup_webview";
  private static final String AD_AUTO_WEBVIEW_DELAY = "autoWebviewDelay";
  private static final int AD_COUNT = 1;
  private static final String AD_JUMP_URL = "url";
  private static final String AD_MAX_CONSUMPTION = "max_consumption";
  private static final String AD_PENDANT_SHOW = "should_pendant_show";
  private static final String AD_PENDANT_URL = "pendant";
  private static final String AD_PICTURE_URL = "pic";
  private static final int AD_POS_ID = 637;
  private static final String AD_STATIC_PENDANT_URL = "staticPendant";
  private static final String AD_TYPE = "type";
  public static final int ENTRANCE_DISAPPEAR = 2;
  private static final String EVENT_NAME = "xiaoyouxi_red_rain_icon";
  public static final int FAILURE = 1;
  public static int RESULT = 0;
  public static final int SHOW_GIF_ANIMATION = 0;
  public static final int SHOW_STATIC = 1;
  private static String SP_NAME = "pendantDataManager";
  public static final int SUCCESS = 0;
  public static final String TAG = "PendantDataManager";
  public static boolean TIME_EXTENSION_ENABLE = false;
  public static int entranceStrategy;
  public static int numTianshuRequest;
  private static Map<String, String> param = new HashMap();
  
  private static void addMoreTimeForReward(int paramInt, IMiniAppContext paramIMiniAppContext, Date paramDate1, Date paramDate2)
  {
    PendantManager.REMOVE_HANDLER.postDelayed(new PendantDataManager.7(paramIMiniAppContext), paramDate1.getTime() - paramDate2.getTime());
    PendantManager.REMOVE_HANDLER.postDelayed(new PendantDataManager.8(paramIMiniAppContext), paramDate1.getTime() - paramDate2.getTime() + 300000L);
  }
  
  private static void delayForWebviewPopup(PendantAdInfo paramPendantAdInfo, IMiniAppContext paramIMiniAppContext, int paramInt, MiniAppProxy paramMiniAppProxy, Context paramContext)
  {
    Handler localHandler = PendantManager.AUTO_WEBVIEW_DELAY_HANDLER;
    paramPendantAdInfo = new PendantDataManager.5(paramPendantAdInfo, paramMiniAppProxy, paramContext, paramIMiniAppContext);
    long l;
    if (paramInt > 0) {
      l = paramInt * 1000;
    } else {
      l = 0L;
    }
    localHandler.postDelayed(paramPendantAdInfo, l);
  }
  
  @NotNull
  private static AsyncResult getCallback(Context paramContext, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt, ChannelProxy paramChannelProxy, MiniAppProxy paramMiniAppProxy)
  {
    return new PendantDataManager.2(paramString, paramInt, paramContext, paramIMiniAppContext, paramChannelProxy, paramMiniAppProxy);
  }
  
  public static SharedPreferences getSp()
  {
    return AppLoaderFactory.g().getContext().getSharedPreferences(SP_NAME, 0);
  }
  
  private static TianShuAccess.AdItem getTianshuItem(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = (TianShuAccess.GetAdsRsp)paramJSONObject.get("response");
    }
    catch (JSONException paramJSONObject)
    {
      QMLog.e("PendantDataManager", "parse Ad Data Exception ", paramJSONObject);
      paramJSONObject = null;
    }
    if (isAdResponseValid(paramJSONObject))
    {
      QMLog.e("PendantDataManager", "handleTianShuResponse mapAds is empty");
      return null;
    }
    paramJSONObject = (TianShuAccess.RspEntry)paramJSONObject.mapAds.get(0);
    if (isRspEntryValid(paramJSONObject))
    {
      QMLog.e("PendantDataManager", "handleTianShuResponse rspEntry is empty");
      return null;
    }
    paramJSONObject = (TianShuAccess.AdItem)paramJSONObject.value.lst.get(0);
    if (isAdItemValid(paramJSONObject))
    {
      QMLog.e("PendantDataManager", "handleTianShuResponse adItem is empty");
      return null;
    }
    return paramJSONObject;
  }
  
  private static void handleCorrectTianshuOperation(Context paramContext, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt, ChannelProxy paramChannelProxy, MiniAppProxy paramMiniAppProxy, PendantAdInfo paramPendantAdInfo)
  {
    param.put("app_id", paramString);
    param.put("active_id", getSp().getString("activeId", "0"));
    param.put("ext1", "2");
    param.put("ext2", getSp().getString("AdId", "0"));
    Object localObject = handleTianshuDateParsing(new Date(paramChannelProxy.getServerTime()), paramPendantAdInfo);
    if (localObject == null) {
      return;
    }
    paramChannelProxy = (Date)((ArrayList)localObject).get(0);
    Date localDate1 = (Date)((ArrayList)localObject).get(1);
    Date localDate2 = (Date)((ArrayList)localObject).get(2);
    localObject = (Date)((ArrayList)localObject).get(3);
    pendantStateChange(paramPendantAdInfo, paramChannelProxy, localDate1, localDate2, (Date)localObject, paramIMiniAppContext, paramMiniAppProxy, paramContext, paramString, paramInt);
    addMoreTimeForReward(5, paramIMiniAppContext, (Date)localObject, paramChannelProxy);
  }
  
  private static PendantAdInfo handleTianShuResponse(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    paramJSONObject = getTianshuItem(paramJSONObject);
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("type", "");
    ((HashMap)localObject2).put("url", "");
    ((HashMap)localObject2).put("pic", "");
    ((HashMap)localObject2).put("pendant", "");
    ((HashMap)localObject2).put("staticPendant", "");
    ((HashMap)localObject2).put("autoPopup_webview", "");
    ((HashMap)localObject2).put("absTime_webview_popup", "");
    ((HashMap)localObject2).put("autoWebviewDelay", "");
    ((HashMap)localObject2).put("should_pendant_show", "");
    ((HashMap)localObject2).put("absTime_pendant_show", "");
    ((HashMap)localObject2).put("pendant_duration_hr", "");
    ((HashMap)localObject2).put("max_consumption", "");
    ((HashMap)localObject2).put("active_id", "");
    Object localObject1 = paramJSONObject.argList.get().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
      ((HashMap)localObject2).put(((TianShuAccess.MapEntry)localObject3).key.get(), ((TianShuAccess.MapEntry)localObject3).value.get());
    }
    localObject1 = (String)((HashMap)localObject2).get("type");
    Object localObject3 = (String)((HashMap)localObject2).get("pic");
    String str1 = (String)((HashMap)localObject2).get("pendant");
    String str2 = (String)((HashMap)localObject2).get("staticPendant");
    String str3 = (String)((HashMap)localObject2).get("autoPopup_webview");
    String str4 = (String)((HashMap)localObject2).get("absTime_webview_popup");
    String str5 = (String)((HashMap)localObject2).get("autoWebviewDelay");
    String str6 = (String)((HashMap)localObject2).get("should_pendant_show");
    String str7 = (String)((HashMap)localObject2).get("absTime_pendant_show");
    String str8 = (String)((HashMap)localObject2).get("pendant_duration_hr");
    String str9 = (String)((HashMap)localObject2).get("max_consumption");
    String str10 = (String)((HashMap)localObject2).get("active_id");
    localObject2 = processUrlFromTianShu((String)((HashMap)localObject2).get("url"), paramString, paramJSONObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleTianShuResponse type:");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(", jumpUrl:");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(", pictureUrl:");
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append(", pendantUrl:");
    localStringBuilder.append(str1);
    localStringBuilder.append(", staticPendantUrl:");
    localStringBuilder.append(str2);
    localStringBuilder.append(", autoWebview:");
    localStringBuilder.append(str3);
    localStringBuilder.append(", absTimeWebview:");
    localStringBuilder.append(str4);
    localStringBuilder.append("autoWebviewDelay:");
    localStringBuilder.append(str5);
    localStringBuilder.append(", shouldShowPendant:");
    localStringBuilder.append(str6);
    localStringBuilder.append(", absTimeShowPendant:");
    localStringBuilder.append(str7);
    localStringBuilder.append(", absTimeRemovePendant:");
    localStringBuilder.append(str8);
    localStringBuilder.append(", numMaxConsumption:");
    localStringBuilder.append(str9);
    localStringBuilder.append(", activeId:");
    localStringBuilder.append(str10);
    QMLog.i("PendantDataManager", localStringBuilder.toString());
    return new PendantAdInfo.Builder().adItem(paramJSONObject).type((String)localObject1).pictureUrl((String)localObject3).pendantUrl(str1).staticPendantUrl(str2).jumpUrl((String)localObject2).appId(paramString).scene(paramInt).autoPopUpWebview(str3).popUpTime(str4).autoWebviewDelay(str5).showPendant(str6).absTimeShowPendant(str7).absTimeRemovePendant(str8).numMaxConsumption(str9).activeId(str10).build();
  }
  
  public static ArrayList<Date> handleTianshuDateParsing(Date paramDate, PendantAdInfo paramPendantAdInfo)
  {
    Object localObject = new SimpleDateFormat("HH:mm");
    try
    {
      paramDate = ((SimpleDateFormat)localObject).parse(((SimpleDateFormat)localObject).format(paramDate));
      Date localDate1 = ((SimpleDateFormat)localObject).parse(paramPendantAdInfo.getPopUpTime());
      Date localDate2 = ((SimpleDateFormat)localObject).parse(paramPendantAdInfo.getAbsTimeShowPendant());
      paramPendantAdInfo = ((SimpleDateFormat)localObject).parse(paramPendantAdInfo.getAbsTimeRemovePendant());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPopUpTime:");
      ((StringBuilder)localObject).append(localDate1);
      ((StringBuilder)localObject).append(", getAbsTimeShowPendant:");
      ((StringBuilder)localObject).append(localDate2);
      ((StringBuilder)localObject).append(", getAbsTimeRemovePendant");
      ((StringBuilder)localObject).append(paramPendantAdInfo);
      ((StringBuilder)localObject).append(", curTime:");
      ((StringBuilder)localObject).append(paramDate);
      QMLog.d("PendantDataManager", ((StringBuilder)localObject).toString());
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramDate);
      ((ArrayList)localObject).add(localDate1);
      ((ArrayList)localObject).add(localDate2);
      ((ArrayList)localObject).add(paramPendantAdInfo);
      return localObject;
    }
    catch (ParseException paramDate)
    {
      paramDate.printStackTrace();
      QMLog.e("PendantDataManager", "date parsing error");
    }
    return null;
  }
  
  private static boolean isAdItemValid(TianShuAccess.AdItem paramAdItem)
  {
    return (paramAdItem == null) || (paramAdItem.argList == null) || (paramAdItem.argList.isEmpty());
  }
  
  private static boolean isAdResponseValid(TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    return (paramGetAdsRsp == null) || (paramGetAdsRsp.mapAds.isEmpty());
  }
  
  private static boolean isPendantConfigCorrect(PendantAdInfo paramPendantAdInfo)
  {
    return (paramPendantAdInfo != null) && (URLUtil.isValidUrl(paramPendantAdInfo.getPictureUrl())) && (URLUtil.isValidUrl(paramPendantAdInfo.getPendantUrl())) && (URLUtil.isValidUrl(paramPendantAdInfo.getJumpUrl())) && ((!getSp().contains("appid")) || (getSp().getString("appid", "0").equals(paramPendantAdInfo.getAppId())));
  }
  
  private static boolean isRspEntryValid(TianShuAccess.RspEntry paramRspEntry)
  {
    return (paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.isEmpty());
  }
  
  private static void pendantStateChange(PendantAdInfo paramPendantAdInfo, Date paramDate1, Date paramDate2, Date paramDate3, Date paramDate4, IMiniAppContext paramIMiniAppContext, MiniAppProxy paramMiniAppProxy, Context paramContext, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("entranceStrategy=");
    localStringBuilder.append(entranceStrategy);
    QMLog.d("PendantDataManager", localStringBuilder.toString());
    int i = entranceStrategy;
    if (i == 0)
    {
      if (shouldLaunchWebviewImmediately(paramPendantAdInfo, paramDate1, paramDate2, paramDate4))
      {
        QMLog.d("PendantDataManager", "已到活动投放时间， 直接打开webview");
        entranceStrategy = 2;
        delayForWebviewPopup(paramPendantAdInfo, paramIMiniAppContext, Integer.parseInt(paramPendantAdInfo.getAutoWebviewDelay()), paramMiniAppProxy, paramContext);
        return;
      }
      if (shouldWaitForPendantShowUp(paramPendantAdInfo, paramDate1, paramDate3, paramDate4))
      {
        QMLog.d("PendantDataManager", "时间没到活动时间，倒计时等待红包挂件出现");
        waitForPendantShowUp(paramPendantAdInfo, paramIMiniAppContext, paramDate2, paramDate1);
        return;
      }
      QMLog.e("PendantDataManager", "判定拉到的天枢超出活动时间，应当消耗掉");
      performReport(paramPendantAdInfo.getAdItem(), paramPendantAdInfo.getType(), 101);
      getSp().edit().putString("numMaxConsumption", Integer.toString(Integer.parseInt(paramPendantAdInfo.getNumMaxConsumption()) - 1)).commit();
      requestAd((Activity)paramContext, paramIMiniAppContext, paramString, paramInt);
      return;
    }
    if (i == 1)
    {
      QMLog.d("PendantDataManager", "红包翻倍，静态红包挂件出现");
      OperatePendantAd.obtain(paramIMiniAppContext).show(paramPendantAdInfo);
      return;
    }
    if (i == 2)
    {
      QMLog.d("PendantDataManager", "红包挂件消失");
      OperatePendantAd.obtain(paramIMiniAppContext).remove();
    }
  }
  
  private static boolean performReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    if (paramAdItem == null) {
      return false;
    }
    ThreadManager.getSubThreadHandler().post(new PendantDataManager.4(paramAdItem, paramString, paramInt));
    return true;
  }
  
  private static boolean preloadDrawables(Context paramContext, PendantAdInfo paramPendantAdInfo)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    localMiniAppProxy.getDrawable(paramContext, paramPendantAdInfo.getPictureUrl(), 0, 0, null);
    localMiniAppProxy.getDrawable(paramContext, paramPendantAdInfo.getPendantUrl(), 0, 0, null);
    localMiniAppProxy.getDrawable(paramContext, paramPendantAdInfo.getStaticPendantUrl(), 0, 0, null);
    return true;
  }
  
  private static void printErrCode(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = (TianShuAccess.GetAdsRsp)paramJSONObject.get("response");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("err code: ");
      localStringBuilder.append(String.valueOf(paramJSONObject.code.get()));
      localStringBuilder.append(", err msg: ");
      localStringBuilder.append(String.valueOf(paramJSONObject.errmsg.get()));
      QMLog.e("PendantDataManager", localStringBuilder.toString());
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QMLog.e("PendantDataManager", "parse err code Exception ", paramJSONObject);
    }
  }
  
  private static String processUrlFromTianShu(String paramString1, String paramString2, TianShuAccess.AdItem paramAdItem)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("url from tianshu : ");
    ((StringBuilder)localObject1).append(paramString1);
    QMLog.w("PendantDataManager", ((StringBuilder)localObject1).toString());
    Object localObject2 = "";
    if (paramString2 == null) {
      paramString2 = "";
    }
    if ((paramAdItem != null) && (paramAdItem.iAdId != null))
    {
      localObject1 = String.valueOf(paramAdItem.iAdId.get());
      localObject2 = String.valueOf(paramAdItem.traceinfo);
      paramAdItem = new StringBuilder();
      paramAdItem.append("广告id:");
      paramAdItem.append((String)localObject1);
      QMLog.d("PendantDataManager", paramAdItem.toString());
      paramAdItem = (TianShuAccess.AdItem)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = "";
      paramAdItem = (TianShuAccess.AdItem)localObject2;
    }
    localObject2 = paramString1;
    if (paramString1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("&appid=");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("&item_id=");
      ((StringBuilder)localObject2).append(paramAdItem);
      ((StringBuilder)localObject2).append("&trigger_info=");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      paramString1 = new StringBuilder();
      paramString1.append("url with data : ");
      paramString1.append((String)localObject2);
      QMLog.w("PendantDataManager", paramString1.toString());
    }
    return localObject2;
  }
  
  public static void reportClick(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new PendantDataManager.10(paramString));
  }
  
  public static void reportExposure(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new PendantDataManager.9(paramString));
  }
  
  public static void requestAd(Activity paramActivity, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new PendantDataManager.1(paramActivity, paramIMiniAppContext, paramString, paramInt));
  }
  
  private static void requestTianShu(Context paramContext, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestTianShu with appId=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" scene=");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.i("PendantDataManager", ((StringBuilder)localObject).toString());
    localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (!((ChannelProxy)localObject).tianshuRequestAdv(paramContext, paramString, paramInt, 637, 1, getCallback(paramContext, paramIMiniAppContext, paramString, paramInt, (ChannelProxy)localObject, (MiniAppProxy)ProxyManager.get(MiniAppProxy.class)))) {
      QMLog.e("PendantDataManager", "requestTianShu isImpl=false");
    }
  }
  
  public static void requestTianshuAgain(PendantAdInfo paramPendantAdInfo, Context paramContext, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt)
  {
    if ((paramPendantAdInfo == null) && (numTianshuRequest == 0))
    {
      QMLog.d("PendantDataManager", "重新拉取天枢");
      numTianshuRequest += 1;
      PendantManager.SHOW_HANDLER.postDelayed(new PendantDataManager.3(paramContext, paramIMiniAppContext, paramString, paramInt), 180000L);
    }
  }
  
  public static boolean requestTianshuCache(String paramString, Context paramContext, IMiniAppContext paramIMiniAppContext, int paramInt, ChannelProxy paramChannelProxy, MiniAppProxy paramMiniAppProxy)
  {
    Object localObject = new SimpleDateFormat("yyyy_MM_dd").format(new Date(System.currentTimeMillis()));
    if (!getSp().contains("curDay"))
    {
      QMLog.i("PendantDataManager", "no record from disk");
      return false;
    }
    if ((!getSp().getString("numMaxConsumption", "0").equals("0")) && (getSp().getString("curDay", "").equals(localObject)))
    {
      if (!getSp().getString("appid", "").equals(paramString))
      {
        QMLog.i("PendantDataManager", "not in the same app");
        return false;
      }
      if (entranceStrategy == 2) {
        entranceStrategy = 0;
      }
      localObject = new PendantAdInfo.Builder().adItem(null).type(getSp().getString("type", "1")).pictureUrl(getSp().getString("pictureUrl", "")).pendantUrl(getSp().getString("pendantUrl", "")).staticPendantUrl(getSp().getString("staticPendantUrl", "")).jumpUrl(getSp().getString("jumpUrl", "")).appId(getSp().getString("appid", "0")).scene(paramInt).autoPopUpWebview(getSp().getString("autoPopUpWebview", "1")).popUpTime(getSp().getString("popUpTime", "0")).autoWebviewDelay(getSp().getString("autoWebviewDelay", "0")).showPendant(getSp().getString("showPendant", "1")).absTimeShowPendant(getSp().getString("absTimeShowPendant", "0")).absTimeRemovePendant(getSp().getString("absTimeRemovePendant", "0")).numMaxConsumption(getSp().getString("numMaxConsumption", "0")).activeId(getSp().getString("activeId", "0")).build();
      QMLog.i("PendantDataManager", "从sp中恢复天枢");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpURL = ");
      localStringBuilder.append(((PendantAdInfo)localObject).getJumpUrl());
      QMLog.i("PendantDataManager", localStringBuilder.toString());
      handleCorrectTianshuOperation(paramContext, paramIMiniAppContext, paramString, paramInt, paramChannelProxy, paramMiniAppProxy, (PendantAdInfo)localObject);
      return true;
    }
    QMLog.i("PendantDataManager", "outdated pendant ad, cleaning");
    return false;
  }
  
  private static boolean shouldLaunchWebviewImmediately(PendantAdInfo paramPendantAdInfo, Date paramDate1, Date paramDate2, Date paramDate3)
  {
    return (paramPendantAdInfo.shouldWebviewAutoPopup()) && (paramDate1.compareTo(paramDate2) >= 0) && (paramDate1.compareTo(paramDate3) < 0);
  }
  
  private static boolean shouldWaitForPendantShowUp(PendantAdInfo paramPendantAdInfo, Date paramDate1, Date paramDate2, Date paramDate3)
  {
    return (paramPendantAdInfo.shouldPendantShow()) && (paramDate1.compareTo(paramDate2) < 0) && (paramDate1.compareTo(paramDate3) < 0);
  }
  
  private static void waitForPendantShowUp(PendantAdInfo paramPendantAdInfo, IMiniAppContext paramIMiniAppContext, Date paramDate1, Date paramDate2)
  {
    PendantManager.SHOW_HANDLER.postDelayed(new PendantDataManager.6(paramIMiniAppContext, paramPendantAdInfo), paramDate1.getTime() - paramDate2.getTime());
  }
  
  public static void wirteTianshuCache(PendantAdInfo paramPendantAdInfo)
  {
    String str = new SimpleDateFormat("yyyy_MM_dd").format(new Date(System.currentTimeMillis()));
    if ((getSp().contains("curDay")) && (!getSp().getString("curDay", "").equals(str)))
    {
      getSp().edit().clear().putString("curDay", str).commit();
    }
    else if (!getSp().contains("curDay"))
    {
      QMLog.i("PendantDataManager", "creating a new record...");
      getSp().edit().putString("curDay", str).commit();
    }
    else
    {
      if (Integer.parseInt(paramPendantAdInfo.getNumMaxConsumption()) <= 0) {
        break label580;
      }
      QMLog.i("PendantDataManager", "updating an existing record...");
    }
    getSp().edit().putString("AdId", String.valueOf(paramPendantAdInfo.getAdItem().iAdId.get())).commit();
    getSp().edit().putString("type", paramPendantAdInfo.getType()).commit();
    getSp().edit().putString("pictureUrl", paramPendantAdInfo.getPictureUrl()).commit();
    getSp().edit().putString("pendantUrl", paramPendantAdInfo.getPendantUrl()).commit();
    getSp().edit().putString("staticPendantUrl", paramPendantAdInfo.getStaticPendantUrl()).commit();
    getSp().edit().putString("jumpUrl", paramPendantAdInfo.getJumpUrl()).commit();
    getSp().edit().putString("appid", paramPendantAdInfo.getAppId()).commit();
    getSp().edit().putInt("scene", paramPendantAdInfo.getScene()).commit();
    getSp().edit().putString("autoPopUpWebview", paramPendantAdInfo.getAutoPopUpWebview()).commit();
    getSp().edit().putString("popUpTime", paramPendantAdInfo.getPopUpTime()).commit();
    getSp().edit().putString("autoWebviewDelay", paramPendantAdInfo.getAutoWebviewDelay()).commit();
    getSp().edit().putString("showPendant", paramPendantAdInfo.getShowPendant()).commit();
    getSp().edit().putString("absTimeShowPendant", paramPendantAdInfo.getAbsTimeShowPendant()).commit();
    getSp().edit().putString("absTimeRemovePendant", paramPendantAdInfo.getAbsTimeRemovePendant()).commit();
    getSp().edit().putString("numMaxConsumption", paramPendantAdInfo.getNumMaxConsumption()).commit();
    getSp().edit().putString("activeId", paramPendantAdInfo.getActiveId()).commit();
    return;
    label580:
    getSp().edit().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantDataManager
 * JD-Core Version:    0.7.0.1
 */