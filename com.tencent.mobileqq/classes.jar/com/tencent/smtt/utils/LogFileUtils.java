package com.tencent.smtt.utils;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils
{
  private static OutputStream a;
  
  public static void closeOutputStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {
      try
      {
        paramOutputStream.close();
        return;
      }
      catch (IOException paramOutputStream)
      {
        Log.e("LOG_FILE", "Couldn't close stream!", paramOutputStream);
      }
    }
  }
  
  public static byte[] createHeaderText(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = encryptKey(paramString1, paramString2);
      paramString2 = String.format("%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      return arrayOfByte;
    }
    catch (Exception paramString1)
    {
      label69:
      break label69;
    }
    return null;
  }
  
  public static String createKey()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  public static byte[] encrypt(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("encrypt exception:");
      paramString2.append(paramString1.getMessage());
      Log.e("LOG_FILE", paramString2.toString());
    }
    return null;
  }
  
  public static byte[] encryptKey(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("encrypt exception:");
      paramString2.append(paramString1.getMessage());
      Log.e("LOG_FILE", paramString2.toString());
    }
    return null;
  }
  
  /* Error */
  public static void writeDataToStorage(java.io.File paramFile, String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: aload_3
    //   5: invokestatic 123	com/tencent/smtt/utils/LogFileUtils:encrypt	(Ljava/lang/String;Ljava/lang/String;)[B
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +8 -> 18
    //   13: aconst_null
    //   14: astore_3
    //   15: goto +5 -> 20
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: invokevirtual 129	java/io/File:getParentFile	()Ljava/io/File;
    //   24: invokevirtual 133	java/io/File:mkdirs	()Z
    //   27: pop
    //   28: aload_0
    //   29: invokevirtual 136	java/io/File:isFile	()Z
    //   32: ifeq +31 -> 63
    //   35: aload_0
    //   36: invokevirtual 139	java/io/File:exists	()Z
    //   39: ifeq +24 -> 63
    //   42: aload_0
    //   43: invokevirtual 142	java/io/File:length	()J
    //   46: ldc2_w 143
    //   49: lcmp
    //   50: ifle +13 -> 63
    //   53: aload_0
    //   54: invokevirtual 147	java/io/File:delete	()Z
    //   57: pop
    //   58: aload_0
    //   59: invokevirtual 150	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   66: ifnonnull +23 -> 89
    //   69: new 154	java/io/BufferedOutputStream
    //   72: dup
    //   73: new 156	java/io/FileOutputStream
    //   76: dup
    //   77: aload_0
    //   78: iload 4
    //   80: invokespecial 159	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   83: invokespecial 161	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: putstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   89: aload_3
    //   90: ifnull +16 -> 106
    //   93: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   96: aload_3
    //   97: invokevirtual 164	java/lang/String:getBytes	()[B
    //   100: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   103: goto +36 -> 139
    //   106: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   109: aload_2
    //   110: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   113: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   116: aload_1
    //   117: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   120: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   123: iconst_2
    //   124: newarray byte
    //   126: dup
    //   127: iconst_0
    //   128: bipush 10
    //   130: bastore
    //   131: dup
    //   132: iconst_1
    //   133: bipush 10
    //   135: bastore
    //   136: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   139: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +46 -> 190
    //   147: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 171	java/io/OutputStream:flush	()V
    //   155: goto +35 -> 190
    //   158: astore_0
    //   159: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +9 -> 173
    //   167: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   170: invokevirtual 171	java/io/OutputStream:flush	()V
    //   173: aload_0
    //   174: athrow
    //   175: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   178: astore_0
    //   179: aload_0
    //   180: ifnull +10 -> 190
    //   183: getstatic 152	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   186: astore_0
    //   187: goto -36 -> 151
    //   190: ldc 2
    //   192: monitorexit
    //   193: return
    //   194: astore_0
    //   195: ldc 2
    //   197: monitorexit
    //   198: goto +5 -> 203
    //   201: aload_0
    //   202: athrow
    //   203: goto -2 -> 201
    //   206: astore_0
    //   207: goto -32 -> 175
    //   210: astore_0
    //   211: goto -21 -> 190
    //   214: astore_1
    //   215: goto -42 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramFile	java.io.File
    //   0	218	1	paramString1	String
    //   0	218	2	paramArrayOfByte	byte[]
    //   0	218	3	paramString2	String
    //   0	218	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   20	63	158	finally
    //   63	89	158	finally
    //   93	103	158	finally
    //   106	139	158	finally
    //   3	9	194	finally
    //   139	143	194	finally
    //   147	151	194	finally
    //   151	155	194	finally
    //   159	163	194	finally
    //   167	173	194	finally
    //   173	175	194	finally
    //   175	179	194	finally
    //   183	187	194	finally
    //   20	63	206	java/lang/Throwable
    //   63	89	206	java/lang/Throwable
    //   93	103	206	java/lang/Throwable
    //   106	139	206	java/lang/Throwable
    //   147	151	210	java/lang/Throwable
    //   151	155	210	java/lang/Throwable
    //   183	187	210	java/lang/Throwable
    //   167	173	214	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.utils.LogFileUtils
 * JD-Core Version:    0.7.0.1
 */