package com.tencent.qqmini.sdk.runtime.widget;

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
    //   1: getfield 15	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   4: ifnonnull +39 -> 43
    //   7: ldc 26
    //   9: ldc 28
    //   11: invokestatic 34	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   18: getfield 39	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer	Lcom/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer;
    //   21: invokevirtual 44	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:a	()Lcom/tencent/qqmini/sdk/runtime/core/page/PageWebviewContainer;
    //   24: aload_0
    //   25: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   28: getfield 47	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: aconst_null
    //   32: aload_0
    //   33: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   36: getfield 50	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_Int	I
    //   39: invokevirtual 56	com/tencent/qqmini/sdk/runtime/core/page/PageWebviewContainer:c	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   42: return
    //   43: aload_0
    //   44: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   47: getfield 60	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView;
    //   50: aload_0
    //   51: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   54: getfield 63	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   57: ldc 65
    //   59: dconst_0
    //   60: invokevirtual 71	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   63: invokevirtual 77	com/tencent/qqmini/sdk/runtime/widget/CanvasView:b	(D)I
    //   66: istore 10
    //   68: aload_0
    //   69: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   72: getfield 60	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView;
    //   75: aload_0
    //   76: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   79: getfield 63	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   82: ldc 79
    //   84: dconst_0
    //   85: invokevirtual 71	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   88: invokevirtual 77	com/tencent/qqmini/sdk/runtime/widget/CanvasView:b	(D)I
    //   91: istore 11
    //   93: iload 10
    //   95: ifgt +922 -> 1017
    //   98: aload_0
    //   99: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   102: getfield 60	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView;
    //   105: invokevirtual 83	com/tencent/qqmini/sdk/runtime/widget/CanvasView:getWidth	()I
    //   108: istore 10
    //   110: iload 11
    //   112: ifgt +902 -> 1014
    //   115: aload_0
    //   116: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   119: getfield 60	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView;
    //   122: invokevirtual 86	com/tencent/qqmini/sdk/runtime/widget/CanvasView:getHeight	()I
    //   125: istore 11
    //   127: aload_0
    //   128: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   131: getfield 63	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   134: ldc 88
    //   136: dconst_0
    //   137: invokevirtual 71	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   140: d2i
    //   141: istore 5
    //   143: aload_0
    //   144: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   147: getfield 63	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   150: ldc 90
    //   152: dconst_0
    //   153: invokevirtual 71	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   156: d2i
    //   157: istore 6
    //   159: iload 5
    //   161: istore 4
    //   163: iload 5
    //   165: ifgt +18 -> 183
    //   168: aload_0
    //   169: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   172: getfield 60	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView;
    //   175: iload 10
    //   177: i2d
    //   178: invokevirtual 92	com/tencent/qqmini/sdk/runtime/widget/CanvasView:a	(D)I
    //   181: istore 4
    //   183: iload 6
    //   185: istore 5
    //   187: iload 6
    //   189: ifgt +18 -> 207
    //   192: aload_0
    //   193: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   196: getfield 60	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView;
    //   199: iload 11
    //   201: i2d
    //   202: invokevirtual 92	com/tencent/qqmini/sdk/runtime/widget/CanvasView:a	(D)I
    //   205: istore 5
    //   207: ldc 26
    //   209: new 94	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   216: ldc 97
    //   218: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 4
    //   223: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc 106
    //   228: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload 5
    //   233: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 113	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aconst_null
    //   243: astore 12
    //   245: aload_0
    //   246: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   249: getfield 116	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_Boolean	Z
    //   252: ifeq +247 -> 499
    //   255: getstatic 122	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   258: astore 13
    //   260: iload 4
    //   262: iload 5
    //   264: aload 13
    //   266: invokestatic 128	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   269: astore 14
    //   271: aload 14
    //   273: astore 12
    //   275: aload 12
    //   277: ifnonnull +726 -> 1003
    //   280: aload_0
    //   281: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   284: getfield 116	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_Boolean	Z
    //   287: ifeq +232 -> 519
    //   290: ldc2_w 129
    //   293: iload 4
    //   295: i2l
    //   296: ldiv
    //   297: iload 5
    //   299: i2l
    //   300: ldiv
    //   301: ldc2_w 131
    //   304: ldiv
    //   305: l2d
    //   306: invokestatic 138	java/lang/Math:sqrt	(D)D
    //   309: dstore_1
    //   310: dload_1
    //   311: d2f
    //   312: fstore_3
    //   313: fload_3
    //   314: fconst_1
    //   315: fcmpg
    //   316: ifge +687 -> 1003
    //   319: iload 4
    //   321: i2f
    //   322: fload_3
    //   323: fmul
    //   324: f2i
    //   325: istore 8
    //   327: fload_3
    //   328: iload 5
    //   330: i2f
    //   331: fmul
    //   332: f2i
    //   333: istore 6
    //   335: iload 8
    //   337: iload 6
    //   339: aload 13
    //   341: invokestatic 128	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   344: astore 14
    //   346: aload 14
    //   348: astore 12
    //   350: iload 6
    //   352: istore 7
    //   354: iload 8
    //   356: istore 9
    //   358: aload 12
    //   360: ifnonnull +661 -> 1021
    //   363: iload 8
    //   365: i2d
    //   366: ldc2_w 139
    //   369: ddiv
    //   370: d2i
    //   371: istore 9
    //   373: iload 6
    //   375: i2d
    //   376: ldc2_w 139
    //   379: ddiv
    //   380: d2i
    //   381: istore 7
    //   383: iload 9
    //   385: iload 7
    //   387: aload 13
    //   389: invokestatic 128	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   392: astore 13
    //   394: aload 13
    //   396: astore 12
    //   398: iload 7
    //   400: istore 6
    //   402: iload 9
    //   404: istore 7
    //   406: aload 12
    //   408: ifnonnull +161 -> 569
    //   411: aload_0
    //   412: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   415: getfield 39	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer	Lcom/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer;
    //   418: invokevirtual 44	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:a	()Lcom/tencent/qqmini/sdk/runtime/core/page/PageWebviewContainer;
    //   421: aload_0
    //   422: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   425: getfield 47	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   428: aconst_null
    //   429: aload_0
    //   430: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   433: getfield 50	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_Int	I
    //   436: invokevirtual 56	com/tencent/qqmini/sdk/runtime/core/page/PageWebviewContainer:c	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   439: return
    //   440: astore 12
    //   442: ldc 26
    //   444: new 94	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   451: ldc 142
    //   453: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 12
    //   458: invokestatic 148	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   461: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 34	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload_0
    //   471: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   474: getfield 39	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer	Lcom/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer;
    //   477: invokevirtual 44	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:a	()Lcom/tencent/qqmini/sdk/runtime/core/page/PageWebviewContainer;
    //   480: aload_0
    //   481: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   484: getfield 47	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   487: aconst_null
    //   488: aload_0
    //   489: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   492: getfield 50	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_Int	I
    //   495: invokevirtual 56	com/tencent/qqmini/sdk/runtime/core/page/PageWebviewContainer:c	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   498: return
    //   499: getstatic 151	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   502: astore 13
    //   504: goto -244 -> 260
    //   507: astore 14
    //   509: ldc 26
    //   511: ldc 153
    //   513: invokestatic 156	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: goto -241 -> 275
    //   519: ldc2_w 129
    //   522: iload 4
    //   524: i2l
    //   525: ldiv
    //   526: iload 5
    //   528: i2l
    //   529: ldiv
    //   530: ldc2_w 131
    //   533: ldiv
    //   534: l2d
    //   535: invokestatic 138	java/lang/Math:sqrt	(D)D
    //   538: d2f
    //   539: fstore_3
    //   540: goto -227 -> 313
    //   543: astore 14
    //   545: ldc 26
    //   547: ldc 158
    //   549: invokestatic 156	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: goto -202 -> 350
    //   555: astore 13
    //   557: ldc 26
    //   559: ldc 160
    //   561: aload 13
    //   563: invokestatic 163	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   566: goto +455 -> 1021
    //   569: new 165	android/graphics/Canvas
    //   572: dup
    //   573: aload 12
    //   575: invokespecial 168	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   578: astore 13
    //   580: aload 13
    //   582: new 170	android/graphics/PaintFlagsDrawFilter
    //   585: dup
    //   586: iconst_0
    //   587: iconst_3
    //   588: invokespecial 173	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   591: invokevirtual 177	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   594: new 179	android/graphics/Rect
    //   597: dup
    //   598: iconst_0
    //   599: iconst_0
    //   600: iload 7
    //   602: iload 6
    //   604: invokespecial 182	android/graphics/Rect:<init>	(IIII)V
    //   607: astore 14
    //   609: aload_0
    //   610: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   613: getfield 60	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView;
    //   616: aload_0
    //   617: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   620: getfield 63	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   623: ldc 184
    //   625: dconst_0
    //   626: invokevirtual 71	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   629: invokevirtual 77	com/tencent/qqmini/sdk/runtime/widget/CanvasView:b	(D)I
    //   632: istore 8
    //   634: aload_0
    //   635: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   638: getfield 60	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:this$0	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView;
    //   641: aload_0
    //   642: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   645: getfield 63	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   648: ldc 186
    //   650: dconst_0
    //   651: invokevirtual 71	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   654: invokevirtual 77	com/tencent/qqmini/sdk/runtime/widget/CanvasView:b	(D)I
    //   657: istore 9
    //   659: new 179	android/graphics/Rect
    //   662: dup
    //   663: iload 8
    //   665: iload 9
    //   667: iload 10
    //   669: iload 8
    //   671: iadd
    //   672: iload 11
    //   674: iload 9
    //   676: iadd
    //   677: invokespecial 182	android/graphics/Rect:<init>	(IIII)V
    //   680: astore 15
    //   682: aload 13
    //   684: aload_0
    //   685: getfield 15	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   688: aload 15
    //   690: aload 14
    //   692: aconst_null
    //   693: invokevirtual 190	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   696: invokestatic 195	bgnt:a	()Lbgnt;
    //   699: aload_0
    //   700: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   703: getfield 197	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:b	Ljava/lang/String;
    //   706: invokevirtual 200	bgnt:b	(Ljava/lang/String;)Ljava/lang/String;
    //   709: astore 14
    //   711: aload 14
    //   713: invokestatic 205	bgpc:a	(Ljava/lang/String;)Ljava/io/File;
    //   716: astore 13
    //   718: new 207	java/io/FileOutputStream
    //   721: dup
    //   722: aload 13
    //   724: invokespecial 210	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   727: astore 13
    //   729: iload 7
    //   731: iload 6
    //   733: imul
    //   734: iload 4
    //   736: idiv
    //   737: iload 5
    //   739: idiv
    //   740: i2f
    //   741: fstore_3
    //   742: aload_0
    //   743: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   746: getfield 116	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_Boolean	Z
    //   749: ifeq +127 -> 876
    //   752: aload_0
    //   753: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   756: getfield 63	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   759: ldc 212
    //   761: dconst_1
    //   762: invokevirtual 71	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   765: fload_3
    //   766: f2d
    //   767: ddiv
    //   768: dstore_1
    //   769: aload 12
    //   771: getstatic 218	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   774: dload_1
    //   775: ldc2_w 219
    //   778: dmul
    //   779: d2i
    //   780: aload 13
    //   782: invokevirtual 224	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   785: pop
    //   786: new 67	org/json/JSONObject
    //   789: dup
    //   790: invokespecial 225	org/json/JSONObject:<init>	()V
    //   793: astore 12
    //   795: aload 12
    //   797: ldc 227
    //   799: invokestatic 195	bgnt:a	()Lbgnt;
    //   802: aload 14
    //   804: invokevirtual 229	bgnt:e	(Ljava/lang/String;)Ljava/lang/String;
    //   807: invokevirtual 233	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   810: pop
    //   811: aload_0
    //   812: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   815: getfield 39	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer	Lcom/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer;
    //   818: invokevirtual 44	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:a	()Lcom/tencent/qqmini/sdk/runtime/core/page/PageWebviewContainer;
    //   821: aload_0
    //   822: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   825: getfield 50	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_Int	I
    //   828: aload 12
    //   830: invokevirtual 234	org/json/JSONObject:toString	()Ljava/lang/String;
    //   833: invokevirtual 237	com/tencent/qqmini/sdk/runtime/core/page/PageWebviewContainer:a	(ILjava/lang/String;)V
    //   836: aload 13
    //   838: ifnull +13 -> 851
    //   841: aload 13
    //   843: invokevirtual 240	java/io/FileOutputStream:flush	()V
    //   846: aload 13
    //   848: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   851: aload_0
    //   852: getfield 15	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   855: ifnull +165 -> 1020
    //   858: aload_0
    //   859: getfield 15	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   862: invokevirtual 247	android/graphics/Bitmap:isRecycled	()Z
    //   865: ifne +155 -> 1020
    //   868: aload_0
    //   869: getfield 15	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   872: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   875: return
    //   876: aload_0
    //   877: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   880: getfield 63	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   883: ldc 252
    //   885: dconst_1
    //   886: invokevirtual 71	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   889: fload_3
    //   890: f2d
    //   891: ddiv
    //   892: dstore_1
    //   893: aload 12
    //   895: getstatic 255	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   898: dload_1
    //   899: ldc2_w 219
    //   902: dmul
    //   903: d2i
    //   904: aload 13
    //   906: invokevirtual 224	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   909: pop
    //   910: goto -124 -> 786
    //   913: astore 12
    //   915: aload 13
    //   917: ifnull +13 -> 930
    //   920: aload 13
    //   922: invokevirtual 240	java/io/FileOutputStream:flush	()V
    //   925: aload 13
    //   927: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   930: aload_0
    //   931: getfield 15	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   934: ifnull +20 -> 954
    //   937: aload_0
    //   938: getfield 15	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   941: invokevirtual 247	android/graphics/Bitmap:isRecycled	()Z
    //   944: ifne +10 -> 954
    //   947: aload_0
    //   948: getfield 15	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   951: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   954: aload 12
    //   956: athrow
    //   957: astore 12
    //   959: aload 12
    //   961: invokevirtual 258	org/json/JSONException:printStackTrace	()V
    //   964: aload_0
    //   965: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   968: getfield 39	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer	Lcom/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer;
    //   971: invokevirtual 44	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:a	()Lcom/tencent/qqmini/sdk/runtime/core/page/PageWebviewContainer;
    //   974: aload_0
    //   975: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   978: getfield 47	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   981: aconst_null
    //   982: aload_0
    //   983: getfield 13	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2$1:jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCanvasView$2	Lcom/tencent/qqmini/sdk/runtime/widget/CanvasView$2;
    //   986: getfield 50	com/tencent/qqmini/sdk/runtime/widget/CanvasView$2:jdField_a_of_type_Int	I
    //   989: invokevirtual 56	com/tencent/qqmini/sdk/runtime/core/page/PageWebviewContainer:c	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   992: goto -156 -> 836
    //   995: astore 12
    //   997: aconst_null
    //   998: astore 13
    //   1000: goto -85 -> 915
    //   1003: iload 5
    //   1005: istore 6
    //   1007: iload 4
    //   1009: istore 8
    //   1011: goto -661 -> 350
    //   1014: goto -887 -> 127
    //   1017: goto -907 -> 110
    //   1020: return
    //   1021: iload 7
    //   1023: istore 6
    //   1025: iload 9
    //   1027: istore 7
    //   1029: goto -623 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1032	0	this	1
    //   309	590	1	d	double
    //   312	578	3	f	float
    //   161	847	4	i	int
    //   141	863	5	j	int
    //   157	867	6	k	int
    //   352	676	7	m	int
    //   325	685	8	n	int
    //   356	670	9	i1	int
    //   66	606	10	i2	int
    //   91	586	11	i3	int
    //   243	164	12	localObject1	Object
    //   440	330	12	localThrowable1	java.lang.Throwable
    //   793	101	12	localJSONObject	org.json.JSONObject
    //   913	42	12	localObject2	Object
    //   957	3	12	localJSONException	org.json.JSONException
    //   995	1	12	localObject3	Object
    //   258	245	13	localObject4	Object
    //   555	7	13	localThrowable2	java.lang.Throwable
    //   578	421	13	localObject5	Object
    //   269	78	14	localBitmap	Bitmap
    //   507	1	14	localThrowable3	java.lang.Throwable
    //   543	1	14	localThrowable4	java.lang.Throwable
    //   607	196	14	localObject6	Object
    //   680	9	15	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   0	42	440	java/lang/Throwable
    //   43	93	440	java/lang/Throwable
    //   98	110	440	java/lang/Throwable
    //   115	127	440	java/lang/Throwable
    //   127	159	440	java/lang/Throwable
    //   168	183	440	java/lang/Throwable
    //   192	207	440	java/lang/Throwable
    //   207	242	440	java/lang/Throwable
    //   245	260	440	java/lang/Throwable
    //   280	310	440	java/lang/Throwable
    //   411	439	440	java/lang/Throwable
    //   499	504	440	java/lang/Throwable
    //   509	516	440	java/lang/Throwable
    //   519	540	440	java/lang/Throwable
    //   545	552	440	java/lang/Throwable
    //   557	566	440	java/lang/Throwable
    //   569	718	440	java/lang/Throwable
    //   841	851	440	java/lang/Throwable
    //   851	875	440	java/lang/Throwable
    //   920	930	440	java/lang/Throwable
    //   930	954	440	java/lang/Throwable
    //   954	957	440	java/lang/Throwable
    //   260	271	507	java/lang/Throwable
    //   335	346	543	java/lang/Throwable
    //   383	394	555	java/lang/Throwable
    //   729	786	913	finally
    //   786	836	913	finally
    //   876	910	913	finally
    //   959	992	913	finally
    //   786	836	957	org/json/JSONException
    //   718	729	995	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.CanvasView.2.1
 * JD-Core Version:    0.7.0.1
 */