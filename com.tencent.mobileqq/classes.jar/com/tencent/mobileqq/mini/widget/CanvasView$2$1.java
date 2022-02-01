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
    //   7: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$200	()Ljava/lang/String;
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
    //   94: ifgt +933 -> 1027
    //   97: aload_0
    //   98: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   101: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   104: invokevirtual 85	com/tencent/mobileqq/mini/widget/CanvasView:getWidth	()I
    //   107: istore 10
    //   109: iload 11
    //   111: ifgt +913 -> 1024
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
    //   212: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$200	()Ljava/lang/String;
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
    //   259: ifeq +242 -> 501
    //   262: getstatic 129	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   265: astore 13
    //   267: iload 4
    //   269: iload 5
    //   271: aload 13
    //   273: invokestatic 135	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   276: astore 14
    //   278: aload 14
    //   280: astore 12
    //   282: aload 12
    //   284: ifnonnull +729 -> 1013
    //   287: aload_0
    //   288: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   291: getfield 123	com/tencent/mobileqq/mini/widget/CanvasView$2:val$isPngFile	Z
    //   294: ifeq +229 -> 523
    //   297: ldc2_w 136
    //   300: iload 4
    //   302: i2d
    //   303: ddiv
    //   304: iload 5
    //   306: i2d
    //   307: ddiv
    //   308: ldc2_w 138
    //   311: ddiv
    //   312: invokestatic 145	java/lang/Math:sqrt	(D)D
    //   315: dstore_1
    //   316: dload_1
    //   317: d2f
    //   318: fstore_3
    //   319: fload_3
    //   320: fconst_1
    //   321: fcmpg
    //   322: ifge +691 -> 1013
    //   325: iload 4
    //   327: i2f
    //   328: fload_3
    //   329: fmul
    //   330: f2i
    //   331: istore 8
    //   333: fload_3
    //   334: iload 5
    //   336: i2f
    //   337: fmul
    //   338: f2i
    //   339: istore 6
    //   341: iload 8
    //   343: iload 6
    //   345: aload 13
    //   347: invokestatic 135	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   350: astore 14
    //   352: aload 14
    //   354: astore 12
    //   356: iload 6
    //   358: istore 7
    //   360: iload 8
    //   362: istore 9
    //   364: aload 12
    //   366: ifnonnull +665 -> 1031
    //   369: iload 8
    //   371: i2d
    //   372: ldc2_w 146
    //   375: ddiv
    //   376: d2i
    //   377: istore 9
    //   379: iload 6
    //   381: i2d
    //   382: ldc2_w 146
    //   385: ddiv
    //   386: d2i
    //   387: istore 7
    //   389: iload 9
    //   391: iload 7
    //   393: aload 13
    //   395: invokestatic 135	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   398: astore 13
    //   400: aload 13
    //   402: astore 12
    //   404: iload 7
    //   406: istore 6
    //   408: iload 9
    //   410: istore 7
    //   412: aload 12
    //   414: ifnonnull +162 -> 576
    //   417: aload_0
    //   418: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   421: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   424: aload_0
    //   425: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   428: getfield 49	com/tencent/mobileqq/mini/widget/CanvasView$2:val$event	Ljava/lang/String;
    //   431: aconst_null
    //   432: aload_0
    //   433: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   436: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   439: invokevirtual 59	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   442: return
    //   443: astore 12
    //   445: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$200	()Ljava/lang/String;
    //   448: iconst_2
    //   449: new 101	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   456: ldc 149
    //   458: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 12
    //   463: invokestatic 155	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   466: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 39	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: aload_0
    //   476: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   479: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   482: aload_0
    //   483: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   486: getfield 49	com/tencent/mobileqq/mini/widget/CanvasView$2:val$event	Ljava/lang/String;
    //   489: aconst_null
    //   490: aload_0
    //   491: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   494: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   497: invokevirtual 59	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   500: return
    //   501: getstatic 158	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   504: astore 13
    //   506: goto -239 -> 267
    //   509: astore 14
    //   511: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$200	()Ljava/lang/String;
    //   514: iconst_2
    //   515: ldc 160
    //   517: invokestatic 163	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: goto -238 -> 282
    //   523: ldc2_w 136
    //   526: iload 4
    //   528: i2d
    //   529: ddiv
    //   530: iload 5
    //   532: i2d
    //   533: ddiv
    //   534: ldc2_w 164
    //   537: ddiv
    //   538: invokestatic 145	java/lang/Math:sqrt	(D)D
    //   541: d2f
    //   542: fstore_3
    //   543: goto -224 -> 319
    //   546: astore 14
    //   548: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$200	()Ljava/lang/String;
    //   551: iconst_2
    //   552: ldc 167
    //   554: invokestatic 163	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: goto -201 -> 356
    //   560: astore 13
    //   562: invokestatic 31	com/tencent/mobileqq/mini/widget/CanvasView:access$200	()Ljava/lang/String;
    //   565: iconst_2
    //   566: ldc 169
    //   568: aload 13
    //   570: invokestatic 172	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   573: goto +458 -> 1031
    //   576: new 174	android/graphics/Canvas
    //   579: dup
    //   580: aload 12
    //   582: invokespecial 177	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   585: astore 13
    //   587: aload 13
    //   589: new 179	android/graphics/PaintFlagsDrawFilter
    //   592: dup
    //   593: iconst_0
    //   594: iconst_3
    //   595: invokespecial 182	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   598: invokevirtual 186	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   601: new 188	android/graphics/Rect
    //   604: dup
    //   605: iconst_0
    //   606: iconst_0
    //   607: iload 7
    //   609: iload 6
    //   611: invokespecial 191	android/graphics/Rect:<init>	(IIII)V
    //   614: astore 14
    //   616: aload_0
    //   617: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   620: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   623: aload_0
    //   624: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   627: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   630: ldc 193
    //   632: dconst_0
    //   633: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   636: invokevirtual 79	com/tencent/mobileqq/mini/widget/CanvasView:mpx2pxInt	(D)I
    //   639: istore 8
    //   641: aload_0
    //   642: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   645: getfield 63	com/tencent/mobileqq/mini/widget/CanvasView$2:this$0	Lcom/tencent/mobileqq/mini/widget/CanvasView;
    //   648: aload_0
    //   649: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   652: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   655: ldc 195
    //   657: dconst_0
    //   658: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   661: invokevirtual 79	com/tencent/mobileqq/mini/widget/CanvasView:mpx2pxInt	(D)I
    //   664: istore 9
    //   666: new 188	android/graphics/Rect
    //   669: dup
    //   670: iload 8
    //   672: iload 9
    //   674: iload 10
    //   676: iload 8
    //   678: iadd
    //   679: iload 11
    //   681: iload 9
    //   683: iadd
    //   684: invokespecial 191	android/graphics/Rect:<init>	(IIII)V
    //   687: astore 15
    //   689: aload 13
    //   691: aload_0
    //   692: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   695: aload 15
    //   697: aload 14
    //   699: aconst_null
    //   700: invokevirtual 199	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   703: invokestatic 205	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   706: aload_0
    //   707: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   710: getfield 208	com/tencent/mobileqq/mini/widget/CanvasView$2:val$fileType	Ljava/lang/String;
    //   713: invokevirtual 212	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   716: astore 14
    //   718: aload 14
    //   720: invokestatic 218	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   723: astore 13
    //   725: new 220	java/io/FileOutputStream
    //   728: dup
    //   729: aload 13
    //   731: invokespecial 223	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   734: astore 13
    //   736: iload 7
    //   738: iload 6
    //   740: imul
    //   741: iload 4
    //   743: idiv
    //   744: iload 5
    //   746: idiv
    //   747: i2f
    //   748: fstore_3
    //   749: aload_0
    //   750: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   753: getfield 123	com/tencent/mobileqq/mini/widget/CanvasView$2:val$isPngFile	Z
    //   756: ifeq +132 -> 888
    //   759: aload_0
    //   760: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   763: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   766: ldc 225
    //   768: dconst_1
    //   769: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   772: fload_3
    //   773: f2d
    //   774: ddiv
    //   775: dstore_1
    //   776: aload 12
    //   778: getstatic 231	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   781: dload_1
    //   782: ldc2_w 232
    //   785: dmul
    //   786: d2i
    //   787: aload 13
    //   789: invokevirtual 237	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   792: pop
    //   793: new 71	org/json/JSONObject
    //   796: dup
    //   797: invokespecial 238	org/json/JSONObject:<init>	()V
    //   800: astore 12
    //   802: aload 12
    //   804: ldc 240
    //   806: invokestatic 205	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   809: aload 14
    //   811: invokevirtual 243	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   814: invokevirtual 247	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   817: pop
    //   818: aload_0
    //   819: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   822: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   825: getfield 251	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/AppBrandRuntime;
    //   828: getfield 257	com/tencent/mobileqq/mini/appbrand/AppBrandRuntime:serviceRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   831: aload_0
    //   832: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   835: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   838: aload 12
    //   840: invokevirtual 258	org/json/JSONObject:toString	()Ljava/lang/String;
    //   843: invokeinterface 264 3 0
    //   848: aload 13
    //   850: ifnull +13 -> 863
    //   853: aload 13
    //   855: invokevirtual 267	java/io/FileOutputStream:flush	()V
    //   858: aload 13
    //   860: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   863: aload_0
    //   864: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   867: ifnull +163 -> 1030
    //   870: aload_0
    //   871: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   874: invokevirtual 273	android/graphics/Bitmap:isRecycled	()Z
    //   877: ifne +153 -> 1030
    //   880: aload_0
    //   881: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   884: invokevirtual 276	android/graphics/Bitmap:recycle	()V
    //   887: return
    //   888: aload_0
    //   889: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   892: getfield 67	com/tencent/mobileqq/mini/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   895: ldc_w 278
    //   898: dconst_1
    //   899: invokevirtual 75	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   902: fload_3
    //   903: f2d
    //   904: ddiv
    //   905: dstore_1
    //   906: aload 12
    //   908: getstatic 281	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   911: dload_1
    //   912: ldc2_w 232
    //   915: dmul
    //   916: d2i
    //   917: aload 13
    //   919: invokevirtual 237	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   922: pop
    //   923: goto -130 -> 793
    //   926: astore 12
    //   928: aload 13
    //   930: ifnull +13 -> 943
    //   933: aload 13
    //   935: invokevirtual 267	java/io/FileOutputStream:flush	()V
    //   938: aload 13
    //   940: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   943: aload_0
    //   944: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   947: ifnull +20 -> 967
    //   950: aload_0
    //   951: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   954: invokevirtual 273	android/graphics/Bitmap:isRecycled	()Z
    //   957: ifne +10 -> 967
    //   960: aload_0
    //   961: getfield 16	com/tencent/mobileqq/mini/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   964: invokevirtual 276	android/graphics/Bitmap:recycle	()V
    //   967: aload 12
    //   969: athrow
    //   970: astore 12
    //   972: aload 12
    //   974: invokevirtual 284	org/json/JSONException:printStackTrace	()V
    //   977: aload_0
    //   978: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   981: getfield 45	com/tencent/mobileqq/mini/widget/CanvasView$2:val$wc	Lcom/tencent/mobileqq/mini/appbrand/page/WebviewContainer;
    //   984: aload_0
    //   985: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   988: getfield 49	com/tencent/mobileqq/mini/widget/CanvasView$2:val$event	Ljava/lang/String;
    //   991: aconst_null
    //   992: aload_0
    //   993: getfield 14	com/tencent/mobileqq/mini/widget/CanvasView$2$1:this$1	Lcom/tencent/mobileqq/mini/widget/CanvasView$2;
    //   996: getfield 53	com/tencent/mobileqq/mini/widget/CanvasView$2:val$callBackId	I
    //   999: invokevirtual 59	com/tencent/mobileqq/mini/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   1002: goto -154 -> 848
    //   1005: astore 12
    //   1007: aconst_null
    //   1008: astore 13
    //   1010: goto -82 -> 928
    //   1013: iload 5
    //   1015: istore 6
    //   1017: iload 4
    //   1019: istore 8
    //   1021: goto -665 -> 356
    //   1024: goto -898 -> 126
    //   1027: goto -918 -> 109
    //   1030: return
    //   1031: iload 7
    //   1033: istore 6
    //   1035: iload 9
    //   1037: istore 7
    //   1039: goto -627 -> 412
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1042	0	this	1
    //   315	597	1	d	double
    //   318	585	3	f	float
    //   160	858	4	i	int
    //   140	874	5	j	int
    //   156	878	6	k	int
    //   358	680	7	m	int
    //   331	689	8	n	int
    //   362	674	9	i1	int
    //   65	614	10	i2	int
    //   90	594	11	i3	int
    //   250	163	12	localObject1	Object
    //   443	334	12	localThrowable1	java.lang.Throwable
    //   800	107	12	localJSONObject	org.json.JSONObject
    //   926	42	12	localObject2	Object
    //   970	3	12	localJSONException	org.json.JSONException
    //   1005	1	12	localObject3	Object
    //   265	240	13	localObject4	Object
    //   560	9	13	localThrowable2	java.lang.Throwable
    //   585	424	13	localObject5	Object
    //   276	77	14	localBitmap	Bitmap
    //   509	1	14	localThrowable3	java.lang.Throwable
    //   546	1	14	localThrowable4	java.lang.Throwable
    //   614	196	14	localObject6	Object
    //   687	9	15	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   0	41	443	java/lang/Throwable
    //   42	92	443	java/lang/Throwable
    //   97	109	443	java/lang/Throwable
    //   114	126	443	java/lang/Throwable
    //   126	158	443	java/lang/Throwable
    //   167	182	443	java/lang/Throwable
    //   191	206	443	java/lang/Throwable
    //   206	249	443	java/lang/Throwable
    //   252	267	443	java/lang/Throwable
    //   287	316	443	java/lang/Throwable
    //   417	442	443	java/lang/Throwable
    //   501	506	443	java/lang/Throwable
    //   511	520	443	java/lang/Throwable
    //   523	543	443	java/lang/Throwable
    //   548	557	443	java/lang/Throwable
    //   562	573	443	java/lang/Throwable
    //   576	725	443	java/lang/Throwable
    //   853	863	443	java/lang/Throwable
    //   863	887	443	java/lang/Throwable
    //   933	943	443	java/lang/Throwable
    //   943	967	443	java/lang/Throwable
    //   967	970	443	java/lang/Throwable
    //   267	278	509	java/lang/Throwable
    //   341	352	546	java/lang/Throwable
    //   389	400	560	java/lang/Throwable
    //   736	793	926	finally
    //   793	848	926	finally
    //   888	923	926	finally
    //   972	1002	926	finally
    //   793	848	970	org/json/JSONException
    //   725	736	1005	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CanvasView.2.1
 * JD-Core Version:    0.7.0.1
 */