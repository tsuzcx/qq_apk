package com.tencent.open.virtual;

import bior;
import biyc;
import biyp;

public class OpenSdkVirtualManager$4
  implements Runnable
{
  public OpenSdkVirtualManager$4(biyp parambiyp, String paramString1, String paramString2, biyc parambiyc, bior parambior) {}
  
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
    //   19: invokestatic 50	ayyz:a	(Lcom/tencent/mobileqq/pic/CompressInfo;)Z
    //   22: pop
    //   23: ldc 52
    //   25: iconst_1
    //   26: iconst_5
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: ldc 54
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload_0
    //   38: getfield 21	com/tencent/open/virtual/OpenSdkVirtualManager$4:b	Ljava/lang/String;
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: ldc 56
    //   46: aastore
    //   47: dup
    //   48: iconst_3
    //   49: aload_0
    //   50: getfield 19	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: aastore
    //   54: dup
    //   55: iconst_4
    //   56: aload_2
    //   57: aastore
    //   58: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   61: aload_2
    //   62: getfield 65	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   65: invokestatic 70	bgsp:a	(Ljava/lang/String;)Z
    //   68: ifne +550 -> 618
    //   71: new 72	java/io/File
    //   74: dup
    //   75: aload_2
    //   76: getfield 65	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   79: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: invokevirtual 79	java/io/File:exists	()Z
    //   85: ifeq +525 -> 610
    //   88: new 81	org/json/JSONObject
    //   91: dup
    //   92: invokespecial 82	org/json/JSONObject:<init>	()V
    //   95: astore 4
    //   97: new 84	java/io/FileInputStream
    //   100: dup
    //   101: aload_2
    //   102: getfield 65	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   105: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   108: astore_3
    //   109: aload_3
    //   110: astore_2
    //   111: aload_3
    //   112: invokevirtual 89	java/io/FileInputStream:available	()I
    //   115: istore_1
    //   116: aload_3
    //   117: astore_2
    //   118: iload_1
    //   119: newarray byte
    //   121: astore 5
    //   123: aload_3
    //   124: astore_2
    //   125: aload_3
    //   126: aload 5
    //   128: invokevirtual 93	java/io/FileInputStream:read	([B)I
    //   131: pop
    //   132: aload_3
    //   133: astore_2
    //   134: aload 5
    //   136: iconst_2
    //   137: invokestatic 99	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   140: astore 6
    //   142: aload_3
    //   143: astore_2
    //   144: ldc 52
    //   146: iconst_1
    //   147: iconst_4
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: ldc 101
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: iload_1
    //   159: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_2
    //   165: ldc 109
    //   167: aastore
    //   168: dup
    //   169: iconst_3
    //   170: aload 6
    //   172: invokevirtual 114	java/lang/String:length	()I
    //   175: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   178: aastore
    //   179: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   182: aload_3
    //   183: astore_2
    //   184: new 81	org/json/JSONObject
    //   187: dup
    //   188: invokespecial 82	org/json/JSONObject:<init>	()V
    //   191: astore 5
    //   193: aload_3
    //   194: astore_2
    //   195: aload 5
    //   197: ldc 116
    //   199: iconst_4
    //   200: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   203: pop
    //   204: aload_3
    //   205: astore_2
    //   206: aload 5
    //   208: ldc 122
    //   210: iconst_3
    //   211: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   214: pop
    //   215: aload_3
    //   216: astore_2
    //   217: aload 5
    //   219: ldc 124
    //   221: iload_1
    //   222: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   225: pop
    //   226: aload_3
    //   227: astore_2
    //   228: aload 5
    //   230: ldc 126
    //   232: aload 6
    //   234: invokevirtual 129	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   237: pop
    //   238: aload_3
    //   239: astore_2
    //   240: new 81	org/json/JSONObject
    //   243: dup
    //   244: invokespecial 82	org/json/JSONObject:<init>	()V
    //   247: astore 6
    //   249: aload_3
    //   250: astore_2
    //   251: aload 6
    //   253: ldc 131
    //   255: iconst_0
    //   256: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   259: pop
    //   260: aload_3
    //   261: astore_2
    //   262: new 133	org/json/JSONArray
    //   265: dup
    //   266: invokespecial 134	org/json/JSONArray:<init>	()V
    //   269: astore 7
    //   271: aload_3
    //   272: astore_2
    //   273: aload 7
    //   275: aload 5
    //   277: invokevirtual 137	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   280: pop
    //   281: aload_3
    //   282: astore_2
    //   283: aload 6
    //   285: ldc 139
    //   287: aload 7
    //   289: invokevirtual 129	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload_3
    //   294: astore_2
    //   295: aload 4
    //   297: ldc 141
    //   299: aload_0
    //   300: getfield 23	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_Biyc	Lbiyc;
    //   303: getfield 144	biyc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   306: invokestatic 150	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   309: invokevirtual 153	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload_3
    //   314: astore_2
    //   315: aload 4
    //   317: ldc 155
    //   319: iconst_1
    //   320: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   323: pop
    //   324: aload_3
    //   325: astore_2
    //   326: aload 4
    //   328: ldc 157
    //   330: iconst_1
    //   331: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   334: pop
    //   335: aload_3
    //   336: astore_2
    //   337: aload 4
    //   339: ldc 159
    //   341: iconst_1
    //   342: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   345: pop
    //   346: aload_3
    //   347: astore_2
    //   348: aload 4
    //   350: ldc 161
    //   352: aload 6
    //   354: invokevirtual 129	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   357: pop
    //   358: aload_3
    //   359: astore_2
    //   360: aload_0
    //   361: getfield 17	com/tencent/open/virtual/OpenSdkVirtualManager$4:this$0	Lbiyp;
    //   364: iconst_0
    //   365: invokestatic 166	biyp:a	(Lbiyp;I)I
    //   368: pop
    //   369: aload_3
    //   370: astore_2
    //   371: aload_0
    //   372: getfield 17	com/tencent/open/virtual/OpenSdkVirtualManager$4:this$0	Lbiyp;
    //   375: aload_0
    //   376: getfield 23	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_Biyc	Lbiyc;
    //   379: aload_0
    //   380: getfield 19	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   383: aload 4
    //   385: aload_0
    //   386: getfield 25	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_Bior	Lbior;
    //   389: invokestatic 169	biyp:a	(Lbiyp;Lbiyc;Ljava/lang/String;Lorg/json/JSONObject;Lbior;)V
    //   392: aload_3
    //   393: ifnull +7 -> 400
    //   396: aload_3
    //   397: invokevirtual 172	java/io/FileInputStream:close	()V
    //   400: iconst_1
    //   401: istore_1
    //   402: iload_1
    //   403: ifne +33 -> 436
    //   406: ldc 52
    //   408: iconst_1
    //   409: ldc 174
    //   411: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   414: aload_0
    //   415: getfield 25	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_Bior	Lbior;
    //   418: ifnull +18 -> 436
    //   421: aload_0
    //   422: getfield 25	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_Bior	Lbior;
    //   425: iconst_0
    //   426: aload_0
    //   427: getfield 19	com/tencent/open/virtual/OpenSdkVirtualManager$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   430: aconst_null
    //   431: bipush 254
    //   433: invokevirtual 182	bior:a	(ZLjava/lang/String;Ljava/lang/String;I)V
    //   436: return
    //   437: astore_2
    //   438: ldc 52
    //   440: iconst_1
    //   441: ldc 184
    //   443: aload_2
    //   444: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   447: iconst_1
    //   448: istore_1
    //   449: goto -47 -> 402
    //   452: astore 4
    //   454: aconst_null
    //   455: astore_3
    //   456: aload_3
    //   457: astore_2
    //   458: ldc 52
    //   460: iconst_1
    //   461: ldc 184
    //   463: aload 4
    //   465: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   468: aload_3
    //   469: ifnull +7 -> 476
    //   472: aload_3
    //   473: invokevirtual 172	java/io/FileInputStream:close	()V
    //   476: iconst_0
    //   477: istore_1
    //   478: goto -76 -> 402
    //   481: astore_2
    //   482: ldc 52
    //   484: iconst_1
    //   485: ldc 184
    //   487: aload_2
    //   488: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   491: iconst_0
    //   492: istore_1
    //   493: goto -91 -> 402
    //   496: astore 4
    //   498: aconst_null
    //   499: astore_3
    //   500: aload_3
    //   501: astore_2
    //   502: ldc 52
    //   504: iconst_1
    //   505: ldc 184
    //   507: aload 4
    //   509: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   512: aload_3
    //   513: ifnull +7 -> 520
    //   516: aload_3
    //   517: invokevirtual 172	java/io/FileInputStream:close	()V
    //   520: iconst_0
    //   521: istore_1
    //   522: goto -120 -> 402
    //   525: astore_2
    //   526: ldc 52
    //   528: iconst_1
    //   529: ldc 184
    //   531: aload_2
    //   532: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   535: iconst_0
    //   536: istore_1
    //   537: goto -135 -> 402
    //   540: astore 4
    //   542: aconst_null
    //   543: astore_3
    //   544: aload_3
    //   545: astore_2
    //   546: ldc 52
    //   548: iconst_1
    //   549: ldc 184
    //   551: aload 4
    //   553: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   556: aload_3
    //   557: ifnull +7 -> 564
    //   560: aload_3
    //   561: invokevirtual 172	java/io/FileInputStream:close	()V
    //   564: iconst_0
    //   565: istore_1
    //   566: goto -164 -> 402
    //   569: astore_2
    //   570: ldc 52
    //   572: iconst_1
    //   573: ldc 184
    //   575: aload_2
    //   576: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   579: iconst_0
    //   580: istore_1
    //   581: goto -179 -> 402
    //   584: astore_3
    //   585: aconst_null
    //   586: astore_2
    //   587: aload_2
    //   588: ifnull +7 -> 595
    //   591: aload_2
    //   592: invokevirtual 172	java/io/FileInputStream:close	()V
    //   595: aload_3
    //   596: athrow
    //   597: astore_2
    //   598: ldc 52
    //   600: iconst_1
    //   601: ldc 184
    //   603: aload_2
    //   604: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   607: goto -12 -> 595
    //   610: ldc 52
    //   612: iconst_1
    //   613: ldc 189
    //   615: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: iconst_0
    //   619: istore_1
    //   620: goto -218 -> 402
    //   623: astore_3
    //   624: goto -37 -> 587
    //   627: astore 4
    //   629: goto -85 -> 544
    //   632: astore 4
    //   634: goto -134 -> 500
    //   637: astore 4
    //   639: goto -183 -> 456
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	this	4
    //   115	505	1	i	int
    //   12	359	2	localObject1	Object
    //   437	7	2	localIOException1	java.io.IOException
    //   457	1	2	localObject2	Object
    //   481	7	2	localIOException2	java.io.IOException
    //   501	1	2	localObject3	Object
    //   525	7	2	localIOException3	java.io.IOException
    //   545	1	2	localObject4	Object
    //   569	7	2	localIOException4	java.io.IOException
    //   586	6	2	localObject5	Object
    //   597	7	2	localIOException5	java.io.IOException
    //   108	453	3	localFileInputStream	java.io.FileInputStream
    //   584	12	3	localObject6	Object
    //   623	1	3	localObject7	Object
    //   95	289	4	localJSONObject	org.json.JSONObject
    //   452	12	4	localJSONException1	org.json.JSONException
    //   496	12	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   540	12	4	localIOException6	java.io.IOException
    //   627	1	4	localIOException7	java.io.IOException
    //   632	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   637	1	4	localJSONException2	org.json.JSONException
    //   121	155	5	localObject8	Object
    //   140	213	6	localObject9	Object
    //   269	19	7	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   396	400	437	java/io/IOException
    //   97	109	452	org/json/JSONException
    //   472	476	481	java/io/IOException
    //   97	109	496	java/io/FileNotFoundException
    //   516	520	525	java/io/IOException
    //   97	109	540	java/io/IOException
    //   560	564	569	java/io/IOException
    //   97	109	584	finally
    //   591	595	597	java/io/IOException
    //   111	116	623	finally
    //   118	123	623	finally
    //   125	132	623	finally
    //   134	142	623	finally
    //   144	182	623	finally
    //   184	193	623	finally
    //   195	204	623	finally
    //   206	215	623	finally
    //   217	226	623	finally
    //   228	238	623	finally
    //   240	249	623	finally
    //   251	260	623	finally
    //   262	271	623	finally
    //   273	281	623	finally
    //   283	293	623	finally
    //   295	313	623	finally
    //   315	324	623	finally
    //   326	335	623	finally
    //   337	346	623	finally
    //   348	358	623	finally
    //   360	369	623	finally
    //   371	392	623	finally
    //   458	468	623	finally
    //   502	512	623	finally
    //   546	556	623	finally
    //   111	116	627	java/io/IOException
    //   118	123	627	java/io/IOException
    //   125	132	627	java/io/IOException
    //   134	142	627	java/io/IOException
    //   144	182	627	java/io/IOException
    //   184	193	627	java/io/IOException
    //   195	204	627	java/io/IOException
    //   206	215	627	java/io/IOException
    //   217	226	627	java/io/IOException
    //   228	238	627	java/io/IOException
    //   240	249	627	java/io/IOException
    //   251	260	627	java/io/IOException
    //   262	271	627	java/io/IOException
    //   273	281	627	java/io/IOException
    //   283	293	627	java/io/IOException
    //   295	313	627	java/io/IOException
    //   315	324	627	java/io/IOException
    //   326	335	627	java/io/IOException
    //   337	346	627	java/io/IOException
    //   348	358	627	java/io/IOException
    //   360	369	627	java/io/IOException
    //   371	392	627	java/io/IOException
    //   111	116	632	java/io/FileNotFoundException
    //   118	123	632	java/io/FileNotFoundException
    //   125	132	632	java/io/FileNotFoundException
    //   134	142	632	java/io/FileNotFoundException
    //   144	182	632	java/io/FileNotFoundException
    //   184	193	632	java/io/FileNotFoundException
    //   195	204	632	java/io/FileNotFoundException
    //   206	215	632	java/io/FileNotFoundException
    //   217	226	632	java/io/FileNotFoundException
    //   228	238	632	java/io/FileNotFoundException
    //   240	249	632	java/io/FileNotFoundException
    //   251	260	632	java/io/FileNotFoundException
    //   262	271	632	java/io/FileNotFoundException
    //   273	281	632	java/io/FileNotFoundException
    //   283	293	632	java/io/FileNotFoundException
    //   295	313	632	java/io/FileNotFoundException
    //   315	324	632	java/io/FileNotFoundException
    //   326	335	632	java/io/FileNotFoundException
    //   337	346	632	java/io/FileNotFoundException
    //   348	358	632	java/io/FileNotFoundException
    //   360	369	632	java/io/FileNotFoundException
    //   371	392	632	java/io/FileNotFoundException
    //   111	116	637	org/json/JSONException
    //   118	123	637	org/json/JSONException
    //   125	132	637	org/json/JSONException
    //   134	142	637	org/json/JSONException
    //   144	182	637	org/json/JSONException
    //   184	193	637	org/json/JSONException
    //   195	204	637	org/json/JSONException
    //   206	215	637	org/json/JSONException
    //   217	226	637	org/json/JSONException
    //   228	238	637	org/json/JSONException
    //   240	249	637	org/json/JSONException
    //   251	260	637	org/json/JSONException
    //   262	271	637	org/json/JSONException
    //   273	281	637	org/json/JSONException
    //   283	293	637	org/json/JSONException
    //   295	313	637	org/json/JSONException
    //   315	324	637	org/json/JSONException
    //   326	335	637	org/json/JSONException
    //   337	346	637	org/json/JSONException
    //   348	358	637	org/json/JSONException
    //   360	369	637	org/json/JSONException
    //   371	392	637	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualManager.4
 * JD-Core Version:    0.7.0.1
 */