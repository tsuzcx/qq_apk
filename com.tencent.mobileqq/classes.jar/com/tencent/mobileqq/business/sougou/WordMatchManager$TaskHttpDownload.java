package com.tencent.mobileqq.business.sougou;

public class WordMatchManager$TaskHttpDownload
  implements Runnable
{
  int a = 0;
  
  WordMatchManager$TaskHttpDownload(WordMatchManager paramWordMatchManager, int paramInt)
  {
    this.a = paramInt;
  }
  
  /* Error */
  private java.net.HttpURLConnection a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   4: iload_1
    //   5: invokevirtual 31	com/tencent/mobileqq/business/sougou/WordMatchManager:b	(I)Ljava/lang/String;
    //   8: astore 4
    //   10: new 33	java/net/URL
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 36	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 40	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   24: checkcast 42	java/net/HttpURLConnection
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +42 -> 71
    //   32: aconst_null
    //   33: astore_2
    //   34: aload_2
    //   35: areturn
    //   36: astore_2
    //   37: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +29 -> 69
    //   43: ldc 50
    //   45: iconst_2
    //   46: new 52	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   53: ldc 55
    //   55: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 4
    //   60: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload_3
    //   72: sipush 30000
    //   75: invokevirtual 71	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   78: aload_3
    //   79: aload_0
    //   80: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   83: iload_1
    //   84: invokevirtual 74	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)J
    //   87: invokevirtual 78	java/net/HttpURLConnection:setIfModifiedSince	(J)V
    //   90: aload_3
    //   91: sipush 30000
    //   94: invokevirtual 81	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   97: aload_3
    //   98: ldc 83
    //   100: invokevirtual 86	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   103: aload_3
    //   104: astore_2
    //   105: aload_3
    //   106: invokevirtual 90	java/net/HttpURLConnection:getResponseCode	()I
    //   109: sipush 200
    //   112: if_icmpeq -78 -> 34
    //   115: aload_3
    //   116: invokevirtual 90	java/net/HttpURLConnection:getResponseCode	()I
    //   119: istore_1
    //   120: aload_3
    //   121: astore_2
    //   122: iload_1
    //   123: sipush 206
    //   126: if_icmpeq -92 -> 34
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +29 -> 164
    //   138: ldc 50
    //   140: iconst_2
    //   141: new 52	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   148: ldc 92
    //   150: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 4
    //   155: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aconst_null
    //   165: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	TaskHttpDownload
    //   0	166	1	paramInt	int
    //   19	16	2	localURL	java.net.URL
    //   36	1	2	localMalformedURLException	java.net.MalformedURLException
    //   104	18	2	localObject	Object
    //   131	1	2	localIOException	java.io.IOException
    //   27	94	3	localHttpURLConnection	java.net.HttpURLConnection
    //   8	146	4	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   10	20	36	java/net/MalformedURLException
    //   20	28	131	java/io/IOException
    //   71	103	131	java/io/IOException
    //   105	120	131	java/io/IOException
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 98	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6: ifeq +42 -> 48
    //   9: ldc 50
    //   11: iconst_4
    //   12: new 52	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   19: ldc 100
    //   21: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   28: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 105
    //   33: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   39: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   42: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: invokestatic 118	bfiu:a	()Z
    //   51: ifne +240 -> 291
    //   54: iconst_0
    //   55: istore_2
    //   56: invokestatic 98	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   59: ifeq +51 -> 110
    //   62: ldc 50
    //   64: iconst_4
    //   65: new 52	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   72: ldc 120
    //   74: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   81: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: ldc 122
    //   86: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: iload_2
    //   90: invokevirtual 125	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: ldc 105
    //   95: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   101: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   104: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: iload_2
    //   111: ifeq +644 -> 755
    //   114: aload_0
    //   115: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   118: iconst_1
    //   119: if_icmpne +573 -> 692
    //   122: aload_0
    //   123: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   126: getfield 128	com/tencent/mobileqq/business/sougou/WordMatchManager:jdField_a_of_type_Anym	Lanym;
    //   129: astore_3
    //   130: aload_0
    //   131: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   134: iconst_1
    //   135: putfield 132	com/tencent/mobileqq/business/sougou/WordMatchManager:e	Z
    //   138: aload_0
    //   139: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   142: getfield 128	com/tencent/mobileqq/business/sougou/WordMatchManager:jdField_a_of_type_Anym	Lanym;
    //   145: getfield 137	anym:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   148: astore 4
    //   150: aload 4
    //   152: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +576 -> 731
    //   158: aload_0
    //   159: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   162: iconst_2
    //   163: if_icmpeq +11 -> 174
    //   166: aload_0
    //   167: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   170: iconst_1
    //   171: if_icmpne +560 -> 731
    //   174: aload 4
    //   176: invokevirtual 148	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   179: astore 4
    //   181: aload_0
    //   182: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   185: new 52	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   192: aload_0
    //   193: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   196: aload_0
    //   197: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   200: invokevirtual 150	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   203: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 152
    //   208: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 155	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Lcom/tencent/mobileqq/business/sougou/WordMatchManager;Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 5
    //   219: aload 5
    //   221: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne +16 -> 240
    //   227: aload 5
    //   229: invokevirtual 148	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   232: aload 4
    //   234: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   237: ifne +494 -> 731
    //   240: aload_0
    //   241: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   244: iconst_0
    //   245: invokevirtual 162	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Z)V
    //   248: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +39 -> 290
    //   254: ldc 50
    //   256: iconst_2
    //   257: new 52	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   264: ldc 164
    //   266: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 5
    //   271: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 166
    //   276: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 4
    //   281: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: return
    //   291: new 168	java/io/File
    //   294: dup
    //   295: getstatic 169	com/tencent/mobileqq/business/sougou/WordMatchManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   298: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   301: astore_3
    //   302: aload_3
    //   303: invokevirtual 173	java/io/File:exists	()Z
    //   306: ifne +8 -> 314
    //   309: aload_3
    //   310: invokevirtual 176	java/io/File:mkdir	()Z
    //   313: pop
    //   314: new 52	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   321: aload_0
    //   322: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   325: aload_0
    //   326: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   329: invokevirtual 150	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   332: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc 152
    //   337: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: astore_3
    //   344: new 168	java/io/File
    //   347: dup
    //   348: aload_3
    //   349: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   352: astore 6
    //   354: aload 6
    //   356: invokevirtual 173	java/io/File:exists	()Z
    //   359: ifeq +53 -> 412
    //   362: aload 6
    //   364: invokevirtual 179	java/io/File:delete	()Z
    //   367: ifne +39 -> 406
    //   370: invokestatic 98	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   373: ifeq +416 -> 789
    //   376: ldc 50
    //   378: iconst_4
    //   379: new 52	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   386: ldc 181
    //   388: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_3
    //   392: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: iconst_0
    //   402: istore_2
    //   403: goto -347 -> 56
    //   406: aload 6
    //   408: invokevirtual 184	java/io/File:createNewFile	()Z
    //   411: pop
    //   412: invokestatic 190	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   415: invokestatic 195	bcnt:a	(Landroid/content/Context;)I
    //   418: iconst_2
    //   419: if_icmpeq +46 -> 465
    //   422: iconst_0
    //   423: istore_2
    //   424: goto -368 -> 56
    //   427: astore 5
    //   429: invokestatic 98	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   432: ifeq +28 -> 460
    //   435: ldc 50
    //   437: iconst_4
    //   438: new 52	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   445: ldc 197
    //   447: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_3
    //   451: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: iconst_0
    //   461: istore_2
    //   462: goto -406 -> 56
    //   465: aload_0
    //   466: aload_0
    //   467: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   470: invokespecial 199	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	(I)Ljava/net/HttpURLConnection;
    //   473: astore 5
    //   475: aload 5
    //   477: ifnonnull +8 -> 485
    //   480: iconst_0
    //   481: istore_2
    //   482: goto -426 -> 56
    //   485: aload 5
    //   487: invokevirtual 90	java/net/HttpURLConnection:getResponseCode	()I
    //   490: sipush 200
    //   493: if_icmpeq +8 -> 501
    //   496: iconst_0
    //   497: istore_2
    //   498: goto -442 -> 56
    //   501: aload 5
    //   503: invokevirtual 203	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   506: astore 7
    //   508: new 205	java/io/FileOutputStream
    //   511: dup
    //   512: aload 6
    //   514: iconst_1
    //   515: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   518: astore 6
    //   520: sipush 4096
    //   523: newarray byte
    //   525: astore 8
    //   527: aload 7
    //   529: aload 8
    //   531: invokevirtual 214	java/io/InputStream:read	([B)I
    //   534: istore_1
    //   535: iload_1
    //   536: iconst_m1
    //   537: if_icmpeq +48 -> 585
    //   540: aload 6
    //   542: aload 8
    //   544: iconst_0
    //   545: iload_1
    //   546: invokevirtual 218	java/io/FileOutputStream:write	([BII)V
    //   549: goto -22 -> 527
    //   552: astore 8
    //   554: invokestatic 98	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   557: ifeq +28 -> 585
    //   560: ldc 50
    //   562: iconst_4
    //   563: new 52	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   570: ldc 220
    //   572: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_3
    //   576: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: aload 7
    //   587: invokevirtual 223	java/io/InputStream:close	()V
    //   590: aload 6
    //   592: invokevirtual 224	java/io/FileOutputStream:close	()V
    //   595: aload_3
    //   596: aload_0
    //   597: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   600: aload_0
    //   601: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   604: invokevirtual 150	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   607: invokestatic 229	anyi:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   610: ifeq +179 -> 789
    //   613: aload_0
    //   614: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   617: aload_0
    //   618: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   621: aload 5
    //   623: invokevirtual 232	java/net/HttpURLConnection:getLastModified	()J
    //   626: invokevirtual 235	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(IJ)V
    //   629: iconst_1
    //   630: istore_2
    //   631: goto -575 -> 56
    //   634: astore 6
    //   636: invokestatic 98	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   639: ifeq +28 -> 667
    //   642: ldc 50
    //   644: iconst_4
    //   645: new 52	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   652: ldc 237
    //   654: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload_3
    //   658: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   667: iconst_0
    //   668: istore_2
    //   669: goto -613 -> 56
    //   672: astore 8
    //   674: aload 7
    //   676: invokevirtual 223	java/io/InputStream:close	()V
    //   679: aload 6
    //   681: invokevirtual 224	java/io/FileOutputStream:close	()V
    //   684: aload 8
    //   686: athrow
    //   687: astore 6
    //   689: goto -94 -> 595
    //   692: aload_0
    //   693: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   696: iconst_2
    //   697: if_icmpne +87 -> 784
    //   700: aload_0
    //   701: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   704: iconst_1
    //   705: putfield 132	com/tencent/mobileqq/business/sougou/WordMatchManager:e	Z
    //   708: aload_0
    //   709: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   712: getfield 239	com/tencent/mobileqq/business/sougou/WordMatchManager:b	Lanym;
    //   715: getfield 137	anym:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   718: astore 4
    //   720: aload_0
    //   721: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   724: getfield 239	com/tencent/mobileqq/business/sougou/WordMatchManager:b	Lanym;
    //   727: astore_3
    //   728: goto -578 -> 150
    //   731: aload_3
    //   732: ifnull +11 -> 743
    //   735: aload_0
    //   736: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   739: aload_3
    //   740: invokevirtual 242	com/tencent/mobileqq/business/sougou/WordMatchManager:b	(Lanym;)V
    //   743: aload_0
    //   744: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   747: aload_0
    //   748: getfield 19	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	I
    //   751: invokevirtual 244	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)V
    //   754: return
    //   755: aload_0
    //   756: getfield 14	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   759: iload_2
    //   760: invokevirtual 162	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Z)V
    //   763: return
    //   764: astore 7
    //   766: goto -176 -> 590
    //   769: astore 6
    //   771: goto -176 -> 595
    //   774: astore 7
    //   776: goto -97 -> 679
    //   779: astore 6
    //   781: goto -97 -> 684
    //   784: aconst_null
    //   785: astore_3
    //   786: goto -636 -> 150
    //   789: iconst_0
    //   790: istore_2
    //   791: goto -735 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	794	0	this	TaskHttpDownload
    //   534	12	1	i	int
    //   55	736	2	bool	boolean
    //   129	657	3	localObject1	Object
    //   1	718	4	str1	java.lang.String
    //   217	53	5	str2	java.lang.String
    //   427	1	5	localIOException1	java.io.IOException
    //   473	149	5	localHttpURLConnection	java.net.HttpURLConnection
    //   352	239	6	localObject2	Object
    //   634	46	6	localFileNotFoundException	java.io.FileNotFoundException
    //   687	1	6	localIOException2	java.io.IOException
    //   769	1	6	localIOException3	java.io.IOException
    //   779	1	6	localIOException4	java.io.IOException
    //   506	169	7	localInputStream	java.io.InputStream
    //   764	1	7	localIOException5	java.io.IOException
    //   774	1	7	localIOException6	java.io.IOException
    //   525	18	8	arrayOfByte	byte[]
    //   552	1	8	localIOException7	java.io.IOException
    //   672	13	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   406	412	427	java/io/IOException
    //   540	549	552	java/io/IOException
    //   508	520	634	java/io/FileNotFoundException
    //   520	527	672	finally
    //   527	535	672	finally
    //   540	549	672	finally
    //   554	585	672	finally
    //   485	496	687	java/io/IOException
    //   501	508	687	java/io/IOException
    //   508	520	687	java/io/IOException
    //   636	667	687	java/io/IOException
    //   684	687	687	java/io/IOException
    //   585	590	764	java/io/IOException
    //   590	595	769	java/io/IOException
    //   674	679	774	java/io/IOException
    //   679	684	779	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.TaskHttpDownload
 * JD-Core Version:    0.7.0.1
 */