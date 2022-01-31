package com.tencent.mobileqq.mini.appbrand.page;

import baip;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
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
    if (baip.a(PageWebview.access$200(this.this$0))) {
      PageWebview.access$202(this.this$0, AppLoaderFactory.getAppLoaderManager().waWebviewJsStr());
    }
    if (baip.a(PageWebview.access$300(this.this$0))) {
      PageWebview.access$302(this.this$0, AppLoaderFactory.getAppLoaderManager().waRemoteDebugJsStr());
    }
    QLog.i("miniapp-start", 1, "---PageWebView begin run js defaultConfig --- webviewid:" + this.this$0.pageWebviewId);
    PageWebview.access$400(this.this$0, 18);
    this.this$0.initJSDefaultConfig();
    QLog.i("miniapp-start", 1, "---PageWebView begin load wawebview --- webviewid:" + this.this$0.pageWebviewId);
    PageWebview.access$800(this.this$0, PageWebview.access$200(this.this$0) + PageWebview.access$300(this.this$0), new PageWebview.2.1(this));
  }
  
  /* Error */
  public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_3
    //   8: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +33 -> 44
    //   14: ldc 117
    //   16: iconst_2
    //   17: new 28	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   24: ldc 119
    //   26: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokeinterface 125 1 0
    //   35: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_2
    //   45: invokeinterface 125 1 0
    //   50: invokevirtual 131	android/net/Uri:toString	()Ljava/lang/String;
    //   53: astore 7
    //   55: aload 7
    //   57: ldc 133
    //   59: invokevirtual 138	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   62: ifeq +533 -> 595
    //   65: aload 7
    //   67: ldc 140
    //   69: invokevirtual 143	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   72: ifeq +339 -> 411
    //   75: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +12 -> 90
    //   81: invokestatic 146	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   84: iconst_2
    //   85: ldc 148
    //   87: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: invokestatic 154	com/tencent/mobileqq/mini/apkg/ApkgManager:getInstance	()Lcom/tencent/mobileqq/mini/apkg/ApkgManager;
    //   93: invokevirtual 157	com/tencent/mobileqq/mini/apkg/ApkgManager:getBasePageFrameStr	()Ljava/lang/String;
    //   96: astore_1
    //   97: aload_0
    //   98: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   101: invokestatic 161	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   104: ifnull +14 -> 118
    //   107: aload_0
    //   108: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   111: invokestatic 161	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   114: arraylength
    //   115: ifne +150 -> 265
    //   118: aload_0
    //   119: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   122: aload_1
    //   123: ldc 163
    //   125: invokevirtual 167	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   128: invokestatic 171	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$102	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;[B)[B
    //   131: pop
    //   132: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +52 -> 187
    //   138: invokestatic 146	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   141: astore_1
    //   142: new 28	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   149: ldc 173
    //   151: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   159: invokestatic 161	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   162: ifnull +12 -> 174
    //   165: aload_0
    //   166: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   169: invokestatic 161	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   172: arraylength
    //   173: istore_3
    //   174: aload_1
    //   175: iconst_2
    //   176: aload_2
    //   177: iload_3
    //   178: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: new 175	java/io/ByteArrayInputStream
    //   190: dup
    //   191: aload_0
    //   192: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   195: invokestatic 161	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   198: iconst_0
    //   199: aload_0
    //   200: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   203: invokestatic 161	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   206: arraylength
    //   207: invokespecial 178	java/io/ByteArrayInputStream:<init>	([BII)V
    //   210: astore_2
    //   211: aload_2
    //   212: astore 6
    //   214: new 180	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   217: dup
    //   218: ldc 182
    //   220: ldc 163
    //   222: aload_2
    //   223: invokespecial 185	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   226: astore_1
    //   227: aload_2
    //   228: astore 6
    //   230: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +15 -> 248
    //   236: aload_2
    //   237: astore 6
    //   239: invokestatic 146	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   242: iconst_2
    //   243: ldc 187
    //   245: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aload_1
    //   249: astore 6
    //   251: aload_2
    //   252: ifnull +10 -> 262
    //   255: aload_2
    //   256: invokevirtual 190	java/io/ByteArrayInputStream:close	()V
    //   259: aload_1
    //   260: astore 6
    //   262: aload 6
    //   264: areturn
    //   265: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -81 -> 187
    //   271: invokestatic 146	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   274: astore_1
    //   275: new 28	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   282: ldc 192
    //   284: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: astore_2
    //   288: iload 4
    //   290: istore_3
    //   291: aload_0
    //   292: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   295: invokestatic 161	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   298: ifnull +12 -> 310
    //   301: aload_0
    //   302: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   305: invokestatic 161	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$100	(Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;)[B
    //   308: arraylength
    //   309: istore_3
    //   310: aload_1
    //   311: iconst_2
    //   312: aload_2
    //   313: iload_3
    //   314: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: goto -136 -> 187
    //   326: astore 7
    //   328: aconst_null
    //   329: astore_2
    //   330: aconst_null
    //   331: astore_1
    //   332: aload_2
    //   333: astore 6
    //   335: invokestatic 146	com/tencent/mobileqq/mini/appbrand/page/PageWebview:access$000	()Ljava/lang/String;
    //   338: iconst_2
    //   339: new 28	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   346: ldc 194
    //   348: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 7
    //   353: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload_1
    //   363: astore 6
    //   365: aload_2
    //   366: ifnull -104 -> 262
    //   369: aload_2
    //   370: invokevirtual 190	java/io/ByteArrayInputStream:close	()V
    //   373: aload_1
    //   374: areturn
    //   375: astore_2
    //   376: aload_2
    //   377: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   380: aload_1
    //   381: areturn
    //   382: astore_2
    //   383: aload_2
    //   384: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   387: aload_1
    //   388: areturn
    //   389: astore_1
    //   390: aload 6
    //   392: astore_2
    //   393: aload_2
    //   394: ifnull +7 -> 401
    //   397: aload_2
    //   398: invokevirtual 190	java/io/ByteArrayInputStream:close	()V
    //   401: aload_1
    //   402: athrow
    //   403: astore_2
    //   404: aload_2
    //   405: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   408: goto -7 -> 401
    //   411: aload 7
    //   413: invokestatic 205	com/tencent/mobileqq/mini/util/ImageUtil:isJpgFile	(Ljava/lang/String;)Z
    //   416: ifne +11 -> 427
    //   419: aload 7
    //   421: invokestatic 208	com/tencent/mobileqq/mini/util/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   424: ifeq +79 -> 503
    //   427: aload_0
    //   428: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   431: getfield 212	com/tencent/mobileqq/mini/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   434: ifnonnull +10 -> 444
    //   437: aload_0
    //   438: aload_1
    //   439: aload_2
    //   440: invokespecial 214	com/tencent/smtt/sdk/WebViewClient:shouldInterceptRequest	(Lcom/tencent/smtt/sdk/WebView;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   443: areturn
    //   444: aload 7
    //   446: ldc 133
    //   448: invokevirtual 218	java/lang/String:length	()I
    //   451: invokevirtual 222	java/lang/String:substring	(I)Ljava/lang/String;
    //   454: astore_2
    //   455: aload 7
    //   457: invokestatic 208	com/tencent/mobileqq/mini/util/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   460: istore 5
    //   462: iload 5
    //   464: ifeq +33 -> 497
    //   467: ldc 224
    //   469: astore_1
    //   470: new 180	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   473: dup
    //   474: aload_1
    //   475: ldc 163
    //   477: aload_0
    //   478: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   481: getfield 212	com/tencent/mobileqq/mini/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   484: aload_2
    //   485: invokevirtual 230	com/tencent/mobileqq/mini/apkg/ApkgInfo:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   488: iload 5
    //   490: invokestatic 234	com/tencent/mobileqq/mini/util/ImageUtil:getLocalImageStream	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   493: invokespecial 185	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   496: areturn
    //   497: ldc 236
    //   499: astore_1
    //   500: goto -30 -> 470
    //   503: aload 7
    //   505: ldc 238
    //   507: invokevirtual 143	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   510: ifne +13 -> 523
    //   513: aload 7
    //   515: ldc 240
    //   517: invokevirtual 143	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   520: ifeq +235 -> 755
    //   523: aload_0
    //   524: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   527: getfield 212	com/tencent/mobileqq/mini/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   530: ifnonnull +10 -> 540
    //   533: aload_0
    //   534: aload_1
    //   535: aload_2
    //   536: invokespecial 214	com/tencent/smtt/sdk/WebViewClient:shouldInterceptRequest	(Lcom/tencent/smtt/sdk/WebView;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   539: areturn
    //   540: aload 7
    //   542: ldc 133
    //   544: invokevirtual 218	java/lang/String:length	()I
    //   547: invokevirtual 222	java/lang/String:substring	(I)Ljava/lang/String;
    //   550: astore_2
    //   551: aload 7
    //   553: ldc 238
    //   555: invokevirtual 143	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   558: ifeq +31 -> 589
    //   561: ldc 242
    //   563: astore_1
    //   564: new 180	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   567: dup
    //   568: aload_1
    //   569: ldc 163
    //   571: aload_0
    //   572: getfield 10	com/tencent/mobileqq/mini/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   575: getfield 212	com/tencent/mobileqq/mini/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   578: aload_2
    //   579: invokevirtual 230	com/tencent/mobileqq/mini/apkg/ApkgInfo:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   582: invokestatic 246	com/tencent/mobileqq/mini/util/ImageUtil:getLocalNoBitmapImageStream	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   585: invokespecial 185	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   588: areturn
    //   589: ldc 248
    //   591: astore_1
    //   592: goto -28 -> 564
    //   595: aload 7
    //   597: getstatic 254	com/tencent/mobileqq/mini/utils/MiniAppGlobal:STR_WXFILE	Ljava/lang/String;
    //   600: invokevirtual 138	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   603: ifeq +125 -> 728
    //   606: aload 7
    //   608: invokestatic 205	com/tencent/mobileqq/mini/util/ImageUtil:isJpgFile	(Ljava/lang/String;)Z
    //   611: ifne +11 -> 622
    //   614: aload 7
    //   616: invokestatic 208	com/tencent/mobileqq/mini/util/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   619: ifeq +48 -> 667
    //   622: aload 7
    //   624: invokestatic 208	com/tencent/mobileqq/mini/util/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   627: istore 5
    //   629: iload 5
    //   631: ifeq +30 -> 661
    //   634: ldc 224
    //   636: astore_1
    //   637: new 180	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   640: dup
    //   641: aload_1
    //   642: ldc 163
    //   644: invokestatic 259	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   647: aload 7
    //   649: invokevirtual 262	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   652: iload 5
    //   654: invokestatic 234	com/tencent/mobileqq/mini/util/ImageUtil:getLocalImageStream	(Ljava/lang/String;Z)Ljava/io/InputStream;
    //   657: invokespecial 185	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   660: areturn
    //   661: ldc 236
    //   663: astore_1
    //   664: goto -27 -> 637
    //   667: aload 7
    //   669: ldc 238
    //   671: invokevirtual 143	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   674: ifne +13 -> 687
    //   677: aload 7
    //   679: ldc 240
    //   681: invokevirtual 143	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   684: ifeq +71 -> 755
    //   687: aload 7
    //   689: ldc 238
    //   691: invokevirtual 143	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   694: ifeq +28 -> 722
    //   697: ldc 242
    //   699: astore_1
    //   700: new 180	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   703: dup
    //   704: aload_1
    //   705: ldc 163
    //   707: invokestatic 259	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   710: aload 7
    //   712: invokevirtual 262	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   715: invokestatic 246	com/tencent/mobileqq/mini/util/ImageUtil:getLocalNoBitmapImageStream	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   718: invokespecial 185	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   721: areturn
    //   722: ldc 248
    //   724: astore_1
    //   725: goto -25 -> 700
    //   728: aload_0
    //   729: aload_1
    //   730: aload 7
    //   732: invokespecial 265	com/tencent/smtt/sdk/WebViewClient:shouldInterceptRequest	(Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   735: areturn
    //   736: astore_1
    //   737: aload 6
    //   739: astore_2
    //   740: goto -347 -> 393
    //   743: astore 7
    //   745: aconst_null
    //   746: astore_1
    //   747: goto -415 -> 332
    //   750: astore 7
    //   752: goto -420 -> 332
    //   755: aconst_null
    //   756: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	757	0	this	2
    //   0	757	1	paramWebView	WebView
    //   0	757	2	paramWebResourceRequest	WebResourceRequest
    //   7	307	3	i	int
    //   4	285	4	j	int
    //   460	193	5	bool	boolean
    //   1	737	6	localObject	java.lang.Object
    //   53	13	7	str	String
    //   326	405	7	localException1	java.lang.Exception
    //   743	1	7	localException2	java.lang.Exception
    //   750	1	7	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   97	118	326	java/lang/Exception
    //   118	155	326	java/lang/Exception
    //   155	174	326	java/lang/Exception
    //   174	187	326	java/lang/Exception
    //   187	211	326	java/lang/Exception
    //   265	288	326	java/lang/Exception
    //   291	310	326	java/lang/Exception
    //   310	323	326	java/lang/Exception
    //   369	373	375	java/io/IOException
    //   255	259	382	java/io/IOException
    //   97	118	389	finally
    //   118	155	389	finally
    //   155	174	389	finally
    //   174	187	389	finally
    //   187	211	389	finally
    //   265	288	389	finally
    //   291	310	389	finally
    //   310	323	389	finally
    //   397	401	403	java/io/IOException
    //   214	227	736	finally
    //   230	236	736	finally
    //   239	248	736	finally
    //   335	362	736	finally
    //   214	227	743	java/lang/Exception
    //   230	236	750	java/lang/Exception
    //   239	248	750	java/lang/Exception
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.PageWebview.2
 * JD-Core Version:    0.7.0.1
 */