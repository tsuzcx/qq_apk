package com.tencent.mobileqq.vas;

public class VasQuickUpdateManager$UpdateInfo
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  
  /* Error */
  public void a(com.tencent.pb.scupdate.SCUpdatePB.UpdateInfo paramUpdateInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: getfield 26	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:bid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5: invokevirtual 32	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8: i2l
    //   9: putfield 34	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_a_of_type_Long	J
    //   12: aload_0
    //   13: aload_1
    //   14: getfield 38	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:scid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   17: invokevirtual 43	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   20: putfield 45	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: aload_0
    //   24: aload_1
    //   25: getfield 48	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:dst_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   28: invokevirtual 43	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   31: putfield 50	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   34: aload_0
    //   35: aload_1
    //   36: getfield 53	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:src_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   39: invokevirtual 43	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   42: putfield 55	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   45: aload_0
    //   46: aload_1
    //   47: getfield 58	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:delta_mode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   50: invokevirtual 32	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   53: putfield 60	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_a_of_type_Int	I
    //   56: aload_0
    //   57: aload_1
    //   58: getfield 63	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:storage_mode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   61: invokevirtual 32	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   64: putfield 65	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_b_of_type_Int	I
    //   67: aload_0
    //   68: aload_1
    //   69: getfield 68	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:compress_mode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 32	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   75: putfield 70	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_c_of_type_Int	I
    //   78: aload_0
    //   79: aload_1
    //   80: getfield 73	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   83: invokevirtual 43	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   86: putfield 75	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   89: aload_0
    //   90: aload_1
    //   91: getfield 79	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:filesize	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   94: invokevirtual 84	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   97: putfield 86	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_b_of_type_Long	J
    //   100: aload_1
    //   101: getfield 90	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:filecontent	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   104: invokevirtual 95	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   107: invokevirtual 101	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   110: astore 10
    //   112: aload 10
    //   114: arraylength
    //   115: ifle +342 -> 457
    //   118: aconst_null
    //   119: astore 8
    //   121: aconst_null
    //   122: astore 7
    //   124: aload 8
    //   126: astore 4
    //   128: invokestatic 107	com/tencent/mobileqq/vas/VasQuickUpdateEngine:getInstance	()Lcom/tencent/mobileqq/vas/VasQuickUpdateEngine;
    //   131: aload_0
    //   132: getfield 34	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_a_of_type_Long	J
    //   135: aload_0
    //   136: getfield 45	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   139: invokevirtual 111	com/tencent/mobileqq/vas/VasQuickUpdateEngine:getItemInfo	(JLjava/lang/String;)Lcom/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo;
    //   142: astore 5
    //   144: aload 8
    //   146: astore 4
    //   148: new 113	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   155: invokestatic 120	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   158: invokevirtual 124	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   161: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   164: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 135
    //   169: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokestatic 140	java/lang/System:currentTimeMillis	()J
    //   175: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc 145
    //   180: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload_2
    //   184: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore 9
    //   192: aload 9
    //   194: astore 6
    //   196: aload 5
    //   198: ifnull +139 -> 337
    //   201: aload 9
    //   203: astore 6
    //   205: aload 8
    //   207: astore 4
    //   209: aload 5
    //   211: getfield 156	com/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo:strSavePath	Ljava/lang/String;
    //   214: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifne +120 -> 337
    //   220: aload 8
    //   222: astore 4
    //   224: aload 5
    //   226: getfield 166	com/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo:bSaveInDir	Z
    //   229: ifeq +240 -> 469
    //   232: aload 8
    //   234: astore 4
    //   236: aload 5
    //   238: getfield 156	com/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo:strSavePath	Ljava/lang/String;
    //   241: astore 5
    //   243: aload 9
    //   245: astore 6
    //   247: aload 8
    //   249: astore 4
    //   251: aload 5
    //   253: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   256: ifne +81 -> 337
    //   259: aload 8
    //   261: astore 4
    //   263: new 126	java/io/File
    //   266: dup
    //   267: aload 5
    //   269: invokespecial 169	java/io/File:<init>	(Ljava/lang/String;)V
    //   272: astore 6
    //   274: aload 8
    //   276: astore 4
    //   278: aload 6
    //   280: invokevirtual 173	java/io/File:exists	()Z
    //   283: ifne +13 -> 296
    //   286: aload 8
    //   288: astore 4
    //   290: aload 6
    //   292: invokevirtual 176	java/io/File:mkdirs	()Z
    //   295: pop
    //   296: aload 8
    //   298: astore 4
    //   300: new 113	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   307: aload 5
    //   309: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc 135
    //   314: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokestatic 140	java/lang/System:currentTimeMillis	()J
    //   320: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   323: ldc 145
    //   325: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: iload_2
    //   329: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: astore 6
    //   337: aload 8
    //   339: astore 4
    //   341: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +33 -> 377
    //   347: aload 8
    //   349: astore 4
    //   351: ldc 183
    //   353: iconst_2
    //   354: new 113	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   361: ldc 185
    //   363: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 6
    //   368: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload 8
    //   379: astore 4
    //   381: aload 6
    //   383: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   386: ifne +117 -> 503
    //   389: aload 8
    //   391: astore 4
    //   393: new 190	java/io/DataOutputStream
    //   396: dup
    //   397: new 192	java/io/BufferedOutputStream
    //   400: dup
    //   401: new 194	java/io/FileOutputStream
    //   404: dup
    //   405: new 126	java/io/File
    //   408: dup
    //   409: aload 6
    //   411: invokespecial 169	java/io/File:<init>	(Ljava/lang/String;)V
    //   414: invokespecial 197	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   417: invokespecial 200	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   420: invokespecial 201	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   423: astore 5
    //   425: aload 5
    //   427: aload 10
    //   429: iconst_0
    //   430: aload 10
    //   432: arraylength
    //   433: invokevirtual 205	java/io/DataOutputStream:write	([BII)V
    //   436: aload 5
    //   438: invokevirtual 208	java/io/DataOutputStream:flush	()V
    //   441: aload_0
    //   442: aload 6
    //   444: putfield 210	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:e	Ljava/lang/String;
    //   447: aload 5
    //   449: ifnull +8 -> 457
    //   452: aload 5
    //   454: invokevirtual 213	java/io/DataOutputStream:close	()V
    //   457: aload_0
    //   458: aload_1
    //   459: getfield 217	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   462: invokevirtual 220	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   465: putfield 222	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:jdField_d_of_type_Int	I
    //   468: return
    //   469: aload 8
    //   471: astore 4
    //   473: aload 5
    //   475: getfield 156	com/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo:strSavePath	Ljava/lang/String;
    //   478: ldc 224
    //   480: invokevirtual 230	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   483: istore_3
    //   484: aload 8
    //   486: astore 4
    //   488: aload 5
    //   490: getfield 156	com/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo:strSavePath	Ljava/lang/String;
    //   493: iconst_0
    //   494: iload_3
    //   495: invokevirtual 234	java/lang/String:substring	(II)Ljava/lang/String;
    //   498: astore 5
    //   500: goto -257 -> 243
    //   503: aload 8
    //   505: astore 4
    //   507: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +15 -> 525
    //   513: aload 8
    //   515: astore 4
    //   517: ldc 183
    //   519: iconst_2
    //   520: ldc 236
    //   522: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: aload 8
    //   527: astore 4
    //   529: aload_0
    //   530: ldc 238
    //   532: putfield 210	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:e	Ljava/lang/String;
    //   535: aconst_null
    //   536: astore 5
    //   538: goto -91 -> 447
    //   541: astore 4
    //   543: ldc 183
    //   545: iconst_1
    //   546: ldc 240
    //   548: aload 4
    //   550: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   553: goto -96 -> 457
    //   556: astore 6
    //   558: aload 7
    //   560: astore 5
    //   562: aload 5
    //   564: astore 4
    //   566: ldc 183
    //   568: iconst_1
    //   569: ldc 245
    //   571: aload 6
    //   573: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   576: aload 5
    //   578: astore 4
    //   580: aload_0
    //   581: ldc 238
    //   583: putfield 210	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:e	Ljava/lang/String;
    //   586: aload 5
    //   588: ifnull -131 -> 457
    //   591: aload 5
    //   593: invokevirtual 213	java/io/DataOutputStream:close	()V
    //   596: goto -139 -> 457
    //   599: astore 4
    //   601: ldc 183
    //   603: iconst_1
    //   604: ldc 240
    //   606: aload 4
    //   608: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   611: goto -154 -> 457
    //   614: astore_1
    //   615: aload 4
    //   617: ifnull +8 -> 625
    //   620: aload 4
    //   622: invokevirtual 213	java/io/DataOutputStream:close	()V
    //   625: aload_1
    //   626: athrow
    //   627: astore 4
    //   629: ldc 183
    //   631: iconst_1
    //   632: ldc 240
    //   634: aload 4
    //   636: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   639: goto -14 -> 625
    //   642: astore_1
    //   643: aload 5
    //   645: astore 4
    //   647: goto -32 -> 615
    //   650: astore 6
    //   652: goto -90 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	this	UpdateInfo
    //   0	655	1	paramUpdateInfo	com.tencent.pb.scupdate.SCUpdatePB.UpdateInfo
    //   0	655	2	paramInt	int
    //   483	12	3	i	int
    //   126	402	4	localObject1	Object
    //   541	8	4	localException1	java.lang.Exception
    //   564	15	4	localObject2	Object
    //   599	22	4	localException2	java.lang.Exception
    //   627	8	4	localException3	java.lang.Exception
    //   645	1	4	localObject3	Object
    //   142	502	5	localObject4	Object
    //   194	249	6	localObject5	Object
    //   556	16	6	localException4	java.lang.Exception
    //   650	1	6	localException5	java.lang.Exception
    //   122	437	7	localObject6	Object
    //   119	407	8	localObject7	Object
    //   190	54	9	str	String
    //   110	321	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   452	457	541	java/lang/Exception
    //   128	144	556	java/lang/Exception
    //   148	192	556	java/lang/Exception
    //   209	220	556	java/lang/Exception
    //   224	232	556	java/lang/Exception
    //   236	243	556	java/lang/Exception
    //   251	259	556	java/lang/Exception
    //   263	274	556	java/lang/Exception
    //   278	286	556	java/lang/Exception
    //   290	296	556	java/lang/Exception
    //   300	337	556	java/lang/Exception
    //   341	347	556	java/lang/Exception
    //   351	377	556	java/lang/Exception
    //   381	389	556	java/lang/Exception
    //   393	425	556	java/lang/Exception
    //   473	484	556	java/lang/Exception
    //   488	500	556	java/lang/Exception
    //   507	513	556	java/lang/Exception
    //   517	525	556	java/lang/Exception
    //   529	535	556	java/lang/Exception
    //   591	596	599	java/lang/Exception
    //   128	144	614	finally
    //   148	192	614	finally
    //   209	220	614	finally
    //   224	232	614	finally
    //   236	243	614	finally
    //   251	259	614	finally
    //   263	274	614	finally
    //   278	286	614	finally
    //   290	296	614	finally
    //   300	337	614	finally
    //   341	347	614	finally
    //   351	377	614	finally
    //   381	389	614	finally
    //   393	425	614	finally
    //   473	484	614	finally
    //   488	500	614	finally
    //   507	513	614	finally
    //   517	525	614	finally
    //   529	535	614	finally
    //   566	576	614	finally
    //   580	586	614	finally
    //   620	625	627	java/lang/Exception
    //   425	447	642	finally
    //   425	447	650	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.UpdateInfo
 * JD-Core Version:    0.7.0.1
 */