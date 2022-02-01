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
    //   0: aconst_null
    //   1: astore 13
    //   3: aload_0
    //   4: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   7: ifnonnull +15 -> 22
    //   10: aload_0
    //   11: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   14: getfield 29	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   17: invokevirtual 35	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   20: pop
    //   21: return
    //   22: new 37	android/graphics/Matrix
    //   25: dup
    //   26: invokespecial 38	android/graphics/Matrix:<init>	()V
    //   29: astore 12
    //   31: fconst_1
    //   32: aload_0
    //   33: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   36: getfield 42	com/tencent/qqmini/miniapp/widget/CanvasView$1:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   39: invokestatic 48	com/tencent/qqmini/miniapp/widget/CanvasView:access$100	(Lcom/tencent/qqmini/miniapp/widget/CanvasView;)F
    //   42: fdiv
    //   43: fstore 5
    //   45: aload 12
    //   47: fload 5
    //   49: fload 5
    //   51: invokevirtual 52	android/graphics/Matrix:postScale	(FF)Z
    //   54: pop
    //   55: aload_0
    //   56: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   59: iconst_0
    //   60: iconst_0
    //   61: aload_0
    //   62: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   65: invokevirtual 58	android/graphics/Bitmap:getWidth	()I
    //   68: aload_0
    //   69: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   72: invokevirtual 61	android/graphics/Bitmap:getHeight	()I
    //   75: aload 12
    //   77: iconst_1
    //   78: invokestatic 65	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   81: astore 12
    //   83: aload_0
    //   84: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   87: getfield 69	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   90: ldc 71
    //   92: invokevirtual 77	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   95: istore 6
    //   97: aload_0
    //   98: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   101: getfield 69	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   104: ldc 79
    //   106: invokevirtual 77	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   109: istore 7
    //   111: aload_0
    //   112: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   115: getfield 69	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   118: ldc 81
    //   120: invokevirtual 77	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   123: istore 8
    //   125: aload_0
    //   126: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   129: getfield 69	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   132: ldc 83
    //   134: invokevirtual 77	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   137: istore 9
    //   139: iload 8
    //   141: iload 9
    //   143: imul
    //   144: newarray int
    //   146: astore 14
    //   148: aload 12
    //   150: aload 14
    //   152: iconst_0
    //   153: iload 8
    //   155: iload 6
    //   157: iload 7
    //   159: iload 8
    //   161: iload 9
    //   163: invokevirtual 87	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   166: iload 8
    //   168: iload 9
    //   170: imul
    //   171: iconst_4
    //   172: imul
    //   173: newarray byte
    //   175: astore 13
    //   177: iconst_0
    //   178: istore 6
    //   180: goto +365 -> 545
    //   183: iload 7
    //   185: iload 8
    //   187: if_icmpge +371 -> 558
    //   190: iload 8
    //   192: iload 6
    //   194: imul
    //   195: iload 7
    //   197: iadd
    //   198: istore 11
    //   200: iload 11
    //   202: iconst_4
    //   203: imul
    //   204: istore 10
    //   206: aload 14
    //   208: iload 11
    //   210: iaload
    //   211: istore 11
    //   213: iload 11
    //   215: invokestatic 93	android/graphics/Color:alpha	(I)I
    //   218: i2b
    //   219: istore_1
    //   220: iload 11
    //   222: invokestatic 96	android/graphics/Color:red	(I)I
    //   225: i2b
    //   226: istore_2
    //   227: iload 11
    //   229: invokestatic 99	android/graphics/Color:green	(I)I
    //   232: i2b
    //   233: istore_3
    //   234: iload 11
    //   236: invokestatic 102	android/graphics/Color:blue	(I)I
    //   239: i2b
    //   240: istore 4
    //   242: aload 13
    //   244: iload 10
    //   246: iload_2
    //   247: bastore
    //   248: aload 13
    //   250: iload 10
    //   252: iconst_1
    //   253: iadd
    //   254: iload_3
    //   255: bastore
    //   256: aload 13
    //   258: iload 10
    //   260: iconst_2
    //   261: iadd
    //   262: iload 4
    //   264: bastore
    //   265: aload 13
    //   267: iload 10
    //   269: iconst_3
    //   270: iadd
    //   271: iload_1
    //   272: bastore
    //   273: iload 7
    //   275: iconst_1
    //   276: iadd
    //   277: istore 7
    //   279: goto -96 -> 183
    //   282: new 73	org/json/JSONObject
    //   285: dup
    //   286: invokespecial 103	org/json/JSONObject:<init>	()V
    //   289: astore 14
    //   291: aload 14
    //   293: ldc 81
    //   295: iload 8
    //   297: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   300: pop
    //   301: aload 14
    //   303: ldc 83
    //   305: iload 9
    //   307: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   310: pop
    //   311: aconst_null
    //   312: aload 13
    //   314: getstatic 113	com/tencent/qqmini/sdk/core/utils/NativeBuffer:TYPE_BUFFER_BASE64	I
    //   317: ldc 115
    //   319: aload 14
    //   321: invokestatic 119	com/tencent/qqmini/sdk/core/utils/NativeBuffer:packNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;[BILjava/lang/String;Lorg/json/JSONObject;)V
    //   324: aload_0
    //   325: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   328: getfield 29	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   331: aload 14
    //   333: invokevirtual 123	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:ok	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   336: pop
    //   337: aload_0
    //   338: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   341: ifnull +20 -> 361
    //   344: aload_0
    //   345: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   348: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   351: ifne +10 -> 361
    //   354: aload_0
    //   355: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   358: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   361: aload 12
    //   363: ifnull -342 -> 21
    //   366: aload 12
    //   368: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   371: ifne -350 -> 21
    //   374: aload 12
    //   376: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   379: return
    //   380: astore 13
    //   382: aconst_null
    //   383: astore 12
    //   385: ldc 132
    //   387: new 134	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   394: ldc 137
    //   396: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload 13
    //   401: invokestatic 147	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   404: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 156	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload_0
    //   414: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$1;
    //   417: getfield 29	com/tencent/qqmini/miniapp/widget/CanvasView$1:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   420: invokevirtual 35	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   423: pop
    //   424: aload_0
    //   425: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   428: ifnull +20 -> 448
    //   431: aload_0
    //   432: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   435: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   438: ifne +10 -> 448
    //   441: aload_0
    //   442: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   445: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   448: aload 12
    //   450: ifnull -429 -> 21
    //   453: aload 12
    //   455: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   458: ifne -437 -> 21
    //   461: aload 12
    //   463: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   466: return
    //   467: astore 12
    //   469: aload_0
    //   470: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   473: ifnull +20 -> 493
    //   476: aload_0
    //   477: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   480: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   483: ifne +10 -> 493
    //   486: aload_0
    //   487: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   490: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   493: aload 13
    //   495: ifnull +16 -> 511
    //   498: aload 13
    //   500: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   503: ifne +8 -> 511
    //   506: aload 13
    //   508: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   511: aload 12
    //   513: athrow
    //   514: astore 14
    //   516: aload 12
    //   518: astore 13
    //   520: aload 14
    //   522: astore 12
    //   524: goto -55 -> 469
    //   527: astore 14
    //   529: aload 12
    //   531: astore 13
    //   533: aload 14
    //   535: astore 12
    //   537: goto -68 -> 469
    //   540: astore 13
    //   542: goto -157 -> 385
    //   545: iload 6
    //   547: iload 9
    //   549: if_icmpge -267 -> 282
    //   552: iconst_0
    //   553: istore 7
    //   555: goto -372 -> 183
    //   558: iload 6
    //   560: iconst_1
    //   561: iadd
    //   562: istore 6
    //   564: goto -19 -> 545
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	567	0	this	1
    //   219	53	1	i	int
    //   226	21	2	j	int
    //   233	22	3	k	int
    //   240	23	4	m	int
    //   43	7	5	f	float
    //   95	468	6	n	int
    //   109	445	7	i1	int
    //   123	173	8	i2	int
    //   137	413	9	i3	int
    //   204	67	10	i4	int
    //   198	37	11	i5	int
    //   29	433	12	localObject1	Object
    //   467	50	12	localObject2	Object
    //   522	14	12	localObject3	Object
    //   1	312	13	arrayOfByte	byte[]
    //   380	127	13	localThrowable1	java.lang.Throwable
    //   518	14	13	localObject4	Object
    //   540	1	13	localThrowable2	java.lang.Throwable
    //   146	186	14	localObject5	Object
    //   514	7	14	localObject6	Object
    //   527	7	14	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   22	83	380	java/lang/Throwable
    //   22	83	467	finally
    //   83	177	514	finally
    //   213	242	514	finally
    //   282	337	514	finally
    //   385	424	527	finally
    //   83	177	540	java/lang/Throwable
    //   213	242	540	java/lang/Throwable
    //   282	337	540	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.1.1
 * JD-Core Version:    0.7.0.1
 */