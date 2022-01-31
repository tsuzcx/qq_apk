package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import aasd;
import abwu;
import abwx;
import abxc;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
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
import wxe;

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
  public static final String API_SHOW_SHARE_MENU = "showShareMenu";
  public static final String API_SHOW_SHARE_MENU_WITH_SHARE_TICKET = "showShareMenuWithShareTicket";
  public static final String API_UPDATE_SHARE_MENU = "updateShareMenuShareTicket";
  public static final String API_VERIFY_PLUGIN = "verifyPlugin";
  private static final String CONFIG_SPLIT = ",";
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
  private abwx apiManager;
  private Long lastNotRspReqTime = Long.valueOf(0L);
  private List<abwu> loginCallBacks = new LinkedList();
  protected GdtAppReceiver mGgtAppReceiver;
  private ArrayList<String> openUrlDomainWhiteList;
  private String privateOpenUrlDomainWhiteList;
  
  private void downloadImageByURLDrawable(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramURLDrawableListener != null)
    {
      if (paramString.getStatus() != 1) {
        break label44;
      }
      wxe.b("[mini] DataJsPlugin", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label44:
      wxe.b("[mini] DataJsPlugin", "start load URLDrawable.");
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
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aasd.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
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
  
  private void initApiManager(int paramInt, String paramString)
  {
    abxc.a();
    this.apiManager = abxc.a(this.jsPluginEngine.getActivityContext(), paramInt, paramString);
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
    localObject = new Handler(((HandlerThread)localObject).getLooper(), new DataJsPlugin.24(this, paramJsRuntime, paramString2, paramInt2));
    ((Handler)localObject).sendEmptyMessageDelayed(1, paramInt1);
    MiniAppCmdUtil.getInstance().getGroupShareInfo(this.jsPluginEngine.appBrandRuntime.appId, paramString1, null, new DataJsPlugin.25(this, paramJsRuntime, paramString2, paramInt2, (Handler)localObject));
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
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramStGetAdReq, new DataJsPlugin.28(this, paramJsRuntime, paramString, paramInt1, paramInt2));
  }
  
  private void startGroupBrowserActivity(Activity paramActivity, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    paramString1 = new Bundle();
    paramString1.putBoolean("hide_more_button", true);
    localIntent.putExtras(paramString1);
    MiniAppController.getInstance().setActivityResultListener(new DataJsPlugin.29(this, paramJsRuntime, paramString2, paramInt));
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
      ShareUtils.startSharePicToQzone(this.jsPluginEngine.getActivityContext(), paramString2, this.jsPluginEngine.appBrandRuntime.getApkgInfo());
      return;
    case 3: 
      ShareUtils.startSharePicToWeChat(this.jsPluginEngine.getActivityContext(), ShareUtils.getFileUri(this.jsPluginEngine.getActivityContext(), paramString2), true);
      return;
    }
    ShareUtils.startSharePicToWeChat(this.jsPluginEngine.getActivityContext(), ShareUtils.getFileUri(this.jsPluginEngine.getActivityContext(), paramString2), false);
  }
  
  private void startShareNetworkPicMessage(Context paramContext, String paramString1, String paramString2, int paramInt, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    ThreadManager.getUIHandler().post(new DataJsPlugin.30(this, paramContext, paramString2, paramString1, paramInt));
  }
  
  public void getUserInfo(JsRuntime paramJsRuntime, String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    String str = this.jsPluginEngine.appBrandRuntime.appId;
    QLog.d("[mini] DataJsPlugin", 1, "getUserInfo appID:" + str);
    MiniAppCmdUtil.getInstance().getUserInfo(str, paramBoolean, paramString3, new DataJsPlugin.27(this, paramString2, paramJsRuntime, paramString1, paramInt));
  }
  
  /* Error */
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 618	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc 139
    //   8: iconst_2
    //   9: new 321	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 620
    //   19: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 622
    //   29: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 624
    //   39: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 600	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_3
    //   54: ifnonnull +18 -> 72
    //   57: ldc 139
    //   59: iconst_4
    //   60: ldc_w 626
    //   63: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: ldc_w 631
    //   69: astore_2
    //   70: aload_2
    //   71: areturn
    //   72: aconst_null
    //   73: astore 22
    //   75: aload_0
    //   76: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   79: ifnull +12 -> 91
    //   82: aload_0
    //   83: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   86: invokevirtual 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   89: astore 22
    //   91: aload 22
    //   93: ifnull +26 -> 119
    //   96: new 321	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   103: aload_1
    //   104: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 22
    //   109: invokevirtual 636	java/lang/Object:hashCode	()I
    //   112: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: pop
    //   119: ldc 35
    //   121: aload_1
    //   122: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +12 -> 137
    //   128: ldc 38
    //   130: aload_1
    //   131: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +1111 -> 1245
    //   137: aload 22
    //   139: ifnull +1074 -> 1213
    //   142: getstatic 641	android/os/Build$VERSION:SDK_INT	I
    //   145: bipush 17
    //   147: if_icmplt +806 -> 953
    //   150: new 643	android/util/DisplayMetrics
    //   153: dup
    //   154: invokespecial 644	android/util/DisplayMetrics:<init>	()V
    //   157: astore_2
    //   158: aload 22
    //   160: ldc_w 646
    //   163: invokevirtual 650	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   166: checkcast 652	android/view/WindowManager
    //   169: invokeinterface 656 1 0
    //   174: aload_2
    //   175: invokevirtual 662	android/view/Display:getRealMetrics	(Landroid/util/DisplayMetrics;)V
    //   178: aload 22
    //   180: invokestatic 668	com/tencent/mobileqq/mini/util/DisplayUtil:hasNavBar	(Landroid/content/Context;)Z
    //   183: ifeq +11 -> 194
    //   186: aload 22
    //   188: invokestatic 672	com/tencent/mobileqq/mini/util/DisplayUtil:isNavigationBarExist	(Landroid/app/Activity;)Z
    //   191: ifne +9 -> 200
    //   194: invokestatic 675	com/tencent/mobileqq/mini/util/DisplayUtil:isFlymeOS7NavBarShow	()Z
    //   197: ifeq +768 -> 965
    //   200: iconst_1
    //   201: istore 16
    //   203: aload_2
    //   204: getfield 679	android/util/DisplayMetrics:density	F
    //   207: f2d
    //   208: dstore 5
    //   210: aload_2
    //   211: getfield 682	android/util/DisplayMetrics:widthPixels	I
    //   214: i2d
    //   215: dload 5
    //   217: ddiv
    //   218: invokestatic 688	java/lang/Math:round	(D)J
    //   221: l2f
    //   222: ldc_w 689
    //   225: fadd
    //   226: f2i
    //   227: istore 9
    //   229: aload_2
    //   230: getfield 692	android/util/DisplayMetrics:heightPixels	I
    //   233: i2d
    //   234: dload 5
    //   236: ddiv
    //   237: invokestatic 688	java/lang/Math:round	(D)J
    //   240: l2f
    //   241: ldc_w 689
    //   244: fadd
    //   245: f2i
    //   246: istore 8
    //   248: iload 8
    //   250: istore 7
    //   252: iload 16
    //   254: ifeq +23 -> 277
    //   257: iload 8
    //   259: aload_0
    //   260: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   263: invokevirtual 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   266: invokestatic 696	com/tencent/mobileqq/mini/util/DisplayUtil:getNavigationBarHeight	(Landroid/content/Context;)I
    //   269: i2d
    //   270: dload 5
    //   272: ddiv
    //   273: d2i
    //   274: isub
    //   275: istore 7
    //   277: aload 22
    //   279: invokestatic 701	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   282: i2f
    //   283: invokestatic 704	java/lang/Math:round	(F)I
    //   286: i2d
    //   287: dload 5
    //   289: ddiv
    //   290: d2i
    //   291: istore 10
    //   293: ldc_w 705
    //   296: invokestatic 709	bdoo:b	(F)I
    //   299: i2d
    //   300: dload 5
    //   302: ddiv
    //   303: ldc2_w 710
    //   306: dadd
    //   307: d2i
    //   308: istore 11
    //   310: ldc_w 712
    //   313: invokestatic 709	bdoo:b	(F)I
    //   316: i2d
    //   317: dload 5
    //   319: ddiv
    //   320: ldc2_w 710
    //   323: dadd
    //   324: d2i
    //   325: istore 8
    //   327: aconst_null
    //   328: astore 20
    //   330: aload_0
    //   331: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   334: ifnull +637 -> 971
    //   337: aload_0
    //   338: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   341: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   344: ifnull +627 -> 971
    //   347: aload_0
    //   348: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   351: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   354: invokevirtual 716	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   357: ifnull +614 -> 971
    //   360: aload_0
    //   361: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   364: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   367: invokevirtual 716	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   370: invokevirtual 721	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   373: ifnull +598 -> 971
    //   376: aload_0
    //   377: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   380: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   383: invokevirtual 716	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   386: invokevirtual 721	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   389: astore 20
    //   391: aload 20
    //   393: astore_2
    //   394: aload 20
    //   396: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   399: ifne +9815 -> 10214
    //   402: aload_0
    //   403: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   406: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   409: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   412: invokevirtual 727	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   415: aload 20
    //   417: invokevirtual 733	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   420: getfield 739	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   423: getfield 745	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   426: getfield 750	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   429: astore 21
    //   431: aload 20
    //   433: astore_2
    //   434: aload_0
    //   435: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   438: ifnull +9770 -> 10208
    //   441: aload_0
    //   442: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   445: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   448: ifnull +9760 -> 10208
    //   451: aload_0
    //   452: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   455: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   458: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   461: ifnull +9747 -> 10208
    //   464: aload_0
    //   465: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   468: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   471: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   474: invokevirtual 727	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   477: ifnull +9731 -> 10208
    //   480: aload_0
    //   481: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   484: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   487: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   490: invokevirtual 727	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   493: getfield 754	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   496: ifnull +684 -> 1180
    //   499: aload_0
    //   500: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   503: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   506: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   509: aload_2
    //   510: invokevirtual 757	com/tencent/mobileqq/mini/apkg/ApkgInfo:isTabBarPage	(Ljava/lang/String;)Z
    //   513: ifeq +667 -> 1180
    //   516: aload_0
    //   517: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   520: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   523: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   526: invokevirtual 727	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   529: getfield 754	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   532: invokevirtual 762	com/tencent/mobileqq/mini/apkg/TabBarInfo:isShow	()Z
    //   535: ifeq +645 -> 1180
    //   538: iconst_1
    //   539: istore 15
    //   541: ldc_w 764
    //   544: aload 21
    //   546: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   549: ifeq +643 -> 1192
    //   552: iload 15
    //   554: ifeq +632 -> 1186
    //   557: iload 7
    //   559: iload 10
    //   561: isub
    //   562: iload 11
    //   564: isub
    //   565: iload 8
    //   567: isub
    //   568: istore 8
    //   570: invokestatic 767	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   573: ifeq +63 -> 636
    //   576: ldc 139
    //   578: iconst_1
    //   579: new 321	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 769
    //   589: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: iload 8
    //   594: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   597: ldc_w 771
    //   600: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload 21
    //   605: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: ldc_w 773
    //   611: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: iload 15
    //   616: invokevirtual 776	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   619: ldc_w 778
    //   622: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: iload 16
    //   627: invokevirtual 776	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   630: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: invokestatic 784	com/tencent/mobileqq/mini/app/AppLoaderFactory:getAppLoaderManager	()Lcom/tencent/mobileqq/mini/app/BaseAppLoaderManager;
    //   639: invokeinterface 790 1 0
    //   644: getfield 795	com/tencent/mobileqq/mini/sdk/BaseLibInfo:baseLibVersion	Ljava/lang/String;
    //   647: astore_2
    //   648: new 271	org/json/JSONObject
    //   651: dup
    //   652: invokespecial 796	org/json/JSONObject:<init>	()V
    //   655: astore 20
    //   657: aload 20
    //   659: ldc_w 798
    //   662: getstatic 803	android/os/Build:BRAND	Ljava/lang/String;
    //   665: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   668: pop
    //   669: aload 20
    //   671: ldc_w 809
    //   674: getstatic 812	android/os/Build:MODEL	Ljava/lang/String;
    //   677: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   680: pop
    //   681: aload 20
    //   683: ldc_w 814
    //   686: dload 5
    //   688: invokevirtual 817	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   691: pop
    //   692: aload 20
    //   694: ldc_w 819
    //   697: iload 9
    //   699: invokevirtual 822	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   702: pop
    //   703: aload 20
    //   705: ldc_w 824
    //   708: iload 7
    //   710: invokevirtual 822	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 20
    //   716: ldc_w 826
    //   719: iload 9
    //   721: invokevirtual 822	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   724: pop
    //   725: aload 20
    //   727: ldc_w 828
    //   730: iload 8
    //   732: invokevirtual 822	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   735: pop
    //   736: aload 20
    //   738: ldc_w 830
    //   741: iload 10
    //   743: invokevirtual 822	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   746: pop
    //   747: aload 20
    //   749: ldc_w 832
    //   752: ldc_w 834
    //   755: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   758: pop
    //   759: aload 20
    //   761: ldc_w 836
    //   764: invokestatic 841	bdgk:c	()Ljava/lang/String;
    //   767: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   770: pop
    //   771: aload 20
    //   773: ldc_w 843
    //   776: new 321	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   783: ldc_w 845
    //   786: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: getstatic 848	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   792: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   801: pop
    //   802: aload 20
    //   804: ldc_w 850
    //   807: ldc_w 852
    //   810: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   813: pop
    //   814: aload 20
    //   816: ldc_w 854
    //   819: bipush 16
    //   821: invokevirtual 822	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   824: pop
    //   825: aload 20
    //   827: ldc_w 856
    //   830: aload_2
    //   831: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   834: pop
    //   835: aload 20
    //   837: ldc_w 858
    //   840: ldc 112
    //   842: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   845: pop
    //   846: aload 20
    //   848: ldc_w 860
    //   851: aload 22
    //   853: invokestatic 864	com/tencent/mobileqq/mini/util/DisplayUtil:getDisplayCutoutSafeArea	(Landroid/app/Activity;)Lorg/json/JSONObject;
    //   856: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   859: pop
    //   860: aload_1
    //   861: aload 20
    //   863: invokestatic 870	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   866: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   869: astore 20
    //   871: aload 20
    //   873: astore_2
    //   874: ldc 35
    //   876: aload_1
    //   877: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   880: ifeq -810 -> 70
    //   883: aload_3
    //   884: iload 4
    //   886: aload 20
    //   888: invokeinterface 876 3 0
    //   893: aload 20
    //   895: areturn
    //   896: astore_2
    //   897: ldc 139
    //   899: iconst_1
    //   900: new 321	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   907: ldc_w 878
    //   910: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: new 341	java/lang/Throwable
    //   916: dup
    //   917: aload_2
    //   918: invokespecial 881	java/lang/Throwable:<init>	(Ljava/lang/Throwable;)V
    //   921: invokevirtual 884	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   924: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: aload_1
    //   931: aconst_null
    //   932: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   935: astore_1
    //   936: aload_3
    //   937: iload 4
    //   939: aload_1
    //   940: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   943: invokeinterface 876 3 0
    //   948: aload_1
    //   949: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   952: areturn
    //   953: aload 22
    //   955: invokevirtual 891	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   958: invokevirtual 897	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   961: astore_2
    //   962: goto -784 -> 178
    //   965: iconst_0
    //   966: istore 16
    //   968: goto -765 -> 203
    //   971: aload 20
    //   973: astore_2
    //   974: aload_0
    //   975: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   978: ifnull +9236 -> 10214
    //   981: aload 20
    //   983: astore_2
    //   984: aload_0
    //   985: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   988: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   991: ifnull +9223 -> 10214
    //   994: aload 20
    //   996: astore_2
    //   997: aload_0
    //   998: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1001: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1004: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1007: ifnull +9207 -> 10214
    //   1010: aconst_null
    //   1011: astore 20
    //   1013: aload 20
    //   1015: astore_2
    //   1016: aload_0
    //   1017: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1020: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1023: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1026: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1029: ifnull +45 -> 1074
    //   1032: aload 20
    //   1034: astore_2
    //   1035: aload_0
    //   1036: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1039: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1042: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1045: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1048: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1051: ifnull +23 -> 1074
    //   1054: aload_0
    //   1055: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1058: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1061: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1064: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1067: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1070: getfield 912	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   1073: astore_2
    //   1074: aconst_null
    //   1075: astore 20
    //   1077: aload_0
    //   1078: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1081: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1084: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1087: getfield 916	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1090: ifnull +21 -> 1111
    //   1093: aload_0
    //   1094: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1097: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1100: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1103: getfield 916	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1106: getfield 919	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   1109: astore 20
    //   1111: aload_0
    //   1112: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1115: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1118: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1121: aload_2
    //   1122: invokevirtual 922	com/tencent/mobileqq/mini/apkg/ApkgInfo:isUrlFileExist	(Ljava/lang/String;)Z
    //   1125: ifne +49 -> 1174
    //   1128: aload 20
    //   1130: astore_2
    //   1131: aload 20
    //   1133: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1136: ifne +9078 -> 10214
    //   1139: aload_0
    //   1140: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1143: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1146: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1149: invokevirtual 727	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1152: aload 20
    //   1154: invokevirtual 733	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   1157: getfield 739	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   1160: getfield 745	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   1163: getfield 750	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   1166: astore 21
    //   1168: aload 20
    //   1170: astore_2
    //   1171: goto -737 -> 434
    //   1174: aload_2
    //   1175: astore 20
    //   1177: goto -49 -> 1128
    //   1180: iconst_0
    //   1181: istore 15
    //   1183: goto -642 -> 541
    //   1186: iconst_0
    //   1187: istore 8
    //   1189: goto -632 -> 557
    //   1192: iload 15
    //   1194: ifeq +13 -> 1207
    //   1197: iload 7
    //   1199: iload 8
    //   1201: isub
    //   1202: istore 8
    //   1204: goto -634 -> 570
    //   1207: iconst_0
    //   1208: istore 8
    //   1210: goto -13 -> 1197
    //   1213: ldc 139
    //   1215: iconst_1
    //   1216: ldc_w 924
    //   1219: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1222: aload_1
    //   1223: aconst_null
    //   1224: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1227: astore_1
    //   1228: aload_3
    //   1229: iload 4
    //   1231: aload_1
    //   1232: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1235: invokeinterface 876 3 0
    //   1240: aload_1
    //   1241: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1244: areturn
    //   1245: ldc_w 926
    //   1248: aload_1
    //   1249: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1252: ifeq +135 -> 1387
    //   1255: iconst_0
    //   1256: istore 8
    //   1258: iload 8
    //   1260: istore 7
    //   1262: aload_2
    //   1263: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1266: ifne +70 -> 1336
    //   1269: new 271	org/json/JSONObject
    //   1272: dup
    //   1273: aload_2
    //   1274: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1277: ldc_w 928
    //   1280: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1283: astore_1
    //   1284: iload 8
    //   1286: istore 7
    //   1288: aload_1
    //   1289: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1292: ifne +44 -> 1336
    //   1295: iconst_1
    //   1296: istore 7
    //   1298: aload 22
    //   1300: new 512	android/content/Intent
    //   1303: dup
    //   1304: ldc_w 933
    //   1307: new 321	java/lang/StringBuilder
    //   1310: dup
    //   1311: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   1314: ldc_w 935
    //   1317: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: aload_1
    //   1321: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: invokestatic 941	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1330: invokespecial 944	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1333: invokevirtual 948	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1336: iload 7
    //   1338: ifeq +38 -> 1376
    //   1341: ldc_w 926
    //   1344: aconst_null
    //   1345: invokestatic 870	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1348: astore_1
    //   1349: aload_1
    //   1350: ifnull +15 -> 1365
    //   1353: aload_3
    //   1354: iload 4
    //   1356: aload_1
    //   1357: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1360: invokeinterface 876 3 0
    //   1365: ldc_w 631
    //   1368: areturn
    //   1369: astore_1
    //   1370: iconst_0
    //   1371: istore 7
    //   1373: goto -37 -> 1336
    //   1376: ldc_w 926
    //   1379: aconst_null
    //   1380: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1383: astore_1
    //   1384: goto -35 -> 1349
    //   1387: ldc_w 950
    //   1390: aload_1
    //   1391: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1394: ifeq +202 -> 1596
    //   1397: ldc 139
    //   1399: iconst_2
    //   1400: iconst_2
    //   1401: anewarray 633	java/lang/Object
    //   1404: dup
    //   1405: iconst_0
    //   1406: ldc_w 951
    //   1409: aastore
    //   1410: dup
    //   1411: iconst_1
    //   1412: aload_2
    //   1413: aastore
    //   1414: invokestatic 954	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1417: new 271	org/json/JSONObject
    //   1420: dup
    //   1421: aload_2
    //   1422: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1425: ldc_w 956
    //   1428: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1431: astore 20
    //   1433: aload 20
    //   1435: ldc_w 962
    //   1438: ldc_w 631
    //   1441: invokevirtual 965	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1444: astore 21
    //   1446: aload 20
    //   1448: ldc_w 967
    //   1451: iconst_1
    //   1452: invokevirtual 971	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1455: pop
    //   1456: ldc_w 973
    //   1459: aload 21
    //   1461: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1464: ifeq -99 -> 1365
    //   1467: invokestatic 399	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1470: invokevirtual 977	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1473: astore 20
    //   1475: aload 20
    //   1477: instanceof 979
    //   1480: ifeq +101 -> 1581
    //   1483: aload 20
    //   1485: checkcast 979	com/tencent/mobileqq/mini/MiniAppInterface
    //   1488: aload_0
    //   1489: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1492: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1495: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1498: invokevirtual 983	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   1501: astore 20
    //   1503: aload 20
    //   1505: ifnull +61 -> 1566
    //   1508: aload 20
    //   1510: aload_1
    //   1511: aload_2
    //   1512: invokevirtual 989	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlag	(Ljava/lang/String;Ljava/lang/String;)I
    //   1515: iconst_2
    //   1516: if_icmpne +50 -> 1566
    //   1519: new 991	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2
    //   1522: dup
    //   1523: aload_0
    //   1524: aload_3
    //   1525: aload_1
    //   1526: iload 4
    //   1528: invokespecial 992	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1531: astore_1
    //   1532: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1535: aload_0
    //   1536: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1539: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1542: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1545: aload_1
    //   1546: invokevirtual 995	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getPhoneNumber	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1549: goto -184 -> 1365
    //   1552: astore_1
    //   1553: ldc 139
    //   1555: iconst_2
    //   1556: ldc_w 951
    //   1559: aload_1
    //   1560: invokestatic 997	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1563: goto -198 -> 1365
    //   1566: aload_0
    //   1567: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1570: aload_3
    //   1571: aload_1
    //   1572: aconst_null
    //   1573: iload 4
    //   1575: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   1578: goto -213 -> 1365
    //   1581: aload_0
    //   1582: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1585: aload_3
    //   1586: aload_1
    //   1587: aconst_null
    //   1588: iload 4
    //   1590: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   1593: goto -228 -> 1365
    //   1596: ldc 50
    //   1598: aload_1
    //   1599: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1602: ifeq +86 -> 1688
    //   1605: ldc 139
    //   1607: iconst_2
    //   1608: new 321	java/lang/StringBuilder
    //   1611: dup
    //   1612: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   1615: ldc_w 1002
    //   1618: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1621: iload 4
    //   1623: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1626: ldc_w 1004
    //   1629: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: aload_0
    //   1633: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1636: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1639: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1642: getfield 916	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1645: getfield 1007	com/tencent/mobileqq/mini/apkg/AppConfigInfo:PackageToolVersion	Ljava/lang/String;
    //   1648: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1654: invokestatic 600	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1657: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1660: aload_0
    //   1661: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1664: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1667: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1670: new 1009	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3
    //   1673: dup
    //   1674: aload_0
    //   1675: aload_3
    //   1676: aload_1
    //   1677: iload 4
    //   1679: invokespecial 1010	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1682: invokevirtual 1013	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getLoginCode	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1685: goto -320 -> 1365
    //   1688: ldc_w 1015
    //   1691: aload_1
    //   1692: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1695: ifeq +1131 -> 2826
    //   1698: new 271	org/json/JSONObject
    //   1701: dup
    //   1702: invokespecial 796	org/json/JSONObject:<init>	()V
    //   1705: pop
    //   1706: new 271	org/json/JSONObject
    //   1709: dup
    //   1710: aload_2
    //   1711: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1714: astore 20
    //   1716: aload 20
    //   1718: ldc_w 956
    //   1721: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1724: astore 22
    //   1726: aload 22
    //   1728: ldc_w 962
    //   1731: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1734: astore 21
    //   1736: ldc_w 1017
    //   1739: aload 21
    //   1741: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1744: ifne +14 -> 1758
    //   1747: ldc_w 1019
    //   1750: aload 21
    //   1752: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1755: ifeq +101 -> 1856
    //   1758: aload 22
    //   1760: ldc_w 967
    //   1763: invokevirtual 1021	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1766: istore 15
    //   1768: aload 22
    //   1770: ldc_w 1023
    //   1773: aconst_null
    //   1774: invokevirtual 965	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1777: astore 20
    //   1779: aload 22
    //   1781: ldc_w 956
    //   1784: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1787: astore_2
    //   1788: aload_2
    //   1789: ifnull +49 -> 1838
    //   1792: aload_2
    //   1793: ldc_w 1023
    //   1796: ldc_w 1025
    //   1799: invokevirtual 965	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1802: astore_2
    //   1803: aload_0
    //   1804: aload_3
    //   1805: aload_1
    //   1806: aload 21
    //   1808: iload 4
    //   1810: iload 15
    //   1812: aload_2
    //   1813: invokevirtual 1027	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getUserInfo	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V
    //   1816: goto -451 -> 1365
    //   1819: astore_1
    //   1820: ldc 139
    //   1822: iconst_1
    //   1823: aload_1
    //   1824: iconst_0
    //   1825: anewarray 633	java/lang/Object
    //   1828: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1831: aload_1
    //   1832: invokevirtual 1031	java/lang/Exception:printStackTrace	()V
    //   1835: goto -470 -> 1365
    //   1838: aload 20
    //   1840: astore_2
    //   1841: aload 20
    //   1843: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1846: ifeq -43 -> 1803
    //   1849: ldc_w 1025
    //   1852: astore_2
    //   1853: goto -50 -> 1803
    //   1856: ldc_w 1033
    //   1859: aload 21
    //   1861: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1864: ifeq +47 -> 1911
    //   1867: new 1035	Wallet/IsUinFocusMpIdReq
    //   1870: dup
    //   1871: invokestatic 399	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1874: invokevirtual 977	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1877: invokevirtual 1040	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   1880: aload_0
    //   1881: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1884: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1887: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1890: invokespecial 1042	Wallet/IsUinFocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1893: new 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4
    //   1896: dup
    //   1897: aload_0
    //   1898: aload_3
    //   1899: aload_1
    //   1900: iload 4
    //   1902: invokespecial 1045	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1905: invokestatic 1050	aivh:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   1908: goto -543 -> 1365
    //   1911: ldc_w 1052
    //   1914: aload 21
    //   1916: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1919: ifeq +141 -> 2060
    //   1922: aload 20
    //   1924: ldc_w 1054
    //   1927: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1930: ldc_w 1056
    //   1933: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1936: astore_2
    //   1937: ldc 98
    //   1939: aload_0
    //   1940: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1943: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1946: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1949: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1952: ifeq +75 -> 2027
    //   1955: ldc 139
    //   1957: iconst_1
    //   1958: ldc_w 1058
    //   1961: invokestatic 600	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1964: new 271	org/json/JSONObject
    //   1967: dup
    //   1968: invokespecial 796	org/json/JSONObject:<init>	()V
    //   1971: astore_2
    //   1972: new 271	org/json/JSONObject
    //   1975: dup
    //   1976: invokespecial 796	org/json/JSONObject:<init>	()V
    //   1979: astore 20
    //   1981: aload 20
    //   1983: ldc_w 956
    //   1986: ldc 145
    //   1988: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1991: pop
    //   1992: aload_2
    //   1993: ldc_w 1060
    //   1996: aload 20
    //   1998: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2001: pop
    //   2002: aload_0
    //   2003: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2006: aload_3
    //   2007: aload_1
    //   2008: aload_2
    //   2009: iload 4
    //   2011: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2014: goto -649 -> 1365
    //   2017: astore 20
    //   2019: aload 20
    //   2021: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   2024: goto -22 -> 2002
    //   2027: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2030: aload_0
    //   2031: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2034: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2037: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2040: aload_2
    //   2041: aconst_null
    //   2042: new 1066	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5
    //   2045: dup
    //   2046: aload_0
    //   2047: aload_3
    //   2048: aload_1
    //   2049: iload 4
    //   2051: invokespecial 1067	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2054: invokevirtual 1070	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkNavigateRight	(Ljava/lang/String;Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2057: goto -692 -> 1365
    //   2060: ldc_w 1072
    //   2063: aload 21
    //   2065: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2068: ifeq +404 -> 2472
    //   2071: aload 22
    //   2073: ldc_w 956
    //   2076: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2079: ldc_w 1074
    //   2082: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2085: astore 26
    //   2087: iconst_2
    //   2088: istore 7
    //   2090: aload 22
    //   2092: ldc_w 956
    //   2095: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2098: ldc_w 1076
    //   2101: invokevirtual 483	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2104: ifeq +19 -> 2123
    //   2107: aload 22
    //   2109: ldc_w 956
    //   2112: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2115: ldc_w 1076
    //   2118: invokevirtual 1080	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2121: istore 7
    //   2123: aload_0
    //   2124: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2127: getfield 1084	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2130: invokevirtual 1089	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   2133: invokestatic 1092	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   2136: invokevirtual 1096	java/lang/Long:longValue	()J
    //   2139: lstore 18
    //   2141: aconst_null
    //   2142: astore_2
    //   2143: aload_0
    //   2144: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2147: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2150: ifnull +14 -> 2164
    //   2153: aload_0
    //   2154: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2157: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2160: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2163: astore_2
    //   2164: ldc 139
    //   2166: iconst_2
    //   2167: new 321	java/lang/StringBuilder
    //   2170: dup
    //   2171: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   2174: ldc_w 1098
    //   2177: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2180: aload_2
    //   2181: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2184: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2187: invokestatic 600	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2190: aload_2
    //   2191: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2194: ifne -829 -> 1365
    //   2197: iload 7
    //   2199: invokestatic 1102	com/tencent/mobileqq/mini/util/AdUtils:getSpAdGdtCookie	(I)Ljava/lang/String;
    //   2202: astore 27
    //   2204: aload_0
    //   2205: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2208: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2211: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   2214: astore 28
    //   2216: ldc_w 631
    //   2219: astore 21
    //   2221: ldc_w 631
    //   2224: astore 23
    //   2226: ldc_w 631
    //   2229: astore 25
    //   2231: ldc_w 631
    //   2234: astore 24
    //   2236: aload 21
    //   2238: astore 20
    //   2240: aload 28
    //   2242: ifnull +61 -> 2303
    //   2245: aload 21
    //   2247: astore 20
    //   2249: aload 28
    //   2251: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2254: ifnull +49 -> 2303
    //   2257: aload 21
    //   2259: astore 20
    //   2261: aload 28
    //   2263: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2266: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2269: ifnull +34 -> 2303
    //   2272: aload 21
    //   2274: astore 20
    //   2276: aload 28
    //   2278: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2281: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2284: getfield 912	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2287: ifnull +16 -> 2303
    //   2290: aload 28
    //   2292: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2295: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2298: getfield 912	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2301: astore 20
    //   2303: aload 23
    //   2305: astore 22
    //   2307: aload 25
    //   2309: astore 21
    //   2311: aload 28
    //   2313: ifnull +67 -> 2380
    //   2316: aload 23
    //   2318: astore 22
    //   2320: aload 25
    //   2322: astore 21
    //   2324: aload 28
    //   2326: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2329: ifnull +51 -> 2380
    //   2332: aload 23
    //   2334: astore 22
    //   2336: aload 25
    //   2338: astore 21
    //   2340: aload 28
    //   2342: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2345: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2348: ifnull +32 -> 2380
    //   2351: aload 28
    //   2353: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2356: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2359: getfield 1105	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/lang/String;
    //   2362: astore 22
    //   2364: aload 28
    //   2366: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2369: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2372: getfield 1108	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   2375: invokestatic 1110	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2378: astore 21
    //   2380: aload 24
    //   2382: astore 23
    //   2384: aload 28
    //   2386: ifnull +43 -> 2429
    //   2389: aload 24
    //   2391: astore 23
    //   2393: aload 28
    //   2395: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2398: ifnull +31 -> 2429
    //   2401: aload 24
    //   2403: astore 23
    //   2405: aload 28
    //   2407: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2410: getfield 1114	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2413: ifnull +16 -> 2429
    //   2416: aload 28
    //   2418: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2421: getfield 1114	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2424: getfield 1119	com/tencent/mobileqq/mini/apkg/MiniAppInfo:via	Ljava/lang/String;
    //   2427: astore 23
    //   2429: aload_0
    //   2430: aload_0
    //   2431: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2434: getfield 1084	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2437: lload 18
    //   2439: aload 26
    //   2441: aload_2
    //   2442: bipush 53
    //   2444: iload 7
    //   2446: iconst_0
    //   2447: aload 27
    //   2449: aload 20
    //   2451: aload 22
    //   2453: aload 21
    //   2455: aload 23
    //   2457: invokestatic 1123	com/tencent/mobileqq/mini/util/AdUtils:createAdRequest	(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)LNS_MINI_AD/MiniAppAd$StGetAdReq;
    //   2460: aload_3
    //   2461: aload_1
    //   2462: iload 4
    //   2464: iload 7
    //   2466: invokespecial 1125	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:sendAdRequest	(LNS_MINI_AD/MiniAppAd$StGetAdReq;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;II)V
    //   2469: goto -1104 -> 1365
    //   2472: ldc_w 1127
    //   2475: aload 21
    //   2477: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2480: ifeq +232 -> 2712
    //   2483: new 271	org/json/JSONObject
    //   2486: dup
    //   2487: new 271	org/json/JSONObject
    //   2490: dup
    //   2491: aload_2
    //   2492: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2495: ldc_w 956
    //   2498: invokevirtual 1129	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2501: ldc_w 956
    //   2504: invokevirtual 1129	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2507: ldc_w 304
    //   2510: invokevirtual 1132	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   2513: invokevirtual 1133	java/lang/Object:toString	()Ljava/lang/String;
    //   2516: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2519: astore_2
    //   2520: ldc_w 306
    //   2523: new 306	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   2526: dup
    //   2527: invokespecial 307	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   2530: aload_2
    //   2531: invokestatic 313	aasd:a	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   2534: invokevirtual 319	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2537: checkcast 306	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   2540: astore 20
    //   2542: aload_0
    //   2543: getfield 1135	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2546: ifnonnull +45 -> 2591
    //   2549: aload_0
    //   2550: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2553: ifnull +38 -> 2591
    //   2556: aload_0
    //   2557: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2560: invokevirtual 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2563: ifnull +28 -> 2591
    //   2566: aload_0
    //   2567: new 1137	com/tencent/gdtad/aditem/GdtAppReceiver
    //   2570: dup
    //   2571: invokespecial 1138	com/tencent/gdtad/aditem/GdtAppReceiver:<init>	()V
    //   2574: putfield 1135	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2577: aload_0
    //   2578: getfield 1135	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2581: aload_0
    //   2582: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2585: invokevirtual 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2588: invokevirtual 1142	com/tencent/gdtad/aditem/GdtAppReceiver:register	(Landroid/content/Context;)V
    //   2591: new 1144	com/tencent/gdtad/aditem/GdtHandler$Params
    //   2594: dup
    //   2595: invokespecial 1145	com/tencent/gdtad/aditem/GdtHandler$Params:<init>	()V
    //   2598: astore_2
    //   2599: aload_2
    //   2600: bipush 11
    //   2602: putfield 1147	com/tencent/gdtad/aditem/GdtHandler$Params:c	I
    //   2605: aload_2
    //   2606: new 1149	java/lang/ref/WeakReference
    //   2609: dup
    //   2610: aload_0
    //   2611: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2614: getfield 1084	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2617: invokespecial 1152	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   2620: putfield 1155	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   2623: aload_2
    //   2624: new 1157	com/tencent/gdtad/aditem/GdtAd
    //   2627: dup
    //   2628: aload 20
    //   2630: invokespecial 1160	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   2633: putfield 1163	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_ComTencentGdtadAditemGdtAd	Lcom/tencent/gdtad/aditem/GdtAd;
    //   2636: aload_2
    //   2637: iconst_1
    //   2638: putfield 1166	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_Boolean	Z
    //   2641: aload_2
    //   2642: iconst_1
    //   2643: putfield 1168	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_b_of_type_Boolean	Z
    //   2646: aload_2
    //   2647: new 1149	java/lang/ref/WeakReference
    //   2650: dup
    //   2651: aload_0
    //   2652: getfield 1135	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2655: invokespecial 1152	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   2658: putfield 1170	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   2661: aload_2
    //   2662: ldc_w 1172
    //   2665: putfield 1175	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_b_of_type_JavaLangClass	Ljava/lang/Class;
    //   2668: new 525	android/os/Bundle
    //   2671: dup
    //   2672: invokespecial 526	android/os/Bundle:<init>	()V
    //   2675: astore 20
    //   2677: aload 20
    //   2679: ldc_w 1177
    //   2682: ldc 8
    //   2684: invokevirtual 1180	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2687: aload_2
    //   2688: aload 20
    //   2690: putfield 1183	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   2693: aload_2
    //   2694: invokestatic 1188	com/tencent/gdtad/aditem/GdtHandler:a	(Lcom/tencent/gdtad/aditem/GdtHandler$Params;)V
    //   2697: aload_0
    //   2698: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2701: aload_3
    //   2702: aload_1
    //   2703: aconst_null
    //   2704: iload 4
    //   2706: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2709: goto -1344 -> 1365
    //   2712: ldc_w 1190
    //   2715: aload 21
    //   2717: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2720: ifeq +63 -> 2783
    //   2723: aload 22
    //   2725: ldc_w 956
    //   2728: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2731: ldc_w 1192
    //   2734: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2737: astore_2
    //   2738: aload 22
    //   2740: ldc_w 956
    //   2743: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2746: ldc_w 1194
    //   2749: iconst_0
    //   2750: invokevirtual 1197	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2753: istore 8
    //   2755: iload 8
    //   2757: istore 7
    //   2759: iload 8
    //   2761: ifgt +8 -> 2769
    //   2764: sipush 30000
    //   2767: istore 7
    //   2769: aload_0
    //   2770: aload_2
    //   2771: iload 7
    //   2773: aload_3
    //   2774: aload_1
    //   2775: iload 4
    //   2777: invokespecial 1199	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2780: goto -1415 -> 1365
    //   2783: ldc_w 1201
    //   2786: aload 21
    //   2788: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2791: ifeq -1426 -> 1365
    //   2794: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2797: aload_0
    //   2798: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2801: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2804: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2807: aconst_null
    //   2808: new 1203	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6
    //   2811: dup
    //   2812: aload_0
    //   2813: aload_3
    //   2814: aload_1
    //   2815: iload 4
    //   2817: invokespecial 1204	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2820: invokevirtual 1208	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserHealthData	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2823: goto -1458 -> 1365
    //   2826: ldc 59
    //   2828: aload_1
    //   2829: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2832: ifeq +34 -> 2866
    //   2835: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2838: aload_0
    //   2839: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2842: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2845: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2848: new 1210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7
    //   2851: dup
    //   2852: aload_0
    //   2853: aload_3
    //   2854: aload_1
    //   2855: iload 4
    //   2857: invokespecial 1211	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2860: invokevirtual 1214	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkSession	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2863: goto -1498 -> 1365
    //   2866: ldc 83
    //   2868: aload_1
    //   2869: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2872: ifne +12 -> 2884
    //   2875: ldc 86
    //   2877: aload_1
    //   2878: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2881: ifeq +771 -> 3652
    //   2884: aload_0
    //   2885: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2888: ifnull +752 -> 3640
    //   2891: aload_0
    //   2892: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2895: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2898: ifnull +688 -> 3586
    //   2901: iconst_m1
    //   2902: istore 9
    //   2904: aload_2
    //   2905: ifnull +23 -> 2928
    //   2908: ldc_w 1216
    //   2911: aload_2
    //   2912: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2915: ifne +13 -> 2928
    //   2918: ldc_w 1218
    //   2921: aload_2
    //   2922: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2925: ifeq +103 -> 3028
    //   2928: iconst_0
    //   2929: istore 15
    //   2931: iconst_1
    //   2932: istore 13
    //   2934: iconst_1
    //   2935: istore 12
    //   2937: iconst_1
    //   2938: istore 9
    //   2940: iconst_1
    //   2941: istore 7
    //   2943: aload_0
    //   2944: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   2947: ifeq +412 -> 3359
    //   2950: aload_0
    //   2951: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   2954: astore_2
    //   2955: aload_2
    //   2956: ifnull +384 -> 3340
    //   2959: iload 13
    //   2961: iconst_1
    //   2962: if_icmpne +346 -> 3308
    //   2965: aload_2
    //   2966: iconst_1
    //   2967: putfield 1230	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   2970: iload 12
    //   2972: iconst_1
    //   2973: if_icmpne +343 -> 3316
    //   2976: aload_2
    //   2977: iconst_1
    //   2978: putfield 1233	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   2981: iload 9
    //   2983: iconst_1
    //   2984: if_icmpne +340 -> 3324
    //   2987: aload_2
    //   2988: iconst_1
    //   2989: putfield 1236	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   2992: iload 7
    //   2994: iconst_1
    //   2995: if_icmpne +337 -> 3332
    //   2998: aload_2
    //   2999: iconst_1
    //   3000: putfield 1239	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3003: aload_2
    //   3004: iload 15
    //   3006: putfield 1242	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3009: aload_0
    //   3010: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3013: aload_3
    //   3014: aload_1
    //   3015: aload_1
    //   3016: aconst_null
    //   3017: invokestatic 870	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3020: iload 4
    //   3022: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3025: goto -1660 -> 1365
    //   3028: new 271	org/json/JSONObject
    //   3031: dup
    //   3032: aload_2
    //   3033: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3036: astore_2
    //   3037: aload_2
    //   3038: ldc_w 1243
    //   3041: iconst_0
    //   3042: invokevirtual 971	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3045: istore 16
    //   3047: aload_2
    //   3048: ldc_w 1245
    //   3051: invokevirtual 1248	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   3054: checkcast 282	org/json/JSONArray
    //   3057: astore_2
    //   3058: aload_2
    //   3059: ifnonnull +7163 -> 10222
    //   3062: iconst_1
    //   3063: istore 13
    //   3065: iconst_1
    //   3066: istore 12
    //   3068: iconst_1
    //   3069: istore 9
    //   3071: iconst_1
    //   3072: istore 7
    //   3074: iload 16
    //   3076: istore 15
    //   3078: goto -135 -> 2943
    //   3081: iload 10
    //   3083: aload_2
    //   3084: invokevirtual 1251	org/json/JSONArray:length	()I
    //   3087: if_icmpge +76 -> 3163
    //   3090: aload_2
    //   3091: iload 10
    //   3093: invokevirtual 1253	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   3096: astore 20
    //   3098: aload 20
    //   3100: ldc 112
    //   3102: invokevirtual 1256	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3105: ifeq +6 -> 3111
    //   3108: iconst_1
    //   3109: istore 11
    //   3111: aload 20
    //   3113: ldc 115
    //   3115: invokevirtual 1256	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3118: ifeq +6 -> 3124
    //   3121: iconst_1
    //   3122: istore 7
    //   3124: aload 20
    //   3126: ldc 118
    //   3128: invokevirtual 1256	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3131: ifeq +6 -> 3137
    //   3134: iconst_1
    //   3135: istore 9
    //   3137: aload 20
    //   3139: ldc 121
    //   3141: invokevirtual 1256	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3144: istore 15
    //   3146: iload 15
    //   3148: ifeq +6 -> 3154
    //   3151: iconst_1
    //   3152: istore 8
    //   3154: iload 10
    //   3156: iconst_1
    //   3157: iadd
    //   3158: istore 10
    //   3160: goto -79 -> 3081
    //   3163: iload 11
    //   3165: istore 10
    //   3167: iload 11
    //   3169: iconst_m1
    //   3170: if_icmpne +6 -> 3176
    //   3173: iconst_0
    //   3174: istore 10
    //   3176: iload 7
    //   3178: istore 11
    //   3180: iload 7
    //   3182: iconst_m1
    //   3183: if_icmpne +6 -> 3189
    //   3186: iconst_0
    //   3187: istore 11
    //   3189: iload 9
    //   3191: iconst_m1
    //   3192: if_icmpne +7009 -> 10201
    //   3195: iconst_0
    //   3196: istore 14
    //   3198: iload 14
    //   3200: istore 9
    //   3202: iload 8
    //   3204: istore 7
    //   3206: iload 11
    //   3208: istore 12
    //   3210: iload 10
    //   3212: istore 13
    //   3214: iload 16
    //   3216: istore 15
    //   3218: iload 8
    //   3220: iconst_m1
    //   3221: if_icmpne -278 -> 2943
    //   3224: iconst_0
    //   3225: istore 7
    //   3227: iload 14
    //   3229: istore 9
    //   3231: iload 11
    //   3233: istore 12
    //   3235: iload 10
    //   3237: istore 13
    //   3239: iload 16
    //   3241: istore 15
    //   3243: goto -300 -> 2943
    //   3246: astore_2
    //   3247: aload_2
    //   3248: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   3251: ldc 139
    //   3253: iconst_1
    //   3254: aload_2
    //   3255: iconst_0
    //   3256: anewarray 633	java/lang/Object
    //   3259: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3262: aload_0
    //   3263: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3266: ifeq +23 -> 3289
    //   3269: aload_0
    //   3270: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3273: aload_3
    //   3274: aload_1
    //   3275: aload_1
    //   3276: aconst_null
    //   3277: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3280: iload 4
    //   3282: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3285: ldc_w 631
    //   3288: areturn
    //   3289: aload_0
    //   3290: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3293: aload_3
    //   3294: aload_1
    //   3295: aload_1
    //   3296: aconst_null
    //   3297: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3300: iload 4
    //   3302: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3305: goto -20 -> 3285
    //   3308: aload_2
    //   3309: iconst_0
    //   3310: putfield 1230	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3313: goto -343 -> 2970
    //   3316: aload_2
    //   3317: iconst_0
    //   3318: putfield 1233	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3321: goto -340 -> 2981
    //   3324: aload_2
    //   3325: iconst_0
    //   3326: putfield 1236	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3329: goto -337 -> 2992
    //   3332: aload_2
    //   3333: iconst_0
    //   3334: putfield 1239	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3337: goto -334 -> 3003
    //   3340: aload_0
    //   3341: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3344: aload_3
    //   3345: aload_1
    //   3346: aload_1
    //   3347: aconst_null
    //   3348: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3351: iload 4
    //   3353: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3356: goto -1991 -> 1365
    //   3359: aload_0
    //   3360: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3363: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3366: invokevirtual 1260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3369: ifnull +198 -> 3567
    //   3372: aload_0
    //   3373: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3376: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3379: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3382: ifnull +185 -> 3567
    //   3385: iload 13
    //   3387: iconst_1
    //   3388: if_icmpne +111 -> 3499
    //   3391: aload_0
    //   3392: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3395: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3398: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3401: iconst_1
    //   3402: putfield 1267	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3405: iload 12
    //   3407: iconst_1
    //   3408: if_icmpne +108 -> 3516
    //   3411: aload_0
    //   3412: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3415: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3418: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3421: iconst_1
    //   3422: putfield 1268	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3425: iload 9
    //   3427: iconst_1
    //   3428: if_icmpne +105 -> 3533
    //   3431: aload_0
    //   3432: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3435: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3438: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3441: iconst_1
    //   3442: putfield 1269	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3445: iload 7
    //   3447: iconst_1
    //   3448: if_icmpne +102 -> 3550
    //   3451: aload_0
    //   3452: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3455: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3458: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3461: iconst_1
    //   3462: putfield 1270	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3465: aload_0
    //   3466: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3469: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3472: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3475: iload 15
    //   3477: putfield 1271	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3480: aload_0
    //   3481: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3484: aload_3
    //   3485: aload_1
    //   3486: aload_1
    //   3487: aconst_null
    //   3488: invokestatic 870	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3491: iload 4
    //   3493: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3496: goto -2131 -> 1365
    //   3499: aload_0
    //   3500: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3503: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3506: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3509: iconst_0
    //   3510: putfield 1267	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3513: goto -108 -> 3405
    //   3516: aload_0
    //   3517: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3520: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3523: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3526: iconst_0
    //   3527: putfield 1268	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3530: goto -105 -> 3425
    //   3533: aload_0
    //   3534: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3537: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3540: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3543: iconst_0
    //   3544: putfield 1269	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3547: goto -102 -> 3445
    //   3550: aload_0
    //   3551: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3554: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3557: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3560: iconst_0
    //   3561: putfield 1270	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3564: goto -99 -> 3465
    //   3567: aload_0
    //   3568: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3571: aload_3
    //   3572: aload_1
    //   3573: aload_1
    //   3574: aconst_null
    //   3575: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3578: iload 4
    //   3580: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3583: goto -2218 -> 1365
    //   3586: ldc 139
    //   3588: iconst_1
    //   3589: ldc_w 1273
    //   3592: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3595: aload_0
    //   3596: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3599: ifeq +22 -> 3621
    //   3602: aload_0
    //   3603: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3606: aload_3
    //   3607: aload_1
    //   3608: aload_1
    //   3609: aconst_null
    //   3610: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3613: iload 4
    //   3615: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3618: goto -2253 -> 1365
    //   3621: aload_0
    //   3622: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3625: aload_3
    //   3626: aload_1
    //   3627: aload_1
    //   3628: aconst_null
    //   3629: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3632: iload 4
    //   3634: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3637: goto -2272 -> 1365
    //   3640: ldc 139
    //   3642: iconst_1
    //   3643: ldc_w 1275
    //   3646: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3649: goto -2284 -> 1365
    //   3652: ldc 89
    //   3654: aload_1
    //   3655: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3658: ifeq +220 -> 3878
    //   3661: new 271	org/json/JSONObject
    //   3664: dup
    //   3665: aload_2
    //   3666: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3669: astore_2
    //   3670: aload_2
    //   3671: ldc_w 1243
    //   3674: iconst_0
    //   3675: invokevirtual 971	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3678: istore 15
    //   3680: aload_2
    //   3681: ldc_w 1277
    //   3684: invokevirtual 1021	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   3687: pop
    //   3688: aload_2
    //   3689: ldc_w 1279
    //   3692: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3695: pop
    //   3696: aload_2
    //   3697: ldc_w 1281
    //   3700: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3703: pop
    //   3704: aload_0
    //   3705: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3708: ifeq +91 -> 3799
    //   3711: aload_0
    //   3712: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3715: astore_2
    //   3716: aload_2
    //   3717: ifnull +63 -> 3780
    //   3720: aload_2
    //   3721: iload 15
    //   3723: putfield 1242	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3726: aload_0
    //   3727: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3730: aload_3
    //   3731: aload_1
    //   3732: aload_1
    //   3733: aconst_null
    //   3734: invokestatic 870	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3737: iload 4
    //   3739: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3742: aload_0
    //   3743: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3746: aload_3
    //   3747: aload_1
    //   3748: aload_1
    //   3749: aconst_null
    //   3750: invokestatic 870	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3753: iload 4
    //   3755: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3758: goto -2393 -> 1365
    //   3761: astore_1
    //   3762: ldc 139
    //   3764: iconst_1
    //   3765: aload_1
    //   3766: iconst_0
    //   3767: anewarray 633	java/lang/Object
    //   3770: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3773: aload_1
    //   3774: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   3777: goto -2412 -> 1365
    //   3780: aload_0
    //   3781: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3784: aload_3
    //   3785: aload_1
    //   3786: aload_1
    //   3787: aconst_null
    //   3788: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3791: iload 4
    //   3793: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3796: goto -54 -> 3742
    //   3799: aload_0
    //   3800: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3803: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3806: invokevirtual 1260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3809: ifnull +50 -> 3859
    //   3812: aload_0
    //   3813: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3816: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3819: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3822: ifnull +37 -> 3859
    //   3825: aload_0
    //   3826: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3829: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3832: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3835: iload 15
    //   3837: putfield 1271	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3840: aload_0
    //   3841: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3844: aload_3
    //   3845: aload_1
    //   3846: aload_1
    //   3847: aconst_null
    //   3848: invokestatic 870	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3851: iload 4
    //   3853: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3856: goto -114 -> 3742
    //   3859: aload_0
    //   3860: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3863: aload_3
    //   3864: aload_1
    //   3865: aload_1
    //   3866: aconst_null
    //   3867: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3870: iload 4
    //   3872: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3875: goto -133 -> 3742
    //   3878: ldc 32
    //   3880: aload_1
    //   3881: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3884: ifeq +79 -> 3963
    //   3887: new 271	org/json/JSONObject
    //   3890: dup
    //   3891: aload_2
    //   3892: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3895: astore_2
    //   3896: aload_2
    //   3897: ldc_w 1192
    //   3900: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3903: astore 20
    //   3905: aload_2
    //   3906: ldc_w 1194
    //   3909: iconst_0
    //   3910: invokevirtual 1197	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3913: istore 8
    //   3915: iload 8
    //   3917: istore 7
    //   3919: iload 8
    //   3921: ifgt +8 -> 3929
    //   3924: sipush 30000
    //   3927: istore 7
    //   3929: aload_0
    //   3930: aload 20
    //   3932: iload 7
    //   3934: aload_3
    //   3935: aload_1
    //   3936: iload 4
    //   3938: invokespecial 1199	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   3941: goto -2576 -> 1365
    //   3944: astore_1
    //   3945: ldc 139
    //   3947: iconst_1
    //   3948: aload_1
    //   3949: iconst_0
    //   3950: anewarray 633	java/lang/Object
    //   3953: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3956: aload_1
    //   3957: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   3960: goto -2595 -> 1365
    //   3963: ldc 68
    //   3965: aload_1
    //   3966: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3969: ifne +21 -> 3990
    //   3972: ldc 65
    //   3974: aload_1
    //   3975: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3978: ifne +12 -> 3990
    //   3981: ldc 71
    //   3983: aload_1
    //   3984: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3987: ifeq +1371 -> 5358
    //   3990: iconst_0
    //   3991: istore 15
    //   3993: ldc 68
    //   3995: aload_1
    //   3996: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3999: ifeq +6 -> 4005
    //   4002: iconst_1
    //   4003: istore 15
    //   4005: new 271	org/json/JSONObject
    //   4008: dup
    //   4009: aload_2
    //   4010: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4013: astore 23
    //   4015: aload 23
    //   4017: ldc_w 1283
    //   4020: iconst_m1
    //   4021: invokevirtual 1197	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4024: istore 9
    //   4026: iconst_m1
    //   4027: istore 7
    //   4029: aconst_null
    //   4030: astore 22
    //   4032: iload 9
    //   4034: ifne +6223 -> 10257
    //   4037: iconst_0
    //   4038: istore 7
    //   4040: aconst_null
    //   4041: astore_2
    //   4042: aload 23
    //   4044: ldc_w 1285
    //   4047: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4050: astore 25
    //   4052: aload 23
    //   4054: ldc_w 1287
    //   4057: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4060: astore 26
    //   4062: ldc 68
    //   4064: aload_1
    //   4065: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4068: ifne +6169 -> 10237
    //   4071: ldc 71
    //   4073: aload_1
    //   4074: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4077: ifeq +29 -> 4106
    //   4080: goto +6157 -> 10237
    //   4083: aload_0
    //   4084: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4087: ifeq +510 -> 4597
    //   4090: aload_0
    //   4091: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4094: ifnull +503 -> 4597
    //   4097: aload_0
    //   4098: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4101: iload 8
    //   4103: putfield 1290	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4106: aload_0
    //   4107: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4110: ifeq +524 -> 4634
    //   4113: aload_0
    //   4114: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4117: ifnull +517 -> 4634
    //   4120: aload_0
    //   4121: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4124: aload_1
    //   4125: putfield 1293	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   4128: aload_0
    //   4129: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4132: iload 4
    //   4134: putfield 1296	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   4137: aload 23
    //   4139: ldc_w 1298
    //   4142: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4145: astore 20
    //   4147: aload 20
    //   4149: astore 21
    //   4151: aload 20
    //   4153: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4156: ifeq +13 -> 4169
    //   4159: aload 23
    //   4161: ldc_w 1300
    //   4164: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4167: astore 21
    //   4169: aload 23
    //   4171: ldc_w 1302
    //   4174: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4177: astore 24
    //   4179: aload 23
    //   4181: ldc_w 1304
    //   4184: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4187: astore 27
    //   4189: aload 23
    //   4191: ldc_w 1306
    //   4194: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4197: astore 23
    //   4199: aload 21
    //   4201: astore 20
    //   4203: aload 21
    //   4205: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4208: ifeq +15 -> 4223
    //   4211: aload_0
    //   4212: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4215: ifeq +451 -> 4666
    //   4218: ldc_w 1308
    //   4221: astore 20
    //   4223: new 1310	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8
    //   4226: dup
    //   4227: aload_0
    //   4228: aload_3
    //   4229: aload_1
    //   4230: iload 4
    //   4232: invokespecial 1311	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   4235: astore_1
    //   4236: aload_0
    //   4237: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4240: ifeq +21 -> 4261
    //   4243: aload_0
    //   4244: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4247: ifnull +14 -> 4261
    //   4250: aload_0
    //   4251: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4254: getfield 1290	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4257: iconst_1
    //   4258: if_icmpeq +27 -> 4285
    //   4261: aload_0
    //   4262: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4265: ifne +506 -> 4771
    //   4268: aload_0
    //   4269: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4272: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4275: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4278: getfield 1312	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4281: iconst_1
    //   4282: if_icmpne +489 -> 4771
    //   4285: aload 27
    //   4287: ldc_w 1314
    //   4290: invokevirtual 1317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4293: ifne +14 -> 4307
    //   4296: aload 27
    //   4298: ldc_w 1319
    //   4301: invokevirtual 1317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4304: ifeq +383 -> 4687
    //   4307: aload_0
    //   4308: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4311: invokevirtual 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4314: aload 24
    //   4316: aload 27
    //   4318: aload 20
    //   4320: aload_0
    //   4321: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4324: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4327: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4330: iload 15
    //   4332: invokestatic 1323	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4335: goto +5918 -> 10253
    //   4338: iload 9
    //   4340: iconst_2
    //   4341: if_icmpne +5930 -> 10271
    //   4344: iconst_0
    //   4345: istore 7
    //   4347: aload 23
    //   4349: ldc_w 1325
    //   4352: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4355: astore_2
    //   4356: aload_2
    //   4357: ifnull +80 -> 4437
    //   4360: aload_0
    //   4361: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4364: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4367: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4370: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4373: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4376: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4379: ifnull +58 -> 4437
    //   4382: aload_2
    //   4383: aload_0
    //   4384: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4387: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4390: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4393: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4396: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4399: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4402: invokevirtual 1334	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   4405: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4408: ifeq +29 -> 4437
    //   4411: aload_0
    //   4412: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4415: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4418: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4421: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4424: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4427: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4430: astore 22
    //   4432: aconst_null
    //   4433: astore_2
    //   4434: goto -392 -> 4042
    //   4437: ldc 139
    //   4439: iconst_1
    //   4440: new 321	java/lang/StringBuilder
    //   4443: dup
    //   4444: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   4447: ldc_w 1336
    //   4450: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4453: aload_2
    //   4454: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4457: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4460: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4463: aconst_null
    //   4464: astore_2
    //   4465: goto -423 -> 4042
    //   4468: iload 9
    //   4470: iconst_5
    //   4471: if_icmpne +102 -> 4573
    //   4474: aload 23
    //   4476: ldc_w 1338
    //   4479: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4482: astore 20
    //   4484: aload_0
    //   4485: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4488: ifeq +37 -> 4525
    //   4491: aload_0
    //   4492: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4495: ifnull +30 -> 4525
    //   4498: aload_0
    //   4499: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4502: getfield 1342	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4505: astore_2
    //   4506: aload_2
    //   4507: ifnull +35 -> 4542
    //   4510: aload_2
    //   4511: invokevirtual 1345	com/tencent/mobileqq/mini/sdk/ShareChatModel:getEntryHash	()Ljava/lang/String;
    //   4514: aload 20
    //   4516: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4519: ifeq +23 -> 4542
    //   4522: goto +5777 -> 10299
    //   4525: aload_0
    //   4526: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4529: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4532: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4535: getfield 1346	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4538: astore_2
    //   4539: goto -33 -> 4506
    //   4542: ldc 139
    //   4544: iconst_1
    //   4545: new 321	java/lang/StringBuilder
    //   4548: dup
    //   4549: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   4552: ldc_w 1336
    //   4555: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4558: aconst_null
    //   4559: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4562: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4565: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4568: aconst_null
    //   4569: astore_2
    //   4570: goto +5729 -> 10299
    //   4573: iload 9
    //   4575: bipush 6
    //   4577: if_icmpne +5619 -> 10196
    //   4580: ldc 71
    //   4582: aload_1
    //   4583: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4586: ifeq +5610 -> 10196
    //   4589: iconst_0
    //   4590: istore 7
    //   4592: aconst_null
    //   4593: astore_2
    //   4594: goto -552 -> 4042
    //   4597: aload_0
    //   4598: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4601: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4604: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4607: iload 8
    //   4609: putfield 1312	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4612: goto -506 -> 4106
    //   4615: astore_1
    //   4616: ldc 139
    //   4618: iconst_1
    //   4619: aload_1
    //   4620: iconst_0
    //   4621: anewarray 633	java/lang/Object
    //   4624: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4627: aload_1
    //   4628: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   4631: goto -3266 -> 1365
    //   4634: aload_0
    //   4635: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4638: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4641: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4644: aload_1
    //   4645: putfield 1347	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   4648: aload_0
    //   4649: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4652: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4655: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4658: iload 4
    //   4660: putfield 1348	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   4663: goto -526 -> 4137
    //   4666: aload_0
    //   4667: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4670: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4673: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4676: invokevirtual 727	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   4679: getfield 919	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   4682: astore 20
    //   4684: goto -461 -> 4223
    //   4687: aload_0
    //   4688: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4691: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4694: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4697: pop
    //   4698: invokestatic 1353	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   4701: aload 27
    //   4703: invokevirtual 1356	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   4706: astore_1
    //   4707: aload_1
    //   4708: invokestatic 1360	bdnn:a	(Ljava/lang/String;)Z
    //   4711: ifne +33 -> 4744
    //   4714: aload_0
    //   4715: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4718: invokevirtual 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4721: aload 24
    //   4723: aload_1
    //   4724: aload 20
    //   4726: aload_0
    //   4727: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4730: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4733: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4736: iload 15
    //   4738: invokestatic 1323	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4741: goto +5512 -> 10253
    //   4744: aload_0
    //   4745: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4748: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4751: new 1362	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9
    //   4754: dup
    //   4755: aload_0
    //   4756: aload 24
    //   4758: aload 20
    //   4760: iload 15
    //   4762: invokespecial 1365	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4765: invokevirtual 1369	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   4768: goto +5485 -> 10253
    //   4771: aload_0
    //   4772: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4775: ifeq +21 -> 4796
    //   4778: aload_0
    //   4779: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4782: ifnull +14 -> 4796
    //   4785: aload_0
    //   4786: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4789: getfield 1290	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4792: iconst_3
    //   4793: if_icmpeq +27 -> 4820
    //   4796: aload_0
    //   4797: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4800: ifne +55 -> 4855
    //   4803: aload_0
    //   4804: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4807: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4810: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4813: getfield 1312	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4816: iconst_3
    //   4817: if_icmpne +38 -> 4855
    //   4820: aload_0
    //   4821: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4824: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4827: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4830: astore_1
    //   4831: aload_0
    //   4832: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4835: invokevirtual 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4838: aload 24
    //   4840: aload_1
    //   4841: getfield 1372	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   4844: aload 20
    //   4846: iconst_3
    //   4847: aload_1
    //   4848: invokestatic 1376	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   4851: ldc_w 631
    //   4854: areturn
    //   4855: aload_0
    //   4856: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4859: ifeq +21 -> 4880
    //   4862: aload_0
    //   4863: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4866: ifnull +14 -> 4880
    //   4869: aload_0
    //   4870: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4873: getfield 1290	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4876: iconst_4
    //   4877: if_icmpeq +27 -> 4904
    //   4880: aload_0
    //   4881: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4884: ifne +55 -> 4939
    //   4887: aload_0
    //   4888: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4891: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4894: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4897: getfield 1312	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4900: iconst_4
    //   4901: if_icmpne +38 -> 4939
    //   4904: aload_0
    //   4905: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4908: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4911: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4914: astore_1
    //   4915: aload_0
    //   4916: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4919: invokevirtual 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4922: aload 24
    //   4924: aload_1
    //   4925: getfield 1372	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   4928: aload 20
    //   4930: iconst_4
    //   4931: aload_1
    //   4932: invokestatic 1376	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   4935: ldc_w 631
    //   4938: areturn
    //   4939: aload 27
    //   4941: invokestatic 1381	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   4944: ifne +5361 -> 10305
    //   4947: aload 27
    //   4949: invokestatic 1384	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   4952: ifeq +5359 -> 10311
    //   4955: goto +5350 -> 10305
    //   4958: aload_0
    //   4959: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4962: ifnull +5355 -> 10317
    //   4965: aload_0
    //   4966: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4969: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4972: ifnull +5345 -> 10317
    //   4975: aload 27
    //   4977: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4980: ifne +5337 -> 10317
    //   4983: new 1386	java/io/File
    //   4986: dup
    //   4987: invokestatic 1353	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   4990: aload 27
    //   4992: invokevirtual 1356	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   4995: invokespecial 1387	java/io/File:<init>	(Ljava/lang/String;)V
    //   4998: invokevirtual 1390	java/io/File:exists	()Z
    //   5001: ifeq +5316 -> 10317
    //   5004: iconst_1
    //   5005: istore 17
    //   5007: aload 27
    //   5009: invokestatic 1360	bdnn:a	(Ljava/lang/String;)Z
    //   5012: ifne +13 -> 5025
    //   5015: iload 16
    //   5017: ifne +197 -> 5214
    //   5020: iload 17
    //   5022: ifne +192 -> 5214
    //   5025: aload_0
    //   5026: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5029: ifeq +110 -> 5139
    //   5032: aload_0
    //   5033: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5036: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5039: astore_3
    //   5040: invokestatic 1395	com/tencent/mobileqq/minigame/utils/GameWnsUtils:defaultShareImg	()Ljava/lang/String;
    //   5043: astore 21
    //   5045: iload 15
    //   5047: ifeq +5276 -> 10323
    //   5050: bipush 11
    //   5052: istore 4
    //   5054: aload_3
    //   5055: aload 24
    //   5057: aload 21
    //   5059: aload 20
    //   5061: aload 23
    //   5063: aload 25
    //   5065: aload 26
    //   5067: aload 22
    //   5069: aload_2
    //   5070: iload 4
    //   5072: iload 9
    //   5074: ldc_w 631
    //   5077: aload_1
    //   5078: invokevirtual 1399	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5081: ldc 139
    //   5083: iconst_1
    //   5084: new 321	java/lang/StringBuilder
    //   5087: dup
    //   5088: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   5091: ldc_w 1401
    //   5094: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5097: iload 16
    //   5099: invokevirtual 776	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5102: ldc_w 1403
    //   5105: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5108: iload 17
    //   5110: invokevirtual 776	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5113: ldc_w 1405
    //   5116: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5119: aload 27
    //   5121: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5124: ldc_w 1407
    //   5127: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5130: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5133: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5136: goto -3771 -> 1365
    //   5139: aload_0
    //   5140: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5143: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5146: ifnull -3781 -> 1365
    //   5149: aload_0
    //   5150: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5153: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5156: getfield 1410	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5159: ifeq +16 -> 5175
    //   5162: ldc 139
    //   5164: iconst_1
    //   5165: ldc_w 1412
    //   5168: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5171: ldc_w 631
    //   5174: areturn
    //   5175: aload_0
    //   5176: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5179: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5182: new 1414	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10
    //   5185: dup
    //   5186: aload_0
    //   5187: aload 24
    //   5189: aload 20
    //   5191: aload 23
    //   5193: aload 25
    //   5195: aload 26
    //   5197: aload 22
    //   5199: aload_2
    //   5200: iload 15
    //   5202: iload 9
    //   5204: aload_1
    //   5205: invokespecial 1417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;ZILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5208: invokevirtual 1369	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5211: goto -3846 -> 1365
    //   5214: aload 27
    //   5216: ldc_w 1314
    //   5219: invokevirtual 1317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5222: ifne +14 -> 5236
    //   5225: aload 27
    //   5227: ldc_w 1319
    //   5230: invokevirtual 1317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5233: ifeq +50 -> 5283
    //   5236: aload_0
    //   5237: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5240: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5243: astore_3
    //   5244: iload 15
    //   5246: ifeq +5084 -> 10330
    //   5249: bipush 11
    //   5251: istore 4
    //   5253: aload_3
    //   5254: aload 24
    //   5256: aload 27
    //   5258: aload 20
    //   5260: aload 23
    //   5262: aload 25
    //   5264: aload 26
    //   5266: aload 22
    //   5268: aload_2
    //   5269: iload 4
    //   5271: iload 9
    //   5273: ldc_w 631
    //   5276: aload_1
    //   5277: invokevirtual 1399	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5280: goto -3915 -> 1365
    //   5283: aload_0
    //   5284: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5287: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5290: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5293: pop
    //   5294: invokestatic 1353	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5297: aload 27
    //   5299: invokevirtual 1356	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5302: astore_3
    //   5303: aload_0
    //   5304: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5307: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5310: astore 21
    //   5312: iload 15
    //   5314: ifeq +37 -> 5351
    //   5317: bipush 11
    //   5319: istore 4
    //   5321: aload 21
    //   5323: aload 24
    //   5325: aload_3
    //   5326: aload 20
    //   5328: aload 23
    //   5330: aload 25
    //   5332: aload 26
    //   5334: aload 22
    //   5336: aload_2
    //   5337: iload 4
    //   5339: iload 9
    //   5341: ldc_w 631
    //   5344: aload_1
    //   5345: invokevirtual 1399	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5348: goto -3983 -> 1365
    //   5351: bipush 12
    //   5353: istore 4
    //   5355: goto -34 -> 5321
    //   5358: ldc 74
    //   5360: aload_1
    //   5361: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5364: ifne +12 -> 5376
    //   5367: ldc 77
    //   5369: aload_1
    //   5370: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5373: ifeq +531 -> 5904
    //   5376: new 271	org/json/JSONObject
    //   5379: dup
    //   5380: aload_2
    //   5381: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5384: astore_2
    //   5385: aload_2
    //   5386: ldc_w 1283
    //   5389: iconst_m1
    //   5390: invokevirtual 1197	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5393: istore 8
    //   5395: iconst_m1
    //   5396: istore 7
    //   5398: iload 8
    //   5400: ifne +242 -> 5642
    //   5403: iconst_0
    //   5404: istore 7
    //   5406: ldc 77
    //   5408: aload_1
    //   5409: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5412: ifeq +39 -> 5451
    //   5415: iload 7
    //   5417: istore 8
    //   5419: iload 7
    //   5421: iconst_m1
    //   5422: if_icmpne +6 -> 5428
    //   5425: iconst_0
    //   5426: istore 8
    //   5428: aload_0
    //   5429: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5432: ifeq +258 -> 5690
    //   5435: aload_0
    //   5436: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5439: ifnull +251 -> 5690
    //   5442: aload_0
    //   5443: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5446: iload 8
    //   5448: putfield 1290	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5451: aload_0
    //   5452: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5455: ifeq +253 -> 5708
    //   5458: aload_0
    //   5459: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5462: ifnull +246 -> 5708
    //   5465: aload_0
    //   5466: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5469: getfield 1290	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5472: istore 7
    //   5474: aload_0
    //   5475: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5478: ifeq +248 -> 5726
    //   5481: aload_0
    //   5482: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5485: ifnull +241 -> 5726
    //   5488: aload_0
    //   5489: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5492: aload_1
    //   5493: putfield 1293	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   5496: aload_0
    //   5497: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5500: iload 4
    //   5502: putfield 1296	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   5505: new 1419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11
    //   5508: dup
    //   5509: aload_0
    //   5510: aload_3
    //   5511: aload_1
    //   5512: iload 4
    //   5514: invokespecial 1420	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   5517: astore_1
    //   5518: aload_0
    //   5519: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5522: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5525: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5528: astore_3
    //   5529: aload_2
    //   5530: ldc_w 1302
    //   5533: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5536: astore 20
    //   5538: aload_2
    //   5539: ldc_w 1304
    //   5542: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5545: astore_2
    //   5546: aload_2
    //   5547: invokestatic 1381	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   5550: ifne +4787 -> 10337
    //   5553: aload_2
    //   5554: invokestatic 1384	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   5557: ifeq +4786 -> 10343
    //   5560: goto +4777 -> 10337
    //   5563: invokestatic 1353	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5566: aload_2
    //   5567: invokevirtual 1356	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5570: astore 21
    //   5572: aload_0
    //   5573: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5576: ifnull +4773 -> 10349
    //   5579: aload_0
    //   5580: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5583: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5586: ifnull +4763 -> 10349
    //   5589: aload_2
    //   5590: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5593: ifne +4756 -> 10349
    //   5596: new 1386	java/io/File
    //   5599: dup
    //   5600: aload 21
    //   5602: invokespecial 1387	java/io/File:<init>	(Ljava/lang/String;)V
    //   5605: invokevirtual 1390	java/io/File:exists	()Z
    //   5608: ifeq +4741 -> 10349
    //   5611: iconst_1
    //   5612: istore 8
    //   5614: iload 4
    //   5616: ifeq +142 -> 5758
    //   5619: aload_0
    //   5620: aload 22
    //   5622: aload 20
    //   5624: aload_2
    //   5625: iload 7
    //   5627: aload_1
    //   5628: invokespecial 188	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5631: goto -4266 -> 1365
    //   5634: astore_1
    //   5635: aload_1
    //   5636: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   5639: goto -4274 -> 1365
    //   5642: iload 8
    //   5644: iconst_1
    //   5645: if_icmpne +9 -> 5654
    //   5648: iconst_1
    //   5649: istore 7
    //   5651: goto -245 -> 5406
    //   5654: iload 8
    //   5656: iconst_2
    //   5657: if_icmpne +9 -> 5666
    //   5660: iconst_0
    //   5661: istore 7
    //   5663: goto -257 -> 5406
    //   5666: iload 8
    //   5668: iconst_3
    //   5669: if_icmpne +9 -> 5678
    //   5672: iconst_3
    //   5673: istore 7
    //   5675: goto -269 -> 5406
    //   5678: iload 8
    //   5680: iconst_4
    //   5681: if_icmpne -275 -> 5406
    //   5684: iconst_4
    //   5685: istore 7
    //   5687: goto -281 -> 5406
    //   5690: aload_0
    //   5691: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5694: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5697: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5700: iload 8
    //   5702: putfield 1312	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5705: goto -254 -> 5451
    //   5708: aload_0
    //   5709: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5712: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5715: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5718: getfield 1312	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5721: istore 7
    //   5723: goto -249 -> 5474
    //   5726: aload_0
    //   5727: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5730: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5733: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5736: aload_1
    //   5737: putfield 1347	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   5740: aload_0
    //   5741: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5744: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5747: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5750: iload 4
    //   5752: putfield 1348	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   5755: goto -250 -> 5505
    //   5758: aload_2
    //   5759: invokestatic 1360	bdnn:a	(Ljava/lang/String;)Z
    //   5762: ifne +13 -> 5775
    //   5765: iload 4
    //   5767: ifne +114 -> 5881
    //   5770: iload 8
    //   5772: ifne +109 -> 5881
    //   5775: aload_0
    //   5776: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5779: ifeq +37 -> 5816
    //   5782: aload_3
    //   5783: ifnull +21 -> 5804
    //   5786: aload_0
    //   5787: aload 22
    //   5789: aload 20
    //   5791: aload_3
    //   5792: getfield 1372	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5795: iload 7
    //   5797: aload_1
    //   5798: invokespecial 188	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5801: goto -4436 -> 1365
    //   5804: ldc 139
    //   5806: iconst_1
    //   5807: ldc_w 1422
    //   5810: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5813: goto -4448 -> 1365
    //   5816: aload_0
    //   5817: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5820: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5823: ifnull -4458 -> 1365
    //   5826: aload_0
    //   5827: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5830: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5833: getfield 1410	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5836: ifeq +16 -> 5852
    //   5839: ldc 139
    //   5841: iconst_1
    //   5842: ldc_w 1424
    //   5845: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5848: ldc_w 631
    //   5851: areturn
    //   5852: aload_0
    //   5853: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5856: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5859: new 1426	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12
    //   5862: dup
    //   5863: aload_0
    //   5864: aload_3
    //   5865: aload 22
    //   5867: aload 20
    //   5869: iload 7
    //   5871: aload_1
    //   5872: invokespecial 1429	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Landroid/app/Activity;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5875: invokevirtual 1369	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5878: goto -4513 -> 1365
    //   5881: iload 4
    //   5883: ifne -4518 -> 1365
    //   5886: iload 8
    //   5888: ifeq -4523 -> 1365
    //   5891: aload_0
    //   5892: aload 20
    //   5894: aload 21
    //   5896: iload 7
    //   5898: invokespecial 194	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareLocalPicMessage	(Ljava/lang/String;Ljava/lang/String;I)V
    //   5901: goto -4536 -> 1365
    //   5904: ldc 44
    //   5906: aload_1
    //   5907: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5910: ifeq +383 -> 6293
    //   5913: aload_0
    //   5914: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5917: ifnull -4552 -> 1365
    //   5920: aload_0
    //   5921: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5924: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5927: ifnull -4562 -> 1365
    //   5930: new 271	org/json/JSONObject
    //   5933: dup
    //   5934: aload_2
    //   5935: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5938: ldc_w 1431
    //   5941: invokevirtual 1248	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   5944: checkcast 282	org/json/JSONArray
    //   5947: astore_2
    //   5948: aload_2
    //   5949: ifnonnull +98 -> 6047
    //   5952: iconst_0
    //   5953: istore 10
    //   5955: iconst_0
    //   5956: istore 9
    //   5958: iconst_0
    //   5959: istore 8
    //   5961: iconst_0
    //   5962: istore 7
    //   5964: aload_0
    //   5965: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5968: ifeq +185 -> 6153
    //   5971: aload_0
    //   5972: invokevirtual 1225	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5975: astore_2
    //   5976: aload_2
    //   5977: ifnull +157 -> 6134
    //   5980: iload 10
    //   5982: ifne +8 -> 5990
    //   5985: aload_2
    //   5986: iconst_0
    //   5987: putfield 1230	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   5990: iload 9
    //   5992: ifne +8 -> 6000
    //   5995: aload_2
    //   5996: iconst_0
    //   5997: putfield 1233	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   6000: iload 8
    //   6002: ifne +8 -> 6010
    //   6005: aload_2
    //   6006: iconst_0
    //   6007: putfield 1236	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   6010: iload 7
    //   6012: ifne +8 -> 6020
    //   6015: aload_2
    //   6016: iconst_0
    //   6017: putfield 1239	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   6020: aload_0
    //   6021: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6024: aload_3
    //   6025: aload_1
    //   6026: aload_1
    //   6027: aconst_null
    //   6028: invokestatic 870	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6031: iload 4
    //   6033: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6036: goto -4671 -> 1365
    //   6039: astore_1
    //   6040: aload_1
    //   6041: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   6044: goto -4679 -> 1365
    //   6047: iconst_m1
    //   6048: istore 7
    //   6050: iconst_m1
    //   6051: istore 8
    //   6053: iconst_m1
    //   6054: istore 9
    //   6056: iconst_m1
    //   6057: istore 10
    //   6059: iconst_0
    //   6060: istore 11
    //   6062: iload 11
    //   6064: aload_2
    //   6065: invokevirtual 1251	org/json/JSONArray:length	()I
    //   6068: if_icmpge +4125 -> 10193
    //   6071: aload_2
    //   6072: iload 11
    //   6074: invokevirtual 1253	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6077: astore 20
    //   6079: aload 20
    //   6081: ldc 112
    //   6083: invokevirtual 1256	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6086: ifeq +6 -> 6092
    //   6089: iconst_0
    //   6090: istore 10
    //   6092: aload 20
    //   6094: ldc 115
    //   6096: invokevirtual 1256	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6099: ifeq +6 -> 6105
    //   6102: iconst_0
    //   6103: istore 9
    //   6105: aload 20
    //   6107: ldc 118
    //   6109: invokevirtual 1256	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6112: ifeq +6 -> 6118
    //   6115: iconst_0
    //   6116: istore 8
    //   6118: aload 20
    //   6120: ldc 121
    //   6122: invokevirtual 1256	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6125: ifeq +4230 -> 10355
    //   6128: iconst_0
    //   6129: istore 7
    //   6131: goto +4224 -> 10355
    //   6134: aload_0
    //   6135: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6138: aload_3
    //   6139: aload_1
    //   6140: aload_1
    //   6141: aconst_null
    //   6142: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6145: iload 4
    //   6147: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6150: goto -4785 -> 1365
    //   6153: aload_0
    //   6154: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6157: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6160: invokevirtual 1260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   6163: ifnull +111 -> 6274
    //   6166: aload_0
    //   6167: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6170: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6173: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6176: ifnull +98 -> 6274
    //   6179: iload 10
    //   6181: ifne +17 -> 6198
    //   6184: aload_0
    //   6185: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6188: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6191: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6194: iconst_0
    //   6195: putfield 1267	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   6198: iload 9
    //   6200: ifne +17 -> 6217
    //   6203: aload_0
    //   6204: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6207: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6210: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6213: iconst_0
    //   6214: putfield 1268	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   6217: iload 8
    //   6219: ifne +17 -> 6236
    //   6222: aload_0
    //   6223: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6226: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6229: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6232: iconst_0
    //   6233: putfield 1269	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   6236: iload 7
    //   6238: ifne +17 -> 6255
    //   6241: aload_0
    //   6242: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6245: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6248: invokevirtual 1264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6251: iconst_0
    //   6252: putfield 1270	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   6255: aload_0
    //   6256: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6259: aload_3
    //   6260: aload_1
    //   6261: aload_1
    //   6262: aconst_null
    //   6263: invokestatic 870	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6266: iload 4
    //   6268: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6271: goto -4906 -> 1365
    //   6274: aload_0
    //   6275: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6278: aload_3
    //   6279: aload_1
    //   6280: aload_1
    //   6281: aconst_null
    //   6282: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6285: iload 4
    //   6287: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6290: goto -4925 -> 1365
    //   6293: ldc_w 1433
    //   6296: aload_1
    //   6297: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6300: ifeq +298 -> 6598
    //   6303: invokestatic 399	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6306: invokevirtual 977	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6309: astore 20
    //   6311: aload 20
    //   6313: instanceof 979
    //   6316: ifeq +3871 -> 10187
    //   6319: aload 20
    //   6321: checkcast 979	com/tencent/mobileqq/mini/MiniAppInterface
    //   6324: astore 20
    //   6326: aload 20
    //   6328: ifnonnull +18 -> 6346
    //   6331: aload_0
    //   6332: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6335: aload_3
    //   6336: aload_1
    //   6337: aconst_null
    //   6338: iload 4
    //   6340: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6343: goto -4978 -> 1365
    //   6346: new 271	org/json/JSONObject
    //   6349: dup
    //   6350: aload_2
    //   6351: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6354: ldc_w 1435
    //   6357: invokevirtual 1438	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6360: iconst_0
    //   6361: invokevirtual 1253	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6364: astore 22
    //   6366: aload 22
    //   6368: astore 21
    //   6370: aload 22
    //   6372: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6375: ifne +10 -> 6385
    //   6378: aload 22
    //   6380: invokevirtual 1441	java/lang/String:trim	()Ljava/lang/String;
    //   6383: astore 21
    //   6385: aload 20
    //   6387: aload_0
    //   6388: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6391: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6394: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6397: invokevirtual 983	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   6400: astore 20
    //   6402: aload 20
    //   6404: ifnull +179 -> 6583
    //   6407: aload 21
    //   6409: invokestatic 1444	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   6412: ifeq +171 -> 6583
    //   6415: aload 20
    //   6417: invokevirtual 1447	com/tencent/mobileqq/mini/app/AuthorizeCenter:isAuthorizeSynchronized	()Z
    //   6420: istore 15
    //   6422: aload 21
    //   6424: ldc_w 1449
    //   6427: invokevirtual 1317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6430: ifeq +59 -> 6489
    //   6433: iload 15
    //   6435: ifne +54 -> 6489
    //   6438: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6441: aconst_null
    //   6442: aload_0
    //   6443: invokevirtual 1452	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   6446: new 1454	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13
    //   6449: dup
    //   6450: aload_0
    //   6451: aload 20
    //   6453: aload 21
    //   6455: aload_3
    //   6456: aload_1
    //   6457: iload 4
    //   6459: aload_2
    //   6460: invokespecial 1457	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILjava/lang/String;)V
    //   6463: invokevirtual 1461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getAuthList	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6466: goto -5101 -> 1365
    //   6469: astore_2
    //   6470: aload_2
    //   6471: invokevirtual 391	java/lang/Throwable:printStackTrace	()V
    //   6474: aload_0
    //   6475: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6478: aload_3
    //   6479: aload_1
    //   6480: aconst_null
    //   6481: iload 4
    //   6483: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6486: goto -5121 -> 1365
    //   6489: aload 20
    //   6491: aload 21
    //   6493: invokevirtual 1464	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   6496: istore 8
    //   6498: iload 8
    //   6500: istore 7
    //   6502: iload 8
    //   6504: iconst_1
    //   6505: if_icmpne +42 -> 6547
    //   6508: aload_0
    //   6509: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6512: invokevirtual 1467	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   6515: ifne +3849 -> 10364
    //   6518: aload_0
    //   6519: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6522: astore 20
    //   6524: iload 8
    //   6526: istore 7
    //   6528: aload_0
    //   6529: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6532: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6535: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6538: invokestatic 1470	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   6541: ifeq +6 -> 6547
    //   6544: goto +3820 -> 10364
    //   6547: iload 7
    //   6549: iconst_2
    //   6550: if_icmpne +18 -> 6568
    //   6553: aload_0
    //   6554: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6557: aload_3
    //   6558: aload_1
    //   6559: aconst_null
    //   6560: iload 4
    //   6562: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6565: goto -5200 -> 1365
    //   6568: aload_0
    //   6569: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6572: aload_1
    //   6573: aload_2
    //   6574: aload_3
    //   6575: iload 4
    //   6577: invokevirtual 1474	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:reqAuthorize	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   6580: goto -5215 -> 1365
    //   6583: aload_0
    //   6584: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6587: aload_3
    //   6588: aload_1
    //   6589: aconst_null
    //   6590: iload 4
    //   6592: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6595: goto -5230 -> 1365
    //   6598: ldc 56
    //   6600: aload_1
    //   6601: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6604: ifeq +165 -> 6769
    //   6607: new 271	org/json/JSONObject
    //   6610: dup
    //   6611: aload_2
    //   6612: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6615: astore_1
    //   6616: ldc 139
    //   6618: iconst_2
    //   6619: new 321	java/lang/StringBuilder
    //   6622: dup
    //   6623: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   6626: ldc_w 1476
    //   6629: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6632: aload_1
    //   6633: invokevirtual 884	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6636: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6639: invokestatic 600	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6642: new 512	android/content/Intent
    //   6645: dup
    //   6646: invokespecial 1477	android/content/Intent:<init>	()V
    //   6649: astore_2
    //   6650: aload_2
    //   6651: new 1479	android/content/ComponentName
    //   6654: dup
    //   6655: aload_0
    //   6656: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6659: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6662: getfield 1483	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6665: ldc_w 1485
    //   6668: invokespecial 1486	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6671: invokevirtual 1490	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   6674: pop
    //   6675: aload_2
    //   6676: ldc_w 1492
    //   6679: aload_1
    //   6680: ldc_w 1492
    //   6683: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6686: invokevirtual 523	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6689: pop
    //   6690: aload_2
    //   6691: ldc_w 1494
    //   6694: sipush 1008
    //   6697: invokevirtual 1497	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6700: pop
    //   6701: aload_2
    //   6702: ldc_w 1499
    //   6705: iconst_2
    //   6706: invokevirtual 1497	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6709: pop
    //   6710: aload_2
    //   6711: ldc_w 1501
    //   6714: aload_1
    //   6715: ldc_w 1503
    //   6718: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6721: invokevirtual 523	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6724: pop
    //   6725: aload_2
    //   6726: ldc_w 1504
    //   6729: invokevirtual 1508	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   6732: pop
    //   6733: aload_0
    //   6734: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6737: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6740: getfield 1483	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6743: aload_2
    //   6744: invokevirtual 948	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   6747: goto -5382 -> 1365
    //   6750: astore_1
    //   6751: ldc 139
    //   6753: iconst_1
    //   6754: aload_1
    //   6755: iconst_0
    //   6756: anewarray 633	java/lang/Object
    //   6759: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   6762: aload_1
    //   6763: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   6766: goto -5401 -> 1365
    //   6769: ldc 11
    //   6771: aload_1
    //   6772: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6775: ifeq +61 -> 6836
    //   6778: new 271	org/json/JSONObject
    //   6781: dup
    //   6782: aload_2
    //   6783: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6786: astore_2
    //   6787: new 1510	Wallet/FocusMpIdReq
    //   6790: dup
    //   6791: invokestatic 399	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6794: invokevirtual 977	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6797: invokevirtual 1040	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6800: aload_2
    //   6801: ldc_w 1512
    //   6804: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6807: invokespecial 1513	Wallet/FocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   6810: new 1515	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14
    //   6813: dup
    //   6814: aload_0
    //   6815: aload_3
    //   6816: aload_1
    //   6817: iload 4
    //   6819: invokespecial 1516	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   6822: invokestatic 1050	aivh:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   6825: goto -5460 -> 1365
    //   6828: astore_1
    //   6829: aload_1
    //   6830: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   6833: goto -5468 -> 1365
    //   6836: ldc_w 1518
    //   6839: aload_1
    //   6840: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6843: ifeq +34 -> 6877
    //   6846: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6849: aload_0
    //   6850: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6853: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6856: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6859: new 1520	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15
    //   6862: dup
    //   6863: aload_0
    //   6864: aload_3
    //   6865: aload_1
    //   6866: iload 4
    //   6868: invokespecial 1521	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   6871: invokevirtual 1524	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getFormId	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6874: goto -5509 -> 1365
    //   6877: ldc 109
    //   6879: aload_1
    //   6880: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6883: ifeq +149 -> 7032
    //   6886: aload_0
    //   6887: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6890: ifnonnull +7 -> 6897
    //   6893: ldc_w 631
    //   6896: areturn
    //   6897: new 271	org/json/JSONObject
    //   6900: dup
    //   6901: aload_2
    //   6902: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6905: ldc_w 1525
    //   6908: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6911: astore_2
    //   6912: invokestatic 1531	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   6915: aload_0
    //   6916: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6919: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6922: getfield 1483	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6925: invokevirtual 1535	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   6928: astore_1
    //   6929: aload_1
    //   6930: ifnull +3440 -> 10370
    //   6933: aload_1
    //   6934: invokevirtual 1541	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getMiniGamePkg	()Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;
    //   6937: astore_1
    //   6938: aload_2
    //   6939: aload_1
    //   6940: invokestatic 1547	com/tencent/mobileqq/mini/entry/MiniAppUtils:checkNavigationAppIdListForMiniGame	(Ljava/lang/String;Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;)Z
    //   6943: istore 15
    //   6945: new 271	org/json/JSONObject
    //   6948: dup
    //   6949: invokespecial 796	org/json/JSONObject:<init>	()V
    //   6952: astore_1
    //   6953: aload_1
    //   6954: ldc_w 1549
    //   6957: iload 15
    //   6959: invokevirtual 1552	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   6962: pop
    //   6963: ldc 139
    //   6965: iconst_2
    //   6966: new 321	java/lang/StringBuilder
    //   6969: dup
    //   6970: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   6973: ldc_w 1554
    //   6976: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6979: aload_1
    //   6980: invokevirtual 884	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6983: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6986: invokestatic 600	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6989: aload_1
    //   6990: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   6993: areturn
    //   6994: astore_2
    //   6995: ldc 139
    //   6997: iconst_1
    //   6998: aload_2
    //   6999: iconst_0
    //   7000: anewarray 633	java/lang/Object
    //   7003: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7006: aload_2
    //   7007: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   7010: goto -47 -> 6963
    //   7013: astore_1
    //   7014: ldc 139
    //   7016: iconst_1
    //   7017: aload_1
    //   7018: iconst_0
    //   7019: anewarray 633	java/lang/Object
    //   7022: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7025: aload_1
    //   7026: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   7029: goto -5664 -> 1365
    //   7032: ldc_w 1556
    //   7035: aload_1
    //   7036: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7039: ifeq +222 -> 7261
    //   7042: invokestatic 399	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7045: invokevirtual 977	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   7048: astore_1
    //   7049: aload_1
    //   7050: instanceof 979
    //   7053: ifeq +3129 -> 10182
    //   7056: aload_1
    //   7057: checkcast 979	com/tencent/mobileqq/mini/MiniAppInterface
    //   7060: astore_1
    //   7061: aload_0
    //   7062: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7065: ifnull +7 -> 7072
    //   7068: aload_1
    //   7069: ifnonnull +26 -> 7095
    //   7072: aload_0
    //   7073: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7076: aload_3
    //   7077: ldc_w 1557
    //   7080: aconst_null
    //   7081: ldc_w 1558
    //   7084: invokestatic 1562	alud:a	(I)Ljava/lang/String;
    //   7087: iload 4
    //   7089: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7092: goto -5727 -> 1365
    //   7095: aload_1
    //   7096: aload_0
    //   7097: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7100: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7103: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7106: invokevirtual 983	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   7109: astore_1
    //   7110: aload_1
    //   7111: ifnull +121 -> 7232
    //   7114: ldc_w 1564
    //   7117: invokestatic 1444	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   7120: ifeq +112 -> 7232
    //   7123: aload_1
    //   7124: ldc_w 1564
    //   7127: invokevirtual 1464	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   7130: istore 8
    //   7132: iload 8
    //   7134: istore 7
    //   7136: iload 8
    //   7138: iconst_1
    //   7139: if_icmpne +41 -> 7180
    //   7142: aload_0
    //   7143: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7146: invokevirtual 1467	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   7149: ifne +28 -> 7177
    //   7152: aload_0
    //   7153: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7156: astore_1
    //   7157: iload 8
    //   7159: istore 7
    //   7161: aload_0
    //   7162: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7165: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7168: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7171: invokestatic 1470	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   7174: ifeq +6 -> 7180
    //   7177: iconst_2
    //   7178: istore 7
    //   7180: iload 7
    //   7182: iconst_2
    //   7183: if_icmpne +20 -> 7203
    //   7186: aload_0
    //   7187: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7190: aload_3
    //   7191: ldc_w 1557
    //   7194: aconst_null
    //   7195: iload 4
    //   7197: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7200: goto -5835 -> 1365
    //   7203: ldc 139
    //   7205: iconst_1
    //   7206: ldc_w 1566
    //   7209: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7212: aload_0
    //   7213: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7216: aload_3
    //   7217: ldc_w 1557
    //   7220: aconst_null
    //   7221: ldc_w 1566
    //   7224: iload 4
    //   7226: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7229: goto -5864 -> 1365
    //   7232: aload_0
    //   7233: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7236: aload_3
    //   7237: ldc_w 1557
    //   7240: aconst_null
    //   7241: ldc_w 1568
    //   7244: iload 4
    //   7246: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7249: ldc 139
    //   7251: iconst_1
    //   7252: ldc_w 1570
    //   7255: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7258: goto -5893 -> 1365
    //   7261: ldc_w 1572
    //   7264: aload_1
    //   7265: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7268: ifeq +213 -> 7481
    //   7271: new 271	org/json/JSONObject
    //   7274: dup
    //   7275: aload_2
    //   7276: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7279: astore 20
    //   7281: aload 20
    //   7283: ldc_w 1574
    //   7286: invokevirtual 1438	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7289: astore_2
    //   7290: aload 20
    //   7292: ldc_w 1023
    //   7295: ldc_w 1025
    //   7298: invokevirtual 965	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7301: astore 20
    //   7303: aload_2
    //   7304: ifnull -5939 -> 1365
    //   7307: aload_2
    //   7308: invokevirtual 1251	org/json/JSONArray:length	()I
    //   7311: ifle -5946 -> 1365
    //   7314: aload_2
    //   7315: invokevirtual 1251	org/json/JSONArray:length	()I
    //   7318: anewarray 363	java/lang/String
    //   7321: astore 21
    //   7323: iconst_0
    //   7324: istore 7
    //   7326: iload 7
    //   7328: aload_2
    //   7329: invokevirtual 1251	org/json/JSONArray:length	()I
    //   7332: if_icmpge +23 -> 7355
    //   7335: aload 21
    //   7337: iload 7
    //   7339: aload_2
    //   7340: iload 7
    //   7342: invokevirtual 1253	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   7345: aastore
    //   7346: iload 7
    //   7348: iconst_1
    //   7349: iadd
    //   7350: istore 7
    //   7352: goto -26 -> 7326
    //   7355: invokestatic 1531	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   7358: aload_0
    //   7359: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7362: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7365: getfield 1483	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   7368: invokevirtual 1535	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   7371: astore_2
    //   7372: aload_2
    //   7373: ifnonnull +26 -> 7399
    //   7376: aload_1
    //   7377: aconst_null
    //   7378: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   7381: astore_2
    //   7382: aload_0
    //   7383: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7386: aload_3
    //   7387: aload_1
    //   7388: aload_2
    //   7389: iload 4
    //   7391: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7394: aload_2
    //   7395: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7398: areturn
    //   7399: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7402: aload_2
    //   7403: invokevirtual 1578	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7406: invokevirtual 1581	com/tencent/mobileqq/minigame/manager/GameInfoManager:getAppId	()Ljava/lang/String;
    //   7409: aload 20
    //   7411: aload 21
    //   7413: new 1583	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16
    //   7416: dup
    //   7417: aload_0
    //   7418: aload_2
    //   7419: aload_3
    //   7420: aload_1
    //   7421: iload 4
    //   7423: invokespecial 1586	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7426: invokevirtual 1590	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoOpenData	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7429: goto -6064 -> 1365
    //   7432: astore_2
    //   7433: aload_0
    //   7434: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7437: aload_3
    //   7438: aload_1
    //   7439: aconst_null
    //   7440: iload 4
    //   7442: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7445: ldc 139
    //   7447: iconst_1
    //   7448: new 321	java/lang/StringBuilder
    //   7451: dup
    //   7452: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   7455: ldc_w 1592
    //   7458: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7461: aload_1
    //   7462: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7465: ldc_w 1594
    //   7468: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7471: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7474: aload_2
    //   7475: invokestatic 997	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7478: goto -6113 -> 1365
    //   7481: ldc 41
    //   7483: aload_1
    //   7484: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7487: ifeq +424 -> 7911
    //   7490: new 271	org/json/JSONObject
    //   7493: dup
    //   7494: aload_2
    //   7495: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7498: astore_2
    //   7499: aload_2
    //   7500: ldc_w 1596
    //   7503: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7506: astore 23
    //   7508: aload_2
    //   7509: ldc_w 1598
    //   7512: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7515: astore 24
    //   7517: aload_2
    //   7518: ldc_w 1600
    //   7521: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7524: astore 25
    //   7526: aload_2
    //   7527: ldc_w 1602
    //   7530: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7533: astore 21
    //   7535: aload_2
    //   7536: ldc_w 1604
    //   7539: invokevirtual 1607	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7542: istore 7
    //   7544: ldc_w 1609
    //   7547: aload 24
    //   7549: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7552: ifne +33 -> 7585
    //   7555: ldc_w 1611
    //   7558: aload 24
    //   7560: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7563: ifne +22 -> 7585
    //   7566: aload_0
    //   7567: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7570: aload_3
    //   7571: aload_1
    //   7572: aconst_null
    //   7573: ldc_w 1613
    //   7576: iload 4
    //   7578: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7581: ldc_w 631
    //   7584: areturn
    //   7585: ldc_w 1609
    //   7588: aload 23
    //   7590: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7593: ifne +33 -> 7626
    //   7596: ldc_w 1615
    //   7599: aload 23
    //   7601: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7604: ifne +22 -> 7626
    //   7607: aload_0
    //   7608: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7611: aload_3
    //   7612: aload_1
    //   7613: aconst_null
    //   7614: ldc_w 1617
    //   7617: iload 4
    //   7619: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7622: ldc_w 631
    //   7625: areturn
    //   7626: iload 7
    //   7628: ifgt +22 -> 7650
    //   7631: aload_0
    //   7632: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7635: aload_3
    //   7636: aload_1
    //   7637: aconst_null
    //   7638: ldc_w 1619
    //   7641: iload 4
    //   7643: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7646: ldc_w 631
    //   7649: areturn
    //   7650: aload 21
    //   7652: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7655: ifeq +22 -> 7677
    //   7658: aload_0
    //   7659: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7662: aload_3
    //   7663: aload_1
    //   7664: aconst_null
    //   7665: ldc_w 1621
    //   7668: iload 4
    //   7670: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7673: ldc_w 631
    //   7676: areturn
    //   7677: new 1623	android/graphics/Paint
    //   7680: dup
    //   7681: invokespecial 1624	android/graphics/Paint:<init>	()V
    //   7684: astore 22
    //   7686: aload 22
    //   7688: iload 7
    //   7690: i2f
    //   7691: invokevirtual 1628	android/graphics/Paint:setTextSize	(F)V
    //   7694: aconst_null
    //   7695: astore 20
    //   7697: ldc_w 1609
    //   7700: aload 23
    //   7702: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7705: ifeq +68 -> 7773
    //   7708: ldc_w 1609
    //   7711: aload 24
    //   7713: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7716: ifeq +33 -> 7749
    //   7719: aload 25
    //   7721: iconst_0
    //   7722: invokestatic 1634	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7725: astore_2
    //   7726: aload_2
    //   7727: ifnonnull +105 -> 7832
    //   7730: aload_0
    //   7731: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7734: aload_3
    //   7735: aload_1
    //   7736: aconst_null
    //   7737: ldc_w 1636
    //   7740: iload 4
    //   7742: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7745: ldc_w 631
    //   7748: areturn
    //   7749: aload 20
    //   7751: astore_2
    //   7752: ldc_w 1611
    //   7755: aload 24
    //   7757: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7760: ifeq -34 -> 7726
    //   7763: aload 25
    //   7765: iconst_1
    //   7766: invokestatic 1634	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7769: astore_2
    //   7770: goto -44 -> 7726
    //   7773: aload 20
    //   7775: astore_2
    //   7776: ldc_w 1615
    //   7779: aload 23
    //   7781: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7784: ifeq -58 -> 7726
    //   7787: ldc_w 1609
    //   7790: aload 24
    //   7792: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7795: ifeq +13 -> 7808
    //   7798: aload 25
    //   7800: iconst_2
    //   7801: invokestatic 1634	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7804: astore_2
    //   7805: goto -79 -> 7726
    //   7808: aload 20
    //   7810: astore_2
    //   7811: ldc_w 1611
    //   7814: aload 24
    //   7816: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7819: ifeq -93 -> 7726
    //   7822: aload 25
    //   7824: iconst_3
    //   7825: invokestatic 1634	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7828: astore_2
    //   7829: goto -103 -> 7726
    //   7832: new 1638	android/graphics/Rect
    //   7835: dup
    //   7836: invokespecial 1639	android/graphics/Rect:<init>	()V
    //   7839: astore_2
    //   7840: aload 22
    //   7842: aload 21
    //   7844: iconst_0
    //   7845: aload 21
    //   7847: invokevirtual 1640	java/lang/String:length	()I
    //   7850: aload_2
    //   7851: invokevirtual 1644	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   7854: aload_0
    //   7855: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7858: aload_3
    //   7859: aload_1
    //   7860: aconst_null
    //   7861: iload 4
    //   7863: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7866: new 321	java/lang/StringBuilder
    //   7869: dup
    //   7870: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   7873: ldc_w 631
    //   7876: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7879: aload_2
    //   7880: invokevirtual 1647	android/graphics/Rect:height	()I
    //   7883: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7886: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7889: astore_2
    //   7890: aload_2
    //   7891: areturn
    //   7892: astore_2
    //   7893: aload_0
    //   7894: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7897: aload_3
    //   7898: aload_1
    //   7899: aconst_null
    //   7900: ldc_w 1649
    //   7903: iload 4
    //   7905: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7908: goto -6543 -> 1365
    //   7911: ldc_w 1651
    //   7914: aload_1
    //   7915: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7918: ifeq +28 -> 7946
    //   7921: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7924: aload_0
    //   7925: invokevirtual 1452	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   7928: new 1653	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17
    //   7931: dup
    //   7932: aload_0
    //   7933: aload_3
    //   7934: aload_1
    //   7935: iload 4
    //   7937: invokespecial 1654	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7940: invokevirtual 1656	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoExtra	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7943: goto -6578 -> 1365
    //   7946: ldc 23
    //   7948: aload_1
    //   7949: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7952: ifeq +323 -> 8275
    //   7955: aload_0
    //   7956: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   7959: ifeq -6594 -> 1365
    //   7962: invokestatic 1531	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   7965: aload_0
    //   7966: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7969: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7972: getfield 1483	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   7975: invokevirtual 1535	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   7978: astore 20
    //   7980: aload 20
    //   7982: ifnonnull +26 -> 8008
    //   7985: aload_1
    //   7986: aconst_null
    //   7987: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   7990: astore_2
    //   7991: aload_0
    //   7992: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7995: aload_3
    //   7996: aload_1
    //   7997: aload_2
    //   7998: iload 4
    //   8000: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8003: aload_2
    //   8004: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8007: areturn
    //   8008: aload 20
    //   8010: invokevirtual 1578	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8013: invokevirtual 1660	com/tencent/mobileqq/minigame/manager/GameInfoManager:getLaunchOptions	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions;
    //   8016: astore 21
    //   8018: new 271	org/json/JSONObject
    //   8021: dup
    //   8022: invokespecial 796	org/json/JSONObject:<init>	()V
    //   8025: astore 22
    //   8027: new 271	org/json/JSONObject
    //   8030: dup
    //   8031: invokespecial 796	org/json/JSONObject:<init>	()V
    //   8034: astore 23
    //   8036: aload 21
    //   8038: getfield 1665	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8041: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8044: ifeq +170 -> 8214
    //   8047: aconst_null
    //   8048: astore_2
    //   8049: aload 23
    //   8051: ldc_w 1525
    //   8054: aload_2
    //   8055: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8058: pop
    //   8059: aload 21
    //   8061: getfield 1668	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8064: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8067: ifeq +156 -> 8223
    //   8070: aconst_null
    //   8071: astore_2
    //   8072: aload 23
    //   8074: ldc_w 1670
    //   8077: aload_2
    //   8078: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8081: pop
    //   8082: aload 22
    //   8084: ldc_w 1671
    //   8087: aload 21
    //   8089: getfield 1672	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:scene	I
    //   8092: invokestatic 1678	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getWikiScene	(I)I
    //   8095: invokevirtual 822	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   8098: pop
    //   8099: aload 22
    //   8101: ldc_w 1300
    //   8104: aload 21
    //   8106: getfield 1681	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:query	Lorg/json/JSONObject;
    //   8109: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8112: pop
    //   8113: aload 21
    //   8115: getfield 1683	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8118: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8121: ifeq +111 -> 8232
    //   8124: aconst_null
    //   8125: astore_2
    //   8126: aload 22
    //   8128: ldc_w 1192
    //   8131: aload_2
    //   8132: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8135: pop
    //   8136: aload 22
    //   8138: ldc_w 1685
    //   8141: aload 23
    //   8143: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8146: pop
    //   8147: aload 22
    //   8149: ldc_w 1687
    //   8152: aload 20
    //   8154: invokevirtual 1578	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8157: invokevirtual 1690	com/tencent/mobileqq/minigame/manager/GameInfoManager:getExtendData	()Ljava/lang/String;
    //   8160: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8163: pop
    //   8164: aload 22
    //   8166: ldc_w 1325
    //   8169: aload 21
    //   8171: getfield 1692	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:entryDataHash	Ljava/lang/String;
    //   8174: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8177: pop
    //   8178: ldc 139
    //   8180: iconst_1
    //   8181: new 321	java/lang/StringBuilder
    //   8184: dup
    //   8185: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   8188: ldc_w 1694
    //   8191: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8194: aload 22
    //   8196: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8199: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8202: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8205: invokestatic 372	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8208: aload 22
    //   8210: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8213: areturn
    //   8214: aload 21
    //   8216: getfield 1665	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8219: astore_2
    //   8220: goto -171 -> 8049
    //   8223: aload 21
    //   8225: getfield 1668	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8228: astore_2
    //   8229: goto -157 -> 8072
    //   8232: aload 21
    //   8234: getfield 1683	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8237: astore_2
    //   8238: goto -112 -> 8126
    //   8241: astore_2
    //   8242: ldc 139
    //   8244: iconst_1
    //   8245: ldc_w 1696
    //   8248: aload_2
    //   8249: invokestatic 997	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8252: aload_1
    //   8253: aconst_null
    //   8254: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8257: astore_1
    //   8258: aload_3
    //   8259: iload 4
    //   8261: aload_1
    //   8262: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8265: invokeinterface 876 3 0
    //   8270: aload_1
    //   8271: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8274: areturn
    //   8275: ldc 53
    //   8277: aload_1
    //   8278: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8281: ifeq +648 -> 8929
    //   8284: new 271	org/json/JSONObject
    //   8287: dup
    //   8288: aload_2
    //   8289: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8292: astore_2
    //   8293: ldc 139
    //   8295: iconst_1
    //   8296: new 321	java/lang/StringBuilder
    //   8299: dup
    //   8300: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   8303: ldc_w 1698
    //   8306: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8309: aload_2
    //   8310: invokevirtual 884	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8313: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8316: invokestatic 600	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8319: aload_2
    //   8320: ldc_w 519
    //   8323: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8326: astore 22
    //   8328: aload 22
    //   8330: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8333: ifeq +20 -> 8353
    //   8336: aload_0
    //   8337: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8340: aload_3
    //   8341: aload_1
    //   8342: aconst_null
    //   8343: ldc_w 1700
    //   8346: iload 4
    //   8348: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8351: aconst_null
    //   8352: areturn
    //   8353: aload_2
    //   8354: ldc_w 1702
    //   8357: iconst_0
    //   8358: invokevirtual 971	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8361: istore 15
    //   8363: aload 22
    //   8365: invokevirtual 1705	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   8368: astore 20
    //   8370: aload 20
    //   8372: invokestatic 1711	com/tencent/mobileqq/mini/apkg/DomainConfig:getDomainConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/DomainConfig;
    //   8375: astore 21
    //   8377: iload 15
    //   8379: ifne +78 -> 8457
    //   8382: aload_0
    //   8383: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8386: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8389: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   8392: aload 20
    //   8394: iconst_0
    //   8395: invokevirtual 1714	com/tencent/mobileqq/mini/apkg/ApkgInfo:isValidPrefix	(Ljava/lang/String;Z)Z
    //   8398: ifne +20 -> 8418
    //   8401: aload_0
    //   8402: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8405: aload_3
    //   8406: aload_1
    //   8407: aconst_null
    //   8408: ldc_w 1716
    //   8411: iload 4
    //   8413: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8416: aconst_null
    //   8417: areturn
    //   8418: aload_0
    //   8419: getfield 343	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8422: ifnull +35 -> 8457
    //   8425: aload_0
    //   8426: getfield 343	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8429: aload 21
    //   8431: getfield 1719	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8434: invokevirtual 1722	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   8437: ifne +20 -> 8457
    //   8440: aload_0
    //   8441: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8444: aload_3
    //   8445: aload_1
    //   8446: aconst_null
    //   8447: ldc_w 1724
    //   8450: iload 4
    //   8452: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8455: aconst_null
    //   8456: areturn
    //   8457: ldc_w 1726
    //   8460: aload 21
    //   8462: getfield 1719	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8465: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8468: ifeq +438 -> 8906
    //   8471: ldc_w 1728
    //   8474: ldc_w 1730
    //   8477: invokestatic 1735	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8480: astore_2
    //   8481: aload 22
    //   8483: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8486: ifne +402 -> 8888
    //   8489: aload_0
    //   8490: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8493: ifnull +395 -> 8888
    //   8496: aload_0
    //   8497: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8500: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8503: ifnull +385 -> 8888
    //   8506: invokestatic 1740	com/tencent/mobileqq/mini/mainpage/MainPageFragment:getUin	()Ljava/lang/String;
    //   8509: astore 21
    //   8511: aload 21
    //   8513: ifnonnull +1862 -> 10375
    //   8516: ldc_w 631
    //   8519: astore 20
    //   8521: aload 22
    //   8523: ldc_w 1742
    //   8526: aload 20
    //   8528: invokevirtual 1746	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8531: ldc_w 1748
    //   8534: invokestatic 841	bdgk:c	()Ljava/lang/String;
    //   8537: invokevirtual 1746	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8540: ldc_w 1750
    //   8543: ldc_w 1752
    //   8546: invokevirtual 1746	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8549: ldc_w 1754
    //   8552: getstatic 641	android/os/Build$VERSION:SDK_INT	I
    //   8555: invokestatic 1110	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   8558: invokevirtual 1746	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8561: ldc_w 1756
    //   8564: invokestatic 1760	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8567: invokestatic 1765	bdin:a	(Landroid/content/Context;)Ljava/lang/String;
    //   8570: invokevirtual 1746	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8573: ldc_w 1767
    //   8576: aload_2
    //   8577: invokevirtual 1746	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8580: astore 22
    //   8582: invokestatic 399	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8585: new 321	java/lang/StringBuilder
    //   8588: dup
    //   8589: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   8592: getstatic 1773	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   8595: invokevirtual 1774	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   8598: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8601: aload 21
    //   8603: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8606: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8609: invokevirtual 1777	com/tencent/common/app/BaseApplicationImpl:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   8612: astore 20
    //   8614: aload 20
    //   8616: astore_2
    //   8617: aload 20
    //   8619: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8622: ifeq +7 -> 8629
    //   8625: ldc_w 631
    //   8628: astore_2
    //   8629: aload 22
    //   8631: ldc_w 1779
    //   8634: aload_2
    //   8635: invokevirtual 1746	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8638: astore_2
    //   8639: invokestatic 618	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8642: ifeq +29 -> 8671
    //   8645: ldc 139
    //   8647: iconst_2
    //   8648: new 321	java/lang/StringBuilder
    //   8651: dup
    //   8652: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   8655: ldc_w 1781
    //   8658: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8661: aload_2
    //   8662: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8665: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8668: invokestatic 600	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8671: new 512	android/content/Intent
    //   8674: dup
    //   8675: aload_0
    //   8676: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8679: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8682: getfield 1483	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8685: ldc_w 514
    //   8688: invokespecial 517	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8691: astore 20
    //   8693: aload 20
    //   8695: ldc_w 1783
    //   8698: ldc_w 1784
    //   8701: invokestatic 1562	alud:a	(I)Ljava/lang/String;
    //   8704: invokevirtual 523	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8707: pop
    //   8708: aload 20
    //   8710: ldc_w 528
    //   8713: iconst_1
    //   8714: invokevirtual 1787	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8717: pop
    //   8718: aload 20
    //   8720: ldc_w 1789
    //   8723: iconst_1
    //   8724: invokevirtual 1787	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8727: pop
    //   8728: aload 20
    //   8730: ldc_w 519
    //   8733: aload_2
    //   8734: invokevirtual 523	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8737: pop
    //   8738: aload_0
    //   8739: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8742: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8745: getfield 1483	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8748: aload 20
    //   8750: invokevirtual 948	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   8753: aload_0
    //   8754: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8757: aload_3
    //   8758: aload_1
    //   8759: aconst_null
    //   8760: iload 4
    //   8762: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8765: aload_2
    //   8766: ldc_w 1791
    //   8769: invokevirtual 1317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8772: ifeq -7407 -> 1365
    //   8775: ldc 139
    //   8777: iconst_2
    //   8778: ldc_w 1793
    //   8781: invokestatic 600	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8784: new 525	android/os/Bundle
    //   8787: dup
    //   8788: invokespecial 526	android/os/Bundle:<init>	()V
    //   8791: astore_1
    //   8792: aload_1
    //   8793: ldc_w 1795
    //   8796: aload_0
    //   8797: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8800: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8803: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   8806: invokevirtual 1180	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8809: invokestatic 1800	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   8812: ldc_w 1802
    //   8815: ldc_w 1804
    //   8818: aload_1
    //   8819: new 1806	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18
    //   8822: dup
    //   8823: aload_0
    //   8824: invokespecial 1809	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;)V
    //   8827: invokevirtual 1813	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   8830: goto -7465 -> 1365
    //   8833: astore_1
    //   8834: ldc 139
    //   8836: iconst_1
    //   8837: aload_1
    //   8838: iconst_0
    //   8839: anewarray 633	java/lang/Object
    //   8842: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   8845: goto -7480 -> 1365
    //   8848: astore_2
    //   8849: ldc 139
    //   8851: iconst_1
    //   8852: new 321	java/lang/StringBuilder
    //   8855: dup
    //   8856: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   8859: ldc_w 1815
    //   8862: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8865: ldc_w 631
    //   8868: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8871: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8874: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8877: aload_2
    //   8878: invokevirtual 1816	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   8881: ldc_w 631
    //   8884: astore_2
    //   8885: goto -404 -> 8481
    //   8888: aload_0
    //   8889: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8892: aload_3
    //   8893: aload_1
    //   8894: aconst_null
    //   8895: ldc_w 1818
    //   8898: iload 4
    //   8900: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8903: goto -7538 -> 1365
    //   8906: new 1820	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19
    //   8909: dup
    //   8910: aload_0
    //   8911: aload_2
    //   8912: aload_3
    //   8913: aload_1
    //   8914: iload 4
    //   8916: invokespecial 1823	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   8919: bipush 16
    //   8921: aconst_null
    //   8922: iconst_0
    //   8923: invokestatic 1827	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   8926: goto -7561 -> 1365
    //   8929: ldc 62
    //   8931: aload_1
    //   8932: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8935: ifeq +113 -> 9048
    //   8938: new 271	org/json/JSONObject
    //   8941: dup
    //   8942: aload_2
    //   8943: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8946: ldc_w 1829
    //   8949: iconst_0
    //   8950: invokevirtual 971	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8953: istore 15
    //   8955: aload_0
    //   8956: invokevirtual 1221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   8959: ifeq -7594 -> 1365
    //   8962: invokestatic 1531	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   8965: aload_0
    //   8966: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8969: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8972: getfield 1483	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8975: invokevirtual 1535	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   8978: astore_2
    //   8979: aload_2
    //   8980: ifnonnull +26 -> 9006
    //   8983: aload_1
    //   8984: aconst_null
    //   8985: invokestatic 887	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8988: astore_2
    //   8989: aload_0
    //   8990: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8993: aload_3
    //   8994: aload_1
    //   8995: aload_2
    //   8996: iload 4
    //   8998: invokevirtual 1000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9001: aload_2
    //   9002: invokevirtual 871	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9005: areturn
    //   9006: aload_2
    //   9007: invokevirtual 1578	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   9010: invokevirtual 1833	com/tencent/mobileqq/minigame/manager/GameInfoManager:getMiniAppConfig	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9013: iload 15
    //   9015: invokestatic 1839	com/tencent/mobileqq/minigame/gpkg/GpkgManager:setOfflineResourceContent	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Z)V
    //   9018: aload_0
    //   9019: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9022: aload_3
    //   9023: aload_1
    //   9024: aconst_null
    //   9025: iload 4
    //   9027: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9030: goto -7665 -> 1365
    //   9033: astore_1
    //   9034: ldc 139
    //   9036: iconst_1
    //   9037: aload_1
    //   9038: iconst_0
    //   9039: anewarray 633	java/lang/Object
    //   9042: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   9045: goto -7680 -> 1365
    //   9048: ldc 92
    //   9050: aload_1
    //   9051: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9054: ifeq +178 -> 9232
    //   9057: aload_0
    //   9058: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9061: ifnull -7696 -> 1365
    //   9064: new 374	java/util/ArrayList
    //   9067: dup
    //   9068: invokespecial 375	java/util/ArrayList:<init>	()V
    //   9071: astore 20
    //   9073: new 271	org/json/JSONObject
    //   9076: dup
    //   9077: aload_2
    //   9078: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9081: ldc_w 956
    //   9084: invokevirtual 960	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   9087: ldc_w 1841
    //   9090: invokevirtual 1438	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9093: astore_2
    //   9094: aload_2
    //   9095: ifnull +85 -> 9180
    //   9098: aload_2
    //   9099: invokevirtual 1251	org/json/JSONArray:length	()I
    //   9102: ifle +78 -> 9180
    //   9105: iconst_0
    //   9106: istore 7
    //   9108: iload 7
    //   9110: aload_2
    //   9111: invokevirtual 1251	org/json/JSONArray:length	()I
    //   9114: if_icmpge +66 -> 9180
    //   9117: aload_2
    //   9118: iload 7
    //   9120: invokevirtual 1844	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9123: checkcast 271	org/json/JSONObject
    //   9126: astore 21
    //   9128: new 1846	com/tencent/mobileqq/mini/apkg/PluginInfo
    //   9131: dup
    //   9132: invokespecial 1847	com/tencent/mobileqq/mini/apkg/PluginInfo:<init>	()V
    //   9135: astore 22
    //   9137: aload 22
    //   9139: aload 21
    //   9141: ldc_w 1849
    //   9144: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9147: invokevirtual 1852	com/tencent/mobileqq/mini/apkg/PluginInfo:setPluginId	(Ljava/lang/String;)V
    //   9150: aload 22
    //   9152: aload 21
    //   9154: ldc_w 1854
    //   9157: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9160: invokevirtual 1857	com/tencent/mobileqq/mini/apkg/PluginInfo:setInnerVersion	(Ljava/lang/String;)V
    //   9163: aload 20
    //   9165: aload 22
    //   9167: invokevirtual 388	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9170: pop
    //   9171: iload 7
    //   9173: iconst_1
    //   9174: iadd
    //   9175: istore 7
    //   9177: goto -69 -> 9108
    //   9180: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9183: aload_0
    //   9184: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9187: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9190: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9193: aload 20
    //   9195: new 1859	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20
    //   9198: dup
    //   9199: aload_0
    //   9200: aload_3
    //   9201: aload_1
    //   9202: iload 4
    //   9204: invokespecial 1860	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9207: invokevirtual 1863	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:verifyPlugin	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9210: goto -7845 -> 1365
    //   9213: astore_2
    //   9214: aload_0
    //   9215: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9218: aload_3
    //   9219: aload_1
    //   9220: aconst_null
    //   9221: ldc_w 1865
    //   9224: iload 4
    //   9226: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9229: goto -7864 -> 1365
    //   9232: ldc 14
    //   9234: aload_1
    //   9235: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9238: ifeq +127 -> 9365
    //   9241: aload_0
    //   9242: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9245: ifnull -7880 -> 1365
    //   9248: aload_2
    //   9249: ifnull -7884 -> 1365
    //   9252: new 271	org/json/JSONObject
    //   9255: dup
    //   9256: aload_2
    //   9257: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9260: ldc_w 1867
    //   9263: invokevirtual 1438	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9266: astore_2
    //   9267: new 374	java/util/ArrayList
    //   9270: dup
    //   9271: invokespecial 375	java/util/ArrayList:<init>	()V
    //   9274: astore 20
    //   9276: aload_2
    //   9277: ifnull +46 -> 9323
    //   9280: aload_2
    //   9281: invokevirtual 1251	org/json/JSONArray:length	()I
    //   9284: ifle +39 -> 9323
    //   9287: iconst_0
    //   9288: istore 7
    //   9290: iload 7
    //   9292: aload_2
    //   9293: invokevirtual 1251	org/json/JSONArray:length	()I
    //   9296: if_icmpge +27 -> 9323
    //   9299: aload 20
    //   9301: aload_2
    //   9302: iload 7
    //   9304: invokevirtual 1844	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9307: invokestatic 1870	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9310: invokevirtual 388	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9313: pop
    //   9314: iload 7
    //   9316: iconst_1
    //   9317: iadd
    //   9318: istore 7
    //   9320: goto -30 -> 9290
    //   9323: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9326: aload 20
    //   9328: new 1872	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21
    //   9331: dup
    //   9332: aload_0
    //   9333: aload_3
    //   9334: aload_1
    //   9335: iload 4
    //   9337: invokespecial 1873	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9340: invokevirtual 1876	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:batchGetContact	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9343: goto -7978 -> 1365
    //   9346: astore_2
    //   9347: aload_0
    //   9348: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9351: aload_3
    //   9352: aload_1
    //   9353: aconst_null
    //   9354: ldc_w 1878
    //   9357: iload 4
    //   9359: invokevirtual 428	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9362: goto -7997 -> 1365
    //   9365: ldc 26
    //   9367: aload_1
    //   9368: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9371: ifeq +60 -> 9431
    //   9374: new 271	org/json/JSONObject
    //   9377: dup
    //   9378: invokespecial 796	org/json/JSONObject:<init>	()V
    //   9381: astore_2
    //   9382: aload_2
    //   9383: ldc_w 288
    //   9386: aload_0
    //   9387: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9390: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9393: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9396: getfield 1879	com/tencent/mobileqq/mini/apkg/ApkgInfo:appId	Ljava/lang/String;
    //   9399: invokestatic 1884	com/tencent/mobileqq/mini/report/MiniReportManager:getLaunchPerformance	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9402: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   9405: pop
    //   9406: aload_0
    //   9407: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9410: aload_3
    //   9411: aload_1
    //   9412: aload_2
    //   9413: iload 4
    //   9415: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9418: goto -8053 -> 1365
    //   9421: astore 20
    //   9423: aload 20
    //   9425: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   9428: goto -22 -> 9406
    //   9431: ldc_w 1886
    //   9434: aload_1
    //   9435: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9438: ifeq +131 -> 9569
    //   9441: new 271	org/json/JSONObject
    //   9444: dup
    //   9445: invokespecial 796	org/json/JSONObject:<init>	()V
    //   9448: astore_2
    //   9449: aload_0
    //   9450: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9453: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9456: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9459: astore 20
    //   9461: iconst_0
    //   9462: istore 16
    //   9464: iload 16
    //   9466: istore 15
    //   9468: aload 20
    //   9470: ifnull +64 -> 9534
    //   9473: iload 16
    //   9475: istore 15
    //   9477: aload 20
    //   9479: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9482: ifnull +52 -> 9534
    //   9485: iload 16
    //   9487: istore 15
    //   9489: aload 20
    //   9491: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9494: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9497: ifnull +37 -> 9534
    //   9500: iload 16
    //   9502: istore 15
    //   9504: aload 20
    //   9506: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9509: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9512: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9515: ifnull +19 -> 9534
    //   9518: aload 20
    //   9520: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9523: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9526: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9529: getfield 1889	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9532: istore 15
    //   9534: aload_2
    //   9535: ldc_w 1891
    //   9538: iload 15
    //   9540: invokevirtual 1552	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9543: pop
    //   9544: aload_0
    //   9545: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9548: aload_3
    //   9549: aload_1
    //   9550: aload_2
    //   9551: iload 4
    //   9553: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9556: goto -8191 -> 1365
    //   9559: astore 20
    //   9561: aload 20
    //   9563: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   9566: goto -22 -> 9544
    //   9569: ldc_w 1893
    //   9572: aload_1
    //   9573: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9576: ifeq +293 -> 9869
    //   9579: new 271	org/json/JSONObject
    //   9582: dup
    //   9583: aload_2
    //   9584: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9587: ldc_w 1325
    //   9590: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9593: astore_2
    //   9594: aload_0
    //   9595: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9598: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9601: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9604: astore 20
    //   9606: new 271	org/json/JSONObject
    //   9609: dup
    //   9610: invokespecial 796	org/json/JSONObject:<init>	()V
    //   9613: astore 21
    //   9615: iconst_0
    //   9616: istore 16
    //   9618: iload 16
    //   9620: istore 15
    //   9622: aload 20
    //   9624: ifnull +64 -> 9688
    //   9627: iload 16
    //   9629: istore 15
    //   9631: aload 20
    //   9633: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9636: ifnull +52 -> 9688
    //   9639: iload 16
    //   9641: istore 15
    //   9643: aload 20
    //   9645: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9648: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9651: ifnull +37 -> 9688
    //   9654: iload 16
    //   9656: istore 15
    //   9658: aload 20
    //   9660: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9663: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9666: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9669: ifnull +19 -> 9688
    //   9672: aload 20
    //   9674: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9677: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9680: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9683: getfield 1889	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9686: istore 15
    //   9688: aload 21
    //   9690: ldc_w 1891
    //   9693: iload 15
    //   9695: invokevirtual 1552	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9698: pop
    //   9699: aload 20
    //   9701: ifnull +152 -> 9853
    //   9704: aload 20
    //   9706: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9709: ifnull +144 -> 9853
    //   9712: aload 20
    //   9714: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9717: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9720: ifnull +133 -> 9853
    //   9723: aload 20
    //   9725: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9728: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9731: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9734: ifnull +119 -> 9853
    //   9737: aload_2
    //   9738: ifnull +115 -> 9853
    //   9741: aload_2
    //   9742: aload 20
    //   9744: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9747: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9750: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9753: invokevirtual 1334	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   9756: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9759: ifeq +94 -> 9853
    //   9762: aload 20
    //   9764: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9767: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9770: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9773: getfield 1896	com/tencent/mobileqq/mini/sdk/EntryModel:type	I
    //   9776: iconst_1
    //   9777: if_icmpne +76 -> 9853
    //   9780: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9783: aconst_null
    //   9784: aload_0
    //   9785: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9788: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9791: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9794: aload 20
    //   9796: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9799: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9802: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9805: getfield 1899	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   9808: invokestatic 1902	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9811: aload 20
    //   9813: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9816: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9819: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9822: getfield 1905	com/tencent/mobileqq/mini/sdk/EntryModel:dwGroupClassExt	J
    //   9825: new 1907	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22
    //   9828: dup
    //   9829: aload_0
    //   9830: aload 21
    //   9832: aload_3
    //   9833: aload_1
    //   9834: iload 4
    //   9836: invokespecial 1908	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9839: invokevirtual 1912	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserGroupInfo	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9842: goto -8477 -> 1365
    //   9845: astore_1
    //   9846: aload_1
    //   9847: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   9850: goto -8485 -> 1365
    //   9853: aload_0
    //   9854: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9857: aload_3
    //   9858: aload_1
    //   9859: aload 21
    //   9861: iload 4
    //   9863: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9866: goto -8501 -> 1365
    //   9869: ldc_w 1914
    //   9872: aload_1
    //   9873: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9876: ifeq +193 -> 10069
    //   9879: new 271	org/json/JSONObject
    //   9882: dup
    //   9883: aload_2
    //   9884: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9887: astore 20
    //   9889: aload 20
    //   9891: ldc_w 1325
    //   9894: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9897: astore_2
    //   9898: aload 20
    //   9900: ldc_w 519
    //   9903: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9906: astore 20
    //   9908: aload_0
    //   9909: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9912: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9915: invokevirtual 564	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9918: astore 21
    //   9920: aload 21
    //   9922: ifnull -8557 -> 1365
    //   9925: aload 21
    //   9927: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9930: ifnull -8565 -> 1365
    //   9933: aload 21
    //   9935: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9938: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9941: ifnull -8576 -> 1365
    //   9944: aload 21
    //   9946: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9949: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9952: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9955: ifnull -8590 -> 1365
    //   9958: aload_2
    //   9959: ifnull -8594 -> 1365
    //   9962: aload_2
    //   9963: aload 21
    //   9965: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9968: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9971: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9974: invokevirtual 1334	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   9977: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9980: ifeq -8615 -> 1365
    //   9983: aload 21
    //   9985: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9988: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9991: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9994: getfield 1889	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9997: ifeq -8632 -> 1365
    //   10000: aload 20
    //   10002: ifnull -8637 -> 1365
    //   10005: aload 20
    //   10007: ldc_w 1916
    //   10010: invokevirtual 1918	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10013: ifeq -8648 -> 1365
    //   10016: aload 20
    //   10018: ldc_w 1916
    //   10021: aload 21
    //   10023: getfield 901	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10026: getfield 907	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10029: getfield 1329	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10032: getfield 1899	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   10035: invokestatic 1902	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   10038: invokevirtual 1746	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   10041: astore_2
    //   10042: aload_0
    //   10043: aload_0
    //   10044: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10047: getfield 1084	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   10050: aload_2
    //   10051: aload_3
    //   10052: aload_1
    //   10053: iload 4
    //   10055: invokespecial 1920	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startGroupBrowserActivity	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10058: goto -8693 -> 1365
    //   10061: astore_1
    //   10062: aload_1
    //   10063: invokevirtual 1064	org/json/JSONException:printStackTrace	()V
    //   10066: goto -8701 -> 1365
    //   10069: ldc_w 1922
    //   10072: aload_1
    //   10073: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10076: ifne +13 -> 10089
    //   10079: ldc_w 1924
    //   10082: aload_1
    //   10083: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10086: ifeq +18 -> 10104
    //   10089: aload_0
    //   10090: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10093: aload_3
    //   10094: aload_1
    //   10095: aconst_null
    //   10096: iload 4
    //   10098: invokevirtual 1063	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   10101: goto -8736 -> 1365
    //   10104: ldc 20
    //   10106: aload_1
    //   10107: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10110: ifeq -8745 -> 1365
    //   10113: new 271	org/json/JSONObject
    //   10116: dup
    //   10117: aload_2
    //   10118: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10121: ldc_w 1926
    //   10124: invokevirtual 931	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10127: astore_2
    //   10128: aload_2
    //   10129: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10132: ifne -8767 -> 1365
    //   10135: invokestatic 459	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   10138: aload_0
    //   10139: getfield 411	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10142: getfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   10145: getfield 468	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   10148: aconst_null
    //   10149: aload_2
    //   10150: new 1928	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23
    //   10153: dup
    //   10154: aload_0
    //   10155: aload_3
    //   10156: aload_1
    //   10157: iload 4
    //   10159: invokespecial 1929	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10162: invokevirtual 1933	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getTcbTicket	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   10165: goto -8800 -> 1365
    //   10168: astore_1
    //   10169: ldc 139
    //   10171: iconst_1
    //   10172: ldc_w 1935
    //   10175: aload_1
    //   10176: invokestatic 997	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10179: goto -8814 -> 1365
    //   10182: aconst_null
    //   10183: astore_1
    //   10184: goto -3123 -> 7061
    //   10187: aconst_null
    //   10188: astore 20
    //   10190: goto -3864 -> 6326
    //   10193: goto -4229 -> 5964
    //   10196: aconst_null
    //   10197: astore_2
    //   10198: goto -6156 -> 4042
    //   10201: iload 9
    //   10203: istore 14
    //   10205: goto -7007 -> 3198
    //   10208: iconst_0
    //   10209: istore 15
    //   10211: goto -9670 -> 541
    //   10214: ldc_w 764
    //   10217: astore 21
    //   10219: goto -9785 -> 434
    //   10222: iconst_m1
    //   10223: istore 8
    //   10225: iconst_m1
    //   10226: istore 7
    //   10228: iconst_m1
    //   10229: istore 11
    //   10231: iconst_0
    //   10232: istore 10
    //   10234: goto -7153 -> 3081
    //   10237: iload 7
    //   10239: istore 8
    //   10241: iload 7
    //   10243: iconst_m1
    //   10244: if_icmpne -6161 -> 4083
    //   10247: iconst_0
    //   10248: istore 8
    //   10250: goto -6167 -> 4083
    //   10253: ldc_w 631
    //   10256: areturn
    //   10257: iload 9
    //   10259: iconst_1
    //   10260: if_icmpne -5922 -> 4338
    //   10263: iconst_1
    //   10264: istore 7
    //   10266: aconst_null
    //   10267: astore_2
    //   10268: goto -6226 -> 4042
    //   10271: iload 9
    //   10273: iconst_3
    //   10274: if_icmpne +11 -> 10285
    //   10277: iconst_3
    //   10278: istore 7
    //   10280: aconst_null
    //   10281: astore_2
    //   10282: goto -6240 -> 4042
    //   10285: iload 9
    //   10287: iconst_4
    //   10288: if_icmpne -5820 -> 4468
    //   10291: iconst_4
    //   10292: istore 7
    //   10294: aconst_null
    //   10295: astore_2
    //   10296: goto -6254 -> 4042
    //   10299: iconst_0
    //   10300: istore 7
    //   10302: goto -6260 -> 4042
    //   10305: iconst_1
    //   10306: istore 16
    //   10308: goto -5350 -> 4958
    //   10311: iconst_0
    //   10312: istore 16
    //   10314: goto -5356 -> 4958
    //   10317: iconst_0
    //   10318: istore 17
    //   10320: goto -5313 -> 5007
    //   10323: bipush 12
    //   10325: istore 4
    //   10327: goto -5273 -> 5054
    //   10330: bipush 12
    //   10332: istore 4
    //   10334: goto -5081 -> 5253
    //   10337: iconst_1
    //   10338: istore 4
    //   10340: goto -4777 -> 5563
    //   10343: iconst_0
    //   10344: istore 4
    //   10346: goto -4783 -> 5563
    //   10349: iconst_0
    //   10350: istore 8
    //   10352: goto -4738 -> 5614
    //   10355: iload 11
    //   10357: iconst_1
    //   10358: iadd
    //   10359: istore 11
    //   10361: goto -4299 -> 6062
    //   10364: iconst_2
    //   10365: istore 7
    //   10367: goto -3820 -> 6547
    //   10370: aconst_null
    //   10371: astore_1
    //   10372: goto -3434 -> 6938
    //   10375: aload 21
    //   10377: astore 20
    //   10379: goto -1858 -> 8521
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10382	0	this	DataJsPlugin
    //   0	10382	1	paramString1	String
    //   0	10382	2	paramString2	String
    //   0	10382	3	paramJsRuntime	JsRuntime
    //   0	10382	4	paramInt	int
    //   208	479	5	d	double
    //   250	10116	7	i	int
    //   246	10105	8	j	int
    //   227	10062	9	k	int
    //   291	9942	10	m	int
    //   308	10052	11	n	int
    //   2935	474	12	i1	int
    //   2932	457	13	i2	int
    //   3196	7008	14	i3	int
    //   539	9671	15	bool1	boolean
    //   201	10112	16	bool2	boolean
    //   5005	5314	17	bool3	boolean
    //   2139	299	18	l	long
    //   328	1669	20	localObject1	Object
    //   2017	3	20	localJSONException1	org.json.JSONException
    //   2238	7089	20	localObject2	Object
    //   9421	3	20	localJSONException2	org.json.JSONException
    //   9459	60	20	localApkgInfo1	com.tencent.mobileqq.mini.apkg.ApkgInfo
    //   9559	3	20	localJSONException3	org.json.JSONException
    //   9604	774	20	localObject3	Object
    //   429	9947	21	localObject4	Object
    //   73	9093	22	localObject5	Object
    //   2224	5918	23	localObject6	Object
    //   2234	5581	24	str1	String
    //   2229	5594	25	str2	String
    //   2085	3248	26	str3	String
    //   2202	3096	27	str4	String
    //   2214	203	28	localApkgInfo2	com.tencent.mobileqq.mini.apkg.ApkgInfo
    // Exception table:
    //   from	to	target	type
    //   636	871	896	java/lang/Exception
    //   874	893	896	java/lang/Exception
    //   1269	1284	1369	java/lang/Exception
    //   1288	1295	1369	java/lang/Exception
    //   1298	1336	1369	java/lang/Exception
    //   1417	1503	1552	org/json/JSONException
    //   1508	1549	1552	org/json/JSONException
    //   1566	1578	1552	org/json/JSONException
    //   1581	1593	1552	org/json/JSONException
    //   1706	1758	1819	java/lang/Exception
    //   1758	1788	1819	java/lang/Exception
    //   1792	1803	1819	java/lang/Exception
    //   1803	1816	1819	java/lang/Exception
    //   1841	1849	1819	java/lang/Exception
    //   1856	1908	1819	java/lang/Exception
    //   1911	1981	1819	java/lang/Exception
    //   1981	2002	1819	java/lang/Exception
    //   2002	2014	1819	java/lang/Exception
    //   2019	2024	1819	java/lang/Exception
    //   2027	2057	1819	java/lang/Exception
    //   2060	2087	1819	java/lang/Exception
    //   2090	2123	1819	java/lang/Exception
    //   2123	2141	1819	java/lang/Exception
    //   2143	2164	1819	java/lang/Exception
    //   2164	2216	1819	java/lang/Exception
    //   2249	2257	1819	java/lang/Exception
    //   2261	2272	1819	java/lang/Exception
    //   2276	2303	1819	java/lang/Exception
    //   2324	2332	1819	java/lang/Exception
    //   2340	2380	1819	java/lang/Exception
    //   2393	2401	1819	java/lang/Exception
    //   2405	2429	1819	java/lang/Exception
    //   2429	2469	1819	java/lang/Exception
    //   2472	2591	1819	java/lang/Exception
    //   2591	2709	1819	java/lang/Exception
    //   2712	2755	1819	java/lang/Exception
    //   2769	2780	1819	java/lang/Exception
    //   2783	2823	1819	java/lang/Exception
    //   1981	2002	2017	org/json/JSONException
    //   3028	3058	3246	org/json/JSONException
    //   3081	3098	3246	org/json/JSONException
    //   3098	3108	3246	org/json/JSONException
    //   3111	3121	3246	org/json/JSONException
    //   3124	3134	3246	org/json/JSONException
    //   3137	3146	3246	org/json/JSONException
    //   3661	3716	3761	org/json/JSONException
    //   3720	3742	3761	org/json/JSONException
    //   3742	3758	3761	org/json/JSONException
    //   3780	3796	3761	org/json/JSONException
    //   3799	3856	3761	org/json/JSONException
    //   3859	3875	3761	org/json/JSONException
    //   3887	3915	3944	org/json/JSONException
    //   3929	3941	3944	org/json/JSONException
    //   3993	4002	4615	org/json/JSONException
    //   4005	4026	4615	org/json/JSONException
    //   4042	4080	4615	org/json/JSONException
    //   4083	4106	4615	org/json/JSONException
    //   4106	4137	4615	org/json/JSONException
    //   4137	4147	4615	org/json/JSONException
    //   4151	4169	4615	org/json/JSONException
    //   4169	4199	4615	org/json/JSONException
    //   4203	4218	4615	org/json/JSONException
    //   4223	4261	4615	org/json/JSONException
    //   4261	4285	4615	org/json/JSONException
    //   4285	4307	4615	org/json/JSONException
    //   4307	4335	4615	org/json/JSONException
    //   4347	4356	4615	org/json/JSONException
    //   4360	4432	4615	org/json/JSONException
    //   4437	4463	4615	org/json/JSONException
    //   4474	4506	4615	org/json/JSONException
    //   4510	4522	4615	org/json/JSONException
    //   4525	4539	4615	org/json/JSONException
    //   4542	4568	4615	org/json/JSONException
    //   4580	4589	4615	org/json/JSONException
    //   4597	4612	4615	org/json/JSONException
    //   4634	4663	4615	org/json/JSONException
    //   4666	4684	4615	org/json/JSONException
    //   4687	4741	4615	org/json/JSONException
    //   4744	4768	4615	org/json/JSONException
    //   4771	4796	4615	org/json/JSONException
    //   4796	4820	4615	org/json/JSONException
    //   4820	4851	4615	org/json/JSONException
    //   4855	4880	4615	org/json/JSONException
    //   4880	4904	4615	org/json/JSONException
    //   4904	4935	4615	org/json/JSONException
    //   4939	4955	4615	org/json/JSONException
    //   4958	5004	4615	org/json/JSONException
    //   5007	5015	4615	org/json/JSONException
    //   5025	5045	4615	org/json/JSONException
    //   5054	5136	4615	org/json/JSONException
    //   5139	5171	4615	org/json/JSONException
    //   5175	5211	4615	org/json/JSONException
    //   5214	5236	4615	org/json/JSONException
    //   5236	5244	4615	org/json/JSONException
    //   5253	5280	4615	org/json/JSONException
    //   5283	5312	4615	org/json/JSONException
    //   5321	5348	4615	org/json/JSONException
    //   5376	5395	5634	org/json/JSONException
    //   5406	5415	5634	org/json/JSONException
    //   5428	5451	5634	org/json/JSONException
    //   5451	5474	5634	org/json/JSONException
    //   5474	5505	5634	org/json/JSONException
    //   5505	5560	5634	org/json/JSONException
    //   5563	5611	5634	org/json/JSONException
    //   5619	5631	5634	org/json/JSONException
    //   5690	5705	5634	org/json/JSONException
    //   5708	5723	5634	org/json/JSONException
    //   5726	5755	5634	org/json/JSONException
    //   5758	5765	5634	org/json/JSONException
    //   5775	5782	5634	org/json/JSONException
    //   5786	5801	5634	org/json/JSONException
    //   5804	5813	5634	org/json/JSONException
    //   5816	5848	5634	org/json/JSONException
    //   5852	5878	5634	org/json/JSONException
    //   5891	5901	5634	org/json/JSONException
    //   5930	5948	6039	org/json/JSONException
    //   5964	5976	6039	org/json/JSONException
    //   5985	5990	6039	org/json/JSONException
    //   5995	6000	6039	org/json/JSONException
    //   6005	6010	6039	org/json/JSONException
    //   6015	6020	6039	org/json/JSONException
    //   6020	6036	6039	org/json/JSONException
    //   6062	6079	6039	org/json/JSONException
    //   6079	6089	6039	org/json/JSONException
    //   6092	6102	6039	org/json/JSONException
    //   6105	6115	6039	org/json/JSONException
    //   6118	6128	6039	org/json/JSONException
    //   6134	6150	6039	org/json/JSONException
    //   6153	6179	6039	org/json/JSONException
    //   6184	6198	6039	org/json/JSONException
    //   6203	6217	6039	org/json/JSONException
    //   6222	6236	6039	org/json/JSONException
    //   6241	6255	6039	org/json/JSONException
    //   6255	6271	6039	org/json/JSONException
    //   6274	6290	6039	org/json/JSONException
    //   6346	6366	6469	java/lang/Throwable
    //   6370	6385	6469	java/lang/Throwable
    //   6385	6402	6469	java/lang/Throwable
    //   6407	6433	6469	java/lang/Throwable
    //   6438	6466	6469	java/lang/Throwable
    //   6489	6498	6469	java/lang/Throwable
    //   6508	6524	6469	java/lang/Throwable
    //   6528	6544	6469	java/lang/Throwable
    //   6553	6565	6469	java/lang/Throwable
    //   6568	6580	6469	java/lang/Throwable
    //   6583	6595	6469	java/lang/Throwable
    //   6607	6747	6750	org/json/JSONException
    //   6778	6825	6828	org/json/JSONException
    //   6953	6963	6994	org/json/JSONException
    //   6897	6929	7013	org/json/JSONException
    //   6933	6938	7013	org/json/JSONException
    //   6938	6953	7013	org/json/JSONException
    //   6963	6994	7013	org/json/JSONException
    //   6995	7010	7013	org/json/JSONException
    //   7271	7303	7432	org/json/JSONException
    //   7307	7323	7432	org/json/JSONException
    //   7326	7346	7432	org/json/JSONException
    //   7355	7372	7432	org/json/JSONException
    //   7376	7399	7432	org/json/JSONException
    //   7399	7429	7432	org/json/JSONException
    //   7490	7581	7892	org/json/JSONException
    //   7585	7622	7892	org/json/JSONException
    //   7631	7646	7892	org/json/JSONException
    //   7650	7673	7892	org/json/JSONException
    //   7677	7694	7892	org/json/JSONException
    //   7697	7726	7892	org/json/JSONException
    //   7730	7745	7892	org/json/JSONException
    //   7752	7770	7892	org/json/JSONException
    //   7776	7805	7892	org/json/JSONException
    //   7811	7829	7892	org/json/JSONException
    //   7832	7890	7892	org/json/JSONException
    //   8036	8047	8241	org/json/JSONException
    //   8049	8070	8241	org/json/JSONException
    //   8072	8124	8241	org/json/JSONException
    //   8126	8214	8241	org/json/JSONException
    //   8214	8220	8241	org/json/JSONException
    //   8223	8229	8241	org/json/JSONException
    //   8232	8238	8241	org/json/JSONException
    //   8284	8351	8833	java/lang/Throwable
    //   8353	8377	8833	java/lang/Throwable
    //   8382	8416	8833	java/lang/Throwable
    //   8418	8455	8833	java/lang/Throwable
    //   8457	8471	8833	java/lang/Throwable
    //   8471	8481	8833	java/lang/Throwable
    //   8481	8511	8833	java/lang/Throwable
    //   8521	8614	8833	java/lang/Throwable
    //   8617	8625	8833	java/lang/Throwable
    //   8629	8671	8833	java/lang/Throwable
    //   8671	8830	8833	java/lang/Throwable
    //   8849	8881	8833	java/lang/Throwable
    //   8888	8903	8833	java/lang/Throwable
    //   8906	8926	8833	java/lang/Throwable
    //   8471	8481	8848	java/io/UnsupportedEncodingException
    //   8938	8979	9033	java/lang/Throwable
    //   8983	9006	9033	java/lang/Throwable
    //   9006	9030	9033	java/lang/Throwable
    //   9064	9094	9213	java/lang/Throwable
    //   9098	9105	9213	java/lang/Throwable
    //   9108	9171	9213	java/lang/Throwable
    //   9180	9210	9213	java/lang/Throwable
    //   9252	9276	9346	java/lang/Throwable
    //   9280	9287	9346	java/lang/Throwable
    //   9290	9314	9346	java/lang/Throwable
    //   9323	9343	9346	java/lang/Throwable
    //   9382	9406	9421	org/json/JSONException
    //   9449	9461	9559	org/json/JSONException
    //   9477	9485	9559	org/json/JSONException
    //   9489	9500	9559	org/json/JSONException
    //   9504	9534	9559	org/json/JSONException
    //   9534	9544	9559	org/json/JSONException
    //   9579	9615	9845	org/json/JSONException
    //   9631	9639	9845	org/json/JSONException
    //   9643	9654	9845	org/json/JSONException
    //   9658	9688	9845	org/json/JSONException
    //   9688	9699	9845	org/json/JSONException
    //   9704	9737	9845	org/json/JSONException
    //   9741	9842	9845	org/json/JSONException
    //   9853	9866	9845	org/json/JSONException
    //   9879	9920	10061	org/json/JSONException
    //   9925	9958	10061	org/json/JSONException
    //   9962	10000	10061	org/json/JSONException
    //   10005	10058	10061	org/json/JSONException
    //   10113	10165	10168	java/lang/Throwable
  }
  
  public void login(abwu paramabwu)
  {
    if (paramabwu == null) {
      return;
    }
    ThreadManager.excute(new DataJsPlugin.26(this, paramabwu), 16, null, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin
 * JD-Core Version:    0.7.0.1
 */