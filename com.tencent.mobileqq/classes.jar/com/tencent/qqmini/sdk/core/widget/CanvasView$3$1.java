package com.tencent.qqmini.sdk.core.widget;

import android.graphics.Bitmap;

class CanvasView$3$1
  implements Runnable
{
  CanvasView$3$1(CanvasView.3 param3, Bitmap paramBitmap) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   4: ifnonnull +39 -> 43
    //   7: invokestatic 29	com/tencent/qqmini/sdk/core/widget/CanvasView:a	()Ljava/lang/String;
    //   10: ldc 31
    //   12: invokestatic 37	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   19: getfield 42	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_Bgms	Lbgms;
    //   22: aload_0
    //   23: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   26: getfield 45	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: aconst_null
    //   30: aload_0
    //   31: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   34: getfield 48	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_Int	I
    //   37: invokeinterface 53 4 0
    //   42: return
    //   43: aload_0
    //   44: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   47: getfield 57	com/tencent/qqmini/sdk/core/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/sdk/core/widget/CanvasView;
    //   50: aload_0
    //   51: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   54: getfield 60	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   57: ldc 62
    //   59: dconst_0
    //   60: invokevirtual 68	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   63: invokevirtual 72	com/tencent/qqmini/sdk/core/widget/CanvasView:b	(D)I
    //   66: istore 6
    //   68: aload_0
    //   69: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   72: getfield 57	com/tencent/qqmini/sdk/core/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/sdk/core/widget/CanvasView;
    //   75: aload_0
    //   76: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   79: getfield 60	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   82: ldc 74
    //   84: dconst_0
    //   85: invokevirtual 68	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   88: invokevirtual 72	com/tencent/qqmini/sdk/core/widget/CanvasView:b	(D)I
    //   91: istore 7
    //   93: iload 6
    //   95: ifgt +698 -> 793
    //   98: aload_0
    //   99: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   102: getfield 57	com/tencent/qqmini/sdk/core/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/sdk/core/widget/CanvasView;
    //   105: invokevirtual 78	com/tencent/qqmini/sdk/core/widget/CanvasView:getWidth	()I
    //   108: istore 6
    //   110: iload 7
    //   112: ifgt +678 -> 790
    //   115: aload_0
    //   116: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   119: getfield 57	com/tencent/qqmini/sdk/core/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/sdk/core/widget/CanvasView;
    //   122: invokevirtual 81	com/tencent/qqmini/sdk/core/widget/CanvasView:getHeight	()I
    //   125: istore 7
    //   127: aload_0
    //   128: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   131: getfield 60	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   134: ldc 83
    //   136: dconst_0
    //   137: invokevirtual 68	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   140: d2i
    //   141: istore 5
    //   143: aload_0
    //   144: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   147: getfield 60	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   150: ldc 85
    //   152: dconst_0
    //   153: invokevirtual 68	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   156: d2i
    //   157: istore 8
    //   159: iload 5
    //   161: istore 4
    //   163: iload 5
    //   165: ifgt +18 -> 183
    //   168: aload_0
    //   169: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   172: getfield 57	com/tencent/qqmini/sdk/core/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/sdk/core/widget/CanvasView;
    //   175: iload 6
    //   177: i2d
    //   178: invokevirtual 87	com/tencent/qqmini/sdk/core/widget/CanvasView:a	(D)I
    //   181: istore 4
    //   183: iload 8
    //   185: istore 5
    //   187: iload 8
    //   189: ifgt +18 -> 207
    //   192: aload_0
    //   193: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   196: getfield 57	com/tencent/qqmini/sdk/core/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/sdk/core/widget/CanvasView;
    //   199: iload 7
    //   201: i2d
    //   202: invokevirtual 87	com/tencent/qqmini/sdk/core/widget/CanvasView:a	(D)I
    //   205: istore 5
    //   207: invokestatic 29	com/tencent/qqmini/sdk/core/widget/CanvasView:a	()Ljava/lang/String;
    //   210: new 89	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   217: ldc 92
    //   219: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload 4
    //   224: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: ldc 101
    //   229: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 5
    //   234: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 107	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: ldc 108
    //   245: iload 4
    //   247: i2f
    //   248: fdiv
    //   249: ldc 109
    //   251: iload 5
    //   253: i2f
    //   254: fdiv
    //   255: invokestatic 115	java/lang/Math:min	(FF)F
    //   258: fstore_3
    //   259: fload_3
    //   260: fconst_1
    //   261: fcmpg
    //   262: ifge +525 -> 787
    //   265: iload 4
    //   267: i2f
    //   268: fload_3
    //   269: fmul
    //   270: f2i
    //   271: istore 4
    //   273: iload 5
    //   275: i2f
    //   276: fload_3
    //   277: fmul
    //   278: f2i
    //   279: istore 5
    //   281: aload_0
    //   282: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   285: getfield 118	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_Boolean	Z
    //   288: ifeq +368 -> 656
    //   291: getstatic 124	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   294: astore 9
    //   296: iload 4
    //   298: iload 5
    //   300: aload 9
    //   302: invokestatic 130	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   305: astore 9
    //   307: new 132	android/graphics/Canvas
    //   310: dup
    //   311: aload 9
    //   313: invokespecial 135	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   316: astore 10
    //   318: aload 10
    //   320: new 137	android/graphics/PaintFlagsDrawFilter
    //   323: dup
    //   324: iconst_0
    //   325: iconst_3
    //   326: invokespecial 140	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   329: invokevirtual 144	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   332: new 146	android/graphics/Rect
    //   335: dup
    //   336: iconst_0
    //   337: iconst_0
    //   338: iload 4
    //   340: iload 5
    //   342: invokespecial 149	android/graphics/Rect:<init>	(IIII)V
    //   345: astore 11
    //   347: aload_0
    //   348: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   351: getfield 57	com/tencent/qqmini/sdk/core/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/sdk/core/widget/CanvasView;
    //   354: aload_0
    //   355: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   358: getfield 60	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   361: ldc 151
    //   363: dconst_0
    //   364: invokevirtual 68	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   367: invokevirtual 72	com/tencent/qqmini/sdk/core/widget/CanvasView:b	(D)I
    //   370: istore 4
    //   372: aload_0
    //   373: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   376: getfield 57	com/tencent/qqmini/sdk/core/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/sdk/core/widget/CanvasView;
    //   379: aload_0
    //   380: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   383: getfield 60	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   386: ldc 153
    //   388: dconst_0
    //   389: invokevirtual 68	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   392: invokevirtual 72	com/tencent/qqmini/sdk/core/widget/CanvasView:b	(D)I
    //   395: istore 5
    //   397: new 146	android/graphics/Rect
    //   400: dup
    //   401: iload 4
    //   403: iload 5
    //   405: iload 6
    //   407: iload 4
    //   409: iadd
    //   410: iload 7
    //   412: iload 5
    //   414: iadd
    //   415: invokespecial 149	android/graphics/Rect:<init>	(IIII)V
    //   418: astore 12
    //   420: aload 10
    //   422: aload_0
    //   423: getfield 15	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   426: aload 12
    //   428: aload 11
    //   430: aconst_null
    //   431: invokevirtual 157	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   434: invokestatic 162	bgjm:a	()Lbgjm;
    //   437: aload_0
    //   438: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   441: getfield 164	com/tencent/qqmini/sdk/core/widget/CanvasView$3:b	Ljava/lang/String;
    //   444: invokevirtual 167	bgjm:b	(Ljava/lang/String;)Ljava/lang/String;
    //   447: astore 11
    //   449: aload 11
    //   451: invokestatic 172	bgkv:a	(Ljava/lang/String;)Ljava/io/File;
    //   454: astore 10
    //   456: new 174	java/io/FileOutputStream
    //   459: dup
    //   460: aload 10
    //   462: invokespecial 177	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   465: astore 10
    //   467: aload_0
    //   468: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   471: getfield 118	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_Boolean	Z
    //   474: ifeq +190 -> 664
    //   477: aload_0
    //   478: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   481: getfield 60	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   484: ldc 179
    //   486: dconst_1
    //   487: invokevirtual 68	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   490: dstore_1
    //   491: aload 9
    //   493: getstatic 185	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   496: dload_1
    //   497: ldc2_w 186
    //   500: dmul
    //   501: d2i
    //   502: aload 10
    //   504: invokevirtual 191	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   507: pop
    //   508: new 64	org/json/JSONObject
    //   511: dup
    //   512: invokespecial 192	org/json/JSONObject:<init>	()V
    //   515: astore 9
    //   517: aload 9
    //   519: ldc 194
    //   521: invokestatic 162	bgjm:a	()Lbgjm;
    //   524: aload 11
    //   526: invokevirtual 196	bgjm:e	(Ljava/lang/String;)Ljava/lang/String;
    //   529: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   532: pop
    //   533: aload_0
    //   534: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   537: getfield 203	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_Bghn	Lbghn;
    //   540: aload_0
    //   541: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   544: getfield 48	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_Int	I
    //   547: aload 9
    //   549: invokevirtual 204	org/json/JSONObject:toString	()Ljava/lang/String;
    //   552: invokeinterface 209 3 0
    //   557: aload 10
    //   559: ifnull +13 -> 572
    //   562: aload 10
    //   564: invokevirtual 212	java/io/FileOutputStream:flush	()V
    //   567: aload 10
    //   569: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   572: aload_0
    //   573: getfield 15	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   576: ifnull +220 -> 796
    //   579: aload_0
    //   580: getfield 15	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   583: invokevirtual 219	android/graphics/Bitmap:isRecycled	()Z
    //   586: ifne +210 -> 796
    //   589: aload_0
    //   590: getfield 15	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   593: invokevirtual 222	android/graphics/Bitmap:recycle	()V
    //   596: return
    //   597: astore 9
    //   599: invokestatic 29	com/tencent/qqmini/sdk/core/widget/CanvasView:a	()Ljava/lang/String;
    //   602: new 89	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   609: ldc 224
    //   611: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload 9
    //   616: invokestatic 230	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   619: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 37	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload_0
    //   629: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   632: getfield 42	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_Bgms	Lbgms;
    //   635: aload_0
    //   636: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   639: getfield 45	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   642: aconst_null
    //   643: aload_0
    //   644: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   647: getfield 48	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_Int	I
    //   650: invokeinterface 53 4 0
    //   655: return
    //   656: getstatic 233	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   659: astore 9
    //   661: goto -365 -> 296
    //   664: aload_0
    //   665: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   668: getfield 60	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   671: ldc 235
    //   673: dconst_1
    //   674: invokevirtual 68	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   677: dstore_1
    //   678: aload 9
    //   680: getstatic 238	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   683: dload_1
    //   684: ldc2_w 186
    //   687: dmul
    //   688: d2i
    //   689: aload 10
    //   691: invokevirtual 191	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   694: pop
    //   695: goto -187 -> 508
    //   698: astore 9
    //   700: aload 10
    //   702: ifnull +13 -> 715
    //   705: aload 10
    //   707: invokevirtual 212	java/io/FileOutputStream:flush	()V
    //   710: aload 10
    //   712: invokevirtual 215	java/io/FileOutputStream:close	()V
    //   715: aload_0
    //   716: getfield 15	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   719: ifnull +20 -> 739
    //   722: aload_0
    //   723: getfield 15	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   726: invokevirtual 219	android/graphics/Bitmap:isRecycled	()Z
    //   729: ifne +10 -> 739
    //   732: aload_0
    //   733: getfield 15	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   736: invokevirtual 222	android/graphics/Bitmap:recycle	()V
    //   739: aload 9
    //   741: athrow
    //   742: astore 9
    //   744: aload 9
    //   746: invokevirtual 241	org/json/JSONException:printStackTrace	()V
    //   749: aload_0
    //   750: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   753: getfield 42	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_Bgms	Lbgms;
    //   756: aload_0
    //   757: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   760: getfield 45	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   763: aconst_null
    //   764: aload_0
    //   765: getfield 13	com/tencent/qqmini/sdk/core/widget/CanvasView$3$1:jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCanvasView$3	Lcom/tencent/qqmini/sdk/core/widget/CanvasView$3;
    //   768: getfield 48	com/tencent/qqmini/sdk/core/widget/CanvasView$3:jdField_a_of_type_Int	I
    //   771: invokeinterface 53 4 0
    //   776: goto -219 -> 557
    //   779: astore 9
    //   781: aconst_null
    //   782: astore 10
    //   784: goto -84 -> 700
    //   787: goto -506 -> 281
    //   790: goto -663 -> 127
    //   793: goto -683 -> 110
    //   796: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	797	0	this	1
    //   490	194	1	d	double
    //   258	19	3	f	float
    //   161	249	4	i	int
    //   141	274	5	j	int
    //   66	344	6	k	int
    //   91	324	7	m	int
    //   157	31	8	n	int
    //   294	254	9	localObject1	Object
    //   597	18	9	localThrowable	java.lang.Throwable
    //   659	20	9	localConfig	android.graphics.Bitmap.Config
    //   698	42	9	localObject2	Object
    //   742	3	9	localJSONException	org.json.JSONException
    //   779	1	9	localObject3	Object
    //   316	467	10	localObject4	Object
    //   345	180	11	localObject5	Object
    //   418	9	12	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   0	42	597	java/lang/Throwable
    //   43	93	597	java/lang/Throwable
    //   98	110	597	java/lang/Throwable
    //   115	127	597	java/lang/Throwable
    //   127	159	597	java/lang/Throwable
    //   168	183	597	java/lang/Throwable
    //   192	207	597	java/lang/Throwable
    //   207	259	597	java/lang/Throwable
    //   281	296	597	java/lang/Throwable
    //   296	456	597	java/lang/Throwable
    //   562	572	597	java/lang/Throwable
    //   572	596	597	java/lang/Throwable
    //   656	661	597	java/lang/Throwable
    //   705	715	597	java/lang/Throwable
    //   715	739	597	java/lang/Throwable
    //   739	742	597	java/lang/Throwable
    //   467	508	698	finally
    //   508	557	698	finally
    //   664	695	698	finally
    //   744	776	698	finally
    //   508	557	742	org/json/JSONException
    //   456	467	779	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.CanvasView.3.1
 * JD-Core Version:    0.7.0.1
 */