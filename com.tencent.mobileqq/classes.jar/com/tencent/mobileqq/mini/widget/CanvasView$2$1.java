package com.tencent.mobileqq.mini.widget;

import android.graphics.Bitmap;

class CanvasView$2$1
  implements Runnable
{
  CanvasView$2$1(CanvasView.2 param2, Bitmap paramBitmap) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   4: ifnonnull +38 -> 42
    //   7: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$100	()Ljava/lang/String;
    //   10: iconst_2
    //   11: ldc 33
    //   13: invokestatic 39	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_0
    //   17: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   20: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   23: aload_0
    //   24: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   27: getfield 49	com/tencent/mobileqq/mini/widget/CanvasView$2:val$event	Ljava/lang/String;
    //   30: aconst_null
    //   31: aload_0
    //   32: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   35: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   38: invokevirtual 59	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   41: return
    //   42: aload_0
    //   43: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   46: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   49: aload_0
    //   50: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   53: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   56: ldc 69
    //   58: dconst_0
    //   59: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   62: invokevirtual 79	com/tencent/mobileqq/mini/widget/CanvasView:mpx2pxInt	(D)I
    //   65: istore 10
    //   67: aload_0
    //   68: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   71: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   74: aload_0
    //   75: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   78: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   81: ldc 81
    //   83: dconst_0
    //   84: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   87: invokevirtual 79	com/tencent/mobileqq/mini/widget/CanvasView:mpx2pxInt	(D)I
    //   90: istore 11
    //   92: iload 10
    //   94: ifgt +935 -> 1029
    //   97: aload_0
    //   98: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   101: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   104: invokevirtual 85	com/tencent/mobileqq/mini/widget/CanvasView:getWidth	()I
    //   107: istore 10
    //   109: iload 11
    //   111: ifgt +915 -> 1026
    //   114: aload_0
    //   115: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   118: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   121: invokevirtual 88	com/tencent/mobileqq/mini/widget/CanvasView:getHeight	()I
    //   124: istore 11
    //   126: aload_0
    //   127: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   130: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   133: ldc 90
    //   135: dconst_0
    //   136: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   139: d2i
    //   140: istore 5
    //   142: aload_0
    //   143: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   146: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   149: ldc 92
    //   151: dconst_0
    //   152: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   155: d2i
    //   156: istore 6
    //   158: iload 5
    //   160: istore 4
    //   162: iload 5
    //   164: ifgt +18 -> 182
    //   167: aload_0
    //   168: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   171: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   174: iload 10
    //   176: i2d
    //   177: invokevirtual 95	com/tencent/mobileqq/mini/widget/CanvasView:px2mpxInt	(D)I
    //   180: istore 4
    //   182: iload 6
    //   184: istore 5
    //   186: iload 6
    //   188: ifgt +18 -> 206
    //   191: aload_0
    //   192: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   195: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   198: iload 11
    //   200: i2d
    //   201: invokevirtual 95	com/tencent/mobileqq/mini/widget/CanvasView:px2mpxInt	(D)I
    //   204: istore 5
    //   206: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +40 -> 249
    //   212: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$100	()Ljava/lang/String;
    //   215: iconst_2
    //   216: new 101	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   223: ldc 104
    //   225: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: iload 4
    //   230: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc 113
    //   235: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: iload 5
    //   240: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aconst_null
    //   250: astore 12
    //   252: aload_0
    //   253: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   256: getfield 123	com/tencent/mobileqq/mini/widget/CanvasView$2:val$isPngFile	Z
    //   259: ifeq +243 -> 502
    //   262: getstatic 129	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   265: astore 13
    //   267: iload 4
    //   269: iload 5
    //   271: aload 13
    //   273: invokestatic 135	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   276: astore 14
    //   278: aload 14
    //   280: astore 12
    //   282: aload 12
    //   284: ifnonnull +731 -> 1015
    //   287: aload_0
    //   288: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   291: getfield 123	com/tencent/mobileqq/mini/widget/CanvasView$2:val$isPngFile	Z
    //   294: ifeq +230 -> 524
    //   297: ldc2_w 136
    //   300: iload 4
    //   302: i2l
    //   303: ldiv
    //   304: iload 5
    //   306: i2l
    //   307: ldiv
    //   308: ldc2_w 138
    //   311: ldiv
    //   312: l2d
    //   313: invokestatic 145	java/lang/Math:sqrt	(D)D
    //   316: dstore_1
    //   317: dload_1
    //   318: d2f
    //   319: fstore_3
    //   320: fload_3
    //   321: fconst_1
    //   322: fcmpg
    //   323: ifge +692 -> 1015
    //   326: iload 4
    //   328: i2f
    //   329: fload_3
    //   330: fmul
    //   331: f2i
    //   332: istore 8
    //   334: fload_3
    //   335: iload 5
    //   337: i2f
    //   338: fmul
    //   339: f2i
    //   340: istore 6
    //   342: iload 8
    //   344: iload 6
    //   346: aload 13
    //   348: invokestatic 135	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   351: astore 14
    //   353: aload 14
    //   355: astore 12
    //   357: iload 6
    //   359: istore 7
    //   361: iload 8
    //   363: istore 9
    //   365: aload 12
    //   367: ifnonnull +666 -> 1033
    //   370: iload 8
    //   372: i2d
    //   373: ldc2_w 146
    //   376: ddiv
    //   377: d2i
    //   378: istore 9
    //   380: iload 6
    //   382: i2d
    //   383: ldc2_w 146
    //   386: ddiv
    //   387: d2i
    //   388: istore 7
    //   390: iload 9
    //   392: iload 7
    //   394: aload 13
    //   396: invokestatic 135	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   399: astore 13
    //   401: aload 13
    //   403: astore 12
    //   405: iload 7
    //   407: istore 6
    //   409: iload 9
    //   411: istore 7
    //   413: aload 12
    //   415: ifnonnull +163 -> 578
    //   418: aload_0
    //   419: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   422: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   425: aload_0
    //   426: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   429: getfield 49	com/tencent/mobileqq/mini/widget/CanvasView$2:val$event	Ljava/lang/String;
    //   432: aconst_null
    //   433: aload_0
    //   434: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   437: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   440: invokevirtual 59	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   443: return
    //   444: astore 12
    //   446: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$100	()Ljava/lang/String;
    //   449: iconst_2
    //   450: new 101	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   457: ldc 149
    //   459: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 12
    //   464: invokestatic 155	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   467: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 39	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: aload_0
    //   477: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   480: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   483: aload_0
    //   484: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   487: getfield 49	com/tencent/mobileqq/mini/widget/CanvasView$2:val$event	Ljava/lang/String;
    //   490: aconst_null
    //   491: aload_0
    //   492: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   495: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   498: invokevirtual 59	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   501: return
    //   502: getstatic 158	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   505: astore 13
    //   507: goto -240 -> 267
    //   510: astore 14
    //   512: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$100	()Ljava/lang/String;
    //   515: iconst_2
    //   516: ldc 160
    //   518: invokestatic 163	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto -239 -> 282
    //   524: ldc2_w 136
    //   527: iload 4
    //   529: i2l
    //   530: ldiv
    //   531: iload 5
    //   533: i2l
    //   534: ldiv
    //   535: ldc2_w 138
    //   538: ldiv
    //   539: l2d
    //   540: invokestatic 145	java/lang/Math:sqrt	(D)D
    //   543: d2f
    //   544: fstore_3
    //   545: goto -225 -> 320
    //   548: astore 14
    //   550: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$100	()Ljava/lang/String;
    //   553: iconst_2
    //   554: ldc 165
    //   556: invokestatic 163	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: goto -202 -> 357
    //   562: astore 13
    //   564: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$100	()Ljava/lang/String;
    //   567: iconst_2
    //   568: ldc 167
    //   570: aload 13
    //   572: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   575: goto +458 -> 1033
    //   578: new 172	android/graphics/Canvas
    //   581: dup
    //   582: aload 12
    //   584: invokespecial 175	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   587: astore 13
    //   589: aload 13
    //   591: new 177	android/graphics/PaintFlagsDrawFilter
    //   594: dup
    //   595: iconst_0
    //   596: iconst_3
    //   597: invokespecial 180	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   600: invokevirtual 184	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   603: new 186	android/graphics/Rect
    //   606: dup
    //   607: iconst_0
    //   608: iconst_0
    //   609: iload 7
    //   611: iload 6
    //   613: invokespecial 189	android/graphics/Rect:<init>	(IIII)V
    //   616: astore 14
    //   618: aload_0
    //   619: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   622: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   625: aload_0
    //   626: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   629: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   632: ldc 191
    //   634: dconst_0
    //   635: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   638: invokevirtual 79	com/tencent/mobileqq/mini/widget/CanvasView:mpx2pxInt	(D)I
    //   641: istore 8
    //   643: aload_0
    //   644: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   647: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   650: aload_0
    //   651: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   654: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   657: ldc 193
    //   659: dconst_0
    //   660: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   663: invokevirtual 79	com/tencent/mobileqq/mini/widget/CanvasView:mpx2pxInt	(D)I
    //   666: istore 9
    //   668: new 186	android/graphics/Rect
    //   671: dup
    //   672: iload 8
    //   674: iload 9
    //   676: iload 10
    //   678: iload 8
    //   680: iadd
    //   681: iload 11
    //   683: iload 9
    //   685: iadd
    //   686: invokespecial 189	android/graphics/Rect:<init>	(IIII)V
    //   689: astore 15
    //   691: aload 13
    //   693: aload_0
    //   694: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   697: aload 15
    //   699: aload 14
    //   701: aconst_null
    //   702: invokevirtual 197	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   705: invokestatic 203	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   708: aload_0
    //   709: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   712: getfield 206	com/tencent/mobileqq/mini/widget/CanvasView$2:val$fileType	Ljava/lang/String;
    //   715: invokevirtual 210	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   718: astore 14
    //   720: aload 14
    //   722: invokestatic 216	bdhb:a	(Ljava/lang/String;)Ljava/io/File;
    //   725: astore 13
    //   727: new 218	java/io/FileOutputStream
    //   730: dup
    //   731: aload 13
    //   733: invokespecial 221	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   736: astore 13
    //   738: iload 7
    //   740: iload 6
    //   742: imul
    //   743: iload 4
    //   745: idiv
    //   746: iload 5
    //   748: idiv
    //   749: i2f
    //   750: fstore_3
    //   751: aload_0
    //   752: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   755: getfield 123	com/tencent/mobileqq/mini/widget/CanvasView$2:val$isPngFile	Z
    //   758: ifeq +132 -> 890
    //   761: aload_0
    //   762: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   765: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   768: ldc 223
    //   770: dconst_1
    //   771: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   774: fload_3
    //   775: f2d
    //   776: ddiv
    //   777: dstore_1
    //   778: aload 12
    //   780: getstatic 229	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   783: dload_1
    //   784: ldc2_w 230
    //   787: dmul
    //   788: d2i
    //   789: aload 13
    //   791: invokevirtual 235	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   794: pop
    //   795: new 71	org/json/JSONObject
    //   798: dup
    //   799: invokespecial 236	org/json/JSONObject:<init>	()V
    //   802: astore 12
    //   804: aload 12
    //   806: ldc 238
    //   808: invokestatic 203	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   811: aload 14
    //   813: invokevirtual 241	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   816: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   819: pop
    //   820: aload_0
    //   821: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   824: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   827: getfield 249	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/AppBrandRuntime;
    //   830: getfield 255	com/tencent/mobileqq/mini/appbrand/AppBrandRuntime:serviceRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   833: aload_0
    //   834: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   837: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   840: aload 12
    //   842: invokevirtual 256	org/json/JSONObject:toString	()Ljava/lang/String;
    //   845: invokeinterface 262 3 0
    //   850: aload 13
    //   852: ifnull +13 -> 865
    //   855: aload 13
    //   857: invokevirtual 265	java/io/FileOutputStream:flush	()V
    //   860: aload 13
    //   862: invokevirtual 268	java/io/FileOutputStream:close	()V
    //   865: aload_0
    //   866: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   869: ifnull +163 -> 1032
    //   872: aload_0
    //   873: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   876: invokevirtual 271	android/graphics/Bitmap:isRecycled	()Z
    //   879: ifne +153 -> 1032
    //   882: aload_0
    //   883: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   886: invokevirtual 274	android/graphics/Bitmap:recycle	()V
    //   889: return
    //   890: aload_0
    //   891: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   894: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   897: ldc_w 276
    //   900: dconst_1
    //   901: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   904: fload_3
    //   905: f2d
    //   906: ddiv
    //   907: dstore_1
    //   908: aload 12
    //   910: getstatic 279	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   913: dload_1
    //   914: ldc2_w 230
    //   917: dmul
    //   918: d2i
    //   919: aload 13
    //   921: invokevirtual 235	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   924: pop
    //   925: goto -130 -> 795
    //   928: astore 12
    //   930: aload 13
    //   932: ifnull +13 -> 945
    //   935: aload 13
    //   937: invokevirtual 265	java/io/FileOutputStream:flush	()V
    //   940: aload 13
    //   942: invokevirtual 268	java/io/FileOutputStream:close	()V
    //   945: aload_0
    //   946: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   949: ifnull +20 -> 969
    //   952: aload_0
    //   953: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   956: invokevirtual 271	android/graphics/Bitmap:isRecycled	()Z
    //   959: ifne +10 -> 969
    //   962: aload_0
    //   963: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   966: invokevirtual 274	android/graphics/Bitmap:recycle	()V
    //   969: aload 12
    //   971: athrow
    //   972: astore 12
    //   974: aload 12
    //   976: invokevirtual 282	org/json/JSONException:printStackTrace	()V
    //   979: aload_0
    //   980: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   983: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   986: aload_0
    //   987: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   990: getfield 49	com/tencent/mobileqq/mini/widget/CanvasView$2:val$event	Ljava/lang/String;
    //   993: aconst_null
    //   994: aload_0
    //   995: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   998: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   1001: invokevirtual 59	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   1004: goto -154 -> 850
    //   1007: astore 12
    //   1009: aconst_null
    //   1010: astore 13
    //   1012: goto -82 -> 930
    //   1015: iload 5
    //   1017: istore 6
    //   1019: iload 4
    //   1021: istore 8
    //   1023: goto -666 -> 357
    //   1026: goto -900 -> 126
    //   1029: goto -920 -> 109
    //   1032: return
    //   1033: iload 7
    //   1035: istore 6
    //   1037: iload 9
    //   1039: istore 7
    //   1041: goto -628 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1044	0	this	1
    //   316	598	1	d	double
    //   319	586	3	f	float
    //   160	860	4	i	int
    //   140	876	5	j	int
    //   156	880	6	k	int
    //   359	681	7	m	int
    //   332	690	8	n	int
    //   363	675	9	i1	int
    //   65	616	10	i2	int
    //   90	596	11	i3	int
    //   250	164	12	localObject1	Object
    //   444	335	12	localThrowable1	java.lang.Throwable
    //   802	107	12	localJSONObject	org.json.JSONObject
    //   928	42	12	localObject2	Object
    //   972	3	12	localJSONException	org.json.JSONException
    //   1007	1	12	localObject3	Object
    //   265	241	13	localObject4	Object
    //   562	9	13	localThrowable2	java.lang.Throwable
    //   587	424	13	localObject5	Object
    //   276	78	14	localBitmap	Bitmap
    //   510	1	14	localThrowable3	java.lang.Throwable
    //   548	1	14	localThrowable4	java.lang.Throwable
    //   616	196	14	localObject6	Object
    //   689	9	15	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   0	41	444	java/lang/Throwable
    //   42	92	444	java/lang/Throwable
    //   97	109	444	java/lang/Throwable
    //   114	126	444	java/lang/Throwable
    //   126	158	444	java/lang/Throwable
    //   167	182	444	java/lang/Throwable
    //   191	206	444	java/lang/Throwable
    //   206	249	444	java/lang/Throwable
    //   252	267	444	java/lang/Throwable
    //   287	317	444	java/lang/Throwable
    //   418	443	444	java/lang/Throwable
    //   502	507	444	java/lang/Throwable
    //   512	521	444	java/lang/Throwable
    //   524	545	444	java/lang/Throwable
    //   550	559	444	java/lang/Throwable
    //   564	575	444	java/lang/Throwable
    //   578	727	444	java/lang/Throwable
    //   855	865	444	java/lang/Throwable
    //   865	889	444	java/lang/Throwable
    //   935	945	444	java/lang/Throwable
    //   945	969	444	java/lang/Throwable
    //   969	972	444	java/lang/Throwable
    //   267	278	510	java/lang/Throwable
    //   342	353	548	java/lang/Throwable
    //   390	401	562	java/lang/Throwable
    //   738	795	928	finally
    //   795	850	928	finally
    //   890	925	928	finally
    //   974	1004	928	finally
    //   795	850	972	org/json/JSONException
    //   727	738	1007	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CanvasView.2.1
 * JD-Core Version:    0.7.0.1
 */