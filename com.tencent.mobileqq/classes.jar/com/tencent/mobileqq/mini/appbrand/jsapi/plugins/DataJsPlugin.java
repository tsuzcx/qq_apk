package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import acvb;
import admy;
import adnb;
import adng;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.jsapi.callbacks.IGameUI;
import com.tencent.mobileqq.minigame.jsapi.manager.SystemInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import yuk;

public class DataJsPlugin
  extends BaseJsPlugin
{
  public static final String AD_REF_ID = "biz_src_miniappD";
  public static final String API_ADD_CONTACT = "private_addContact";
  public static final String API_BATCH_GET_CONTACT = "batchGetContact";
  public static final String API_GET_APP_CONFIG = "getAppConfig";
  public static final String API_GET_CLOUD_TICKET = "getCloudTicket";
  public static final String API_GET_LAUNCH_OPTIONS_SYNC = "getLaunchOptionsSync";
  public static final String API_GET_PERFORMANCE = "getPerformance";
  public static final String API_GET_PERMISSION_BYTES = "getPermissionBytes";
  public static final String API_GET_SHARE_INFO = "getShareInfo";
  private static final String API_GET_SYSTEM_INFO = "getSystemInfo";
  private static final String API_GET_SYSTEM_INFO_SYNC = "getSystemInfoSync";
  private static final String API_GET_TEXT_LINEHEIGHT = "getTextLineHeight";
  public static final String API_HIDE_SHARE_MENU = "hideShareMenu";
  public static final String API_INIT_READY = "initReady";
  public static final String API_LOGIN = "login";
  public static final String API_PRIVATE_OPENURL = "private_openUrl";
  public static final String API_PROFILE = "profile";
  public static final String API_REFRESH_SESSION = "refreshSession";
  public static final String API_SET_OFFLINE_RESOURCE_READY = "recordOffLineResourceState";
  public static final String API_SHARE_APP_MSG = "shareAppMessage";
  public static final String API_SHARE_APP_MSG_DIRECTLY = "shareAppMessageDirectly";
  public static final String API_SHARE_APP_MSG_DIRECTLY_TO_FRIEND_LIST = "shareAppMessageDirectlyToFriendList";
  public static final String API_SHARE_APP_PIC_MSG = "shareAppPictureMessage";
  public static final String API_SHARE_APP_PIC_MSG_DIRECTLY = "shareAppPictureMessageDirectly";
  public static final String API_SHARE_APP_PIC_MSG_TO_FRIEND_LIST = "shareAppPictureMessageDirectlyToFriendList";
  public static final String API_SHARE_INVITE = "shareInvite";
  public static final String API_SHOW_SHARE_MENU = "showShareMenu";
  public static final String API_SHOW_SHARE_MENU_WITH_SHARE_TICKET = "showShareMenuWithShareTicket";
  public static final String API_UPDATE_SHARE_MENU = "updateShareMenuShareTicket";
  public static final String API_VERIFY_PLUGIN = "verifyPlugin";
  private static final String CONFIG_SPLIT = ",";
  public static final int ERRCODE_INVITE_CANCEL = 1;
  public static final int ERRCODE_INVITE_REQUIRE = 2;
  public static final String ERRMSG_INVITE_CANCEL = "用户取消";
  public static final String ERRMSG_INVITE_REQUIRE = "分享失败";
  private static final String MINI_APP_STORE_APPID = "1108291530";
  public static final int NEED_HIDE = 0;
  public static final int NEED_SHOW = 1;
  public static final String PREF_NAME = "miniAppLoginSp";
  public static final String PRIVATE_API_NAVIGATE_TO_MINI_PROGRAM_CONFIG = "navigateToMiniProgramConfig";
  public static final String SHARE_ITEM_QQ = "qq";
  public static final String SHARE_ITEM_QZONE = "qzone";
  public static final String SHARE_ITEM_WECHAT_FRIEND = "wechatFriends";
  public static final String SHARE_ITEM_WECHAT_MOMENT = "wechatMoment";
  public static final int SHARE_TARGET_QQ = 0;
  public static final int SHARE_TARGET_QQ_DIRECTLY = 2;
  public static final int SHARE_TARGET_QZONE = 1;
  public static final int SHARE_TARGET_SHARE_CHAT = 5;
  public static final int SHARE_TARGET_TO_FRIEND_LIST = 6;
  public static final int SHARE_TARGET_WECHAT_FRIEND = 3;
  public static final int SHARE_TARGET_WECHAT_MOMENTS = 4;
  private static final Set<String> S_EVENT_MAP = new DataJsPlugin.1();
  private static final String TAG = "[mini] DataJsPlugin";
  public static final int UNDEFINED = -1;
  private static final int WHAT_GET_SHARE_INFO_TIMEOUT = 1;
  private static final String fakeCheckNavigateRightRsp = "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}";
  private adnb apiManager;
  private Map<Integer, JsRuntime> cacheCallbackId2JsRuntime = new HashMap();
  private Long lastNotRspReqTime = Long.valueOf(0L);
  private List<admy> loginCallBacks = new LinkedList();
  protected GdtAppReceiver mGgtAppReceiver;
  private SystemInfoManager mSystemInfoManager;
  private ArrayList<String> openUrlDomainWhiteList;
  private String privateOpenUrlDomainWhiteList;
  
  private boolean doShareInvite(JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
    if (!this.cacheCallbackId2JsRuntime.containsKey(Integer.valueOf(paramInt))) {
      this.cacheCallbackId2JsRuntime.put(Integer.valueOf(paramInt), paramJsRuntime);
    }
    try
    {
      MiniProgramShareUtils.shareUpdatableMsg(this.jsPluginEngine.activityContext, this.jsPluginEngine.appBrandRuntime.appId, this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config.verType, "657667B4D8C04B3F84E4AAA3D046A903", paramString, paramInt);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[mini] DataJsPlugin", 1, "shareInvite error, ", localThrowable);
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, paramInt);
    }
    return false;
  }
  
  private void downloadImageByURLDrawable(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramURLDrawableListener != null)
    {
      if (paramString.getStatus() != 1) {
        break label45;
      }
      yuk.b("[mini] DataJsPlugin", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label45:
      yuk.b("[mini] DataJsPlugin", "start load URLDrawable.");
    }
  }
  
  private qq_ad_get.QQAdGetRsp.AdInfo getBannerAdInfo(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString).getJSONArray("pos_ads_info").getJSONObject(0);
      int i = Integer.valueOf(((JSONObject)localObject).getString("ret")).intValue();
      ((JSONObject)localObject).getString("msg");
      if (i == 0)
      {
        localObject = ((JSONObject)localObject).getJSONArray("ads_info").getJSONObject(0);
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(acvb.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.i("[mini] DataJsPlugin", 2, "getBannerAdInfo error" + paramString, localException);
      return null;
    }
    return null;
  }
  
  private void getOpenUrlDomainWhiteList()
  {
    if (this.openUrlDomainWhiteList == null)
    {
      String str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "domainWhiteList", "tucao.qq.com,mobile.qzone.qq.com");
      if ((str1 != null) && (!str1.equals(this.privateOpenUrlDomainWhiteList)))
      {
        QLog.i("[mini] DataJsPlugin", 1, "getOpenUrlDomainWhiteList:" + str1);
        this.openUrlDomainWhiteList = new ArrayList();
        try
        {
          String[] arrayOfString = str1.split(",");
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              String str2 = arrayOfString[i];
              if (!TextUtils.isEmpty(str2)) {
                this.openUrlDomainWhiteList.add(str2);
              }
              i += 1;
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.privateOpenUrlDomainWhiteList = str1;
        }
      }
    }
  }
  
  private static SharedPreferences getPreference(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getSharedPreferences(paramString, 0);
    }
    return null;
  }
  
  private void handleAdApi(JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString, int paramInt1, int paramInt2)
  {
    String str3 = paramJSONObject.optJSONObject("data").optString("pos_id");
    if (paramJSONObject.optJSONObject("data").has("adType")) {
      paramInt2 = paramJSONObject.optJSONObject("data").optInt("adType");
    }
    for (;;)
    {
      int i = 1;
      if (paramJSONObject.optJSONObject("data").has("size")) {
        i = paramJSONObject.optJSONObject("data").optInt("size");
      }
      long l = Long.valueOf(this.jsPluginEngine.activityContext.getCurrentAccountUin()).longValue();
      paramJSONObject = null;
      if (this.jsPluginEngine.appBrandRuntime != null) {
        paramJSONObject = this.jsPluginEngine.appBrandRuntime.appId;
      }
      QLog.d("[mini] DataJsPlugin", 2, "getBlockAd appid = " + paramJSONObject);
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        String str4 = AdUtils.getSpAdGdtCookie(paramInt2);
        ApkgInfo localApkgInfo = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
        Object localObject2 = "";
        Object localObject4 = "";
        String str2 = "";
        String str1 = "";
        Object localObject1 = localObject2;
        if (localApkgInfo != null)
        {
          localObject1 = localObject2;
          if (localApkgInfo.appConfig != null)
          {
            localObject1 = localObject2;
            if (localApkgInfo.appConfig.launchParam != null)
            {
              localObject1 = localObject2;
              if (localApkgInfo.appConfig.launchParam.entryPath != null) {
                localObject1 = localApkgInfo.appConfig.launchParam.entryPath;
              }
            }
          }
        }
        Object localObject3 = localObject4;
        localObject2 = str2;
        if (localApkgInfo != null)
        {
          localObject3 = localObject4;
          localObject2 = str2;
          if (localApkgInfo.appConfig != null)
          {
            localObject3 = localObject4;
            localObject2 = str2;
            if (localApkgInfo.appConfig.launchParam != null)
            {
              localObject3 = localApkgInfo.appConfig.launchParam.reportData;
              localObject2 = String.valueOf(localApkgInfo.appConfig.launchParam.scene);
            }
          }
        }
        localObject4 = str1;
        if (localApkgInfo != null)
        {
          localObject4 = str1;
          if (localApkgInfo.appConfig != null)
          {
            localObject4 = str1;
            if (localApkgInfo.appConfig.config != null) {
              localObject4 = localApkgInfo.appConfig.config.via;
            }
          }
        }
        sendAdRequest(AdUtils.createAdRequest(this.jsPluginEngine.activityContext, l, str3, paramJSONObject, 53, paramInt2, 0, str4, (String)localObject1, (String)localObject3, (String)localObject2, (String)localObject4, i), paramJsRuntime, paramString, paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private String handleGameSystemInfo(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    MiniGamePkg localMiniGamePkg = null;
    if (this.jsPluginEngine != null) {}
    for (Object localObject1 = this.jsPluginEngine.getActivityContext();; localObject1 = null)
    {
      boolean bool;
      if ((localObject1 instanceof GameActivity)) {
        if (this.mSystemInfoManager == null)
        {
          this.mSystemInfoManager = new SystemInfoManager((Context)localObject1);
          Object localObject2 = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.jsPluginEngine.appBrandRuntime.activity);
          if (localObject2 != null) {
            localMiniGamePkg = ((GameRuntimeLoader)localObject2).getMiniGamePkg();
          }
          localObject2 = this.mSystemInfoManager;
          if ((localMiniGamePkg == null) || (!localMiniGamePkg.isOrientationLandscape())) {
            break label160;
          }
          bool = true;
          ((SystemInfoManager)localObject2).setLandscape(bool);
          this.mSystemInfoManager.setGameUI((IGameUI)localObject1);
          localObject1 = this.jsPluginEngine.getActivityContext();
          this.mSystemInfoManager.setActivity((Activity)localObject1);
        }
      }
      for (localObject1 = this.mSystemInfoManager.getSystemInfo();; localObject1 = ApiUtil.wrapCallbackFail(paramString, null))
      {
        if (!"getSystemInfoSync".equals(paramString)) {
          break label185;
        }
        return ((JSONObject)localObject1).toString();
        label160:
        bool = false;
        break;
        QLog.e("[mini] DataJsPlugin", 1, "getSystemInfo error, context is not GameActivity");
      }
      label185:
      paramJsRuntime.evaluateCallbackJs(paramInt, ((JSONObject)localObject1).toString());
      return "";
    }
  }
  
  private void handleWebapiPluginGetuserinfo(JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString1, int paramInt, String paramString2)
  {
    try
    {
      Object localObject = paramJSONObject.optJSONObject("data");
      paramJSONObject = ((JSONObject)localObject).optString("miniprogram_appid");
      boolean bool = ((JSONObject)localObject).optBoolean("withCredentials");
      localObject = ((JSONObject)localObject).optString("lang");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        getUserInfo(paramJSONObject, paramJsRuntime, paramString1, paramString2, paramInt, bool, (String)localObject);
        return;
      }
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
      AuthorizeCenter.setAllowPluginScopeName(null);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void handleWebapiPluginLogin(JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("data").optString("miniprogram_appid");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        MiniAppCmdUtil.getInstance().getLoginCode(paramJSONObject, new DataJsPlugin.24(this, paramJsRuntime, paramString, paramInt));
        return;
      }
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, paramInt);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void handleWebapiPluginSetauth(JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
    try
    {
      Object localObject1 = paramJSONObject.optJSONObject("data");
      if (localObject1 != null)
      {
        localObject1 = ((JSONObject)localObject1).optString("miniprogram_appid");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject2 = getAppBrandRuntime();
          if (localObject2 == null) {
            return;
          }
          paramJSONObject = paramJSONObject.optString("plugin_appid");
          localObject2 = ((AppBrandRuntime)localObject2).appInterface.getAuthorizeCenter((String)localObject1);
          paramJSONObject = AuthorizeCenter.getScopePluginSetauthName((String)localObject1, paramJSONObject);
          AuthorizeCenter.setAllowPluginScopeName(paramJSONObject);
          ((AuthorizeCenter)localObject2).setAuthorize(paramJSONObject, true);
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString, null, paramInt);
          return;
        }
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, paramInt);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, paramInt);
  }
  
  private void initApiManager(int paramInt, String paramString)
  {
    adng.a();
    this.apiManager = adng.a(this.jsPluginEngine.getActivityContext(), paramInt, paramString);
  }
  
  private void operateGetShareInfo(String paramString1, int paramInt1, JsRuntime paramJsRuntime, String paramString2, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString2, null, "shareTicket can not be null", paramInt2);
      return;
    }
    Object localObject = new HandlerThread("getShareInfoHandlerThread");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper(), new DataJsPlugin.25(this, paramJsRuntime, paramString2, paramInt2));
    ((Handler)localObject).sendEmptyMessageDelayed(1, paramInt1);
    MiniAppCmdUtil.getInstance().getGroupShareInfo(this.jsPluginEngine.appBrandRuntime.appId, paramString1, null, new DataJsPlugin.26(this, paramJsRuntime, paramString2, paramInt2, (Handler)localObject));
  }
  
  private void saveAdCookie(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).has("gdt_cookie"))
      {
        localObject = ((JSONObject)localObject).getString("gdt_cookie");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        AdUtils.putSpAdGdtCookie(paramInt, (String)localObject);
        QLog.i("[mini] DataJsPlugin", 2, "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + (String)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("[mini] DataJsPlugin", 2, "parseAndSaveCookie error" + paramString, localException);
    }
  }
  
  private void sendAdRequest(MiniAppAd.StGetAdReq paramStGetAdReq, JsRuntime paramJsRuntime, String paramString, int paramInt1, int paramInt2)
  {
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramStGetAdReq, new DataJsPlugin.29(this, paramJsRuntime, paramString, paramInt1, paramInt2));
  }
  
  private void startGroupBrowserActivity(Activity paramActivity, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    paramString1 = new Bundle();
    paramString1.putBoolean("hide_more_button", true);
    localIntent.putExtras(paramString1);
    MiniAppController.getInstance().setActivityResultListener(new DataJsPlugin.30(this, paramJsRuntime, paramString2, paramInt));
    paramActivity.startActivityForResult(localIntent, 9);
  }
  
  private void startShareLocalPicMessage(String paramString1, String paramString2, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      ShareUtils.startSharePicToQQ(this.jsPluginEngine.getActivityContext(), paramString2);
      return;
    case 1: 
      ShareUtils.startSharePicToQzone(this.jsPluginEngine.getActivityContext(), paramString2, this.jsPluginEngine.appBrandRuntime.getApkgInfo().apkgName);
      return;
    case 3: 
      ShareUtils.startSharePicToWeChat(this.jsPluginEngine.getActivityContext(), ShareUtils.getFileUri(this.jsPluginEngine.getActivityContext(), paramString2), true);
      return;
    }
    ShareUtils.startSharePicToWeChat(this.jsPluginEngine.getActivityContext(), ShareUtils.getFileUri(this.jsPluginEngine.getActivityContext(), paramString2), false);
  }
  
  private void startShareNetworkPicMessage(Context paramContext, String paramString1, String paramString2, int paramInt, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    ThreadManager.getUIHandler().post(new DataJsPlugin.31(this, paramContext, paramString2, paramString1, paramInt));
  }
  
  public void getUserInfo(JsRuntime paramJsRuntime, String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    getUserInfo(this.jsPluginEngine.appBrandRuntime.appId, paramJsRuntime, paramString1, paramString2, paramInt, paramBoolean, paramString3);
  }
  
  public void getUserInfo(String paramString1, JsRuntime paramJsRuntime, String paramString2, String paramString3, int paramInt, boolean paramBoolean, String paramString4)
  {
    QLog.d("[mini] DataJsPlugin", 1, "getUserInfo appID:" + paramString1);
    MiniAppCmdUtil.getInstance().getUserInfo(paramString1, paramBoolean, paramString4, new DataJsPlugin.28(this, paramString3, paramJsRuntime, paramString2, paramInt));
  }
  
  public void handleCallback(int paramInt, String paramString)
  {
    if (this.cacheCallbackId2JsRuntime.get(Integer.valueOf(paramInt)) != null) {
      ((JsRuntime)this.cacheCallbackId2JsRuntime.remove(Integer.valueOf(paramInt))).evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  /* Error */
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 894	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc 150
    //   8: iconst_2
    //   9: new 419	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 896
    //   19: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 898
    //   29: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 900
    //   39: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 771	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_3
    //   54: ifnonnull +18 -> 72
    //   57: ldc 150
    //   59: iconst_4
    //   60: ldc_w 902
    //   63: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: ldc_w 545
    //   69: astore_2
    //   70: aload_2
    //   71: areturn
    //   72: aconst_null
    //   73: astore 22
    //   75: aload_0
    //   76: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   79: ifnull +12 -> 91
    //   82: aload_0
    //   83: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   86: invokevirtual 579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   89: astore 22
    //   91: aload 22
    //   93: ifnull +26 -> 119
    //   96: new 419	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   103: aload_1
    //   104: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 22
    //   109: invokevirtual 907	java/lang/Object:hashCode	()I
    //   112: invokevirtual 771	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: pop
    //   119: ldc 35
    //   121: aload_1
    //   122: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +12 -> 137
    //   128: ldc 38
    //   130: aload_1
    //   131: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +1334 -> 1468
    //   137: aload 22
    //   139: ifnull +1297 -> 1436
    //   142: aload_0
    //   143: getfield 911	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isGameRuntime	Z
    //   146: ifeq +12 -> 158
    //   149: aload_0
    //   150: aload_1
    //   151: aload_3
    //   152: iload 4
    //   154: invokespecial 913	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleGameSystemInfo	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)Ljava/lang/String;
    //   157: areturn
    //   158: getstatic 918	android/os/Build$VERSION:SDK_INT	I
    //   161: bipush 17
    //   163: if_icmplt +945 -> 1108
    //   166: new 920	android/util/DisplayMetrics
    //   169: dup
    //   170: invokespecial 921	android/util/DisplayMetrics:<init>	()V
    //   173: astore_2
    //   174: aload 22
    //   176: ldc_w 923
    //   179: invokevirtual 927	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   182: checkcast 929	android/view/WindowManager
    //   185: invokeinterface 933 1 0
    //   190: aload_2
    //   191: invokevirtual 939	android/view/Display:getRealMetrics	(Landroid/util/DisplayMetrics;)V
    //   194: getstatic 944	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   197: ldc_w 946
    //   200: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   203: ifeq +917 -> 1120
    //   206: aload 22
    //   208: invokestatic 955	com/tencent/mobileqq/mini/util/DisplayUtil:checkNavigationBarShow	(Landroid/content/Context;)Z
    //   211: istore 15
    //   213: aload_2
    //   214: getfield 959	android/util/DisplayMetrics:density	F
    //   217: f2d
    //   218: dstore 5
    //   220: aload_2
    //   221: getfield 962	android/util/DisplayMetrics:widthPixels	I
    //   224: i2d
    //   225: dload 5
    //   227: ddiv
    //   228: invokestatic 968	java/lang/Math:round	(D)J
    //   231: l2f
    //   232: ldc_w 969
    //   235: fadd
    //   236: f2i
    //   237: istore 12
    //   239: aload_2
    //   240: getfield 972	android/util/DisplayMetrics:heightPixels	I
    //   243: i2d
    //   244: dload 5
    //   246: ddiv
    //   247: invokestatic 968	java/lang/Math:round	(D)J
    //   250: l2f
    //   251: ldc_w 969
    //   254: fadd
    //   255: f2i
    //   256: istore 8
    //   258: iload 8
    //   260: istore 7
    //   262: iload 15
    //   264: ifeq +23 -> 287
    //   267: iload 8
    //   269: aload_0
    //   270: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   273: invokevirtual 579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   276: invokestatic 976	com/tencent/mobileqq/mini/util/DisplayUtil:getNavigationBarHeight	(Landroid/content/Context;)I
    //   279: i2d
    //   280: dload 5
    //   282: ddiv
    //   283: d2i
    //   284: isub
    //   285: istore 7
    //   287: aload 22
    //   289: invokestatic 981	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   292: i2f
    //   293: invokestatic 984	java/lang/Math:round	(F)I
    //   296: i2d
    //   297: dload 5
    //   299: ddiv
    //   300: d2i
    //   301: istore 10
    //   303: ldc_w 985
    //   306: invokestatic 989	bhtq:b	(F)I
    //   309: i2d
    //   310: dload 5
    //   312: ddiv
    //   313: ldc2_w 990
    //   316: dadd
    //   317: d2i
    //   318: istore 9
    //   320: ldc_w 992
    //   323: invokestatic 989	bhtq:b	(F)I
    //   326: i2d
    //   327: dload 5
    //   329: ddiv
    //   330: ldc2_w 990
    //   333: dadd
    //   334: d2i
    //   335: istore 8
    //   337: aconst_null
    //   338: astore 20
    //   340: aload_0
    //   341: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   344: ifnull +810 -> 1154
    //   347: aload_0
    //   348: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   351: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   354: ifnull +800 -> 1154
    //   357: aload_0
    //   358: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   361: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   364: invokevirtual 996	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   367: ifnull +787 -> 1154
    //   370: aload_0
    //   371: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   374: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   377: invokevirtual 996	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   380: invokevirtual 1001	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   383: ifnull +771 -> 1154
    //   386: aload_0
    //   387: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   390: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   393: invokevirtual 996	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   396: invokevirtual 1001	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   399: astore 20
    //   401: aload 20
    //   403: astore_2
    //   404: aload 20
    //   406: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   409: ifne +9929 -> 10338
    //   412: aload_0
    //   413: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   416: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   419: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   422: invokevirtual 1005	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   425: aload 20
    //   427: invokevirtual 1011	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   430: getfield 1017	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   433: getfield 1023	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   436: getfield 1028	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   439: astore 21
    //   441: aload 20
    //   443: astore_2
    //   444: aload_0
    //   445: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   448: ifnull +9884 -> 10332
    //   451: aload_0
    //   452: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   455: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   458: ifnull +9874 -> 10332
    //   461: aload_0
    //   462: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   465: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   468: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   471: ifnull +9861 -> 10332
    //   474: aload_0
    //   475: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   478: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   481: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   484: invokevirtual 1005	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   487: ifnull +9845 -> 10332
    //   490: aload_0
    //   491: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   494: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   497: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   500: invokevirtual 1005	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   503: getfield 1032	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   506: ifnull +857 -> 1363
    //   509: aload_0
    //   510: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   513: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   516: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   519: aload_2
    //   520: invokevirtual 1035	com/tencent/mobileqq/mini/apkg/ApkgInfo:isTabBarPage	(Ljava/lang/String;)Z
    //   523: ifeq +840 -> 1363
    //   526: aload_0
    //   527: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   530: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   533: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   536: invokevirtual 1005	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   539: getfield 1032	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   542: invokevirtual 1040	com/tencent/mobileqq/mini/apkg/TabBarInfo:isShow	()Z
    //   545: ifeq +818 -> 1363
    //   548: iconst_1
    //   549: istore 16
    //   551: ldc_w 1042
    //   554: aload 21
    //   556: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   559: ifeq +816 -> 1375
    //   562: iload 16
    //   564: ifeq +805 -> 1369
    //   567: iload 7
    //   569: iload 10
    //   571: isub
    //   572: iload 9
    //   574: isub
    //   575: iload 8
    //   577: isub
    //   578: istore 8
    //   580: invokestatic 1045	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   583: ifeq +63 -> 646
    //   586: ldc 150
    //   588: iconst_1
    //   589: new 419	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   596: ldc_w 1047
    //   599: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: iload 8
    //   604: invokevirtual 771	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   607: ldc_w 1049
    //   610: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 21
    //   615: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 1051
    //   621: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: iload 16
    //   626: invokevirtual 1054	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   629: ldc_w 1056
    //   632: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: iload 15
    //   637: invokevirtual 1054	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   640: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: aload 22
    //   648: aload 22
    //   650: invokestatic 1061	bnlc:a	(Landroid/content/Context;Landroid/app/Activity;)I
    //   653: istore 11
    //   655: iload 11
    //   657: istore 9
    //   659: iload 11
    //   661: ifne +7 -> 668
    //   664: iload 10
    //   666: istore 9
    //   668: new 371	org/json/JSONObject
    //   671: dup
    //   672: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   675: astore_2
    //   676: aload_2
    //   677: ldc_w 1064
    //   680: iconst_0
    //   681: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   684: pop
    //   685: aload_2
    //   686: ldc_w 1069
    //   689: iload 9
    //   691: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   694: pop
    //   695: aload_2
    //   696: ldc_w 1071
    //   699: iload 12
    //   701: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   704: pop
    //   705: aload_2
    //   706: ldc_w 1073
    //   709: iload 7
    //   711: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   714: pop
    //   715: aload_2
    //   716: ldc_w 1075
    //   719: iload 12
    //   721: iconst_0
    //   722: isub
    //   723: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   726: pop
    //   727: aload_2
    //   728: ldc_w 1077
    //   731: iload 7
    //   733: iload 9
    //   735: isub
    //   736: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   739: pop
    //   740: invokestatic 1083	com/tencent/mobileqq/mini/app/AppLoaderFactory:getAppLoaderManager	()Lcom/tencent/mobileqq/mini/app/BaseAppLoaderManager;
    //   743: invokeinterface 1089 1 0
    //   748: getfield 1094	com/tencent/mobileqq/mini/sdk/BaseLibInfo:baseLibVersion	Ljava/lang/String;
    //   751: astore 21
    //   753: new 371	org/json/JSONObject
    //   756: dup
    //   757: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   760: astore 20
    //   762: aload 20
    //   764: ldc_w 1096
    //   767: getstatic 1099	android/os/Build:BRAND	Ljava/lang/String;
    //   770: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   773: pop
    //   774: aload 20
    //   776: ldc_w 1104
    //   779: getstatic 1107	android/os/Build:MODEL	Ljava/lang/String;
    //   782: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   785: pop
    //   786: aload 20
    //   788: ldc_w 1109
    //   791: dload 5
    //   793: invokevirtual 1112	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   796: pop
    //   797: aload 20
    //   799: ldc_w 1114
    //   802: iload 12
    //   804: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   807: pop
    //   808: aload 20
    //   810: ldc_w 1116
    //   813: iload 7
    //   815: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   818: pop
    //   819: aload 20
    //   821: ldc_w 1118
    //   824: iload 12
    //   826: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   829: pop
    //   830: aload 20
    //   832: ldc_w 1120
    //   835: iload 8
    //   837: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   840: pop
    //   841: aload 20
    //   843: ldc_w 1122
    //   846: iload 10
    //   848: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   851: pop
    //   852: aload 20
    //   854: ldc_w 1124
    //   857: ldc_w 1126
    //   860: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   863: pop
    //   864: aload 20
    //   866: ldc_w 1128
    //   869: invokestatic 1133	bhlo:c	()Ljava/lang/String;
    //   872: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   875: pop
    //   876: aload 20
    //   878: ldc_w 1135
    //   881: new 419	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   888: ldc_w 1137
    //   891: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: getstatic 1140	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   897: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   906: pop
    //   907: aload 20
    //   909: ldc_w 1142
    //   912: ldc_w 1144
    //   915: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   918: pop
    //   919: aload 20
    //   921: ldc_w 1146
    //   924: bipush 16
    //   926: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   929: pop
    //   930: aload 20
    //   932: ldc_w 1148
    //   935: aload 21
    //   937: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   940: pop
    //   941: aload 20
    //   943: ldc_w 1150
    //   946: ldc 124
    //   948: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   951: pop
    //   952: aload 20
    //   954: ldc_w 1152
    //   957: aload_2
    //   958: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   961: pop
    //   962: aload_0
    //   963: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   966: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   969: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   972: invokevirtual 1005	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   975: getfield 1155	com/tencent/mobileqq/mini/apkg/AppConfigInfo:darkmode	Z
    //   978: ifeq +37 -> 1015
    //   981: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   984: invokevirtual 1159	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   987: invokestatic 1165	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   990: astore_2
    //   991: ldc_w 1167
    //   994: aload_2
    //   995: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   998: ifeq +414 -> 1412
    //   1001: ldc_w 1169
    //   1004: astore_2
    //   1005: aload 20
    //   1007: ldc_w 1171
    //   1010: aload_2
    //   1011: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1014: pop
    //   1015: aload_1
    //   1016: aload 20
    //   1018: invokestatic 1174	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1021: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1024: astore 20
    //   1026: aload 20
    //   1028: astore_2
    //   1029: ldc 35
    //   1031: aload_1
    //   1032: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1035: ifeq -965 -> 70
    //   1038: aload_3
    //   1039: iload 4
    //   1041: aload 20
    //   1043: invokeinterface 647 3 0
    //   1048: aload 20
    //   1050: areturn
    //   1051: astore_2
    //   1052: ldc 150
    //   1054: iconst_1
    //   1055: new 419	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   1062: ldc_w 1176
    //   1065: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: new 253	java/lang/Throwable
    //   1071: dup
    //   1072: aload_2
    //   1073: invokespecial 1179	java/lang/Throwable:<init>	(Ljava/lang/Throwable;)V
    //   1076: invokevirtual 1182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1079: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1082: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1085: aload_1
    //   1086: aconst_null
    //   1087: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1090: astore_1
    //   1091: aload_3
    //   1092: iload 4
    //   1094: aload_1
    //   1095: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1098: invokeinterface 647 3 0
    //   1103: aload_1
    //   1104: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1107: areturn
    //   1108: aload 22
    //   1110: invokevirtual 1186	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1113: invokevirtual 1192	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1116: astore_2
    //   1117: goto -923 -> 194
    //   1120: aload 22
    //   1122: invokestatic 1195	com/tencent/mobileqq/mini/util/DisplayUtil:hasNavBar	(Landroid/content/Context;)Z
    //   1125: ifeq +11 -> 1136
    //   1128: aload 22
    //   1130: invokestatic 1199	com/tencent/mobileqq/mini/util/DisplayUtil:isNavigationBarExist	(Landroid/app/Activity;)Z
    //   1133: ifne +9 -> 1142
    //   1136: invokestatic 1202	com/tencent/mobileqq/mini/util/DisplayUtil:isFlymeOS7NavBarShow	()Z
    //   1139: ifeq +9 -> 1148
    //   1142: iconst_1
    //   1143: istore 15
    //   1145: goto -932 -> 213
    //   1148: iconst_0
    //   1149: istore 15
    //   1151: goto -938 -> 213
    //   1154: aload 20
    //   1156: astore_2
    //   1157: aload_0
    //   1158: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1161: ifnull +9177 -> 10338
    //   1164: aload 20
    //   1166: astore_2
    //   1167: aload_0
    //   1168: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1171: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1174: ifnull +9164 -> 10338
    //   1177: aload 20
    //   1179: astore_2
    //   1180: aload_0
    //   1181: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1184: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1187: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1190: ifnull +9148 -> 10338
    //   1193: aconst_null
    //   1194: astore 20
    //   1196: aload 20
    //   1198: astore_2
    //   1199: aload_0
    //   1200: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1203: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1206: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1209: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1212: ifnull +45 -> 1257
    //   1215: aload 20
    //   1217: astore_2
    //   1218: aload_0
    //   1219: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1222: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1225: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1228: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1231: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1234: ifnull +23 -> 1257
    //   1237: aload_0
    //   1238: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1241: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1244: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1247: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1250: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1253: getfield 554	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   1256: astore_2
    //   1257: aconst_null
    //   1258: astore 20
    //   1260: aload_0
    //   1261: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1264: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1267: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1270: getfield 1206	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1273: ifnull +21 -> 1294
    //   1276: aload_0
    //   1277: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1280: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1283: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1286: getfield 1206	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1289: getfield 1209	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   1292: astore 20
    //   1294: aload_0
    //   1295: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1298: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1301: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1304: aload_2
    //   1305: invokevirtual 1212	com/tencent/mobileqq/mini/apkg/ApkgInfo:isUrlFileExist	(Ljava/lang/String;)Z
    //   1308: ifne +49 -> 1357
    //   1311: aload 20
    //   1313: astore_2
    //   1314: aload 20
    //   1316: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1319: ifne +9019 -> 10338
    //   1322: aload_0
    //   1323: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1326: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1329: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1332: invokevirtual 1005	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1335: aload 20
    //   1337: invokevirtual 1011	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   1340: getfield 1017	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   1343: getfield 1023	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   1346: getfield 1028	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   1349: astore 21
    //   1351: aload 20
    //   1353: astore_2
    //   1354: goto -910 -> 444
    //   1357: aload_2
    //   1358: astore 20
    //   1360: goto -49 -> 1311
    //   1363: iconst_0
    //   1364: istore 16
    //   1366: goto -815 -> 551
    //   1369: iconst_0
    //   1370: istore 8
    //   1372: goto -805 -> 567
    //   1375: iload 16
    //   1377: ifeq +13 -> 1390
    //   1380: iload 7
    //   1382: iload 8
    //   1384: isub
    //   1385: istore 8
    //   1387: goto -807 -> 580
    //   1390: iconst_0
    //   1391: istore 8
    //   1393: goto -13 -> 1380
    //   1396: astore 20
    //   1398: ldc 150
    //   1400: iconst_1
    //   1401: ldc_w 1214
    //   1404: aload 20
    //   1406: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1409: goto -669 -> 740
    //   1412: ldc_w 1216
    //   1415: aload_2
    //   1416: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1419: ifeq +10 -> 1429
    //   1422: ldc_w 1218
    //   1425: astore_2
    //   1426: goto -421 -> 1005
    //   1429: ldc_w 1169
    //   1432: astore_2
    //   1433: goto -428 -> 1005
    //   1436: ldc 150
    //   1438: iconst_1
    //   1439: ldc_w 1220
    //   1442: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1445: aload_1
    //   1446: aconst_null
    //   1447: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1450: astore_1
    //   1451: aload_3
    //   1452: iload 4
    //   1454: aload_1
    //   1455: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1458: invokeinterface 647 3 0
    //   1463: aload_1
    //   1464: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1467: areturn
    //   1468: ldc_w 1222
    //   1471: aload_1
    //   1472: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1475: ifeq +135 -> 1610
    //   1478: iconst_0
    //   1479: istore 8
    //   1481: iload 8
    //   1483: istore 7
    //   1485: aload_2
    //   1486: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1489: ifne +70 -> 1559
    //   1492: new 371	org/json/JSONObject
    //   1495: dup
    //   1496: aload_2
    //   1497: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1500: ldc_w 1224
    //   1503: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1506: astore_1
    //   1507: iload 8
    //   1509: istore 7
    //   1511: aload_1
    //   1512: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1515: ifne +44 -> 1559
    //   1518: iconst_1
    //   1519: istore 7
    //   1521: aload 22
    //   1523: new 788	android/content/Intent
    //   1526: dup
    //   1527: ldc_w 1226
    //   1530: new 419	java/lang/StringBuilder
    //   1533: dup
    //   1534: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   1537: ldc_w 1228
    //   1540: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: aload_1
    //   1544: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1550: invokestatic 1234	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1553: invokespecial 1237	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1556: invokevirtual 1241	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1559: iload 7
    //   1561: ifeq +38 -> 1599
    //   1564: ldc_w 1222
    //   1567: aconst_null
    //   1568: invokestatic 1174	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1571: astore_1
    //   1572: aload_1
    //   1573: ifnull +15 -> 1588
    //   1576: aload_3
    //   1577: iload 4
    //   1579: aload_1
    //   1580: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1583: invokeinterface 647 3 0
    //   1588: ldc_w 545
    //   1591: areturn
    //   1592: astore_1
    //   1593: iconst_0
    //   1594: istore 7
    //   1596: goto -37 -> 1559
    //   1599: ldc_w 1222
    //   1602: aconst_null
    //   1603: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1606: astore_1
    //   1607: goto -35 -> 1572
    //   1610: ldc_w 1243
    //   1613: aload_1
    //   1614: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1617: ifeq +190 -> 1807
    //   1620: ldc 150
    //   1622: iconst_2
    //   1623: iconst_2
    //   1624: anewarray 904	java/lang/Object
    //   1627: dup
    //   1628: iconst_0
    //   1629: ldc_w 1244
    //   1632: aastore
    //   1633: dup
    //   1634: iconst_1
    //   1635: aload_2
    //   1636: aastore
    //   1637: invokestatic 1247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1640: new 371	org/json/JSONObject
    //   1643: dup
    //   1644: aload_2
    //   1645: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1648: astore_2
    //   1649: aload_2
    //   1650: ldc_w 499
    //   1653: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1656: astore 20
    //   1658: aload 20
    //   1660: ldc_w 1249
    //   1663: ldc_w 545
    //   1666: invokevirtual 1251	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1669: astore 21
    //   1671: aload 20
    //   1673: ldc_w 1253
    //   1676: iconst_1
    //   1677: invokevirtual 1256	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1680: pop
    //   1681: ldc_w 1258
    //   1684: aload 21
    //   1686: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1689: ifeq +49 -> 1738
    //   1692: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1695: aload_0
    //   1696: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1699: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1702: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1705: new 1260	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2
    //   1708: dup
    //   1709: aload_0
    //   1710: aload_3
    //   1711: aload_1
    //   1712: iload 4
    //   1714: aload_2
    //   1715: invokespecial 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILorg/json/JSONObject;)V
    //   1718: invokevirtual 1265	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getPhoneNumber	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1721: goto -133 -> 1588
    //   1724: astore_1
    //   1725: ldc 150
    //   1727: iconst_2
    //   1728: ldc_w 1244
    //   1731: aload_1
    //   1732: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1735: goto -147 -> 1588
    //   1738: ldc 150
    //   1740: iconst_1
    //   1741: new 419	java/lang/StringBuilder
    //   1744: dup
    //   1745: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   1748: ldc_w 1267
    //   1751: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1754: aload 21
    //   1756: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: ldc_w 1269
    //   1762: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1765: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1768: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1771: aload_0
    //   1772: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1775: aload_3
    //   1776: aload_1
    //   1777: aconst_null
    //   1778: new 419	java/lang/StringBuilder
    //   1781: dup
    //   1782: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   1785: aload 21
    //   1787: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: ldc_w 1269
    //   1793: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1799: iload 4
    //   1801: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   1804: goto -216 -> 1588
    //   1807: ldc 50
    //   1809: aload_1
    //   1810: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1813: ifeq +86 -> 1899
    //   1816: ldc 150
    //   1818: iconst_2
    //   1819: new 419	java/lang/StringBuilder
    //   1822: dup
    //   1823: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   1826: ldc_w 1271
    //   1829: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: iload 4
    //   1834: invokevirtual 771	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1837: ldc_w 1273
    //   1840: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: aload_0
    //   1844: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1847: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1850: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1853: getfield 1206	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1856: getfield 1276	com/tencent/mobileqq/mini/apkg/AppConfigInfo:PackageToolVersion	Ljava/lang/String;
    //   1859: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1865: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1868: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1871: aload_0
    //   1872: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1875: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1878: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1881: new 1278	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3
    //   1884: dup
    //   1885: aload_0
    //   1886: aload_3
    //   1887: aload_1
    //   1888: iload 4
    //   1890: invokespecial 1279	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1893: invokevirtual 684	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getLoginCode	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1896: goto -308 -> 1588
    //   1899: ldc_w 1281
    //   1902: aload_1
    //   1903: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1906: ifeq +1007 -> 2913
    //   1909: new 371	org/json/JSONObject
    //   1912: dup
    //   1913: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   1916: pop
    //   1917: new 371	org/json/JSONObject
    //   1920: dup
    //   1921: aload_2
    //   1922: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1925: astore 20
    //   1927: aload 20
    //   1929: ldc_w 499
    //   1932: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1935: astore_2
    //   1936: aload_2
    //   1937: ldc_w 1249
    //   1940: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1943: astore 21
    //   1945: ldc 150
    //   1947: iconst_2
    //   1948: new 419	java/lang/StringBuilder
    //   1951: dup
    //   1952: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   1955: ldc_w 1283
    //   1958: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1961: aload 21
    //   1963: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1972: ldc_w 1285
    //   1975: aload 21
    //   1977: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1980: ifne +14 -> 1994
    //   1983: ldc_w 1287
    //   1986: aload 21
    //   1988: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1991: ifeq +98 -> 2089
    //   1994: aload_2
    //   1995: ldc_w 1253
    //   1998: invokevirtual 656	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   2001: istore 15
    //   2003: aload_2
    //   2004: ldc_w 658
    //   2007: aconst_null
    //   2008: invokevirtual 1251	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2011: astore 20
    //   2013: aload_2
    //   2014: ldc_w 499
    //   2017: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2020: astore_2
    //   2021: aload_2
    //   2022: ifnull +49 -> 2071
    //   2025: aload_2
    //   2026: ldc_w 658
    //   2029: ldc_w 1289
    //   2032: invokevirtual 1251	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2035: astore_2
    //   2036: aload_0
    //   2037: aload_3
    //   2038: aload_1
    //   2039: aload 21
    //   2041: iload 4
    //   2043: iload 15
    //   2045: aload_2
    //   2046: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getUserInfo	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V
    //   2049: goto -461 -> 1588
    //   2052: astore_1
    //   2053: ldc 150
    //   2055: iconst_1
    //   2056: aload_1
    //   2057: iconst_0
    //   2058: anewarray 904	java/lang/Object
    //   2061: invokestatic 1294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2064: aload_1
    //   2065: invokevirtual 668	java/lang/Exception:printStackTrace	()V
    //   2068: goto -480 -> 1588
    //   2071: aload 20
    //   2073: astore_2
    //   2074: aload 20
    //   2076: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2079: ifeq -43 -> 2036
    //   2082: ldc_w 1289
    //   2085: astore_2
    //   2086: goto -50 -> 2036
    //   2089: ldc_w 1296
    //   2092: aload 21
    //   2094: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2097: ifeq +15 -> 2112
    //   2100: aload_0
    //   2101: aload_2
    //   2102: aload_3
    //   2103: aload_1
    //   2104: iload 4
    //   2106: invokespecial 1298	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleWebapiPluginSetauth	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2109: goto -521 -> 1588
    //   2112: ldc_w 1300
    //   2115: aload 21
    //   2117: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2120: ifeq +15 -> 2135
    //   2123: aload_0
    //   2124: aload_2
    //   2125: aload_3
    //   2126: aload_1
    //   2127: iload 4
    //   2129: invokespecial 1302	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleWebapiPluginLogin	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2132: goto -544 -> 1588
    //   2135: ldc_w 1304
    //   2138: aload 21
    //   2140: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2143: ifeq +17 -> 2160
    //   2146: aload_0
    //   2147: aload_2
    //   2148: aload_3
    //   2149: aload_1
    //   2150: iload 4
    //   2152: aload 21
    //   2154: invokespecial 1306	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleWebapiPluginGetuserinfo	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILjava/lang/String;)V
    //   2157: goto -569 -> 1588
    //   2160: ldc_w 1308
    //   2163: aload 21
    //   2165: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2168: ifeq +47 -> 2215
    //   2171: new 1310	Wallet/IsUinFocusMpIdReq
    //   2174: dup
    //   2175: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2178: invokevirtual 1159	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   2181: invokevirtual 1315	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   2184: aload_0
    //   2185: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2188: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2191: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2194: invokespecial 1317	Wallet/IsUinFocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   2197: new 1319	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4
    //   2200: dup
    //   2201: aload_0
    //   2202: aload_3
    //   2203: aload_1
    //   2204: iload 4
    //   2206: invokespecial 1320	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2209: invokestatic 1325	akxq:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   2212: goto -624 -> 1588
    //   2215: ldc_w 1327
    //   2218: aload 21
    //   2220: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2223: ifeq +141 -> 2364
    //   2226: aload 20
    //   2228: ldc_w 1329
    //   2231: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2234: ldc_w 1331
    //   2237: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2240: astore_2
    //   2241: ldc 112
    //   2243: aload_0
    //   2244: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2247: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2250: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2253: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2256: ifeq +75 -> 2331
    //   2259: ldc 150
    //   2261: iconst_1
    //   2262: ldc_w 1333
    //   2265: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2268: new 371	org/json/JSONObject
    //   2271: dup
    //   2272: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   2275: astore_2
    //   2276: new 371	org/json/JSONObject
    //   2279: dup
    //   2280: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   2283: astore 20
    //   2285: aload 20
    //   2287: ldc_w 499
    //   2290: ldc 156
    //   2292: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2295: pop
    //   2296: aload_2
    //   2297: ldc_w 1335
    //   2300: aload 20
    //   2302: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2305: pop
    //   2306: aload_0
    //   2307: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2310: aload_3
    //   2311: aload_1
    //   2312: aload_2
    //   2313: iload 4
    //   2315: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2318: goto -730 -> 1588
    //   2321: astore 20
    //   2323: aload 20
    //   2325: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   2328: goto -22 -> 2306
    //   2331: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2334: aload_0
    //   2335: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2338: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2341: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2344: aload_2
    //   2345: aconst_null
    //   2346: new 1338	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5
    //   2349: dup
    //   2350: aload_0
    //   2351: aload_3
    //   2352: aload_1
    //   2353: iload 4
    //   2355: invokespecial 1339	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2358: invokevirtual 1342	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkNavigateRight	(Ljava/lang/String;Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2361: goto -773 -> 1588
    //   2364: ldc_w 1344
    //   2367: aload 21
    //   2369: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2372: ifeq +402 -> 2774
    //   2375: aload_2
    //   2376: ldc_w 499
    //   2379: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2382: ldc_w 505
    //   2385: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2388: astore 26
    //   2390: iconst_2
    //   2391: istore 7
    //   2393: aload_2
    //   2394: ldc_w 499
    //   2397: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2400: ldc_w 510
    //   2403: invokevirtual 514	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2406: ifeq +18 -> 2424
    //   2409: aload_2
    //   2410: ldc_w 499
    //   2413: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2416: ldc_w 510
    //   2419: invokevirtual 518	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2422: istore 7
    //   2424: aload_0
    //   2425: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2428: getfield 278	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2431: invokevirtual 525	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   2434: invokestatic 528	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   2437: invokevirtual 532	java/lang/Long:longValue	()J
    //   2440: lstore 18
    //   2442: aconst_null
    //   2443: astore_2
    //   2444: aload_0
    //   2445: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2448: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2451: ifnull +14 -> 2465
    //   2454: aload_0
    //   2455: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2458: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2461: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2464: astore_2
    //   2465: ldc 150
    //   2467: iconst_2
    //   2468: new 419	java/lang/StringBuilder
    //   2471: dup
    //   2472: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   2475: ldc_w 1346
    //   2478: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2481: aload_2
    //   2482: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2485: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2488: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2491: aload_2
    //   2492: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2495: ifne -907 -> 1588
    //   2498: iload 7
    //   2500: invokestatic 543	com/tencent/mobileqq/mini/util/AdUtils:getSpAdGdtCookie	(I)Ljava/lang/String;
    //   2503: astore 27
    //   2505: aload_0
    //   2506: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2509: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2512: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   2515: astore 28
    //   2517: ldc_w 545
    //   2520: astore 21
    //   2522: ldc_w 545
    //   2525: astore 23
    //   2527: ldc_w 545
    //   2530: astore 25
    //   2532: ldc_w 545
    //   2535: astore 24
    //   2537: aload 21
    //   2539: astore 20
    //   2541: aload 28
    //   2543: ifnull +61 -> 2604
    //   2546: aload 21
    //   2548: astore 20
    //   2550: aload 28
    //   2552: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2555: ifnull +49 -> 2604
    //   2558: aload 21
    //   2560: astore 20
    //   2562: aload 28
    //   2564: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2567: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2570: ifnull +34 -> 2604
    //   2573: aload 21
    //   2575: astore 20
    //   2577: aload 28
    //   2579: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2582: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2585: getfield 554	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2588: ifnull +16 -> 2604
    //   2591: aload 28
    //   2593: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2596: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2599: getfield 554	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2602: astore 20
    //   2604: aload 23
    //   2606: astore 22
    //   2608: aload 25
    //   2610: astore 21
    //   2612: aload 28
    //   2614: ifnull +67 -> 2681
    //   2617: aload 23
    //   2619: astore 22
    //   2621: aload 25
    //   2623: astore 21
    //   2625: aload 28
    //   2627: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2630: ifnull +51 -> 2681
    //   2633: aload 23
    //   2635: astore 22
    //   2637: aload 25
    //   2639: astore 21
    //   2641: aload 28
    //   2643: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2646: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2649: ifnull +32 -> 2681
    //   2652: aload 28
    //   2654: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2657: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2660: getfield 557	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/lang/String;
    //   2663: astore 22
    //   2665: aload 28
    //   2667: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2670: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2673: getfield 560	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   2676: invokestatic 562	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2679: astore 21
    //   2681: aload 24
    //   2683: astore 23
    //   2685: aload 28
    //   2687: ifnull +43 -> 2730
    //   2690: aload 24
    //   2692: astore 23
    //   2694: aload 28
    //   2696: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2699: ifnull +31 -> 2730
    //   2702: aload 24
    //   2704: astore 23
    //   2706: aload 28
    //   2708: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2711: getfield 303	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2714: ifnull +16 -> 2730
    //   2717: aload 28
    //   2719: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2722: getfield 303	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2725: getfield 565	com/tencent/mobileqq/mini/apkg/MiniAppInfo:via	Ljava/lang/String;
    //   2728: astore 23
    //   2730: aload_0
    //   2731: aload_0
    //   2732: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2735: getfield 278	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2738: lload 18
    //   2740: aload 26
    //   2742: aload_2
    //   2743: bipush 53
    //   2745: iload 7
    //   2747: iconst_0
    //   2748: aload 27
    //   2750: aload 20
    //   2752: aload 22
    //   2754: aload 21
    //   2756: aload 23
    //   2758: iconst_1
    //   2759: invokestatic 569	com/tencent/mobileqq/mini/util/AdUtils:createAdRequest	(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LNS_MINI_AD/MiniAppAd$StGetAdReq;
    //   2762: aload_3
    //   2763: aload_1
    //   2764: iload 4
    //   2766: iload 7
    //   2768: invokespecial 573	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:sendAdRequest	(LNS_MINI_AD/MiniAppAd$StGetAdReq;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;II)V
    //   2771: goto -1183 -> 1588
    //   2774: ldc_w 1348
    //   2777: aload 21
    //   2779: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2782: ifeq +17 -> 2799
    //   2785: aload_0
    //   2786: aload_2
    //   2787: aload_3
    //   2788: aload_1
    //   2789: iload 4
    //   2791: bipush 12
    //   2793: invokespecial 1350	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleAdApi	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;II)V
    //   2796: goto -1208 -> 1588
    //   2799: ldc_w 1352
    //   2802: aload 21
    //   2804: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2807: ifeq +63 -> 2870
    //   2810: aload_2
    //   2811: ldc_w 499
    //   2814: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2817: ldc_w 1354
    //   2820: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2823: astore 20
    //   2825: aload_2
    //   2826: ldc_w 499
    //   2829: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2832: ldc_w 1356
    //   2835: iconst_0
    //   2836: invokevirtual 1359	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2839: istore 8
    //   2841: iload 8
    //   2843: istore 7
    //   2845: iload 8
    //   2847: ifgt +8 -> 2855
    //   2850: sipush 30000
    //   2853: istore 7
    //   2855: aload_0
    //   2856: aload 20
    //   2858: iload 7
    //   2860: aload_3
    //   2861: aload_1
    //   2862: iload 4
    //   2864: invokespecial 1361	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2867: goto -1279 -> 1588
    //   2870: ldc_w 1363
    //   2873: aload 21
    //   2875: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2878: ifeq -1290 -> 1588
    //   2881: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2884: aload_0
    //   2885: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2888: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2891: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2894: aconst_null
    //   2895: new 1365	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6
    //   2898: dup
    //   2899: aload_0
    //   2900: aload_3
    //   2901: aload_1
    //   2902: iload 4
    //   2904: invokespecial 1366	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2907: invokevirtual 1370	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserHealthData	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2910: goto -1322 -> 1588
    //   2913: ldc 59
    //   2915: aload_1
    //   2916: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2919: ifeq +34 -> 2953
    //   2922: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2925: aload_0
    //   2926: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2929: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2932: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2935: new 1372	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7
    //   2938: dup
    //   2939: aload_0
    //   2940: aload_3
    //   2941: aload_1
    //   2942: iload 4
    //   2944: invokespecial 1373	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2947: invokevirtual 1376	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkSession	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2950: goto -1362 -> 1588
    //   2953: ldc 86
    //   2955: aload_1
    //   2956: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2959: ifne +12 -> 2971
    //   2962: ldc 89
    //   2964: aload_1
    //   2965: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2968: ifeq +771 -> 3739
    //   2971: aload_0
    //   2972: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2975: ifnull +752 -> 3727
    //   2978: aload_0
    //   2979: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2982: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2985: ifnull +688 -> 3673
    //   2988: iconst_m1
    //   2989: istore 9
    //   2991: aload_2
    //   2992: ifnull +23 -> 3015
    //   2995: ldc_w 1378
    //   2998: aload_2
    //   2999: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3002: ifne +13 -> 3015
    //   3005: ldc_w 1380
    //   3008: aload_2
    //   3009: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3012: ifeq +103 -> 3115
    //   3015: iconst_0
    //   3016: istore 15
    //   3018: iconst_1
    //   3019: istore 13
    //   3021: iconst_1
    //   3022: istore 12
    //   3024: iconst_1
    //   3025: istore 9
    //   3027: iconst_1
    //   3028: istore 7
    //   3030: aload_0
    //   3031: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3034: ifeq +412 -> 3446
    //   3037: aload_0
    //   3038: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3041: astore_2
    //   3042: aload_2
    //   3043: ifnull +384 -> 3427
    //   3046: iload 13
    //   3048: iconst_1
    //   3049: if_icmpne +346 -> 3395
    //   3052: aload_2
    //   3053: iconst_1
    //   3054: putfield 1392	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3057: iload 12
    //   3059: iconst_1
    //   3060: if_icmpne +343 -> 3403
    //   3063: aload_2
    //   3064: iconst_1
    //   3065: putfield 1395	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3068: iload 9
    //   3070: iconst_1
    //   3071: if_icmpne +340 -> 3411
    //   3074: aload_2
    //   3075: iconst_1
    //   3076: putfield 1398	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3079: iload 7
    //   3081: iconst_1
    //   3082: if_icmpne +337 -> 3419
    //   3085: aload_2
    //   3086: iconst_1
    //   3087: putfield 1401	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3090: aload_2
    //   3091: iload 15
    //   3093: putfield 1404	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3096: aload_0
    //   3097: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3100: aload_3
    //   3101: aload_1
    //   3102: aload_1
    //   3103: aconst_null
    //   3104: invokestatic 1174	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3107: iload 4
    //   3109: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3112: goto -1524 -> 1588
    //   3115: new 371	org/json/JSONObject
    //   3118: dup
    //   3119: aload_2
    //   3120: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3123: astore_2
    //   3124: aload_2
    //   3125: ldc_w 1405
    //   3128: iconst_0
    //   3129: invokevirtual 1256	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3132: istore 16
    //   3134: aload_2
    //   3135: ldc_w 1407
    //   3138: invokevirtual 1410	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   3141: checkcast 382	org/json/JSONArray
    //   3144: astore_2
    //   3145: aload_2
    //   3146: ifnonnull +7200 -> 10346
    //   3149: iconst_1
    //   3150: istore 13
    //   3152: iconst_1
    //   3153: istore 12
    //   3155: iconst_1
    //   3156: istore 9
    //   3158: iconst_1
    //   3159: istore 7
    //   3161: iload 16
    //   3163: istore 15
    //   3165: goto -135 -> 3030
    //   3168: iload 10
    //   3170: aload_2
    //   3171: invokevirtual 1413	org/json/JSONArray:length	()I
    //   3174: if_icmpge +76 -> 3250
    //   3177: aload_2
    //   3178: iload 10
    //   3180: invokevirtual 1415	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   3183: astore 20
    //   3185: aload 20
    //   3187: ldc 124
    //   3189: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3192: ifeq +6 -> 3198
    //   3195: iconst_1
    //   3196: istore 11
    //   3198: aload 20
    //   3200: ldc 127
    //   3202: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3205: ifeq +6 -> 3211
    //   3208: iconst_1
    //   3209: istore 7
    //   3211: aload 20
    //   3213: ldc 130
    //   3215: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3218: ifeq +6 -> 3224
    //   3221: iconst_1
    //   3222: istore 9
    //   3224: aload 20
    //   3226: ldc 133
    //   3228: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3231: istore 15
    //   3233: iload 15
    //   3235: ifeq +6 -> 3241
    //   3238: iconst_1
    //   3239: istore 8
    //   3241: iload 10
    //   3243: iconst_1
    //   3244: iadd
    //   3245: istore 10
    //   3247: goto -79 -> 3168
    //   3250: iload 11
    //   3252: istore 10
    //   3254: iload 11
    //   3256: iconst_m1
    //   3257: if_icmpne +6 -> 3263
    //   3260: iconst_0
    //   3261: istore 10
    //   3263: iload 7
    //   3265: istore 11
    //   3267: iload 7
    //   3269: iconst_m1
    //   3270: if_icmpne +6 -> 3276
    //   3273: iconst_0
    //   3274: istore 11
    //   3276: iload 9
    //   3278: iconst_m1
    //   3279: if_icmpne +7046 -> 10325
    //   3282: iconst_0
    //   3283: istore 14
    //   3285: iload 14
    //   3287: istore 9
    //   3289: iload 8
    //   3291: istore 7
    //   3293: iload 11
    //   3295: istore 12
    //   3297: iload 10
    //   3299: istore 13
    //   3301: iload 16
    //   3303: istore 15
    //   3305: iload 8
    //   3307: iconst_m1
    //   3308: if_icmpne -278 -> 3030
    //   3311: iconst_0
    //   3312: istore 7
    //   3314: iload 14
    //   3316: istore 9
    //   3318: iload 11
    //   3320: istore 12
    //   3322: iload 10
    //   3324: istore 13
    //   3326: iload 16
    //   3328: istore 15
    //   3330: goto -300 -> 3030
    //   3333: astore_2
    //   3334: aload_2
    //   3335: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   3338: ldc 150
    //   3340: iconst_1
    //   3341: aload_2
    //   3342: iconst_0
    //   3343: anewarray 904	java/lang/Object
    //   3346: invokestatic 1294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3349: aload_0
    //   3350: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3353: ifeq +23 -> 3376
    //   3356: aload_0
    //   3357: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3360: aload_3
    //   3361: aload_1
    //   3362: aload_1
    //   3363: aconst_null
    //   3364: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3367: iload 4
    //   3369: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3372: ldc_w 545
    //   3375: areturn
    //   3376: aload_0
    //   3377: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3380: aload_3
    //   3381: aload_1
    //   3382: aload_1
    //   3383: aconst_null
    //   3384: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3387: iload 4
    //   3389: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3392: goto -20 -> 3372
    //   3395: aload_2
    //   3396: iconst_0
    //   3397: putfield 1392	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3400: goto -343 -> 3057
    //   3403: aload_2
    //   3404: iconst_0
    //   3405: putfield 1395	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3408: goto -340 -> 3068
    //   3411: aload_2
    //   3412: iconst_0
    //   3413: putfield 1398	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3416: goto -337 -> 3079
    //   3419: aload_2
    //   3420: iconst_0
    //   3421: putfield 1401	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3424: goto -334 -> 3090
    //   3427: aload_0
    //   3428: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3431: aload_3
    //   3432: aload_1
    //   3433: aload_1
    //   3434: aconst_null
    //   3435: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3438: iload 4
    //   3440: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3443: goto -1855 -> 1588
    //   3446: aload_0
    //   3447: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3450: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3453: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3456: ifnull +198 -> 3654
    //   3459: aload_0
    //   3460: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3463: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3466: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3469: ifnull +185 -> 3654
    //   3472: iload 13
    //   3474: iconst_1
    //   3475: if_icmpne +111 -> 3586
    //   3478: aload_0
    //   3479: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3482: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3485: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3488: iconst_1
    //   3489: putfield 1426	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3492: iload 12
    //   3494: iconst_1
    //   3495: if_icmpne +108 -> 3603
    //   3498: aload_0
    //   3499: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3502: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3505: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3508: iconst_1
    //   3509: putfield 1427	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3512: iload 9
    //   3514: iconst_1
    //   3515: if_icmpne +105 -> 3620
    //   3518: aload_0
    //   3519: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3522: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3525: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3528: iconst_1
    //   3529: putfield 1428	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3532: iload 7
    //   3534: iconst_1
    //   3535: if_icmpne +102 -> 3637
    //   3538: aload_0
    //   3539: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3542: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3545: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3548: iconst_1
    //   3549: putfield 1429	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3552: aload_0
    //   3553: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3556: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3559: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3562: iload 15
    //   3564: putfield 1430	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3567: aload_0
    //   3568: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3571: aload_3
    //   3572: aload_1
    //   3573: aload_1
    //   3574: aconst_null
    //   3575: invokestatic 1174	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3578: iload 4
    //   3580: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3583: goto -1995 -> 1588
    //   3586: aload_0
    //   3587: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3590: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3593: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3596: iconst_0
    //   3597: putfield 1426	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3600: goto -108 -> 3492
    //   3603: aload_0
    //   3604: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3607: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3610: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3613: iconst_0
    //   3614: putfield 1427	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3617: goto -105 -> 3512
    //   3620: aload_0
    //   3621: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3624: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3627: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3630: iconst_0
    //   3631: putfield 1428	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3634: goto -102 -> 3532
    //   3637: aload_0
    //   3638: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3641: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3644: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3647: iconst_0
    //   3648: putfield 1429	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3651: goto -99 -> 3552
    //   3654: aload_0
    //   3655: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3658: aload_3
    //   3659: aload_1
    //   3660: aload_1
    //   3661: aconst_null
    //   3662: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3665: iload 4
    //   3667: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3670: goto -2082 -> 1588
    //   3673: ldc 150
    //   3675: iconst_1
    //   3676: ldc_w 1432
    //   3679: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3682: aload_0
    //   3683: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3686: ifeq +22 -> 3708
    //   3689: aload_0
    //   3690: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3693: aload_3
    //   3694: aload_1
    //   3695: aload_1
    //   3696: aconst_null
    //   3697: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3700: iload 4
    //   3702: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3705: goto -2117 -> 1588
    //   3708: aload_0
    //   3709: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3712: aload_3
    //   3713: aload_1
    //   3714: aload_1
    //   3715: aconst_null
    //   3716: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3719: iload 4
    //   3721: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3724: goto -2136 -> 1588
    //   3727: ldc 150
    //   3729: iconst_1
    //   3730: ldc_w 1434
    //   3733: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3736: goto -2148 -> 1588
    //   3739: ldc 92
    //   3741: aload_1
    //   3742: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3745: ifeq +220 -> 3965
    //   3748: new 371	org/json/JSONObject
    //   3751: dup
    //   3752: aload_2
    //   3753: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3756: astore_2
    //   3757: aload_2
    //   3758: ldc_w 1405
    //   3761: iconst_0
    //   3762: invokevirtual 1256	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3765: istore 15
    //   3767: aload_2
    //   3768: ldc_w 1436
    //   3771: invokevirtual 656	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   3774: pop
    //   3775: aload_2
    //   3776: ldc_w 1438
    //   3779: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3782: pop
    //   3783: aload_2
    //   3784: ldc_w 1440
    //   3787: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3790: pop
    //   3791: aload_0
    //   3792: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3795: ifeq +91 -> 3886
    //   3798: aload_0
    //   3799: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3802: astore_2
    //   3803: aload_2
    //   3804: ifnull +63 -> 3867
    //   3807: aload_2
    //   3808: iload 15
    //   3810: putfield 1404	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3813: aload_0
    //   3814: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3817: aload_3
    //   3818: aload_1
    //   3819: aload_1
    //   3820: aconst_null
    //   3821: invokestatic 1174	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3824: iload 4
    //   3826: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3829: aload_0
    //   3830: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3833: aload_3
    //   3834: aload_1
    //   3835: aload_1
    //   3836: aconst_null
    //   3837: invokestatic 1174	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3840: iload 4
    //   3842: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3845: goto -2257 -> 1588
    //   3848: astore_1
    //   3849: ldc 150
    //   3851: iconst_1
    //   3852: aload_1
    //   3853: iconst_0
    //   3854: anewarray 904	java/lang/Object
    //   3857: invokestatic 1294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3860: aload_1
    //   3861: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   3864: goto -2276 -> 1588
    //   3867: aload_0
    //   3868: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3871: aload_3
    //   3872: aload_1
    //   3873: aload_1
    //   3874: aconst_null
    //   3875: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3878: iload 4
    //   3880: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3883: goto -54 -> 3829
    //   3886: aload_0
    //   3887: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3890: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3893: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3896: ifnull +50 -> 3946
    //   3899: aload_0
    //   3900: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3903: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3906: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3909: ifnull +37 -> 3946
    //   3912: aload_0
    //   3913: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3916: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3919: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3922: iload 15
    //   3924: putfield 1430	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3927: aload_0
    //   3928: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3931: aload_3
    //   3932: aload_1
    //   3933: aload_1
    //   3934: aconst_null
    //   3935: invokestatic 1174	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3938: iload 4
    //   3940: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3943: goto -114 -> 3829
    //   3946: aload_0
    //   3947: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3950: aload_3
    //   3951: aload_1
    //   3952: aload_1
    //   3953: aconst_null
    //   3954: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3957: iload 4
    //   3959: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3962: goto -133 -> 3829
    //   3965: ldc 32
    //   3967: aload_1
    //   3968: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3971: ifeq +79 -> 4050
    //   3974: new 371	org/json/JSONObject
    //   3977: dup
    //   3978: aload_2
    //   3979: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3982: astore_2
    //   3983: aload_2
    //   3984: ldc_w 1354
    //   3987: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3990: astore 20
    //   3992: aload_2
    //   3993: ldc_w 1356
    //   3996: iconst_0
    //   3997: invokevirtual 1359	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4000: istore 8
    //   4002: iload 8
    //   4004: istore 7
    //   4006: iload 8
    //   4008: ifgt +8 -> 4016
    //   4011: sipush 30000
    //   4014: istore 7
    //   4016: aload_0
    //   4017: aload 20
    //   4019: iload 7
    //   4021: aload_3
    //   4022: aload_1
    //   4023: iload 4
    //   4025: invokespecial 1361	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   4028: goto -2440 -> 1588
    //   4031: astore_1
    //   4032: ldc 150
    //   4034: iconst_1
    //   4035: aload_1
    //   4036: iconst_0
    //   4037: anewarray 904	java/lang/Object
    //   4040: invokestatic 1294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4043: aload_1
    //   4044: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   4047: goto -2459 -> 1588
    //   4050: ldc 68
    //   4052: aload_1
    //   4053: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4056: ifne +21 -> 4077
    //   4059: ldc 65
    //   4061: aload_1
    //   4062: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4065: ifne +12 -> 4077
    //   4068: ldc 71
    //   4070: aload_1
    //   4071: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4074: ifeq +1379 -> 5453
    //   4077: iconst_0
    //   4078: istore 15
    //   4080: ldc 68
    //   4082: aload_1
    //   4083: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4086: ifeq +6 -> 4092
    //   4089: iconst_1
    //   4090: istore 15
    //   4092: new 371	org/json/JSONObject
    //   4095: dup
    //   4096: aload_2
    //   4097: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4100: astore 23
    //   4102: aload 23
    //   4104: ldc_w 1442
    //   4107: iconst_m1
    //   4108: invokevirtual 1359	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4111: istore 9
    //   4113: iconst_m1
    //   4114: istore 7
    //   4116: aconst_null
    //   4117: astore 22
    //   4119: iload 9
    //   4121: ifne +6260 -> 10381
    //   4124: iconst_0
    //   4125: istore 7
    //   4127: aconst_null
    //   4128: astore_2
    //   4129: aload 23
    //   4131: ldc_w 1444
    //   4134: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4137: astore 25
    //   4139: aload 23
    //   4141: ldc_w 1446
    //   4144: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4147: astore 26
    //   4149: ldc 68
    //   4151: aload_1
    //   4152: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4155: ifne +6206 -> 10361
    //   4158: ldc 71
    //   4160: aload_1
    //   4161: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4164: ifeq +29 -> 4193
    //   4167: goto +6194 -> 10361
    //   4170: aload_0
    //   4171: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4174: ifeq +518 -> 4692
    //   4177: aload_0
    //   4178: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4181: ifnull +511 -> 4692
    //   4184: aload_0
    //   4185: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4188: iload 8
    //   4190: putfield 1449	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4193: aload_0
    //   4194: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4197: ifeq +532 -> 4729
    //   4200: aload_0
    //   4201: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4204: ifnull +525 -> 4729
    //   4207: aload_0
    //   4208: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4211: aload_1
    //   4212: putfield 1452	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   4215: aload_0
    //   4216: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4219: iload 4
    //   4221: putfield 1455	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   4224: aload_0
    //   4225: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4228: aload_3
    //   4229: putfield 1459	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   4232: aload 23
    //   4234: ldc_w 1461
    //   4237: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4240: astore 20
    //   4242: aload 20
    //   4244: astore 21
    //   4246: aload 20
    //   4248: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4251: ifeq +13 -> 4264
    //   4254: aload 23
    //   4256: ldc_w 1463
    //   4259: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4262: astore 21
    //   4264: aload 23
    //   4266: ldc_w 1465
    //   4269: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4272: astore 24
    //   4274: aload 23
    //   4276: ldc_w 1467
    //   4279: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4282: astore 27
    //   4284: aload 23
    //   4286: ldc_w 1469
    //   4289: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4292: astore 23
    //   4294: aload 21
    //   4296: astore 20
    //   4298: aload 21
    //   4300: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4303: ifeq +15 -> 4318
    //   4306: aload_0
    //   4307: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4310: ifeq +451 -> 4761
    //   4313: ldc_w 1471
    //   4316: astore 20
    //   4318: new 1473	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8
    //   4321: dup
    //   4322: aload_0
    //   4323: aload_3
    //   4324: aload_1
    //   4325: iload 4
    //   4327: invokespecial 1474	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   4330: astore_1
    //   4331: aload_0
    //   4332: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4335: ifeq +21 -> 4356
    //   4338: aload_0
    //   4339: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4342: ifnull +14 -> 4356
    //   4345: aload_0
    //   4346: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4349: getfield 1449	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4352: iconst_1
    //   4353: if_icmpeq +27 -> 4380
    //   4356: aload_0
    //   4357: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4360: ifne +506 -> 4866
    //   4363: aload_0
    //   4364: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4367: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4370: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4373: getfield 1475	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4376: iconst_1
    //   4377: if_icmpne +489 -> 4866
    //   4380: aload 27
    //   4382: ldc_w 1477
    //   4385: invokevirtual 1480	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4388: ifne +14 -> 4402
    //   4391: aload 27
    //   4393: ldc_w 1482
    //   4396: invokevirtual 1480	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4399: ifeq +383 -> 4782
    //   4402: aload_0
    //   4403: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4406: invokevirtual 579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4409: aload 24
    //   4411: aload 27
    //   4413: aload 20
    //   4415: aload_0
    //   4416: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4419: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4422: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4425: iload 15
    //   4427: invokestatic 1486	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4430: goto +5947 -> 10377
    //   4433: iload 9
    //   4435: iconst_2
    //   4436: if_icmpne +5959 -> 10395
    //   4439: iconst_0
    //   4440: istore 7
    //   4442: aload 23
    //   4444: ldc_w 1488
    //   4447: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4450: astore_2
    //   4451: aload_2
    //   4452: ifnull +80 -> 4532
    //   4455: aload_0
    //   4456: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4459: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4462: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4465: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4468: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4471: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4474: ifnull +58 -> 4532
    //   4477: aload_2
    //   4478: aload_0
    //   4479: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4482: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4485: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4488: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4491: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4494: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4497: invokevirtual 1497	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   4500: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4503: ifeq +29 -> 4532
    //   4506: aload_0
    //   4507: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4510: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4513: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4516: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4519: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4522: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4525: astore 22
    //   4527: aconst_null
    //   4528: astore_2
    //   4529: goto -400 -> 4129
    //   4532: ldc 150
    //   4534: iconst_1
    //   4535: new 419	java/lang/StringBuilder
    //   4538: dup
    //   4539: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   4542: ldc_w 1499
    //   4545: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4548: aload_2
    //   4549: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4552: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4555: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4558: aconst_null
    //   4559: astore_2
    //   4560: goto -431 -> 4129
    //   4563: iload 9
    //   4565: iconst_5
    //   4566: if_icmpne +102 -> 4668
    //   4569: aload 23
    //   4571: ldc_w 1501
    //   4574: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4577: astore 20
    //   4579: aload_0
    //   4580: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4583: ifeq +37 -> 4620
    //   4586: aload_0
    //   4587: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4590: ifnull +30 -> 4620
    //   4593: aload_0
    //   4594: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4597: getfield 1505	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4600: astore_2
    //   4601: aload_2
    //   4602: ifnull +35 -> 4637
    //   4605: aload_2
    //   4606: invokevirtual 1508	com/tencent/mobileqq/mini/sdk/ShareChatModel:getEntryHash	()Ljava/lang/String;
    //   4609: aload 20
    //   4611: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4614: ifeq +23 -> 4637
    //   4617: goto +5806 -> 10423
    //   4620: aload_0
    //   4621: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4624: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4627: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4630: getfield 1509	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4633: astore_2
    //   4634: goto -33 -> 4601
    //   4637: ldc 150
    //   4639: iconst_1
    //   4640: new 419	java/lang/StringBuilder
    //   4643: dup
    //   4644: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   4647: ldc_w 1499
    //   4650: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4653: aconst_null
    //   4654: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4657: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4660: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4663: aconst_null
    //   4664: astore_2
    //   4665: goto +5758 -> 10423
    //   4668: iload 9
    //   4670: bipush 6
    //   4672: if_icmpne +5648 -> 10320
    //   4675: ldc 71
    //   4677: aload_1
    //   4678: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4681: ifeq +5639 -> 10320
    //   4684: iconst_0
    //   4685: istore 7
    //   4687: aconst_null
    //   4688: astore_2
    //   4689: goto -560 -> 4129
    //   4692: aload_0
    //   4693: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4696: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4699: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4702: iload 8
    //   4704: putfield 1475	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4707: goto -514 -> 4193
    //   4710: astore_1
    //   4711: ldc 150
    //   4713: iconst_1
    //   4714: aload_1
    //   4715: iconst_0
    //   4716: anewarray 904	java/lang/Object
    //   4719: invokestatic 1294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4722: aload_1
    //   4723: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   4726: goto -3138 -> 1588
    //   4729: aload_0
    //   4730: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4733: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4736: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4739: aload_1
    //   4740: putfield 1510	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   4743: aload_0
    //   4744: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4747: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4750: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4753: iload 4
    //   4755: putfield 1511	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   4758: goto -526 -> 4232
    //   4761: aload_0
    //   4762: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4765: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4768: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4771: invokevirtual 1005	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   4774: getfield 1209	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   4777: astore 20
    //   4779: goto -461 -> 4318
    //   4782: aload_0
    //   4783: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4786: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4789: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4792: pop
    //   4793: invokestatic 1516	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   4796: aload 27
    //   4798: invokevirtual 1519	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   4801: astore_1
    //   4802: aload_1
    //   4803: invokestatic 1523	bhsr:a	(Ljava/lang/String;)Z
    //   4806: ifne +33 -> 4839
    //   4809: aload_0
    //   4810: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4813: invokevirtual 579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4816: aload 24
    //   4818: aload_1
    //   4819: aload 20
    //   4821: aload_0
    //   4822: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4825: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4828: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4831: iload 15
    //   4833: invokestatic 1486	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4836: goto +5541 -> 10377
    //   4839: aload_0
    //   4840: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4843: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4846: new 1525	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9
    //   4849: dup
    //   4850: aload_0
    //   4851: aload 24
    //   4853: aload 20
    //   4855: iload 15
    //   4857: invokespecial 1528	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4860: invokevirtual 1532	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   4863: goto +5514 -> 10377
    //   4866: aload_0
    //   4867: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4870: ifeq +21 -> 4891
    //   4873: aload_0
    //   4874: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4877: ifnull +14 -> 4891
    //   4880: aload_0
    //   4881: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4884: getfield 1449	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4887: iconst_3
    //   4888: if_icmpeq +27 -> 4915
    //   4891: aload_0
    //   4892: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4895: ifne +55 -> 4950
    //   4898: aload_0
    //   4899: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4902: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4905: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4908: getfield 1475	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4911: iconst_3
    //   4912: if_icmpne +38 -> 4950
    //   4915: aload_0
    //   4916: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4919: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4922: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4925: astore_1
    //   4926: aload_0
    //   4927: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4930: invokevirtual 579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4933: aload 24
    //   4935: aload_1
    //   4936: getfield 1535	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   4939: aload 20
    //   4941: iconst_3
    //   4942: aload_1
    //   4943: invokestatic 1539	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   4946: ldc_w 545
    //   4949: areturn
    //   4950: aload_0
    //   4951: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4954: ifeq +21 -> 4975
    //   4957: aload_0
    //   4958: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4961: ifnull +14 -> 4975
    //   4964: aload_0
    //   4965: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4968: getfield 1449	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4971: iconst_4
    //   4972: if_icmpeq +27 -> 4999
    //   4975: aload_0
    //   4976: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4979: ifne +55 -> 5034
    //   4982: aload_0
    //   4983: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4986: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4989: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4992: getfield 1475	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4995: iconst_4
    //   4996: if_icmpne +38 -> 5034
    //   4999: aload_0
    //   5000: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5003: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5006: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5009: astore_1
    //   5010: aload_0
    //   5011: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5014: invokevirtual 579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   5017: aload 24
    //   5019: aload_1
    //   5020: getfield 1535	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5023: aload 20
    //   5025: iconst_4
    //   5026: aload_1
    //   5027: invokestatic 1539	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   5030: ldc_w 545
    //   5033: areturn
    //   5034: aload 27
    //   5036: invokestatic 1544	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   5039: ifne +5390 -> 10429
    //   5042: aload 27
    //   5044: invokestatic 1547	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   5047: ifeq +5388 -> 10435
    //   5050: goto +5379 -> 10429
    //   5053: aload_0
    //   5054: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5057: ifnull +5384 -> 10441
    //   5060: aload_0
    //   5061: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5064: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5067: ifnull +5374 -> 10441
    //   5070: aload 27
    //   5072: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5075: ifne +5366 -> 10441
    //   5078: new 1549	java/io/File
    //   5081: dup
    //   5082: invokestatic 1516	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5085: aload 27
    //   5087: invokevirtual 1519	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5090: invokespecial 1550	java/io/File:<init>	(Ljava/lang/String;)V
    //   5093: invokevirtual 1553	java/io/File:exists	()Z
    //   5096: ifeq +5345 -> 10441
    //   5099: iconst_1
    //   5100: istore 17
    //   5102: aload 27
    //   5104: invokestatic 1523	bhsr:a	(Ljava/lang/String;)Z
    //   5107: ifne +13 -> 5120
    //   5110: iload 16
    //   5112: ifne +197 -> 5309
    //   5115: iload 17
    //   5117: ifne +192 -> 5309
    //   5120: aload_0
    //   5121: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5124: ifeq +110 -> 5234
    //   5127: aload_0
    //   5128: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5131: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5134: astore_3
    //   5135: invokestatic 1558	com/tencent/mobileqq/minigame/utils/GameWnsUtils:defaultShareImg	()Ljava/lang/String;
    //   5138: astore 21
    //   5140: iload 15
    //   5142: ifeq +5305 -> 10447
    //   5145: bipush 11
    //   5147: istore 4
    //   5149: aload_3
    //   5150: aload 24
    //   5152: aload 21
    //   5154: aload 20
    //   5156: aload 23
    //   5158: aload 25
    //   5160: aload 26
    //   5162: aload 22
    //   5164: aload_2
    //   5165: iload 4
    //   5167: iload 9
    //   5169: ldc_w 545
    //   5172: aload_1
    //   5173: invokevirtual 1562	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5176: ldc 150
    //   5178: iconst_1
    //   5179: new 419	java/lang/StringBuilder
    //   5182: dup
    //   5183: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   5186: ldc_w 1564
    //   5189: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5192: iload 16
    //   5194: invokevirtual 1054	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5197: ldc_w 1566
    //   5200: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5203: iload 17
    //   5205: invokevirtual 1054	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5208: ldc_w 1568
    //   5211: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5214: aload 27
    //   5216: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5219: ldc_w 1570
    //   5222: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5225: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5228: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5231: goto -3643 -> 1588
    //   5234: aload_0
    //   5235: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5238: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5241: ifnull -3653 -> 1588
    //   5244: aload_0
    //   5245: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5248: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5251: getfield 1573	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5254: ifeq +16 -> 5270
    //   5257: ldc 150
    //   5259: iconst_1
    //   5260: ldc_w 1575
    //   5263: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5266: ldc_w 545
    //   5269: areturn
    //   5270: aload_0
    //   5271: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5274: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5277: new 1577	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10
    //   5280: dup
    //   5281: aload_0
    //   5282: aload 24
    //   5284: aload 20
    //   5286: aload 23
    //   5288: aload 25
    //   5290: aload 26
    //   5292: aload 22
    //   5294: aload_2
    //   5295: iload 15
    //   5297: iload 9
    //   5299: aload_1
    //   5300: invokespecial 1580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;ZILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5303: invokevirtual 1532	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5306: goto -3718 -> 1588
    //   5309: aload 27
    //   5311: ldc_w 1477
    //   5314: invokevirtual 1480	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5317: ifne +14 -> 5331
    //   5320: aload 27
    //   5322: ldc_w 1482
    //   5325: invokevirtual 1480	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5328: ifeq +50 -> 5378
    //   5331: aload_0
    //   5332: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5335: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5338: astore_3
    //   5339: iload 15
    //   5341: ifeq +5113 -> 10454
    //   5344: bipush 11
    //   5346: istore 4
    //   5348: aload_3
    //   5349: aload 24
    //   5351: aload 27
    //   5353: aload 20
    //   5355: aload 23
    //   5357: aload 25
    //   5359: aload 26
    //   5361: aload 22
    //   5363: aload_2
    //   5364: iload 4
    //   5366: iload 9
    //   5368: ldc_w 545
    //   5371: aload_1
    //   5372: invokevirtual 1562	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5375: goto -3787 -> 1588
    //   5378: aload_0
    //   5379: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5382: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5385: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5388: pop
    //   5389: invokestatic 1516	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5392: aload 27
    //   5394: invokevirtual 1519	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5397: astore_3
    //   5398: aload_0
    //   5399: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5402: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5405: astore 21
    //   5407: iload 15
    //   5409: ifeq +37 -> 5446
    //   5412: bipush 11
    //   5414: istore 4
    //   5416: aload 21
    //   5418: aload 24
    //   5420: aload_3
    //   5421: aload 20
    //   5423: aload 23
    //   5425: aload 25
    //   5427: aload 26
    //   5429: aload 22
    //   5431: aload_2
    //   5432: iload 4
    //   5434: iload 9
    //   5436: ldc_w 545
    //   5439: aload_1
    //   5440: invokevirtual 1562	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5443: goto -3855 -> 1588
    //   5446: bipush 12
    //   5448: istore 4
    //   5450: goto -34 -> 5416
    //   5453: ldc 74
    //   5455: aload_1
    //   5456: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5459: ifne +12 -> 5471
    //   5462: ldc 77
    //   5464: aload_1
    //   5465: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5468: ifeq +539 -> 6007
    //   5471: new 371	org/json/JSONObject
    //   5474: dup
    //   5475: aload_2
    //   5476: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5479: astore_2
    //   5480: aload_2
    //   5481: ldc_w 1442
    //   5484: iconst_m1
    //   5485: invokevirtual 1359	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5488: istore 8
    //   5490: iconst_m1
    //   5491: istore 7
    //   5493: iload 8
    //   5495: ifne +250 -> 5745
    //   5498: iconst_0
    //   5499: istore 7
    //   5501: ldc 77
    //   5503: aload_1
    //   5504: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5507: ifeq +39 -> 5546
    //   5510: iload 7
    //   5512: istore 8
    //   5514: iload 7
    //   5516: iconst_m1
    //   5517: if_icmpne +6 -> 5523
    //   5520: iconst_0
    //   5521: istore 8
    //   5523: aload_0
    //   5524: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5527: ifeq +266 -> 5793
    //   5530: aload_0
    //   5531: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5534: ifnull +259 -> 5793
    //   5537: aload_0
    //   5538: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5541: iload 8
    //   5543: putfield 1449	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5546: aload_0
    //   5547: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5550: ifeq +261 -> 5811
    //   5553: aload_0
    //   5554: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5557: ifnull +254 -> 5811
    //   5560: aload_0
    //   5561: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5564: getfield 1449	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5567: istore 7
    //   5569: aload_0
    //   5570: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5573: ifeq +256 -> 5829
    //   5576: aload_0
    //   5577: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5580: ifnull +249 -> 5829
    //   5583: aload_0
    //   5584: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5587: aload_1
    //   5588: putfield 1452	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   5591: aload_0
    //   5592: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5595: iload 4
    //   5597: putfield 1455	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   5600: aload_0
    //   5601: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5604: aload_3
    //   5605: putfield 1459	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   5608: new 1582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11
    //   5611: dup
    //   5612: aload_0
    //   5613: aload_3
    //   5614: aload_1
    //   5615: iload 4
    //   5617: invokespecial 1583	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   5620: astore_1
    //   5621: aload_0
    //   5622: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5625: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5628: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5631: astore_3
    //   5632: aload_2
    //   5633: ldc_w 1465
    //   5636: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5639: astore 20
    //   5641: aload_2
    //   5642: ldc_w 1467
    //   5645: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5648: astore_2
    //   5649: aload_2
    //   5650: invokestatic 1544	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   5653: ifne +4808 -> 10461
    //   5656: aload_2
    //   5657: invokestatic 1547	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   5660: ifeq +4807 -> 10467
    //   5663: goto +4798 -> 10461
    //   5666: invokestatic 1516	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5669: aload_2
    //   5670: invokevirtual 1519	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5673: astore 21
    //   5675: aload_0
    //   5676: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5679: ifnull +4794 -> 10473
    //   5682: aload_0
    //   5683: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5686: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5689: ifnull +4784 -> 10473
    //   5692: aload_2
    //   5693: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5696: ifne +4777 -> 10473
    //   5699: new 1549	java/io/File
    //   5702: dup
    //   5703: aload 21
    //   5705: invokespecial 1550	java/io/File:<init>	(Ljava/lang/String;)V
    //   5708: invokevirtual 1553	java/io/File:exists	()Z
    //   5711: ifeq +4762 -> 10473
    //   5714: iconst_1
    //   5715: istore 8
    //   5717: iload 4
    //   5719: ifeq +142 -> 5861
    //   5722: aload_0
    //   5723: aload 22
    //   5725: aload 20
    //   5727: aload_2
    //   5728: iload 7
    //   5730: aload_1
    //   5731: invokespecial 209	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5734: goto -4146 -> 1588
    //   5737: astore_1
    //   5738: aload_1
    //   5739: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   5742: goto -4154 -> 1588
    //   5745: iload 8
    //   5747: iconst_1
    //   5748: if_icmpne +9 -> 5757
    //   5751: iconst_1
    //   5752: istore 7
    //   5754: goto -253 -> 5501
    //   5757: iload 8
    //   5759: iconst_2
    //   5760: if_icmpne +9 -> 5769
    //   5763: iconst_0
    //   5764: istore 7
    //   5766: goto -265 -> 5501
    //   5769: iload 8
    //   5771: iconst_3
    //   5772: if_icmpne +9 -> 5781
    //   5775: iconst_3
    //   5776: istore 7
    //   5778: goto -277 -> 5501
    //   5781: iload 8
    //   5783: iconst_4
    //   5784: if_icmpne -283 -> 5501
    //   5787: iconst_4
    //   5788: istore 7
    //   5790: goto -289 -> 5501
    //   5793: aload_0
    //   5794: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5797: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5800: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5803: iload 8
    //   5805: putfield 1475	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5808: goto -262 -> 5546
    //   5811: aload_0
    //   5812: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5815: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5818: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5821: getfield 1475	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5824: istore 7
    //   5826: goto -257 -> 5569
    //   5829: aload_0
    //   5830: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5833: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5836: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5839: aload_1
    //   5840: putfield 1510	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   5843: aload_0
    //   5844: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5847: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5850: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5853: iload 4
    //   5855: putfield 1511	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   5858: goto -250 -> 5608
    //   5861: aload_2
    //   5862: invokestatic 1523	bhsr:a	(Ljava/lang/String;)Z
    //   5865: ifne +13 -> 5878
    //   5868: iload 4
    //   5870: ifne +114 -> 5984
    //   5873: iload 8
    //   5875: ifne +109 -> 5984
    //   5878: aload_0
    //   5879: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5882: ifeq +37 -> 5919
    //   5885: aload_3
    //   5886: ifnull +21 -> 5907
    //   5889: aload_0
    //   5890: aload 22
    //   5892: aload 20
    //   5894: aload_3
    //   5895: getfield 1535	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5898: iload 7
    //   5900: aload_1
    //   5901: invokespecial 209	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5904: goto -4316 -> 1588
    //   5907: ldc 150
    //   5909: iconst_1
    //   5910: ldc_w 1585
    //   5913: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5916: goto -4328 -> 1588
    //   5919: aload_0
    //   5920: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5923: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5926: ifnull -4338 -> 1588
    //   5929: aload_0
    //   5930: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5933: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5936: getfield 1573	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5939: ifeq +16 -> 5955
    //   5942: ldc 150
    //   5944: iconst_1
    //   5945: ldc_w 1587
    //   5948: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5951: ldc_w 545
    //   5954: areturn
    //   5955: aload_0
    //   5956: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5959: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5962: new 1589	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12
    //   5965: dup
    //   5966: aload_0
    //   5967: aload_3
    //   5968: aload 22
    //   5970: aload 20
    //   5972: iload 7
    //   5974: aload_1
    //   5975: invokespecial 1592	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Landroid/app/Activity;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5978: invokevirtual 1532	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5981: goto -4393 -> 1588
    //   5984: iload 4
    //   5986: ifne -4398 -> 1588
    //   5989: iload 8
    //   5991: ifeq -4403 -> 1588
    //   5994: aload_0
    //   5995: aload 20
    //   5997: aload 21
    //   5999: iload 7
    //   6001: invokespecial 215	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareLocalPicMessage	(Ljava/lang/String;Ljava/lang/String;I)V
    //   6004: goto -4416 -> 1588
    //   6007: ldc 44
    //   6009: aload_1
    //   6010: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6013: ifeq +383 -> 6396
    //   6016: aload_0
    //   6017: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6020: ifnull -4432 -> 1588
    //   6023: aload_0
    //   6024: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6027: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6030: ifnull -4442 -> 1588
    //   6033: new 371	org/json/JSONObject
    //   6036: dup
    //   6037: aload_2
    //   6038: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6041: ldc_w 1594
    //   6044: invokevirtual 1410	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   6047: checkcast 382	org/json/JSONArray
    //   6050: astore_2
    //   6051: aload_2
    //   6052: ifnonnull +98 -> 6150
    //   6055: iconst_0
    //   6056: istore 10
    //   6058: iconst_0
    //   6059: istore 9
    //   6061: iconst_0
    //   6062: istore 8
    //   6064: iconst_0
    //   6065: istore 7
    //   6067: aload_0
    //   6068: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   6071: ifeq +185 -> 6256
    //   6074: aload_0
    //   6075: invokevirtual 1387	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   6078: astore_2
    //   6079: aload_2
    //   6080: ifnull +157 -> 6237
    //   6083: iload 10
    //   6085: ifne +8 -> 6093
    //   6088: aload_2
    //   6089: iconst_0
    //   6090: putfield 1392	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   6093: iload 9
    //   6095: ifne +8 -> 6103
    //   6098: aload_2
    //   6099: iconst_0
    //   6100: putfield 1395	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   6103: iload 8
    //   6105: ifne +8 -> 6113
    //   6108: aload_2
    //   6109: iconst_0
    //   6110: putfield 1398	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   6113: iload 7
    //   6115: ifne +8 -> 6123
    //   6118: aload_2
    //   6119: iconst_0
    //   6120: putfield 1401	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   6123: aload_0
    //   6124: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6127: aload_3
    //   6128: aload_1
    //   6129: aload_1
    //   6130: aconst_null
    //   6131: invokestatic 1174	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6134: iload 4
    //   6136: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6139: goto -4551 -> 1588
    //   6142: astore_1
    //   6143: aload_1
    //   6144: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   6147: goto -4559 -> 1588
    //   6150: iconst_m1
    //   6151: istore 7
    //   6153: iconst_m1
    //   6154: istore 8
    //   6156: iconst_m1
    //   6157: istore 9
    //   6159: iconst_m1
    //   6160: istore 10
    //   6162: iconst_0
    //   6163: istore 11
    //   6165: iload 11
    //   6167: aload_2
    //   6168: invokevirtual 1413	org/json/JSONArray:length	()I
    //   6171: if_icmpge +4146 -> 10317
    //   6174: aload_2
    //   6175: iload 11
    //   6177: invokevirtual 1415	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6180: astore 20
    //   6182: aload 20
    //   6184: ldc 124
    //   6186: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6189: ifeq +6 -> 6195
    //   6192: iconst_0
    //   6193: istore 10
    //   6195: aload 20
    //   6197: ldc 127
    //   6199: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6202: ifeq +6 -> 6208
    //   6205: iconst_0
    //   6206: istore 9
    //   6208: aload 20
    //   6210: ldc 130
    //   6212: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6215: ifeq +6 -> 6221
    //   6218: iconst_0
    //   6219: istore 8
    //   6221: aload 20
    //   6223: ldc 133
    //   6225: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6228: ifeq +4251 -> 10479
    //   6231: iconst_0
    //   6232: istore 7
    //   6234: goto +4245 -> 10479
    //   6237: aload_0
    //   6238: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6241: aload_3
    //   6242: aload_1
    //   6243: aload_1
    //   6244: aconst_null
    //   6245: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6248: iload 4
    //   6250: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6253: goto -4665 -> 1588
    //   6256: aload_0
    //   6257: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6260: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6263: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   6266: ifnull +111 -> 6377
    //   6269: aload_0
    //   6270: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6273: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6276: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6279: ifnull +98 -> 6377
    //   6282: iload 10
    //   6284: ifne +17 -> 6301
    //   6287: aload_0
    //   6288: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6291: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6294: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6297: iconst_0
    //   6298: putfield 1426	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   6301: iload 9
    //   6303: ifne +17 -> 6320
    //   6306: aload_0
    //   6307: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6310: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6313: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6316: iconst_0
    //   6317: putfield 1427	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   6320: iload 8
    //   6322: ifne +17 -> 6339
    //   6325: aload_0
    //   6326: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6329: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6332: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6335: iconst_0
    //   6336: putfield 1428	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   6339: iload 7
    //   6341: ifne +17 -> 6358
    //   6344: aload_0
    //   6345: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6348: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6351: invokevirtual 1423	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6354: iconst_0
    //   6355: putfield 1429	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   6358: aload_0
    //   6359: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6362: aload_3
    //   6363: aload_1
    //   6364: aload_1
    //   6365: aconst_null
    //   6366: invokestatic 1174	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6369: iload 4
    //   6371: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6374: goto -4786 -> 1588
    //   6377: aload_0
    //   6378: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6381: aload_3
    //   6382: aload_1
    //   6383: aload_1
    //   6384: aconst_null
    //   6385: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6388: iload 4
    //   6390: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6393: goto -4805 -> 1588
    //   6396: ldc_w 1596
    //   6399: aload_1
    //   6400: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6403: ifeq +298 -> 6701
    //   6406: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6409: invokevirtual 1159	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6412: astore 20
    //   6414: aload 20
    //   6416: instanceof 699
    //   6419: ifeq +3892 -> 10311
    //   6422: aload 20
    //   6424: checkcast 699	com/tencent/mobileqq/mini/MiniAppInterface
    //   6427: astore 20
    //   6429: aload 20
    //   6431: ifnonnull +18 -> 6449
    //   6434: aload_0
    //   6435: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6438: aload_3
    //   6439: aload_1
    //   6440: aconst_null
    //   6441: iload 4
    //   6443: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6446: goto -4858 -> 1588
    //   6449: new 371	org/json/JSONObject
    //   6452: dup
    //   6453: aload_2
    //   6454: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6457: ldc_w 1598
    //   6460: invokevirtual 1601	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6463: iconst_0
    //   6464: invokevirtual 1415	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6467: astore 22
    //   6469: aload 22
    //   6471: astore 21
    //   6473: aload 22
    //   6475: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6478: ifne +10 -> 6488
    //   6481: aload 22
    //   6483: invokevirtual 1604	java/lang/String:trim	()Ljava/lang/String;
    //   6486: astore 21
    //   6488: aload 20
    //   6490: aload_0
    //   6491: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6494: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6497: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6500: invokevirtual 703	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   6503: astore 20
    //   6505: aload 20
    //   6507: ifnull +179 -> 6686
    //   6510: aload 21
    //   6512: invokestatic 1607	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   6515: ifeq +171 -> 6686
    //   6518: aload 20
    //   6520: invokevirtual 1610	com/tencent/mobileqq/mini/app/AuthorizeCenter:isAuthorizeSynchronized	()Z
    //   6523: istore 15
    //   6525: aload 21
    //   6527: ldc_w 1612
    //   6530: invokevirtual 1480	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6533: ifeq +59 -> 6592
    //   6536: iload 15
    //   6538: ifne +54 -> 6592
    //   6541: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6544: aconst_null
    //   6545: aload_0
    //   6546: invokevirtual 1615	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   6549: new 1617	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13
    //   6552: dup
    //   6553: aload_0
    //   6554: aload 20
    //   6556: aload 21
    //   6558: aload_3
    //   6559: aload_1
    //   6560: iload 4
    //   6562: aload_2
    //   6563: invokespecial 1620	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILjava/lang/String;)V
    //   6566: invokevirtual 1624	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getAuthList	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6569: goto -4981 -> 1588
    //   6572: astore_2
    //   6573: aload_2
    //   6574: invokevirtual 483	java/lang/Throwable:printStackTrace	()V
    //   6577: aload_0
    //   6578: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6581: aload_3
    //   6582: aload_1
    //   6583: aconst_null
    //   6584: iload 4
    //   6586: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6589: goto -5001 -> 1588
    //   6592: aload 20
    //   6594: aload 21
    //   6596: invokevirtual 1627	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   6599: istore 8
    //   6601: iload 8
    //   6603: istore 7
    //   6605: iload 8
    //   6607: iconst_1
    //   6608: if_icmpne +42 -> 6650
    //   6611: aload_0
    //   6612: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6615: invokevirtual 1630	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   6618: ifne +3870 -> 10488
    //   6621: aload_0
    //   6622: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6625: astore 20
    //   6627: iload 8
    //   6629: istore 7
    //   6631: aload_0
    //   6632: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6635: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6638: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6641: invokestatic 1633	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   6644: ifeq +6 -> 6650
    //   6647: goto +3841 -> 10488
    //   6650: iload 7
    //   6652: iconst_2
    //   6653: if_icmpne +18 -> 6671
    //   6656: aload_0
    //   6657: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6660: aload_3
    //   6661: aload_1
    //   6662: aconst_null
    //   6663: iload 4
    //   6665: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6668: goto -5080 -> 1588
    //   6671: aload_0
    //   6672: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6675: aload_1
    //   6676: aload_2
    //   6677: aload_3
    //   6678: iload 4
    //   6680: invokevirtual 1637	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:reqAuthorize	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   6683: goto -5095 -> 1588
    //   6686: aload_0
    //   6687: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6690: aload_3
    //   6691: aload_1
    //   6692: aconst_null
    //   6693: iload 4
    //   6695: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6698: goto -5110 -> 1588
    //   6701: ldc 56
    //   6703: aload_1
    //   6704: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6707: ifeq +165 -> 6872
    //   6710: new 371	org/json/JSONObject
    //   6713: dup
    //   6714: aload_2
    //   6715: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6718: astore_1
    //   6719: ldc 150
    //   6721: iconst_2
    //   6722: new 419	java/lang/StringBuilder
    //   6725: dup
    //   6726: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   6729: ldc_w 1639
    //   6732: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6735: aload_1
    //   6736: invokevirtual 1182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6739: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6742: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6745: new 788	android/content/Intent
    //   6748: dup
    //   6749: invokespecial 1640	android/content/Intent:<init>	()V
    //   6752: astore_2
    //   6753: aload_2
    //   6754: new 1642	android/content/ComponentName
    //   6757: dup
    //   6758: aload_0
    //   6759: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6762: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6765: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6768: ldc_w 1644
    //   6771: invokespecial 1645	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6774: invokevirtual 1649	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   6777: pop
    //   6778: aload_2
    //   6779: ldc_w 1651
    //   6782: aload_1
    //   6783: ldc_w 1651
    //   6786: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6789: invokevirtual 799	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6792: pop
    //   6793: aload_2
    //   6794: ldc_w 1653
    //   6797: sipush 1008
    //   6800: invokevirtual 1656	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6803: pop
    //   6804: aload_2
    //   6805: ldc_w 1658
    //   6808: iconst_2
    //   6809: invokevirtual 1656	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6812: pop
    //   6813: aload_2
    //   6814: ldc_w 1660
    //   6817: aload_1
    //   6818: ldc_w 1662
    //   6821: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6824: invokevirtual 799	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6827: pop
    //   6828: aload_2
    //   6829: ldc_w 1663
    //   6832: invokevirtual 1667	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   6835: pop
    //   6836: aload_0
    //   6837: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6840: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6843: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6846: aload_2
    //   6847: invokevirtual 1241	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   6850: goto -5262 -> 1588
    //   6853: astore_1
    //   6854: ldc 150
    //   6856: iconst_1
    //   6857: aload_1
    //   6858: iconst_0
    //   6859: anewarray 904	java/lang/Object
    //   6862: invokestatic 1294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   6865: aload_1
    //   6866: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   6869: goto -5281 -> 1588
    //   6872: ldc 11
    //   6874: aload_1
    //   6875: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6878: ifeq +61 -> 6939
    //   6881: new 371	org/json/JSONObject
    //   6884: dup
    //   6885: aload_2
    //   6886: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6889: astore_2
    //   6890: new 1669	Wallet/FocusMpIdReq
    //   6893: dup
    //   6894: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6897: invokevirtual 1159	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6900: invokevirtual 1315	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6903: aload_2
    //   6904: ldc_w 1671
    //   6907: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6910: invokespecial 1672	Wallet/FocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   6913: new 1674	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14
    //   6916: dup
    //   6917: aload_0
    //   6918: aload_3
    //   6919: aload_1
    //   6920: iload 4
    //   6922: invokespecial 1675	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   6925: invokestatic 1325	akxq:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   6928: goto -5340 -> 1588
    //   6931: astore_1
    //   6932: aload_1
    //   6933: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   6936: goto -5348 -> 1588
    //   6939: ldc_w 1677
    //   6942: aload_1
    //   6943: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6946: ifeq +34 -> 6980
    //   6949: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6952: aload_0
    //   6953: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6956: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6959: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6962: new 1679	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15
    //   6965: dup
    //   6966: aload_0
    //   6967: aload_3
    //   6968: aload_1
    //   6969: iload 4
    //   6971: invokespecial 1680	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   6974: invokevirtual 1683	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getFormId	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6977: goto -5389 -> 1588
    //   6980: ldc 121
    //   6982: aload_1
    //   6983: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6986: ifeq +149 -> 7135
    //   6989: aload_0
    //   6990: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6993: ifnonnull +7 -> 7000
    //   6996: ldc_w 545
    //   6999: areturn
    //   7000: new 371	org/json/JSONObject
    //   7003: dup
    //   7004: aload_2
    //   7005: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7008: ldc_w 1684
    //   7011: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7014: astore_2
    //   7015: invokestatic 594	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   7018: aload_0
    //   7019: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7022: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7025: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   7028: invokevirtual 602	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   7031: astore_1
    //   7032: aload_1
    //   7033: ifnull +3461 -> 10494
    //   7036: aload_1
    //   7037: invokevirtual 608	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getMiniGamePkg	()Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;
    //   7040: astore_1
    //   7041: aload_2
    //   7042: aload_1
    //   7043: invokestatic 1690	com/tencent/mobileqq/mini/entry/MiniAppUtils:checkNavigationAppIdListForMiniGame	(Ljava/lang/String;Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;)Z
    //   7046: istore 15
    //   7048: new 371	org/json/JSONObject
    //   7051: dup
    //   7052: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   7055: astore_1
    //   7056: aload_1
    //   7057: ldc_w 1692
    //   7060: iload 15
    //   7062: invokevirtual 1695	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   7065: pop
    //   7066: ldc 150
    //   7068: iconst_2
    //   7069: new 419	java/lang/StringBuilder
    //   7072: dup
    //   7073: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   7076: ldc_w 1697
    //   7079: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7082: aload_1
    //   7083: invokevirtual 1182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7086: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7089: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7092: aload_1
    //   7093: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7096: areturn
    //   7097: astore_2
    //   7098: ldc 150
    //   7100: iconst_1
    //   7101: aload_2
    //   7102: iconst_0
    //   7103: anewarray 904	java/lang/Object
    //   7106: invokestatic 1294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7109: aload_2
    //   7110: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   7113: goto -47 -> 7066
    //   7116: astore_1
    //   7117: ldc 150
    //   7119: iconst_1
    //   7120: aload_1
    //   7121: iconst_0
    //   7122: anewarray 904	java/lang/Object
    //   7125: invokestatic 1294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7128: aload_1
    //   7129: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   7132: goto -5544 -> 1588
    //   7135: ldc_w 1699
    //   7138: aload_1
    //   7139: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7142: ifeq +222 -> 7364
    //   7145: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7148: invokevirtual 1159	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   7151: astore_1
    //   7152: aload_1
    //   7153: instanceof 699
    //   7156: ifeq +3150 -> 10306
    //   7159: aload_1
    //   7160: checkcast 699	com/tencent/mobileqq/mini/MiniAppInterface
    //   7163: astore_1
    //   7164: aload_0
    //   7165: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7168: ifnull +7 -> 7175
    //   7171: aload_1
    //   7172: ifnonnull +26 -> 7198
    //   7175: aload_0
    //   7176: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7179: aload_3
    //   7180: ldc_w 1700
    //   7183: aconst_null
    //   7184: ldc_w 1701
    //   7187: invokestatic 1705	anzj:a	(I)Ljava/lang/String;
    //   7190: iload 4
    //   7192: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7195: goto -5607 -> 1588
    //   7198: aload_1
    //   7199: aload_0
    //   7200: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7203: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7206: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7209: invokevirtual 703	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   7212: astore_1
    //   7213: aload_1
    //   7214: ifnull +121 -> 7335
    //   7217: ldc_w 1707
    //   7220: invokestatic 1607	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   7223: ifeq +112 -> 7335
    //   7226: aload_1
    //   7227: ldc_w 1707
    //   7230: invokevirtual 1627	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   7233: istore 8
    //   7235: iload 8
    //   7237: istore 7
    //   7239: iload 8
    //   7241: iconst_1
    //   7242: if_icmpne +41 -> 7283
    //   7245: aload_0
    //   7246: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7249: invokevirtual 1630	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   7252: ifne +28 -> 7280
    //   7255: aload_0
    //   7256: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7259: astore_1
    //   7260: iload 8
    //   7262: istore 7
    //   7264: aload_0
    //   7265: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7268: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7271: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7274: invokestatic 1633	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   7277: ifeq +6 -> 7283
    //   7280: iconst_2
    //   7281: istore 7
    //   7283: iload 7
    //   7285: iconst_2
    //   7286: if_icmpne +20 -> 7306
    //   7289: aload_0
    //   7290: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7293: aload_3
    //   7294: ldc_w 1700
    //   7297: aconst_null
    //   7298: iload 4
    //   7300: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7303: goto -5715 -> 1588
    //   7306: ldc 150
    //   7308: iconst_1
    //   7309: ldc_w 1709
    //   7312: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7315: aload_0
    //   7316: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7319: aload_3
    //   7320: ldc_w 1700
    //   7323: aconst_null
    //   7324: ldc_w 1709
    //   7327: iload 4
    //   7329: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7332: goto -5744 -> 1588
    //   7335: aload_0
    //   7336: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7339: aload_3
    //   7340: ldc_w 1700
    //   7343: aconst_null
    //   7344: ldc_w 1711
    //   7347: iload 4
    //   7349: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7352: ldc 150
    //   7354: iconst_1
    //   7355: ldc_w 1713
    //   7358: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7361: goto -5773 -> 1588
    //   7364: ldc_w 1715
    //   7367: aload_1
    //   7368: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7371: ifeq +213 -> 7584
    //   7374: new 371	org/json/JSONObject
    //   7377: dup
    //   7378: aload_2
    //   7379: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7382: astore 20
    //   7384: aload 20
    //   7386: ldc_w 1717
    //   7389: invokevirtual 1601	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7392: astore_2
    //   7393: aload 20
    //   7395: ldc_w 658
    //   7398: ldc_w 1289
    //   7401: invokevirtual 1251	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7404: astore 20
    //   7406: aload_2
    //   7407: ifnull -5819 -> 1588
    //   7410: aload_2
    //   7411: invokevirtual 1413	org/json/JSONArray:length	()I
    //   7414: ifle -5826 -> 1588
    //   7417: aload_2
    //   7418: invokevirtual 1413	org/json/JSONArray:length	()I
    //   7421: anewarray 456	java/lang/String
    //   7424: astore 21
    //   7426: iconst_0
    //   7427: istore 7
    //   7429: iload 7
    //   7431: aload_2
    //   7432: invokevirtual 1413	org/json/JSONArray:length	()I
    //   7435: if_icmpge +23 -> 7458
    //   7438: aload 21
    //   7440: iload 7
    //   7442: aload_2
    //   7443: iload 7
    //   7445: invokevirtual 1415	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   7448: aastore
    //   7449: iload 7
    //   7451: iconst_1
    //   7452: iadd
    //   7453: istore 7
    //   7455: goto -26 -> 7429
    //   7458: invokestatic 594	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   7461: aload_0
    //   7462: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7465: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7468: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   7471: invokevirtual 602	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   7474: astore_2
    //   7475: aload_2
    //   7476: ifnonnull +26 -> 7502
    //   7479: aload_1
    //   7480: aconst_null
    //   7481: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   7484: astore_2
    //   7485: aload_0
    //   7486: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7489: aload_3
    //   7490: aload_1
    //   7491: aload_2
    //   7492: iload 4
    //   7494: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7497: aload_2
    //   7498: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7501: areturn
    //   7502: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7505: aload_2
    //   7506: invokevirtual 1721	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7509: invokevirtual 1724	com/tencent/mobileqq/minigame/manager/GameInfoManager:getAppId	()Ljava/lang/String;
    //   7512: aload 20
    //   7514: aload 21
    //   7516: new 1726	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16
    //   7519: dup
    //   7520: aload_0
    //   7521: aload_2
    //   7522: aload_3
    //   7523: aload_1
    //   7524: iload 4
    //   7526: invokespecial 1729	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7529: invokevirtual 1733	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoOpenData	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7532: goto -5944 -> 1588
    //   7535: astore_2
    //   7536: aload_0
    //   7537: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7540: aload_3
    //   7541: aload_1
    //   7542: aconst_null
    //   7543: iload 4
    //   7545: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7548: ldc 150
    //   7550: iconst_1
    //   7551: new 419	java/lang/StringBuilder
    //   7554: dup
    //   7555: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   7558: ldc_w 1735
    //   7561: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7564: aload_1
    //   7565: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7568: ldc_w 1737
    //   7571: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7574: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7577: aload_2
    //   7578: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7581: goto -5993 -> 1588
    //   7584: ldc 41
    //   7586: aload_1
    //   7587: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7590: ifeq +424 -> 8014
    //   7593: new 371	org/json/JSONObject
    //   7596: dup
    //   7597: aload_2
    //   7598: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7601: astore_2
    //   7602: aload_2
    //   7603: ldc_w 1739
    //   7606: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7609: astore 23
    //   7611: aload_2
    //   7612: ldc_w 1741
    //   7615: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7618: astore 24
    //   7620: aload_2
    //   7621: ldc_w 1743
    //   7624: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7627: astore 25
    //   7629: aload_2
    //   7630: ldc_w 1745
    //   7633: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7636: astore 21
    //   7638: aload_2
    //   7639: ldc_w 1747
    //   7642: invokevirtual 1750	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7645: istore 7
    //   7647: ldc_w 1752
    //   7650: aload 24
    //   7652: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7655: ifne +33 -> 7688
    //   7658: ldc_w 1754
    //   7661: aload 24
    //   7663: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7666: ifne +22 -> 7688
    //   7669: aload_0
    //   7670: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7673: aload_3
    //   7674: aload_1
    //   7675: aconst_null
    //   7676: ldc_w 1756
    //   7679: iload 4
    //   7681: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7684: ldc_w 545
    //   7687: areturn
    //   7688: ldc_w 1752
    //   7691: aload 23
    //   7693: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7696: ifne +33 -> 7729
    //   7699: ldc_w 1758
    //   7702: aload 23
    //   7704: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7707: ifne +22 -> 7729
    //   7710: aload_0
    //   7711: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7714: aload_3
    //   7715: aload_1
    //   7716: aconst_null
    //   7717: ldc_w 1760
    //   7720: iload 4
    //   7722: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7725: ldc_w 545
    //   7728: areturn
    //   7729: iload 7
    //   7731: ifgt +22 -> 7753
    //   7734: aload_0
    //   7735: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7738: aload_3
    //   7739: aload_1
    //   7740: aconst_null
    //   7741: ldc_w 1762
    //   7744: iload 4
    //   7746: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7749: ldc_w 545
    //   7752: areturn
    //   7753: aload 21
    //   7755: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7758: ifeq +22 -> 7780
    //   7761: aload_0
    //   7762: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7765: aload_3
    //   7766: aload_1
    //   7767: aconst_null
    //   7768: ldc_w 1764
    //   7771: iload 4
    //   7773: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7776: ldc_w 545
    //   7779: areturn
    //   7780: new 1766	android/graphics/Paint
    //   7783: dup
    //   7784: invokespecial 1767	android/graphics/Paint:<init>	()V
    //   7787: astore 22
    //   7789: aload 22
    //   7791: iload 7
    //   7793: i2f
    //   7794: invokevirtual 1771	android/graphics/Paint:setTextSize	(F)V
    //   7797: aconst_null
    //   7798: astore 20
    //   7800: ldc_w 1752
    //   7803: aload 23
    //   7805: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7808: ifeq +68 -> 7876
    //   7811: ldc_w 1752
    //   7814: aload 24
    //   7816: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7819: ifeq +33 -> 7852
    //   7822: aload 25
    //   7824: iconst_0
    //   7825: invokestatic 1777	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7828: astore_2
    //   7829: aload_2
    //   7830: ifnonnull +105 -> 7935
    //   7833: aload_0
    //   7834: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7837: aload_3
    //   7838: aload_1
    //   7839: aconst_null
    //   7840: ldc_w 1779
    //   7843: iload 4
    //   7845: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7848: ldc_w 545
    //   7851: areturn
    //   7852: aload 20
    //   7854: astore_2
    //   7855: ldc_w 1754
    //   7858: aload 24
    //   7860: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7863: ifeq -34 -> 7829
    //   7866: aload 25
    //   7868: iconst_1
    //   7869: invokestatic 1777	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7872: astore_2
    //   7873: goto -44 -> 7829
    //   7876: aload 20
    //   7878: astore_2
    //   7879: ldc_w 1758
    //   7882: aload 23
    //   7884: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7887: ifeq -58 -> 7829
    //   7890: ldc_w 1752
    //   7893: aload 24
    //   7895: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7898: ifeq +13 -> 7911
    //   7901: aload 25
    //   7903: iconst_2
    //   7904: invokestatic 1777	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7907: astore_2
    //   7908: goto -79 -> 7829
    //   7911: aload 20
    //   7913: astore_2
    //   7914: ldc_w 1754
    //   7917: aload 24
    //   7919: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7922: ifeq -93 -> 7829
    //   7925: aload 25
    //   7927: iconst_3
    //   7928: invokestatic 1777	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7931: astore_2
    //   7932: goto -103 -> 7829
    //   7935: new 1781	android/graphics/Rect
    //   7938: dup
    //   7939: invokespecial 1782	android/graphics/Rect:<init>	()V
    //   7942: astore_2
    //   7943: aload 22
    //   7945: aload 21
    //   7947: iconst_0
    //   7948: aload 21
    //   7950: invokevirtual 1783	java/lang/String:length	()I
    //   7953: aload_2
    //   7954: invokevirtual 1787	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   7957: aload_0
    //   7958: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7961: aload_3
    //   7962: aload_1
    //   7963: aconst_null
    //   7964: iload 4
    //   7966: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7969: new 419	java/lang/StringBuilder
    //   7972: dup
    //   7973: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   7976: ldc_w 545
    //   7979: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7982: aload_2
    //   7983: invokevirtual 1789	android/graphics/Rect:height	()I
    //   7986: invokevirtual 771	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7989: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7992: astore_2
    //   7993: aload_2
    //   7994: areturn
    //   7995: astore_2
    //   7996: aload_0
    //   7997: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8000: aload_3
    //   8001: aload_1
    //   8002: aconst_null
    //   8003: ldc_w 1791
    //   8006: iload 4
    //   8008: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8011: goto -6423 -> 1588
    //   8014: ldc_w 1793
    //   8017: aload_1
    //   8018: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8021: ifeq +28 -> 8049
    //   8024: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   8027: aload_0
    //   8028: invokevirtual 1615	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   8031: new 1795	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17
    //   8034: dup
    //   8035: aload_0
    //   8036: aload_3
    //   8037: aload_1
    //   8038: iload 4
    //   8040: invokespecial 1796	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   8043: invokevirtual 1798	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoExtra	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   8046: goto -6458 -> 1588
    //   8049: ldc 23
    //   8051: aload_1
    //   8052: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8055: ifeq +323 -> 8378
    //   8058: aload_0
    //   8059: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   8062: ifeq -6474 -> 1588
    //   8065: invokestatic 594	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   8068: aload_0
    //   8069: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8072: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8075: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8078: invokevirtual 602	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   8081: astore 20
    //   8083: aload 20
    //   8085: ifnonnull +26 -> 8111
    //   8088: aload_1
    //   8089: aconst_null
    //   8090: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8093: astore_2
    //   8094: aload_0
    //   8095: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8098: aload_3
    //   8099: aload_1
    //   8100: aload_2
    //   8101: iload 4
    //   8103: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8106: aload_2
    //   8107: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8110: areturn
    //   8111: aload 20
    //   8113: invokevirtual 1721	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8116: invokevirtual 1802	com/tencent/mobileqq/minigame/manager/GameInfoManager:getLaunchOptions	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions;
    //   8119: astore 21
    //   8121: new 371	org/json/JSONObject
    //   8124: dup
    //   8125: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   8128: astore 22
    //   8130: new 371	org/json/JSONObject
    //   8133: dup
    //   8134: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   8137: astore 23
    //   8139: aload 21
    //   8141: getfield 1807	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8144: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8147: ifeq +170 -> 8317
    //   8150: aconst_null
    //   8151: astore_2
    //   8152: aload 23
    //   8154: ldc_w 1684
    //   8157: aload_2
    //   8158: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8161: pop
    //   8162: aload 21
    //   8164: getfield 1810	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8167: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8170: ifeq +156 -> 8326
    //   8173: aconst_null
    //   8174: astore_2
    //   8175: aload 23
    //   8177: ldc_w 1812
    //   8180: aload_2
    //   8181: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8184: pop
    //   8185: aload 22
    //   8187: ldc_w 1813
    //   8190: aload 21
    //   8192: getfield 1814	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:scene	I
    //   8195: invokestatic 1820	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getWikiScene	(I)I
    //   8198: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   8201: pop
    //   8202: aload 22
    //   8204: ldc_w 1463
    //   8207: aload 21
    //   8209: getfield 1823	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:query	Lorg/json/JSONObject;
    //   8212: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8215: pop
    //   8216: aload 21
    //   8218: getfield 1825	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8221: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8224: ifeq +111 -> 8335
    //   8227: aconst_null
    //   8228: astore_2
    //   8229: aload 22
    //   8231: ldc_w 1354
    //   8234: aload_2
    //   8235: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8238: pop
    //   8239: aload 22
    //   8241: ldc_w 1827
    //   8244: aload 23
    //   8246: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8249: pop
    //   8250: aload 22
    //   8252: ldc_w 1829
    //   8255: aload 20
    //   8257: invokevirtual 1721	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8260: invokevirtual 1832	com/tencent/mobileqq/minigame/manager/GameInfoManager:getExtendData	()Ljava/lang/String;
    //   8263: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8266: pop
    //   8267: aload 22
    //   8269: ldc_w 1488
    //   8272: aload 21
    //   8274: getfield 1834	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:entryDataHash	Ljava/lang/String;
    //   8277: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8280: pop
    //   8281: ldc 150
    //   8283: iconst_1
    //   8284: new 419	java/lang/StringBuilder
    //   8287: dup
    //   8288: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   8291: ldc_w 1836
    //   8294: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8297: aload 22
    //   8299: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8302: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8305: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8308: invokestatic 464	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8311: aload 22
    //   8313: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8316: areturn
    //   8317: aload 21
    //   8319: getfield 1807	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8322: astore_2
    //   8323: goto -171 -> 8152
    //   8326: aload 21
    //   8328: getfield 1810	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8331: astore_2
    //   8332: goto -157 -> 8175
    //   8335: aload 21
    //   8337: getfield 1825	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8340: astore_2
    //   8341: goto -112 -> 8229
    //   8344: astore_2
    //   8345: ldc 150
    //   8347: iconst_1
    //   8348: ldc_w 1838
    //   8351: aload_2
    //   8352: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8355: aload_1
    //   8356: aconst_null
    //   8357: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8360: astore_1
    //   8361: aload_3
    //   8362: iload 4
    //   8364: aload_1
    //   8365: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8368: invokeinterface 647 3 0
    //   8373: aload_1
    //   8374: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8377: areturn
    //   8378: ldc 53
    //   8380: aload_1
    //   8381: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8384: ifeq +648 -> 9032
    //   8387: new 371	org/json/JSONObject
    //   8390: dup
    //   8391: aload_2
    //   8392: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8395: astore_2
    //   8396: ldc 150
    //   8398: iconst_1
    //   8399: new 419	java/lang/StringBuilder
    //   8402: dup
    //   8403: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   8406: ldc_w 1840
    //   8409: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8412: aload_2
    //   8413: invokevirtual 1182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8416: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8419: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8422: aload_2
    //   8423: ldc_w 795
    //   8426: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8429: astore 22
    //   8431: aload 22
    //   8433: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8436: ifeq +20 -> 8456
    //   8439: aload_0
    //   8440: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8443: aload_3
    //   8444: aload_1
    //   8445: aconst_null
    //   8446: ldc_w 1842
    //   8449: iload 4
    //   8451: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8454: aconst_null
    //   8455: areturn
    //   8456: aload_2
    //   8457: ldc_w 1844
    //   8460: iconst_0
    //   8461: invokevirtual 1256	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8464: istore 15
    //   8466: aload 22
    //   8468: invokevirtual 1847	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   8471: astore 20
    //   8473: aload 20
    //   8475: invokestatic 1853	com/tencent/mobileqq/mini/apkg/DomainConfig:getDomainConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/DomainConfig;
    //   8478: astore 21
    //   8480: iload 15
    //   8482: ifne +78 -> 8560
    //   8485: aload_0
    //   8486: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8489: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8492: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   8495: aload 20
    //   8497: iconst_0
    //   8498: invokevirtual 1856	com/tencent/mobileqq/mini/apkg/ApkgInfo:isValidPrefix	(Ljava/lang/String;Z)Z
    //   8501: ifne +20 -> 8521
    //   8504: aload_0
    //   8505: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8508: aload_3
    //   8509: aload_1
    //   8510: aconst_null
    //   8511: ldc_w 1858
    //   8514: iload 4
    //   8516: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8519: aconst_null
    //   8520: areturn
    //   8521: aload_0
    //   8522: getfield 436	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8525: ifnull +35 -> 8560
    //   8528: aload_0
    //   8529: getfield 436	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8532: aload 21
    //   8534: getfield 1861	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8537: invokevirtual 1864	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   8540: ifne +20 -> 8560
    //   8543: aload_0
    //   8544: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8547: aload_3
    //   8548: aload_1
    //   8549: aconst_null
    //   8550: ldc_w 1866
    //   8553: iload 4
    //   8555: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8558: aconst_null
    //   8559: areturn
    //   8560: ldc_w 1868
    //   8563: aload 21
    //   8565: getfield 1861	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8568: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8571: ifeq +438 -> 9009
    //   8574: ldc_w 1870
    //   8577: ldc_w 1872
    //   8580: invokestatic 1877	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8583: astore_2
    //   8584: aload 22
    //   8586: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8589: ifne +402 -> 8991
    //   8592: aload_0
    //   8593: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8596: ifnull +395 -> 8991
    //   8599: aload_0
    //   8600: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8603: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8606: ifnull +385 -> 8991
    //   8609: invokestatic 1882	com/tencent/mobileqq/mini/mainpage/MainPageFragment:getUin	()Ljava/lang/String;
    //   8612: astore 21
    //   8614: aload 21
    //   8616: ifnonnull +1883 -> 10499
    //   8619: ldc_w 545
    //   8622: astore 20
    //   8624: aload 22
    //   8626: ldc_w 1884
    //   8629: aload 20
    //   8631: invokevirtual 1888	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8634: ldc_w 1890
    //   8637: invokestatic 1133	bhlo:c	()Ljava/lang/String;
    //   8640: invokevirtual 1888	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8643: ldc_w 1892
    //   8646: ldc_w 1144
    //   8649: invokevirtual 1888	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8652: ldc_w 1894
    //   8655: getstatic 918	android/os/Build$VERSION:SDK_INT	I
    //   8658: invokestatic 562	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   8661: invokevirtual 1888	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8664: ldc_w 1896
    //   8667: invokestatic 1900	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8670: invokestatic 1905	bhnv:a	(Landroid/content/Context;)Ljava/lang/String;
    //   8673: invokevirtual 1888	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8676: ldc_w 1907
    //   8679: aload_2
    //   8680: invokevirtual 1888	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8683: astore 22
    //   8685: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8688: new 419	java/lang/StringBuilder
    //   8691: dup
    //   8692: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   8695: getstatic 1913	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   8698: invokevirtual 1914	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   8701: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8704: aload 21
    //   8706: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8709: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8712: invokevirtual 1917	com/tencent/common/app/BaseApplicationImpl:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   8715: astore 20
    //   8717: aload 20
    //   8719: astore_2
    //   8720: aload 20
    //   8722: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8725: ifeq +7 -> 8732
    //   8728: ldc_w 545
    //   8731: astore_2
    //   8732: aload 22
    //   8734: ldc_w 1919
    //   8737: aload_2
    //   8738: invokevirtual 1888	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8741: astore_2
    //   8742: invokestatic 894	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8745: ifeq +29 -> 8774
    //   8748: ldc 150
    //   8750: iconst_2
    //   8751: new 419	java/lang/StringBuilder
    //   8754: dup
    //   8755: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   8758: ldc_w 1921
    //   8761: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8764: aload_2
    //   8765: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8768: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8771: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8774: new 788	android/content/Intent
    //   8777: dup
    //   8778: aload_0
    //   8779: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8782: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8785: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8788: ldc_w 790
    //   8791: invokespecial 793	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8794: astore 20
    //   8796: aload 20
    //   8798: ldc_w 1923
    //   8801: ldc_w 1924
    //   8804: invokestatic 1705	anzj:a	(I)Ljava/lang/String;
    //   8807: invokevirtual 799	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8810: pop
    //   8811: aload 20
    //   8813: ldc_w 804
    //   8816: iconst_1
    //   8817: invokevirtual 1927	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8820: pop
    //   8821: aload 20
    //   8823: ldc_w 1929
    //   8826: iconst_1
    //   8827: invokevirtual 1927	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8830: pop
    //   8831: aload 20
    //   8833: ldc_w 795
    //   8836: aload_2
    //   8837: invokevirtual 799	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8840: pop
    //   8841: aload_0
    //   8842: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8845: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8848: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8851: aload 20
    //   8853: invokevirtual 1241	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   8856: aload_0
    //   8857: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8860: aload_3
    //   8861: aload_1
    //   8862: aconst_null
    //   8863: iload 4
    //   8865: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8868: aload_2
    //   8869: ldc_w 1931
    //   8872: invokevirtual 1480	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8875: ifeq -7287 -> 1588
    //   8878: ldc 150
    //   8880: iconst_2
    //   8881: ldc_w 1933
    //   8884: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8887: new 801	android/os/Bundle
    //   8890: dup
    //   8891: invokespecial 802	android/os/Bundle:<init>	()V
    //   8894: astore_1
    //   8895: aload_1
    //   8896: ldc_w 1935
    //   8899: aload_0
    //   8900: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8903: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8906: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   8909: invokevirtual 1938	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8912: invokestatic 1943	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   8915: ldc_w 1945
    //   8918: ldc_w 1947
    //   8921: aload_1
    //   8922: new 1949	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18
    //   8925: dup
    //   8926: aload_0
    //   8927: invokespecial 1952	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;)V
    //   8930: invokevirtual 1956	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   8933: goto -7345 -> 1588
    //   8936: astore_1
    //   8937: ldc 150
    //   8939: iconst_1
    //   8940: aload_1
    //   8941: iconst_0
    //   8942: anewarray 904	java/lang/Object
    //   8945: invokestatic 1294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   8948: goto -7360 -> 1588
    //   8951: astore_2
    //   8952: ldc 150
    //   8954: iconst_1
    //   8955: new 419	java/lang/StringBuilder
    //   8958: dup
    //   8959: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   8962: ldc_w 1958
    //   8965: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8968: ldc_w 545
    //   8971: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8974: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8977: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8980: aload_2
    //   8981: invokevirtual 1959	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   8984: ldc_w 545
    //   8987: astore_2
    //   8988: goto -404 -> 8584
    //   8991: aload_0
    //   8992: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8995: aload_3
    //   8996: aload_1
    //   8997: aconst_null
    //   8998: ldc_w 1961
    //   9001: iload 4
    //   9003: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9006: goto -7418 -> 1588
    //   9009: new 1963	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19
    //   9012: dup
    //   9013: aload_0
    //   9014: aload_2
    //   9015: aload_3
    //   9016: aload_1
    //   9017: iload 4
    //   9019: invokespecial 1966	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9022: bipush 16
    //   9024: aconst_null
    //   9025: iconst_0
    //   9026: invokestatic 1970	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   9029: goto -7441 -> 1588
    //   9032: ldc 62
    //   9034: aload_1
    //   9035: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9038: ifeq +113 -> 9151
    //   9041: new 371	org/json/JSONObject
    //   9044: dup
    //   9045: aload_2
    //   9046: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9049: ldc_w 1972
    //   9052: iconst_0
    //   9053: invokevirtual 1256	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   9056: istore 15
    //   9058: aload_0
    //   9059: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   9062: ifeq -7474 -> 1588
    //   9065: invokestatic 594	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   9068: aload_0
    //   9069: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9072: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9075: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   9078: invokevirtual 602	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   9081: astore_2
    //   9082: aload_2
    //   9083: ifnonnull +26 -> 9109
    //   9086: aload_1
    //   9087: aconst_null
    //   9088: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   9091: astore_2
    //   9092: aload_0
    //   9093: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9096: aload_3
    //   9097: aload_1
    //   9098: aload_2
    //   9099: iload 4
    //   9101: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9104: aload_2
    //   9105: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9108: areturn
    //   9109: aload_2
    //   9110: invokevirtual 1721	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   9113: invokevirtual 1976	com/tencent/mobileqq/minigame/manager/GameInfoManager:getMiniAppConfig	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9116: iload 15
    //   9118: invokestatic 1982	com/tencent/mobileqq/minigame/gpkg/GpkgManager:setOfflineResourceContent	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Z)V
    //   9121: aload_0
    //   9122: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9125: aload_3
    //   9126: aload_1
    //   9127: aconst_null
    //   9128: iload 4
    //   9130: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9133: goto -7545 -> 1588
    //   9136: astore_1
    //   9137: ldc 150
    //   9139: iconst_1
    //   9140: aload_1
    //   9141: iconst_0
    //   9142: anewarray 904	java/lang/Object
    //   9145: invokestatic 1294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   9148: goto -7560 -> 1588
    //   9151: ldc 95
    //   9153: aload_1
    //   9154: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9157: ifeq +178 -> 9335
    //   9160: aload_0
    //   9161: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9164: ifnull -7576 -> 1588
    //   9167: new 466	java/util/ArrayList
    //   9170: dup
    //   9171: invokespecial 467	java/util/ArrayList:<init>	()V
    //   9174: astore 20
    //   9176: new 371	org/json/JSONObject
    //   9179: dup
    //   9180: aload_2
    //   9181: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9184: ldc_w 499
    //   9187: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   9190: ldc_w 1984
    //   9193: invokevirtual 1601	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9196: astore_2
    //   9197: aload_2
    //   9198: ifnull +85 -> 9283
    //   9201: aload_2
    //   9202: invokevirtual 1413	org/json/JSONArray:length	()I
    //   9205: ifle +78 -> 9283
    //   9208: iconst_0
    //   9209: istore 7
    //   9211: iload 7
    //   9213: aload_2
    //   9214: invokevirtual 1413	org/json/JSONArray:length	()I
    //   9217: if_icmpge +66 -> 9283
    //   9220: aload_2
    //   9221: iload 7
    //   9223: invokevirtual 1987	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9226: checkcast 371	org/json/JSONObject
    //   9229: astore 21
    //   9231: new 1989	com/tencent/mobileqq/mini/apkg/PluginInfo
    //   9234: dup
    //   9235: invokespecial 1990	com/tencent/mobileqq/mini/apkg/PluginInfo:<init>	()V
    //   9238: astore 22
    //   9240: aload 22
    //   9242: aload 21
    //   9244: ldc_w 1992
    //   9247: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9250: invokevirtual 1995	com/tencent/mobileqq/mini/apkg/PluginInfo:setPluginId	(Ljava/lang/String;)V
    //   9253: aload 22
    //   9255: aload 21
    //   9257: ldc_w 1997
    //   9260: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9263: invokevirtual 2000	com/tencent/mobileqq/mini/apkg/PluginInfo:setInnerVersion	(Ljava/lang/String;)V
    //   9266: aload 20
    //   9268: aload 22
    //   9270: invokevirtual 480	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9273: pop
    //   9274: iload 7
    //   9276: iconst_1
    //   9277: iadd
    //   9278: istore 7
    //   9280: goto -69 -> 9211
    //   9283: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9286: aload_0
    //   9287: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9290: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9293: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9296: aload 20
    //   9298: new 2002	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20
    //   9301: dup
    //   9302: aload_0
    //   9303: aload_3
    //   9304: aload_1
    //   9305: iload 4
    //   9307: invokespecial 2003	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9310: invokevirtual 2006	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:verifyPlugin	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9313: goto -7725 -> 1588
    //   9316: astore_2
    //   9317: aload_0
    //   9318: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9321: aload_3
    //   9322: aload_1
    //   9323: aconst_null
    //   9324: ldc_w 2008
    //   9327: iload 4
    //   9329: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9332: goto -7744 -> 1588
    //   9335: ldc 14
    //   9337: aload_1
    //   9338: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9341: ifeq +127 -> 9468
    //   9344: aload_0
    //   9345: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9348: ifnull -7760 -> 1588
    //   9351: aload_2
    //   9352: ifnull -7764 -> 1588
    //   9355: new 371	org/json/JSONObject
    //   9358: dup
    //   9359: aload_2
    //   9360: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9363: ldc_w 2010
    //   9366: invokevirtual 1601	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9369: astore_2
    //   9370: new 466	java/util/ArrayList
    //   9373: dup
    //   9374: invokespecial 467	java/util/ArrayList:<init>	()V
    //   9377: astore 20
    //   9379: aload_2
    //   9380: ifnull +46 -> 9426
    //   9383: aload_2
    //   9384: invokevirtual 1413	org/json/JSONArray:length	()I
    //   9387: ifle +39 -> 9426
    //   9390: iconst_0
    //   9391: istore 7
    //   9393: iload 7
    //   9395: aload_2
    //   9396: invokevirtual 1413	org/json/JSONArray:length	()I
    //   9399: if_icmpge +27 -> 9426
    //   9402: aload 20
    //   9404: aload_2
    //   9405: iload 7
    //   9407: invokevirtual 1987	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9410: invokestatic 2013	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9413: invokevirtual 480	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9416: pop
    //   9417: iload 7
    //   9419: iconst_1
    //   9420: iadd
    //   9421: istore 7
    //   9423: goto -30 -> 9393
    //   9426: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9429: aload 20
    //   9431: new 2015	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21
    //   9434: dup
    //   9435: aload_0
    //   9436: aload_3
    //   9437: aload_1
    //   9438: iload 4
    //   9440: invokespecial 2016	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9443: invokevirtual 2019	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:batchGetContact	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9446: goto -7858 -> 1588
    //   9449: astore_2
    //   9450: aload_0
    //   9451: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9454: aload_3
    //   9455: aload_1
    //   9456: aconst_null
    //   9457: ldc_w 2021
    //   9460: iload 4
    //   9462: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9465: goto -7877 -> 1588
    //   9468: ldc 26
    //   9470: aload_1
    //   9471: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9474: ifeq +60 -> 9534
    //   9477: new 371	org/json/JSONObject
    //   9480: dup
    //   9481: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   9484: astore_2
    //   9485: aload_2
    //   9486: ldc_w 388
    //   9489: aload_0
    //   9490: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9493: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9496: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9499: getfield 2022	com/tencent/mobileqq/mini/apkg/ApkgInfo:appId	Ljava/lang/String;
    //   9502: invokestatic 2027	com/tencent/mobileqq/mini/report/MiniReportManager:getLaunchPerformance	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9505: invokevirtual 1102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   9508: pop
    //   9509: aload_0
    //   9510: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9513: aload_3
    //   9514: aload_1
    //   9515: aload_2
    //   9516: iload 4
    //   9518: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9521: goto -7933 -> 1588
    //   9524: astore 20
    //   9526: aload 20
    //   9528: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   9531: goto -22 -> 9509
    //   9534: ldc_w 2029
    //   9537: aload_1
    //   9538: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9541: ifeq +131 -> 9672
    //   9544: new 371	org/json/JSONObject
    //   9547: dup
    //   9548: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   9551: astore_2
    //   9552: aload_0
    //   9553: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9556: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9559: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9562: astore 20
    //   9564: iconst_0
    //   9565: istore 16
    //   9567: iload 16
    //   9569: istore 15
    //   9571: aload 20
    //   9573: ifnull +64 -> 9637
    //   9576: iload 16
    //   9578: istore 15
    //   9580: aload 20
    //   9582: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9585: ifnull +52 -> 9637
    //   9588: iload 16
    //   9590: istore 15
    //   9592: aload 20
    //   9594: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9597: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9600: ifnull +37 -> 9637
    //   9603: iload 16
    //   9605: istore 15
    //   9607: aload 20
    //   9609: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9612: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9615: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9618: ifnull +19 -> 9637
    //   9621: aload 20
    //   9623: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9626: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9629: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9632: getfield 2032	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9635: istore 15
    //   9637: aload_2
    //   9638: ldc_w 2034
    //   9641: iload 15
    //   9643: invokevirtual 1695	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9646: pop
    //   9647: aload_0
    //   9648: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9651: aload_3
    //   9652: aload_1
    //   9653: aload_2
    //   9654: iload 4
    //   9656: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9659: goto -8071 -> 1588
    //   9662: astore 20
    //   9664: aload 20
    //   9666: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   9669: goto -22 -> 9647
    //   9672: ldc_w 2036
    //   9675: aload_1
    //   9676: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9679: ifeq +293 -> 9972
    //   9682: new 371	org/json/JSONObject
    //   9685: dup
    //   9686: aload_2
    //   9687: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9690: ldc_w 1488
    //   9693: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9696: astore_2
    //   9697: aload_0
    //   9698: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9701: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9704: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9707: astore 20
    //   9709: new 371	org/json/JSONObject
    //   9712: dup
    //   9713: invokespecial 1062	org/json/JSONObject:<init>	()V
    //   9716: astore 21
    //   9718: iconst_0
    //   9719: istore 16
    //   9721: iload 16
    //   9723: istore 15
    //   9725: aload 20
    //   9727: ifnull +64 -> 9791
    //   9730: iload 16
    //   9732: istore 15
    //   9734: aload 20
    //   9736: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9739: ifnull +52 -> 9791
    //   9742: iload 16
    //   9744: istore 15
    //   9746: aload 20
    //   9748: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9751: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9754: ifnull +37 -> 9791
    //   9757: iload 16
    //   9759: istore 15
    //   9761: aload 20
    //   9763: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9766: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9769: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9772: ifnull +19 -> 9791
    //   9775: aload 20
    //   9777: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9780: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9783: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9786: getfield 2032	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9789: istore 15
    //   9791: aload 21
    //   9793: ldc_w 2034
    //   9796: iload 15
    //   9798: invokevirtual 1695	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9801: pop
    //   9802: aload 20
    //   9804: ifnull +152 -> 9956
    //   9807: aload 20
    //   9809: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9812: ifnull +144 -> 9956
    //   9815: aload 20
    //   9817: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9820: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9823: ifnull +133 -> 9956
    //   9826: aload 20
    //   9828: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9831: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9834: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9837: ifnull +119 -> 9956
    //   9840: aload_2
    //   9841: ifnull +115 -> 9956
    //   9844: aload_2
    //   9845: aload 20
    //   9847: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9850: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9853: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9856: invokevirtual 1497	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   9859: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9862: ifeq +94 -> 9956
    //   9865: aload 20
    //   9867: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9870: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9873: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9876: getfield 2039	com/tencent/mobileqq/mini/sdk/EntryModel:type	I
    //   9879: iconst_1
    //   9880: if_icmpne +76 -> 9956
    //   9883: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9886: aconst_null
    //   9887: aload_0
    //   9888: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9891: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9894: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9897: aload 20
    //   9899: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9902: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9905: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9908: getfield 2042	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   9911: invokestatic 2045	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9914: aload 20
    //   9916: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9919: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9922: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9925: getfield 2048	com/tencent/mobileqq/mini/sdk/EntryModel:dwGroupClassExt	J
    //   9928: new 2050	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22
    //   9931: dup
    //   9932: aload_0
    //   9933: aload 21
    //   9935: aload_3
    //   9936: aload_1
    //   9937: iload 4
    //   9939: invokespecial 2051	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9942: invokevirtual 2055	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserGroupInfo	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9945: goto -8357 -> 1588
    //   9948: astore_1
    //   9949: aload_1
    //   9950: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   9953: goto -8365 -> 1588
    //   9956: aload_0
    //   9957: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9960: aload_3
    //   9961: aload_1
    //   9962: aload 21
    //   9964: iload 4
    //   9966: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9969: goto -8381 -> 1588
    //   9972: ldc_w 2057
    //   9975: aload_1
    //   9976: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9979: ifeq +193 -> 10172
    //   9982: new 371	org/json/JSONObject
    //   9985: dup
    //   9986: aload_2
    //   9987: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9990: astore 20
    //   9992: aload 20
    //   9994: ldc_w 1488
    //   9997: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10000: astore_2
    //   10001: aload 20
    //   10003: ldc_w 795
    //   10006: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10009: astore 20
    //   10011: aload_0
    //   10012: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10015: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   10018: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   10021: astore 21
    //   10023: aload 21
    //   10025: ifnull -8437 -> 1588
    //   10028: aload 21
    //   10030: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10033: ifnull -8445 -> 1588
    //   10036: aload 21
    //   10038: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10041: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10044: ifnull -8456 -> 1588
    //   10047: aload 21
    //   10049: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10052: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10055: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10058: ifnull -8470 -> 1588
    //   10061: aload_2
    //   10062: ifnull -8474 -> 1588
    //   10065: aload_2
    //   10066: aload 21
    //   10068: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10071: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10074: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10077: invokevirtual 1497	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   10080: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10083: ifeq -8495 -> 1588
    //   10086: aload 21
    //   10088: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10091: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10094: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10097: getfield 2032	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   10100: ifeq -8512 -> 1588
    //   10103: aload 20
    //   10105: ifnull -8517 -> 1588
    //   10108: aload 20
    //   10110: ldc_w 2059
    //   10113: invokevirtual 2061	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10116: ifeq -8528 -> 1588
    //   10119: aload 20
    //   10121: ldc_w 2059
    //   10124: aload 21
    //   10126: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10129: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10132: getfield 1492	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10135: getfield 2042	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   10138: invokestatic 2045	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   10141: invokevirtual 1888	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   10144: astore_2
    //   10145: aload_0
    //   10146: aload_0
    //   10147: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10150: getfield 278	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   10153: aload_2
    //   10154: aload_3
    //   10155: aload_1
    //   10156: iload 4
    //   10158: invokespecial 2063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startGroupBrowserActivity	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10161: goto -8573 -> 1588
    //   10164: astore_1
    //   10165: aload_1
    //   10166: invokevirtual 1336	org/json/JSONException:printStackTrace	()V
    //   10169: goto -8581 -> 1588
    //   10172: ldc_w 2065
    //   10175: aload_1
    //   10176: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10179: ifne +13 -> 10192
    //   10182: ldc_w 2067
    //   10185: aload_1
    //   10186: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10189: ifeq +18 -> 10207
    //   10192: aload_0
    //   10193: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10196: aload_3
    //   10197: aload_1
    //   10198: aconst_null
    //   10199: iload 4
    //   10201: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   10204: goto -8616 -> 1588
    //   10207: ldc 20
    //   10209: aload_1
    //   10210: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10213: ifeq +72 -> 10285
    //   10216: new 371	org/json/JSONObject
    //   10219: dup
    //   10220: aload_2
    //   10221: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10224: ldc_w 2069
    //   10227: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10230: astore_2
    //   10231: aload_2
    //   10232: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10235: ifne -8647 -> 1588
    //   10238: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   10241: aload_0
    //   10242: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10245: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   10248: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   10251: aconst_null
    //   10252: aload_2
    //   10253: new 2071	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23
    //   10256: dup
    //   10257: aload_0
    //   10258: aload_3
    //   10259: aload_1
    //   10260: iload 4
    //   10262: invokespecial 2072	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10265: invokevirtual 2076	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getTcbTicket	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   10268: goto -8680 -> 1588
    //   10271: astore_1
    //   10272: ldc 150
    //   10274: iconst_1
    //   10275: ldc_w 2078
    //   10278: aload_1
    //   10279: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10282: goto -8694 -> 1588
    //   10285: ldc 83
    //   10287: aload_1
    //   10288: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10291: ifeq -8703 -> 1588
    //   10294: aload_0
    //   10295: aload_3
    //   10296: aload_1
    //   10297: iload 4
    //   10299: invokespecial 2080	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:doShareInvite	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)Z
    //   10302: pop
    //   10303: goto -8715 -> 1588
    //   10306: aconst_null
    //   10307: astore_1
    //   10308: goto -3144 -> 7164
    //   10311: aconst_null
    //   10312: astore 20
    //   10314: goto -3885 -> 6429
    //   10317: goto -4250 -> 6067
    //   10320: aconst_null
    //   10321: astore_2
    //   10322: goto -6193 -> 4129
    //   10325: iload 9
    //   10327: istore 14
    //   10329: goto -7044 -> 3285
    //   10332: iconst_0
    //   10333: istore 16
    //   10335: goto -9784 -> 551
    //   10338: ldc_w 1042
    //   10341: astore 21
    //   10343: goto -9899 -> 444
    //   10346: iconst_m1
    //   10347: istore 8
    //   10349: iconst_m1
    //   10350: istore 7
    //   10352: iconst_m1
    //   10353: istore 11
    //   10355: iconst_0
    //   10356: istore 10
    //   10358: goto -7190 -> 3168
    //   10361: iload 7
    //   10363: istore 8
    //   10365: iload 7
    //   10367: iconst_m1
    //   10368: if_icmpne -6198 -> 4170
    //   10371: iconst_0
    //   10372: istore 8
    //   10374: goto -6204 -> 4170
    //   10377: ldc_w 545
    //   10380: areturn
    //   10381: iload 9
    //   10383: iconst_1
    //   10384: if_icmpne -5951 -> 4433
    //   10387: iconst_1
    //   10388: istore 7
    //   10390: aconst_null
    //   10391: astore_2
    //   10392: goto -6263 -> 4129
    //   10395: iload 9
    //   10397: iconst_3
    //   10398: if_icmpne +11 -> 10409
    //   10401: iconst_3
    //   10402: istore 7
    //   10404: aconst_null
    //   10405: astore_2
    //   10406: goto -6277 -> 4129
    //   10409: iload 9
    //   10411: iconst_4
    //   10412: if_icmpne -5849 -> 4563
    //   10415: iconst_4
    //   10416: istore 7
    //   10418: aconst_null
    //   10419: astore_2
    //   10420: goto -6291 -> 4129
    //   10423: iconst_0
    //   10424: istore 7
    //   10426: goto -6297 -> 4129
    //   10429: iconst_1
    //   10430: istore 16
    //   10432: goto -5379 -> 5053
    //   10435: iconst_0
    //   10436: istore 16
    //   10438: goto -5385 -> 5053
    //   10441: iconst_0
    //   10442: istore 17
    //   10444: goto -5342 -> 5102
    //   10447: bipush 12
    //   10449: istore 4
    //   10451: goto -5302 -> 5149
    //   10454: bipush 12
    //   10456: istore 4
    //   10458: goto -5110 -> 5348
    //   10461: iconst_1
    //   10462: istore 4
    //   10464: goto -4798 -> 5666
    //   10467: iconst_0
    //   10468: istore 4
    //   10470: goto -4804 -> 5666
    //   10473: iconst_0
    //   10474: istore 8
    //   10476: goto -4759 -> 5717
    //   10479: iload 11
    //   10481: iconst_1
    //   10482: iadd
    //   10483: istore 11
    //   10485: goto -4320 -> 6165
    //   10488: iconst_2
    //   10489: istore 7
    //   10491: goto -3841 -> 6650
    //   10494: aconst_null
    //   10495: astore_1
    //   10496: goto -3455 -> 7041
    //   10499: aload 21
    //   10501: astore 20
    //   10503: goto -1879 -> 8624
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10506	0	this	DataJsPlugin
    //   0	10506	1	paramString1	String
    //   0	10506	2	paramString2	String
    //   0	10506	3	paramJsRuntime	JsRuntime
    //   0	10506	4	paramInt	int
    //   218	574	5	d	double
    //   260	10230	7	i	int
    //   256	10219	8	j	int
    //   318	10095	9	k	int
    //   301	10056	10	m	int
    //   653	9831	11	n	int
    //   237	3259	12	i1	int
    //   3019	457	13	i2	int
    //   3283	7045	14	i3	int
    //   211	9586	15	bool1	boolean
    //   549	9888	16	bool2	boolean
    //   5100	5343	17	bool3	boolean
    //   2440	299	18	l	long
    //   338	1021	20	localObject1	Object
    //   1396	9	20	localJSONException1	org.json.JSONException
    //   1656	645	20	localObject2	Object
    //   2321	3	20	localJSONException2	org.json.JSONException
    //   2539	6891	20	localObject3	Object
    //   9524	3	20	localJSONException3	org.json.JSONException
    //   9562	60	20	localApkgInfo1	ApkgInfo
    //   9662	3	20	localJSONException4	org.json.JSONException
    //   9707	795	20	localObject4	Object
    //   439	10061	21	localObject5	Object
    //   73	9196	22	localObject6	Object
    //   2525	5720	23	localObject7	Object
    //   2535	5383	24	str1	String
    //   2530	5396	25	str2	String
    //   2388	3040	26	str3	String
    //   2503	2890	27	str4	String
    //   2515	203	28	localApkgInfo2	ApkgInfo
    // Exception table:
    //   from	to	target	type
    //   740	1001	1051	java/lang/Exception
    //   1005	1015	1051	java/lang/Exception
    //   1015	1026	1051	java/lang/Exception
    //   1029	1048	1051	java/lang/Exception
    //   1412	1422	1051	java/lang/Exception
    //   676	740	1396	org/json/JSONException
    //   1492	1507	1592	java/lang/Exception
    //   1511	1518	1592	java/lang/Exception
    //   1521	1559	1592	java/lang/Exception
    //   1640	1721	1724	org/json/JSONException
    //   1738	1804	1724	org/json/JSONException
    //   1917	1994	2052	java/lang/Exception
    //   1994	2021	2052	java/lang/Exception
    //   2025	2036	2052	java/lang/Exception
    //   2036	2049	2052	java/lang/Exception
    //   2074	2082	2052	java/lang/Exception
    //   2089	2109	2052	java/lang/Exception
    //   2112	2132	2052	java/lang/Exception
    //   2135	2157	2052	java/lang/Exception
    //   2160	2212	2052	java/lang/Exception
    //   2215	2285	2052	java/lang/Exception
    //   2285	2306	2052	java/lang/Exception
    //   2306	2318	2052	java/lang/Exception
    //   2323	2328	2052	java/lang/Exception
    //   2331	2361	2052	java/lang/Exception
    //   2364	2390	2052	java/lang/Exception
    //   2393	2424	2052	java/lang/Exception
    //   2424	2442	2052	java/lang/Exception
    //   2444	2465	2052	java/lang/Exception
    //   2465	2517	2052	java/lang/Exception
    //   2550	2558	2052	java/lang/Exception
    //   2562	2573	2052	java/lang/Exception
    //   2577	2604	2052	java/lang/Exception
    //   2625	2633	2052	java/lang/Exception
    //   2641	2681	2052	java/lang/Exception
    //   2694	2702	2052	java/lang/Exception
    //   2706	2730	2052	java/lang/Exception
    //   2730	2771	2052	java/lang/Exception
    //   2774	2796	2052	java/lang/Exception
    //   2799	2841	2052	java/lang/Exception
    //   2855	2867	2052	java/lang/Exception
    //   2870	2910	2052	java/lang/Exception
    //   2285	2306	2321	org/json/JSONException
    //   3115	3145	3333	org/json/JSONException
    //   3168	3185	3333	org/json/JSONException
    //   3185	3195	3333	org/json/JSONException
    //   3198	3208	3333	org/json/JSONException
    //   3211	3221	3333	org/json/JSONException
    //   3224	3233	3333	org/json/JSONException
    //   3748	3803	3848	org/json/JSONException
    //   3807	3829	3848	org/json/JSONException
    //   3829	3845	3848	org/json/JSONException
    //   3867	3883	3848	org/json/JSONException
    //   3886	3943	3848	org/json/JSONException
    //   3946	3962	3848	org/json/JSONException
    //   3974	4002	4031	org/json/JSONException
    //   4016	4028	4031	org/json/JSONException
    //   4080	4089	4710	org/json/JSONException
    //   4092	4113	4710	org/json/JSONException
    //   4129	4167	4710	org/json/JSONException
    //   4170	4193	4710	org/json/JSONException
    //   4193	4232	4710	org/json/JSONException
    //   4232	4242	4710	org/json/JSONException
    //   4246	4264	4710	org/json/JSONException
    //   4264	4294	4710	org/json/JSONException
    //   4298	4313	4710	org/json/JSONException
    //   4318	4356	4710	org/json/JSONException
    //   4356	4380	4710	org/json/JSONException
    //   4380	4402	4710	org/json/JSONException
    //   4402	4430	4710	org/json/JSONException
    //   4442	4451	4710	org/json/JSONException
    //   4455	4527	4710	org/json/JSONException
    //   4532	4558	4710	org/json/JSONException
    //   4569	4601	4710	org/json/JSONException
    //   4605	4617	4710	org/json/JSONException
    //   4620	4634	4710	org/json/JSONException
    //   4637	4663	4710	org/json/JSONException
    //   4675	4684	4710	org/json/JSONException
    //   4692	4707	4710	org/json/JSONException
    //   4729	4758	4710	org/json/JSONException
    //   4761	4779	4710	org/json/JSONException
    //   4782	4836	4710	org/json/JSONException
    //   4839	4863	4710	org/json/JSONException
    //   4866	4891	4710	org/json/JSONException
    //   4891	4915	4710	org/json/JSONException
    //   4915	4946	4710	org/json/JSONException
    //   4950	4975	4710	org/json/JSONException
    //   4975	4999	4710	org/json/JSONException
    //   4999	5030	4710	org/json/JSONException
    //   5034	5050	4710	org/json/JSONException
    //   5053	5099	4710	org/json/JSONException
    //   5102	5110	4710	org/json/JSONException
    //   5120	5140	4710	org/json/JSONException
    //   5149	5231	4710	org/json/JSONException
    //   5234	5266	4710	org/json/JSONException
    //   5270	5306	4710	org/json/JSONException
    //   5309	5331	4710	org/json/JSONException
    //   5331	5339	4710	org/json/JSONException
    //   5348	5375	4710	org/json/JSONException
    //   5378	5407	4710	org/json/JSONException
    //   5416	5443	4710	org/json/JSONException
    //   5471	5490	5737	org/json/JSONException
    //   5501	5510	5737	org/json/JSONException
    //   5523	5546	5737	org/json/JSONException
    //   5546	5569	5737	org/json/JSONException
    //   5569	5608	5737	org/json/JSONException
    //   5608	5663	5737	org/json/JSONException
    //   5666	5714	5737	org/json/JSONException
    //   5722	5734	5737	org/json/JSONException
    //   5793	5808	5737	org/json/JSONException
    //   5811	5826	5737	org/json/JSONException
    //   5829	5858	5737	org/json/JSONException
    //   5861	5868	5737	org/json/JSONException
    //   5878	5885	5737	org/json/JSONException
    //   5889	5904	5737	org/json/JSONException
    //   5907	5916	5737	org/json/JSONException
    //   5919	5951	5737	org/json/JSONException
    //   5955	5981	5737	org/json/JSONException
    //   5994	6004	5737	org/json/JSONException
    //   6033	6051	6142	org/json/JSONException
    //   6067	6079	6142	org/json/JSONException
    //   6088	6093	6142	org/json/JSONException
    //   6098	6103	6142	org/json/JSONException
    //   6108	6113	6142	org/json/JSONException
    //   6118	6123	6142	org/json/JSONException
    //   6123	6139	6142	org/json/JSONException
    //   6165	6182	6142	org/json/JSONException
    //   6182	6192	6142	org/json/JSONException
    //   6195	6205	6142	org/json/JSONException
    //   6208	6218	6142	org/json/JSONException
    //   6221	6231	6142	org/json/JSONException
    //   6237	6253	6142	org/json/JSONException
    //   6256	6282	6142	org/json/JSONException
    //   6287	6301	6142	org/json/JSONException
    //   6306	6320	6142	org/json/JSONException
    //   6325	6339	6142	org/json/JSONException
    //   6344	6358	6142	org/json/JSONException
    //   6358	6374	6142	org/json/JSONException
    //   6377	6393	6142	org/json/JSONException
    //   6449	6469	6572	java/lang/Throwable
    //   6473	6488	6572	java/lang/Throwable
    //   6488	6505	6572	java/lang/Throwable
    //   6510	6536	6572	java/lang/Throwable
    //   6541	6569	6572	java/lang/Throwable
    //   6592	6601	6572	java/lang/Throwable
    //   6611	6627	6572	java/lang/Throwable
    //   6631	6647	6572	java/lang/Throwable
    //   6656	6668	6572	java/lang/Throwable
    //   6671	6683	6572	java/lang/Throwable
    //   6686	6698	6572	java/lang/Throwable
    //   6710	6850	6853	org/json/JSONException
    //   6881	6928	6931	org/json/JSONException
    //   7056	7066	7097	org/json/JSONException
    //   7000	7032	7116	org/json/JSONException
    //   7036	7041	7116	org/json/JSONException
    //   7041	7056	7116	org/json/JSONException
    //   7066	7097	7116	org/json/JSONException
    //   7098	7113	7116	org/json/JSONException
    //   7374	7406	7535	org/json/JSONException
    //   7410	7426	7535	org/json/JSONException
    //   7429	7449	7535	org/json/JSONException
    //   7458	7475	7535	org/json/JSONException
    //   7479	7502	7535	org/json/JSONException
    //   7502	7532	7535	org/json/JSONException
    //   7593	7684	7995	org/json/JSONException
    //   7688	7725	7995	org/json/JSONException
    //   7734	7749	7995	org/json/JSONException
    //   7753	7776	7995	org/json/JSONException
    //   7780	7797	7995	org/json/JSONException
    //   7800	7829	7995	org/json/JSONException
    //   7833	7848	7995	org/json/JSONException
    //   7855	7873	7995	org/json/JSONException
    //   7879	7908	7995	org/json/JSONException
    //   7914	7932	7995	org/json/JSONException
    //   7935	7993	7995	org/json/JSONException
    //   8139	8150	8344	org/json/JSONException
    //   8152	8173	8344	org/json/JSONException
    //   8175	8227	8344	org/json/JSONException
    //   8229	8317	8344	org/json/JSONException
    //   8317	8323	8344	org/json/JSONException
    //   8326	8332	8344	org/json/JSONException
    //   8335	8341	8344	org/json/JSONException
    //   8387	8454	8936	java/lang/Throwable
    //   8456	8480	8936	java/lang/Throwable
    //   8485	8519	8936	java/lang/Throwable
    //   8521	8558	8936	java/lang/Throwable
    //   8560	8574	8936	java/lang/Throwable
    //   8574	8584	8936	java/lang/Throwable
    //   8584	8614	8936	java/lang/Throwable
    //   8624	8717	8936	java/lang/Throwable
    //   8720	8728	8936	java/lang/Throwable
    //   8732	8774	8936	java/lang/Throwable
    //   8774	8933	8936	java/lang/Throwable
    //   8952	8984	8936	java/lang/Throwable
    //   8991	9006	8936	java/lang/Throwable
    //   9009	9029	8936	java/lang/Throwable
    //   8574	8584	8951	java/io/UnsupportedEncodingException
    //   9041	9082	9136	java/lang/Throwable
    //   9086	9109	9136	java/lang/Throwable
    //   9109	9133	9136	java/lang/Throwable
    //   9167	9197	9316	java/lang/Throwable
    //   9201	9208	9316	java/lang/Throwable
    //   9211	9274	9316	java/lang/Throwable
    //   9283	9313	9316	java/lang/Throwable
    //   9355	9379	9449	java/lang/Throwable
    //   9383	9390	9449	java/lang/Throwable
    //   9393	9417	9449	java/lang/Throwable
    //   9426	9446	9449	java/lang/Throwable
    //   9485	9509	9524	org/json/JSONException
    //   9552	9564	9662	org/json/JSONException
    //   9580	9588	9662	org/json/JSONException
    //   9592	9603	9662	org/json/JSONException
    //   9607	9637	9662	org/json/JSONException
    //   9637	9647	9662	org/json/JSONException
    //   9682	9718	9948	org/json/JSONException
    //   9734	9742	9948	org/json/JSONException
    //   9746	9757	9948	org/json/JSONException
    //   9761	9791	9948	org/json/JSONException
    //   9791	9802	9948	org/json/JSONException
    //   9807	9840	9948	org/json/JSONException
    //   9844	9945	9948	org/json/JSONException
    //   9956	9969	9948	org/json/JSONException
    //   9982	10023	10164	org/json/JSONException
    //   10028	10061	10164	org/json/JSONException
    //   10065	10103	10164	org/json/JSONException
    //   10108	10161	10164	org/json/JSONException
    //   10216	10268	10271	java/lang/Throwable
  }
  
  public void login(admy paramadmy)
  {
    if (paramadmy == null) {
      return;
    }
    ThreadManager.excute(new DataJsPlugin.27(this, paramadmy), 16, null, false);
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    getOpenUrlDomainWhiteList();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.mGgtAppReceiver != null) && (this.jsPluginEngine != null) && (this.jsPluginEngine.getActivityContext() != null))
    {
      this.mGgtAppReceiver.unregister(this.jsPluginEngine.getActivityContext());
      this.mGgtAppReceiver = null;
    }
    this.cacheCallbackId2JsRuntime.clear();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin
 * JD-Core Version:    0.7.0.1
 */