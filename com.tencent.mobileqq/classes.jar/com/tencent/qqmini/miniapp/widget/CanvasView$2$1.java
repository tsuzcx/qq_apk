package com.tencent.qqmini.miniapp.widget;

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
    //   1: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   4: ifnonnull +22 -> 26
    //   7: ldc 27
    //   9: ldc 29
    //   11: invokestatic 35	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   18: getfield 41	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   21: invokevirtual 47	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   24: pop
    //   25: return
    //   26: aload_0
    //   27: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   30: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   33: aload_0
    //   34: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   37: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   40: ldc 57
    //   42: dconst_0
    //   43: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   46: invokevirtual 69	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   49: istore 10
    //   51: aload_0
    //   52: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   55: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   58: aload_0
    //   59: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   62: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   65: ldc 71
    //   67: dconst_0
    //   68: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   71: invokevirtual 69	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   74: istore 11
    //   76: iload 10
    //   78: ifgt +896 -> 974
    //   81: aload_0
    //   82: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   85: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   88: invokevirtual 75	com/tencent/qqmini/miniapp/widget/CanvasView:getWidth	()I
    //   91: istore 10
    //   93: iload 11
    //   95: ifgt +876 -> 971
    //   98: aload_0
    //   99: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   102: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   105: invokevirtual 78	com/tencent/qqmini/miniapp/widget/CanvasView:getHeight	()I
    //   108: istore 11
    //   110: aload_0
    //   111: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   114: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   117: ldc 80
    //   119: dconst_0
    //   120: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   123: d2i
    //   124: istore 5
    //   126: aload_0
    //   127: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   130: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   133: ldc 82
    //   135: dconst_0
    //   136: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   139: d2i
    //   140: istore 6
    //   142: iload 5
    //   144: istore 4
    //   146: iload 5
    //   148: ifgt +18 -> 166
    //   151: aload_0
    //   152: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   155: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   158: iload 10
    //   160: i2d
    //   161: invokevirtual 85	com/tencent/qqmini/miniapp/widget/CanvasView:px2mpxInt	(D)I
    //   164: istore 4
    //   166: iload 6
    //   168: istore 5
    //   170: iload 6
    //   172: ifgt +18 -> 190
    //   175: aload_0
    //   176: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   179: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   182: iload 11
    //   184: i2d
    //   185: invokevirtual 85	com/tencent/qqmini/miniapp/widget/CanvasView:px2mpxInt	(D)I
    //   188: istore 5
    //   190: ldc 27
    //   192: new 87	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   199: ldc 90
    //   201: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload 4
    //   206: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: ldc 99
    //   211: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload 5
    //   216: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 105	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aconst_null
    //   226: astore 12
    //   228: aload_0
    //   229: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   232: getfield 109	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$isPngFile	Z
    //   235: ifeq +208 -> 443
    //   238: getstatic 115	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   241: astore 13
    //   243: iload 4
    //   245: iload 5
    //   247: aload 13
    //   249: invokestatic 121	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   252: astore 14
    //   254: aload 14
    //   256: astore 12
    //   258: aload 12
    //   260: ifnonnull +700 -> 960
    //   263: aload_0
    //   264: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   267: getfield 109	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$isPngFile	Z
    //   270: ifeq +195 -> 465
    //   273: ldc2_w 122
    //   276: iload 4
    //   278: i2d
    //   279: ddiv
    //   280: iload 5
    //   282: i2d
    //   283: ddiv
    //   284: ldc2_w 124
    //   287: ddiv
    //   288: invokestatic 131	java/lang/Math:sqrt	(D)D
    //   291: dstore_1
    //   292: dload_1
    //   293: d2f
    //   294: fstore_3
    //   295: fload_3
    //   296: fconst_1
    //   297: fcmpg
    //   298: ifge +662 -> 960
    //   301: iload 4
    //   303: i2f
    //   304: fload_3
    //   305: fmul
    //   306: f2i
    //   307: istore 7
    //   309: fload_3
    //   310: iload 5
    //   312: i2f
    //   313: fmul
    //   314: f2i
    //   315: istore 6
    //   317: iload 7
    //   319: iload 6
    //   321: aload 13
    //   323: invokestatic 121	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   326: astore 14
    //   328: aload 14
    //   330: astore 12
    //   332: iload 6
    //   334: istore 8
    //   336: iload 7
    //   338: istore 9
    //   340: aload 12
    //   342: ifnonnull +636 -> 978
    //   345: iload 7
    //   347: i2d
    //   348: ldc2_w 132
    //   351: ddiv
    //   352: d2i
    //   353: istore 9
    //   355: iload 6
    //   357: i2d
    //   358: ldc2_w 132
    //   361: ddiv
    //   362: d2i
    //   363: istore 6
    //   365: iload 9
    //   367: iload 6
    //   369: aload 13
    //   371: invokestatic 121	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   374: astore 13
    //   376: iload 9
    //   378: istore 7
    //   380: aload 13
    //   382: astore 12
    //   384: aload 12
    //   386: ifnonnull +134 -> 520
    //   389: aload_0
    //   390: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   393: getfield 41	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   396: invokevirtual 47	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   399: pop
    //   400: return
    //   401: astore 12
    //   403: ldc 27
    //   405: new 87	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   412: ldc 135
    //   414: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 12
    //   419: invokestatic 141	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   422: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 35	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_0
    //   432: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   435: getfield 41	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   438: invokevirtual 47	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   441: pop
    //   442: return
    //   443: getstatic 144	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   446: astore 13
    //   448: goto -205 -> 243
    //   451: astore 14
    //   453: ldc 27
    //   455: ldc 146
    //   457: aload 14
    //   459: invokestatic 150	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   462: goto -204 -> 258
    //   465: ldc2_w 122
    //   468: iload 4
    //   470: i2d
    //   471: ddiv
    //   472: iload 5
    //   474: i2d
    //   475: ddiv
    //   476: ldc2_w 124
    //   479: ddiv
    //   480: invokestatic 131	java/lang/Math:sqrt	(D)D
    //   483: d2f
    //   484: fstore_3
    //   485: goto -190 -> 295
    //   488: astore 14
    //   490: ldc 27
    //   492: ldc 152
    //   494: aload 14
    //   496: invokestatic 150	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   499: goto -167 -> 332
    //   502: astore 13
    //   504: ldc 27
    //   506: ldc 154
    //   508: aload 13
    //   510: invokestatic 156	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   513: iload 6
    //   515: istore 8
    //   517: goto +461 -> 978
    //   520: new 158	android/graphics/Canvas
    //   523: dup
    //   524: aload 12
    //   526: invokespecial 161	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   529: astore 13
    //   531: aload 13
    //   533: new 163	android/graphics/PaintFlagsDrawFilter
    //   536: dup
    //   537: iconst_0
    //   538: iconst_3
    //   539: invokespecial 166	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   542: invokevirtual 170	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   545: new 172	android/graphics/Rect
    //   548: dup
    //   549: iconst_0
    //   550: iconst_0
    //   551: iload 7
    //   553: iload 6
    //   555: invokespecial 175	android/graphics/Rect:<init>	(IIII)V
    //   558: astore 14
    //   560: aload_0
    //   561: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   564: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   567: aload_0
    //   568: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   571: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   574: ldc 177
    //   576: dconst_0
    //   577: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   580: invokevirtual 69	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   583: istore 8
    //   585: aload_0
    //   586: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   589: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   592: aload_0
    //   593: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   596: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   599: ldc 179
    //   601: dconst_0
    //   602: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   605: invokevirtual 69	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   608: istore 9
    //   610: new 172	android/graphics/Rect
    //   613: dup
    //   614: iload 8
    //   616: iload 9
    //   618: iload 10
    //   620: iload 8
    //   622: iadd
    //   623: iload 11
    //   625: iload 9
    //   627: iadd
    //   628: invokespecial 175	android/graphics/Rect:<init>	(IIII)V
    //   631: astore 15
    //   633: aload 13
    //   635: aload_0
    //   636: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   639: aload 15
    //   641: aload 14
    //   643: aconst_null
    //   644: invokevirtual 183	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   647: aload_0
    //   648: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   651: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   654: invokestatic 187	com/tencent/qqmini/miniapp/widget/CanvasView:access$200	(Lcom/tencent/qqmini/miniapp/widget/CanvasView;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   657: ldc 189
    //   659: invokeinterface 195 2 0
    //   664: checkcast 189	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   667: aload_0
    //   668: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   671: getfield 199	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$fileType	Ljava/lang/String;
    //   674: invokevirtual 203	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   677: astore 14
    //   679: aload 14
    //   681: invokestatic 209	com/tencent/qqmini/sdk/core/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   684: astore 13
    //   686: new 211	java/io/FileOutputStream
    //   689: dup
    //   690: aload 13
    //   692: invokespecial 214	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   695: astore 13
    //   697: iload 7
    //   699: iload 6
    //   701: imul
    //   702: iload 4
    //   704: idiv
    //   705: iload 5
    //   707: idiv
    //   708: i2f
    //   709: fstore_3
    //   710: aload_0
    //   711: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   714: getfield 109	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$isPngFile	Z
    //   717: ifeq +132 -> 849
    //   720: aload_0
    //   721: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   724: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   727: ldc 216
    //   729: dconst_1
    //   730: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   733: fload_3
    //   734: f2d
    //   735: ddiv
    //   736: dstore_1
    //   737: aload 12
    //   739: getstatic 222	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   742: dload_1
    //   743: ldc2_w 223
    //   746: dmul
    //   747: d2i
    //   748: aload 13
    //   750: invokevirtual 228	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   753: pop
    //   754: new 59	org/json/JSONObject
    //   757: dup
    //   758: invokespecial 229	org/json/JSONObject:<init>	()V
    //   761: astore 12
    //   763: aload 12
    //   765: ldc 231
    //   767: aload_0
    //   768: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   771: getfield 51	com/tencent/qqmini/miniapp/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   774: invokestatic 187	com/tencent/qqmini/miniapp/widget/CanvasView:access$200	(Lcom/tencent/qqmini/miniapp/widget/CanvasView;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   777: ldc 189
    //   779: invokeinterface 195 2 0
    //   784: checkcast 189	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   787: aload 14
    //   789: invokevirtual 234	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   792: invokevirtual 238	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   795: pop
    //   796: aload_0
    //   797: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   800: getfield 41	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   803: aload 12
    //   805: invokevirtual 242	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:ok	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   808: pop
    //   809: aload 13
    //   811: ifnull +13 -> 824
    //   814: aload 13
    //   816: invokevirtual 245	java/io/FileOutputStream:flush	()V
    //   819: aload 13
    //   821: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   824: aload_0
    //   825: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   828: ifnull +149 -> 977
    //   831: aload_0
    //   832: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   835: invokevirtual 252	android/graphics/Bitmap:isRecycled	()Z
    //   838: ifne +139 -> 977
    //   841: aload_0
    //   842: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   845: invokevirtual 255	android/graphics/Bitmap:recycle	()V
    //   848: return
    //   849: aload_0
    //   850: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   853: getfield 55	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$paramObj	Lorg/json/JSONObject;
    //   856: ldc_w 257
    //   859: dconst_1
    //   860: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   863: fload_3
    //   864: f2d
    //   865: ddiv
    //   866: dstore_1
    //   867: aload 12
    //   869: getstatic 260	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   872: dload_1
    //   873: ldc2_w 223
    //   876: dmul
    //   877: d2i
    //   878: aload 13
    //   880: invokevirtual 228	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   883: pop
    //   884: goto -130 -> 754
    //   887: astore 12
    //   889: aload 13
    //   891: ifnull +13 -> 904
    //   894: aload 13
    //   896: invokevirtual 245	java/io/FileOutputStream:flush	()V
    //   899: aload 13
    //   901: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   904: aload_0
    //   905: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   908: ifnull +20 -> 928
    //   911: aload_0
    //   912: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   915: invokevirtual 252	android/graphics/Bitmap:isRecycled	()Z
    //   918: ifne +10 -> 928
    //   921: aload_0
    //   922: getfield 16	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:val$currBitmap	Landroid/graphics/Bitmap;
    //   925: invokevirtual 255	android/graphics/Bitmap:recycle	()V
    //   928: aload 12
    //   930: athrow
    //   931: astore 12
    //   933: aload 12
    //   935: invokevirtual 263	org/json/JSONException:printStackTrace	()V
    //   938: aload_0
    //   939: getfield 14	com/tencent/qqmini/miniapp/widget/CanvasView$2$1:this$1	Lcom/tencent/qqmini/miniapp/widget/CanvasView$2;
    //   942: getfield 41	com/tencent/qqmini/miniapp/widget/CanvasView$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   945: invokevirtual 47	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   948: pop
    //   949: goto -140 -> 809
    //   952: astore 12
    //   954: aconst_null
    //   955: astore 13
    //   957: goto -68 -> 889
    //   960: iload 5
    //   962: istore 6
    //   964: iload 4
    //   966: istore 7
    //   968: goto -636 -> 332
    //   971: goto -861 -> 110
    //   974: goto -881 -> 93
    //   977: return
    //   978: iload 8
    //   980: istore 6
    //   982: iload 9
    //   984: istore 7
    //   986: goto -602 -> 384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	989	0	this	1
    //   291	582	1	d	double
    //   294	570	3	f	float
    //   144	821	4	i	int
    //   124	837	5	j	int
    //   140	841	6	k	int
    //   307	678	7	m	int
    //   334	645	8	n	int
    //   338	645	9	i1	int
    //   49	574	10	i2	int
    //   74	554	11	i3	int
    //   226	159	12	localObject1	Object
    //   401	337	12	localThrowable1	java.lang.Throwable
    //   761	107	12	localJSONObject	org.json.JSONObject
    //   887	42	12	localObject2	Object
    //   931	3	12	localJSONException	org.json.JSONException
    //   952	1	12	localObject3	Object
    //   241	206	13	localObject4	Object
    //   502	7	13	localThrowable2	java.lang.Throwable
    //   529	427	13	localObject5	Object
    //   252	77	14	localBitmap	Bitmap
    //   451	7	14	localThrowable3	java.lang.Throwable
    //   488	7	14	localThrowable4	java.lang.Throwable
    //   558	230	14	localObject6	Object
    //   631	9	15	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   0	25	401	java/lang/Throwable
    //   26	76	401	java/lang/Throwable
    //   81	93	401	java/lang/Throwable
    //   98	110	401	java/lang/Throwable
    //   110	142	401	java/lang/Throwable
    //   151	166	401	java/lang/Throwable
    //   175	190	401	java/lang/Throwable
    //   190	225	401	java/lang/Throwable
    //   228	243	401	java/lang/Throwable
    //   263	292	401	java/lang/Throwable
    //   389	400	401	java/lang/Throwable
    //   443	448	401	java/lang/Throwable
    //   453	462	401	java/lang/Throwable
    //   465	485	401	java/lang/Throwable
    //   490	499	401	java/lang/Throwable
    //   504	513	401	java/lang/Throwable
    //   520	686	401	java/lang/Throwable
    //   814	824	401	java/lang/Throwable
    //   824	848	401	java/lang/Throwable
    //   894	904	401	java/lang/Throwable
    //   904	928	401	java/lang/Throwable
    //   928	931	401	java/lang/Throwable
    //   243	254	451	java/lang/Throwable
    //   317	328	488	java/lang/Throwable
    //   365	376	502	java/lang/Throwable
    //   697	754	887	finally
    //   754	809	887	finally
    //   849	884	887	finally
    //   933	949	887	finally
    //   754	809	931	org/json/JSONException
    //   686	697	952	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.2.1
 * JD-Core Version:    0.7.0.1
 */