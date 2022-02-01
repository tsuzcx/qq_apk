package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegDataDest;
import java.io.File;

final class Utils$1
  implements JpegDataDest
{
  Utils$1(File paramFile, CompressInfo paramCompressInfo) {}
  
  /* Error */
  public void dataArrived(java.nio.ByteBuffer paramByteBuffer, boolean paramBoolean, Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 25	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: getfield 13	com/tencent/mobileqq/pic/compress/Utils$1:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   13: iconst_1
    //   14: invokespecial 28	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   17: invokevirtual 32	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   20: astore 5
    //   22: aload 5
    //   24: astore_3
    //   25: aload 5
    //   27: astore 4
    //   29: aload 5
    //   31: aload_1
    //   32: invokevirtual 38	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   35: pop
    //   36: aload 5
    //   38: ifnull +91 -> 129
    //   41: iload_2
    //   42: ifeq +76 -> 118
    //   45: aload 5
    //   47: iconst_1
    //   48: invokevirtual 42	java/nio/channels/FileChannel:force	(Z)V
    //   51: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +64 -> 118
    //   57: new 50	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   64: astore_1
    //   65: aload_1
    //   66: ldc 53
    //   68: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_1
    //   73: aload_0
    //   74: getfield 13	com/tencent/mobileqq/pic/compress/Utils$1:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   77: invokevirtual 63	java/io/File:length	()J
    //   80: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc 68
    //   86: iconst_2
    //   87: aload_1
    //   88: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 76	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: goto +24 -> 118
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   102: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +13 -> 118
    //   108: ldc 68
    //   110: iconst_2
    //   111: aload_1
    //   112: invokevirtual 80	java/io/IOException:toString	()Ljava/lang/String;
    //   115: invokestatic 76	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload 5
    //   120: invokevirtual 83	java/nio/channels/FileChannel:close	()V
    //   123: return
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   129: return
    //   130: astore_1
    //   131: goto +118 -> 249
    //   134: aload 4
    //   136: astore_3
    //   137: aload_0
    //   138: getfield 15	com/tencent/mobileqq/pic/compress/Utils$1:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   141: ifnull +14 -> 155
    //   144: aload 4
    //   146: astore_3
    //   147: aload_0
    //   148: getfield 15	com/tencent/mobileqq/pic/compress/Utils$1:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   151: iconst_1
    //   152: invokevirtual 88	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   155: aload 4
    //   157: ifnull +91 -> 248
    //   160: iload_2
    //   161: ifeq +76 -> 237
    //   164: aload 4
    //   166: iconst_1
    //   167: invokevirtual 42	java/nio/channels/FileChannel:force	(Z)V
    //   170: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +64 -> 237
    //   176: new 50	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   183: astore_1
    //   184: aload_1
    //   185: ldc 53
    //   187: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: aload_0
    //   193: getfield 13	com/tencent/mobileqq/pic/compress/Utils$1:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   196: invokevirtual 63	java/io/File:length	()J
    //   199: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: ldc 68
    //   205: iconst_2
    //   206: aload_1
    //   207: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 76	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: goto +24 -> 237
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   221: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +13 -> 237
    //   227: ldc 68
    //   229: iconst_2
    //   230: aload_1
    //   231: invokevirtual 80	java/io/IOException:toString	()Ljava/lang/String;
    //   234: invokestatic 76	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload 4
    //   239: invokevirtual 83	java/nio/channels/FileChannel:close	()V
    //   242: return
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   248: return
    //   249: aload_3
    //   250: ifnull +98 -> 348
    //   253: iload_2
    //   254: ifeq +82 -> 336
    //   257: aload_3
    //   258: iconst_1
    //   259: invokevirtual 42	java/nio/channels/FileChannel:force	(Z)V
    //   262: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +71 -> 336
    //   268: new 50	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   275: astore 4
    //   277: aload 4
    //   279: ldc 53
    //   281: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 4
    //   287: aload_0
    //   288: getfield 13	com/tencent/mobileqq/pic/compress/Utils$1:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   291: invokevirtual 63	java/io/File:length	()J
    //   294: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: ldc 68
    //   300: iconst_2
    //   301: aload 4
    //   303: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 76	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: goto +27 -> 336
    //   312: astore 4
    //   314: aload 4
    //   316: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   319: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +14 -> 336
    //   325: ldc 68
    //   327: iconst_2
    //   328: aload 4
    //   330: invokevirtual 80	java/io/IOException:toString	()Ljava/lang/String;
    //   333: invokestatic 76	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_3
    //   337: invokevirtual 83	java/nio/channels/FileChannel:close	()V
    //   340: goto +8 -> 348
    //   343: astore_3
    //   344: aload_3
    //   345: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   348: aload_1
    //   349: athrow
    //   350: astore_1
    //   351: goto -217 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	1
    //   0	354	1	paramByteBuffer	java.nio.ByteBuffer
    //   0	354	2	paramBoolean	boolean
    //   0	354	3	paramObject	Object
    //   1	301	4	localObject	Object
    //   312	17	4	localIOException	java.io.IOException
    //   20	99	5	localFileChannel	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   45	94	97	java/io/IOException
    //   118	123	124	java/io/IOException
    //   5	22	130	finally
    //   29	36	130	finally
    //   137	144	130	finally
    //   147	155	130	finally
    //   164	213	216	java/io/IOException
    //   237	242	243	java/io/IOException
    //   257	309	312	java/io/IOException
    //   336	340	343	java/io/IOException
    //   5	22	350	java/io/IOException
    //   29	36	350	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.Utils.1
 * JD-Core Version:    0.7.0.1
 */