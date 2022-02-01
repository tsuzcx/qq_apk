package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import org.json.JSONObject;

class CanvasView$3
  implements Runnable
{
  CanvasView$3(CanvasView paramCanvasView, Bitmap paramBitmap, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject, boolean paramBoolean, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$currBitmap	Landroid/graphics/Bitmap;
    //   4: ifnonnull +19 -> 23
    //   7: ldc 41
    //   9: ldc 43
    //   11: invokestatic 49	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 26	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   18: invokevirtual 55	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   21: pop
    //   22: return
    //   23: aload_0
    //   24: getfield 22	com/tencent/qqmini/miniapp/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   27: aload_0
    //   28: getfield 28	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$paramObj	Lorg/json/JSONObject;
    //   31: ldc 57
    //   33: dconst_0
    //   34: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   37: invokevirtual 69	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   40: istore_3
    //   41: aload_0
    //   42: getfield 22	com/tencent/qqmini/miniapp/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   45: aload_0
    //   46: getfield 28	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$paramObj	Lorg/json/JSONObject;
    //   49: ldc 71
    //   51: dconst_0
    //   52: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   55: invokevirtual 69	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2pxInt	(D)I
    //   58: istore_2
    //   59: iload_3
    //   60: istore 6
    //   62: iload_3
    //   63: ifgt +12 -> 75
    //   66: aload_0
    //   67: getfield 22	com/tencent/qqmini/miniapp/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   70: invokevirtual 75	com/tencent/qqmini/miniapp/widget/CanvasView:getWidth	()I
    //   73: istore 6
    //   75: iload_2
    //   76: istore 7
    //   78: iload_2
    //   79: ifgt +12 -> 91
    //   82: aload_0
    //   83: getfield 22	com/tencent/qqmini/miniapp/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   86: invokevirtual 78	com/tencent/qqmini/miniapp/widget/CanvasView:getHeight	()I
    //   89: istore 7
    //   91: aload_0
    //   92: getfield 28	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$paramObj	Lorg/json/JSONObject;
    //   95: ldc 80
    //   97: dconst_0
    //   98: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   101: d2i
    //   102: istore_3
    //   103: aload_0
    //   104: getfield 28	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$paramObj	Lorg/json/JSONObject;
    //   107: ldc 82
    //   109: dconst_0
    //   110: invokevirtual 63	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   113: d2i
    //   114: istore 4
    //   116: iload_3
    //   117: istore_2
    //   118: iload_3
    //   119: ifgt +14 -> 133
    //   122: aload_0
    //   123: getfield 22	com/tencent/qqmini/miniapp/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   126: iload 6
    //   128: i2d
    //   129: invokevirtual 85	com/tencent/qqmini/miniapp/widget/CanvasView:px2mpxInt	(D)I
    //   132: istore_2
    //   133: iload 4
    //   135: istore_3
    //   136: iload 4
    //   138: ifgt +14 -> 152
    //   141: aload_0
    //   142: getfield 22	com/tencent/qqmini/miniapp/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   145: iload 7
    //   147: i2d
    //   148: invokevirtual 85	com/tencent/qqmini/miniapp/widget/CanvasView:px2mpxInt	(D)I
    //   151: istore_3
    //   152: ldc 41
    //   154: new 87	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   161: ldc 90
    //   163: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload_2
    //   167: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc 99
    //   172: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload_3
    //   176: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 105	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aconst_null
    //   186: astore 10
    //   188: aload_0
    //   189: getfield 22	com/tencent/qqmini/miniapp/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   192: aload_0
    //   193: getfield 30	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$isPngFile	Z
    //   196: invokestatic 109	com/tencent/qqmini/miniapp/widget/CanvasView:access$300	(Lcom/tencent/qqmini/miniapp/widget/CanvasView;Z)Landroid/graphics/Bitmap$Config;
    //   199: astore 12
    //   201: iload_2
    //   202: iload_3
    //   203: aload 12
    //   205: invokestatic 115	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   208: astore 11
    //   210: aload 11
    //   212: astore 10
    //   214: aload 10
    //   216: ifnonnull +239 -> 455
    //   219: aload_0
    //   220: getfield 22	com/tencent/qqmini/miniapp/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   223: iload_2
    //   224: iload_3
    //   225: aload_0
    //   226: getfield 30	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$isPngFile	Z
    //   229: invokestatic 119	com/tencent/qqmini/miniapp/widget/CanvasView:access$400	(Lcom/tencent/qqmini/miniapp/widget/CanvasView;IIZ)F
    //   232: fstore_1
    //   233: fload_1
    //   234: fconst_1
    //   235: fcmpg
    //   236: ifge +219 -> 455
    //   239: iload_2
    //   240: i2f
    //   241: fload_1
    //   242: fmul
    //   243: f2i
    //   244: istore 4
    //   246: fload_1
    //   247: iload_3
    //   248: i2f
    //   249: fmul
    //   250: f2i
    //   251: istore 5
    //   253: iload 4
    //   255: iload 5
    //   257: aload 12
    //   259: invokestatic 115	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   262: astore 11
    //   264: aload 11
    //   266: astore 10
    //   268: iload 4
    //   270: istore 8
    //   272: iload 5
    //   274: istore 9
    //   276: aload 10
    //   278: astore 11
    //   280: aload 10
    //   282: ifnonnull +34 -> 316
    //   285: iload 4
    //   287: i2d
    //   288: ldc2_w 120
    //   291: ddiv
    //   292: d2i
    //   293: istore 8
    //   295: iload 5
    //   297: i2d
    //   298: ldc2_w 120
    //   301: ddiv
    //   302: d2i
    //   303: istore 9
    //   305: iload 8
    //   307: iload 9
    //   309: aload 12
    //   311: invokestatic 115	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   314: astore 11
    //   316: aload 11
    //   318: ifnonnull +97 -> 415
    //   321: aload_0
    //   322: getfield 26	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   325: invokevirtual 55	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   328: pop
    //   329: return
    //   330: astore 10
    //   332: ldc 41
    //   334: new 87	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   341: ldc 123
    //   343: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 10
    //   348: invokestatic 129	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   351: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 49	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_0
    //   361: getfield 26	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   364: invokevirtual 55	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:fail	()Ljava/lang/String;
    //   367: pop
    //   368: return
    //   369: astore 11
    //   371: ldc 41
    //   373: ldc 131
    //   375: aload 11
    //   377: invokestatic 135	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   380: goto -166 -> 214
    //   383: astore 11
    //   385: ldc 41
    //   387: ldc 137
    //   389: aload 11
    //   391: invokestatic 135	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   394: goto -126 -> 268
    //   397: astore 11
    //   399: ldc 41
    //   401: ldc 139
    //   403: aload 11
    //   405: invokestatic 141	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   408: aload 10
    //   410: astore 11
    //   412: goto -96 -> 316
    //   415: aload_0
    //   416: getfield 22	com/tencent/qqmini/miniapp/widget/CanvasView$3:this$0	Lcom/tencent/qqmini/miniapp/widget/CanvasView;
    //   419: iload 6
    //   421: iload 7
    //   423: iload_2
    //   424: iload_3
    //   425: iload 8
    //   427: iload 9
    //   429: aload 11
    //   431: aload_0
    //   432: getfield 28	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$paramObj	Lorg/json/JSONObject;
    //   435: aload_0
    //   436: getfield 24	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$currBitmap	Landroid/graphics/Bitmap;
    //   439: aload_0
    //   440: getfield 32	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$fileType	Ljava/lang/String;
    //   443: aload_0
    //   444: getfield 30	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$isPngFile	Z
    //   447: aload_0
    //   448: getfield 26	com/tencent/qqmini/miniapp/widget/CanvasView$3:val$req	Lcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;
    //   451: invokestatic 145	com/tencent/qqmini/miniapp/widget/CanvasView:access$500	(Lcom/tencent/qqmini/miniapp/widget/CanvasView;IIIIIILandroid/graphics/Bitmap;Lorg/json/JSONObject;Landroid/graphics/Bitmap;Ljava/lang/String;ZLcom/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent;)V
    //   454: return
    //   455: iload_3
    //   456: istore 5
    //   458: iload_2
    //   459: istore 4
    //   461: goto -193 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	3
    //   232	15	1	f	float
    //   58	401	2	i	int
    //   40	416	3	j	int
    //   114	346	4	k	int
    //   251	206	5	m	int
    //   60	360	6	n	int
    //   76	346	7	i1	int
    //   270	156	8	i2	int
    //   274	154	9	i3	int
    //   186	95	10	localObject1	Object
    //   330	79	10	localThrowable1	java.lang.Throwable
    //   208	109	11	localObject2	Object
    //   369	7	11	localThrowable2	java.lang.Throwable
    //   383	7	11	localThrowable3	java.lang.Throwable
    //   397	7	11	localThrowable4	java.lang.Throwable
    //   410	20	11	localThrowable5	java.lang.Throwable
    //   199	111	12	localConfig	android.graphics.Bitmap.Config
    // Exception table:
    //   from	to	target	type
    //   0	22	330	java/lang/Throwable
    //   23	59	330	java/lang/Throwable
    //   66	75	330	java/lang/Throwable
    //   82	91	330	java/lang/Throwable
    //   91	116	330	java/lang/Throwable
    //   122	133	330	java/lang/Throwable
    //   141	152	330	java/lang/Throwable
    //   152	185	330	java/lang/Throwable
    //   188	201	330	java/lang/Throwable
    //   219	233	330	java/lang/Throwable
    //   321	329	330	java/lang/Throwable
    //   371	380	330	java/lang/Throwable
    //   385	394	330	java/lang/Throwable
    //   399	408	330	java/lang/Throwable
    //   415	454	330	java/lang/Throwable
    //   201	210	369	java/lang/Throwable
    //   253	264	383	java/lang/Throwable
    //   305	316	397	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.3
 * JD-Core Version:    0.7.0.1
 */