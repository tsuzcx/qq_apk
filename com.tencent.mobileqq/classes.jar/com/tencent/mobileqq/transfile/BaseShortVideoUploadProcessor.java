package com.tencent.mobileqq.transfile;

import java.io.RandomAccessFile;

public class BaseShortVideoUploadProcessor
  extends BaseUploadProcessor
{
  protected RandomAccessFile mThumbRaf;
  protected byte[] thumbFileMd5;
  
  public BaseShortVideoUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
  }
  
  /* Error */
  public java.lang.String combineThumbAndVideo()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:thumbFileMd5	[B
    //   4: arraylength
    //   5: aload_0
    //   6: getfield 26	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:mLocalMd5	[B
    //   9: arraylength
    //   10: iadd
    //   11: newarray byte
    //   13: astore 7
    //   15: aload_0
    //   16: getfield 23	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:thumbFileMd5	[B
    //   19: astore 8
    //   21: aload 8
    //   23: iconst_0
    //   24: aload 7
    //   26: iconst_0
    //   27: aload 8
    //   29: arraylength
    //   30: invokestatic 32	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   33: aload_0
    //   34: getfield 26	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:mLocalMd5	[B
    //   37: iconst_0
    //   38: aload 7
    //   40: aload_0
    //   41: getfield 23	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:thumbFileMd5	[B
    //   44: arraylength
    //   45: aload_0
    //   46: getfield 26	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:mLocalMd5	[B
    //   49: arraylength
    //   50: invokestatic 32	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   53: new 34	java/lang/StringBuilder
    //   56: dup
    //   57: invokestatic 39	com/tencent/mobileqq/shortvideo/SVUtils:b	()Ljava/lang/String;
    //   60: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: astore 8
    //   65: aload 8
    //   67: aload 7
    //   69: invokestatic 48	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   72: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 8
    //   78: ldc 54
    //   80: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 8
    //   86: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore 12
    //   91: invokestatic 63	android/os/SystemClock:uptimeMillis	()J
    //   94: lstore_2
    //   95: new 65	java/io/File
    //   98: dup
    //   99: aload 12
    //   101: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: invokevirtual 70	java/io/File:delete	()Z
    //   107: pop
    //   108: new 65	java/io/File
    //   111: dup
    //   112: aload 12
    //   114: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: astore 7
    //   119: aload 7
    //   121: invokevirtual 73	java/io/File:exists	()Z
    //   124: istore 6
    //   126: iload 6
    //   128: ifne +19 -> 147
    //   131: aload 7
    //   133: invokevirtual 76	java/io/File:createNewFile	()Z
    //   136: pop
    //   137: goto +10 -> 147
    //   140: astore 8
    //   142: aload 8
    //   144: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   147: new 82	java/io/FileOutputStream
    //   150: dup
    //   151: aload 7
    //   153: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   156: astore 7
    //   158: new 87	java/io/BufferedOutputStream
    //   161: dup
    //   162: aload 7
    //   164: invokespecial 90	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   167: astore 10
    //   169: aload 10
    //   171: astore 8
    //   173: aload 7
    //   175: astore 9
    //   177: aload_0
    //   178: getfield 92	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:mThumbRaf	Ljava/io/RandomAccessFile;
    //   181: invokevirtual 97	java/io/RandomAccessFile:length	()J
    //   184: l2i
    //   185: newarray byte
    //   187: astore 11
    //   189: aload 10
    //   191: astore 8
    //   193: aload 7
    //   195: astore 9
    //   197: aload_0
    //   198: getfield 92	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:mThumbRaf	Ljava/io/RandomAccessFile;
    //   201: aload 11
    //   203: invokevirtual 101	java/io/RandomAccessFile:read	([B)I
    //   206: pop
    //   207: aload 10
    //   209: astore 8
    //   211: aload 7
    //   213: astore 9
    //   215: aload 10
    //   217: aload 11
    //   219: invokevirtual 105	java/io/BufferedOutputStream:write	([B)V
    //   222: aload 10
    //   224: astore 8
    //   226: aload 7
    //   228: astore 9
    //   230: ldc 106
    //   232: newarray byte
    //   234: astore 11
    //   236: aload 10
    //   238: astore 8
    //   240: aload 7
    //   242: astore 9
    //   244: aload_0
    //   245: getfield 109	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:mRaf	Ljava/io/RandomAccessFile;
    //   248: aload 11
    //   250: invokevirtual 101	java/io/RandomAccessFile:read	([B)I
    //   253: istore_1
    //   254: iload_1
    //   255: iconst_m1
    //   256: if_icmpeq +23 -> 279
    //   259: aload 10
    //   261: astore 8
    //   263: aload 7
    //   265: astore 9
    //   267: aload 10
    //   269: aload 11
    //   271: iconst_0
    //   272: iload_1
    //   273: invokevirtual 112	java/io/BufferedOutputStream:write	([BII)V
    //   276: goto -40 -> 236
    //   279: aload 10
    //   281: astore 8
    //   283: aload 7
    //   285: astore 9
    //   287: invokestatic 63	android/os/SystemClock:uptimeMillis	()J
    //   290: lstore 4
    //   292: aload 10
    //   294: astore 8
    //   296: aload 7
    //   298: astore 9
    //   300: aload_0
    //   301: getfield 116	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:mProcessorReport	Lcom/tencent/mobileqq/transfile/report/ProcessorReport;
    //   304: getfield 122	com/tencent/mobileqq/transfile/report/ProcessorReport:mReportInfo	Ljava/util/HashMap;
    //   307: ldc 124
    //   309: lload 4
    //   311: lload_2
    //   312: lsub
    //   313: invokestatic 130	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   316: invokevirtual 136	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   319: pop
    //   320: aload 10
    //   322: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   325: goto +10 -> 335
    //   328: astore 8
    //   330: aload 8
    //   332: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   335: aload 7
    //   337: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   340: aload 12
    //   342: areturn
    //   343: astore 11
    //   345: goto +66 -> 411
    //   348: astore 11
    //   350: goto +116 -> 466
    //   353: astore 11
    //   355: goto +166 -> 521
    //   358: astore 8
    //   360: aconst_null
    //   361: astore 9
    //   363: goto +228 -> 591
    //   366: astore 11
    //   368: aconst_null
    //   369: astore 10
    //   371: goto +40 -> 411
    //   374: astore 11
    //   376: aconst_null
    //   377: astore 10
    //   379: goto +87 -> 466
    //   382: astore 11
    //   384: aconst_null
    //   385: astore 10
    //   387: goto +134 -> 521
    //   390: astore 8
    //   392: aconst_null
    //   393: astore 9
    //   395: aload 9
    //   397: astore 7
    //   399: goto +192 -> 591
    //   402: astore 11
    //   404: aconst_null
    //   405: astore 7
    //   407: aload 7
    //   409: astore 10
    //   411: aload 10
    //   413: astore 8
    //   415: aload 7
    //   417: astore 9
    //   419: aload 11
    //   421: invokevirtual 141	java/lang/OutOfMemoryError:printStackTrace	()V
    //   424: aload 10
    //   426: ifnull +18 -> 444
    //   429: aload 10
    //   431: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   434: goto +10 -> 444
    //   437: astore 8
    //   439: aload 8
    //   441: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   444: aload 7
    //   446: ifnull +128 -> 574
    //   449: aload 7
    //   451: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   454: aload 12
    //   456: areturn
    //   457: astore 11
    //   459: aconst_null
    //   460: astore 7
    //   462: aload 7
    //   464: astore 10
    //   466: aload 10
    //   468: astore 8
    //   470: aload 7
    //   472: astore 9
    //   474: aload 11
    //   476: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   479: aload 10
    //   481: ifnull +18 -> 499
    //   484: aload 10
    //   486: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   489: goto +10 -> 499
    //   492: astore 8
    //   494: aload 8
    //   496: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   499: aload 7
    //   501: ifnull +73 -> 574
    //   504: aload 7
    //   506: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   509: aload 12
    //   511: areturn
    //   512: astore 11
    //   514: aconst_null
    //   515: astore 7
    //   517: aload 7
    //   519: astore 10
    //   521: aload 10
    //   523: astore 8
    //   525: aload 7
    //   527: astore 9
    //   529: aload 11
    //   531: invokevirtual 142	java/io/FileNotFoundException:printStackTrace	()V
    //   534: aload 10
    //   536: ifnull +18 -> 554
    //   539: aload 10
    //   541: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   544: goto +10 -> 554
    //   547: astore 8
    //   549: aload 8
    //   551: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   554: aload 7
    //   556: ifnull +18 -> 574
    //   559: aload 7
    //   561: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   564: aload 12
    //   566: areturn
    //   567: astore 7
    //   569: aload 7
    //   571: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   574: aload 12
    //   576: areturn
    //   577: astore 10
    //   579: aload 9
    //   581: astore 7
    //   583: aload 8
    //   585: astore 9
    //   587: aload 10
    //   589: astore 8
    //   591: aload 9
    //   593: ifnull +18 -> 611
    //   596: aload 9
    //   598: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   601: goto +10 -> 611
    //   604: astore 9
    //   606: aload 9
    //   608: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   611: aload 7
    //   613: ifnull +18 -> 631
    //   616: aload 7
    //   618: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   621: goto +10 -> 631
    //   624: astore 7
    //   626: aload 7
    //   628: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   631: goto +6 -> 637
    //   634: aload 8
    //   636: athrow
    //   637: goto -3 -> 634
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	640	0	this	BaseShortVideoUploadProcessor
    //   253	20	1	i	int
    //   94	218	2	l1	long
    //   290	20	4	l2	long
    //   124	3	6	bool	boolean
    //   13	547	7	localObject1	java.lang.Object
    //   567	3	7	localIOException1	java.io.IOException
    //   581	36	7	localObject2	java.lang.Object
    //   624	3	7	localIOException2	java.io.IOException
    //   19	66	8	localObject3	java.lang.Object
    //   140	3	8	localIOException3	java.io.IOException
    //   171	124	8	localObject4	java.lang.Object
    //   328	3	8	localIOException4	java.io.IOException
    //   358	1	8	localObject5	java.lang.Object
    //   390	1	8	localObject6	java.lang.Object
    //   413	1	8	localObject7	java.lang.Object
    //   437	3	8	localIOException5	java.io.IOException
    //   468	1	8	localObject8	java.lang.Object
    //   492	3	8	localIOException6	java.io.IOException
    //   523	1	8	localObject9	java.lang.Object
    //   547	37	8	localIOException7	java.io.IOException
    //   589	46	8	localObject10	java.lang.Object
    //   175	422	9	localObject11	java.lang.Object
    //   604	3	9	localIOException8	java.io.IOException
    //   167	373	10	localObject12	java.lang.Object
    //   577	11	10	localObject13	java.lang.Object
    //   187	83	11	arrayOfByte	byte[]
    //   343	1	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   348	1	11	localIOException9	java.io.IOException
    //   353	1	11	localFileNotFoundException1	java.io.FileNotFoundException
    //   366	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   374	1	11	localIOException10	java.io.IOException
    //   382	1	11	localFileNotFoundException2	java.io.FileNotFoundException
    //   402	18	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   457	18	11	localIOException11	java.io.IOException
    //   512	18	11	localFileNotFoundException3	java.io.FileNotFoundException
    //   89	486	12	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   131	137	140	java/io/IOException
    //   320	325	328	java/io/IOException
    //   177	189	343	java/lang/OutOfMemoryError
    //   197	207	343	java/lang/OutOfMemoryError
    //   215	222	343	java/lang/OutOfMemoryError
    //   230	236	343	java/lang/OutOfMemoryError
    //   244	254	343	java/lang/OutOfMemoryError
    //   267	276	343	java/lang/OutOfMemoryError
    //   287	292	343	java/lang/OutOfMemoryError
    //   300	320	343	java/lang/OutOfMemoryError
    //   177	189	348	java/io/IOException
    //   197	207	348	java/io/IOException
    //   215	222	348	java/io/IOException
    //   230	236	348	java/io/IOException
    //   244	254	348	java/io/IOException
    //   267	276	348	java/io/IOException
    //   287	292	348	java/io/IOException
    //   300	320	348	java/io/IOException
    //   177	189	353	java/io/FileNotFoundException
    //   197	207	353	java/io/FileNotFoundException
    //   215	222	353	java/io/FileNotFoundException
    //   230	236	353	java/io/FileNotFoundException
    //   244	254	353	java/io/FileNotFoundException
    //   267	276	353	java/io/FileNotFoundException
    //   287	292	353	java/io/FileNotFoundException
    //   300	320	353	java/io/FileNotFoundException
    //   158	169	358	finally
    //   158	169	366	java/lang/OutOfMemoryError
    //   158	169	374	java/io/IOException
    //   158	169	382	java/io/FileNotFoundException
    //   91	126	390	finally
    //   131	137	390	finally
    //   142	147	390	finally
    //   147	158	390	finally
    //   91	126	402	java/lang/OutOfMemoryError
    //   131	137	402	java/lang/OutOfMemoryError
    //   142	147	402	java/lang/OutOfMemoryError
    //   147	158	402	java/lang/OutOfMemoryError
    //   429	434	437	java/io/IOException
    //   91	126	457	java/io/IOException
    //   142	147	457	java/io/IOException
    //   147	158	457	java/io/IOException
    //   484	489	492	java/io/IOException
    //   91	126	512	java/io/FileNotFoundException
    //   131	137	512	java/io/FileNotFoundException
    //   142	147	512	java/io/FileNotFoundException
    //   147	158	512	java/io/FileNotFoundException
    //   539	544	547	java/io/IOException
    //   335	340	567	java/io/IOException
    //   449	454	567	java/io/IOException
    //   504	509	567	java/io/IOException
    //   559	564	567	java/io/IOException
    //   177	189	577	finally
    //   197	207	577	finally
    //   215	222	577	finally
    //   230	236	577	finally
    //   244	254	577	finally
    //   267	276	577	finally
    //   287	292	577	finally
    //   300	320	577	finally
    //   419	424	577	finally
    //   474	479	577	finally
    //   529	534	577	finally
    //   596	601	604	java/io/IOException
    //   616	621	624	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseShortVideoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */