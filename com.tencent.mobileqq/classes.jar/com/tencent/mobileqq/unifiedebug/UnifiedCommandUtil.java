package com.tencent.mobileqq.unifiedebug;

public class UnifiedCommandUtil
{
  public static UnifiedCommandUtil.ExecResult a(String paramString)
  {
    return a(new String[] { paramString });
  }
  
  /* Error */
  public static UnifiedCommandUtil.ExecResult a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 22	com/tencent/mobileqq/unifiedebug/UnifiedCommandUtil$ExecResult
    //   3: dup
    //   4: invokespecial 23	com/tencent/mobileqq/unifiedebug/UnifiedCommandUtil$ExecResult:<init>	()V
    //   7: astore 13
    //   9: iconst_0
    //   10: istore_3
    //   11: aload_0
    //   12: ifnull +940 -> 952
    //   15: aload_0
    //   16: arraylength
    //   17: ifne +6 -> 23
    //   20: goto +932 -> 952
    //   23: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +38 -> 64
    //   29: new 31	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   36: astore 4
    //   38: aload 4
    //   40: ldc 34
    //   42: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 4
    //   48: aload_0
    //   49: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 43
    //   55: iconst_2
    //   56: aload 4
    //   58: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: new 53	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 54	java/util/ArrayList:<init>	()V
    //   71: astore 14
    //   73: aconst_null
    //   74: astore 10
    //   76: aconst_null
    //   77: astore 8
    //   79: aconst_null
    //   80: astore 9
    //   82: invokestatic 60	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   85: ldc 62
    //   87: invokevirtual 66	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   90: astore 5
    //   92: new 68	java/io/DataOutputStream
    //   95: dup
    //   96: aload 5
    //   98: invokevirtual 74	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   101: invokespecial 77	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: astore 4
    //   106: aload_0
    //   107: arraylength
    //   108: istore_2
    //   109: iconst_0
    //   110: istore_1
    //   111: goto +850 -> 961
    //   114: aload 4
    //   116: aload 6
    //   118: invokevirtual 81	java/lang/String:getBytes	()[B
    //   121: invokevirtual 85	java/io/DataOutputStream:write	([B)V
    //   124: aload 4
    //   126: ldc 87
    //   128: invokevirtual 91	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   131: aload 4
    //   133: invokevirtual 94	java/io/DataOutputStream:flush	()V
    //   136: goto +840 -> 976
    //   139: aload 4
    //   141: ldc 96
    //   143: invokevirtual 91	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   146: aload 4
    //   148: invokevirtual 94	java/io/DataOutputStream:flush	()V
    //   151: aload 5
    //   153: invokevirtual 100	java/lang/Process:waitFor	()I
    //   156: istore_1
    //   157: new 31	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   164: astore_0
    //   165: new 102	java/io/BufferedReader
    //   168: dup
    //   169: new 104	java/io/InputStreamReader
    //   172: dup
    //   173: aload 5
    //   175: invokevirtual 108	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   178: invokespecial 111	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   181: invokespecial 114	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   184: astore 6
    //   186: new 102	java/io/BufferedReader
    //   189: dup
    //   190: new 104	java/io/InputStreamReader
    //   193: dup
    //   194: aload 5
    //   196: invokevirtual 117	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   199: invokespecial 111	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   202: invokespecial 114	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   205: astore 7
    //   207: aload 6
    //   209: invokevirtual 120	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   212: astore 8
    //   214: aload 8
    //   216: ifnull +58 -> 274
    //   219: aload 14
    //   221: aload 8
    //   223: invokeinterface 126 2 0
    //   228: pop
    //   229: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq -25 -> 207
    //   235: new 31	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   242: astore 9
    //   244: aload 9
    //   246: ldc 128
    //   248: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 9
    //   254: aload 8
    //   256: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: ldc 43
    //   262: iconst_2
    //   263: aload 9
    //   265: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: goto -64 -> 207
    //   274: aload 7
    //   276: invokevirtual 120	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   279: astore 8
    //   281: aload 8
    //   283: ifnull +13 -> 296
    //   286: aload_0
    //   287: aload 8
    //   289: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: goto -19 -> 274
    //   296: aload 4
    //   298: invokevirtual 131	java/io/DataOutputStream:close	()V
    //   301: aload 6
    //   303: invokevirtual 132	java/io/BufferedReader:close	()V
    //   306: aload 7
    //   308: invokevirtual 132	java/io/BufferedReader:close	()V
    //   311: goto +10 -> 321
    //   314: astore 4
    //   316: aload 4
    //   318: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   321: aload 5
    //   323: ifnull +8 -> 331
    //   326: aload 5
    //   328: invokevirtual 138	java/lang/Process:destroy	()V
    //   331: aload_0
    //   332: astore 4
    //   334: iload_1
    //   335: istore_2
    //   336: goto +454 -> 790
    //   339: astore 9
    //   341: aload 4
    //   343: astore 8
    //   345: aload 7
    //   347: astore_0
    //   348: aload 9
    //   350: astore 4
    //   352: goto +528 -> 880
    //   355: astore 8
    //   357: aload 7
    //   359: astore 9
    //   361: goto +32 -> 393
    //   364: astore 8
    //   366: aload 7
    //   368: astore 9
    //   370: goto +43 -> 413
    //   373: astore 7
    //   375: aconst_null
    //   376: astore_0
    //   377: aload 4
    //   379: astore 8
    //   381: aload 7
    //   383: astore 4
    //   385: goto +495 -> 880
    //   388: astore 8
    //   390: aconst_null
    //   391: astore 9
    //   393: aload 5
    //   395: astore 7
    //   397: aload 6
    //   399: astore 5
    //   401: aload 9
    //   403: astore 6
    //   405: goto +202 -> 607
    //   408: astore 8
    //   410: aconst_null
    //   411: astore 9
    //   413: aload 5
    //   415: astore 7
    //   417: aload 6
    //   419: astore 5
    //   421: aload 9
    //   423: astore 6
    //   425: goto +290 -> 715
    //   428: astore 8
    //   430: aconst_null
    //   431: astore 6
    //   433: aload 6
    //   435: astore 9
    //   437: aload 5
    //   439: astore 7
    //   441: aload 9
    //   443: astore 5
    //   445: goto +162 -> 607
    //   448: astore 8
    //   450: aconst_null
    //   451: astore 6
    //   453: aload 6
    //   455: astore 9
    //   457: aload 5
    //   459: astore 7
    //   461: aload 9
    //   463: astore 5
    //   465: goto +250 -> 715
    //   468: astore 9
    //   470: aconst_null
    //   471: astore 8
    //   473: aload 8
    //   475: astore 6
    //   477: aload 6
    //   479: astore_0
    //   480: aload 5
    //   482: astore 7
    //   484: aload 8
    //   486: astore 5
    //   488: aload 9
    //   490: astore 8
    //   492: goto +115 -> 607
    //   495: astore 9
    //   497: aconst_null
    //   498: astore 8
    //   500: aload 8
    //   502: astore 6
    //   504: aload 6
    //   506: astore_0
    //   507: aload 5
    //   509: astore 7
    //   511: aload 8
    //   513: astore 5
    //   515: aload 9
    //   517: astore 8
    //   519: goto +196 -> 715
    //   522: astore 7
    //   524: aconst_null
    //   525: astore 6
    //   527: goto +372 -> 899
    //   530: astore 8
    //   532: aconst_null
    //   533: astore 6
    //   535: aload 5
    //   537: astore 7
    //   539: goto +61 -> 600
    //   542: astore 8
    //   544: aconst_null
    //   545: astore 6
    //   547: aload 5
    //   549: astore 7
    //   551: goto +157 -> 708
    //   554: astore_0
    //   555: goto +17 -> 572
    //   558: astore 8
    //   560: goto +29 -> 589
    //   563: astore 8
    //   565: goto +132 -> 697
    //   568: astore_0
    //   569: aconst_null
    //   570: astore 5
    //   572: aconst_null
    //   573: astore 4
    //   575: aconst_null
    //   576: astore 6
    //   578: aload_0
    //   579: astore 7
    //   581: goto +318 -> 899
    //   584: astore 8
    //   586: aconst_null
    //   587: astore 5
    //   589: aconst_null
    //   590: astore 6
    //   592: aload 5
    //   594: astore 7
    //   596: aload 9
    //   598: astore 4
    //   600: aconst_null
    //   601: astore 5
    //   603: aconst_null
    //   604: astore_0
    //   605: iconst_m1
    //   606: istore_1
    //   607: aload 4
    //   609: astore 12
    //   611: aload 7
    //   613: astore 9
    //   615: aload 5
    //   617: astore 10
    //   619: aload 6
    //   621: astore 11
    //   623: aload 8
    //   625: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   628: aload 4
    //   630: ifnull +11 -> 641
    //   633: aload 4
    //   635: invokevirtual 131	java/io/DataOutputStream:close	()V
    //   638: goto +3 -> 641
    //   641: aload 5
    //   643: ifnull +8 -> 651
    //   646: aload 5
    //   648: invokevirtual 132	java/io/BufferedReader:close	()V
    //   651: aload 6
    //   653: ifnull +16 -> 669
    //   656: aload 6
    //   658: invokevirtual 132	java/io/BufferedReader:close	()V
    //   661: goto +8 -> 669
    //   664: aload 4
    //   666: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   669: aload_0
    //   670: astore 4
    //   672: iload_1
    //   673: istore_2
    //   674: aload 7
    //   676: ifnull +114 -> 790
    //   679: aload 7
    //   681: invokevirtual 138	java/lang/Process:destroy	()V
    //   684: aload_0
    //   685: astore 4
    //   687: iload_1
    //   688: istore_2
    //   689: goto +101 -> 790
    //   692: astore 8
    //   694: aconst_null
    //   695: astore 5
    //   697: aconst_null
    //   698: astore 6
    //   700: aload 5
    //   702: astore 7
    //   704: aload 10
    //   706: astore 4
    //   708: aconst_null
    //   709: astore 5
    //   711: aconst_null
    //   712: astore_0
    //   713: iconst_m1
    //   714: istore_1
    //   715: aload 4
    //   717: astore 12
    //   719: aload 7
    //   721: astore 9
    //   723: aload 5
    //   725: astore 10
    //   727: aload 6
    //   729: astore 11
    //   731: aload 8
    //   733: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   736: aload 4
    //   738: ifnull +11 -> 749
    //   741: aload 4
    //   743: invokevirtual 131	java/io/DataOutputStream:close	()V
    //   746: goto +3 -> 749
    //   749: aload 5
    //   751: ifnull +8 -> 759
    //   754: aload 5
    //   756: invokevirtual 132	java/io/BufferedReader:close	()V
    //   759: aload 6
    //   761: ifnull +16 -> 777
    //   764: aload 6
    //   766: invokevirtual 132	java/io/BufferedReader:close	()V
    //   769: goto +8 -> 777
    //   772: aload 4
    //   774: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   777: aload_0
    //   778: astore 4
    //   780: iload_1
    //   781: istore_2
    //   782: aload 7
    //   784: ifnull +6 -> 790
    //   787: goto -108 -> 679
    //   790: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   793: ifeq +33 -> 826
    //   796: ldc 43
    //   798: iconst_2
    //   799: getstatic 145	java/util/Locale:CHINA	Ljava/util/Locale;
    //   802: ldc 147
    //   804: iconst_2
    //   805: anewarray 4	java/lang/Object
    //   808: dup
    //   809: iconst_0
    //   810: aload 4
    //   812: aastore
    //   813: dup
    //   814: iconst_1
    //   815: iload_2
    //   816: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   819: aastore
    //   820: invokestatic 157	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   823: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   826: iload_2
    //   827: ifne +5 -> 832
    //   830: iconst_1
    //   831: istore_3
    //   832: aload 13
    //   834: iload_3
    //   835: putfield 160	com/tencent/mobileqq/unifiedebug/UnifiedCommandUtil$ExecResult:jdField_a_of_type_Boolean	Z
    //   838: aload 13
    //   840: aload 14
    //   842: putfield 163	com/tencent/mobileqq/unifiedebug/UnifiedCommandUtil$ExecResult:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   845: aload 4
    //   847: ifnull +13 -> 860
    //   850: aload 13
    //   852: aload 4
    //   854: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   857: putfield 166	com/tencent/mobileqq/unifiedebug/UnifiedCommandUtil$ExecResult:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   860: aload 13
    //   862: areturn
    //   863: astore 4
    //   865: aload 12
    //   867: astore 8
    //   869: aload 11
    //   871: astore_0
    //   872: aload 10
    //   874: astore 6
    //   876: aload 9
    //   878: astore 5
    //   880: aload 6
    //   882: astore 9
    //   884: aload 4
    //   886: astore 7
    //   888: aload_0
    //   889: astore 6
    //   891: aload 8
    //   893: astore 4
    //   895: aload 9
    //   897: astore 8
    //   899: aload 4
    //   901: ifnull +11 -> 912
    //   904: aload 4
    //   906: invokevirtual 131	java/io/DataOutputStream:close	()V
    //   909: goto +3 -> 912
    //   912: aload 8
    //   914: ifnull +8 -> 922
    //   917: aload 8
    //   919: invokevirtual 132	java/io/BufferedReader:close	()V
    //   922: aload 6
    //   924: ifnull +15 -> 939
    //   927: aload 6
    //   929: invokevirtual 132	java/io/BufferedReader:close	()V
    //   932: goto +7 -> 939
    //   935: aload_0
    //   936: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   939: aload 5
    //   941: ifnull +8 -> 949
    //   944: aload 5
    //   946: invokevirtual 138	java/lang/Process:destroy	()V
    //   949: aload 7
    //   951: athrow
    //   952: aload 13
    //   954: iconst_0
    //   955: putfield 160	com/tencent/mobileqq/unifiedebug/UnifiedCommandUtil$ExecResult:jdField_a_of_type_Boolean	Z
    //   958: aload 13
    //   960: areturn
    //   961: iload_1
    //   962: iload_2
    //   963: if_icmpge -824 -> 139
    //   966: aload_0
    //   967: iload_1
    //   968: aaload
    //   969: astore 6
    //   971: aload 6
    //   973: ifnonnull -859 -> 114
    //   976: iload_1
    //   977: iconst_1
    //   978: iadd
    //   979: istore_1
    //   980: goto -19 -> 961
    //   983: astore 4
    //   985: goto -321 -> 664
    //   988: astore 4
    //   990: goto -218 -> 772
    //   993: astore_0
    //   994: goto -59 -> 935
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	997	0	paramArrayOfString	String[]
    //   110	870	1	i	int
    //   108	856	2	j	int
    //   10	825	3	bool	boolean
    //   36	261	4	localObject1	Object
    //   314	3	4	localIOException1	java.io.IOException
    //   332	521	4	localObject2	Object
    //   863	22	4	localObject3	Object
    //   893	12	4	localObject4	Object
    //   983	1	4	localIOException2	java.io.IOException
    //   988	1	4	localIOException3	java.io.IOException
    //   90	855	5	localObject5	Object
    //   116	856	6	localObject6	Object
    //   205	162	7	localBufferedReader	java.io.BufferedReader
    //   373	9	7	localObject7	Object
    //   395	115	7	localObject8	Object
    //   522	1	7	localObject9	Object
    //   537	413	7	localObject10	Object
    //   77	267	8	localObject11	Object
    //   355	1	8	localException1	java.lang.Exception
    //   364	1	8	localIOException4	java.io.IOException
    //   379	1	8	localObject12	Object
    //   388	1	8	localException2	java.lang.Exception
    //   408	1	8	localIOException5	java.io.IOException
    //   428	1	8	localException3	java.lang.Exception
    //   448	1	8	localIOException6	java.io.IOException
    //   471	47	8	localObject13	Object
    //   530	1	8	localException4	java.lang.Exception
    //   542	1	8	localIOException7	java.io.IOException
    //   558	1	8	localException5	java.lang.Exception
    //   563	1	8	localIOException8	java.io.IOException
    //   584	40	8	localException6	java.lang.Exception
    //   692	40	8	localIOException9	java.io.IOException
    //   867	51	8	localObject14	Object
    //   80	184	9	localStringBuilder	java.lang.StringBuilder
    //   339	10	9	localObject15	Object
    //   359	103	9	localObject16	Object
    //   468	21	9	localException7	java.lang.Exception
    //   495	102	9	localIOException10	java.io.IOException
    //   613	283	9	localObject17	Object
    //   74	799	10	localObject18	Object
    //   621	249	11	localObject19	Object
    //   609	257	12	localObject20	Object
    //   7	952	13	localExecResult	UnifiedCommandUtil.ExecResult
    //   71	770	14	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   296	311	314	java/io/IOException
    //   207	214	339	finally
    //   219	271	339	finally
    //   274	281	339	finally
    //   286	293	339	finally
    //   207	214	355	java/lang/Exception
    //   219	271	355	java/lang/Exception
    //   274	281	355	java/lang/Exception
    //   286	293	355	java/lang/Exception
    //   207	214	364	java/io/IOException
    //   219	271	364	java/io/IOException
    //   274	281	364	java/io/IOException
    //   286	293	364	java/io/IOException
    //   186	207	373	finally
    //   186	207	388	java/lang/Exception
    //   186	207	408	java/io/IOException
    //   165	186	428	java/lang/Exception
    //   165	186	448	java/io/IOException
    //   157	165	468	java/lang/Exception
    //   157	165	495	java/io/IOException
    //   106	109	522	finally
    //   114	136	522	finally
    //   139	157	522	finally
    //   157	165	522	finally
    //   165	186	522	finally
    //   106	109	530	java/lang/Exception
    //   114	136	530	java/lang/Exception
    //   139	157	530	java/lang/Exception
    //   106	109	542	java/io/IOException
    //   114	136	542	java/io/IOException
    //   139	157	542	java/io/IOException
    //   92	106	554	finally
    //   92	106	558	java/lang/Exception
    //   92	106	563	java/io/IOException
    //   82	92	568	finally
    //   82	92	584	java/lang/Exception
    //   82	92	692	java/io/IOException
    //   623	628	863	finally
    //   731	736	863	finally
    //   633	638	983	java/io/IOException
    //   646	651	983	java/io/IOException
    //   656	661	983	java/io/IOException
    //   741	746	988	java/io/IOException
    //   754	759	988	java/io/IOException
    //   764	769	988	java/io/IOException
    //   904	909	993	java/io/IOException
    //   917	922	993	java/io/IOException
    //   927	932	993	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedCommandUtil
 * JD-Core Version:    0.7.0.1
 */