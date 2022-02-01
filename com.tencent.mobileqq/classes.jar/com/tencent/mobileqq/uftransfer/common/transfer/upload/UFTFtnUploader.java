package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTHttpUrlProcessor;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator.UFTHttpErr;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator.UFTHttpReq;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator.UFTHttpRsp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import mqq.app.AppRuntime;

public class UFTFtnUploader
  extends UFTHttpCommunicator
  implements IUFTFtnUploader
{
  private IUFTFtnUploaderCallback jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback;
  private UFTFtnUploader.UperProp jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadUFTFtnUploader$UperProp;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final byte[] b;
  
  private UFTFtnUploader(AppRuntime paramAppRuntime, long paramLong, UFTFtnUploader.UperProp paramUperProp)
  {
    super(paramAppRuntime, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadUFTFtnUploader$UperProp = paramUperProp;
    this.jdField_a_of_type_ArrayOfByte = UFTDependFeatureApi.a(paramUperProp.jdField_a_of_type_JavaLangString);
    this.b = UFTDependFeatureApi.a(paramUperProp.jdField_b_of_type_JavaLangString);
  }
  
  public static UFTFtnUploader a(AppRuntime paramAppRuntime, long paramLong, UFTFtnUploader.UperProp paramUperProp)
  {
    if (paramUperProp == null)
    {
      UFTLog.c("[UFTTransfer] UFTFtnDataUploader", 1, "DlderAttr is null");
      return null;
    }
    if (!paramUperProp.a()) {
      return null;
    }
    return new UFTFtnUploader(paramAppRuntime, paramLong, paramUperProp);
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: new 58	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 61	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_1
    //   9: new 63	java/io/DataInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 66	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore 8
    //   19: aload 8
    //   21: ldc2_w 67
    //   24: invokevirtual 72	java/io/DataInputStream:skip	(J)J
    //   27: pop2
    //   28: aload 8
    //   30: invokevirtual 76	java/io/DataInputStream:readInt	()I
    //   33: istore_3
    //   34: iload_3
    //   35: ifeq +74 -> 109
    //   38: new 78	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   45: astore_2
    //   46: aload_2
    //   47: ldc 83
    //   49: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_2
    //   54: aload_0
    //   55: getfield 90	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_Long	J
    //   58: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: ldc 95
    //   65: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: iload_3
    //   71: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: ldc 38
    //   77: iconst_1
    //   78: aload_2
    //   79: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 105	com/tencent/mobileqq/uftransfer/depend/UFTLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_0
    //   86: getfield 107	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback	Lcom/tencent/mobileqq/uftransfer/common/transfer/upload/IUFTFtnUploaderCallback;
    //   89: sipush 9001
    //   92: ldc 109
    //   94: invokeinterface 114 3 0
    //   99: aload_1
    //   100: invokevirtual 117	java/io/ByteArrayInputStream:close	()V
    //   103: aload 8
    //   105: invokevirtual 118	java/io/DataInputStream:close	()V
    //   108: return
    //   109: aload 8
    //   111: ldc2_w 119
    //   114: invokevirtual 72	java/io/DataInputStream:skip	(J)J
    //   117: pop2
    //   118: aload 8
    //   120: invokevirtual 124	java/io/DataInputStream:readByte	()B
    //   123: istore_3
    //   124: iload_3
    //   125: ifne +42 -> 167
    //   128: aload 8
    //   130: invokevirtual 76	java/io/DataInputStream:readInt	()I
    //   133: istore_3
    //   134: aload 8
    //   136: invokevirtual 76	java/io/DataInputStream:readInt	()I
    //   139: i2l
    //   140: lstore 4
    //   142: iload_3
    //   143: i2l
    //   144: lstore 6
    //   146: aload_0
    //   147: getfield 107	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback	Lcom/tencent/mobileqq/uftransfer/common/transfer/upload/IUFTFtnUploaderCallback;
    //   150: lload 6
    //   152: lload 4
    //   154: bipush 32
    //   156: lshl
    //   157: lor
    //   158: aload_2
    //   159: invokeinterface 127 4 0
    //   164: goto +81 -> 245
    //   167: iload_3
    //   168: iconst_1
    //   169: if_icmpne +15 -> 184
    //   172: aload_0
    //   173: getfield 107	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback	Lcom/tencent/mobileqq/uftransfer/common/transfer/upload/IUFTFtnUploaderCallback;
    //   176: invokeinterface 129 1 0
    //   181: goto +64 -> 245
    //   184: new 78	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   191: astore_2
    //   192: aload_2
    //   193: ldc 83
    //   195: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_2
    //   200: aload_0
    //   201: getfield 90	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_Long	J
    //   204: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_2
    //   209: ldc 131
    //   211: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_2
    //   216: iload_3
    //   217: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: ldc 38
    //   223: iconst_1
    //   224: aload_2
    //   225: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 105	com/tencent/mobileqq/uftransfer/depend/UFTLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload_0
    //   232: getfield 107	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback	Lcom/tencent/mobileqq/uftransfer/common/transfer/upload/IUFTFtnUploaderCallback;
    //   235: sipush 9001
    //   238: ldc 133
    //   240: invokeinterface 114 3 0
    //   245: aload_1
    //   246: invokevirtual 117	java/io/ByteArrayInputStream:close	()V
    //   249: aload 8
    //   251: invokevirtual 118	java/io/DataInputStream:close	()V
    //   254: return
    //   255: astore_2
    //   256: goto +77 -> 333
    //   259: astore_2
    //   260: new 78	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   267: astore 9
    //   269: aload 9
    //   271: ldc 83
    //   273: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 9
    //   279: aload_0
    //   280: getfield 90	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_Long	J
    //   283: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 9
    //   289: ldc 135
    //   291: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 9
    //   297: aload_2
    //   298: invokevirtual 136	java/io/IOException:toString	()Ljava/lang/String;
    //   301: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc 38
    //   307: iconst_1
    //   308: aload 9
    //   310: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 105	com/tencent/mobileqq/uftransfer/depend/UFTLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload_0
    //   317: getfield 107	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback	Lcom/tencent/mobileqq/uftransfer/common/transfer/upload/IUFTFtnUploaderCallback;
    //   320: sipush 9001
    //   323: ldc 133
    //   325: invokeinterface 114 3 0
    //   330: goto -85 -> 245
    //   333: aload_1
    //   334: invokevirtual 117	java/io/ByteArrayInputStream:close	()V
    //   337: aload 8
    //   339: invokevirtual 118	java/io/DataInputStream:close	()V
    //   342: goto +5 -> 347
    //   345: aload_2
    //   346: athrow
    //   347: goto -2 -> 345
    //   350: astore_1
    //   351: return
    //   352: astore_1
    //   353: return
    //   354: astore_1
    //   355: goto -13 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	UFTFtnUploader
    //   0	358	1	paramArrayOfByte	byte[]
    //   0	358	2	paramString	String
    //   33	184	3	i	int
    //   140	13	4	l1	long
    //   144	7	6	l2	long
    //   17	321	8	localDataInputStream	java.io.DataInputStream
    //   267	42	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	34	255	finally
    //   38	99	255	finally
    //   109	124	255	finally
    //   128	142	255	finally
    //   146	164	255	finally
    //   172	181	255	finally
    //   184	245	255	finally
    //   260	330	255	finally
    //   19	34	259	java/io/IOException
    //   38	99	259	java/io/IOException
    //   109	124	259	java/io/IOException
    //   128	142	259	java/io/IOException
    //   146	164	259	java/io/IOException
    //   172	181	259	java/io/IOException
    //   184	245	259	java/io/IOException
    //   99	108	350	java/lang/Exception
    //   245	254	352	java/lang/Exception
    //   333	342	354	java/lang/Exception
  }
  
  /* Error */
  private byte[] a(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_ArrayOfByte	[B
    //   4: arraylength
    //   5: iconst_2
    //   6: iadd
    //   7: iconst_2
    //   8: iadd
    //   9: aload_0
    //   10: getfield 34	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:b	[B
    //   13: arraylength
    //   14: iadd
    //   15: bipush 20
    //   17: iadd
    //   18: aload_3
    //   19: arraylength
    //   20: iadd
    //   21: istore 4
    //   23: new 139	java/io/ByteArrayOutputStream
    //   26: dup
    //   27: iload 4
    //   29: bipush 16
    //   31: iadd
    //   32: invokespecial 142	java/io/ByteArrayOutputStream:<init>	(I)V
    //   35: astore 5
    //   37: new 144	java/io/DataOutputStream
    //   40: dup
    //   41: aload 5
    //   43: invokespecial 147	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: astore 6
    //   48: aload 6
    //   50: ldc 148
    //   52: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   55: aload 6
    //   57: sipush 1007
    //   60: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   63: aload 6
    //   65: iconst_0
    //   66: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   69: aload 6
    //   71: iload 4
    //   73: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   76: aload 6
    //   78: aload_0
    //   79: getfield 30	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_ArrayOfByte	[B
    //   82: arraylength
    //   83: invokevirtual 154	java/io/DataOutputStream:writeShort	(I)V
    //   86: aload 6
    //   88: aload_0
    //   89: getfield 30	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_ArrayOfByte	[B
    //   92: invokevirtual 157	java/io/DataOutputStream:write	([B)V
    //   95: aload 6
    //   97: aload_0
    //   98: getfield 34	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:b	[B
    //   101: arraylength
    //   102: invokevirtual 154	java/io/DataOutputStream:writeShort	(I)V
    //   105: aload 6
    //   107: aload_0
    //   108: getfield 34	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:b	[B
    //   111: invokevirtual 157	java/io/DataOutputStream:write	([B)V
    //   114: aload 6
    //   116: aload_0
    //   117: getfield 18	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadUFTFtnUploader$UperProp	Lcom/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader$UperProp;
    //   120: getfield 158	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader$UperProp:jdField_a_of_type_Long	J
    //   123: ldc2_w 159
    //   126: land
    //   127: l2i
    //   128: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   131: aload 6
    //   133: lload_1
    //   134: ldc2_w 159
    //   137: land
    //   138: l2i
    //   139: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   142: aload 6
    //   144: aload_3
    //   145: arraylength
    //   146: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   149: aload 6
    //   151: aload_0
    //   152: getfield 18	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadUFTFtnUploader$UperProp	Lcom/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader$UperProp;
    //   155: getfield 158	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader$UperProp:jdField_a_of_type_Long	J
    //   158: bipush 32
    //   160: lshr
    //   161: l2i
    //   162: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   165: aload 6
    //   167: lload_1
    //   168: bipush 32
    //   170: lshr
    //   171: l2i
    //   172: invokevirtual 151	java/io/DataOutputStream:writeInt	(I)V
    //   175: aload 6
    //   177: aload_3
    //   178: iconst_0
    //   179: aload_3
    //   180: arraylength
    //   181: invokevirtual 163	java/io/DataOutputStream:write	([BII)V
    //   184: aload 5
    //   186: invokevirtual 167	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   189: astore_3
    //   190: aload 5
    //   192: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   195: aload 6
    //   197: invokevirtual 169	java/io/DataOutputStream:close	()V
    //   200: aload_3
    //   201: areturn
    //   202: astore_3
    //   203: goto +76 -> 279
    //   206: astore_3
    //   207: aload_3
    //   208: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   211: new 78	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   218: astore 7
    //   220: aload 7
    //   222: ldc 83
    //   224: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 7
    //   230: aload_0
    //   231: getfield 90	com/tencent/mobileqq/uftransfer/common/transfer/upload/UFTFtnUploader:jdField_a_of_type_Long	J
    //   234: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 7
    //   240: ldc 174
    //   242: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 7
    //   248: aload_3
    //   249: invokevirtual 136	java/io/IOException:toString	()Ljava/lang/String;
    //   252: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: ldc 38
    //   258: iconst_1
    //   259: aload 7
    //   261: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 105	com/tencent/mobileqq/uftransfer/depend/UFTLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aload 5
    //   269: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   272: aload 6
    //   274: invokevirtual 169	java/io/DataOutputStream:close	()V
    //   277: aconst_null
    //   278: areturn
    //   279: aload 5
    //   281: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   284: aload 6
    //   286: invokevirtual 169	java/io/DataOutputStream:close	()V
    //   289: aload_3
    //   290: athrow
    //   291: astore 5
    //   293: aload_3
    //   294: areturn
    //   295: astore_3
    //   296: goto -19 -> 277
    //   299: astore 5
    //   301: goto -12 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	UFTFtnUploader
    //   0	304	1	paramLong	long
    //   0	304	3	paramArrayOfByte	byte[]
    //   21	51	4	i	int
    //   35	245	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   291	1	5	localException1	java.lang.Exception
    //   299	1	5	localException2	java.lang.Exception
    //   46	239	6	localDataOutputStream	java.io.DataOutputStream
    //   218	42	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	190	202	finally
    //   207	267	202	finally
    //   48	190	206	java/io/IOException
    //   190	200	291	java/lang/Exception
    //   267	277	295	java/lang/Exception
    //   279	289	299	java/lang/Exception
  }
  
  public void a()
  {
    b();
  }
  
  public void a(IUFTFtnUploaderCallback paramIUFTFtnUploaderCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback = paramIUFTFtnUploaderCallback;
  }
  
  protected void a(UFTHttpCommunicator.UFTHttpErr paramUFTHttpErr)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] onError errCode:");
    localStringBuilder.append(paramUFTHttpErr.a());
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramUFTHttpErr.a());
    UFTLog.d("[UFTTransfer] UFTFtnDataUploader", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback.a(paramUFTHttpErr.a(), paramUFTHttpErr.a(), paramUFTHttpErr.b());
  }
  
  protected void a(UFTHttpCommunicator.UFTHttpRsp paramUFTHttpRsp)
  {
    a(paramUFTHttpRsp.a(), paramUFTHttpRsp.a());
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback.g_(paramString);
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramLong, paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      paramString = new StringBuilder();
      paramString.append("id[");
      paramString.append(this.jdField_a_of_type_Long);
      paramString.append("] sendData packageData return null");
      UFTLog.d("[UFTTransfer] UFTFtnDataUploader", 2, paramString.toString());
      return false;
    }
    UFTHttpCommunicator.UFTHttpReq localUFTHttpReq = new UFTHttpCommunicator.UFTHttpReq(paramString, paramArrayOfByte, false);
    localUFTHttpReq.a("POST");
    localUFTHttpReq.a(5);
    localUFTHttpReq.b(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadUFTFtnUploader$UperProp.jdField_b_of_type_Int);
    localUFTHttpReq.c(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadUFTFtnUploader$UperProp.jdField_a_of_type_Int);
    localUFTHttpReq.d(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadUFTFtnUploader$UperProp.d);
    if (paramString != null) {
      paramArrayOfByte = paramString.toLowerCase();
    } else {
      paramArrayOfByte = "";
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadUFTFtnUploader$UperProp.jdField_a_of_type_Boolean) && (paramArrayOfByte.startsWith("https")))
    {
      localUFTHttpReq.a(true);
      localUFTHttpReq.b(UFTHttpUrlProcessor.a(paramString));
      localUFTHttpReq.b(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadUFTFtnUploader$UperProp.c);
    }
    return a(localUFTHttpReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnUploader
 * JD-Core Version:    0.7.0.1
 */