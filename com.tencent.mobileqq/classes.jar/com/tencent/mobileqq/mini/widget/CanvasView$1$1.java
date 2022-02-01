package com.tencent.mobileqq.mini.widget;

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
    //   1: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   4: ifnonnull +29 -> 33
    //   7: aload_0
    //   8: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   11: getfield 29	com/tencent/mobileqq/mini/widget/CanvasView$1:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   14: aload_0
    //   15: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   18: getfield 33	com/tencent/mobileqq/mini/widget/CanvasView$1:val$event	Ljava/lang/String;
    //   21: aconst_null
    //   22: aload_0
    //   23: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   26: getfield 37	com/tencent/mobileqq/mini/widget/CanvasView$1:val$callBackId	I
    //   29: invokevirtual 43	com/tencent/mobileqq/mini/widget/CanvasView:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   32: return
    //   33: new 45	android/graphics/Matrix
    //   36: dup
    //   37: invokespecial 46	android/graphics/Matrix:<init>	()V
    //   40: astore 12
    //   42: fconst_1
    //   43: aload_0
    //   44: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   47: getfield 29	com/tencent/mobileqq/mini/widget/CanvasView$1:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   50: invokestatic 50	com/tencent/mobileqq/mini/widget/CanvasView:access$100	(Lcom/tencent/mobileqq/mini/widget/CanvasView;)F
    //   53: fdiv
    //   54: fstore 5
    //   56: aload 12
    //   58: fload 5
    //   60: fload 5
    //   62: invokevirtual 54	android/graphics/Matrix:postScale	(FF)Z
    //   65: pop
    //   66: aload_0
    //   67: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   70: iconst_0
    //   71: iconst_0
    //   72: aload_0
    //   73: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   76: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   79: aload_0
    //   80: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   83: invokevirtual 63	android/graphics/Bitmap:getHeight	()I
    //   86: aload 12
    //   88: iconst_1
    //   89: invokestatic 67	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   92: astore 12
    //   94: aload_0
    //   95: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   98: getfield 71	com/tencent/mobileqq/mini/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   101: ldc 73
    //   103: invokevirtual 79	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   106: istore 6
    //   108: aload_0
    //   109: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   112: getfield 71	com/tencent/mobileqq/mini/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   115: ldc 81
    //   117: invokevirtual 79	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   120: istore 7
    //   122: aload_0
    //   123: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   126: getfield 71	com/tencent/mobileqq/mini/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   129: ldc 83
    //   131: invokevirtual 79	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   134: istore 8
    //   136: aload_0
    //   137: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   140: getfield 71	com/tencent/mobileqq/mini/widget/CanvasView$1:val$paramObj	Lorg/json/JSONObject;
    //   143: ldc 85
    //   145: invokevirtual 79	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   148: istore 9
    //   150: iload 8
    //   152: iload 9
    //   154: imul
    //   155: newarray int
    //   157: astore 14
    //   159: aload 12
    //   161: aload 14
    //   163: iconst_0
    //   164: iload 8
    //   166: iload 6
    //   168: iload 7
    //   170: iload 8
    //   172: iload 9
    //   174: invokevirtual 89	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   177: iload 8
    //   179: iload 9
    //   181: imul
    //   182: iconst_4
    //   183: imul
    //   184: newarray byte
    //   186: astore 13
    //   188: iconst_0
    //   189: istore 6
    //   191: goto +381 -> 572
    //   194: iload 7
    //   196: iload 8
    //   198: if_icmpge +387 -> 585
    //   201: iload 8
    //   203: iload 6
    //   205: imul
    //   206: iload 7
    //   208: iadd
    //   209: istore 11
    //   211: iload 11
    //   213: iconst_4
    //   214: imul
    //   215: istore 10
    //   217: aload 14
    //   219: iload 11
    //   221: iaload
    //   222: istore 11
    //   224: iload 11
    //   226: invokestatic 95	android/graphics/Color:alpha	(I)I
    //   229: i2b
    //   230: istore_1
    //   231: iload 11
    //   233: invokestatic 98	android/graphics/Color:red	(I)I
    //   236: i2b
    //   237: istore_2
    //   238: iload 11
    //   240: invokestatic 101	android/graphics/Color:green	(I)I
    //   243: i2b
    //   244: istore_3
    //   245: iload 11
    //   247: invokestatic 104	android/graphics/Color:blue	(I)I
    //   250: i2b
    //   251: istore 4
    //   253: aload 13
    //   255: iload 10
    //   257: iload_2
    //   258: bastore
    //   259: aload 13
    //   261: iload 10
    //   263: iconst_1
    //   264: iadd
    //   265: iload_3
    //   266: bastore
    //   267: aload 13
    //   269: iload 10
    //   271: iconst_2
    //   272: iadd
    //   273: iload 4
    //   275: bastore
    //   276: aload 13
    //   278: iload 10
    //   280: iconst_3
    //   281: iadd
    //   282: iload_1
    //   283: bastore
    //   284: iload 7
    //   286: iconst_1
    //   287: iadd
    //   288: istore 7
    //   290: goto -96 -> 194
    //   293: new 75	org/json/JSONObject
    //   296: dup
    //   297: invokespecial 105	org/json/JSONObject:<init>	()V
    //   300: astore 14
    //   302: aload 14
    //   304: ldc 83
    //   306: iload 8
    //   308: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   311: pop
    //   312: aload 14
    //   314: ldc 85
    //   316: iload 9
    //   318: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   321: pop
    //   322: aload 13
    //   324: getstatic 114	com/tencent/mobileqq/minigame/utils/NativeBuffer:TYPE_BUFFER_BASE64	I
    //   327: ldc 116
    //   329: aload 14
    //   331: aconst_null
    //   332: invokestatic 120	com/tencent/mobileqq/minigame/utils/NativeBuffer:packNativeBuffer	([BILjava/lang/String;Lorg/json/JSONObject;Lcom/tencent/mobileqq/triton/sdk/bridge/ITNativeBufferPool;)V
    //   335: aload_0
    //   336: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   339: getfield 29	com/tencent/mobileqq/mini/widget/CanvasView$1:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   342: aload_0
    //   343: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   346: getfield 33	com/tencent/mobileqq/mini/widget/CanvasView$1:val$event	Ljava/lang/String;
    //   349: aload 14
    //   351: aload_0
    //   352: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   355: getfield 37	com/tencent/mobileqq/mini/widget/CanvasView$1:val$callBackId	I
    //   358: invokevirtual 123	com/tencent/mobileqq/mini/widget/CanvasView:callbackJsEventOK	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   361: aload_0
    //   362: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   365: ifnull +20 -> 385
    //   368: aload_0
    //   369: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   372: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   375: ifne +10 -> 385
    //   378: aload_0
    //   379: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   382: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   385: aload 12
    //   387: ifnull -355 -> 32
    //   390: aload 12
    //   392: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   395: ifne -363 -> 32
    //   398: aload 12
    //   400: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   403: return
    //   404: astore 13
    //   406: aconst_null
    //   407: astore 12
    //   409: invokestatic 134	com/tencent/mobileqq/mini/widget/CanvasView:access$200	()Ljava/lang/String;
    //   412: iconst_2
    //   413: new 136	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   420: ldc 139
    //   422: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 13
    //   427: invokestatic 149	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   430: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: aload_0
    //   440: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   443: getfield 29	com/tencent/mobileqq/mini/widget/CanvasView$1:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   446: aload_0
    //   447: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   450: getfield 33	com/tencent/mobileqq/mini/widget/CanvasView$1:val$event	Ljava/lang/String;
    //   453: aconst_null
    //   454: aload_0
    //   455: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$1$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$1;
    //   458: getfield 37	com/tencent/mobileqq/mini/widget/CanvasView$1:val$callBackId	I
    //   461: invokevirtual 43	com/tencent/mobileqq/mini/widget/CanvasView:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   464: aload_0
    //   465: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   468: ifnull +20 -> 488
    //   471: aload_0
    //   472: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   475: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   478: ifne +10 -> 488
    //   481: aload_0
    //   482: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   485: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   488: aload 12
    //   490: ifnull -458 -> 32
    //   493: aload 12
    //   495: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   498: ifne -466 -> 32
    //   501: aload 12
    //   503: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   506: return
    //   507: astore 13
    //   509: aconst_null
    //   510: astore 12
    //   512: aload_0
    //   513: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   516: ifnull +20 -> 536
    //   519: aload_0
    //   520: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   523: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   526: ifne +10 -> 536
    //   529: aload_0
    //   530: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$1$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   533: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   536: aload 12
    //   538: ifnull +16 -> 554
    //   541: aload 12
    //   543: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
    //   546: ifne +8 -> 554
    //   549: aload 12
    //   551: invokevirtual 130	android/graphics/Bitmap:recycle	()V
    //   554: aload 13
    //   556: athrow
    //   557: astore 13
    //   559: goto -47 -> 512
    //   562: astore 13
    //   564: goto -52 -> 512
    //   567: astore 13
    //   569: goto -160 -> 409
    //   572: iload 6
    //   574: iload 9
    //   576: if_icmpge -283 -> 293
    //   579: iconst_0
    //   580: istore 7
    //   582: goto -388 -> 194
    //   585: iload 6
    //   587: iconst_1
    //   588: iadd
    //   589: istore 6
    //   591: goto -19 -> 572
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	1
    //   230	53	1	i	int
    //   237	21	2	j	int
    //   244	22	3	k	int
    //   251	23	4	m	int
    //   54	7	5	f	float
    //   106	484	6	n	int
    //   120	461	7	i1	int
    //   134	173	8	i2	int
    //   148	429	9	i3	int
    //   215	67	10	i4	int
    //   209	37	11	i5	int
    //   40	510	12	localObject1	Object
    //   186	137	13	arrayOfByte	byte[]
    //   404	22	13	localThrowable1	java.lang.Throwable
    //   507	48	13	localObject2	Object
    //   557	1	13	localObject3	Object
    //   562	1	13	localObject4	Object
    //   567	1	13	localThrowable2	java.lang.Throwable
    //   157	193	14	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	94	404	java/lang/Throwable
    //   33	94	507	finally
    //   94	188	557	finally
    //   224	253	557	finally
    //   293	361	557	finally
    //   409	464	562	finally
    //   94	188	567	java/lang/Throwable
    //   224	253	567	java/lang/Throwable
    //   293	361	567	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CanvasView.1.1
 * JD-Core Version:    0.7.0.1
 */