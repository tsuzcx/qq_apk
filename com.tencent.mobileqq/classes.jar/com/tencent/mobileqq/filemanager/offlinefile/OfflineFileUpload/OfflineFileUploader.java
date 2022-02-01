package com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload;

import com.tencent.mobileqq.filemanager.app.FileTransferObserver;

public class OfflineFileUploader
  implements IOfflineFileHttpUploderSink
{
  long jdField_a_of_type_Long;
  FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = null;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  /* Error */
  public long a(com.tencent.mobileqq.transfile.NetResp paramNetResp)
  {
    // Byte code:
    //   0: new 26	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: getfield 32	com/tencent/mobileqq/transfile/NetResp:mRespData	[B
    //   8: invokespecial 35	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_1
    //   12: new 37	java/io/DataInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 40	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore 6
    //   22: aload 6
    //   24: ldc2_w 41
    //   27: invokevirtual 46	java/io/DataInputStream:skip	(J)J
    //   30: pop2
    //   31: aload 6
    //   33: invokevirtual 50	java/io/DataInputStream:readInt	()I
    //   36: ifeq +18 -> 54
    //   39: aload_0
    //   40: invokevirtual 52	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:b	()V
    //   43: aload_1
    //   44: invokevirtual 55	java/io/ByteArrayInputStream:close	()V
    //   47: aload 6
    //   49: invokevirtual 56	java/io/DataInputStream:close	()V
    //   52: lconst_0
    //   53: lreturn
    //   54: aload 6
    //   56: ldc2_w 57
    //   59: invokevirtual 46	java/io/DataInputStream:skip	(J)J
    //   62: pop2
    //   63: aload 6
    //   65: invokevirtual 62	java/io/DataInputStream:readByte	()B
    //   68: istore_2
    //   69: iload_2
    //   70: ifne +37 -> 107
    //   73: aload 6
    //   75: invokevirtual 50	java/io/DataInputStream:readInt	()I
    //   78: istore_2
    //   79: aload 6
    //   81: invokevirtual 50	java/io/DataInputStream:readInt	()I
    //   84: istore_3
    //   85: iload_3
    //   86: i2l
    //   87: bipush 32
    //   89: lshl
    //   90: iload_2
    //   91: i2l
    //   92: lor
    //   93: lstore 4
    //   95: aload_1
    //   96: invokevirtual 55	java/io/ByteArrayInputStream:close	()V
    //   99: aload 6
    //   101: invokevirtual 56	java/io/DataInputStream:close	()V
    //   104: lload 4
    //   106: lreturn
    //   107: iload_2
    //   108: iconst_1
    //   109: if_icmpne +18 -> 127
    //   112: aload_0
    //   113: invokevirtual 64	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:a	()V
    //   116: aload_1
    //   117: invokevirtual 55	java/io/ByteArrayInputStream:close	()V
    //   120: aload 6
    //   122: invokevirtual 56	java/io/DataInputStream:close	()V
    //   125: lconst_0
    //   126: lreturn
    //   127: aload_0
    //   128: invokevirtual 52	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:b	()V
    //   131: aload_1
    //   132: invokevirtual 55	java/io/ByteArrayInputStream:close	()V
    //   135: aload 6
    //   137: invokevirtual 56	java/io/DataInputStream:close	()V
    //   140: lconst_0
    //   141: lreturn
    //   142: astore 7
    //   144: goto +23 -> 167
    //   147: astore 7
    //   149: aload 7
    //   151: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   154: aload_1
    //   155: invokevirtual 55	java/io/ByteArrayInputStream:close	()V
    //   158: aload 6
    //   160: invokevirtual 56	java/io/DataInputStream:close	()V
    //   163: ldc2_w 68
    //   166: lreturn
    //   167: aload_1
    //   168: invokevirtual 55	java/io/ByteArrayInputStream:close	()V
    //   171: aload 6
    //   173: invokevirtual 56	java/io/DataInputStream:close	()V
    //   176: aload 7
    //   178: athrow
    //   179: astore_1
    //   180: lconst_0
    //   181: lreturn
    //   182: astore_1
    //   183: lload 4
    //   185: lreturn
    //   186: astore_1
    //   187: lconst_0
    //   188: lreturn
    //   189: astore_1
    //   190: lconst_0
    //   191: lreturn
    //   192: astore_1
    //   193: goto -30 -> 163
    //   196: astore_1
    //   197: goto -21 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	OfflineFileUploader
    //   0	200	1	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    //   68	42	2	i	int
    //   84	2	3	j	int
    //   93	91	4	l	long
    //   20	152	6	localDataInputStream	java.io.DataInputStream
    //   142	1	7	localObject	Object
    //   147	30	7	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   22	43	142	finally
    //   54	69	142	finally
    //   73	85	142	finally
    //   112	116	142	finally
    //   127	131	142	finally
    //   149	154	142	finally
    //   22	43	147	java/io/IOException
    //   54	69	147	java/io/IOException
    //   73	85	147	java/io/IOException
    //   112	116	147	java/io/IOException
    //   127	131	147	java/io/IOException
    //   43	52	179	java/lang/Exception
    //   95	104	182	java/lang/Exception
    //   116	125	186	java/lang/Exception
    //   131	140	189	java/lang/Exception
    //   154	163	192	java/lang/Exception
    //   167	176	196	java/lang/Exception
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver.a();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver.a(paramLong1, paramLong2);
  }
  
  public void a(boolean paramBoolean) {}
  
  /* Error */
  public byte[] a(byte[] paramArrayOfByte, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:b	Ljava/lang/String;
    //   4: astore 6
    //   6: aload 6
    //   8: astore 5
    //   10: aload 6
    //   12: ifnonnull +9 -> 21
    //   15: aload_0
    //   16: getfield 81	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:c	Ljava/lang/String;
    //   19: astore 5
    //   21: aload_0
    //   22: getfield 83	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   25: astore 6
    //   27: aload 6
    //   29: ifnull +259 -> 288
    //   32: aload 5
    //   34: ifnull +254 -> 288
    //   37: aload 6
    //   39: invokevirtual 88	java/lang/String:length	()I
    //   42: ifeq +246 -> 288
    //   45: aload 5
    //   47: invokevirtual 88	java/lang/String:length	()I
    //   50: ifne +6 -> 56
    //   53: goto +235 -> 288
    //   56: aload 5
    //   58: invokestatic 94	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   61: astore 7
    //   63: aload_0
    //   64: getfield 83	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokestatic 94	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   70: astore 8
    //   72: aload 8
    //   74: arraylength
    //   75: iconst_2
    //   76: iadd
    //   77: iconst_2
    //   78: iadd
    //   79: aload 7
    //   81: arraylength
    //   82: iadd
    //   83: bipush 20
    //   85: iadd
    //   86: aload_1
    //   87: arraylength
    //   88: iadd
    //   89: istore 4
    //   91: new 96	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: iload 4
    //   97: bipush 16
    //   99: iadd
    //   100: invokespecial 99	java/io/ByteArrayOutputStream:<init>	(I)V
    //   103: astore 5
    //   105: new 101	java/io/DataOutputStream
    //   108: dup
    //   109: aload 5
    //   111: invokespecial 104	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   114: astore 6
    //   116: aload 6
    //   118: ldc 105
    //   120: invokevirtual 108	java/io/DataOutputStream:writeInt	(I)V
    //   123: aload 6
    //   125: sipush 1007
    //   128: invokevirtual 108	java/io/DataOutputStream:writeInt	(I)V
    //   131: aload 6
    //   133: iconst_0
    //   134: invokevirtual 108	java/io/DataOutputStream:writeInt	(I)V
    //   137: aload 6
    //   139: iload 4
    //   141: invokevirtual 108	java/io/DataOutputStream:writeInt	(I)V
    //   144: aload 6
    //   146: aload 8
    //   148: arraylength
    //   149: invokevirtual 111	java/io/DataOutputStream:writeShort	(I)V
    //   152: aload 6
    //   154: aload 8
    //   156: invokevirtual 114	java/io/DataOutputStream:write	([B)V
    //   159: aload 6
    //   161: aload 7
    //   163: arraylength
    //   164: invokevirtual 111	java/io/DataOutputStream:writeShort	(I)V
    //   167: aload 6
    //   169: aload 7
    //   171: invokevirtual 114	java/io/DataOutputStream:write	([B)V
    //   174: aload 6
    //   176: aload_0
    //   177: getfield 116	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_Long	J
    //   180: ldc2_w 117
    //   183: land
    //   184: l2i
    //   185: invokevirtual 108	java/io/DataOutputStream:writeInt	(I)V
    //   188: aload 6
    //   190: lload_2
    //   191: ldc2_w 117
    //   194: land
    //   195: l2i
    //   196: invokevirtual 108	java/io/DataOutputStream:writeInt	(I)V
    //   199: aload 6
    //   201: aload_1
    //   202: arraylength
    //   203: invokevirtual 108	java/io/DataOutputStream:writeInt	(I)V
    //   206: aload 6
    //   208: aload_0
    //   209: getfield 116	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_Long	J
    //   212: bipush 32
    //   214: lshr
    //   215: l2i
    //   216: invokevirtual 108	java/io/DataOutputStream:writeInt	(I)V
    //   219: aload 6
    //   221: lload_2
    //   222: bipush 32
    //   224: lshr
    //   225: l2i
    //   226: invokevirtual 108	java/io/DataOutputStream:writeInt	(I)V
    //   229: aload 6
    //   231: aload_1
    //   232: iconst_0
    //   233: aload_1
    //   234: arraylength
    //   235: invokevirtual 121	java/io/DataOutputStream:write	([BII)V
    //   238: aload 5
    //   240: invokevirtual 125	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   243: astore_1
    //   244: aload 5
    //   246: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   249: aload 6
    //   251: invokevirtual 127	java/io/DataOutputStream:close	()V
    //   254: aload_1
    //   255: areturn
    //   256: astore_1
    //   257: goto +19 -> 276
    //   260: aload_0
    //   261: invokevirtual 52	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:b	()V
    //   264: aload 5
    //   266: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   269: aload 6
    //   271: invokevirtual 127	java/io/DataOutputStream:close	()V
    //   274: aconst_null
    //   275: areturn
    //   276: aload 5
    //   278: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   281: aload 6
    //   283: invokevirtual 127	java/io/DataOutputStream:close	()V
    //   286: aload_1
    //   287: athrow
    //   288: invokestatic 133	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   291: ifne +9 -> 300
    //   294: aload_0
    //   295: invokevirtual 52	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:b	()V
    //   298: aconst_null
    //   299: areturn
    //   300: new 135	java/lang/NullPointerException
    //   303: dup
    //   304: invokespecial 136	java/lang/NullPointerException:<init>	()V
    //   307: athrow
    //   308: astore_1
    //   309: goto -49 -> 260
    //   312: astore 5
    //   314: aload_1
    //   315: areturn
    //   316: astore_1
    //   317: aconst_null
    //   318: areturn
    //   319: astore 5
    //   321: goto -35 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	OfflineFileUploader
    //   0	324	1	paramArrayOfByte	byte[]
    //   0	324	2	paramLong	long
    //   89	51	4	i	int
    //   8	269	5	localObject1	Object
    //   312	1	5	localException1	java.lang.Exception
    //   319	1	5	localException2	java.lang.Exception
    //   4	278	6	localObject2	Object
    //   61	109	7	arrayOfByte1	byte[]
    //   70	85	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   116	244	256	finally
    //   260	264	256	finally
    //   116	244	308	java/io/IOException
    //   244	254	312	java/lang/Exception
    //   264	274	316	java/lang/Exception
    //   276	286	319	java/lang/Exception
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploader
 * JD-Core Version:    0.7.0.1
 */