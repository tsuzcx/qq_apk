package com.tencent.mobileqq.now.netchannel.tool;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GZipUtil
{
  private static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramInputStream)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("closeQuietly(), InputStream IOIOException: ");
          localStringBuilder.append(paramInputStream.getMessage());
          QLog.e("GZipUtil", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  /* Error */
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 49	java/util/zip/GZIPInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 51	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   13: astore_0
    //   14: sipush 1024
    //   17: newarray byte
    //   19: astore_3
    //   20: aload_0
    //   21: aload_3
    //   22: iconst_0
    //   23: sipush 1024
    //   26: invokevirtual 55	java/util/zip/GZIPInputStream:read	([BII)I
    //   29: istore_2
    //   30: iload_2
    //   31: iconst_m1
    //   32: if_icmpeq +13 -> 45
    //   35: aload_1
    //   36: aload_3
    //   37: iconst_0
    //   38: iload_2
    //   39: invokevirtual 61	java/io/OutputStream:write	([BII)V
    //   42: goto -22 -> 20
    //   45: aload_0
    //   46: invokestatic 63	com/tencent/mobileqq/now/netchannel/tool/GZipUtil:a	(Ljava/io/InputStream;)V
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: astore_3
    //   53: aload_1
    //   54: astore_0
    //   55: goto +73 -> 128
    //   58: astore_1
    //   59: goto +11 -> 70
    //   62: astore_0
    //   63: goto +65 -> 128
    //   66: astore_1
    //   67: aload 4
    //   69: astore_0
    //   70: aload_0
    //   71: astore_3
    //   72: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +49 -> 124
    //   78: aload_0
    //   79: astore_3
    //   80: new 26	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   87: astore 4
    //   89: aload_0
    //   90: astore_3
    //   91: aload 4
    //   93: ldc 65
    //   95: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_0
    //   100: astore_3
    //   101: aload 4
    //   103: aload_1
    //   104: invokevirtual 37	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_0
    //   112: astore_3
    //   113: ldc 39
    //   115: iconst_2
    //   116: aload 4
    //   118: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload_0
    //   125: astore_3
    //   126: aload_1
    //   127: athrow
    //   128: aload_3
    //   129: invokestatic 63	com/tencent/mobileqq/now/netchannel/tool/GZipUtil:a	(Ljava/io/InputStream;)V
    //   132: goto +5 -> 137
    //   135: aload_0
    //   136: athrow
    //   137: goto -2 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramInputStream	InputStream
    //   0	140	1	paramOutputStream	OutputStream
    //   29	10	2	i	int
    //   4	125	3	localObject	Object
    //   1	116	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	20	50	finally
    //   20	30	50	finally
    //   35	42	50	finally
    //   14	20	58	java/io/IOException
    //   20	30	58	java/io/IOException
    //   35	42	58	java/io/IOException
    //   5	14	62	finally
    //   72	78	62	finally
    //   80	89	62	finally
    //   91	99	62	finally
    //   101	111	62	finally
    //   113	124	62	finally
    //   126	128	62	finally
    //   5	14	66	java/io/IOException
  }
  
  private static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {
      try
      {
        paramOutputStream.close();
        return;
      }
      catch (IOException paramOutputStream)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("closeQuietly(), OutputStream IOIOException: ");
          localStringBuilder.append(paramOutputStream.getMessage());
          QLog.e("GZipUtil", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 72	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 75	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 77	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 78	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokestatic 80	com/tencent/mobileqq/now/netchannel/tool/GZipUtil:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   22: aload_1
    //   23: invokevirtual 84	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   26: astore_2
    //   27: aload_1
    //   28: invokevirtual 87	java/io/ByteArrayOutputStream:flush	()V
    //   31: aload_1
    //   32: invokestatic 89	com/tencent/mobileqq/now/netchannel/tool/GZipUtil:a	(Ljava/io/OutputStream;)V
    //   35: aload_0
    //   36: invokestatic 63	com/tencent/mobileqq/now/netchannel/tool/GZipUtil:a	(Ljava/io/InputStream;)V
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: goto +46 -> 88
    //   45: astore_2
    //   46: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +37 -> 86
    //   52: new 26	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   59: astore_3
    //   60: aload_3
    //   61: ldc 65
    //   63: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_3
    //   68: aload_2
    //   69: invokevirtual 37	java/io/IOException:getMessage	()Ljava/lang/String;
    //   72: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: ldc 39
    //   78: iconst_2
    //   79: aload_3
    //   80: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 46	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload_2
    //   87: athrow
    //   88: aload_1
    //   89: invokestatic 89	com/tencent/mobileqq/now/netchannel/tool/GZipUtil:a	(Ljava/io/OutputStream;)V
    //   92: aload_0
    //   93: invokestatic 63	com/tencent/mobileqq/now/netchannel/tool/GZipUtil:a	(Ljava/io/InputStream;)V
    //   96: aload_2
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramArrayOfByte	byte[]
    //   16	73	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   26	14	2	arrayOfByte	byte[]
    //   41	1	2	localObject	Object
    //   45	52	2	localIOException	IOException
    //   59	21	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	31	41	finally
    //   46	86	41	finally
    //   86	88	41	finally
    //   17	31	45	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.tool.GZipUtil
 * JD-Core Version:    0.7.0.1
 */