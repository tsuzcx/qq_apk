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
    InflaterInputStream localInflaterInputStream = new InflaterInputStream(paramInputStream);
    int i = 1024;
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
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 67	java/util/zip/Deflater:reset	()V
    //   12: aload_3
    //   13: aload_0
    //   14: invokevirtual 71	java/util/zip/Deflater:setInput	([B)V
    //   17: aload_3
    //   18: invokevirtual 72	java/util/zip/Deflater:finish	()V
    //   21: new 45	java/io/ByteArrayOutputStream
    //   24: dup
    //   25: aload_0
    //   26: arraylength
    //   27: invokespecial 48	java/io/ByteArrayOutputStream:<init>	(I)V
    //   30: astore 4
    //   32: sipush 1024
    //   35: newarray byte
    //   37: astore_1
    //   38: aload_3
    //   39: invokevirtual 76	java/util/zip/Deflater:finished	()Z
    //   42: ifne +18 -> 60
    //   45: aload 4
    //   47: aload_1
    //   48: iconst_0
    //   49: aload_3
    //   50: aload_1
    //   51: invokevirtual 80	java/util/zip/Deflater:deflate	([B)I
    //   54: invokevirtual 53	java/io/ByteArrayOutputStream:write	([BII)V
    //   57: goto -19 -> 38
    //   60: aload 4
    //   62: invokevirtual 60	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   65: astore_2
    //   66: aload_2
    //   67: astore_1
    //   68: aload 4
    //   70: invokevirtual 83	java/io/ByteArrayOutputStream:close	()V
    //   73: aload_2
    //   74: astore_0
    //   75: goto +29 -> 104
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   83: aload_1
    //   84: astore_0
    //   85: goto +19 -> 104
    //   88: astore_0
    //   89: goto +21 -> 110
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   97: aload_0
    //   98: astore_1
    //   99: aload 4
    //   101: invokevirtual 83	java/io/ByteArrayOutputStream:close	()V
    //   104: aload_3
    //   105: invokevirtual 87	java/util/zip/Deflater:end	()V
    //   108: aload_0
    //   109: areturn
    //   110: aload 4
    //   112: invokevirtual 83	java/io/ByteArrayOutputStream:close	()V
    //   115: goto +8 -> 123
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   123: goto +5 -> 128
    //   126: aload_0
    //   127: athrow
    //   128: goto -2 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramArrayOfByte	byte[]
    //   37	47	1	localObject	Object
    //   92	2	1	localException	Exception
    //   98	1	1	arrayOfByte1	byte[]
    //   118	2	1	localIOException	IOException
    //   65	9	2	arrayOfByte2	byte[]
    //   7	98	3	localDeflater	java.util.zip.Deflater
    //   30	81	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   68	73	78	java/io/IOException
    //   99	104	78	java/io/IOException
    //   32	38	88	finally
    //   38	57	88	finally
    //   60	66	88	finally
    //   93	97	88	finally
    //   32	38	92	java/lang/Exception
    //   38	57	92	java/lang/Exception
    //   60	66	92	java/lang/Exception
    //   110	115	118	java/io/IOException
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
    //   37: ifne +17 -> 54
    //   40: aload_0
    //   41: aload_2
    //   42: iconst_0
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 97	java/util/zip/Inflater:inflate	([B)I
    //   48: invokevirtual 53	java/io/ByteArrayOutputStream:write	([BII)V
    //   51: goto -18 -> 33
    //   54: aload_0
    //   55: invokevirtual 60	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   58: astore_2
    //   59: aload_0
    //   60: invokevirtual 83	java/io/ByteArrayOutputStream:close	()V
    //   63: aload_1
    //   64: invokevirtual 98	java/util/zip/Inflater:end	()V
    //   67: aload_2
    //   68: areturn
    //   69: astore_0
    //   70: new 30	java/lang/Exception
    //   73: dup
    //   74: aload_0
    //   75: invokevirtual 34	java/io/IOException:toString	()Ljava/lang/String;
    //   78: invokespecial 37	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   81: athrow
    //   82: astore_1
    //   83: goto +16 -> 99
    //   86: astore_1
    //   87: new 30	java/lang/Exception
    //   90: dup
    //   91: aload_1
    //   92: invokevirtual 99	java/lang/Exception:toString	()Ljava/lang/String;
    //   95: invokespecial 37	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   98: athrow
    //   99: aload_0
    //   100: invokevirtual 83	java/io/ByteArrayOutputStream:close	()V
    //   103: aload_1
    //   104: athrow
    //   105: astore_0
    //   106: new 30	java/lang/Exception
    //   109: dup
    //   110: aload_0
    //   111: invokevirtual 34	java/io/IOException:toString	()Ljava/lang/String;
    //   114: invokespecial 37	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   117: astore_0
    //   118: goto +5 -> 123
    //   121: aload_0
    //   122: athrow
    //   123: goto -2 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramArrayOfByte	byte[]
    //   7	57	1	localInflater	java.util.zip.Inflater
    //   82	1	1	localObject	Object
    //   86	18	1	localException	Exception
    //   32	36	2	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   59	63	69	java/io/IOException
    //   27	33	82	finally
    //   33	51	82	finally
    //   54	59	82	finally
    //   87	99	82	finally
    //   27	33	86	java/lang/Exception
    //   33	51	86	java/lang/Exception
    //   54	59	86	java/lang/Exception
    //   99	103	105	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.j
 * JD-Core Version:    0.7.0.1
 */