package com.tencent.mobileqq.transfile.quic.internal;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.quic.open.ILoadSo;
import com.tencent.mobileqq.transfile.quic.open.ILoadSoCallback;
import mqq.os.MqqHandler;

public class LoadSoImp
  implements ILoadSo
{
  public static void asyncLoadSo(ILoadSoCallback paramILoadSoCallback)
  {
    ThreadManager.getFileThreadHandler().post(new LoadSoImp.1(paramILoadSoCallback));
  }
  
  /* Error */
  private static boolean realLoadQuicSo()
  {
    // Byte code:
    //   0: getstatic 42	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmpge +13 -> 18
    //   8: ldc 44
    //   10: iconst_4
    //   11: ldc 46
    //   13: invokestatic 52	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: iconst_0
    //   17: ireturn
    //   18: invokestatic 58	com/tencent/mobileqq/transfile/quic/internal/Utils:getAndromedaSoPath	()Ljava/lang/String;
    //   21: invokestatic 64	java/lang/System:load	(Ljava/lang/String;)V
    //   24: goto +9 -> 33
    //   27: invokestatic 58	com/tencent/mobileqq/transfile/quic/internal/Utils:getAndromedaSoPath	()Ljava/lang/String;
    //   30: invokestatic 64	java/lang/System:load	(Ljava/lang/String;)V
    //   33: invokestatic 67	com/tencent/mobileqq/transfile/quic/internal/Utils:getQuicEngineSoPath	()Ljava/lang/String;
    //   36: invokestatic 64	java/lang/System:load	(Ljava/lang/String;)V
    //   39: goto +9 -> 48
    //   42: invokestatic 67	com/tencent/mobileqq/transfile/quic/internal/Utils:getQuicEngineSoPath	()Ljava/lang/String;
    //   45: invokestatic 64	java/lang/System:load	(Ljava/lang/String;)V
    //   48: iconst_1
    //   49: ireturn
    //   50: astore_0
    //   51: ldc 44
    //   53: iconst_4
    //   54: ldc 69
    //   56: aload_0
    //   57: invokestatic 72	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   60: iconst_0
    //   61: ireturn
    //   62: astore_0
    //   63: goto -36 -> 27
    //   66: astore_0
    //   67: goto -25 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	7	0	localThrowable1	java.lang.Throwable
    //   62	1	0	localThrowable2	java.lang.Throwable
    //   66	1	0	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   27	33	50	java/lang/Throwable
    //   42	48	50	java/lang/Throwable
    //   18	24	62	java/lang/Throwable
    //   33	39	66	java/lang/Throwable
  }
  
  public void loadSo(ILoadSoCallback paramILoadSoCallback)
  {
    asyncLoadSo(paramILoadSoCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.LoadSoImp
 * JD-Core Version:    0.7.0.1
 */