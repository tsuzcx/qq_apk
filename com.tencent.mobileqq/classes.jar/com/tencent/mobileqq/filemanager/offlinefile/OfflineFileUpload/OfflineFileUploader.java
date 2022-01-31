package com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload;

import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.transfile.NetResp;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class OfflineFileUploader
  implements IOfflineFileHttpUploderSink
{
  long jdField_a_of_type_Long;
  FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = null;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public long a(NetResp paramNetResp)
  {
    paramNetResp = new ByteArrayInputStream(paramNetResp.a);
    DataInputStream localDataInputStream = new DataInputStream(paramNetResp);
    try
    {
      localDataInputStream.skip(4L);
      if (localDataInputStream.readInt() != 0) {
        b();
      }
    }
    catch (IOException localIOException)
    {
      int i;
      int j;
      long l;
      localIOException.printStackTrace();
    }
    finally
    {
      try
      {
        paramNetResp.close();
        localDataInputStream.close();
        return -1L;
        localObject = finally;
        try
        {
          paramNetResp.close();
          localDataInputStream.close();
          throw localObject;
        }
        catch (Exception paramNetResp)
        {
          break label187;
        }
      }
      catch (Exception paramNetResp)
      {
        break label172;
      }
    }
    try
    {
      paramNetResp.close();
      localDataInputStream.close();
      return 0L;
    }
    catch (Exception paramNetResp) {}
    localDataInputStream.skip(8L);
    i = localDataInputStream.readByte();
    if (i == 0)
    {
      i = localDataInputStream.readInt();
      j = localDataInputStream.readInt();
      l = j;
      l = i | l << 32;
      try
      {
        paramNetResp.close();
        localDataInputStream.close();
        return l;
      }
      catch (Exception paramNetResp)
      {
        return l;
      }
    }
    if (i == 1)
    {
      a();
      try
      {
        paramNetResp.close();
        localDataInputStream.close();
        return 0L;
      }
      catch (Exception paramNetResp)
      {
        return 0L;
      }
    }
    b();
    try
    {
      paramNetResp.close();
      localDataInputStream.close();
      return 0L;
    }
    catch (Exception paramNetResp)
    {
      return 0L;
    }
    label172:
    label187:
    return 0L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver.a();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver.a(paramLong1, paramLong2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, FileTransferObserver paramFileTransferObserver)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = paramFileTransferObserver;
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
    //   22: getfield 77	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   25: ifnull +26 -> 51
    //   28: aload 5
    //   30: ifnull +21 -> 51
    //   33: aload_0
    //   34: getfield 77	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokevirtual 90	java/lang/String:length	()I
    //   40: ifeq +11 -> 51
    //   43: aload 5
    //   45: invokevirtual 90	java/lang/String:length	()I
    //   48: ifne +23 -> 71
    //   51: invokestatic 96	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   54: ifeq +11 -> 65
    //   57: new 98	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 99	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: aload_0
    //   66: invokevirtual 51	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:b	()V
    //   69: aconst_null
    //   70: areturn
    //   71: aload 5
    //   73: invokestatic 105	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   76: astore 7
    //   78: aload_0
    //   79: getfield 77	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   82: invokestatic 105	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   85: astore 8
    //   87: aload 8
    //   89: arraylength
    //   90: iconst_2
    //   91: iadd
    //   92: iconst_2
    //   93: iadd
    //   94: aload 7
    //   96: arraylength
    //   97: iadd
    //   98: bipush 20
    //   100: iadd
    //   101: aload_1
    //   102: arraylength
    //   103: iadd
    //   104: istore 4
    //   106: new 107	java/io/ByteArrayOutputStream
    //   109: dup
    //   110: iload 4
    //   112: bipush 16
    //   114: iadd
    //   115: invokespecial 110	java/io/ByteArrayOutputStream:<init>	(I)V
    //   118: astore 5
    //   120: new 112	java/io/DataOutputStream
    //   123: dup
    //   124: aload 5
    //   126: invokespecial 115	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   129: astore 6
    //   131: aload 6
    //   133: ldc 116
    //   135: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   138: aload 6
    //   140: sipush 1007
    //   143: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   146: aload 6
    //   148: iconst_0
    //   149: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   152: aload 6
    //   154: iload 4
    //   156: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   159: aload 6
    //   161: aload 8
    //   163: arraylength
    //   164: invokevirtual 122	java/io/DataOutputStream:writeShort	(I)V
    //   167: aload 6
    //   169: aload 8
    //   171: invokevirtual 125	java/io/DataOutputStream:write	([B)V
    //   174: aload 6
    //   176: aload 7
    //   178: arraylength
    //   179: invokevirtual 122	java/io/DataOutputStream:writeShort	(I)V
    //   182: aload 6
    //   184: aload 7
    //   186: invokevirtual 125	java/io/DataOutputStream:write	([B)V
    //   189: aload 6
    //   191: aload_0
    //   192: getfield 83	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_Long	J
    //   195: ldc2_w 126
    //   198: land
    //   199: l2i
    //   200: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   203: aload 6
    //   205: lload_2
    //   206: ldc2_w 126
    //   209: land
    //   210: l2i
    //   211: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   214: aload 6
    //   216: aload_1
    //   217: arraylength
    //   218: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   221: aload 6
    //   223: aload_0
    //   224: getfield 83	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_Long	J
    //   227: bipush 32
    //   229: lshr
    //   230: l2i
    //   231: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   234: aload 6
    //   236: lload_2
    //   237: bipush 32
    //   239: lshr
    //   240: l2i
    //   241: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   244: aload 6
    //   246: aload_1
    //   247: iconst_0
    //   248: aload_1
    //   249: arraylength
    //   250: invokevirtual 130	java/io/DataOutputStream:write	([BII)V
    //   253: aload 5
    //   255: invokevirtual 134	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   258: astore_1
    //   259: aload 5
    //   261: invokevirtual 135	java/io/ByteArrayOutputStream:close	()V
    //   264: aload 6
    //   266: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   269: aload_1
    //   270: areturn
    //   271: astore 5
    //   273: aload_1
    //   274: areturn
    //   275: astore_1
    //   276: aload_0
    //   277: invokevirtual 51	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:b	()V
    //   280: aload 5
    //   282: invokevirtual 135	java/io/ByteArrayOutputStream:close	()V
    //   285: aload 6
    //   287: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   290: aconst_null
    //   291: areturn
    //   292: astore_1
    //   293: aload 5
    //   295: invokevirtual 135	java/io/ByteArrayOutputStream:close	()V
    //   298: aload 6
    //   300: invokevirtual 136	java/io/DataOutputStream:close	()V
    //   303: aload_1
    //   304: athrow
    //   305: astore 5
    //   307: goto -4 -> 303
    //   310: astore_1
    //   311: goto -21 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	OfflineFileUploader
    //   0	314	1	paramArrayOfByte	byte[]
    //   0	314	2	paramLong	long
    //   104	51	4	i	int
    //   8	252	5	localObject1	Object
    //   271	23	5	localException1	Exception
    //   305	1	5	localException2	Exception
    //   4	295	6	localObject2	Object
    //   76	109	7	arrayOfByte1	byte[]
    //   85	85	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   259	269	271	java/lang/Exception
    //   131	259	275	java/io/IOException
    //   131	259	292	finally
    //   276	280	292	finally
    //   293	303	305	java/lang/Exception
    //   280	290	310	java/lang/Exception
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploader
 * JD-Core Version:    0.7.0.1
 */