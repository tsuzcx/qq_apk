package com.tencent.qphone.base.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public abstract class j
{
  public static void a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    paramOutputStream = new DeflaterOutputStream(paramOutputStream);
    try
    {
      paramOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramOutputStream.finish();
      paramOutputStream.flush();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new Exception(paramArrayOfByte.toString());
    }
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    int i = 1024;
    InflaterInputStream localInflaterInputStream = new InflaterInputStream(paramInputStream);
    paramInputStream = new ByteArrayOutputStream(1024);
    try
    {
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        i = localInflaterInputStream.read(arrayOfByte, 0, i);
        if (i <= 0) {
          break;
        }
        paramInputStream.write(arrayOfByte, 0, i);
      }
      return paramInputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 63	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 64	java/util/zip/Deflater:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 67	java/util/zip/Deflater:reset	()V
    //   12: aload_2
    //   13: aload_0
    //   14: invokevirtual 71	java/util/zip/Deflater:setInput	([B)V
    //   17: aload_2
    //   18: invokevirtual 72	java/util/zip/Deflater:finish	()V
    //   21: new 45	java/io/ByteArrayOutputStream
    //   24: dup
    //   25: aload_0
    //   26: arraylength
    //   27: invokespecial 48	java/io/ByteArrayOutputStream:<init>	(I)V
    //   30: astore_3
    //   31: sipush 1024
    //   34: newarray byte
    //   36: astore_1
    //   37: aload_2
    //   38: invokevirtual 76	java/util/zip/Deflater:finished	()Z
    //   41: ifne +32 -> 73
    //   44: aload_3
    //   45: aload_1
    //   46: iconst_0
    //   47: aload_2
    //   48: aload_1
    //   49: invokevirtual 80	java/util/zip/Deflater:deflate	([B)I
    //   52: invokevirtual 53	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -18 -> 37
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 81	java/lang/Exception:printStackTrace	()V
    //   63: aload_3
    //   64: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   67: aload_2
    //   68: invokevirtual 87	java/util/zip/Deflater:end	()V
    //   71: aload_0
    //   72: areturn
    //   73: aload_3
    //   74: invokevirtual 60	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: aload_3
    //   81: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   84: goto -17 -> 67
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   92: goto -25 -> 67
    //   95: astore_0
    //   96: aload_3
    //   97: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   100: aload_0
    //   101: athrow
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   107: goto -7 -> 100
    //   110: astore_1
    //   111: goto -23 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramArrayOfByte	byte[]
    //   36	13	1	arrayOfByte1	byte[]
    //   58	2	1	localException	Exception
    //   77	2	1	arrayOfByte2	byte[]
    //   87	2	1	localIOException1	IOException
    //   102	2	1	localIOException2	IOException
    //   110	1	1	localIOException3	IOException
    //   7	61	2	localDeflater	java.util.zip.Deflater
    //   30	67	3	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	37	58	java/lang/Exception
    //   37	55	58	java/lang/Exception
    //   73	78	58	java/lang/Exception
    //   80	84	87	java/io/IOException
    //   31	37	95	finally
    //   37	55	95	finally
    //   59	63	95	finally
    //   73	78	95	finally
    //   96	100	102	java/io/IOException
    //   63	67	110	java/io/IOException
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 90	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 91	java/util/zip/Inflater:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 92	java/util/zip/Inflater:reset	()V
    //   12: aload_1
    //   13: aload_0
    //   14: invokevirtual 93	java/util/zip/Inflater:setInput	([B)V
    //   17: new 45	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: aload_0
    //   22: arraylength
    //   23: invokespecial 48	java/io/ByteArrayOutputStream:<init>	(I)V
    //   26: astore_0
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 94	java/util/zip/Inflater:finished	()Z
    //   37: ifne +37 -> 74
    //   40: aload_0
    //   41: aload_2
    //   42: iconst_0
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 97	java/util/zip/Inflater:inflate	([B)I
    //   48: invokevirtual 53	java/io/ByteArrayOutputStream:write	([BII)V
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: new 30	java/lang/Exception
    //   58: dup
    //   59: aload_1
    //   60: invokevirtual 98	java/lang/Exception:toString	()Ljava/lang/String;
    //   63: invokespecial 37	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   66: athrow
    //   67: astore_1
    //   68: aload_0
    //   69: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_1
    //   73: athrow
    //   74: aload_0
    //   75: invokevirtual 60	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   78: astore_2
    //   79: aload_0
    //   80: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   83: aload_1
    //   84: invokevirtual 99	java/util/zip/Inflater:end	()V
    //   87: aload_2
    //   88: areturn
    //   89: astore_0
    //   90: new 30	java/lang/Exception
    //   93: dup
    //   94: aload_0
    //   95: invokevirtual 34	java/io/IOException:toString	()Ljava/lang/String;
    //   98: invokespecial 37	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   101: athrow
    //   102: astore_0
    //   103: new 30	java/lang/Exception
    //   106: dup
    //   107: aload_0
    //   108: invokevirtual 34	java/io/IOException:toString	()Ljava/lang/String;
    //   111: invokespecial 37	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramArrayOfByte	byte[]
    //   7	37	1	localInflater	java.util.zip.Inflater
    //   54	6	1	localException	Exception
    //   67	17	1	localObject	Object
    //   32	56	2	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	33	54	java/lang/Exception
    //   33	51	54	java/lang/Exception
    //   74	79	54	java/lang/Exception
    //   27	33	67	finally
    //   33	51	67	finally
    //   55	67	67	finally
    //   74	79	67	finally
    //   68	72	89	java/io/IOException
    //   79	83	102	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.j
 * JD-Core Version:    0.7.0.1
 */