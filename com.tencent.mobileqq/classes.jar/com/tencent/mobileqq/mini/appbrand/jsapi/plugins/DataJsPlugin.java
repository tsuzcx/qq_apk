package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
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
import urk;
import ynv;
import zrt;
import zrw;
import zsb;

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
  private zrw apiManager;
  private Long lastNotRspReqTime = Long.valueOf(0L);
  private List<zrt> loginCallBacks = new LinkedList();
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
      urk.b("[mini] DataJsPlugin", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label44:
      urk.b("[mini] DataJsPlugin", "start load URLDrawable.");
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
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
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
    zsb.a();
    this.apiManager = zsb.a(this.jsPluginEngine.getActivityContext(), paramInt, paramString);
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
    localObject = new Handler(((HandlerThread)localObject).getLooper(), new DataJsPlugin.23(this, paramJsRuntime, paramString2, paramInt2));
    ((Handler)localObject).sendEmptyMessageDelayed(1, paramInt1);
    MiniAppCmdUtil.getInstance().getGroupShareInfo(this.jsPluginEngine.appBrandRuntime.appId, paramString1, null, new DataJsPlugin.24(this, paramJsRuntime, paramString2, paramInt2, (Handler)localObject));
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
      ShareUtils.startSharePicToQzone(this.jsPluginEngine.getActivityContext(), paramString1, paramString2, this.jsPluginEngine.appBrandRuntime.getApkgInfo());
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
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramStGetAdReq, new DataJsPlugin.27(this, paramJsRuntime, paramString, paramInt1, paramInt2));
  }
  
  private void startGroupBrowserActivity(Activity paramActivity, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    paramString1 = new Bundle();
    paramString1.putBoolean("hide_more_button", true);
    localIntent.putExtras(paramString1);
    MiniAppController.getInstance().setActivityResultListener(new DataJsPlugin.28(this, paramJsRuntime, paramString2, paramInt));
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
      ThreadManager.excute(new DataJsPlugin.30(this, paramString2, str), 64, new DataJsPlugin.31(this, str, paramString1, paramInt), true);
      return;
    }
    realSharePic(paramString1, paramString2, paramInt);
  }
  
  private void startShareNetworkPicMessage(Context paramContext, String paramString1, String paramString2, int paramInt, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    ThreadManager.getUIHandler().post(new DataJsPlugin.29(this, paramContext, paramString2, paramString1, paramInt));
  }
  
  public void getUserInfo(JsRuntime paramJsRuntime, String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    String str = this.jsPluginEngine.appBrandRuntime.appId;
    QLog.d("[mini] DataJsPlugin", 1, "getUserInfo appID:" + str);
    MiniAppCmdUtil.getInstance().getUserInfo(str, paramBoolean, paramString3, new DataJsPlugin.26(this, paramString2, paramJsRuntime, paramString1, paramInt));
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
    //   119: aload_0
    //   120: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   123: instanceof 671
    //   126: istore 15
    //   128: ldc 35
    //   130: aload_1
    //   131: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifne +12 -> 146
    //   137: ldc 38
    //   139: aload_1
    //   140: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +1131 -> 1274
    //   146: aload 22
    //   148: ifnull +1094 -> 1242
    //   151: getstatic 676	android/os/Build$VERSION:SDK_INT	I
    //   154: bipush 17
    //   156: if_icmplt +811 -> 967
    //   159: new 678	android/util/DisplayMetrics
    //   162: dup
    //   163: invokespecial 679	android/util/DisplayMetrics:<init>	()V
    //   166: astore_2
    //   167: aload 22
    //   169: ldc_w 681
    //   172: invokevirtual 685	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   175: checkcast 687	android/view/WindowManager
    //   178: invokeinterface 691 1 0
    //   183: aload_2
    //   184: invokevirtual 697	android/view/Display:getRealMetrics	(Landroid/util/DisplayMetrics;)V
    //   187: aload 22
    //   189: invokestatic 703	com/tencent/mobileqq/mini/util/DisplayUtil:hasNavBar	(Landroid/content/Context;)Z
    //   192: ifeq +11 -> 203
    //   195: aload 22
    //   197: invokestatic 707	com/tencent/mobileqq/mini/util/DisplayUtil:isNavigationBarExist	(Landroid/app/Activity;)Z
    //   200: ifne +9 -> 209
    //   203: invokestatic 710	com/tencent/mobileqq/mini/util/DisplayUtil:isFlymeOS7NavBarShow	()Z
    //   206: ifeq +773 -> 979
    //   209: iconst_1
    //   210: istore 16
    //   212: aload_2
    //   213: getfield 714	android/util/DisplayMetrics:density	F
    //   216: f2d
    //   217: dstore 5
    //   219: aload_2
    //   220: getfield 717	android/util/DisplayMetrics:widthPixels	I
    //   223: i2d
    //   224: dload 5
    //   226: ddiv
    //   227: invokestatic 723	java/lang/Math:round	(D)J
    //   230: l2f
    //   231: ldc_w 724
    //   234: fadd
    //   235: f2i
    //   236: istore 9
    //   238: aload_2
    //   239: getfield 727	android/util/DisplayMetrics:heightPixels	I
    //   242: i2d
    //   243: dload 5
    //   245: ddiv
    //   246: invokestatic 723	java/lang/Math:round	(D)J
    //   249: l2f
    //   250: ldc_w 724
    //   253: fadd
    //   254: f2i
    //   255: istore 8
    //   257: iload 8
    //   259: istore 7
    //   261: iload 16
    //   263: ifeq +23 -> 286
    //   266: iload 8
    //   268: aload_0
    //   269: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   272: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   275: invokestatic 731	com/tencent/mobileqq/mini/util/DisplayUtil:getNavigationBarHeight	(Landroid/content/Context;)I
    //   278: i2d
    //   279: dload 5
    //   281: ddiv
    //   282: d2i
    //   283: isub
    //   284: istore 7
    //   286: aload 22
    //   288: invokestatic 736	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   291: i2f
    //   292: invokestatic 739	java/lang/Math:round	(F)I
    //   295: i2d
    //   296: dload 5
    //   298: ddiv
    //   299: d2i
    //   300: istore 10
    //   302: ldc_w 740
    //   305: invokestatic 744	bajq:b	(F)I
    //   308: i2d
    //   309: dload 5
    //   311: ddiv
    //   312: ldc2_w 745
    //   315: dadd
    //   316: d2i
    //   317: istore 11
    //   319: ldc_w 747
    //   322: invokestatic 744	bajq:b	(F)I
    //   325: i2d
    //   326: dload 5
    //   328: ddiv
    //   329: ldc2_w 745
    //   332: dadd
    //   333: d2i
    //   334: istore 8
    //   336: aconst_null
    //   337: astore 20
    //   339: aload_0
    //   340: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   343: ifnull +642 -> 985
    //   346: aload_0
    //   347: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   350: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   353: ifnull +632 -> 985
    //   356: aload_0
    //   357: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   360: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   363: invokevirtual 751	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   366: ifnull +619 -> 985
    //   369: aload_0
    //   370: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   373: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   376: invokevirtual 751	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   379: invokevirtual 756	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   382: ifnull +603 -> 985
    //   385: aload_0
    //   386: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   389: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   392: invokevirtual 751	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   395: invokevirtual 756	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   398: astore 20
    //   400: aload 20
    //   402: astore_2
    //   403: aload 20
    //   405: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifne +9242 -> 9650
    //   411: aload_0
    //   412: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   415: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   418: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   421: invokevirtual 762	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   424: aload 20
    //   426: invokevirtual 768	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   429: getfield 774	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   432: getfield 780	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   435: getfield 785	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   438: astore 21
    //   440: aload 20
    //   442: astore_2
    //   443: aload_0
    //   444: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   447: ifnull +9197 -> 9644
    //   450: aload_0
    //   451: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   454: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   457: ifnull +9187 -> 9644
    //   460: aload_0
    //   461: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   464: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   467: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   470: ifnull +9174 -> 9644
    //   473: aload_0
    //   474: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   477: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   480: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   483: invokevirtual 762	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   486: ifnull +9158 -> 9644
    //   489: aload_0
    //   490: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   493: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   496: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   499: invokevirtual 762	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   502: getfield 789	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   505: ifnull +689 -> 1194
    //   508: aload_0
    //   509: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   512: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   515: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   518: aload_2
    //   519: invokevirtual 792	com/tencent/mobileqq/mini/apkg/ApkgInfo:isTabBarPage	(Ljava/lang/String;)Z
    //   522: ifeq +672 -> 1194
    //   525: aload_0
    //   526: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   529: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   532: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   535: invokevirtual 762	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   538: getfield 789	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   541: invokevirtual 797	com/tencent/mobileqq/mini/apkg/TabBarInfo:isShow	()Z
    //   544: ifeq +650 -> 1194
    //   547: iconst_1
    //   548: istore 15
    //   550: ldc_w 799
    //   553: aload 21
    //   555: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   558: ifeq +648 -> 1206
    //   561: iload 15
    //   563: ifeq +637 -> 1200
    //   566: iload 7
    //   568: iload 10
    //   570: isub
    //   571: iload 11
    //   573: isub
    //   574: iload 8
    //   576: isub
    //   577: istore 8
    //   579: invokestatic 802	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   582: ifeq +63 -> 645
    //   585: ldc 139
    //   587: iconst_1
    //   588: new 323	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   595: ldc_w 804
    //   598: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 8
    //   603: invokevirtual 513	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: ldc_w 806
    //   609: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: aload 21
    //   614: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: ldc_w 808
    //   620: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: iload 15
    //   625: invokevirtual 811	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   628: ldc_w 813
    //   631: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: iload 16
    //   636: invokevirtual 811	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   639: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: aload_0
    //   646: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   649: instanceof 671
    //   652: ifeq +575 -> 1227
    //   655: invokestatic 819	com/tencent/mobileqq/minigame/manager/GameLoadManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameLoadManager;
    //   658: invokevirtual 822	com/tencent/mobileqq/minigame/manager/GameLoadManager:getEngineVersion	()Ljava/lang/String;
    //   661: astore_2
    //   662: new 273	org/json/JSONObject
    //   665: dup
    //   666: invokespecial 823	org/json/JSONObject:<init>	()V
    //   669: astore 20
    //   671: aload 20
    //   673: ldc_w 825
    //   676: getstatic 830	android/os/Build:BRAND	Ljava/lang/String;
    //   679: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   682: pop
    //   683: aload 20
    //   685: ldc_w 836
    //   688: getstatic 839	android/os/Build:MODEL	Ljava/lang/String;
    //   691: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   694: pop
    //   695: aload 20
    //   697: ldc_w 841
    //   700: dload 5
    //   702: invokevirtual 844	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   705: pop
    //   706: aload 20
    //   708: ldc_w 846
    //   711: iload 9
    //   713: invokevirtual 849	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   716: pop
    //   717: aload 20
    //   719: ldc_w 851
    //   722: iload 7
    //   724: invokevirtual 849	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload 20
    //   730: ldc_w 853
    //   733: iload 9
    //   735: invokevirtual 849	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   738: pop
    //   739: aload 20
    //   741: ldc_w 855
    //   744: iload 8
    //   746: invokevirtual 849	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   749: pop
    //   750: aload 20
    //   752: ldc_w 857
    //   755: iload 10
    //   757: invokevirtual 849	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   760: pop
    //   761: aload 20
    //   763: ldc_w 859
    //   766: ldc_w 861
    //   769: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   772: pop
    //   773: aload 20
    //   775: ldc_w 863
    //   778: invokestatic 868	babp:c	()Ljava/lang/String;
    //   781: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   784: pop
    //   785: aload 20
    //   787: ldc_w 870
    //   790: new 323	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   797: ldc_w 872
    //   800: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: getstatic 875	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   806: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   815: pop
    //   816: aload 20
    //   818: ldc_w 877
    //   821: ldc_w 879
    //   824: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   827: pop
    //   828: aload 20
    //   830: ldc_w 881
    //   833: bipush 16
    //   835: invokevirtual 849	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   838: pop
    //   839: aload 20
    //   841: ldc_w 883
    //   844: aload_2
    //   845: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   848: pop
    //   849: aload 20
    //   851: ldc_w 885
    //   854: ldc 112
    //   856: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   859: pop
    //   860: aload 20
    //   862: ldc_w 887
    //   865: aload 22
    //   867: invokestatic 891	com/tencent/mobileqq/mini/util/DisplayUtil:getDisplayCutoutSafeArea	(Landroid/app/Activity;)Lorg/json/JSONObject;
    //   870: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   873: pop
    //   874: aload_1
    //   875: aload 20
    //   877: invokestatic 897	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   880: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   883: astore 20
    //   885: aload 20
    //   887: astore_2
    //   888: ldc 35
    //   890: aload_1
    //   891: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   894: ifeq -824 -> 70
    //   897: aload_3
    //   898: iload 4
    //   900: aload 20
    //   902: invokeinterface 903 3 0
    //   907: aload 20
    //   909: areturn
    //   910: astore_2
    //   911: ldc 139
    //   913: iconst_1
    //   914: new 323	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   921: ldc_w 905
    //   924: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: new 343	java/lang/Throwable
    //   930: dup
    //   931: aload_2
    //   932: invokespecial 908	java/lang/Throwable:<init>	(Ljava/lang/Throwable;)V
    //   935: invokevirtual 911	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   938: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   944: aload_1
    //   945: aconst_null
    //   946: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   949: astore_1
    //   950: aload_3
    //   951: iload 4
    //   953: aload_1
    //   954: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   957: invokeinterface 903 3 0
    //   962: aload_1
    //   963: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   966: areturn
    //   967: aload 22
    //   969: invokevirtual 918	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   972: invokevirtual 924	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   975: astore_2
    //   976: goto -789 -> 187
    //   979: iconst_0
    //   980: istore 16
    //   982: goto -770 -> 212
    //   985: aload 20
    //   987: astore_2
    //   988: aload_0
    //   989: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   992: ifnull +8658 -> 9650
    //   995: aload 20
    //   997: astore_2
    //   998: aload_0
    //   999: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1002: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1005: ifnull +8645 -> 9650
    //   1008: aload 20
    //   1010: astore_2
    //   1011: aload_0
    //   1012: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1015: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1018: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1021: ifnull +8629 -> 9650
    //   1024: aconst_null
    //   1025: astore 20
    //   1027: aload 20
    //   1029: astore_2
    //   1030: aload_0
    //   1031: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1034: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1037: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1040: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1043: ifnull +45 -> 1088
    //   1046: aload 20
    //   1048: astore_2
    //   1049: aload_0
    //   1050: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1053: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1056: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1059: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1062: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1065: ifnull +23 -> 1088
    //   1068: aload_0
    //   1069: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1072: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1075: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1078: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1081: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1084: getfield 939	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   1087: astore_2
    //   1088: aconst_null
    //   1089: astore 20
    //   1091: aload_0
    //   1092: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1095: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1098: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1101: getfield 943	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1104: ifnull +21 -> 1125
    //   1107: aload_0
    //   1108: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1111: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1114: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1117: getfield 943	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1120: getfield 946	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   1123: astore 20
    //   1125: aload_0
    //   1126: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1129: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1132: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1135: aload_2
    //   1136: invokevirtual 949	com/tencent/mobileqq/mini/apkg/ApkgInfo:isUrlFileExist	(Ljava/lang/String;)Z
    //   1139: ifne +49 -> 1188
    //   1142: aload 20
    //   1144: astore_2
    //   1145: aload 20
    //   1147: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1150: ifne +8500 -> 9650
    //   1153: aload_0
    //   1154: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1157: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1160: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1163: invokevirtual 762	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1166: aload 20
    //   1168: invokevirtual 768	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   1171: getfield 774	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   1174: getfield 780	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   1177: getfield 785	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   1180: astore 21
    //   1182: aload 20
    //   1184: astore_2
    //   1185: goto -742 -> 443
    //   1188: aload_2
    //   1189: astore 20
    //   1191: goto -49 -> 1142
    //   1194: iconst_0
    //   1195: istore 15
    //   1197: goto -647 -> 550
    //   1200: iconst_0
    //   1201: istore 8
    //   1203: goto -637 -> 566
    //   1206: iload 15
    //   1208: ifeq +13 -> 1221
    //   1211: iload 7
    //   1213: iload 8
    //   1215: isub
    //   1216: istore 8
    //   1218: goto -639 -> 579
    //   1221: iconst_0
    //   1222: istore 8
    //   1224: goto -13 -> 1211
    //   1227: invokestatic 955	com/tencent/mobileqq/mini/app/AppLoaderFactory:getAppLoaderManager	()Lcom/tencent/mobileqq/mini/app/BaseAppLoaderManager;
    //   1230: invokeinterface 961 1 0
    //   1235: getfield 966	com/tencent/mobileqq/mini/sdk/BaseLibInfo:baseLibVersion	Ljava/lang/String;
    //   1238: astore_2
    //   1239: goto -577 -> 662
    //   1242: ldc 139
    //   1244: iconst_1
    //   1245: ldc_w 968
    //   1248: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1251: aload_1
    //   1252: aconst_null
    //   1253: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1256: astore_1
    //   1257: aload_3
    //   1258: iload 4
    //   1260: aload_1
    //   1261: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1264: invokeinterface 903 3 0
    //   1269: aload_1
    //   1270: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1273: areturn
    //   1274: ldc_w 970
    //   1277: aload_1
    //   1278: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1281: ifeq +135 -> 1416
    //   1284: iconst_0
    //   1285: istore 8
    //   1287: iload 8
    //   1289: istore 7
    //   1291: aload_2
    //   1292: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1295: ifne +70 -> 1365
    //   1298: new 273	org/json/JSONObject
    //   1301: dup
    //   1302: aload_2
    //   1303: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1306: ldc_w 972
    //   1309: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1312: astore_1
    //   1313: iload 8
    //   1315: istore 7
    //   1317: aload_1
    //   1318: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1321: ifne +44 -> 1365
    //   1324: iconst_1
    //   1325: istore 7
    //   1327: aload 22
    //   1329: new 532	android/content/Intent
    //   1332: dup
    //   1333: ldc_w 977
    //   1336: new 323	java/lang/StringBuilder
    //   1339: dup
    //   1340: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1343: ldc_w 979
    //   1346: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: aload_1
    //   1350: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1356: invokestatic 985	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1359: invokespecial 988	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1362: invokevirtual 992	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1365: iload 7
    //   1367: ifeq +38 -> 1405
    //   1370: ldc_w 970
    //   1373: aconst_null
    //   1374: invokestatic 897	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1377: astore_1
    //   1378: aload_1
    //   1379: ifnull +15 -> 1394
    //   1382: aload_3
    //   1383: iload 4
    //   1385: aload_1
    //   1386: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1389: invokeinterface 903 3 0
    //   1394: ldc_w 664
    //   1397: areturn
    //   1398: astore_1
    //   1399: iconst_0
    //   1400: istore 7
    //   1402: goto -37 -> 1365
    //   1405: ldc_w 970
    //   1408: aconst_null
    //   1409: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1412: astore_1
    //   1413: goto -35 -> 1378
    //   1416: ldc_w 994
    //   1419: aload_1
    //   1420: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1423: ifeq +202 -> 1625
    //   1426: ldc 139
    //   1428: iconst_2
    //   1429: iconst_2
    //   1430: anewarray 666	java/lang/Object
    //   1433: dup
    //   1434: iconst_0
    //   1435: ldc_w 995
    //   1438: aastore
    //   1439: dup
    //   1440: iconst_1
    //   1441: aload_2
    //   1442: aastore
    //   1443: invokestatic 998	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1446: new 273	org/json/JSONObject
    //   1449: dup
    //   1450: aload_2
    //   1451: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1454: ldc_w 1000
    //   1457: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1460: astore 20
    //   1462: aload 20
    //   1464: ldc_w 1006
    //   1467: ldc_w 664
    //   1470: invokevirtual 1009	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1473: astore 21
    //   1475: aload 20
    //   1477: ldc_w 1011
    //   1480: iconst_1
    //   1481: invokevirtual 1015	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1484: pop
    //   1485: ldc_w 1017
    //   1488: aload 21
    //   1490: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1493: ifeq -99 -> 1394
    //   1496: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1499: invokevirtual 1021	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1502: astore 20
    //   1504: aload 20
    //   1506: instanceof 1023
    //   1509: ifeq +101 -> 1610
    //   1512: aload 20
    //   1514: checkcast 1023	com/tencent/mobileqq/mini/MiniAppInterface
    //   1517: aload_0
    //   1518: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1521: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1524: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1527: invokevirtual 1027	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   1530: astore 20
    //   1532: aload 20
    //   1534: ifnull +61 -> 1595
    //   1537: aload 20
    //   1539: aload_1
    //   1540: aload_2
    //   1541: invokevirtual 1033	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlag	(Ljava/lang/String;Ljava/lang/String;)I
    //   1544: iconst_2
    //   1545: if_icmpne +50 -> 1595
    //   1548: new 1035	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2
    //   1551: dup
    //   1552: aload_0
    //   1553: aload_3
    //   1554: aload_1
    //   1555: iload 4
    //   1557: invokespecial 1036	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1560: astore_1
    //   1561: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1564: aload_0
    //   1565: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1568: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1571: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1574: aload_1
    //   1575: invokevirtual 1039	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getPhoneNumber	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1578: goto -184 -> 1394
    //   1581: astore_1
    //   1582: ldc 139
    //   1584: iconst_2
    //   1585: ldc_w 995
    //   1588: aload_1
    //   1589: invokestatic 1041	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1592: goto -198 -> 1394
    //   1595: aload_0
    //   1596: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1599: aload_3
    //   1600: aload_1
    //   1601: aconst_null
    //   1602: iload 4
    //   1604: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   1607: goto -213 -> 1394
    //   1610: aload_0
    //   1611: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1614: aload_3
    //   1615: aload_1
    //   1616: aconst_null
    //   1617: iload 4
    //   1619: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   1622: goto -228 -> 1394
    //   1625: ldc 50
    //   1627: aload_1
    //   1628: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1631: ifeq +86 -> 1717
    //   1634: ldc 139
    //   1636: iconst_2
    //   1637: new 323	java/lang/StringBuilder
    //   1640: dup
    //   1641: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1644: ldc_w 1046
    //   1647: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: iload 4
    //   1652: invokevirtual 513	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1655: ldc_w 1048
    //   1658: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: aload_0
    //   1662: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1665: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1668: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1671: getfield 943	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1674: getfield 1051	com/tencent/mobileqq/mini/apkg/AppConfigInfo:PackageToolVersion	Ljava/lang/String;
    //   1677: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1683: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1686: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1689: aload_0
    //   1690: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1693: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1696: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1699: new 1053	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3
    //   1702: dup
    //   1703: aload_0
    //   1704: aload_3
    //   1705: aload_1
    //   1706: iload 4
    //   1708: invokespecial 1054	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1711: invokevirtual 1057	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getLoginCode	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1714: goto -320 -> 1394
    //   1717: ldc_w 1059
    //   1720: aload_1
    //   1721: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1724: ifeq +1070 -> 2794
    //   1727: new 273	org/json/JSONObject
    //   1730: dup
    //   1731: invokespecial 823	org/json/JSONObject:<init>	()V
    //   1734: pop
    //   1735: new 273	org/json/JSONObject
    //   1738: dup
    //   1739: aload_2
    //   1740: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1743: astore 20
    //   1745: aload 20
    //   1747: ldc_w 1000
    //   1750: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1753: astore 22
    //   1755: aload 22
    //   1757: ldc_w 1006
    //   1760: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1763: astore 21
    //   1765: ldc_w 1061
    //   1768: aload 21
    //   1770: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1773: ifne +14 -> 1787
    //   1776: ldc_w 1063
    //   1779: aload 21
    //   1781: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1784: ifeq +101 -> 1885
    //   1787: aload 22
    //   1789: ldc_w 1011
    //   1792: invokevirtual 1065	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1795: istore 15
    //   1797: aload 22
    //   1799: ldc_w 1067
    //   1802: aconst_null
    //   1803: invokevirtual 1009	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1806: astore 20
    //   1808: aload 22
    //   1810: ldc_w 1000
    //   1813: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1816: astore_2
    //   1817: aload_2
    //   1818: ifnull +49 -> 1867
    //   1821: aload_2
    //   1822: ldc_w 1067
    //   1825: ldc_w 1069
    //   1828: invokevirtual 1009	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1831: astore_2
    //   1832: aload_0
    //   1833: aload_3
    //   1834: aload_1
    //   1835: aload 21
    //   1837: iload 4
    //   1839: iload 15
    //   1841: aload_2
    //   1842: invokevirtual 1071	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getUserInfo	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V
    //   1845: goto -451 -> 1394
    //   1848: astore_1
    //   1849: ldc 139
    //   1851: iconst_1
    //   1852: aload_1
    //   1853: iconst_0
    //   1854: anewarray 666	java/lang/Object
    //   1857: invokestatic 1074	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1860: aload_1
    //   1861: invokevirtual 1075	java/lang/Exception:printStackTrace	()V
    //   1864: goto -470 -> 1394
    //   1867: aload 20
    //   1869: astore_2
    //   1870: aload 20
    //   1872: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1875: ifeq -43 -> 1832
    //   1878: ldc_w 1069
    //   1881: astore_2
    //   1882: goto -50 -> 1832
    //   1885: ldc_w 1077
    //   1888: aload 21
    //   1890: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1893: ifeq +47 -> 1940
    //   1896: new 1079	Wallet/IsUinFocusMpIdReq
    //   1899: dup
    //   1900: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1903: invokevirtual 1021	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1906: invokevirtual 1084	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   1909: aload_0
    //   1910: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1913: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1916: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1919: invokespecial 1086	Wallet/IsUinFocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1922: new 1088	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4
    //   1925: dup
    //   1926: aload_0
    //   1927: aload_3
    //   1928: aload_1
    //   1929: iload 4
    //   1931: invokespecial 1089	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1934: invokestatic 1094	agkg:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   1937: goto -543 -> 1394
    //   1940: ldc_w 1096
    //   1943: aload 21
    //   1945: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1948: ifeq +141 -> 2089
    //   1951: aload 20
    //   1953: ldc_w 1098
    //   1956: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1959: ldc_w 1100
    //   1962: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1965: astore_2
    //   1966: ldc 98
    //   1968: aload_0
    //   1969: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1972: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1975: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1978: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1981: ifeq +75 -> 2056
    //   1984: ldc 139
    //   1986: iconst_1
    //   1987: ldc_w 1102
    //   1990: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1993: new 273	org/json/JSONObject
    //   1996: dup
    //   1997: invokespecial 823	org/json/JSONObject:<init>	()V
    //   2000: astore_2
    //   2001: new 273	org/json/JSONObject
    //   2004: dup
    //   2005: invokespecial 823	org/json/JSONObject:<init>	()V
    //   2008: astore 20
    //   2010: aload 20
    //   2012: ldc_w 1000
    //   2015: ldc 145
    //   2017: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2020: pop
    //   2021: aload_2
    //   2022: ldc_w 1104
    //   2025: aload 20
    //   2027: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2030: pop
    //   2031: aload_0
    //   2032: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2035: aload_3
    //   2036: aload_1
    //   2037: aload_2
    //   2038: iload 4
    //   2040: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2043: goto -649 -> 1394
    //   2046: astore 20
    //   2048: aload 20
    //   2050: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   2053: goto -22 -> 2031
    //   2056: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2059: aload_0
    //   2060: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2063: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2066: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2069: aload_2
    //   2070: aconst_null
    //   2071: new 1110	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5
    //   2074: dup
    //   2075: aload_0
    //   2076: aload_3
    //   2077: aload_1
    //   2078: iload 4
    //   2080: invokespecial 1111	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2083: invokevirtual 1114	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkNavigateRight	(Ljava/lang/String;Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2086: goto -692 -> 1394
    //   2089: ldc_w 1116
    //   2092: aload 21
    //   2094: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2097: ifeq +407 -> 2504
    //   2100: aload 22
    //   2102: ldc_w 1000
    //   2105: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2108: ldc_w 1118
    //   2111: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2114: astore 26
    //   2116: iconst_2
    //   2117: istore 7
    //   2119: aload 22
    //   2121: ldc_w 1000
    //   2124: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2127: ldc_w 1120
    //   2130: invokevirtual 503	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2133: ifeq +19 -> 2152
    //   2136: aload 22
    //   2138: ldc_w 1000
    //   2141: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2144: ldc_w 1120
    //   2147: invokevirtual 1124	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2150: istore 7
    //   2152: aload_0
    //   2153: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2156: getfield 1128	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2159: invokevirtual 1133	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   2162: invokestatic 1136	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   2165: invokevirtual 1140	java/lang/Long:longValue	()J
    //   2168: lstore 18
    //   2170: aconst_null
    //   2171: astore_2
    //   2172: aload_0
    //   2173: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2176: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2179: ifnull +14 -> 2193
    //   2182: aload_0
    //   2183: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2186: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2189: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2192: astore_2
    //   2193: ldc 139
    //   2195: iconst_2
    //   2196: new 323	java/lang/StringBuilder
    //   2199: dup
    //   2200: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2203: ldc_w 1142
    //   2206: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2209: aload_2
    //   2210: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2213: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2216: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2219: aload_2
    //   2220: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2223: ifne -829 -> 1394
    //   2226: iload 7
    //   2228: invokestatic 1146	com/tencent/mobileqq/mini/util/AdUtils:getSpAdGdtCookie	(I)Ljava/lang/String;
    //   2231: astore 27
    //   2233: aload_0
    //   2234: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2237: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2240: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   2243: astore 28
    //   2245: ldc_w 664
    //   2248: astore 21
    //   2250: ldc_w 664
    //   2253: astore 23
    //   2255: ldc_w 664
    //   2258: astore 25
    //   2260: ldc_w 664
    //   2263: astore 24
    //   2265: aload 21
    //   2267: astore 20
    //   2269: aload 28
    //   2271: ifnull +61 -> 2332
    //   2274: aload 21
    //   2276: astore 20
    //   2278: aload 28
    //   2280: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2283: ifnull +49 -> 2332
    //   2286: aload 21
    //   2288: astore 20
    //   2290: aload 28
    //   2292: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2295: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2298: ifnull +34 -> 2332
    //   2301: aload 21
    //   2303: astore 20
    //   2305: aload 28
    //   2307: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2310: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2313: getfield 939	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2316: ifnull +16 -> 2332
    //   2319: aload 28
    //   2321: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2324: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2327: getfield 939	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2330: astore 20
    //   2332: aload 23
    //   2334: astore 22
    //   2336: aload 25
    //   2338: astore 21
    //   2340: aload 28
    //   2342: ifnull +70 -> 2412
    //   2345: aload 23
    //   2347: astore 22
    //   2349: aload 25
    //   2351: astore 21
    //   2353: aload 28
    //   2355: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2358: ifnull +54 -> 2412
    //   2361: aload 23
    //   2363: astore 22
    //   2365: aload 25
    //   2367: astore 21
    //   2369: aload 28
    //   2371: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2374: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2377: ifnull +35 -> 2412
    //   2380: aload 28
    //   2382: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2385: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2388: getfield 1150	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/util/Map;
    //   2391: invokestatic 1156	com/tencent/mobileqq/mini/apkg/MiniAppInfo:getReportDataString	(Ljava/util/Map;)Ljava/lang/String;
    //   2394: astore 22
    //   2396: aload 28
    //   2398: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2401: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2404: getfield 1159	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   2407: invokestatic 1161	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2410: astore 21
    //   2412: aload 24
    //   2414: astore 23
    //   2416: aload 28
    //   2418: ifnull +43 -> 2461
    //   2421: aload 24
    //   2423: astore 23
    //   2425: aload 28
    //   2427: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2430: ifnull +31 -> 2461
    //   2433: aload 24
    //   2435: astore 23
    //   2437: aload 28
    //   2439: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2442: getfield 1165	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2445: ifnull +16 -> 2461
    //   2448: aload 28
    //   2450: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2453: getfield 1165	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2456: getfield 1168	com/tencent/mobileqq/mini/apkg/MiniAppInfo:via	Ljava/lang/String;
    //   2459: astore 23
    //   2461: aload_0
    //   2462: aload_0
    //   2463: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2466: getfield 1128	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2469: lload 18
    //   2471: aload 26
    //   2473: aload_2
    //   2474: bipush 53
    //   2476: iload 7
    //   2478: iconst_0
    //   2479: aload 27
    //   2481: aload 20
    //   2483: aload 22
    //   2485: aload 21
    //   2487: aload 23
    //   2489: invokestatic 1172	com/tencent/mobileqq/mini/util/AdUtils:createAdRequest	(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)LNS_MINI_AD/MiniAppAd$StGetAdReq;
    //   2492: aload_3
    //   2493: aload_1
    //   2494: iload 4
    //   2496: iload 7
    //   2498: invokespecial 1174	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:sendAdRequest	(LNS_MINI_AD/MiniAppAd$StGetAdReq;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;II)V
    //   2501: goto -1107 -> 1394
    //   2504: ldc_w 1176
    //   2507: aload 21
    //   2509: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2512: ifeq +168 -> 2680
    //   2515: new 273	org/json/JSONObject
    //   2518: dup
    //   2519: new 273	org/json/JSONObject
    //   2522: dup
    //   2523: aload_2
    //   2524: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2527: ldc_w 1000
    //   2530: invokevirtual 1178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2533: ldc_w 1000
    //   2536: invokevirtual 1178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2539: ldc_w 306
    //   2542: invokevirtual 1181	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   2545: invokevirtual 1182	java/lang/Object:toString	()Ljava/lang/String;
    //   2548: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2551: astore_2
    //   2552: ldc_w 308
    //   2555: new 308	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   2558: dup
    //   2559: invokespecial 309	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   2562: aload_2
    //   2563: invokestatic 315	ynv:a	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   2566: invokevirtual 321	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2569: checkcast 308	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   2572: astore 20
    //   2574: new 1184	yjs
    //   2577: dup
    //   2578: invokespecial 1185	yjs:<init>	()V
    //   2581: astore_2
    //   2582: aload_2
    //   2583: bipush 11
    //   2585: putfield 1187	yjs:jdField_a_of_type_Int	I
    //   2588: aload_2
    //   2589: new 1189	java/lang/ref/WeakReference
    //   2592: dup
    //   2593: aload_0
    //   2594: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2597: getfield 1128	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2600: invokespecial 1192	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   2603: putfield 1195	yjs:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   2606: aload_2
    //   2607: new 1197	com/tencent/gdtad/aditem/GdtAd
    //   2610: dup
    //   2611: aload 20
    //   2613: invokespecial 1200	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   2616: putfield 1203	yjs:jdField_a_of_type_ComTencentGdtadAditemGdtAd	Lcom/tencent/gdtad/aditem/GdtAd;
    //   2619: aload_2
    //   2620: iconst_1
    //   2621: putfield 1206	yjs:jdField_a_of_type_Boolean	Z
    //   2624: aload_2
    //   2625: iconst_1
    //   2626: putfield 1208	yjs:jdField_b_of_type_Boolean	Z
    //   2629: aload_2
    //   2630: ldc_w 1210
    //   2633: putfield 1213	yjs:jdField_b_of_type_JavaLangClass	Ljava/lang/Class;
    //   2636: new 545	android/os/Bundle
    //   2639: dup
    //   2640: invokespecial 546	android/os/Bundle:<init>	()V
    //   2643: astore 20
    //   2645: aload 20
    //   2647: ldc_w 1215
    //   2650: ldc 8
    //   2652: invokevirtual 1218	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2655: aload_2
    //   2656: aload 20
    //   2658: putfield 1221	yjs:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   2661: aload_2
    //   2662: invokestatic 1226	yjr:a	(Lyjs;)V
    //   2665: aload_0
    //   2666: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2669: aload_3
    //   2670: aload_1
    //   2671: aconst_null
    //   2672: iload 4
    //   2674: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2677: goto -1283 -> 1394
    //   2680: ldc_w 1228
    //   2683: aload 21
    //   2685: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2688: ifeq +63 -> 2751
    //   2691: aload 22
    //   2693: ldc_w 1000
    //   2696: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2699: ldc_w 1230
    //   2702: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2705: astore_2
    //   2706: aload 22
    //   2708: ldc_w 1000
    //   2711: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2714: ldc_w 1232
    //   2717: iconst_0
    //   2718: invokevirtual 1235	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2721: istore 8
    //   2723: iload 8
    //   2725: istore 7
    //   2727: iload 8
    //   2729: ifgt +8 -> 2737
    //   2732: sipush 30000
    //   2735: istore 7
    //   2737: aload_0
    //   2738: aload_2
    //   2739: iload 7
    //   2741: aload_3
    //   2742: aload_1
    //   2743: iload 4
    //   2745: invokespecial 1237	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2748: goto -1354 -> 1394
    //   2751: ldc_w 1239
    //   2754: aload 21
    //   2756: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2759: ifeq -1365 -> 1394
    //   2762: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2765: aload_0
    //   2766: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2769: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2772: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2775: aconst_null
    //   2776: new 1241	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6
    //   2779: dup
    //   2780: aload_0
    //   2781: aload_3
    //   2782: aload_1
    //   2783: iload 4
    //   2785: invokespecial 1242	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2788: invokevirtual 1246	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserHealthData	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2791: goto -1397 -> 1394
    //   2794: ldc 59
    //   2796: aload_1
    //   2797: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2800: ifeq +34 -> 2834
    //   2803: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2806: aload_0
    //   2807: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2810: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2813: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2816: new 1248	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7
    //   2819: dup
    //   2820: aload_0
    //   2821: aload_3
    //   2822: aload_1
    //   2823: iload 4
    //   2825: invokespecial 1249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2828: invokevirtual 1252	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkSession	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2831: goto -1437 -> 1394
    //   2834: ldc 83
    //   2836: aload_1
    //   2837: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2840: ifne +12 -> 2852
    //   2843: ldc 86
    //   2845: aload_1
    //   2846: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2849: ifeq +771 -> 3620
    //   2852: aload_0
    //   2853: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2856: ifnull +752 -> 3608
    //   2859: aload_0
    //   2860: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2863: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2866: ifnull +688 -> 3554
    //   2869: iconst_m1
    //   2870: istore 9
    //   2872: aload_2
    //   2873: ifnull +23 -> 2896
    //   2876: ldc_w 1254
    //   2879: aload_2
    //   2880: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2883: ifne +13 -> 2896
    //   2886: ldc_w 1256
    //   2889: aload_2
    //   2890: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2893: ifeq +103 -> 2996
    //   2896: iconst_0
    //   2897: istore 15
    //   2899: iconst_1
    //   2900: istore 13
    //   2902: iconst_1
    //   2903: istore 12
    //   2905: iconst_1
    //   2906: istore 9
    //   2908: iconst_1
    //   2909: istore 7
    //   2911: aload_0
    //   2912: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   2915: ifeq +412 -> 3327
    //   2918: aload_0
    //   2919: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   2922: astore_2
    //   2923: aload_2
    //   2924: ifnull +384 -> 3308
    //   2927: iload 13
    //   2929: iconst_1
    //   2930: if_icmpne +346 -> 3276
    //   2933: aload_2
    //   2934: iconst_1
    //   2935: putfield 1268	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   2938: iload 12
    //   2940: iconst_1
    //   2941: if_icmpne +343 -> 3284
    //   2944: aload_2
    //   2945: iconst_1
    //   2946: putfield 1271	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   2949: iload 9
    //   2951: iconst_1
    //   2952: if_icmpne +340 -> 3292
    //   2955: aload_2
    //   2956: iconst_1
    //   2957: putfield 1274	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   2960: iload 7
    //   2962: iconst_1
    //   2963: if_icmpne +337 -> 3300
    //   2966: aload_2
    //   2967: iconst_1
    //   2968: putfield 1277	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   2971: aload_2
    //   2972: iload 15
    //   2974: putfield 1280	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   2977: aload_0
    //   2978: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2981: aload_3
    //   2982: aload_1
    //   2983: aload_1
    //   2984: aconst_null
    //   2985: invokestatic 897	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   2988: iload 4
    //   2990: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2993: goto -1599 -> 1394
    //   2996: new 273	org/json/JSONObject
    //   2999: dup
    //   3000: aload_2
    //   3001: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3004: astore_2
    //   3005: aload_2
    //   3006: ldc_w 1281
    //   3009: iconst_0
    //   3010: invokevirtual 1015	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3013: istore 16
    //   3015: aload_2
    //   3016: ldc_w 1283
    //   3019: invokevirtual 1286	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   3022: checkcast 284	org/json/JSONArray
    //   3025: astore_2
    //   3026: aload_2
    //   3027: ifnonnull +6631 -> 9658
    //   3030: iconst_1
    //   3031: istore 13
    //   3033: iconst_1
    //   3034: istore 12
    //   3036: iconst_1
    //   3037: istore 9
    //   3039: iconst_1
    //   3040: istore 7
    //   3042: iload 16
    //   3044: istore 15
    //   3046: goto -135 -> 2911
    //   3049: iload 10
    //   3051: aload_2
    //   3052: invokevirtual 1289	org/json/JSONArray:length	()I
    //   3055: if_icmpge +76 -> 3131
    //   3058: aload_2
    //   3059: iload 10
    //   3061: invokevirtual 1291	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   3064: astore 20
    //   3066: aload 20
    //   3068: ldc 112
    //   3070: invokevirtual 1294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3073: ifeq +6 -> 3079
    //   3076: iconst_1
    //   3077: istore 11
    //   3079: aload 20
    //   3081: ldc 115
    //   3083: invokevirtual 1294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3086: ifeq +6 -> 3092
    //   3089: iconst_1
    //   3090: istore 7
    //   3092: aload 20
    //   3094: ldc 118
    //   3096: invokevirtual 1294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3099: ifeq +6 -> 3105
    //   3102: iconst_1
    //   3103: istore 9
    //   3105: aload 20
    //   3107: ldc 121
    //   3109: invokevirtual 1294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3112: istore 15
    //   3114: iload 15
    //   3116: ifeq +6 -> 3122
    //   3119: iconst_1
    //   3120: istore 8
    //   3122: iload 10
    //   3124: iconst_1
    //   3125: iadd
    //   3126: istore 10
    //   3128: goto -79 -> 3049
    //   3131: iload 11
    //   3133: istore 10
    //   3135: iload 11
    //   3137: iconst_m1
    //   3138: if_icmpne +6 -> 3144
    //   3141: iconst_0
    //   3142: istore 10
    //   3144: iload 7
    //   3146: istore 11
    //   3148: iload 7
    //   3150: iconst_m1
    //   3151: if_icmpne +6 -> 3157
    //   3154: iconst_0
    //   3155: istore 11
    //   3157: iload 9
    //   3159: iconst_m1
    //   3160: if_icmpne +6477 -> 9637
    //   3163: iconst_0
    //   3164: istore 14
    //   3166: iload 14
    //   3168: istore 9
    //   3170: iload 8
    //   3172: istore 7
    //   3174: iload 11
    //   3176: istore 12
    //   3178: iload 10
    //   3180: istore 13
    //   3182: iload 16
    //   3184: istore 15
    //   3186: iload 8
    //   3188: iconst_m1
    //   3189: if_icmpne -278 -> 2911
    //   3192: iconst_0
    //   3193: istore 7
    //   3195: iload 14
    //   3197: istore 9
    //   3199: iload 11
    //   3201: istore 12
    //   3203: iload 10
    //   3205: istore 13
    //   3207: iload 16
    //   3209: istore 15
    //   3211: goto -300 -> 2911
    //   3214: astore_2
    //   3215: aload_2
    //   3216: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   3219: ldc 139
    //   3221: iconst_1
    //   3222: aload_2
    //   3223: iconst_0
    //   3224: anewarray 666	java/lang/Object
    //   3227: invokestatic 1074	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3230: aload_0
    //   3231: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3234: ifeq +23 -> 3257
    //   3237: aload_0
    //   3238: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3241: aload_3
    //   3242: aload_1
    //   3243: aload_1
    //   3244: aconst_null
    //   3245: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3248: iload 4
    //   3250: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3253: ldc_w 664
    //   3256: areturn
    //   3257: aload_0
    //   3258: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3261: aload_3
    //   3262: aload_1
    //   3263: aload_1
    //   3264: aconst_null
    //   3265: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3268: iload 4
    //   3270: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3273: goto -20 -> 3253
    //   3276: aload_2
    //   3277: iconst_0
    //   3278: putfield 1268	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3281: goto -343 -> 2938
    //   3284: aload_2
    //   3285: iconst_0
    //   3286: putfield 1271	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3289: goto -340 -> 2949
    //   3292: aload_2
    //   3293: iconst_0
    //   3294: putfield 1274	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3297: goto -337 -> 2960
    //   3300: aload_2
    //   3301: iconst_0
    //   3302: putfield 1277	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3305: goto -334 -> 2971
    //   3308: aload_0
    //   3309: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3312: aload_3
    //   3313: aload_1
    //   3314: aload_1
    //   3315: aconst_null
    //   3316: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3319: iload 4
    //   3321: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3324: goto -1930 -> 1394
    //   3327: aload_0
    //   3328: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3331: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3334: invokevirtual 1298	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3337: ifnull +198 -> 3535
    //   3340: aload_0
    //   3341: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3344: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3347: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3350: ifnull +185 -> 3535
    //   3353: iload 13
    //   3355: iconst_1
    //   3356: if_icmpne +111 -> 3467
    //   3359: aload_0
    //   3360: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3363: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3366: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3369: iconst_1
    //   3370: putfield 1305	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3373: iload 12
    //   3375: iconst_1
    //   3376: if_icmpne +108 -> 3484
    //   3379: aload_0
    //   3380: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3383: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3386: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3389: iconst_1
    //   3390: putfield 1306	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3393: iload 9
    //   3395: iconst_1
    //   3396: if_icmpne +105 -> 3501
    //   3399: aload_0
    //   3400: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3403: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3406: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3409: iconst_1
    //   3410: putfield 1307	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3413: iload 7
    //   3415: iconst_1
    //   3416: if_icmpne +102 -> 3518
    //   3419: aload_0
    //   3420: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3423: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3426: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3429: iconst_1
    //   3430: putfield 1308	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3433: aload_0
    //   3434: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3437: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3440: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3443: iload 15
    //   3445: putfield 1309	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3448: aload_0
    //   3449: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3452: aload_3
    //   3453: aload_1
    //   3454: aload_1
    //   3455: aconst_null
    //   3456: invokestatic 897	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3459: iload 4
    //   3461: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3464: goto -2070 -> 1394
    //   3467: aload_0
    //   3468: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3471: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3474: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3477: iconst_0
    //   3478: putfield 1305	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3481: goto -108 -> 3373
    //   3484: aload_0
    //   3485: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3488: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3491: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3494: iconst_0
    //   3495: putfield 1306	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3498: goto -105 -> 3393
    //   3501: aload_0
    //   3502: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3505: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3508: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3511: iconst_0
    //   3512: putfield 1307	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3515: goto -102 -> 3413
    //   3518: aload_0
    //   3519: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3522: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3525: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3528: iconst_0
    //   3529: putfield 1308	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3532: goto -99 -> 3433
    //   3535: aload_0
    //   3536: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3539: aload_3
    //   3540: aload_1
    //   3541: aload_1
    //   3542: aconst_null
    //   3543: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3546: iload 4
    //   3548: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3551: goto -2157 -> 1394
    //   3554: ldc 139
    //   3556: iconst_1
    //   3557: ldc_w 1311
    //   3560: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3563: aload_0
    //   3564: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3567: ifeq +22 -> 3589
    //   3570: aload_0
    //   3571: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3574: aload_3
    //   3575: aload_1
    //   3576: aload_1
    //   3577: aconst_null
    //   3578: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3581: iload 4
    //   3583: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3586: goto -2192 -> 1394
    //   3589: aload_0
    //   3590: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3593: aload_3
    //   3594: aload_1
    //   3595: aload_1
    //   3596: aconst_null
    //   3597: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3600: iload 4
    //   3602: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3605: goto -2211 -> 1394
    //   3608: ldc 139
    //   3610: iconst_1
    //   3611: ldc_w 1313
    //   3614: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3617: goto -2223 -> 1394
    //   3620: ldc 89
    //   3622: aload_1
    //   3623: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3626: ifeq +220 -> 3846
    //   3629: new 273	org/json/JSONObject
    //   3632: dup
    //   3633: aload_2
    //   3634: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3637: astore_2
    //   3638: aload_2
    //   3639: ldc_w 1281
    //   3642: iconst_0
    //   3643: invokevirtual 1015	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3646: istore 15
    //   3648: aload_2
    //   3649: ldc_w 1315
    //   3652: invokevirtual 1065	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   3655: pop
    //   3656: aload_2
    //   3657: ldc_w 1317
    //   3660: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3663: pop
    //   3664: aload_2
    //   3665: ldc_w 1319
    //   3668: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3671: pop
    //   3672: aload_0
    //   3673: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3676: ifeq +91 -> 3767
    //   3679: aload_0
    //   3680: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3683: astore_2
    //   3684: aload_2
    //   3685: ifnull +63 -> 3748
    //   3688: aload_2
    //   3689: iload 15
    //   3691: putfield 1280	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3694: aload_0
    //   3695: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3698: aload_3
    //   3699: aload_1
    //   3700: aload_1
    //   3701: aconst_null
    //   3702: invokestatic 897	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3705: iload 4
    //   3707: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3710: aload_0
    //   3711: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3714: aload_3
    //   3715: aload_1
    //   3716: aload_1
    //   3717: aconst_null
    //   3718: invokestatic 897	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3721: iload 4
    //   3723: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3726: goto -2332 -> 1394
    //   3729: astore_1
    //   3730: ldc 139
    //   3732: iconst_1
    //   3733: aload_1
    //   3734: iconst_0
    //   3735: anewarray 666	java/lang/Object
    //   3738: invokestatic 1074	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3741: aload_1
    //   3742: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   3745: goto -2351 -> 1394
    //   3748: aload_0
    //   3749: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3752: aload_3
    //   3753: aload_1
    //   3754: aload_1
    //   3755: aconst_null
    //   3756: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3759: iload 4
    //   3761: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3764: goto -54 -> 3710
    //   3767: aload_0
    //   3768: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3771: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3774: invokevirtual 1298	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3777: ifnull +50 -> 3827
    //   3780: aload_0
    //   3781: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3784: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3787: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3790: ifnull +37 -> 3827
    //   3793: aload_0
    //   3794: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3797: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3800: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3803: iload 15
    //   3805: putfield 1309	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3808: aload_0
    //   3809: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3812: aload_3
    //   3813: aload_1
    //   3814: aload_1
    //   3815: aconst_null
    //   3816: invokestatic 897	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3819: iload 4
    //   3821: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3824: goto -114 -> 3710
    //   3827: aload_0
    //   3828: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3831: aload_3
    //   3832: aload_1
    //   3833: aload_1
    //   3834: aconst_null
    //   3835: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3838: iload 4
    //   3840: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3843: goto -133 -> 3710
    //   3846: ldc 32
    //   3848: aload_1
    //   3849: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3852: ifeq +79 -> 3931
    //   3855: new 273	org/json/JSONObject
    //   3858: dup
    //   3859: aload_2
    //   3860: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3863: astore_2
    //   3864: aload_2
    //   3865: ldc_w 1230
    //   3868: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3871: astore 20
    //   3873: aload_2
    //   3874: ldc_w 1232
    //   3877: iconst_0
    //   3878: invokevirtual 1235	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3881: istore 8
    //   3883: iload 8
    //   3885: istore 7
    //   3887: iload 8
    //   3889: ifgt +8 -> 3897
    //   3892: sipush 30000
    //   3895: istore 7
    //   3897: aload_0
    //   3898: aload 20
    //   3900: iload 7
    //   3902: aload_3
    //   3903: aload_1
    //   3904: iload 4
    //   3906: invokespecial 1237	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   3909: goto -2515 -> 1394
    //   3912: astore_1
    //   3913: ldc 139
    //   3915: iconst_1
    //   3916: aload_1
    //   3917: iconst_0
    //   3918: anewarray 666	java/lang/Object
    //   3921: invokestatic 1074	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3924: aload_1
    //   3925: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   3928: goto -2534 -> 1394
    //   3931: ldc 68
    //   3933: aload_1
    //   3934: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3937: ifne +21 -> 3958
    //   3940: ldc 65
    //   3942: aload_1
    //   3943: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3946: ifne +12 -> 3958
    //   3949: ldc 71
    //   3951: aload_1
    //   3952: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3955: ifeq +1371 -> 5326
    //   3958: iconst_0
    //   3959: istore 15
    //   3961: ldc 68
    //   3963: aload_1
    //   3964: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3967: ifeq +6 -> 3973
    //   3970: iconst_1
    //   3971: istore 15
    //   3973: new 273	org/json/JSONObject
    //   3976: dup
    //   3977: aload_2
    //   3978: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3981: astore 23
    //   3983: aload 23
    //   3985: ldc_w 1321
    //   3988: iconst_m1
    //   3989: invokevirtual 1235	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3992: istore 9
    //   3994: iconst_m1
    //   3995: istore 7
    //   3997: aconst_null
    //   3998: astore 22
    //   4000: iload 9
    //   4002: ifne +5691 -> 9693
    //   4005: iconst_0
    //   4006: istore 7
    //   4008: aconst_null
    //   4009: astore_2
    //   4010: aload 23
    //   4012: ldc_w 1323
    //   4015: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4018: astore 25
    //   4020: aload 23
    //   4022: ldc_w 1325
    //   4025: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4028: astore 26
    //   4030: ldc 68
    //   4032: aload_1
    //   4033: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4036: ifne +5637 -> 9673
    //   4039: ldc 71
    //   4041: aload_1
    //   4042: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4045: ifeq +29 -> 4074
    //   4048: goto +5625 -> 9673
    //   4051: aload_0
    //   4052: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4055: ifeq +510 -> 4565
    //   4058: aload_0
    //   4059: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4062: ifnull +503 -> 4565
    //   4065: aload_0
    //   4066: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4069: iload 8
    //   4071: putfield 1328	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4074: aload_0
    //   4075: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4078: ifeq +524 -> 4602
    //   4081: aload_0
    //   4082: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4085: ifnull +517 -> 4602
    //   4088: aload_0
    //   4089: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4092: aload_1
    //   4093: putfield 1331	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   4096: aload_0
    //   4097: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4100: iload 4
    //   4102: putfield 1334	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   4105: aload 23
    //   4107: ldc_w 1336
    //   4110: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4113: astore 20
    //   4115: aload 20
    //   4117: astore 21
    //   4119: aload 20
    //   4121: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4124: ifeq +13 -> 4137
    //   4127: aload 23
    //   4129: ldc_w 1338
    //   4132: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4135: astore 21
    //   4137: aload 23
    //   4139: ldc_w 1340
    //   4142: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4145: astore 24
    //   4147: aload 23
    //   4149: ldc_w 1342
    //   4152: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4155: astore 27
    //   4157: aload 23
    //   4159: ldc_w 1344
    //   4162: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4165: astore 23
    //   4167: aload 21
    //   4169: astore 20
    //   4171: aload 21
    //   4173: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4176: ifeq +15 -> 4191
    //   4179: aload_0
    //   4180: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4183: ifeq +451 -> 4634
    //   4186: ldc_w 1346
    //   4189: astore 20
    //   4191: new 1348	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8
    //   4194: dup
    //   4195: aload_0
    //   4196: aload_3
    //   4197: aload_1
    //   4198: iload 4
    //   4200: invokespecial 1349	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   4203: astore_1
    //   4204: aload_0
    //   4205: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4208: ifeq +21 -> 4229
    //   4211: aload_0
    //   4212: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4215: ifnull +14 -> 4229
    //   4218: aload_0
    //   4219: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4222: getfield 1328	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4225: iconst_1
    //   4226: if_icmpeq +27 -> 4253
    //   4229: aload_0
    //   4230: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4233: ifne +506 -> 4739
    //   4236: aload_0
    //   4237: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4240: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4243: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4246: getfield 1350	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4249: iconst_1
    //   4250: if_icmpne +489 -> 4739
    //   4253: aload 27
    //   4255: ldc_w 1352
    //   4258: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4261: ifne +14 -> 4275
    //   4264: aload 27
    //   4266: ldc_w 1354
    //   4269: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4272: ifeq +383 -> 4655
    //   4275: aload_0
    //   4276: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4279: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4282: aload 24
    //   4284: aload 27
    //   4286: aload 20
    //   4288: aload_0
    //   4289: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4292: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4295: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4298: iload 15
    //   4300: invokestatic 1358	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4303: goto +5386 -> 9689
    //   4306: iload 9
    //   4308: iconst_2
    //   4309: if_icmpne +5398 -> 9707
    //   4312: iconst_0
    //   4313: istore 7
    //   4315: aload 23
    //   4317: ldc_w 1360
    //   4320: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4323: astore_2
    //   4324: aload_2
    //   4325: ifnull +80 -> 4405
    //   4328: aload_0
    //   4329: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4332: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4335: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4338: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4341: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4344: getfield 1364	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4347: ifnull +58 -> 4405
    //   4350: aload_2
    //   4351: aload_0
    //   4352: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4355: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4358: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4361: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4364: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4367: getfield 1364	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4370: invokevirtual 1369	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   4373: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4376: ifeq +29 -> 4405
    //   4379: aload_0
    //   4380: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4383: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4386: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4389: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4392: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4395: getfield 1364	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4398: astore 22
    //   4400: aconst_null
    //   4401: astore_2
    //   4402: goto -392 -> 4010
    //   4405: ldc 139
    //   4407: iconst_1
    //   4408: new 323	java/lang/StringBuilder
    //   4411: dup
    //   4412: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   4415: ldc_w 1371
    //   4418: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4421: aload_2
    //   4422: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4425: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4428: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4431: aconst_null
    //   4432: astore_2
    //   4433: goto -423 -> 4010
    //   4436: iload 9
    //   4438: iconst_5
    //   4439: if_icmpne +102 -> 4541
    //   4442: aload 23
    //   4444: ldc_w 1373
    //   4447: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4450: astore 20
    //   4452: aload_0
    //   4453: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4456: ifeq +37 -> 4493
    //   4459: aload_0
    //   4460: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4463: ifnull +30 -> 4493
    //   4466: aload_0
    //   4467: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4470: getfield 1377	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4473: astore_2
    //   4474: aload_2
    //   4475: ifnull +35 -> 4510
    //   4478: aload_2
    //   4479: invokevirtual 1380	com/tencent/mobileqq/mini/sdk/ShareChatModel:getEntryHash	()Ljava/lang/String;
    //   4482: aload 20
    //   4484: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4487: ifeq +23 -> 4510
    //   4490: goto +5245 -> 9735
    //   4493: aload_0
    //   4494: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4497: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4500: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4503: getfield 1381	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4506: astore_2
    //   4507: goto -33 -> 4474
    //   4510: ldc 139
    //   4512: iconst_1
    //   4513: new 323	java/lang/StringBuilder
    //   4516: dup
    //   4517: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   4520: ldc_w 1371
    //   4523: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4526: aconst_null
    //   4527: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4530: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4533: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4536: aconst_null
    //   4537: astore_2
    //   4538: goto +5197 -> 9735
    //   4541: iload 9
    //   4543: bipush 6
    //   4545: if_icmpne +5087 -> 9632
    //   4548: ldc 71
    //   4550: aload_1
    //   4551: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4554: ifeq +5078 -> 9632
    //   4557: iconst_0
    //   4558: istore 7
    //   4560: aconst_null
    //   4561: astore_2
    //   4562: goto -552 -> 4010
    //   4565: aload_0
    //   4566: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4569: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4572: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4575: iload 8
    //   4577: putfield 1350	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4580: goto -506 -> 4074
    //   4583: astore_1
    //   4584: ldc 139
    //   4586: iconst_1
    //   4587: aload_1
    //   4588: iconst_0
    //   4589: anewarray 666	java/lang/Object
    //   4592: invokestatic 1074	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4595: aload_1
    //   4596: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   4599: goto -3205 -> 1394
    //   4602: aload_0
    //   4603: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4606: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4609: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4612: aload_1
    //   4613: putfield 1382	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   4616: aload_0
    //   4617: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4620: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4623: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4626: iload 4
    //   4628: putfield 1383	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   4631: goto -526 -> 4105
    //   4634: aload_0
    //   4635: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4638: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4641: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4644: invokevirtual 762	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   4647: getfield 946	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   4650: astore 20
    //   4652: goto -461 -> 4191
    //   4655: aload_0
    //   4656: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4659: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4662: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4665: pop
    //   4666: invokestatic 1388	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   4669: aload 27
    //   4671: invokevirtual 1391	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   4674: astore_1
    //   4675: aload_1
    //   4676: invokestatic 1395	baip:a	(Ljava/lang/String;)Z
    //   4679: ifne +33 -> 4712
    //   4682: aload_0
    //   4683: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4686: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4689: aload 24
    //   4691: aload_1
    //   4692: aload 20
    //   4694: aload_0
    //   4695: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4698: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4701: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4704: iload 15
    //   4706: invokestatic 1358	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4709: goto +4980 -> 9689
    //   4712: aload_0
    //   4713: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4716: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4719: new 1397	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9
    //   4722: dup
    //   4723: aload_0
    //   4724: aload 24
    //   4726: aload 20
    //   4728: iload 15
    //   4730: invokespecial 1400	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4733: invokevirtual 1404	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   4736: goto +4953 -> 9689
    //   4739: aload_0
    //   4740: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4743: ifeq +21 -> 4764
    //   4746: aload_0
    //   4747: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4750: ifnull +14 -> 4764
    //   4753: aload_0
    //   4754: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4757: getfield 1328	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4760: iconst_3
    //   4761: if_icmpeq +27 -> 4788
    //   4764: aload_0
    //   4765: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4768: ifne +55 -> 4823
    //   4771: aload_0
    //   4772: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4775: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4778: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4781: getfield 1350	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4784: iconst_3
    //   4785: if_icmpne +38 -> 4823
    //   4788: aload_0
    //   4789: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4792: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4795: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4798: astore_1
    //   4799: aload_0
    //   4800: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4803: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4806: aload 24
    //   4808: aload_1
    //   4809: getfield 1407	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   4812: aload 20
    //   4814: iconst_3
    //   4815: aload_1
    //   4816: invokestatic 1411	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   4819: ldc_w 664
    //   4822: areturn
    //   4823: aload_0
    //   4824: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4827: ifeq +21 -> 4848
    //   4830: aload_0
    //   4831: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4834: ifnull +14 -> 4848
    //   4837: aload_0
    //   4838: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4841: getfield 1328	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4844: iconst_4
    //   4845: if_icmpeq +27 -> 4872
    //   4848: aload_0
    //   4849: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4852: ifne +55 -> 4907
    //   4855: aload_0
    //   4856: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4859: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4862: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4865: getfield 1350	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4868: iconst_4
    //   4869: if_icmpne +38 -> 4907
    //   4872: aload_0
    //   4873: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4876: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4879: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4882: astore_1
    //   4883: aload_0
    //   4884: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4887: invokevirtual 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4890: aload 24
    //   4892: aload_1
    //   4893: getfield 1407	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   4896: aload 20
    //   4898: iconst_4
    //   4899: aload_1
    //   4900: invokestatic 1411	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   4903: ldc_w 664
    //   4906: areturn
    //   4907: aload 27
    //   4909: invokestatic 1416	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   4912: ifne +4829 -> 9741
    //   4915: aload 27
    //   4917: invokestatic 1419	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   4920: ifeq +4827 -> 9747
    //   4923: goto +4818 -> 9741
    //   4926: aload_0
    //   4927: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4930: ifnull +4823 -> 9753
    //   4933: aload_0
    //   4934: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4937: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4940: ifnull +4813 -> 9753
    //   4943: aload 27
    //   4945: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4948: ifne +4805 -> 9753
    //   4951: new 586	java/io/File
    //   4954: dup
    //   4955: invokestatic 1388	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   4958: aload 27
    //   4960: invokevirtual 1391	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   4963: invokespecial 593	java/io/File:<init>	(Ljava/lang/String;)V
    //   4966: invokevirtual 1422	java/io/File:exists	()Z
    //   4969: ifeq +4784 -> 9753
    //   4972: iconst_1
    //   4973: istore 17
    //   4975: aload 27
    //   4977: invokestatic 1395	baip:a	(Ljava/lang/String;)Z
    //   4980: ifne +13 -> 4993
    //   4983: iload 16
    //   4985: ifne +197 -> 5182
    //   4988: iload 17
    //   4990: ifne +192 -> 5182
    //   4993: aload_0
    //   4994: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4997: ifeq +110 -> 5107
    //   5000: aload_0
    //   5001: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5004: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5007: astore_3
    //   5008: invokestatic 1427	com/tencent/mobileqq/minigame/utils/GameWnsUtils:defaultShareImg	()Ljava/lang/String;
    //   5011: astore 21
    //   5013: iload 15
    //   5015: ifeq +4744 -> 9759
    //   5018: bipush 11
    //   5020: istore 4
    //   5022: aload_3
    //   5023: aload 24
    //   5025: aload 21
    //   5027: aload 20
    //   5029: aload 23
    //   5031: aload 25
    //   5033: aload 26
    //   5035: aload 22
    //   5037: aload_2
    //   5038: iload 4
    //   5040: iload 9
    //   5042: ldc_w 664
    //   5045: aload_1
    //   5046: invokevirtual 1431	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5049: ldc 139
    //   5051: iconst_1
    //   5052: new 323	java/lang/StringBuilder
    //   5055: dup
    //   5056: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   5059: ldc_w 1433
    //   5062: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5065: iload 16
    //   5067: invokevirtual 811	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5070: ldc_w 1435
    //   5073: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5076: iload 17
    //   5078: invokevirtual 811	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5081: ldc_w 1437
    //   5084: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5087: aload 27
    //   5089: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5092: ldc_w 1439
    //   5095: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5098: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5101: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5104: goto -3710 -> 1394
    //   5107: aload_0
    //   5108: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5111: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5114: ifnull -3720 -> 1394
    //   5117: aload_0
    //   5118: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5121: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5124: getfield 1442	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5127: ifeq +16 -> 5143
    //   5130: ldc 139
    //   5132: iconst_1
    //   5133: ldc_w 1444
    //   5136: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5139: ldc_w 664
    //   5142: areturn
    //   5143: aload_0
    //   5144: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5147: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5150: new 1446	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10
    //   5153: dup
    //   5154: aload_0
    //   5155: aload 24
    //   5157: aload 20
    //   5159: aload 23
    //   5161: aload 25
    //   5163: aload 26
    //   5165: aload 22
    //   5167: aload_2
    //   5168: iload 15
    //   5170: iload 9
    //   5172: aload_1
    //   5173: invokespecial 1449	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;ZILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5176: invokevirtual 1404	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5179: goto -3785 -> 1394
    //   5182: aload 27
    //   5184: ldc_w 1352
    //   5187: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5190: ifne +14 -> 5204
    //   5193: aload 27
    //   5195: ldc_w 1354
    //   5198: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5201: ifeq +50 -> 5251
    //   5204: aload_0
    //   5205: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5208: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5211: astore_3
    //   5212: iload 15
    //   5214: ifeq +4552 -> 9766
    //   5217: bipush 11
    //   5219: istore 4
    //   5221: aload_3
    //   5222: aload 24
    //   5224: aload 27
    //   5226: aload 20
    //   5228: aload 23
    //   5230: aload 25
    //   5232: aload 26
    //   5234: aload 22
    //   5236: aload_2
    //   5237: iload 4
    //   5239: iload 9
    //   5241: ldc_w 664
    //   5244: aload_1
    //   5245: invokevirtual 1431	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5248: goto -3854 -> 1394
    //   5251: aload_0
    //   5252: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5255: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5258: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5261: pop
    //   5262: invokestatic 1388	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5265: aload 27
    //   5267: invokevirtual 1391	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5270: astore_3
    //   5271: aload_0
    //   5272: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5275: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5278: astore 21
    //   5280: iload 15
    //   5282: ifeq +37 -> 5319
    //   5285: bipush 11
    //   5287: istore 4
    //   5289: aload 21
    //   5291: aload 24
    //   5293: aload_3
    //   5294: aload 20
    //   5296: aload 23
    //   5298: aload 25
    //   5300: aload 26
    //   5302: aload 22
    //   5304: aload_2
    //   5305: iload 4
    //   5307: iload 9
    //   5309: ldc_w 664
    //   5312: aload_1
    //   5313: invokevirtual 1431	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5316: goto -3922 -> 1394
    //   5319: bipush 12
    //   5321: istore 4
    //   5323: goto -34 -> 5289
    //   5326: ldc 74
    //   5328: aload_1
    //   5329: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5332: ifne +12 -> 5344
    //   5335: ldc 77
    //   5337: aload_1
    //   5338: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5341: ifeq +531 -> 5872
    //   5344: new 273	org/json/JSONObject
    //   5347: dup
    //   5348: aload_2
    //   5349: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5352: astore_2
    //   5353: aload_2
    //   5354: ldc_w 1321
    //   5357: iconst_m1
    //   5358: invokevirtual 1235	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5361: istore 8
    //   5363: iconst_m1
    //   5364: istore 7
    //   5366: iload 8
    //   5368: ifne +242 -> 5610
    //   5371: iconst_0
    //   5372: istore 7
    //   5374: ldc 77
    //   5376: aload_1
    //   5377: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5380: ifeq +39 -> 5419
    //   5383: iload 7
    //   5385: istore 8
    //   5387: iload 7
    //   5389: iconst_m1
    //   5390: if_icmpne +6 -> 5396
    //   5393: iconst_0
    //   5394: istore 8
    //   5396: aload_0
    //   5397: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5400: ifeq +258 -> 5658
    //   5403: aload_0
    //   5404: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5407: ifnull +251 -> 5658
    //   5410: aload_0
    //   5411: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5414: iload 8
    //   5416: putfield 1328	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5419: aload_0
    //   5420: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5423: ifeq +253 -> 5676
    //   5426: aload_0
    //   5427: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5430: ifnull +246 -> 5676
    //   5433: aload_0
    //   5434: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5437: getfield 1328	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5440: istore 7
    //   5442: aload_0
    //   5443: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5446: ifeq +248 -> 5694
    //   5449: aload_0
    //   5450: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5453: ifnull +241 -> 5694
    //   5456: aload_0
    //   5457: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5460: aload_1
    //   5461: putfield 1331	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   5464: aload_0
    //   5465: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5468: iload 4
    //   5470: putfield 1334	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   5473: new 1451	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11
    //   5476: dup
    //   5477: aload_0
    //   5478: aload_3
    //   5479: aload_1
    //   5480: iload 4
    //   5482: invokespecial 1452	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   5485: astore_1
    //   5486: aload_0
    //   5487: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5490: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5493: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5496: astore_3
    //   5497: aload_2
    //   5498: ldc_w 1340
    //   5501: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5504: astore 20
    //   5506: aload_2
    //   5507: ldc_w 1342
    //   5510: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5513: astore_2
    //   5514: aload_2
    //   5515: invokestatic 1416	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   5518: ifne +4255 -> 9773
    //   5521: aload_2
    //   5522: invokestatic 1419	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   5525: ifeq +4254 -> 9779
    //   5528: goto +4245 -> 9773
    //   5531: invokestatic 1388	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5534: aload_2
    //   5535: invokevirtual 1391	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5538: astore 21
    //   5540: aload_0
    //   5541: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5544: ifnull +4241 -> 9785
    //   5547: aload_0
    //   5548: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5551: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5554: ifnull +4231 -> 9785
    //   5557: aload_2
    //   5558: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5561: ifne +4224 -> 9785
    //   5564: new 586	java/io/File
    //   5567: dup
    //   5568: aload 21
    //   5570: invokespecial 593	java/io/File:<init>	(Ljava/lang/String;)V
    //   5573: invokevirtual 1422	java/io/File:exists	()Z
    //   5576: ifeq +4209 -> 9785
    //   5579: iconst_1
    //   5580: istore 8
    //   5582: iload 4
    //   5584: ifeq +142 -> 5726
    //   5587: aload_0
    //   5588: aload 22
    //   5590: aload 20
    //   5592: aload_2
    //   5593: iload 7
    //   5595: aload_1
    //   5596: invokespecial 186	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5599: goto -4205 -> 1394
    //   5602: astore_1
    //   5603: aload_1
    //   5604: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   5607: goto -4213 -> 1394
    //   5610: iload 8
    //   5612: iconst_1
    //   5613: if_icmpne +9 -> 5622
    //   5616: iconst_1
    //   5617: istore 7
    //   5619: goto -245 -> 5374
    //   5622: iload 8
    //   5624: iconst_2
    //   5625: if_icmpne +9 -> 5634
    //   5628: iconst_0
    //   5629: istore 7
    //   5631: goto -257 -> 5374
    //   5634: iload 8
    //   5636: iconst_3
    //   5637: if_icmpne +9 -> 5646
    //   5640: iconst_3
    //   5641: istore 7
    //   5643: goto -269 -> 5374
    //   5646: iload 8
    //   5648: iconst_4
    //   5649: if_icmpne -275 -> 5374
    //   5652: iconst_4
    //   5653: istore 7
    //   5655: goto -281 -> 5374
    //   5658: aload_0
    //   5659: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5662: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5665: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5668: iload 8
    //   5670: putfield 1350	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5673: goto -254 -> 5419
    //   5676: aload_0
    //   5677: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5680: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5683: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5686: getfield 1350	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5689: istore 7
    //   5691: goto -249 -> 5442
    //   5694: aload_0
    //   5695: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5698: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5701: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5704: aload_1
    //   5705: putfield 1382	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   5708: aload_0
    //   5709: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5712: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5715: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5718: iload 4
    //   5720: putfield 1383	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   5723: goto -250 -> 5473
    //   5726: aload_2
    //   5727: invokestatic 1395	baip:a	(Ljava/lang/String;)Z
    //   5730: ifne +13 -> 5743
    //   5733: iload 4
    //   5735: ifne +114 -> 5849
    //   5738: iload 8
    //   5740: ifne +109 -> 5849
    //   5743: aload_0
    //   5744: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5747: ifeq +37 -> 5784
    //   5750: aload_3
    //   5751: ifnull +21 -> 5772
    //   5754: aload_0
    //   5755: aload 22
    //   5757: aload 20
    //   5759: aload_3
    //   5760: getfield 1407	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5763: iload 7
    //   5765: aload_1
    //   5766: invokespecial 186	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5769: goto -4375 -> 1394
    //   5772: ldc 139
    //   5774: iconst_1
    //   5775: ldc_w 1454
    //   5778: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5781: goto -4387 -> 1394
    //   5784: aload_0
    //   5785: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5788: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5791: ifnull -4397 -> 1394
    //   5794: aload_0
    //   5795: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5798: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5801: getfield 1442	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5804: ifeq +16 -> 5820
    //   5807: ldc 139
    //   5809: iconst_1
    //   5810: ldc_w 1456
    //   5813: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5816: ldc_w 664
    //   5819: areturn
    //   5820: aload_0
    //   5821: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5824: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5827: new 1458	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12
    //   5830: dup
    //   5831: aload_0
    //   5832: aload_3
    //   5833: aload 22
    //   5835: aload 20
    //   5837: iload 7
    //   5839: aload_1
    //   5840: invokespecial 1461	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Landroid/app/Activity;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5843: invokevirtual 1404	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5846: goto -4452 -> 1394
    //   5849: iload 4
    //   5851: ifne -4457 -> 1394
    //   5854: iload 8
    //   5856: ifeq -4462 -> 1394
    //   5859: aload_0
    //   5860: aload 20
    //   5862: aload 21
    //   5864: iload 7
    //   5866: invokespecial 192	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareLocalPicMessage	(Ljava/lang/String;Ljava/lang/String;I)V
    //   5869: goto -4475 -> 1394
    //   5872: ldc 44
    //   5874: aload_1
    //   5875: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5878: ifeq +380 -> 6258
    //   5881: aload_0
    //   5882: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5885: ifnull -4491 -> 1394
    //   5888: aload_0
    //   5889: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5892: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5895: ifnull -4501 -> 1394
    //   5898: iconst_m1
    //   5899: istore 8
    //   5901: iconst_m1
    //   5902: istore 7
    //   5904: new 273	org/json/JSONObject
    //   5907: dup
    //   5908: aload_2
    //   5909: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5912: ldc_w 1463
    //   5915: invokevirtual 1286	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   5918: checkcast 284	org/json/JSONArray
    //   5921: astore_2
    //   5922: aload_2
    //   5923: ifnonnull +95 -> 6018
    //   5926: iconst_0
    //   5927: istore 10
    //   5929: iconst_0
    //   5930: istore 9
    //   5932: iconst_m1
    //   5933: istore 8
    //   5935: aload_0
    //   5936: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5939: ifeq +179 -> 6118
    //   5942: aload_0
    //   5943: invokevirtual 1263	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5946: astore_2
    //   5947: aload_2
    //   5948: ifnull +151 -> 6099
    //   5951: iload 10
    //   5953: ifne +8 -> 5961
    //   5956: aload_2
    //   5957: iconst_0
    //   5958: putfield 1268	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   5961: iload 9
    //   5963: ifne +8 -> 5971
    //   5966: aload_2
    //   5967: iconst_0
    //   5968: putfield 1271	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   5971: iload 8
    //   5973: ifne +8 -> 5981
    //   5976: aload_2
    //   5977: iconst_0
    //   5978: putfield 1274	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   5981: iload 7
    //   5983: ifne +8 -> 5991
    //   5986: aload_2
    //   5987: iconst_0
    //   5988: putfield 1277	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   5991: aload_0
    //   5992: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5995: aload_3
    //   5996: aload_1
    //   5997: aload_1
    //   5998: aconst_null
    //   5999: invokestatic 897	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6002: iload 4
    //   6004: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6007: goto -4613 -> 1394
    //   6010: astore_1
    //   6011: aload_1
    //   6012: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   6015: goto -4621 -> 1394
    //   6018: iconst_m1
    //   6019: istore 9
    //   6021: iconst_m1
    //   6022: istore 10
    //   6024: iconst_0
    //   6025: istore 11
    //   6027: iload 11
    //   6029: aload_2
    //   6030: invokevirtual 1289	org/json/JSONArray:length	()I
    //   6033: if_icmpge +3596 -> 9629
    //   6036: aload_2
    //   6037: iload 11
    //   6039: invokevirtual 1291	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6042: astore 20
    //   6044: aload 20
    //   6046: ldc 112
    //   6048: invokevirtual 1294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6051: ifeq +6 -> 6057
    //   6054: iconst_0
    //   6055: istore 10
    //   6057: aload 20
    //   6059: ldc 115
    //   6061: invokevirtual 1294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6064: ifeq +6 -> 6070
    //   6067: iconst_0
    //   6068: istore 9
    //   6070: aload 20
    //   6072: ldc 118
    //   6074: invokevirtual 1294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6077: ifeq +6 -> 6083
    //   6080: iconst_1
    //   6081: istore 8
    //   6083: aload 20
    //   6085: ldc 121
    //   6087: invokevirtual 1294	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6090: ifeq +3701 -> 9791
    //   6093: iconst_1
    //   6094: istore 7
    //   6096: goto +3695 -> 9791
    //   6099: aload_0
    //   6100: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6103: aload_3
    //   6104: aload_1
    //   6105: aload_1
    //   6106: aconst_null
    //   6107: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6110: iload 4
    //   6112: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6115: goto -4721 -> 1394
    //   6118: aload_0
    //   6119: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6122: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6125: invokevirtual 1298	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   6128: ifnull +111 -> 6239
    //   6131: aload_0
    //   6132: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6135: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6138: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6141: ifnull +98 -> 6239
    //   6144: iload 10
    //   6146: ifne +17 -> 6163
    //   6149: aload_0
    //   6150: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6153: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6156: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6159: iconst_0
    //   6160: putfield 1305	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   6163: iload 9
    //   6165: ifne +17 -> 6182
    //   6168: aload_0
    //   6169: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6172: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6175: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6178: iconst_0
    //   6179: putfield 1306	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   6182: iload 8
    //   6184: ifne +17 -> 6201
    //   6187: aload_0
    //   6188: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6191: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6194: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6197: iconst_0
    //   6198: putfield 1307	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   6201: iload 7
    //   6203: ifne +17 -> 6220
    //   6206: aload_0
    //   6207: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6210: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6213: invokevirtual 1302	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6216: iconst_0
    //   6217: putfield 1308	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   6220: aload_0
    //   6221: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6224: aload_3
    //   6225: aload_1
    //   6226: aload_1
    //   6227: aconst_null
    //   6228: invokestatic 897	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6231: iload 4
    //   6233: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6236: goto -4842 -> 1394
    //   6239: aload_0
    //   6240: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6243: aload_3
    //   6244: aload_1
    //   6245: aload_1
    //   6246: aconst_null
    //   6247: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6250: iload 4
    //   6252: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6255: goto -4861 -> 1394
    //   6258: ldc_w 1465
    //   6261: aload_1
    //   6262: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6265: ifeq +268 -> 6533
    //   6268: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6271: invokevirtual 1021	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6274: astore 20
    //   6276: aload 20
    //   6278: instanceof 1023
    //   6281: ifeq +3342 -> 9623
    //   6284: aload 20
    //   6286: checkcast 1023	com/tencent/mobileqq/mini/MiniAppInterface
    //   6289: astore 20
    //   6291: aload 20
    //   6293: ifnonnull +18 -> 6311
    //   6296: aload_0
    //   6297: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6300: aload_3
    //   6301: aload_1
    //   6302: aconst_null
    //   6303: iload 4
    //   6305: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6308: goto -4914 -> 1394
    //   6311: new 273	org/json/JSONObject
    //   6314: dup
    //   6315: aload_2
    //   6316: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6319: ldc_w 1467
    //   6322: invokevirtual 1470	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6325: iconst_0
    //   6326: invokevirtual 1291	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6329: astore 22
    //   6331: aload 22
    //   6333: astore 21
    //   6335: aload 22
    //   6337: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6340: ifne +10 -> 6350
    //   6343: aload 22
    //   6345: invokevirtual 1473	java/lang/String:trim	()Ljava/lang/String;
    //   6348: astore 21
    //   6350: aload 20
    //   6352: aload_0
    //   6353: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6356: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6359: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6362: invokevirtual 1027	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   6365: astore 20
    //   6367: aload 20
    //   6369: ifnull +149 -> 6518
    //   6372: aload 21
    //   6374: invokestatic 1476	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   6377: ifeq +141 -> 6518
    //   6380: aload 20
    //   6382: invokevirtual 1479	com/tencent/mobileqq/mini/app/AuthorizeCenter:isAuthorizeSynchronized	()Z
    //   6385: istore 15
    //   6387: aload 21
    //   6389: ldc_w 1481
    //   6392: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6395: ifeq +59 -> 6454
    //   6398: iload 15
    //   6400: ifne +54 -> 6454
    //   6403: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6406: aconst_null
    //   6407: aload_0
    //   6408: invokevirtual 1484	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   6411: new 1486	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13
    //   6414: dup
    //   6415: aload_0
    //   6416: aload 20
    //   6418: aload 21
    //   6420: aload_3
    //   6421: aload_1
    //   6422: iload 4
    //   6424: aload_2
    //   6425: invokespecial 1489	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILjava/lang/String;)V
    //   6428: invokevirtual 1493	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getAuthList	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6431: goto -5037 -> 1394
    //   6434: astore_2
    //   6435: aload_2
    //   6436: invokevirtual 393	java/lang/Throwable:printStackTrace	()V
    //   6439: aload_0
    //   6440: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6443: aload_3
    //   6444: aload_1
    //   6445: aconst_null
    //   6446: iload 4
    //   6448: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6451: goto -5057 -> 1394
    //   6454: aload 20
    //   6456: aload 21
    //   6458: invokevirtual 1496	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   6461: istore 7
    //   6463: aload_0
    //   6464: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6467: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6470: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6473: invokestatic 1499	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   6476: ifeq +6 -> 6482
    //   6479: iconst_2
    //   6480: istore 7
    //   6482: iload 7
    //   6484: iconst_2
    //   6485: if_icmpne +18 -> 6503
    //   6488: aload_0
    //   6489: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6492: aload_3
    //   6493: aload_1
    //   6494: aconst_null
    //   6495: iload 4
    //   6497: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6500: goto -5106 -> 1394
    //   6503: aload_0
    //   6504: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6507: aload_1
    //   6508: aload_2
    //   6509: aload_3
    //   6510: iload 4
    //   6512: invokevirtual 1503	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:reqAuthorize	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   6515: goto -5121 -> 1394
    //   6518: aload_0
    //   6519: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6522: aload_3
    //   6523: aload_1
    //   6524: aconst_null
    //   6525: iload 4
    //   6527: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6530: goto -5136 -> 1394
    //   6533: ldc 56
    //   6535: aload_1
    //   6536: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6539: ifeq +165 -> 6704
    //   6542: new 273	org/json/JSONObject
    //   6545: dup
    //   6546: aload_2
    //   6547: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6550: astore_1
    //   6551: ldc 139
    //   6553: iconst_2
    //   6554: new 323	java/lang/StringBuilder
    //   6557: dup
    //   6558: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   6561: ldc_w 1505
    //   6564: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6567: aload_1
    //   6568: invokevirtual 911	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6571: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6574: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6577: new 532	android/content/Intent
    //   6580: dup
    //   6581: invokespecial 1506	android/content/Intent:<init>	()V
    //   6584: astore_2
    //   6585: aload_2
    //   6586: new 1508	android/content/ComponentName
    //   6589: dup
    //   6590: aload_0
    //   6591: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6594: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6597: getfield 1512	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6600: ldc_w 1514
    //   6603: invokespecial 1515	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6606: invokevirtual 1519	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   6609: pop
    //   6610: aload_2
    //   6611: ldc_w 1521
    //   6614: aload_1
    //   6615: ldc_w 1521
    //   6618: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6621: invokevirtual 543	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6624: pop
    //   6625: aload_2
    //   6626: ldc_w 1523
    //   6629: sipush 1008
    //   6632: invokevirtual 1526	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6635: pop
    //   6636: aload_2
    //   6637: ldc_w 1528
    //   6640: iconst_2
    //   6641: invokevirtual 1526	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6644: pop
    //   6645: aload_2
    //   6646: ldc_w 1530
    //   6649: aload_1
    //   6650: ldc_w 1532
    //   6653: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6656: invokevirtual 543	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6659: pop
    //   6660: aload_2
    //   6661: ldc_w 1533
    //   6664: invokevirtual 1537	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   6667: pop
    //   6668: aload_0
    //   6669: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6672: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6675: getfield 1512	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6678: aload_2
    //   6679: invokevirtual 992	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   6682: goto -5288 -> 1394
    //   6685: astore_1
    //   6686: ldc 139
    //   6688: iconst_1
    //   6689: aload_1
    //   6690: iconst_0
    //   6691: anewarray 666	java/lang/Object
    //   6694: invokestatic 1074	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   6697: aload_1
    //   6698: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   6701: goto -5307 -> 1394
    //   6704: ldc 11
    //   6706: aload_1
    //   6707: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6710: ifeq +61 -> 6771
    //   6713: new 273	org/json/JSONObject
    //   6716: dup
    //   6717: aload_2
    //   6718: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6721: astore_2
    //   6722: new 1539	Wallet/FocusMpIdReq
    //   6725: dup
    //   6726: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6729: invokevirtual 1021	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6732: invokevirtual 1084	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6735: aload_2
    //   6736: ldc_w 1541
    //   6739: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6742: invokespecial 1542	Wallet/FocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   6745: new 1544	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14
    //   6748: dup
    //   6749: aload_0
    //   6750: aload_3
    //   6751: aload_1
    //   6752: iload 4
    //   6754: invokespecial 1545	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   6757: invokestatic 1094	agkg:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   6760: goto -5366 -> 1394
    //   6763: astore_1
    //   6764: aload_1
    //   6765: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   6768: goto -5374 -> 1394
    //   6771: ldc_w 1547
    //   6774: aload_1
    //   6775: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6778: ifeq +34 -> 6812
    //   6781: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6784: aload_0
    //   6785: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6788: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6791: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6794: new 1549	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15
    //   6797: dup
    //   6798: aload_0
    //   6799: aload_3
    //   6800: aload_1
    //   6801: iload 4
    //   6803: invokespecial 1550	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   6806: invokevirtual 1553	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getFormId	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6809: goto -5415 -> 1394
    //   6812: ldc 109
    //   6814: aload_1
    //   6815: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6818: ifeq +120 -> 6938
    //   6821: aload_0
    //   6822: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6825: ifnonnull +7 -> 6832
    //   6828: ldc_w 664
    //   6831: areturn
    //   6832: new 273	org/json/JSONObject
    //   6835: dup
    //   6836: aload_2
    //   6837: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6840: ldc_w 1554
    //   6843: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6846: invokestatic 1559	com/tencent/mobileqq/mini/entry/MiniAppUtils:checkNavigationAppIdListForMiniGame	(Ljava/lang/String;)Z
    //   6849: istore 15
    //   6851: new 273	org/json/JSONObject
    //   6854: dup
    //   6855: invokespecial 823	org/json/JSONObject:<init>	()V
    //   6858: astore_1
    //   6859: aload_1
    //   6860: ldc_w 1561
    //   6863: iload 15
    //   6865: invokevirtual 1564	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   6868: pop
    //   6869: ldc 139
    //   6871: iconst_2
    //   6872: new 323	java/lang/StringBuilder
    //   6875: dup
    //   6876: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   6879: ldc_w 1566
    //   6882: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6885: aload_1
    //   6886: invokevirtual 911	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6889: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6892: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6895: aload_1
    //   6896: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   6899: areturn
    //   6900: astore_2
    //   6901: ldc 139
    //   6903: iconst_1
    //   6904: aload_2
    //   6905: iconst_0
    //   6906: anewarray 666	java/lang/Object
    //   6909: invokestatic 1074	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   6912: aload_2
    //   6913: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   6916: goto -47 -> 6869
    //   6919: astore_1
    //   6920: ldc 139
    //   6922: iconst_1
    //   6923: aload_1
    //   6924: iconst_0
    //   6925: anewarray 666	java/lang/Object
    //   6928: invokestatic 1074	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   6931: aload_1
    //   6932: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   6935: goto -5541 -> 1394
    //   6938: ldc_w 1568
    //   6941: aload_1
    //   6942: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6945: ifeq +193 -> 7138
    //   6948: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6951: invokevirtual 1021	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6954: astore_1
    //   6955: aload_1
    //   6956: instanceof 1023
    //   6959: ifeq +2659 -> 9618
    //   6962: aload_1
    //   6963: checkcast 1023	com/tencent/mobileqq/mini/MiniAppInterface
    //   6966: astore_1
    //   6967: aload_0
    //   6968: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6971: ifnull +7 -> 6978
    //   6974: aload_1
    //   6975: ifnonnull +26 -> 7001
    //   6978: aload_0
    //   6979: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6982: aload_3
    //   6983: ldc_w 1569
    //   6986: aconst_null
    //   6987: ldc_w 1570
    //   6990: invokestatic 1574	ajjy:a	(I)Ljava/lang/String;
    //   6993: iload 4
    //   6995: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   6998: goto -5604 -> 1394
    //   7001: aload_1
    //   7002: aload_0
    //   7003: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7006: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7009: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7012: invokevirtual 1027	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   7015: astore_1
    //   7016: aload_1
    //   7017: ifnull +92 -> 7109
    //   7020: ldc_w 1576
    //   7023: invokestatic 1476	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   7026: ifeq +83 -> 7109
    //   7029: aload_1
    //   7030: ldc_w 1576
    //   7033: invokevirtual 1496	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   7036: istore 7
    //   7038: aload_0
    //   7039: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7042: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7045: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7048: invokestatic 1499	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   7051: ifeq +6 -> 7057
    //   7054: iconst_2
    //   7055: istore 7
    //   7057: iload 7
    //   7059: iconst_2
    //   7060: if_icmpne +20 -> 7080
    //   7063: aload_0
    //   7064: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7067: aload_3
    //   7068: ldc_w 1569
    //   7071: aconst_null
    //   7072: iload 4
    //   7074: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7077: goto -5683 -> 1394
    //   7080: ldc 139
    //   7082: iconst_1
    //   7083: ldc_w 1578
    //   7086: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7089: aload_0
    //   7090: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7093: aload_3
    //   7094: ldc_w 1569
    //   7097: aconst_null
    //   7098: ldc_w 1578
    //   7101: iload 4
    //   7103: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7106: goto -5712 -> 1394
    //   7109: aload_0
    //   7110: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7113: aload_3
    //   7114: ldc_w 1569
    //   7117: aconst_null
    //   7118: ldc_w 1580
    //   7121: iload 4
    //   7123: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7126: ldc 139
    //   7128: iconst_1
    //   7129: ldc_w 1582
    //   7132: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7135: goto -5741 -> 1394
    //   7138: ldc_w 1584
    //   7141: aload_1
    //   7142: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7145: ifeq +167 -> 7312
    //   7148: new 273	org/json/JSONObject
    //   7151: dup
    //   7152: aload_2
    //   7153: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7156: astore 20
    //   7158: aload 20
    //   7160: ldc_w 1586
    //   7163: invokevirtual 1470	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7166: astore_2
    //   7167: aload 20
    //   7169: ldc_w 1067
    //   7172: ldc_w 1069
    //   7175: invokevirtual 1009	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7178: astore 20
    //   7180: aload_2
    //   7181: ifnull -5787 -> 1394
    //   7184: aload_2
    //   7185: invokevirtual 1289	org/json/JSONArray:length	()I
    //   7188: ifle -5794 -> 1394
    //   7191: aload_2
    //   7192: invokevirtual 1289	org/json/JSONArray:length	()I
    //   7195: anewarray 365	java/lang/String
    //   7198: astore 21
    //   7200: iconst_0
    //   7201: istore 7
    //   7203: iload 7
    //   7205: aload_2
    //   7206: invokevirtual 1289	org/json/JSONArray:length	()I
    //   7209: if_icmpge +23 -> 7232
    //   7212: aload 21
    //   7214: iload 7
    //   7216: aload_2
    //   7217: iload 7
    //   7219: invokevirtual 1291	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   7222: aastore
    //   7223: iload 7
    //   7225: iconst_1
    //   7226: iadd
    //   7227: istore 7
    //   7229: goto -26 -> 7203
    //   7232: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7235: invokestatic 1591	com/tencent/mobileqq/minigame/manager/GameInfoManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7238: invokevirtual 1592	com/tencent/mobileqq/minigame/manager/GameInfoManager:getAppId	()Ljava/lang/String;
    //   7241: aload 20
    //   7243: aload 21
    //   7245: new 1594	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16
    //   7248: dup
    //   7249: aload_0
    //   7250: aload_3
    //   7251: aload_1
    //   7252: iload 4
    //   7254: invokespecial 1595	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7257: invokevirtual 1599	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoOpenData	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7260: goto -5866 -> 1394
    //   7263: astore_2
    //   7264: aload_0
    //   7265: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7268: aload_3
    //   7269: aload_1
    //   7270: aconst_null
    //   7271: iload 4
    //   7273: invokevirtual 1044	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7276: ldc 139
    //   7278: iconst_1
    //   7279: new 323	java/lang/StringBuilder
    //   7282: dup
    //   7283: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7286: ldc_w 1601
    //   7289: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7292: aload_1
    //   7293: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7296: ldc_w 1603
    //   7299: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7302: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7305: aload_2
    //   7306: invokestatic 1041	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7309: goto -5915 -> 1394
    //   7312: ldc 41
    //   7314: aload_1
    //   7315: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7318: ifeq +424 -> 7742
    //   7321: new 273	org/json/JSONObject
    //   7324: dup
    //   7325: aload_2
    //   7326: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7329: astore_2
    //   7330: aload_2
    //   7331: ldc_w 1605
    //   7334: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7337: astore 23
    //   7339: aload_2
    //   7340: ldc_w 1607
    //   7343: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7346: astore 24
    //   7348: aload_2
    //   7349: ldc_w 1609
    //   7352: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7355: astore 25
    //   7357: aload_2
    //   7358: ldc_w 1611
    //   7361: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7364: astore 21
    //   7366: aload_2
    //   7367: ldc_w 1613
    //   7370: invokevirtual 1616	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7373: istore 7
    //   7375: ldc_w 1618
    //   7378: aload 24
    //   7380: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7383: ifne +33 -> 7416
    //   7386: ldc_w 1620
    //   7389: aload 24
    //   7391: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7394: ifne +22 -> 7416
    //   7397: aload_0
    //   7398: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7401: aload_3
    //   7402: aload_1
    //   7403: aconst_null
    //   7404: ldc_w 1622
    //   7407: iload 4
    //   7409: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7412: ldc_w 664
    //   7415: areturn
    //   7416: ldc_w 1618
    //   7419: aload 23
    //   7421: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7424: ifne +33 -> 7457
    //   7427: ldc_w 1624
    //   7430: aload 23
    //   7432: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7435: ifne +22 -> 7457
    //   7438: aload_0
    //   7439: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7442: aload_3
    //   7443: aload_1
    //   7444: aconst_null
    //   7445: ldc_w 1626
    //   7448: iload 4
    //   7450: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7453: ldc_w 664
    //   7456: areturn
    //   7457: iload 7
    //   7459: ifgt +22 -> 7481
    //   7462: aload_0
    //   7463: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7466: aload_3
    //   7467: aload_1
    //   7468: aconst_null
    //   7469: ldc_w 1628
    //   7472: iload 4
    //   7474: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7477: ldc_w 664
    //   7480: areturn
    //   7481: aload 21
    //   7483: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7486: ifeq +22 -> 7508
    //   7489: aload_0
    //   7490: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7493: aload_3
    //   7494: aload_1
    //   7495: aconst_null
    //   7496: ldc_w 1630
    //   7499: iload 4
    //   7501: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7504: ldc_w 664
    //   7507: areturn
    //   7508: new 1632	android/graphics/Paint
    //   7511: dup
    //   7512: invokespecial 1633	android/graphics/Paint:<init>	()V
    //   7515: astore 22
    //   7517: aload 22
    //   7519: iload 7
    //   7521: i2f
    //   7522: invokevirtual 1637	android/graphics/Paint:setTextSize	(F)V
    //   7525: aconst_null
    //   7526: astore 20
    //   7528: ldc_w 1618
    //   7531: aload 23
    //   7533: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7536: ifeq +68 -> 7604
    //   7539: ldc_w 1618
    //   7542: aload 24
    //   7544: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7547: ifeq +33 -> 7580
    //   7550: aload 25
    //   7552: iconst_0
    //   7553: invokestatic 1643	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7556: astore_2
    //   7557: aload_2
    //   7558: ifnonnull +105 -> 7663
    //   7561: aload_0
    //   7562: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7565: aload_3
    //   7566: aload_1
    //   7567: aconst_null
    //   7568: ldc_w 1645
    //   7571: iload 4
    //   7573: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7576: ldc_w 664
    //   7579: areturn
    //   7580: aload 20
    //   7582: astore_2
    //   7583: ldc_w 1620
    //   7586: aload 24
    //   7588: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7591: ifeq -34 -> 7557
    //   7594: aload 25
    //   7596: iconst_1
    //   7597: invokestatic 1643	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7600: astore_2
    //   7601: goto -44 -> 7557
    //   7604: aload 20
    //   7606: astore_2
    //   7607: ldc_w 1624
    //   7610: aload 23
    //   7612: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7615: ifeq -58 -> 7557
    //   7618: ldc_w 1618
    //   7621: aload 24
    //   7623: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7626: ifeq +13 -> 7639
    //   7629: aload 25
    //   7631: iconst_2
    //   7632: invokestatic 1643	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7635: astore_2
    //   7636: goto -79 -> 7557
    //   7639: aload 20
    //   7641: astore_2
    //   7642: ldc_w 1620
    //   7645: aload 24
    //   7647: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7650: ifeq -93 -> 7557
    //   7653: aload 25
    //   7655: iconst_3
    //   7656: invokestatic 1643	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7659: astore_2
    //   7660: goto -103 -> 7557
    //   7663: new 1647	android/graphics/Rect
    //   7666: dup
    //   7667: invokespecial 1648	android/graphics/Rect:<init>	()V
    //   7670: astore_2
    //   7671: aload 22
    //   7673: aload 21
    //   7675: iconst_0
    //   7676: aload 21
    //   7678: invokevirtual 1649	java/lang/String:length	()I
    //   7681: aload_2
    //   7682: invokevirtual 1653	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   7685: aload_0
    //   7686: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7689: aload_3
    //   7690: aload_1
    //   7691: aconst_null
    //   7692: iload 4
    //   7694: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7697: new 323	java/lang/StringBuilder
    //   7700: dup
    //   7701: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7704: ldc_w 664
    //   7707: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7710: aload_2
    //   7711: invokevirtual 1656	android/graphics/Rect:height	()I
    //   7714: invokevirtual 513	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7717: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7720: astore_2
    //   7721: aload_2
    //   7722: areturn
    //   7723: astore_2
    //   7724: aload_0
    //   7725: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7728: aload_3
    //   7729: aload_1
    //   7730: aconst_null
    //   7731: ldc_w 1658
    //   7734: iload 4
    //   7736: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7739: goto -6345 -> 1394
    //   7742: ldc_w 1660
    //   7745: aload_1
    //   7746: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7749: ifeq +28 -> 7777
    //   7752: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7755: aload_0
    //   7756: invokevirtual 1484	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   7759: new 1662	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17
    //   7762: dup
    //   7763: aload_0
    //   7764: aload_3
    //   7765: aload_1
    //   7766: iload 4
    //   7768: invokespecial 1663	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7771: invokevirtual 1665	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoExtra	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7774: goto -6380 -> 1394
    //   7777: ldc 23
    //   7779: aload_1
    //   7780: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7783: ifeq +273 -> 8056
    //   7786: aload_0
    //   7787: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   7790: ifeq -6396 -> 1394
    //   7793: invokestatic 1591	com/tencent/mobileqq/minigame/manager/GameInfoManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7796: invokevirtual 1669	com/tencent/mobileqq/minigame/manager/GameInfoManager:getLaunchOptions	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions;
    //   7799: astore 20
    //   7801: new 273	org/json/JSONObject
    //   7804: dup
    //   7805: invokespecial 823	org/json/JSONObject:<init>	()V
    //   7808: astore 21
    //   7810: new 273	org/json/JSONObject
    //   7813: dup
    //   7814: invokespecial 823	org/json/JSONObject:<init>	()V
    //   7817: astore 22
    //   7819: aload 20
    //   7821: getfield 1674	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   7824: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7827: ifeq +168 -> 7995
    //   7830: aconst_null
    //   7831: astore_2
    //   7832: aload 22
    //   7834: ldc_w 1554
    //   7837: aload_2
    //   7838: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7841: pop
    //   7842: aload 20
    //   7844: getfield 1677	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   7847: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7850: ifeq +154 -> 8004
    //   7853: aconst_null
    //   7854: astore_2
    //   7855: aload 22
    //   7857: ldc_w 1679
    //   7860: aload_2
    //   7861: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7864: pop
    //   7865: aload 21
    //   7867: ldc_w 1680
    //   7870: aload 20
    //   7872: getfield 1681	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:scene	I
    //   7875: invokestatic 1687	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getWikiScene	(I)I
    //   7878: invokevirtual 849	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   7881: pop
    //   7882: aload 21
    //   7884: ldc_w 1338
    //   7887: aload 20
    //   7889: getfield 1690	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:query	Lorg/json/JSONObject;
    //   7892: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7895: pop
    //   7896: aload 20
    //   7898: getfield 1692	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   7901: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7904: ifeq +109 -> 8013
    //   7907: aconst_null
    //   7908: astore_2
    //   7909: aload 21
    //   7911: ldc_w 1230
    //   7914: aload_2
    //   7915: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7918: pop
    //   7919: aload 21
    //   7921: ldc_w 1694
    //   7924: aload 22
    //   7926: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7929: pop
    //   7930: aload 21
    //   7932: ldc_w 1696
    //   7935: invokestatic 1591	com/tencent/mobileqq/minigame/manager/GameInfoManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7938: invokevirtual 1699	com/tencent/mobileqq/minigame/manager/GameInfoManager:getExtendData	()Ljava/lang/String;
    //   7941: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7944: pop
    //   7945: aload 21
    //   7947: ldc_w 1360
    //   7950: aload 20
    //   7952: getfield 1701	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:entryDataHash	Ljava/lang/String;
    //   7955: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   7958: pop
    //   7959: ldc 139
    //   7961: iconst_1
    //   7962: new 323	java/lang/StringBuilder
    //   7965: dup
    //   7966: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7969: ldc_w 1703
    //   7972: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7975: aload 21
    //   7977: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7980: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7983: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7986: invokestatic 374	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7989: aload 21
    //   7991: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7994: areturn
    //   7995: aload 20
    //   7997: getfield 1674	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8000: astore_2
    //   8001: goto -169 -> 7832
    //   8004: aload 20
    //   8006: getfield 1677	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8009: astore_2
    //   8010: goto -155 -> 7855
    //   8013: aload 20
    //   8015: getfield 1692	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8018: astore_2
    //   8019: goto -110 -> 7909
    //   8022: astore_2
    //   8023: ldc 139
    //   8025: iconst_1
    //   8026: ldc_w 1705
    //   8029: aload_2
    //   8030: invokestatic 1041	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8033: aload_1
    //   8034: aconst_null
    //   8035: invokestatic 914	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8038: astore_1
    //   8039: aload_3
    //   8040: iload 4
    //   8042: aload_1
    //   8043: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8046: invokeinterface 903 3 0
    //   8051: aload_1
    //   8052: invokevirtual 898	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8055: areturn
    //   8056: ldc 53
    //   8058: aload_1
    //   8059: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8062: ifeq +648 -> 8710
    //   8065: new 273	org/json/JSONObject
    //   8068: dup
    //   8069: aload_2
    //   8070: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8073: astore_2
    //   8074: ldc 139
    //   8076: iconst_1
    //   8077: new 323	java/lang/StringBuilder
    //   8080: dup
    //   8081: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   8084: ldc_w 1707
    //   8087: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8090: aload_2
    //   8091: invokevirtual 911	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8094: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8097: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8100: aload_2
    //   8101: ldc_w 539
    //   8104: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8107: astore 22
    //   8109: aload 22
    //   8111: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8114: ifeq +20 -> 8134
    //   8117: aload_0
    //   8118: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8121: aload_3
    //   8122: aload_1
    //   8123: aconst_null
    //   8124: ldc_w 1709
    //   8127: iload 4
    //   8129: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8132: aconst_null
    //   8133: areturn
    //   8134: aload_2
    //   8135: ldc_w 1711
    //   8138: iconst_0
    //   8139: invokevirtual 1015	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8142: istore 15
    //   8144: aload 22
    //   8146: invokevirtual 1714	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   8149: astore 20
    //   8151: aload 20
    //   8153: invokestatic 1720	com/tencent/mobileqq/mini/apkg/DomainConfig:getDomainConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/DomainConfig;
    //   8156: astore 21
    //   8158: iload 15
    //   8160: ifne +78 -> 8238
    //   8163: aload_0
    //   8164: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8167: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8170: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   8173: aload 20
    //   8175: iconst_0
    //   8176: invokevirtual 1723	com/tencent/mobileqq/mini/apkg/ApkgInfo:isValidPrefix	(Ljava/lang/String;Z)Z
    //   8179: ifne +20 -> 8199
    //   8182: aload_0
    //   8183: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8186: aload_3
    //   8187: aload_1
    //   8188: aconst_null
    //   8189: ldc_w 1725
    //   8192: iload 4
    //   8194: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8197: aconst_null
    //   8198: areturn
    //   8199: aload_0
    //   8200: getfield 345	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8203: ifnull +35 -> 8238
    //   8206: aload_0
    //   8207: getfield 345	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8210: aload 21
    //   8212: getfield 1728	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8215: invokevirtual 1731	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   8218: ifne +20 -> 8238
    //   8221: aload_0
    //   8222: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8225: aload_3
    //   8226: aload_1
    //   8227: aconst_null
    //   8228: ldc_w 1733
    //   8231: iload 4
    //   8233: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8236: aconst_null
    //   8237: areturn
    //   8238: ldc_w 1735
    //   8241: aload 21
    //   8243: getfield 1728	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8246: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8249: ifeq +438 -> 8687
    //   8252: ldc_w 1737
    //   8255: ldc_w 1739
    //   8258: invokestatic 1744	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8261: astore_2
    //   8262: aload 22
    //   8264: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8267: ifne +402 -> 8669
    //   8270: aload_0
    //   8271: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8274: ifnull +395 -> 8669
    //   8277: aload_0
    //   8278: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8281: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8284: ifnull +385 -> 8669
    //   8287: invokestatic 1749	com/tencent/mobileqq/mini/mainpage/MainPageFragment:getUin	()Ljava/lang/String;
    //   8290: astore 21
    //   8292: aload 21
    //   8294: ifnonnull +1506 -> 9800
    //   8297: ldc_w 664
    //   8300: astore 20
    //   8302: aload 22
    //   8304: ldc_w 1751
    //   8307: aload 20
    //   8309: invokevirtual 1755	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8312: ldc_w 1757
    //   8315: invokestatic 868	babp:c	()Ljava/lang/String;
    //   8318: invokevirtual 1755	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8321: ldc_w 1759
    //   8324: ldc_w 1761
    //   8327: invokevirtual 1755	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8330: ldc_w 1763
    //   8333: getstatic 676	android/os/Build$VERSION:SDK_INT	I
    //   8336: invokestatic 1161	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   8339: invokevirtual 1755	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8342: ldc_w 1765
    //   8345: invokestatic 578	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8348: invokestatic 1770	badq:a	(Landroid/content/Context;)Ljava/lang/String;
    //   8351: invokevirtual 1755	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8354: ldc_w 1772
    //   8357: aload_2
    //   8358: invokevirtual 1755	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8361: astore 22
    //   8363: invokestatic 401	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8366: new 323	java/lang/StringBuilder
    //   8369: dup
    //   8370: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   8373: getstatic 1778	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   8376: invokevirtual 1779	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   8379: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8382: aload 21
    //   8384: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8387: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8390: invokevirtual 1782	com/tencent/common/app/BaseApplicationImpl:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   8393: astore 20
    //   8395: aload 20
    //   8397: astore_2
    //   8398: aload 20
    //   8400: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8403: ifeq +7 -> 8410
    //   8406: ldc_w 664
    //   8409: astore_2
    //   8410: aload 22
    //   8412: ldc_w 1784
    //   8415: aload_2
    //   8416: invokevirtual 1755	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8419: astore_2
    //   8420: invokestatic 651	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8423: ifeq +29 -> 8452
    //   8426: ldc 139
    //   8428: iconst_2
    //   8429: new 323	java/lang/StringBuilder
    //   8432: dup
    //   8433: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   8436: ldc_w 1786
    //   8439: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8442: aload_2
    //   8443: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8446: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8449: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8452: new 532	android/content/Intent
    //   8455: dup
    //   8456: aload_0
    //   8457: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8460: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8463: getfield 1512	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8466: ldc_w 534
    //   8469: invokespecial 537	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8472: astore 20
    //   8474: aload 20
    //   8476: ldc_w 1788
    //   8479: ldc_w 1789
    //   8482: invokestatic 1574	ajjy:a	(I)Ljava/lang/String;
    //   8485: invokevirtual 543	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8488: pop
    //   8489: aload 20
    //   8491: ldc_w 548
    //   8494: iconst_1
    //   8495: invokevirtual 1792	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8498: pop
    //   8499: aload 20
    //   8501: ldc_w 1794
    //   8504: iconst_1
    //   8505: invokevirtual 1792	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8508: pop
    //   8509: aload 20
    //   8511: ldc_w 539
    //   8514: aload_2
    //   8515: invokevirtual 543	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8518: pop
    //   8519: aload_0
    //   8520: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8523: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8526: getfield 1512	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8529: aload 20
    //   8531: invokevirtual 992	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   8534: aload_0
    //   8535: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8538: aload_3
    //   8539: aload_1
    //   8540: aconst_null
    //   8541: iload 4
    //   8543: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8546: aload_2
    //   8547: ldc_w 1796
    //   8550: invokevirtual 592	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8553: ifeq -7159 -> 1394
    //   8556: ldc 139
    //   8558: iconst_2
    //   8559: ldc_w 1798
    //   8562: invokestatic 633	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8565: new 545	android/os/Bundle
    //   8568: dup
    //   8569: invokespecial 546	android/os/Bundle:<init>	()V
    //   8572: astore_1
    //   8573: aload_1
    //   8574: ldc_w 1800
    //   8577: aload_0
    //   8578: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8581: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8584: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   8587: invokevirtual 1218	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8590: invokestatic 1805	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   8593: ldc_w 1807
    //   8596: ldc_w 1809
    //   8599: aload_1
    //   8600: new 1811	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18
    //   8603: dup
    //   8604: aload_0
    //   8605: invokespecial 1814	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;)V
    //   8608: invokevirtual 1818	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   8611: goto -7217 -> 1394
    //   8614: astore_1
    //   8615: ldc 139
    //   8617: iconst_1
    //   8618: aload_1
    //   8619: iconst_0
    //   8620: anewarray 666	java/lang/Object
    //   8623: invokestatic 1074	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   8626: goto -7232 -> 1394
    //   8629: astore_2
    //   8630: ldc 139
    //   8632: iconst_1
    //   8633: new 323	java/lang/StringBuilder
    //   8636: dup
    //   8637: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   8640: ldc_w 1820
    //   8643: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8646: ldc_w 664
    //   8649: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8652: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8655: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8658: aload_2
    //   8659: invokevirtual 1821	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   8662: ldc_w 664
    //   8665: astore_2
    //   8666: goto -404 -> 8262
    //   8669: aload_0
    //   8670: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8673: aload_3
    //   8674: aload_1
    //   8675: aconst_null
    //   8676: ldc_w 1823
    //   8679: iload 4
    //   8681: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8684: goto -7290 -> 1394
    //   8687: aload_2
    //   8688: aload_0
    //   8689: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8692: new 1825	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19
    //   8695: dup
    //   8696: aload_0
    //   8697: aload_3
    //   8698: aload_1
    //   8699: iload 4
    //   8701: invokespecial 1826	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   8704: invokestatic 1832	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/InternalJSPlugin:openUrl	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/InternalJSPlugin$openUrlCallback;)V
    //   8707: goto -7313 -> 1394
    //   8710: ldc 62
    //   8712: aload_1
    //   8713: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8716: ifeq +68 -> 8784
    //   8719: new 273	org/json/JSONObject
    //   8722: dup
    //   8723: aload_2
    //   8724: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8727: ldc_w 1834
    //   8730: iconst_0
    //   8731: invokevirtual 1015	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8734: istore 15
    //   8736: aload_0
    //   8737: invokevirtual 1259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   8740: ifeq -7346 -> 1394
    //   8743: invokestatic 1591	com/tencent/mobileqq/minigame/manager/GameInfoManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8746: invokevirtual 1838	com/tencent/mobileqq/minigame/manager/GameInfoManager:getMiniAppConfig	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   8749: iload 15
    //   8751: invokestatic 1844	com/tencent/mobileqq/minigame/gpkg/GpkgManager:setOfflineResourceContent	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Z)V
    //   8754: aload_0
    //   8755: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8758: aload_3
    //   8759: aload_1
    //   8760: aconst_null
    //   8761: iload 4
    //   8763: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8766: goto -7372 -> 1394
    //   8769: astore_1
    //   8770: ldc 139
    //   8772: iconst_1
    //   8773: aload_1
    //   8774: iconst_0
    //   8775: anewarray 666	java/lang/Object
    //   8778: invokestatic 1074	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   8781: goto -7387 -> 1394
    //   8784: ldc 92
    //   8786: aload_1
    //   8787: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8790: ifeq +178 -> 8968
    //   8793: aload_0
    //   8794: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8797: ifnull -7403 -> 1394
    //   8800: new 376	java/util/ArrayList
    //   8803: dup
    //   8804: invokespecial 377	java/util/ArrayList:<init>	()V
    //   8807: astore 20
    //   8809: new 273	org/json/JSONObject
    //   8812: dup
    //   8813: aload_2
    //   8814: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8817: ldc_w 1000
    //   8820: invokevirtual 1004	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   8823: ldc_w 1846
    //   8826: invokevirtual 1470	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   8829: astore_2
    //   8830: aload_2
    //   8831: ifnull +85 -> 8916
    //   8834: aload_2
    //   8835: invokevirtual 1289	org/json/JSONArray:length	()I
    //   8838: ifle +78 -> 8916
    //   8841: iconst_0
    //   8842: istore 7
    //   8844: iload 7
    //   8846: aload_2
    //   8847: invokevirtual 1289	org/json/JSONArray:length	()I
    //   8850: if_icmpge +66 -> 8916
    //   8853: aload_2
    //   8854: iload 7
    //   8856: invokevirtual 1849	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   8859: checkcast 273	org/json/JSONObject
    //   8862: astore 21
    //   8864: new 1851	com/tencent/mobileqq/mini/apkg/PluginInfo
    //   8867: dup
    //   8868: invokespecial 1852	com/tencent/mobileqq/mini/apkg/PluginInfo:<init>	()V
    //   8871: astore 22
    //   8873: aload 22
    //   8875: aload 21
    //   8877: ldc_w 1854
    //   8880: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8883: invokevirtual 1857	com/tencent/mobileqq/mini/apkg/PluginInfo:setPluginId	(Ljava/lang/String;)V
    //   8886: aload 22
    //   8888: aload 21
    //   8890: ldc_w 1859
    //   8893: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8896: invokevirtual 1862	com/tencent/mobileqq/mini/apkg/PluginInfo:setInnerVersion	(Ljava/lang/String;)V
    //   8899: aload 20
    //   8901: aload 22
    //   8903: invokevirtual 390	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   8906: pop
    //   8907: iload 7
    //   8909: iconst_1
    //   8910: iadd
    //   8911: istore 7
    //   8913: goto -69 -> 8844
    //   8916: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   8919: aload_0
    //   8920: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8923: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8926: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   8929: aload 20
    //   8931: new 1864	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20
    //   8934: dup
    //   8935: aload_0
    //   8936: aload_3
    //   8937: aload_1
    //   8938: iload 4
    //   8940: invokespecial 1865	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   8943: invokevirtual 1868	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:verifyPlugin	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   8946: goto -7552 -> 1394
    //   8949: astore_2
    //   8950: aload_0
    //   8951: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8954: aload_3
    //   8955: aload_1
    //   8956: aconst_null
    //   8957: ldc_w 1870
    //   8960: iload 4
    //   8962: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8965: goto -7571 -> 1394
    //   8968: ldc 14
    //   8970: aload_1
    //   8971: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8974: ifeq +127 -> 9101
    //   8977: aload_0
    //   8978: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8981: ifnull -7587 -> 1394
    //   8984: aload_2
    //   8985: ifnull -7591 -> 1394
    //   8988: new 273	org/json/JSONObject
    //   8991: dup
    //   8992: aload_2
    //   8993: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8996: ldc_w 1872
    //   8999: invokevirtual 1470	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9002: astore_2
    //   9003: new 376	java/util/ArrayList
    //   9006: dup
    //   9007: invokespecial 377	java/util/ArrayList:<init>	()V
    //   9010: astore 20
    //   9012: aload_2
    //   9013: ifnull +46 -> 9059
    //   9016: aload_2
    //   9017: invokevirtual 1289	org/json/JSONArray:length	()I
    //   9020: ifle +39 -> 9059
    //   9023: iconst_0
    //   9024: istore 7
    //   9026: iload 7
    //   9028: aload_2
    //   9029: invokevirtual 1289	org/json/JSONArray:length	()I
    //   9032: if_icmpge +27 -> 9059
    //   9035: aload 20
    //   9037: aload_2
    //   9038: iload 7
    //   9040: invokevirtual 1849	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9043: invokestatic 1875	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9046: invokevirtual 390	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9049: pop
    //   9050: iload 7
    //   9052: iconst_1
    //   9053: iadd
    //   9054: istore 7
    //   9056: goto -30 -> 9026
    //   9059: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9062: aload 20
    //   9064: new 1877	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21
    //   9067: dup
    //   9068: aload_0
    //   9069: aload_3
    //   9070: aload_1
    //   9071: iload 4
    //   9073: invokespecial 1878	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9076: invokevirtual 1881	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:batchGetContact	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9079: goto -7685 -> 1394
    //   9082: astore_2
    //   9083: aload_0
    //   9084: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9087: aload_3
    //   9088: aload_1
    //   9089: aconst_null
    //   9090: ldc_w 1883
    //   9093: iload 4
    //   9095: invokevirtual 430	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9098: goto -7704 -> 1394
    //   9101: ldc 26
    //   9103: aload_1
    //   9104: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9107: ifeq +60 -> 9167
    //   9110: new 273	org/json/JSONObject
    //   9113: dup
    //   9114: invokespecial 823	org/json/JSONObject:<init>	()V
    //   9117: astore_2
    //   9118: aload_2
    //   9119: ldc_w 290
    //   9122: aload_0
    //   9123: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9126: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9129: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9132: getfield 1884	com/tencent/mobileqq/mini/apkg/ApkgInfo:appId	Ljava/lang/String;
    //   9135: invokestatic 1889	com/tencent/mobileqq/mini/report/MiniReportManager:getLaunchPerformance	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9138: invokevirtual 834	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   9141: pop
    //   9142: aload_0
    //   9143: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9146: aload_3
    //   9147: aload_1
    //   9148: aload_2
    //   9149: iload 4
    //   9151: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9154: goto -7760 -> 1394
    //   9157: astore 20
    //   9159: aload 20
    //   9161: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   9164: goto -22 -> 9142
    //   9167: ldc_w 1891
    //   9170: aload_1
    //   9171: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9174: ifeq +131 -> 9305
    //   9177: new 273	org/json/JSONObject
    //   9180: dup
    //   9181: invokespecial 823	org/json/JSONObject:<init>	()V
    //   9184: astore_2
    //   9185: aload_0
    //   9186: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9189: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9192: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9195: astore 20
    //   9197: iconst_0
    //   9198: istore 16
    //   9200: iload 16
    //   9202: istore 15
    //   9204: aload 20
    //   9206: ifnull +64 -> 9270
    //   9209: iload 16
    //   9211: istore 15
    //   9213: aload 20
    //   9215: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9218: ifnull +52 -> 9270
    //   9221: iload 16
    //   9223: istore 15
    //   9225: aload 20
    //   9227: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9230: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9233: ifnull +37 -> 9270
    //   9236: iload 16
    //   9238: istore 15
    //   9240: aload 20
    //   9242: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9245: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9248: getfield 1364	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9251: ifnull +19 -> 9270
    //   9254: aload 20
    //   9256: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9259: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9262: getfield 1364	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9265: getfield 1894	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9268: istore 15
    //   9270: aload_2
    //   9271: ldc_w 1896
    //   9274: iload 15
    //   9276: invokevirtual 1564	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9279: pop
    //   9280: aload_0
    //   9281: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9284: aload_3
    //   9285: aload_1
    //   9286: aload_2
    //   9287: iload 4
    //   9289: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9292: goto -7898 -> 1394
    //   9295: astore 20
    //   9297: aload 20
    //   9299: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   9302: goto -22 -> 9280
    //   9305: ldc_w 1898
    //   9308: aload_1
    //   9309: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9312: ifeq +193 -> 9505
    //   9315: new 273	org/json/JSONObject
    //   9318: dup
    //   9319: aload_2
    //   9320: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9323: astore 20
    //   9325: aload 20
    //   9327: ldc_w 1360
    //   9330: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9333: astore_2
    //   9334: aload 20
    //   9336: ldc_w 539
    //   9339: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9342: astore 20
    //   9344: aload_0
    //   9345: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9348: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9351: invokevirtual 489	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9354: astore 21
    //   9356: aload 21
    //   9358: ifnull -7964 -> 1394
    //   9361: aload 21
    //   9363: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9366: ifnull -7972 -> 1394
    //   9369: aload 21
    //   9371: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9374: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9377: ifnull -7983 -> 1394
    //   9380: aload 21
    //   9382: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9385: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9388: getfield 1364	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9391: ifnull -7997 -> 1394
    //   9394: aload_2
    //   9395: ifnull -8001 -> 1394
    //   9398: aload_2
    //   9399: aload 21
    //   9401: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9404: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9407: getfield 1364	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9410: invokevirtual 1369	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   9413: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9416: ifeq -8022 -> 1394
    //   9419: aload 21
    //   9421: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9424: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9427: getfield 1364	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9430: getfield 1894	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9433: ifeq -8039 -> 1394
    //   9436: aload 20
    //   9438: ifnull -8044 -> 1394
    //   9441: aload 20
    //   9443: ldc_w 1900
    //   9446: invokevirtual 1902	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   9449: ifeq -8055 -> 1394
    //   9452: aload 20
    //   9454: ldc_w 1900
    //   9457: aload 21
    //   9459: getfield 928	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9462: getfield 934	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9465: getfield 1364	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9468: getfield 1905	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   9471: invokestatic 1908	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9474: invokevirtual 1755	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   9477: astore_2
    //   9478: aload_0
    //   9479: aload_0
    //   9480: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9483: getfield 1128	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   9486: aload_2
    //   9487: aload_3
    //   9488: aload_1
    //   9489: iload 4
    //   9491: invokespecial 1910	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startGroupBrowserActivity	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9494: goto -8100 -> 1394
    //   9497: astore_1
    //   9498: aload_1
    //   9499: invokevirtual 1108	org/json/JSONException:printStackTrace	()V
    //   9502: goto -8108 -> 1394
    //   9505: ldc_w 1912
    //   9508: aload_1
    //   9509: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9512: ifne +13 -> 9525
    //   9515: ldc_w 1914
    //   9518: aload_1
    //   9519: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9522: ifeq +18 -> 9540
    //   9525: aload_0
    //   9526: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9529: aload_3
    //   9530: aload_1
    //   9531: aconst_null
    //   9532: iload 4
    //   9534: invokevirtual 1107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9537: goto -8143 -> 1394
    //   9540: ldc 20
    //   9542: aload_1
    //   9543: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9546: ifeq -8152 -> 1394
    //   9549: new 273	org/json/JSONObject
    //   9552: dup
    //   9553: aload_2
    //   9554: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9557: ldc_w 1916
    //   9560: invokevirtual 975	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9563: astore_2
    //   9564: aload_2
    //   9565: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9568: ifne -8174 -> 1394
    //   9571: invokestatic 461	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9574: aload_0
    //   9575: getfield 413	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9578: getfield 465	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9581: getfield 470	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9584: aconst_null
    //   9585: aload_2
    //   9586: new 1918	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22
    //   9589: dup
    //   9590: aload_0
    //   9591: aload_3
    //   9592: aload_1
    //   9593: iload 4
    //   9595: invokespecial 1919	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9598: invokevirtual 1923	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getTcbTicket	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9601: goto -8207 -> 1394
    //   9604: astore_1
    //   9605: ldc 139
    //   9607: iconst_1
    //   9608: ldc_w 1925
    //   9611: aload_1
    //   9612: invokestatic 1041	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   9615: goto -8221 -> 1394
    //   9618: aconst_null
    //   9619: astore_1
    //   9620: goto -2653 -> 6967
    //   9623: aconst_null
    //   9624: astore 20
    //   9626: goto -3335 -> 6291
    //   9629: goto -3694 -> 5935
    //   9632: aconst_null
    //   9633: astore_2
    //   9634: goto -5624 -> 4010
    //   9637: iload 9
    //   9639: istore 14
    //   9641: goto -6475 -> 3166
    //   9644: iconst_0
    //   9645: istore 15
    //   9647: goto -9097 -> 550
    //   9650: ldc_w 799
    //   9653: astore 21
    //   9655: goto -9212 -> 443
    //   9658: iconst_m1
    //   9659: istore 8
    //   9661: iconst_m1
    //   9662: istore 7
    //   9664: iconst_m1
    //   9665: istore 11
    //   9667: iconst_0
    //   9668: istore 10
    //   9670: goto -6621 -> 3049
    //   9673: iload 7
    //   9675: istore 8
    //   9677: iload 7
    //   9679: iconst_m1
    //   9680: if_icmpne -5629 -> 4051
    //   9683: iconst_0
    //   9684: istore 8
    //   9686: goto -5635 -> 4051
    //   9689: ldc_w 664
    //   9692: areturn
    //   9693: iload 9
    //   9695: iconst_1
    //   9696: if_icmpne -5390 -> 4306
    //   9699: iconst_1
    //   9700: istore 7
    //   9702: aconst_null
    //   9703: astore_2
    //   9704: goto -5694 -> 4010
    //   9707: iload 9
    //   9709: iconst_3
    //   9710: if_icmpne +11 -> 9721
    //   9713: iconst_3
    //   9714: istore 7
    //   9716: aconst_null
    //   9717: astore_2
    //   9718: goto -5708 -> 4010
    //   9721: iload 9
    //   9723: iconst_4
    //   9724: if_icmpne -5288 -> 4436
    //   9727: iconst_4
    //   9728: istore 7
    //   9730: aconst_null
    //   9731: astore_2
    //   9732: goto -5722 -> 4010
    //   9735: iconst_0
    //   9736: istore 7
    //   9738: goto -5728 -> 4010
    //   9741: iconst_1
    //   9742: istore 16
    //   9744: goto -4818 -> 4926
    //   9747: iconst_0
    //   9748: istore 16
    //   9750: goto -4824 -> 4926
    //   9753: iconst_0
    //   9754: istore 17
    //   9756: goto -4781 -> 4975
    //   9759: bipush 12
    //   9761: istore 4
    //   9763: goto -4741 -> 5022
    //   9766: bipush 12
    //   9768: istore 4
    //   9770: goto -4549 -> 5221
    //   9773: iconst_1
    //   9774: istore 4
    //   9776: goto -4245 -> 5531
    //   9779: iconst_0
    //   9780: istore 4
    //   9782: goto -4251 -> 5531
    //   9785: iconst_0
    //   9786: istore 8
    //   9788: goto -4206 -> 5582
    //   9791: iload 11
    //   9793: iconst_1
    //   9794: iadd
    //   9795: istore 11
    //   9797: goto -3770 -> 6027
    //   9800: aload 21
    //   9802: astore 20
    //   9804: goto -1502 -> 8302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	9807	0	this	DataJsPlugin
    //   0	9807	1	paramString1	String
    //   0	9807	2	paramString2	String
    //   0	9807	3	paramJsRuntime	JsRuntime
    //   0	9807	4	paramInt	int
    //   217	484	5	d	double
    //   259	9478	7	i	int
    //   255	9532	8	j	int
    //   236	9489	9	k	int
    //   300	9369	10	m	int
    //   317	9479	11	n	int
    //   2903	474	12	i1	int
    //   2900	457	13	i2	int
    //   3164	6476	14	i3	int
    //   126	9520	15	bool1	boolean
    //   210	9539	16	bool2	boolean
    //   4973	4782	17	bool3	boolean
    //   2168	302	18	l	long
    //   337	1689	20	localObject1	Object
    //   2046	3	20	localJSONException1	org.json.JSONException
    //   2267	6796	20	localObject2	Object
    //   9157	3	20	localJSONException2	org.json.JSONException
    //   9195	60	20	localApkgInfo1	com.tencent.mobileqq.mini.apkg.ApkgInfo
    //   9295	3	20	localJSONException3	org.json.JSONException
    //   9323	480	20	localObject3	Object
    //   438	9363	21	localObject4	Object
    //   73	8829	22	localObject5	Object
    //   2253	5358	23	localObject6	Object
    //   2263	5383	24	str1	String
    //   2258	5396	25	str2	String
    //   2114	3187	26	str3	String
    //   2231	3035	27	str4	String
    //   2243	206	28	localApkgInfo2	com.tencent.mobileqq.mini.apkg.ApkgInfo
    // Exception table:
    //   from	to	target	type
    //   645	662	910	java/lang/Exception
    //   662	885	910	java/lang/Exception
    //   888	907	910	java/lang/Exception
    //   1227	1239	910	java/lang/Exception
    //   1298	1313	1398	java/lang/Exception
    //   1317	1324	1398	java/lang/Exception
    //   1327	1365	1398	java/lang/Exception
    //   1446	1532	1581	org/json/JSONException
    //   1537	1578	1581	org/json/JSONException
    //   1595	1607	1581	org/json/JSONException
    //   1610	1622	1581	org/json/JSONException
    //   1735	1787	1848	java/lang/Exception
    //   1787	1817	1848	java/lang/Exception
    //   1821	1832	1848	java/lang/Exception
    //   1832	1845	1848	java/lang/Exception
    //   1870	1878	1848	java/lang/Exception
    //   1885	1937	1848	java/lang/Exception
    //   1940	2010	1848	java/lang/Exception
    //   2010	2031	1848	java/lang/Exception
    //   2031	2043	1848	java/lang/Exception
    //   2048	2053	1848	java/lang/Exception
    //   2056	2086	1848	java/lang/Exception
    //   2089	2116	1848	java/lang/Exception
    //   2119	2152	1848	java/lang/Exception
    //   2152	2170	1848	java/lang/Exception
    //   2172	2193	1848	java/lang/Exception
    //   2193	2245	1848	java/lang/Exception
    //   2278	2286	1848	java/lang/Exception
    //   2290	2301	1848	java/lang/Exception
    //   2305	2332	1848	java/lang/Exception
    //   2353	2361	1848	java/lang/Exception
    //   2369	2412	1848	java/lang/Exception
    //   2425	2433	1848	java/lang/Exception
    //   2437	2461	1848	java/lang/Exception
    //   2461	2501	1848	java/lang/Exception
    //   2504	2677	1848	java/lang/Exception
    //   2680	2723	1848	java/lang/Exception
    //   2737	2748	1848	java/lang/Exception
    //   2751	2791	1848	java/lang/Exception
    //   2010	2031	2046	org/json/JSONException
    //   2996	3026	3214	org/json/JSONException
    //   3049	3066	3214	org/json/JSONException
    //   3066	3076	3214	org/json/JSONException
    //   3079	3089	3214	org/json/JSONException
    //   3092	3102	3214	org/json/JSONException
    //   3105	3114	3214	org/json/JSONException
    //   3629	3684	3729	org/json/JSONException
    //   3688	3710	3729	org/json/JSONException
    //   3710	3726	3729	org/json/JSONException
    //   3748	3764	3729	org/json/JSONException
    //   3767	3824	3729	org/json/JSONException
    //   3827	3843	3729	org/json/JSONException
    //   3855	3883	3912	org/json/JSONException
    //   3897	3909	3912	org/json/JSONException
    //   3961	3970	4583	org/json/JSONException
    //   3973	3994	4583	org/json/JSONException
    //   4010	4048	4583	org/json/JSONException
    //   4051	4074	4583	org/json/JSONException
    //   4074	4105	4583	org/json/JSONException
    //   4105	4115	4583	org/json/JSONException
    //   4119	4137	4583	org/json/JSONException
    //   4137	4167	4583	org/json/JSONException
    //   4171	4186	4583	org/json/JSONException
    //   4191	4229	4583	org/json/JSONException
    //   4229	4253	4583	org/json/JSONException
    //   4253	4275	4583	org/json/JSONException
    //   4275	4303	4583	org/json/JSONException
    //   4315	4324	4583	org/json/JSONException
    //   4328	4400	4583	org/json/JSONException
    //   4405	4431	4583	org/json/JSONException
    //   4442	4474	4583	org/json/JSONException
    //   4478	4490	4583	org/json/JSONException
    //   4493	4507	4583	org/json/JSONException
    //   4510	4536	4583	org/json/JSONException
    //   4548	4557	4583	org/json/JSONException
    //   4565	4580	4583	org/json/JSONException
    //   4602	4631	4583	org/json/JSONException
    //   4634	4652	4583	org/json/JSONException
    //   4655	4709	4583	org/json/JSONException
    //   4712	4736	4583	org/json/JSONException
    //   4739	4764	4583	org/json/JSONException
    //   4764	4788	4583	org/json/JSONException
    //   4788	4819	4583	org/json/JSONException
    //   4823	4848	4583	org/json/JSONException
    //   4848	4872	4583	org/json/JSONException
    //   4872	4903	4583	org/json/JSONException
    //   4907	4923	4583	org/json/JSONException
    //   4926	4972	4583	org/json/JSONException
    //   4975	4983	4583	org/json/JSONException
    //   4993	5013	4583	org/json/JSONException
    //   5022	5104	4583	org/json/JSONException
    //   5107	5139	4583	org/json/JSONException
    //   5143	5179	4583	org/json/JSONException
    //   5182	5204	4583	org/json/JSONException
    //   5204	5212	4583	org/json/JSONException
    //   5221	5248	4583	org/json/JSONException
    //   5251	5280	4583	org/json/JSONException
    //   5289	5316	4583	org/json/JSONException
    //   5344	5363	5602	org/json/JSONException
    //   5374	5383	5602	org/json/JSONException
    //   5396	5419	5602	org/json/JSONException
    //   5419	5442	5602	org/json/JSONException
    //   5442	5473	5602	org/json/JSONException
    //   5473	5528	5602	org/json/JSONException
    //   5531	5579	5602	org/json/JSONException
    //   5587	5599	5602	org/json/JSONException
    //   5658	5673	5602	org/json/JSONException
    //   5676	5691	5602	org/json/JSONException
    //   5694	5723	5602	org/json/JSONException
    //   5726	5733	5602	org/json/JSONException
    //   5743	5750	5602	org/json/JSONException
    //   5754	5769	5602	org/json/JSONException
    //   5772	5781	5602	org/json/JSONException
    //   5784	5816	5602	org/json/JSONException
    //   5820	5846	5602	org/json/JSONException
    //   5859	5869	5602	org/json/JSONException
    //   5904	5922	6010	org/json/JSONException
    //   5935	5947	6010	org/json/JSONException
    //   5956	5961	6010	org/json/JSONException
    //   5966	5971	6010	org/json/JSONException
    //   5976	5981	6010	org/json/JSONException
    //   5986	5991	6010	org/json/JSONException
    //   5991	6007	6010	org/json/JSONException
    //   6027	6044	6010	org/json/JSONException
    //   6044	6054	6010	org/json/JSONException
    //   6057	6067	6010	org/json/JSONException
    //   6070	6080	6010	org/json/JSONException
    //   6083	6093	6010	org/json/JSONException
    //   6099	6115	6010	org/json/JSONException
    //   6118	6144	6010	org/json/JSONException
    //   6149	6163	6010	org/json/JSONException
    //   6168	6182	6010	org/json/JSONException
    //   6187	6201	6010	org/json/JSONException
    //   6206	6220	6010	org/json/JSONException
    //   6220	6236	6010	org/json/JSONException
    //   6239	6255	6010	org/json/JSONException
    //   6311	6331	6434	java/lang/Throwable
    //   6335	6350	6434	java/lang/Throwable
    //   6350	6367	6434	java/lang/Throwable
    //   6372	6398	6434	java/lang/Throwable
    //   6403	6431	6434	java/lang/Throwable
    //   6454	6463	6434	java/lang/Throwable
    //   6463	6479	6434	java/lang/Throwable
    //   6488	6500	6434	java/lang/Throwable
    //   6503	6515	6434	java/lang/Throwable
    //   6518	6530	6434	java/lang/Throwable
    //   6542	6682	6685	org/json/JSONException
    //   6713	6760	6763	org/json/JSONException
    //   6859	6869	6900	org/json/JSONException
    //   6832	6859	6919	org/json/JSONException
    //   6869	6900	6919	org/json/JSONException
    //   6901	6916	6919	org/json/JSONException
    //   7148	7180	7263	org/json/JSONException
    //   7184	7200	7263	org/json/JSONException
    //   7203	7223	7263	org/json/JSONException
    //   7232	7260	7263	org/json/JSONException
    //   7321	7412	7723	org/json/JSONException
    //   7416	7453	7723	org/json/JSONException
    //   7462	7477	7723	org/json/JSONException
    //   7481	7504	7723	org/json/JSONException
    //   7508	7525	7723	org/json/JSONException
    //   7528	7557	7723	org/json/JSONException
    //   7561	7576	7723	org/json/JSONException
    //   7583	7601	7723	org/json/JSONException
    //   7607	7636	7723	org/json/JSONException
    //   7642	7660	7723	org/json/JSONException
    //   7663	7721	7723	org/json/JSONException
    //   7819	7830	8022	org/json/JSONException
    //   7832	7853	8022	org/json/JSONException
    //   7855	7907	8022	org/json/JSONException
    //   7909	7995	8022	org/json/JSONException
    //   7995	8001	8022	org/json/JSONException
    //   8004	8010	8022	org/json/JSONException
    //   8013	8019	8022	org/json/JSONException
    //   8065	8132	8614	java/lang/Throwable
    //   8134	8158	8614	java/lang/Throwable
    //   8163	8197	8614	java/lang/Throwable
    //   8199	8236	8614	java/lang/Throwable
    //   8238	8252	8614	java/lang/Throwable
    //   8252	8262	8614	java/lang/Throwable
    //   8262	8292	8614	java/lang/Throwable
    //   8302	8395	8614	java/lang/Throwable
    //   8398	8406	8614	java/lang/Throwable
    //   8410	8452	8614	java/lang/Throwable
    //   8452	8611	8614	java/lang/Throwable
    //   8630	8662	8614	java/lang/Throwable
    //   8669	8684	8614	java/lang/Throwable
    //   8687	8707	8614	java/lang/Throwable
    //   8252	8262	8629	java/io/UnsupportedEncodingException
    //   8719	8766	8769	java/lang/Throwable
    //   8800	8830	8949	java/lang/Throwable
    //   8834	8841	8949	java/lang/Throwable
    //   8844	8907	8949	java/lang/Throwable
    //   8916	8946	8949	java/lang/Throwable
    //   8988	9012	9082	java/lang/Throwable
    //   9016	9023	9082	java/lang/Throwable
    //   9026	9050	9082	java/lang/Throwable
    //   9059	9079	9082	java/lang/Throwable
    //   9118	9142	9157	org/json/JSONException
    //   9185	9197	9295	org/json/JSONException
    //   9213	9221	9295	org/json/JSONException
    //   9225	9236	9295	org/json/JSONException
    //   9240	9270	9295	org/json/JSONException
    //   9270	9280	9295	org/json/JSONException
    //   9315	9356	9497	org/json/JSONException
    //   9361	9394	9497	org/json/JSONException
    //   9398	9436	9497	org/json/JSONException
    //   9441	9494	9497	org/json/JSONException
    //   9549	9601	9604	java/lang/Throwable
  }
  
  public void login(zrt paramzrt)
  {
    if (paramzrt == null) {
      return;
    }
    ThreadManager.excute(new DataJsPlugin.25(this, paramzrt), 16, null, false);
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