package com.tencent.open.base;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  public static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +135 -> 136
    //   4: aload_0
    //   5: invokevirtual 43	java/io/File:exists	()Z
    //   8: ifeq +128 -> 136
    //   11: aload_0
    //   12: invokevirtual 47	java/io/File:length	()J
    //   15: lconst_0
    //   16: lcmp
    //   17: ifle +119 -> 136
    //   20: aconst_null
    //   21: astore_2
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore_1
    //   26: new 49	java/io/BufferedInputStream
    //   29: dup
    //   30: new 51	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 54	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: invokespecial 57	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   41: astore_0
    //   42: aload_0
    //   43: invokestatic 60	com/tencent/open/base/MD5:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_0
    //   48: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   51: aload_1
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   58: aload_1
    //   59: areturn
    //   60: astore_2
    //   61: aload_0
    //   62: astore_1
    //   63: aload_2
    //   64: astore_0
    //   65: goto +53 -> 118
    //   68: goto +11 -> 79
    //   71: astore_2
    //   72: goto +29 -> 101
    //   75: astore_0
    //   76: goto +42 -> 118
    //   79: aload_0
    //   80: ifnull +56 -> 136
    //   83: aload_0
    //   84: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   87: goto +49 -> 136
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   95: goto +41 -> 136
    //   98: astore_2
    //   99: aload_3
    //   100: astore_0
    //   101: aload_0
    //   102: astore_1
    //   103: aload_2
    //   104: invokevirtual 67	java/io/FileNotFoundException:printStackTrace	()V
    //   107: aload_0
    //   108: ifnull +28 -> 136
    //   111: aload_0
    //   112: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   115: goto +21 -> 136
    //   118: aload_1
    //   119: ifnull +15 -> 134
    //   122: aload_1
    //   123: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   126: goto +8 -> 134
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   134: aload_0
    //   135: athrow
    //   136: ldc 69
    //   138: areturn
    //   139: astore_0
    //   140: aload_2
    //   141: astore_0
    //   142: goto -63 -> 79
    //   145: astore_1
    //   146: goto -78 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramFile	java.io.File
    //   25	98	1	localObject1	Object
    //   129	2	1	localIOException	IOException
    //   145	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   21	1	2	localObject2	Object
    //   60	4	2	localObject3	Object
    //   71	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   98	43	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   23	77	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   47	51	53	java/io/IOException
    //   42	47	60	finally
    //   42	47	71	java/io/FileNotFoundException
    //   26	42	75	finally
    //   103	107	75	finally
    //   83	87	90	java/io/IOException
    //   111	115	90	java/io/IOException
    //   26	42	98	java/io/FileNotFoundException
    //   122	126	129	java/io/IOException
    //   26	42	139	java/lang/OutOfMemoryError
    //   42	47	145	java/lang/OutOfMemoryError
  }
  
  public static String a(InputStream paramInputStream)
  {
    int i;
    do
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        byte[] arrayOfByte = new byte[4196];
        i = 0;
        for (;;)
        {
          int j = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
          if (j == -1) {
            break;
          }
          if (j > 0)
          {
            localMessageDigest.update(arrayOfByte, 0, j);
            i += j;
          }
        }
        paramInputStream = a(localMessageDigest.digest());
        return paramInputStream;
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
        return "";
      }
      catch (NoSuchAlgorithmException paramInputStream)
      {
        paramInputStream.printStackTrace();
        return "";
      }
    } while (i != 0);
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 16))
    {
      char[] arrayOfChar1 = new char[32];
      int i = 0;
      int j = 0;
      while (i < 16)
      {
        int k = paramArrayOfByte[i];
        int m = j + 1;
        char[] arrayOfChar2 = a;
        arrayOfChar1[j] = arrayOfChar2[(k >>> 4 & 0xF)];
        j = m + 1;
        arrayOfChar1[m] = arrayOfChar2[(k & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar1);
    }
    return "";
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: ldc 73
    //   2: invokestatic 79	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_1
    //   6: aload_0
    //   7: ldc 111
    //   9: invokevirtual 114	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   12: astore_0
    //   13: aload_1
    //   14: aload_0
    //   15: invokevirtual 117	java/security/MessageDigest:digest	([B)[B
    //   18: areturn
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 118	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   24: ldc 120
    //   26: ldc 122
    //   28: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aconst_null
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   38: ldc 120
    //   40: ldc 131
    //   42: invokestatic 128	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aconst_null
    //   46: areturn
    //   47: aload_0
    //   48: invokevirtual 132	java/lang/Throwable:printStackTrace	()V
    //   51: aconst_null
    //   52: areturn
    //   53: astore_0
    //   54: goto -7 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramString	String
    //   5	9	1	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   6	13	19	java/io/UnsupportedEncodingException
    //   0	6	33	java/lang/Exception
    //   0	6	53	java/lang/Throwable
    //   6	13	53	java/lang/Throwable
    //   13	19	53	java/lang/Throwable
    //   20	31	53	java/lang/Throwable
    //   34	45	53	java/lang/Throwable
  }
  
  public static String b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return "";
    }
    return a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.MD5
 * JD-Core Version:    0.7.0.1
 */