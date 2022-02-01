package com.tencent.mobileqq.troopshare;

class TroopShareUtility$10
  implements Runnable
{
  TroopShareUtility$10(TroopShareUtility paramTroopShareUtility, TroopShareUtility.UploadHeaderCallback paramUploadHeaderCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/troopshare/TroopShareUtility$10:this$0	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   4: getfield 28	com/tencent/mobileqq/troopshare/TroopShareUtility:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   7: invokevirtual 34	com/tencent/mobileqq/app/BaseActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   10: checkcast 36	com/tencent/mobileqq/app/QQAppInterface
    //   13: astore 8
    //   15: aload 8
    //   17: iconst_2
    //   18: invokevirtual 40	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   21: checkcast 42	mqq/manager/TicketManager
    //   24: aload 8
    //   26: invokevirtual 46	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokeinterface 50 2 0
    //   34: astore 9
    //   36: aload 8
    //   38: getstatic 56	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   41: invokevirtual 40	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   44: checkcast 58	com/tencent/mobileqq/app/TroopManager
    //   47: aload_0
    //   48: getfield 14	com/tencent/mobileqq/troopshare/TroopShareUtility$10:this$0	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   51: getfield 61	com/tencent/mobileqq/troopshare/TroopShareUtility:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   54: getfield 67	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   57: invokevirtual 71	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   60: astore 4
    //   62: aload 9
    //   64: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +326 -> 393
    //   70: aload 4
    //   72: ifnull +321 -> 393
    //   75: aload 4
    //   77: getfield 82	com/tencent/mobileqq/data/troop/TroopInfo:wMemberNum	I
    //   80: istore_1
    //   81: iconst_1
    //   82: iload_1
    //   83: if_icmpne +487 -> 570
    //   86: invokestatic 87	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   89: ifeq +305 -> 394
    //   92: getstatic 92	com/tencent/mobileqq/app/AppConstants:PATH_HEAD_HD	Ljava/lang/String;
    //   95: astore 4
    //   97: new 94	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   104: aload 4
    //   106: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 101
    //   111: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore 4
    //   119: new 106	java/io/File
    //   122: dup
    //   123: aload 4
    //   125: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 5
    //   130: aload 5
    //   132: invokevirtual 112	java/io/File:exists	()Z
    //   135: ifne +422 -> 557
    //   138: aload 5
    //   140: invokevirtual 115	java/io/File:createNewFile	()Z
    //   143: pop
    //   144: new 117	java/io/BufferedOutputStream
    //   147: dup
    //   148: new 119	java/io/FileOutputStream
    //   151: dup
    //   152: aload 5
    //   154: invokespecial 122	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   157: sipush 8192
    //   160: invokespecial 125	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   163: astore 6
    //   165: aload 6
    //   167: astore 5
    //   169: invokestatic 130	com/tencent/mobileqq/utils/ImageUtil:a	()Landroid/graphics/drawable/Drawable;
    //   172: checkcast 132	android/graphics/drawable/BitmapDrawable
    //   175: invokevirtual 136	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   178: getstatic 142	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   181: bipush 100
    //   183: aload 6
    //   185: invokevirtual 148	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   188: istore_2
    //   189: iload_2
    //   190: ifeq +375 -> 565
    //   193: iconst_1
    //   194: istore_2
    //   195: aload 6
    //   197: ifnull +365 -> 562
    //   200: aload 6
    //   202: invokevirtual 153	java/io/OutputStream:close	()V
    //   205: new 155	java/util/ArrayList
    //   208: dup
    //   209: invokespecial 156	java/util/ArrayList:<init>	()V
    //   212: astore 7
    //   214: aload 8
    //   216: bipush 113
    //   218: aload_0
    //   219: getfield 14	com/tencent/mobileqq/troopshare/TroopShareUtility$10:this$0	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   222: getfield 61	com/tencent/mobileqq/troopshare/TroopShareUtility:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   225: getfield 67	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   228: iconst_0
    //   229: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getCustomFaceFilePath	(ILjava/lang/String;I)Ljava/lang/String;
    //   232: astore 6
    //   234: new 106	java/io/File
    //   237: dup
    //   238: aload 6
    //   240: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   243: astore 10
    //   245: aload 4
    //   247: astore 5
    //   249: iload_1
    //   250: iconst_1
    //   251: if_icmpeq +15 -> 266
    //   254: aload 10
    //   256: invokevirtual 112	java/io/File:exists	()Z
    //   259: ifne +291 -> 550
    //   262: aload 4
    //   264: astore 5
    //   266: aload 7
    //   268: aload 5
    //   270: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   273: pop
    //   274: aload 7
    //   276: aload 8
    //   278: invokevirtual 167	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   281: aload 9
    //   283: ldc 169
    //   285: invokestatic 175	cooperation/qzone/QZoneShareManager:batchUploadImages	(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    //   288: astore 4
    //   290: aload 4
    //   292: ifnull +250 -> 542
    //   295: aload 4
    //   297: invokevirtual 179	java/util/ArrayList:size	()I
    //   300: ifle +242 -> 542
    //   303: aload 4
    //   305: iconst_0
    //   306: invokevirtual 183	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   309: checkcast 185	java/lang/String
    //   312: astore 5
    //   314: aload 5
    //   316: astore 4
    //   318: iload_2
    //   319: istore_3
    //   320: aload 5
    //   322: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   325: ifne +35 -> 360
    //   328: aload 5
    //   330: ldc 187
    //   332: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   335: ifne +19 -> 354
    //   338: aload 5
    //   340: astore 4
    //   342: iload_2
    //   343: istore_3
    //   344: aload 5
    //   346: ldc 193
    //   348: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   351: ifeq +9 -> 360
    //   354: iconst_1
    //   355: istore_3
    //   356: aload 5
    //   358: astore 4
    //   360: iload_3
    //   361: ifne +7 -> 368
    //   364: ldc 195
    //   366: astore 4
    //   368: new 197	android/os/Handler
    //   371: dup
    //   372: invokestatic 203	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   375: invokespecial 206	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   378: new 208	com/tencent/mobileqq/troopshare/TroopShareUtility$10$1
    //   381: dup
    //   382: aload_0
    //   383: iload_3
    //   384: aload 4
    //   386: invokespecial 211	com/tencent/mobileqq/troopshare/TroopShareUtility$10$1:<init>	(Lcom/tencent/mobileqq/troopshare/TroopShareUtility$10;ZLjava/lang/String;)V
    //   389: invokevirtual 215	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   392: pop
    //   393: return
    //   394: ldc 217
    //   396: astore 4
    //   398: goto -301 -> 97
    //   401: astore 5
    //   403: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +16 -> 422
    //   409: ldc 224
    //   411: iconst_2
    //   412: aload 5
    //   414: invokevirtual 227	java/io/IOException:getMessage	()Ljava/lang/String;
    //   417: aload 5
    //   419: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   422: goto -217 -> 205
    //   425: astore 7
    //   427: aconst_null
    //   428: astore 6
    //   430: aload 6
    //   432: astore 5
    //   434: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +12 -> 449
    //   440: aload 6
    //   442: astore 5
    //   444: aload 7
    //   446: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   449: aload 6
    //   451: ifnull +106 -> 557
    //   454: aload 6
    //   456: invokevirtual 153	java/io/OutputStream:close	()V
    //   459: iconst_0
    //   460: istore_2
    //   461: goto -256 -> 205
    //   464: astore 5
    //   466: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq +16 -> 485
    //   472: ldc 224
    //   474: iconst_2
    //   475: aload 5
    //   477: invokevirtual 227	java/io/IOException:getMessage	()Ljava/lang/String;
    //   480: aload 5
    //   482: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   485: iconst_0
    //   486: istore_2
    //   487: goto -282 -> 205
    //   490: astore 4
    //   492: aconst_null
    //   493: astore 5
    //   495: aload 5
    //   497: ifnull +8 -> 505
    //   500: aload 5
    //   502: invokevirtual 153	java/io/OutputStream:close	()V
    //   505: aload 4
    //   507: athrow
    //   508: astore 5
    //   510: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq -8 -> 505
    //   516: ldc 224
    //   518: iconst_2
    //   519: aload 5
    //   521: invokevirtual 227	java/io/IOException:getMessage	()Ljava/lang/String;
    //   524: aload 5
    //   526: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   529: goto -24 -> 505
    //   532: astore 4
    //   534: goto -39 -> 495
    //   537: astore 7
    //   539: goto -109 -> 430
    //   542: aconst_null
    //   543: astore 4
    //   545: iload_2
    //   546: istore_3
    //   547: goto -187 -> 360
    //   550: aload 6
    //   552: astore 5
    //   554: goto -288 -> 266
    //   557: iconst_0
    //   558: istore_2
    //   559: goto -354 -> 205
    //   562: goto -357 -> 205
    //   565: iconst_0
    //   566: istore_2
    //   567: goto -372 -> 195
    //   570: aconst_null
    //   571: astore 4
    //   573: iconst_0
    //   574: istore_2
    //   575: goto -370 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	this	10
    //   80	172	1	i	int
    //   188	387	2	bool1	boolean
    //   319	228	3	bool2	boolean
    //   60	337	4	localObject1	Object
    //   490	16	4	localObject2	Object
    //   532	1	4	localObject3	Object
    //   543	29	4	localObject4	Object
    //   128	229	5	localObject5	Object
    //   401	17	5	localIOException1	java.io.IOException
    //   432	11	5	localObject6	Object
    //   464	17	5	localIOException2	java.io.IOException
    //   493	8	5	localObject7	Object
    //   508	17	5	localIOException3	java.io.IOException
    //   552	1	5	localObject8	Object
    //   163	388	6	localObject9	Object
    //   212	63	7	localArrayList	java.util.ArrayList
    //   425	20	7	localIOException4	java.io.IOException
    //   537	1	7	localIOException5	java.io.IOException
    //   13	264	8	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   34	248	9	str	java.lang.String
    //   243	12	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   200	205	401	java/io/IOException
    //   138	165	425	java/io/IOException
    //   454	459	464	java/io/IOException
    //   138	165	490	finally
    //   500	505	508	java/io/IOException
    //   169	189	532	finally
    //   434	440	532	finally
    //   444	449	532	finally
    //   169	189	537	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.10
 * JD-Core Version:    0.7.0.1
 */