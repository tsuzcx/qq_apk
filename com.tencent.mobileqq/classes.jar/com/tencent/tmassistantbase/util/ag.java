package com.tencent.tmassistantbase.util;

public class ag
{
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 10	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 14	java/util/zip/Deflater:<init>	()V
    //   7: astore_2
    //   8: new 16	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: aload_0
    //   13: arraylength
    //   14: invokespecial 19	java/io/ByteArrayOutputStream:<init>	(I)V
    //   17: astore_1
    //   18: aload_2
    //   19: bipush 9
    //   21: invokevirtual 22	java/util/zip/Deflater:setLevel	(I)V
    //   24: aload_2
    //   25: aload_0
    //   26: invokevirtual 26	java/util/zip/Deflater:setInput	([B)V
    //   29: aload_2
    //   30: invokevirtual 29	java/util/zip/Deflater:finish	()V
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_0
    //   39: aload_2
    //   40: invokevirtual 33	java/util/zip/Deflater:finished	()Z
    //   43: ifne +17 -> 60
    //   46: aload_1
    //   47: aload_0
    //   48: iconst_0
    //   49: aload_2
    //   50: aload_0
    //   51: invokevirtual 37	java/util/zip/Deflater:deflate	([B)I
    //   54: invokevirtual 41	java/io/ByteArrayOutputStream:write	([BII)V
    //   57: goto -18 -> 39
    //   60: aload_2
    //   61: invokevirtual 44	java/util/zip/Deflater:end	()V
    //   64: aload_1
    //   65: invokevirtual 47	java/io/ByteArrayOutputStream:close	()V
    //   68: goto +8 -> 76
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 50	java/io/IOException:printStackTrace	()V
    //   76: aload_1
    //   77: invokevirtual 54	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   80: areturn
    //   81: astore_0
    //   82: goto +6 -> 88
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_1
    //   88: aload_2
    //   89: invokevirtual 44	java/util/zip/Deflater:end	()V
    //   92: aload_1
    //   93: ifnull +15 -> 108
    //   96: aload_1
    //   97: invokevirtual 47	java/io/ByteArrayOutputStream:close	()V
    //   100: goto +8 -> 108
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 50	java/io/IOException:printStackTrace	()V
    //   108: goto +5 -> 113
    //   111: aload_0
    //   112: athrow
    //   113: goto -2 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramArrayOfByte	byte[]
    //   17	80	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   103	2	1	localIOException	java.io.IOException
    //   7	82	2	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   64	68	71	java/io/IOException
    //   18	39	81	finally
    //   39	57	81	finally
    //   8	18	85	finally
    //   96	100	103	java/io/IOException
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 60	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 61	java/util/zip/Inflater:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: new 16	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: aload_0
    //   18: arraylength
    //   19: invokespecial 19	java/io/ByteArrayOutputStream:<init>	(I)V
    //   22: astore_1
    //   23: sipush 1024
    //   26: newarray byte
    //   28: astore_2
    //   29: aload 4
    //   31: aload_0
    //   32: invokevirtual 62	java/util/zip/Inflater:setInput	([B)V
    //   35: aload 4
    //   37: invokevirtual 63	java/util/zip/Inflater:finished	()Z
    //   40: ifne +18 -> 58
    //   43: aload_1
    //   44: aload_2
    //   45: iconst_0
    //   46: aload 4
    //   48: aload_2
    //   49: invokevirtual 66	java/util/zip/Inflater:inflate	([B)I
    //   52: invokevirtual 41	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -20 -> 35
    //   58: aload 4
    //   60: invokevirtual 67	java/util/zip/Inflater:end	()V
    //   63: aload_1
    //   64: invokevirtual 47	java/io/ByteArrayOutputStream:close	()V
    //   67: goto +47 -> 114
    //   70: astore_0
    //   71: goto +48 -> 119
    //   74: astore_2
    //   75: aload_1
    //   76: astore_0
    //   77: aload_2
    //   78: astore_1
    //   79: goto +12 -> 91
    //   82: astore_0
    //   83: aload_2
    //   84: astore_1
    //   85: goto +34 -> 119
    //   88: astore_1
    //   89: aload_3
    //   90: astore_0
    //   91: aload_0
    //   92: astore_2
    //   93: aload_1
    //   94: invokevirtual 68	java/util/zip/DataFormatException:printStackTrace	()V
    //   97: aload 4
    //   99: invokevirtual 67	java/util/zip/Inflater:end	()V
    //   102: aload_0
    //   103: astore_1
    //   104: aload_0
    //   105: ifnull +9 -> 114
    //   108: aload_0
    //   109: invokevirtual 47	java/io/ByteArrayOutputStream:close	()V
    //   112: aload_0
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 54	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   118: areturn
    //   119: aload 4
    //   121: invokevirtual 67	java/util/zip/Inflater:end	()V
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 47	java/io/ByteArrayOutputStream:close	()V
    //   132: goto +5 -> 137
    //   135: aload_0
    //   136: athrow
    //   137: goto -2 -> 135
    //   140: astore_0
    //   141: goto -74 -> 67
    //   144: astore_1
    //   145: aload_0
    //   146: astore_1
    //   147: goto -33 -> 114
    //   150: astore_1
    //   151: goto -19 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramArrayOfByte	byte[]
    //   22	63	1	localObject1	Object
    //   88	6	1	localDataFormatException1	java.util.zip.DataFormatException
    //   103	26	1	arrayOfByte1	byte[]
    //   144	1	1	localIOException1	java.io.IOException
    //   146	1	1	arrayOfByte2	byte[]
    //   150	1	1	localIOException2	java.io.IOException
    //   12	37	2	arrayOfByte3	byte[]
    //   74	10	2	localDataFormatException2	java.util.zip.DataFormatException
    //   92	1	2	arrayOfByte4	byte[]
    //   10	80	3	localObject2	Object
    //   7	113	4	localInflater	java.util.zip.Inflater
    // Exception table:
    //   from	to	target	type
    //   23	35	70	finally
    //   35	55	70	finally
    //   23	35	74	java/util/zip/DataFormatException
    //   35	55	74	java/util/zip/DataFormatException
    //   13	23	82	finally
    //   93	97	82	finally
    //   13	23	88	java/util/zip/DataFormatException
    //   63	67	140	java/io/IOException
    //   108	112	144	java/io/IOException
    //   128	132	150	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.ag
 * JD-Core Version:    0.7.0.1
 */