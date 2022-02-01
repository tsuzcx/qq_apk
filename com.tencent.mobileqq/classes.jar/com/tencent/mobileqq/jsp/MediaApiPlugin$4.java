package com.tencent.mobileqq.jsp;

import java.util.concurrent.atomic.AtomicBoolean;

class MediaApiPlugin$4
  implements Runnable
{
  MediaApiPlugin$4(MediaApiPlugin paramMediaApiPlugin, String paramString1, String paramString2, AtomicBoolean paramAtomicBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 38	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 39	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: invokestatic 45	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: astore 4
    //   13: iconst_m1
    //   14: istore_2
    //   15: invokestatic 45	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: aload_0
    //   19: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$4:a	Ljava/lang/String;
    //   22: aconst_null
    //   23: ldc 47
    //   25: aconst_null
    //   26: aconst_null
    //   27: invokestatic 53	com/tencent/biz/common/util/HttpUtil:openRequest	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Lorg/apache/http/HttpResponse;
    //   30: astore 5
    //   32: iload_2
    //   33: istore_1
    //   34: aload 5
    //   36: ifnull +231 -> 267
    //   39: aload 5
    //   41: invokeinterface 59 1 0
    //   46: invokeinterface 65 1 0
    //   51: istore_1
    //   52: iload_1
    //   53: sipush 200
    //   56: if_icmpne +211 -> 267
    //   59: aload 5
    //   61: invokestatic 69	com/tencent/biz/common/util/HttpUtil:readHttpResponseSteam	(Lorg/apache/http/HttpResponse;)Ljava/io/ByteArrayOutputStream;
    //   64: invokevirtual 75	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   67: astore 5
    //   69: aload_3
    //   70: ldc 77
    //   72: iload_1
    //   73: invokevirtual 81	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload_0
    //   78: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   81: aload 5
    //   83: invokevirtual 86	com/tencent/mobileqq/jsp/MediaApiPlugin:a	([B)Ljava/lang/String;
    //   86: astore 5
    //   88: aload_3
    //   89: ldc 88
    //   91: iconst_0
    //   92: invokevirtual 81	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_3
    //   97: ldc 90
    //   99: aload 4
    //   101: ldc 91
    //   103: invokevirtual 97	android/content/Context:getString	(I)Ljava/lang/String;
    //   106: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   109: pop
    //   110: aload_3
    //   111: ldc 102
    //   113: aload 5
    //   115: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   118: pop
    //   119: goto +50 -> 169
    //   122: aload_3
    //   123: ldc 88
    //   125: iconst_2
    //   126: invokevirtual 81	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload_3
    //   131: ldc 90
    //   133: aload 4
    //   135: ldc 103
    //   137: invokevirtual 97	android/content/Context:getString	(I)Ljava/lang/String;
    //   140: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   143: pop
    //   144: goto +25 -> 169
    //   147: aload_3
    //   148: ldc 88
    //   150: iconst_1
    //   151: invokevirtual 81	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   154: pop
    //   155: aload_3
    //   156: ldc 90
    //   158: aload 4
    //   160: ldc 104
    //   162: invokevirtual 97	android/content/Context:getString	(I)Ljava/lang/String;
    //   165: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload_0
    //   170: getfield 21	com/tencent/mobileqq/jsp/MediaApiPlugin$4:b	Ljava/lang/String;
    //   173: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +40 -> 216
    //   179: aload_0
    //   180: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$4:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   183: iconst_0
    //   184: iconst_1
    //   185: invokevirtual 116	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   188: ifeq +28 -> 216
    //   191: aload_0
    //   192: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   195: aload_0
    //   196: getfield 21	com/tencent/mobileqq/jsp/MediaApiPlugin$4:b	Ljava/lang/String;
    //   199: iconst_1
    //   200: anewarray 118	java/lang/String
    //   203: dup
    //   204: iconst_0
    //   205: aload_3
    //   206: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   209: aastore
    //   210: invokevirtual 126	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   213: goto +17 -> 230
    //   216: aload_0
    //   217: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   220: ldc 128
    //   222: iconst_0
    //   223: aload_3
    //   224: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   227: invokevirtual 132	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload_0
    //   231: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   234: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   237: ifnull +26 -> 263
    //   240: aload_0
    //   241: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   244: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   247: invokevirtual 142	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   250: ifeq +13 -> 263
    //   253: aload_0
    //   254: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   257: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   260: invokevirtual 145	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   263: return
    //   264: goto +49 -> 313
    //   267: iload_1
    //   268: istore_2
    //   269: aload_0
    //   270: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   273: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   276: ifnull +67 -> 343
    //   279: iload_1
    //   280: istore_2
    //   281: aload_0
    //   282: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   285: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   288: invokevirtual 142	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   291: ifeq +52 -> 343
    //   294: aload_0
    //   295: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   298: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   301: invokevirtual 145	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   304: iload_1
    //   305: istore_2
    //   306: goto +37 -> 343
    //   309: astore_3
    //   310: goto +250 -> 560
    //   313: iload_1
    //   314: istore_2
    //   315: aload_0
    //   316: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   319: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   322: ifnull +21 -> 343
    //   325: iload_1
    //   326: istore_2
    //   327: aload_0
    //   328: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   331: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   334: invokevirtual 142	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   337: ifeq +6 -> 343
    //   340: goto -46 -> 294
    //   343: aload_3
    //   344: ldc 88
    //   346: iconst_3
    //   347: invokevirtual 81	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   350: pop
    //   351: aload_3
    //   352: ldc 90
    //   354: aload 4
    //   356: ldc 146
    //   358: invokevirtual 97	android/content/Context:getString	(I)Ljava/lang/String;
    //   361: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   364: pop
    //   365: aload_3
    //   366: ldc 77
    //   368: iload_2
    //   369: invokevirtual 81	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   372: pop
    //   373: aload_0
    //   374: getfield 21	com/tencent/mobileqq/jsp/MediaApiPlugin$4:b	Ljava/lang/String;
    //   377: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   380: ifne +38 -> 418
    //   383: aload_0
    //   384: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$4:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   387: iconst_0
    //   388: iconst_1
    //   389: invokevirtual 116	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   392: ifeq +26 -> 418
    //   395: aload_0
    //   396: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   399: aload_0
    //   400: getfield 21	com/tencent/mobileqq/jsp/MediaApiPlugin$4:b	Ljava/lang/String;
    //   403: iconst_1
    //   404: anewarray 118	java/lang/String
    //   407: dup
    //   408: iconst_0
    //   409: aload_3
    //   410: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   413: aastore
    //   414: invokevirtual 126	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   417: return
    //   418: aload_0
    //   419: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   422: ldc 128
    //   424: iconst_0
    //   425: aload_3
    //   426: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   429: invokevirtual 132	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: return
    //   433: iconst_m1
    //   434: istore_1
    //   435: aload_3
    //   436: ldc 88
    //   438: iconst_m1
    //   439: invokevirtual 81	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   442: pop
    //   443: aload_3
    //   444: ldc 90
    //   446: aload 4
    //   448: ldc 147
    //   450: invokevirtual 97	android/content/Context:getString	(I)Ljava/lang/String;
    //   453: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   456: pop
    //   457: aload_3
    //   458: ldc 77
    //   460: iload_1
    //   461: invokevirtual 81	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   464: pop
    //   465: aload_0
    //   466: getfield 21	com/tencent/mobileqq/jsp/MediaApiPlugin$4:b	Ljava/lang/String;
    //   469: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   472: ifne +40 -> 512
    //   475: aload_0
    //   476: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$4:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   479: iconst_0
    //   480: iconst_1
    //   481: invokevirtual 116	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   484: ifeq +28 -> 512
    //   487: aload_0
    //   488: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   491: aload_0
    //   492: getfield 21	com/tencent/mobileqq/jsp/MediaApiPlugin$4:b	Ljava/lang/String;
    //   495: iconst_1
    //   496: anewarray 118	java/lang/String
    //   499: dup
    //   500: iconst_0
    //   501: aload_3
    //   502: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   505: aastore
    //   506: invokevirtual 126	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   509: goto +17 -> 526
    //   512: aload_0
    //   513: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   516: ldc 128
    //   518: iconst_0
    //   519: aload_3
    //   520: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   523: invokevirtual 132	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: aload_0
    //   527: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   530: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   533: ifnull +26 -> 559
    //   536: aload_0
    //   537: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   540: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   543: invokevirtual 142	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   546: ifeq +13 -> 559
    //   549: aload_0
    //   550: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   553: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   556: invokevirtual 145	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   559: return
    //   560: aload_0
    //   561: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   564: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   567: ifnull +26 -> 593
    //   570: aload_0
    //   571: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   574: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   577: invokevirtual 142	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   580: ifeq +13 -> 593
    //   583: aload_0
    //   584: getfield 17	com/tencent/mobileqq/jsp/MediaApiPlugin$4:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   587: getfield 136	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   590: invokevirtual 145	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   593: goto +5 -> 598
    //   596: aload_3
    //   597: athrow
    //   598: goto -2 -> 596
    //   601: astore 5
    //   603: goto -170 -> 433
    //   606: astore 5
    //   608: iload_2
    //   609: istore_1
    //   610: goto -297 -> 313
    //   613: astore 5
    //   615: goto -180 -> 435
    //   618: astore 5
    //   620: goto -356 -> 264
    //   623: astore 6
    //   625: goto -548 -> 77
    //   628: astore 5
    //   630: goto -483 -> 147
    //   633: astore 5
    //   635: goto -513 -> 122
    //   638: astore 5
    //   640: goto -471 -> 169
    //   643: astore 4
    //   645: goto -272 -> 373
    //   648: astore 4
    //   650: goto -185 -> 465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	4
    //   33	577	1	i	int
    //   14	595	2	j	int
    //   7	217	3	localJSONObject	org.json.JSONObject
    //   309	288	3	localObject1	Object
    //   11	436	4	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    //   643	1	4	localJSONException1	org.json.JSONException
    //   648	1	4	localJSONException2	org.json.JSONException
    //   30	84	5	localObject2	Object
    //   601	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   606	1	5	localIOException1	java.io.IOException
    //   613	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   618	1	5	localIOException2	java.io.IOException
    //   628	1	5	localIOException3	java.io.IOException
    //   633	1	5	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   638	1	5	localJSONException3	org.json.JSONException
    //   623	1	6	localJSONException4	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   15	32	309	finally
    //   39	52	309	finally
    //   59	69	309	finally
    //   69	77	309	finally
    //   77	88	309	finally
    //   88	119	309	finally
    //   122	144	309	finally
    //   147	169	309	finally
    //   169	213	309	finally
    //   216	230	309	finally
    //   435	465	309	finally
    //   465	509	309	finally
    //   512	526	309	finally
    //   15	32	601	java/lang/OutOfMemoryError
    //   39	52	601	java/lang/OutOfMemoryError
    //   15	32	606	java/io/IOException
    //   39	52	606	java/io/IOException
    //   59	69	613	java/lang/OutOfMemoryError
    //   69	77	613	java/lang/OutOfMemoryError
    //   77	88	613	java/lang/OutOfMemoryError
    //   88	119	613	java/lang/OutOfMemoryError
    //   122	144	613	java/lang/OutOfMemoryError
    //   147	169	613	java/lang/OutOfMemoryError
    //   169	213	613	java/lang/OutOfMemoryError
    //   216	230	613	java/lang/OutOfMemoryError
    //   59	69	618	java/io/IOException
    //   69	77	618	java/io/IOException
    //   122	144	618	java/io/IOException
    //   147	169	618	java/io/IOException
    //   169	213	618	java/io/IOException
    //   216	230	618	java/io/IOException
    //   69	77	623	org/json/JSONException
    //   77	88	628	java/io/IOException
    //   88	119	628	java/io/IOException
    //   77	88	633	java/lang/IllegalArgumentException
    //   88	119	633	java/lang/IllegalArgumentException
    //   88	119	638	org/json/JSONException
    //   122	144	638	org/json/JSONException
    //   147	169	638	org/json/JSONException
    //   343	373	643	org/json/JSONException
    //   435	465	648	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.4
 * JD-Core Version:    0.7.0.1
 */