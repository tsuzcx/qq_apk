package com.tencent.tgpa.vendorpd.b;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: sipush 2048
    //   3: newarray byte
    //   5: astore_3
    //   6: new 34	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 38	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_2
    //   15: aload_2
    //   16: astore_0
    //   17: ldc 40
    //   19: invokestatic 46	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   22: astore 4
    //   24: aload_2
    //   25: astore_0
    //   26: aload_2
    //   27: aload_3
    //   28: invokevirtual 52	java/io/InputStream:read	([B)I
    //   31: istore_1
    //   32: iload_1
    //   33: ifle +16 -> 49
    //   36: aload_2
    //   37: astore_0
    //   38: aload 4
    //   40: aload_3
    //   41: iconst_0
    //   42: iload_1
    //   43: invokevirtual 56	java/security/MessageDigest:update	([BII)V
    //   46: goto -22 -> 24
    //   49: aload_2
    //   50: astore_0
    //   51: aload 4
    //   53: invokevirtual 60	java/security/MessageDigest:digest	()[B
    //   56: invokestatic 64	com/tencent/tgpa/vendorpd/b/c:b	([B)Ljava/lang/String;
    //   59: astore_3
    //   60: aload_2
    //   61: invokevirtual 67	java/io/InputStream:close	()V
    //   64: aload_3
    //   65: areturn
    //   66: astore_3
    //   67: goto +16 -> 83
    //   70: astore_3
    //   71: goto +31 -> 102
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_0
    //   77: goto +41 -> 118
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_0
    //   85: aload_3
    //   86: invokevirtual 70	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   89: aload_2
    //   90: ifnull +25 -> 115
    //   93: aload_2
    //   94: invokevirtual 67	java/io/InputStream:close	()V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_3
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: astore_0
    //   104: aload_3
    //   105: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   108: aload_2
    //   109: ifnull +6 -> 115
    //   112: goto -19 -> 93
    //   115: aconst_null
    //   116: areturn
    //   117: astore_2
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 67	java/io/InputStream:close	()V
    //   126: goto +5 -> 131
    //   129: aload_2
    //   130: athrow
    //   131: goto -2 -> 129
    //   134: astore_0
    //   135: aload_3
    //   136: areturn
    //   137: astore_0
    //   138: aconst_null
    //   139: areturn
    //   140: astore_0
    //   141: goto -15 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramFile	java.io.File
    //   31	12	1	i	int
    //   14	47	2	localFileInputStream	java.io.FileInputStream
    //   74	1	2	localObject1	Object
    //   82	27	2	localObject2	Object
    //   117	13	2	localObject3	Object
    //   5	60	3	localObject4	Object
    //   66	1	3	localNoSuchAlgorithmException1	NoSuchAlgorithmException
    //   70	1	3	localIOException1	java.io.IOException
    //   80	6	3	localNoSuchAlgorithmException2	NoSuchAlgorithmException
    //   99	37	3	localIOException2	java.io.IOException
    //   22	30	4	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   17	24	66	java/security/NoSuchAlgorithmException
    //   26	32	66	java/security/NoSuchAlgorithmException
    //   38	46	66	java/security/NoSuchAlgorithmException
    //   51	60	66	java/security/NoSuchAlgorithmException
    //   17	24	70	java/io/IOException
    //   26	32	70	java/io/IOException
    //   38	46	70	java/io/IOException
    //   51	60	70	java/io/IOException
    //   6	15	74	finally
    //   6	15	80	java/security/NoSuchAlgorithmException
    //   6	15	99	java/io/IOException
    //   17	24	117	finally
    //   26	32	117	finally
    //   38	46	117	finally
    //   51	60	117	finally
    //   85	89	117	finally
    //   104	108	117	finally
    //   60	64	134	java/io/IOException
    //   93	97	137	java/io/IOException
    //   122	126	140	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("utf-8"));
      paramString = c(new BigInteger(1, localMessageDigest.digest()).toString(16));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfByte[i];
        localStringBuilder.append(a[(k >> 4 & 0xF)]);
        localStringBuilder.append(a[(k & 0xF)]);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      if (j < 16) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(Integer.toHexString(j));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] b(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = paramString.toCharArray();
      byte[] arrayOfByte = new byte[paramString.length / 2];
      int i = 0;
      while (i < arrayOfByte.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        int j = i * 2;
        localStringBuilder.append(paramString[j]);
        localStringBuilder.append(paramString[(j + 1)]);
        arrayOfByte[i] = ((byte)Integer.parseInt(localStringBuilder.toString(), 16));
        i += 1;
      }
      return arrayOfByte;
    }
    return null;
  }
  
  private static String c(String paramString)
  {
    if (paramString.length() == 32) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0");
    localStringBuilder.append(paramString);
    return c(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.b.c
 * JD-Core Version:    0.7.0.1
 */