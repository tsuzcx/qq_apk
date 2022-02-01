package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;

class CanvasView$1$1
  implements Runnable
{
  CanvasView$1$1(CanvasView.1 param1, Bitmap paramBitmap) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   4: ifnonnull +15 -> 19
    //   7: aload_0
    //   8: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   11: getfield 29	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   14: invokevirtual 35	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   17: pop
    //   18: return
    //   19: aconst_null
    //   20: astore 14
    //   22: aconst_null
    //   23: astore 13
    //   25: aload 13
    //   27: astore 12
    //   29: new 37	android/graphics/Matrix
    //   32: dup
    //   33: invokespecial 38	android/graphics/Matrix:<init>	()V
    //   36: astore 15
    //   38: aload 13
    //   40: astore 12
    //   42: fconst_1
    //   43: aload_0
    //   44: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   47: getfield 42	com/tencent/qqmini/miniapp/widget/CanvasView$1:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   50: invokestatic 48	com/tencent/qqmini/miniapp/widget/CanvasView:access$100	(Lcom/tencent/qqmini/miniapp/widget/CanvasView;)F
    //   53: fdiv
    //   54: fstore 5
    //   56: aload 13
    //   58: astore 12
    //   60: aload 15
    //   62: fload 5
    //   64: fload 5
    //   66: invokevirtual 52	android/graphics/Matrix:postScale	(FF)Z
    //   69: pop
    //   70: aload 13
    //   72: astore 12
    //   74: aload_0
    //   75: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   78: iconst_0
    //   79: iconst_0
    //   80: aload_0
    //   81: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   84: invokevirtual 58	android/graphics/Bitmap:getWidth	()I
    //   87: aload_0
    //   88: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   91: invokevirtual 61	android/graphics/Bitmap:getHeight	()I
    //   94: aload 15
    //   96: iconst_1
    //   97: invokestatic 65	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   100: astore 13
    //   102: aload_0
    //   103: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   106: getfield 69	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   109: ldc 71
    //   111: invokevirtual 77	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   114: istore 6
    //   116: aload_0
    //   117: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   120: getfield 69	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   123: ldc 79
    //   125: invokevirtual 77	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   128: istore 7
    //   130: aload_0
    //   131: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   134: getfield 69	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   137: ldc 81
    //   139: invokevirtual 77	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   142: istore 8
    //   144: aload_0
    //   145: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   148: getfield 69	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   151: ldc 83
    //   153: invokevirtual 77	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   156: istore 9
    //   158: iload 8
    //   160: iload 9
    //   162: imul
    //   163: istore 10
    //   165: iload 10
    //   167: newarray int
    //   169: astore 14
    //   171: aload 13
    //   173: aload 14
    //   175: iconst_0
    //   176: iload 8
    //   178: iload 6
    //   180: iload 7
    //   182: iload 8
    //   184: iload 9
    //   186: invokevirtual 87	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   189: iload 10
    //   191: iconst_4
    //   192: imul
    //   193: newarray byte
    //   195: astore 12
    //   197: iconst_0
    //   198: istore 6
    //   200: goto +402 -> 602
    //   203: iload 7
    //   205: iload 8
    //   207: if_icmpge +408 -> 615
    //   210: iload 8
    //   212: iload 6
    //   214: imul
    //   215: iload 7
    //   217: iadd
    //   218: istore 11
    //   220: iload 11
    //   222: iconst_4
    //   223: imul
    //   224: istore 10
    //   226: aload 14
    //   228: iload 11
    //   230: iaload
    //   231: istore 11
    //   233: iload 11
    //   235: invokestatic 93	android/graphics/Color:alpha	(I)I
    //   238: i2b
    //   239: istore_1
    //   240: iload 11
    //   242: invokestatic 96	android/graphics/Color:red	(I)I
    //   245: i2b
    //   246: istore_2
    //   247: iload 11
    //   249: invokestatic 99	android/graphics/Color:green	(I)I
    //   252: i2b
    //   253: istore_3
    //   254: iload 11
    //   256: invokestatic 102	android/graphics/Color:blue	(I)I
    //   259: i2b
    //   260: istore 4
    //   262: aload 12
    //   264: iload 10
    //   266: iload_2
    //   267: bastore
    //   268: aload 12
    //   270: iload 10
    //   272: iconst_1
    //   273: iadd
    //   274: iload_3
    //   275: bastore
    //   276: aload 12
    //   278: iload 10
    //   280: iconst_2
    //   281: iadd
    //   282: iload 4
    //   284: bastore
    //   285: aload 12
    //   287: iload 10
    //   289: iconst_3
    //   290: iadd
    //   291: iload_1
    //   292: bastore
    //   293: iload 7
    //   295: iconst_1
    //   296: iadd
    //   297: istore 7
    //   299: goto -96 -> 203
    //   302: new 73	org/json/JSONObject
    //   305: dup
    //   306: invokespecial 103	org/json/JSONObject:<init>	()V
    //   309: astore 14
    //   311: aload 14
    //   313: ldc 81
    //   315: iload 8
    //   317: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   320: pop
    //   321: aload 14
    //   323: ldc 83
    //   325: iload 9
    //   327: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   330: pop
    //   331: aconst_null
    //   332: aload 12
    //   334: getstatic 113	com/tencent/qqmini/sdk/core/utils/NativeBuffer:TYPE_BUFFER_BASE64	I
    //   337: ldc 115
    //   339: aload 14
    //   341: invokestatic 119	com/tencent/qqmini/sdk/core/utils/NativeBuffer:packNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;[BILjava/lang/String;Lorg/json/JSONObject;)V
    //   344: aload_0
    //   345: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   348: getfield 29	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   351: aload 14
    //   353: invokevirtual 123	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:ok	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   356: pop
    //   357: aload_0
    //   358: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   361: astore 12
    //   363: aload 12
    //   365: ifnull +18 -> 383
    //   368: aload 12
    //   370: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   373: ifne +10 -> 383
    //   376: aload_0
    //   377: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   380: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   383: aload 13
    //   385: ifnull +163 -> 548
    //   388: aload 13
    //   390: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   393: ifne +155 -> 548
    //   396: aload 13
    //   398: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   401: return
    //   402: astore 12
    //   404: goto +145 -> 549
    //   407: astore 14
    //   409: goto +26 -> 435
    //   412: astore 14
    //   414: aload 12
    //   416: astore 13
    //   418: aload 14
    //   420: astore 12
    //   422: goto +127 -> 549
    //   425: astore 12
    //   427: aload 14
    //   429: astore 13
    //   431: aload 12
    //   433: astore 14
    //   435: aload 13
    //   437: astore 12
    //   439: new 132	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   446: astore 15
    //   448: aload 13
    //   450: astore 12
    //   452: aload 15
    //   454: ldc 135
    //   456: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 13
    //   462: astore 12
    //   464: aload 15
    //   466: aload 14
    //   468: invokestatic 145	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   471: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 13
    //   477: astore 12
    //   479: ldc 147
    //   481: aload 15
    //   483: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 156	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload 13
    //   491: astore 12
    //   493: aload_0
    //   494: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   497: getfield 29	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   500: invokevirtual 35	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   503: pop
    //   504: aload_0
    //   505: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   508: astore 12
    //   510: aload 12
    //   512: ifnull +18 -> 530
    //   515: aload 12
    //   517: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   520: ifne +10 -> 530
    //   523: aload_0
    //   524: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   527: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   530: aload 13
    //   532: ifnull +16 -> 548
    //   535: aload 13
    //   537: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   540: ifne +8 -> 548
    //   543: aload 13
    //   545: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   548: return
    //   549: aload_0
    //   550: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   553: astore 14
    //   555: aload 14
    //   557: ifnull +18 -> 575
    //   560: aload 14
    //   562: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   565: ifne +10 -> 575
    //   568: aload_0
    //   569: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   572: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   575: aload 13
    //   577: ifnull +16 -> 593
    //   580: aload 13
    //   582: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   585: ifne +8 -> 593
    //   588: aload 13
    //   590: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   593: goto +6 -> 599
    //   596: aload 12
    //   598: athrow
    //   599: goto -3 -> 596
    //   602: iload 6
    //   604: iload 9
    //   606: if_icmpge -304 -> 302
    //   609: iconst_0
    //   610: istore 7
    //   612: goto -409 -> 203
    //   615: iload 6
    //   617: iconst_1
    //   618: iadd
    //   619: istore 6
    //   621: goto -19 -> 602
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	this	1
    //   239	53	1	i	int
    //   246	21	2	j	int
    //   253	22	3	k	int
    //   260	23	4	m	int
    //   54	11	5	f	float
    //   114	506	6	n	int
    //   128	483	7	i1	int
    //   142	174	8	i2	int
    //   156	451	9	i3	int
    //   163	128	10	i4	int
    //   218	37	11	i5	int
    //   27	342	12	localObject1	Object
    //   402	13	12	localObject2	Object
    //   420	1	12	localObject3	Object
    //   425	7	12	localThrowable1	java.lang.Throwable
    //   437	160	12	localObject4	Object
    //   23	566	13	localObject5	Object
    //   20	332	14	localObject6	Object
    //   407	1	14	localThrowable2	java.lang.Throwable
    //   412	16	14	localObject7	Object
    //   433	128	14	localObject8	Object
    //   36	446	15	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   102	158	402	finally
    //   165	197	402	finally
    //   233	262	402	finally
    //   302	357	402	finally
    //   102	158	407	java/lang/Throwable
    //   165	197	407	java/lang/Throwable
    //   233	262	407	java/lang/Throwable
    //   302	357	407	java/lang/Throwable
    //   29	38	412	finally
    //   42	56	412	finally
    //   60	70	412	finally
    //   74	102	412	finally
    //   439	448	412	finally
    //   452	460	412	finally
    //   464	475	412	finally
    //   479	489	412	finally
    //   493	504	412	finally
    //   29	38	425	java/lang/Throwable
    //   42	56	425	java/lang/Throwable
    //   60	70	425	java/lang/Throwable
    //   74	102	425	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.1.1
 * JD-Core Version:    0.7.0.1
 */