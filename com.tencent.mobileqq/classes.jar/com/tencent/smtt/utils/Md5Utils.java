package com.tencent.smtt.utils;

import java.io.InputStream;
import java.security.MessageDigest;

public class Md5Utils
{
  /* Error */
  public static String getMD5(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: ldc 19
    //   8: invokestatic 25	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   11: astore_2
    //   12: new 27	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_0
    //   21: sipush 8192
    //   24: newarray byte
    //   26: astore_3
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 34	java/io/FileInputStream:read	([B)I
    //   32: istore_1
    //   33: iload_1
    //   34: iconst_m1
    //   35: if_icmpeq +40 -> 75
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: iload_1
    //   42: invokevirtual 38	java/security/MessageDigest:update	([BII)V
    //   45: goto -18 -> 27
    //   48: astore_2
    //   49: aload 5
    //   51: astore_3
    //   52: aload_0
    //   53: ifnull +10 -> 63
    //   56: aload_0
    //   57: invokevirtual 41	java/io/FileInputStream:close	()V
    //   60: aload 5
    //   62: astore_3
    //   63: aload_3
    //   64: areturn
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 44	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   70: aconst_null
    //   71: astore_2
    //   72: goto -60 -> 12
    //   75: aload_2
    //   76: invokevirtual 48	java/security/MessageDigest:digest	()[B
    //   79: invokestatic 54	com/tencent/smtt/utils/ByteUtils:byteToHexString	([B)Ljava/lang/String;
    //   82: astore_2
    //   83: aload_2
    //   84: astore_3
    //   85: aload_0
    //   86: ifnull -23 -> 63
    //   89: aload_0
    //   90: invokevirtual 41	java/io/FileInputStream:close	()V
    //   93: aload_2
    //   94: areturn
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   100: aload_2
    //   101: areturn
    //   102: astore_2
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 41	java/io/FileInputStream:close	()V
    //   113: aload_2
    //   114: athrow
    //   115: astore_0
    //   116: aload 4
    //   118: astore_2
    //   119: goto -23 -> 96
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_0
    //   125: aload 5
    //   127: astore_3
    //   128: aload_0
    //   129: ifnull -66 -> 63
    //   132: aload_0
    //   133: invokevirtual 41	java/io/FileInputStream:close	()V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: aload 4
    //   141: astore_2
    //   142: goto -46 -> 96
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   150: goto -37 -> 113
    //   153: astore_2
    //   154: goto -49 -> 105
    //   157: astore_2
    //   158: goto -33 -> 125
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_0
    //   164: goto -115 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramFile	java.io.File
    //   32	10	1	i	int
    //   11	28	2	localMessageDigest	MessageDigest
    //   48	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   65	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   71	30	2	str	String
    //   102	12	2	localObject1	Object
    //   118	24	2	localObject2	Object
    //   153	1	2	localObject3	Object
    //   157	1	2	localIOException	java.io.IOException
    //   26	102	3	localObject4	Object
    //   1	139	4	localObject5	Object
    //   4	122	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	27	48	java/io/FileNotFoundException
    //   27	33	48	java/io/FileNotFoundException
    //   38	45	48	java/io/FileNotFoundException
    //   75	83	48	java/io/FileNotFoundException
    //   6	12	65	java/security/NoSuchAlgorithmException
    //   89	93	95	java/io/IOException
    //   6	12	102	finally
    //   12	21	102	finally
    //   66	70	102	finally
    //   56	60	115	java/io/IOException
    //   6	12	122	java/io/IOException
    //   12	21	122	java/io/IOException
    //   66	70	122	java/io/IOException
    //   132	136	138	java/io/IOException
    //   109	113	145	java/io/IOException
    //   21	27	153	finally
    //   27	33	153	finally
    //   38	45	153	finally
    //   75	83	153	finally
    //   21	27	157	java/io/IOException
    //   27	33	157	java/io/IOException
    //   38	45	157	java/io/IOException
    //   75	83	157	java/io/IOException
    //   6	12	161	java/io/FileNotFoundException
    //   12	21	161	java/io/FileNotFoundException
    //   66	70	161	java/io/FileNotFoundException
  }
  
  public static String getMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString);
      paramString = ByteUtils.byteToHexString(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static byte[] getMD5(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        if (localMessageDigest != null)
        {
          byte[] arrayOfByte = new byte[8192];
          for (;;)
          {
            int i = paramInputStream.read(arrayOfByte);
            if (i == -1) {
              break;
            }
            localMessageDigest.update(arrayOfByte, 0, i);
          }
          paramInputStream = localMessageDigest.digest();
          return paramInputStream;
        }
      }
      catch (Throwable paramInputStream) {}
    }
    return null;
  }
  
  public static byte[] getMD5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.Md5Utils
 * JD-Core Version:    0.7.0.1
 */