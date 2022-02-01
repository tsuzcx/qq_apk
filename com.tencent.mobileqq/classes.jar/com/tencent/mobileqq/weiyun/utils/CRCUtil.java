package com.tencent.mobileqq.weiyun.utils;

public class CRCUtil
{
  /* Error */
  public static long a(java.lang.String paramString, long paramLong)
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray byte
    //   5: astore 11
    //   7: new 15	java/util/zip/CRC32
    //   10: dup
    //   11: invokespecial 16	java/util/zip/CRC32:<init>	()V
    //   14: astore 12
    //   16: new 18	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 21	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: lload_1
    //   26: lstore 5
    //   28: lconst_0
    //   29: lstore 7
    //   31: aload_0
    //   32: aload 11
    //   34: invokevirtual 27	java/io/InputStream:read	([B)I
    //   37: istore 4
    //   39: iload 4
    //   41: ifle +52 -> 93
    //   44: iload 4
    //   46: istore_3
    //   47: lload 5
    //   49: iload 4
    //   51: i2l
    //   52: lcmp
    //   53: ifge +7 -> 60
    //   56: lload 5
    //   58: l2i
    //   59: istore_3
    //   60: aload 12
    //   62: aload 11
    //   64: iconst_0
    //   65: iload_3
    //   66: invokevirtual 31	java/util/zip/CRC32:update	([BII)V
    //   69: lload 7
    //   71: iload_3
    //   72: i2l
    //   73: ladd
    //   74: lstore 7
    //   76: lload_1
    //   77: lload 7
    //   79: lsub
    //   80: lstore 9
    //   82: lload 9
    //   84: lstore 5
    //   86: lload 9
    //   88: lconst_0
    //   89: lcmp
    //   90: ifgt -59 -> 31
    //   93: aload_0
    //   94: invokevirtual 34	java/io/InputStream:close	()V
    //   97: aload 12
    //   99: invokevirtual 38	java/util/zip/CRC32:getValue	()J
    //   102: lstore_1
    //   103: aload_0
    //   104: invokevirtual 34	java/io/InputStream:close	()V
    //   107: lload_1
    //   108: lreturn
    //   109: astore 12
    //   111: aload_0
    //   112: astore 11
    //   114: aload 12
    //   116: astore_0
    //   117: goto +10 -> 127
    //   120: goto +21 -> 141
    //   123: astore_0
    //   124: aconst_null
    //   125: astore 11
    //   127: aload 11
    //   129: ifnull +8 -> 137
    //   132: aload 11
    //   134: invokevirtual 34	java/io/InputStream:close	()V
    //   137: aload_0
    //   138: athrow
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 34	java/io/InputStream:close	()V
    //   149: lconst_0
    //   150: lreturn
    //   151: astore_0
    //   152: goto -13 -> 139
    //   155: astore 11
    //   157: goto -37 -> 120
    //   160: astore_0
    //   161: lload_1
    //   162: lreturn
    //   163: astore 11
    //   165: goto -28 -> 137
    //   168: astore_0
    //   169: lconst_0
    //   170: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramString	java.lang.String
    //   0	171	1	paramLong	long
    //   46	26	3	i	int
    //   37	13	4	j	int
    //   26	59	5	l1	long
    //   29	49	7	l2	long
    //   80	7	9	l3	long
    //   5	128	11	localObject1	Object
    //   155	1	11	localIOException1	java.io.IOException
    //   163	1	11	localIOException2	java.io.IOException
    //   14	84	12	localCRC32	java.util.zip.CRC32
    //   109	6	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	39	109	finally
    //   60	69	109	finally
    //   93	103	109	finally
    //   16	25	123	finally
    //   16	25	151	java/io/IOException
    //   31	39	155	java/io/IOException
    //   60	69	155	java/io/IOException
    //   93	103	155	java/io/IOException
    //   103	107	160	java/io/IOException
    //   132	137	163	java/io/IOException
    //   145	149	168	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.utils.CRCUtil
 * JD-Core Version:    0.7.0.1
 */