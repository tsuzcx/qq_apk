package com.tencent.mobileqq.jsp;

class MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2
  extends Thread
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2(MediaApiPlugin paramMediaApiPlugin, String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:b	Ljava/lang/String;
    //   4: aload_0
    //   5: getfield 21	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:jdField_a_of_type_Int	I
    //   8: invokestatic 38	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11: astore_1
    //   12: aload_0
    //   13: invokevirtual 42	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:isInterrupted	()Z
    //   16: ifne +46 -> 62
    //   19: aload_0
    //   20: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   23: aload_0
    //   24: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: iconst_2
    //   28: anewarray 44	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 46
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload_1
    //   39: invokevirtual 52	org/json/JSONObject:toString	()Ljava/lang/String;
    //   42: aastore
    //   43: invokevirtual 56	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   50: getfield 59	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   53: invokevirtual 64	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   56: ifeq +215 -> 271
    //   59: goto +75 -> 134
    //   62: new 33	java/lang/InterruptedException
    //   65: dup
    //   66: invokespecial 65	java/lang/InterruptedException:<init>	()V
    //   69: athrow
    //   70: astore_1
    //   71: goto +201 -> 272
    //   74: aload_0
    //   75: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   78: getfield 69	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   81: invokevirtual 74	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +35 -> 121
    //   89: aload_1
    //   90: invokevirtual 79	android/app/Activity:isFinishing	()Z
    //   93: ifne +28 -> 121
    //   96: aload_0
    //   97: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   100: aload_0
    //   101: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   104: iconst_2
    //   105: anewarray 44	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: ldc 81
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: ldc 83
    //   117: aastore
    //   118: invokevirtual 56	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   121: aload_0
    //   122: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   125: getfield 59	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   128: invokevirtual 64	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   131: ifeq +140 -> 271
    //   134: aload_0
    //   135: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   138: getfield 59	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   141: invokevirtual 86	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   144: return
    //   145: aload_0
    //   146: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   149: aload_0
    //   150: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   153: iconst_2
    //   154: anewarray 44	java/lang/String
    //   157: dup
    //   158: iconst_0
    //   159: ldc 88
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: ldc 83
    //   166: aastore
    //   167: invokevirtual 56	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   170: aload_0
    //   171: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   174: getfield 59	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   177: invokevirtual 64	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   180: ifeq +91 -> 271
    //   183: goto -49 -> 134
    //   186: aload_0
    //   187: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   190: aload_0
    //   191: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   194: iconst_2
    //   195: anewarray 44	java/lang/String
    //   198: dup
    //   199: iconst_0
    //   200: ldc 88
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: ldc 83
    //   207: aastore
    //   208: invokevirtual 56	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   211: aload_0
    //   212: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   215: getfield 59	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   218: invokevirtual 64	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   221: ifeq +50 -> 271
    //   224: goto -90 -> 134
    //   227: invokestatic 93	java/lang/System:gc	()V
    //   230: aload_0
    //   231: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   234: aload_0
    //   235: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   238: iconst_2
    //   239: anewarray 44	java/lang/String
    //   242: dup
    //   243: iconst_0
    //   244: ldc 95
    //   246: aastore
    //   247: dup
    //   248: iconst_1
    //   249: ldc 83
    //   251: aastore
    //   252: invokevirtual 56	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   255: aload_0
    //   256: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   259: getfield 59	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   262: invokevirtual 64	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   265: ifeq +6 -> 271
    //   268: goto -134 -> 134
    //   271: return
    //   272: aload_0
    //   273: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   276: getfield 59	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   279: invokevirtual 64	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   282: ifeq +13 -> 295
    //   285: aload_0
    //   286: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PrepareSinglePictureAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   289: getfield 59	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   292: invokevirtual 86	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   295: goto +5 -> 300
    //   298: aload_1
    //   299: athrow
    //   300: goto -2 -> 298
    //   303: astore_1
    //   304: goto -77 -> 227
    //   307: astore_1
    //   308: goto -122 -> 186
    //   311: astore_1
    //   312: goto -167 -> 145
    //   315: astore_1
    //   316: goto -242 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	PrepareSinglePictureAndCallbackThreadV2
    //   11	28	1	localJSONObject	org.json.JSONObject
    //   70	1	1	localObject	java.lang.Object
    //   84	215	1	localActivity	android.app.Activity
    //   303	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   307	1	1	localIOException	java.io.IOException
    //   311	1	1	localJSONException	org.json.JSONException
    //   315	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   0	46	70	finally
    //   62	70	70	finally
    //   74	85	70	finally
    //   89	121	70	finally
    //   145	170	70	finally
    //   186	211	70	finally
    //   227	255	70	finally
    //   0	46	303	java/lang/OutOfMemoryError
    //   62	70	303	java/lang/OutOfMemoryError
    //   0	46	307	java/io/IOException
    //   62	70	307	java/io/IOException
    //   0	46	311	org/json/JSONException
    //   62	70	311	org/json/JSONException
    //   0	46	315	java/lang/InterruptedException
    //   62	70	315	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.PrepareSinglePictureAndCallbackThreadV2
 * JD-Core Version:    0.7.0.1
 */