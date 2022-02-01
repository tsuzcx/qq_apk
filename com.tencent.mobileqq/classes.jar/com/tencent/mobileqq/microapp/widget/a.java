package com.tencent.mobileqq.microapp.widget;

import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import org.json.JSONObject;

final class a
  implements Runnable
{
  a(CanvasView paramCanvasView, JSONObject paramJSONObject, WebviewContainer paramWebviewContainer, String paramString, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   4: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   7: f2d
    //   8: dstore_1
    //   9: aload_0
    //   10: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   13: ldc 44
    //   15: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   18: dstore_3
    //   19: dload_1
    //   20: invokestatic 56	java/lang/Double:isNaN	(D)Z
    //   23: pop
    //   24: dload_1
    //   25: dload_3
    //   26: dmul
    //   27: d2i
    //   28: istore 9
    //   30: aload_0
    //   31: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   34: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   37: f2d
    //   38: dstore_1
    //   39: aload_0
    //   40: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   43: ldc 58
    //   45: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   48: dstore_3
    //   49: dload_1
    //   50: invokestatic 56	java/lang/Double:isNaN	(D)Z
    //   53: pop
    //   54: dload_1
    //   55: dload_3
    //   56: dmul
    //   57: d2i
    //   58: istore 10
    //   60: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq +60 -> 123
    //   66: invokestatic 67	com/tencent/mobileqq/microapp/widget/CanvasView:a	()Ljava/lang/String;
    //   69: astore 11
    //   71: new 69	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   78: astore 12
    //   80: aload 12
    //   82: ldc 72
    //   84: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 12
    //   90: iload 9
    //   92: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 12
    //   98: ldc 81
    //   100: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 12
    //   106: iload 10
    //   108: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 11
    //   114: iconst_2
    //   115: aload 12
    //   117: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_0
    //   124: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   127: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   130: f2d
    //   131: dstore_1
    //   132: aload_0
    //   133: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   136: ldc 89
    //   138: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   141: dstore_3
    //   142: aload_0
    //   143: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   146: ldc 91
    //   148: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   151: dstore 5
    //   153: dload_1
    //   154: invokestatic 56	java/lang/Double:isNaN	(D)Z
    //   157: pop
    //   158: dload_1
    //   159: dload_3
    //   160: dload 5
    //   162: dadd
    //   163: dmul
    //   164: ldc2_w 92
    //   167: dadd
    //   168: d2i
    //   169: istore 7
    //   171: aload_0
    //   172: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   175: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   178: f2d
    //   179: dstore_1
    //   180: aload_0
    //   181: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   184: ldc 95
    //   186: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   189: dstore_3
    //   190: aload_0
    //   191: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   194: ldc 97
    //   196: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   199: dstore 5
    //   201: dload_1
    //   202: invokestatic 56	java/lang/Double:isNaN	(D)Z
    //   205: pop
    //   206: dload_1
    //   207: dload_3
    //   208: dload 5
    //   210: dadd
    //   211: dmul
    //   212: ldc2_w 92
    //   215: dadd
    //   216: d2i
    //   217: istore 8
    //   219: iload 9
    //   221: iload 10
    //   223: getstatic 103	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   226: invokestatic 109	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   229: astore 11
    //   231: new 111	android/graphics/Canvas
    //   234: dup
    //   235: aload 11
    //   237: invokespecial 114	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   240: astore 12
    //   242: aload_0
    //   243: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   246: aload_0
    //   247: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   250: invokestatic 117	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;Landroid/view/View;)Landroid/graphics/Bitmap;
    //   253: astore 13
    //   255: aload 13
    //   257: ifnonnull +20 -> 277
    //   260: aload_0
    //   261: getfield 24	com/tencent/mobileqq/microapp/widget/a:b	Lcom/tencent/mobileqq/microapp/appbrand/page/WebviewContainer;
    //   264: aload_0
    //   265: getfield 26	com/tencent/mobileqq/microapp/widget/a:c	Ljava/lang/String;
    //   268: aconst_null
    //   269: aload_0
    //   270: getfield 28	com/tencent/mobileqq/microapp/widget/a:d	I
    //   273: invokevirtual 123	com/tencent/mobileqq/microapp/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   276: return
    //   277: new 125	android/graphics/Rect
    //   280: dup
    //   281: iconst_0
    //   282: iconst_0
    //   283: iload 9
    //   285: iload 10
    //   287: invokespecial 128	android/graphics/Rect:<init>	(IIII)V
    //   290: astore 14
    //   292: aload_0
    //   293: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   296: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   299: f2d
    //   300: dstore_1
    //   301: aload_0
    //   302: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   305: ldc 91
    //   307: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   310: dstore_3
    //   311: dload_1
    //   312: invokestatic 56	java/lang/Double:isNaN	(D)Z
    //   315: pop
    //   316: dload_1
    //   317: dload_3
    //   318: dmul
    //   319: ldc2_w 92
    //   322: dadd
    //   323: d2i
    //   324: istore 9
    //   326: aload_0
    //   327: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   330: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   333: f2d
    //   334: dstore_1
    //   335: aload_0
    //   336: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   339: ldc 97
    //   341: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   344: dstore_3
    //   345: dload_1
    //   346: invokestatic 56	java/lang/Double:isNaN	(D)Z
    //   349: pop
    //   350: dload_1
    //   351: dload_3
    //   352: dmul
    //   353: ldc2_w 92
    //   356: dadd
    //   357: d2i
    //   358: istore 10
    //   360: aload 12
    //   362: aload 13
    //   364: new 125	android/graphics/Rect
    //   367: dup
    //   368: iload 9
    //   370: iload 10
    //   372: iload 7
    //   374: iload 8
    //   376: invokespecial 128	android/graphics/Rect:<init>	(IIII)V
    //   379: aload 14
    //   381: aconst_null
    //   382: invokevirtual 132	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   385: aload_0
    //   386: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   389: ldc 134
    //   391: invokevirtual 138	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   394: astore 15
    //   396: invokestatic 143	com/tencent/mobileqq/microapp/appbrand/b/b:a	()Lcom/tencent/mobileqq/microapp/appbrand/b/b;
    //   399: aload 15
    //   401: invokevirtual 145	com/tencent/mobileqq/microapp/appbrand/b/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   404: astore 14
    //   406: aload 14
    //   408: invokestatic 151	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   411: astore 12
    //   413: new 153	java/io/FileOutputStream
    //   416: dup
    //   417: aload 12
    //   419: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   422: astore 12
    //   424: ldc 158
    //   426: aload 15
    //   428: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   431: ifeq +33 -> 464
    //   434: aload_0
    //   435: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   438: ldc 166
    //   440: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   443: dstore_1
    //   444: aload 11
    //   446: getstatic 172	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   449: dload_1
    //   450: ldc2_w 173
    //   453: dmul
    //   454: d2i
    //   455: aload 12
    //   457: invokevirtual 178	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   460: pop
    //   461: goto +40 -> 501
    //   464: ldc 180
    //   466: aload 15
    //   468: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   471: ifeq +30 -> 501
    //   474: aload_0
    //   475: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   478: ldc 182
    //   480: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   483: dstore_1
    //   484: aload 11
    //   486: getstatic 185	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   489: dload_1
    //   490: ldc2_w 173
    //   493: dmul
    //   494: d2i
    //   495: aload 12
    //   497: invokevirtual 178	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   500: pop
    //   501: new 46	org/json/JSONObject
    //   504: dup
    //   505: invokespecial 186	org/json/JSONObject:<init>	()V
    //   508: astore 11
    //   510: aload 11
    //   512: ldc 188
    //   514: invokestatic 143	com/tencent/mobileqq/microapp/appbrand/b/b:a	()Lcom/tencent/mobileqq/microapp/appbrand/b/b;
    //   517: aload 14
    //   519: invokevirtual 190	com/tencent/mobileqq/microapp/appbrand/b/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   522: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   525: pop
    //   526: aload_0
    //   527: getfield 24	com/tencent/mobileqq/microapp/widget/a:b	Lcom/tencent/mobileqq/microapp/appbrand/page/WebviewContainer;
    //   530: getfield 198	com/tencent/mobileqq/microapp/appbrand/page/WebviewContainer:appBrandRuntime	Lcom/tencent/mobileqq/microapp/appbrand/a;
    //   533: getfield 204	com/tencent/mobileqq/microapp/appbrand/a:i	Lcom/tencent/mobileqq/microapp/appbrand/page/ServiceWebview;
    //   536: aload_0
    //   537: getfield 28	com/tencent/mobileqq/microapp/widget/a:d	I
    //   540: aload 11
    //   542: invokevirtual 205	org/json/JSONObject:toString	()Ljava/lang/String;
    //   545: invokevirtual 211	com/tencent/mobileqq/microapp/appbrand/page/ServiceWebview:evaluateCallbackJs	(ILjava/lang/String;)V
    //   548: goto +26 -> 574
    //   551: astore 11
    //   553: aload 11
    //   555: invokevirtual 214	org/json/JSONException:printStackTrace	()V
    //   558: aload_0
    //   559: getfield 24	com/tencent/mobileqq/microapp/widget/a:b	Lcom/tencent/mobileqq/microapp/appbrand/page/WebviewContainer;
    //   562: aload_0
    //   563: getfield 26	com/tencent/mobileqq/microapp/widget/a:c	Ljava/lang/String;
    //   566: aconst_null
    //   567: aload_0
    //   568: getfield 28	com/tencent/mobileqq/microapp/widget/a:d	I
    //   571: invokevirtual 123	com/tencent/mobileqq/microapp/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   574: aload 12
    //   576: invokevirtual 217	java/io/FileOutputStream:flush	()V
    //   579: aload 12
    //   581: invokevirtual 220	java/io/FileOutputStream:close	()V
    //   584: aload 13
    //   586: ifnull +121 -> 707
    //   589: aload 13
    //   591: invokevirtual 223	android/graphics/Bitmap:isRecycled	()Z
    //   594: ifne +113 -> 707
    //   597: aload 13
    //   599: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   602: return
    //   603: aload 12
    //   605: ifnull +13 -> 618
    //   608: aload 12
    //   610: invokevirtual 217	java/io/FileOutputStream:flush	()V
    //   613: aload 12
    //   615: invokevirtual 220	java/io/FileOutputStream:close	()V
    //   618: aload 13
    //   620: ifnull +16 -> 636
    //   623: aload 13
    //   625: invokevirtual 223	android/graphics/Bitmap:isRecycled	()Z
    //   628: ifne +8 -> 636
    //   631: aload 13
    //   633: invokevirtual 226	android/graphics/Bitmap:recycle	()V
    //   636: aload 11
    //   638: athrow
    //   639: astore 11
    //   641: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   644: ifeq +47 -> 691
    //   647: invokestatic 67	com/tencent/mobileqq/microapp/widget/CanvasView:a	()Ljava/lang/String;
    //   650: astore 12
    //   652: new 69	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   659: astore 13
    //   661: aload 13
    //   663: ldc 228
    //   665: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 13
    //   671: aload 11
    //   673: invokevirtual 231	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   676: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 12
    //   682: iconst_2
    //   683: aload 13
    //   685: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: aload_0
    //   692: getfield 24	com/tencent/mobileqq/microapp/widget/a:b	Lcom/tencent/mobileqq/microapp/appbrand/page/WebviewContainer;
    //   695: aload_0
    //   696: getfield 26	com/tencent/mobileqq/microapp/widget/a:c	Ljava/lang/String;
    //   699: aconst_null
    //   700: aload_0
    //   701: getfield 28	com/tencent/mobileqq/microapp/widget/a:d	I
    //   704: invokevirtual 123	com/tencent/mobileqq/microapp/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   707: return
    //   708: astore 11
    //   710: goto -107 -> 603
    //   713: astore 11
    //   715: aconst_null
    //   716: astore 12
    //   718: goto -115 -> 603
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	a
    //   8	482	1	d1	double
    //   18	334	3	d2	double
    //   151	58	5	d3	double
    //   169	204	7	i	int
    //   217	158	8	j	int
    //   28	341	9	k	int
    //   58	313	10	m	int
    //   69	472	11	localObject1	Object
    //   551	86	11	localJSONException	org.json.JSONException
    //   639	33	11	localThrowable	java.lang.Throwable
    //   708	1	11	localObject2	Object
    //   713	1	11	localObject3	Object
    //   78	639	12	localObject4	Object
    //   253	431	13	localObject5	Object
    //   290	228	14	localObject6	Object
    //   394	73	15	str	String
    // Exception table:
    //   from	to	target	type
    //   501	548	551	org/json/JSONException
    //   0	19	639	java/lang/Throwable
    //   30	49	639	java/lang/Throwable
    //   60	123	639	java/lang/Throwable
    //   123	153	639	java/lang/Throwable
    //   171	201	639	java/lang/Throwable
    //   219	255	639	java/lang/Throwable
    //   260	276	639	java/lang/Throwable
    //   277	311	639	java/lang/Throwable
    //   326	345	639	java/lang/Throwable
    //   360	413	639	java/lang/Throwable
    //   574	584	639	java/lang/Throwable
    //   589	602	639	java/lang/Throwable
    //   608	618	639	java/lang/Throwable
    //   623	636	639	java/lang/Throwable
    //   636	639	639	java/lang/Throwable
    //   424	461	708	finally
    //   464	501	708	finally
    //   501	548	708	finally
    //   553	574	708	finally
    //   413	424	713	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.a
 * JD-Core Version:    0.7.0.1
 */