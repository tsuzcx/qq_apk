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
    //   8: aload_0
    //   9: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   12: ldc 44
    //   14: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   17: dmul
    //   18: d2i
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   24: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   27: f2d
    //   28: aload_0
    //   29: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   32: ldc 52
    //   34: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   37: dmul
    //   38: d2i
    //   39: istore 4
    //   41: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +39 -> 83
    //   47: invokestatic 61	com/tencent/mobileqq/microapp/widget/CanvasView:a	()Ljava/lang/String;
    //   50: iconst_2
    //   51: new 63	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   58: ldc 66
    //   60: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload_3
    //   64: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: ldc 75
    //   69: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: iload 4
    //   74: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_0
    //   84: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   87: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   90: f2d
    //   91: aload_0
    //   92: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   95: ldc 83
    //   97: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   100: aload_0
    //   101: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   104: ldc 85
    //   106: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   109: dadd
    //   110: dmul
    //   111: ldc2_w 86
    //   114: dadd
    //   115: d2i
    //   116: istore 5
    //   118: aload_0
    //   119: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   122: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   125: f2d
    //   126: aload_0
    //   127: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   130: ldc 89
    //   132: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   135: aload_0
    //   136: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   139: ldc 91
    //   141: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   144: dadd
    //   145: dmul
    //   146: ldc2_w 86
    //   149: dadd
    //   150: d2i
    //   151: istore 6
    //   153: iload_3
    //   154: iload 4
    //   156: getstatic 97	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   159: invokestatic 103	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   162: astore 7
    //   164: new 105	android/graphics/Canvas
    //   167: dup
    //   168: aload 7
    //   170: invokespecial 108	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   173: astore 8
    //   175: aload_0
    //   176: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   179: aload_0
    //   180: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   183: invokestatic 111	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;Landroid/view/View;)Landroid/graphics/Bitmap;
    //   186: astore 9
    //   188: aload 9
    //   190: ifnonnull +20 -> 210
    //   193: aload_0
    //   194: getfield 24	com/tencent/mobileqq/microapp/widget/a:b	Lcom/tencent/mobileqq/microapp/appbrand/page/WebviewContainer;
    //   197: aload_0
    //   198: getfield 26	com/tencent/mobileqq/microapp/widget/a:c	Ljava/lang/String;
    //   201: aconst_null
    //   202: aload_0
    //   203: getfield 28	com/tencent/mobileqq/microapp/widget/a:d	I
    //   206: invokevirtual 117	com/tencent/mobileqq/microapp/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   209: return
    //   210: new 119	android/graphics/Rect
    //   213: dup
    //   214: iconst_0
    //   215: iconst_0
    //   216: iload_3
    //   217: iload 4
    //   219: invokespecial 122	android/graphics/Rect:<init>	(IIII)V
    //   222: astore 10
    //   224: aload 8
    //   226: aload 9
    //   228: new 119	android/graphics/Rect
    //   231: dup
    //   232: aload_0
    //   233: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   236: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   239: f2d
    //   240: aload_0
    //   241: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   244: ldc 85
    //   246: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   249: dmul
    //   250: ldc2_w 86
    //   253: dadd
    //   254: d2i
    //   255: aload_0
    //   256: getfield 20	com/tencent/mobileqq/microapp/widget/a:e	Lcom/tencent/mobileqq/microapp/widget/CanvasView;
    //   259: invokestatic 42	com/tencent/mobileqq/microapp/widget/CanvasView:a	(Lcom/tencent/mobileqq/microapp/widget/CanvasView;)F
    //   262: f2d
    //   263: aload_0
    //   264: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   267: ldc 91
    //   269: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   272: dmul
    //   273: ldc2_w 86
    //   276: dadd
    //   277: d2i
    //   278: iload 5
    //   280: iload 6
    //   282: invokespecial 122	android/graphics/Rect:<init>	(IIII)V
    //   285: aload 10
    //   287: aconst_null
    //   288: invokevirtual 126	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   291: aload_0
    //   292: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   295: ldc 128
    //   297: invokevirtual 132	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   300: astore 11
    //   302: invokestatic 137	com/tencent/mobileqq/microapp/appbrand/utils/b:a	()Lcom/tencent/mobileqq/microapp/appbrand/utils/b;
    //   305: aload 11
    //   307: invokevirtual 139	com/tencent/mobileqq/microapp/appbrand/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   310: astore 10
    //   312: aload 10
    //   314: invokestatic 144	bbdj:a	(Ljava/lang/String;)Ljava/io/File;
    //   317: astore 8
    //   319: new 146	java/io/FileOutputStream
    //   322: dup
    //   323: aload 8
    //   325: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   328: astore 8
    //   330: ldc 151
    //   332: aload 11
    //   334: invokevirtual 157	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   337: ifeq +166 -> 503
    //   340: aload_0
    //   341: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   344: ldc 159
    //   346: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   349: dstore_1
    //   350: aload 7
    //   352: getstatic 165	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   355: dload_1
    //   356: ldc2_w 166
    //   359: dmul
    //   360: d2i
    //   361: aload 8
    //   363: invokevirtual 171	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   366: pop
    //   367: new 46	org/json/JSONObject
    //   370: dup
    //   371: invokespecial 172	org/json/JSONObject:<init>	()V
    //   374: astore 7
    //   376: aload 7
    //   378: ldc 174
    //   380: invokestatic 137	com/tencent/mobileqq/microapp/appbrand/utils/b:a	()Lcom/tencent/mobileqq/microapp/appbrand/utils/b;
    //   383: aload 10
    //   385: invokevirtual 176	com/tencent/mobileqq/microapp/appbrand/utils/b:c	(Ljava/lang/String;)Ljava/lang/String;
    //   388: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   391: pop
    //   392: aload_0
    //   393: getfield 24	com/tencent/mobileqq/microapp/widget/a:b	Lcom/tencent/mobileqq/microapp/appbrand/page/WebviewContainer;
    //   396: getfield 184	com/tencent/mobileqq/microapp/appbrand/page/WebviewContainer:appBrandRuntime	Lcom/tencent/mobileqq/microapp/appbrand/a;
    //   399: getfield 190	com/tencent/mobileqq/microapp/appbrand/a:i	Lcom/tencent/mobileqq/microapp/appbrand/page/ServiceWebview;
    //   402: aload_0
    //   403: getfield 28	com/tencent/mobileqq/microapp/widget/a:d	I
    //   406: aload 7
    //   408: invokevirtual 191	org/json/JSONObject:toString	()Ljava/lang/String;
    //   411: invokevirtual 197	com/tencent/mobileqq/microapp/appbrand/page/ServiceWebview:evaluateCallbackJs	(ILjava/lang/String;)V
    //   414: aload 8
    //   416: ifnull +13 -> 429
    //   419: aload 8
    //   421: invokevirtual 200	java/io/FileOutputStream:flush	()V
    //   424: aload 8
    //   426: invokevirtual 203	java/io/FileOutputStream:close	()V
    //   429: aload 9
    //   431: ifnull +184 -> 615
    //   434: aload 9
    //   436: invokevirtual 206	android/graphics/Bitmap:isRecycled	()Z
    //   439: ifne +176 -> 615
    //   442: aload 9
    //   444: invokevirtual 209	android/graphics/Bitmap:recycle	()V
    //   447: return
    //   448: astore 7
    //   450: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   453: ifeq +33 -> 486
    //   456: invokestatic 61	com/tencent/mobileqq/microapp/widget/CanvasView:a	()Ljava/lang/String;
    //   459: iconst_2
    //   460: new 63	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   467: ldc 211
    //   469: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload 7
    //   474: invokevirtual 214	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   477: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aload_0
    //   487: getfield 24	com/tencent/mobileqq/microapp/widget/a:b	Lcom/tencent/mobileqq/microapp/appbrand/page/WebviewContainer;
    //   490: aload_0
    //   491: getfield 26	com/tencent/mobileqq/microapp/widget/a:c	Ljava/lang/String;
    //   494: aconst_null
    //   495: aload_0
    //   496: getfield 28	com/tencent/mobileqq/microapp/widget/a:d	I
    //   499: invokevirtual 117	com/tencent/mobileqq/microapp/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   502: return
    //   503: ldc 216
    //   505: aload 11
    //   507: invokevirtual 157	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   510: ifeq -143 -> 367
    //   513: aload_0
    //   514: getfield 22	com/tencent/mobileqq/microapp/widget/a:a	Lorg/json/JSONObject;
    //   517: ldc 218
    //   519: invokevirtual 50	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   522: dstore_1
    //   523: aload 7
    //   525: getstatic 221	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   528: dload_1
    //   529: ldc2_w 166
    //   532: dmul
    //   533: d2i
    //   534: aload 8
    //   536: invokevirtual 171	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   539: pop
    //   540: goto -173 -> 367
    //   543: astore 7
    //   545: aload 8
    //   547: ifnull +13 -> 560
    //   550: aload 8
    //   552: invokevirtual 200	java/io/FileOutputStream:flush	()V
    //   555: aload 8
    //   557: invokevirtual 203	java/io/FileOutputStream:close	()V
    //   560: aload 9
    //   562: ifnull +16 -> 578
    //   565: aload 9
    //   567: invokevirtual 206	android/graphics/Bitmap:isRecycled	()Z
    //   570: ifne +8 -> 578
    //   573: aload 9
    //   575: invokevirtual 209	android/graphics/Bitmap:recycle	()V
    //   578: aload 7
    //   580: athrow
    //   581: astore 7
    //   583: aload 7
    //   585: invokevirtual 224	org/json/JSONException:printStackTrace	()V
    //   588: aload_0
    //   589: getfield 24	com/tencent/mobileqq/microapp/widget/a:b	Lcom/tencent/mobileqq/microapp/appbrand/page/WebviewContainer;
    //   592: aload_0
    //   593: getfield 26	com/tencent/mobileqq/microapp/widget/a:c	Ljava/lang/String;
    //   596: aconst_null
    //   597: aload_0
    //   598: getfield 28	com/tencent/mobileqq/microapp/widget/a:d	I
    //   601: invokevirtual 117	com/tencent/mobileqq/microapp/appbrand/page/WebviewContainer:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   604: goto -190 -> 414
    //   607: astore 7
    //   609: aconst_null
    //   610: astore 8
    //   612: goto -67 -> 545
    //   615: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	this	a
    //   349	180	1	d1	double
    //   19	198	3	i	int
    //   39	179	4	j	int
    //   116	163	5	k	int
    //   151	130	6	m	int
    //   162	245	7	localObject1	Object
    //   448	76	7	localThrowable	java.lang.Throwable
    //   543	36	7	localObject2	Object
    //   581	3	7	localJSONException	org.json.JSONException
    //   607	1	7	localObject3	Object
    //   173	438	8	localObject4	Object
    //   186	388	9	localBitmap	android.graphics.Bitmap
    //   222	162	10	localObject5	Object
    //   300	206	11	str	String
    // Exception table:
    //   from	to	target	type
    //   0	83	448	java/lang/Throwable
    //   83	188	448	java/lang/Throwable
    //   193	209	448	java/lang/Throwable
    //   210	319	448	java/lang/Throwable
    //   419	429	448	java/lang/Throwable
    //   434	447	448	java/lang/Throwable
    //   550	560	448	java/lang/Throwable
    //   565	578	448	java/lang/Throwable
    //   578	581	448	java/lang/Throwable
    //   330	367	543	finally
    //   367	414	543	finally
    //   503	540	543	finally
    //   583	604	543	finally
    //   367	414	581	org/json/JSONException
    //   319	330	607	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.a
 * JD-Core Version:    0.7.0.1
 */