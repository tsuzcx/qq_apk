package com.tencent.sveffects;

public class SvEffectSdkInitor
{
  public static boolean a;
  private static volatile boolean b;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	com/tencent/sveffects/SvEffectSdkInitor:b	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 19	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   18: ldc 21
    //   20: invokestatic 27	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: new 29	com/tencent/sveffects/SvEffectSdkInitor$QQDpcSwitcher
    //   26: dup
    //   27: invokespecial 30	com/tencent/sveffects/SvEffectSdkInitor$QQDpcSwitcher:<init>	()V
    //   30: new 32	com/tencent/sveffects/SvEffectSdkInitor$QQResources
    //   33: dup
    //   34: invokespecial 33	com/tencent/sveffects/SvEffectSdkInitor$QQResources:<init>	()V
    //   37: new 35	com/tencent/sveffects/SvEffectSdkInitor$QQLogger
    //   40: dup
    //   41: invokespecial 36	com/tencent/sveffects/SvEffectSdkInitor$QQLogger:<init>	()V
    //   44: new 38	com/tencent/sveffects/SvEffectSdkInitor$QQReporter
    //   47: dup
    //   48: invokespecial 39	com/tencent/sveffects/SvEffectSdkInitor$QQReporter:<init>	()V
    //   51: invokevirtual 42	com/tencent/sveffects/SdkContext:a	(Ljava/lang/String;Landroid/app/Application;Lcom/tencent/sveffects/DpcSwitcher;Lcom/tencent/mobileqq/shortvideo/resource/Resources;Lcom/tencent/sveffects/Logger;Lcom/tencent/sveffects/Reporter;)V
    //   54: iconst_1
    //   55: putstatic 14	com/tencent/sveffects/SvEffectSdkInitor:b	Z
    //   58: goto -47 -> 11
    //   61: astore_1
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   61	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	61	finally
    //   15	58	61	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor
 * JD-Core Version:    0.7.0.1
 */