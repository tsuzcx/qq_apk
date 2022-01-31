package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.util.Set;

public class AppJsPlugin
  extends BaseJsPlugin
{
  private static final String CHANNEL = "10036618";
  private static final String EVENT_DOWNLOAD_APP = "startDownloadAppTask";
  private static final String EVENT_DOWNLOAD_APP_CANCEL = "cancelDownloadAppTask";
  private static final String EVENT_INSTALL_APP = "installApp";
  private static final String EVENT_QUERY_APP_INFO = "queryAppInfo";
  private static final String EVENT_QUERY_DOWNLOAD_INFO = "queryDownloadAppTask";
  private static final String EVENT_START_APP = "startApp";
  public static final String FOLDER = Environment.getExternalStorageDirectory().getPath() + "/tencent/mini/app_download/";
  private static final Set<String> S_EVENT_MAP = new AppJsPlugin.1();
  private static final String TAG = "AppJsPlugin";
  private static final String VIA = "SmallGame";
  private AppJsPlugin.AppDownloadManager mAppDownloadManager;
  
  private File getAkgCacheFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return new File(FOLDER + File.separator + MD5.toMD5(paramString) + ".apk");
  }
  
  /* Error */
  public String handleNativeRequest(String paramString1, String paramString2, com.tencent.mobileqq.mini.webview.JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: ldc 11
    //   2: aload_1
    //   3: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +159 -> 165
    //   9: new 115	org/json/JSONObject
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 6
    //   21: ldc 118
    //   23: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 7
    //   28: aload 6
    //   30: ldc 123
    //   32: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 8
    //   37: aload 6
    //   39: ldc 125
    //   41: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 9
    //   46: aload 6
    //   48: ldc 127
    //   50: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 10
    //   55: aload 6
    //   57: ldc 129
    //   59: invokevirtual 133	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   62: istore 5
    //   64: aload 8
    //   66: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifne +44 -> 113
    //   72: aload_0
    //   73: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   76: aload 8
    //   78: new 135	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$3
    //   81: dup
    //   82: aload_0
    //   83: aload_1
    //   84: aload_3
    //   85: iload 4
    //   87: aload 8
    //   89: iload 5
    //   91: aload 7
    //   93: aload 9
    //   95: aload 10
    //   97: invokespecial 138	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   100: invokevirtual 144	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:queryApkDownloadInfo	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$IWaldlCallback;)V
    //   103: aload_0
    //   104: aload_1
    //   105: aload_2
    //   106: aload_3
    //   107: iload 4
    //   109: invokespecial 146	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPlugin:handleNativeRequest	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)Ljava/lang/String;
    //   112: areturn
    //   113: aload_3
    //   114: iload 4
    //   116: aload_1
    //   117: aconst_null
    //   118: invokestatic 152	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   121: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   124: invokeinterface 159 3 0
    //   129: goto -26 -> 103
    //   132: astore 6
    //   134: ldc 33
    //   136: iconst_1
    //   137: aload 6
    //   139: iconst_0
    //   140: anewarray 161	java/lang/Object
    //   143: invokestatic 167	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   146: aload_3
    //   147: iload 4
    //   149: aload_1
    //   150: aconst_null
    //   151: invokestatic 152	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   154: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   157: invokeinterface 159 3 0
    //   162: goto -59 -> 103
    //   165: ldc 14
    //   167: aload_1
    //   168: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +123 -> 294
    //   174: new 115	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 168	org/json/JSONObject:<init>	()V
    //   181: astore 6
    //   183: new 115	org/json/JSONObject
    //   186: dup
    //   187: aload_2
    //   188: invokespecial 116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   191: ldc 123
    //   193: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 7
    //   198: aload 6
    //   200: ldc 123
    //   202: aload 7
    //   204: invokevirtual 172	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload_0
    //   209: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   212: aload 7
    //   214: invokevirtual 175	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:stopDownloadTask	(Ljava/lang/String;)Z
    //   217: ifeq +57 -> 274
    //   220: aload_3
    //   221: iload 4
    //   223: aload_1
    //   224: aload 6
    //   226: invokestatic 178	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   229: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   232: invokeinterface 159 3 0
    //   237: goto -134 -> 103
    //   240: astore 7
    //   242: ldc 33
    //   244: iconst_1
    //   245: aload 7
    //   247: iconst_0
    //   248: anewarray 161	java/lang/Object
    //   251: invokestatic 167	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   254: aload_3
    //   255: iload 4
    //   257: aload_1
    //   258: aload 6
    //   260: invokestatic 152	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   263: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   266: invokeinterface 159 3 0
    //   271: goto -168 -> 103
    //   274: aload_3
    //   275: iload 4
    //   277: aload_1
    //   278: aload 6
    //   280: invokestatic 152	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   283: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   286: invokeinterface 159 3 0
    //   291: goto -188 -> 103
    //   294: ldc 23
    //   296: aload_1
    //   297: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   300: ifeq +77 -> 377
    //   303: new 115	org/json/JSONObject
    //   306: dup
    //   307: aload_2
    //   308: invokespecial 116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   311: ldc 123
    //   313: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   316: astore 6
    //   318: aload_0
    //   319: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   322: aload 6
    //   324: new 180	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$4
    //   327: dup
    //   328: aload_0
    //   329: aload 6
    //   331: aload_1
    //   332: aload_3
    //   333: iload 4
    //   335: invokespecial 183	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$4:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   338: invokestatic 187	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;Ljava/lang/String;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$IWaldlCallback;)V
    //   341: goto -238 -> 103
    //   344: astore 6
    //   346: ldc 33
    //   348: iconst_1
    //   349: aload 6
    //   351: iconst_0
    //   352: anewarray 161	java/lang/Object
    //   355: invokestatic 167	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   358: aload_3
    //   359: iload 4
    //   361: aload_1
    //   362: aconst_null
    //   363: invokestatic 152	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   366: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   369: invokeinterface 159 3 0
    //   374: goto -271 -> 103
    //   377: ldc 20
    //   379: aload_1
    //   380: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   383: ifeq +209 -> 592
    //   386: new 115	org/json/JSONObject
    //   389: dup
    //   390: aload_2
    //   391: invokespecial 116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   394: ldc 118
    //   396: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   399: astore 7
    //   401: aload_0
    //   402: getfield 191	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   405: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   408: invokevirtual 203	com/tencent/mobileqq/app/BaseActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   411: astore 8
    //   413: aload_0
    //   414: getfield 191	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   417: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   420: aload 7
    //   422: invokestatic 209	bhtl:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/pm/PackageInfo;
    //   425: astore 6
    //   427: aload 6
    //   429: ifnull +142 -> 571
    //   432: new 115	org/json/JSONObject
    //   435: dup
    //   436: invokespecial 168	org/json/JSONObject:<init>	()V
    //   439: astore 9
    //   441: aload 9
    //   443: ldc 118
    //   445: aload 7
    //   447: invokevirtual 172	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   450: pop
    //   451: aload 9
    //   453: ldc 211
    //   455: aload 6
    //   457: getfield 217	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   460: aload 8
    //   462: invokevirtual 223	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   465: invokeinterface 226 1 0
    //   470: invokevirtual 172	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   473: pop
    //   474: aload 9
    //   476: ldc 228
    //   478: aload 6
    //   480: getfield 231	android/content/pm/PackageInfo:versionCode	I
    //   483: invokevirtual 234	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   486: pop
    //   487: aload 9
    //   489: ldc 236
    //   491: aload 6
    //   493: getfield 238	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   496: invokevirtual 172	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   499: pop
    //   500: aload_3
    //   501: iload 4
    //   503: aload_1
    //   504: aload 9
    //   506: invokestatic 178	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   509: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   512: invokeinterface 159 3 0
    //   517: goto -414 -> 103
    //   520: astore 6
    //   522: ldc 33
    //   524: iconst_1
    //   525: aload 6
    //   527: iconst_0
    //   528: anewarray 161	java/lang/Object
    //   531: invokestatic 167	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   534: aload_3
    //   535: iload 4
    //   537: aload_1
    //   538: aconst_null
    //   539: invokestatic 152	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   542: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   545: invokeinterface 159 3 0
    //   550: goto -447 -> 103
    //   553: astore 6
    //   555: ldc 33
    //   557: iconst_1
    //   558: ldc 240
    //   560: aload 6
    //   562: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   565: aconst_null
    //   566: astore 6
    //   568: goto -141 -> 427
    //   571: aload_3
    //   572: iload 4
    //   574: aload_1
    //   575: aconst_null
    //   576: ldc 247
    //   578: invokestatic 250	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   581: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   584: invokeinterface 159 3 0
    //   589: goto -486 -> 103
    //   592: ldc 17
    //   594: aload_1
    //   595: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifeq +88 -> 686
    //   601: new 115	org/json/JSONObject
    //   604: dup
    //   605: aload_2
    //   606: invokespecial 116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   609: astore 6
    //   611: aload 6
    //   613: ldc 118
    //   615: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   618: pop
    //   619: aload 6
    //   621: ldc 123
    //   623: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   626: astore 6
    //   628: aload_0
    //   629: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   632: aload 6
    //   634: new 252	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$5
    //   637: dup
    //   638: aload_0
    //   639: aload_1
    //   640: aload_3
    //   641: iload 4
    //   643: invokespecial 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$5:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   646: invokevirtual 258	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:installApp	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$IWaldlCallback;)Z
    //   649: pop
    //   650: goto -547 -> 103
    //   653: astore 6
    //   655: ldc 33
    //   657: iconst_1
    //   658: aload 6
    //   660: iconst_0
    //   661: anewarray 161	java/lang/Object
    //   664: invokestatic 167	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   667: aload_3
    //   668: iload 4
    //   670: aload_1
    //   671: aconst_null
    //   672: invokestatic 152	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   675: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   678: invokeinterface 159 3 0
    //   683: goto -580 -> 103
    //   686: ldc 26
    //   688: aload_1
    //   689: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   692: ifeq -589 -> 103
    //   695: new 115	org/json/JSONObject
    //   698: dup
    //   699: aload_2
    //   700: invokespecial 116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   703: astore 6
    //   705: aload 6
    //   707: ldc 118
    //   709: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   712: astore 7
    //   714: aload 6
    //   716: ldc_w 260
    //   719: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   722: astore 8
    //   724: aload_0
    //   725: getfield 191	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   728: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   731: invokevirtual 203	com/tencent/mobileqq/app/BaseActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   734: astore 9
    //   736: aload 9
    //   738: iconst_0
    //   739: invokevirtual 266	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   742: invokeinterface 272 1 0
    //   747: astore 10
    //   749: aload 10
    //   751: invokeinterface 278 1 0
    //   756: ifeq +280 -> 1036
    //   759: aload 10
    //   761: invokeinterface 282 1 0
    //   766: checkcast 213	android/content/pm/PackageInfo
    //   769: astore 6
    //   771: aload 6
    //   773: getfield 285	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   776: ifnull -27 -> 749
    //   779: aload 6
    //   781: getfield 285	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   784: aload 7
    //   786: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   789: ifeq -40 -> 749
    //   792: aload 6
    //   794: ifnull +223 -> 1017
    //   797: new 115	org/json/JSONObject
    //   800: dup
    //   801: invokespecial 168	org/json/JSONObject:<init>	()V
    //   804: astore 10
    //   806: aload 8
    //   808: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   811: ifne +167 -> 978
    //   814: new 287	android/content/Intent
    //   817: dup
    //   818: invokespecial 288	android/content/Intent:<init>	()V
    //   821: astore 6
    //   823: aload 6
    //   825: ldc_w 290
    //   828: ldc_w 292
    //   831: invokevirtual 296	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   834: pop
    //   835: aload 6
    //   837: ldc_w 297
    //   840: invokevirtual 301	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   843: pop
    //   844: aload 6
    //   846: new 303	android/content/ComponentName
    //   849: dup
    //   850: aload 7
    //   852: aload 8
    //   854: invokespecial 306	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: invokevirtual 310	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   860: pop
    //   861: aload 6
    //   863: aload 9
    //   865: ldc_w 311
    //   868: invokevirtual 315	android/content/Intent:resolveActivityInfo	(Landroid/content/pm/PackageManager;I)Landroid/content/pm/ActivityInfo;
    //   871: ifnull +68 -> 939
    //   874: aload_0
    //   875: getfield 191	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   878: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   881: aload 6
    //   883: invokevirtual 319	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   886: aload_3
    //   887: iload 4
    //   889: aload_1
    //   890: aload 10
    //   892: invokestatic 178	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   895: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   898: invokeinterface 159 3 0
    //   903: goto -800 -> 103
    //   906: astore 6
    //   908: ldc 33
    //   910: iconst_1
    //   911: aload 6
    //   913: iconst_0
    //   914: anewarray 161	java/lang/Object
    //   917: invokestatic 167	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   920: aload_3
    //   921: iload 4
    //   923: aload_1
    //   924: aconst_null
    //   925: invokestatic 152	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   928: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   931: invokeinterface 159 3 0
    //   936: goto -833 -> 103
    //   939: ldc 33
    //   941: iconst_1
    //   942: iconst_1
    //   943: anewarray 161	java/lang/Object
    //   946: dup
    //   947: iconst_0
    //   948: ldc_w 321
    //   951: aastore
    //   952: invokestatic 324	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   955: aload_3
    //   956: iload 4
    //   958: aload_1
    //   959: aconst_null
    //   960: ldc_w 326
    //   963: invokestatic 250	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   966: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   969: invokeinterface 159 3 0
    //   974: ldc_w 328
    //   977: areturn
    //   978: aload 9
    //   980: aload 6
    //   982: getfield 285	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   985: invokevirtual 332	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   988: astore 6
    //   990: aload 6
    //   992: ldc_w 290
    //   995: ldc_w 292
    //   998: invokevirtual 296	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1001: pop
    //   1002: aload_0
    //   1003: getfield 191	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1006: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1009: aload 6
    //   1011: invokevirtual 319	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   1014: goto -128 -> 886
    //   1017: aload_3
    //   1018: iload 4
    //   1020: aload_1
    //   1021: aconst_null
    //   1022: invokestatic 152	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1025: invokevirtual 153	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1028: invokeinterface 159 3 0
    //   1033: goto -930 -> 103
    //   1036: aconst_null
    //   1037: astore 6
    //   1039: goto -247 -> 792
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1042	0	this	AppJsPlugin
    //   0	1042	1	paramString1	String
    //   0	1042	2	paramString2	String
    //   0	1042	3	paramJsRuntime	com.tencent.mobileqq.mini.webview.JsRuntime
    //   0	1042	4	paramInt	int
    //   62	28	5	bool	boolean
    //   17	39	6	localJSONObject	org.json.JSONObject
    //   132	6	6	localThrowable1	java.lang.Throwable
    //   181	149	6	localObject1	java.lang.Object
    //   344	6	6	localThrowable2	java.lang.Throwable
    //   425	67	6	localPackageInfo	android.content.pm.PackageInfo
    //   520	6	6	localThrowable3	java.lang.Throwable
    //   553	8	6	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   566	67	6	localObject2	java.lang.Object
    //   653	6	6	localThrowable4	java.lang.Throwable
    //   703	179	6	localObject3	java.lang.Object
    //   906	75	6	localThrowable5	java.lang.Throwable
    //   988	50	6	localIntent	android.content.Intent
    //   26	187	7	str1	String
    //   240	6	7	localThrowable6	java.lang.Throwable
    //   399	452	7	str2	String
    //   35	818	8	localObject4	java.lang.Object
    //   44	935	9	localObject5	java.lang.Object
    //   53	838	10	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   9	103	132	java/lang/Throwable
    //   113	129	132	java/lang/Throwable
    //   183	237	240	java/lang/Throwable
    //   274	291	240	java/lang/Throwable
    //   303	341	344	java/lang/Throwable
    //   386	413	520	java/lang/Throwable
    //   413	427	520	java/lang/Throwable
    //   432	517	520	java/lang/Throwable
    //   555	565	520	java/lang/Throwable
    //   571	589	520	java/lang/Throwable
    //   413	427	553	android/content/pm/PackageManager$NameNotFoundException
    //   601	650	653	java/lang/Throwable
    //   695	749	906	java/lang/Throwable
    //   749	792	906	java/lang/Throwable
    //   797	886	906	java/lang/Throwable
    //   886	903	906	java/lang/Throwable
    //   939	974	906	java/lang/Throwable
    //   978	1014	906	java/lang/Throwable
    //   1017	1033	906	java/lang/Throwable
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.mAppDownloadManager = new AppJsPlugin.AppDownloadManager(this, paramBaseJsPluginEngine.activityContext);
  }
  
  public void onDestroy()
  {
    if (this.mAppDownloadManager != null) {
      this.mAppDownloadManager.unInit();
    }
    super.onDestroy();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin
 * JD-Core Version:    0.7.0.1
 */