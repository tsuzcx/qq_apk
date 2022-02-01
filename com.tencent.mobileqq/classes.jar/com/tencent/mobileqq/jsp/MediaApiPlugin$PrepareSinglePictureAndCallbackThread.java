package com.tencent.mobileqq.jsp;

class MediaApiPlugin$PrepareSinglePictureAndCallbackThread
  extends Thread
{
  String a;
  int b;
  int c;
  int d;
  int e;
  String f;
  
  public MediaApiPlugin$PrepareSinglePictureAndCallbackThread(MediaApiPlugin paramMediaApiPlugin, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramString2;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:f	Ljava/lang/String;
    //   4: aload_0
    //   5: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:d	I
    //   8: aload_0
    //   9: getfield 31	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:e	I
    //   12: aload_0
    //   13: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:b	I
    //   16: aload_0
    //   17: getfield 27	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:c	I
    //   20: invokestatic 48	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;IIII)Lorg/json/JSONObject;
    //   23: astore_1
    //   24: aload_0
    //   25: invokevirtual 52	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:isInterrupted	()Z
    //   28: ifne +56 -> 84
    //   31: aload_0
    //   32: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   35: aload_0
    //   36: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:a	Ljava/lang/String;
    //   39: iconst_2
    //   40: anewarray 54	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: ldc 56
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: aload_1
    //   51: invokevirtual 62	org/json/JSONObject:toString	()Ljava/lang/String;
    //   54: aastore
    //   55: invokevirtual 66	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   62: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   65: ifnull +268 -> 333
    //   68: aload_0
    //   69: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   72: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   75: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   78: ifeq +255 -> 333
    //   81: goto +85 -> 166
    //   84: new 43	java/lang/InterruptedException
    //   87: dup
    //   88: invokespecial 75	java/lang/InterruptedException:<init>	()V
    //   91: athrow
    //   92: astore_1
    //   93: goto +241 -> 334
    //   96: aload_0
    //   97: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   100: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   103: invokevirtual 84	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +35 -> 143
    //   111: aload_1
    //   112: invokevirtual 89	android/app/Activity:isFinishing	()Z
    //   115: ifne +28 -> 143
    //   118: aload_0
    //   119: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   122: aload_0
    //   123: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:a	Ljava/lang/String;
    //   126: iconst_2
    //   127: anewarray 54	java/lang/String
    //   130: dup
    //   131: iconst_0
    //   132: ldc 91
    //   134: aastore
    //   135: dup
    //   136: iconst_1
    //   137: ldc 93
    //   139: aastore
    //   140: invokevirtual 66	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   143: aload_0
    //   144: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   147: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   150: ifnull +183 -> 333
    //   153: aload_0
    //   154: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   157: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   160: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   163: ifeq +170 -> 333
    //   166: aload_0
    //   167: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   170: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   173: invokevirtual 96	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   176: return
    //   177: aload_0
    //   178: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   181: aload_0
    //   182: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:a	Ljava/lang/String;
    //   185: iconst_2
    //   186: anewarray 54	java/lang/String
    //   189: dup
    //   190: iconst_0
    //   191: ldc 98
    //   193: aastore
    //   194: dup
    //   195: iconst_1
    //   196: ldc 93
    //   198: aastore
    //   199: invokevirtual 66	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   202: aload_0
    //   203: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   206: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   209: ifnull +124 -> 333
    //   212: aload_0
    //   213: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   216: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   219: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   222: ifeq +111 -> 333
    //   225: goto -59 -> 166
    //   228: aload_0
    //   229: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   232: aload_0
    //   233: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:a	Ljava/lang/String;
    //   236: iconst_2
    //   237: anewarray 54	java/lang/String
    //   240: dup
    //   241: iconst_0
    //   242: ldc 98
    //   244: aastore
    //   245: dup
    //   246: iconst_1
    //   247: ldc 93
    //   249: aastore
    //   250: invokevirtual 66	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   253: aload_0
    //   254: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   257: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   260: ifnull +73 -> 333
    //   263: aload_0
    //   264: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   267: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   270: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   273: ifeq +60 -> 333
    //   276: goto -110 -> 166
    //   279: invokestatic 103	java/lang/System:gc	()V
    //   282: aload_0
    //   283: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   286: aload_0
    //   287: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:a	Ljava/lang/String;
    //   290: iconst_2
    //   291: anewarray 54	java/lang/String
    //   294: dup
    //   295: iconst_0
    //   296: ldc 105
    //   298: aastore
    //   299: dup
    //   300: iconst_1
    //   301: ldc 93
    //   303: aastore
    //   304: invokevirtual 66	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   307: aload_0
    //   308: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   311: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   314: ifnull +19 -> 333
    //   317: aload_0
    //   318: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   321: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   324: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   327: ifeq +6 -> 333
    //   330: goto -164 -> 166
    //   333: return
    //   334: aload_0
    //   335: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   338: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   341: ifnull +26 -> 367
    //   344: aload_0
    //   345: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   348: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   351: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   354: ifeq +13 -> 367
    //   357: aload_0
    //   358: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   361: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:f	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   364: invokevirtual 96	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   367: goto +5 -> 372
    //   370: aload_1
    //   371: athrow
    //   372: goto -2 -> 370
    //   375: astore_1
    //   376: goto -97 -> 279
    //   379: astore_1
    //   380: goto -152 -> 228
    //   383: astore_1
    //   384: goto -207 -> 177
    //   387: astore_1
    //   388: goto -292 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	PrepareSinglePictureAndCallbackThread
    //   23	28	1	localJSONObject	org.json.JSONObject
    //   92	1	1	localObject	java.lang.Object
    //   106	265	1	localActivity	android.app.Activity
    //   375	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   379	1	1	localIOException	java.io.IOException
    //   383	1	1	localJSONException	org.json.JSONException
    //   387	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   0	58	92	finally
    //   84	92	92	finally
    //   96	107	92	finally
    //   111	143	92	finally
    //   177	202	92	finally
    //   228	253	92	finally
    //   279	307	92	finally
    //   0	58	375	java/lang/OutOfMemoryError
    //   84	92	375	java/lang/OutOfMemoryError
    //   0	58	379	java/io/IOException
    //   84	92	379	java/io/IOException
    //   0	58	383	org/json/JSONException
    //   84	92	383	org/json/JSONException
    //   0	58	387	java/lang/InterruptedException
    //   84	92	387	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.PrepareSinglePictureAndCallbackThread
 * JD-Core Version:    0.7.0.1
 */