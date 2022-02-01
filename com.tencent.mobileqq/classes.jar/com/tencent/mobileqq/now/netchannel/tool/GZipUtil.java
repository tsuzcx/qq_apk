package com.tencent.mobileqq.now.netchannel.tool;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GZipUtil
{
  private static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("GZipUtil", 2, "closeQuietly(), InputStream IOIOException: " + paramInputStream.getMessage());
    }
  }
  
  /* Error */
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: new 49	java/util/zip/GZIPInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 51	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore_0
    //   11: sipush 1024
    //   14: newarray byte
    //   16: astore 4
    //   18: aload_3
    //   19: astore_0
    //   20: aload_3
    //   21: aload 4
    //   23: iconst_0
    //   24: sipush 1024
    //   27: invokevirtual 55	java/util/zip/GZIPInputStream:read	([BII)I
    //   30: istore_2
    //   31: iload_2
    //   32: iconst_m1
    //   33: if_icmpeq +74 -> 107
    //   36: aload_3
    //   37: astore_0
    //   38: aload_1
    //   39: aload 4
    //   41: iconst_0
    //   42: iload_2
    //   43: invokevirtual 61	java/io/OutputStream:write	([BII)V
    //   46: goto -28 -> 18
    //   49: astore_0
    //   50: aload_3
    //   51: astore_1
    //   52: aload_0
    //   53: astore_3
    //   54: aload_1
    //   55: astore_0
    //   56: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +33 -> 92
    //   62: aload_1
    //   63: astore_0
    //   64: ldc 26
    //   66: iconst_2
    //   67: new 28	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   74: ldc 63
    //   76: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_3
    //   80: invokevirtual 39	java/io/IOException:getMessage	()Ljava/lang/String;
    //   83: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_1
    //   93: astore_0
    //   94: aload_3
    //   95: athrow
    //   96: astore_3
    //   97: aload_0
    //   98: astore_1
    //   99: aload_3
    //   100: astore_0
    //   101: aload_1
    //   102: invokestatic 65	com/tencent/mobileqq/now/netchannel/tool/GZipUtil:a	(Ljava/io/InputStream;)V
    //   105: aload_0
    //   106: athrow
    //   107: aload_3
    //   108: invokestatic 65	com/tencent/mobileqq/now/netchannel/tool/GZipUtil:a	(Ljava/io/InputStream;)V
    //   111: return
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_1
    //   115: goto -14 -> 101
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_1
    //   121: goto -67 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramInputStream	InputStream
    //   0	124	1	paramOutputStream	OutputStream
    //   30	13	2	i	int
    //   8	87	3	localObject	Object
    //   96	12	3	localInputStream	InputStream
    //   118	1	3	localIOException	IOException
    //   16	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	18	49	java/io/IOException
    //   20	31	49	java/io/IOException
    //   38	46	49	java/io/IOException
    //   11	18	96	finally
    //   20	31	96	finally
    //   38	46	96	finally
    //   56	62	96	finally
    //   64	92	96	finally
    //   94	96	96	finally
    //   0	9	112	finally
    //   0	9	118	java/io/IOException
  }
  
  private static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("GZipUtil", 2, "closeQuietly(), OutputStream IOIOException: " + paramOutputStream.getMessage());
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      a(paramArrayOfByte, localByteArrayOutputStream);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.flush();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GZipUtil", 2, "decompress(), IOIOException: " + localIOException.getMessage());
      }
      throw localIOException;
    }
    finally
    {
      a(localByteArrayOutputStream);
      a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.tool.GZipUtil
 * JD-Core Version:    0.7.0.1
 */