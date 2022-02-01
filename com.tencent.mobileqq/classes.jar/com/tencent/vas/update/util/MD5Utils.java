package com.tencent.vas.update.util;

public class MD5Utils
{
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar;
    int i;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      arrayOfChar = new char[paramArrayOfByte.length * 2];
      i = 0;
    }
    try
    {
      while (i < paramArrayOfByte.length)
      {
        int k = paramArrayOfByte[i];
        int j = i * 2;
        arrayOfChar[(j + 1)] = digits[(k & 0xF)];
        k = (byte)(k >>> 4);
        arrayOfChar[(j + 0)] = digits[(k & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
    return null;
  }
  
  /* Error */
  protected static byte[] encodeFile(String paramString)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 55	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
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
    //   39: astore_0
    //   40: sipush 4096
    //   43: newarray byte
    //   45: astore_3
    //   46: aload_0
    //   47: aload_3
    //   48: invokevirtual 78	java/io/BufferedInputStream:read	([B)I
    //   51: istore_1
    //   52: iload_1
    //   53: iconst_m1
    //   54: if_icmpeq +13 -> 67
    //   57: aload_2
    //   58: aload_3
    //   59: iconst_0
    //   60: iload_1
    //   61: invokevirtual 82	java/security/MessageDigest:update	([BII)V
    //   64: goto -18 -> 46
    //   67: aload_2
    //   68: invokevirtual 86	java/security/MessageDigest:digest	()[B
    //   71: astore_2
    //   72: aload_0
    //   73: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   76: goto +8 -> 84
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   84: aload_2
    //   85: areturn
    //   86: astore_2
    //   87: goto +21 -> 108
    //   90: astore_2
    //   91: aload_2
    //   92: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   95: aload_0
    //   96: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   106: aconst_null
    //   107: areturn
    //   108: aload_0
    //   109: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   112: goto +8 -> 120
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   120: aload_2
    //   121: athrow
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 93	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 94	java/io/FileNotFoundException:printStackTrace	()V
    //   134: aconst_null
    //   135: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   51	10	1	i	int
    //   5	80	2	localObject1	Object
    //   86	1	2	localObject2	Object
    //   90	31	2	localIOException	java.io.IOException
    //   45	14	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   72	76	79	java/io/IOException
    //   46	52	86	finally
    //   57	64	86	finally
    //   67	72	86	finally
    //   91	95	86	finally
    //   46	52	90	java/io/IOException
    //   57	64	90	java/io/IOException
    //   67	72	90	java/io/IOException
    //   95	99	101	java/io/IOException
    //   108	112	115	java/io/IOException
    //   0	22	122	java/security/NoSuchAlgorithmException
    //   24	46	122	java/security/NoSuchAlgorithmException
    //   72	76	122	java/security/NoSuchAlgorithmException
    //   80	84	122	java/security/NoSuchAlgorithmException
    //   95	99	122	java/security/NoSuchAlgorithmException
    //   102	106	122	java/security/NoSuchAlgorithmException
    //   108	112	122	java/security/NoSuchAlgorithmException
    //   116	120	122	java/security/NoSuchAlgorithmException
    //   120	122	122	java/security/NoSuchAlgorithmException
    //   0	22	129	java/io/FileNotFoundException
    //   24	46	129	java/io/FileNotFoundException
    //   72	76	129	java/io/FileNotFoundException
    //   80	84	129	java/io/FileNotFoundException
    //   95	99	129	java/io/FileNotFoundException
    //   102	106	129	java/io/FileNotFoundException
    //   108	112	129	java/io/FileNotFoundException
    //   116	120	129	java/io/FileNotFoundException
    //   120	122	129	java/io/FileNotFoundException
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