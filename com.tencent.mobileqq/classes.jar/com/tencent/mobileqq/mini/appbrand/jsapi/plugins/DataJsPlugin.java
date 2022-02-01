package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import abrk;
import acjr;
import acju;
import acjz;
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
import xvv;

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
  private acju apiManager;
  private Map<Integer, JsRuntime> cacheCallbackId2JsRuntime = new HashMap();
  private Long lastNotRspReqTime = Long.valueOf(0L);
  private List<acjr> loginCallBacks = new LinkedList();
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
      xvv.b("[mini] DataJsPlugin", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label45:
      xvv.b("[mini] DataJsPlugin", "start load URLDrawable.");
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
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
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
    acjz.a();
    this.apiManager = acjz.a(this.jsPluginEngine.getActivityContext(), paramInt, paramString);
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
    //   306: invokestatic 990	com/tencent/mobileqq/utils/ViewUtils:dpToPx	(F)I
    //   309: i2d
    //   310: dload 5
    //   312: ddiv
    //   313: ldc2_w 991
    //   316: dadd
    //   317: d2i
    //   318: istore 9
    //   320: ldc_w 993
    //   323: invokestatic 990	com/tencent/mobileqq/utils/ViewUtils:dpToPx	(F)I
    //   326: i2d
    //   327: dload 5
    //   329: ddiv
    //   330: ldc2_w 991
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
    //   364: invokevirtual 997	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   367: ifnull +787 -> 1154
    //   370: aload_0
    //   371: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   374: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   377: invokevirtual 997	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   380: invokevirtual 1002	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   383: ifnull +771 -> 1154
    //   386: aload_0
    //   387: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   390: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   393: invokevirtual 997	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   396: invokevirtual 1002	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   399: astore 20
    //   401: aload 20
    //   403: astore_2
    //   404: aload 20
    //   406: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   409: ifne +9887 -> 10296
    //   412: aload_0
    //   413: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   416: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   419: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   422: invokevirtual 1006	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   425: aload 20
    //   427: invokevirtual 1012	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   430: getfield 1018	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   433: getfield 1024	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   436: getfield 1029	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   439: astore 21
    //   441: aload 20
    //   443: astore_2
    //   444: aload_0
    //   445: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   448: ifnull +9842 -> 10290
    //   451: aload_0
    //   452: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   455: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   458: ifnull +9832 -> 10290
    //   461: aload_0
    //   462: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   465: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   468: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   471: ifnull +9819 -> 10290
    //   474: aload_0
    //   475: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   478: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   481: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   484: invokevirtual 1006	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   487: ifnull +9803 -> 10290
    //   490: aload_0
    //   491: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   494: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   497: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   500: invokevirtual 1006	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   503: getfield 1033	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   506: ifnull +857 -> 1363
    //   509: aload_0
    //   510: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   513: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   516: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   519: aload_2
    //   520: invokevirtual 1036	com/tencent/mobileqq/mini/apkg/ApkgInfo:isTabBarPage	(Ljava/lang/String;)Z
    //   523: ifeq +840 -> 1363
    //   526: aload_0
    //   527: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   530: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   533: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   536: invokevirtual 1006	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   539: getfield 1033	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   542: invokevirtual 1041	com/tencent/mobileqq/mini/apkg/TabBarInfo:isShow	()Z
    //   545: ifeq +818 -> 1363
    //   548: iconst_1
    //   549: istore 16
    //   551: ldc_w 1043
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
    //   580: invokestatic 1046	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   583: ifeq +63 -> 646
    //   586: ldc 150
    //   588: iconst_1
    //   589: new 419	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   596: ldc_w 1048
    //   599: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: iload 8
    //   604: invokevirtual 771	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   607: ldc_w 1050
    //   610: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 21
    //   615: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 1052
    //   621: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: iload 16
    //   626: invokevirtual 1055	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   629: ldc_w 1057
    //   632: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: iload 15
    //   637: invokevirtual 1055	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   640: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: aload 22
    //   648: aload 22
    //   650: invokestatic 1063	cooperation/qzone/util/SystemUtil:getNotchHeight	(Landroid/content/Context;Landroid/app/Activity;)I
    //   653: istore 11
    //   655: iload 11
    //   657: istore 9
    //   659: iload 11
    //   661: ifne +7 -> 668
    //   664: iload 10
    //   666: istore 9
    //   668: new 371	org/json/JSONObject
    //   671: dup
    //   672: invokespecial 1064	org/json/JSONObject:<init>	()V
    //   675: astore_2
    //   676: aload_2
    //   677: ldc_w 1066
    //   680: iconst_0
    //   681: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   684: pop
    //   685: aload_2
    //   686: ldc_w 1071
    //   689: iload 9
    //   691: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   694: pop
    //   695: aload_2
    //   696: ldc_w 1073
    //   699: iload 12
    //   701: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   704: pop
    //   705: aload_2
    //   706: ldc_w 1075
    //   709: iload 7
    //   711: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   714: pop
    //   715: aload_2
    //   716: ldc_w 1077
    //   719: iload 12
    //   721: iconst_0
    //   722: isub
    //   723: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   726: pop
    //   727: aload_2
    //   728: ldc_w 1079
    //   731: iload 7
    //   733: iload 9
    //   735: isub
    //   736: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   739: pop
    //   740: invokestatic 1085	com/tencent/mobileqq/mini/app/AppLoaderFactory:getAppLoaderManager	()Lcom/tencent/mobileqq/mini/app/BaseAppLoaderManager;
    //   743: invokeinterface 1091 1 0
    //   748: getfield 1096	com/tencent/mobileqq/mini/sdk/BaseLibInfo:baseLibVersion	Ljava/lang/String;
    //   751: astore 21
    //   753: new 371	org/json/JSONObject
    //   756: dup
    //   757: invokespecial 1064	org/json/JSONObject:<init>	()V
    //   760: astore 20
    //   762: aload 20
    //   764: ldc_w 1098
    //   767: getstatic 1101	android/os/Build:BRAND	Ljava/lang/String;
    //   770: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   773: pop
    //   774: aload 20
    //   776: ldc_w 1106
    //   779: getstatic 1109	android/os/Build:MODEL	Ljava/lang/String;
    //   782: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   785: pop
    //   786: aload 20
    //   788: ldc_w 1111
    //   791: dload 5
    //   793: invokevirtual 1114	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   796: pop
    //   797: aload 20
    //   799: ldc_w 1116
    //   802: iload 12
    //   804: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   807: pop
    //   808: aload 20
    //   810: ldc_w 1118
    //   813: iload 7
    //   815: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   818: pop
    //   819: aload 20
    //   821: ldc_w 1120
    //   824: iload 12
    //   826: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   829: pop
    //   830: aload 20
    //   832: ldc_w 1122
    //   835: iload 8
    //   837: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   840: pop
    //   841: aload 20
    //   843: ldc_w 1124
    //   846: iload 10
    //   848: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   851: pop
    //   852: aload 20
    //   854: ldc_w 1126
    //   857: ldc_w 1128
    //   860: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   863: pop
    //   864: aload 20
    //   866: ldc_w 1130
    //   869: invokestatic 1135	com/tencent/mobileqq/utils/DeviceInfoUtil:getQQVersion	()Ljava/lang/String;
    //   872: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   875: pop
    //   876: aload 20
    //   878: ldc_w 1137
    //   881: new 419	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   888: ldc_w 1139
    //   891: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: getstatic 1142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   897: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   906: pop
    //   907: aload 20
    //   909: ldc_w 1144
    //   912: ldc_w 1146
    //   915: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   918: pop
    //   919: aload 20
    //   921: ldc_w 1148
    //   924: bipush 16
    //   926: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   929: pop
    //   930: aload 20
    //   932: ldc_w 1150
    //   935: aload 21
    //   937: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   940: pop
    //   941: aload 20
    //   943: ldc_w 1152
    //   946: ldc 124
    //   948: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   951: pop
    //   952: aload 20
    //   954: ldc_w 1154
    //   957: aload_2
    //   958: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   961: pop
    //   962: aload_0
    //   963: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   966: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   969: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   972: invokevirtual 1006	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   975: getfield 1157	com/tencent/mobileqq/mini/apkg/AppConfigInfo:darkmode	Z
    //   978: ifeq +37 -> 1015
    //   981: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   984: invokevirtual 1161	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   987: invokestatic 1167	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   990: astore_2
    //   991: ldc_w 1169
    //   994: aload_2
    //   995: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   998: ifeq +414 -> 1412
    //   1001: ldc_w 1171
    //   1004: astore_2
    //   1005: aload 20
    //   1007: ldc_w 1173
    //   1010: aload_2
    //   1011: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1014: pop
    //   1015: aload_1
    //   1016: aload 20
    //   1018: invokestatic 1176	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
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
    //   1062: ldc_w 1178
    //   1065: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: new 253	java/lang/Throwable
    //   1071: dup
    //   1072: aload_2
    //   1073: invokespecial 1181	java/lang/Throwable:<init>	(Ljava/lang/Throwable;)V
    //   1076: invokevirtual 1184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
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
    //   1110: invokevirtual 1188	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1113: invokevirtual 1194	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1116: astore_2
    //   1117: goto -923 -> 194
    //   1120: aload 22
    //   1122: invokestatic 1197	com/tencent/mobileqq/mini/util/DisplayUtil:hasNavBar	(Landroid/content/Context;)Z
    //   1125: ifeq +11 -> 1136
    //   1128: aload 22
    //   1130: invokestatic 1201	com/tencent/mobileqq/mini/util/DisplayUtil:isNavigationBarExist	(Landroid/app/Activity;)Z
    //   1133: ifne +9 -> 1142
    //   1136: invokestatic 1204	com/tencent/mobileqq/mini/util/DisplayUtil:isFlymeOS7NavBarShow	()Z
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
    //   1161: ifnull +9135 -> 10296
    //   1164: aload 20
    //   1166: astore_2
    //   1167: aload_0
    //   1168: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1171: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1174: ifnull +9122 -> 10296
    //   1177: aload 20
    //   1179: astore_2
    //   1180: aload_0
    //   1181: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1184: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1187: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1190: ifnull +9106 -> 10296
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
    //   1270: getfield 1208	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1273: ifnull +21 -> 1294
    //   1276: aload_0
    //   1277: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1280: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1283: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1286: getfield 1208	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1289: getfield 1211	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   1292: astore 20
    //   1294: aload_0
    //   1295: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1298: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1301: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1304: aload_2
    //   1305: invokevirtual 1214	com/tencent/mobileqq/mini/apkg/ApkgInfo:isUrlFileExist	(Ljava/lang/String;)Z
    //   1308: ifne +49 -> 1357
    //   1311: aload 20
    //   1313: astore_2
    //   1314: aload 20
    //   1316: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1319: ifne +8977 -> 10296
    //   1322: aload_0
    //   1323: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1326: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1329: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1332: invokevirtual 1006	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1335: aload 20
    //   1337: invokevirtual 1012	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   1340: getfield 1018	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   1343: getfield 1024	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   1346: getfield 1029	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
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
    //   1401: ldc_w 1216
    //   1404: aload 20
    //   1406: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1409: goto -669 -> 740
    //   1412: ldc_w 1218
    //   1415: aload_2
    //   1416: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1419: ifeq +10 -> 1429
    //   1422: ldc_w 1220
    //   1425: astore_2
    //   1426: goto -421 -> 1005
    //   1429: ldc_w 1171
    //   1432: astore_2
    //   1433: goto -428 -> 1005
    //   1436: ldc 150
    //   1438: iconst_1
    //   1439: ldc_w 1222
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
    //   1468: ldc_w 1224
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
    //   1500: ldc_w 1226
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
    //   1527: ldc_w 1228
    //   1530: new 419	java/lang/StringBuilder
    //   1533: dup
    //   1534: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   1537: ldc_w 1230
    //   1540: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: aload_1
    //   1544: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1550: invokestatic 1236	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1553: invokespecial 1239	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1556: invokevirtual 1243	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1559: iload 7
    //   1561: ifeq +38 -> 1599
    //   1564: ldc_w 1224
    //   1567: aconst_null
    //   1568: invokestatic 1176	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
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
    //   1599: ldc_w 1224
    //   1602: aconst_null
    //   1603: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1606: astore_1
    //   1607: goto -35 -> 1572
    //   1610: ldc_w 1245
    //   1613: aload_1
    //   1614: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1617: ifeq +190 -> 1807
    //   1620: ldc 150
    //   1622: iconst_2
    //   1623: iconst_2
    //   1624: anewarray 904	java/lang/Object
    //   1627: dup
    //   1628: iconst_0
    //   1629: ldc_w 1246
    //   1632: aastore
    //   1633: dup
    //   1634: iconst_1
    //   1635: aload_2
    //   1636: aastore
    //   1637: invokestatic 1249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
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
    //   1660: ldc_w 1251
    //   1663: ldc_w 545
    //   1666: invokevirtual 1253	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1669: astore 21
    //   1671: aload 20
    //   1673: ldc_w 1255
    //   1676: iconst_1
    //   1677: invokevirtual 1258	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1680: pop
    //   1681: ldc_w 1260
    //   1684: aload 21
    //   1686: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1689: ifeq +49 -> 1738
    //   1692: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1695: aload_0
    //   1696: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1699: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1702: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1705: new 1262	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2
    //   1708: dup
    //   1709: aload_0
    //   1710: aload_3
    //   1711: aload_1
    //   1712: iload 4
    //   1714: aload_2
    //   1715: invokespecial 1265	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILorg/json/JSONObject;)V
    //   1718: invokevirtual 1267	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getPhoneNumber	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1721: goto -133 -> 1588
    //   1724: astore_1
    //   1725: ldc 150
    //   1727: iconst_2
    //   1728: ldc_w 1246
    //   1731: aload_1
    //   1732: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1735: goto -147 -> 1588
    //   1738: ldc 150
    //   1740: iconst_1
    //   1741: new 419	java/lang/StringBuilder
    //   1744: dup
    //   1745: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   1748: ldc_w 1269
    //   1751: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1754: aload 21
    //   1756: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: ldc_w 1271
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
    //   1790: ldc_w 1271
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
    //   1826: ldc_w 1273
    //   1829: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: iload 4
    //   1834: invokevirtual 771	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1837: ldc_w 1275
    //   1840: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: aload_0
    //   1844: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1847: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1850: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1853: getfield 1208	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1856: getfield 1278	com/tencent/mobileqq/mini/apkg/AppConfigInfo:PackageToolVersion	Ljava/lang/String;
    //   1859: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1865: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1868: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1871: aload_0
    //   1872: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1875: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1878: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1881: new 1280	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3
    //   1884: dup
    //   1885: aload_0
    //   1886: aload_3
    //   1887: aload_1
    //   1888: iload 4
    //   1890: invokespecial 1281	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1893: invokevirtual 684	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getLoginCode	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1896: goto -308 -> 1588
    //   1899: ldc_w 1283
    //   1902: aload_1
    //   1903: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1906: ifeq +1007 -> 2913
    //   1909: new 371	org/json/JSONObject
    //   1912: dup
    //   1913: invokespecial 1064	org/json/JSONObject:<init>	()V
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
    //   1937: ldc_w 1251
    //   1940: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1943: astore 21
    //   1945: ldc 150
    //   1947: iconst_2
    //   1948: new 419	java/lang/StringBuilder
    //   1951: dup
    //   1952: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   1955: ldc_w 1285
    //   1958: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1961: aload 21
    //   1963: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1972: ldc_w 1287
    //   1975: aload 21
    //   1977: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1980: ifne +14 -> 1994
    //   1983: ldc_w 1289
    //   1986: aload 21
    //   1988: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1991: ifeq +98 -> 2089
    //   1994: aload_2
    //   1995: ldc_w 1255
    //   1998: invokevirtual 656	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   2001: istore 15
    //   2003: aload_2
    //   2004: ldc_w 658
    //   2007: aconst_null
    //   2008: invokevirtual 1253	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2011: astore 20
    //   2013: aload_2
    //   2014: ldc_w 499
    //   2017: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2020: astore_2
    //   2021: aload_2
    //   2022: ifnull +49 -> 2071
    //   2025: aload_2
    //   2026: ldc_w 658
    //   2029: ldc_w 1291
    //   2032: invokevirtual 1253	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2035: astore_2
    //   2036: aload_0
    //   2037: aload_3
    //   2038: aload_1
    //   2039: aload 21
    //   2041: iload 4
    //   2043: iload 15
    //   2045: aload_2
    //   2046: invokevirtual 1293	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getUserInfo	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V
    //   2049: goto -461 -> 1588
    //   2052: astore_1
    //   2053: ldc 150
    //   2055: iconst_1
    //   2056: aload_1
    //   2057: iconst_0
    //   2058: anewarray 904	java/lang/Object
    //   2061: invokestatic 1296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2064: aload_1
    //   2065: invokevirtual 668	java/lang/Exception:printStackTrace	()V
    //   2068: goto -480 -> 1588
    //   2071: aload 20
    //   2073: astore_2
    //   2074: aload 20
    //   2076: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2079: ifeq -43 -> 2036
    //   2082: ldc_w 1291
    //   2085: astore_2
    //   2086: goto -50 -> 2036
    //   2089: ldc_w 1298
    //   2092: aload 21
    //   2094: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2097: ifeq +15 -> 2112
    //   2100: aload_0
    //   2101: aload_2
    //   2102: aload_3
    //   2103: aload_1
    //   2104: iload 4
    //   2106: invokespecial 1300	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleWebapiPluginSetauth	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2109: goto -521 -> 1588
    //   2112: ldc_w 1302
    //   2115: aload 21
    //   2117: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2120: ifeq +15 -> 2135
    //   2123: aload_0
    //   2124: aload_2
    //   2125: aload_3
    //   2126: aload_1
    //   2127: iload 4
    //   2129: invokespecial 1304	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleWebapiPluginLogin	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2132: goto -544 -> 1588
    //   2135: ldc_w 1306
    //   2138: aload 21
    //   2140: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2143: ifeq +17 -> 2160
    //   2146: aload_0
    //   2147: aload_2
    //   2148: aload_3
    //   2149: aload_1
    //   2150: iload 4
    //   2152: aload 21
    //   2154: invokespecial 1308	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleWebapiPluginGetuserinfo	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILjava/lang/String;)V
    //   2157: goto -569 -> 1588
    //   2160: ldc_w 1310
    //   2163: aload 21
    //   2165: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2168: ifeq +47 -> 2215
    //   2171: new 1312	Wallet/IsUinFocusMpIdReq
    //   2174: dup
    //   2175: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2178: invokevirtual 1161	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   2181: invokevirtual 1317	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   2184: aload_0
    //   2185: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2188: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2191: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2194: invokespecial 1319	Wallet/IsUinFocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   2197: new 1321	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4
    //   2200: dup
    //   2201: aload_0
    //   2202: aload_3
    //   2203: aload_1
    //   2204: iload 4
    //   2206: invokespecial 1322	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2209: invokestatic 1327	ajvh:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   2212: goto -624 -> 1588
    //   2215: ldc_w 1329
    //   2218: aload 21
    //   2220: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2223: ifeq +141 -> 2364
    //   2226: aload 20
    //   2228: ldc_w 1331
    //   2231: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2234: ldc_w 1333
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
    //   2262: ldc_w 1335
    //   2265: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2268: new 371	org/json/JSONObject
    //   2271: dup
    //   2272: invokespecial 1064	org/json/JSONObject:<init>	()V
    //   2275: astore_2
    //   2276: new 371	org/json/JSONObject
    //   2279: dup
    //   2280: invokespecial 1064	org/json/JSONObject:<init>	()V
    //   2283: astore 20
    //   2285: aload 20
    //   2287: ldc_w 499
    //   2290: ldc 156
    //   2292: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2295: pop
    //   2296: aload_2
    //   2297: ldc_w 1337
    //   2300: aload 20
    //   2302: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
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
    //   2325: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   2328: goto -22 -> 2306
    //   2331: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2334: aload_0
    //   2335: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2338: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2341: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2344: aload_2
    //   2345: aconst_null
    //   2346: new 1340	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5
    //   2349: dup
    //   2350: aload_0
    //   2351: aload_3
    //   2352: aload_1
    //   2353: iload 4
    //   2355: invokespecial 1341	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2358: invokevirtual 1344	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkNavigateRight	(Ljava/lang/String;Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2361: goto -773 -> 1588
    //   2364: ldc_w 1346
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
    //   2475: ldc_w 1348
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
    //   2774: ldc_w 1350
    //   2777: aload 21
    //   2779: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2782: ifeq +17 -> 2799
    //   2785: aload_0
    //   2786: aload_2
    //   2787: aload_3
    //   2788: aload_1
    //   2789: iload 4
    //   2791: bipush 12
    //   2793: invokespecial 1352	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleAdApi	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;II)V
    //   2796: goto -1208 -> 1588
    //   2799: ldc_w 1354
    //   2802: aload 21
    //   2804: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2807: ifeq +63 -> 2870
    //   2810: aload_2
    //   2811: ldc_w 499
    //   2814: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2817: ldc_w 1356
    //   2820: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2823: astore 20
    //   2825: aload_2
    //   2826: ldc_w 499
    //   2829: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2832: ldc_w 1358
    //   2835: iconst_0
    //   2836: invokevirtual 1361	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
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
    //   2864: invokespecial 1363	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2867: goto -1279 -> 1588
    //   2870: ldc_w 1365
    //   2873: aload 21
    //   2875: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2878: ifeq -1290 -> 1588
    //   2881: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2884: aload_0
    //   2885: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2888: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2891: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2894: aconst_null
    //   2895: new 1367	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6
    //   2898: dup
    //   2899: aload_0
    //   2900: aload_3
    //   2901: aload_1
    //   2902: iload 4
    //   2904: invokespecial 1368	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2907: invokevirtual 1372	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserHealthData	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
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
    //   2935: new 1374	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7
    //   2938: dup
    //   2939: aload_0
    //   2940: aload_3
    //   2941: aload_1
    //   2942: iload 4
    //   2944: invokespecial 1375	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2947: invokevirtual 1378	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkSession	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2950: goto -1362 -> 1588
    //   2953: ldc 86
    //   2955: aload_1
    //   2956: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2959: ifne +12 -> 2971
    //   2962: ldc 89
    //   2964: aload_1
    //   2965: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2968: ifeq +719 -> 3687
    //   2971: aload_0
    //   2972: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2975: ifnull +700 -> 3675
    //   2978: aload_0
    //   2979: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2982: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2985: ifnull +662 -> 3647
    //   2988: iconst_m1
    //   2989: istore 9
    //   2991: aload_2
    //   2992: ifnull +23 -> 3015
    //   2995: ldc_w 1380
    //   2998: aload_2
    //   2999: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3002: ifne +13 -> 3015
    //   3005: ldc_w 1382
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
    //   3031: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3034: ifeq +386 -> 3420
    //   3037: aload_0
    //   3038: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3041: astore_2
    //   3042: aload_2
    //   3043: ifnull +358 -> 3401
    //   3046: iload 13
    //   3048: iconst_1
    //   3049: if_icmpne +320 -> 3369
    //   3052: aload_2
    //   3053: iconst_1
    //   3054: putfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3057: iload 12
    //   3059: iconst_1
    //   3060: if_icmpne +317 -> 3377
    //   3063: aload_2
    //   3064: iconst_1
    //   3065: putfield 1397	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3068: iload 9
    //   3070: iconst_1
    //   3071: if_icmpne +314 -> 3385
    //   3074: aload_2
    //   3075: iconst_1
    //   3076: putfield 1400	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3079: iload 7
    //   3081: iconst_1
    //   3082: if_icmpne +311 -> 3393
    //   3085: aload_2
    //   3086: iconst_1
    //   3087: putfield 1403	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3090: aload_2
    //   3091: iload 15
    //   3093: putfield 1406	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3096: aload_0
    //   3097: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3100: aload_3
    //   3101: aload_1
    //   3102: aload_1
    //   3103: aconst_null
    //   3104: invokestatic 1176	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3107: iload 4
    //   3109: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3112: goto -1524 -> 1588
    //   3115: new 371	org/json/JSONObject
    //   3118: dup
    //   3119: aload_2
    //   3120: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3123: astore_2
    //   3124: aload_2
    //   3125: ldc_w 1407
    //   3128: iconst_0
    //   3129: invokevirtual 1258	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3132: istore 16
    //   3134: aload_2
    //   3135: ldc_w 1409
    //   3138: invokevirtual 1412	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   3141: checkcast 382	org/json/JSONArray
    //   3144: astore_2
    //   3145: aload_2
    //   3146: ifnonnull +7158 -> 10304
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
    //   3171: invokevirtual 1415	org/json/JSONArray:length	()I
    //   3174: if_icmpge +76 -> 3250
    //   3177: aload_2
    //   3178: iload 10
    //   3180: invokevirtual 1417	org/json/JSONArray:getString	(I)Ljava/lang/String;
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
    //   3279: if_icmpne +7004 -> 10283
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
    //   3335: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   3338: ldc 150
    //   3340: iconst_1
    //   3341: aload_2
    //   3342: iconst_0
    //   3343: anewarray 904	java/lang/Object
    //   3346: invokestatic 1296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3349: aload_0
    //   3350: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3353: aload_3
    //   3354: aload_1
    //   3355: aload_1
    //   3356: aconst_null
    //   3357: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3360: iload 4
    //   3362: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3365: ldc_w 545
    //   3368: areturn
    //   3369: aload_2
    //   3370: iconst_0
    //   3371: putfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3374: goto -317 -> 3057
    //   3377: aload_2
    //   3378: iconst_0
    //   3379: putfield 1397	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3382: goto -314 -> 3068
    //   3385: aload_2
    //   3386: iconst_0
    //   3387: putfield 1400	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3390: goto -311 -> 3079
    //   3393: aload_2
    //   3394: iconst_0
    //   3395: putfield 1403	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3398: goto -308 -> 3090
    //   3401: aload_0
    //   3402: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3405: aload_3
    //   3406: aload_1
    //   3407: aload_1
    //   3408: aconst_null
    //   3409: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3412: iload 4
    //   3414: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3417: goto -1829 -> 1588
    //   3420: aload_0
    //   3421: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3424: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3427: invokevirtual 1421	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3430: ifnull +198 -> 3628
    //   3433: aload_0
    //   3434: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3437: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3440: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3443: ifnull +185 -> 3628
    //   3446: iload 13
    //   3448: iconst_1
    //   3449: if_icmpne +111 -> 3560
    //   3452: aload_0
    //   3453: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3456: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3459: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3462: iconst_1
    //   3463: putfield 1428	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3466: iload 12
    //   3468: iconst_1
    //   3469: if_icmpne +108 -> 3577
    //   3472: aload_0
    //   3473: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3476: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3479: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3482: iconst_1
    //   3483: putfield 1429	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3486: iload 9
    //   3488: iconst_1
    //   3489: if_icmpne +105 -> 3594
    //   3492: aload_0
    //   3493: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3496: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3499: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3502: iconst_1
    //   3503: putfield 1430	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3506: iload 7
    //   3508: iconst_1
    //   3509: if_icmpne +102 -> 3611
    //   3512: aload_0
    //   3513: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3516: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3519: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3522: iconst_1
    //   3523: putfield 1431	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3526: aload_0
    //   3527: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3530: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3533: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3536: iload 15
    //   3538: putfield 1432	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3541: aload_0
    //   3542: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3545: aload_3
    //   3546: aload_1
    //   3547: aload_1
    //   3548: aconst_null
    //   3549: invokestatic 1176	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3552: iload 4
    //   3554: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3557: goto -1969 -> 1588
    //   3560: aload_0
    //   3561: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3564: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3567: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3570: iconst_0
    //   3571: putfield 1428	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3574: goto -108 -> 3466
    //   3577: aload_0
    //   3578: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3581: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3584: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3587: iconst_0
    //   3588: putfield 1429	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3591: goto -105 -> 3486
    //   3594: aload_0
    //   3595: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3598: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3601: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3604: iconst_0
    //   3605: putfield 1430	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3608: goto -102 -> 3506
    //   3611: aload_0
    //   3612: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3615: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3618: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3621: iconst_0
    //   3622: putfield 1431	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3625: goto -99 -> 3526
    //   3628: aload_0
    //   3629: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3632: aload_3
    //   3633: aload_1
    //   3634: aload_1
    //   3635: aconst_null
    //   3636: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3639: iload 4
    //   3641: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3644: goto -2056 -> 1588
    //   3647: ldc 150
    //   3649: iconst_1
    //   3650: ldc_w 1434
    //   3653: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3656: aload_0
    //   3657: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3660: aload_3
    //   3661: aload_1
    //   3662: aload_1
    //   3663: aconst_null
    //   3664: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3667: iload 4
    //   3669: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3672: goto -2084 -> 1588
    //   3675: ldc 150
    //   3677: iconst_1
    //   3678: ldc_w 1436
    //   3681: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3684: goto -2096 -> 1588
    //   3687: ldc 92
    //   3689: aload_1
    //   3690: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3693: ifeq +220 -> 3913
    //   3696: new 371	org/json/JSONObject
    //   3699: dup
    //   3700: aload_2
    //   3701: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3704: astore_2
    //   3705: aload_2
    //   3706: ldc_w 1407
    //   3709: iconst_0
    //   3710: invokevirtual 1258	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3713: istore 15
    //   3715: aload_2
    //   3716: ldc_w 1438
    //   3719: invokevirtual 656	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   3722: pop
    //   3723: aload_2
    //   3724: ldc_w 1440
    //   3727: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3730: pop
    //   3731: aload_2
    //   3732: ldc_w 1442
    //   3735: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3738: pop
    //   3739: aload_0
    //   3740: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3743: ifeq +91 -> 3834
    //   3746: aload_0
    //   3747: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3750: astore_2
    //   3751: aload_2
    //   3752: ifnull +63 -> 3815
    //   3755: aload_2
    //   3756: iload 15
    //   3758: putfield 1406	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3761: aload_0
    //   3762: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3765: aload_3
    //   3766: aload_1
    //   3767: aload_1
    //   3768: aconst_null
    //   3769: invokestatic 1176	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3772: iload 4
    //   3774: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3777: aload_0
    //   3778: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3781: aload_3
    //   3782: aload_1
    //   3783: aload_1
    //   3784: aconst_null
    //   3785: invokestatic 1176	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3788: iload 4
    //   3790: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3793: goto -2205 -> 1588
    //   3796: astore_1
    //   3797: ldc 150
    //   3799: iconst_1
    //   3800: aload_1
    //   3801: iconst_0
    //   3802: anewarray 904	java/lang/Object
    //   3805: invokestatic 1296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3808: aload_1
    //   3809: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   3812: goto -2224 -> 1588
    //   3815: aload_0
    //   3816: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3819: aload_3
    //   3820: aload_1
    //   3821: aload_1
    //   3822: aconst_null
    //   3823: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3826: iload 4
    //   3828: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3831: goto -54 -> 3777
    //   3834: aload_0
    //   3835: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3838: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3841: invokevirtual 1421	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3844: ifnull +50 -> 3894
    //   3847: aload_0
    //   3848: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3851: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3854: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3857: ifnull +37 -> 3894
    //   3860: aload_0
    //   3861: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3864: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3867: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3870: iload 15
    //   3872: putfield 1432	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3875: aload_0
    //   3876: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3879: aload_3
    //   3880: aload_1
    //   3881: aload_1
    //   3882: aconst_null
    //   3883: invokestatic 1176	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3886: iload 4
    //   3888: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3891: goto -114 -> 3777
    //   3894: aload_0
    //   3895: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3898: aload_3
    //   3899: aload_1
    //   3900: aload_1
    //   3901: aconst_null
    //   3902: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3905: iload 4
    //   3907: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3910: goto -133 -> 3777
    //   3913: ldc 32
    //   3915: aload_1
    //   3916: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3919: ifeq +79 -> 3998
    //   3922: new 371	org/json/JSONObject
    //   3925: dup
    //   3926: aload_2
    //   3927: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3930: astore_2
    //   3931: aload_2
    //   3932: ldc_w 1356
    //   3935: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3938: astore 20
    //   3940: aload_2
    //   3941: ldc_w 1358
    //   3944: iconst_0
    //   3945: invokevirtual 1361	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3948: istore 8
    //   3950: iload 8
    //   3952: istore 7
    //   3954: iload 8
    //   3956: ifgt +8 -> 3964
    //   3959: sipush 30000
    //   3962: istore 7
    //   3964: aload_0
    //   3965: aload 20
    //   3967: iload 7
    //   3969: aload_3
    //   3970: aload_1
    //   3971: iload 4
    //   3973: invokespecial 1363	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   3976: goto -2388 -> 1588
    //   3979: astore_1
    //   3980: ldc 150
    //   3982: iconst_1
    //   3983: aload_1
    //   3984: iconst_0
    //   3985: anewarray 904	java/lang/Object
    //   3988: invokestatic 1296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3991: aload_1
    //   3992: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   3995: goto -2407 -> 1588
    //   3998: ldc 68
    //   4000: aload_1
    //   4001: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4004: ifne +21 -> 4025
    //   4007: ldc 65
    //   4009: aload_1
    //   4010: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4013: ifne +12 -> 4025
    //   4016: ldc 71
    //   4018: aload_1
    //   4019: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4022: ifeq +1379 -> 5401
    //   4025: iconst_0
    //   4026: istore 15
    //   4028: ldc 68
    //   4030: aload_1
    //   4031: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4034: ifeq +6 -> 4040
    //   4037: iconst_1
    //   4038: istore 15
    //   4040: new 371	org/json/JSONObject
    //   4043: dup
    //   4044: aload_2
    //   4045: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4048: astore 23
    //   4050: aload 23
    //   4052: ldc_w 1444
    //   4055: iconst_m1
    //   4056: invokevirtual 1361	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4059: istore 9
    //   4061: iconst_m1
    //   4062: istore 7
    //   4064: aconst_null
    //   4065: astore 22
    //   4067: iload 9
    //   4069: ifne +6270 -> 10339
    //   4072: iconst_0
    //   4073: istore 7
    //   4075: aconst_null
    //   4076: astore_2
    //   4077: aload 23
    //   4079: ldc_w 1446
    //   4082: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4085: astore 25
    //   4087: aload 23
    //   4089: ldc_w 1448
    //   4092: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4095: astore 26
    //   4097: ldc 68
    //   4099: aload_1
    //   4100: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4103: ifne +6216 -> 10319
    //   4106: ldc 71
    //   4108: aload_1
    //   4109: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4112: ifeq +29 -> 4141
    //   4115: goto +6204 -> 10319
    //   4118: aload_0
    //   4119: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4122: ifeq +518 -> 4640
    //   4125: aload_0
    //   4126: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4129: ifnull +511 -> 4640
    //   4132: aload_0
    //   4133: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4136: iload 8
    //   4138: putfield 1451	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4141: aload_0
    //   4142: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4145: ifeq +532 -> 4677
    //   4148: aload_0
    //   4149: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4152: ifnull +525 -> 4677
    //   4155: aload_0
    //   4156: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4159: aload_1
    //   4160: putfield 1454	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   4163: aload_0
    //   4164: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4167: iload 4
    //   4169: putfield 1457	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   4172: aload_0
    //   4173: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4176: aload_3
    //   4177: putfield 1461	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   4180: aload 23
    //   4182: ldc_w 1463
    //   4185: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4188: astore 20
    //   4190: aload 20
    //   4192: astore 21
    //   4194: aload 20
    //   4196: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4199: ifeq +13 -> 4212
    //   4202: aload 23
    //   4204: ldc_w 1465
    //   4207: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4210: astore 21
    //   4212: aload 23
    //   4214: ldc_w 1467
    //   4217: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4220: astore 24
    //   4222: aload 23
    //   4224: ldc_w 1469
    //   4227: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4230: astore 27
    //   4232: aload 23
    //   4234: ldc_w 1471
    //   4237: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4240: astore 23
    //   4242: aload 21
    //   4244: astore 20
    //   4246: aload 21
    //   4248: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4251: ifeq +15 -> 4266
    //   4254: aload_0
    //   4255: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4258: ifeq +451 -> 4709
    //   4261: ldc_w 1473
    //   4264: astore 20
    //   4266: new 1475	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8
    //   4269: dup
    //   4270: aload_0
    //   4271: aload_3
    //   4272: aload_1
    //   4273: iload 4
    //   4275: invokespecial 1476	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   4278: astore_1
    //   4279: aload_0
    //   4280: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4283: ifeq +21 -> 4304
    //   4286: aload_0
    //   4287: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4290: ifnull +14 -> 4304
    //   4293: aload_0
    //   4294: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4297: getfield 1451	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4300: iconst_1
    //   4301: if_icmpeq +27 -> 4328
    //   4304: aload_0
    //   4305: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4308: ifne +506 -> 4814
    //   4311: aload_0
    //   4312: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4315: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4318: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4321: getfield 1477	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4324: iconst_1
    //   4325: if_icmpne +489 -> 4814
    //   4328: aload 27
    //   4330: ldc_w 1479
    //   4333: invokevirtual 1482	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4336: ifne +14 -> 4350
    //   4339: aload 27
    //   4341: ldc_w 1484
    //   4344: invokevirtual 1482	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4347: ifeq +383 -> 4730
    //   4350: aload_0
    //   4351: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4354: invokevirtual 579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4357: aload 24
    //   4359: aload 27
    //   4361: aload 20
    //   4363: aload_0
    //   4364: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4367: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4370: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4373: iload 15
    //   4375: invokestatic 1488	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4378: goto +5957 -> 10335
    //   4381: iload 9
    //   4383: iconst_2
    //   4384: if_icmpne +5969 -> 10353
    //   4387: iconst_0
    //   4388: istore 7
    //   4390: aload 23
    //   4392: ldc_w 1490
    //   4395: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4398: astore_2
    //   4399: aload_2
    //   4400: ifnull +80 -> 4480
    //   4403: aload_0
    //   4404: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4407: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4410: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4413: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4416: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4419: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4422: ifnull +58 -> 4480
    //   4425: aload_2
    //   4426: aload_0
    //   4427: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4430: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4433: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4436: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4439: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4442: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4445: invokevirtual 1499	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   4448: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4451: ifeq +29 -> 4480
    //   4454: aload_0
    //   4455: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4458: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4461: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4464: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4467: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4470: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4473: astore 22
    //   4475: aconst_null
    //   4476: astore_2
    //   4477: goto -400 -> 4077
    //   4480: ldc 150
    //   4482: iconst_1
    //   4483: new 419	java/lang/StringBuilder
    //   4486: dup
    //   4487: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   4490: ldc_w 1501
    //   4493: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4496: aload_2
    //   4497: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4500: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4503: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4506: aconst_null
    //   4507: astore_2
    //   4508: goto -431 -> 4077
    //   4511: iload 9
    //   4513: iconst_5
    //   4514: if_icmpne +102 -> 4616
    //   4517: aload 23
    //   4519: ldc_w 1503
    //   4522: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4525: astore 20
    //   4527: aload_0
    //   4528: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4531: ifeq +37 -> 4568
    //   4534: aload_0
    //   4535: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4538: ifnull +30 -> 4568
    //   4541: aload_0
    //   4542: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4545: getfield 1507	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4548: astore_2
    //   4549: aload_2
    //   4550: ifnull +35 -> 4585
    //   4553: aload_2
    //   4554: invokevirtual 1510	com/tencent/mobileqq/mini/sdk/ShareChatModel:getEntryHash	()Ljava/lang/String;
    //   4557: aload 20
    //   4559: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4562: ifeq +23 -> 4585
    //   4565: goto +5816 -> 10381
    //   4568: aload_0
    //   4569: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4572: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4575: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4578: getfield 1511	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4581: astore_2
    //   4582: goto -33 -> 4549
    //   4585: ldc 150
    //   4587: iconst_1
    //   4588: new 419	java/lang/StringBuilder
    //   4591: dup
    //   4592: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   4595: ldc_w 1501
    //   4598: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4601: aconst_null
    //   4602: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4605: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4608: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4611: aconst_null
    //   4612: astore_2
    //   4613: goto +5768 -> 10381
    //   4616: iload 9
    //   4618: bipush 6
    //   4620: if_icmpne +5658 -> 10278
    //   4623: ldc 71
    //   4625: aload_1
    //   4626: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4629: ifeq +5649 -> 10278
    //   4632: iconst_0
    //   4633: istore 7
    //   4635: aconst_null
    //   4636: astore_2
    //   4637: goto -560 -> 4077
    //   4640: aload_0
    //   4641: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4644: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4647: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4650: iload 8
    //   4652: putfield 1477	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4655: goto -514 -> 4141
    //   4658: astore_1
    //   4659: ldc 150
    //   4661: iconst_1
    //   4662: aload_1
    //   4663: iconst_0
    //   4664: anewarray 904	java/lang/Object
    //   4667: invokestatic 1296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4670: aload_1
    //   4671: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   4674: goto -3086 -> 1588
    //   4677: aload_0
    //   4678: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4681: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4684: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4687: aload_1
    //   4688: putfield 1512	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   4691: aload_0
    //   4692: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4695: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4698: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4701: iload 4
    //   4703: putfield 1513	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   4706: goto -526 -> 4180
    //   4709: aload_0
    //   4710: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4713: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4716: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4719: invokevirtual 1006	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   4722: getfield 1211	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   4725: astore 20
    //   4727: goto -461 -> 4266
    //   4730: aload_0
    //   4731: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4734: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4737: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4740: pop
    //   4741: invokestatic 1518	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   4744: aload 27
    //   4746: invokevirtual 1521	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   4749: astore_1
    //   4750: aload_1
    //   4751: invokestatic 1525	com/tencent/mobileqq/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   4754: ifne +33 -> 4787
    //   4757: aload_0
    //   4758: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4761: invokevirtual 579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4764: aload 24
    //   4766: aload_1
    //   4767: aload 20
    //   4769: aload_0
    //   4770: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4773: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4776: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4779: iload 15
    //   4781: invokestatic 1488	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4784: goto +5551 -> 10335
    //   4787: aload_0
    //   4788: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4791: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4794: new 1527	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9
    //   4797: dup
    //   4798: aload_0
    //   4799: aload 24
    //   4801: aload 20
    //   4803: iload 15
    //   4805: invokespecial 1530	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4808: invokevirtual 1534	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   4811: goto +5524 -> 10335
    //   4814: aload_0
    //   4815: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4818: ifeq +21 -> 4839
    //   4821: aload_0
    //   4822: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4825: ifnull +14 -> 4839
    //   4828: aload_0
    //   4829: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4832: getfield 1451	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4835: iconst_3
    //   4836: if_icmpeq +27 -> 4863
    //   4839: aload_0
    //   4840: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4843: ifne +55 -> 4898
    //   4846: aload_0
    //   4847: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4850: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4853: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4856: getfield 1477	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4859: iconst_3
    //   4860: if_icmpne +38 -> 4898
    //   4863: aload_0
    //   4864: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4867: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4870: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4873: astore_1
    //   4874: aload_0
    //   4875: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4878: invokevirtual 579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4881: aload 24
    //   4883: aload_1
    //   4884: getfield 1537	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   4887: aload 20
    //   4889: iconst_3
    //   4890: aload_1
    //   4891: invokestatic 1541	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   4894: ldc_w 545
    //   4897: areturn
    //   4898: aload_0
    //   4899: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4902: ifeq +21 -> 4923
    //   4905: aload_0
    //   4906: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4909: ifnull +14 -> 4923
    //   4912: aload_0
    //   4913: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4916: getfield 1451	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4919: iconst_4
    //   4920: if_icmpeq +27 -> 4947
    //   4923: aload_0
    //   4924: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4927: ifne +55 -> 4982
    //   4930: aload_0
    //   4931: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4934: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4937: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4940: getfield 1477	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4943: iconst_4
    //   4944: if_icmpne +38 -> 4982
    //   4947: aload_0
    //   4948: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4951: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4954: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4957: astore_1
    //   4958: aload_0
    //   4959: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4962: invokevirtual 579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4965: aload 24
    //   4967: aload_1
    //   4968: getfield 1537	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   4971: aload 20
    //   4973: iconst_4
    //   4974: aload_1
    //   4975: invokestatic 1541	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   4978: ldc_w 545
    //   4981: areturn
    //   4982: aload 27
    //   4984: invokestatic 1546	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   4987: ifne +5400 -> 10387
    //   4990: aload 27
    //   4992: invokestatic 1549	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   4995: ifeq +5398 -> 10393
    //   4998: goto +5389 -> 10387
    //   5001: aload_0
    //   5002: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5005: ifnull +5394 -> 10399
    //   5008: aload_0
    //   5009: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5012: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5015: ifnull +5384 -> 10399
    //   5018: aload 27
    //   5020: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5023: ifne +5376 -> 10399
    //   5026: new 1551	java/io/File
    //   5029: dup
    //   5030: invokestatic 1518	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5033: aload 27
    //   5035: invokevirtual 1521	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5038: invokespecial 1552	java/io/File:<init>	(Ljava/lang/String;)V
    //   5041: invokevirtual 1555	java/io/File:exists	()Z
    //   5044: ifeq +5355 -> 10399
    //   5047: iconst_1
    //   5048: istore 17
    //   5050: aload 27
    //   5052: invokestatic 1525	com/tencent/mobileqq/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   5055: ifne +13 -> 5068
    //   5058: iload 16
    //   5060: ifne +197 -> 5257
    //   5063: iload 17
    //   5065: ifne +192 -> 5257
    //   5068: aload_0
    //   5069: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5072: ifeq +110 -> 5182
    //   5075: aload_0
    //   5076: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5079: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5082: astore_3
    //   5083: invokestatic 1560	com/tencent/mobileqq/minigame/utils/GameWnsUtils:defaultShareImg	()Ljava/lang/String;
    //   5086: astore 21
    //   5088: iload 15
    //   5090: ifeq +5315 -> 10405
    //   5093: bipush 11
    //   5095: istore 4
    //   5097: aload_3
    //   5098: aload 24
    //   5100: aload 21
    //   5102: aload 20
    //   5104: aload 23
    //   5106: aload 25
    //   5108: aload 26
    //   5110: aload 22
    //   5112: aload_2
    //   5113: iload 4
    //   5115: iload 9
    //   5117: ldc_w 545
    //   5120: aload_1
    //   5121: invokevirtual 1564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5124: ldc 150
    //   5126: iconst_1
    //   5127: new 419	java/lang/StringBuilder
    //   5130: dup
    //   5131: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   5134: ldc_w 1566
    //   5137: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5140: iload 16
    //   5142: invokevirtual 1055	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5145: ldc_w 1568
    //   5148: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5151: iload 17
    //   5153: invokevirtual 1055	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5156: ldc_w 1570
    //   5159: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5162: aload 27
    //   5164: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5167: ldc_w 1572
    //   5170: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5173: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5176: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5179: goto -3591 -> 1588
    //   5182: aload_0
    //   5183: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5186: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5189: ifnull -3601 -> 1588
    //   5192: aload_0
    //   5193: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5196: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5199: getfield 1575	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5202: ifeq +16 -> 5218
    //   5205: ldc 150
    //   5207: iconst_1
    //   5208: ldc_w 1577
    //   5211: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5214: ldc_w 545
    //   5217: areturn
    //   5218: aload_0
    //   5219: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5222: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5225: new 1579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10
    //   5228: dup
    //   5229: aload_0
    //   5230: aload 24
    //   5232: aload 20
    //   5234: aload 23
    //   5236: aload 25
    //   5238: aload 26
    //   5240: aload 22
    //   5242: aload_2
    //   5243: iload 15
    //   5245: iload 9
    //   5247: aload_1
    //   5248: invokespecial 1582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;ZILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5251: invokevirtual 1534	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5254: goto -3666 -> 1588
    //   5257: aload 27
    //   5259: ldc_w 1479
    //   5262: invokevirtual 1482	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5265: ifne +14 -> 5279
    //   5268: aload 27
    //   5270: ldc_w 1484
    //   5273: invokevirtual 1482	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5276: ifeq +50 -> 5326
    //   5279: aload_0
    //   5280: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5283: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5286: astore_3
    //   5287: iload 15
    //   5289: ifeq +5123 -> 10412
    //   5292: bipush 11
    //   5294: istore 4
    //   5296: aload_3
    //   5297: aload 24
    //   5299: aload 27
    //   5301: aload 20
    //   5303: aload 23
    //   5305: aload 25
    //   5307: aload 26
    //   5309: aload 22
    //   5311: aload_2
    //   5312: iload 4
    //   5314: iload 9
    //   5316: ldc_w 545
    //   5319: aload_1
    //   5320: invokevirtual 1564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5323: goto -3735 -> 1588
    //   5326: aload_0
    //   5327: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5330: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5333: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5336: pop
    //   5337: invokestatic 1518	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5340: aload 27
    //   5342: invokevirtual 1521	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5345: astore_3
    //   5346: aload_0
    //   5347: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5350: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5353: astore 21
    //   5355: iload 15
    //   5357: ifeq +37 -> 5394
    //   5360: bipush 11
    //   5362: istore 4
    //   5364: aload 21
    //   5366: aload 24
    //   5368: aload_3
    //   5369: aload 20
    //   5371: aload 23
    //   5373: aload 25
    //   5375: aload 26
    //   5377: aload 22
    //   5379: aload_2
    //   5380: iload 4
    //   5382: iload 9
    //   5384: ldc_w 545
    //   5387: aload_1
    //   5388: invokevirtual 1564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5391: goto -3803 -> 1588
    //   5394: bipush 12
    //   5396: istore 4
    //   5398: goto -34 -> 5364
    //   5401: ldc 74
    //   5403: aload_1
    //   5404: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5407: ifne +12 -> 5419
    //   5410: ldc 77
    //   5412: aload_1
    //   5413: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5416: ifeq +539 -> 5955
    //   5419: new 371	org/json/JSONObject
    //   5422: dup
    //   5423: aload_2
    //   5424: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5427: astore_2
    //   5428: aload_2
    //   5429: ldc_w 1444
    //   5432: iconst_m1
    //   5433: invokevirtual 1361	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5436: istore 8
    //   5438: iconst_m1
    //   5439: istore 7
    //   5441: iload 8
    //   5443: ifne +250 -> 5693
    //   5446: iconst_0
    //   5447: istore 7
    //   5449: ldc 77
    //   5451: aload_1
    //   5452: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5455: ifeq +39 -> 5494
    //   5458: iload 7
    //   5460: istore 8
    //   5462: iload 7
    //   5464: iconst_m1
    //   5465: if_icmpne +6 -> 5471
    //   5468: iconst_0
    //   5469: istore 8
    //   5471: aload_0
    //   5472: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5475: ifeq +266 -> 5741
    //   5478: aload_0
    //   5479: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5482: ifnull +259 -> 5741
    //   5485: aload_0
    //   5486: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5489: iload 8
    //   5491: putfield 1451	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5494: aload_0
    //   5495: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5498: ifeq +261 -> 5759
    //   5501: aload_0
    //   5502: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5505: ifnull +254 -> 5759
    //   5508: aload_0
    //   5509: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5512: getfield 1451	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5515: istore 7
    //   5517: aload_0
    //   5518: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5521: ifeq +256 -> 5777
    //   5524: aload_0
    //   5525: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5528: ifnull +249 -> 5777
    //   5531: aload_0
    //   5532: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5535: aload_1
    //   5536: putfield 1454	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   5539: aload_0
    //   5540: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5543: iload 4
    //   5545: putfield 1457	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   5548: aload_0
    //   5549: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5552: aload_3
    //   5553: putfield 1461	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   5556: new 1584	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11
    //   5559: dup
    //   5560: aload_0
    //   5561: aload_3
    //   5562: aload_1
    //   5563: iload 4
    //   5565: invokespecial 1585	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   5568: astore_1
    //   5569: aload_0
    //   5570: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5573: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5576: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5579: astore_3
    //   5580: aload_2
    //   5581: ldc_w 1467
    //   5584: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5587: astore 20
    //   5589: aload_2
    //   5590: ldc_w 1469
    //   5593: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5596: astore_2
    //   5597: aload_2
    //   5598: invokestatic 1546	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   5601: ifne +4818 -> 10419
    //   5604: aload_2
    //   5605: invokestatic 1549	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   5608: ifeq +4817 -> 10425
    //   5611: goto +4808 -> 10419
    //   5614: invokestatic 1518	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5617: aload_2
    //   5618: invokevirtual 1521	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5621: astore 21
    //   5623: aload_0
    //   5624: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5627: ifnull +4804 -> 10431
    //   5630: aload_0
    //   5631: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5634: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5637: ifnull +4794 -> 10431
    //   5640: aload_2
    //   5641: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5644: ifne +4787 -> 10431
    //   5647: new 1551	java/io/File
    //   5650: dup
    //   5651: aload 21
    //   5653: invokespecial 1552	java/io/File:<init>	(Ljava/lang/String;)V
    //   5656: invokevirtual 1555	java/io/File:exists	()Z
    //   5659: ifeq +4772 -> 10431
    //   5662: iconst_1
    //   5663: istore 8
    //   5665: iload 4
    //   5667: ifeq +142 -> 5809
    //   5670: aload_0
    //   5671: aload 22
    //   5673: aload 20
    //   5675: aload_2
    //   5676: iload 7
    //   5678: aload_1
    //   5679: invokespecial 209	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5682: goto -4094 -> 1588
    //   5685: astore_1
    //   5686: aload_1
    //   5687: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   5690: goto -4102 -> 1588
    //   5693: iload 8
    //   5695: iconst_1
    //   5696: if_icmpne +9 -> 5705
    //   5699: iconst_1
    //   5700: istore 7
    //   5702: goto -253 -> 5449
    //   5705: iload 8
    //   5707: iconst_2
    //   5708: if_icmpne +9 -> 5717
    //   5711: iconst_0
    //   5712: istore 7
    //   5714: goto -265 -> 5449
    //   5717: iload 8
    //   5719: iconst_3
    //   5720: if_icmpne +9 -> 5729
    //   5723: iconst_3
    //   5724: istore 7
    //   5726: goto -277 -> 5449
    //   5729: iload 8
    //   5731: iconst_4
    //   5732: if_icmpne -283 -> 5449
    //   5735: iconst_4
    //   5736: istore 7
    //   5738: goto -289 -> 5449
    //   5741: aload_0
    //   5742: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5745: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5748: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5751: iload 8
    //   5753: putfield 1477	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5756: goto -262 -> 5494
    //   5759: aload_0
    //   5760: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5763: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5766: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5769: getfield 1477	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5772: istore 7
    //   5774: goto -257 -> 5517
    //   5777: aload_0
    //   5778: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5781: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5784: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5787: aload_1
    //   5788: putfield 1512	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   5791: aload_0
    //   5792: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5795: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5798: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5801: iload 4
    //   5803: putfield 1513	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   5806: goto -250 -> 5556
    //   5809: aload_2
    //   5810: invokestatic 1525	com/tencent/mobileqq/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   5813: ifne +13 -> 5826
    //   5816: iload 4
    //   5818: ifne +114 -> 5932
    //   5821: iload 8
    //   5823: ifne +109 -> 5932
    //   5826: aload_0
    //   5827: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5830: ifeq +37 -> 5867
    //   5833: aload_3
    //   5834: ifnull +21 -> 5855
    //   5837: aload_0
    //   5838: aload 22
    //   5840: aload 20
    //   5842: aload_3
    //   5843: getfield 1537	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5846: iload 7
    //   5848: aload_1
    //   5849: invokespecial 209	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5852: goto -4264 -> 1588
    //   5855: ldc 150
    //   5857: iconst_1
    //   5858: ldc_w 1587
    //   5861: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5864: goto -4276 -> 1588
    //   5867: aload_0
    //   5868: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5871: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5874: ifnull -4286 -> 1588
    //   5877: aload_0
    //   5878: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5881: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5884: getfield 1575	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5887: ifeq +16 -> 5903
    //   5890: ldc 150
    //   5892: iconst_1
    //   5893: ldc_w 1589
    //   5896: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5899: ldc_w 545
    //   5902: areturn
    //   5903: aload_0
    //   5904: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5907: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5910: new 1591	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12
    //   5913: dup
    //   5914: aload_0
    //   5915: aload_3
    //   5916: aload 22
    //   5918: aload 20
    //   5920: iload 7
    //   5922: aload_1
    //   5923: invokespecial 1594	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Landroid/app/Activity;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5926: invokevirtual 1534	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5929: goto -4341 -> 1588
    //   5932: iload 4
    //   5934: ifne -4346 -> 1588
    //   5937: iload 8
    //   5939: ifeq -4351 -> 1588
    //   5942: aload_0
    //   5943: aload 20
    //   5945: aload 21
    //   5947: iload 7
    //   5949: invokespecial 215	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareLocalPicMessage	(Ljava/lang/String;Ljava/lang/String;I)V
    //   5952: goto -4364 -> 1588
    //   5955: ldc 44
    //   5957: aload_1
    //   5958: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5961: ifeq +383 -> 6344
    //   5964: aload_0
    //   5965: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5968: ifnull -4380 -> 1588
    //   5971: aload_0
    //   5972: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5975: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5978: ifnull -4390 -> 1588
    //   5981: new 371	org/json/JSONObject
    //   5984: dup
    //   5985: aload_2
    //   5986: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5989: ldc_w 1596
    //   5992: invokevirtual 1412	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   5995: checkcast 382	org/json/JSONArray
    //   5998: astore_2
    //   5999: aload_2
    //   6000: ifnonnull +98 -> 6098
    //   6003: iconst_0
    //   6004: istore 10
    //   6006: iconst_0
    //   6007: istore 9
    //   6009: iconst_0
    //   6010: istore 8
    //   6012: iconst_0
    //   6013: istore 7
    //   6015: aload_0
    //   6016: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   6019: ifeq +185 -> 6204
    //   6022: aload_0
    //   6023: invokevirtual 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   6026: astore_2
    //   6027: aload_2
    //   6028: ifnull +157 -> 6185
    //   6031: iload 10
    //   6033: ifne +8 -> 6041
    //   6036: aload_2
    //   6037: iconst_0
    //   6038: putfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   6041: iload 9
    //   6043: ifne +8 -> 6051
    //   6046: aload_2
    //   6047: iconst_0
    //   6048: putfield 1397	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   6051: iload 8
    //   6053: ifne +8 -> 6061
    //   6056: aload_2
    //   6057: iconst_0
    //   6058: putfield 1400	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   6061: iload 7
    //   6063: ifne +8 -> 6071
    //   6066: aload_2
    //   6067: iconst_0
    //   6068: putfield 1403	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   6071: aload_0
    //   6072: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6075: aload_3
    //   6076: aload_1
    //   6077: aload_1
    //   6078: aconst_null
    //   6079: invokestatic 1176	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6082: iload 4
    //   6084: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6087: goto -4499 -> 1588
    //   6090: astore_1
    //   6091: aload_1
    //   6092: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   6095: goto -4507 -> 1588
    //   6098: iconst_m1
    //   6099: istore 7
    //   6101: iconst_m1
    //   6102: istore 8
    //   6104: iconst_m1
    //   6105: istore 9
    //   6107: iconst_m1
    //   6108: istore 10
    //   6110: iconst_0
    //   6111: istore 11
    //   6113: iload 11
    //   6115: aload_2
    //   6116: invokevirtual 1415	org/json/JSONArray:length	()I
    //   6119: if_icmpge +4156 -> 10275
    //   6122: aload_2
    //   6123: iload 11
    //   6125: invokevirtual 1417	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6128: astore 20
    //   6130: aload 20
    //   6132: ldc 124
    //   6134: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6137: ifeq +6 -> 6143
    //   6140: iconst_0
    //   6141: istore 10
    //   6143: aload 20
    //   6145: ldc 127
    //   6147: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6150: ifeq +6 -> 6156
    //   6153: iconst_0
    //   6154: istore 9
    //   6156: aload 20
    //   6158: ldc 130
    //   6160: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6163: ifeq +6 -> 6169
    //   6166: iconst_0
    //   6167: istore 8
    //   6169: aload 20
    //   6171: ldc 133
    //   6173: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6176: ifeq +4261 -> 10437
    //   6179: iconst_0
    //   6180: istore 7
    //   6182: goto +4255 -> 10437
    //   6185: aload_0
    //   6186: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6189: aload_3
    //   6190: aload_1
    //   6191: aload_1
    //   6192: aconst_null
    //   6193: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6196: iload 4
    //   6198: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6201: goto -4613 -> 1588
    //   6204: aload_0
    //   6205: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6208: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6211: invokevirtual 1421	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   6214: ifnull +111 -> 6325
    //   6217: aload_0
    //   6218: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6221: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6224: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6227: ifnull +98 -> 6325
    //   6230: iload 10
    //   6232: ifne +17 -> 6249
    //   6235: aload_0
    //   6236: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6239: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6242: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6245: iconst_0
    //   6246: putfield 1428	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   6249: iload 9
    //   6251: ifne +17 -> 6268
    //   6254: aload_0
    //   6255: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6258: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6261: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6264: iconst_0
    //   6265: putfield 1429	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   6268: iload 8
    //   6270: ifne +17 -> 6287
    //   6273: aload_0
    //   6274: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6277: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6280: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6283: iconst_0
    //   6284: putfield 1430	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   6287: iload 7
    //   6289: ifne +17 -> 6306
    //   6292: aload_0
    //   6293: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6296: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6299: invokevirtual 1425	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6302: iconst_0
    //   6303: putfield 1431	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   6306: aload_0
    //   6307: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6310: aload_3
    //   6311: aload_1
    //   6312: aload_1
    //   6313: aconst_null
    //   6314: invokestatic 1176	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6317: iload 4
    //   6319: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6322: goto -4734 -> 1588
    //   6325: aload_0
    //   6326: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6329: aload_3
    //   6330: aload_1
    //   6331: aload_1
    //   6332: aconst_null
    //   6333: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6336: iload 4
    //   6338: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6341: goto -4753 -> 1588
    //   6344: ldc_w 1598
    //   6347: aload_1
    //   6348: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6351: ifeq +298 -> 6649
    //   6354: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6357: invokevirtual 1161	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6360: astore 20
    //   6362: aload 20
    //   6364: instanceof 699
    //   6367: ifeq +3902 -> 10269
    //   6370: aload 20
    //   6372: checkcast 699	com/tencent/mobileqq/mini/MiniAppInterface
    //   6375: astore 20
    //   6377: aload 20
    //   6379: ifnonnull +18 -> 6397
    //   6382: aload_0
    //   6383: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6386: aload_3
    //   6387: aload_1
    //   6388: aconst_null
    //   6389: iload 4
    //   6391: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6394: goto -4806 -> 1588
    //   6397: new 371	org/json/JSONObject
    //   6400: dup
    //   6401: aload_2
    //   6402: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6405: ldc_w 1600
    //   6408: invokevirtual 1603	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6411: iconst_0
    //   6412: invokevirtual 1417	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6415: astore 22
    //   6417: aload 22
    //   6419: astore 21
    //   6421: aload 22
    //   6423: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6426: ifne +10 -> 6436
    //   6429: aload 22
    //   6431: invokevirtual 1606	java/lang/String:trim	()Ljava/lang/String;
    //   6434: astore 21
    //   6436: aload 20
    //   6438: aload_0
    //   6439: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6442: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6445: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6448: invokevirtual 703	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   6451: astore 20
    //   6453: aload 20
    //   6455: ifnull +179 -> 6634
    //   6458: aload 21
    //   6460: invokestatic 1609	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   6463: ifeq +171 -> 6634
    //   6466: aload 20
    //   6468: invokevirtual 1612	com/tencent/mobileqq/mini/app/AuthorizeCenter:isAuthorizeSynchronized	()Z
    //   6471: istore 15
    //   6473: aload 21
    //   6475: ldc_w 1614
    //   6478: invokevirtual 1482	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6481: ifeq +59 -> 6540
    //   6484: iload 15
    //   6486: ifne +54 -> 6540
    //   6489: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6492: aconst_null
    //   6493: aload_0
    //   6494: invokevirtual 1617	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   6497: new 1619	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13
    //   6500: dup
    //   6501: aload_0
    //   6502: aload 20
    //   6504: aload 21
    //   6506: aload_3
    //   6507: aload_1
    //   6508: iload 4
    //   6510: aload_2
    //   6511: invokespecial 1622	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILjava/lang/String;)V
    //   6514: invokevirtual 1626	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getAuthList	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6517: goto -4929 -> 1588
    //   6520: astore_2
    //   6521: aload_2
    //   6522: invokevirtual 483	java/lang/Throwable:printStackTrace	()V
    //   6525: aload_0
    //   6526: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6529: aload_3
    //   6530: aload_1
    //   6531: aconst_null
    //   6532: iload 4
    //   6534: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6537: goto -4949 -> 1588
    //   6540: aload 20
    //   6542: aload 21
    //   6544: invokevirtual 1629	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   6547: istore 8
    //   6549: iload 8
    //   6551: istore 7
    //   6553: iload 8
    //   6555: iconst_1
    //   6556: if_icmpne +42 -> 6598
    //   6559: aload_0
    //   6560: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6563: invokevirtual 1632	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   6566: ifne +3880 -> 10446
    //   6569: aload_0
    //   6570: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6573: astore 20
    //   6575: iload 8
    //   6577: istore 7
    //   6579: aload_0
    //   6580: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6583: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6586: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6589: invokestatic 1635	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   6592: ifeq +6 -> 6598
    //   6595: goto +3851 -> 10446
    //   6598: iload 7
    //   6600: iconst_2
    //   6601: if_icmpne +18 -> 6619
    //   6604: aload_0
    //   6605: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6608: aload_3
    //   6609: aload_1
    //   6610: aconst_null
    //   6611: iload 4
    //   6613: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6616: goto -5028 -> 1588
    //   6619: aload_0
    //   6620: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6623: aload_1
    //   6624: aload_2
    //   6625: aload_3
    //   6626: iload 4
    //   6628: invokevirtual 1639	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:reqAuthorize	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   6631: goto -5043 -> 1588
    //   6634: aload_0
    //   6635: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6638: aload_3
    //   6639: aload_1
    //   6640: aconst_null
    //   6641: iload 4
    //   6643: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6646: goto -5058 -> 1588
    //   6649: ldc 56
    //   6651: aload_1
    //   6652: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6655: ifeq +165 -> 6820
    //   6658: new 371	org/json/JSONObject
    //   6661: dup
    //   6662: aload_2
    //   6663: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6666: astore_1
    //   6667: ldc 150
    //   6669: iconst_2
    //   6670: new 419	java/lang/StringBuilder
    //   6673: dup
    //   6674: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   6677: ldc_w 1641
    //   6680: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6683: aload_1
    //   6684: invokevirtual 1184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6687: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6690: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6693: new 788	android/content/Intent
    //   6696: dup
    //   6697: invokespecial 1642	android/content/Intent:<init>	()V
    //   6700: astore_2
    //   6701: aload_2
    //   6702: new 1644	android/content/ComponentName
    //   6705: dup
    //   6706: aload_0
    //   6707: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6710: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6713: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6716: ldc_w 1646
    //   6719: invokespecial 1647	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6722: invokevirtual 1651	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   6725: pop
    //   6726: aload_2
    //   6727: ldc_w 1653
    //   6730: aload_1
    //   6731: ldc_w 1653
    //   6734: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6737: invokevirtual 799	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6740: pop
    //   6741: aload_2
    //   6742: ldc_w 1655
    //   6745: sipush 1008
    //   6748: invokevirtual 1658	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6751: pop
    //   6752: aload_2
    //   6753: ldc_w 1660
    //   6756: iconst_2
    //   6757: invokevirtual 1658	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6760: pop
    //   6761: aload_2
    //   6762: ldc_w 1662
    //   6765: aload_1
    //   6766: ldc_w 1664
    //   6769: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6772: invokevirtual 799	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6775: pop
    //   6776: aload_2
    //   6777: ldc_w 1665
    //   6780: invokevirtual 1669	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   6783: pop
    //   6784: aload_0
    //   6785: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6788: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6791: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6794: aload_2
    //   6795: invokevirtual 1243	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   6798: goto -5210 -> 1588
    //   6801: astore_1
    //   6802: ldc 150
    //   6804: iconst_1
    //   6805: aload_1
    //   6806: iconst_0
    //   6807: anewarray 904	java/lang/Object
    //   6810: invokestatic 1296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   6813: aload_1
    //   6814: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   6817: goto -5229 -> 1588
    //   6820: ldc 11
    //   6822: aload_1
    //   6823: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6826: ifeq +61 -> 6887
    //   6829: new 371	org/json/JSONObject
    //   6832: dup
    //   6833: aload_2
    //   6834: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6837: astore_2
    //   6838: new 1671	Wallet/FocusMpIdReq
    //   6841: dup
    //   6842: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6845: invokevirtual 1161	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6848: invokevirtual 1317	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6851: aload_2
    //   6852: ldc_w 1673
    //   6855: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6858: invokespecial 1674	Wallet/FocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   6861: new 1676	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14
    //   6864: dup
    //   6865: aload_0
    //   6866: aload_3
    //   6867: aload_1
    //   6868: iload 4
    //   6870: invokespecial 1677	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   6873: invokestatic 1327	ajvh:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   6876: goto -5288 -> 1588
    //   6879: astore_1
    //   6880: aload_1
    //   6881: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   6884: goto -5296 -> 1588
    //   6887: ldc_w 1679
    //   6890: aload_1
    //   6891: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6894: ifeq +34 -> 6928
    //   6897: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6900: aload_0
    //   6901: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6904: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6907: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6910: new 1681	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15
    //   6913: dup
    //   6914: aload_0
    //   6915: aload_3
    //   6916: aload_1
    //   6917: iload 4
    //   6919: invokespecial 1682	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   6922: invokevirtual 1685	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getFormId	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6925: goto -5337 -> 1588
    //   6928: ldc 121
    //   6930: aload_1
    //   6931: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6934: ifeq +149 -> 7083
    //   6937: aload_0
    //   6938: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6941: ifnonnull +7 -> 6948
    //   6944: ldc_w 545
    //   6947: areturn
    //   6948: new 371	org/json/JSONObject
    //   6951: dup
    //   6952: aload_2
    //   6953: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6956: ldc_w 1686
    //   6959: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6962: astore_2
    //   6963: invokestatic 594	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   6966: aload_0
    //   6967: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6970: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6973: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6976: invokevirtual 602	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   6979: astore_1
    //   6980: aload_1
    //   6981: ifnull +3471 -> 10452
    //   6984: aload_1
    //   6985: invokevirtual 608	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getMiniGamePkg	()Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;
    //   6988: astore_1
    //   6989: aload_2
    //   6990: aload_1
    //   6991: invokestatic 1692	com/tencent/mobileqq/mini/entry/MiniAppUtils:checkNavigationAppIdListForMiniGame	(Ljava/lang/String;Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;)Z
    //   6994: istore 15
    //   6996: new 371	org/json/JSONObject
    //   6999: dup
    //   7000: invokespecial 1064	org/json/JSONObject:<init>	()V
    //   7003: astore_1
    //   7004: aload_1
    //   7005: ldc_w 1694
    //   7008: iload 15
    //   7010: invokevirtual 1697	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   7013: pop
    //   7014: ldc 150
    //   7016: iconst_2
    //   7017: new 419	java/lang/StringBuilder
    //   7020: dup
    //   7021: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   7024: ldc_w 1699
    //   7027: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7030: aload_1
    //   7031: invokevirtual 1184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7034: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7037: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7040: aload_1
    //   7041: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7044: areturn
    //   7045: astore_2
    //   7046: ldc 150
    //   7048: iconst_1
    //   7049: aload_2
    //   7050: iconst_0
    //   7051: anewarray 904	java/lang/Object
    //   7054: invokestatic 1296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7057: aload_2
    //   7058: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   7061: goto -47 -> 7014
    //   7064: astore_1
    //   7065: ldc 150
    //   7067: iconst_1
    //   7068: aload_1
    //   7069: iconst_0
    //   7070: anewarray 904	java/lang/Object
    //   7073: invokestatic 1296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7076: aload_1
    //   7077: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   7080: goto -5492 -> 1588
    //   7083: ldc_w 1701
    //   7086: aload_1
    //   7087: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7090: ifeq +222 -> 7312
    //   7093: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7096: invokevirtual 1161	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   7099: astore_1
    //   7100: aload_1
    //   7101: instanceof 699
    //   7104: ifeq +3160 -> 10264
    //   7107: aload_1
    //   7108: checkcast 699	com/tencent/mobileqq/mini/MiniAppInterface
    //   7111: astore_1
    //   7112: aload_0
    //   7113: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7116: ifnull +7 -> 7123
    //   7119: aload_1
    //   7120: ifnonnull +26 -> 7146
    //   7123: aload_0
    //   7124: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7127: aload_3
    //   7128: ldc_w 1702
    //   7131: aconst_null
    //   7132: ldc_w 1703
    //   7135: invokestatic 1707	amtj:a	(I)Ljava/lang/String;
    //   7138: iload 4
    //   7140: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7143: goto -5555 -> 1588
    //   7146: aload_1
    //   7147: aload_0
    //   7148: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7151: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7154: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7157: invokevirtual 703	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   7160: astore_1
    //   7161: aload_1
    //   7162: ifnull +121 -> 7283
    //   7165: ldc_w 1709
    //   7168: invokestatic 1609	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   7171: ifeq +112 -> 7283
    //   7174: aload_1
    //   7175: ldc_w 1709
    //   7178: invokevirtual 1629	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   7181: istore 8
    //   7183: iload 8
    //   7185: istore 7
    //   7187: iload 8
    //   7189: iconst_1
    //   7190: if_icmpne +41 -> 7231
    //   7193: aload_0
    //   7194: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7197: invokevirtual 1632	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   7200: ifne +28 -> 7228
    //   7203: aload_0
    //   7204: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7207: astore_1
    //   7208: iload 8
    //   7210: istore 7
    //   7212: aload_0
    //   7213: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7216: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7219: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7222: invokestatic 1635	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   7225: ifeq +6 -> 7231
    //   7228: iconst_2
    //   7229: istore 7
    //   7231: iload 7
    //   7233: iconst_2
    //   7234: if_icmpne +20 -> 7254
    //   7237: aload_0
    //   7238: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7241: aload_3
    //   7242: ldc_w 1702
    //   7245: aconst_null
    //   7246: iload 4
    //   7248: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7251: goto -5663 -> 1588
    //   7254: ldc 150
    //   7256: iconst_1
    //   7257: ldc_w 1711
    //   7260: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7263: aload_0
    //   7264: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7267: aload_3
    //   7268: ldc_w 1702
    //   7271: aconst_null
    //   7272: ldc_w 1711
    //   7275: iload 4
    //   7277: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7280: goto -5692 -> 1588
    //   7283: aload_0
    //   7284: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7287: aload_3
    //   7288: ldc_w 1702
    //   7291: aconst_null
    //   7292: ldc_w 1713
    //   7295: iload 4
    //   7297: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7300: ldc 150
    //   7302: iconst_1
    //   7303: ldc_w 1715
    //   7306: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7309: goto -5721 -> 1588
    //   7312: ldc_w 1717
    //   7315: aload_1
    //   7316: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7319: ifeq +213 -> 7532
    //   7322: new 371	org/json/JSONObject
    //   7325: dup
    //   7326: aload_2
    //   7327: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7330: astore 20
    //   7332: aload 20
    //   7334: ldc_w 1719
    //   7337: invokevirtual 1603	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7340: astore_2
    //   7341: aload 20
    //   7343: ldc_w 658
    //   7346: ldc_w 1291
    //   7349: invokevirtual 1253	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7352: astore 20
    //   7354: aload_2
    //   7355: ifnull -5767 -> 1588
    //   7358: aload_2
    //   7359: invokevirtual 1415	org/json/JSONArray:length	()I
    //   7362: ifle -5774 -> 1588
    //   7365: aload_2
    //   7366: invokevirtual 1415	org/json/JSONArray:length	()I
    //   7369: anewarray 456	java/lang/String
    //   7372: astore 21
    //   7374: iconst_0
    //   7375: istore 7
    //   7377: iload 7
    //   7379: aload_2
    //   7380: invokevirtual 1415	org/json/JSONArray:length	()I
    //   7383: if_icmpge +23 -> 7406
    //   7386: aload 21
    //   7388: iload 7
    //   7390: aload_2
    //   7391: iload 7
    //   7393: invokevirtual 1417	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   7396: aastore
    //   7397: iload 7
    //   7399: iconst_1
    //   7400: iadd
    //   7401: istore 7
    //   7403: goto -26 -> 7377
    //   7406: invokestatic 594	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   7409: aload_0
    //   7410: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7413: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7416: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   7419: invokevirtual 602	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   7422: astore_2
    //   7423: aload_2
    //   7424: ifnonnull +26 -> 7450
    //   7427: aload_1
    //   7428: aconst_null
    //   7429: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   7432: astore_2
    //   7433: aload_0
    //   7434: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7437: aload_3
    //   7438: aload_1
    //   7439: aload_2
    //   7440: iload 4
    //   7442: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7445: aload_2
    //   7446: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7449: areturn
    //   7450: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7453: aload_2
    //   7454: invokevirtual 1723	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7457: invokevirtual 1726	com/tencent/mobileqq/minigame/manager/GameInfoManager:getAppId	()Ljava/lang/String;
    //   7460: aload 20
    //   7462: aload 21
    //   7464: new 1728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16
    //   7467: dup
    //   7468: aload_0
    //   7469: aload_2
    //   7470: aload_3
    //   7471: aload_1
    //   7472: iload 4
    //   7474: invokespecial 1731	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7477: invokevirtual 1735	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoOpenData	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7480: goto -5892 -> 1588
    //   7483: astore_2
    //   7484: aload_0
    //   7485: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7488: aload_3
    //   7489: aload_1
    //   7490: aconst_null
    //   7491: iload 4
    //   7493: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7496: ldc 150
    //   7498: iconst_1
    //   7499: new 419	java/lang/StringBuilder
    //   7502: dup
    //   7503: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   7506: ldc_w 1737
    //   7509: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7512: aload_1
    //   7513: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7516: ldc_w 1739
    //   7519: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7522: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7525: aload_2
    //   7526: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7529: goto -5941 -> 1588
    //   7532: ldc 41
    //   7534: aload_1
    //   7535: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7538: ifeq +424 -> 7962
    //   7541: new 371	org/json/JSONObject
    //   7544: dup
    //   7545: aload_2
    //   7546: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7549: astore_2
    //   7550: aload_2
    //   7551: ldc_w 1741
    //   7554: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7557: astore 23
    //   7559: aload_2
    //   7560: ldc_w 1743
    //   7563: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7566: astore 24
    //   7568: aload_2
    //   7569: ldc_w 1745
    //   7572: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7575: astore 25
    //   7577: aload_2
    //   7578: ldc_w 1747
    //   7581: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7584: astore 21
    //   7586: aload_2
    //   7587: ldc_w 1749
    //   7590: invokevirtual 1752	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7593: istore 7
    //   7595: ldc_w 1754
    //   7598: aload 24
    //   7600: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7603: ifne +33 -> 7636
    //   7606: ldc_w 1756
    //   7609: aload 24
    //   7611: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7614: ifne +22 -> 7636
    //   7617: aload_0
    //   7618: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7621: aload_3
    //   7622: aload_1
    //   7623: aconst_null
    //   7624: ldc_w 1758
    //   7627: iload 4
    //   7629: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7632: ldc_w 545
    //   7635: areturn
    //   7636: ldc_w 1754
    //   7639: aload 23
    //   7641: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7644: ifne +33 -> 7677
    //   7647: ldc_w 1760
    //   7650: aload 23
    //   7652: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7655: ifne +22 -> 7677
    //   7658: aload_0
    //   7659: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7662: aload_3
    //   7663: aload_1
    //   7664: aconst_null
    //   7665: ldc_w 1762
    //   7668: iload 4
    //   7670: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7673: ldc_w 545
    //   7676: areturn
    //   7677: iload 7
    //   7679: ifgt +22 -> 7701
    //   7682: aload_0
    //   7683: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7686: aload_3
    //   7687: aload_1
    //   7688: aconst_null
    //   7689: ldc_w 1764
    //   7692: iload 4
    //   7694: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7697: ldc_w 545
    //   7700: areturn
    //   7701: aload 21
    //   7703: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7706: ifeq +22 -> 7728
    //   7709: aload_0
    //   7710: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7713: aload_3
    //   7714: aload_1
    //   7715: aconst_null
    //   7716: ldc_w 1766
    //   7719: iload 4
    //   7721: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7724: ldc_w 545
    //   7727: areturn
    //   7728: new 1768	android/graphics/Paint
    //   7731: dup
    //   7732: invokespecial 1769	android/graphics/Paint:<init>	()V
    //   7735: astore 22
    //   7737: aload 22
    //   7739: iload 7
    //   7741: i2f
    //   7742: invokevirtual 1773	android/graphics/Paint:setTextSize	(F)V
    //   7745: aconst_null
    //   7746: astore 20
    //   7748: ldc_w 1754
    //   7751: aload 23
    //   7753: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7756: ifeq +68 -> 7824
    //   7759: ldc_w 1754
    //   7762: aload 24
    //   7764: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7767: ifeq +33 -> 7800
    //   7770: aload 25
    //   7772: iconst_0
    //   7773: invokestatic 1779	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7776: astore_2
    //   7777: aload_2
    //   7778: ifnonnull +105 -> 7883
    //   7781: aload_0
    //   7782: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7785: aload_3
    //   7786: aload_1
    //   7787: aconst_null
    //   7788: ldc_w 1781
    //   7791: iload 4
    //   7793: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7796: ldc_w 545
    //   7799: areturn
    //   7800: aload 20
    //   7802: astore_2
    //   7803: ldc_w 1756
    //   7806: aload 24
    //   7808: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7811: ifeq -34 -> 7777
    //   7814: aload 25
    //   7816: iconst_1
    //   7817: invokestatic 1779	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7820: astore_2
    //   7821: goto -44 -> 7777
    //   7824: aload 20
    //   7826: astore_2
    //   7827: ldc_w 1760
    //   7830: aload 23
    //   7832: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7835: ifeq -58 -> 7777
    //   7838: ldc_w 1754
    //   7841: aload 24
    //   7843: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7846: ifeq +13 -> 7859
    //   7849: aload 25
    //   7851: iconst_2
    //   7852: invokestatic 1779	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7855: astore_2
    //   7856: goto -79 -> 7777
    //   7859: aload 20
    //   7861: astore_2
    //   7862: ldc_w 1756
    //   7865: aload 24
    //   7867: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7870: ifeq -93 -> 7777
    //   7873: aload 25
    //   7875: iconst_3
    //   7876: invokestatic 1779	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7879: astore_2
    //   7880: goto -103 -> 7777
    //   7883: new 1783	android/graphics/Rect
    //   7886: dup
    //   7887: invokespecial 1784	android/graphics/Rect:<init>	()V
    //   7890: astore_2
    //   7891: aload 22
    //   7893: aload 21
    //   7895: iconst_0
    //   7896: aload 21
    //   7898: invokevirtual 1785	java/lang/String:length	()I
    //   7901: aload_2
    //   7902: invokevirtual 1789	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   7905: aload_0
    //   7906: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7909: aload_3
    //   7910: aload_1
    //   7911: aconst_null
    //   7912: iload 4
    //   7914: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7917: new 419	java/lang/StringBuilder
    //   7920: dup
    //   7921: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   7924: ldc_w 545
    //   7927: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7930: aload_2
    //   7931: invokevirtual 1791	android/graphics/Rect:height	()I
    //   7934: invokevirtual 771	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7937: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7940: astore_2
    //   7941: aload_2
    //   7942: areturn
    //   7943: astore_2
    //   7944: aload_0
    //   7945: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7948: aload_3
    //   7949: aload_1
    //   7950: aconst_null
    //   7951: ldc_w 1793
    //   7954: iload 4
    //   7956: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7959: goto -6371 -> 1588
    //   7962: ldc_w 1795
    //   7965: aload_1
    //   7966: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7969: ifeq +28 -> 7997
    //   7972: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7975: aload_0
    //   7976: invokevirtual 1617	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   7979: new 1797	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17
    //   7982: dup
    //   7983: aload_0
    //   7984: aload_3
    //   7985: aload_1
    //   7986: iload 4
    //   7988: invokespecial 1798	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7991: invokevirtual 1800	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoExtra	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7994: goto -6406 -> 1588
    //   7997: ldc 23
    //   7999: aload_1
    //   8000: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8003: ifeq +323 -> 8326
    //   8006: aload_0
    //   8007: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   8010: ifeq -6422 -> 1588
    //   8013: invokestatic 594	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   8016: aload_0
    //   8017: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8020: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8023: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8026: invokevirtual 602	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   8029: astore 20
    //   8031: aload 20
    //   8033: ifnonnull +26 -> 8059
    //   8036: aload_1
    //   8037: aconst_null
    //   8038: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8041: astore_2
    //   8042: aload_0
    //   8043: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8046: aload_3
    //   8047: aload_1
    //   8048: aload_2
    //   8049: iload 4
    //   8051: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8054: aload_2
    //   8055: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8058: areturn
    //   8059: aload 20
    //   8061: invokevirtual 1723	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8064: invokevirtual 1804	com/tencent/mobileqq/minigame/manager/GameInfoManager:getLaunchOptions	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions;
    //   8067: astore 21
    //   8069: new 371	org/json/JSONObject
    //   8072: dup
    //   8073: invokespecial 1064	org/json/JSONObject:<init>	()V
    //   8076: astore 22
    //   8078: new 371	org/json/JSONObject
    //   8081: dup
    //   8082: invokespecial 1064	org/json/JSONObject:<init>	()V
    //   8085: astore 23
    //   8087: aload 21
    //   8089: getfield 1809	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8092: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8095: ifeq +170 -> 8265
    //   8098: aconst_null
    //   8099: astore_2
    //   8100: aload 23
    //   8102: ldc_w 1686
    //   8105: aload_2
    //   8106: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8109: pop
    //   8110: aload 21
    //   8112: getfield 1812	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8115: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8118: ifeq +156 -> 8274
    //   8121: aconst_null
    //   8122: astore_2
    //   8123: aload 23
    //   8125: ldc_w 1814
    //   8128: aload_2
    //   8129: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8132: pop
    //   8133: aload 22
    //   8135: ldc_w 1815
    //   8138: aload 21
    //   8140: getfield 1816	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:scene	I
    //   8143: invokestatic 1822	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getWikiScene	(I)I
    //   8146: invokevirtual 1069	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   8149: pop
    //   8150: aload 22
    //   8152: ldc_w 1465
    //   8155: aload 21
    //   8157: getfield 1825	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:query	Lorg/json/JSONObject;
    //   8160: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8163: pop
    //   8164: aload 21
    //   8166: getfield 1827	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8169: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8172: ifeq +111 -> 8283
    //   8175: aconst_null
    //   8176: astore_2
    //   8177: aload 22
    //   8179: ldc_w 1356
    //   8182: aload_2
    //   8183: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8186: pop
    //   8187: aload 22
    //   8189: ldc_w 1829
    //   8192: aload 23
    //   8194: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8197: pop
    //   8198: aload 22
    //   8200: ldc_w 1831
    //   8203: aload 20
    //   8205: invokevirtual 1723	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8208: invokevirtual 1834	com/tencent/mobileqq/minigame/manager/GameInfoManager:getExtendData	()Ljava/lang/String;
    //   8211: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8214: pop
    //   8215: aload 22
    //   8217: ldc_w 1490
    //   8220: aload 21
    //   8222: getfield 1836	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:entryDataHash	Ljava/lang/String;
    //   8225: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8228: pop
    //   8229: ldc 150
    //   8231: iconst_1
    //   8232: new 419	java/lang/StringBuilder
    //   8235: dup
    //   8236: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   8239: ldc_w 1838
    //   8242: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8245: aload 22
    //   8247: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8250: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8253: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8256: invokestatic 464	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8259: aload 22
    //   8261: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8264: areturn
    //   8265: aload 21
    //   8267: getfield 1809	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8270: astore_2
    //   8271: goto -171 -> 8100
    //   8274: aload 21
    //   8276: getfield 1812	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8279: astore_2
    //   8280: goto -157 -> 8123
    //   8283: aload 21
    //   8285: getfield 1827	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8288: astore_2
    //   8289: goto -112 -> 8177
    //   8292: astore_2
    //   8293: ldc 150
    //   8295: iconst_1
    //   8296: ldc_w 1840
    //   8299: aload_2
    //   8300: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8303: aload_1
    //   8304: aconst_null
    //   8305: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8308: astore_1
    //   8309: aload_3
    //   8310: iload 4
    //   8312: aload_1
    //   8313: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8316: invokeinterface 647 3 0
    //   8321: aload_1
    //   8322: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8325: areturn
    //   8326: ldc 53
    //   8328: aload_1
    //   8329: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8332: ifeq +658 -> 8990
    //   8335: new 371	org/json/JSONObject
    //   8338: dup
    //   8339: aload_2
    //   8340: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8343: astore_2
    //   8344: ldc 150
    //   8346: iconst_1
    //   8347: new 419	java/lang/StringBuilder
    //   8350: dup
    //   8351: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   8354: ldc_w 1842
    //   8357: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8360: aload_2
    //   8361: invokevirtual 1184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8364: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8367: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8370: aload_2
    //   8371: ldc_w 795
    //   8374: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8377: astore 22
    //   8379: aload 22
    //   8381: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8384: ifeq +20 -> 8404
    //   8387: aload_0
    //   8388: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8391: aload_3
    //   8392: aload_1
    //   8393: aconst_null
    //   8394: ldc_w 1844
    //   8397: iload 4
    //   8399: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8402: aconst_null
    //   8403: areturn
    //   8404: aload_2
    //   8405: ldc_w 1846
    //   8408: iconst_0
    //   8409: invokevirtual 1258	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8412: istore 15
    //   8414: aload 22
    //   8416: invokevirtual 1849	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   8419: astore 20
    //   8421: aload 20
    //   8423: invokestatic 1855	com/tencent/mobileqq/mini/apkg/DomainConfig:getDomainConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/DomainConfig;
    //   8426: astore 21
    //   8428: iload 15
    //   8430: ifne +83 -> 8513
    //   8433: aload_0
    //   8434: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8437: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8440: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   8443: aload 20
    //   8445: iconst_0
    //   8446: invokevirtual 1858	com/tencent/mobileqq/mini/apkg/ApkgInfo:isValidPrefix	(Ljava/lang/String;Z)Z
    //   8449: ifne +20 -> 8469
    //   8452: aload_0
    //   8453: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8456: aload_3
    //   8457: aload_1
    //   8458: aconst_null
    //   8459: ldc_w 1860
    //   8462: iload 4
    //   8464: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8467: aconst_null
    //   8468: areturn
    //   8469: aload_0
    //   8470: getfield 436	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8473: ifnull +40 -> 8513
    //   8476: aload 21
    //   8478: ifnull +35 -> 8513
    //   8481: aload_0
    //   8482: getfield 436	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8485: aload 21
    //   8487: getfield 1863	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8490: invokevirtual 1866	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   8493: ifne +20 -> 8513
    //   8496: aload_0
    //   8497: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8500: aload_3
    //   8501: aload_1
    //   8502: aconst_null
    //   8503: ldc_w 1868
    //   8506: iload 4
    //   8508: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8511: aconst_null
    //   8512: areturn
    //   8513: aload 21
    //   8515: ifnull +452 -> 8967
    //   8518: ldc_w 1870
    //   8521: aload 21
    //   8523: getfield 1863	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8526: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8529: ifeq +438 -> 8967
    //   8532: ldc_w 1872
    //   8535: ldc_w 1874
    //   8538: invokestatic 1879	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8541: astore_2
    //   8542: aload 22
    //   8544: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8547: ifne +402 -> 8949
    //   8550: aload_0
    //   8551: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8554: ifnull +395 -> 8949
    //   8557: aload_0
    //   8558: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8561: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8564: ifnull +385 -> 8949
    //   8567: invokestatic 1884	com/tencent/mobileqq/mini/mainpage/MainPageFragment:getUin	()Ljava/lang/String;
    //   8570: astore 21
    //   8572: aload 21
    //   8574: ifnonnull +1883 -> 10457
    //   8577: ldc_w 545
    //   8580: astore 20
    //   8582: aload 22
    //   8584: ldc_w 1886
    //   8587: aload 20
    //   8589: invokevirtual 1890	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8592: ldc_w 1892
    //   8595: invokestatic 1135	com/tencent/mobileqq/utils/DeviceInfoUtil:getQQVersion	()Ljava/lang/String;
    //   8598: invokevirtual 1890	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8601: ldc_w 1894
    //   8604: ldc_w 1146
    //   8607: invokevirtual 1890	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8610: ldc_w 1896
    //   8613: getstatic 918	android/os/Build$VERSION:SDK_INT	I
    //   8616: invokestatic 562	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   8619: invokevirtual 1890	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8622: ldc_w 1898
    //   8625: invokestatic 1902	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8628: invokestatic 1908	com/tencent/mobileqq/utils/NetworkUtil:getApn	(Landroid/content/Context;)Ljava/lang/String;
    //   8631: invokevirtual 1890	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8634: ldc_w 1910
    //   8637: aload_2
    //   8638: invokevirtual 1890	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8641: astore 22
    //   8643: invokestatic 491	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8646: new 419	java/lang/StringBuilder
    //   8649: dup
    //   8650: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   8653: getstatic 1916	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   8656: invokevirtual 1917	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   8659: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8662: aload 21
    //   8664: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8667: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8670: invokevirtual 1920	com/tencent/common/app/BaseApplicationImpl:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   8673: astore 20
    //   8675: aload 20
    //   8677: astore_2
    //   8678: aload 20
    //   8680: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8683: ifeq +7 -> 8690
    //   8686: ldc_w 545
    //   8689: astore_2
    //   8690: aload 22
    //   8692: ldc_w 1922
    //   8695: aload_2
    //   8696: invokevirtual 1890	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8699: astore_2
    //   8700: invokestatic 894	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8703: ifeq +29 -> 8732
    //   8706: ldc 150
    //   8708: iconst_2
    //   8709: new 419	java/lang/StringBuilder
    //   8712: dup
    //   8713: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   8716: ldc_w 1924
    //   8719: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8722: aload_2
    //   8723: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8726: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8729: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8732: new 788	android/content/Intent
    //   8735: dup
    //   8736: aload_0
    //   8737: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8740: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8743: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8746: ldc_w 790
    //   8749: invokespecial 793	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8752: astore 20
    //   8754: aload 20
    //   8756: ldc_w 1926
    //   8759: ldc_w 1927
    //   8762: invokestatic 1707	amtj:a	(I)Ljava/lang/String;
    //   8765: invokevirtual 799	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8768: pop
    //   8769: aload 20
    //   8771: ldc_w 804
    //   8774: iconst_1
    //   8775: invokevirtual 1930	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8778: pop
    //   8779: aload 20
    //   8781: ldc_w 1932
    //   8784: iconst_1
    //   8785: invokevirtual 1930	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8788: pop
    //   8789: aload 20
    //   8791: ldc_w 795
    //   8794: aload_2
    //   8795: invokevirtual 799	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8798: pop
    //   8799: aload_0
    //   8800: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8803: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8806: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8809: aload 20
    //   8811: invokevirtual 1243	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   8814: aload_0
    //   8815: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8818: aload_3
    //   8819: aload_1
    //   8820: aconst_null
    //   8821: iload 4
    //   8823: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8826: aload_2
    //   8827: ldc_w 1934
    //   8830: invokevirtual 1482	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8833: ifeq -7245 -> 1588
    //   8836: ldc 150
    //   8838: iconst_2
    //   8839: ldc_w 1936
    //   8842: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8845: new 801	android/os/Bundle
    //   8848: dup
    //   8849: invokespecial 802	android/os/Bundle:<init>	()V
    //   8852: astore_1
    //   8853: aload_1
    //   8854: ldc_w 1938
    //   8857: aload_0
    //   8858: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8861: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8864: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   8867: invokevirtual 1941	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8870: invokestatic 1946	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   8873: ldc_w 1948
    //   8876: ldc_w 1950
    //   8879: aload_1
    //   8880: new 1952	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18
    //   8883: dup
    //   8884: aload_0
    //   8885: invokespecial 1955	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;)V
    //   8888: invokevirtual 1959	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   8891: goto -7303 -> 1588
    //   8894: astore_1
    //   8895: ldc 150
    //   8897: iconst_1
    //   8898: aload_1
    //   8899: iconst_0
    //   8900: anewarray 904	java/lang/Object
    //   8903: invokestatic 1296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   8906: goto -7318 -> 1588
    //   8909: astore_2
    //   8910: ldc 150
    //   8912: iconst_1
    //   8913: new 419	java/lang/StringBuilder
    //   8916: dup
    //   8917: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   8920: ldc_w 1961
    //   8923: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8926: ldc_w 545
    //   8929: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8932: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8935: invokestatic 636	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8938: aload_2
    //   8939: invokevirtual 1962	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   8942: ldc_w 545
    //   8945: astore_2
    //   8946: goto -404 -> 8542
    //   8949: aload_0
    //   8950: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8953: aload_3
    //   8954: aload_1
    //   8955: aconst_null
    //   8956: ldc_w 1964
    //   8959: iload 4
    //   8961: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8964: goto -7376 -> 1588
    //   8967: new 1966	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19
    //   8970: dup
    //   8971: aload_0
    //   8972: aload_2
    //   8973: aload_3
    //   8974: aload_1
    //   8975: iload 4
    //   8977: invokespecial 1969	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   8980: bipush 16
    //   8982: aconst_null
    //   8983: iconst_0
    //   8984: invokestatic 1973	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   8987: goto -7399 -> 1588
    //   8990: ldc 62
    //   8992: aload_1
    //   8993: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8996: ifeq +113 -> 9109
    //   8999: new 371	org/json/JSONObject
    //   9002: dup
    //   9003: aload_2
    //   9004: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9007: ldc_w 1975
    //   9010: iconst_0
    //   9011: invokevirtual 1258	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   9014: istore 15
    //   9016: aload_0
    //   9017: invokevirtual 1385	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   9020: ifeq -7432 -> 1588
    //   9023: invokestatic 594	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   9026: aload_0
    //   9027: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9030: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9033: getfield 598	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   9036: invokevirtual 602	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   9039: astore_2
    //   9040: aload_2
    //   9041: ifnonnull +26 -> 9067
    //   9044: aload_1
    //   9045: aconst_null
    //   9046: invokestatic 642	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   9049: astore_2
    //   9050: aload_0
    //   9051: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9054: aload_3
    //   9055: aload_1
    //   9056: aload_2
    //   9057: iload 4
    //   9059: invokevirtual 328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9062: aload_2
    //   9063: invokevirtual 632	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9066: areturn
    //   9067: aload_2
    //   9068: invokevirtual 1723	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   9071: invokevirtual 1979	com/tencent/mobileqq/minigame/manager/GameInfoManager:getMiniAppConfig	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9074: iload 15
    //   9076: invokestatic 1985	com/tencent/mobileqq/minigame/gpkg/GpkgManager:setOfflineResourceContent	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Z)V
    //   9079: aload_0
    //   9080: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9083: aload_3
    //   9084: aload_1
    //   9085: aconst_null
    //   9086: iload 4
    //   9088: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9091: goto -7503 -> 1588
    //   9094: astore_1
    //   9095: ldc 150
    //   9097: iconst_1
    //   9098: aload_1
    //   9099: iconst_0
    //   9100: anewarray 904	java/lang/Object
    //   9103: invokestatic 1296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   9106: goto -7518 -> 1588
    //   9109: ldc 95
    //   9111: aload_1
    //   9112: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9115: ifeq +178 -> 9293
    //   9118: aload_0
    //   9119: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9122: ifnull -7534 -> 1588
    //   9125: new 466	java/util/ArrayList
    //   9128: dup
    //   9129: invokespecial 467	java/util/ArrayList:<init>	()V
    //   9132: astore 20
    //   9134: new 371	org/json/JSONObject
    //   9137: dup
    //   9138: aload_2
    //   9139: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9142: ldc_w 499
    //   9145: invokevirtual 503	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   9148: ldc_w 1987
    //   9151: invokevirtual 1603	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9154: astore_2
    //   9155: aload_2
    //   9156: ifnull +85 -> 9241
    //   9159: aload_2
    //   9160: invokevirtual 1415	org/json/JSONArray:length	()I
    //   9163: ifle +78 -> 9241
    //   9166: iconst_0
    //   9167: istore 7
    //   9169: iload 7
    //   9171: aload_2
    //   9172: invokevirtual 1415	org/json/JSONArray:length	()I
    //   9175: if_icmpge +66 -> 9241
    //   9178: aload_2
    //   9179: iload 7
    //   9181: invokevirtual 1990	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9184: checkcast 371	org/json/JSONObject
    //   9187: astore 21
    //   9189: new 1992	com/tencent/mobileqq/mini/apkg/PluginInfo
    //   9192: dup
    //   9193: invokespecial 1993	com/tencent/mobileqq/mini/apkg/PluginInfo:<init>	()V
    //   9196: astore 22
    //   9198: aload 22
    //   9200: aload 21
    //   9202: ldc_w 1995
    //   9205: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9208: invokevirtual 1998	com/tencent/mobileqq/mini/apkg/PluginInfo:setPluginId	(Ljava/lang/String;)V
    //   9211: aload 22
    //   9213: aload 21
    //   9215: ldc_w 2000
    //   9218: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9221: invokevirtual 2003	com/tencent/mobileqq/mini/apkg/PluginInfo:setInnerVersion	(Ljava/lang/String;)V
    //   9224: aload 20
    //   9226: aload 22
    //   9228: invokevirtual 480	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9231: pop
    //   9232: iload 7
    //   9234: iconst_1
    //   9235: iadd
    //   9236: istore 7
    //   9238: goto -69 -> 9169
    //   9241: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9244: aload_0
    //   9245: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9248: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9251: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9254: aload 20
    //   9256: new 2005	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20
    //   9259: dup
    //   9260: aload_0
    //   9261: aload_3
    //   9262: aload_1
    //   9263: iload 4
    //   9265: invokespecial 2006	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9268: invokevirtual 2009	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:verifyPlugin	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9271: goto -7683 -> 1588
    //   9274: astore_2
    //   9275: aload_0
    //   9276: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9279: aload_3
    //   9280: aload_1
    //   9281: aconst_null
    //   9282: ldc_w 2011
    //   9285: iload 4
    //   9287: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9290: goto -7702 -> 1588
    //   9293: ldc 14
    //   9295: aload_1
    //   9296: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9299: ifeq +127 -> 9426
    //   9302: aload_0
    //   9303: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9306: ifnull -7718 -> 1588
    //   9309: aload_2
    //   9310: ifnull -7722 -> 1588
    //   9313: new 371	org/json/JSONObject
    //   9316: dup
    //   9317: aload_2
    //   9318: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9321: ldc_w 2013
    //   9324: invokevirtual 1603	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9327: astore_2
    //   9328: new 466	java/util/ArrayList
    //   9331: dup
    //   9332: invokespecial 467	java/util/ArrayList:<init>	()V
    //   9335: astore 20
    //   9337: aload_2
    //   9338: ifnull +46 -> 9384
    //   9341: aload_2
    //   9342: invokevirtual 1415	org/json/JSONArray:length	()I
    //   9345: ifle +39 -> 9384
    //   9348: iconst_0
    //   9349: istore 7
    //   9351: iload 7
    //   9353: aload_2
    //   9354: invokevirtual 1415	org/json/JSONArray:length	()I
    //   9357: if_icmpge +27 -> 9384
    //   9360: aload 20
    //   9362: aload_2
    //   9363: iload 7
    //   9365: invokevirtual 1990	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9368: invokestatic 2016	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9371: invokevirtual 480	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9374: pop
    //   9375: iload 7
    //   9377: iconst_1
    //   9378: iadd
    //   9379: istore 7
    //   9381: goto -30 -> 9351
    //   9384: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9387: aload 20
    //   9389: new 2018	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21
    //   9392: dup
    //   9393: aload_0
    //   9394: aload_3
    //   9395: aload_1
    //   9396: iload 4
    //   9398: invokespecial 2019	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9401: invokevirtual 2022	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:batchGetContact	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9404: goto -7816 -> 1588
    //   9407: astore_2
    //   9408: aload_0
    //   9409: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9412: aload_3
    //   9413: aload_1
    //   9414: aconst_null
    //   9415: ldc_w 2024
    //   9418: iload 4
    //   9420: invokevirtual 728	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9423: goto -7835 -> 1588
    //   9426: ldc 26
    //   9428: aload_1
    //   9429: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9432: ifeq +60 -> 9492
    //   9435: new 371	org/json/JSONObject
    //   9438: dup
    //   9439: invokespecial 1064	org/json/JSONObject:<init>	()V
    //   9442: astore_2
    //   9443: aload_2
    //   9444: ldc_w 388
    //   9447: aload_0
    //   9448: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9451: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9454: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9457: getfield 2025	com/tencent/mobileqq/mini/apkg/ApkgInfo:appId	Ljava/lang/String;
    //   9460: invokestatic 2030	com/tencent/mobileqq/mini/report/MiniReportManager:getLaunchPerformance	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9463: invokevirtual 1104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   9466: pop
    //   9467: aload_0
    //   9468: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9471: aload_3
    //   9472: aload_1
    //   9473: aload_2
    //   9474: iload 4
    //   9476: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9479: goto -7891 -> 1588
    //   9482: astore 20
    //   9484: aload 20
    //   9486: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   9489: goto -22 -> 9467
    //   9492: ldc_w 2032
    //   9495: aload_1
    //   9496: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9499: ifeq +131 -> 9630
    //   9502: new 371	org/json/JSONObject
    //   9505: dup
    //   9506: invokespecial 1064	org/json/JSONObject:<init>	()V
    //   9509: astore_2
    //   9510: aload_0
    //   9511: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9514: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9517: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9520: astore 20
    //   9522: iconst_0
    //   9523: istore 16
    //   9525: iload 16
    //   9527: istore 15
    //   9529: aload 20
    //   9531: ifnull +64 -> 9595
    //   9534: iload 16
    //   9536: istore 15
    //   9538: aload 20
    //   9540: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9543: ifnull +52 -> 9595
    //   9546: iload 16
    //   9548: istore 15
    //   9550: aload 20
    //   9552: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9555: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9558: ifnull +37 -> 9595
    //   9561: iload 16
    //   9563: istore 15
    //   9565: aload 20
    //   9567: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9570: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9573: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9576: ifnull +19 -> 9595
    //   9579: aload 20
    //   9581: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9584: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9587: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9590: getfield 2035	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9593: istore 15
    //   9595: aload_2
    //   9596: ldc_w 2037
    //   9599: iload 15
    //   9601: invokevirtual 1697	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9604: pop
    //   9605: aload_0
    //   9606: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9609: aload_3
    //   9610: aload_1
    //   9611: aload_2
    //   9612: iload 4
    //   9614: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9617: goto -8029 -> 1588
    //   9620: astore 20
    //   9622: aload 20
    //   9624: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   9627: goto -22 -> 9605
    //   9630: ldc_w 2039
    //   9633: aload_1
    //   9634: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9637: ifeq +293 -> 9930
    //   9640: new 371	org/json/JSONObject
    //   9643: dup
    //   9644: aload_2
    //   9645: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9648: ldc_w 1490
    //   9651: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9654: astore_2
    //   9655: aload_0
    //   9656: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9659: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9662: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9665: astore 20
    //   9667: new 371	org/json/JSONObject
    //   9670: dup
    //   9671: invokespecial 1064	org/json/JSONObject:<init>	()V
    //   9674: astore 21
    //   9676: iconst_0
    //   9677: istore 16
    //   9679: iload 16
    //   9681: istore 15
    //   9683: aload 20
    //   9685: ifnull +64 -> 9749
    //   9688: iload 16
    //   9690: istore 15
    //   9692: aload 20
    //   9694: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9697: ifnull +52 -> 9749
    //   9700: iload 16
    //   9702: istore 15
    //   9704: aload 20
    //   9706: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9709: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9712: ifnull +37 -> 9749
    //   9715: iload 16
    //   9717: istore 15
    //   9719: aload 20
    //   9721: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9724: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9727: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9730: ifnull +19 -> 9749
    //   9733: aload 20
    //   9735: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9738: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9741: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9744: getfield 2035	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9747: istore 15
    //   9749: aload 21
    //   9751: ldc_w 2037
    //   9754: iload 15
    //   9756: invokevirtual 1697	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9759: pop
    //   9760: aload 20
    //   9762: ifnull +152 -> 9914
    //   9765: aload 20
    //   9767: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9770: ifnull +144 -> 9914
    //   9773: aload 20
    //   9775: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9778: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9781: ifnull +133 -> 9914
    //   9784: aload 20
    //   9786: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9789: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9792: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9795: ifnull +119 -> 9914
    //   9798: aload_2
    //   9799: ifnull +115 -> 9914
    //   9802: aload_2
    //   9803: aload 20
    //   9805: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9808: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9811: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9814: invokevirtual 1499	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   9817: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9820: ifeq +94 -> 9914
    //   9823: aload 20
    //   9825: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9828: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9831: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9834: getfield 2042	com/tencent/mobileqq/mini/sdk/EntryModel:type	I
    //   9837: iconst_1
    //   9838: if_icmpne +76 -> 9914
    //   9841: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9844: aconst_null
    //   9845: aload_0
    //   9846: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9849: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9852: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9855: aload 20
    //   9857: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9860: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9863: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9866: getfield 2045	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   9869: invokestatic 2048	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9872: aload 20
    //   9874: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9877: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9880: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9883: getfield 2051	com/tencent/mobileqq/mini/sdk/EntryModel:dwGroupClassExt	J
    //   9886: new 2053	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22
    //   9889: dup
    //   9890: aload_0
    //   9891: aload 21
    //   9893: aload_3
    //   9894: aload_1
    //   9895: iload 4
    //   9897: invokespecial 2054	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9900: invokevirtual 2058	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserGroupInfo	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9903: goto -8315 -> 1588
    //   9906: astore_1
    //   9907: aload_1
    //   9908: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   9911: goto -8323 -> 1588
    //   9914: aload_0
    //   9915: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9918: aload_3
    //   9919: aload_1
    //   9920: aload 21
    //   9922: iload 4
    //   9924: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9927: goto -8339 -> 1588
    //   9930: ldc_w 2060
    //   9933: aload_1
    //   9934: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9937: ifeq +193 -> 10130
    //   9940: new 371	org/json/JSONObject
    //   9943: dup
    //   9944: aload_2
    //   9945: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9948: astore 20
    //   9950: aload 20
    //   9952: ldc_w 1490
    //   9955: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9958: astore_2
    //   9959: aload 20
    //   9961: ldc_w 795
    //   9964: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9967: astore 20
    //   9969: aload_0
    //   9970: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9973: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9976: invokevirtual 291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9979: astore 21
    //   9981: aload 21
    //   9983: ifnull -8395 -> 1588
    //   9986: aload 21
    //   9988: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9991: ifnull -8403 -> 1588
    //   9994: aload 21
    //   9996: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9999: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10002: ifnull -8414 -> 1588
    //   10005: aload 21
    //   10007: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10010: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10013: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10016: ifnull -8428 -> 1588
    //   10019: aload_2
    //   10020: ifnull -8432 -> 1588
    //   10023: aload_2
    //   10024: aload 21
    //   10026: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10029: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10032: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10035: invokevirtual 1499	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   10038: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10041: ifeq -8453 -> 1588
    //   10044: aload 21
    //   10046: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10049: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10052: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10055: getfield 2035	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   10058: ifeq -8470 -> 1588
    //   10061: aload 20
    //   10063: ifnull -8475 -> 1588
    //   10066: aload 20
    //   10068: ldc_w 2062
    //   10071: invokevirtual 2064	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10074: ifeq -8486 -> 1588
    //   10077: aload 20
    //   10079: ldc_w 2062
    //   10082: aload 21
    //   10084: getfield 297	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10087: getfield 549	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10090: getfield 1494	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10093: getfield 2045	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   10096: invokestatic 2048	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   10099: invokevirtual 1890	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   10102: astore_2
    //   10103: aload_0
    //   10104: aload_0
    //   10105: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10108: getfield 278	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   10111: aload_2
    //   10112: aload_3
    //   10113: aload_1
    //   10114: iload 4
    //   10116: invokespecial 2066	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startGroupBrowserActivity	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10119: goto -8531 -> 1588
    //   10122: astore_1
    //   10123: aload_1
    //   10124: invokevirtual 1338	org/json/JSONException:printStackTrace	()V
    //   10127: goto -8539 -> 1588
    //   10130: ldc_w 2068
    //   10133: aload_1
    //   10134: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10137: ifne +13 -> 10150
    //   10140: ldc_w 2070
    //   10143: aload_1
    //   10144: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10147: ifeq +18 -> 10165
    //   10150: aload_0
    //   10151: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10154: aload_3
    //   10155: aload_1
    //   10156: aconst_null
    //   10157: iload 4
    //   10159: invokevirtual 714	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   10162: goto -8574 -> 1588
    //   10165: ldc 20
    //   10167: aload_1
    //   10168: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10171: ifeq +72 -> 10243
    //   10174: new 371	org/json/JSONObject
    //   10177: dup
    //   10178: aload_2
    //   10179: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10182: ldc_w 2072
    //   10185: invokevirtual 508	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10188: astore_2
    //   10189: aload_2
    //   10190: invokestatic 477	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10193: ifne -8605 -> 1588
    //   10196: invokestatic 675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   10199: aload_0
    //   10200: getfield 272	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10203: getfield 282	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   10206: getfield 287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   10209: aconst_null
    //   10210: aload_2
    //   10211: new 2074	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23
    //   10214: dup
    //   10215: aload_0
    //   10216: aload_3
    //   10217: aload_1
    //   10218: iload 4
    //   10220: invokespecial 2075	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10223: invokevirtual 2079	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getTcbTicket	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   10226: goto -8638 -> 1588
    //   10229: astore_1
    //   10230: ldc 150
    //   10232: iconst_1
    //   10233: ldc_w 2081
    //   10236: aload_1
    //   10237: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10240: goto -8652 -> 1588
    //   10243: ldc 83
    //   10245: aload_1
    //   10246: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10249: ifeq -8661 -> 1588
    //   10252: aload_0
    //   10253: aload_3
    //   10254: aload_1
    //   10255: iload 4
    //   10257: invokespecial 2083	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:doShareInvite	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)Z
    //   10260: pop
    //   10261: goto -8673 -> 1588
    //   10264: aconst_null
    //   10265: astore_1
    //   10266: goto -3154 -> 7112
    //   10269: aconst_null
    //   10270: astore 20
    //   10272: goto -3895 -> 6377
    //   10275: goto -4260 -> 6015
    //   10278: aconst_null
    //   10279: astore_2
    //   10280: goto -6203 -> 4077
    //   10283: iload 9
    //   10285: istore 14
    //   10287: goto -7002 -> 3285
    //   10290: iconst_0
    //   10291: istore 16
    //   10293: goto -9742 -> 551
    //   10296: ldc_w 1043
    //   10299: astore 21
    //   10301: goto -9857 -> 444
    //   10304: iconst_m1
    //   10305: istore 8
    //   10307: iconst_m1
    //   10308: istore 7
    //   10310: iconst_m1
    //   10311: istore 11
    //   10313: iconst_0
    //   10314: istore 10
    //   10316: goto -7148 -> 3168
    //   10319: iload 7
    //   10321: istore 8
    //   10323: iload 7
    //   10325: iconst_m1
    //   10326: if_icmpne -6208 -> 4118
    //   10329: iconst_0
    //   10330: istore 8
    //   10332: goto -6214 -> 4118
    //   10335: ldc_w 545
    //   10338: areturn
    //   10339: iload 9
    //   10341: iconst_1
    //   10342: if_icmpne -5961 -> 4381
    //   10345: iconst_1
    //   10346: istore 7
    //   10348: aconst_null
    //   10349: astore_2
    //   10350: goto -6273 -> 4077
    //   10353: iload 9
    //   10355: iconst_3
    //   10356: if_icmpne +11 -> 10367
    //   10359: iconst_3
    //   10360: istore 7
    //   10362: aconst_null
    //   10363: astore_2
    //   10364: goto -6287 -> 4077
    //   10367: iload 9
    //   10369: iconst_4
    //   10370: if_icmpne -5859 -> 4511
    //   10373: iconst_4
    //   10374: istore 7
    //   10376: aconst_null
    //   10377: astore_2
    //   10378: goto -6301 -> 4077
    //   10381: iconst_0
    //   10382: istore 7
    //   10384: goto -6307 -> 4077
    //   10387: iconst_1
    //   10388: istore 16
    //   10390: goto -5389 -> 5001
    //   10393: iconst_0
    //   10394: istore 16
    //   10396: goto -5395 -> 5001
    //   10399: iconst_0
    //   10400: istore 17
    //   10402: goto -5352 -> 5050
    //   10405: bipush 12
    //   10407: istore 4
    //   10409: goto -5312 -> 5097
    //   10412: bipush 12
    //   10414: istore 4
    //   10416: goto -5120 -> 5296
    //   10419: iconst_1
    //   10420: istore 4
    //   10422: goto -4808 -> 5614
    //   10425: iconst_0
    //   10426: istore 4
    //   10428: goto -4814 -> 5614
    //   10431: iconst_0
    //   10432: istore 8
    //   10434: goto -4769 -> 5665
    //   10437: iload 11
    //   10439: iconst_1
    //   10440: iadd
    //   10441: istore 11
    //   10443: goto -4330 -> 6113
    //   10446: iconst_2
    //   10447: istore 7
    //   10449: goto -3851 -> 6598
    //   10452: aconst_null
    //   10453: astore_1
    //   10454: goto -3465 -> 6989
    //   10457: aload 21
    //   10459: astore 20
    //   10461: goto -1879 -> 8582
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10464	0	this	DataJsPlugin
    //   0	10464	1	paramString1	String
    //   0	10464	2	paramString2	String
    //   0	10464	3	paramJsRuntime	JsRuntime
    //   0	10464	4	paramInt	int
    //   218	574	5	d	double
    //   260	10188	7	i	int
    //   256	10177	8	j	int
    //   318	10053	9	k	int
    //   301	10014	10	m	int
    //   653	9789	11	n	int
    //   237	3233	12	i1	int
    //   3019	431	13	i2	int
    //   3283	7003	14	i3	int
    //   211	9544	15	bool1	boolean
    //   549	9846	16	bool2	boolean
    //   5048	5353	17	bool3	boolean
    //   2440	299	18	l	long
    //   338	1021	20	localObject1	Object
    //   1396	9	20	localJSONException1	org.json.JSONException
    //   1656	645	20	localObject2	Object
    //   2321	3	20	localJSONException2	org.json.JSONException
    //   2539	6849	20	localObject3	Object
    //   9482	3	20	localJSONException3	org.json.JSONException
    //   9520	60	20	localApkgInfo1	ApkgInfo
    //   9620	3	20	localJSONException4	org.json.JSONException
    //   9665	795	20	localObject4	Object
    //   439	10019	21	localObject5	Object
    //   73	9154	22	localObject6	Object
    //   2525	5668	23	localObject7	Object
    //   2535	5331	24	str1	String
    //   2530	5344	25	str2	String
    //   2388	2988	26	str3	String
    //   2503	2838	27	str4	String
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
    //   3696	3751	3796	org/json/JSONException
    //   3755	3777	3796	org/json/JSONException
    //   3777	3793	3796	org/json/JSONException
    //   3815	3831	3796	org/json/JSONException
    //   3834	3891	3796	org/json/JSONException
    //   3894	3910	3796	org/json/JSONException
    //   3922	3950	3979	org/json/JSONException
    //   3964	3976	3979	org/json/JSONException
    //   4028	4037	4658	org/json/JSONException
    //   4040	4061	4658	org/json/JSONException
    //   4077	4115	4658	org/json/JSONException
    //   4118	4141	4658	org/json/JSONException
    //   4141	4180	4658	org/json/JSONException
    //   4180	4190	4658	org/json/JSONException
    //   4194	4212	4658	org/json/JSONException
    //   4212	4242	4658	org/json/JSONException
    //   4246	4261	4658	org/json/JSONException
    //   4266	4304	4658	org/json/JSONException
    //   4304	4328	4658	org/json/JSONException
    //   4328	4350	4658	org/json/JSONException
    //   4350	4378	4658	org/json/JSONException
    //   4390	4399	4658	org/json/JSONException
    //   4403	4475	4658	org/json/JSONException
    //   4480	4506	4658	org/json/JSONException
    //   4517	4549	4658	org/json/JSONException
    //   4553	4565	4658	org/json/JSONException
    //   4568	4582	4658	org/json/JSONException
    //   4585	4611	4658	org/json/JSONException
    //   4623	4632	4658	org/json/JSONException
    //   4640	4655	4658	org/json/JSONException
    //   4677	4706	4658	org/json/JSONException
    //   4709	4727	4658	org/json/JSONException
    //   4730	4784	4658	org/json/JSONException
    //   4787	4811	4658	org/json/JSONException
    //   4814	4839	4658	org/json/JSONException
    //   4839	4863	4658	org/json/JSONException
    //   4863	4894	4658	org/json/JSONException
    //   4898	4923	4658	org/json/JSONException
    //   4923	4947	4658	org/json/JSONException
    //   4947	4978	4658	org/json/JSONException
    //   4982	4998	4658	org/json/JSONException
    //   5001	5047	4658	org/json/JSONException
    //   5050	5058	4658	org/json/JSONException
    //   5068	5088	4658	org/json/JSONException
    //   5097	5179	4658	org/json/JSONException
    //   5182	5214	4658	org/json/JSONException
    //   5218	5254	4658	org/json/JSONException
    //   5257	5279	4658	org/json/JSONException
    //   5279	5287	4658	org/json/JSONException
    //   5296	5323	4658	org/json/JSONException
    //   5326	5355	4658	org/json/JSONException
    //   5364	5391	4658	org/json/JSONException
    //   5419	5438	5685	org/json/JSONException
    //   5449	5458	5685	org/json/JSONException
    //   5471	5494	5685	org/json/JSONException
    //   5494	5517	5685	org/json/JSONException
    //   5517	5556	5685	org/json/JSONException
    //   5556	5611	5685	org/json/JSONException
    //   5614	5662	5685	org/json/JSONException
    //   5670	5682	5685	org/json/JSONException
    //   5741	5756	5685	org/json/JSONException
    //   5759	5774	5685	org/json/JSONException
    //   5777	5806	5685	org/json/JSONException
    //   5809	5816	5685	org/json/JSONException
    //   5826	5833	5685	org/json/JSONException
    //   5837	5852	5685	org/json/JSONException
    //   5855	5864	5685	org/json/JSONException
    //   5867	5899	5685	org/json/JSONException
    //   5903	5929	5685	org/json/JSONException
    //   5942	5952	5685	org/json/JSONException
    //   5981	5999	6090	org/json/JSONException
    //   6015	6027	6090	org/json/JSONException
    //   6036	6041	6090	org/json/JSONException
    //   6046	6051	6090	org/json/JSONException
    //   6056	6061	6090	org/json/JSONException
    //   6066	6071	6090	org/json/JSONException
    //   6071	6087	6090	org/json/JSONException
    //   6113	6130	6090	org/json/JSONException
    //   6130	6140	6090	org/json/JSONException
    //   6143	6153	6090	org/json/JSONException
    //   6156	6166	6090	org/json/JSONException
    //   6169	6179	6090	org/json/JSONException
    //   6185	6201	6090	org/json/JSONException
    //   6204	6230	6090	org/json/JSONException
    //   6235	6249	6090	org/json/JSONException
    //   6254	6268	6090	org/json/JSONException
    //   6273	6287	6090	org/json/JSONException
    //   6292	6306	6090	org/json/JSONException
    //   6306	6322	6090	org/json/JSONException
    //   6325	6341	6090	org/json/JSONException
    //   6397	6417	6520	java/lang/Throwable
    //   6421	6436	6520	java/lang/Throwable
    //   6436	6453	6520	java/lang/Throwable
    //   6458	6484	6520	java/lang/Throwable
    //   6489	6517	6520	java/lang/Throwable
    //   6540	6549	6520	java/lang/Throwable
    //   6559	6575	6520	java/lang/Throwable
    //   6579	6595	6520	java/lang/Throwable
    //   6604	6616	6520	java/lang/Throwable
    //   6619	6631	6520	java/lang/Throwable
    //   6634	6646	6520	java/lang/Throwable
    //   6658	6798	6801	org/json/JSONException
    //   6829	6876	6879	org/json/JSONException
    //   7004	7014	7045	org/json/JSONException
    //   6948	6980	7064	org/json/JSONException
    //   6984	6989	7064	org/json/JSONException
    //   6989	7004	7064	org/json/JSONException
    //   7014	7045	7064	org/json/JSONException
    //   7046	7061	7064	org/json/JSONException
    //   7322	7354	7483	org/json/JSONException
    //   7358	7374	7483	org/json/JSONException
    //   7377	7397	7483	org/json/JSONException
    //   7406	7423	7483	org/json/JSONException
    //   7427	7450	7483	org/json/JSONException
    //   7450	7480	7483	org/json/JSONException
    //   7541	7632	7943	org/json/JSONException
    //   7636	7673	7943	org/json/JSONException
    //   7682	7697	7943	org/json/JSONException
    //   7701	7724	7943	org/json/JSONException
    //   7728	7745	7943	org/json/JSONException
    //   7748	7777	7943	org/json/JSONException
    //   7781	7796	7943	org/json/JSONException
    //   7803	7821	7943	org/json/JSONException
    //   7827	7856	7943	org/json/JSONException
    //   7862	7880	7943	org/json/JSONException
    //   7883	7941	7943	org/json/JSONException
    //   8087	8098	8292	org/json/JSONException
    //   8100	8121	8292	org/json/JSONException
    //   8123	8175	8292	org/json/JSONException
    //   8177	8265	8292	org/json/JSONException
    //   8265	8271	8292	org/json/JSONException
    //   8274	8280	8292	org/json/JSONException
    //   8283	8289	8292	org/json/JSONException
    //   8335	8402	8894	java/lang/Throwable
    //   8404	8428	8894	java/lang/Throwable
    //   8433	8467	8894	java/lang/Throwable
    //   8469	8476	8894	java/lang/Throwable
    //   8481	8511	8894	java/lang/Throwable
    //   8518	8532	8894	java/lang/Throwable
    //   8532	8542	8894	java/lang/Throwable
    //   8542	8572	8894	java/lang/Throwable
    //   8582	8675	8894	java/lang/Throwable
    //   8678	8686	8894	java/lang/Throwable
    //   8690	8732	8894	java/lang/Throwable
    //   8732	8891	8894	java/lang/Throwable
    //   8910	8942	8894	java/lang/Throwable
    //   8949	8964	8894	java/lang/Throwable
    //   8967	8987	8894	java/lang/Throwable
    //   8532	8542	8909	java/io/UnsupportedEncodingException
    //   8999	9040	9094	java/lang/Throwable
    //   9044	9067	9094	java/lang/Throwable
    //   9067	9091	9094	java/lang/Throwable
    //   9125	9155	9274	java/lang/Throwable
    //   9159	9166	9274	java/lang/Throwable
    //   9169	9232	9274	java/lang/Throwable
    //   9241	9271	9274	java/lang/Throwable
    //   9313	9337	9407	java/lang/Throwable
    //   9341	9348	9407	java/lang/Throwable
    //   9351	9375	9407	java/lang/Throwable
    //   9384	9404	9407	java/lang/Throwable
    //   9443	9467	9482	org/json/JSONException
    //   9510	9522	9620	org/json/JSONException
    //   9538	9546	9620	org/json/JSONException
    //   9550	9561	9620	org/json/JSONException
    //   9565	9595	9620	org/json/JSONException
    //   9595	9605	9620	org/json/JSONException
    //   9640	9676	9906	org/json/JSONException
    //   9692	9700	9906	org/json/JSONException
    //   9704	9715	9906	org/json/JSONException
    //   9719	9749	9906	org/json/JSONException
    //   9749	9760	9906	org/json/JSONException
    //   9765	9798	9906	org/json/JSONException
    //   9802	9903	9906	org/json/JSONException
    //   9914	9927	9906	org/json/JSONException
    //   9940	9981	10122	org/json/JSONException
    //   9986	10019	10122	org/json/JSONException
    //   10023	10061	10122	org/json/JSONException
    //   10066	10119	10122	org/json/JSONException
    //   10174	10226	10229	java/lang/Throwable
  }
  
  public void login(acjr paramacjr)
  {
    if (paramacjr == null) {
      return;
    }
    ThreadManager.excute(new DataJsPlugin.27(this, paramacjr), 16, null, false);
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