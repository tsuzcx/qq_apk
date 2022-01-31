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
    //   65: istore 6
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
    //   90: istore 7
    //   92: iload 6
    //   94: ifgt +709 -> 803
    //   97: aload_0
    //   98: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   101: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   104: invokevirtual 85	com/tencent/mobileqq/mini/widget/CanvasView:getWidth	()I
    //   107: istore 6
    //   109: iload 7
    //   111: ifgt +689 -> 800
    //   114: aload_0
    //   115: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   118: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   121: invokevirtual 88	com/tencent/mobileqq/mini/widget/CanvasView:getHeight	()I
    //   124: istore 7
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
    //   156: istore 8
    //   158: iload 5
    //   160: istore 4
    //   162: iload 5
    //   164: ifgt +18 -> 182
    //   167: aload_0
    //   168: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   171: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   174: iload 6
    //   176: i2d
    //   177: invokevirtual 95	com/tencent/mobileqq/mini/widget/CanvasView:px2mpxInt	(D)I
    //   180: istore 4
    //   182: iload 8
    //   184: istore 5
    //   186: iload 8
    //   188: ifgt +18 -> 206
    //   191: aload_0
    //   192: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   195: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   198: iload 7
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
    //   249: ldc 120
    //   251: iload 4
    //   253: i2f
    //   254: fdiv
    //   255: ldc 121
    //   257: iload 5
    //   259: i2f
    //   260: fdiv
    //   261: invokestatic 127	java/lang/Math:min	(FF)F
    //   264: fstore_3
    //   265: fload_3
    //   266: fconst_1
    //   267: fcmpg
    //   268: ifge +529 -> 797
    //   271: iload 4
    //   273: i2f
    //   274: fload_3
    //   275: fmul
    //   276: f2i
    //   277: istore 4
    //   279: iload 5
    //   281: i2f
    //   282: fload_3
    //   283: fmul
    //   284: f2i
    //   285: istore 5
    //   287: aload_0
    //   288: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   291: getfield 131	com/tencent/mobileqq/mini/widget/CanvasView$2:val$isPngFile	Z
    //   294: ifeq +373 -> 667
    //   297: getstatic 137	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   300: astore 9
    //   302: iload 4
    //   304: iload 5
    //   306: aload 9
    //   308: invokestatic 143	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   311: astore 9
    //   313: new 145	android/graphics/Canvas
    //   316: dup
    //   317: aload 9
    //   319: invokespecial 148	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   322: astore 10
    //   324: aload 10
    //   326: new 150	android/graphics/PaintFlagsDrawFilter
    //   329: dup
    //   330: iconst_0
    //   331: iconst_3
    //   332: invokespecial 153	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   335: invokevirtual 157	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   338: new 159	android/graphics/Rect
    //   341: dup
    //   342: iconst_0
    //   343: iconst_0
    //   344: iload 4
    //   346: iload 5
    //   348: invokespecial 162	android/graphics/Rect:<init>	(IIII)V
    //   351: astore 11
    //   353: aload_0
    //   354: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   357: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   360: aload_0
    //   361: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   364: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   367: ldc 164
    //   369: dconst_0
    //   370: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   373: invokevirtual 79	com/tencent/mobileqq/mini/widget/CanvasView:mpx2pxInt	(D)I
    //   376: istore 4
    //   378: aload_0
    //   379: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   382: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   385: aload_0
    //   386: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   389: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   392: ldc 166
    //   394: dconst_0
    //   395: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   398: invokevirtual 79	com/tencent/mobileqq/mini/widget/CanvasView:mpx2pxInt	(D)I
    //   401: istore 5
    //   403: new 159	android/graphics/Rect
    //   406: dup
    //   407: iload 4
    //   409: iload 5
    //   411: iload 6
    //   413: iload 4
    //   415: iadd
    //   416: iload 7
    //   418: iload 5
    //   420: iadd
    //   421: invokespecial 162	android/graphics/Rect:<init>	(IIII)V
    //   424: astore 12
    //   426: aload 10
    //   428: aload_0
    //   429: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   432: aload 12
    //   434: aload 11
    //   436: aconst_null
    //   437: invokevirtual 170	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   440: invokestatic 176	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   443: aload_0
    //   444: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   447: getfield 179	com/tencent/mobileqq/mini/widget/CanvasView$2:val$fileType	Ljava/lang/String;
    //   450: invokevirtual 183	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   453: astore 11
    //   455: aload 11
    //   457: invokestatic 189	bace:a	(Ljava/lang/String;)Ljava/io/File;
    //   460: astore 10
    //   462: new 191	java/io/FileOutputStream
    //   465: dup
    //   466: aload 10
    //   468: invokespecial 194	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   471: astore 10
    //   473: aload_0
    //   474: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   477: getfield 131	com/tencent/mobileqq/mini/widget/CanvasView$2:val$isPngFile	Z
    //   480: ifeq +195 -> 675
    //   483: aload_0
    //   484: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   487: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   490: ldc 196
    //   492: dconst_1
    //   493: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   496: dstore_1
    //   497: aload 9
    //   499: getstatic 202	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   502: dload_1
    //   503: ldc2_w 203
    //   506: dmul
    //   507: d2i
    //   508: aload 10
    //   510: invokevirtual 208	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   513: pop
    //   514: new 71	org/json/JSONObject
    //   517: dup
    //   518: invokespecial 209	org/json/JSONObject:<init>	()V
    //   521: astore 9
    //   523: aload 9
    //   525: ldc 211
    //   527: invokestatic 176	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   530: aload 11
    //   532: invokevirtual 214	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   535: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   538: pop
    //   539: aload_0
    //   540: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   543: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   546: getfield 222	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/AppBrandRuntime;
    //   549: getfield 228	com/tencent/mobileqq/mini/appbrand/AppBrandRuntime:serviceRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   552: aload_0
    //   553: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   556: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   559: aload 9
    //   561: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   564: invokeinterface 235 3 0
    //   569: aload 10
    //   571: ifnull +13 -> 584
    //   574: aload 10
    //   576: invokevirtual 238	java/io/FileOutputStream:flush	()V
    //   579: aload 10
    //   581: invokevirtual 241	java/io/FileOutputStream:close	()V
    //   584: aload_0
    //   585: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   588: ifnull +218 -> 806
    //   591: aload_0
    //   592: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   595: invokevirtual 244	android/graphics/Bitmap:isRecycled	()Z
    //   598: ifne +208 -> 806
    //   601: aload_0
    //   602: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   605: invokevirtual 247	android/graphics/Bitmap:recycle	()V
    //   608: return
    //   609: astore 9
    //   611: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$100	()Ljava/lang/String;
    //   614: iconst_2
    //   615: new 101	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   622: ldc 249
    //   624: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 9
    //   629: invokestatic 255	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   632: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 39	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: aload_0
    //   642: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   645: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   648: aload_0
    //   649: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   652: getfield 49	com/tencent/mobileqq/mini/widget/CanvasView$2:val$event	Ljava/lang/String;
    //   655: aconst_null
    //   656: aload_0
    //   657: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   660: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   663: invokevirtual 59	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   666: return
    //   667: getstatic 258	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   670: astore 9
    //   672: goto -370 -> 302
    //   675: aload_0
    //   676: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   679: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   682: ldc_w 260
    //   685: dconst_1
    //   686: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   689: dstore_1
    //   690: aload 9
    //   692: getstatic 263	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   695: dload_1
    //   696: ldc2_w 203
    //   699: dmul
    //   700: d2i
    //   701: aload 10
    //   703: invokevirtual 208	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   706: pop
    //   707: goto -193 -> 514
    //   710: astore 9
    //   712: aload 10
    //   714: ifnull +13 -> 727
    //   717: aload 10
    //   719: invokevirtual 238	java/io/FileOutputStream:flush	()V
    //   722: aload 10
    //   724: invokevirtual 241	java/io/FileOutputStream:close	()V
    //   727: aload_0
    //   728: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   731: ifnull +20 -> 751
    //   734: aload_0
    //   735: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   738: invokevirtual 244	android/graphics/Bitmap:isRecycled	()Z
    //   741: ifne +10 -> 751
    //   744: aload_0
    //   745: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   748: invokevirtual 247	android/graphics/Bitmap:recycle	()V
    //   751: aload 9
    //   753: athrow
    //   754: astore 9
    //   756: aload 9
    //   758: invokevirtual 266	org/json/JSONException:printStackTrace	()V
    //   761: aload_0
    //   762: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   765: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   768: aload_0
    //   769: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   772: getfield 49	com/tencent/mobileqq/mini/widget/CanvasView$2:val$event	Ljava/lang/String;
    //   775: aconst_null
    //   776: aload_0
    //   777: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   780: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   783: invokevirtual 59	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   786: goto -217 -> 569
    //   789: astore 9
    //   791: aconst_null
    //   792: astore 10
    //   794: goto -82 -> 712
    //   797: goto -510 -> 287
    //   800: goto -674 -> 126
    //   803: goto -694 -> 109
    //   806: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	807	0	this	1
    //   496	200	1	d	double
    //   264	19	3	f	float
    //   160	256	4	i	int
    //   140	281	5	j	int
    //   65	351	6	k	int
    //   90	331	7	m	int
    //   156	31	8	n	int
    //   300	260	9	localObject1	Object
    //   609	19	9	localThrowable	java.lang.Throwable
    //   670	21	9	localConfig	android.graphics.Bitmap.Config
    //   710	42	9	localObject2	Object
    //   754	3	9	localJSONException	org.json.JSONException
    //   789	1	9	localObject3	Object
    //   322	471	10	localObject4	Object
    //   351	180	11	localObject5	Object
    //   424	9	12	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   0	41	609	java/lang/Throwable
    //   42	92	609	java/lang/Throwable
    //   97	109	609	java/lang/Throwable
    //   114	126	609	java/lang/Throwable
    //   126	158	609	java/lang/Throwable
    //   167	182	609	java/lang/Throwable
    //   191	206	609	java/lang/Throwable
    //   206	249	609	java/lang/Throwable
    //   249	265	609	java/lang/Throwable
    //   287	302	609	java/lang/Throwable
    //   302	462	609	java/lang/Throwable
    //   574	584	609	java/lang/Throwable
    //   584	608	609	java/lang/Throwable
    //   667	672	609	java/lang/Throwable
    //   717	727	609	java/lang/Throwable
    //   727	751	609	java/lang/Throwable
    //   751	754	609	java/lang/Throwable
    //   473	514	710	finally
    //   514	569	710	finally
    //   675	707	710	finally
    //   756	786	710	finally
    //   514	569	754	org/json/JSONException
    //   462	473	789	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CanvasView.2.1
 * JD-Core Version:    0.7.0.1
 */