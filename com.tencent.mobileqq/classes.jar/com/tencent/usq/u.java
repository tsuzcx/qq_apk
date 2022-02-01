package com.tencent.usq;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.InputStream;
import java.security.MessageDigest;

public final class u
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    try
    {
      paramContext = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 64);
      if (paramContext == null) {
        return "f2";
      }
      if (paramContext.signatures == null) {
        return "f3";
      }
      if (paramContext.signatures[0] == null) {
        return "f4";
      }
      paramContext = paramContext.signatures[0].toByteArray();
      if ((paramContext != null) && (paramContext.length != 0)) {
        try
        {
          localObject = MessageDigest.getInstance("MD5");
          ((MessageDigest)localObject).update(paramContext);
          paramContext = a(((MessageDigest)localObject).digest());
          return paramContext;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return "f6";
        }
      }
      return "f5";
    }
    catch (Exception paramContext)
    {
      label99:
      break label99;
    }
    return "f1";
  }
  
  public static String a(InputStream paramInputStream)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = a(localMessageDigest.digest());
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 111	com/tencent/mdm/m:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +5 -> 11
    //   9: aload_1
    //   10: areturn
    //   11: aconst_null
    //   12: astore_2
    //   13: new 113	java/io/BufferedInputStream
    //   16: dup
    //   17: new 115	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 121	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: invokestatic 123	com/tencent/usq/u:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   40: aload_2
    //   41: areturn
    //   42: astore_2
    //   43: goto +12 -> 55
    //   46: astore_0
    //   47: aload_2
    //   48: astore_1
    //   49: goto +27 -> 76
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_2
    //   72: aload_0
    //   73: astore_1
    //   74: aload_2
    //   75: astore_0
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   84: aload_0
    //   85: athrow
    //   86: astore_0
    //   87: aload_2
    //   88: areturn
    //   89: astore_0
    //   90: aconst_null
    //   91: areturn
    //   92: astore_1
    //   93: goto -9 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramString	String
    //   4	77	1	localObject	Object
    //   92	1	1	localIOException1	java.io.IOException
    //   12	29	2	str1	String
    //   42	6	2	localIOException2	java.io.IOException
    //   52	6	2	localIOException3	java.io.IOException
    //   71	17	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   31	36	42	java/io/IOException
    //   13	29	46	finally
    //   13	29	52	java/io/IOException
    //   31	36	71	finally
    //   57	61	71	finally
    //   36	40	86	java/io/IOException
    //   65	69	89	java/io/IOException
    //   80	84	92	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(a[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.usq.u
 * JD-Core Version:    0.7.0.1
 */