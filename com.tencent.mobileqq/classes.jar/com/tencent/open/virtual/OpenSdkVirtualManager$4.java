package com.tencent.open.virtual;

import bdna;
import bdno;
import bdnx;

public class OpenSdkVirtualManager$4
  implements Runnable
{
  public OpenSdkVirtualManager$4(bdno parambdno, String paramString1, String paramString2, bdna parambdna, bdnx parambdnx) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 38	com/tencent/mobileqq/pic/CompressInfo
    //   3: dup
    //   4: aload_0
    //   5: getfield 19	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: iconst_0
    //   9: invokespecial 41	com/tencent/mobileqq/pic/CompressInfo:<init>	(Ljava/lang/String;I)V
    //   12: astore_2
    //   13: aload_2
    //   14: iconst_0
    //   15: putfield 45	com/tencent/mobileqq/pic/CompressInfo:f	I
    //   18: aload_2
    //   19: invokestatic 50	auoq:a	(Lcom/tencent/mobileqq/pic/CompressInfo;)Z
    //   22: pop
    //   23: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +41 -> 67
    //   29: ldc 58
    //   31: iconst_2
    //   32: iconst_5
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc 60
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_0
    //   44: getfield 21	com/tencent/open/virtual/OpenSdkVirtualManager$4:b	Ljava/lang/String;
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: ldc 62
    //   52: aastore
    //   53: dup
    //   54: iconst_3
    //   55: aload_0
    //   56: getfield 19	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   59: aastore
    //   60: dup
    //   61: iconst_4
    //   62: aload_2
    //   63: aastore
    //   64: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   67: aload_2
    //   68: getfield 69	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   71: invokestatic 74	bbjw:a	(Ljava/lang/String;)Z
    //   74: ifne +558 -> 632
    //   77: new 76	java/io/File
    //   80: dup
    //   81: aload_2
    //   82: getfield 69	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   85: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokevirtual 82	java/io/File:exists	()Z
    //   91: ifeq +533 -> 624
    //   94: new 84	org/json/JSONObject
    //   97: dup
    //   98: invokespecial 85	org/json/JSONObject:<init>	()V
    //   101: astore 4
    //   103: new 87	java/io/FileInputStream
    //   106: dup
    //   107: aload_2
    //   108: getfield 69	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   111: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   114: astore_3
    //   115: aload_3
    //   116: astore_2
    //   117: aload_3
    //   118: invokevirtual 92	java/io/FileInputStream:available	()I
    //   121: istore_1
    //   122: aload_3
    //   123: astore_2
    //   124: iload_1
    //   125: newarray byte
    //   127: astore 5
    //   129: aload_3
    //   130: astore_2
    //   131: aload_3
    //   132: aload 5
    //   134: invokevirtual 96	java/io/FileInputStream:read	([B)I
    //   137: pop
    //   138: aload_3
    //   139: astore_2
    //   140: aload 5
    //   142: iconst_2
    //   143: invokestatic 102	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   146: astore 6
    //   148: aload_3
    //   149: astore_2
    //   150: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +43 -> 196
    //   156: aload_3
    //   157: astore_2
    //   158: ldc 58
    //   160: iconst_2
    //   161: iconst_4
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: ldc 104
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: iload_1
    //   173: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: aastore
    //   177: dup
    //   178: iconst_2
    //   179: ldc 112
    //   181: aastore
    //   182: dup
    //   183: iconst_3
    //   184: aload 6
    //   186: invokevirtual 117	java/lang/String:length	()I
    //   189: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   196: aload_3
    //   197: astore_2
    //   198: new 84	org/json/JSONObject
    //   201: dup
    //   202: invokespecial 85	org/json/JSONObject:<init>	()V
    //   205: astore 5
    //   207: aload_3
    //   208: astore_2
    //   209: aload 5
    //   211: ldc 119
    //   213: iconst_4
    //   214: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload_3
    //   219: astore_2
    //   220: aload 5
    //   222: ldc 125
    //   224: iconst_3
    //   225: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload_3
    //   230: astore_2
    //   231: aload 5
    //   233: ldc 127
    //   235: iload_1
    //   236: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   239: pop
    //   240: aload_3
    //   241: astore_2
    //   242: aload 5
    //   244: ldc 129
    //   246: aload 6
    //   248: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   251: pop
    //   252: aload_3
    //   253: astore_2
    //   254: new 84	org/json/JSONObject
    //   257: dup
    //   258: invokespecial 85	org/json/JSONObject:<init>	()V
    //   261: astore 6
    //   263: aload_3
    //   264: astore_2
    //   265: aload 6
    //   267: ldc 134
    //   269: iconst_0
    //   270: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   273: pop
    //   274: aload_3
    //   275: astore_2
    //   276: new 136	org/json/JSONArray
    //   279: dup
    //   280: invokespecial 137	org/json/JSONArray:<init>	()V
    //   283: astore 7
    //   285: aload_3
    //   286: astore_2
    //   287: aload 7
    //   289: aload 5
    //   291: invokevirtual 140	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   294: pop
    //   295: aload_3
    //   296: astore_2
    //   297: aload 6
    //   299: ldc 142
    //   301: aload 7
    //   303: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   306: pop
    //   307: aload_3
    //   308: astore_2
    //   309: aload 4
    //   311: ldc 144
    //   313: aload_0
    //   314: getfield 23	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_Bdna	Lbdna;
    //   317: getfield 147	bdna:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   320: invokestatic 153	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   323: invokevirtual 156	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   326: pop
    //   327: aload_3
    //   328: astore_2
    //   329: aload 4
    //   331: ldc 158
    //   333: iconst_1
    //   334: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   337: pop
    //   338: aload_3
    //   339: astore_2
    //   340: aload 4
    //   342: ldc 160
    //   344: iconst_1
    //   345: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   348: pop
    //   349: aload_3
    //   350: astore_2
    //   351: aload 4
    //   353: ldc 162
    //   355: iconst_1
    //   356: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   359: pop
    //   360: aload_3
    //   361: astore_2
    //   362: aload 4
    //   364: ldc 164
    //   366: aload 6
    //   368: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   371: pop
    //   372: aload_3
    //   373: astore_2
    //   374: aload_0
    //   375: getfield 17	com/tencent/open/virtual/OpenSdkVirtualManager$4:this$0	Lbdno;
    //   378: iconst_0
    //   379: invokestatic 169	bdno:a	(Lbdno;I)I
    //   382: pop
    //   383: aload_3
    //   384: astore_2
    //   385: aload_0
    //   386: getfield 17	com/tencent/open/virtual/OpenSdkVirtualManager$4:this$0	Lbdno;
    //   389: aload_0
    //   390: getfield 23	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_Bdna	Lbdna;
    //   393: aload_0
    //   394: getfield 19	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   397: aload 4
    //   399: aload_0
    //   400: getfield 25	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_Bdnx	Lbdnx;
    //   403: invokestatic 172	bdno:a	(Lbdno;Lbdna;Ljava/lang/String;Lorg/json/JSONObject;Lbdnx;)V
    //   406: aload_3
    //   407: ifnull +7 -> 414
    //   410: aload_3
    //   411: invokevirtual 175	java/io/FileInputStream:close	()V
    //   414: iconst_1
    //   415: istore_1
    //   416: iload_1
    //   417: ifne +33 -> 450
    //   420: ldc 58
    //   422: iconst_1
    //   423: ldc 177
    //   425: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload_0
    //   429: getfield 25	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_Bdnx	Lbdnx;
    //   432: ifnull +18 -> 450
    //   435: aload_0
    //   436: getfield 25	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_Bdnx	Lbdnx;
    //   439: iconst_0
    //   440: aload_0
    //   441: getfield 19	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   444: aconst_null
    //   445: bipush 254
    //   447: invokevirtual 185	bdnx:a	(ZLjava/lang/String;Ljava/lang/String;I)V
    //   450: return
    //   451: astore_2
    //   452: ldc 58
    //   454: iconst_1
    //   455: ldc 187
    //   457: aload_2
    //   458: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   461: iconst_1
    //   462: istore_1
    //   463: goto -47 -> 416
    //   466: astore 4
    //   468: aconst_null
    //   469: astore_3
    //   470: aload_3
    //   471: astore_2
    //   472: ldc 58
    //   474: iconst_1
    //   475: ldc 187
    //   477: aload 4
    //   479: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   482: aload_3
    //   483: ifnull +7 -> 490
    //   486: aload_3
    //   487: invokevirtual 175	java/io/FileInputStream:close	()V
    //   490: iconst_0
    //   491: istore_1
    //   492: goto -76 -> 416
    //   495: astore_2
    //   496: ldc 58
    //   498: iconst_1
    //   499: ldc 187
    //   501: aload_2
    //   502: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   505: iconst_0
    //   506: istore_1
    //   507: goto -91 -> 416
    //   510: astore 4
    //   512: aconst_null
    //   513: astore_3
    //   514: aload_3
    //   515: astore_2
    //   516: ldc 58
    //   518: iconst_1
    //   519: ldc 187
    //   521: aload 4
    //   523: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   526: aload_3
    //   527: ifnull +7 -> 534
    //   530: aload_3
    //   531: invokevirtual 175	java/io/FileInputStream:close	()V
    //   534: iconst_0
    //   535: istore_1
    //   536: goto -120 -> 416
    //   539: astore_2
    //   540: ldc 58
    //   542: iconst_1
    //   543: ldc 187
    //   545: aload_2
    //   546: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   549: iconst_0
    //   550: istore_1
    //   551: goto -135 -> 416
    //   554: astore 4
    //   556: aconst_null
    //   557: astore_3
    //   558: aload_3
    //   559: astore_2
    //   560: ldc 58
    //   562: iconst_1
    //   563: ldc 187
    //   565: aload 4
    //   567: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   570: aload_3
    //   571: ifnull +7 -> 578
    //   574: aload_3
    //   575: invokevirtual 175	java/io/FileInputStream:close	()V
    //   578: iconst_0
    //   579: istore_1
    //   580: goto -164 -> 416
    //   583: astore_2
    //   584: ldc 58
    //   586: iconst_1
    //   587: ldc 187
    //   589: aload_2
    //   590: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   593: iconst_0
    //   594: istore_1
    //   595: goto -179 -> 416
    //   598: astore_3
    //   599: aconst_null
    //   600: astore_2
    //   601: aload_2
    //   602: ifnull +7 -> 609
    //   605: aload_2
    //   606: invokevirtual 175	java/io/FileInputStream:close	()V
    //   609: aload_3
    //   610: athrow
    //   611: astore_2
    //   612: ldc 58
    //   614: iconst_1
    //   615: ldc 187
    //   617: aload_2
    //   618: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   621: goto -12 -> 609
    //   624: ldc 58
    //   626: iconst_1
    //   627: ldc 192
    //   629: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: iconst_0
    //   633: istore_1
    //   634: goto -218 -> 416
    //   637: astore_3
    //   638: goto -37 -> 601
    //   641: astore 4
    //   643: goto -85 -> 558
    //   646: astore 4
    //   648: goto -134 -> 514
    //   651: astore 4
    //   653: goto -183 -> 470
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	656	0	this	4
    //   121	513	1	i	int
    //   12	373	2	localObject1	Object
    //   451	7	2	localIOException1	java.io.IOException
    //   471	1	2	localObject2	Object
    //   495	7	2	localIOException2	java.io.IOException
    //   515	1	2	localObject3	Object
    //   539	7	2	localIOException3	java.io.IOException
    //   559	1	2	localObject4	Object
    //   583	7	2	localIOException4	java.io.IOException
    //   600	6	2	localObject5	Object
    //   611	7	2	localIOException5	java.io.IOException
    //   114	461	3	localFileInputStream	java.io.FileInputStream
    //   598	12	3	localObject6	Object
    //   637	1	3	localObject7	Object
    //   101	297	4	localJSONObject	org.json.JSONObject
    //   466	12	4	localJSONException1	org.json.JSONException
    //   510	12	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   554	12	4	localIOException6	java.io.IOException
    //   641	1	4	localIOException7	java.io.IOException
    //   646	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   651	1	4	localJSONException2	org.json.JSONException
    //   127	163	5	localObject8	Object
    //   146	221	6	localObject9	Object
    //   283	19	7	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   410	414	451	java/io/IOException
    //   103	115	466	org/json/JSONException
    //   486	490	495	java/io/IOException
    //   103	115	510	java/io/FileNotFoundException
    //   530	534	539	java/io/IOException
    //   103	115	554	java/io/IOException
    //   574	578	583	java/io/IOException
    //   103	115	598	finally
    //   605	609	611	java/io/IOException
    //   117	122	637	finally
    //   124	129	637	finally
    //   131	138	637	finally
    //   140	148	637	finally
    //   150	156	637	finally
    //   158	196	637	finally
    //   198	207	637	finally
    //   209	218	637	finally
    //   220	229	637	finally
    //   231	240	637	finally
    //   242	252	637	finally
    //   254	263	637	finally
    //   265	274	637	finally
    //   276	285	637	finally
    //   287	295	637	finally
    //   297	307	637	finally
    //   309	327	637	finally
    //   329	338	637	finally
    //   340	349	637	finally
    //   351	360	637	finally
    //   362	372	637	finally
    //   374	383	637	finally
    //   385	406	637	finally
    //   472	482	637	finally
    //   516	526	637	finally
    //   560	570	637	finally
    //   117	122	641	java/io/IOException
    //   124	129	641	java/io/IOException
    //   131	138	641	java/io/IOException
    //   140	148	641	java/io/IOException
    //   150	156	641	java/io/IOException
    //   158	196	641	java/io/IOException
    //   198	207	641	java/io/IOException
    //   209	218	641	java/io/IOException
    //   220	229	641	java/io/IOException
    //   231	240	641	java/io/IOException
    //   242	252	641	java/io/IOException
    //   254	263	641	java/io/IOException
    //   265	274	641	java/io/IOException
    //   276	285	641	java/io/IOException
    //   287	295	641	java/io/IOException
    //   297	307	641	java/io/IOException
    //   309	327	641	java/io/IOException
    //   329	338	641	java/io/IOException
    //   340	349	641	java/io/IOException
    //   351	360	641	java/io/IOException
    //   362	372	641	java/io/IOException
    //   374	383	641	java/io/IOException
    //   385	406	641	java/io/IOException
    //   117	122	646	java/io/FileNotFoundException
    //   124	129	646	java/io/FileNotFoundException
    //   131	138	646	java/io/FileNotFoundException
    //   140	148	646	java/io/FileNotFoundException
    //   150	156	646	java/io/FileNotFoundException
    //   158	196	646	java/io/FileNotFoundException
    //   198	207	646	java/io/FileNotFoundException
    //   209	218	646	java/io/FileNotFoundException
    //   220	229	646	java/io/FileNotFoundException
    //   231	240	646	java/io/FileNotFoundException
    //   242	252	646	java/io/FileNotFoundException
    //   254	263	646	java/io/FileNotFoundException
    //   265	274	646	java/io/FileNotFoundException
    //   276	285	646	java/io/FileNotFoundException
    //   287	295	646	java/io/FileNotFoundException
    //   297	307	646	java/io/FileNotFoundException
    //   309	327	646	java/io/FileNotFoundException
    //   329	338	646	java/io/FileNotFoundException
    //   340	349	646	java/io/FileNotFoundException
    //   351	360	646	java/io/FileNotFoundException
    //   362	372	646	java/io/FileNotFoundException
    //   374	383	646	java/io/FileNotFoundException
    //   385	406	646	java/io/FileNotFoundException
    //   117	122	651	org/json/JSONException
    //   124	129	651	org/json/JSONException
    //   131	138	651	org/json/JSONException
    //   140	148	651	org/json/JSONException
    //   150	156	651	org/json/JSONException
    //   158	196	651	org/json/JSONException
    //   198	207	651	org/json/JSONException
    //   209	218	651	org/json/JSONException
    //   220	229	651	org/json/JSONException
    //   231	240	651	org/json/JSONException
    //   242	252	651	org/json/JSONException
    //   254	263	651	org/json/JSONException
    //   265	274	651	org/json/JSONException
    //   276	285	651	org/json/JSONException
    //   287	295	651	org/json/JSONException
    //   297	307	651	org/json/JSONException
    //   309	327	651	org/json/JSONException
    //   329	338	651	org/json/JSONException
    //   340	349	651	org/json/JSONException
    //   351	360	651	org/json/JSONException
    //   362	372	651	org/json/JSONException
    //   374	383	651	org/json/JSONException
    //   385	406	651	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualManager.4
 * JD-Core Version:    0.7.0.1
 */