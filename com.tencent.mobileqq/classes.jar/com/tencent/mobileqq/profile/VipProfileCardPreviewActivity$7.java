package com.tencent.mobileqq.profile;

class VipProfileCardPreviewActivity$7
  implements Runnable
{
  VipProfileCardPreviewActivity$7(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, String paramString1, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 30	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 31	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 9
    //   9: aload 9
    //   11: iconst_1
    //   12: putfield 35	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   15: aload_0
    //   16: getfield 15	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:this$0	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   19: getfield 41	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: invokevirtual 53	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   28: astore 10
    //   30: aload_0
    //   31: getfield 17	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:a	Ljava/lang/String;
    //   34: aload 9
    //   36: invokestatic 59	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   39: pop
    //   40: aload 9
    //   42: iconst_0
    //   43: putfield 35	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   46: aload 9
    //   48: getstatic 65	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   51: putfield 68	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   54: aload 9
    //   56: aload_0
    //   57: getfield 15	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:this$0	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   60: aload 9
    //   62: aload_0
    //   63: getfield 15	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:this$0	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   66: getfield 72	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:ak	I
    //   69: aload_0
    //   70: getfield 15	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:this$0	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   73: getfield 75	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:aj	I
    //   76: invokevirtual 78	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   79: putfield 81	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   82: new 83	java/io/BufferedInputStream
    //   85: dup
    //   86: new 85	java/io/FileInputStream
    //   89: dup
    //   90: new 87	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: getfield 17	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:a	Ljava/lang/String;
    //   98: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: invokespecial 96	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore 7
    //   109: aload 7
    //   111: astore 6
    //   113: aload 7
    //   115: aconst_null
    //   116: aload 9
    //   118: invokestatic 100	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   121: astore 8
    //   123: aload 8
    //   125: ifnonnull +22 -> 147
    //   128: aload 7
    //   130: invokevirtual 103	java/io/BufferedInputStream:close	()V
    //   133: return
    //   134: astore 6
    //   136: ldc 105
    //   138: iconst_1
    //   139: ldc 107
    //   141: aload 6
    //   143: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   146: return
    //   147: aload 7
    //   149: astore 6
    //   151: aload 8
    //   153: invokevirtual 119	android/graphics/Bitmap:getHeight	()I
    //   156: istore_2
    //   157: aload 7
    //   159: astore 6
    //   161: aload 8
    //   163: invokevirtual 122	android/graphics/Bitmap:getWidth	()I
    //   166: istore_3
    //   167: aload 7
    //   169: astore 6
    //   171: aload_0
    //   172: getfield 15	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:this$0	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   175: getfield 125	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:u	I
    //   178: i2f
    //   179: aload_0
    //   180: getfield 15	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:this$0	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   183: getfield 128	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:t	I
    //   186: i2f
    //   187: fdiv
    //   188: fstore_1
    //   189: aload 7
    //   191: astore 6
    //   193: iload_3
    //   194: iload_2
    //   195: i2f
    //   196: fload_1
    //   197: fmul
    //   198: f2i
    //   199: invokestatic 134	java/lang/Math:min	(II)I
    //   202: istore 4
    //   204: aload 7
    //   206: astore 6
    //   208: iload 4
    //   210: i2f
    //   211: fload_1
    //   212: fdiv
    //   213: f2i
    //   214: istore 5
    //   216: aload 7
    //   218: astore 6
    //   220: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +543 -> 766
    //   226: aload 7
    //   228: astore 6
    //   230: new 140	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   237: astore 11
    //   239: aload 7
    //   241: astore 6
    //   243: aload 11
    //   245: ldc 143
    //   247: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 7
    //   253: astore 6
    //   255: aload 11
    //   257: iload 4
    //   259: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 7
    //   265: astore 6
    //   267: aload 11
    //   269: ldc 152
    //   271: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 7
    //   277: astore 6
    //   279: aload 11
    //   281: iload 5
    //   283: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 7
    //   289: astore 6
    //   291: aload 11
    //   293: ldc 154
    //   295: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 7
    //   301: astore 6
    //   303: aload 11
    //   305: aload 9
    //   307: getfield 81	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   310: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 7
    //   316: astore 6
    //   318: ldc 105
    //   320: iconst_2
    //   321: aload 11
    //   323: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: goto +437 -> 766
    //   332: aload 7
    //   334: astore 6
    //   336: aload 8
    //   338: iconst_0
    //   339: iconst_0
    //   340: iload 4
    //   342: iload 5
    //   344: invokestatic 166	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   347: astore 9
    //   349: aload 7
    //   351: astore 6
    //   353: aload 8
    //   355: invokevirtual 169	android/graphics/Bitmap:recycle	()V
    //   358: aload 7
    //   360: astore 6
    //   362: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +416 -> 781
    //   368: aload 7
    //   370: astore 6
    //   372: ldc 105
    //   374: iconst_2
    //   375: ldc 171
    //   377: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: goto +401 -> 781
    //   383: aload 8
    //   385: ifnull +99 -> 484
    //   388: aload 7
    //   390: astore 6
    //   392: aload 8
    //   394: invokestatic 176	com/tencent/mobileqq/util/Utils:a	(Landroid/graphics/Bitmap;)I
    //   397: istore_2
    //   398: aload 7
    //   400: astore 6
    //   402: new 178	android/graphics/drawable/BitmapDrawable
    //   405: dup
    //   406: aload 10
    //   408: aload 8
    //   410: invokespecial 181	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   413: astore 8
    //   415: aload 7
    //   417: astore 6
    //   419: aload 8
    //   421: aload 10
    //   423: invokevirtual 187	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   426: invokevirtual 191	android/graphics/drawable/BitmapDrawable:setTargetDensity	(Landroid/util/DisplayMetrics;)V
    //   429: aload 7
    //   431: astore 6
    //   433: aload_0
    //   434: getfield 19	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:b	Ljava/lang/String;
    //   437: ifnull +34 -> 471
    //   440: aload 7
    //   442: astore 6
    //   444: getstatic 196	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   447: aload_0
    //   448: getfield 19	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:b	Ljava/lang/String;
    //   451: new 198	android/util/Pair
    //   454: dup
    //   455: aload 8
    //   457: invokevirtual 202	android/graphics/drawable/BitmapDrawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   460: iload_2
    //   461: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   464: invokespecial 211	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   467: invokevirtual 217	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   470: pop
    //   471: aload 7
    //   473: astore 6
    //   475: aload_0
    //   476: getfield 15	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:this$0	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   479: aload 8
    //   481: putfield 221	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:H	Landroid/graphics/drawable/Drawable;
    //   484: aload 7
    //   486: astore 6
    //   488: aload_0
    //   489: getfield 15	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:this$0	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   492: getfield 221	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:H	Landroid/graphics/drawable/Drawable;
    //   495: ifnull +34 -> 529
    //   498: aload 7
    //   500: astore 6
    //   502: aload_0
    //   503: getfield 15	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:this$0	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   506: getfield 225	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	Landroid/os/Handler;
    //   509: ifnull +20 -> 529
    //   512: aload 7
    //   514: astore 6
    //   516: aload_0
    //   517: getfield 15	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$7:this$0	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   520: getfield 225	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	Landroid/os/Handler;
    //   523: bipush 27
    //   525: invokevirtual 231	android/os/Handler:sendEmptyMessage	(I)Z
    //   528: pop
    //   529: aload 7
    //   531: invokevirtual 103	java/io/BufferedInputStream:close	()V
    //   534: return
    //   535: astore 8
    //   537: goto +21 -> 558
    //   540: astore 8
    //   542: goto +97 -> 639
    //   545: astore 6
    //   547: aconst_null
    //   548: astore 7
    //   550: goto +188 -> 738
    //   553: astore 8
    //   555: aconst_null
    //   556: astore 7
    //   558: aload 7
    //   560: astore 6
    //   562: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +58 -> 623
    //   568: aload 7
    //   570: astore 6
    //   572: new 140	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   579: astore 9
    //   581: aload 7
    //   583: astore 6
    //   585: aload 9
    //   587: ldc 233
    //   589: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 7
    //   595: astore 6
    //   597: aload 9
    //   599: aload 8
    //   601: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   604: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 7
    //   610: astore 6
    //   612: ldc 105
    //   614: iconst_2
    //   615: aload 9
    //   617: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: aload 7
    //   625: ifnull +102 -> 727
    //   628: aload 7
    //   630: invokevirtual 103	java/io/BufferedInputStream:close	()V
    //   633: return
    //   634: astore 8
    //   636: aconst_null
    //   637: astore 7
    //   639: aload 7
    //   641: astore 6
    //   643: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +58 -> 704
    //   649: aload 7
    //   651: astore 6
    //   653: new 140	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   660: astore 9
    //   662: aload 7
    //   664: astore 6
    //   666: aload 9
    //   668: ldc 238
    //   670: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload 7
    //   676: astore 6
    //   678: aload 9
    //   680: aload 8
    //   682: invokevirtual 239	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   685: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload 7
    //   691: astore 6
    //   693: ldc 105
    //   695: iconst_2
    //   696: aload 9
    //   698: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: aload 7
    //   706: ifnull +21 -> 727
    //   709: aload 7
    //   711: invokevirtual 103	java/io/BufferedInputStream:close	()V
    //   714: return
    //   715: astore 6
    //   717: ldc 105
    //   719: iconst_1
    //   720: ldc 107
    //   722: aload 6
    //   724: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   727: return
    //   728: astore 8
    //   730: aload 6
    //   732: astore 7
    //   734: aload 8
    //   736: astore 6
    //   738: aload 7
    //   740: ifnull +23 -> 763
    //   743: aload 7
    //   745: invokevirtual 103	java/io/BufferedInputStream:close	()V
    //   748: goto +15 -> 763
    //   751: astore 7
    //   753: ldc 105
    //   755: iconst_1
    //   756: ldc 107
    //   758: aload 7
    //   760: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   763: aload 6
    //   765: athrow
    //   766: iload_3
    //   767: iload 4
    //   769: if_icmpne -437 -> 332
    //   772: iload_2
    //   773: iload 5
    //   775: if_icmpne -443 -> 332
    //   778: goto -395 -> 383
    //   781: aload 9
    //   783: astore 8
    //   785: goto -402 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	this	7
    //   188	24	1	f	float
    //   156	620	2	i	int
    //   166	604	3	j	int
    //   202	568	4	k	int
    //   214	562	5	m	int
    //   111	1	6	localObject1	Object
    //   134	8	6	localException1	java.lang.Exception
    //   149	366	6	localObject2	Object
    //   545	1	6	localObject3	Object
    //   560	132	6	localObject4	Object
    //   715	16	6	localException2	java.lang.Exception
    //   736	28	6	localObject5	Object
    //   107	637	7	localObject6	Object
    //   751	8	7	localException3	java.lang.Exception
    //   121	359	8	localObject7	Object
    //   535	1	8	localException4	java.lang.Exception
    //   540	1	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   553	47	8	localException5	java.lang.Exception
    //   634	47	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   728	7	8	localObject8	Object
    //   783	1	8	localObject9	Object
    //   7	775	9	localObject10	Object
    //   28	394	10	localResources	android.content.res.Resources
    //   237	85	11	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   128	133	134	java/lang/Exception
    //   113	123	535	java/lang/Exception
    //   151	157	535	java/lang/Exception
    //   161	167	535	java/lang/Exception
    //   171	189	535	java/lang/Exception
    //   193	204	535	java/lang/Exception
    //   208	216	535	java/lang/Exception
    //   220	226	535	java/lang/Exception
    //   230	239	535	java/lang/Exception
    //   243	251	535	java/lang/Exception
    //   255	263	535	java/lang/Exception
    //   267	275	535	java/lang/Exception
    //   279	287	535	java/lang/Exception
    //   291	299	535	java/lang/Exception
    //   303	314	535	java/lang/Exception
    //   318	329	535	java/lang/Exception
    //   336	349	535	java/lang/Exception
    //   353	358	535	java/lang/Exception
    //   362	368	535	java/lang/Exception
    //   372	380	535	java/lang/Exception
    //   392	398	535	java/lang/Exception
    //   402	415	535	java/lang/Exception
    //   419	429	535	java/lang/Exception
    //   433	440	535	java/lang/Exception
    //   444	471	535	java/lang/Exception
    //   475	484	535	java/lang/Exception
    //   488	498	535	java/lang/Exception
    //   502	512	535	java/lang/Exception
    //   516	529	535	java/lang/Exception
    //   113	123	540	java/lang/OutOfMemoryError
    //   151	157	540	java/lang/OutOfMemoryError
    //   161	167	540	java/lang/OutOfMemoryError
    //   171	189	540	java/lang/OutOfMemoryError
    //   193	204	540	java/lang/OutOfMemoryError
    //   208	216	540	java/lang/OutOfMemoryError
    //   220	226	540	java/lang/OutOfMemoryError
    //   230	239	540	java/lang/OutOfMemoryError
    //   243	251	540	java/lang/OutOfMemoryError
    //   255	263	540	java/lang/OutOfMemoryError
    //   267	275	540	java/lang/OutOfMemoryError
    //   279	287	540	java/lang/OutOfMemoryError
    //   291	299	540	java/lang/OutOfMemoryError
    //   303	314	540	java/lang/OutOfMemoryError
    //   318	329	540	java/lang/OutOfMemoryError
    //   336	349	540	java/lang/OutOfMemoryError
    //   353	358	540	java/lang/OutOfMemoryError
    //   362	368	540	java/lang/OutOfMemoryError
    //   372	380	540	java/lang/OutOfMemoryError
    //   392	398	540	java/lang/OutOfMemoryError
    //   402	415	540	java/lang/OutOfMemoryError
    //   419	429	540	java/lang/OutOfMemoryError
    //   433	440	540	java/lang/OutOfMemoryError
    //   444	471	540	java/lang/OutOfMemoryError
    //   475	484	540	java/lang/OutOfMemoryError
    //   488	498	540	java/lang/OutOfMemoryError
    //   502	512	540	java/lang/OutOfMemoryError
    //   516	529	540	java/lang/OutOfMemoryError
    //   0	109	545	finally
    //   0	109	553	java/lang/Exception
    //   0	109	634	java/lang/OutOfMemoryError
    //   529	534	715	java/lang/Exception
    //   628	633	715	java/lang/Exception
    //   709	714	715	java/lang/Exception
    //   113	123	728	finally
    //   151	157	728	finally
    //   161	167	728	finally
    //   171	189	728	finally
    //   193	204	728	finally
    //   208	216	728	finally
    //   220	226	728	finally
    //   230	239	728	finally
    //   243	251	728	finally
    //   255	263	728	finally
    //   267	275	728	finally
    //   279	287	728	finally
    //   291	299	728	finally
    //   303	314	728	finally
    //   318	329	728	finally
    //   336	349	728	finally
    //   353	358	728	finally
    //   362	368	728	finally
    //   372	380	728	finally
    //   392	398	728	finally
    //   402	415	728	finally
    //   419	429	728	finally
    //   433	440	728	finally
    //   444	471	728	finally
    //   475	484	728	finally
    //   488	498	728	finally
    //   502	512	728	finally
    //   516	529	728	finally
    //   562	568	728	finally
    //   572	581	728	finally
    //   585	593	728	finally
    //   597	608	728	finally
    //   612	623	728	finally
    //   643	649	728	finally
    //   653	662	728	finally
    //   666	674	728	finally
    //   678	689	728	finally
    //   693	704	728	finally
    //   743	748	751	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.7
 * JD-Core Version:    0.7.0.1
 */