package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class MediaChooseJsProxyImpl$3
  implements IActivityResultListener
{
  MediaChooseJsProxyImpl$3(MediaChooseJsProxyImpl paramMediaChooseJsProxyImpl, IActivityResultManager paramIActivityResultManager) {}
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: sipush 10020
    //   4: if_icmpeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: iload_2
    //   10: iconst_m1
    //   11: if_icmpeq +31 -> 42
    //   14: aload_0
    //   15: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   18: astore_3
    //   19: aload_3
    //   20: aload_3
    //   21: invokestatic 31	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;)I
    //   24: ldc 33
    //   26: aconst_null
    //   27: invokestatic 36	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;ILjava/lang/String;Lorg/json/JSONObject;)V
    //   30: aload_0
    //   31: getfield 15	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager	Lcom/tencent/qqmini/sdk/launcher/shell/IActivityResultManager;
    //   34: aload_0
    //   35: invokeinterface 42 2 0
    //   40: iconst_1
    //   41: ireturn
    //   42: aload_3
    //   43: getstatic 47	com/tencent/aelight/camera/struct/editor/PublishParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   46: invokevirtual 53	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   49: checkcast 44	com/tencent/aelight/camera/struct/editor/PublishParam
    //   52: astore 8
    //   54: aload_3
    //   55: ldc 55
    //   57: invokevirtual 59	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_3
    //   61: aload 8
    //   63: ifnull +308 -> 371
    //   66: new 61	org/json/JSONObject
    //   69: dup
    //   70: invokespecial 62	org/json/JSONObject:<init>	()V
    //   73: astore_3
    //   74: aload 8
    //   76: getfield 65	com/tencent/aelight/camera/struct/editor/PublishParam:j	Ljava/lang/String;
    //   79: astore 9
    //   81: new 67	java/io/File
    //   84: dup
    //   85: aload 9
    //   87: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: invokevirtual 74	java/io/File:length	()J
    //   93: lstore 4
    //   95: aload 8
    //   97: getfield 77	com/tencent/aelight/camera/struct/editor/PublishParam:jdField_a_of_type_Long	J
    //   100: lstore 6
    //   102: aload 8
    //   104: getfield 80	com/tencent/aelight/camera/struct/editor/PublishParam:jdField_a_of_type_Int	I
    //   107: istore_1
    //   108: aload 8
    //   110: getfield 83	com/tencent/aelight/camera/struct/editor/PublishParam:b	I
    //   113: istore_2
    //   114: aload 8
    //   116: getfield 86	com/tencent/aelight/camera/struct/editor/PublishParam:c	Ljava/lang/String;
    //   119: astore 8
    //   121: aload_0
    //   122: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   125: invokestatic 89	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   128: astore 10
    //   130: aload_3
    //   131: ldc 91
    //   133: aload 10
    //   135: ldc 93
    //   137: invokeinterface 99 2 0
    //   142: checkcast 93	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   145: aload 9
    //   147: invokeinterface 102 2 0
    //   152: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   155: pop
    //   156: aload_3
    //   157: ldc 108
    //   159: ldc 110
    //   161: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload_3
    //   166: ldc 112
    //   168: lload 4
    //   170: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   173: pop
    //   174: aload_3
    //   175: ldc 117
    //   177: lload 6
    //   179: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   182: pop
    //   183: aload_3
    //   184: ldc 119
    //   186: iload_1
    //   187: invokevirtual 122	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_3
    //   192: ldc 124
    //   194: iload_2
    //   195: invokevirtual 122	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   198: pop
    //   199: aload_3
    //   200: ldc 126
    //   202: aload_0
    //   203: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   206: invokestatic 89	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   209: ldc 93
    //   211: invokeinterface 99 2 0
    //   216: checkcast 93	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   219: aload 8
    //   221: invokeinterface 102 2 0
    //   226: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   229: pop
    //   230: new 128	org/json/JSONArray
    //   233: dup
    //   234: invokespecial 129	org/json/JSONArray:<init>	()V
    //   237: astore 8
    //   239: aload 8
    //   241: aload_3
    //   242: invokevirtual 132	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   245: pop
    //   246: new 61	org/json/JSONObject
    //   249: dup
    //   250: invokespecial 62	org/json/JSONObject:<init>	()V
    //   253: astore_3
    //   254: aload_3
    //   255: ldc 134
    //   257: aload 8
    //   259: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   262: pop
    //   263: aload_0
    //   264: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   267: astore 8
    //   269: aload_0
    //   270: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   273: invokestatic 31	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;)I
    //   276: istore_1
    //   277: aload 8
    //   279: iload_1
    //   280: ldc 33
    //   282: aload_3
    //   283: invokestatic 136	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:b	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;ILjava/lang/String;Lorg/json/JSONObject;)V
    //   286: goto +300 -> 586
    //   289: astore_3
    //   290: goto +16 -> 306
    //   293: astore_3
    //   294: goto +12 -> 306
    //   297: astore_3
    //   298: goto +8 -> 306
    //   301: astore_3
    //   302: goto +4 -> 306
    //   305: astore_3
    //   306: ldc 138
    //   308: iconst_1
    //   309: ldc 140
    //   311: aload_3
    //   312: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   315: aload_0
    //   316: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   319: astore 8
    //   321: aload 8
    //   323: invokestatic 31	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;)I
    //   326: istore_1
    //   327: new 148	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   334: astore 9
    //   336: aload 9
    //   338: ldc 151
    //   340: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 9
    //   346: aload_3
    //   347: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   350: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 8
    //   356: iload_1
    //   357: ldc 33
    //   359: aconst_null
    //   360: aload 9
    //   362: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 165	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   368: goto +218 -> 586
    //   371: aload_3
    //   372: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +211 -> 586
    //   378: new 67	java/io/File
    //   381: dup
    //   382: aload_3
    //   383: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   386: invokevirtual 74	java/io/File:length	()J
    //   389: lstore 4
    //   391: new 61	org/json/JSONObject
    //   394: dup
    //   395: invokespecial 62	org/json/JSONObject:<init>	()V
    //   398: astore 8
    //   400: aload 8
    //   402: ldc 91
    //   404: aload_0
    //   405: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   408: invokestatic 89	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   411: ldc 93
    //   413: invokeinterface 99 2 0
    //   418: checkcast 93	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   421: aload_3
    //   422: invokeinterface 102 2 0
    //   427: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   430: pop
    //   431: aload 8
    //   433: ldc 108
    //   435: ldc 173
    //   437: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   440: pop
    //   441: aload 8
    //   443: ldc 112
    //   445: lload 4
    //   447: invokevirtual 115	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   450: pop
    //   451: new 128	org/json/JSONArray
    //   454: dup
    //   455: invokespecial 129	org/json/JSONArray:<init>	()V
    //   458: astore_3
    //   459: aload_3
    //   460: aload 8
    //   462: invokevirtual 132	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   465: pop
    //   466: new 61	org/json/JSONObject
    //   469: dup
    //   470: invokespecial 62	org/json/JSONObject:<init>	()V
    //   473: astore 8
    //   475: aload 8
    //   477: ldc 134
    //   479: aload_3
    //   480: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   483: pop
    //   484: aload_0
    //   485: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   488: aload_0
    //   489: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   492: invokestatic 31	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;)I
    //   495: ldc 33
    //   497: aload 8
    //   499: invokestatic 136	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:b	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;ILjava/lang/String;Lorg/json/JSONObject;)V
    //   502: goto +66 -> 568
    //   505: astore_3
    //   506: ldc 138
    //   508: iconst_1
    //   509: ldc 175
    //   511: aload_3
    //   512: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   515: aload_0
    //   516: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   519: astore 8
    //   521: aload 8
    //   523: invokestatic 31	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;)I
    //   526: istore_1
    //   527: new 148	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   534: astore 9
    //   536: aload 9
    //   538: ldc 151
    //   540: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload 9
    //   546: aload_3
    //   547: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   550: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 8
    //   556: iload_1
    //   557: ldc 33
    //   559: aconst_null
    //   560: aload 9
    //   562: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 165	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   568: aload_0
    //   569: getfield 13	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiProxyimplMediaChooseJsProxyImpl	Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;
    //   572: astore_3
    //   573: aload_3
    //   574: aload_3
    //   575: invokestatic 31	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;)I
    //   578: ldc 33
    //   580: aconst_null
    //   581: ldc 177
    //   583: invokestatic 165	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl:a	(Lcom/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl;ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   586: aload_0
    //   587: getfield 15	com/tencent/qqmini/proxyimpl/MediaChooseJsProxyImpl$3:jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager	Lcom/tencent/qqmini/sdk/launcher/shell/IActivityResultManager;
    //   590: aload_0
    //   591: invokeinterface 42 2 0
    //   596: iconst_1
    //   597: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	this	3
    //   0	598	1	paramInt1	int
    //   0	598	2	paramInt2	int
    //   0	598	3	paramIntent	android.content.Intent
    //   93	353	4	l1	long
    //   100	78	6	l2	long
    //   52	503	8	localObject1	Object
    //   79	482	9	localObject2	Object
    //   128	6	10	localIMiniAppContext	com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    // Exception table:
    //   from	to	target	type
    //   277	286	289	java/lang/Exception
    //   130	277	293	java/lang/Exception
    //   121	130	297	java/lang/Exception
    //   108	121	301	java/lang/Exception
    //   66	108	305	java/lang/Exception
    //   391	502	505	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */