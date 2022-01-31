package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import aabi;
import aabl;
import aabq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import ved;
import yxo;

public class DataJsPlugin
  extends BaseJsPlugin
{
  private static final String AD_REF_ID = "biz_src_miniappD";
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
  private aabl apiManager;
  private Long lastNotRspReqTime = Long.valueOf(0L);
  private List<aabi> loginCallBacks = new LinkedList();
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
      ved.b("[mini] DataJsPlugin", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label44:
      ved.b("[mini] DataJsPlugin", "start load URLDrawable.");
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
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
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
    aabq.a();
    this.apiManager = aabq.a(this.jsPluginEngine.getActivityContext(), paramInt, paramString);
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
  
  private void realSharePic(String paramString1, String paramString2, int paramInt)
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
      ShareUtils.startSharePicToWeChat(this.jsPluginEngine.getActivityContext(), paramString2, true);
      return;
    }
    ShareUtils.startSharePicToWeChat(this.jsPluginEngine.getActivityContext(), paramString2, false);
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
    if (paramString2 == null) {
      return;
    }
    if (paramString2.startsWith(BaseApplicationImpl.getContext().getFilesDir().getPath()))
    {
      paramString2 = new File(paramString2);
      String str = paramString2.getName();
      ThreadManager.excute(new DataJsPlugin.31(this, paramString2, str), 64, new DataJsPlugin.32(this, str, paramString1, paramInt), true);
      return;
    }
    realSharePic(paramString1, paramString2, paramInt);
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
    //   0: invokestatic 651	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc 139
    //   8: iconst_2
    //   9: new 323	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 653
    //   19: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 655
    //   29: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 657
    //   39: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 513	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_3
    //   54: ifnonnull +18 -> 72
    //   57: ldc 139
    //   59: iconst_4
    //   60: ldc_w 659
    //   63: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: ldc_w 664
    //   69: astore_2
    //   70: aload_2
    //   71: areturn
    //   72: aconst_null
    //   73: astore 22
    //   75: aload_0
    //   76: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   79: ifnull +12 -> 91
    //   82: aload_0
    //   83: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   86: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   89: astore 22
    //   91: aload 22
    //   93: ifnull +26 -> 119
    //   96: new 323	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   103: aload_1
    //   104: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 22
    //   109: invokevirtual 669	java/lang/Object:hashCode	()I
    //   112: invokevirtual 513	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: pop
    //   119: ldc 35
    //   121: aload_1
    //   122: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +12 -> 137
    //   128: ldc 38
    //   130: aload_1
    //   131: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +1111 -> 1245
    //   137: aload 22
    //   139: ifnull +1074 -> 1213
    //   142: getstatic 674	android/os/Build$VERSION:SDK_INT	I
    //   145: bipush 17
    //   147: if_icmplt +806 -> 953
    //   150: new 676	android/util/DisplayMetrics
    //   153: dup
    //   154: invokespecial 677	android/util/DisplayMetrics:<init>	()V
    //   157: astore_2
    //   158: aload 22
    //   160: ldc_w 679
    //   163: invokevirtual 683	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   166: checkcast 685	android/view/WindowManager
    //   169: invokeinterface 689 1 0
    //   174: aload_2
    //   175: invokevirtual 695	android/view/Display:getRealMetrics	(Landroid/util/DisplayMetrics;)V
    //   178: aload 22
    //   180: invokestatic 701	com/tencent/mobileqq/mini/util/DisplayUtil:hasNavBar	(Landroid/content/Context;)Z
    //   183: ifeq +11 -> 194
    //   186: aload 22
    //   188: invokestatic 705	com/tencent/mobileqq/mini/util/DisplayUtil:isNavigationBarExist	(Landroid/app/Activity;)Z
    //   191: ifne +9 -> 200
    //   194: invokestatic 708	com/tencent/mobileqq/mini/util/DisplayUtil:isFlymeOS7NavBarShow	()Z
    //   197: ifeq +768 -> 965
    //   200: iconst_1
    //   201: istore 16
    //   203: aload_2
    //   204: getfield 712	android/util/DisplayMetrics:density	F
    //   207: f2d
    //   208: dstore 5
    //   210: aload_2
    //   211: getfield 715	android/util/DisplayMetrics:widthPixels	I
    //   214: i2d
    //   215: dload 5
    //   217: ddiv
    //   218: invokestatic 721	java/lang/Math:round	(D)J
    //   221: l2f
    //   222: ldc_w 722
    //   225: fadd
    //   226: f2i
    //   227: istore 9
    //   229: aload_2
    //   230: getfield 725	android/util/DisplayMetrics:heightPixels	I
    //   233: i2d
    //   234: dload 5
    //   236: ddiv
    //   237: invokestatic 721	java/lang/Math:round	(D)J
    //   240: l2f
    //   241: ldc_w 722
    //   244: fadd
    //   245: f2i
    //   246: istore 8
    //   248: iload 8
    //   250: istore 7
    //   252: iload 16
    //   254: ifeq +23 -> 277
    //   257: iload 8
    //   259: aload_0
    //   260: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   263: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   266: invokestatic 729	com/tencent/mobileqq/mini/util/DisplayUtil:getNavigationBarHeight	(Landroid/content/Context;)I
    //   269: i2d
    //   270: dload 5
    //   272: ddiv
    //   273: d2i
    //   274: isub
    //   275: istore 7
    //   277: aload 22
    //   279: invokestatic 734	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   282: i2f
    //   283: invokestatic 737	java/lang/Math:round	(F)I
    //   286: i2d
    //   287: dload 5
    //   289: ddiv
    //   290: d2i
    //   291: istore 10
    //   293: ldc_w 738
    //   296: invokestatic 742	bbll:b	(F)I
    //   299: i2d
    //   300: dload 5
    //   302: ddiv
    //   303: ldc2_w 743
    //   306: dadd
    //   307: d2i
    //   308: istore 11
    //   310: ldc_w 745
    //   313: invokestatic 742	bbll:b	(F)I
    //   316: i2d
    //   317: dload 5
    //   319: ddiv
    //   320: ldc2_w 743
    //   323: dadd
    //   324: d2i
    //   325: istore 8
    //   327: aconst_null
    //   328: astore 20
    //   330: aload_0
    //   331: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   334: ifnull +637 -> 971
    //   337: aload_0
    //   338: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   341: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   344: ifnull +627 -> 971
    //   347: aload_0
    //   348: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   351: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   354: invokevirtual 749	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   357: ifnull +614 -> 971
    //   360: aload_0
    //   361: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   364: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   367: invokevirtual 749	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   370: invokevirtual 754	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   373: ifnull +598 -> 971
    //   376: aload_0
    //   377: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   380: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   383: invokevirtual 749	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   386: invokevirtual 754	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   389: astore 20
    //   391: aload 20
    //   393: astore_2
    //   394: aload 20
    //   396: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   399: ifne +9581 -> 9980
    //   402: aload_0
    //   403: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   406: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   409: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   412: invokevirtual 760	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   415: aload 20
    //   417: invokevirtual 766	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   420: getfield 772	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   423: getfield 778	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   426: getfield 783	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   429: astore 21
    //   431: aload 20
    //   433: astore_2
    //   434: aload_0
    //   435: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   438: ifnull +9536 -> 9974
    //   441: aload_0
    //   442: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   445: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   448: ifnull +9526 -> 9974
    //   451: aload_0
    //   452: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   455: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   458: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   461: ifnull +9513 -> 9974
    //   464: aload_0
    //   465: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   468: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   471: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   474: invokevirtual 760	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   477: ifnull +9497 -> 9974
    //   480: aload_0
    //   481: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   484: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   487: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   490: invokevirtual 760	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   493: getfield 787	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   496: ifnull +684 -> 1180
    //   499: aload_0
    //   500: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   503: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   506: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   509: aload_2
    //   510: invokevirtual 790	com/tencent/mobileqq/mini/apkg/ApkgInfo:isTabBarPage	(Ljava/lang/String;)Z
    //   513: ifeq +667 -> 1180
    //   516: aload_0
    //   517: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   520: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   523: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   526: invokevirtual 760	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   529: getfield 787	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   532: invokevirtual 795	com/tencent/mobileqq/mini/apkg/TabBarInfo:isShow	()Z
    //   535: ifeq +645 -> 1180
    //   538: iconst_1
    //   539: istore 15
    //   541: ldc_w 797
    //   544: aload 21
    //   546: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   570: invokestatic 800	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   573: ifeq +63 -> 636
    //   576: ldc 139
    //   578: iconst_1
    //   579: new 323	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 802
    //   589: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: iload 8
    //   594: invokevirtual 513	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   597: ldc_w 804
    //   600: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload 21
    //   605: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: ldc_w 806
    //   611: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: iload 15
    //   616: invokevirtual 809	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   619: ldc_w 811
    //   622: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: iload 16
    //   627: invokevirtual 809	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   630: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: invokestatic 817	com/tencent/mobileqq/mini/app/AppLoaderFactory:getAppLoaderManager	()Lcom/tencent/mobileqq/mini/app/BaseAppLoaderManager;
    //   639: invokeinterface 823 1 0
    //   644: getfield 828	com/tencent/mobileqq/mini/sdk/BaseLibInfo:baseLibVersion	Ljava/lang/String;
    //   647: astore_2
    //   648: new 273	org/json/JSONObject
    //   651: dup
    //   652: invokespecial 829	org/json/JSONObject:<init>	()V
    //   655: astore 20
    //   657: aload 20
    //   659: ldc_w 831
    //   662: getstatic 836	android/os/Build:BRAND	Ljava/lang/String;
    //   665: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   668: pop
    //   669: aload 20
    //   671: ldc_w 842
    //   674: getstatic 845	android/os/Build:MODEL	Ljava/lang/String;
    //   677: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   680: pop
    //   681: aload 20
    //   683: ldc_w 847
    //   686: dload 5
    //   688: invokevirtual 850	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   691: pop
    //   692: aload 20
    //   694: ldc_w 852
    //   697: iload 9
    //   699: invokevirtual 855	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   702: pop
    //   703: aload 20
    //   705: ldc_w 857
    //   708: iload 7
    //   710: invokevirtual 855	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 20
    //   716: ldc_w 859
    //   719: iload 9
    //   721: invokevirtual 855	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   724: pop
    //   725: aload 20
    //   727: ldc_w 861
    //   730: iload 8
    //   732: invokevirtual 855	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   735: pop
    //   736: aload 20
    //   738: ldc_w 863
    //   741: iload 10
    //   743: invokevirtual 855	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   746: pop
    //   747: aload 20
    //   749: ldc_w 865
    //   752: ldc_w 867
    //   755: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   758: pop
    //   759: aload 20
    //   761: ldc_w 869
    //   764: invokestatic 874	bbdh:c	()Ljava/lang/String;
    //   767: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   770: pop
    //   771: aload 20
    //   773: ldc_w 876
    //   776: new 323	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   783: ldc_w 878
    //   786: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: getstatic 881	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   792: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   801: pop
    //   802: aload 20
    //   804: ldc_w 883
    //   807: ldc_w 885
    //   810: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   813: pop
    //   814: aload 20
    //   816: ldc_w 887
    //   819: bipush 16
    //   821: invokevirtual 855	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   824: pop
    //   825: aload 20
    //   827: ldc_w 889
    //   830: aload_2
    //   831: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   834: pop
    //   835: aload 20
    //   837: ldc_w 891
    //   840: ldc 112
    //   842: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   845: pop
    //   846: aload 20
    //   848: ldc_w 893
    //   851: aload 22
    //   853: invokestatic 897	com/tencent/mobileqq/mini/util/DisplayUtil:getDisplayCutoutSafeArea	(Landroid/app/Activity;)Lorg/json/JSONObject;
    //   856: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   859: pop
    //   860: aload_1
    //   861: aload 20
    //   863: invokestatic 903	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   866: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   869: astore 20
    //   871: aload 20
    //   873: astore_2
    //   874: ldc 35
    //   876: aload_1
    //   877: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   880: ifeq -810 -> 70
    //   883: aload_3
    //   884: iload 4
    //   886: aload 20
    //   888: invokeinterface 909 3 0
    //   893: aload 20
    //   895: areturn
    //   896: astore_2
    //   897: ldc 139
    //   899: iconst_1
    //   900: new 323	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   907: ldc_w 911
    //   910: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: new 343	java/lang/Throwable
    //   916: dup
    //   917: aload_2
    //   918: invokespecial 914	java/lang/Throwable:<init>	(Ljava/lang/Throwable;)V
    //   921: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   924: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: aload_1
    //   931: aconst_null
    //   932: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   935: astore_1
    //   936: aload_3
    //   937: iload 4
    //   939: aload_1
    //   940: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   943: invokeinterface 909 3 0
    //   948: aload_1
    //   949: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   952: areturn
    //   953: aload 22
    //   955: invokevirtual 924	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   958: invokevirtual 930	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   961: astore_2
    //   962: goto -784 -> 178
    //   965: iconst_0
    //   966: istore 16
    //   968: goto -765 -> 203
    //   971: aload 20
    //   973: astore_2
    //   974: aload_0
    //   975: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   978: ifnull +9002 -> 9980
    //   981: aload 20
    //   983: astore_2
    //   984: aload_0
    //   985: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   988: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   991: ifnull +8989 -> 9980
    //   994: aload 20
    //   996: astore_2
    //   997: aload_0
    //   998: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1001: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1004: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1007: ifnull +8973 -> 9980
    //   1010: aconst_null
    //   1011: astore 20
    //   1013: aload 20
    //   1015: astore_2
    //   1016: aload_0
    //   1017: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1020: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1023: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1026: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1029: ifnull +45 -> 1074
    //   1032: aload 20
    //   1034: astore_2
    //   1035: aload_0
    //   1036: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1039: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1042: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1045: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1048: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1051: ifnull +23 -> 1074
    //   1054: aload_0
    //   1055: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1058: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1061: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1064: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1067: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1070: getfield 945	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   1073: astore_2
    //   1074: aconst_null
    //   1075: astore 20
    //   1077: aload_0
    //   1078: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1081: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1084: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1087: getfield 949	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1090: ifnull +21 -> 1111
    //   1093: aload_0
    //   1094: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1097: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1100: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1103: getfield 949	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1106: getfield 952	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   1109: astore 20
    //   1111: aload_0
    //   1112: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1115: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1118: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1121: aload_2
    //   1122: invokevirtual 955	com/tencent/mobileqq/mini/apkg/ApkgInfo:isUrlFileExist	(Ljava/lang/String;)Z
    //   1125: ifne +49 -> 1174
    //   1128: aload 20
    //   1130: astore_2
    //   1131: aload 20
    //   1133: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1136: ifne +8844 -> 9980
    //   1139: aload_0
    //   1140: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1143: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1146: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1149: invokevirtual 760	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1152: aload 20
    //   1154: invokevirtual 766	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   1157: getfield 772	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   1160: getfield 778	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   1163: getfield 783	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
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
    //   1216: ldc_w 957
    //   1219: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1222: aload_1
    //   1223: aconst_null
    //   1224: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1227: astore_1
    //   1228: aload_3
    //   1229: iload 4
    //   1231: aload_1
    //   1232: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1235: invokeinterface 909 3 0
    //   1240: aload_1
    //   1241: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1244: areturn
    //   1245: ldc_w 959
    //   1248: aload_1
    //   1249: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1252: ifeq +135 -> 1387
    //   1255: iconst_0
    //   1256: istore 8
    //   1258: iload 8
    //   1260: istore 7
    //   1262: aload_2
    //   1263: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1266: ifne +70 -> 1336
    //   1269: new 273	org/json/JSONObject
    //   1272: dup
    //   1273: aload_2
    //   1274: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1277: ldc_w 961
    //   1280: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1283: astore_1
    //   1284: iload 8
    //   1286: istore 7
    //   1288: aload_1
    //   1289: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1292: ifne +44 -> 1336
    //   1295: iconst_1
    //   1296: istore 7
    //   1298: aload 22
    //   1300: new 532	android/content/Intent
    //   1303: dup
    //   1304: ldc_w 966
    //   1307: new 323	java/lang/StringBuilder
    //   1310: dup
    //   1311: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1314: ldc_w 968
    //   1317: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: aload_1
    //   1321: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: invokestatic 974	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1330: invokespecial 977	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1333: invokevirtual 981	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1336: iload 7
    //   1338: ifeq +38 -> 1376
    //   1341: ldc_w 959
    //   1344: aconst_null
    //   1345: invokestatic 903	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1348: astore_1
    //   1349: aload_1
    //   1350: ifnull +15 -> 1365
    //   1353: aload_3
    //   1354: iload 4
    //   1356: aload_1
    //   1357: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1360: invokeinterface 909 3 0
    //   1365: ldc_w 664
    //   1368: areturn
    //   1369: astore_1
    //   1370: iconst_0
    //   1371: istore 7
    //   1373: goto -37 -> 1336
    //   1376: ldc_w 959
    //   1379: aconst_null
    //   1380: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1383: astore_1
    //   1384: goto -35 -> 1349
    //   1387: ldc_w 983
    //   1390: aload_1
    //   1391: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1394: ifeq +202 -> 1596
    //   1397: ldc 139
    //   1399: iconst_2
    //   1400: iconst_2
    //   1401: anewarray 666	java/lang/Object
    //   1404: dup
    //   1405: iconst_0
    //   1406: ldc_w 984
    //   1409: aastore
    //   1410: dup
    //   1411: iconst_1
    //   1412: aload_2
    //   1413: aastore
    //   1414: invokestatic 987	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1417: new 273	org/json/JSONObject
    //   1420: dup
    //   1421: aload_2
    //   1422: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1425: ldc_w 989
    //   1428: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1431: astore 20
    //   1433: aload 20
    //   1435: ldc_w 995
    //   1438: ldc_w 664
    //   1441: invokevirtual 998	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1444: astore 21
    //   1446: aload 20
    //   1448: ldc_w 1000
    //   1451: iconst_1
    //   1452: invokevirtual 1004	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1455: pop
    //   1456: ldc_w 1006
    //   1459: aload 21
    //   1461: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1464: ifeq -99 -> 1365
    //   1467: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1470: invokevirtual 1010	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1473: astore 20
    //   1475: aload 20
    //   1477: instanceof 1012
    //   1480: ifeq +101 -> 1581
    //   1483: aload 20
    //   1485: checkcast 1012	com/tencent/mobileqq/mini/MiniAppInterface
    //   1488: aload_0
    //   1489: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1492: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1495: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1498: invokevirtual 1016	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   1501: astore 20
    //   1503: aload 20
    //   1505: ifnull +61 -> 1566
    //   1508: aload 20
    //   1510: aload_1
    //   1511: aload_2
    //   1512: invokevirtual 1022	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlag	(Ljava/lang/String;Ljava/lang/String;)I
    //   1515: iconst_2
    //   1516: if_icmpne +50 -> 1566
    //   1519: new 1024	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2
    //   1522: dup
    //   1523: aload_0
    //   1524: aload_3
    //   1525: aload_1
    //   1526: iload 4
    //   1528: invokespecial 1025	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1531: astore_1
    //   1532: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1535: aload_0
    //   1536: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1539: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1542: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1545: aload_1
    //   1546: invokevirtual 1028	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getPhoneNumber	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1549: goto -184 -> 1365
    //   1552: astore_1
    //   1553: ldc 139
    //   1555: iconst_2
    //   1556: ldc_w 984
    //   1559: aload_1
    //   1560: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1563: goto -198 -> 1365
    //   1566: aload_0
    //   1567: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1570: aload_3
    //   1571: aload_1
    //   1572: aconst_null
    //   1573: iload 4
    //   1575: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   1578: goto -213 -> 1365
    //   1581: aload_0
    //   1582: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1585: aload_3
    //   1586: aload_1
    //   1587: aconst_null
    //   1588: iload 4
    //   1590: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   1593: goto -228 -> 1365
    //   1596: ldc 50
    //   1598: aload_1
    //   1599: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1602: ifeq +86 -> 1688
    //   1605: ldc 139
    //   1607: iconst_2
    //   1608: new 323	java/lang/StringBuilder
    //   1611: dup
    //   1612: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1615: ldc_w 1035
    //   1618: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1621: iload 4
    //   1623: invokevirtual 513	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1626: ldc_w 1037
    //   1629: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: aload_0
    //   1633: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1636: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1639: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1642: getfield 949	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1645: getfield 1040	com/tencent/mobileqq/mini/apkg/AppConfigInfo:PackageToolVersion	Ljava/lang/String;
    //   1648: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1654: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1657: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1660: aload_0
    //   1661: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1664: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1667: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1670: new 1042	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3
    //   1673: dup
    //   1674: aload_0
    //   1675: aload_3
    //   1676: aload_1
    //   1677: iload 4
    //   1679: invokespecial 1043	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1682: invokevirtual 1046	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getLoginCode	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1685: goto -320 -> 1365
    //   1688: ldc_w 1048
    //   1691: aload_1
    //   1692: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1695: ifeq +1070 -> 2765
    //   1698: new 273	org/json/JSONObject
    //   1701: dup
    //   1702: invokespecial 829	org/json/JSONObject:<init>	()V
    //   1705: pop
    //   1706: new 273	org/json/JSONObject
    //   1709: dup
    //   1710: aload_2
    //   1711: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1714: astore 20
    //   1716: aload 20
    //   1718: ldc_w 989
    //   1721: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1724: astore 22
    //   1726: aload 22
    //   1728: ldc_w 995
    //   1731: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1734: astore 21
    //   1736: ldc_w 1050
    //   1739: aload 21
    //   1741: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1744: ifne +14 -> 1758
    //   1747: ldc_w 1052
    //   1750: aload 21
    //   1752: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1755: ifeq +101 -> 1856
    //   1758: aload 22
    //   1760: ldc_w 1000
    //   1763: invokevirtual 1054	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1766: istore 15
    //   1768: aload 22
    //   1770: ldc_w 1056
    //   1773: aconst_null
    //   1774: invokevirtual 998	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1777: astore 20
    //   1779: aload 22
    //   1781: ldc_w 989
    //   1784: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1787: astore_2
    //   1788: aload_2
    //   1789: ifnull +49 -> 1838
    //   1792: aload_2
    //   1793: ldc_w 1056
    //   1796: ldc_w 1058
    //   1799: invokevirtual 998	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1802: astore_2
    //   1803: aload_0
    //   1804: aload_3
    //   1805: aload_1
    //   1806: aload 21
    //   1808: iload 4
    //   1810: iload 15
    //   1812: aload_2
    //   1813: invokevirtual 1060	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getUserInfo	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V
    //   1816: goto -451 -> 1365
    //   1819: astore_1
    //   1820: ldc 139
    //   1822: iconst_1
    //   1823: aload_1
    //   1824: iconst_0
    //   1825: anewarray 666	java/lang/Object
    //   1828: invokestatic 1063	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1831: aload_1
    //   1832: invokevirtual 1064	java/lang/Exception:printStackTrace	()V
    //   1835: goto -470 -> 1365
    //   1838: aload 20
    //   1840: astore_2
    //   1841: aload 20
    //   1843: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1846: ifeq -43 -> 1803
    //   1849: ldc_w 1058
    //   1852: astore_2
    //   1853: goto -50 -> 1803
    //   1856: ldc_w 1066
    //   1859: aload 21
    //   1861: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1864: ifeq +47 -> 1911
    //   1867: new 1068	Wallet/IsUinFocusMpIdReq
    //   1870: dup
    //   1871: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1874: invokevirtual 1010	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1877: invokevirtual 1073	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   1880: aload_0
    //   1881: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1884: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1887: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1890: invokespecial 1075	Wallet/IsUinFocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1893: new 1077	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4
    //   1896: dup
    //   1897: aload_0
    //   1898: aload_3
    //   1899: aload_1
    //   1900: iload 4
    //   1902: invokespecial 1078	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1905: invokestatic 1083	agwt:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   1908: goto -543 -> 1365
    //   1911: ldc_w 1085
    //   1914: aload 21
    //   1916: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1919: ifeq +141 -> 2060
    //   1922: aload 20
    //   1924: ldc_w 1087
    //   1927: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1930: ldc_w 1089
    //   1933: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1936: astore_2
    //   1937: ldc 98
    //   1939: aload_0
    //   1940: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1943: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1946: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1949: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1952: ifeq +75 -> 2027
    //   1955: ldc 139
    //   1957: iconst_1
    //   1958: ldc_w 1091
    //   1961: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1964: new 273	org/json/JSONObject
    //   1967: dup
    //   1968: invokespecial 829	org/json/JSONObject:<init>	()V
    //   1971: astore_2
    //   1972: new 273	org/json/JSONObject
    //   1975: dup
    //   1976: invokespecial 829	org/json/JSONObject:<init>	()V
    //   1979: astore 20
    //   1981: aload 20
    //   1983: ldc_w 989
    //   1986: ldc 145
    //   1988: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1991: pop
    //   1992: aload_2
    //   1993: ldc_w 1093
    //   1996: aload 20
    //   1998: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2001: pop
    //   2002: aload_0
    //   2003: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2006: aload_3
    //   2007: aload_1
    //   2008: aload_2
    //   2009: iload 4
    //   2011: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2014: goto -649 -> 1365
    //   2017: astore 20
    //   2019: aload 20
    //   2021: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   2024: goto -22 -> 2002
    //   2027: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2030: aload_0
    //   2031: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2034: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2037: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2040: aload_2
    //   2041: aconst_null
    //   2042: new 1099	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5
    //   2045: dup
    //   2046: aload_0
    //   2047: aload_3
    //   2048: aload_1
    //   2049: iload 4
    //   2051: invokespecial 1100	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2054: invokevirtual 1103	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkNavigateRight	(Ljava/lang/String;Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2057: goto -692 -> 1365
    //   2060: ldc_w 1105
    //   2063: aload 21
    //   2065: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2068: ifeq +407 -> 2475
    //   2071: aload 22
    //   2073: ldc_w 989
    //   2076: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2079: ldc_w 1107
    //   2082: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2085: astore 26
    //   2087: iconst_2
    //   2088: istore 7
    //   2090: aload 22
    //   2092: ldc_w 989
    //   2095: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2098: ldc_w 1109
    //   2101: invokevirtual 503	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2104: ifeq +19 -> 2123
    //   2107: aload 22
    //   2109: ldc_w 989
    //   2112: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2115: ldc_w 1109
    //   2118: invokevirtual 1113	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2121: istore 7
    //   2123: aload_0
    //   2124: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2127: getfield 1117	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2130: invokevirtual 1122	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   2133: invokestatic 1125	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   2136: invokevirtual 1129	java/lang/Long:longValue	()J
    //   2139: lstore 18
    //   2141: aconst_null
    //   2142: astore_2
    //   2143: aload_0
    //   2144: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2147: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2150: ifnull +14 -> 2164
    //   2153: aload_0
    //   2154: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2157: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2160: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2163: astore_2
    //   2164: ldc 139
    //   2166: iconst_2
    //   2167: new 323	java/lang/StringBuilder
    //   2170: dup
    //   2171: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2174: ldc_w 1131
    //   2177: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2180: aload_2
    //   2181: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2184: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2187: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2190: aload_2
    //   2191: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2194: ifne -829 -> 1365
    //   2197: iload 7
    //   2199: invokestatic 1135	com/tencent/mobileqq/mini/util/AdUtils:getSpAdGdtCookie	(I)Ljava/lang/String;
    //   2202: astore 27
    //   2204: aload_0
    //   2205: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2208: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2211: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   2214: astore 28
    //   2216: ldc_w 664
    //   2219: astore 21
    //   2221: ldc_w 664
    //   2224: astore 23
    //   2226: ldc_w 664
    //   2229: astore 25
    //   2231: ldc_w 664
    //   2234: astore 24
    //   2236: aload 21
    //   2238: astore 20
    //   2240: aload 28
    //   2242: ifnull +61 -> 2303
    //   2245: aload 21
    //   2247: astore 20
    //   2249: aload 28
    //   2251: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2254: ifnull +49 -> 2303
    //   2257: aload 21
    //   2259: astore 20
    //   2261: aload 28
    //   2263: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2266: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2269: ifnull +34 -> 2303
    //   2272: aload 21
    //   2274: astore 20
    //   2276: aload 28
    //   2278: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2281: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2284: getfield 945	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2287: ifnull +16 -> 2303
    //   2290: aload 28
    //   2292: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2295: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2298: getfield 945	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2301: astore 20
    //   2303: aload 23
    //   2305: astore 22
    //   2307: aload 25
    //   2309: astore 21
    //   2311: aload 28
    //   2313: ifnull +70 -> 2383
    //   2316: aload 23
    //   2318: astore 22
    //   2320: aload 25
    //   2322: astore 21
    //   2324: aload 28
    //   2326: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2329: ifnull +54 -> 2383
    //   2332: aload 23
    //   2334: astore 22
    //   2336: aload 25
    //   2338: astore 21
    //   2340: aload 28
    //   2342: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2345: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2348: ifnull +35 -> 2383
    //   2351: aload 28
    //   2353: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2356: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2359: getfield 1139	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/util/Map;
    //   2362: invokestatic 1145	com/tencent/mobileqq/mini/apkg/MiniAppInfo:getReportDataString	(Ljava/util/Map;)Ljava/lang/String;
    //   2365: astore 22
    //   2367: aload 28
    //   2369: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2372: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2375: getfield 1148	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   2378: invokestatic 1150	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2381: astore 21
    //   2383: aload 24
    //   2385: astore 23
    //   2387: aload 28
    //   2389: ifnull +43 -> 2432
    //   2392: aload 24
    //   2394: astore 23
    //   2396: aload 28
    //   2398: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2401: ifnull +31 -> 2432
    //   2404: aload 24
    //   2406: astore 23
    //   2408: aload 28
    //   2410: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2413: getfield 1154	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2416: ifnull +16 -> 2432
    //   2419: aload 28
    //   2421: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2424: getfield 1154	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2427: getfield 1157	com/tencent/mobileqq/mini/apkg/MiniAppInfo:via	Ljava/lang/String;
    //   2430: astore 23
    //   2432: aload_0
    //   2433: aload_0
    //   2434: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2437: getfield 1117	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2440: lload 18
    //   2442: aload 26
    //   2444: aload_2
    //   2445: bipush 53
    //   2447: iload 7
    //   2449: iconst_0
    //   2450: aload 27
    //   2452: aload 20
    //   2454: aload 22
    //   2456: aload 21
    //   2458: aload 23
    //   2460: invokestatic 1161	com/tencent/mobileqq/mini/util/AdUtils:createAdRequest	(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)LNS_MINI_AD/MiniAppAd$StGetAdReq;
    //   2463: aload_3
    //   2464: aload_1
    //   2465: iload 4
    //   2467: iload 7
    //   2469: invokespecial 1163	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:sendAdRequest	(LNS_MINI_AD/MiniAppAd$StGetAdReq;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;II)V
    //   2472: goto -1107 -> 1365
    //   2475: ldc_w 1165
    //   2478: aload 21
    //   2480: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2483: ifeq +168 -> 2651
    //   2486: new 273	org/json/JSONObject
    //   2489: dup
    //   2490: new 273	org/json/JSONObject
    //   2493: dup
    //   2494: aload_2
    //   2495: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2498: ldc_w 989
    //   2501: invokevirtual 1167	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2504: ldc_w 989
    //   2507: invokevirtual 1167	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2510: ldc_w 306
    //   2513: invokevirtual 1170	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   2516: invokevirtual 1171	java/lang/Object:toString	()Ljava/lang/String;
    //   2519: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2522: astore_2
    //   2523: ldc_w 308
    //   2526: new 308	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   2529: dup
    //   2530: invokespecial 309	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   2533: aload_2
    //   2534: invokestatic 315	yxo:a	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   2537: invokevirtual 321	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2540: checkcast 308	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   2543: astore 20
    //   2545: new 1173	com/tencent/gdtad/aditem/GdtHandler$Params
    //   2548: dup
    //   2549: invokespecial 1174	com/tencent/gdtad/aditem/GdtHandler$Params:<init>	()V
    //   2552: astore_2
    //   2553: aload_2
    //   2554: bipush 11
    //   2556: putfield 1176	com/tencent/gdtad/aditem/GdtHandler$Params:c	I
    //   2559: aload_2
    //   2560: new 1178	java/lang/ref/WeakReference
    //   2563: dup
    //   2564: aload_0
    //   2565: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2568: getfield 1117	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2571: invokespecial 1181	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   2574: putfield 1184	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   2577: aload_2
    //   2578: new 1186	com/tencent/gdtad/aditem/GdtAd
    //   2581: dup
    //   2582: aload 20
    //   2584: invokespecial 1189	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   2587: putfield 1192	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_ComTencentGdtadAditemGdtAd	Lcom/tencent/gdtad/aditem/GdtAd;
    //   2590: aload_2
    //   2591: iconst_1
    //   2592: putfield 1195	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_Boolean	Z
    //   2595: aload_2
    //   2596: iconst_1
    //   2597: putfield 1197	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_b_of_type_Boolean	Z
    //   2600: aload_2
    //   2601: ldc_w 1199
    //   2604: putfield 1202	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_b_of_type_JavaLangClass	Ljava/lang/Class;
    //   2607: new 545	android/os/Bundle
    //   2610: dup
    //   2611: invokespecial 546	android/os/Bundle:<init>	()V
    //   2614: astore 20
    //   2616: aload 20
    //   2618: ldc_w 1204
    //   2621: ldc 8
    //   2623: invokevirtual 1207	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2626: aload_2
    //   2627: aload 20
    //   2629: putfield 1210	com/tencent/gdtad/aditem/GdtHandler$Params:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   2632: aload_2
    //   2633: invokestatic 1215	com/tencent/gdtad/aditem/GdtHandler:a	(Lcom/tencent/gdtad/aditem/GdtHandler$Params;)V
    //   2636: aload_0
    //   2637: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2640: aload_3
    //   2641: aload_1
    //   2642: aconst_null
    //   2643: iload 4
    //   2645: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2648: goto -1283 -> 1365
    //   2651: ldc_w 1217
    //   2654: aload 21
    //   2656: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2659: ifeq +63 -> 2722
    //   2662: aload 22
    //   2664: ldc_w 989
    //   2667: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2670: ldc_w 1219
    //   2673: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2676: astore_2
    //   2677: aload 22
    //   2679: ldc_w 989
    //   2682: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2685: ldc_w 1221
    //   2688: iconst_0
    //   2689: invokevirtual 1224	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2692: istore 8
    //   2694: iload 8
    //   2696: istore 7
    //   2698: iload 8
    //   2700: ifgt +8 -> 2708
    //   2703: sipush 30000
    //   2706: istore 7
    //   2708: aload_0
    //   2709: aload_2
    //   2710: iload 7
    //   2712: aload_3
    //   2713: aload_1
    //   2714: iload 4
    //   2716: invokespecial 1226	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2719: goto -1354 -> 1365
    //   2722: ldc_w 1228
    //   2725: aload 21
    //   2727: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2730: ifeq -1365 -> 1365
    //   2733: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2736: aload_0
    //   2737: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2740: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2743: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2746: aconst_null
    //   2747: new 1230	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6
    //   2750: dup
    //   2751: aload_0
    //   2752: aload_3
    //   2753: aload_1
    //   2754: iload 4
    //   2756: invokespecial 1231	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2759: invokevirtual 1235	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserHealthData	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2762: goto -1397 -> 1365
    //   2765: ldc 59
    //   2767: aload_1
    //   2768: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2771: ifeq +34 -> 2805
    //   2774: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2777: aload_0
    //   2778: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2781: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2784: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2787: new 1237	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7
    //   2790: dup
    //   2791: aload_0
    //   2792: aload_3
    //   2793: aload_1
    //   2794: iload 4
    //   2796: invokespecial 1238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2799: invokevirtual 1241	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkSession	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2802: goto -1437 -> 1365
    //   2805: ldc 83
    //   2807: aload_1
    //   2808: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2811: ifne +12 -> 2823
    //   2814: ldc 86
    //   2816: aload_1
    //   2817: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2820: ifeq +771 -> 3591
    //   2823: aload_0
    //   2824: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2827: ifnull +752 -> 3579
    //   2830: aload_0
    //   2831: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2834: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2837: ifnull +688 -> 3525
    //   2840: iconst_m1
    //   2841: istore 9
    //   2843: aload_2
    //   2844: ifnull +23 -> 2867
    //   2847: ldc_w 1243
    //   2850: aload_2
    //   2851: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2854: ifne +13 -> 2867
    //   2857: ldc_w 1245
    //   2860: aload_2
    //   2861: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2864: ifeq +103 -> 2967
    //   2867: iconst_0
    //   2868: istore 15
    //   2870: iconst_1
    //   2871: istore 13
    //   2873: iconst_1
    //   2874: istore 12
    //   2876: iconst_1
    //   2877: istore 9
    //   2879: iconst_1
    //   2880: istore 7
    //   2882: aload_0
    //   2883: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   2886: ifeq +412 -> 3298
    //   2889: aload_0
    //   2890: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   2893: astore_2
    //   2894: aload_2
    //   2895: ifnull +384 -> 3279
    //   2898: iload 13
    //   2900: iconst_1
    //   2901: if_icmpne +346 -> 3247
    //   2904: aload_2
    //   2905: iconst_1
    //   2906: putfield 1257	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   2909: iload 12
    //   2911: iconst_1
    //   2912: if_icmpne +343 -> 3255
    //   2915: aload_2
    //   2916: iconst_1
    //   2917: putfield 1260	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   2920: iload 9
    //   2922: iconst_1
    //   2923: if_icmpne +340 -> 3263
    //   2926: aload_2
    //   2927: iconst_1
    //   2928: putfield 1263	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   2931: iload 7
    //   2933: iconst_1
    //   2934: if_icmpne +337 -> 3271
    //   2937: aload_2
    //   2938: iconst_1
    //   2939: putfield 1266	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   2942: aload_2
    //   2943: iload 15
    //   2945: putfield 1269	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   2948: aload_0
    //   2949: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2952: aload_3
    //   2953: aload_1
    //   2954: aload_1
    //   2955: aconst_null
    //   2956: invokestatic 903	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   2959: iload 4
    //   2961: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2964: goto -1599 -> 1365
    //   2967: new 273	org/json/JSONObject
    //   2970: dup
    //   2971: aload_2
    //   2972: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2975: astore_2
    //   2976: aload_2
    //   2977: ldc_w 1270
    //   2980: iconst_0
    //   2981: invokevirtual 1004	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2984: istore 16
    //   2986: aload_2
    //   2987: ldc_w 1272
    //   2990: invokevirtual 1275	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   2993: checkcast 284	org/json/JSONArray
    //   2996: astore_2
    //   2997: aload_2
    //   2998: ifnonnull +6990 -> 9988
    //   3001: iconst_1
    //   3002: istore 13
    //   3004: iconst_1
    //   3005: istore 12
    //   3007: iconst_1
    //   3008: istore 9
    //   3010: iconst_1
    //   3011: istore 7
    //   3013: iload 16
    //   3015: istore 15
    //   3017: goto -135 -> 2882
    //   3020: iload 10
    //   3022: aload_2
    //   3023: invokevirtual 1278	org/json/JSONArray:length	()I
    //   3026: if_icmpge +76 -> 3102
    //   3029: aload_2
    //   3030: iload 10
    //   3032: invokevirtual 1280	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   3035: astore 20
    //   3037: aload 20
    //   3039: ldc 112
    //   3041: invokevirtual 1283	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3044: ifeq +6 -> 3050
    //   3047: iconst_1
    //   3048: istore 11
    //   3050: aload 20
    //   3052: ldc 115
    //   3054: invokevirtual 1283	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3057: ifeq +6 -> 3063
    //   3060: iconst_1
    //   3061: istore 7
    //   3063: aload 20
    //   3065: ldc 118
    //   3067: invokevirtual 1283	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3070: ifeq +6 -> 3076
    //   3073: iconst_1
    //   3074: istore 9
    //   3076: aload 20
    //   3078: ldc 121
    //   3080: invokevirtual 1283	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3083: istore 15
    //   3085: iload 15
    //   3087: ifeq +6 -> 3093
    //   3090: iconst_1
    //   3091: istore 8
    //   3093: iload 10
    //   3095: iconst_1
    //   3096: iadd
    //   3097: istore 10
    //   3099: goto -79 -> 3020
    //   3102: iload 11
    //   3104: istore 10
    //   3106: iload 11
    //   3108: iconst_m1
    //   3109: if_icmpne +6 -> 3115
    //   3112: iconst_0
    //   3113: istore 10
    //   3115: iload 7
    //   3117: istore 11
    //   3119: iload 7
    //   3121: iconst_m1
    //   3122: if_icmpne +6 -> 3128
    //   3125: iconst_0
    //   3126: istore 11
    //   3128: iload 9
    //   3130: iconst_m1
    //   3131: if_icmpne +6836 -> 9967
    //   3134: iconst_0
    //   3135: istore 14
    //   3137: iload 14
    //   3139: istore 9
    //   3141: iload 8
    //   3143: istore 7
    //   3145: iload 11
    //   3147: istore 12
    //   3149: iload 10
    //   3151: istore 13
    //   3153: iload 16
    //   3155: istore 15
    //   3157: iload 8
    //   3159: iconst_m1
    //   3160: if_icmpne -278 -> 2882
    //   3163: iconst_0
    //   3164: istore 7
    //   3166: iload 14
    //   3168: istore 9
    //   3170: iload 11
    //   3172: istore 12
    //   3174: iload 10
    //   3176: istore 13
    //   3178: iload 16
    //   3180: istore 15
    //   3182: goto -300 -> 2882
    //   3185: astore_2
    //   3186: aload_2
    //   3187: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   3190: ldc 139
    //   3192: iconst_1
    //   3193: aload_2
    //   3194: iconst_0
    //   3195: anewarray 666	java/lang/Object
    //   3198: invokestatic 1063	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3201: aload_0
    //   3202: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3205: ifeq +23 -> 3228
    //   3208: aload_0
    //   3209: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3212: aload_3
    //   3213: aload_1
    //   3214: aload_1
    //   3215: aconst_null
    //   3216: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3219: iload 4
    //   3221: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3224: ldc_w 664
    //   3227: areturn
    //   3228: aload_0
    //   3229: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3232: aload_3
    //   3233: aload_1
    //   3234: aload_1
    //   3235: aconst_null
    //   3236: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3239: iload 4
    //   3241: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3244: goto -20 -> 3224
    //   3247: aload_2
    //   3248: iconst_0
    //   3249: putfield 1257	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3252: goto -343 -> 2909
    //   3255: aload_2
    //   3256: iconst_0
    //   3257: putfield 1260	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3260: goto -340 -> 2920
    //   3263: aload_2
    //   3264: iconst_0
    //   3265: putfield 1263	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3268: goto -337 -> 2931
    //   3271: aload_2
    //   3272: iconst_0
    //   3273: putfield 1266	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3276: goto -334 -> 2942
    //   3279: aload_0
    //   3280: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3283: aload_3
    //   3284: aload_1
    //   3285: aload_1
    //   3286: aconst_null
    //   3287: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3290: iload 4
    //   3292: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3295: goto -1930 -> 1365
    //   3298: aload_0
    //   3299: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3302: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3305: invokevirtual 1287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3308: ifnull +198 -> 3506
    //   3311: aload_0
    //   3312: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3315: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3318: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3321: ifnull +185 -> 3506
    //   3324: iload 13
    //   3326: iconst_1
    //   3327: if_icmpne +111 -> 3438
    //   3330: aload_0
    //   3331: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3334: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3337: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3340: iconst_1
    //   3341: putfield 1294	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3344: iload 12
    //   3346: iconst_1
    //   3347: if_icmpne +108 -> 3455
    //   3350: aload_0
    //   3351: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3354: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3357: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3360: iconst_1
    //   3361: putfield 1295	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3364: iload 9
    //   3366: iconst_1
    //   3367: if_icmpne +105 -> 3472
    //   3370: aload_0
    //   3371: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3374: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3377: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3380: iconst_1
    //   3381: putfield 1296	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3384: iload 7
    //   3386: iconst_1
    //   3387: if_icmpne +102 -> 3489
    //   3390: aload_0
    //   3391: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3394: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3397: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3400: iconst_1
    //   3401: putfield 1297	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3404: aload_0
    //   3405: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3408: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3411: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3414: iload 15
    //   3416: putfield 1298	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3419: aload_0
    //   3420: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3423: aload_3
    //   3424: aload_1
    //   3425: aload_1
    //   3426: aconst_null
    //   3427: invokestatic 903	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3430: iload 4
    //   3432: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3435: goto -2070 -> 1365
    //   3438: aload_0
    //   3439: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3442: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3445: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3448: iconst_0
    //   3449: putfield 1294	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3452: goto -108 -> 3344
    //   3455: aload_0
    //   3456: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3459: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3462: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3465: iconst_0
    //   3466: putfield 1295	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3469: goto -105 -> 3364
    //   3472: aload_0
    //   3473: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3476: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3479: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3482: iconst_0
    //   3483: putfield 1296	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3486: goto -102 -> 3384
    //   3489: aload_0
    //   3490: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3493: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3496: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3499: iconst_0
    //   3500: putfield 1297	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3503: goto -99 -> 3404
    //   3506: aload_0
    //   3507: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3510: aload_3
    //   3511: aload_1
    //   3512: aload_1
    //   3513: aconst_null
    //   3514: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3517: iload 4
    //   3519: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3522: goto -2157 -> 1365
    //   3525: ldc 139
    //   3527: iconst_1
    //   3528: ldc_w 1300
    //   3531: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3534: aload_0
    //   3535: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3538: ifeq +22 -> 3560
    //   3541: aload_0
    //   3542: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3545: aload_3
    //   3546: aload_1
    //   3547: aload_1
    //   3548: aconst_null
    //   3549: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3552: iload 4
    //   3554: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3557: goto -2192 -> 1365
    //   3560: aload_0
    //   3561: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3564: aload_3
    //   3565: aload_1
    //   3566: aload_1
    //   3567: aconst_null
    //   3568: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3571: iload 4
    //   3573: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3576: goto -2211 -> 1365
    //   3579: ldc 139
    //   3581: iconst_1
    //   3582: ldc_w 1302
    //   3585: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3588: goto -2223 -> 1365
    //   3591: ldc 89
    //   3593: aload_1
    //   3594: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3597: ifeq +220 -> 3817
    //   3600: new 273	org/json/JSONObject
    //   3603: dup
    //   3604: aload_2
    //   3605: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3608: astore_2
    //   3609: aload_2
    //   3610: ldc_w 1270
    //   3613: iconst_0
    //   3614: invokevirtual 1004	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3617: istore 15
    //   3619: aload_2
    //   3620: ldc_w 1304
    //   3623: invokevirtual 1054	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   3626: pop
    //   3627: aload_2
    //   3628: ldc_w 1306
    //   3631: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3634: pop
    //   3635: aload_2
    //   3636: ldc_w 1308
    //   3639: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3642: pop
    //   3643: aload_0
    //   3644: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3647: ifeq +91 -> 3738
    //   3650: aload_0
    //   3651: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3654: astore_2
    //   3655: aload_2
    //   3656: ifnull +63 -> 3719
    //   3659: aload_2
    //   3660: iload 15
    //   3662: putfield 1269	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3665: aload_0
    //   3666: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3669: aload_3
    //   3670: aload_1
    //   3671: aload_1
    //   3672: aconst_null
    //   3673: invokestatic 903	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3676: iload 4
    //   3678: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3681: aload_0
    //   3682: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3685: aload_3
    //   3686: aload_1
    //   3687: aload_1
    //   3688: aconst_null
    //   3689: invokestatic 903	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3692: iload 4
    //   3694: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3697: goto -2332 -> 1365
    //   3700: astore_1
    //   3701: ldc 139
    //   3703: iconst_1
    //   3704: aload_1
    //   3705: iconst_0
    //   3706: anewarray 666	java/lang/Object
    //   3709: invokestatic 1063	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3712: aload_1
    //   3713: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   3716: goto -2351 -> 1365
    //   3719: aload_0
    //   3720: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3723: aload_3
    //   3724: aload_1
    //   3725: aload_1
    //   3726: aconst_null
    //   3727: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3730: iload 4
    //   3732: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3735: goto -54 -> 3681
    //   3738: aload_0
    //   3739: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3742: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3745: invokevirtual 1287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3748: ifnull +50 -> 3798
    //   3751: aload_0
    //   3752: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3755: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3758: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3761: ifnull +37 -> 3798
    //   3764: aload_0
    //   3765: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3768: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3771: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3774: iload 15
    //   3776: putfield 1298	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3779: aload_0
    //   3780: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3783: aload_3
    //   3784: aload_1
    //   3785: aload_1
    //   3786: aconst_null
    //   3787: invokestatic 903	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3790: iload 4
    //   3792: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3795: goto -114 -> 3681
    //   3798: aload_0
    //   3799: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3802: aload_3
    //   3803: aload_1
    //   3804: aload_1
    //   3805: aconst_null
    //   3806: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3809: iload 4
    //   3811: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3814: goto -133 -> 3681
    //   3817: ldc 32
    //   3819: aload_1
    //   3820: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3823: ifeq +79 -> 3902
    //   3826: new 273	org/json/JSONObject
    //   3829: dup
    //   3830: aload_2
    //   3831: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3834: astore_2
    //   3835: aload_2
    //   3836: ldc_w 1219
    //   3839: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3842: astore 20
    //   3844: aload_2
    //   3845: ldc_w 1221
    //   3848: iconst_0
    //   3849: invokevirtual 1224	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3852: istore 8
    //   3854: iload 8
    //   3856: istore 7
    //   3858: iload 8
    //   3860: ifgt +8 -> 3868
    //   3863: sipush 30000
    //   3866: istore 7
    //   3868: aload_0
    //   3869: aload 20
    //   3871: iload 7
    //   3873: aload_3
    //   3874: aload_1
    //   3875: iload 4
    //   3877: invokespecial 1226	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   3880: goto -2515 -> 1365
    //   3883: astore_1
    //   3884: ldc 139
    //   3886: iconst_1
    //   3887: aload_1
    //   3888: iconst_0
    //   3889: anewarray 666	java/lang/Object
    //   3892: invokestatic 1063	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3895: aload_1
    //   3896: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   3899: goto -2534 -> 1365
    //   3902: ldc 68
    //   3904: aload_1
    //   3905: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3908: ifne +21 -> 3929
    //   3911: ldc 65
    //   3913: aload_1
    //   3914: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3917: ifne +12 -> 3929
    //   3920: ldc 71
    //   3922: aload_1
    //   3923: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3926: ifeq +1371 -> 5297
    //   3929: iconst_0
    //   3930: istore 15
    //   3932: ldc 68
    //   3934: aload_1
    //   3935: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3938: ifeq +6 -> 3944
    //   3941: iconst_1
    //   3942: istore 15
    //   3944: new 273	org/json/JSONObject
    //   3947: dup
    //   3948: aload_2
    //   3949: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3952: astore 23
    //   3954: aload 23
    //   3956: ldc_w 1310
    //   3959: iconst_m1
    //   3960: invokevirtual 1224	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3963: istore 9
    //   3965: iconst_m1
    //   3966: istore 7
    //   3968: aconst_null
    //   3969: astore 22
    //   3971: iload 9
    //   3973: ifne +6050 -> 10023
    //   3976: iconst_0
    //   3977: istore 7
    //   3979: aconst_null
    //   3980: astore_2
    //   3981: aload 23
    //   3983: ldc_w 1312
    //   3986: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3989: astore 25
    //   3991: aload 23
    //   3993: ldc_w 1314
    //   3996: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3999: astore 26
    //   4001: ldc 68
    //   4003: aload_1
    //   4004: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4007: ifne +5996 -> 10003
    //   4010: ldc 71
    //   4012: aload_1
    //   4013: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4016: ifeq +29 -> 4045
    //   4019: goto +5984 -> 10003
    //   4022: aload_0
    //   4023: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4026: ifeq +510 -> 4536
    //   4029: aload_0
    //   4030: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4033: ifnull +503 -> 4536
    //   4036: aload_0
    //   4037: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4040: iload 8
    //   4042: putfield 1317	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4045: aload_0
    //   4046: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4049: ifeq +524 -> 4573
    //   4052: aload_0
    //   4053: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4056: ifnull +517 -> 4573
    //   4059: aload_0
    //   4060: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4063: aload_1
    //   4064: putfield 1320	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   4067: aload_0
    //   4068: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4071: iload 4
    //   4073: putfield 1323	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   4076: aload 23
    //   4078: ldc_w 1325
    //   4081: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4084: astore 20
    //   4086: aload 20
    //   4088: astore 21
    //   4090: aload 20
    //   4092: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4095: ifeq +13 -> 4108
    //   4098: aload 23
    //   4100: ldc_w 1327
    //   4103: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4106: astore 21
    //   4108: aload 23
    //   4110: ldc_w 1329
    //   4113: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4116: astore 24
    //   4118: aload 23
    //   4120: ldc_w 1331
    //   4123: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4126: astore 27
    //   4128: aload 23
    //   4130: ldc_w 1333
    //   4133: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4136: astore 23
    //   4138: aload 21
    //   4140: astore 20
    //   4142: aload 21
    //   4144: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4147: ifeq +15 -> 4162
    //   4150: aload_0
    //   4151: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4154: ifeq +451 -> 4605
    //   4157: ldc_w 1335
    //   4160: astore 20
    //   4162: new 1337	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8
    //   4165: dup
    //   4166: aload_0
    //   4167: aload_3
    //   4168: aload_1
    //   4169: iload 4
    //   4171: invokespecial 1338	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   4174: astore_1
    //   4175: aload_0
    //   4176: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4179: ifeq +21 -> 4200
    //   4182: aload_0
    //   4183: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4186: ifnull +14 -> 4200
    //   4189: aload_0
    //   4190: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4193: getfield 1317	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4196: iconst_1
    //   4197: if_icmpeq +27 -> 4224
    //   4200: aload_0
    //   4201: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4204: ifne +506 -> 4710
    //   4207: aload_0
    //   4208: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4211: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4214: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4217: getfield 1339	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4220: iconst_1
    //   4221: if_icmpne +489 -> 4710
    //   4224: aload 27
    //   4226: ldc_w 1341
    //   4229: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4232: ifne +14 -> 4246
    //   4235: aload 27
    //   4237: ldc_w 1343
    //   4240: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4243: ifeq +383 -> 4626
    //   4246: aload_0
    //   4247: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4250: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4253: aload 24
    //   4255: aload 27
    //   4257: aload 20
    //   4259: aload_0
    //   4260: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4263: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4266: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4269: iload 15
    //   4271: invokestatic 1347	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4274: goto +5745 -> 10019
    //   4277: iload 9
    //   4279: iconst_2
    //   4280: if_icmpne +5757 -> 10037
    //   4283: iconst_0
    //   4284: istore 7
    //   4286: aload 23
    //   4288: ldc_w 1349
    //   4291: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4294: astore_2
    //   4295: aload_2
    //   4296: ifnull +80 -> 4376
    //   4299: aload_0
    //   4300: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4303: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4306: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4309: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4312: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4315: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4318: ifnull +58 -> 4376
    //   4321: aload_2
    //   4322: aload_0
    //   4323: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4326: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4329: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4332: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4335: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4338: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4341: invokevirtual 1358	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   4344: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4347: ifeq +29 -> 4376
    //   4350: aload_0
    //   4351: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4354: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4357: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4360: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4363: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4366: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4369: astore 22
    //   4371: aconst_null
    //   4372: astore_2
    //   4373: goto -392 -> 3981
    //   4376: ldc 139
    //   4378: iconst_1
    //   4379: new 323	java/lang/StringBuilder
    //   4382: dup
    //   4383: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   4386: ldc_w 1360
    //   4389: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4392: aload_2
    //   4393: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4396: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4399: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4402: aconst_null
    //   4403: astore_2
    //   4404: goto -423 -> 3981
    //   4407: iload 9
    //   4409: iconst_5
    //   4410: if_icmpne +102 -> 4512
    //   4413: aload 23
    //   4415: ldc_w 1362
    //   4418: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4421: astore 20
    //   4423: aload_0
    //   4424: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4427: ifeq +37 -> 4464
    //   4430: aload_0
    //   4431: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4434: ifnull +30 -> 4464
    //   4437: aload_0
    //   4438: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4441: getfield 1366	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4444: astore_2
    //   4445: aload_2
    //   4446: ifnull +35 -> 4481
    //   4449: aload_2
    //   4450: invokevirtual 1369	com/tencent/mobileqq/mini/sdk/ShareChatModel:getEntryHash	()Ljava/lang/String;
    //   4453: aload 20
    //   4455: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4458: ifeq +23 -> 4481
    //   4461: goto +5604 -> 10065
    //   4464: aload_0
    //   4465: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4468: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4471: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4474: getfield 1370	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4477: astore_2
    //   4478: goto -33 -> 4445
    //   4481: ldc 139
    //   4483: iconst_1
    //   4484: new 323	java/lang/StringBuilder
    //   4487: dup
    //   4488: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   4491: ldc_w 1360
    //   4494: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4497: aconst_null
    //   4498: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4501: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4504: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4507: aconst_null
    //   4508: astore_2
    //   4509: goto +5556 -> 10065
    //   4512: iload 9
    //   4514: bipush 6
    //   4516: if_icmpne +5446 -> 9962
    //   4519: ldc 71
    //   4521: aload_1
    //   4522: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4525: ifeq +5437 -> 9962
    //   4528: iconst_0
    //   4529: istore 7
    //   4531: aconst_null
    //   4532: astore_2
    //   4533: goto -552 -> 3981
    //   4536: aload_0
    //   4537: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4540: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4543: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4546: iload 8
    //   4548: putfield 1339	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4551: goto -506 -> 4045
    //   4554: astore_1
    //   4555: ldc 139
    //   4557: iconst_1
    //   4558: aload_1
    //   4559: iconst_0
    //   4560: anewarray 666	java/lang/Object
    //   4563: invokestatic 1063	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4566: aload_1
    //   4567: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   4570: goto -3205 -> 1365
    //   4573: aload_0
    //   4574: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4577: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4580: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4583: aload_1
    //   4584: putfield 1371	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   4587: aload_0
    //   4588: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4591: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4594: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4597: iload 4
    //   4599: putfield 1372	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   4602: goto -526 -> 4076
    //   4605: aload_0
    //   4606: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4609: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4612: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4615: invokevirtual 760	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   4618: getfield 952	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   4621: astore 20
    //   4623: goto -461 -> 4162
    //   4626: aload_0
    //   4627: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4630: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4633: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4636: pop
    //   4637: invokestatic 1377	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   4640: aload 27
    //   4642: invokevirtual 1380	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   4645: astore_1
    //   4646: aload_1
    //   4647: invokestatic 1384	bbkk:a	(Ljava/lang/String;)Z
    //   4650: ifne +33 -> 4683
    //   4653: aload_0
    //   4654: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4657: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4660: aload 24
    //   4662: aload_1
    //   4663: aload 20
    //   4665: aload_0
    //   4666: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4669: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4672: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4675: iload 15
    //   4677: invokestatic 1347	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4680: goto +5339 -> 10019
    //   4683: aload_0
    //   4684: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4687: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4690: new 1386	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9
    //   4693: dup
    //   4694: aload_0
    //   4695: aload 24
    //   4697: aload 20
    //   4699: iload 15
    //   4701: invokespecial 1389	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4704: invokevirtual 1393	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   4707: goto +5312 -> 10019
    //   4710: aload_0
    //   4711: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4714: ifeq +21 -> 4735
    //   4717: aload_0
    //   4718: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4721: ifnull +14 -> 4735
    //   4724: aload_0
    //   4725: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4728: getfield 1317	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4731: iconst_3
    //   4732: if_icmpeq +27 -> 4759
    //   4735: aload_0
    //   4736: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4739: ifne +55 -> 4794
    //   4742: aload_0
    //   4743: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4746: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4749: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4752: getfield 1339	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4755: iconst_3
    //   4756: if_icmpne +38 -> 4794
    //   4759: aload_0
    //   4760: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4763: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4766: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4769: astore_1
    //   4770: aload_0
    //   4771: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4774: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4777: aload 24
    //   4779: aload_1
    //   4780: getfield 1396	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   4783: aload 20
    //   4785: iconst_3
    //   4786: aload_1
    //   4787: invokestatic 1400	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   4790: ldc_w 664
    //   4793: areturn
    //   4794: aload_0
    //   4795: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4798: ifeq +21 -> 4819
    //   4801: aload_0
    //   4802: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4805: ifnull +14 -> 4819
    //   4808: aload_0
    //   4809: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4812: getfield 1317	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4815: iconst_4
    //   4816: if_icmpeq +27 -> 4843
    //   4819: aload_0
    //   4820: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4823: ifne +55 -> 4878
    //   4826: aload_0
    //   4827: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4830: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4833: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4836: getfield 1339	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4839: iconst_4
    //   4840: if_icmpne +38 -> 4878
    //   4843: aload_0
    //   4844: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4847: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4850: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4853: astore_1
    //   4854: aload_0
    //   4855: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4858: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4861: aload 24
    //   4863: aload_1
    //   4864: getfield 1396	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   4867: aload 20
    //   4869: iconst_4
    //   4870: aload_1
    //   4871: invokestatic 1400	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   4874: ldc_w 664
    //   4877: areturn
    //   4878: aload 27
    //   4880: invokestatic 1405	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   4883: ifne +5188 -> 10071
    //   4886: aload 27
    //   4888: invokestatic 1408	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   4891: ifeq +5186 -> 10077
    //   4894: goto +5177 -> 10071
    //   4897: aload_0
    //   4898: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4901: ifnull +5182 -> 10083
    //   4904: aload_0
    //   4905: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4908: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4911: ifnull +5172 -> 10083
    //   4914: aload 27
    //   4916: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4919: ifne +5164 -> 10083
    //   4922: new 586	java/io/File
    //   4925: dup
    //   4926: invokestatic 1377	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   4929: aload 27
    //   4931: invokevirtual 1380	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   4934: invokespecial 593	java/io/File:<init>	(Ljava/lang/String;)V
    //   4937: invokevirtual 1411	java/io/File:exists	()Z
    //   4940: ifeq +5143 -> 10083
    //   4943: iconst_1
    //   4944: istore 17
    //   4946: aload 27
    //   4948: invokestatic 1384	bbkk:a	(Ljava/lang/String;)Z
    //   4951: ifne +13 -> 4964
    //   4954: iload 16
    //   4956: ifne +197 -> 5153
    //   4959: iload 17
    //   4961: ifne +192 -> 5153
    //   4964: aload_0
    //   4965: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4968: ifeq +110 -> 5078
    //   4971: aload_0
    //   4972: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4975: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4978: astore_3
    //   4979: invokestatic 1416	com/tencent/mobileqq/minigame/utils/GameWnsUtils:defaultShareImg	()Ljava/lang/String;
    //   4982: astore 21
    //   4984: iload 15
    //   4986: ifeq +5103 -> 10089
    //   4989: bipush 11
    //   4991: istore 4
    //   4993: aload_3
    //   4994: aload 24
    //   4996: aload 21
    //   4998: aload 20
    //   5000: aload 23
    //   5002: aload 25
    //   5004: aload 26
    //   5006: aload 22
    //   5008: aload_2
    //   5009: iload 4
    //   5011: iload 9
    //   5013: ldc_w 664
    //   5016: aload_1
    //   5017: invokevirtual 1420	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5020: ldc 139
    //   5022: iconst_1
    //   5023: new 323	java/lang/StringBuilder
    //   5026: dup
    //   5027: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   5030: ldc_w 1422
    //   5033: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5036: iload 16
    //   5038: invokevirtual 809	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5041: ldc_w 1424
    //   5044: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5047: iload 17
    //   5049: invokevirtual 809	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5052: ldc_w 1426
    //   5055: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5058: aload 27
    //   5060: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5063: ldc_w 1428
    //   5066: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5069: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5072: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5075: goto -3710 -> 1365
    //   5078: aload_0
    //   5079: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5082: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5085: ifnull -3720 -> 1365
    //   5088: aload_0
    //   5089: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5092: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5095: getfield 1431	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5098: ifeq +16 -> 5114
    //   5101: ldc 139
    //   5103: iconst_1
    //   5104: ldc_w 1433
    //   5107: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5110: ldc_w 664
    //   5113: areturn
    //   5114: aload_0
    //   5115: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5118: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5121: new 1435	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10
    //   5124: dup
    //   5125: aload_0
    //   5126: aload 24
    //   5128: aload 20
    //   5130: aload 23
    //   5132: aload 25
    //   5134: aload 26
    //   5136: aload 22
    //   5138: aload_2
    //   5139: iload 15
    //   5141: iload 9
    //   5143: aload_1
    //   5144: invokespecial 1438	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;ZILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5147: invokevirtual 1393	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5150: goto -3785 -> 1365
    //   5153: aload 27
    //   5155: ldc_w 1341
    //   5158: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5161: ifne +14 -> 5175
    //   5164: aload 27
    //   5166: ldc_w 1343
    //   5169: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5172: ifeq +50 -> 5222
    //   5175: aload_0
    //   5176: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5179: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5182: astore_3
    //   5183: iload 15
    //   5185: ifeq +4911 -> 10096
    //   5188: bipush 11
    //   5190: istore 4
    //   5192: aload_3
    //   5193: aload 24
    //   5195: aload 27
    //   5197: aload 20
    //   5199: aload 23
    //   5201: aload 25
    //   5203: aload 26
    //   5205: aload 22
    //   5207: aload_2
    //   5208: iload 4
    //   5210: iload 9
    //   5212: ldc_w 664
    //   5215: aload_1
    //   5216: invokevirtual 1420	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5219: goto -3854 -> 1365
    //   5222: aload_0
    //   5223: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5226: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5229: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5232: pop
    //   5233: invokestatic 1377	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5236: aload 27
    //   5238: invokevirtual 1380	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5241: astore_3
    //   5242: aload_0
    //   5243: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5246: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5249: astore 21
    //   5251: iload 15
    //   5253: ifeq +37 -> 5290
    //   5256: bipush 11
    //   5258: istore 4
    //   5260: aload 21
    //   5262: aload 24
    //   5264: aload_3
    //   5265: aload 20
    //   5267: aload 23
    //   5269: aload 25
    //   5271: aload 26
    //   5273: aload 22
    //   5275: aload_2
    //   5276: iload 4
    //   5278: iload 9
    //   5280: ldc_w 664
    //   5283: aload_1
    //   5284: invokevirtual 1420	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5287: goto -3922 -> 1365
    //   5290: bipush 12
    //   5292: istore 4
    //   5294: goto -34 -> 5260
    //   5297: ldc 74
    //   5299: aload_1
    //   5300: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5303: ifne +12 -> 5315
    //   5306: ldc 77
    //   5308: aload_1
    //   5309: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5312: ifeq +531 -> 5843
    //   5315: new 273	org/json/JSONObject
    //   5318: dup
    //   5319: aload_2
    //   5320: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5323: astore_2
    //   5324: aload_2
    //   5325: ldc_w 1310
    //   5328: iconst_m1
    //   5329: invokevirtual 1224	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5332: istore 8
    //   5334: iconst_m1
    //   5335: istore 7
    //   5337: iload 8
    //   5339: ifne +242 -> 5581
    //   5342: iconst_0
    //   5343: istore 7
    //   5345: ldc 77
    //   5347: aload_1
    //   5348: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5351: ifeq +39 -> 5390
    //   5354: iload 7
    //   5356: istore 8
    //   5358: iload 7
    //   5360: iconst_m1
    //   5361: if_icmpne +6 -> 5367
    //   5364: iconst_0
    //   5365: istore 8
    //   5367: aload_0
    //   5368: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5371: ifeq +258 -> 5629
    //   5374: aload_0
    //   5375: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5378: ifnull +251 -> 5629
    //   5381: aload_0
    //   5382: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5385: iload 8
    //   5387: putfield 1317	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5390: aload_0
    //   5391: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5394: ifeq +253 -> 5647
    //   5397: aload_0
    //   5398: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5401: ifnull +246 -> 5647
    //   5404: aload_0
    //   5405: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5408: getfield 1317	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5411: istore 7
    //   5413: aload_0
    //   5414: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5417: ifeq +248 -> 5665
    //   5420: aload_0
    //   5421: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5424: ifnull +241 -> 5665
    //   5427: aload_0
    //   5428: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5431: aload_1
    //   5432: putfield 1320	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   5435: aload_0
    //   5436: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5439: iload 4
    //   5441: putfield 1323	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   5444: new 1440	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11
    //   5447: dup
    //   5448: aload_0
    //   5449: aload_3
    //   5450: aload_1
    //   5451: iload 4
    //   5453: invokespecial 1441	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   5456: astore_1
    //   5457: aload_0
    //   5458: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5461: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5464: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5467: astore_3
    //   5468: aload_2
    //   5469: ldc_w 1329
    //   5472: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5475: astore 20
    //   5477: aload_2
    //   5478: ldc_w 1331
    //   5481: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5484: astore_2
    //   5485: aload_2
    //   5486: invokestatic 1405	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   5489: ifne +4614 -> 10103
    //   5492: aload_2
    //   5493: invokestatic 1408	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   5496: ifeq +4613 -> 10109
    //   5499: goto +4604 -> 10103
    //   5502: invokestatic 1377	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5505: aload_2
    //   5506: invokevirtual 1380	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5509: astore 21
    //   5511: aload_0
    //   5512: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5515: ifnull +4600 -> 10115
    //   5518: aload_0
    //   5519: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5522: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5525: ifnull +4590 -> 10115
    //   5528: aload_2
    //   5529: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5532: ifne +4583 -> 10115
    //   5535: new 586	java/io/File
    //   5538: dup
    //   5539: aload 21
    //   5541: invokespecial 593	java/io/File:<init>	(Ljava/lang/String;)V
    //   5544: invokevirtual 1411	java/io/File:exists	()Z
    //   5547: ifeq +4568 -> 10115
    //   5550: iconst_1
    //   5551: istore 8
    //   5553: iload 4
    //   5555: ifeq +142 -> 5697
    //   5558: aload_0
    //   5559: aload 22
    //   5561: aload 20
    //   5563: aload_2
    //   5564: iload 7
    //   5566: aload_1
    //   5567: invokespecial 186	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5570: goto -4205 -> 1365
    //   5573: astore_1
    //   5574: aload_1
    //   5575: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   5578: goto -4213 -> 1365
    //   5581: iload 8
    //   5583: iconst_1
    //   5584: if_icmpne +9 -> 5593
    //   5587: iconst_1
    //   5588: istore 7
    //   5590: goto -245 -> 5345
    //   5593: iload 8
    //   5595: iconst_2
    //   5596: if_icmpne +9 -> 5605
    //   5599: iconst_0
    //   5600: istore 7
    //   5602: goto -257 -> 5345
    //   5605: iload 8
    //   5607: iconst_3
    //   5608: if_icmpne +9 -> 5617
    //   5611: iconst_3
    //   5612: istore 7
    //   5614: goto -269 -> 5345
    //   5617: iload 8
    //   5619: iconst_4
    //   5620: if_icmpne -275 -> 5345
    //   5623: iconst_4
    //   5624: istore 7
    //   5626: goto -281 -> 5345
    //   5629: aload_0
    //   5630: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5633: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5636: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5639: iload 8
    //   5641: putfield 1339	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5644: goto -254 -> 5390
    //   5647: aload_0
    //   5648: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5651: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5654: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5657: getfield 1339	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5660: istore 7
    //   5662: goto -249 -> 5413
    //   5665: aload_0
    //   5666: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5669: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5672: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5675: aload_1
    //   5676: putfield 1371	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   5679: aload_0
    //   5680: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5683: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5686: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5689: iload 4
    //   5691: putfield 1372	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   5694: goto -250 -> 5444
    //   5697: aload_2
    //   5698: invokestatic 1384	bbkk:a	(Ljava/lang/String;)Z
    //   5701: ifne +13 -> 5714
    //   5704: iload 4
    //   5706: ifne +114 -> 5820
    //   5709: iload 8
    //   5711: ifne +109 -> 5820
    //   5714: aload_0
    //   5715: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5718: ifeq +37 -> 5755
    //   5721: aload_3
    //   5722: ifnull +21 -> 5743
    //   5725: aload_0
    //   5726: aload 22
    //   5728: aload 20
    //   5730: aload_3
    //   5731: getfield 1396	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5734: iload 7
    //   5736: aload_1
    //   5737: invokespecial 186	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5740: goto -4375 -> 1365
    //   5743: ldc 139
    //   5745: iconst_1
    //   5746: ldc_w 1443
    //   5749: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5752: goto -4387 -> 1365
    //   5755: aload_0
    //   5756: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5759: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5762: ifnull -4397 -> 1365
    //   5765: aload_0
    //   5766: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5769: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5772: getfield 1431	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5775: ifeq +16 -> 5791
    //   5778: ldc 139
    //   5780: iconst_1
    //   5781: ldc_w 1445
    //   5784: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5787: ldc_w 664
    //   5790: areturn
    //   5791: aload_0
    //   5792: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5795: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5798: new 1447	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12
    //   5801: dup
    //   5802: aload_0
    //   5803: aload_3
    //   5804: aload 22
    //   5806: aload 20
    //   5808: iload 7
    //   5810: aload_1
    //   5811: invokespecial 1450	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Landroid/app/Activity;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5814: invokevirtual 1393	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5817: goto -4452 -> 1365
    //   5820: iload 4
    //   5822: ifne -4457 -> 1365
    //   5825: iload 8
    //   5827: ifeq -4462 -> 1365
    //   5830: aload_0
    //   5831: aload 20
    //   5833: aload 21
    //   5835: iload 7
    //   5837: invokespecial 192	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareLocalPicMessage	(Ljava/lang/String;Ljava/lang/String;I)V
    //   5840: goto -4475 -> 1365
    //   5843: ldc 44
    //   5845: aload_1
    //   5846: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5849: ifeq +380 -> 6229
    //   5852: aload_0
    //   5853: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5856: ifnull -4491 -> 1365
    //   5859: aload_0
    //   5860: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5863: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5866: ifnull -4501 -> 1365
    //   5869: iconst_m1
    //   5870: istore 8
    //   5872: iconst_m1
    //   5873: istore 7
    //   5875: new 273	org/json/JSONObject
    //   5878: dup
    //   5879: aload_2
    //   5880: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5883: ldc_w 1452
    //   5886: invokevirtual 1275	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   5889: checkcast 284	org/json/JSONArray
    //   5892: astore_2
    //   5893: aload_2
    //   5894: ifnonnull +95 -> 5989
    //   5897: iconst_0
    //   5898: istore 10
    //   5900: iconst_0
    //   5901: istore 9
    //   5903: iconst_m1
    //   5904: istore 8
    //   5906: aload_0
    //   5907: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5910: ifeq +179 -> 6089
    //   5913: aload_0
    //   5914: invokevirtual 1252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5917: astore_2
    //   5918: aload_2
    //   5919: ifnull +151 -> 6070
    //   5922: iload 10
    //   5924: ifne +8 -> 5932
    //   5927: aload_2
    //   5928: iconst_0
    //   5929: putfield 1257	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   5932: iload 9
    //   5934: ifne +8 -> 5942
    //   5937: aload_2
    //   5938: iconst_0
    //   5939: putfield 1260	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   5942: iload 8
    //   5944: ifne +8 -> 5952
    //   5947: aload_2
    //   5948: iconst_0
    //   5949: putfield 1263	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   5952: iload 7
    //   5954: ifne +8 -> 5962
    //   5957: aload_2
    //   5958: iconst_0
    //   5959: putfield 1266	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   5962: aload_0
    //   5963: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5966: aload_3
    //   5967: aload_1
    //   5968: aload_1
    //   5969: aconst_null
    //   5970: invokestatic 903	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   5973: iload 4
    //   5975: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   5978: goto -4613 -> 1365
    //   5981: astore_1
    //   5982: aload_1
    //   5983: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   5986: goto -4621 -> 1365
    //   5989: iconst_m1
    //   5990: istore 9
    //   5992: iconst_m1
    //   5993: istore 10
    //   5995: iconst_0
    //   5996: istore 11
    //   5998: iload 11
    //   6000: aload_2
    //   6001: invokevirtual 1278	org/json/JSONArray:length	()I
    //   6004: if_icmpge +3955 -> 9959
    //   6007: aload_2
    //   6008: iload 11
    //   6010: invokevirtual 1280	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6013: astore 20
    //   6015: aload 20
    //   6017: ldc 112
    //   6019: invokevirtual 1283	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6022: ifeq +6 -> 6028
    //   6025: iconst_0
    //   6026: istore 10
    //   6028: aload 20
    //   6030: ldc 115
    //   6032: invokevirtual 1283	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6035: ifeq +6 -> 6041
    //   6038: iconst_0
    //   6039: istore 9
    //   6041: aload 20
    //   6043: ldc 118
    //   6045: invokevirtual 1283	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6048: ifeq +6 -> 6054
    //   6051: iconst_1
    //   6052: istore 8
    //   6054: aload 20
    //   6056: ldc 121
    //   6058: invokevirtual 1283	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6061: ifeq +4060 -> 10121
    //   6064: iconst_1
    //   6065: istore 7
    //   6067: goto +4054 -> 10121
    //   6070: aload_0
    //   6071: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6074: aload_3
    //   6075: aload_1
    //   6076: aload_1
    //   6077: aconst_null
    //   6078: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6081: iload 4
    //   6083: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6086: goto -4721 -> 1365
    //   6089: aload_0
    //   6090: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6093: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6096: invokevirtual 1287	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   6099: ifnull +111 -> 6210
    //   6102: aload_0
    //   6103: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6106: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6109: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6112: ifnull +98 -> 6210
    //   6115: iload 10
    //   6117: ifne +17 -> 6134
    //   6120: aload_0
    //   6121: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6124: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6127: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6130: iconst_0
    //   6131: putfield 1294	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   6134: iload 9
    //   6136: ifne +17 -> 6153
    //   6139: aload_0
    //   6140: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6143: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6146: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6149: iconst_0
    //   6150: putfield 1295	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   6153: iload 8
    //   6155: ifne +17 -> 6172
    //   6158: aload_0
    //   6159: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6162: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6165: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6168: iconst_0
    //   6169: putfield 1296	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   6172: iload 7
    //   6174: ifne +17 -> 6191
    //   6177: aload_0
    //   6178: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6181: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6184: invokevirtual 1291	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6187: iconst_0
    //   6188: putfield 1297	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   6191: aload_0
    //   6192: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6195: aload_3
    //   6196: aload_1
    //   6197: aload_1
    //   6198: aconst_null
    //   6199: invokestatic 903	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6202: iload 4
    //   6204: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6207: goto -4842 -> 1365
    //   6210: aload_0
    //   6211: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6214: aload_3
    //   6215: aload_1
    //   6216: aload_1
    //   6217: aconst_null
    //   6218: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6221: iload 4
    //   6223: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6226: goto -4861 -> 1365
    //   6229: ldc_w 1454
    //   6232: aload_1
    //   6233: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6236: ifeq +298 -> 6534
    //   6239: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6242: invokevirtual 1010	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6245: astore 20
    //   6247: aload 20
    //   6249: instanceof 1012
    //   6252: ifeq +3701 -> 9953
    //   6255: aload 20
    //   6257: checkcast 1012	com/tencent/mobileqq/mini/MiniAppInterface
    //   6260: astore 20
    //   6262: aload 20
    //   6264: ifnonnull +18 -> 6282
    //   6267: aload_0
    //   6268: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6271: aload_3
    //   6272: aload_1
    //   6273: aconst_null
    //   6274: iload 4
    //   6276: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6279: goto -4914 -> 1365
    //   6282: new 273	org/json/JSONObject
    //   6285: dup
    //   6286: aload_2
    //   6287: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6290: ldc_w 1456
    //   6293: invokevirtual 1459	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6296: iconst_0
    //   6297: invokevirtual 1280	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6300: astore 22
    //   6302: aload 22
    //   6304: astore 21
    //   6306: aload 22
    //   6308: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6311: ifne +10 -> 6321
    //   6314: aload 22
    //   6316: invokevirtual 1462	java/lang/String:trim	()Ljava/lang/String;
    //   6319: astore 21
    //   6321: aload 20
    //   6323: aload_0
    //   6324: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6327: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6330: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6333: invokevirtual 1016	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   6336: astore 20
    //   6338: aload 20
    //   6340: ifnull +179 -> 6519
    //   6343: aload 21
    //   6345: invokestatic 1465	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   6348: ifeq +171 -> 6519
    //   6351: aload 20
    //   6353: invokevirtual 1468	com/tencent/mobileqq/mini/app/AuthorizeCenter:isAuthorizeSynchronized	()Z
    //   6356: istore 15
    //   6358: aload 21
    //   6360: ldc_w 1470
    //   6363: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6366: ifeq +59 -> 6425
    //   6369: iload 15
    //   6371: ifne +54 -> 6425
    //   6374: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6377: aconst_null
    //   6378: aload_0
    //   6379: invokevirtual 1473	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   6382: new 1475	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13
    //   6385: dup
    //   6386: aload_0
    //   6387: aload 20
    //   6389: aload 21
    //   6391: aload_3
    //   6392: aload_1
    //   6393: iload 4
    //   6395: aload_2
    //   6396: invokespecial 1478	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILjava/lang/String;)V
    //   6399: invokevirtual 1482	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getAuthList	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6402: goto -5037 -> 1365
    //   6405: astore_2
    //   6406: aload_2
    //   6407: invokevirtual 393	java/lang/Throwable:printStackTrace	()V
    //   6410: aload_0
    //   6411: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6414: aload_3
    //   6415: aload_1
    //   6416: aconst_null
    //   6417: iload 4
    //   6419: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6422: goto -5057 -> 1365
    //   6425: aload 20
    //   6427: aload 21
    //   6429: invokevirtual 1485	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   6432: istore 8
    //   6434: iload 8
    //   6436: istore 7
    //   6438: iload 8
    //   6440: iconst_1
    //   6441: if_icmpne +42 -> 6483
    //   6444: aload_0
    //   6445: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6448: invokevirtual 1488	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   6451: ifne +3679 -> 10130
    //   6454: aload_0
    //   6455: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6458: astore 20
    //   6460: iload 8
    //   6462: istore 7
    //   6464: aload_0
    //   6465: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6468: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6471: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6474: invokestatic 1491	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   6477: ifeq +6 -> 6483
    //   6480: goto +3650 -> 10130
    //   6483: iload 7
    //   6485: iconst_2
    //   6486: if_icmpne +18 -> 6504
    //   6489: aload_0
    //   6490: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6493: aload_3
    //   6494: aload_1
    //   6495: aconst_null
    //   6496: iload 4
    //   6498: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6501: goto -5136 -> 1365
    //   6504: aload_0
    //   6505: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6508: aload_1
    //   6509: aload_2
    //   6510: aload_3
    //   6511: iload 4
    //   6513: invokevirtual 1495	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:reqAuthorize	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   6516: goto -5151 -> 1365
    //   6519: aload_0
    //   6520: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6523: aload_3
    //   6524: aload_1
    //   6525: aconst_null
    //   6526: iload 4
    //   6528: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6531: goto -5166 -> 1365
    //   6534: ldc 56
    //   6536: aload_1
    //   6537: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6540: ifeq +165 -> 6705
    //   6543: new 273	org/json/JSONObject
    //   6546: dup
    //   6547: aload_2
    //   6548: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6551: astore_1
    //   6552: ldc 139
    //   6554: iconst_2
    //   6555: new 323	java/lang/StringBuilder
    //   6558: dup
    //   6559: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   6562: ldc_w 1497
    //   6565: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6568: aload_1
    //   6569: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6572: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6575: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6578: new 532	android/content/Intent
    //   6581: dup
    //   6582: invokespecial 1498	android/content/Intent:<init>	()V
    //   6585: astore_2
    //   6586: aload_2
    //   6587: new 1500	android/content/ComponentName
    //   6590: dup
    //   6591: aload_0
    //   6592: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6595: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6598: getfield 1504	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6601: ldc_w 1506
    //   6604: invokespecial 1507	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6607: invokevirtual 1511	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   6610: pop
    //   6611: aload_2
    //   6612: ldc_w 1513
    //   6615: aload_1
    //   6616: ldc_w 1513
    //   6619: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6622: invokevirtual 543	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6625: pop
    //   6626: aload_2
    //   6627: ldc_w 1515
    //   6630: sipush 1008
    //   6633: invokevirtual 1518	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6636: pop
    //   6637: aload_2
    //   6638: ldc_w 1520
    //   6641: iconst_2
    //   6642: invokevirtual 1518	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6645: pop
    //   6646: aload_2
    //   6647: ldc_w 1522
    //   6650: aload_1
    //   6651: ldc_w 1524
    //   6654: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6657: invokevirtual 543	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6660: pop
    //   6661: aload_2
    //   6662: ldc_w 1525
    //   6665: invokevirtual 1529	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   6668: pop
    //   6669: aload_0
    //   6670: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6673: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6676: getfield 1504	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6679: aload_2
    //   6680: invokevirtual 981	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   6683: goto -5318 -> 1365
    //   6686: astore_1
    //   6687: ldc 139
    //   6689: iconst_1
    //   6690: aload_1
    //   6691: iconst_0
    //   6692: anewarray 666	java/lang/Object
    //   6695: invokestatic 1063	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   6698: aload_1
    //   6699: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   6702: goto -5337 -> 1365
    //   6705: ldc 11
    //   6707: aload_1
    //   6708: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6711: ifeq +61 -> 6772
    //   6714: new 273	org/json/JSONObject
    //   6717: dup
    //   6718: aload_2
    //   6719: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6722: astore_2
    //   6723: new 1531	Wallet/FocusMpIdReq
    //   6726: dup
    //   6727: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6730: invokevirtual 1010	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6733: invokevirtual 1073	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6736: aload_2
    //   6737: ldc_w 1533
    //   6740: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6743: invokespecial 1534	Wallet/FocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   6746: new 1536	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14
    //   6749: dup
    //   6750: aload_0
    //   6751: aload_3
    //   6752: aload_1
    //   6753: iload 4
    //   6755: invokespecial 1537	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   6758: invokestatic 1083	agwt:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   6761: goto -5396 -> 1365
    //   6764: astore_1
    //   6765: aload_1
    //   6766: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   6769: goto -5404 -> 1365
    //   6772: ldc_w 1539
    //   6775: aload_1
    //   6776: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6779: ifeq +34 -> 6813
    //   6782: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6785: aload_0
    //   6786: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6789: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6792: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6795: new 1541	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15
    //   6798: dup
    //   6799: aload_0
    //   6800: aload_3
    //   6801: aload_1
    //   6802: iload 4
    //   6804: invokespecial 1542	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   6807: invokevirtual 1545	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getFormId	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6810: goto -5445 -> 1365
    //   6813: ldc 109
    //   6815: aload_1
    //   6816: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6819: ifeq +120 -> 6939
    //   6822: aload_0
    //   6823: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6826: ifnonnull +7 -> 6833
    //   6829: ldc_w 664
    //   6832: areturn
    //   6833: new 273	org/json/JSONObject
    //   6836: dup
    //   6837: aload_2
    //   6838: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6841: ldc_w 1546
    //   6844: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6847: invokestatic 1551	com/tencent/mobileqq/mini/entry/MiniAppUtils:checkNavigationAppIdListForMiniGame	(Ljava/lang/String;)Z
    //   6850: istore 15
    //   6852: new 273	org/json/JSONObject
    //   6855: dup
    //   6856: invokespecial 829	org/json/JSONObject:<init>	()V
    //   6859: astore_1
    //   6860: aload_1
    //   6861: ldc_w 1553
    //   6864: iload 15
    //   6866: invokevirtual 1556	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   6869: pop
    //   6870: ldc 139
    //   6872: iconst_2
    //   6873: new 323	java/lang/StringBuilder
    //   6876: dup
    //   6877: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   6880: ldc_w 1558
    //   6883: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6886: aload_1
    //   6887: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6890: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6893: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6896: aload_1
    //   6897: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   6900: areturn
    //   6901: astore_2
    //   6902: ldc 139
    //   6904: iconst_1
    //   6905: aload_2
    //   6906: iconst_0
    //   6907: anewarray 666	java/lang/Object
    //   6910: invokestatic 1063	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   6913: aload_2
    //   6914: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   6917: goto -47 -> 6870
    //   6920: astore_1
    //   6921: ldc 139
    //   6923: iconst_1
    //   6924: aload_1
    //   6925: iconst_0
    //   6926: anewarray 666	java/lang/Object
    //   6929: invokestatic 1063	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   6932: aload_1
    //   6933: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   6936: goto -5571 -> 1365
    //   6939: ldc_w 1560
    //   6942: aload_1
    //   6943: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6946: ifeq +222 -> 7168
    //   6949: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6952: invokevirtual 1010	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6955: astore_1
    //   6956: aload_1
    //   6957: instanceof 1012
    //   6960: ifeq +2988 -> 9948
    //   6963: aload_1
    //   6964: checkcast 1012	com/tencent/mobileqq/mini/MiniAppInterface
    //   6967: astore_1
    //   6968: aload_0
    //   6969: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6972: ifnull +7 -> 6979
    //   6975: aload_1
    //   6976: ifnonnull +26 -> 7002
    //   6979: aload_0
    //   6980: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6983: aload_3
    //   6984: ldc_w 1561
    //   6987: aconst_null
    //   6988: ldc_w 1562
    //   6991: invokestatic 1566	ajya:a	(I)Ljava/lang/String;
    //   6994: iload 4
    //   6996: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   6999: goto -5634 -> 1365
    //   7002: aload_1
    //   7003: aload_0
    //   7004: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7007: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7010: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7013: invokevirtual 1016	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   7016: astore_1
    //   7017: aload_1
    //   7018: ifnull +121 -> 7139
    //   7021: ldc_w 1568
    //   7024: invokestatic 1465	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   7027: ifeq +112 -> 7139
    //   7030: aload_1
    //   7031: ldc_w 1568
    //   7034: invokevirtual 1485	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   7037: istore 8
    //   7039: iload 8
    //   7041: istore 7
    //   7043: iload 8
    //   7045: iconst_1
    //   7046: if_icmpne +41 -> 7087
    //   7049: aload_0
    //   7050: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7053: invokevirtual 1488	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   7056: ifne +28 -> 7084
    //   7059: aload_0
    //   7060: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7063: astore_1
    //   7064: iload 8
    //   7066: istore 7
    //   7068: aload_0
    //   7069: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7072: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7075: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7078: invokestatic 1491	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   7081: ifeq +6 -> 7087
    //   7084: iconst_2
    //   7085: istore 7
    //   7087: iload 7
    //   7089: iconst_2
    //   7090: if_icmpne +20 -> 7110
    //   7093: aload_0
    //   7094: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7097: aload_3
    //   7098: ldc_w 1561
    //   7101: aconst_null
    //   7102: iload 4
    //   7104: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7107: goto -5742 -> 1365
    //   7110: ldc 139
    //   7112: iconst_1
    //   7113: ldc_w 1570
    //   7116: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7119: aload_0
    //   7120: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7123: aload_3
    //   7124: ldc_w 1561
    //   7127: aconst_null
    //   7128: ldc_w 1570
    //   7131: iload 4
    //   7133: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7136: goto -5771 -> 1365
    //   7139: aload_0
    //   7140: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7143: aload_3
    //   7144: ldc_w 1561
    //   7147: aconst_null
    //   7148: ldc_w 1572
    //   7151: iload 4
    //   7153: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7156: ldc 139
    //   7158: iconst_1
    //   7159: ldc_w 1574
    //   7162: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7165: goto -5800 -> 1365
    //   7168: ldc_w 1576
    //   7171: aload_1
    //   7172: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7175: ifeq +167 -> 7342
    //   7178: new 273	org/json/JSONObject
    //   7181: dup
    //   7182: aload_2
    //   7183: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7186: astore 20
    //   7188: aload 20
    //   7190: ldc_w 1578
    //   7193: invokevirtual 1459	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7196: astore_2
    //   7197: aload 20
    //   7199: ldc_w 1056
    //   7202: ldc_w 1058
    //   7205: invokevirtual 998	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7208: astore 20
    //   7210: aload_2
    //   7211: ifnull -5846 -> 1365
    //   7214: aload_2
    //   7215: invokevirtual 1278	org/json/JSONArray:length	()I
    //   7218: ifle -5853 -> 1365
    //   7221: aload_2
    //   7222: invokevirtual 1278	org/json/JSONArray:length	()I
    //   7225: anewarray 365	java/lang/String
    //   7228: astore 21
    //   7230: iconst_0
    //   7231: istore 7
    //   7233: iload 7
    //   7235: aload_2
    //   7236: invokevirtual 1278	org/json/JSONArray:length	()I
    //   7239: if_icmpge +23 -> 7262
    //   7242: aload 21
    //   7244: iload 7
    //   7246: aload_2
    //   7247: iload 7
    //   7249: invokevirtual 1280	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   7252: aastore
    //   7253: iload 7
    //   7255: iconst_1
    //   7256: iadd
    //   7257: istore 7
    //   7259: goto -26 -> 7233
    //   7262: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7265: invokestatic 1584	com/tencent/mobileqq/minigame/manager/GameInfoManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7268: invokevirtual 1585	com/tencent/mobileqq/minigame/manager/GameInfoManager:getAppId	()Ljava/lang/String;
    //   7271: aload 20
    //   7273: aload 21
    //   7275: new 1587	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16
    //   7278: dup
    //   7279: aload_0
    //   7280: aload_3
    //   7281: aload_1
    //   7282: iload 4
    //   7284: invokespecial 1588	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7287: invokevirtual 1592	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoOpenData	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7290: goto -5925 -> 1365
    //   7293: astore_2
    //   7294: aload_0
    //   7295: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7298: aload_3
    //   7299: aload_1
    //   7300: aconst_null
    //   7301: iload 4
    //   7303: invokevirtual 1033	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7306: ldc 139
    //   7308: iconst_1
    //   7309: new 323	java/lang/StringBuilder
    //   7312: dup
    //   7313: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7316: ldc_w 1594
    //   7319: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7322: aload_1
    //   7323: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7326: ldc_w 1596
    //   7329: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7332: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7335: aload_2
    //   7336: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7339: goto -5974 -> 1365
    //   7342: ldc 41
    //   7344: aload_1
    //   7345: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7348: ifeq +424 -> 7772
    //   7351: new 273	org/json/JSONObject
    //   7354: dup
    //   7355: aload_2
    //   7356: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7359: astore_2
    //   7360: aload_2
    //   7361: ldc_w 1598
    //   7364: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7367: astore 23
    //   7369: aload_2
    //   7370: ldc_w 1600
    //   7373: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7376: astore 24
    //   7378: aload_2
    //   7379: ldc_w 1602
    //   7382: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7385: astore 25
    //   7387: aload_2
    //   7388: ldc_w 1604
    //   7391: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7394: astore 21
    //   7396: aload_2
    //   7397: ldc_w 1606
    //   7400: invokevirtual 1609	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7403: istore 7
    //   7405: ldc_w 1611
    //   7408: aload 24
    //   7410: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7413: ifne +33 -> 7446
    //   7416: ldc_w 1613
    //   7419: aload 24
    //   7421: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7424: ifne +22 -> 7446
    //   7427: aload_0
    //   7428: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7431: aload_3
    //   7432: aload_1
    //   7433: aconst_null
    //   7434: ldc_w 1615
    //   7437: iload 4
    //   7439: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7442: ldc_w 664
    //   7445: areturn
    //   7446: ldc_w 1611
    //   7449: aload 23
    //   7451: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7454: ifne +33 -> 7487
    //   7457: ldc_w 1617
    //   7460: aload 23
    //   7462: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7465: ifne +22 -> 7487
    //   7468: aload_0
    //   7469: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7472: aload_3
    //   7473: aload_1
    //   7474: aconst_null
    //   7475: ldc_w 1619
    //   7478: iload 4
    //   7480: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7483: ldc_w 664
    //   7486: areturn
    //   7487: iload 7
    //   7489: ifgt +22 -> 7511
    //   7492: aload_0
    //   7493: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7496: aload_3
    //   7497: aload_1
    //   7498: aconst_null
    //   7499: ldc_w 1621
    //   7502: iload 4
    //   7504: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7507: ldc_w 664
    //   7510: areturn
    //   7511: aload 21
    //   7513: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7516: ifeq +22 -> 7538
    //   7519: aload_0
    //   7520: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7523: aload_3
    //   7524: aload_1
    //   7525: aconst_null
    //   7526: ldc_w 1623
    //   7529: iload 4
    //   7531: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7534: ldc_w 664
    //   7537: areturn
    //   7538: new 1625	android/graphics/Paint
    //   7541: dup
    //   7542: invokespecial 1626	android/graphics/Paint:<init>	()V
    //   7545: astore 22
    //   7547: aload 22
    //   7549: iload 7
    //   7551: i2f
    //   7552: invokevirtual 1630	android/graphics/Paint:setTextSize	(F)V
    //   7555: aconst_null
    //   7556: astore 20
    //   7558: ldc_w 1611
    //   7561: aload 23
    //   7563: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7566: ifeq +68 -> 7634
    //   7569: ldc_w 1611
    //   7572: aload 24
    //   7574: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7577: ifeq +33 -> 7610
    //   7580: aload 25
    //   7582: iconst_0
    //   7583: invokestatic 1636	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7586: astore_2
    //   7587: aload_2
    //   7588: ifnonnull +105 -> 7693
    //   7591: aload_0
    //   7592: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7595: aload_3
    //   7596: aload_1
    //   7597: aconst_null
    //   7598: ldc_w 1638
    //   7601: iload 4
    //   7603: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7606: ldc_w 664
    //   7609: areturn
    //   7610: aload 20
    //   7612: astore_2
    //   7613: ldc_w 1613
    //   7616: aload 24
    //   7618: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7621: ifeq -34 -> 7587
    //   7624: aload 25
    //   7626: iconst_1
    //   7627: invokestatic 1636	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7630: astore_2
    //   7631: goto -44 -> 7587
    //   7634: aload 20
    //   7636: astore_2
    //   7637: ldc_w 1617
    //   7640: aload 23
    //   7642: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7645: ifeq -58 -> 7587
    //   7648: ldc_w 1611
    //   7651: aload 24
    //   7653: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7656: ifeq +13 -> 7669
    //   7659: aload 25
    //   7661: iconst_2
    //   7662: invokestatic 1636	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7665: astore_2
    //   7666: goto -79 -> 7587
    //   7669: aload 20
    //   7671: astore_2
    //   7672: ldc_w 1613
    //   7675: aload 24
    //   7677: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7680: ifeq -93 -> 7587
    //   7683: aload 25
    //   7685: iconst_3
    //   7686: invokestatic 1636	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7689: astore_2
    //   7690: goto -103 -> 7587
    //   7693: new 1640	android/graphics/Rect
    //   7696: dup
    //   7697: invokespecial 1641	android/graphics/Rect:<init>	()V
    //   7700: astore_2
    //   7701: aload 22
    //   7703: aload 21
    //   7705: iconst_0
    //   7706: aload 21
    //   7708: invokevirtual 1642	java/lang/String:length	()I
    //   7711: aload_2
    //   7712: invokevirtual 1646	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   7715: aload_0
    //   7716: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7719: aload_3
    //   7720: aload_1
    //   7721: aconst_null
    //   7722: iload 4
    //   7724: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7727: new 323	java/lang/StringBuilder
    //   7730: dup
    //   7731: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7734: ldc_w 664
    //   7737: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7740: aload_2
    //   7741: invokevirtual 1649	android/graphics/Rect:height	()I
    //   7744: invokevirtual 513	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7747: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7750: astore_2
    //   7751: aload_2
    //   7752: areturn
    //   7753: astore_2
    //   7754: aload_0
    //   7755: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7758: aload_3
    //   7759: aload_1
    //   7760: aconst_null
    //   7761: ldc_w 1651
    //   7764: iload 4
    //   7766: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7769: goto -6404 -> 1365
    //   7772: ldc_w 1653
    //   7775: aload_1
    //   7776: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7779: ifeq +28 -> 7807
    //   7782: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7785: aload_0
    //   7786: invokevirtual 1473	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   7789: new 1655	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17
    //   7792: dup
    //   7793: aload_0
    //   7794: aload_3
    //   7795: aload_1
    //   7796: iload 4
    //   7798: invokespecial 1656	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7801: invokevirtual 1658	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoExtra	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7804: goto -6439 -> 1365
    //   7807: ldc 23
    //   7809: aload_1
    //   7810: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7813: ifeq +273 -> 8086
    //   7816: aload_0
    //   7817: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   7820: ifeq -6455 -> 1365
    //   7823: invokestatic 1584	com/tencent/mobileqq/minigame/manager/GameInfoManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7826: invokevirtual 1662	com/tencent/mobileqq/minigame/manager/GameInfoManager:getLaunchOptions	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions;
    //   7829: astore 20
    //   7831: new 273	org/json/JSONObject
    //   7834: dup
    //   7835: invokespecial 829	org/json/JSONObject:<init>	()V
    //   7838: astore 21
    //   7840: new 273	org/json/JSONObject
    //   7843: dup
    //   7844: invokespecial 829	org/json/JSONObject:<init>	()V
    //   7847: astore 22
    //   7849: aload 20
    //   7851: getfield 1667	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   7854: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7857: ifeq +168 -> 8025
    //   7860: aconst_null
    //   7861: astore_2
    //   7862: aload 22
    //   7864: ldc_w 1546
    //   7867: aload_2
    //   7868: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7871: pop
    //   7872: aload 20
    //   7874: getfield 1670	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   7877: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7880: ifeq +154 -> 8034
    //   7883: aconst_null
    //   7884: astore_2
    //   7885: aload 22
    //   7887: ldc_w 1672
    //   7890: aload_2
    //   7891: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7894: pop
    //   7895: aload 21
    //   7897: ldc_w 1673
    //   7900: aload 20
    //   7902: getfield 1674	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:scene	I
    //   7905: invokestatic 1680	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getWikiScene	(I)I
    //   7908: invokevirtual 855	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   7911: pop
    //   7912: aload 21
    //   7914: ldc_w 1327
    //   7917: aload 20
    //   7919: getfield 1683	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:query	Lorg/json/JSONObject;
    //   7922: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7925: pop
    //   7926: aload 20
    //   7928: getfield 1685	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   7931: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7934: ifeq +109 -> 8043
    //   7937: aconst_null
    //   7938: astore_2
    //   7939: aload 21
    //   7941: ldc_w 1219
    //   7944: aload_2
    //   7945: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7948: pop
    //   7949: aload 21
    //   7951: ldc_w 1687
    //   7954: aload 22
    //   7956: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7959: pop
    //   7960: aload 21
    //   7962: ldc_w 1689
    //   7965: invokestatic 1584	com/tencent/mobileqq/minigame/manager/GameInfoManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7968: invokevirtual 1692	com/tencent/mobileqq/minigame/manager/GameInfoManager:getExtendData	()Ljava/lang/String;
    //   7971: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7974: pop
    //   7975: aload 21
    //   7977: ldc_w 1349
    //   7980: aload 20
    //   7982: getfield 1694	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:entryDataHash	Ljava/lang/String;
    //   7985: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7988: pop
    //   7989: ldc 139
    //   7991: iconst_1
    //   7992: new 323	java/lang/StringBuilder
    //   7995: dup
    //   7996: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7999: ldc_w 1696
    //   8002: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8005: aload 21
    //   8007: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8010: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8013: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8016: invokestatic 374	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8019: aload 21
    //   8021: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8024: areturn
    //   8025: aload 20
    //   8027: getfield 1667	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8030: astore_2
    //   8031: goto -169 -> 7862
    //   8034: aload 20
    //   8036: getfield 1670	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8039: astore_2
    //   8040: goto -155 -> 7885
    //   8043: aload 20
    //   8045: getfield 1685	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8048: astore_2
    //   8049: goto -110 -> 7939
    //   8052: astore_2
    //   8053: ldc 139
    //   8055: iconst_1
    //   8056: ldc_w 1698
    //   8059: aload_2
    //   8060: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8063: aload_1
    //   8064: aconst_null
    //   8065: invokestatic 920	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8068: astore_1
    //   8069: aload_3
    //   8070: iload 4
    //   8072: aload_1
    //   8073: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8076: invokeinterface 909 3 0
    //   8081: aload_1
    //   8082: invokevirtual 904	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8085: areturn
    //   8086: ldc 53
    //   8088: aload_1
    //   8089: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8092: ifeq +648 -> 8740
    //   8095: new 273	org/json/JSONObject
    //   8098: dup
    //   8099: aload_2
    //   8100: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8103: astore_2
    //   8104: ldc 139
    //   8106: iconst_1
    //   8107: new 323	java/lang/StringBuilder
    //   8110: dup
    //   8111: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   8114: ldc_w 1700
    //   8117: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8120: aload_2
    //   8121: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8124: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8127: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8130: aload_2
    //   8131: ldc_w 539
    //   8134: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8137: astore 22
    //   8139: aload 22
    //   8141: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8144: ifeq +20 -> 8164
    //   8147: aload_0
    //   8148: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8151: aload_3
    //   8152: aload_1
    //   8153: aconst_null
    //   8154: ldc_w 1702
    //   8157: iload 4
    //   8159: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8162: aconst_null
    //   8163: areturn
    //   8164: aload_2
    //   8165: ldc_w 1704
    //   8168: iconst_0
    //   8169: invokevirtual 1004	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8172: istore 15
    //   8174: aload 22
    //   8176: invokevirtual 1707	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   8179: astore 20
    //   8181: aload 20
    //   8183: invokestatic 1713	com/tencent/mobileqq/mini/apkg/DomainConfig:getDomainConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/DomainConfig;
    //   8186: astore 21
    //   8188: iload 15
    //   8190: ifne +78 -> 8268
    //   8193: aload_0
    //   8194: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8197: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8200: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   8203: aload 20
    //   8205: iconst_0
    //   8206: invokevirtual 1716	com/tencent/mobileqq/mini/apkg/ApkgInfo:isValidPrefix	(Ljava/lang/String;Z)Z
    //   8209: ifne +20 -> 8229
    //   8212: aload_0
    //   8213: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8216: aload_3
    //   8217: aload_1
    //   8218: aconst_null
    //   8219: ldc_w 1718
    //   8222: iload 4
    //   8224: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8227: aconst_null
    //   8228: areturn
    //   8229: aload_0
    //   8230: getfield 345	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8233: ifnull +35 -> 8268
    //   8236: aload_0
    //   8237: getfield 345	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8240: aload 21
    //   8242: getfield 1721	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8245: invokevirtual 1724	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   8248: ifne +20 -> 8268
    //   8251: aload_0
    //   8252: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8255: aload_3
    //   8256: aload_1
    //   8257: aconst_null
    //   8258: ldc_w 1726
    //   8261: iload 4
    //   8263: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8266: aconst_null
    //   8267: areturn
    //   8268: ldc_w 1728
    //   8271: aload 21
    //   8273: getfield 1721	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8276: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8279: ifeq +438 -> 8717
    //   8282: ldc_w 1730
    //   8285: ldc_w 1732
    //   8288: invokestatic 1737	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8291: astore_2
    //   8292: aload 22
    //   8294: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8297: ifne +402 -> 8699
    //   8300: aload_0
    //   8301: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8304: ifnull +395 -> 8699
    //   8307: aload_0
    //   8308: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8311: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8314: ifnull +385 -> 8699
    //   8317: invokestatic 1742	com/tencent/mobileqq/mini/mainpage/MainPageFragment:getUin	()Ljava/lang/String;
    //   8320: astore 21
    //   8322: aload 21
    //   8324: ifnonnull +1812 -> 10136
    //   8327: ldc_w 664
    //   8330: astore 20
    //   8332: aload 22
    //   8334: ldc_w 1744
    //   8337: aload 20
    //   8339: invokevirtual 1748	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8342: ldc_w 1750
    //   8345: invokestatic 874	bbdh:c	()Ljava/lang/String;
    //   8348: invokevirtual 1748	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8351: ldc_w 1752
    //   8354: ldc_w 1754
    //   8357: invokevirtual 1748	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8360: ldc_w 1756
    //   8363: getstatic 674	android/os/Build$VERSION:SDK_INT	I
    //   8366: invokestatic 1150	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   8369: invokevirtual 1748	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8372: ldc_w 1758
    //   8375: invokestatic 578	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8378: invokestatic 1763	bbfj:a	(Landroid/content/Context;)Ljava/lang/String;
    //   8381: invokevirtual 1748	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8384: ldc_w 1765
    //   8387: aload_2
    //   8388: invokevirtual 1748	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8391: astore 22
    //   8393: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8396: new 323	java/lang/StringBuilder
    //   8399: dup
    //   8400: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   8403: getstatic 1771	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   8406: invokevirtual 1772	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   8409: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8412: aload 21
    //   8414: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8417: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8420: invokevirtual 1775	com/tencent/common/app/BaseApplicationImpl:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   8423: astore 20
    //   8425: aload 20
    //   8427: astore_2
    //   8428: aload 20
    //   8430: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8433: ifeq +7 -> 8440
    //   8436: ldc_w 664
    //   8439: astore_2
    //   8440: aload 22
    //   8442: ldc_w 1777
    //   8445: aload_2
    //   8446: invokevirtual 1748	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8449: astore_2
    //   8450: invokestatic 651	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8453: ifeq +29 -> 8482
    //   8456: ldc 139
    //   8458: iconst_2
    //   8459: new 323	java/lang/StringBuilder
    //   8462: dup
    //   8463: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   8466: ldc_w 1779
    //   8469: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8472: aload_2
    //   8473: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8476: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8479: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8482: new 532	android/content/Intent
    //   8485: dup
    //   8486: aload_0
    //   8487: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8490: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8493: getfield 1504	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8496: ldc_w 534
    //   8499: invokespecial 537	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8502: astore 20
    //   8504: aload 20
    //   8506: ldc_w 1781
    //   8509: ldc_w 1782
    //   8512: invokestatic 1566	ajya:a	(I)Ljava/lang/String;
    //   8515: invokevirtual 543	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8518: pop
    //   8519: aload 20
    //   8521: ldc_w 548
    //   8524: iconst_1
    //   8525: invokevirtual 1785	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8528: pop
    //   8529: aload 20
    //   8531: ldc_w 1787
    //   8534: iconst_1
    //   8535: invokevirtual 1785	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8538: pop
    //   8539: aload 20
    //   8541: ldc_w 539
    //   8544: aload_2
    //   8545: invokevirtual 543	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8548: pop
    //   8549: aload_0
    //   8550: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8553: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8556: getfield 1504	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8559: aload 20
    //   8561: invokevirtual 981	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   8564: aload_0
    //   8565: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8568: aload_3
    //   8569: aload_1
    //   8570: aconst_null
    //   8571: iload 4
    //   8573: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8576: aload_2
    //   8577: ldc_w 1789
    //   8580: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8583: ifeq -7218 -> 1365
    //   8586: ldc 139
    //   8588: iconst_2
    //   8589: ldc_w 1791
    //   8592: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8595: new 545	android/os/Bundle
    //   8598: dup
    //   8599: invokespecial 546	android/os/Bundle:<init>	()V
    //   8602: astore_1
    //   8603: aload_1
    //   8604: ldc_w 1793
    //   8607: aload_0
    //   8608: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8611: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8614: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   8617: invokevirtual 1207	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8620: invokestatic 1798	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   8623: ldc_w 1800
    //   8626: ldc_w 1802
    //   8629: aload_1
    //   8630: new 1804	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18
    //   8633: dup
    //   8634: aload_0
    //   8635: invokespecial 1807	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;)V
    //   8638: invokevirtual 1811	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   8641: goto -7276 -> 1365
    //   8644: astore_1
    //   8645: ldc 139
    //   8647: iconst_1
    //   8648: aload_1
    //   8649: iconst_0
    //   8650: anewarray 666	java/lang/Object
    //   8653: invokestatic 1063	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   8656: goto -7291 -> 1365
    //   8659: astore_2
    //   8660: ldc 139
    //   8662: iconst_1
    //   8663: new 323	java/lang/StringBuilder
    //   8666: dup
    //   8667: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   8670: ldc_w 1813
    //   8673: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8676: ldc_w 664
    //   8679: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8682: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8685: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8688: aload_2
    //   8689: invokevirtual 1814	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   8692: ldc_w 664
    //   8695: astore_2
    //   8696: goto -404 -> 8292
    //   8699: aload_0
    //   8700: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8703: aload_3
    //   8704: aload_1
    //   8705: aconst_null
    //   8706: ldc_w 1816
    //   8709: iload 4
    //   8711: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8714: goto -7349 -> 1365
    //   8717: aload_2
    //   8718: aload_0
    //   8719: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8722: new 1818	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19
    //   8725: dup
    //   8726: aload_0
    //   8727: aload_3
    //   8728: aload_1
    //   8729: iload 4
    //   8731: invokespecial 1819	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   8734: invokestatic 1825	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/InternalJSPlugin:openUrl	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/InternalJSPlugin$openUrlCallback;)V
    //   8737: goto -7372 -> 1365
    //   8740: ldc 62
    //   8742: aload_1
    //   8743: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8746: ifeq +68 -> 8814
    //   8749: new 273	org/json/JSONObject
    //   8752: dup
    //   8753: aload_2
    //   8754: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8757: ldc_w 1827
    //   8760: iconst_0
    //   8761: invokevirtual 1004	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8764: istore 15
    //   8766: aload_0
    //   8767: invokevirtual 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   8770: ifeq -7405 -> 1365
    //   8773: invokestatic 1584	com/tencent/mobileqq/minigame/manager/GameInfoManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8776: invokevirtual 1831	com/tencent/mobileqq/minigame/manager/GameInfoManager:getMiniAppConfig	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   8779: iload 15
    //   8781: invokestatic 1837	com/tencent/mobileqq/minigame/gpkg/GpkgManager:setOfflineResourceContent	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Z)V
    //   8784: aload_0
    //   8785: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8788: aload_3
    //   8789: aload_1
    //   8790: aconst_null
    //   8791: iload 4
    //   8793: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8796: goto -7431 -> 1365
    //   8799: astore_1
    //   8800: ldc 139
    //   8802: iconst_1
    //   8803: aload_1
    //   8804: iconst_0
    //   8805: anewarray 666	java/lang/Object
    //   8808: invokestatic 1063	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   8811: goto -7446 -> 1365
    //   8814: ldc 92
    //   8816: aload_1
    //   8817: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8820: ifeq +178 -> 8998
    //   8823: aload_0
    //   8824: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8827: ifnull -7462 -> 1365
    //   8830: new 376	java/util/ArrayList
    //   8833: dup
    //   8834: invokespecial 377	java/util/ArrayList:<init>	()V
    //   8837: astore 20
    //   8839: new 273	org/json/JSONObject
    //   8842: dup
    //   8843: aload_2
    //   8844: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8847: ldc_w 989
    //   8850: invokevirtual 993	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   8853: ldc_w 1839
    //   8856: invokevirtual 1459	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   8859: astore_2
    //   8860: aload_2
    //   8861: ifnull +85 -> 8946
    //   8864: aload_2
    //   8865: invokevirtual 1278	org/json/JSONArray:length	()I
    //   8868: ifle +78 -> 8946
    //   8871: iconst_0
    //   8872: istore 7
    //   8874: iload 7
    //   8876: aload_2
    //   8877: invokevirtual 1278	org/json/JSONArray:length	()I
    //   8880: if_icmpge +66 -> 8946
    //   8883: aload_2
    //   8884: iload 7
    //   8886: invokevirtual 1842	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   8889: checkcast 273	org/json/JSONObject
    //   8892: astore 21
    //   8894: new 1844	com/tencent/mobileqq/mini/apkg/PluginInfo
    //   8897: dup
    //   8898: invokespecial 1845	com/tencent/mobileqq/mini/apkg/PluginInfo:<init>	()V
    //   8901: astore 22
    //   8903: aload 22
    //   8905: aload 21
    //   8907: ldc_w 1847
    //   8910: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8913: invokevirtual 1850	com/tencent/mobileqq/mini/apkg/PluginInfo:setPluginId	(Ljava/lang/String;)V
    //   8916: aload 22
    //   8918: aload 21
    //   8920: ldc_w 1852
    //   8923: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8926: invokevirtual 1855	com/tencent/mobileqq/mini/apkg/PluginInfo:setInnerVersion	(Ljava/lang/String;)V
    //   8929: aload 20
    //   8931: aload 22
    //   8933: invokevirtual 390	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   8936: pop
    //   8937: iload 7
    //   8939: iconst_1
    //   8940: iadd
    //   8941: istore 7
    //   8943: goto -69 -> 8874
    //   8946: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   8949: aload_0
    //   8950: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8953: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8956: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   8959: aload 20
    //   8961: new 1857	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20
    //   8964: dup
    //   8965: aload_0
    //   8966: aload_3
    //   8967: aload_1
    //   8968: iload 4
    //   8970: invokespecial 1858	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   8973: invokevirtual 1861	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:verifyPlugin	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   8976: goto -7611 -> 1365
    //   8979: astore_2
    //   8980: aload_0
    //   8981: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8984: aload_3
    //   8985: aload_1
    //   8986: aconst_null
    //   8987: ldc_w 1863
    //   8990: iload 4
    //   8992: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8995: goto -7630 -> 1365
    //   8998: ldc 14
    //   9000: aload_1
    //   9001: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9004: ifeq +127 -> 9131
    //   9007: aload_0
    //   9008: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9011: ifnull -7646 -> 1365
    //   9014: aload_2
    //   9015: ifnull -7650 -> 1365
    //   9018: new 273	org/json/JSONObject
    //   9021: dup
    //   9022: aload_2
    //   9023: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9026: ldc_w 1865
    //   9029: invokevirtual 1459	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9032: astore_2
    //   9033: new 376	java/util/ArrayList
    //   9036: dup
    //   9037: invokespecial 377	java/util/ArrayList:<init>	()V
    //   9040: astore 20
    //   9042: aload_2
    //   9043: ifnull +46 -> 9089
    //   9046: aload_2
    //   9047: invokevirtual 1278	org/json/JSONArray:length	()I
    //   9050: ifle +39 -> 9089
    //   9053: iconst_0
    //   9054: istore 7
    //   9056: iload 7
    //   9058: aload_2
    //   9059: invokevirtual 1278	org/json/JSONArray:length	()I
    //   9062: if_icmpge +27 -> 9089
    //   9065: aload 20
    //   9067: aload_2
    //   9068: iload 7
    //   9070: invokevirtual 1842	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9073: invokestatic 1868	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9076: invokevirtual 390	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9079: pop
    //   9080: iload 7
    //   9082: iconst_1
    //   9083: iadd
    //   9084: istore 7
    //   9086: goto -30 -> 9056
    //   9089: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9092: aload 20
    //   9094: new 1870	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21
    //   9097: dup
    //   9098: aload_0
    //   9099: aload_3
    //   9100: aload_1
    //   9101: iload 4
    //   9103: invokespecial 1871	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9106: invokevirtual 1874	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:batchGetContact	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9109: goto -7744 -> 1365
    //   9112: astore_2
    //   9113: aload_0
    //   9114: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9117: aload_3
    //   9118: aload_1
    //   9119: aconst_null
    //   9120: ldc_w 1876
    //   9123: iload 4
    //   9125: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9128: goto -7763 -> 1365
    //   9131: ldc 26
    //   9133: aload_1
    //   9134: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9137: ifeq +60 -> 9197
    //   9140: new 273	org/json/JSONObject
    //   9143: dup
    //   9144: invokespecial 829	org/json/JSONObject:<init>	()V
    //   9147: astore_2
    //   9148: aload_2
    //   9149: ldc_w 290
    //   9152: aload_0
    //   9153: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9156: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9159: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9162: getfield 1877	com/tencent/mobileqq/mini/apkg/ApkgInfo:appId	Ljava/lang/String;
    //   9165: invokestatic 1882	com/tencent/mobileqq/mini/report/MiniReportManager:getLaunchPerformance	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9168: invokevirtual 840	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   9171: pop
    //   9172: aload_0
    //   9173: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9176: aload_3
    //   9177: aload_1
    //   9178: aload_2
    //   9179: iload 4
    //   9181: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9184: goto -7819 -> 1365
    //   9187: astore 20
    //   9189: aload 20
    //   9191: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   9194: goto -22 -> 9172
    //   9197: ldc_w 1884
    //   9200: aload_1
    //   9201: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9204: ifeq +131 -> 9335
    //   9207: new 273	org/json/JSONObject
    //   9210: dup
    //   9211: invokespecial 829	org/json/JSONObject:<init>	()V
    //   9214: astore_2
    //   9215: aload_0
    //   9216: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9219: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9222: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9225: astore 20
    //   9227: iconst_0
    //   9228: istore 16
    //   9230: iload 16
    //   9232: istore 15
    //   9234: aload 20
    //   9236: ifnull +64 -> 9300
    //   9239: iload 16
    //   9241: istore 15
    //   9243: aload 20
    //   9245: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9248: ifnull +52 -> 9300
    //   9251: iload 16
    //   9253: istore 15
    //   9255: aload 20
    //   9257: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9260: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9263: ifnull +37 -> 9300
    //   9266: iload 16
    //   9268: istore 15
    //   9270: aload 20
    //   9272: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9275: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9278: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9281: ifnull +19 -> 9300
    //   9284: aload 20
    //   9286: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9289: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9292: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9295: getfield 1887	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9298: istore 15
    //   9300: aload_2
    //   9301: ldc_w 1889
    //   9304: iload 15
    //   9306: invokevirtual 1556	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9309: pop
    //   9310: aload_0
    //   9311: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9314: aload_3
    //   9315: aload_1
    //   9316: aload_2
    //   9317: iload 4
    //   9319: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9322: goto -7957 -> 1365
    //   9325: astore 20
    //   9327: aload 20
    //   9329: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   9332: goto -22 -> 9310
    //   9335: ldc_w 1891
    //   9338: aload_1
    //   9339: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9342: ifeq +293 -> 9635
    //   9345: new 273	org/json/JSONObject
    //   9348: dup
    //   9349: aload_2
    //   9350: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9353: ldc_w 1349
    //   9356: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9359: astore_2
    //   9360: aload_0
    //   9361: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9364: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9367: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9370: astore 20
    //   9372: new 273	org/json/JSONObject
    //   9375: dup
    //   9376: invokespecial 829	org/json/JSONObject:<init>	()V
    //   9379: astore 21
    //   9381: iconst_0
    //   9382: istore 16
    //   9384: iload 16
    //   9386: istore 15
    //   9388: aload 20
    //   9390: ifnull +64 -> 9454
    //   9393: iload 16
    //   9395: istore 15
    //   9397: aload 20
    //   9399: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9402: ifnull +52 -> 9454
    //   9405: iload 16
    //   9407: istore 15
    //   9409: aload 20
    //   9411: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9414: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9417: ifnull +37 -> 9454
    //   9420: iload 16
    //   9422: istore 15
    //   9424: aload 20
    //   9426: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9429: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9432: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9435: ifnull +19 -> 9454
    //   9438: aload 20
    //   9440: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9443: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9446: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9449: getfield 1887	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9452: istore 15
    //   9454: aload 21
    //   9456: ldc_w 1889
    //   9459: iload 15
    //   9461: invokevirtual 1556	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9464: pop
    //   9465: aload 20
    //   9467: ifnull +152 -> 9619
    //   9470: aload 20
    //   9472: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9475: ifnull +144 -> 9619
    //   9478: aload 20
    //   9480: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9483: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9486: ifnull +133 -> 9619
    //   9489: aload 20
    //   9491: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9494: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9497: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9500: ifnull +119 -> 9619
    //   9503: aload_2
    //   9504: ifnull +115 -> 9619
    //   9507: aload_2
    //   9508: aload 20
    //   9510: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9513: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9516: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9519: invokevirtual 1358	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   9522: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9525: ifeq +94 -> 9619
    //   9528: aload 20
    //   9530: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9533: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9536: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9539: getfield 1894	com/tencent/mobileqq/mini/sdk/EntryModel:type	I
    //   9542: iconst_1
    //   9543: if_icmpne +76 -> 9619
    //   9546: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9549: aconst_null
    //   9550: aload_0
    //   9551: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9554: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9557: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9560: aload 20
    //   9562: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9565: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9568: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9571: getfield 1897	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   9574: invokestatic 1900	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9577: aload 20
    //   9579: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9582: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9585: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9588: getfield 1903	com/tencent/mobileqq/mini/sdk/EntryModel:dwGroupClassExt	J
    //   9591: new 1905	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22
    //   9594: dup
    //   9595: aload_0
    //   9596: aload 21
    //   9598: aload_3
    //   9599: aload_1
    //   9600: iload 4
    //   9602: invokespecial 1908	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9605: invokevirtual 1912	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserGroupInfo	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9608: goto -8243 -> 1365
    //   9611: astore_1
    //   9612: aload_1
    //   9613: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   9616: goto -8251 -> 1365
    //   9619: aload_0
    //   9620: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9623: aload_3
    //   9624: aload_1
    //   9625: aload 21
    //   9627: iload 4
    //   9629: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9632: goto -8267 -> 1365
    //   9635: ldc_w 1914
    //   9638: aload_1
    //   9639: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9642: ifeq +193 -> 9835
    //   9645: new 273	org/json/JSONObject
    //   9648: dup
    //   9649: aload_2
    //   9650: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9653: astore 20
    //   9655: aload 20
    //   9657: ldc_w 1349
    //   9660: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9663: astore_2
    //   9664: aload 20
    //   9666: ldc_w 539
    //   9669: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9672: astore 20
    //   9674: aload_0
    //   9675: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9678: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9681: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9684: astore 21
    //   9686: aload 21
    //   9688: ifnull -8323 -> 1365
    //   9691: aload 21
    //   9693: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9696: ifnull -8331 -> 1365
    //   9699: aload 21
    //   9701: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9704: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9707: ifnull -8342 -> 1365
    //   9710: aload 21
    //   9712: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9715: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9718: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9721: ifnull -8356 -> 1365
    //   9724: aload_2
    //   9725: ifnull -8360 -> 1365
    //   9728: aload_2
    //   9729: aload 21
    //   9731: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9734: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9737: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9740: invokevirtual 1358	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   9743: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9746: ifeq -8381 -> 1365
    //   9749: aload 21
    //   9751: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9754: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9757: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9760: getfield 1887	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9763: ifeq -8398 -> 1365
    //   9766: aload 20
    //   9768: ifnull -8403 -> 1365
    //   9771: aload 20
    //   9773: ldc_w 1916
    //   9776: invokevirtual 1918	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   9779: ifeq -8414 -> 1365
    //   9782: aload 20
    //   9784: ldc_w 1916
    //   9787: aload 21
    //   9789: getfield 934	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9792: getfield 940	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9795: getfield 1353	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9798: getfield 1897	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   9801: invokestatic 1900	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9804: invokevirtual 1748	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   9807: astore_2
    //   9808: aload_0
    //   9809: aload_0
    //   9810: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9813: getfield 1117	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   9816: aload_2
    //   9817: aload_3
    //   9818: aload_1
    //   9819: iload 4
    //   9821: invokespecial 1920	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startGroupBrowserActivity	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9824: goto -8459 -> 1365
    //   9827: astore_1
    //   9828: aload_1
    //   9829: invokevirtual 1097	org/json/JSONException:printStackTrace	()V
    //   9832: goto -8467 -> 1365
    //   9835: ldc_w 1922
    //   9838: aload_1
    //   9839: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9842: ifne +13 -> 9855
    //   9845: ldc_w 1924
    //   9848: aload_1
    //   9849: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9852: ifeq +18 -> 9870
    //   9855: aload_0
    //   9856: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9859: aload_3
    //   9860: aload_1
    //   9861: aconst_null
    //   9862: iload 4
    //   9864: invokevirtual 1096	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9867: goto -8502 -> 1365
    //   9870: ldc 20
    //   9872: aload_1
    //   9873: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9876: ifeq -8511 -> 1365
    //   9879: new 273	org/json/JSONObject
    //   9882: dup
    //   9883: aload_2
    //   9884: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9887: ldc_w 1926
    //   9890: invokevirtual 964	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9893: astore_2
    //   9894: aload_2
    //   9895: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9898: ifne -8533 -> 1365
    //   9901: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9904: aload_0
    //   9905: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9908: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9911: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9914: aconst_null
    //   9915: aload_2
    //   9916: new 1928	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23
    //   9919: dup
    //   9920: aload_0
    //   9921: aload_3
    //   9922: aload_1
    //   9923: iload 4
    //   9925: invokespecial 1929	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9928: invokevirtual 1933	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getTcbTicket	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9931: goto -8566 -> 1365
    //   9934: astore_1
    //   9935: ldc 139
    //   9937: iconst_1
    //   9938: ldc_w 1935
    //   9941: aload_1
    //   9942: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   9945: goto -8580 -> 1365
    //   9948: aconst_null
    //   9949: astore_1
    //   9950: goto -2982 -> 6968
    //   9953: aconst_null
    //   9954: astore 20
    //   9956: goto -3694 -> 6262
    //   9959: goto -4053 -> 5906
    //   9962: aconst_null
    //   9963: astore_2
    //   9964: goto -5983 -> 3981
    //   9967: iload 9
    //   9969: istore 14
    //   9971: goto -6834 -> 3137
    //   9974: iconst_0
    //   9975: istore 15
    //   9977: goto -9436 -> 541
    //   9980: ldc_w 797
    //   9983: astore 21
    //   9985: goto -9551 -> 434
    //   9988: iconst_m1
    //   9989: istore 8
    //   9991: iconst_m1
    //   9992: istore 7
    //   9994: iconst_m1
    //   9995: istore 11
    //   9997: iconst_0
    //   9998: istore 10
    //   10000: goto -6980 -> 3020
    //   10003: iload 7
    //   10005: istore 8
    //   10007: iload 7
    //   10009: iconst_m1
    //   10010: if_icmpne -5988 -> 4022
    //   10013: iconst_0
    //   10014: istore 8
    //   10016: goto -5994 -> 4022
    //   10019: ldc_w 664
    //   10022: areturn
    //   10023: iload 9
    //   10025: iconst_1
    //   10026: if_icmpne -5749 -> 4277
    //   10029: iconst_1
    //   10030: istore 7
    //   10032: aconst_null
    //   10033: astore_2
    //   10034: goto -6053 -> 3981
    //   10037: iload 9
    //   10039: iconst_3
    //   10040: if_icmpne +11 -> 10051
    //   10043: iconst_3
    //   10044: istore 7
    //   10046: aconst_null
    //   10047: astore_2
    //   10048: goto -6067 -> 3981
    //   10051: iload 9
    //   10053: iconst_4
    //   10054: if_icmpne -5647 -> 4407
    //   10057: iconst_4
    //   10058: istore 7
    //   10060: aconst_null
    //   10061: astore_2
    //   10062: goto -6081 -> 3981
    //   10065: iconst_0
    //   10066: istore 7
    //   10068: goto -6087 -> 3981
    //   10071: iconst_1
    //   10072: istore 16
    //   10074: goto -5177 -> 4897
    //   10077: iconst_0
    //   10078: istore 16
    //   10080: goto -5183 -> 4897
    //   10083: iconst_0
    //   10084: istore 17
    //   10086: goto -5140 -> 4946
    //   10089: bipush 12
    //   10091: istore 4
    //   10093: goto -5100 -> 4993
    //   10096: bipush 12
    //   10098: istore 4
    //   10100: goto -4908 -> 5192
    //   10103: iconst_1
    //   10104: istore 4
    //   10106: goto -4604 -> 5502
    //   10109: iconst_0
    //   10110: istore 4
    //   10112: goto -4610 -> 5502
    //   10115: iconst_0
    //   10116: istore 8
    //   10118: goto -4565 -> 5553
    //   10121: iload 11
    //   10123: iconst_1
    //   10124: iadd
    //   10125: istore 11
    //   10127: goto -4129 -> 5998
    //   10130: iconst_2
    //   10131: istore 7
    //   10133: goto -3650 -> 6483
    //   10136: aload 21
    //   10138: astore 20
    //   10140: goto -1808 -> 8332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10143	0	this	DataJsPlugin
    //   0	10143	1	paramString1	String
    //   0	10143	2	paramString2	String
    //   0	10143	3	paramJsRuntime	JsRuntime
    //   0	10143	4	paramInt	int
    //   208	479	5	d	double
    //   250	9882	7	i	int
    //   246	9871	8	j	int
    //   227	9828	9	k	int
    //   291	9708	10	m	int
    //   308	9818	11	n	int
    //   2874	474	12	i1	int
    //   2871	457	13	i2	int
    //   3135	6835	14	i3	int
    //   539	9437	15	bool1	boolean
    //   201	9878	16	bool2	boolean
    //   4944	5141	17	bool3	boolean
    //   2139	302	18	l	long
    //   328	1669	20	localObject1	Object
    //   2017	3	20	localJSONException1	org.json.JSONException
    //   2238	6855	20	localObject2	Object
    //   9187	3	20	localJSONException2	org.json.JSONException
    //   9225	60	20	localApkgInfo1	com.tencent.mobileqq.mini.apkg.ApkgInfo
    //   9325	3	20	localJSONException3	org.json.JSONException
    //   9370	769	20	localObject3	Object
    //   429	9708	21	localObject4	Object
    //   73	8859	22	localObject5	Object
    //   2224	5417	23	localObject6	Object
    //   2234	5442	24	str1	String
    //   2229	5455	25	str2	String
    //   2085	3187	26	str3	String
    //   2202	3035	27	str4	String
    //   2214	206	28	localApkgInfo2	com.tencent.mobileqq.mini.apkg.ApkgInfo
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
    //   2340	2383	1819	java/lang/Exception
    //   2396	2404	1819	java/lang/Exception
    //   2408	2432	1819	java/lang/Exception
    //   2432	2472	1819	java/lang/Exception
    //   2475	2648	1819	java/lang/Exception
    //   2651	2694	1819	java/lang/Exception
    //   2708	2719	1819	java/lang/Exception
    //   2722	2762	1819	java/lang/Exception
    //   1981	2002	2017	org/json/JSONException
    //   2967	2997	3185	org/json/JSONException
    //   3020	3037	3185	org/json/JSONException
    //   3037	3047	3185	org/json/JSONException
    //   3050	3060	3185	org/json/JSONException
    //   3063	3073	3185	org/json/JSONException
    //   3076	3085	3185	org/json/JSONException
    //   3600	3655	3700	org/json/JSONException
    //   3659	3681	3700	org/json/JSONException
    //   3681	3697	3700	org/json/JSONException
    //   3719	3735	3700	org/json/JSONException
    //   3738	3795	3700	org/json/JSONException
    //   3798	3814	3700	org/json/JSONException
    //   3826	3854	3883	org/json/JSONException
    //   3868	3880	3883	org/json/JSONException
    //   3932	3941	4554	org/json/JSONException
    //   3944	3965	4554	org/json/JSONException
    //   3981	4019	4554	org/json/JSONException
    //   4022	4045	4554	org/json/JSONException
    //   4045	4076	4554	org/json/JSONException
    //   4076	4086	4554	org/json/JSONException
    //   4090	4108	4554	org/json/JSONException
    //   4108	4138	4554	org/json/JSONException
    //   4142	4157	4554	org/json/JSONException
    //   4162	4200	4554	org/json/JSONException
    //   4200	4224	4554	org/json/JSONException
    //   4224	4246	4554	org/json/JSONException
    //   4246	4274	4554	org/json/JSONException
    //   4286	4295	4554	org/json/JSONException
    //   4299	4371	4554	org/json/JSONException
    //   4376	4402	4554	org/json/JSONException
    //   4413	4445	4554	org/json/JSONException
    //   4449	4461	4554	org/json/JSONException
    //   4464	4478	4554	org/json/JSONException
    //   4481	4507	4554	org/json/JSONException
    //   4519	4528	4554	org/json/JSONException
    //   4536	4551	4554	org/json/JSONException
    //   4573	4602	4554	org/json/JSONException
    //   4605	4623	4554	org/json/JSONException
    //   4626	4680	4554	org/json/JSONException
    //   4683	4707	4554	org/json/JSONException
    //   4710	4735	4554	org/json/JSONException
    //   4735	4759	4554	org/json/JSONException
    //   4759	4790	4554	org/json/JSONException
    //   4794	4819	4554	org/json/JSONException
    //   4819	4843	4554	org/json/JSONException
    //   4843	4874	4554	org/json/JSONException
    //   4878	4894	4554	org/json/JSONException
    //   4897	4943	4554	org/json/JSONException
    //   4946	4954	4554	org/json/JSONException
    //   4964	4984	4554	org/json/JSONException
    //   4993	5075	4554	org/json/JSONException
    //   5078	5110	4554	org/json/JSONException
    //   5114	5150	4554	org/json/JSONException
    //   5153	5175	4554	org/json/JSONException
    //   5175	5183	4554	org/json/JSONException
    //   5192	5219	4554	org/json/JSONException
    //   5222	5251	4554	org/json/JSONException
    //   5260	5287	4554	org/json/JSONException
    //   5315	5334	5573	org/json/JSONException
    //   5345	5354	5573	org/json/JSONException
    //   5367	5390	5573	org/json/JSONException
    //   5390	5413	5573	org/json/JSONException
    //   5413	5444	5573	org/json/JSONException
    //   5444	5499	5573	org/json/JSONException
    //   5502	5550	5573	org/json/JSONException
    //   5558	5570	5573	org/json/JSONException
    //   5629	5644	5573	org/json/JSONException
    //   5647	5662	5573	org/json/JSONException
    //   5665	5694	5573	org/json/JSONException
    //   5697	5704	5573	org/json/JSONException
    //   5714	5721	5573	org/json/JSONException
    //   5725	5740	5573	org/json/JSONException
    //   5743	5752	5573	org/json/JSONException
    //   5755	5787	5573	org/json/JSONException
    //   5791	5817	5573	org/json/JSONException
    //   5830	5840	5573	org/json/JSONException
    //   5875	5893	5981	org/json/JSONException
    //   5906	5918	5981	org/json/JSONException
    //   5927	5932	5981	org/json/JSONException
    //   5937	5942	5981	org/json/JSONException
    //   5947	5952	5981	org/json/JSONException
    //   5957	5962	5981	org/json/JSONException
    //   5962	5978	5981	org/json/JSONException
    //   5998	6015	5981	org/json/JSONException
    //   6015	6025	5981	org/json/JSONException
    //   6028	6038	5981	org/json/JSONException
    //   6041	6051	5981	org/json/JSONException
    //   6054	6064	5981	org/json/JSONException
    //   6070	6086	5981	org/json/JSONException
    //   6089	6115	5981	org/json/JSONException
    //   6120	6134	5981	org/json/JSONException
    //   6139	6153	5981	org/json/JSONException
    //   6158	6172	5981	org/json/JSONException
    //   6177	6191	5981	org/json/JSONException
    //   6191	6207	5981	org/json/JSONException
    //   6210	6226	5981	org/json/JSONException
    //   6282	6302	6405	java/lang/Throwable
    //   6306	6321	6405	java/lang/Throwable
    //   6321	6338	6405	java/lang/Throwable
    //   6343	6369	6405	java/lang/Throwable
    //   6374	6402	6405	java/lang/Throwable
    //   6425	6434	6405	java/lang/Throwable
    //   6444	6460	6405	java/lang/Throwable
    //   6464	6480	6405	java/lang/Throwable
    //   6489	6501	6405	java/lang/Throwable
    //   6504	6516	6405	java/lang/Throwable
    //   6519	6531	6405	java/lang/Throwable
    //   6543	6683	6686	org/json/JSONException
    //   6714	6761	6764	org/json/JSONException
    //   6860	6870	6901	org/json/JSONException
    //   6833	6860	6920	org/json/JSONException
    //   6870	6901	6920	org/json/JSONException
    //   6902	6917	6920	org/json/JSONException
    //   7178	7210	7293	org/json/JSONException
    //   7214	7230	7293	org/json/JSONException
    //   7233	7253	7293	org/json/JSONException
    //   7262	7290	7293	org/json/JSONException
    //   7351	7442	7753	org/json/JSONException
    //   7446	7483	7753	org/json/JSONException
    //   7492	7507	7753	org/json/JSONException
    //   7511	7534	7753	org/json/JSONException
    //   7538	7555	7753	org/json/JSONException
    //   7558	7587	7753	org/json/JSONException
    //   7591	7606	7753	org/json/JSONException
    //   7613	7631	7753	org/json/JSONException
    //   7637	7666	7753	org/json/JSONException
    //   7672	7690	7753	org/json/JSONException
    //   7693	7751	7753	org/json/JSONException
    //   7849	7860	8052	org/json/JSONException
    //   7862	7883	8052	org/json/JSONException
    //   7885	7937	8052	org/json/JSONException
    //   7939	8025	8052	org/json/JSONException
    //   8025	8031	8052	org/json/JSONException
    //   8034	8040	8052	org/json/JSONException
    //   8043	8049	8052	org/json/JSONException
    //   8095	8162	8644	java/lang/Throwable
    //   8164	8188	8644	java/lang/Throwable
    //   8193	8227	8644	java/lang/Throwable
    //   8229	8266	8644	java/lang/Throwable
    //   8268	8282	8644	java/lang/Throwable
    //   8282	8292	8644	java/lang/Throwable
    //   8292	8322	8644	java/lang/Throwable
    //   8332	8425	8644	java/lang/Throwable
    //   8428	8436	8644	java/lang/Throwable
    //   8440	8482	8644	java/lang/Throwable
    //   8482	8641	8644	java/lang/Throwable
    //   8660	8692	8644	java/lang/Throwable
    //   8699	8714	8644	java/lang/Throwable
    //   8717	8737	8644	java/lang/Throwable
    //   8282	8292	8659	java/io/UnsupportedEncodingException
    //   8749	8796	8799	java/lang/Throwable
    //   8830	8860	8979	java/lang/Throwable
    //   8864	8871	8979	java/lang/Throwable
    //   8874	8937	8979	java/lang/Throwable
    //   8946	8976	8979	java/lang/Throwable
    //   9018	9042	9112	java/lang/Throwable
    //   9046	9053	9112	java/lang/Throwable
    //   9056	9080	9112	java/lang/Throwable
    //   9089	9109	9112	java/lang/Throwable
    //   9148	9172	9187	org/json/JSONException
    //   9215	9227	9325	org/json/JSONException
    //   9243	9251	9325	org/json/JSONException
    //   9255	9266	9325	org/json/JSONException
    //   9270	9300	9325	org/json/JSONException
    //   9300	9310	9325	org/json/JSONException
    //   9345	9381	9611	org/json/JSONException
    //   9397	9405	9611	org/json/JSONException
    //   9409	9420	9611	org/json/JSONException
    //   9424	9454	9611	org/json/JSONException
    //   9454	9465	9611	org/json/JSONException
    //   9470	9503	9611	org/json/JSONException
    //   9507	9608	9611	org/json/JSONException
    //   9619	9632	9611	org/json/JSONException
    //   9645	9686	9827	org/json/JSONException
    //   9691	9724	9827	org/json/JSONException
    //   9728	9766	9827	org/json/JSONException
    //   9771	9824	9827	org/json/JSONException
    //   9879	9931	9934	java/lang/Throwable
  }
  
  public void login(aabi paramaabi)
  {
    if (paramaabi == null) {
      return;
    }
    ThreadManager.excute(new DataJsPlugin.26(this, paramaabi), 16, null, false);
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    getOpenUrlDomainWhiteList();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin
 * JD-Core Version:    0.7.0.1
 */