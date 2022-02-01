package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import java.util.Set;

public class AppJsPlugin
  extends BaseJsPlugin
{
  private static final String CHANNEL = "10036618";
  private static final String EVENT_DOWNLOAD_APP = "startDownloadAppTask";
  private static final String EVENT_DOWNLOAD_APP_CANCEL = "cancelDownloadAppTask";
  private static final String EVENT_INSTALL_APP = "installApp";
  private static final String EVENT_IS_MICROAPP_INSTALLED = "isMicroAppInstalled";
  private static final String EVENT_QUERY_APP_INFO = "queryAppInfo";
  private static final String EVENT_QUERY_DOWNLOAD_INFO = "queryDownloadAppTask";
  private static final String EVENT_START_APP = "startApp";
  private static final Set<String> S_EVENT_MAP = new AppJsPlugin.1();
  private static final String TAG = "AppJsPlugin";
  private static final String VIA = "SmallGame";
  private AppJsPlugin.AppDownloadManager mAppDownloadManager;
  
  /* Error */
  public String handleNativeRequest(String paramString1, String paramString2, com.tencent.mobileqq.mini.webview.JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: ldc 11
    //   2: aload_1
    //   3: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +159 -> 165
    //   9: new 69	org/json/JSONObject
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 6
    //   21: ldc 74
    //   23: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 7
    //   28: aload 6
    //   30: ldc 80
    //   32: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 8
    //   37: aload 6
    //   39: ldc 82
    //   41: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 9
    //   46: aload 6
    //   48: ldc 84
    //   50: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 10
    //   55: aload 6
    //   57: ldc 86
    //   59: invokevirtual 90	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   62: istore 5
    //   64: aload 8
    //   66: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifne +44 -> 113
    //   72: aload_0
    //   73: getfield 55	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   76: aload 8
    //   78: new 98	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$3
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
    //   97: invokespecial 101	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   100: invokevirtual 107	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:queryApkDownloadInfo	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$IWaldlCallback;)V
    //   103: aload_0
    //   104: aload_1
    //   105: aload_2
    //   106: aload_3
    //   107: iload 4
    //   109: invokespecial 109	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPlugin:handleNativeRequest	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)Ljava/lang/String;
    //   112: areturn
    //   113: aload_3
    //   114: iload 4
    //   116: aload_1
    //   117: aconst_null
    //   118: invokestatic 115	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   121: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   124: invokeinterface 125 3 0
    //   129: goto -26 -> 103
    //   132: astore 6
    //   134: ldc 35
    //   136: iconst_1
    //   137: aload 6
    //   139: iconst_0
    //   140: anewarray 127	java/lang/Object
    //   143: invokestatic 133	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   146: aload_3
    //   147: iload 4
    //   149: aload_1
    //   150: aconst_null
    //   151: invokestatic 115	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   154: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   157: invokeinterface 125 3 0
    //   162: goto -59 -> 103
    //   165: ldc 14
    //   167: aload_1
    //   168: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +123 -> 294
    //   174: new 69	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 134	org/json/JSONObject:<init>	()V
    //   181: astore 6
    //   183: new 69	org/json/JSONObject
    //   186: dup
    //   187: aload_2
    //   188: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   191: ldc 80
    //   193: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 7
    //   198: aload 6
    //   200: ldc 80
    //   202: aload 7
    //   204: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload_0
    //   209: getfield 55	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   212: aload 7
    //   214: invokevirtual 141	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:stopDownloadTask	(Ljava/lang/String;)Z
    //   217: ifeq +57 -> 274
    //   220: aload_3
    //   221: iload 4
    //   223: aload_1
    //   224: aload 6
    //   226: invokestatic 144	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   229: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   232: invokeinterface 125 3 0
    //   237: goto -134 -> 103
    //   240: astore 7
    //   242: ldc 35
    //   244: iconst_1
    //   245: aload 7
    //   247: iconst_0
    //   248: anewarray 127	java/lang/Object
    //   251: invokestatic 133	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   254: aload_3
    //   255: iload 4
    //   257: aload_1
    //   258: aload 6
    //   260: invokestatic 115	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   263: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   266: invokeinterface 125 3 0
    //   271: goto -168 -> 103
    //   274: aload_3
    //   275: iload 4
    //   277: aload_1
    //   278: aload 6
    //   280: invokestatic 115	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   283: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   286: invokeinterface 125 3 0
    //   291: goto -188 -> 103
    //   294: ldc 26
    //   296: aload_1
    //   297: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   300: ifeq +77 -> 377
    //   303: new 69	org/json/JSONObject
    //   306: dup
    //   307: aload_2
    //   308: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   311: ldc 80
    //   313: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   316: astore 6
    //   318: aload_0
    //   319: getfield 55	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   322: aload 6
    //   324: new 146	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$4
    //   327: dup
    //   328: aload_0
    //   329: aload 6
    //   331: aload_1
    //   332: aload_3
    //   333: iload 4
    //   335: invokespecial 149	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$4:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   338: invokestatic 153	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:access$100	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;Ljava/lang/String;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$IWaldlCallback;)V
    //   341: goto -238 -> 103
    //   344: astore 6
    //   346: ldc 35
    //   348: iconst_1
    //   349: aload 6
    //   351: iconst_0
    //   352: anewarray 127	java/lang/Object
    //   355: invokestatic 133	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   358: aload_3
    //   359: iload 4
    //   361: aload_1
    //   362: aconst_null
    //   363: invokestatic 115	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   366: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   369: invokeinterface 125 3 0
    //   374: goto -271 -> 103
    //   377: ldc 23
    //   379: aload_1
    //   380: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   383: ifeq +209 -> 592
    //   386: new 69	org/json/JSONObject
    //   389: dup
    //   390: aload_2
    //   391: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   394: ldc 74
    //   396: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   399: astore 7
    //   401: aload_0
    //   402: getfield 157	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   405: getfield 163	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   408: invokevirtual 169	com/tencent/mobileqq/app/BaseActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   411: astore 8
    //   413: aload_0
    //   414: getfield 157	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   417: getfield 163	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   420: aload 7
    //   422: invokestatic 175	bjnn:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/pm/PackageInfo;
    //   425: astore 6
    //   427: aload 6
    //   429: ifnull +142 -> 571
    //   432: new 69	org/json/JSONObject
    //   435: dup
    //   436: invokespecial 134	org/json/JSONObject:<init>	()V
    //   439: astore 9
    //   441: aload 9
    //   443: ldc 74
    //   445: aload 7
    //   447: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   450: pop
    //   451: aload 9
    //   453: ldc 177
    //   455: aload 6
    //   457: getfield 183	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   460: aload 8
    //   462: invokevirtual 189	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   465: invokeinterface 192 1 0
    //   470: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   473: pop
    //   474: aload 9
    //   476: ldc 194
    //   478: aload 6
    //   480: getfield 197	android/content/pm/PackageInfo:versionCode	I
    //   483: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   486: pop
    //   487: aload 9
    //   489: ldc 202
    //   491: aload 6
    //   493: getfield 204	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   496: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   499: pop
    //   500: aload_3
    //   501: iload 4
    //   503: aload_1
    //   504: aload 9
    //   506: invokestatic 144	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   509: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   512: invokeinterface 125 3 0
    //   517: goto -414 -> 103
    //   520: astore 6
    //   522: ldc 35
    //   524: iconst_1
    //   525: aload 6
    //   527: iconst_0
    //   528: anewarray 127	java/lang/Object
    //   531: invokestatic 133	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   534: aload_3
    //   535: iload 4
    //   537: aload_1
    //   538: aconst_null
    //   539: invokestatic 115	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   542: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   545: invokeinterface 125 3 0
    //   550: goto -447 -> 103
    //   553: astore 6
    //   555: ldc 35
    //   557: iconst_1
    //   558: ldc 206
    //   560: aload 6
    //   562: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   565: aconst_null
    //   566: astore 6
    //   568: goto -141 -> 427
    //   571: aload_3
    //   572: iload 4
    //   574: aload_1
    //   575: aconst_null
    //   576: ldc 213
    //   578: invokestatic 216	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   581: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   584: invokeinterface 125 3 0
    //   589: goto -486 -> 103
    //   592: ldc 17
    //   594: aload_1
    //   595: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifeq +88 -> 686
    //   601: new 69	org/json/JSONObject
    //   604: dup
    //   605: aload_2
    //   606: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   609: astore 6
    //   611: aload 6
    //   613: ldc 74
    //   615: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   618: pop
    //   619: aload 6
    //   621: ldc 80
    //   623: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   626: astore 6
    //   628: aload_0
    //   629: getfield 55	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:mAppDownloadManager	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager;
    //   632: aload 6
    //   634: new 218	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$5
    //   637: dup
    //   638: aload_0
    //   639: aload_1
    //   640: aload_3
    //   641: iload 4
    //   643: invokespecial 221	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$5:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   646: invokevirtual 224	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$AppDownloadManager:installApp	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$IWaldlCallback;)Z
    //   649: pop
    //   650: goto -547 -> 103
    //   653: astore 6
    //   655: ldc 35
    //   657: iconst_1
    //   658: aload 6
    //   660: iconst_0
    //   661: anewarray 127	java/lang/Object
    //   664: invokestatic 133	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   667: aload_3
    //   668: iload 4
    //   670: aload_1
    //   671: aconst_null
    //   672: invokestatic 115	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   675: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   678: invokeinterface 125 3 0
    //   683: goto -580 -> 103
    //   686: ldc 29
    //   688: aload_1
    //   689: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   692: ifeq +343 -> 1035
    //   695: new 69	org/json/JSONObject
    //   698: dup
    //   699: aload_2
    //   700: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   703: astore 6
    //   705: aload 6
    //   707: ldc 74
    //   709: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   712: astore 7
    //   714: aload 6
    //   716: ldc 226
    //   718: invokevirtual 78	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   721: astore 8
    //   723: aload_0
    //   724: getfield 157	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   727: getfield 163	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   730: invokevirtual 169	com/tencent/mobileqq/app/BaseActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   733: astore 9
    //   735: aload 9
    //   737: iconst_0
    //   738: invokevirtual 232	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   741: invokeinterface 238 1 0
    //   746: astore 10
    //   748: aload 10
    //   750: invokeinterface 244 1 0
    //   755: ifeq +374 -> 1129
    //   758: aload 10
    //   760: invokeinterface 248 1 0
    //   765: checkcast 179	android/content/pm/PackageInfo
    //   768: astore 6
    //   770: aload 6
    //   772: getfield 251	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   775: ifnull -27 -> 748
    //   778: aload 6
    //   780: getfield 251	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   783: aload 7
    //   785: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   788: ifeq -40 -> 748
    //   791: aload 6
    //   793: ifnull +223 -> 1016
    //   796: new 69	org/json/JSONObject
    //   799: dup
    //   800: invokespecial 134	org/json/JSONObject:<init>	()V
    //   803: astore 10
    //   805: aload 8
    //   807: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   810: ifne +167 -> 977
    //   813: new 253	android/content/Intent
    //   816: dup
    //   817: invokespecial 254	android/content/Intent:<init>	()V
    //   820: astore 6
    //   822: aload 6
    //   824: ldc_w 256
    //   827: ldc_w 258
    //   830: invokevirtual 262	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   833: pop
    //   834: aload 6
    //   836: ldc_w 263
    //   839: invokevirtual 267	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   842: pop
    //   843: aload 6
    //   845: new 269	android/content/ComponentName
    //   848: dup
    //   849: aload 7
    //   851: aload 8
    //   853: invokespecial 272	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   856: invokevirtual 276	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   859: pop
    //   860: aload 6
    //   862: aload 9
    //   864: ldc_w 277
    //   867: invokevirtual 281	android/content/Intent:resolveActivityInfo	(Landroid/content/pm/PackageManager;I)Landroid/content/pm/ActivityInfo;
    //   870: ifnull +68 -> 938
    //   873: aload_0
    //   874: getfield 157	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   877: getfield 163	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   880: aload 6
    //   882: invokevirtual 285	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   885: aload_3
    //   886: iload 4
    //   888: aload_1
    //   889: aload 10
    //   891: invokestatic 144	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   894: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   897: invokeinterface 125 3 0
    //   902: goto -799 -> 103
    //   905: astore 6
    //   907: ldc 35
    //   909: iconst_1
    //   910: aload 6
    //   912: iconst_0
    //   913: anewarray 127	java/lang/Object
    //   916: invokestatic 133	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   919: aload_3
    //   920: iload 4
    //   922: aload_1
    //   923: aconst_null
    //   924: invokestatic 115	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   927: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   930: invokeinterface 125 3 0
    //   935: goto -832 -> 103
    //   938: ldc 35
    //   940: iconst_1
    //   941: iconst_1
    //   942: anewarray 127	java/lang/Object
    //   945: dup
    //   946: iconst_0
    //   947: ldc_w 287
    //   950: aastore
    //   951: invokestatic 290	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   954: aload_3
    //   955: iload 4
    //   957: aload_1
    //   958: aconst_null
    //   959: ldc_w 292
    //   962: invokestatic 216	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   965: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   968: invokeinterface 125 3 0
    //   973: ldc_w 294
    //   976: areturn
    //   977: aload 9
    //   979: aload 6
    //   981: getfield 251	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   984: invokevirtual 298	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   987: astore 6
    //   989: aload 6
    //   991: ldc_w 256
    //   994: ldc_w 258
    //   997: invokevirtual 262	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1000: pop
    //   1001: aload_0
    //   1002: getfield 157	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1005: getfield 163	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1008: aload 6
    //   1010: invokevirtual 285	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   1013: goto -128 -> 885
    //   1016: aload_3
    //   1017: iload 4
    //   1019: aload_1
    //   1020: aconst_null
    //   1021: invokestatic 115	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1024: invokevirtual 119	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1027: invokeinterface 125 3 0
    //   1032: goto -929 -> 103
    //   1035: ldc 20
    //   1037: aload_1
    //   1038: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1041: ifeq -938 -> 103
    //   1044: aload_0
    //   1045: getfield 157	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1048: ifnull +69 -> 1117
    //   1051: aload_0
    //   1052: getfield 157	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1055: getfield 302	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1058: ifnull +59 -> 1117
    //   1061: aload_0
    //   1062: getfield 157	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1065: getfield 302	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1068: invokevirtual 308	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1071: ifnull +46 -> 1117
    //   1074: invokestatic 314	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1077: aconst_null
    //   1078: aload_0
    //   1079: getfield 157	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1082: getfield 302	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1085: invokevirtual 308	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1088: getfield 319	com/tencent/mobileqq/mini/apkg/ApkgInfo:appId	Ljava/lang/String;
    //   1091: ldc_w 294
    //   1094: ldc_w 294
    //   1097: bipush 100
    //   1099: new 321	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$6
    //   1102: dup
    //   1103: aload_0
    //   1104: aload_3
    //   1105: aload_1
    //   1106: iload 4
    //   1108: invokespecial 324	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin$6:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/AppJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1111: invokevirtual 328	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getNativeAppInfoForJump	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1114: goto -1011 -> 103
    //   1117: ldc 35
    //   1119: iconst_1
    //   1120: ldc_w 330
    //   1123: invokestatic 333	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1126: goto -1023 -> 103
    //   1129: aconst_null
    //   1130: astore 6
    //   1132: goto -341 -> 791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1135	0	this	AppJsPlugin
    //   0	1135	1	paramString1	String
    //   0	1135	2	paramString2	String
    //   0	1135	3	paramJsRuntime	com.tencent.mobileqq.mini.webview.JsRuntime
    //   0	1135	4	paramInt	int
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
    //   703	178	6	localObject3	java.lang.Object
    //   905	75	6	localThrowable5	java.lang.Throwable
    //   987	144	6	localIntent	android.content.Intent
    //   26	187	7	str1	String
    //   240	6	7	localThrowable6	java.lang.Throwable
    //   399	451	7	str2	String
    //   35	817	8	localObject4	java.lang.Object
    //   44	934	9	localObject5	java.lang.Object
    //   53	837	10	localObject6	java.lang.Object
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
    //   695	748	905	java/lang/Throwable
    //   748	791	905	java/lang/Throwable
    //   796	885	905	java/lang/Throwable
    //   885	902	905	java/lang/Throwable
    //   938	973	905	java/lang/Throwable
    //   977	1013	905	java/lang/Throwable
    //   1016	1032	905	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin
 * JD-Core Version:    0.7.0.1
 */