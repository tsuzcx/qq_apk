package com.tencent.qqmini.minigame.plugins;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.minigame.R.color;
import com.tencent.qqmini.minigame.R.dimen;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.minigame.ui.RaffleFailDialog;
import com.tencent.qqmini.minigame.ui.RaffleSuccessDialog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.AdUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class RaffleJsPlugin
  extends BaseJsPlugin
{
  private static final long ALLOW_CANCEL_DELAY = 5000L;
  public static final String ERROR_REPORT_NETWORK_ERROR = "network error";
  public static final String ERROR_REPORT_NO_NETWORK = "no network";
  public static final String ERROR_REPORT_RAFFLE_FAIL = "raffle fail";
  public static final String ERROR_REPORT_RAFFLE_LIMITED = "raffle limited";
  public static final String ERROR_REPORT_RAFFLE_OUT_OF_TIME = "raffle out of time";
  public static final String EVENT_ON_RAFFLE_STATE_CHANGE = "onMinigameRaffleStateChange";
  public static final String EVENT_ON_SHARE_SUC_NOTICE = "onRaffleShareSucNotice";
  public static final String EVENT_START_RAFFLE = "minigameRaffle";
  private static final int IMAGE_TYPE_BUTTON = 3;
  private static final int IMAGE_TYPE_LOGO = 1;
  private static final int IMAGE_TYPE_PRIZE = 2;
  public static final String KEY_RESULT_DATA = "key_result_data";
  private static final long PRELOAD_EFFECTIVE_TIME_SECOND = 3600L;
  private static final String PRELOAD_MATERIAL_SP_NAME = "minigame_raffleJsPlugin_getGameRaffleMaterial";
  public static final boolean PRELOAD_SWITCH = true;
  public static final String RAFFLE_SHARE_ACTION = "raffleShare";
  public static final String RAFFLE_STATE_AGAIN = "again";
  public static final String RAFFLE_STATE_CLOSE = "close";
  public static final String RAFFLE_STATE_ERROR = "error";
  public static final int RAFFLE_STATE_HIT = 0;
  public static final int RAFFLE_STATE_LIMITED = 1;
  public static final int RAFFLE_STATE_OUT_OF_TIME = 2;
  public static final String RAFFLE_STATE_SHARE = "share";
  public static final String RAFFLE_STATE_WATCH_AD = "watchAd";
  public static final long RECOVER_CLICK_DELAY = 1000L;
  private static final String REPORT_ACTION_CLK = "clk";
  private static final String REPORT_ACTION_EXP = "exp";
  private static final int REPORT_ERROR_CODE_FAIL_AD_LOAD_ERROR = 7;
  private static final int REPORT_ERROR_CODE_FAIL_GET_MATERIAL_FAIL = 5;
  private static final int REPORT_ERROR_CODE_FAIL_LOAD_IMAGE_ERROR = 6;
  private static final int REPORT_ERROR_CODE_SUCCESS_DO_RAFFLE_DATA_ERROR = 2;
  private static final int REPORT_ERROR_CODE_SUCCESS_DO_RAFFLE_FAIL = 1;
  private static final int REPORT_ERROR_CODE_SUCCESS_GET_MATERIAL_FAIL = 3;
  private static final int REPORT_ERROR_CODE_SUCCESS_LOAD_IMAGE_ERROR = 4;
  private static final String REPORT_EVENT_NAME_FAIL = "xiaoyouxi_fail";
  private static final String REPORT_EVENT_NAME_FAIL_AGAIN = "xiaoyouxi_fail_again";
  private static final String REPORT_EVENT_NAME_FAIL_CLOSE = "xiaoyouxi_fail_close";
  private static final String REPORT_EVENT_NAME_FAIL_SHARE_CLICK = "xiaoyouxi_fail_share_recover";
  private static final String REPORT_EVENT_NAME_FAIL_SHARE_SUCCESS = "xiaoyouxi_fail_share_finish";
  private static final String REPORT_EVENT_NAME_FAIL_WATCH_AD_CLICK = "xiaoyouxi_fail_reward_video";
  private static final String REPORT_EVENT_NAME_FAIL_WATCH_AD_SUCCESS = "xiaoyouxi_fail_reward_video_finish";
  private static final String REPORT_EVENT_NAME_RAFFLE = "xiaoyouxi_choujiang";
  private static final String REPORT_EVENT_NAME_RAFFLE_BACK_AGAIN = "xiaoyouxi_return_again";
  private static final String REPORT_EVENT_NAME_RAFFLE_BACK_GAME = "xiaoyouxi_return_game";
  private static final String REPORT_EVENT_NAME_RAFFLE_CLOSE = "xiaoyouxi_choujiang_close";
  private static final String REPORT_EVENT_NAME_RAFFLE_CLOSE_CANCEL = "xiaoyouxi_close_pop_cancel";
  private static final String REPORT_EVENT_NAME_RAFFLE_CLOSE_CERTAIN = "xiaoyouxi_close_pop_confirm";
  private static final String REPORT_EVENT_NAME_RAFFLE_ERROR = "xiaoyouxi_raffle_error";
  private static final String REPORT_EVENT_NAME_RAFFLE_OPEN = "xiaoyouxi_choujiang_open";
  private static final long SHOW_LOADING_DELAY = 500L;
  private static final String TAG = "RaffleJsPlugin";
  private static final String WEB_VIEW_PARAM = "&_wwv=13";
  private Integer activeId;
  private String appid;
  private String failUrl;
  private String goBackMainButtonUrl;
  private boolean hasGetMaterial;
  Runnable hideLoadingRunnable;
  private boolean isHorizontal;
  private String jumpUrl;
  private Dialog loadingDialog;
  private String logoUrl;
  private boolean mGetRewarded;
  private boolean mIsAlreadyFail;
  private volatile boolean mIsPreloadAd;
  private volatile boolean mIsRequestingAd;
  private AdProxy.AbsRewardVideoAdView mRewardedVideoAd;
  private RaffleJsPlugin.OnRaffleFailListener onRaffleFailListener;
  private RaffleJsPlugin.OnRaffleSuccessListener onRaffleSuccessListener;
  private String posId;
  private String prizeUrl;
  private Integer promotionId;
  private RaffleFailDialog raffleFailDialog;
  private RaffleSuccessDialog raffleSuccessDialog;
  private String receiveUrl;
  private String shareButtonUrl;
  Runnable showLoadingRunnable;
  private String uin;
  private String watchAdButtonUrl;
  private String wishingImgUrl;
  
  public RaffleJsPlugin()
  {
    Integer localInteger = Integer.valueOf(0);
    this.promotionId = localInteger;
    this.activeId = localInteger;
    this.hasGetMaterial = false;
    this.mIsPreloadAd = true;
    this.mIsRequestingAd = false;
    this.mIsAlreadyFail = false;
    this.mGetRewarded = false;
    this.showLoadingRunnable = new RaffleJsPlugin.14(this);
    this.hideLoadingRunnable = new RaffleJsPlugin.15(this);
    this.onRaffleSuccessListener = new RaffleJsPlugin.16(this);
    this.onRaffleFailListener = new RaffleJsPlugin.17(this);
  }
  
  private void clickRewardedAd(Context paramContext)
  {
    boolean bool;
    if ((!this.mIsRequestingAd) && (this.mRewardedVideoAd != null)) {
      bool = true;
    } else {
      bool = false;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clickRewardedAd isValid:");
    localStringBuilder.append(bool);
    localStringBuilder.append(";mIsPreloadAd:");
    localStringBuilder.append(this.mIsPreloadAd);
    QMLog.d(str, localStringBuilder.toString());
    if (bool)
    {
      showRewardedAd(paramContext);
      return;
    }
    if (this.mIsPreloadAd)
    {
      showLoading();
      this.mIsPreloadAd = false;
      return;
    }
    showLoading();
    loadRewardedAd(paramContext);
  }
  
  private void createRewardVideoAdView(Context paramContext, Bundle paramBundle)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createRewardVideoAdView ext:");
    localStringBuilder.append(paramBundle.toString());
    QMLog.d(str, localStringBuilder.toString());
    AppBrandTask.runTaskOnUiThread(new RaffleJsPlugin.10(this, paramContext, paramBundle));
  }
  
  private void dismissDialog(Dialog paramDialog)
  {
    if (paramDialog != null) {
      try
      {
        if (paramDialog.isShowing())
        {
          paramDialog.dismiss();
          return;
        }
      }
      catch (Exception paramDialog)
      {
        QMLog.e(TAG, "dismissDialog exception", paramDialog);
      }
    }
  }
  
  private void doGameRaffle(Context paramContext)
  {
    QMLog.d(TAG, "doGameRaffle");
    showLoading();
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    paramContext = getDoGameRaffleCallback(paramContext);
    localChannelProxy.doGameRaffle(this.appid, this.uin, paramContext);
  }
  
  private static void downloadImage(Context paramContext, String paramString)
  {
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(paramContext, paramString, 0, 0, null);
  }
  
  private void gameRaffleFail(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    QMLog.d(TAG, "gameRaffleFail");
    showLoading();
    getGameRaffleMaterial(paramContext, new RaffleJsPlugin.5(this, paramContext, paramBoolean1, paramBoolean2));
  }
  
  private void gameRaffleSuccess(Context paramContext, JSONObject paramJSONObject)
  {
    QMLog.d(TAG, "gameRaffleSuccess");
    int i;
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("pack");
      this.logoUrl = paramJSONObject.optString("business_name_pic");
      this.jumpUrl = paramJSONObject.getString("url");
      i = 0;
    }
    catch (JSONException paramJSONObject)
    {
      QMLog.e(TAG, "gameRaffleSuccess JSONException", paramJSONObject);
      i = 1;
    }
    if (TextUtils.isEmpty(this.jumpUrl))
    {
      QMLog.e(TAG, "gameRaffleSuccess jumpUrl is null");
      i = 1;
    }
    if (i != 0)
    {
      hideLoading();
      showErrorToast(paramContext, paramContext.getResources().getString(R.string.mini_sdk_game_raffle_fail));
      onRaffleError("raffle fail");
      springHbReportError(2);
      return;
    }
    getGameRaffleMaterial(paramContext, new RaffleJsPlugin.3(this, paramContext));
  }
  
  private AsyncResult getDoGameRaffleCallback(Context paramContext)
  {
    return new RaffleJsPlugin.2(this, paramContext);
  }
  
  private void getGameRaffleMaterial(Context paramContext, RaffleJsPlugin.GetGameRaffleMaterialInterface paramGetGameRaffleMaterialInterface)
  {
    if (this.hasGetMaterial)
    {
      QMLog.d(TAG, "getGameRaffleMaterial hasGetMaterial");
      paramGetGameRaffleMaterialInterface.onSuccess();
      return;
    }
    if (isAlreadyPreload(paramContext))
    {
      QMLog.d(TAG, "getGameRaffleMaterial isAlreadyPreload");
      readFromSp(paramContext);
      paramGetGameRaffleMaterialInterface.onSuccess();
      return;
    }
    QMLog.d(TAG, "getGameRaffleMaterial new request");
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    paramContext = getGetGameRaffleMaterialCallback(paramContext, paramGetGameRaffleMaterialInterface);
    localChannelProxy.getGameRaffleMaterial(this.appid, this.uin, paramContext);
  }
  
  private static void getGameRaffleMaterialStatic(Context paramContext, String paramString1, String paramString2)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getGameRaffleMaterial(paramString1, paramString2, new RaffleJsPlugin.7(paramContext));
  }
  
  private AsyncResult getGetGameRaffleMaterialCallback(Context paramContext, RaffleJsPlugin.GetGameRaffleMaterialInterface paramGetGameRaffleMaterialInterface)
  {
    return new RaffleJsPlugin.8(this, paramGetGameRaffleMaterialInterface, paramContext);
  }
  
  private int getPxFromDimen(Context paramContext, int paramInt1, int paramInt2)
  {
    if (this.isHorizontal) {
      return paramContext.getResources().getDimensionPixelOffset(paramInt2);
    }
    return paramContext.getResources().getDimensionPixelOffset(paramInt1);
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext)
  {
    if (paramContext == null)
    {
      QMLog.e(TAG, "getSharedPreferences context is null");
      return null;
    }
    return paramContext.getSharedPreferences("minigame_raffleJsPlugin_getGameRaffleMaterial", 4);
  }
  
  public static long getUpdateTime(Context paramContext)
  {
    paramContext = getSharedPreferences(paramContext);
    if (paramContext == null) {
      return 0L;
    }
    return paramContext.getLong("updateTime", 0L);
  }
  
  private Drawable getWebImage(Context paramContext, String paramString, int paramInt)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(R.color.transparent);
    if (TextUtils.isEmpty(paramString))
    {
      if (paramInt == 2)
      {
        QMLog.e(TAG, "getWebImage necessary url is null");
        return null;
      }
      QMLog.d(TAG, "getWebImage other url is null");
      return localDrawable;
    }
    int i;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          i = 0;
          paramInt = 0;
        }
        else
        {
          i = getPxFromDimen(paramContext, R.dimen.mini_sdk_raffle_common_button_width, R.dimen.mini_sdk_raffle_landscape_common_button_width);
          paramInt = getPxFromDimen(paramContext, R.dimen.mini_sdk_raffle_common_button_height, R.dimen.mini_sdk_raffle_landscape_common_button_height);
        }
      }
      else
      {
        i = getPxFromDimen(paramContext, R.dimen.mini_sdk_raffle_main_image_width, R.dimen.mini_sdk_raffle_landscape_main_image_width);
        paramInt = getPxFromDimen(paramContext, R.dimen.mini_sdk_raffle_main_image_height, R.dimen.mini_sdk_raffle_landscape_main_image_height);
      }
    }
    else
    {
      i = getPxFromDimen(paramContext, R.dimen.mini_sdk_raffle_logo_image_width, R.dimen.mini_sdk_raffle_landscape_logo_image_width);
      paramInt = getPxFromDimen(paramContext, R.dimen.mini_sdk_raffle_logo_image_height, R.dimen.mini_sdk_raffle_landscape_logo_image_height);
    }
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(paramContext, paramString, i, paramInt, localDrawable);
  }
  
  private static void handlePreload(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramJSONObject.getString("key_result_data"));
      paramJSONObject = localJSONObject.optString("raffleImg");
      String str1 = localJSONObject.optString("openedPackImg");
      String str2 = localJSONObject.optString("backBtn");
      String str3 = localJSONObject.optString("shareImg");
      String str4 = localJSONObject.optString("shareBtn");
      String str5 = localJSONObject.optString("wishingImg");
      String str6 = localJSONObject.optString("watchAdBtn");
      int i = localJSONObject.optInt("promotion_id");
      int j = localJSONObject.optInt("active_id");
      downloadImage(paramContext, paramJSONObject);
      downloadImage(paramContext, str1);
      downloadImage(paramContext, str2);
      downloadImage(paramContext, str3);
      downloadImage(paramContext, str4);
      downloadImage(paramContext, str5);
      downloadImage(paramContext, str6);
      paramContext = getSharedPreferences(paramContext);
      if (paramContext == null)
      {
        QMLog.e(TAG, "handlePreload SharedPreferences is null");
        return;
      }
      paramContext = paramContext.edit();
      paramContext.putString("prizeUrl", paramJSONObject);
      paramContext.putString("receiveUrl", str1);
      paramContext.putString("goBackMainButtonUrl", str2);
      paramContext.putString("failUrl", str3);
      paramContext.putString("shareButtonUrl", str4);
      paramContext.putString("wishingImgUrl", str5);
      paramContext.putString("watchAdButtonUrl", str6);
      paramContext.putInt("promotionId", i);
      paramContext.putInt("activeId", j);
      paramContext.putLong("updateTime", System.currentTimeMillis());
      paramContext.apply();
      return;
    }
    catch (Exception paramContext)
    {
      QMLog.e(TAG, "handlePreload Exception", paramContext);
    }
  }
  
  private boolean isAdInvalid(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    return (!paramBoolean1) && (paramBoolean2) && (TextUtils.isEmpty(paramString));
  }
  
  private static boolean isAlreadyPreload(Context paramContext)
  {
    long l = getUpdateTime(paramContext);
    boolean bool = false;
    if (l != 0L)
    {
      l = (System.currentTimeMillis() - l) / 1000L;
      paramContext = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAlreadyPreload deltaSecond = ");
      localStringBuilder.append(l);
      QMLog.d(paramContext, localStringBuilder.toString());
      if (l <= 3600L) {
        bool = true;
      }
      return bool;
    }
    QMLog.d(TAG, "isAlreadyPreload updateTime = 0");
    return false;
  }
  
  private boolean isNoNetwork(Context paramContext)
  {
    return NetworkUtil.getActiveNetworkType(paramContext) == 0;
  }
  
  private void loadAdError(Context paramContext)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadAdError mIsAlreadyFail = ");
    localStringBuilder.append(this.mIsAlreadyFail);
    QMLog.e(str, localStringBuilder.toString());
    if (this.mIsAlreadyFail)
    {
      onRaffleStateChange("watchAd");
      ThreadManager.getUIHandler().post(new RaffleJsPlugin.12(this, paramContext));
      return;
    }
    this.mIsAlreadyFail = true;
    showErrorToast(paramContext, paramContext.getResources().getString(R.string.mini_sdk_game_raffle_fail_ad_load_fail));
  }
  
  private void loadRewardedAd(Context paramContext)
  {
    QMLog.d(TAG, "loadRewardedAd");
    if (this.mIsRequestingAd)
    {
      QMLog.e(TAG, "loadRewardedAd is requesting Ad");
      return;
    }
    this.mRewardedVideoAd = null;
    this.mIsRequestingAd = true;
    int i = 0;
    this.mGetRewarded = false;
    if (this.isHorizontal) {
      i = 90;
    }
    String str = AdUtil.getSpAdGdtCookie(1);
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    Object localObject5 = "";
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (localMiniAppInfo != null)
    {
      if (localMiniAppInfo.launchParam.entryPath != null) {
        localObject1 = localMiniAppInfo.launchParam.entryPath;
      } else {
        localObject1 = "";
      }
      localObject2 = localMiniAppInfo.launchParam.reportData;
      localObject3 = String.valueOf(localMiniAppInfo.launchParam.scene);
    }
    else
    {
      localObject4 = "";
      localObject1 = localObject4;
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = localObject4;
    }
    Object localObject4 = localObject5;
    if (localMiniAppInfo != null)
    {
      localObject4 = localObject5;
      if (localMiniAppInfo.via != null) {
        localObject4 = localMiniAppInfo.via;
      }
    }
    localObject5 = new Bundle();
    ((Bundle)localObject5).putString(AdProxy.KEY_ACCOUNT, this.uin);
    ((Bundle)localObject5).putInt(AdProxy.KEY_AD_TYPE, 1);
    ((Bundle)localObject5).putInt(AdProxy.KEY_ORIENTATION, i);
    ((Bundle)localObject5).putString(AdProxy.KEY_GDT_COOKIE, str);
    ((Bundle)localObject5).putString(AdProxy.KEY_ENTRY_PATH, (String)localObject1);
    ((Bundle)localObject5).putString(AdProxy.KEY_REPORT_DATA, (String)localObject2);
    ((Bundle)localObject5).putString(AdProxy.KEY_REFER, (String)localObject3);
    ((Bundle)localObject5).putString(AdProxy.KEY_VIA, (String)localObject4);
    createRewardVideoAdView(paramContext, (Bundle)localObject5);
  }
  
  private void onCloseAd(Context paramContext)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCloseAd mGetRewarded = ");
    localStringBuilder.append(this.mGetRewarded);
    QMLog.d(str, localStringBuilder.toString());
    if (this.mGetRewarded)
    {
      onRaffleStateChange("watchAd");
      ThreadManager.getUIHandler().post(new RaffleJsPlugin.11(this, paramContext));
      springHbReport("xiaoyouxi_fail_reward_video_finish", "exp");
    }
  }
  
  private void onRaffleError(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      localJSONObject.put("errorMsg", paramString);
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRaffleError errorMsg: ");
      localStringBuilder.append(paramString);
      QMLog.d(str, localStringBuilder.toString());
      sendSubscribeEvent("onMinigameRaffleStateChange", localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      QMLog.e(TAG, "onRaffleError exception", paramString);
    }
  }
  
  private void onRaffleStateChange(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", paramString);
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRaffleStateChange state: ");
      localStringBuilder.append(paramString);
      QMLog.d(str, localStringBuilder.toString());
      sendSubscribeEvent("onMinigameRaffleStateChange", localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      QMLog.e(TAG, "onRaffleStateChange exception", paramString);
    }
  }
  
  private boolean parseMaterialUrl(JSONObject paramJSONObject)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMaterialUrl jsonObject: ");
    localStringBuilder.append(paramJSONObject.toString());
    QMLog.d(str, localStringBuilder.toString());
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject.getString("key_result_data"));
      this.prizeUrl = paramJSONObject.optString("raffleImg");
      this.receiveUrl = paramJSONObject.optString("openedPackImg");
      this.goBackMainButtonUrl = paramJSONObject.optString("backBtn");
      this.failUrl = paramJSONObject.optString("shareImg");
      this.shareButtonUrl = paramJSONObject.optString("shareBtn");
      this.wishingImgUrl = paramJSONObject.optString("wishingImg");
      this.watchAdButtonUrl = paramJSONObject.optString("watchAdBtn");
      this.promotionId = Integer.valueOf(paramJSONObject.optInt("promotion_id"));
      this.activeId = Integer.valueOf(paramJSONObject.optInt("active_id"));
      this.hasGetMaterial = true;
    }
    catch (JSONException paramJSONObject)
    {
      QMLog.e(TAG, "getMaterialUrl JSONException", paramJSONObject);
      this.hasGetMaterial = false;
    }
    return this.hasGetMaterial;
  }
  
  public static void preloadGameRaffleMaterial(Context paramContext, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!isAlreadyPreload(paramContext)) {
        getGameRaffleMaterialStatic(paramContext, paramString1, paramString2);
      }
      return;
    }
    paramContext = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadGameRaffleMaterial appid=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(";uin=");
    localStringBuilder.append(paramString2);
    QMLog.e(paramContext, localStringBuilder.toString());
  }
  
  private void raffleFailImageLoadError(Context paramContext)
  {
    QMLog.e(TAG, "raffleFailImageLoadError");
    onRaffleError("network error");
    showErrorToast(paramContext, paramContext.getResources().getString(R.string.mini_sdk_game_raffle_fail_image_load_fail));
  }
  
  private void raffleSuccessImageLoadError(Context paramContext)
  {
    QMLog.e(TAG, "raffleSuccessImageLoadError");
    onRaffleError("network error");
    ThreadManager.getUIHandler().post(new RaffleJsPlugin.9(this, paramContext));
  }
  
  private void readFromSp(Context paramContext)
  {
    paramContext = getSharedPreferences(paramContext);
    if (paramContext == null)
    {
      QMLog.e(TAG, "readFromSp SharedPreferences is null");
      this.hasGetMaterial = false;
      return;
    }
    this.prizeUrl = paramContext.getString("prizeUrl", "");
    this.receiveUrl = paramContext.getString("receiveUrl", "");
    this.goBackMainButtonUrl = paramContext.getString("goBackMainButtonUrl", "");
    this.failUrl = paramContext.getString("failUrl", "");
    this.shareButtonUrl = paramContext.getString("shareButtonUrl", "");
    this.wishingImgUrl = paramContext.getString("wishingImgUrl", "");
    this.watchAdButtonUrl = paramContext.getString("watchAdButtonUrl", "");
    this.promotionId = Integer.valueOf(paramContext.getInt("promotionId", 0));
    this.activeId = Integer.valueOf(paramContext.getInt("activeId", 0));
    this.hasGetMaterial = true;
  }
  
  private void showErrorToast(Context paramContext, String paramString)
  {
    ThreadManager.getUIHandler().post(new RaffleJsPlugin.13(this, paramContext, paramString));
  }
  
  private void showGameFailDialog(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    QMLog.d(TAG, "showGameFailDialog");
    Drawable localDrawable3 = getWebImage(paramContext, this.failUrl, 2);
    Drawable localDrawable1;
    if (paramBoolean1) {
      localDrawable1 = getWebImage(paramContext, this.shareButtonUrl, 3);
    } else {
      localDrawable1 = null;
    }
    Drawable localDrawable2;
    if (paramBoolean2) {
      localDrawable2 = getWebImage(paramContext, this.watchAdButtonUrl, 3);
    } else {
      localDrawable2 = null;
    }
    hideLoading();
    ThreadManager.getUIHandler().post(new RaffleJsPlugin.6(this, paramContext, localDrawable3, localDrawable1, localDrawable2, paramBoolean1, paramBoolean2));
  }
  
  private void showGameSuccessDialog(Context paramContext)
  {
    QMLog.d(TAG, "showGameSuccessDialog");
    Drawable localDrawable1 = getWebImage(paramContext, this.logoUrl, 1);
    Drawable localDrawable2 = getWebImage(paramContext, this.wishingImgUrl, 1);
    Drawable localDrawable3 = getWebImage(paramContext, this.prizeUrl, 2);
    Drawable localDrawable4 = getWebImage(paramContext, this.receiveUrl, 2);
    Drawable localDrawable5 = getWebImage(paramContext, this.goBackMainButtonUrl, 3);
    hideLoading();
    ThreadManager.getUIHandler().post(new RaffleJsPlugin.4(this, paramContext, localDrawable1, localDrawable2, localDrawable3, localDrawable4, localDrawable5));
  }
  
  private void showRewardedAd(Context paramContext)
  {
    boolean bool;
    if ((!this.mIsRequestingAd) && (this.mRewardedVideoAd != null)) {
      bool = true;
    } else {
      bool = false;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showRewardedAd isValid:");
    localStringBuilder.append(bool);
    QMLog.d(str, localStringBuilder.toString());
    if (bool)
    {
      this.mRewardedVideoAd.showAD(paramContext, "");
      this.mRewardedVideoAd = null;
      AdFrequencyLimit.setRewardVideoAdShowing(true);
      return;
    }
    loadAdError(paramContext);
  }
  
  private void springHbGameFailReport(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = this.appid;
    String str2 = "";
    if (str1 == null) {
      str1 = "";
    }
    Object localObject1 = this.activeId;
    if (localObject1 != null) {
      localObject1 = ((Integer)localObject1).toString();
    } else {
      localObject1 = "";
    }
    Object localObject2 = this.promotionId;
    if (localObject2 != null) {
      str2 = ((Integer)localObject2).toString();
    }
    localObject2 = new HashMap();
    ((Map)localObject2).put("app_id", str1);
    ((Map)localObject2).put("active_id", localObject1);
    ((Map)localObject2).put("jackpot_id", str2);
    ((Map)localObject2).put("ext1", "1");
    boolean bool;
    if (paramBoolean2) {
      bool = true;
    } else {
      bool = false;
    }
    ((Map)localObject2).put("ext2", String.valueOf(paramBoolean1 | bool));
    str1 = TAG;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("springHbGameFailReport \neventName:xiaoyouxi_fail \nactionType: exp \nparams: ");
    ((StringBuilder)localObject1).append(localObject2.toString());
    QMLog.d(str1, ((StringBuilder)localObject1).toString());
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).springHbReport("xiaoyouxi_fail", 0, 0, (Map)localObject2, "exp");
  }
  
  private void springHbReport(String paramString1, String paramString2)
  {
    String str1 = this.appid;
    String str2 = "";
    if (str1 == null) {
      str1 = "";
    }
    Object localObject1 = this.activeId;
    if (localObject1 != null) {
      localObject1 = ((Integer)localObject1).toString();
    } else {
      localObject1 = "";
    }
    Object localObject2 = this.promotionId;
    if (localObject2 != null) {
      str2 = ((Integer)localObject2).toString();
    }
    localObject2 = new HashMap();
    ((Map)localObject2).put("app_id", str1);
    ((Map)localObject2).put("active_id", localObject1);
    ((Map)localObject2).put("jackpot_id", str2);
    ((Map)localObject2).put("ext1", "1");
    str1 = TAG;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("springHbReport \neventName:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" \nactionType: ");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(" \nparams: ");
    ((StringBuilder)localObject1).append(localObject2.toString());
    QMLog.d(str1, ((StringBuilder)localObject1).toString());
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).springHbReport(paramString1, 0, 0, (Map)localObject2, paramString2);
  }
  
  private void springHbReportError(int paramInt)
  {
    String str = this.appid;
    if (str == null) {
      str = "";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_id", str);
    localHashMap.put("ext1", "1");
    localHashMap.put("ext2", String.valueOf(paramInt));
    str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("springHbReport \neventName:xiaoyouxi_raffle_error \nactionType: exp \nparams: ");
    localStringBuilder.append(localHashMap.toString());
    QMLog.d(str, localStringBuilder.toString());
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).springHbReport("xiaoyouxi_raffle_error", 0, 0, localHashMap, "exp");
  }
  
  private void writeToSp(Context paramContext)
  {
    try
    {
      paramContext = getSharedPreferences(paramContext);
      if (paramContext == null)
      {
        QMLog.e(TAG, "writeToSp SharedPreferences is null");
        return;
      }
      paramContext = paramContext.edit();
      paramContext.putString("prizeUrl", this.prizeUrl);
      paramContext.putString("receiveUrl", this.receiveUrl);
      paramContext.putString("goBackMainButtonUrl", this.goBackMainButtonUrl);
      paramContext.putString("failUrl", this.failUrl);
      paramContext.putString("shareButtonUrl", this.shareButtonUrl);
      paramContext.putString("wishingImgUrl", this.wishingImgUrl);
      paramContext.putString("watchAdButtonUrl", this.watchAdButtonUrl);
      paramContext.putInt("promotionId", this.promotionId.intValue());
      paramContext.putInt("activeId", this.activeId.intValue());
      paramContext.putLong("updateTime", System.currentTimeMillis());
      paramContext.apply();
      return;
    }
    catch (Exception paramContext)
    {
      QMLog.e(TAG, "saveGetGameRaffleMaterialResult Exception", paramContext);
    }
  }
  
  public void hideLoading()
  {
    ThreadManager.getUIHandler().post(this.hideLoadingRunnable);
  }
  
  @JsEvent({"onRaffleShareSucNotice"})
  public void onRaffleShareSucNotice(RequestEvent paramRequestEvent)
  {
    QMLog.d(TAG, "onRaffleShareSucNotice");
    ThreadManager.getUIHandler().post(new RaffleJsPlugin.1(this));
    springHbReport("xiaoyouxi_fail_share_finish", "exp");
  }
  
  public void showLoading()
  {
    ThreadManager.getUIHandler().postDelayed(this.showLoadingRunnable, 500L);
  }
  
  @JsEvent({"minigameRaffle"})
  public void startRaffle(RequestEvent paramRequestEvent)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRaffle params: ");
    localStringBuilder.append(paramRequestEvent.jsonParams);
    QMLog.d((String)localObject, localStringBuilder.toString());
    if (this.mApkgInfo != null) {
      localObject = this.mApkgInfo.appId;
    } else {
      localObject = null;
    }
    this.appid = ((String)localObject);
    this.uin = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
    if ((!TextUtils.isEmpty(this.appid)) && (!TextUtils.isEmpty(this.uin))) {
      try
      {
        localObject = new JSONObject(paramRequestEvent.jsonParams);
        boolean bool1 = ((JSONObject)localObject).getBoolean("isSuccess");
        boolean bool2 = ((JSONObject)localObject).optBoolean("canShare", false);
        boolean bool3 = ((JSONObject)localObject).optBoolean("canWatchAd", false);
        this.posId = ((JSONObject)localObject).optString("adUnitId");
        if (isAdInvalid(bool1, bool3, this.posId))
        {
          QMLog.e(TAG, "startRaffle canWatchAd but posId is null");
          paramRequestEvent.fail();
          return;
        }
        paramRequestEvent.ok();
        paramRequestEvent = this.mMiniAppContext.getAttachedActivity();
        this.isHorizontal = this.mMiniAppContext.isOrientationLandscape();
        if (isNoNetwork(paramRequestEvent))
        {
          showErrorToast(paramRequestEvent, paramRequestEvent.getResources().getString(R.string.mini_sdk_game_raffle_no_network));
          onRaffleError("no network");
          return;
        }
        if (bool1)
        {
          doGameRaffle(paramRequestEvent);
          return;
        }
        gameRaffleFail(paramRequestEvent, bool2, bool3);
        if (bool3)
        {
          this.mIsAlreadyFail = false;
          this.mIsPreloadAd = true;
          loadRewardedAd(paramRequestEvent);
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QMLog.e(TAG, "startRaffle isSuccess is null", localJSONException);
        paramRequestEvent.fail();
        return;
      }
    }
    String str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRaffle appid=");
    localStringBuilder.append(this.appid);
    localStringBuilder.append(";uin=");
    localStringBuilder.append(this.uin);
    QMLog.e(str, localStringBuilder.toString());
    paramRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin
 * JD-Core Version:    0.7.0.1
 */