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
    if (TextUtils.isEmpty(a)) {
      try
      {
        a = f();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current process:");
      localStringBuilder.append(a);
      localStringBuilder.append(",is remote op process:");
      localStringBuilder.append(a.equals(c));
      ab.c("DSDK_ProcessUtils", localStringBuilder.toString());
      return a.equals(c);
    }
    return true;
  }
  
  public static boolean b()
  {
    if (TextUtils.isEmpty(a)) {
      try
      {
        a = f();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current process:");
      localStringBuilder.append(a);
      localStringBuilder.append(",is sdk download service process:");
      localStringBuilder.append(a.contains(b));
      ab.c("DSDK_ProcessUtils", localStringBuilder.toString());
      return a.contains(b);
    }
    return true;
  }
  
  public static void c()
  {
    try
    {
      a = f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remote op process is:");
      localStringBuilder.append(a);
      ab.c("DSDK_ProcessUtils", localStringBuilder.toString());
      if (!a.equals(c))
      {
        c = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("remote op process don't equals \"com.tencent.mobileqq\" set PROCESS_REMOTE_OP = ");
        localStringBuilder.append(c);
        ab.c("DSDK_ProcessUtils", localStringBuilder.toString());
        return;
      }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SDK process is:");
      localStringBuilder.append(a);
      ab.c("DSDK_ProcessUtils", localStringBuilder.toString());
      if (!a.contains(b))
      {
        b = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SDK process don't contain \"TMAssistantDownloadSDKService\" set PROCESS_SDK_DOWNLOAD = ");
        localStringBuilder.append(b);
        ab.c("DSDK_ProcessUtils", localStringBuilder.toString());
        return;
      }
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
    //   3: getstatic 21	com/tencent/tmassistantbase/util/s:a	Ljava/lang/String;
    //   6: invokestatic 27	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore_0
    //   10: iload_0
    //   11: ifeq +9 -> 20
    //   14: invokestatic 31	com/tencent/tmassistantbase/util/s:f	()Ljava/lang/String;
    //   17: putstatic 21	com/tencent/tmassistantbase/util/s:a	Ljava/lang/String;
    //   20: new 36	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   27: astore_1
    //   28: aload_1
    //   29: ldc 87
    //   31: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_1
    //   36: getstatic 21	com/tencent/tmassistantbase/util/s:a	Ljava/lang/String;
    //   39: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: ldc 60
    //   45: aload_1
    //   46: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 89	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: getstatic 21	com/tencent/tmassistantbase/util/s:a	Ljava/lang/String;
    //   55: astore_1
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: goto -48 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	2	0	bool	boolean
    //   27	33	1	localObject1	Object
    //   61	5	1	localObject2	Object
    //   67	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   3	10	61	finally
    //   14	20	61	finally
    //   20	56	61	finally
    //   14	20	67	java/io/IOException
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
    //   30: ifle +5 -> 35
    //   33: iload_1
    //   34: istore_0
    //   35: new 51	java/lang/String
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
    //   52: astore_3
    //   53: aload_2
    //   54: invokevirtual 110	java/io/FileInputStream:close	()V
    //   57: aload_3
    //   58: athrow
    //   59: astore_2
    //   60: aload_3
    //   61: areturn
    //   62: astore_2
    //   63: goto -6 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	22	0	i	int
    //   28	6	1	j	int
    //   14	40	2	localFileInputStream	java.io.FileInputStream
    //   59	1	2	localThrowable1	java.lang.Throwable
    //   62	1	2	localThrowable2	java.lang.Throwable
    //   4	47	3	localObject	Object
    //   52	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   15	29	52	finally
    //   35	46	52	finally
    //   46	50	59	java/lang/Throwable
    //   53	57	62	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.s
 * JD-Core Version:    0.7.0.1
 */