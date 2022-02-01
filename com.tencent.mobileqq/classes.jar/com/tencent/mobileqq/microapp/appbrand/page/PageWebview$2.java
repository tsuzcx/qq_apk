package com.tencent.mobileqq.microapp.appbrand.page;

import android.graphics.Bitmap;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
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
      QLog.d(PageWebview.access$100(), 2, "---finish loadHtml---");
    }
    if (StringUtil.a(PageWebview.access$300(this.this$0)))
    {
      paramWebView = this.this$0;
      PageWebview.access$302(paramWebView, paramWebView.apkgInfo$5475ea27.e());
    }
    paramWebView = this.this$0;
    paramWebView.evaluteJs(PageWebview.access$300(paramWebView), new PageWebview.2.1(this));
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  /* Error */
  public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    // Byte code:
    //   0: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: new 91	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: ldc 94
    //   19: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 5
    //   25: aload_2
    //   26: invokeinterface 104 1 0
    //   31: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: ldc 109
    //   37: iconst_2
    //   38: aload 5
    //   40: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   50: getfield 50	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:apkgInfo$5475ea27	Lcom/tencent/mobileqq/microapp/a/c;
    //   53: ifnonnull +10 -> 63
    //   56: aload_0
    //   57: aload_1
    //   58: aload_2
    //   59: invokespecial 117	com/tencent/smtt/sdk/WebViewClient:shouldInterceptRequest	(Lcom/tencent/smtt/sdk/WebView;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   62: areturn
    //   63: aload_2
    //   64: invokeinterface 104 1 0
    //   69: invokevirtual 120	android/net/Uri:toString	()Ljava/lang/String;
    //   72: astore 9
    //   74: aload 9
    //   76: ldc 122
    //   78: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   81: istore 4
    //   83: ldc 129
    //   85: astore_2
    //   86: ldc 131
    //   88: astore 5
    //   90: aconst_null
    //   91: astore 7
    //   93: aconst_null
    //   94: astore 8
    //   96: aconst_null
    //   97: astore 6
    //   99: iload 4
    //   101: ifeq +586 -> 687
    //   104: aload 9
    //   106: ldc 133
    //   108: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   111: ifeq +430 -> 541
    //   114: aload_0
    //   115: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   118: getfield 50	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:apkgInfo$5475ea27	Lcom/tencent/mobileqq/microapp/a/c;
    //   121: invokevirtual 140	com/tencent/mobileqq/microapp/a/c:c	()Lcom/tencent/mobileqq/microapp/apkg/f;
    //   124: astore 8
    //   126: aload 6
    //   128: astore_2
    //   129: aload_0
    //   130: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   133: invokestatic 144	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   136: ifnull +113 -> 249
    //   139: aload 6
    //   141: astore_2
    //   142: aload_0
    //   143: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   146: invokestatic 144	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   149: arraylength
    //   150: ifne +6 -> 156
    //   153: goto +96 -> 249
    //   156: aload 6
    //   158: astore_2
    //   159: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +198 -> 360
    //   165: aload 6
    //   167: astore_2
    //   168: invokestatic 30	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$100	()Ljava/lang/String;
    //   171: astore_1
    //   172: aload 6
    //   174: astore_2
    //   175: new 91	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   182: astore 5
    //   184: aload 6
    //   186: astore_2
    //   187: aload 5
    //   189: ldc 146
    //   191: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 6
    //   197: astore_2
    //   198: aload_0
    //   199: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   202: invokestatic 144	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   205: ifnull +626 -> 831
    //   208: aload 6
    //   210: astore_2
    //   211: aload_0
    //   212: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   215: invokestatic 144	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   218: arraylength
    //   219: istore_3
    //   220: goto +3 -> 223
    //   223: aload 6
    //   225: astore_2
    //   226: aload 5
    //   228: iload_3
    //   229: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 6
    //   235: astore_2
    //   236: aload_1
    //   237: iconst_2
    //   238: aload 5
    //   240: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: goto +114 -> 360
    //   249: aload 6
    //   251: astore_2
    //   252: aload_0
    //   253: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   256: aload 8
    //   258: getfield 154	com/tencent/mobileqq/microapp/apkg/f:a	Ljava/lang/String;
    //   261: ldc 156
    //   263: invokevirtual 160	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   266: invokestatic 164	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$002	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;[B)[B
    //   269: pop
    //   270: aload 6
    //   272: astore_2
    //   273: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +84 -> 360
    //   279: aload 6
    //   281: astore_2
    //   282: invokestatic 30	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$100	()Ljava/lang/String;
    //   285: astore_1
    //   286: aload 6
    //   288: astore_2
    //   289: new 91	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   296: astore 5
    //   298: aload 6
    //   300: astore_2
    //   301: aload 5
    //   303: ldc 166
    //   305: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 6
    //   311: astore_2
    //   312: aload_0
    //   313: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   316: invokestatic 144	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   319: ifnull +517 -> 836
    //   322: aload 6
    //   324: astore_2
    //   325: aload_0
    //   326: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   329: invokestatic 144	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   332: arraylength
    //   333: istore_3
    //   334: goto +3 -> 337
    //   337: aload 6
    //   339: astore_2
    //   340: aload 5
    //   342: iload_3
    //   343: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 6
    //   349: astore_2
    //   350: aload_1
    //   351: iconst_2
    //   352: aload 5
    //   354: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload 6
    //   362: astore_2
    //   363: new 168	java/io/ByteArrayInputStream
    //   366: dup
    //   367: aload_0
    //   368: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   371: invokestatic 144	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   374: iconst_0
    //   375: aload_0
    //   376: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   379: invokestatic 144	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   382: arraylength
    //   383: invokespecial 171	java/io/ByteArrayInputStream:<init>	([BII)V
    //   386: astore 5
    //   388: new 173	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   391: dup
    //   392: ldc 175
    //   394: ldc 156
    //   396: aload 5
    //   398: invokespecial 178	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   401: astore_1
    //   402: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +12 -> 417
    //   408: invokestatic 30	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$100	()Ljava/lang/String;
    //   411: iconst_2
    //   412: ldc 180
    //   414: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_0
    //   418: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   421: invokestatic 183	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$200	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)Ljava/lang/String;
    //   424: invokestatic 46	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   427: ifeq +16 -> 443
    //   430: aload_0
    //   431: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   434: aload 8
    //   436: getfield 186	com/tencent/mobileqq/microapp/apkg/f:b	Ljava/lang/String;
    //   439: invokestatic 189	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$202	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;Ljava/lang/String;)Ljava/lang/String;
    //   442: pop
    //   443: aload 5
    //   445: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   448: aload_1
    //   449: astore_2
    //   450: goto +71 -> 521
    //   453: astore_2
    //   454: goto +61 -> 515
    //   457: astore_2
    //   458: goto +13 -> 471
    //   461: astore_1
    //   462: aload 5
    //   464: astore_2
    //   465: goto +58 -> 523
    //   468: astore_2
    //   469: aconst_null
    //   470: astore_1
    //   471: aload_2
    //   472: astore 6
    //   474: goto +15 -> 489
    //   477: astore_1
    //   478: goto +45 -> 523
    //   481: astore 6
    //   483: aconst_null
    //   484: astore_1
    //   485: aload 7
    //   487: astore 5
    //   489: aload 5
    //   491: astore_2
    //   492: aload 6
    //   494: invokevirtual 195	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   497: aload_1
    //   498: astore_2
    //   499: aload 5
    //   501: ifnull +20 -> 521
    //   504: aload 5
    //   506: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   509: aload_1
    //   510: astore_2
    //   511: goto +10 -> 521
    //   514: astore_2
    //   515: aload_2
    //   516: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   519: aload_1
    //   520: astore_2
    //   521: aload_2
    //   522: areturn
    //   523: aload_2
    //   524: ifnull +15 -> 539
    //   527: aload_2
    //   528: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   531: goto +8 -> 539
    //   534: astore_2
    //   535: aload_2
    //   536: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   539: aload_1
    //   540: athrow
    //   541: aload 9
    //   543: ldc 198
    //   545: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   548: ifne +88 -> 636
    //   551: aload 9
    //   553: ldc 200
    //   555: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   558: ifeq +6 -> 564
    //   561: goto +75 -> 636
    //   564: aload 9
    //   566: ldc 202
    //   568: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   571: ifne +16 -> 587
    //   574: aload 8
    //   576: astore_1
    //   577: aload 9
    //   579: ldc 204
    //   581: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   584: ifeq +245 -> 829
    //   587: aload 9
    //   589: bipush 26
    //   591: invokevirtual 208	java/lang/String:substring	(I)Ljava/lang/String;
    //   594: astore_1
    //   595: aload 9
    //   597: ldc 202
    //   599: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   602: ifeq +6 -> 608
    //   605: goto +6 -> 611
    //   608: ldc 210
    //   610: astore_2
    //   611: new 173	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   614: dup
    //   615: aload_2
    //   616: ldc 156
    //   618: aload_0
    //   619: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   622: getfield 50	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:apkgInfo$5475ea27	Lcom/tencent/mobileqq/microapp/a/c;
    //   625: aload_1
    //   626: invokevirtual 214	com/tencent/mobileqq/microapp/a/c:j	(Ljava/lang/String;)Ljava/lang/String;
    //   629: invokestatic 218	com/tencent/mobileqq/microapp/a/c:r	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   632: invokespecial 178	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   635: areturn
    //   636: aload 9
    //   638: bipush 26
    //   640: invokevirtual 208	java/lang/String:substring	(I)Ljava/lang/String;
    //   643: astore_1
    //   644: aload 9
    //   646: ldc 198
    //   648: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   651: ifeq +6 -> 657
    //   654: goto +7 -> 661
    //   657: ldc 220
    //   659: astore 5
    //   661: new 173	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   664: dup
    //   665: aload 5
    //   667: ldc 156
    //   669: aload_0
    //   670: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   673: getfield 50	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:apkgInfo$5475ea27	Lcom/tencent/mobileqq/microapp/a/c;
    //   676: aload_1
    //   677: invokevirtual 214	com/tencent/mobileqq/microapp/a/c:j	(Ljava/lang/String;)Ljava/lang/String;
    //   680: invokestatic 223	com/tencent/mobileqq/microapp/a/c:s	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   683: invokespecial 178	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   686: areturn
    //   687: aload 9
    //   689: ldc 225
    //   691: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   694: ifeq +127 -> 821
    //   697: aload 9
    //   699: ldc 198
    //   701: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   704: ifne +77 -> 781
    //   707: aload 9
    //   709: ldc 200
    //   711: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   714: ifeq +6 -> 720
    //   717: goto +64 -> 781
    //   720: aload 9
    //   722: ldc 202
    //   724: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   727: ifne +16 -> 743
    //   730: aload 8
    //   732: astore_1
    //   733: aload 9
    //   735: ldc 204
    //   737: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   740: ifeq +89 -> 829
    //   743: aload 9
    //   745: ldc 202
    //   747: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   750: ifeq +6 -> 756
    //   753: goto +6 -> 759
    //   756: ldc 210
    //   758: astore_2
    //   759: new 173	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   762: dup
    //   763: aload_2
    //   764: ldc 156
    //   766: invokestatic 230	com/tencent/mobileqq/microapp/appbrand/b/b:a	()Lcom/tencent/mobileqq/microapp/appbrand/b/b;
    //   769: aload 9
    //   771: invokevirtual 232	com/tencent/mobileqq/microapp/appbrand/b/b:c	(Ljava/lang/String;)Ljava/lang/String;
    //   774: invokestatic 218	com/tencent/mobileqq/microapp/a/c:r	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   777: invokespecial 178	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   780: areturn
    //   781: aload 9
    //   783: ldc 198
    //   785: invokevirtual 136	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   788: ifeq +6 -> 794
    //   791: goto +7 -> 798
    //   794: ldc 220
    //   796: astore 5
    //   798: new 173	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   801: dup
    //   802: aload 5
    //   804: ldc 156
    //   806: invokestatic 230	com/tencent/mobileqq/microapp/appbrand/b/b:a	()Lcom/tencent/mobileqq/microapp/appbrand/b/b;
    //   809: aload 9
    //   811: invokevirtual 232	com/tencent/mobileqq/microapp/appbrand/b/b:c	(Ljava/lang/String;)Ljava/lang/String;
    //   814: invokestatic 223	com/tencent/mobileqq/microapp/a/c:s	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   817: invokespecial 178	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   820: areturn
    //   821: aload_0
    //   822: aload_1
    //   823: aload 9
    //   825: invokespecial 235	com/tencent/smtt/sdk/WebViewClient:shouldInterceptRequest	(Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   828: astore_1
    //   829: aload_1
    //   830: areturn
    //   831: iconst_0
    //   832: istore_3
    //   833: goto -610 -> 223
    //   836: iconst_0
    //   837: istore_3
    //   838: goto -501 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	841	0	this	2
    //   0	841	1	paramWebView	WebView
    //   0	841	2	paramWebResourceRequest	WebResourceRequest
    //   219	619	3	i	int
    //   81	19	4	bool	boolean
    //   13	790	5	localObject1	java.lang.Object
    //   97	376	6	localWebResourceRequest	WebResourceRequest
    //   481	12	6	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   91	395	7	localObject2	java.lang.Object
    //   94	637	8	localf	com.tencent.mobileqq.microapp.apkg.f
    //   72	752	9	str	String
    // Exception table:
    //   from	to	target	type
    //   443	448	453	java/io/IOException
    //   402	417	457	java/io/UnsupportedEncodingException
    //   417	443	457	java/io/UnsupportedEncodingException
    //   388	402	461	finally
    //   402	417	461	finally
    //   417	443	461	finally
    //   388	402	468	java/io/UnsupportedEncodingException
    //   129	139	477	finally
    //   142	153	477	finally
    //   159	165	477	finally
    //   168	172	477	finally
    //   175	184	477	finally
    //   187	195	477	finally
    //   198	208	477	finally
    //   211	220	477	finally
    //   226	233	477	finally
    //   236	246	477	finally
    //   252	270	477	finally
    //   273	279	477	finally
    //   282	286	477	finally
    //   289	298	477	finally
    //   301	309	477	finally
    //   312	322	477	finally
    //   325	334	477	finally
    //   340	347	477	finally
    //   350	360	477	finally
    //   363	388	477	finally
    //   492	497	477	finally
    //   129	139	481	java/io/UnsupportedEncodingException
    //   142	153	481	java/io/UnsupportedEncodingException
    //   159	165	481	java/io/UnsupportedEncodingException
    //   168	172	481	java/io/UnsupportedEncodingException
    //   175	184	481	java/io/UnsupportedEncodingException
    //   187	195	481	java/io/UnsupportedEncodingException
    //   198	208	481	java/io/UnsupportedEncodingException
    //   211	220	481	java/io/UnsupportedEncodingException
    //   226	233	481	java/io/UnsupportedEncodingException
    //   236	246	481	java/io/UnsupportedEncodingException
    //   252	270	481	java/io/UnsupportedEncodingException
    //   273	279	481	java/io/UnsupportedEncodingException
    //   282	286	481	java/io/UnsupportedEncodingException
    //   289	298	481	java/io/UnsupportedEncodingException
    //   301	309	481	java/io/UnsupportedEncodingException
    //   312	322	481	java/io/UnsupportedEncodingException
    //   325	334	481	java/io/UnsupportedEncodingException
    //   340	347	481	java/io/UnsupportedEncodingException
    //   350	360	481	java/io/UnsupportedEncodingException
    //   363	388	481	java/io/UnsupportedEncodingException
    //   504	509	514	java/io/IOException
    //   527	531	534	java/io/IOException
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.PageWebview.2
 * JD-Core Version:    0.7.0.1
 */