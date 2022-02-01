package com.tencent.tmassistantbase.util;

import android.text.TextUtils;
import java.io.IOException;

public class s
{
  private static String a;
  private static String b = "TMAssistantDownloadSDKService";
  private static String c = "com.tencent.mobileqq";
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, byte paramByte)
  {
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[paramInt1] == paramByte) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static boolean a()
  {
    if (TextUtils.isEmpty(a)) {}
    try
    {
      a = f();
      if (!TextUtils.isEmpty(a))
      {
        ab.c("DSDK_ProcessUtils", "current process:" + a + ",is remote op process:" + a.equals(c));
        return a.equals(c);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    return true;
  }
  
  public static boolean b()
  {
    if (TextUtils.isEmpty(a)) {}
    try
    {
      a = f();
      if (!TextUtils.isEmpty(a))
      {
        ab.c("DSDK_ProcessUtils", "current process:" + a + ",is sdk download service process:" + a.contains(b));
        return a.contains(b);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    return true;
  }
  
  public static void c()
  {
    try
    {
      a = f();
      ab.c("DSDK_ProcessUtils", "remote op process is:" + a);
      if (!a.equals(c))
      {
        c = a;
        ab.c("DSDK_ProcessUtils", "remote op process don't equals \"com.tencent.mobileqq\" set PROCESS_REMOTE_OP = " + c);
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static void d()
  {
    try
    {
      a = f();
      ab.c("DSDK_ProcessUtils", "SDK process is:" + a);
      if (!a.contains(b))
      {
        b = a;
        ab.c("DSDK_ProcessUtils", "SDK process don't contain \"TMAssistantDownloadSDKService\" set PROCESS_SDK_DOWNLOAD = " + b);
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  /* Error */
  public static String e()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 25	com/tencent/tmassistantbase/util/s:a	Ljava/lang/String;
    //   6: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore_0
    //   10: iload_0
    //   11: ifeq +9 -> 20
    //   14: invokestatic 35	com/tencent/tmassistantbase/util/s:f	()Ljava/lang/String;
    //   17: putstatic 25	com/tencent/tmassistantbase/util/s:a	Ljava/lang/String;
    //   20: ldc 37
    //   22: new 39	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   29: ldc 87
    //   31: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: getstatic 25	com/tencent/tmassistantbase/util/s:a	Ljava/lang/String;
    //   37: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 89	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 25	com/tencent/tmassistantbase/util/s:a	Ljava/lang/String;
    //   49: astore_1
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: goto -42 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	2	0	bool	boolean
    //   49	5	1	str	String
    //   55	5	1	localObject	Object
    //   61	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   3	10	55	finally
    //   14	20	55	finally
    //   20	50	55	finally
    //   14	20	61	java/io/IOException
  }
  
  /* Error */
  private static String f()
  {
    // Byte code:
    //   0: bipush 64
    //   2: newarray byte
    //   4: astore_3
    //   5: new 93	java/io/FileInputStream
    //   8: dup
    //   9: ldc 95
    //   11: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_2
    //   15: aload_2
    //   16: aload_3
    //   17: invokevirtual 102	java/io/FileInputStream:read	([B)I
    //   20: istore_0
    //   21: aload_3
    //   22: iconst_0
    //   23: iload_0
    //   24: iconst_0
    //   25: invokestatic 104	com/tencent/tmassistantbase/util/s:a	([BIIB)I
    //   28: istore_1
    //   29: iload_1
    //   30: ifle +22 -> 52
    //   33: iload_1
    //   34: istore_0
    //   35: new 52	java/lang/String
    //   38: dup
    //   39: aload_3
    //   40: iconst_0
    //   41: iload_0
    //   42: invokespecial 107	java/lang/String:<init>	([BII)V
    //   45: astore_3
    //   46: aload_2
    //   47: invokevirtual 110	java/io/FileInputStream:close	()V
    //   50: aload_3
    //   51: areturn
    //   52: goto -17 -> 35
    //   55: astore_3
    //   56: aload_2
    //   57: invokevirtual 110	java/io/FileInputStream:close	()V
    //   60: aload_3
    //   61: athrow
    //   62: astore_2
    //   63: aload_3
    //   64: areturn
    //   65: astore_2
    //   66: goto -6 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	22	0	i	int
    //   28	6	1	j	int
    //   14	43	2	localFileInputStream	java.io.FileInputStream
    //   62	1	2	localThrowable1	java.lang.Throwable
    //   65	1	2	localThrowable2	java.lang.Throwable
    //   4	47	3	localObject	Object
    //   55	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   15	29	55	finally
    //   35	46	55	finally
    //   46	50	62	java/lang/Throwable
    //   56	60	65	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.s
 * JD-Core Version:    0.7.0.1
 */