package com.tencent.sveffects;

public class SvEffectSdkInitor
{
  public static boolean isDovCapture;
  private static volatile boolean isInited;
  
  /* Error */
  public static void init()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 15	com/tencent/sveffects/SvEffectSdkInitor:isInited	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 21	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   18: ldc 23
    //   20: invokestatic 29	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: new 31	com/tencent/sveffects/SvEffectSdkInitor$QQDpcSwitcher
    //   26: dup
    //   27: invokespecial 32	com/tencent/sveffects/SvEffectSdkInitor$QQDpcSwitcher:<init>	()V
    //   30: new 34	com/tencent/sveffects/SvEffectSdkInitor$QQResources
    //   33: dup
    //   34: invokespecial 35	com/tencent/sveffects/SvEffectSdkInitor$QQResources:<init>	()V
    //   37: new 37	com/tencent/sveffects/SvEffectSdkInitor$QQLogger
    //   40: dup
    //   41: invokespecial 38	com/tencent/sveffects/SvEffectSdkInitor$QQLogger:<init>	()V
    //   44: new 40	com/tencent/sveffects/SvEffectSdkInitor$QQReporter
    //   47: dup
    //   48: invokespecial 41	com/tencent/sveffects/SvEffectSdkInitor$QQReporter:<init>	()V
    //   51: invokevirtual 44	com/tencent/sveffects/SdkContext:init	(Ljava/lang/String;Landroid/app/Application;Lcom/tencent/sveffects/DpcSwitcher;Lcom/tencent/mobileqq/shortvideo/resource/Resources;Lcom/tencent/sveffects/Logger;Lcom/tencent/sveffects/Reporter;)V
    //   54: iconst_1
    //   55: putstatic 15	com/tencent/sveffects/SvEffectSdkInitor:isInited	Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor
 * JD-Core Version:    0.7.0.1
 */