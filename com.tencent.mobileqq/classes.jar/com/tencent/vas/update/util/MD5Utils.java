package com.tencent.vas.update.util;

public class MD5Utils
{
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    try
    {
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
        j = (byte)(j >>> 4);
        arrayOfChar[(i * 2 + 0)] = digits[(j & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  /* Error */
  protected static byte[] encodeFile(String paramString)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 55	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_3
    //   6: new 57	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 64	java/io/File:exists	()Z
    //   19: ifne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 66	java/io/BufferedInputStream
    //   27: dup
    //   28: new 68	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 71	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: invokespecial 74	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_2
    //   40: sipush 4096
    //   43: newarray byte
    //   45: astore_0
    //   46: aload_2
    //   47: aload_0
    //   48: invokevirtual 78	java/io/BufferedInputStream:read	([B)I
    //   51: istore_1
    //   52: iload_1
    //   53: iconst_m1
    //   54: if_icmpeq +26 -> 80
    //   57: aload_3
    //   58: aload_0
    //   59: iconst_0
    //   60: iload_1
    //   61: invokevirtual 82	java/security/MessageDigest:update	([BII)V
    //   64: goto -18 -> 46
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   72: aload_2
    //   73: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: areturn
    //   80: aload_3
    //   81: invokevirtual 92	java/security/MessageDigest:digest	()[B
    //   84: astore_0
    //   85: aload_2
    //   86: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   89: goto -11 -> 78
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   97: goto -19 -> 78
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 93	java/io/FileNotFoundException:printStackTrace	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   112: aconst_null
    //   113: astore_0
    //   114: goto -36 -> 78
    //   117: astore_0
    //   118: aload_2
    //   119: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 94	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: aload_2
    //   133: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   136: goto -14 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   51	10	1	i	int
    //   39	47	2	localBufferedInputStream	java.io.BufferedInputStream
    //   92	27	2	localIOException1	java.io.IOException
    //   131	2	2	localIOException2	java.io.IOException
    //   5	76	3	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   46	52	67	java/io/IOException
    //   57	64	67	java/io/IOException
    //   80	85	67	java/io/IOException
    //   85	89	92	java/io/IOException
    //   0	22	100	java/io/FileNotFoundException
    //   24	46	100	java/io/FileNotFoundException
    //   72	76	100	java/io/FileNotFoundException
    //   85	89	100	java/io/FileNotFoundException
    //   93	97	100	java/io/FileNotFoundException
    //   108	112	100	java/io/FileNotFoundException
    //   118	122	100	java/io/FileNotFoundException
    //   122	124	100	java/io/FileNotFoundException
    //   132	136	100	java/io/FileNotFoundException
    //   72	76	107	java/io/IOException
    //   46	52	117	finally
    //   57	64	117	finally
    //   68	72	117	finally
    //   80	85	117	finally
    //   0	22	124	java/security/NoSuchAlgorithmException
    //   24	46	124	java/security/NoSuchAlgorithmException
    //   72	76	124	java/security/NoSuchAlgorithmException
    //   85	89	124	java/security/NoSuchAlgorithmException
    //   93	97	124	java/security/NoSuchAlgorithmException
    //   108	112	124	java/security/NoSuchAlgorithmException
    //   118	122	124	java/security/NoSuchAlgorithmException
    //   122	124	124	java/security/NoSuchAlgorithmException
    //   132	136	124	java/security/NoSuchAlgorithmException
    //   118	122	131	java/io/IOException
  }
  
  public static String encodeFileHexStr(String paramString)
  {
    return bytes2HexStr(encodeFile(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.util.MD5Utils
 * JD-Core Version:    0.7.0.1
 */