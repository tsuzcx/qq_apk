package com.tencent.mobileqq.vas;

public class VasQuickUpdateManager$UpdateInfo
{
  public long bid;
  public int code;
  public int compress_mode;
  public int delta_mode;
  public String dst_version;
  public String filecontent;
  public long filesize;
  public String scid;
  public String src_version;
  public int storage_mode;
  public String url;
  
  /* Error */
  public void set(com.tencent.pb.scupdate.SCUpdatePB.UpdateInfo paramUpdateInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: getfield 32	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:bid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5: invokevirtual 38	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8: i2l
    //   9: putfield 40	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:bid	J
    //   12: aload_0
    //   13: aload_1
    //   14: getfield 43	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:scid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   17: invokevirtual 48	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   20: putfield 50	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:scid	Ljava/lang/String;
    //   23: aload_0
    //   24: aload_1
    //   25: getfield 52	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:dst_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   28: invokevirtual 48	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   31: putfield 54	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:dst_version	Ljava/lang/String;
    //   34: aload_0
    //   35: aload_1
    //   36: getfield 56	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:src_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   39: invokevirtual 48	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   42: putfield 58	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:src_version	Ljava/lang/String;
    //   45: aload_0
    //   46: aload_1
    //   47: getfield 60	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:delta_mode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   50: invokevirtual 38	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   53: putfield 62	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:delta_mode	I
    //   56: aload_0
    //   57: aload_1
    //   58: getfield 64	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:storage_mode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   61: invokevirtual 38	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   64: putfield 66	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:storage_mode	I
    //   67: aload_0
    //   68: aload_1
    //   69: getfield 68	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:compress_mode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 38	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   75: putfield 70	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:compress_mode	I
    //   78: aload_0
    //   79: aload_1
    //   80: getfield 72	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   83: invokevirtual 48	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   86: putfield 74	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:url	Ljava/lang/String;
    //   89: aload_0
    //   90: aload_1
    //   91: getfield 77	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:filesize	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   94: invokevirtual 82	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   97: putfield 84	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filesize	J
    //   100: aload_1
    //   101: getfield 87	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:filecontent	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   104: invokevirtual 92	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   107: invokevirtual 98	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   110: astore 10
    //   112: aload 10
    //   114: arraylength
    //   115: ifle +351 -> 466
    //   118: aconst_null
    //   119: astore 8
    //   121: aconst_null
    //   122: astore 7
    //   124: aload 8
    //   126: astore 4
    //   128: invokestatic 104	com/tencent/mobileqq/vas/VasQuickUpdateEngine:getInstance	()Lcom/tencent/mobileqq/vas/VasQuickUpdateEngine;
    //   131: aload_0
    //   132: getfield 40	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:bid	J
    //   135: aload_0
    //   136: getfield 50	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:scid	Ljava/lang/String;
    //   139: invokevirtual 108	com/tencent/mobileqq/vas/VasQuickUpdateEngine:getItemInfo	(JLjava/lang/String;)Lcom/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo;
    //   142: astore 5
    //   144: aload 8
    //   146: astore 4
    //   148: new 110	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   155: invokestatic 117	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   158: invokevirtual 121	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   161: invokevirtual 126	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   164: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 132
    //   169: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   175: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc 142
    //   180: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload_2
    //   184: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore 9
    //   192: aload 9
    //   194: astore 6
    //   196: aload 5
    //   198: ifnull +148 -> 346
    //   201: aload 9
    //   203: astore 6
    //   205: aload 8
    //   207: astore 4
    //   209: aload 5
    //   211: getfield 153	com/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo:strSavePath	Ljava/lang/String;
    //   214: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifne +129 -> 346
    //   220: aload 8
    //   222: astore 4
    //   224: aload 5
    //   226: getfield 163	com/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo:bSaveInDir	Z
    //   229: ifeq +249 -> 478
    //   232: aload 8
    //   234: astore 4
    //   236: aload 5
    //   238: getfield 153	com/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo:strSavePath	Ljava/lang/String;
    //   241: astore 5
    //   243: aload 9
    //   245: astore 6
    //   247: aload 8
    //   249: astore 4
    //   251: aload 5
    //   253: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   256: ifne +90 -> 346
    //   259: aload 8
    //   261: astore 4
    //   263: new 123	java/io/File
    //   266: dup
    //   267: aload 5
    //   269: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;)V
    //   272: astore 6
    //   274: aload 8
    //   276: astore 4
    //   278: aload 6
    //   280: invokevirtual 170	java/io/File:exists	()Z
    //   283: ifne +13 -> 296
    //   286: aload 8
    //   288: astore 4
    //   290: aload 6
    //   292: invokevirtual 173	java/io/File:mkdirs	()Z
    //   295: pop
    //   296: aload 8
    //   298: astore 4
    //   300: aload 5
    //   302: invokestatic 178	bnon:a	(Ljava/lang/String;)V
    //   305: aload 8
    //   307: astore 4
    //   309: new 110	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   316: aload 5
    //   318: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc 132
    //   323: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   329: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   332: ldc 142
    //   334: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: iload_2
    //   338: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: astore 6
    //   346: aload 8
    //   348: astore 4
    //   350: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +33 -> 386
    //   356: aload 8
    //   358: astore 4
    //   360: ldc 185
    //   362: iconst_2
    //   363: new 110	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   370: ldc 187
    //   372: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload 6
    //   377: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload 8
    //   388: astore 4
    //   390: aload 6
    //   392: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   395: ifne +117 -> 512
    //   398: aload 8
    //   400: astore 4
    //   402: new 193	java/io/DataOutputStream
    //   405: dup
    //   406: new 195	java/io/BufferedOutputStream
    //   409: dup
    //   410: new 197	java/io/FileOutputStream
    //   413: dup
    //   414: new 123	java/io/File
    //   417: dup
    //   418: aload 6
    //   420: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;)V
    //   423: invokespecial 200	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   426: invokespecial 203	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   429: invokespecial 204	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   432: astore 5
    //   434: aload 5
    //   436: aload 10
    //   438: iconst_0
    //   439: aload 10
    //   441: arraylength
    //   442: invokevirtual 208	java/io/DataOutputStream:write	([BII)V
    //   445: aload 5
    //   447: invokevirtual 211	java/io/DataOutputStream:flush	()V
    //   450: aload_0
    //   451: aload 6
    //   453: putfield 213	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
    //   456: aload 5
    //   458: ifnull +8 -> 466
    //   461: aload 5
    //   463: invokevirtual 216	java/io/DataOutputStream:close	()V
    //   466: aload_0
    //   467: aload_1
    //   468: getfield 219	com/tencent/pb/scupdate/SCUpdatePB$UpdateInfo:code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   471: invokevirtual 222	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   474: putfield 224	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:code	I
    //   477: return
    //   478: aload 8
    //   480: astore 4
    //   482: aload 5
    //   484: getfield 153	com/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo:strSavePath	Ljava/lang/String;
    //   487: ldc 226
    //   489: invokevirtual 232	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   492: istore_3
    //   493: aload 8
    //   495: astore 4
    //   497: aload 5
    //   499: getfield 153	com/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo:strSavePath	Ljava/lang/String;
    //   502: iconst_0
    //   503: iload_3
    //   504: invokevirtual 236	java/lang/String:substring	(II)Ljava/lang/String;
    //   507: astore 5
    //   509: goto -266 -> 243
    //   512: aload 8
    //   514: astore 4
    //   516: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +15 -> 534
    //   522: aload 8
    //   524: astore 4
    //   526: ldc 185
    //   528: iconst_2
    //   529: ldc 238
    //   531: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aload 8
    //   536: astore 4
    //   538: aload_0
    //   539: ldc 240
    //   541: putfield 213	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
    //   544: aconst_null
    //   545: astore 5
    //   547: goto -91 -> 456
    //   550: astore 4
    //   552: ldc 185
    //   554: iconst_1
    //   555: ldc 242
    //   557: aload 4
    //   559: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   562: goto -96 -> 466
    //   565: astore 6
    //   567: aload 7
    //   569: astore 5
    //   571: aload 5
    //   573: astore 4
    //   575: ldc 185
    //   577: iconst_1
    //   578: ldc 248
    //   580: aload 6
    //   582: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   585: aload 5
    //   587: astore 4
    //   589: aload_0
    //   590: ldc 240
    //   592: putfield 213	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
    //   595: aload 5
    //   597: ifnull -131 -> 466
    //   600: aload 5
    //   602: invokevirtual 216	java/io/DataOutputStream:close	()V
    //   605: goto -139 -> 466
    //   608: astore 4
    //   610: ldc 185
    //   612: iconst_1
    //   613: ldc 242
    //   615: aload 4
    //   617: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   620: goto -154 -> 466
    //   623: astore_1
    //   624: aload 4
    //   626: ifnull +8 -> 634
    //   629: aload 4
    //   631: invokevirtual 216	java/io/DataOutputStream:close	()V
    //   634: aload_1
    //   635: athrow
    //   636: astore 4
    //   638: ldc 185
    //   640: iconst_1
    //   641: ldc 242
    //   643: aload 4
    //   645: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   648: goto -14 -> 634
    //   651: astore_1
    //   652: aload 5
    //   654: astore 4
    //   656: goto -32 -> 624
    //   659: astore 6
    //   661: goto -90 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	this	UpdateInfo
    //   0	664	1	paramUpdateInfo	com.tencent.pb.scupdate.SCUpdatePB.UpdateInfo
    //   0	664	2	paramInt	int
    //   492	12	3	i	int
    //   126	411	4	localObject1	Object
    //   550	8	4	localException1	java.lang.Exception
    //   573	15	4	localObject2	Object
    //   608	22	4	localException2	java.lang.Exception
    //   636	8	4	localException3	java.lang.Exception
    //   654	1	4	localObject3	Object
    //   142	511	5	localObject4	Object
    //   194	258	6	localObject5	Object
    //   565	16	6	localException4	java.lang.Exception
    //   659	1	6	localException5	java.lang.Exception
    //   122	446	7	localObject6	Object
    //   119	416	8	localObject7	Object
    //   190	54	9	str	String
    //   110	330	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   461	466	550	java/lang/Exception
    //   128	144	565	java/lang/Exception
    //   148	192	565	java/lang/Exception
    //   209	220	565	java/lang/Exception
    //   224	232	565	java/lang/Exception
    //   236	243	565	java/lang/Exception
    //   251	259	565	java/lang/Exception
    //   263	274	565	java/lang/Exception
    //   278	286	565	java/lang/Exception
    //   290	296	565	java/lang/Exception
    //   300	305	565	java/lang/Exception
    //   309	346	565	java/lang/Exception
    //   350	356	565	java/lang/Exception
    //   360	386	565	java/lang/Exception
    //   390	398	565	java/lang/Exception
    //   402	434	565	java/lang/Exception
    //   482	493	565	java/lang/Exception
    //   497	509	565	java/lang/Exception
    //   516	522	565	java/lang/Exception
    //   526	534	565	java/lang/Exception
    //   538	544	565	java/lang/Exception
    //   600	605	608	java/lang/Exception
    //   128	144	623	finally
    //   148	192	623	finally
    //   209	220	623	finally
    //   224	232	623	finally
    //   236	243	623	finally
    //   251	259	623	finally
    //   263	274	623	finally
    //   278	286	623	finally
    //   290	296	623	finally
    //   300	305	623	finally
    //   309	346	623	finally
    //   350	356	623	finally
    //   360	386	623	finally
    //   390	398	623	finally
    //   402	434	623	finally
    //   482	493	623	finally
    //   497	509	623	finally
    //   516	522	623	finally
    //   526	534	623	finally
    //   538	544	623	finally
    //   575	585	623	finally
    //   589	595	623	finally
    //   629	634	636	java/lang/Exception
    //   434	456	651	finally
    //   434	456	659	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.UpdateInfo
 * JD-Core Version:    0.7.0.1
 */