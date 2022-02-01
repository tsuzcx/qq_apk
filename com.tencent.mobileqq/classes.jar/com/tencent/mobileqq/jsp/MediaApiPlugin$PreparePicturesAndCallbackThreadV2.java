package com.tencent.mobileqq.jsp;

class MediaApiPlugin$PreparePicturesAndCallbackThreadV2
  extends Thread
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public MediaApiPlugin$PreparePicturesAndCallbackThreadV2(MediaApiPlugin paramMediaApiPlugin, String paramString, int paramInt, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 35	org/json/JSONArray
    //   3: dup
    //   4: invokespecial 36	org/json/JSONArray:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   12: arraylength
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: iload_2
    //   18: if_icmpge +43 -> 61
    //   21: aload_0
    //   22: invokevirtual 40	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:isInterrupted	()Z
    //   25: ifne +28 -> 53
    //   28: aload_3
    //   29: aload_0
    //   30: getfield 23	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   33: iload_1
    //   34: aaload
    //   35: aload_0
    //   36: getfield 21	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:jdField_a_of_type_Int	I
    //   39: invokestatic 45	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   42: invokevirtual 49	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   45: pop
    //   46: iload_1
    //   47: iconst_1
    //   48: iadd
    //   49: istore_1
    //   50: goto -34 -> 16
    //   53: new 33	java/lang/InterruptedException
    //   56: dup
    //   57: invokespecial 50	java/lang/InterruptedException:<init>	()V
    //   60: athrow
    //   61: aload_0
    //   62: invokevirtual 40	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:isInterrupted	()Z
    //   65: ifne +46 -> 111
    //   68: aload_0
    //   69: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   72: aload_0
    //   73: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   76: iconst_2
    //   77: anewarray 52	java/lang/String
    //   80: dup
    //   81: iconst_0
    //   82: ldc 54
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: aload_3
    //   88: invokevirtual 58	org/json/JSONArray:toString	()Ljava/lang/String;
    //   91: aastore
    //   92: invokevirtual 62	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   95: aload_0
    //   96: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   99: getfield 65	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   102: invokevirtual 70	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   105: ifeq +215 -> 320
    //   108: goto +75 -> 183
    //   111: new 33	java/lang/InterruptedException
    //   114: dup
    //   115: invokespecial 50	java/lang/InterruptedException:<init>	()V
    //   118: athrow
    //   119: astore_3
    //   120: goto +201 -> 321
    //   123: aload_0
    //   124: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   127: getfield 74	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   130: invokevirtual 79	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   133: astore_3
    //   134: aload_3
    //   135: ifnull +35 -> 170
    //   138: aload_3
    //   139: invokevirtual 84	android/app/Activity:isFinishing	()Z
    //   142: ifne +28 -> 170
    //   145: aload_0
    //   146: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   149: aload_0
    //   150: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   153: iconst_2
    //   154: anewarray 52	java/lang/String
    //   157: dup
    //   158: iconst_0
    //   159: ldc 86
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: ldc 88
    //   166: aastore
    //   167: invokevirtual 62	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   170: aload_0
    //   171: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   174: getfield 65	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   177: invokevirtual 70	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   180: ifeq +140 -> 320
    //   183: aload_0
    //   184: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   187: getfield 65	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   190: invokevirtual 91	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   193: return
    //   194: aload_0
    //   195: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   198: aload_0
    //   199: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   202: iconst_2
    //   203: anewarray 52	java/lang/String
    //   206: dup
    //   207: iconst_0
    //   208: ldc 93
    //   210: aastore
    //   211: dup
    //   212: iconst_1
    //   213: ldc 88
    //   215: aastore
    //   216: invokevirtual 62	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   223: getfield 65	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   226: invokevirtual 70	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   229: ifeq +91 -> 320
    //   232: goto -49 -> 183
    //   235: aload_0
    //   236: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   239: aload_0
    //   240: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   243: iconst_2
    //   244: anewarray 52	java/lang/String
    //   247: dup
    //   248: iconst_0
    //   249: ldc 93
    //   251: aastore
    //   252: dup
    //   253: iconst_1
    //   254: ldc 88
    //   256: aastore
    //   257: invokevirtual 62	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   260: aload_0
    //   261: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   264: getfield 65	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   267: invokevirtual 70	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   270: ifeq +50 -> 320
    //   273: goto -90 -> 183
    //   276: invokestatic 98	java/lang/System:gc	()V
    //   279: aload_0
    //   280: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   283: aload_0
    //   284: getfield 19	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   287: iconst_2
    //   288: anewarray 52	java/lang/String
    //   291: dup
    //   292: iconst_0
    //   293: ldc 100
    //   295: aastore
    //   296: dup
    //   297: iconst_1
    //   298: ldc 88
    //   300: aastore
    //   301: invokevirtual 62	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   308: getfield 65	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   311: invokevirtual 70	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   314: ifeq +6 -> 320
    //   317: goto -134 -> 183
    //   320: return
    //   321: aload_0
    //   322: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   325: getfield 65	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   328: invokevirtual 70	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   331: ifeq +13 -> 344
    //   334: aload_0
    //   335: getfield 14	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThreadV2:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   338: getfield 65	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   341: invokevirtual 91	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   344: goto +5 -> 349
    //   347: aload_3
    //   348: athrow
    //   349: goto -2 -> 347
    //   352: astore_3
    //   353: goto -77 -> 276
    //   356: astore_3
    //   357: goto -122 -> 235
    //   360: astore_3
    //   361: goto -167 -> 194
    //   364: astore_3
    //   365: goto -242 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	PreparePicturesAndCallbackThreadV2
    //   15	35	1	i	int
    //   13	6	2	j	int
    //   7	81	3	localJSONArray	org.json.JSONArray
    //   119	1	3	localObject	java.lang.Object
    //   133	215	3	localActivity	android.app.Activity
    //   352	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   356	1	3	localIOException	java.io.IOException
    //   360	1	3	localJSONException	org.json.JSONException
    //   364	1	3	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   0	14	119	finally
    //   21	46	119	finally
    //   53	61	119	finally
    //   61	95	119	finally
    //   111	119	119	finally
    //   123	134	119	finally
    //   138	170	119	finally
    //   194	219	119	finally
    //   235	260	119	finally
    //   276	304	119	finally
    //   0	14	352	java/lang/OutOfMemoryError
    //   21	46	352	java/lang/OutOfMemoryError
    //   53	61	352	java/lang/OutOfMemoryError
    //   61	95	352	java/lang/OutOfMemoryError
    //   111	119	352	java/lang/OutOfMemoryError
    //   0	14	356	java/io/IOException
    //   21	46	356	java/io/IOException
    //   53	61	356	java/io/IOException
    //   61	95	356	java/io/IOException
    //   111	119	356	java/io/IOException
    //   0	14	360	org/json/JSONException
    //   21	46	360	org/json/JSONException
    //   53	61	360	org/json/JSONException
    //   61	95	360	org/json/JSONException
    //   111	119	360	org/json/JSONException
    //   0	14	364	java/lang/InterruptedException
    //   21	46	364	java/lang/InterruptedException
    //   53	61	364	java/lang/InterruptedException
    //   61	95	364	java/lang/InterruptedException
    //   111	119	364	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.PreparePicturesAndCallbackThreadV2
 * JD-Core Version:    0.7.0.1
 */