package com.tencent.mobileqq.mini.appbrand.page;

import Override;
import android.graphics.Bitmap;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class PageWebview$2
  extends WebViewClient
{
  PageWebview$2(PageWebview paramPageWebview) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-start", 1, "---PageWebView finish loadHtml--- webviewid:" + this.this$0.pageWebviewId);
    }
    if (StringUtil.isEmpty(PageWebview.access$200(this.this$0))) {
      PageWebview.access$202(this.this$0, AppLoaderFactory.getAppLoaderManager().waWebviewJsStr());
    }
    if (StringUtil.isEmpty(PageWebview.access$300(this.this$0))) {
      PageWebview.access$302(this.this$0, AppLoaderFactory.getAppLoaderManager().waRemoteDebugJsStr());
    }
    QLog.i("miniapp-start", 1, "---PageWebView begin run js defaultConfig --- webviewid:" + this.this$0.pageWebviewId);
    PageWebview.access$400(this.this$0, 18);
    this.this$0.initJSDefaultConfig(new PageWebview.2.1(this));
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  /* Error */
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_0
    //   10: istore_3
    //   11: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +33 -> 47
    //   17: ldc 127
    //   19: iconst_2
    //   20: new 28	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   27: ldc 129
    //   29: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokeinterface 135 1 0
    //   38: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_2
    //   48: invokeinterface 135 1 0
    //   53: invokevirtual 141	android/net/Uri:toString	()Ljava/lang/String;
    //   56: astore 6
    //   58: aload 6
    //   60: ldc 143
    //   62: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   65: ifeq +589 -> 654
    //   68: aload 6
    //   70: ldc 150
    //   72: invokevirtual 153	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   75: ifeq +394 -> 469
    //   78: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +12 -> 93
    //   84: invokestatic 156	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   87: iconst_2
    //   88: ldc 158
    //   90: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: invokestatic 163	com/tencent/mobileqq/mini/apkg/ApkgManager:getInstance	()Lcom/tencent/mobileqq/mini/apkg/ApkgManager;
    //   96: invokevirtual 166	com/tencent/mobileqq/mini/apkg/ApkgManager:getBasePageFrameStr	()Ljava/lang/String;
    //   99: astore_1
    //   100: aload 7
    //   102: astore 6
    //   104: aload_0
    //   105: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   108: invokestatic 170	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   111: ifnull +18 -> 129
    //   114: aload 7
    //   116: astore 6
    //   118: aload_0
    //   119: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   122: invokestatic 170	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   125: arraylength
    //   126: ifne +173 -> 299
    //   129: aload 7
    //   131: astore 6
    //   133: aload_0
    //   134: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   137: aload_1
    //   138: ldc 172
    //   140: invokevirtual 176	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   143: invokestatic 180	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$102	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;[B)[B
    //   146: pop
    //   147: aload 7
    //   149: astore 6
    //   151: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +72 -> 226
    //   157: aload 7
    //   159: astore 6
    //   161: invokestatic 156	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   164: astore_1
    //   165: aload 7
    //   167: astore 6
    //   169: new 28	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   176: ldc 182
    //   178: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: astore_2
    //   182: aload 7
    //   184: astore 6
    //   186: aload_0
    //   187: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   190: invokestatic 170	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   193: ifnull +16 -> 209
    //   196: aload 7
    //   198: astore 6
    //   200: aload_0
    //   201: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   204: invokestatic 170	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   207: arraylength
    //   208: istore_3
    //   209: aload 7
    //   211: astore 6
    //   213: aload_1
    //   214: iconst_2
    //   215: aload_2
    //   216: iload_3
    //   217: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload 7
    //   228: astore 6
    //   230: new 184	java/io/ByteArrayInputStream
    //   233: dup
    //   234: aload_0
    //   235: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   238: invokestatic 170	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   241: iconst_0
    //   242: aload_0
    //   243: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   246: invokestatic 170	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   249: arraylength
    //   250: invokespecial 187	java/io/ByteArrayInputStream:<init>	([BII)V
    //   253: astore_1
    //   254: new 189	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   257: dup
    //   258: ldc 191
    //   260: ldc 172
    //   262: aload_1
    //   263: invokespecial 194	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   266: astore_2
    //   267: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +12 -> 282
    //   273: invokestatic 156	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   276: iconst_2
    //   277: ldc 196
    //   279: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_2
    //   283: astore 6
    //   285: aload_1
    //   286: ifnull +10 -> 296
    //   289: aload_1
    //   290: invokevirtual 199	java/io/ByteArrayInputStream:close	()V
    //   293: aload_2
    //   294: astore 6
    //   296: aload 6
    //   298: areturn
    //   299: aload 7
    //   301: astore 6
    //   303: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq -80 -> 226
    //   309: aload 7
    //   311: astore 6
    //   313: invokestatic 156	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   316: astore_1
    //   317: aload 7
    //   319: astore 6
    //   321: new 28	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   328: ldc 201
    //   330: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: astore_2
    //   334: iload 4
    //   336: istore_3
    //   337: aload 7
    //   339: astore 6
    //   341: aload_0
    //   342: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   345: invokestatic 170	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   348: ifnull +16 -> 364
    //   351: aload 7
    //   353: astore 6
    //   355: aload_0
    //   356: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   359: invokestatic 170	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   362: arraylength
    //   363: istore_3
    //   364: aload 7
    //   366: astore 6
    //   368: aload_1
    //   369: iconst_2
    //   370: aload_2
    //   371: iload_3
    //   372: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: goto -155 -> 226
    //   384: astore 7
    //   386: aconst_null
    //   387: astore_1
    //   388: aload 8
    //   390: astore_2
    //   391: aload_2
    //   392: astore 6
    //   394: invokestatic 156	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   397: iconst_2
    //   398: new 28	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   405: ldc 203
    //   407: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload 7
    //   412: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: aload_1
    //   422: astore 6
    //   424: aload_2
    //   425: ifnull -129 -> 296
    //   428: aload_2
    //   429: invokevirtual 199	java/io/ByteArrayInputStream:close	()V
    //   432: aload_1
    //   433: areturn
    //   434: astore_2
    //   435: aload_2
    //   436: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   439: aload_1
    //   440: areturn
    //   441: astore_1
    //   442: aload_1
    //   443: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   446: aload_2
    //   447: areturn
    //   448: astore_1
    //   449: aload 6
    //   451: ifnull +8 -> 459
    //   454: aload 6
    //   456: invokevirtual 199	java/io/ByteArrayInputStream:close	()V
    //   459: aload_1
    //   460: athrow
    //   461: astore_2
    //   462: aload_2
    //   463: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   466: goto -7 -> 459
    //   469: aload 6
    //   471: invokestatic 214	com/tencent/mobileqq/mini/util/ImageUtil:isJpgFile	(Ljava/lang/String;)Z
    //   474: ifne +11 -> 485
    //   477: aload 6
    //   479: invokestatic 217	com/tencent/mobileqq/mini/util/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   482: ifeq +79 -> 561
    //   485: aload_0
    //   486: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   489: getfield 221	com/tencent/mobileqq/mini/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   492: ifnonnull +10 -> 502
    //   495: aload_0
    //   496: aload_1
    //   497: aload_2
    //   498: invokespecial 223	com/tencent/smtt/sdk/WebViewClient:shouldInterceptRequest	(Lcom/tencent/smtt/sdk/WebView;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   501: areturn
    //   502: aload 6
    //   504: ldc 143
    //   506: invokevirtual 227	java/lang/String:length	()I
    //   509: invokevirtual 231	java/lang/String:substring	(I)Ljava/lang/String;
    //   512: astore_2
    //   513: aload 6
    //   515: invokestatic 217	com/tencent/mobileqq/mini/util/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   518: istore 5
    //   520: iload 5
    //   522: ifeq +33 -> 555
    //   525: ldc 233
    //   527: astore_1
    //   528: new 189	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   531: dup
    //   532: aload_1
    //   533: ldc 172
    //   535: aload_0
    //   536: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   539: getfield 221	com/tencent/mobileqq/mini/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   542: aload_2
    //   543: invokevirtual 239	com/tencent/mobileqq/mini/apkg/ApkgInfo:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   546: iload 5
    //   548: invokestatic 243	com/tencent/mobileqq/mini/util/ImageUtil:getLocalImageStream	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   551: invokespecial 194	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   554: areturn
    //   555: ldc 245
    //   557: astore_1
    //   558: goto -30 -> 528
    //   561: aload 6
    //   563: ldc 247
    //   565: invokevirtual 153	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   568: ifne +13 -> 581
    //   571: aload 6
    //   573: ldc 249
    //   575: invokevirtual 153	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   578: ifeq +650 -> 1228
    //   581: aload_0
    //   582: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   585: getfield 221	com/tencent/mobileqq/mini/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   588: ifnonnull +10 -> 598
    //   591: aload_0
    //   592: aload_1
    //   593: aload_2
    //   594: invokespecial 223	com/tencent/smtt/sdk/WebViewClient:shouldInterceptRequest	(Lcom/tencent/smtt/sdk/WebView;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   597: areturn
    //   598: aload 6
    //   600: ldc 143
    //   602: invokevirtual 227	java/lang/String:length	()I
    //   605: invokevirtual 231	java/lang/String:substring	(I)Ljava/lang/String;
    //   608: astore_2
    //   609: aload 6
    //   611: ldc 247
    //   613: invokevirtual 153	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   616: ifeq +31 -> 647
    //   619: ldc 251
    //   621: astore_1
    //   622: new 189	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   625: dup
    //   626: aload_1
    //   627: ldc 172
    //   629: aload_0
    //   630: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   633: getfield 221	com/tencent/mobileqq/mini/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   636: aload_2
    //   637: invokevirtual 239	com/tencent/mobileqq/mini/apkg/ApkgInfo:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   640: invokestatic 255	com/tencent/mobileqq/mini/util/ImageUtil:getLocalNoBitmapImageStream	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   643: invokespecial 194	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   646: areturn
    //   647: ldc_w 257
    //   650: astore_1
    //   651: goto -29 -> 622
    //   654: aload 6
    //   656: getstatic 263	com/tencent/mobileqq/mini/utils/MiniAppGlobal:STR_WXFILE	Ljava/lang/String;
    //   659: invokevirtual 148	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   662: ifeq +126 -> 788
    //   665: aload 6
    //   667: invokestatic 214	com/tencent/mobileqq/mini/util/ImageUtil:isJpgFile	(Ljava/lang/String;)Z
    //   670: ifne +11 -> 681
    //   673: aload 6
    //   675: invokestatic 217	com/tencent/mobileqq/mini/util/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   678: ifeq +48 -> 726
    //   681: aload 6
    //   683: invokestatic 217	com/tencent/mobileqq/mini/util/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   686: istore 5
    //   688: iload 5
    //   690: ifeq +30 -> 720
    //   693: ldc 233
    //   695: astore_1
    //   696: new 189	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   699: dup
    //   700: aload_1
    //   701: ldc 172
    //   703: invokestatic 268	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   706: aload 6
    //   708: invokevirtual 271	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   711: iload 5
    //   713: invokestatic 243	com/tencent/mobileqq/mini/util/ImageUtil:getLocalImageStream	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   716: invokespecial 194	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   719: areturn
    //   720: ldc 245
    //   722: astore_1
    //   723: goto -27 -> 696
    //   726: aload 6
    //   728: ldc 247
    //   730: invokevirtual 153	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   733: ifne +13 -> 746
    //   736: aload 6
    //   738: ldc 249
    //   740: invokevirtual 153	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   743: ifeq +485 -> 1228
    //   746: aload 6
    //   748: ldc 247
    //   750: invokevirtual 153	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   753: ifeq +28 -> 781
    //   756: ldc 251
    //   758: astore_1
    //   759: new 189	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   762: dup
    //   763: aload_1
    //   764: ldc 172
    //   766: invokestatic 268	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   769: aload 6
    //   771: invokevirtual 271	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   774: invokestatic 255	com/tencent/mobileqq/mini/util/ImageUtil:getLocalNoBitmapImageStream	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   777: invokespecial 194	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   780: areturn
    //   781: ldc_w 257
    //   784: astore_1
    //   785: goto -26 -> 759
    //   788: aload 6
    //   790: invokestatic 276	com/tencent/mobileqq/mini/appbrand/utils/IPV6OnlyUtils:isIPV6Enable	(Ljava/lang/String;)Z
    //   793: ifeq +361 -> 1154
    //   796: invokestatic 281	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   799: ldc_w 283
    //   802: ldc_w 285
    //   805: ldc_w 287
    //   808: invokevirtual 291	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   811: astore_1
    //   812: new 28	java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   819: aload_1
    //   820: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload 6
    //   825: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: astore 6
    //   833: invokestatic 156	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   836: iconst_2
    //   837: new 28	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   844: ldc_w 293
    //   847: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload 6
    //   852: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   861: new 295	java/net/URL
    //   864: dup
    //   865: aload 6
    //   867: invokespecial 298	java/net/URL:<init>	(Ljava/lang/String;)V
    //   870: invokevirtual 302	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   873: checkcast 304	java/net/HttpURLConnection
    //   876: astore 7
    //   878: aload 7
    //   880: aload_2
    //   881: invokeinterface 307 1 0
    //   886: invokevirtual 310	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   889: aload_2
    //   890: invokeinterface 314 1 0
    //   895: ifnull +79 -> 974
    //   898: aload_2
    //   899: invokeinterface 314 1 0
    //   904: invokeinterface 320 1 0
    //   909: invokeinterface 326 1 0
    //   914: astore_1
    //   915: aload_1
    //   916: invokeinterface 331 1 0
    //   921: ifeq +53 -> 974
    //   924: aload_1
    //   925: invokeinterface 335 1 0
    //   930: checkcast 337	java/util/Map$Entry
    //   933: astore_2
    //   934: aload 7
    //   936: aload_2
    //   937: invokeinterface 340 1 0
    //   942: checkcast 145	java/lang/String
    //   945: aload_2
    //   946: invokeinterface 343 1 0
    //   951: checkcast 145	java/lang/String
    //   954: invokevirtual 347	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   957: goto -42 -> 915
    //   960: astore_1
    //   961: invokestatic 156	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   964: iconst_1
    //   965: ldc_w 349
    //   968: aload_1
    //   969: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   972: aconst_null
    //   973: areturn
    //   974: aload 7
    //   976: sipush 6000
    //   979: invokevirtual 356	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   982: aload 7
    //   984: sipush 6000
    //   987: invokevirtual 359	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   990: ldc_w 361
    //   993: astore_2
    //   994: aload_2
    //   995: astore_1
    //   996: aload 7
    //   998: invokevirtual 364	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   1001: ifnull +47 -> 1048
    //   1004: aload_2
    //   1005: astore_1
    //   1006: aload 7
    //   1008: invokevirtual 364	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   1011: ldc_w 366
    //   1014: invokeinterface 370 2 0
    //   1019: ifeq +29 -> 1048
    //   1022: aload 7
    //   1024: invokevirtual 364	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   1027: ldc_w 366
    //   1030: invokeinterface 374 2 0
    //   1035: checkcast 376	java/util/List
    //   1038: iconst_0
    //   1039: invokeinterface 379 2 0
    //   1044: checkcast 145	java/lang/String
    //   1047: astore_1
    //   1048: aload_1
    //   1049: invokestatic 382	com/tencent/mobileqq/mini/appbrand/utils/IPV6OnlyUtils:getMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   1052: astore_2
    //   1053: aload_1
    //   1054: invokestatic 385	com/tencent/mobileqq/mini/appbrand/utils/IPV6OnlyUtils:getEncoding	(Ljava/lang/String;)Ljava/lang/String;
    //   1057: astore_1
    //   1058: invokestatic 156	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   1061: iconst_2
    //   1062: new 28	java/lang/StringBuilder
    //   1065: dup
    //   1066: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1069: ldc_w 387
    //   1072: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: aload 7
    //   1077: invokevirtual 390	java/net/HttpURLConnection:getResponseCode	()I
    //   1080: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1083: ldc_w 392
    //   1086: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: aload 6
    //   1091: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1097: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1100: invokestatic 156	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   1103: iconst_2
    //   1104: new 28	java/lang/StringBuilder
    //   1107: dup
    //   1108: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1111: ldc_w 394
    //   1114: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: aload_2
    //   1118: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: ldc_w 396
    //   1124: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: aload_1
    //   1128: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1134: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1137: new 189	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   1140: dup
    //   1141: aload_2
    //   1142: aload_1
    //   1143: aload 7
    //   1145: invokevirtual 400	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1148: invokespecial 194	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   1151: astore_1
    //   1152: aload_1
    //   1153: areturn
    //   1154: ldc 127
    //   1156: iconst_2
    //   1157: new 28	java/lang/StringBuilder
    //   1160: dup
    //   1161: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1164: ldc_w 402
    //   1167: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: aload_2
    //   1171: invokeinterface 135 1 0
    //   1176: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1179: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1182: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1185: aload_0
    //   1186: aload_1
    //   1187: aload 6
    //   1189: invokespecial 405	com/tencent/smtt/sdk/WebViewClient:shouldInterceptRequest	(Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   1192: areturn
    //   1193: astore_2
    //   1194: aload_1
    //   1195: astore 6
    //   1197: aload_2
    //   1198: astore_1
    //   1199: goto -750 -> 449
    //   1202: astore 7
    //   1204: aconst_null
    //   1205: astore 6
    //   1207: aload_1
    //   1208: astore_2
    //   1209: aload 6
    //   1211: astore_1
    //   1212: goto -821 -> 391
    //   1215: astore 7
    //   1217: aload_1
    //   1218: astore 6
    //   1220: aload_2
    //   1221: astore_1
    //   1222: aload 6
    //   1224: astore_2
    //   1225: goto -834 -> 391
    //   1228: aconst_null
    //   1229: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1230	0	this	2
    //   0	1230	1	paramWebView	WebView
    //   0	1230	2	paramWebResourceRequest	WebResourceRequest
    //   10	362	3	i	int
    //   7	328	4	j	int
    //   518	194	5	bool	boolean
    //   56	1167	6	localObject1	java.lang.Object
    //   1	364	7	localObject2	java.lang.Object
    //   384	27	7	localException1	java.lang.Exception
    //   876	268	7	localHttpURLConnection	java.net.HttpURLConnection
    //   1202	1	7	localException2	java.lang.Exception
    //   1215	1	7	localException3	java.lang.Exception
    //   4	385	8	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   104	114	384	java/lang/Exception
    //   118	129	384	java/lang/Exception
    //   133	147	384	java/lang/Exception
    //   151	157	384	java/lang/Exception
    //   161	165	384	java/lang/Exception
    //   169	182	384	java/lang/Exception
    //   186	196	384	java/lang/Exception
    //   200	209	384	java/lang/Exception
    //   213	226	384	java/lang/Exception
    //   230	254	384	java/lang/Exception
    //   303	309	384	java/lang/Exception
    //   313	317	384	java/lang/Exception
    //   321	334	384	java/lang/Exception
    //   341	351	384	java/lang/Exception
    //   355	364	384	java/lang/Exception
    //   368	381	384	java/lang/Exception
    //   428	432	434	java/io/IOException
    //   289	293	441	java/io/IOException
    //   104	114	448	finally
    //   118	129	448	finally
    //   133	147	448	finally
    //   151	157	448	finally
    //   161	165	448	finally
    //   169	182	448	finally
    //   186	196	448	finally
    //   200	209	448	finally
    //   213	226	448	finally
    //   230	254	448	finally
    //   303	309	448	finally
    //   313	317	448	finally
    //   321	334	448	finally
    //   341	351	448	finally
    //   355	364	448	finally
    //   368	381	448	finally
    //   394	421	448	finally
    //   454	459	461	java/io/IOException
    //   812	915	960	java/lang/Exception
    //   915	957	960	java/lang/Exception
    //   974	990	960	java/lang/Exception
    //   996	1004	960	java/lang/Exception
    //   1006	1048	960	java/lang/Exception
    //   1048	1152	960	java/lang/Exception
    //   254	267	1193	finally
    //   267	282	1193	finally
    //   254	267	1202	java/lang/Exception
    //   267	282	1215	java/lang/Exception
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.PageWebview.2
 * JD-Core Version:    0.7.0.1
 */