package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import acqx;
import adea;
import aded;
import adei;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import yqp;

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
  private aded apiManager;
  private Long lastNotRspReqTime = Long.valueOf(0L);
  private List<adea> loginCallBacks = new LinkedList();
  protected GdtAppReceiver mGgtAppReceiver;
  private SystemInfoManager mSystemInfoManager;
  private ArrayList<String> openUrlDomainWhiteList;
  private String privateOpenUrlDomainWhiteList;
  
  private boolean doShareInvite(JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
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
      yqp.b("[mini] DataJsPlugin", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label45:
      yqp.b("[mini] DataJsPlugin", "start load URLDrawable.");
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
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(acqx.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
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
            break label142;
          }
          bool = true;
          ((SystemInfoManager)localObject2).setLandscape(bool);
          this.mSystemInfoManager.setGameUI((IGameUI)localObject1);
        }
      }
      for (localObject1 = this.mSystemInfoManager.getSystemInfo();; localObject1 = ApiUtil.wrapCallbackFail(paramString, null))
      {
        if (!"getSystemInfoSync".equals(paramString)) {
          break label167;
        }
        return ((JSONObject)localObject1).toString();
        label142:
        bool = false;
        break;
        QLog.e("[mini] DataJsPlugin", 1, "getSystemInfo error, context is not GameActivity");
      }
      label167:
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
    adei.a();
    this.apiManager = adei.a(this.jsPluginEngine.getActivityContext(), paramInt, paramString);
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
  
  /* Error */
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 863	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc 150
    //   8: iconst_2
    //   9: new 398	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 865
    //   19: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 867
    //   29: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 869
    //   39: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 747	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 517	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_3
    //   54: ifnonnull +18 -> 72
    //   57: ldc 150
    //   59: iconst_4
    //   60: ldc_w 871
    //   63: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: ldc_w 525
    //   69: astore_2
    //   70: aload_2
    //   71: areturn
    //   72: aconst_null
    //   73: astore 22
    //   75: aload_0
    //   76: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   79: ifnull +12 -> 91
    //   82: aload_0
    //   83: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   86: invokevirtual 559	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   89: astore 22
    //   91: aload 22
    //   93: ifnull +26 -> 119
    //   96: new 398	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   103: aload_1
    //   104: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 22
    //   109: invokevirtual 876	java/lang/Object:hashCode	()I
    //   112: invokevirtual 747	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: pop
    //   119: ldc 35
    //   121: aload_1
    //   122: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +12 -> 137
    //   128: ldc 38
    //   130: aload_1
    //   131: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +1149 -> 1283
    //   137: aload 22
    //   139: ifnull +1112 -> 1251
    //   142: aload_0
    //   143: getfield 880	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isGameRuntime	Z
    //   146: ifeq +12 -> 158
    //   149: aload_0
    //   150: aload_1
    //   151: aload_3
    //   152: iload 4
    //   154: invokespecial 882	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleGameSystemInfo	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)Ljava/lang/String;
    //   157: areturn
    //   158: getstatic 887	android/os/Build$VERSION:SDK_INT	I
    //   161: bipush 17
    //   163: if_icmplt +800 -> 963
    //   166: new 889	android/util/DisplayMetrics
    //   169: dup
    //   170: invokespecial 890	android/util/DisplayMetrics:<init>	()V
    //   173: astore_2
    //   174: aload 22
    //   176: ldc_w 892
    //   179: invokevirtual 896	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   182: checkcast 898	android/view/WindowManager
    //   185: invokeinterface 902 1 0
    //   190: aload_2
    //   191: invokevirtual 908	android/view/Display:getRealMetrics	(Landroid/util/DisplayMetrics;)V
    //   194: getstatic 913	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   197: ldc_w 915
    //   200: invokevirtual 918	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   203: ifeq +772 -> 975
    //   206: aload 22
    //   208: invokestatic 924	com/tencent/mobileqq/mini/util/DisplayUtil:checkNavigationBarShow	(Landroid/content/Context;)Z
    //   211: istore 15
    //   213: aload_2
    //   214: getfield 928	android/util/DisplayMetrics:density	F
    //   217: f2d
    //   218: dstore 5
    //   220: aload_2
    //   221: getfield 931	android/util/DisplayMetrics:widthPixels	I
    //   224: i2d
    //   225: dload 5
    //   227: ddiv
    //   228: invokestatic 937	java/lang/Math:round	(D)J
    //   231: l2f
    //   232: ldc_w 938
    //   235: fadd
    //   236: f2i
    //   237: istore 9
    //   239: aload_2
    //   240: getfield 941	android/util/DisplayMetrics:heightPixels	I
    //   243: i2d
    //   244: dload 5
    //   246: ddiv
    //   247: invokestatic 937	java/lang/Math:round	(D)J
    //   250: l2f
    //   251: ldc_w 938
    //   254: fadd
    //   255: f2i
    //   256: istore 8
    //   258: iload 8
    //   260: istore 7
    //   262: iload 15
    //   264: ifeq +23 -> 287
    //   267: iload 8
    //   269: aload_0
    //   270: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   273: invokevirtual 559	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   276: invokestatic 945	com/tencent/mobileqq/mini/util/DisplayUtil:getNavigationBarHeight	(Landroid/content/Context;)I
    //   279: i2d
    //   280: dload 5
    //   282: ddiv
    //   283: d2i
    //   284: isub
    //   285: istore 7
    //   287: aload 22
    //   289: invokestatic 950	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   292: i2f
    //   293: invokestatic 953	java/lang/Math:round	(F)I
    //   296: i2d
    //   297: dload 5
    //   299: ddiv
    //   300: d2i
    //   301: istore 10
    //   303: ldc_w 954
    //   306: invokestatic 958	bgtn:b	(F)I
    //   309: i2d
    //   310: dload 5
    //   312: ddiv
    //   313: ldc2_w 959
    //   316: dadd
    //   317: d2i
    //   318: istore 11
    //   320: ldc_w 961
    //   323: invokestatic 958	bgtn:b	(F)I
    //   326: i2d
    //   327: dload 5
    //   329: ddiv
    //   330: ldc2_w 959
    //   333: dadd
    //   334: d2i
    //   335: istore 8
    //   337: aconst_null
    //   338: astore 20
    //   340: aload_0
    //   341: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   344: ifnull +665 -> 1009
    //   347: aload_0
    //   348: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   351: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   354: ifnull +655 -> 1009
    //   357: aload_0
    //   358: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   361: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   364: invokevirtual 965	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   367: ifnull +642 -> 1009
    //   370: aload_0
    //   371: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   374: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   377: invokevirtual 965	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   380: invokevirtual 970	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   383: ifnull +626 -> 1009
    //   386: aload_0
    //   387: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   390: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   393: invokevirtual 965	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   396: invokevirtual 970	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   399: astore 20
    //   401: aload 20
    //   403: astore_2
    //   404: aload 20
    //   406: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   409: ifne +10114 -> 10523
    //   412: aload_0
    //   413: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   416: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   419: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   422: invokevirtual 974	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   425: aload 20
    //   427: invokevirtual 980	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   430: getfield 986	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   433: getfield 992	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   436: getfield 997	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   439: astore 21
    //   441: aload 20
    //   443: astore_2
    //   444: aload_0
    //   445: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   448: ifnull +10069 -> 10517
    //   451: aload_0
    //   452: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   455: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   458: ifnull +10059 -> 10517
    //   461: aload_0
    //   462: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   465: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   468: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   471: ifnull +10046 -> 10517
    //   474: aload_0
    //   475: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   478: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   481: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   484: invokevirtual 974	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   487: ifnull +10030 -> 10517
    //   490: aload_0
    //   491: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   494: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   497: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   500: invokevirtual 974	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   503: getfield 1001	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   506: ifnull +712 -> 1218
    //   509: aload_0
    //   510: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   513: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   516: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   519: aload_2
    //   520: invokevirtual 1004	com/tencent/mobileqq/mini/apkg/ApkgInfo:isTabBarPage	(Ljava/lang/String;)Z
    //   523: ifeq +695 -> 1218
    //   526: aload_0
    //   527: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   530: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   533: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   536: invokevirtual 974	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   539: getfield 1001	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   542: invokevirtual 1009	com/tencent/mobileqq/mini/apkg/TabBarInfo:isShow	()Z
    //   545: ifeq +673 -> 1218
    //   548: iconst_1
    //   549: istore 16
    //   551: ldc_w 1011
    //   554: aload 21
    //   556: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   559: ifeq +671 -> 1230
    //   562: iload 16
    //   564: ifeq +660 -> 1224
    //   567: iload 7
    //   569: iload 10
    //   571: isub
    //   572: iload 11
    //   574: isub
    //   575: iload 8
    //   577: isub
    //   578: istore 8
    //   580: invokestatic 1014	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   583: ifeq +63 -> 646
    //   586: ldc 150
    //   588: iconst_1
    //   589: new 398	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   596: ldc_w 1016
    //   599: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: iload 8
    //   604: invokevirtual 747	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   607: ldc_w 1018
    //   610: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 21
    //   615: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 1020
    //   621: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: iload 16
    //   626: invokevirtual 1023	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   629: ldc_w 1025
    //   632: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: iload 15
    //   637: invokevirtual 1023	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   640: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: invokestatic 1031	com/tencent/mobileqq/mini/app/AppLoaderFactory:getAppLoaderManager	()Lcom/tencent/mobileqq/mini/app/BaseAppLoaderManager;
    //   649: invokeinterface 1037 1 0
    //   654: getfield 1042	com/tencent/mobileqq/mini/sdk/BaseLibInfo:baseLibVersion	Ljava/lang/String;
    //   657: astore_2
    //   658: new 348	org/json/JSONObject
    //   661: dup
    //   662: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   665: astore 20
    //   667: aload 20
    //   669: ldc_w 1045
    //   672: getstatic 1048	android/os/Build:BRAND	Ljava/lang/String;
    //   675: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   678: pop
    //   679: aload 20
    //   681: ldc_w 1054
    //   684: getstatic 1057	android/os/Build:MODEL	Ljava/lang/String;
    //   687: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   690: pop
    //   691: aload 20
    //   693: ldc_w 1059
    //   696: dload 5
    //   698: invokevirtual 1062	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   701: pop
    //   702: aload 20
    //   704: ldc_w 1064
    //   707: iload 9
    //   709: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   712: pop
    //   713: aload 20
    //   715: ldc_w 1069
    //   718: iload 7
    //   720: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   723: pop
    //   724: aload 20
    //   726: ldc_w 1071
    //   729: iload 9
    //   731: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   734: pop
    //   735: aload 20
    //   737: ldc_w 1073
    //   740: iload 8
    //   742: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   745: pop
    //   746: aload 20
    //   748: ldc_w 1075
    //   751: iload 10
    //   753: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   756: pop
    //   757: aload 20
    //   759: ldc_w 1077
    //   762: ldc_w 1079
    //   765: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   768: pop
    //   769: aload 20
    //   771: ldc_w 1081
    //   774: invokestatic 1086	bgln:c	()Ljava/lang/String;
    //   777: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   780: pop
    //   781: aload 20
    //   783: ldc_w 1088
    //   786: new 398	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   793: ldc_w 1090
    //   796: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: getstatic 1093	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   802: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   811: pop
    //   812: aload 20
    //   814: ldc_w 1095
    //   817: ldc_w 1097
    //   820: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   823: pop
    //   824: aload 20
    //   826: ldc_w 1099
    //   829: bipush 16
    //   831: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   834: pop
    //   835: aload 20
    //   837: ldc_w 1101
    //   840: aload_2
    //   841: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   844: pop
    //   845: aload 20
    //   847: ldc_w 1103
    //   850: ldc 124
    //   852: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   855: pop
    //   856: aload 20
    //   858: ldc_w 1105
    //   861: aload 22
    //   863: invokestatic 1109	com/tencent/mobileqq/mini/util/DisplayUtil:getDisplayCutoutSafeArea	(Landroid/app/Activity;)Lorg/json/JSONObject;
    //   866: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   869: pop
    //   870: aload_1
    //   871: aload 20
    //   873: invokestatic 1112	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   876: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   879: astore 20
    //   881: aload 20
    //   883: astore_2
    //   884: ldc 35
    //   886: aload_1
    //   887: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   890: ifeq -820 -> 70
    //   893: aload_3
    //   894: iload 4
    //   896: aload 20
    //   898: invokeinterface 623 3 0
    //   903: aload 20
    //   905: areturn
    //   906: astore_2
    //   907: ldc 150
    //   909: iconst_1
    //   910: new 398	java/lang/StringBuilder
    //   913: dup
    //   914: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   917: ldc_w 1114
    //   920: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: new 245	java/lang/Throwable
    //   926: dup
    //   927: aload_2
    //   928: invokespecial 1117	java/lang/Throwable:<init>	(Ljava/lang/Throwable;)V
    //   931: invokevirtual 1120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   934: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   940: aload_1
    //   941: aconst_null
    //   942: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   945: astore_1
    //   946: aload_3
    //   947: iload 4
    //   949: aload_1
    //   950: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   953: invokeinterface 623 3 0
    //   958: aload_1
    //   959: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   962: areturn
    //   963: aload 22
    //   965: invokevirtual 1124	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   968: invokevirtual 1130	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   971: astore_2
    //   972: goto -778 -> 194
    //   975: aload 22
    //   977: invokestatic 1133	com/tencent/mobileqq/mini/util/DisplayUtil:hasNavBar	(Landroid/content/Context;)Z
    //   980: ifeq +11 -> 991
    //   983: aload 22
    //   985: invokestatic 1137	com/tencent/mobileqq/mini/util/DisplayUtil:isNavigationBarExist	(Landroid/app/Activity;)Z
    //   988: ifne +9 -> 997
    //   991: invokestatic 1140	com/tencent/mobileqq/mini/util/DisplayUtil:isFlymeOS7NavBarShow	()Z
    //   994: ifeq +9 -> 1003
    //   997: iconst_1
    //   998: istore 15
    //   1000: goto -787 -> 213
    //   1003: iconst_0
    //   1004: istore 15
    //   1006: goto -793 -> 213
    //   1009: aload 20
    //   1011: astore_2
    //   1012: aload_0
    //   1013: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1016: ifnull +9507 -> 10523
    //   1019: aload 20
    //   1021: astore_2
    //   1022: aload_0
    //   1023: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1026: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1029: ifnull +9494 -> 10523
    //   1032: aload 20
    //   1034: astore_2
    //   1035: aload_0
    //   1036: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1039: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1042: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1045: ifnull +9478 -> 10523
    //   1048: aconst_null
    //   1049: astore 20
    //   1051: aload 20
    //   1053: astore_2
    //   1054: aload_0
    //   1055: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1058: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1061: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1064: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1067: ifnull +45 -> 1112
    //   1070: aload 20
    //   1072: astore_2
    //   1073: aload_0
    //   1074: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1077: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1080: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1083: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1086: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1089: ifnull +23 -> 1112
    //   1092: aload_0
    //   1093: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1096: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1099: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1102: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1105: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1108: getfield 534	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   1111: astore_2
    //   1112: aconst_null
    //   1113: astore 20
    //   1115: aload_0
    //   1116: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1119: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1122: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1125: getfield 1144	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1128: ifnull +21 -> 1149
    //   1131: aload_0
    //   1132: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1135: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1138: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1141: getfield 1144	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1144: getfield 1147	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   1147: astore 20
    //   1149: aload_0
    //   1150: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1153: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1156: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1159: aload_2
    //   1160: invokevirtual 1150	com/tencent/mobileqq/mini/apkg/ApkgInfo:isUrlFileExist	(Ljava/lang/String;)Z
    //   1163: ifne +49 -> 1212
    //   1166: aload 20
    //   1168: astore_2
    //   1169: aload 20
    //   1171: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1174: ifne +9349 -> 10523
    //   1177: aload_0
    //   1178: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1181: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1184: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1187: invokevirtual 974	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1190: aload 20
    //   1192: invokevirtual 980	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   1195: getfield 986	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   1198: getfield 992	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   1201: getfield 997	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   1204: astore 21
    //   1206: aload 20
    //   1208: astore_2
    //   1209: goto -765 -> 444
    //   1212: aload_2
    //   1213: astore 20
    //   1215: goto -49 -> 1166
    //   1218: iconst_0
    //   1219: istore 16
    //   1221: goto -670 -> 551
    //   1224: iconst_0
    //   1225: istore 8
    //   1227: goto -660 -> 567
    //   1230: iload 16
    //   1232: ifeq +13 -> 1245
    //   1235: iload 7
    //   1237: iload 8
    //   1239: isub
    //   1240: istore 8
    //   1242: goto -662 -> 580
    //   1245: iconst_0
    //   1246: istore 8
    //   1248: goto -13 -> 1235
    //   1251: ldc 150
    //   1253: iconst_1
    //   1254: ldc_w 1152
    //   1257: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1260: aload_1
    //   1261: aconst_null
    //   1262: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1265: astore_1
    //   1266: aload_3
    //   1267: iload 4
    //   1269: aload_1
    //   1270: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1273: invokeinterface 623 3 0
    //   1278: aload_1
    //   1279: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1282: areturn
    //   1283: ldc_w 1154
    //   1286: aload_1
    //   1287: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1290: ifeq +135 -> 1425
    //   1293: iconst_0
    //   1294: istore 8
    //   1296: iload 8
    //   1298: istore 7
    //   1300: aload_2
    //   1301: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1304: ifne +70 -> 1374
    //   1307: new 348	org/json/JSONObject
    //   1310: dup
    //   1311: aload_2
    //   1312: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1315: ldc_w 1156
    //   1318: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1321: astore_1
    //   1322: iload 8
    //   1324: istore 7
    //   1326: aload_1
    //   1327: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1330: ifne +44 -> 1374
    //   1333: iconst_1
    //   1334: istore 7
    //   1336: aload 22
    //   1338: new 764	android/content/Intent
    //   1341: dup
    //   1342: ldc_w 1158
    //   1345: new 398	java/lang/StringBuilder
    //   1348: dup
    //   1349: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   1352: ldc_w 1160
    //   1355: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: aload_1
    //   1359: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1365: invokestatic 1166	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1368: invokespecial 1169	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1371: invokevirtual 1173	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1374: iload 7
    //   1376: ifeq +38 -> 1414
    //   1379: ldc_w 1154
    //   1382: aconst_null
    //   1383: invokestatic 1112	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1386: astore_1
    //   1387: aload_1
    //   1388: ifnull +15 -> 1403
    //   1391: aload_3
    //   1392: iload 4
    //   1394: aload_1
    //   1395: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1398: invokeinterface 623 3 0
    //   1403: ldc_w 525
    //   1406: areturn
    //   1407: astore_1
    //   1408: iconst_0
    //   1409: istore 7
    //   1411: goto -37 -> 1374
    //   1414: ldc_w 1154
    //   1417: aconst_null
    //   1418: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1421: astore_1
    //   1422: goto -35 -> 1387
    //   1425: ldc_w 1175
    //   1428: aload_1
    //   1429: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1432: ifeq +190 -> 1622
    //   1435: ldc 150
    //   1437: iconst_2
    //   1438: iconst_2
    //   1439: anewarray 873	java/lang/Object
    //   1442: dup
    //   1443: iconst_0
    //   1444: ldc_w 1176
    //   1447: aastore
    //   1448: dup
    //   1449: iconst_1
    //   1450: aload_2
    //   1451: aastore
    //   1452: invokestatic 1179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1455: new 348	org/json/JSONObject
    //   1458: dup
    //   1459: aload_2
    //   1460: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1463: astore_2
    //   1464: aload_2
    //   1465: ldc_w 479
    //   1468: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1471: astore 20
    //   1473: aload 20
    //   1475: ldc_w 1181
    //   1478: ldc_w 525
    //   1481: invokevirtual 1183	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1484: astore 21
    //   1486: aload 20
    //   1488: ldc_w 1185
    //   1491: iconst_1
    //   1492: invokevirtual 1188	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1495: pop
    //   1496: ldc_w 1190
    //   1499: aload 21
    //   1501: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1504: ifeq +49 -> 1553
    //   1507: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1510: aload_0
    //   1511: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1514: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1517: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1520: new 1192	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2
    //   1523: dup
    //   1524: aload_0
    //   1525: aload_3
    //   1526: aload_1
    //   1527: iload 4
    //   1529: aload_2
    //   1530: invokespecial 1195	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILorg/json/JSONObject;)V
    //   1533: invokevirtual 1197	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getPhoneNumber	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1536: goto -133 -> 1403
    //   1539: astore_1
    //   1540: ldc 150
    //   1542: iconst_2
    //   1543: ldc_w 1176
    //   1546: aload_1
    //   1547: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1550: goto -147 -> 1403
    //   1553: ldc 150
    //   1555: iconst_1
    //   1556: new 398	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   1563: ldc_w 1199
    //   1566: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload 21
    //   1571: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: ldc_w 1201
    //   1577: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1583: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1586: aload_0
    //   1587: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1590: aload_3
    //   1591: aload_1
    //   1592: aconst_null
    //   1593: new 398	java/lang/StringBuilder
    //   1596: dup
    //   1597: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   1600: aload 21
    //   1602: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: ldc_w 1201
    //   1608: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1614: iload 4
    //   1616: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   1619: goto -216 -> 1403
    //   1622: ldc 50
    //   1624: aload_1
    //   1625: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1628: ifeq +86 -> 1714
    //   1631: ldc 150
    //   1633: iconst_2
    //   1634: new 398	java/lang/StringBuilder
    //   1637: dup
    //   1638: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   1641: ldc_w 1203
    //   1644: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1647: iload 4
    //   1649: invokevirtual 747	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1652: ldc_w 1205
    //   1655: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: aload_0
    //   1659: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1662: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1665: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1668: getfield 1144	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1671: getfield 1208	com/tencent/mobileqq/mini/apkg/AppConfigInfo:PackageToolVersion	Ljava/lang/String;
    //   1674: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1677: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1680: invokestatic 517	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1683: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1686: aload_0
    //   1687: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1690: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1693: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1696: new 1210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3
    //   1699: dup
    //   1700: aload_0
    //   1701: aload_3
    //   1702: aload_1
    //   1703: iload 4
    //   1705: invokespecial 1211	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1708: invokevirtual 660	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getLoginCode	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1711: goto -308 -> 1403
    //   1714: ldc_w 1213
    //   1717: aload_1
    //   1718: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1721: ifeq +1387 -> 3108
    //   1724: new 348	org/json/JSONObject
    //   1727: dup
    //   1728: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   1731: pop
    //   1732: new 348	org/json/JSONObject
    //   1735: dup
    //   1736: aload_2
    //   1737: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1740: astore 20
    //   1742: aload 20
    //   1744: ldc_w 479
    //   1747: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1750: astore 22
    //   1752: aload 22
    //   1754: ldc_w 1181
    //   1757: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1760: astore 21
    //   1762: ldc 150
    //   1764: iconst_2
    //   1765: new 398	java/lang/StringBuilder
    //   1768: dup
    //   1769: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   1772: ldc_w 1215
    //   1775: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1778: aload 21
    //   1780: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1786: invokestatic 517	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1789: ldc_w 1217
    //   1792: aload 21
    //   1794: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1797: ifne +14 -> 1811
    //   1800: ldc_w 1219
    //   1803: aload 21
    //   1805: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1808: ifeq +101 -> 1909
    //   1811: aload 22
    //   1813: ldc_w 1185
    //   1816: invokevirtual 632	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1819: istore 15
    //   1821: aload 22
    //   1823: ldc_w 634
    //   1826: aconst_null
    //   1827: invokevirtual 1183	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1830: astore 20
    //   1832: aload 22
    //   1834: ldc_w 479
    //   1837: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1840: astore_2
    //   1841: aload_2
    //   1842: ifnull +49 -> 1891
    //   1845: aload_2
    //   1846: ldc_w 634
    //   1849: ldc_w 1221
    //   1852: invokevirtual 1183	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1855: astore_2
    //   1856: aload_0
    //   1857: aload_3
    //   1858: aload_1
    //   1859: aload 21
    //   1861: iload 4
    //   1863: iload 15
    //   1865: aload_2
    //   1866: invokevirtual 1223	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getUserInfo	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V
    //   1869: goto -466 -> 1403
    //   1872: astore_1
    //   1873: ldc 150
    //   1875: iconst_1
    //   1876: aload_1
    //   1877: iconst_0
    //   1878: anewarray 873	java/lang/Object
    //   1881: invokestatic 1226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1884: aload_1
    //   1885: invokevirtual 644	java/lang/Exception:printStackTrace	()V
    //   1888: goto -485 -> 1403
    //   1891: aload 20
    //   1893: astore_2
    //   1894: aload 20
    //   1896: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1899: ifeq -43 -> 1856
    //   1902: ldc_w 1221
    //   1905: astore_2
    //   1906: goto -50 -> 1856
    //   1909: ldc_w 1228
    //   1912: aload 21
    //   1914: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1917: ifeq +16 -> 1933
    //   1920: aload_0
    //   1921: aload 22
    //   1923: aload_3
    //   1924: aload_1
    //   1925: iload 4
    //   1927: invokespecial 1230	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleWebapiPluginSetauth	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1930: goto -527 -> 1403
    //   1933: ldc_w 1232
    //   1936: aload 21
    //   1938: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1941: ifeq +16 -> 1957
    //   1944: aload_0
    //   1945: aload 22
    //   1947: aload_3
    //   1948: aload_1
    //   1949: iload 4
    //   1951: invokespecial 1234	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleWebapiPluginLogin	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1954: goto -551 -> 1403
    //   1957: ldc_w 1236
    //   1960: aload 21
    //   1962: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1965: ifeq +18 -> 1983
    //   1968: aload_0
    //   1969: aload 22
    //   1971: aload_3
    //   1972: aload_1
    //   1973: iload 4
    //   1975: aload 21
    //   1977: invokespecial 1238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleWebapiPluginGetuserinfo	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILjava/lang/String;)V
    //   1980: goto -577 -> 1403
    //   1983: ldc_w 1240
    //   1986: aload 21
    //   1988: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1991: ifeq +47 -> 2038
    //   1994: new 1242	Wallet/IsUinFocusMpIdReq
    //   1997: dup
    //   1998: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2001: invokevirtual 1246	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   2004: invokevirtual 1251	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   2007: aload_0
    //   2008: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2011: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2014: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2017: invokespecial 1253	Wallet/IsUinFocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   2020: new 1255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4
    //   2023: dup
    //   2024: aload_0
    //   2025: aload_3
    //   2026: aload_1
    //   2027: iload 4
    //   2029: invokespecial 1256	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2032: invokestatic 1261	akmf:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   2035: goto -632 -> 1403
    //   2038: ldc_w 1263
    //   2041: aload 21
    //   2043: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2046: ifeq +141 -> 2187
    //   2049: aload 20
    //   2051: ldc_w 1265
    //   2054: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2057: ldc_w 1267
    //   2060: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2063: astore_2
    //   2064: ldc 112
    //   2066: aload_0
    //   2067: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2070: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2073: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2076: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2079: ifeq +75 -> 2154
    //   2082: ldc 150
    //   2084: iconst_1
    //   2085: ldc_w 1269
    //   2088: invokestatic 517	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2091: new 348	org/json/JSONObject
    //   2094: dup
    //   2095: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   2098: astore_2
    //   2099: new 348	org/json/JSONObject
    //   2102: dup
    //   2103: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   2106: astore 20
    //   2108: aload 20
    //   2110: ldc_w 479
    //   2113: ldc 156
    //   2115: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2118: pop
    //   2119: aload_2
    //   2120: ldc_w 1271
    //   2123: aload 20
    //   2125: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2128: pop
    //   2129: aload_0
    //   2130: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2133: aload_3
    //   2134: aload_1
    //   2135: aload_2
    //   2136: iload 4
    //   2138: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2141: goto -738 -> 1403
    //   2144: astore 20
    //   2146: aload 20
    //   2148: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   2151: goto -22 -> 2129
    //   2154: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2157: aload_0
    //   2158: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2161: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2164: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2167: aload_2
    //   2168: aconst_null
    //   2169: new 1274	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5
    //   2172: dup
    //   2173: aload_0
    //   2174: aload_3
    //   2175: aload_1
    //   2176: iload 4
    //   2178: invokespecial 1275	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2181: invokevirtual 1278	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkNavigateRight	(Ljava/lang/String;Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2184: goto -781 -> 1403
    //   2187: ldc_w 1280
    //   2190: aload 21
    //   2192: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2195: ifeq +405 -> 2600
    //   2198: aload 22
    //   2200: ldc_w 479
    //   2203: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2206: ldc_w 485
    //   2209: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2212: astore 26
    //   2214: iconst_2
    //   2215: istore 7
    //   2217: aload 22
    //   2219: ldc_w 479
    //   2222: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2225: ldc_w 490
    //   2228: invokevirtual 494	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2231: ifeq +19 -> 2250
    //   2234: aload 22
    //   2236: ldc_w 479
    //   2239: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2242: ldc_w 490
    //   2245: invokevirtual 498	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2248: istore 7
    //   2250: aload_0
    //   2251: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2254: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2257: invokevirtual 505	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   2260: invokestatic 508	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   2263: invokevirtual 512	java/lang/Long:longValue	()J
    //   2266: lstore 18
    //   2268: aconst_null
    //   2269: astore_2
    //   2270: aload_0
    //   2271: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2274: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2277: ifnull +14 -> 2291
    //   2280: aload_0
    //   2281: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2284: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2287: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2290: astore_2
    //   2291: ldc 150
    //   2293: iconst_2
    //   2294: new 398	java/lang/StringBuilder
    //   2297: dup
    //   2298: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   2301: ldc_w 1282
    //   2304: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2307: aload_2
    //   2308: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2311: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2314: invokestatic 517	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2317: aload_2
    //   2318: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2321: ifne -918 -> 1403
    //   2324: iload 7
    //   2326: invokestatic 523	com/tencent/mobileqq/mini/util/AdUtils:getSpAdGdtCookie	(I)Ljava/lang/String;
    //   2329: astore 27
    //   2331: aload_0
    //   2332: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2335: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2338: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   2341: astore 28
    //   2343: ldc_w 525
    //   2346: astore 21
    //   2348: ldc_w 525
    //   2351: astore 23
    //   2353: ldc_w 525
    //   2356: astore 25
    //   2358: ldc_w 525
    //   2361: astore 24
    //   2363: aload 21
    //   2365: astore 20
    //   2367: aload 28
    //   2369: ifnull +61 -> 2430
    //   2372: aload 21
    //   2374: astore 20
    //   2376: aload 28
    //   2378: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2381: ifnull +49 -> 2430
    //   2384: aload 21
    //   2386: astore 20
    //   2388: aload 28
    //   2390: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2393: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2396: ifnull +34 -> 2430
    //   2399: aload 21
    //   2401: astore 20
    //   2403: aload 28
    //   2405: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2408: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2411: getfield 534	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2414: ifnull +16 -> 2430
    //   2417: aload 28
    //   2419: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2422: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2425: getfield 534	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2428: astore 20
    //   2430: aload 23
    //   2432: astore 22
    //   2434: aload 25
    //   2436: astore 21
    //   2438: aload 28
    //   2440: ifnull +67 -> 2507
    //   2443: aload 23
    //   2445: astore 22
    //   2447: aload 25
    //   2449: astore 21
    //   2451: aload 28
    //   2453: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2456: ifnull +51 -> 2507
    //   2459: aload 23
    //   2461: astore 22
    //   2463: aload 25
    //   2465: astore 21
    //   2467: aload 28
    //   2469: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2472: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2475: ifnull +32 -> 2507
    //   2478: aload 28
    //   2480: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2483: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2486: getfield 537	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/lang/String;
    //   2489: astore 22
    //   2491: aload 28
    //   2493: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2496: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2499: getfield 540	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   2502: invokestatic 542	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2505: astore 21
    //   2507: aload 24
    //   2509: astore 23
    //   2511: aload 28
    //   2513: ifnull +43 -> 2556
    //   2516: aload 24
    //   2518: astore 23
    //   2520: aload 28
    //   2522: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2525: ifnull +31 -> 2556
    //   2528: aload 24
    //   2530: astore 23
    //   2532: aload 28
    //   2534: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2537: getfield 280	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2540: ifnull +16 -> 2556
    //   2543: aload 28
    //   2545: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2548: getfield 280	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2551: getfield 545	com/tencent/mobileqq/mini/apkg/MiniAppInfo:via	Ljava/lang/String;
    //   2554: astore 23
    //   2556: aload_0
    //   2557: aload_0
    //   2558: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2561: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2564: lload 18
    //   2566: aload 26
    //   2568: aload_2
    //   2569: bipush 53
    //   2571: iload 7
    //   2573: iconst_0
    //   2574: aload 27
    //   2576: aload 20
    //   2578: aload 22
    //   2580: aload 21
    //   2582: aload 23
    //   2584: iconst_1
    //   2585: invokestatic 549	com/tencent/mobileqq/mini/util/AdUtils:createAdRequest	(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LNS_MINI_AD/MiniAppAd$StGetAdReq;
    //   2588: aload_3
    //   2589: aload_1
    //   2590: iload 4
    //   2592: iload 7
    //   2594: invokespecial 553	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:sendAdRequest	(LNS_MINI_AD/MiniAppAd$StGetAdReq;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;II)V
    //   2597: goto -1194 -> 1403
    //   2600: ldc_w 1284
    //   2603: aload 21
    //   2605: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2608: ifeq +360 -> 2968
    //   2611: new 348	org/json/JSONObject
    //   2614: dup
    //   2615: aload_2
    //   2616: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2619: astore 22
    //   2621: ldc_w 525
    //   2624: astore_2
    //   2625: new 348	org/json/JSONObject
    //   2628: dup
    //   2629: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   2632: astore 21
    //   2634: aload_2
    //   2635: astore 20
    //   2637: aload 22
    //   2639: ldc_w 479
    //   2642: invokevirtual 494	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2645: ifeq +7866 -> 10511
    //   2648: aload 22
    //   2650: ldc_w 479
    //   2653: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2656: astore 22
    //   2658: aload_2
    //   2659: astore 20
    //   2661: aload 22
    //   2663: ifnull +7848 -> 10511
    //   2666: aload_2
    //   2667: astore 20
    //   2669: aload 22
    //   2671: ldc_w 479
    //   2674: invokevirtual 494	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2677: ifeq +7834 -> 10511
    //   2680: aload 22
    //   2682: ldc_w 479
    //   2685: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2688: astore 22
    //   2690: aload_2
    //   2691: astore 20
    //   2693: aload 22
    //   2695: ifnull +7816 -> 10511
    //   2698: aload 22
    //   2700: ldc_w 381
    //   2703: invokevirtual 494	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2706: ifeq +12 -> 2718
    //   2709: aload 22
    //   2711: ldc_w 381
    //   2714: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2717: astore_2
    //   2718: aload_2
    //   2719: astore 20
    //   2721: aload 22
    //   2723: ldc_w 1286
    //   2726: invokevirtual 494	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2729: ifeq +7782 -> 10511
    //   2732: aload 22
    //   2734: ldc_w 1286
    //   2737: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2740: astore 21
    //   2742: aload_2
    //   2743: astore 20
    //   2745: aload 21
    //   2747: astore_2
    //   2748: new 348	org/json/JSONObject
    //   2751: dup
    //   2752: aload 20
    //   2754: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2757: astore 20
    //   2759: ldc_w 383
    //   2762: new 383	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   2765: dup
    //   2766: invokespecial 384	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   2769: aload 20
    //   2771: invokestatic 390	acqx:a	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   2774: invokevirtual 396	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2777: checkcast 383	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   2780: astore 21
    //   2782: aload_0
    //   2783: getfield 1288	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2786: ifnonnull +45 -> 2831
    //   2789: aload_0
    //   2790: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2793: ifnull +38 -> 2831
    //   2796: aload_0
    //   2797: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2800: invokevirtual 559	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2803: ifnull +28 -> 2831
    //   2806: aload_0
    //   2807: new 1290	com/tencent/gdtad/aditem/GdtAppReceiver
    //   2810: dup
    //   2811: invokespecial 1291	com/tencent/gdtad/aditem/GdtAppReceiver:<init>	()V
    //   2814: putfield 1288	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2817: aload_0
    //   2818: getfield 1288	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2821: aload_0
    //   2822: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2825: invokevirtual 559	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2828: invokevirtual 1294	com/tencent/gdtad/aditem/GdtAppReceiver:register	(Landroid/content/Context;)V
    //   2831: new 1296	com/tencent/gdtad/aditem/GdtHandler$Params
    //   2834: dup
    //   2835: invokespecial 1297	com/tencent/gdtad/aditem/GdtHandler$Params:<init>	()V
    //   2838: astore 20
    //   2840: aload 20
    //   2842: bipush 11
    //   2844: putfield 1299	com/tencent/gdtad/aditem/GdtHandler$Params:c	I
    //   2847: aload 20
    //   2849: new 1301	java/lang/ref/WeakReference
    //   2852: dup
    //   2853: aload_0
    //   2854: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2857: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2860: invokespecial 1304	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   2863: putfield 1307	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   2866: aload 20
    //   2868: new 1309	com/tencent/gdtad/aditem/GdtAd
    //   2871: dup
    //   2872: aload 21
    //   2874: invokespecial 1312	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   2877: putfield 1315	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_ComTencentGdtadAditemGdtAd	Lcom/tencent/gdtad/aditem/GdtAd;
    //   2880: aload 20
    //   2882: iconst_1
    //   2883: putfield 1317	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_Boolean	Z
    //   2886: aload 20
    //   2888: iconst_1
    //   2889: putfield 1319	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_b_of_type_Boolean	Z
    //   2892: aload 20
    //   2894: new 1301	java/lang/ref/WeakReference
    //   2897: dup
    //   2898: aload_0
    //   2899: getfield 1288	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2902: invokespecial 1304	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   2905: putfield 1321	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   2908: aload 20
    //   2910: ldc_w 1323
    //   2913: putfield 1326	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_b_of_type_JavaLangClass	Ljava/lang/Class;
    //   2916: new 777	android/os/Bundle
    //   2919: dup
    //   2920: invokespecial 778	android/os/Bundle:<init>	()V
    //   2923: astore 21
    //   2925: aload 21
    //   2927: ldc_w 1328
    //   2930: ldc 8
    //   2932: invokevirtual 1331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2935: aload 20
    //   2937: aload 21
    //   2939: putfield 1334	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   2942: aload 20
    //   2944: aload_2
    //   2945: putfield 1337	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   2948: aload 20
    //   2950: invokestatic 1342	com/tencent/gdtad/aditem/GdtHandler:a	(Lcom/tencent/gdtad/aditem/GdtHandler$Params;)V
    //   2953: aload_0
    //   2954: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2957: aload_3
    //   2958: aload_1
    //   2959: aconst_null
    //   2960: iload 4
    //   2962: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2965: goto -1562 -> 1403
    //   2968: ldc_w 1344
    //   2971: aload 21
    //   2973: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2976: ifeq +18 -> 2994
    //   2979: aload_0
    //   2980: aload 22
    //   2982: aload_3
    //   2983: aload_1
    //   2984: iload 4
    //   2986: bipush 12
    //   2988: invokespecial 1346	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleAdApi	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;II)V
    //   2991: goto -1588 -> 1403
    //   2994: ldc_w 1348
    //   2997: aload 21
    //   2999: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3002: ifeq +63 -> 3065
    //   3005: aload 22
    //   3007: ldc_w 479
    //   3010: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3013: ldc_w 1350
    //   3016: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3019: astore_2
    //   3020: aload 22
    //   3022: ldc_w 479
    //   3025: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3028: ldc_w 1352
    //   3031: iconst_0
    //   3032: invokevirtual 1355	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3035: istore 8
    //   3037: iload 8
    //   3039: istore 7
    //   3041: iload 8
    //   3043: ifgt +8 -> 3051
    //   3046: sipush 30000
    //   3049: istore 7
    //   3051: aload_0
    //   3052: aload_2
    //   3053: iload 7
    //   3055: aload_3
    //   3056: aload_1
    //   3057: iload 4
    //   3059: invokespecial 1357	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   3062: goto -1659 -> 1403
    //   3065: ldc_w 1359
    //   3068: aload 21
    //   3070: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3073: ifeq -1670 -> 1403
    //   3076: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   3079: aload_0
    //   3080: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3083: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3086: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   3089: aconst_null
    //   3090: new 1361	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6
    //   3093: dup
    //   3094: aload_0
    //   3095: aload_3
    //   3096: aload_1
    //   3097: iload 4
    //   3099: invokespecial 1362	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   3102: invokevirtual 1366	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserHealthData	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   3105: goto -1702 -> 1403
    //   3108: ldc 59
    //   3110: aload_1
    //   3111: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3114: ifeq +34 -> 3148
    //   3117: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   3120: aload_0
    //   3121: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3124: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3127: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   3130: new 1368	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7
    //   3133: dup
    //   3134: aload_0
    //   3135: aload_3
    //   3136: aload_1
    //   3137: iload 4
    //   3139: invokespecial 1369	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   3142: invokevirtual 1372	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkSession	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   3145: goto -1742 -> 1403
    //   3148: ldc 86
    //   3150: aload_1
    //   3151: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3154: ifne +12 -> 3166
    //   3157: ldc 89
    //   3159: aload_1
    //   3160: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3163: ifeq +771 -> 3934
    //   3166: aload_0
    //   3167: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3170: ifnull +752 -> 3922
    //   3173: aload_0
    //   3174: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3177: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3180: ifnull +688 -> 3868
    //   3183: iconst_m1
    //   3184: istore 9
    //   3186: aload_2
    //   3187: ifnull +23 -> 3210
    //   3190: ldc_w 1374
    //   3193: aload_2
    //   3194: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3197: ifne +13 -> 3210
    //   3200: ldc_w 1376
    //   3203: aload_2
    //   3204: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3207: ifeq +103 -> 3310
    //   3210: iconst_0
    //   3211: istore 15
    //   3213: iconst_1
    //   3214: istore 13
    //   3216: iconst_1
    //   3217: istore 12
    //   3219: iconst_1
    //   3220: istore 9
    //   3222: iconst_1
    //   3223: istore 7
    //   3225: aload_0
    //   3226: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3229: ifeq +412 -> 3641
    //   3232: aload_0
    //   3233: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3236: astore_2
    //   3237: aload_2
    //   3238: ifnull +384 -> 3622
    //   3241: iload 13
    //   3243: iconst_1
    //   3244: if_icmpne +346 -> 3590
    //   3247: aload_2
    //   3248: iconst_1
    //   3249: putfield 1388	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3252: iload 12
    //   3254: iconst_1
    //   3255: if_icmpne +343 -> 3598
    //   3258: aload_2
    //   3259: iconst_1
    //   3260: putfield 1391	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3263: iload 9
    //   3265: iconst_1
    //   3266: if_icmpne +340 -> 3606
    //   3269: aload_2
    //   3270: iconst_1
    //   3271: putfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3274: iload 7
    //   3276: iconst_1
    //   3277: if_icmpne +337 -> 3614
    //   3280: aload_2
    //   3281: iconst_1
    //   3282: putfield 1397	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3285: aload_2
    //   3286: iload 15
    //   3288: putfield 1400	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3291: aload_0
    //   3292: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3295: aload_3
    //   3296: aload_1
    //   3297: aload_1
    //   3298: aconst_null
    //   3299: invokestatic 1112	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3302: iload 4
    //   3304: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3307: goto -1904 -> 1403
    //   3310: new 348	org/json/JSONObject
    //   3313: dup
    //   3314: aload_2
    //   3315: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3318: astore_2
    //   3319: aload_2
    //   3320: ldc_w 1401
    //   3323: iconst_0
    //   3324: invokevirtual 1188	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3327: istore 16
    //   3329: aload_2
    //   3330: ldc_w 1403
    //   3333: invokevirtual 1406	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   3336: checkcast 359	org/json/JSONArray
    //   3339: astore_2
    //   3340: aload_2
    //   3341: ifnonnull +7190 -> 10531
    //   3344: iconst_1
    //   3345: istore 13
    //   3347: iconst_1
    //   3348: istore 12
    //   3350: iconst_1
    //   3351: istore 9
    //   3353: iconst_1
    //   3354: istore 7
    //   3356: iload 16
    //   3358: istore 15
    //   3360: goto -135 -> 3225
    //   3363: iload 10
    //   3365: aload_2
    //   3366: invokevirtual 1409	org/json/JSONArray:length	()I
    //   3369: if_icmpge +76 -> 3445
    //   3372: aload_2
    //   3373: iload 10
    //   3375: invokevirtual 1411	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   3378: astore 20
    //   3380: aload 20
    //   3382: ldc 124
    //   3384: invokevirtual 918	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3387: ifeq +6 -> 3393
    //   3390: iconst_1
    //   3391: istore 11
    //   3393: aload 20
    //   3395: ldc 127
    //   3397: invokevirtual 918	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3400: ifeq +6 -> 3406
    //   3403: iconst_1
    //   3404: istore 7
    //   3406: aload 20
    //   3408: ldc 130
    //   3410: invokevirtual 918	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3413: ifeq +6 -> 3419
    //   3416: iconst_1
    //   3417: istore 9
    //   3419: aload 20
    //   3421: ldc 133
    //   3423: invokevirtual 918	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3426: istore 15
    //   3428: iload 15
    //   3430: ifeq +6 -> 3436
    //   3433: iconst_1
    //   3434: istore 8
    //   3436: iload 10
    //   3438: iconst_1
    //   3439: iadd
    //   3440: istore 10
    //   3442: goto -79 -> 3363
    //   3445: iload 11
    //   3447: istore 10
    //   3449: iload 11
    //   3451: iconst_m1
    //   3452: if_icmpne +6 -> 3458
    //   3455: iconst_0
    //   3456: istore 10
    //   3458: iload 7
    //   3460: istore 11
    //   3462: iload 7
    //   3464: iconst_m1
    //   3465: if_icmpne +6 -> 3471
    //   3468: iconst_0
    //   3469: istore 11
    //   3471: iload 9
    //   3473: iconst_m1
    //   3474: if_icmpne +7030 -> 10504
    //   3477: iconst_0
    //   3478: istore 14
    //   3480: iload 14
    //   3482: istore 9
    //   3484: iload 8
    //   3486: istore 7
    //   3488: iload 11
    //   3490: istore 12
    //   3492: iload 10
    //   3494: istore 13
    //   3496: iload 16
    //   3498: istore 15
    //   3500: iload 8
    //   3502: iconst_m1
    //   3503: if_icmpne -278 -> 3225
    //   3506: iconst_0
    //   3507: istore 7
    //   3509: iload 14
    //   3511: istore 9
    //   3513: iload 11
    //   3515: istore 12
    //   3517: iload 10
    //   3519: istore 13
    //   3521: iload 16
    //   3523: istore 15
    //   3525: goto -300 -> 3225
    //   3528: astore_2
    //   3529: aload_2
    //   3530: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   3533: ldc 150
    //   3535: iconst_1
    //   3536: aload_2
    //   3537: iconst_0
    //   3538: anewarray 873	java/lang/Object
    //   3541: invokestatic 1226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3544: aload_0
    //   3545: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3548: ifeq +23 -> 3571
    //   3551: aload_0
    //   3552: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3555: aload_3
    //   3556: aload_1
    //   3557: aload_1
    //   3558: aconst_null
    //   3559: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3562: iload 4
    //   3564: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3567: ldc_w 525
    //   3570: areturn
    //   3571: aload_0
    //   3572: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3575: aload_3
    //   3576: aload_1
    //   3577: aload_1
    //   3578: aconst_null
    //   3579: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3582: iload 4
    //   3584: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3587: goto -20 -> 3567
    //   3590: aload_2
    //   3591: iconst_0
    //   3592: putfield 1388	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3595: goto -343 -> 3252
    //   3598: aload_2
    //   3599: iconst_0
    //   3600: putfield 1391	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3603: goto -340 -> 3263
    //   3606: aload_2
    //   3607: iconst_0
    //   3608: putfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3611: goto -337 -> 3274
    //   3614: aload_2
    //   3615: iconst_0
    //   3616: putfield 1397	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3619: goto -334 -> 3285
    //   3622: aload_0
    //   3623: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3626: aload_3
    //   3627: aload_1
    //   3628: aload_1
    //   3629: aconst_null
    //   3630: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3633: iload 4
    //   3635: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3638: goto -2235 -> 1403
    //   3641: aload_0
    //   3642: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3645: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3648: invokevirtual 1415	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3651: ifnull +198 -> 3849
    //   3654: aload_0
    //   3655: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3658: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3661: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3664: ifnull +185 -> 3849
    //   3667: iload 13
    //   3669: iconst_1
    //   3670: if_icmpne +111 -> 3781
    //   3673: aload_0
    //   3674: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3677: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3680: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3683: iconst_1
    //   3684: putfield 1422	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3687: iload 12
    //   3689: iconst_1
    //   3690: if_icmpne +108 -> 3798
    //   3693: aload_0
    //   3694: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3697: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3700: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3703: iconst_1
    //   3704: putfield 1423	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3707: iload 9
    //   3709: iconst_1
    //   3710: if_icmpne +105 -> 3815
    //   3713: aload_0
    //   3714: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3717: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3720: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3723: iconst_1
    //   3724: putfield 1424	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3727: iload 7
    //   3729: iconst_1
    //   3730: if_icmpne +102 -> 3832
    //   3733: aload_0
    //   3734: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3737: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3740: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3743: iconst_1
    //   3744: putfield 1425	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3747: aload_0
    //   3748: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3751: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3754: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3757: iload 15
    //   3759: putfield 1426	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3762: aload_0
    //   3763: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3766: aload_3
    //   3767: aload_1
    //   3768: aload_1
    //   3769: aconst_null
    //   3770: invokestatic 1112	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3773: iload 4
    //   3775: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3778: goto -2375 -> 1403
    //   3781: aload_0
    //   3782: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3785: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3788: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3791: iconst_0
    //   3792: putfield 1422	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3795: goto -108 -> 3687
    //   3798: aload_0
    //   3799: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3802: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3805: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3808: iconst_0
    //   3809: putfield 1423	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3812: goto -105 -> 3707
    //   3815: aload_0
    //   3816: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3819: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3822: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3825: iconst_0
    //   3826: putfield 1424	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3829: goto -102 -> 3727
    //   3832: aload_0
    //   3833: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3836: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3839: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3842: iconst_0
    //   3843: putfield 1425	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3846: goto -99 -> 3747
    //   3849: aload_0
    //   3850: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3853: aload_3
    //   3854: aload_1
    //   3855: aload_1
    //   3856: aconst_null
    //   3857: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3860: iload 4
    //   3862: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3865: goto -2462 -> 1403
    //   3868: ldc 150
    //   3870: iconst_1
    //   3871: ldc_w 1428
    //   3874: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3877: aload_0
    //   3878: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3881: ifeq +22 -> 3903
    //   3884: aload_0
    //   3885: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3888: aload_3
    //   3889: aload_1
    //   3890: aload_1
    //   3891: aconst_null
    //   3892: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3895: iload 4
    //   3897: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3900: goto -2497 -> 1403
    //   3903: aload_0
    //   3904: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3907: aload_3
    //   3908: aload_1
    //   3909: aload_1
    //   3910: aconst_null
    //   3911: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3914: iload 4
    //   3916: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3919: goto -2516 -> 1403
    //   3922: ldc 150
    //   3924: iconst_1
    //   3925: ldc_w 1430
    //   3928: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3931: goto -2528 -> 1403
    //   3934: ldc 92
    //   3936: aload_1
    //   3937: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3940: ifeq +220 -> 4160
    //   3943: new 348	org/json/JSONObject
    //   3946: dup
    //   3947: aload_2
    //   3948: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3951: astore_2
    //   3952: aload_2
    //   3953: ldc_w 1401
    //   3956: iconst_0
    //   3957: invokevirtual 1188	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3960: istore 15
    //   3962: aload_2
    //   3963: ldc_w 1432
    //   3966: invokevirtual 632	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   3969: pop
    //   3970: aload_2
    //   3971: ldc_w 1434
    //   3974: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3977: pop
    //   3978: aload_2
    //   3979: ldc_w 1436
    //   3982: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3985: pop
    //   3986: aload_0
    //   3987: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3990: ifeq +91 -> 4081
    //   3993: aload_0
    //   3994: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3997: astore_2
    //   3998: aload_2
    //   3999: ifnull +63 -> 4062
    //   4002: aload_2
    //   4003: iload 15
    //   4005: putfield 1400	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   4008: aload_0
    //   4009: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4012: aload_3
    //   4013: aload_1
    //   4014: aload_1
    //   4015: aconst_null
    //   4016: invokestatic 1112	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   4019: iload 4
    //   4021: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   4024: aload_0
    //   4025: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4028: aload_3
    //   4029: aload_1
    //   4030: aload_1
    //   4031: aconst_null
    //   4032: invokestatic 1112	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   4035: iload 4
    //   4037: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   4040: goto -2637 -> 1403
    //   4043: astore_1
    //   4044: ldc 150
    //   4046: iconst_1
    //   4047: aload_1
    //   4048: iconst_0
    //   4049: anewarray 873	java/lang/Object
    //   4052: invokestatic 1226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4055: aload_1
    //   4056: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   4059: goto -2656 -> 1403
    //   4062: aload_0
    //   4063: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4066: aload_3
    //   4067: aload_1
    //   4068: aload_1
    //   4069: aconst_null
    //   4070: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   4073: iload 4
    //   4075: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   4078: goto -54 -> 4024
    //   4081: aload_0
    //   4082: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4085: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4088: invokevirtual 1415	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   4091: ifnull +50 -> 4141
    //   4094: aload_0
    //   4095: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4098: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4101: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4104: ifnull +37 -> 4141
    //   4107: aload_0
    //   4108: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4111: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4114: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4117: iload 15
    //   4119: putfield 1426	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   4122: aload_0
    //   4123: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4126: aload_3
    //   4127: aload_1
    //   4128: aload_1
    //   4129: aconst_null
    //   4130: invokestatic 1112	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   4133: iload 4
    //   4135: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   4138: goto -114 -> 4024
    //   4141: aload_0
    //   4142: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4145: aload_3
    //   4146: aload_1
    //   4147: aload_1
    //   4148: aconst_null
    //   4149: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   4152: iload 4
    //   4154: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   4157: goto -133 -> 4024
    //   4160: ldc 32
    //   4162: aload_1
    //   4163: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4166: ifeq +79 -> 4245
    //   4169: new 348	org/json/JSONObject
    //   4172: dup
    //   4173: aload_2
    //   4174: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4177: astore_2
    //   4178: aload_2
    //   4179: ldc_w 1350
    //   4182: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4185: astore 20
    //   4187: aload_2
    //   4188: ldc_w 1352
    //   4191: iconst_0
    //   4192: invokevirtual 1355	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4195: istore 8
    //   4197: iload 8
    //   4199: istore 7
    //   4201: iload 8
    //   4203: ifgt +8 -> 4211
    //   4206: sipush 30000
    //   4209: istore 7
    //   4211: aload_0
    //   4212: aload 20
    //   4214: iload 7
    //   4216: aload_3
    //   4217: aload_1
    //   4218: iload 4
    //   4220: invokespecial 1357	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   4223: goto -2820 -> 1403
    //   4226: astore_1
    //   4227: ldc 150
    //   4229: iconst_1
    //   4230: aload_1
    //   4231: iconst_0
    //   4232: anewarray 873	java/lang/Object
    //   4235: invokestatic 1226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4238: aload_1
    //   4239: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   4242: goto -2839 -> 1403
    //   4245: ldc 68
    //   4247: aload_1
    //   4248: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4251: ifne +21 -> 4272
    //   4254: ldc 65
    //   4256: aload_1
    //   4257: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4260: ifne +12 -> 4272
    //   4263: ldc 71
    //   4265: aload_1
    //   4266: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4269: ifeq +1371 -> 5640
    //   4272: iconst_0
    //   4273: istore 15
    //   4275: ldc 68
    //   4277: aload_1
    //   4278: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4281: ifeq +6 -> 4287
    //   4284: iconst_1
    //   4285: istore 15
    //   4287: new 348	org/json/JSONObject
    //   4290: dup
    //   4291: aload_2
    //   4292: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4295: astore 23
    //   4297: aload 23
    //   4299: ldc_w 1438
    //   4302: iconst_m1
    //   4303: invokevirtual 1355	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4306: istore 9
    //   4308: iconst_m1
    //   4309: istore 7
    //   4311: aconst_null
    //   4312: astore 22
    //   4314: iload 9
    //   4316: ifne +6250 -> 10566
    //   4319: iconst_0
    //   4320: istore 7
    //   4322: aconst_null
    //   4323: astore_2
    //   4324: aload 23
    //   4326: ldc_w 1440
    //   4329: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4332: astore 25
    //   4334: aload 23
    //   4336: ldc_w 1442
    //   4339: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4342: astore 26
    //   4344: ldc 68
    //   4346: aload_1
    //   4347: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4350: ifne +6196 -> 10546
    //   4353: ldc 71
    //   4355: aload_1
    //   4356: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4359: ifeq +29 -> 4388
    //   4362: goto +6184 -> 10546
    //   4365: aload_0
    //   4366: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4369: ifeq +510 -> 4879
    //   4372: aload_0
    //   4373: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4376: ifnull +503 -> 4879
    //   4379: aload_0
    //   4380: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4383: iload 8
    //   4385: putfield 1445	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4388: aload_0
    //   4389: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4392: ifeq +524 -> 4916
    //   4395: aload_0
    //   4396: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4399: ifnull +517 -> 4916
    //   4402: aload_0
    //   4403: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4406: aload_1
    //   4407: putfield 1448	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   4410: aload_0
    //   4411: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4414: iload 4
    //   4416: putfield 1451	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   4419: aload 23
    //   4421: ldc_w 1453
    //   4424: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4427: astore 20
    //   4429: aload 20
    //   4431: astore 21
    //   4433: aload 20
    //   4435: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4438: ifeq +13 -> 4451
    //   4441: aload 23
    //   4443: ldc_w 1455
    //   4446: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4449: astore 21
    //   4451: aload 23
    //   4453: ldc_w 1457
    //   4456: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4459: astore 24
    //   4461: aload 23
    //   4463: ldc_w 1459
    //   4466: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4469: astore 27
    //   4471: aload 23
    //   4473: ldc_w 1461
    //   4476: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4479: astore 23
    //   4481: aload 21
    //   4483: astore 20
    //   4485: aload 21
    //   4487: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4490: ifeq +15 -> 4505
    //   4493: aload_0
    //   4494: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4497: ifeq +451 -> 4948
    //   4500: ldc_w 1463
    //   4503: astore 20
    //   4505: new 1465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8
    //   4508: dup
    //   4509: aload_0
    //   4510: aload_3
    //   4511: aload_1
    //   4512: iload 4
    //   4514: invokespecial 1466	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   4517: astore_1
    //   4518: aload_0
    //   4519: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4522: ifeq +21 -> 4543
    //   4525: aload_0
    //   4526: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4529: ifnull +14 -> 4543
    //   4532: aload_0
    //   4533: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4536: getfield 1445	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4539: iconst_1
    //   4540: if_icmpeq +27 -> 4567
    //   4543: aload_0
    //   4544: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4547: ifne +506 -> 5053
    //   4550: aload_0
    //   4551: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4554: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4557: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4560: getfield 1467	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4563: iconst_1
    //   4564: if_icmpne +489 -> 5053
    //   4567: aload 27
    //   4569: ldc_w 1469
    //   4572: invokevirtual 1472	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4575: ifne +14 -> 4589
    //   4578: aload 27
    //   4580: ldc_w 1474
    //   4583: invokevirtual 1472	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4586: ifeq +383 -> 4969
    //   4589: aload_0
    //   4590: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4593: invokevirtual 559	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4596: aload 24
    //   4598: aload 27
    //   4600: aload 20
    //   4602: aload_0
    //   4603: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4606: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4609: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4612: iload 15
    //   4614: invokestatic 1478	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4617: goto +5945 -> 10562
    //   4620: iload 9
    //   4622: iconst_2
    //   4623: if_icmpne +5957 -> 10580
    //   4626: iconst_0
    //   4627: istore 7
    //   4629: aload 23
    //   4631: ldc_w 1480
    //   4634: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4637: astore_2
    //   4638: aload_2
    //   4639: ifnull +80 -> 4719
    //   4642: aload_0
    //   4643: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4646: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4649: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4652: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4655: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4658: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4661: ifnull +58 -> 4719
    //   4664: aload_2
    //   4665: aload_0
    //   4666: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4669: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4672: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4675: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4678: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4681: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4684: invokevirtual 1489	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   4687: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4690: ifeq +29 -> 4719
    //   4693: aload_0
    //   4694: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4697: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4700: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4703: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4706: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4709: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4712: astore 22
    //   4714: aconst_null
    //   4715: astore_2
    //   4716: goto -392 -> 4324
    //   4719: ldc 150
    //   4721: iconst_1
    //   4722: new 398	java/lang/StringBuilder
    //   4725: dup
    //   4726: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   4729: ldc_w 1491
    //   4732: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4735: aload_2
    //   4736: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4739: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4742: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4745: aconst_null
    //   4746: astore_2
    //   4747: goto -423 -> 4324
    //   4750: iload 9
    //   4752: iconst_5
    //   4753: if_icmpne +102 -> 4855
    //   4756: aload 23
    //   4758: ldc_w 1493
    //   4761: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4764: astore 20
    //   4766: aload_0
    //   4767: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4770: ifeq +37 -> 4807
    //   4773: aload_0
    //   4774: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4777: ifnull +30 -> 4807
    //   4780: aload_0
    //   4781: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4784: getfield 1497	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4787: astore_2
    //   4788: aload_2
    //   4789: ifnull +35 -> 4824
    //   4792: aload_2
    //   4793: invokevirtual 1500	com/tencent/mobileqq/mini/sdk/ShareChatModel:getEntryHash	()Ljava/lang/String;
    //   4796: aload 20
    //   4798: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4801: ifeq +23 -> 4824
    //   4804: goto +5804 -> 10608
    //   4807: aload_0
    //   4808: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4811: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4814: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4817: getfield 1501	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4820: astore_2
    //   4821: goto -33 -> 4788
    //   4824: ldc 150
    //   4826: iconst_1
    //   4827: new 398	java/lang/StringBuilder
    //   4830: dup
    //   4831: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   4834: ldc_w 1491
    //   4837: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4840: aconst_null
    //   4841: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4844: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4847: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4850: aconst_null
    //   4851: astore_2
    //   4852: goto +5756 -> 10608
    //   4855: iload 9
    //   4857: bipush 6
    //   4859: if_icmpne +5640 -> 10499
    //   4862: ldc 71
    //   4864: aload_1
    //   4865: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4868: ifeq +5631 -> 10499
    //   4871: iconst_0
    //   4872: istore 7
    //   4874: aconst_null
    //   4875: astore_2
    //   4876: goto -552 -> 4324
    //   4879: aload_0
    //   4880: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4883: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4886: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4889: iload 8
    //   4891: putfield 1467	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4894: goto -506 -> 4388
    //   4897: astore_1
    //   4898: ldc 150
    //   4900: iconst_1
    //   4901: aload_1
    //   4902: iconst_0
    //   4903: anewarray 873	java/lang/Object
    //   4906: invokestatic 1226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4909: aload_1
    //   4910: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   4913: goto -3510 -> 1403
    //   4916: aload_0
    //   4917: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4920: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4923: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4926: aload_1
    //   4927: putfield 1502	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   4930: aload_0
    //   4931: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4934: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4937: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4940: iload 4
    //   4942: putfield 1503	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   4945: goto -526 -> 4419
    //   4948: aload_0
    //   4949: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4952: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4955: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4958: invokevirtual 974	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   4961: getfield 1147	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   4964: astore 20
    //   4966: goto -461 -> 4505
    //   4969: aload_0
    //   4970: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4973: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4976: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4979: pop
    //   4980: invokestatic 1508	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   4983: aload 27
    //   4985: invokevirtual 1511	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   4988: astore_1
    //   4989: aload_1
    //   4990: invokestatic 1515	bgsp:a	(Ljava/lang/String;)Z
    //   4993: ifne +33 -> 5026
    //   4996: aload_0
    //   4997: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5000: invokevirtual 559	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   5003: aload 24
    //   5005: aload_1
    //   5006: aload 20
    //   5008: aload_0
    //   5009: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5012: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5015: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5018: iload 15
    //   5020: invokestatic 1478	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   5023: goto +5539 -> 10562
    //   5026: aload_0
    //   5027: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5030: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5033: new 1517	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9
    //   5036: dup
    //   5037: aload_0
    //   5038: aload 24
    //   5040: aload 20
    //   5042: iload 15
    //   5044: invokespecial 1520	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Z)V
    //   5047: invokevirtual 1524	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5050: goto +5512 -> 10562
    //   5053: aload_0
    //   5054: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5057: ifeq +21 -> 5078
    //   5060: aload_0
    //   5061: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5064: ifnull +14 -> 5078
    //   5067: aload_0
    //   5068: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5071: getfield 1445	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5074: iconst_3
    //   5075: if_icmpeq +27 -> 5102
    //   5078: aload_0
    //   5079: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5082: ifne +55 -> 5137
    //   5085: aload_0
    //   5086: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5089: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5092: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5095: getfield 1467	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5098: iconst_3
    //   5099: if_icmpne +38 -> 5137
    //   5102: aload_0
    //   5103: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5106: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5109: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5112: astore_1
    //   5113: aload_0
    //   5114: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5117: invokevirtual 559	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   5120: aload 24
    //   5122: aload_1
    //   5123: getfield 1527	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5126: aload 20
    //   5128: iconst_3
    //   5129: aload_1
    //   5130: invokestatic 1531	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   5133: ldc_w 525
    //   5136: areturn
    //   5137: aload_0
    //   5138: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5141: ifeq +21 -> 5162
    //   5144: aload_0
    //   5145: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5148: ifnull +14 -> 5162
    //   5151: aload_0
    //   5152: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5155: getfield 1445	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5158: iconst_4
    //   5159: if_icmpeq +27 -> 5186
    //   5162: aload_0
    //   5163: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5166: ifne +55 -> 5221
    //   5169: aload_0
    //   5170: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5173: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5176: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5179: getfield 1467	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5182: iconst_4
    //   5183: if_icmpne +38 -> 5221
    //   5186: aload_0
    //   5187: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5190: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5193: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5196: astore_1
    //   5197: aload_0
    //   5198: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5201: invokevirtual 559	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   5204: aload 24
    //   5206: aload_1
    //   5207: getfield 1527	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5210: aload 20
    //   5212: iconst_4
    //   5213: aload_1
    //   5214: invokestatic 1531	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   5217: ldc_w 525
    //   5220: areturn
    //   5221: aload 27
    //   5223: invokestatic 1536	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   5226: ifne +5388 -> 10614
    //   5229: aload 27
    //   5231: invokestatic 1539	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   5234: ifeq +5386 -> 10620
    //   5237: goto +5377 -> 10614
    //   5240: aload_0
    //   5241: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5244: ifnull +5382 -> 10626
    //   5247: aload_0
    //   5248: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5251: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5254: ifnull +5372 -> 10626
    //   5257: aload 27
    //   5259: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5262: ifne +5364 -> 10626
    //   5265: new 1541	java/io/File
    //   5268: dup
    //   5269: invokestatic 1508	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5272: aload 27
    //   5274: invokevirtual 1511	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5277: invokespecial 1542	java/io/File:<init>	(Ljava/lang/String;)V
    //   5280: invokevirtual 1545	java/io/File:exists	()Z
    //   5283: ifeq +5343 -> 10626
    //   5286: iconst_1
    //   5287: istore 17
    //   5289: aload 27
    //   5291: invokestatic 1515	bgsp:a	(Ljava/lang/String;)Z
    //   5294: ifne +13 -> 5307
    //   5297: iload 16
    //   5299: ifne +197 -> 5496
    //   5302: iload 17
    //   5304: ifne +192 -> 5496
    //   5307: aload_0
    //   5308: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5311: ifeq +110 -> 5421
    //   5314: aload_0
    //   5315: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5318: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5321: astore_3
    //   5322: invokestatic 1550	com/tencent/mobileqq/minigame/utils/GameWnsUtils:defaultShareImg	()Ljava/lang/String;
    //   5325: astore 21
    //   5327: iload 15
    //   5329: ifeq +5303 -> 10632
    //   5332: bipush 11
    //   5334: istore 4
    //   5336: aload_3
    //   5337: aload 24
    //   5339: aload 21
    //   5341: aload 20
    //   5343: aload 23
    //   5345: aload 25
    //   5347: aload 26
    //   5349: aload 22
    //   5351: aload_2
    //   5352: iload 4
    //   5354: iload 9
    //   5356: ldc_w 525
    //   5359: aload_1
    //   5360: invokevirtual 1554	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5363: ldc 150
    //   5365: iconst_1
    //   5366: new 398	java/lang/StringBuilder
    //   5369: dup
    //   5370: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   5373: ldc_w 1556
    //   5376: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5379: iload 16
    //   5381: invokevirtual 1023	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5384: ldc_w 1558
    //   5387: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5390: iload 17
    //   5392: invokevirtual 1023	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5395: ldc_w 1560
    //   5398: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5401: aload 27
    //   5403: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5406: ldc_w 1562
    //   5409: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5412: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5415: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5418: goto -4015 -> 1403
    //   5421: aload_0
    //   5422: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5425: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5428: ifnull -4025 -> 1403
    //   5431: aload_0
    //   5432: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5435: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5438: getfield 1565	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5441: ifeq +16 -> 5457
    //   5444: ldc 150
    //   5446: iconst_1
    //   5447: ldc_w 1567
    //   5450: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5453: ldc_w 525
    //   5456: areturn
    //   5457: aload_0
    //   5458: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5461: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5464: new 1569	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10
    //   5467: dup
    //   5468: aload_0
    //   5469: aload 24
    //   5471: aload 20
    //   5473: aload 23
    //   5475: aload 25
    //   5477: aload 26
    //   5479: aload 22
    //   5481: aload_2
    //   5482: iload 15
    //   5484: iload 9
    //   5486: aload_1
    //   5487: invokespecial 1572	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;ZILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5490: invokevirtual 1524	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5493: goto -4090 -> 1403
    //   5496: aload 27
    //   5498: ldc_w 1469
    //   5501: invokevirtual 1472	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5504: ifne +14 -> 5518
    //   5507: aload 27
    //   5509: ldc_w 1474
    //   5512: invokevirtual 1472	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5515: ifeq +50 -> 5565
    //   5518: aload_0
    //   5519: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5522: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5525: astore_3
    //   5526: iload 15
    //   5528: ifeq +5111 -> 10639
    //   5531: bipush 11
    //   5533: istore 4
    //   5535: aload_3
    //   5536: aload 24
    //   5538: aload 27
    //   5540: aload 20
    //   5542: aload 23
    //   5544: aload 25
    //   5546: aload 26
    //   5548: aload 22
    //   5550: aload_2
    //   5551: iload 4
    //   5553: iload 9
    //   5555: ldc_w 525
    //   5558: aload_1
    //   5559: invokevirtual 1554	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5562: goto -4159 -> 1403
    //   5565: aload_0
    //   5566: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5569: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5572: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5575: pop
    //   5576: invokestatic 1508	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5579: aload 27
    //   5581: invokevirtual 1511	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5584: astore_3
    //   5585: aload_0
    //   5586: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5589: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5592: astore 21
    //   5594: iload 15
    //   5596: ifeq +37 -> 5633
    //   5599: bipush 11
    //   5601: istore 4
    //   5603: aload 21
    //   5605: aload 24
    //   5607: aload_3
    //   5608: aload 20
    //   5610: aload 23
    //   5612: aload 25
    //   5614: aload 26
    //   5616: aload 22
    //   5618: aload_2
    //   5619: iload 4
    //   5621: iload 9
    //   5623: ldc_w 525
    //   5626: aload_1
    //   5627: invokevirtual 1554	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5630: goto -4227 -> 1403
    //   5633: bipush 12
    //   5635: istore 4
    //   5637: goto -34 -> 5603
    //   5640: ldc 74
    //   5642: aload_1
    //   5643: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5646: ifne +12 -> 5658
    //   5649: ldc 77
    //   5651: aload_1
    //   5652: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5655: ifeq +531 -> 6186
    //   5658: new 348	org/json/JSONObject
    //   5661: dup
    //   5662: aload_2
    //   5663: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5666: astore_2
    //   5667: aload_2
    //   5668: ldc_w 1438
    //   5671: iconst_m1
    //   5672: invokevirtual 1355	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5675: istore 8
    //   5677: iconst_m1
    //   5678: istore 7
    //   5680: iload 8
    //   5682: ifne +242 -> 5924
    //   5685: iconst_0
    //   5686: istore 7
    //   5688: ldc 77
    //   5690: aload_1
    //   5691: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5694: ifeq +39 -> 5733
    //   5697: iload 7
    //   5699: istore 8
    //   5701: iload 7
    //   5703: iconst_m1
    //   5704: if_icmpne +6 -> 5710
    //   5707: iconst_0
    //   5708: istore 8
    //   5710: aload_0
    //   5711: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5714: ifeq +258 -> 5972
    //   5717: aload_0
    //   5718: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5721: ifnull +251 -> 5972
    //   5724: aload_0
    //   5725: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5728: iload 8
    //   5730: putfield 1445	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5733: aload_0
    //   5734: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5737: ifeq +253 -> 5990
    //   5740: aload_0
    //   5741: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5744: ifnull +246 -> 5990
    //   5747: aload_0
    //   5748: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5751: getfield 1445	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5754: istore 7
    //   5756: aload_0
    //   5757: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5760: ifeq +248 -> 6008
    //   5763: aload_0
    //   5764: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5767: ifnull +241 -> 6008
    //   5770: aload_0
    //   5771: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5774: aload_1
    //   5775: putfield 1448	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   5778: aload_0
    //   5779: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5782: iload 4
    //   5784: putfield 1451	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   5787: new 1574	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11
    //   5790: dup
    //   5791: aload_0
    //   5792: aload_3
    //   5793: aload_1
    //   5794: iload 4
    //   5796: invokespecial 1575	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   5799: astore_1
    //   5800: aload_0
    //   5801: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5804: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5807: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5810: astore_3
    //   5811: aload_2
    //   5812: ldc_w 1457
    //   5815: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5818: astore 20
    //   5820: aload_2
    //   5821: ldc_w 1459
    //   5824: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5827: astore_2
    //   5828: aload_2
    //   5829: invokestatic 1536	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   5832: ifne +4814 -> 10646
    //   5835: aload_2
    //   5836: invokestatic 1539	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   5839: ifeq +4813 -> 10652
    //   5842: goto +4804 -> 10646
    //   5845: invokestatic 1508	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5848: aload_2
    //   5849: invokevirtual 1511	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5852: astore 21
    //   5854: aload_0
    //   5855: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5858: ifnull +4800 -> 10658
    //   5861: aload_0
    //   5862: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5865: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5868: ifnull +4790 -> 10658
    //   5871: aload_2
    //   5872: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5875: ifne +4783 -> 10658
    //   5878: new 1541	java/io/File
    //   5881: dup
    //   5882: aload 21
    //   5884: invokespecial 1542	java/io/File:<init>	(Ljava/lang/String;)V
    //   5887: invokevirtual 1545	java/io/File:exists	()Z
    //   5890: ifeq +4768 -> 10658
    //   5893: iconst_1
    //   5894: istore 8
    //   5896: iload 4
    //   5898: ifeq +142 -> 6040
    //   5901: aload_0
    //   5902: aload 22
    //   5904: aload 20
    //   5906: aload_2
    //   5907: iload 7
    //   5909: aload_1
    //   5910: invokespecial 201	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5913: goto -4510 -> 1403
    //   5916: astore_1
    //   5917: aload_1
    //   5918: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   5921: goto -4518 -> 1403
    //   5924: iload 8
    //   5926: iconst_1
    //   5927: if_icmpne +9 -> 5936
    //   5930: iconst_1
    //   5931: istore 7
    //   5933: goto -245 -> 5688
    //   5936: iload 8
    //   5938: iconst_2
    //   5939: if_icmpne +9 -> 5948
    //   5942: iconst_0
    //   5943: istore 7
    //   5945: goto -257 -> 5688
    //   5948: iload 8
    //   5950: iconst_3
    //   5951: if_icmpne +9 -> 5960
    //   5954: iconst_3
    //   5955: istore 7
    //   5957: goto -269 -> 5688
    //   5960: iload 8
    //   5962: iconst_4
    //   5963: if_icmpne -275 -> 5688
    //   5966: iconst_4
    //   5967: istore 7
    //   5969: goto -281 -> 5688
    //   5972: aload_0
    //   5973: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5976: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5979: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5982: iload 8
    //   5984: putfield 1467	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5987: goto -254 -> 5733
    //   5990: aload_0
    //   5991: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5994: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5997: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6000: getfield 1467	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   6003: istore 7
    //   6005: goto -249 -> 5756
    //   6008: aload_0
    //   6009: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6012: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6015: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6018: aload_1
    //   6019: putfield 1502	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   6022: aload_0
    //   6023: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6026: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6029: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6032: iload 4
    //   6034: putfield 1503	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   6037: goto -250 -> 5787
    //   6040: aload_2
    //   6041: invokestatic 1515	bgsp:a	(Ljava/lang/String;)Z
    //   6044: ifne +13 -> 6057
    //   6047: iload 4
    //   6049: ifne +114 -> 6163
    //   6052: iload 8
    //   6054: ifne +109 -> 6163
    //   6057: aload_0
    //   6058: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   6061: ifeq +37 -> 6098
    //   6064: aload_3
    //   6065: ifnull +21 -> 6086
    //   6068: aload_0
    //   6069: aload 22
    //   6071: aload 20
    //   6073: aload_3
    //   6074: getfield 1527	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   6077: iload 7
    //   6079: aload_1
    //   6080: invokespecial 201	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   6083: goto -4680 -> 1403
    //   6086: ldc 150
    //   6088: iconst_1
    //   6089: ldc_w 1577
    //   6092: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6095: goto -4692 -> 1403
    //   6098: aload_0
    //   6099: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6102: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6105: ifnull -4702 -> 1403
    //   6108: aload_0
    //   6109: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6112: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6115: getfield 1565	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   6118: ifeq +16 -> 6134
    //   6121: ldc 150
    //   6123: iconst_1
    //   6124: ldc_w 1579
    //   6127: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6130: ldc_w 525
    //   6133: areturn
    //   6134: aload_0
    //   6135: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6138: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6141: new 1581	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12
    //   6144: dup
    //   6145: aload_0
    //   6146: aload_3
    //   6147: aload 22
    //   6149: aload 20
    //   6151: iload 7
    //   6153: aload_1
    //   6154: invokespecial 1584	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Landroid/app/Activity;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   6157: invokevirtual 1524	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   6160: goto -4757 -> 1403
    //   6163: iload 4
    //   6165: ifne -4762 -> 1403
    //   6168: iload 8
    //   6170: ifeq -4767 -> 1403
    //   6173: aload_0
    //   6174: aload 20
    //   6176: aload 21
    //   6178: iload 7
    //   6180: invokespecial 207	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareLocalPicMessage	(Ljava/lang/String;Ljava/lang/String;I)V
    //   6183: goto -4780 -> 1403
    //   6186: ldc 44
    //   6188: aload_1
    //   6189: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6192: ifeq +383 -> 6575
    //   6195: aload_0
    //   6196: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6199: ifnull -4796 -> 1403
    //   6202: aload_0
    //   6203: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6206: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6209: ifnull -4806 -> 1403
    //   6212: new 348	org/json/JSONObject
    //   6215: dup
    //   6216: aload_2
    //   6217: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6220: ldc_w 1586
    //   6223: invokevirtual 1406	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   6226: checkcast 359	org/json/JSONArray
    //   6229: astore_2
    //   6230: aload_2
    //   6231: ifnonnull +98 -> 6329
    //   6234: iconst_0
    //   6235: istore 10
    //   6237: iconst_0
    //   6238: istore 9
    //   6240: iconst_0
    //   6241: istore 8
    //   6243: iconst_0
    //   6244: istore 7
    //   6246: aload_0
    //   6247: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   6250: ifeq +185 -> 6435
    //   6253: aload_0
    //   6254: invokevirtual 1383	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   6257: astore_2
    //   6258: aload_2
    //   6259: ifnull +157 -> 6416
    //   6262: iload 10
    //   6264: ifne +8 -> 6272
    //   6267: aload_2
    //   6268: iconst_0
    //   6269: putfield 1388	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   6272: iload 9
    //   6274: ifne +8 -> 6282
    //   6277: aload_2
    //   6278: iconst_0
    //   6279: putfield 1391	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   6282: iload 8
    //   6284: ifne +8 -> 6292
    //   6287: aload_2
    //   6288: iconst_0
    //   6289: putfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   6292: iload 7
    //   6294: ifne +8 -> 6302
    //   6297: aload_2
    //   6298: iconst_0
    //   6299: putfield 1397	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   6302: aload_0
    //   6303: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6306: aload_3
    //   6307: aload_1
    //   6308: aload_1
    //   6309: aconst_null
    //   6310: invokestatic 1112	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6313: iload 4
    //   6315: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6318: goto -4915 -> 1403
    //   6321: astore_1
    //   6322: aload_1
    //   6323: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   6326: goto -4923 -> 1403
    //   6329: iconst_m1
    //   6330: istore 7
    //   6332: iconst_m1
    //   6333: istore 8
    //   6335: iconst_m1
    //   6336: istore 9
    //   6338: iconst_m1
    //   6339: istore 10
    //   6341: iconst_0
    //   6342: istore 11
    //   6344: iload 11
    //   6346: aload_2
    //   6347: invokevirtual 1409	org/json/JSONArray:length	()I
    //   6350: if_icmpge +4146 -> 10496
    //   6353: aload_2
    //   6354: iload 11
    //   6356: invokevirtual 1411	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6359: astore 20
    //   6361: aload 20
    //   6363: ldc 124
    //   6365: invokevirtual 918	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6368: ifeq +6 -> 6374
    //   6371: iconst_0
    //   6372: istore 10
    //   6374: aload 20
    //   6376: ldc 127
    //   6378: invokevirtual 918	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6381: ifeq +6 -> 6387
    //   6384: iconst_0
    //   6385: istore 9
    //   6387: aload 20
    //   6389: ldc 130
    //   6391: invokevirtual 918	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6394: ifeq +6 -> 6400
    //   6397: iconst_0
    //   6398: istore 8
    //   6400: aload 20
    //   6402: ldc 133
    //   6404: invokevirtual 918	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6407: ifeq +4257 -> 10664
    //   6410: iconst_0
    //   6411: istore 7
    //   6413: goto +4251 -> 10664
    //   6416: aload_0
    //   6417: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6420: aload_3
    //   6421: aload_1
    //   6422: aload_1
    //   6423: aconst_null
    //   6424: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6427: iload 4
    //   6429: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6432: goto -5029 -> 1403
    //   6435: aload_0
    //   6436: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6439: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6442: invokevirtual 1415	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   6445: ifnull +111 -> 6556
    //   6448: aload_0
    //   6449: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6452: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6455: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6458: ifnull +98 -> 6556
    //   6461: iload 10
    //   6463: ifne +17 -> 6480
    //   6466: aload_0
    //   6467: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6470: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6473: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6476: iconst_0
    //   6477: putfield 1422	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   6480: iload 9
    //   6482: ifne +17 -> 6499
    //   6485: aload_0
    //   6486: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6489: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6492: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6495: iconst_0
    //   6496: putfield 1423	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   6499: iload 8
    //   6501: ifne +17 -> 6518
    //   6504: aload_0
    //   6505: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6508: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6511: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6514: iconst_0
    //   6515: putfield 1424	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   6518: iload 7
    //   6520: ifne +17 -> 6537
    //   6523: aload_0
    //   6524: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6527: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6530: invokevirtual 1419	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6533: iconst_0
    //   6534: putfield 1425	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   6537: aload_0
    //   6538: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6541: aload_3
    //   6542: aload_1
    //   6543: aload_1
    //   6544: aconst_null
    //   6545: invokestatic 1112	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6548: iload 4
    //   6550: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6553: goto -5150 -> 1403
    //   6556: aload_0
    //   6557: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6560: aload_3
    //   6561: aload_1
    //   6562: aload_1
    //   6563: aconst_null
    //   6564: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6567: iload 4
    //   6569: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6572: goto -5169 -> 1403
    //   6575: ldc_w 1588
    //   6578: aload_1
    //   6579: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6582: ifeq +298 -> 6880
    //   6585: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6588: invokevirtual 1246	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6591: astore 20
    //   6593: aload 20
    //   6595: instanceof 675
    //   6598: ifeq +3892 -> 10490
    //   6601: aload 20
    //   6603: checkcast 675	com/tencent/mobileqq/mini/MiniAppInterface
    //   6606: astore 20
    //   6608: aload 20
    //   6610: ifnonnull +18 -> 6628
    //   6613: aload_0
    //   6614: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6617: aload_3
    //   6618: aload_1
    //   6619: aconst_null
    //   6620: iload 4
    //   6622: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6625: goto -5222 -> 1403
    //   6628: new 348	org/json/JSONObject
    //   6631: dup
    //   6632: aload_2
    //   6633: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6636: ldc_w 1590
    //   6639: invokevirtual 1593	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6642: iconst_0
    //   6643: invokevirtual 1411	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6646: astore 22
    //   6648: aload 22
    //   6650: astore 21
    //   6652: aload 22
    //   6654: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6657: ifne +10 -> 6667
    //   6660: aload 22
    //   6662: invokevirtual 1596	java/lang/String:trim	()Ljava/lang/String;
    //   6665: astore 21
    //   6667: aload 20
    //   6669: aload_0
    //   6670: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6673: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6676: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6679: invokevirtual 679	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   6682: astore 20
    //   6684: aload 20
    //   6686: ifnull +179 -> 6865
    //   6689: aload 21
    //   6691: invokestatic 1599	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   6694: ifeq +171 -> 6865
    //   6697: aload 20
    //   6699: invokevirtual 1602	com/tencent/mobileqq/mini/app/AuthorizeCenter:isAuthorizeSynchronized	()Z
    //   6702: istore 15
    //   6704: aload 21
    //   6706: ldc_w 1604
    //   6709: invokevirtual 1472	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6712: ifeq +59 -> 6771
    //   6715: iload 15
    //   6717: ifne +54 -> 6771
    //   6720: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6723: aconst_null
    //   6724: aload_0
    //   6725: invokevirtual 1607	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   6728: new 1609	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13
    //   6731: dup
    //   6732: aload_0
    //   6733: aload 20
    //   6735: aload 21
    //   6737: aload_3
    //   6738: aload_1
    //   6739: iload 4
    //   6741: aload_2
    //   6742: invokespecial 1612	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILjava/lang/String;)V
    //   6745: invokevirtual 1616	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getAuthList	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6748: goto -5345 -> 1403
    //   6751: astore_2
    //   6752: aload_2
    //   6753: invokevirtual 463	java/lang/Throwable:printStackTrace	()V
    //   6756: aload_0
    //   6757: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6760: aload_3
    //   6761: aload_1
    //   6762: aconst_null
    //   6763: iload 4
    //   6765: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6768: goto -5365 -> 1403
    //   6771: aload 20
    //   6773: aload 21
    //   6775: invokevirtual 1619	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   6778: istore 8
    //   6780: iload 8
    //   6782: istore 7
    //   6784: iload 8
    //   6786: iconst_1
    //   6787: if_icmpne +42 -> 6829
    //   6790: aload_0
    //   6791: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6794: invokevirtual 1622	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   6797: ifne +3876 -> 10673
    //   6800: aload_0
    //   6801: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6804: astore 20
    //   6806: iload 8
    //   6808: istore 7
    //   6810: aload_0
    //   6811: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6814: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6817: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6820: invokestatic 1625	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   6823: ifeq +6 -> 6829
    //   6826: goto +3847 -> 10673
    //   6829: iload 7
    //   6831: iconst_2
    //   6832: if_icmpne +18 -> 6850
    //   6835: aload_0
    //   6836: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6839: aload_3
    //   6840: aload_1
    //   6841: aconst_null
    //   6842: iload 4
    //   6844: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6847: goto -5444 -> 1403
    //   6850: aload_0
    //   6851: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6854: aload_1
    //   6855: aload_2
    //   6856: aload_3
    //   6857: iload 4
    //   6859: invokevirtual 1629	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:reqAuthorize	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   6862: goto -5459 -> 1403
    //   6865: aload_0
    //   6866: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6869: aload_3
    //   6870: aload_1
    //   6871: aconst_null
    //   6872: iload 4
    //   6874: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6877: goto -5474 -> 1403
    //   6880: ldc 56
    //   6882: aload_1
    //   6883: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6886: ifeq +165 -> 7051
    //   6889: new 348	org/json/JSONObject
    //   6892: dup
    //   6893: aload_2
    //   6894: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6897: astore_1
    //   6898: ldc 150
    //   6900: iconst_2
    //   6901: new 398	java/lang/StringBuilder
    //   6904: dup
    //   6905: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   6908: ldc_w 1631
    //   6911: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6914: aload_1
    //   6915: invokevirtual 1120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6918: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6921: invokestatic 517	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6924: new 764	android/content/Intent
    //   6927: dup
    //   6928: invokespecial 1632	android/content/Intent:<init>	()V
    //   6931: astore_2
    //   6932: aload_2
    //   6933: new 1634	android/content/ComponentName
    //   6936: dup
    //   6937: aload_0
    //   6938: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6941: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6944: getfield 578	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6947: ldc_w 1636
    //   6950: invokespecial 1637	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6953: invokevirtual 1641	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   6956: pop
    //   6957: aload_2
    //   6958: ldc_w 1643
    //   6961: aload_1
    //   6962: ldc_w 1643
    //   6965: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6968: invokevirtual 775	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6971: pop
    //   6972: aload_2
    //   6973: ldc_w 1645
    //   6976: sipush 1008
    //   6979: invokevirtual 1648	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6982: pop
    //   6983: aload_2
    //   6984: ldc_w 1650
    //   6987: iconst_2
    //   6988: invokevirtual 1648	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6991: pop
    //   6992: aload_2
    //   6993: ldc_w 1652
    //   6996: aload_1
    //   6997: ldc_w 1654
    //   7000: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7003: invokevirtual 775	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7006: pop
    //   7007: aload_2
    //   7008: ldc_w 1655
    //   7011: invokevirtual 1659	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   7014: pop
    //   7015: aload_0
    //   7016: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7019: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7022: getfield 578	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   7025: aload_2
    //   7026: invokevirtual 1173	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   7029: goto -5626 -> 1403
    //   7032: astore_1
    //   7033: ldc 150
    //   7035: iconst_1
    //   7036: aload_1
    //   7037: iconst_0
    //   7038: anewarray 873	java/lang/Object
    //   7041: invokestatic 1226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7044: aload_1
    //   7045: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   7048: goto -5645 -> 1403
    //   7051: ldc 11
    //   7053: aload_1
    //   7054: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7057: ifeq +61 -> 7118
    //   7060: new 348	org/json/JSONObject
    //   7063: dup
    //   7064: aload_2
    //   7065: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7068: astore_2
    //   7069: new 1661	Wallet/FocusMpIdReq
    //   7072: dup
    //   7073: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7076: invokevirtual 1246	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   7079: invokevirtual 1251	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7082: aload_2
    //   7083: ldc_w 1663
    //   7086: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7089: invokespecial 1664	Wallet/FocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   7092: new 1666	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14
    //   7095: dup
    //   7096: aload_0
    //   7097: aload_3
    //   7098: aload_1
    //   7099: iload 4
    //   7101: invokespecial 1667	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7104: invokestatic 1261	akmf:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   7107: goto -5704 -> 1403
    //   7110: astore_1
    //   7111: aload_1
    //   7112: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   7115: goto -5712 -> 1403
    //   7118: ldc_w 1669
    //   7121: aload_1
    //   7122: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7125: ifeq +34 -> 7159
    //   7128: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7131: aload_0
    //   7132: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7135: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7138: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7141: new 1671	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15
    //   7144: dup
    //   7145: aload_0
    //   7146: aload_3
    //   7147: aload_1
    //   7148: iload 4
    //   7150: invokespecial 1672	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7153: invokevirtual 1675	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getFormId	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7156: goto -5753 -> 1403
    //   7159: ldc 121
    //   7161: aload_1
    //   7162: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7165: ifeq +149 -> 7314
    //   7168: aload_0
    //   7169: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7172: ifnonnull +7 -> 7179
    //   7175: ldc_w 525
    //   7178: areturn
    //   7179: new 348	org/json/JSONObject
    //   7182: dup
    //   7183: aload_2
    //   7184: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7187: ldc_w 1676
    //   7190: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7193: astore_2
    //   7194: invokestatic 574	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   7197: aload_0
    //   7198: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7201: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7204: getfield 578	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   7207: invokevirtual 582	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   7210: astore_1
    //   7211: aload_1
    //   7212: ifnull +3467 -> 10679
    //   7215: aload_1
    //   7216: invokevirtual 588	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getMiniGamePkg	()Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;
    //   7219: astore_1
    //   7220: aload_2
    //   7221: aload_1
    //   7222: invokestatic 1682	com/tencent/mobileqq/mini/entry/MiniAppUtils:checkNavigationAppIdListForMiniGame	(Ljava/lang/String;Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;)Z
    //   7225: istore 15
    //   7227: new 348	org/json/JSONObject
    //   7230: dup
    //   7231: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   7234: astore_1
    //   7235: aload_1
    //   7236: ldc_w 1684
    //   7239: iload 15
    //   7241: invokevirtual 1687	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   7244: pop
    //   7245: ldc 150
    //   7247: iconst_2
    //   7248: new 398	java/lang/StringBuilder
    //   7251: dup
    //   7252: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   7255: ldc_w 1689
    //   7258: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7261: aload_1
    //   7262: invokevirtual 1120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7265: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7268: invokestatic 517	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7271: aload_1
    //   7272: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7275: areturn
    //   7276: astore_2
    //   7277: ldc 150
    //   7279: iconst_1
    //   7280: aload_2
    //   7281: iconst_0
    //   7282: anewarray 873	java/lang/Object
    //   7285: invokestatic 1226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7288: aload_2
    //   7289: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   7292: goto -47 -> 7245
    //   7295: astore_1
    //   7296: ldc 150
    //   7298: iconst_1
    //   7299: aload_1
    //   7300: iconst_0
    //   7301: anewarray 873	java/lang/Object
    //   7304: invokestatic 1226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7307: aload_1
    //   7308: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   7311: goto -5908 -> 1403
    //   7314: ldc_w 1691
    //   7317: aload_1
    //   7318: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7321: ifeq +222 -> 7543
    //   7324: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7327: invokevirtual 1246	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   7330: astore_1
    //   7331: aload_1
    //   7332: instanceof 675
    //   7335: ifeq +3150 -> 10485
    //   7338: aload_1
    //   7339: checkcast 675	com/tencent/mobileqq/mini/MiniAppInterface
    //   7342: astore_1
    //   7343: aload_0
    //   7344: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7347: ifnull +7 -> 7354
    //   7350: aload_1
    //   7351: ifnonnull +26 -> 7377
    //   7354: aload_0
    //   7355: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7358: aload_3
    //   7359: ldc_w 1692
    //   7362: aconst_null
    //   7363: ldc_w 1693
    //   7366: invokestatic 1697	anni:a	(I)Ljava/lang/String;
    //   7369: iload 4
    //   7371: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7374: goto -5971 -> 1403
    //   7377: aload_1
    //   7378: aload_0
    //   7379: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7382: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7385: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7388: invokevirtual 679	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   7391: astore_1
    //   7392: aload_1
    //   7393: ifnull +121 -> 7514
    //   7396: ldc_w 1699
    //   7399: invokestatic 1599	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   7402: ifeq +112 -> 7514
    //   7405: aload_1
    //   7406: ldc_w 1699
    //   7409: invokevirtual 1619	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   7412: istore 8
    //   7414: iload 8
    //   7416: istore 7
    //   7418: iload 8
    //   7420: iconst_1
    //   7421: if_icmpne +41 -> 7462
    //   7424: aload_0
    //   7425: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7428: invokevirtual 1622	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   7431: ifne +28 -> 7459
    //   7434: aload_0
    //   7435: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7438: astore_1
    //   7439: iload 8
    //   7441: istore 7
    //   7443: aload_0
    //   7444: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7447: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7450: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7453: invokestatic 1625	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   7456: ifeq +6 -> 7462
    //   7459: iconst_2
    //   7460: istore 7
    //   7462: iload 7
    //   7464: iconst_2
    //   7465: if_icmpne +20 -> 7485
    //   7468: aload_0
    //   7469: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7472: aload_3
    //   7473: ldc_w 1692
    //   7476: aconst_null
    //   7477: iload 4
    //   7479: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7482: goto -6079 -> 1403
    //   7485: ldc 150
    //   7487: iconst_1
    //   7488: ldc_w 1701
    //   7491: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7494: aload_0
    //   7495: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7498: aload_3
    //   7499: ldc_w 1692
    //   7502: aconst_null
    //   7503: ldc_w 1701
    //   7506: iload 4
    //   7508: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7511: goto -6108 -> 1403
    //   7514: aload_0
    //   7515: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7518: aload_3
    //   7519: ldc_w 1692
    //   7522: aconst_null
    //   7523: ldc_w 1703
    //   7526: iload 4
    //   7528: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7531: ldc 150
    //   7533: iconst_1
    //   7534: ldc_w 1705
    //   7537: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7540: goto -6137 -> 1403
    //   7543: ldc_w 1707
    //   7546: aload_1
    //   7547: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7550: ifeq +213 -> 7763
    //   7553: new 348	org/json/JSONObject
    //   7556: dup
    //   7557: aload_2
    //   7558: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7561: astore 20
    //   7563: aload 20
    //   7565: ldc_w 1709
    //   7568: invokevirtual 1593	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7571: astore_2
    //   7572: aload 20
    //   7574: ldc_w 634
    //   7577: ldc_w 1221
    //   7580: invokevirtual 1183	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7583: astore 20
    //   7585: aload_2
    //   7586: ifnull -6183 -> 1403
    //   7589: aload_2
    //   7590: invokevirtual 1409	org/json/JSONArray:length	()I
    //   7593: ifle -6190 -> 1403
    //   7596: aload_2
    //   7597: invokevirtual 1409	org/json/JSONArray:length	()I
    //   7600: anewarray 435	java/lang/String
    //   7603: astore 21
    //   7605: iconst_0
    //   7606: istore 7
    //   7608: iload 7
    //   7610: aload_2
    //   7611: invokevirtual 1409	org/json/JSONArray:length	()I
    //   7614: if_icmpge +23 -> 7637
    //   7617: aload 21
    //   7619: iload 7
    //   7621: aload_2
    //   7622: iload 7
    //   7624: invokevirtual 1411	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   7627: aastore
    //   7628: iload 7
    //   7630: iconst_1
    //   7631: iadd
    //   7632: istore 7
    //   7634: goto -26 -> 7608
    //   7637: invokestatic 574	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   7640: aload_0
    //   7641: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7644: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7647: getfield 578	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   7650: invokevirtual 582	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   7653: astore_2
    //   7654: aload_2
    //   7655: ifnonnull +26 -> 7681
    //   7658: aload_1
    //   7659: aconst_null
    //   7660: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   7663: astore_2
    //   7664: aload_0
    //   7665: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7668: aload_3
    //   7669: aload_1
    //   7670: aload_2
    //   7671: iload 4
    //   7673: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7676: aload_2
    //   7677: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7680: areturn
    //   7681: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7684: aload_2
    //   7685: invokevirtual 1713	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7688: invokevirtual 1716	com/tencent/mobileqq/minigame/manager/GameInfoManager:getAppId	()Ljava/lang/String;
    //   7691: aload 20
    //   7693: aload 21
    //   7695: new 1718	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16
    //   7698: dup
    //   7699: aload_0
    //   7700: aload_2
    //   7701: aload_3
    //   7702: aload_1
    //   7703: iload 4
    //   7705: invokespecial 1721	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7708: invokevirtual 1725	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoOpenData	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7711: goto -6308 -> 1403
    //   7714: astore_2
    //   7715: aload_0
    //   7716: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7719: aload_3
    //   7720: aload_1
    //   7721: aconst_null
    //   7722: iload 4
    //   7724: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7727: ldc 150
    //   7729: iconst_1
    //   7730: new 398	java/lang/StringBuilder
    //   7733: dup
    //   7734: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   7737: ldc_w 1727
    //   7740: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7743: aload_1
    //   7744: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7747: ldc_w 1729
    //   7750: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7753: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7756: aload_2
    //   7757: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7760: goto -6357 -> 1403
    //   7763: ldc 41
    //   7765: aload_1
    //   7766: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7769: ifeq +424 -> 8193
    //   7772: new 348	org/json/JSONObject
    //   7775: dup
    //   7776: aload_2
    //   7777: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7780: astore_2
    //   7781: aload_2
    //   7782: ldc_w 1731
    //   7785: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7788: astore 23
    //   7790: aload_2
    //   7791: ldc_w 1733
    //   7794: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7797: astore 24
    //   7799: aload_2
    //   7800: ldc_w 1735
    //   7803: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7806: astore 25
    //   7808: aload_2
    //   7809: ldc_w 1737
    //   7812: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7815: astore 21
    //   7817: aload_2
    //   7818: ldc_w 1739
    //   7821: invokevirtual 1742	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7824: istore 7
    //   7826: ldc_w 1744
    //   7829: aload 24
    //   7831: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7834: ifne +33 -> 7867
    //   7837: ldc_w 1746
    //   7840: aload 24
    //   7842: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7845: ifne +22 -> 7867
    //   7848: aload_0
    //   7849: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7852: aload_3
    //   7853: aload_1
    //   7854: aconst_null
    //   7855: ldc_w 1748
    //   7858: iload 4
    //   7860: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7863: ldc_w 525
    //   7866: areturn
    //   7867: ldc_w 1744
    //   7870: aload 23
    //   7872: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7875: ifne +33 -> 7908
    //   7878: ldc_w 1750
    //   7881: aload 23
    //   7883: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7886: ifne +22 -> 7908
    //   7889: aload_0
    //   7890: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7893: aload_3
    //   7894: aload_1
    //   7895: aconst_null
    //   7896: ldc_w 1752
    //   7899: iload 4
    //   7901: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7904: ldc_w 525
    //   7907: areturn
    //   7908: iload 7
    //   7910: ifgt +22 -> 7932
    //   7913: aload_0
    //   7914: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7917: aload_3
    //   7918: aload_1
    //   7919: aconst_null
    //   7920: ldc_w 1754
    //   7923: iload 4
    //   7925: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7928: ldc_w 525
    //   7931: areturn
    //   7932: aload 21
    //   7934: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7937: ifeq +22 -> 7959
    //   7940: aload_0
    //   7941: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7944: aload_3
    //   7945: aload_1
    //   7946: aconst_null
    //   7947: ldc_w 1756
    //   7950: iload 4
    //   7952: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7955: ldc_w 525
    //   7958: areturn
    //   7959: new 1758	android/graphics/Paint
    //   7962: dup
    //   7963: invokespecial 1759	android/graphics/Paint:<init>	()V
    //   7966: astore 22
    //   7968: aload 22
    //   7970: iload 7
    //   7972: i2f
    //   7973: invokevirtual 1763	android/graphics/Paint:setTextSize	(F)V
    //   7976: aconst_null
    //   7977: astore 20
    //   7979: ldc_w 1744
    //   7982: aload 23
    //   7984: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7987: ifeq +68 -> 8055
    //   7990: ldc_w 1744
    //   7993: aload 24
    //   7995: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7998: ifeq +33 -> 8031
    //   8001: aload 25
    //   8003: iconst_0
    //   8004: invokestatic 1769	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   8007: astore_2
    //   8008: aload_2
    //   8009: ifnonnull +105 -> 8114
    //   8012: aload_0
    //   8013: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8016: aload_3
    //   8017: aload_1
    //   8018: aconst_null
    //   8019: ldc_w 1771
    //   8022: iload 4
    //   8024: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8027: ldc_w 525
    //   8030: areturn
    //   8031: aload 20
    //   8033: astore_2
    //   8034: ldc_w 1746
    //   8037: aload 24
    //   8039: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8042: ifeq -34 -> 8008
    //   8045: aload 25
    //   8047: iconst_1
    //   8048: invokestatic 1769	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   8051: astore_2
    //   8052: goto -44 -> 8008
    //   8055: aload 20
    //   8057: astore_2
    //   8058: ldc_w 1750
    //   8061: aload 23
    //   8063: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8066: ifeq -58 -> 8008
    //   8069: ldc_w 1744
    //   8072: aload 24
    //   8074: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8077: ifeq +13 -> 8090
    //   8080: aload 25
    //   8082: iconst_2
    //   8083: invokestatic 1769	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   8086: astore_2
    //   8087: goto -79 -> 8008
    //   8090: aload 20
    //   8092: astore_2
    //   8093: ldc_w 1746
    //   8096: aload 24
    //   8098: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8101: ifeq -93 -> 8008
    //   8104: aload 25
    //   8106: iconst_3
    //   8107: invokestatic 1769	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   8110: astore_2
    //   8111: goto -103 -> 8008
    //   8114: new 1773	android/graphics/Rect
    //   8117: dup
    //   8118: invokespecial 1774	android/graphics/Rect:<init>	()V
    //   8121: astore_2
    //   8122: aload 22
    //   8124: aload 21
    //   8126: iconst_0
    //   8127: aload 21
    //   8129: invokevirtual 1775	java/lang/String:length	()I
    //   8132: aload_2
    //   8133: invokevirtual 1779	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   8136: aload_0
    //   8137: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8140: aload_3
    //   8141: aload_1
    //   8142: aconst_null
    //   8143: iload 4
    //   8145: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8148: new 398	java/lang/StringBuilder
    //   8151: dup
    //   8152: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   8155: ldc_w 525
    //   8158: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8161: aload_2
    //   8162: invokevirtual 1782	android/graphics/Rect:height	()I
    //   8165: invokevirtual 747	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8168: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8171: astore_2
    //   8172: aload_2
    //   8173: areturn
    //   8174: astore_2
    //   8175: aload_0
    //   8176: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8179: aload_3
    //   8180: aload_1
    //   8181: aconst_null
    //   8182: ldc_w 1784
    //   8185: iload 4
    //   8187: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8190: goto -6787 -> 1403
    //   8193: ldc_w 1786
    //   8196: aload_1
    //   8197: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8200: ifeq +28 -> 8228
    //   8203: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   8206: aload_0
    //   8207: invokevirtual 1607	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   8210: new 1788	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17
    //   8213: dup
    //   8214: aload_0
    //   8215: aload_3
    //   8216: aload_1
    //   8217: iload 4
    //   8219: invokespecial 1789	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   8222: invokevirtual 1791	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoExtra	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   8225: goto -6822 -> 1403
    //   8228: ldc 23
    //   8230: aload_1
    //   8231: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8234: ifeq +323 -> 8557
    //   8237: aload_0
    //   8238: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   8241: ifeq -6838 -> 1403
    //   8244: invokestatic 574	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   8247: aload_0
    //   8248: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8251: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8254: getfield 578	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8257: invokevirtual 582	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   8260: astore 20
    //   8262: aload 20
    //   8264: ifnonnull +26 -> 8290
    //   8267: aload_1
    //   8268: aconst_null
    //   8269: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8272: astore_2
    //   8273: aload_0
    //   8274: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8277: aload_3
    //   8278: aload_1
    //   8279: aload_2
    //   8280: iload 4
    //   8282: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8285: aload_2
    //   8286: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8289: areturn
    //   8290: aload 20
    //   8292: invokevirtual 1713	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8295: invokevirtual 1795	com/tencent/mobileqq/minigame/manager/GameInfoManager:getLaunchOptions	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions;
    //   8298: astore 21
    //   8300: new 348	org/json/JSONObject
    //   8303: dup
    //   8304: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   8307: astore 22
    //   8309: new 348	org/json/JSONObject
    //   8312: dup
    //   8313: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   8316: astore 23
    //   8318: aload 21
    //   8320: getfield 1800	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8323: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8326: ifeq +170 -> 8496
    //   8329: aconst_null
    //   8330: astore_2
    //   8331: aload 23
    //   8333: ldc_w 1676
    //   8336: aload_2
    //   8337: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8340: pop
    //   8341: aload 21
    //   8343: getfield 1803	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8346: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8349: ifeq +156 -> 8505
    //   8352: aconst_null
    //   8353: astore_2
    //   8354: aload 23
    //   8356: ldc_w 1805
    //   8359: aload_2
    //   8360: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8363: pop
    //   8364: aload 22
    //   8366: ldc_w 1806
    //   8369: aload 21
    //   8371: getfield 1807	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:scene	I
    //   8374: invokestatic 1813	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getWikiScene	(I)I
    //   8377: invokevirtual 1067	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   8380: pop
    //   8381: aload 22
    //   8383: ldc_w 1455
    //   8386: aload 21
    //   8388: getfield 1815	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:query	Lorg/json/JSONObject;
    //   8391: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8394: pop
    //   8395: aload 21
    //   8397: getfield 1817	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8400: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8403: ifeq +111 -> 8514
    //   8406: aconst_null
    //   8407: astore_2
    //   8408: aload 22
    //   8410: ldc_w 1350
    //   8413: aload_2
    //   8414: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8417: pop
    //   8418: aload 22
    //   8420: ldc_w 1819
    //   8423: aload 23
    //   8425: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8428: pop
    //   8429: aload 22
    //   8431: ldc_w 1821
    //   8434: aload 20
    //   8436: invokevirtual 1713	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8439: invokevirtual 1824	com/tencent/mobileqq/minigame/manager/GameInfoManager:getExtendData	()Ljava/lang/String;
    //   8442: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8445: pop
    //   8446: aload 22
    //   8448: ldc_w 1480
    //   8451: aload 21
    //   8453: getfield 1826	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:entryDataHash	Ljava/lang/String;
    //   8456: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8459: pop
    //   8460: ldc 150
    //   8462: iconst_1
    //   8463: new 398	java/lang/StringBuilder
    //   8466: dup
    //   8467: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   8470: ldc_w 1828
    //   8473: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8476: aload 22
    //   8478: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8481: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8484: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8487: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8490: aload 22
    //   8492: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8495: areturn
    //   8496: aload 21
    //   8498: getfield 1800	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8501: astore_2
    //   8502: goto -171 -> 8331
    //   8505: aload 21
    //   8507: getfield 1803	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8510: astore_2
    //   8511: goto -157 -> 8354
    //   8514: aload 21
    //   8516: getfield 1817	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8519: astore_2
    //   8520: goto -112 -> 8408
    //   8523: astore_2
    //   8524: ldc 150
    //   8526: iconst_1
    //   8527: ldc_w 1830
    //   8530: aload_2
    //   8531: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8534: aload_1
    //   8535: aconst_null
    //   8536: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8539: astore_1
    //   8540: aload_3
    //   8541: iload 4
    //   8543: aload_1
    //   8544: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8547: invokeinterface 623 3 0
    //   8552: aload_1
    //   8553: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8556: areturn
    //   8557: ldc 53
    //   8559: aload_1
    //   8560: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8563: ifeq +648 -> 9211
    //   8566: new 348	org/json/JSONObject
    //   8569: dup
    //   8570: aload_2
    //   8571: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8574: astore_2
    //   8575: ldc 150
    //   8577: iconst_1
    //   8578: new 398	java/lang/StringBuilder
    //   8581: dup
    //   8582: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   8585: ldc_w 1832
    //   8588: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8591: aload_2
    //   8592: invokevirtual 1120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8595: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8598: invokestatic 517	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8601: aload_2
    //   8602: ldc_w 771
    //   8605: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8608: astore 22
    //   8610: aload 22
    //   8612: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8615: ifeq +20 -> 8635
    //   8618: aload_0
    //   8619: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8622: aload_3
    //   8623: aload_1
    //   8624: aconst_null
    //   8625: ldc_w 1834
    //   8628: iload 4
    //   8630: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8633: aconst_null
    //   8634: areturn
    //   8635: aload_2
    //   8636: ldc_w 1836
    //   8639: iconst_0
    //   8640: invokevirtual 1188	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8643: istore 15
    //   8645: aload 22
    //   8647: invokevirtual 1839	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   8650: astore 20
    //   8652: aload 20
    //   8654: invokestatic 1845	com/tencent/mobileqq/mini/apkg/DomainConfig:getDomainConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/DomainConfig;
    //   8657: astore 21
    //   8659: iload 15
    //   8661: ifne +78 -> 8739
    //   8664: aload_0
    //   8665: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8668: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8671: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   8674: aload 20
    //   8676: iconst_0
    //   8677: invokevirtual 1848	com/tencent/mobileqq/mini/apkg/ApkgInfo:isValidPrefix	(Ljava/lang/String;Z)Z
    //   8680: ifne +20 -> 8700
    //   8683: aload_0
    //   8684: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8687: aload_3
    //   8688: aload_1
    //   8689: aconst_null
    //   8690: ldc_w 1850
    //   8693: iload 4
    //   8695: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8698: aconst_null
    //   8699: areturn
    //   8700: aload_0
    //   8701: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8704: ifnull +35 -> 8739
    //   8707: aload_0
    //   8708: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8711: aload 21
    //   8713: getfield 1853	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8716: invokevirtual 1856	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   8719: ifne +20 -> 8739
    //   8722: aload_0
    //   8723: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8726: aload_3
    //   8727: aload_1
    //   8728: aconst_null
    //   8729: ldc_w 1858
    //   8732: iload 4
    //   8734: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8737: aconst_null
    //   8738: areturn
    //   8739: ldc_w 1860
    //   8742: aload 21
    //   8744: getfield 1853	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8747: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8750: ifeq +438 -> 9188
    //   8753: ldc_w 1862
    //   8756: ldc_w 1864
    //   8759: invokestatic 1869	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8762: astore_2
    //   8763: aload 22
    //   8765: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8768: ifne +402 -> 9170
    //   8771: aload_0
    //   8772: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8775: ifnull +395 -> 9170
    //   8778: aload_0
    //   8779: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8782: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8785: ifnull +385 -> 9170
    //   8788: invokestatic 1874	com/tencent/mobileqq/mini/mainpage/MainPageFragment:getUin	()Ljava/lang/String;
    //   8791: astore 21
    //   8793: aload 21
    //   8795: ifnonnull +1889 -> 10684
    //   8798: ldc_w 525
    //   8801: astore 20
    //   8803: aload 22
    //   8805: ldc_w 1876
    //   8808: aload 20
    //   8810: invokevirtual 1880	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8813: ldc_w 1882
    //   8816: invokestatic 1086	bgln:c	()Ljava/lang/String;
    //   8819: invokevirtual 1880	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8822: ldc_w 1884
    //   8825: ldc_w 1097
    //   8828: invokevirtual 1880	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8831: ldc_w 1886
    //   8834: getstatic 887	android/os/Build$VERSION:SDK_INT	I
    //   8837: invokestatic 542	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   8840: invokevirtual 1880	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8843: ldc_w 1888
    //   8846: invokestatic 1892	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8849: invokestatic 1897	bgnt:a	(Landroid/content/Context;)Ljava/lang/String;
    //   8852: invokevirtual 1880	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8855: ldc_w 1899
    //   8858: aload_2
    //   8859: invokevirtual 1880	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8862: astore 22
    //   8864: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8867: new 398	java/lang/StringBuilder
    //   8870: dup
    //   8871: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   8874: getstatic 1905	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   8877: invokevirtual 1906	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   8880: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8883: aload 21
    //   8885: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8888: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8891: invokevirtual 1909	com/tencent/common/app/BaseApplicationImpl:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   8894: astore 20
    //   8896: aload 20
    //   8898: astore_2
    //   8899: aload 20
    //   8901: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8904: ifeq +7 -> 8911
    //   8907: ldc_w 525
    //   8910: astore_2
    //   8911: aload 22
    //   8913: ldc_w 1911
    //   8916: aload_2
    //   8917: invokevirtual 1880	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8920: astore_2
    //   8921: invokestatic 863	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8924: ifeq +29 -> 8953
    //   8927: ldc 150
    //   8929: iconst_2
    //   8930: new 398	java/lang/StringBuilder
    //   8933: dup
    //   8934: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   8937: ldc_w 1913
    //   8940: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8943: aload_2
    //   8944: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8947: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8950: invokestatic 517	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8953: new 764	android/content/Intent
    //   8956: dup
    //   8957: aload_0
    //   8958: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8961: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8964: getfield 578	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8967: ldc_w 766
    //   8970: invokespecial 769	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8973: astore 20
    //   8975: aload 20
    //   8977: ldc_w 1915
    //   8980: ldc_w 1916
    //   8983: invokestatic 1697	anni:a	(I)Ljava/lang/String;
    //   8986: invokevirtual 775	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8989: pop
    //   8990: aload 20
    //   8992: ldc_w 780
    //   8995: iconst_1
    //   8996: invokevirtual 1919	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8999: pop
    //   9000: aload 20
    //   9002: ldc_w 1921
    //   9005: iconst_1
    //   9006: invokevirtual 1919	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   9009: pop
    //   9010: aload 20
    //   9012: ldc_w 771
    //   9015: aload_2
    //   9016: invokevirtual 775	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9019: pop
    //   9020: aload_0
    //   9021: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9024: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9027: getfield 578	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   9030: aload 20
    //   9032: invokevirtual 1173	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   9035: aload_0
    //   9036: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9039: aload_3
    //   9040: aload_1
    //   9041: aconst_null
    //   9042: iload 4
    //   9044: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9047: aload_2
    //   9048: ldc_w 1923
    //   9051: invokevirtual 1472	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9054: ifeq -7651 -> 1403
    //   9057: ldc 150
    //   9059: iconst_2
    //   9060: ldc_w 1925
    //   9063: invokestatic 517	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9066: new 777	android/os/Bundle
    //   9069: dup
    //   9070: invokespecial 778	android/os/Bundle:<init>	()V
    //   9073: astore_1
    //   9074: aload_1
    //   9075: ldc_w 1927
    //   9078: aload_0
    //   9079: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9082: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9085: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9088: invokevirtual 1331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9091: invokestatic 1932	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   9094: ldc_w 1934
    //   9097: ldc_w 1936
    //   9100: aload_1
    //   9101: new 1938	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18
    //   9104: dup
    //   9105: aload_0
    //   9106: invokespecial 1941	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;)V
    //   9109: invokevirtual 1945	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   9112: goto -7709 -> 1403
    //   9115: astore_1
    //   9116: ldc 150
    //   9118: iconst_1
    //   9119: aload_1
    //   9120: iconst_0
    //   9121: anewarray 873	java/lang/Object
    //   9124: invokestatic 1226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   9127: goto -7724 -> 1403
    //   9130: astore_2
    //   9131: ldc 150
    //   9133: iconst_1
    //   9134: new 398	java/lang/StringBuilder
    //   9137: dup
    //   9138: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   9141: ldc_w 1947
    //   9144: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9147: ldc_w 525
    //   9150: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9153: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9156: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   9159: aload_2
    //   9160: invokevirtual 1948	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   9163: ldc_w 525
    //   9166: astore_2
    //   9167: goto -404 -> 8763
    //   9170: aload_0
    //   9171: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9174: aload_3
    //   9175: aload_1
    //   9176: aconst_null
    //   9177: ldc_w 1950
    //   9180: iload 4
    //   9182: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9185: goto -7782 -> 1403
    //   9188: new 1952	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19
    //   9191: dup
    //   9192: aload_0
    //   9193: aload_2
    //   9194: aload_3
    //   9195: aload_1
    //   9196: iload 4
    //   9198: invokespecial 1955	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9201: bipush 16
    //   9203: aconst_null
    //   9204: iconst_0
    //   9205: invokestatic 1959	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   9208: goto -7805 -> 1403
    //   9211: ldc 62
    //   9213: aload_1
    //   9214: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9217: ifeq +113 -> 9330
    //   9220: new 348	org/json/JSONObject
    //   9223: dup
    //   9224: aload_2
    //   9225: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9228: ldc_w 1961
    //   9231: iconst_0
    //   9232: invokevirtual 1188	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   9235: istore 15
    //   9237: aload_0
    //   9238: invokevirtual 1379	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   9241: ifeq -7838 -> 1403
    //   9244: invokestatic 574	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   9247: aload_0
    //   9248: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9251: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9254: getfield 578	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   9257: invokevirtual 582	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   9260: astore_2
    //   9261: aload_2
    //   9262: ifnonnull +26 -> 9288
    //   9265: aload_1
    //   9266: aconst_null
    //   9267: invokestatic 618	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   9270: astore_2
    //   9271: aload_0
    //   9272: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9275: aload_3
    //   9276: aload_1
    //   9277: aload_2
    //   9278: iload 4
    //   9280: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9283: aload_2
    //   9284: invokevirtual 608	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9287: areturn
    //   9288: aload_2
    //   9289: invokevirtual 1713	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   9292: invokevirtual 1965	com/tencent/mobileqq/minigame/manager/GameInfoManager:getMiniAppConfig	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9295: iload 15
    //   9297: invokestatic 1971	com/tencent/mobileqq/minigame/gpkg/GpkgManager:setOfflineResourceContent	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Z)V
    //   9300: aload_0
    //   9301: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9304: aload_3
    //   9305: aload_1
    //   9306: aconst_null
    //   9307: iload 4
    //   9309: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9312: goto -7909 -> 1403
    //   9315: astore_1
    //   9316: ldc 150
    //   9318: iconst_1
    //   9319: aload_1
    //   9320: iconst_0
    //   9321: anewarray 873	java/lang/Object
    //   9324: invokestatic 1226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   9327: goto -7924 -> 1403
    //   9330: ldc 95
    //   9332: aload_1
    //   9333: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9336: ifeq +178 -> 9514
    //   9339: aload_0
    //   9340: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9343: ifnull -7940 -> 1403
    //   9346: new 446	java/util/ArrayList
    //   9349: dup
    //   9350: invokespecial 447	java/util/ArrayList:<init>	()V
    //   9353: astore 20
    //   9355: new 348	org/json/JSONObject
    //   9358: dup
    //   9359: aload_2
    //   9360: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9363: ldc_w 479
    //   9366: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   9369: ldc_w 1973
    //   9372: invokevirtual 1593	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9375: astore_2
    //   9376: aload_2
    //   9377: ifnull +85 -> 9462
    //   9380: aload_2
    //   9381: invokevirtual 1409	org/json/JSONArray:length	()I
    //   9384: ifle +78 -> 9462
    //   9387: iconst_0
    //   9388: istore 7
    //   9390: iload 7
    //   9392: aload_2
    //   9393: invokevirtual 1409	org/json/JSONArray:length	()I
    //   9396: if_icmpge +66 -> 9462
    //   9399: aload_2
    //   9400: iload 7
    //   9402: invokevirtual 1977	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9405: checkcast 348	org/json/JSONObject
    //   9408: astore 21
    //   9410: new 1979	com/tencent/mobileqq/mini/apkg/PluginInfo
    //   9413: dup
    //   9414: invokespecial 1980	com/tencent/mobileqq/mini/apkg/PluginInfo:<init>	()V
    //   9417: astore 22
    //   9419: aload 22
    //   9421: aload 21
    //   9423: ldc_w 1982
    //   9426: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9429: invokevirtual 1985	com/tencent/mobileqq/mini/apkg/PluginInfo:setPluginId	(Ljava/lang/String;)V
    //   9432: aload 22
    //   9434: aload 21
    //   9436: ldc_w 1987
    //   9439: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9442: invokevirtual 1990	com/tencent/mobileqq/mini/apkg/PluginInfo:setInnerVersion	(Ljava/lang/String;)V
    //   9445: aload 20
    //   9447: aload 22
    //   9449: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9452: pop
    //   9453: iload 7
    //   9455: iconst_1
    //   9456: iadd
    //   9457: istore 7
    //   9459: goto -69 -> 9390
    //   9462: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9465: aload_0
    //   9466: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9469: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9472: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9475: aload 20
    //   9477: new 1992	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20
    //   9480: dup
    //   9481: aload_0
    //   9482: aload_3
    //   9483: aload_1
    //   9484: iload 4
    //   9486: invokespecial 1993	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9489: invokevirtual 1996	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:verifyPlugin	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9492: goto -8089 -> 1403
    //   9495: astore_2
    //   9496: aload_0
    //   9497: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9500: aload_3
    //   9501: aload_1
    //   9502: aconst_null
    //   9503: ldc_w 1998
    //   9506: iload 4
    //   9508: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9511: goto -8108 -> 1403
    //   9514: ldc 14
    //   9516: aload_1
    //   9517: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9520: ifeq +127 -> 9647
    //   9523: aload_0
    //   9524: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9527: ifnull -8124 -> 1403
    //   9530: aload_2
    //   9531: ifnull -8128 -> 1403
    //   9534: new 348	org/json/JSONObject
    //   9537: dup
    //   9538: aload_2
    //   9539: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9542: ldc_w 2000
    //   9545: invokevirtual 1593	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9548: astore_2
    //   9549: new 446	java/util/ArrayList
    //   9552: dup
    //   9553: invokespecial 447	java/util/ArrayList:<init>	()V
    //   9556: astore 20
    //   9558: aload_2
    //   9559: ifnull +46 -> 9605
    //   9562: aload_2
    //   9563: invokevirtual 1409	org/json/JSONArray:length	()I
    //   9566: ifle +39 -> 9605
    //   9569: iconst_0
    //   9570: istore 7
    //   9572: iload 7
    //   9574: aload_2
    //   9575: invokevirtual 1409	org/json/JSONArray:length	()I
    //   9578: if_icmpge +27 -> 9605
    //   9581: aload 20
    //   9583: aload_2
    //   9584: iload 7
    //   9586: invokevirtual 1977	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9589: invokestatic 2003	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9592: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9595: pop
    //   9596: iload 7
    //   9598: iconst_1
    //   9599: iadd
    //   9600: istore 7
    //   9602: goto -30 -> 9572
    //   9605: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9608: aload 20
    //   9610: new 2005	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21
    //   9613: dup
    //   9614: aload_0
    //   9615: aload_3
    //   9616: aload_1
    //   9617: iload 4
    //   9619: invokespecial 2006	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9622: invokevirtual 2009	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:batchGetContact	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9625: goto -8222 -> 1403
    //   9628: astore_2
    //   9629: aload_0
    //   9630: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9633: aload_3
    //   9634: aload_1
    //   9635: aconst_null
    //   9636: ldc_w 2011
    //   9639: iload 4
    //   9641: invokevirtual 704	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9644: goto -8241 -> 1403
    //   9647: ldc 26
    //   9649: aload_1
    //   9650: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9653: ifeq +60 -> 9713
    //   9656: new 348	org/json/JSONObject
    //   9659: dup
    //   9660: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   9663: astore_2
    //   9664: aload_2
    //   9665: ldc_w 365
    //   9668: aload_0
    //   9669: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9672: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9675: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9678: getfield 2012	com/tencent/mobileqq/mini/apkg/ApkgInfo:appId	Ljava/lang/String;
    //   9681: invokestatic 2017	com/tencent/mobileqq/mini/report/MiniReportManager:getLaunchPerformance	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9684: invokevirtual 1052	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   9687: pop
    //   9688: aload_0
    //   9689: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9692: aload_3
    //   9693: aload_1
    //   9694: aload_2
    //   9695: iload 4
    //   9697: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9700: goto -8297 -> 1403
    //   9703: astore 20
    //   9705: aload 20
    //   9707: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   9710: goto -22 -> 9688
    //   9713: ldc_w 2019
    //   9716: aload_1
    //   9717: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9720: ifeq +131 -> 9851
    //   9723: new 348	org/json/JSONObject
    //   9726: dup
    //   9727: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   9730: astore_2
    //   9731: aload_0
    //   9732: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9735: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9738: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9741: astore 20
    //   9743: iconst_0
    //   9744: istore 16
    //   9746: iload 16
    //   9748: istore 15
    //   9750: aload 20
    //   9752: ifnull +64 -> 9816
    //   9755: iload 16
    //   9757: istore 15
    //   9759: aload 20
    //   9761: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9764: ifnull +52 -> 9816
    //   9767: iload 16
    //   9769: istore 15
    //   9771: aload 20
    //   9773: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9776: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9779: ifnull +37 -> 9816
    //   9782: iload 16
    //   9784: istore 15
    //   9786: aload 20
    //   9788: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9791: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9794: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9797: ifnull +19 -> 9816
    //   9800: aload 20
    //   9802: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9805: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9808: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9811: getfield 2022	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9814: istore 15
    //   9816: aload_2
    //   9817: ldc_w 2024
    //   9820: iload 15
    //   9822: invokevirtual 1687	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9825: pop
    //   9826: aload_0
    //   9827: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9830: aload_3
    //   9831: aload_1
    //   9832: aload_2
    //   9833: iload 4
    //   9835: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9838: goto -8435 -> 1403
    //   9841: astore 20
    //   9843: aload 20
    //   9845: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   9848: goto -22 -> 9826
    //   9851: ldc_w 2026
    //   9854: aload_1
    //   9855: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9858: ifeq +293 -> 10151
    //   9861: new 348	org/json/JSONObject
    //   9864: dup
    //   9865: aload_2
    //   9866: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9869: ldc_w 1480
    //   9872: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9875: astore_2
    //   9876: aload_0
    //   9877: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9880: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9883: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9886: astore 20
    //   9888: new 348	org/json/JSONObject
    //   9891: dup
    //   9892: invokespecial 1043	org/json/JSONObject:<init>	()V
    //   9895: astore 21
    //   9897: iconst_0
    //   9898: istore 16
    //   9900: iload 16
    //   9902: istore 15
    //   9904: aload 20
    //   9906: ifnull +64 -> 9970
    //   9909: iload 16
    //   9911: istore 15
    //   9913: aload 20
    //   9915: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9918: ifnull +52 -> 9970
    //   9921: iload 16
    //   9923: istore 15
    //   9925: aload 20
    //   9927: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9930: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9933: ifnull +37 -> 9970
    //   9936: iload 16
    //   9938: istore 15
    //   9940: aload 20
    //   9942: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9945: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9948: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9951: ifnull +19 -> 9970
    //   9954: aload 20
    //   9956: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9959: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9962: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9965: getfield 2022	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9968: istore 15
    //   9970: aload 21
    //   9972: ldc_w 2024
    //   9975: iload 15
    //   9977: invokevirtual 1687	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9980: pop
    //   9981: aload 20
    //   9983: ifnull +152 -> 10135
    //   9986: aload 20
    //   9988: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9991: ifnull +144 -> 10135
    //   9994: aload 20
    //   9996: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9999: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10002: ifnull +133 -> 10135
    //   10005: aload 20
    //   10007: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10010: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10013: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10016: ifnull +119 -> 10135
    //   10019: aload_2
    //   10020: ifnull +115 -> 10135
    //   10023: aload_2
    //   10024: aload 20
    //   10026: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10029: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10032: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10035: invokevirtual 1489	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   10038: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10041: ifeq +94 -> 10135
    //   10044: aload 20
    //   10046: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10049: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10052: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10055: getfield 2029	com/tencent/mobileqq/mini/sdk/EntryModel:type	I
    //   10058: iconst_1
    //   10059: if_icmpne +76 -> 10135
    //   10062: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   10065: aconst_null
    //   10066: aload_0
    //   10067: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10070: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   10073: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   10076: aload 20
    //   10078: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10081: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10084: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10087: getfield 2032	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   10090: invokestatic 2035	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   10093: aload 20
    //   10095: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10098: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10101: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10104: getfield 2038	com/tencent/mobileqq/mini/sdk/EntryModel:dwGroupClassExt	J
    //   10107: new 2040	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22
    //   10110: dup
    //   10111: aload_0
    //   10112: aload 21
    //   10114: aload_3
    //   10115: aload_1
    //   10116: iload 4
    //   10118: invokespecial 2041	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10121: invokevirtual 2045	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserGroupInfo	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   10124: goto -8721 -> 1403
    //   10127: astore_1
    //   10128: aload_1
    //   10129: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   10132: goto -8729 -> 1403
    //   10135: aload_0
    //   10136: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10139: aload_3
    //   10140: aload_1
    //   10141: aload 21
    //   10143: iload 4
    //   10145: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   10148: goto -8745 -> 1403
    //   10151: ldc_w 2047
    //   10154: aload_1
    //   10155: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10158: ifeq +193 -> 10351
    //   10161: new 348	org/json/JSONObject
    //   10164: dup
    //   10165: aload_2
    //   10166: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10169: astore 20
    //   10171: aload 20
    //   10173: ldc_w 1480
    //   10176: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10179: astore_2
    //   10180: aload 20
    //   10182: ldc_w 771
    //   10185: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10188: astore 20
    //   10190: aload_0
    //   10191: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10194: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   10197: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   10200: astore 21
    //   10202: aload 21
    //   10204: ifnull -8801 -> 1403
    //   10207: aload 21
    //   10209: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10212: ifnull -8809 -> 1403
    //   10215: aload 21
    //   10217: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10220: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10223: ifnull -8820 -> 1403
    //   10226: aload 21
    //   10228: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10231: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10234: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10237: ifnull -8834 -> 1403
    //   10240: aload_2
    //   10241: ifnull -8838 -> 1403
    //   10244: aload_2
    //   10245: aload 21
    //   10247: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10250: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10253: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10256: invokevirtual 1489	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   10259: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10262: ifeq -8859 -> 1403
    //   10265: aload 21
    //   10267: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10270: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10273: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10276: getfield 2022	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   10279: ifeq -8876 -> 1403
    //   10282: aload 20
    //   10284: ifnull -8881 -> 1403
    //   10287: aload 20
    //   10289: ldc_w 2049
    //   10292: invokevirtual 2051	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10295: ifeq -8892 -> 1403
    //   10298: aload 20
    //   10300: ldc_w 2049
    //   10303: aload 21
    //   10305: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10308: getfield 529	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10311: getfield 1484	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10314: getfield 2032	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   10317: invokestatic 2035	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   10320: invokevirtual 1880	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   10323: astore_2
    //   10324: aload_0
    //   10325: aload_0
    //   10326: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10329: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   10332: aload_2
    //   10333: aload_3
    //   10334: aload_1
    //   10335: iload 4
    //   10337: invokespecial 2053	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startGroupBrowserActivity	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10340: goto -8937 -> 1403
    //   10343: astore_1
    //   10344: aload_1
    //   10345: invokevirtual 1272	org/json/JSONException:printStackTrace	()V
    //   10348: goto -8945 -> 1403
    //   10351: ldc_w 2055
    //   10354: aload_1
    //   10355: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10358: ifne +13 -> 10371
    //   10361: ldc_w 2057
    //   10364: aload_1
    //   10365: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10368: ifeq +18 -> 10386
    //   10371: aload_0
    //   10372: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10375: aload_3
    //   10376: aload_1
    //   10377: aconst_null
    //   10378: iload 4
    //   10380: invokevirtual 690	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   10383: goto -8980 -> 1403
    //   10386: ldc 20
    //   10388: aload_1
    //   10389: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10392: ifeq +72 -> 10464
    //   10395: new 348	org/json/JSONObject
    //   10398: dup
    //   10399: aload_2
    //   10400: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10403: ldc_w 2059
    //   10406: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10409: astore_2
    //   10410: aload_2
    //   10411: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10414: ifne -9011 -> 1403
    //   10417: invokestatic 651	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   10420: aload_0
    //   10421: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10424: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   10427: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   10430: aconst_null
    //   10431: aload_2
    //   10432: new 2061	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23
    //   10435: dup
    //   10436: aload_0
    //   10437: aload_3
    //   10438: aload_1
    //   10439: iload 4
    //   10441: invokespecial 2062	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10444: invokevirtual 2066	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getTcbTicket	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   10447: goto -9044 -> 1403
    //   10450: astore_1
    //   10451: ldc 150
    //   10453: iconst_1
    //   10454: ldc_w 2068
    //   10457: aload_1
    //   10458: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10461: goto -9058 -> 1403
    //   10464: ldc 83
    //   10466: aload_1
    //   10467: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10470: ifeq -9067 -> 1403
    //   10473: aload_0
    //   10474: aload_3
    //   10475: aload_1
    //   10476: iload 4
    //   10478: invokespecial 2070	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:doShareInvite	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)Z
    //   10481: pop
    //   10482: goto -9079 -> 1403
    //   10485: aconst_null
    //   10486: astore_1
    //   10487: goto -3144 -> 7343
    //   10490: aconst_null
    //   10491: astore 20
    //   10493: goto -3885 -> 6608
    //   10496: goto -4250 -> 6246
    //   10499: aconst_null
    //   10500: astore_2
    //   10501: goto -6177 -> 4324
    //   10504: iload 9
    //   10506: istore 14
    //   10508: goto -7028 -> 3480
    //   10511: aload 21
    //   10513: astore_2
    //   10514: goto -7766 -> 2748
    //   10517: iconst_0
    //   10518: istore 16
    //   10520: goto -9969 -> 551
    //   10523: ldc_w 1011
    //   10526: astore 21
    //   10528: goto -10084 -> 444
    //   10531: iconst_m1
    //   10532: istore 8
    //   10534: iconst_m1
    //   10535: istore 7
    //   10537: iconst_m1
    //   10538: istore 11
    //   10540: iconst_0
    //   10541: istore 10
    //   10543: goto -7180 -> 3363
    //   10546: iload 7
    //   10548: istore 8
    //   10550: iload 7
    //   10552: iconst_m1
    //   10553: if_icmpne -6188 -> 4365
    //   10556: iconst_0
    //   10557: istore 8
    //   10559: goto -6194 -> 4365
    //   10562: ldc_w 525
    //   10565: areturn
    //   10566: iload 9
    //   10568: iconst_1
    //   10569: if_icmpne -5949 -> 4620
    //   10572: iconst_1
    //   10573: istore 7
    //   10575: aconst_null
    //   10576: astore_2
    //   10577: goto -6253 -> 4324
    //   10580: iload 9
    //   10582: iconst_3
    //   10583: if_icmpne +11 -> 10594
    //   10586: iconst_3
    //   10587: istore 7
    //   10589: aconst_null
    //   10590: astore_2
    //   10591: goto -6267 -> 4324
    //   10594: iload 9
    //   10596: iconst_4
    //   10597: if_icmpne -5847 -> 4750
    //   10600: iconst_4
    //   10601: istore 7
    //   10603: aconst_null
    //   10604: astore_2
    //   10605: goto -6281 -> 4324
    //   10608: iconst_0
    //   10609: istore 7
    //   10611: goto -6287 -> 4324
    //   10614: iconst_1
    //   10615: istore 16
    //   10617: goto -5377 -> 5240
    //   10620: iconst_0
    //   10621: istore 16
    //   10623: goto -5383 -> 5240
    //   10626: iconst_0
    //   10627: istore 17
    //   10629: goto -5340 -> 5289
    //   10632: bipush 12
    //   10634: istore 4
    //   10636: goto -5300 -> 5336
    //   10639: bipush 12
    //   10641: istore 4
    //   10643: goto -5108 -> 5535
    //   10646: iconst_1
    //   10647: istore 4
    //   10649: goto -4804 -> 5845
    //   10652: iconst_0
    //   10653: istore 4
    //   10655: goto -4810 -> 5845
    //   10658: iconst_0
    //   10659: istore 8
    //   10661: goto -4765 -> 5896
    //   10664: iload 11
    //   10666: iconst_1
    //   10667: iadd
    //   10668: istore 11
    //   10670: goto -4326 -> 6344
    //   10673: iconst_2
    //   10674: istore 7
    //   10676: goto -3847 -> 6829
    //   10679: aconst_null
    //   10680: astore_1
    //   10681: goto -3461 -> 7220
    //   10684: aload 21
    //   10686: astore 20
    //   10688: goto -1885 -> 8803
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10691	0	this	DataJsPlugin
    //   0	10691	1	paramString1	String
    //   0	10691	2	paramString2	String
    //   0	10691	3	paramJsRuntime	JsRuntime
    //   0	10691	4	paramInt	int
    //   218	479	5	d	double
    //   260	10415	7	i	int
    //   256	10404	8	j	int
    //   237	10361	9	k	int
    //   301	10241	10	m	int
    //   318	10351	11	n	int
    //   3217	474	12	i1	int
    //   3214	457	13	i2	int
    //   3478	7029	14	i3	int
    //   211	9765	15	bool1	boolean
    //   549	10073	16	bool2	boolean
    //   5287	5341	17	bool3	boolean
    //   2266	299	18	l	long
    //   338	1786	20	localObject1	Object
    //   2144	3	20	localJSONException1	org.json.JSONException
    //   2365	7244	20	localObject2	Object
    //   9703	3	20	localJSONException2	org.json.JSONException
    //   9741	60	20	localApkgInfo1	ApkgInfo
    //   9841	3	20	localJSONException3	org.json.JSONException
    //   9886	801	20	localObject3	Object
    //   439	10246	21	localObject4	Object
    //   73	9375	22	localObject5	Object
    //   2351	6073	23	localObject6	Object
    //   2361	5736	24	str1	String
    //   2356	5749	25	str2	String
    //   2212	3403	26	str3	String
    //   2329	3251	27	str4	String
    //   2341	203	28	localApkgInfo2	ApkgInfo
    // Exception table:
    //   from	to	target	type
    //   646	881	906	java/lang/Exception
    //   884	903	906	java/lang/Exception
    //   1307	1322	1407	java/lang/Exception
    //   1326	1333	1407	java/lang/Exception
    //   1336	1374	1407	java/lang/Exception
    //   1455	1536	1539	org/json/JSONException
    //   1553	1619	1539	org/json/JSONException
    //   1732	1811	1872	java/lang/Exception
    //   1811	1841	1872	java/lang/Exception
    //   1845	1856	1872	java/lang/Exception
    //   1856	1869	1872	java/lang/Exception
    //   1894	1902	1872	java/lang/Exception
    //   1909	1930	1872	java/lang/Exception
    //   1933	1954	1872	java/lang/Exception
    //   1957	1980	1872	java/lang/Exception
    //   1983	2035	1872	java/lang/Exception
    //   2038	2108	1872	java/lang/Exception
    //   2108	2129	1872	java/lang/Exception
    //   2129	2141	1872	java/lang/Exception
    //   2146	2151	1872	java/lang/Exception
    //   2154	2184	1872	java/lang/Exception
    //   2187	2214	1872	java/lang/Exception
    //   2217	2250	1872	java/lang/Exception
    //   2250	2268	1872	java/lang/Exception
    //   2270	2291	1872	java/lang/Exception
    //   2291	2343	1872	java/lang/Exception
    //   2376	2384	1872	java/lang/Exception
    //   2388	2399	1872	java/lang/Exception
    //   2403	2430	1872	java/lang/Exception
    //   2451	2459	1872	java/lang/Exception
    //   2467	2507	1872	java/lang/Exception
    //   2520	2528	1872	java/lang/Exception
    //   2532	2556	1872	java/lang/Exception
    //   2556	2597	1872	java/lang/Exception
    //   2600	2621	1872	java/lang/Exception
    //   2625	2634	1872	java/lang/Exception
    //   2637	2658	1872	java/lang/Exception
    //   2669	2690	1872	java/lang/Exception
    //   2698	2718	1872	java/lang/Exception
    //   2721	2742	1872	java/lang/Exception
    //   2748	2831	1872	java/lang/Exception
    //   2831	2965	1872	java/lang/Exception
    //   2968	2991	1872	java/lang/Exception
    //   2994	3037	1872	java/lang/Exception
    //   3051	3062	1872	java/lang/Exception
    //   3065	3105	1872	java/lang/Exception
    //   2108	2129	2144	org/json/JSONException
    //   3310	3340	3528	org/json/JSONException
    //   3363	3380	3528	org/json/JSONException
    //   3380	3390	3528	org/json/JSONException
    //   3393	3403	3528	org/json/JSONException
    //   3406	3416	3528	org/json/JSONException
    //   3419	3428	3528	org/json/JSONException
    //   3943	3998	4043	org/json/JSONException
    //   4002	4024	4043	org/json/JSONException
    //   4024	4040	4043	org/json/JSONException
    //   4062	4078	4043	org/json/JSONException
    //   4081	4138	4043	org/json/JSONException
    //   4141	4157	4043	org/json/JSONException
    //   4169	4197	4226	org/json/JSONException
    //   4211	4223	4226	org/json/JSONException
    //   4275	4284	4897	org/json/JSONException
    //   4287	4308	4897	org/json/JSONException
    //   4324	4362	4897	org/json/JSONException
    //   4365	4388	4897	org/json/JSONException
    //   4388	4419	4897	org/json/JSONException
    //   4419	4429	4897	org/json/JSONException
    //   4433	4451	4897	org/json/JSONException
    //   4451	4481	4897	org/json/JSONException
    //   4485	4500	4897	org/json/JSONException
    //   4505	4543	4897	org/json/JSONException
    //   4543	4567	4897	org/json/JSONException
    //   4567	4589	4897	org/json/JSONException
    //   4589	4617	4897	org/json/JSONException
    //   4629	4638	4897	org/json/JSONException
    //   4642	4714	4897	org/json/JSONException
    //   4719	4745	4897	org/json/JSONException
    //   4756	4788	4897	org/json/JSONException
    //   4792	4804	4897	org/json/JSONException
    //   4807	4821	4897	org/json/JSONException
    //   4824	4850	4897	org/json/JSONException
    //   4862	4871	4897	org/json/JSONException
    //   4879	4894	4897	org/json/JSONException
    //   4916	4945	4897	org/json/JSONException
    //   4948	4966	4897	org/json/JSONException
    //   4969	5023	4897	org/json/JSONException
    //   5026	5050	4897	org/json/JSONException
    //   5053	5078	4897	org/json/JSONException
    //   5078	5102	4897	org/json/JSONException
    //   5102	5133	4897	org/json/JSONException
    //   5137	5162	4897	org/json/JSONException
    //   5162	5186	4897	org/json/JSONException
    //   5186	5217	4897	org/json/JSONException
    //   5221	5237	4897	org/json/JSONException
    //   5240	5286	4897	org/json/JSONException
    //   5289	5297	4897	org/json/JSONException
    //   5307	5327	4897	org/json/JSONException
    //   5336	5418	4897	org/json/JSONException
    //   5421	5453	4897	org/json/JSONException
    //   5457	5493	4897	org/json/JSONException
    //   5496	5518	4897	org/json/JSONException
    //   5518	5526	4897	org/json/JSONException
    //   5535	5562	4897	org/json/JSONException
    //   5565	5594	4897	org/json/JSONException
    //   5603	5630	4897	org/json/JSONException
    //   5658	5677	5916	org/json/JSONException
    //   5688	5697	5916	org/json/JSONException
    //   5710	5733	5916	org/json/JSONException
    //   5733	5756	5916	org/json/JSONException
    //   5756	5787	5916	org/json/JSONException
    //   5787	5842	5916	org/json/JSONException
    //   5845	5893	5916	org/json/JSONException
    //   5901	5913	5916	org/json/JSONException
    //   5972	5987	5916	org/json/JSONException
    //   5990	6005	5916	org/json/JSONException
    //   6008	6037	5916	org/json/JSONException
    //   6040	6047	5916	org/json/JSONException
    //   6057	6064	5916	org/json/JSONException
    //   6068	6083	5916	org/json/JSONException
    //   6086	6095	5916	org/json/JSONException
    //   6098	6130	5916	org/json/JSONException
    //   6134	6160	5916	org/json/JSONException
    //   6173	6183	5916	org/json/JSONException
    //   6212	6230	6321	org/json/JSONException
    //   6246	6258	6321	org/json/JSONException
    //   6267	6272	6321	org/json/JSONException
    //   6277	6282	6321	org/json/JSONException
    //   6287	6292	6321	org/json/JSONException
    //   6297	6302	6321	org/json/JSONException
    //   6302	6318	6321	org/json/JSONException
    //   6344	6361	6321	org/json/JSONException
    //   6361	6371	6321	org/json/JSONException
    //   6374	6384	6321	org/json/JSONException
    //   6387	6397	6321	org/json/JSONException
    //   6400	6410	6321	org/json/JSONException
    //   6416	6432	6321	org/json/JSONException
    //   6435	6461	6321	org/json/JSONException
    //   6466	6480	6321	org/json/JSONException
    //   6485	6499	6321	org/json/JSONException
    //   6504	6518	6321	org/json/JSONException
    //   6523	6537	6321	org/json/JSONException
    //   6537	6553	6321	org/json/JSONException
    //   6556	6572	6321	org/json/JSONException
    //   6628	6648	6751	java/lang/Throwable
    //   6652	6667	6751	java/lang/Throwable
    //   6667	6684	6751	java/lang/Throwable
    //   6689	6715	6751	java/lang/Throwable
    //   6720	6748	6751	java/lang/Throwable
    //   6771	6780	6751	java/lang/Throwable
    //   6790	6806	6751	java/lang/Throwable
    //   6810	6826	6751	java/lang/Throwable
    //   6835	6847	6751	java/lang/Throwable
    //   6850	6862	6751	java/lang/Throwable
    //   6865	6877	6751	java/lang/Throwable
    //   6889	7029	7032	org/json/JSONException
    //   7060	7107	7110	org/json/JSONException
    //   7235	7245	7276	org/json/JSONException
    //   7179	7211	7295	org/json/JSONException
    //   7215	7220	7295	org/json/JSONException
    //   7220	7235	7295	org/json/JSONException
    //   7245	7276	7295	org/json/JSONException
    //   7277	7292	7295	org/json/JSONException
    //   7553	7585	7714	org/json/JSONException
    //   7589	7605	7714	org/json/JSONException
    //   7608	7628	7714	org/json/JSONException
    //   7637	7654	7714	org/json/JSONException
    //   7658	7681	7714	org/json/JSONException
    //   7681	7711	7714	org/json/JSONException
    //   7772	7863	8174	org/json/JSONException
    //   7867	7904	8174	org/json/JSONException
    //   7913	7928	8174	org/json/JSONException
    //   7932	7955	8174	org/json/JSONException
    //   7959	7976	8174	org/json/JSONException
    //   7979	8008	8174	org/json/JSONException
    //   8012	8027	8174	org/json/JSONException
    //   8034	8052	8174	org/json/JSONException
    //   8058	8087	8174	org/json/JSONException
    //   8093	8111	8174	org/json/JSONException
    //   8114	8172	8174	org/json/JSONException
    //   8318	8329	8523	org/json/JSONException
    //   8331	8352	8523	org/json/JSONException
    //   8354	8406	8523	org/json/JSONException
    //   8408	8496	8523	org/json/JSONException
    //   8496	8502	8523	org/json/JSONException
    //   8505	8511	8523	org/json/JSONException
    //   8514	8520	8523	org/json/JSONException
    //   8566	8633	9115	java/lang/Throwable
    //   8635	8659	9115	java/lang/Throwable
    //   8664	8698	9115	java/lang/Throwable
    //   8700	8737	9115	java/lang/Throwable
    //   8739	8753	9115	java/lang/Throwable
    //   8753	8763	9115	java/lang/Throwable
    //   8763	8793	9115	java/lang/Throwable
    //   8803	8896	9115	java/lang/Throwable
    //   8899	8907	9115	java/lang/Throwable
    //   8911	8953	9115	java/lang/Throwable
    //   8953	9112	9115	java/lang/Throwable
    //   9131	9163	9115	java/lang/Throwable
    //   9170	9185	9115	java/lang/Throwable
    //   9188	9208	9115	java/lang/Throwable
    //   8753	8763	9130	java/io/UnsupportedEncodingException
    //   9220	9261	9315	java/lang/Throwable
    //   9265	9288	9315	java/lang/Throwable
    //   9288	9312	9315	java/lang/Throwable
    //   9346	9376	9495	java/lang/Throwable
    //   9380	9387	9495	java/lang/Throwable
    //   9390	9453	9495	java/lang/Throwable
    //   9462	9492	9495	java/lang/Throwable
    //   9534	9558	9628	java/lang/Throwable
    //   9562	9569	9628	java/lang/Throwable
    //   9572	9596	9628	java/lang/Throwable
    //   9605	9625	9628	java/lang/Throwable
    //   9664	9688	9703	org/json/JSONException
    //   9731	9743	9841	org/json/JSONException
    //   9759	9767	9841	org/json/JSONException
    //   9771	9782	9841	org/json/JSONException
    //   9786	9816	9841	org/json/JSONException
    //   9816	9826	9841	org/json/JSONException
    //   9861	9897	10127	org/json/JSONException
    //   9913	9921	10127	org/json/JSONException
    //   9925	9936	10127	org/json/JSONException
    //   9940	9970	10127	org/json/JSONException
    //   9970	9981	10127	org/json/JSONException
    //   9986	10019	10127	org/json/JSONException
    //   10023	10124	10127	org/json/JSONException
    //   10135	10148	10127	org/json/JSONException
    //   10161	10202	10343	org/json/JSONException
    //   10207	10240	10343	org/json/JSONException
    //   10244	10282	10343	org/json/JSONException
    //   10287	10340	10343	org/json/JSONException
    //   10395	10447	10450	java/lang/Throwable
  }
  
  public void login(adea paramadea)
  {
    if (paramadea == null) {
      return;
    }
    ThreadManager.excute(new DataJsPlugin.27(this, paramadea), 16, null, false);
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