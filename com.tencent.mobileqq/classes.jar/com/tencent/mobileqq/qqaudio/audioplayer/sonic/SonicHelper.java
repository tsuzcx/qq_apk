package com.tencent.mobileqq.qqaudio.audioplayer.sonic;

public class SonicHelper
{
  public static float a = 1.0F;
  public static float b = 1.5F;
  public static float c = 1.8F;
  private static boolean d = false;
  
  public static boolean a()
  {
    return d;
  }
  
  public static boolean a(float paramFloat)
  {
    return (paramFloat > 1.0F) && (Math.abs(paramFloat - 1.0F) > 0.0F);
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.0E-006F;
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: getstatic 23	com/tencent/mobileqq/qqaudio/audioplayer/sonic/SonicHelper:d	Z
    //   3: ifne +79 -> 82
    //   6: ldc 36
    //   8: invokestatic 42	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   11: iconst_1
    //   12: putstatic 23	com/tencent/mobileqq/qqaudio/audioplayer/sonic/SonicHelper:d	Z
    //   15: getstatic 23	com/tencent/mobileqq/qqaudio/audioplayer/sonic/SonicHelper:d	Z
    //   18: invokestatic 47	com/tencent/mobileqq/qqaudio/QQAudioReporter:a	(Z)V
    //   21: return
    //   22: astore_0
    //   23: goto +51 -> 74
    //   26: astore_0
    //   27: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +37 -> 67
    //   33: new 54	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: ldc 57
    //   44: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: aload_0
    //   50: invokevirtual 65	java/lang/Throwable:toString	()Ljava/lang/String;
    //   53: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: ldc 36
    //   59: iconst_2
    //   60: aload_1
    //   61: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: iconst_0
    //   68: putstatic 23	com/tencent/mobileqq/qqaudio/audioplayer/sonic/SonicHelper:d	Z
    //   71: goto -56 -> 15
    //   74: getstatic 23	com/tencent/mobileqq/qqaudio/audioplayer/sonic/SonicHelper:d	Z
    //   77: invokestatic 47	com/tencent/mobileqq/qqaudio/QQAudioReporter:a	(Z)V
    //   80: aload_0
    //   81: athrow
    //   82: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	1	0	localObject	Object
    //   26	55	0	localThrowable	java.lang.Throwable
    //   40	21	1	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	15	22	finally
    //   27	67	22	finally
    //   67	71	22	finally
    //   6	15	26	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper
 * JD-Core Version:    0.7.0.1
 */