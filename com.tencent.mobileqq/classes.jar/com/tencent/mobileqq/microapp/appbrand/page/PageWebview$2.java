package com.tencent.mobileqq.microapp.appbrand.page;

import bdnn;
import com.tencent.mobileqq.microapp.apkg.f;
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
      QLog.d(PageWebview.access$100(), 2, "---finish loadHtml---");
    }
    if (bdnn.a(PageWebview.access$300(this.this$0))) {
      PageWebview.access$302(this.this$0, this.this$0.apkgInfo.f());
    }
    this.this$0.evaluteJs(PageWebview.access$300(this.this$0), new PageWebview.2.1(this));
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
    //   14: ldc 76
    //   16: iconst_2
    //   17: new 78	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   24: ldc 81
    //   26: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokeinterface 91 1 0
    //   35: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   48: getfield 50	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/microapp/apkg/f;
    //   51: ifnonnull +12 -> 63
    //   54: aload_0
    //   55: aload_1
    //   56: aload_2
    //   57: invokespecial 102	com/tencent/smtt/sdk/WebViewClient:shouldInterceptRequest	(Lcom/tencent/smtt/sdk/WebView;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   60: astore_2
    //   61: aload_2
    //   62: areturn
    //   63: aload_2
    //   64: invokeinterface 91 1 0
    //   69: invokevirtual 105	android/net/Uri:toString	()Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: ldc 107
    //   76: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   79: ifeq +499 -> 578
    //   82: aload_2
    //   83: ldc 114
    //   85: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   88: ifeq +344 -> 432
    //   91: aload_0
    //   92: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   95: getfield 50	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/microapp/apkg/f;
    //   98: invokevirtual 120	com/tencent/mobileqq/microapp/apkg/f:d	()Lcom/tencent/mobileqq/microapp/b/a;
    //   101: astore 7
    //   103: aload_0
    //   104: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   107: invokestatic 124	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   110: ifnull +14 -> 124
    //   113: aload_0
    //   114: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   117: invokestatic 124	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   120: arraylength
    //   121: ifne +192 -> 313
    //   124: aload_0
    //   125: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   128: aload 7
    //   130: getfield 129	com/tencent/mobileqq/microapp/b/a:a	Ljava/lang/String;
    //   133: ldc 131
    //   135: invokevirtual 135	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   138: invokestatic 139	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$002	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;[B)[B
    //   141: pop
    //   142: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +52 -> 197
    //   148: invokestatic 30	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$100	()Ljava/lang/String;
    //   151: astore_1
    //   152: new 78	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   159: ldc 141
    //   161: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: astore_2
    //   165: aload_0
    //   166: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   169: invokestatic 124	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   172: ifnull +12 -> 184
    //   175: aload_0
    //   176: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   179: invokestatic 124	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   182: arraylength
    //   183: istore_3
    //   184: aload_1
    //   185: iconst_2
    //   186: aload_2
    //   187: iload_3
    //   188: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: new 146	java/io/ByteArrayInputStream
    //   200: dup
    //   201: aload_0
    //   202: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   205: invokestatic 124	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   208: iconst_0
    //   209: aload_0
    //   210: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   213: invokestatic 124	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   216: arraylength
    //   217: invokespecial 149	java/io/ByteArrayInputStream:<init>	([BII)V
    //   220: astore 5
    //   222: aload 5
    //   224: astore_2
    //   225: new 151	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   228: dup
    //   229: ldc 153
    //   231: ldc 131
    //   233: aload 5
    //   235: invokespecial 156	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   238: astore_1
    //   239: aload 5
    //   241: astore_2
    //   242: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +15 -> 260
    //   248: aload 5
    //   250: astore_2
    //   251: invokestatic 30	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$100	()Ljava/lang/String;
    //   254: iconst_2
    //   255: ldc 158
    //   257: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload 5
    //   262: astore_2
    //   263: aload_0
    //   264: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   267: invokestatic 161	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$200	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)Ljava/lang/String;
    //   270: invokestatic 46	bdnn:a	(Ljava/lang/String;)Z
    //   273: ifeq +19 -> 292
    //   276: aload 5
    //   278: astore_2
    //   279: aload_0
    //   280: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   283: aload 7
    //   285: getfield 164	com/tencent/mobileqq/microapp/b/a:b	Ljava/lang/String;
    //   288: invokestatic 167	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$202	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;Ljava/lang/String;)Ljava/lang/String;
    //   291: pop
    //   292: aload_1
    //   293: astore_2
    //   294: aload 5
    //   296: ifnull -235 -> 61
    //   299: aload 5
    //   301: invokevirtual 170	java/io/ByteArrayInputStream:close	()V
    //   304: aload_1
    //   305: areturn
    //   306: astore_2
    //   307: aload_2
    //   308: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   311: aload_1
    //   312: areturn
    //   313: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq -119 -> 197
    //   319: invokestatic 30	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$100	()Ljava/lang/String;
    //   322: astore_1
    //   323: new 78	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   330: ldc 175
    //   332: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: astore_2
    //   336: iload 4
    //   338: istore_3
    //   339: aload_0
    //   340: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   343: invokestatic 124	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   346: ifnull +12 -> 358
    //   349: aload_0
    //   350: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   353: invokestatic 124	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:access$000	(Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;)[B
    //   356: arraylength
    //   357: istore_3
    //   358: aload_1
    //   359: iconst_2
    //   360: aload_2
    //   361: iload_3
    //   362: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   365: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: goto -174 -> 197
    //   374: astore 6
    //   376: aconst_null
    //   377: astore 5
    //   379: aconst_null
    //   380: astore_1
    //   381: aload 5
    //   383: astore_2
    //   384: aload 6
    //   386: invokevirtual 176	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   389: aload_1
    //   390: astore_2
    //   391: aload 5
    //   393: ifnull -332 -> 61
    //   396: aload 5
    //   398: invokevirtual 170	java/io/ByteArrayInputStream:close	()V
    //   401: aload_1
    //   402: areturn
    //   403: astore_2
    //   404: aload_2
    //   405: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   408: aload_1
    //   409: areturn
    //   410: astore_1
    //   411: aload 6
    //   413: astore_2
    //   414: aload_2
    //   415: ifnull +7 -> 422
    //   418: aload_2
    //   419: invokevirtual 170	java/io/ByteArrayInputStream:close	()V
    //   422: aload_1
    //   423: athrow
    //   424: astore_2
    //   425: aload_2
    //   426: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   429: goto -7 -> 422
    //   432: aload_2
    //   433: ldc 178
    //   435: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   438: ifne +12 -> 450
    //   441: aload_2
    //   442: ldc 180
    //   444: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   447: ifeq +58 -> 505
    //   450: aload_2
    //   451: ldc 107
    //   453: invokevirtual 184	java/lang/String:length	()I
    //   456: invokevirtual 188	java/lang/String:substring	(I)Ljava/lang/String;
    //   459: astore 5
    //   461: aload_2
    //   462: ldc 178
    //   464: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   467: ifeq +32 -> 499
    //   470: ldc 190
    //   472: astore_1
    //   473: new 151	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   476: dup
    //   477: aload_1
    //   478: ldc 131
    //   480: aload_0
    //   481: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   484: getfield 50	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/microapp/apkg/f;
    //   487: aload 5
    //   489: invokevirtual 194	com/tencent/mobileqq/microapp/apkg/f:j	(Ljava/lang/String;)Ljava/lang/String;
    //   492: invokestatic 198	com/tencent/mobileqq/microapp/b/a:k	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   495: invokespecial 156	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   498: areturn
    //   499: ldc 200
    //   501: astore_1
    //   502: goto -29 -> 473
    //   505: aload_2
    //   506: ldc 202
    //   508: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   511: ifne +12 -> 523
    //   514: aload_2
    //   515: ldc 204
    //   517: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   520: ifeq +204 -> 724
    //   523: aload_2
    //   524: ldc 107
    //   526: invokevirtual 184	java/lang/String:length	()I
    //   529: invokevirtual 188	java/lang/String:substring	(I)Ljava/lang/String;
    //   532: astore 5
    //   534: aload_2
    //   535: ldc 202
    //   537: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   540: ifeq +32 -> 572
    //   543: ldc 206
    //   545: astore_1
    //   546: new 151	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   549: dup
    //   550: aload_1
    //   551: ldc 131
    //   553: aload_0
    //   554: getfield 10	com/tencent/mobileqq/microapp/appbrand/page/PageWebview$2:this$0	Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   557: getfield 50	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:apkgInfo	Lcom/tencent/mobileqq/microapp/apkg/f;
    //   560: aload 5
    //   562: invokevirtual 194	com/tencent/mobileqq/microapp/apkg/f:j	(Ljava/lang/String;)Ljava/lang/String;
    //   565: invokestatic 208	com/tencent/mobileqq/microapp/b/a:j	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   568: invokespecial 156	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   571: areturn
    //   572: ldc 210
    //   574: astore_1
    //   575: goto -29 -> 546
    //   578: aload_2
    //   579: ldc 212
    //   581: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   584: ifeq +117 -> 701
    //   587: aload_2
    //   588: ldc 178
    //   590: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   593: ifne +12 -> 605
    //   596: aload_2
    //   597: ldc 180
    //   599: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   602: ifeq +42 -> 644
    //   605: aload_2
    //   606: ldc 178
    //   608: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   611: ifeq +27 -> 638
    //   614: ldc 190
    //   616: astore_1
    //   617: new 151	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   620: dup
    //   621: aload_1
    //   622: ldc 131
    //   624: invokestatic 217	com/tencent/mobileqq/microapp/appbrand/utils/b:a	()Lcom/tencent/mobileqq/microapp/appbrand/utils/b;
    //   627: aload_2
    //   628: invokevirtual 219	com/tencent/mobileqq/microapp/appbrand/utils/b:d	(Ljava/lang/String;)Ljava/lang/String;
    //   631: invokestatic 198	com/tencent/mobileqq/microapp/b/a:k	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   634: invokespecial 156	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   637: areturn
    //   638: ldc 200
    //   640: astore_1
    //   641: goto -24 -> 617
    //   644: aload_2
    //   645: ldc 202
    //   647: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   650: ifne +12 -> 662
    //   653: aload_2
    //   654: ldc 204
    //   656: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   659: ifeq +65 -> 724
    //   662: aload_2
    //   663: ldc 202
    //   665: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   668: ifeq +27 -> 695
    //   671: ldc 206
    //   673: astore_1
    //   674: new 151	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   677: dup
    //   678: aload_1
    //   679: ldc 131
    //   681: invokestatic 217	com/tencent/mobileqq/microapp/appbrand/utils/b:a	()Lcom/tencent/mobileqq/microapp/appbrand/utils/b;
    //   684: aload_2
    //   685: invokevirtual 219	com/tencent/mobileqq/microapp/appbrand/utils/b:d	(Ljava/lang/String;)Ljava/lang/String;
    //   688: invokestatic 208	com/tencent/mobileqq/microapp/b/a:j	(Ljava/lang/String;)Ljava/io/ByteArrayInputStream;
    //   691: invokespecial 156	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   694: areturn
    //   695: ldc 210
    //   697: astore_1
    //   698: goto -24 -> 674
    //   701: aload_0
    //   702: aload_1
    //   703: aload_2
    //   704: invokespecial 222	com/tencent/smtt/sdk/WebViewClient:shouldInterceptRequest	(Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   707: areturn
    //   708: astore_1
    //   709: goto -295 -> 414
    //   712: astore 6
    //   714: aconst_null
    //   715: astore_1
    //   716: goto -335 -> 381
    //   719: astore 6
    //   721: goto -340 -> 381
    //   724: aconst_null
    //   725: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	this	2
    //   0	726	1	paramWebView	WebView
    //   0	726	2	paramWebResourceRequest	WebResourceRequest
    //   7	355	3	i	int
    //   4	333	4	j	int
    //   220	341	5	localObject1	java.lang.Object
    //   1	1	6	localObject2	java.lang.Object
    //   374	38	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   712	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   719	1	6	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   101	183	7	locala	com.tencent.mobileqq.microapp.b.a
    // Exception table:
    //   from	to	target	type
    //   299	304	306	java/io/IOException
    //   103	124	374	java/io/UnsupportedEncodingException
    //   124	165	374	java/io/UnsupportedEncodingException
    //   165	184	374	java/io/UnsupportedEncodingException
    //   184	197	374	java/io/UnsupportedEncodingException
    //   197	222	374	java/io/UnsupportedEncodingException
    //   313	336	374	java/io/UnsupportedEncodingException
    //   339	358	374	java/io/UnsupportedEncodingException
    //   358	371	374	java/io/UnsupportedEncodingException
    //   396	401	403	java/io/IOException
    //   103	124	410	finally
    //   124	165	410	finally
    //   165	184	410	finally
    //   184	197	410	finally
    //   197	222	410	finally
    //   313	336	410	finally
    //   339	358	410	finally
    //   358	371	410	finally
    //   418	422	424	java/io/IOException
    //   225	239	708	finally
    //   242	248	708	finally
    //   251	260	708	finally
    //   263	276	708	finally
    //   279	292	708	finally
    //   384	389	708	finally
    //   225	239	712	java/io/UnsupportedEncodingException
    //   242	248	719	java/io/UnsupportedEncodingException
    //   251	260	719	java/io/UnsupportedEncodingException
    //   263	276	719	java/io/UnsupportedEncodingException
    //   279	292	719	java/io/UnsupportedEncodingException
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.PageWebview.2
 * JD-Core Version:    0.7.0.1
 */