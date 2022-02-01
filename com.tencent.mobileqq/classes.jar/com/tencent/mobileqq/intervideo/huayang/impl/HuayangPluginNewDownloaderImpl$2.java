package com.tencent.mobileqq.intervideo.huayang.impl;

class HuayangPluginNewDownloaderImpl$2
  implements Runnable
{
  HuayangPluginNewDownloaderImpl$2(HuayangPluginNewDownloaderImpl paramHuayangPluginNewDownloaderImpl) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl$2:this$0	Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;
    //   4: invokestatic 24	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:access$1000	(Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;)V
    //   7: aload_0
    //   8: getfield 12	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl$2:this$0	Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;
    //   11: invokestatic 28	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:access$800	(Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;)Landroid/os/Handler;
    //   14: aload_0
    //   15: getfield 12	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl$2:this$0	Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;
    //   18: invokestatic 32	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:access$1100	(Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;)Ljava/lang/Runnable;
    //   21: invokevirtual 38	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   24: aload_0
    //   25: getfield 12	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl$2:this$0	Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;
    //   28: iconst_0
    //   29: invokestatic 42	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:access$702	(Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;Z)Z
    //   32: pop
    //   33: return
    //   34: astore_1
    //   35: goto +35 -> 70
    //   38: astore_1
    //   39: ldc 44
    //   41: invokestatic 50	com/tencent/mobileqq/intervideo/huayang/Monitor:a	(Ljava/lang/String;)V
    //   44: ldc 52
    //   46: invokestatic 58	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   49: checkcast 52	com/tencent/mobileqq/intervideo/huayang/IHuayangCrashReport
    //   52: new 60	java/lang/RuntimeException
    //   55: dup
    //   56: ldc 62
    //   58: aload_1
    //   59: invokespecial 65	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   62: invokeinterface 69 2 0
    //   67: goto -60 -> 7
    //   70: aload_0
    //   71: getfield 12	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl$2:this$0	Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;
    //   74: invokestatic 28	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:access$800	(Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;)Landroid/os/Handler;
    //   77: aload_0
    //   78: getfield 12	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl$2:this$0	Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;
    //   81: invokestatic 32	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:access$1100	(Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;)Ljava/lang/Runnable;
    //   84: invokevirtual 38	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   87: aload_0
    //   88: getfield 12	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl$2:this$0	Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;
    //   91: iconst_0
    //   92: invokestatic 42	com/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl:access$702	(Lcom/tencent/mobileqq/intervideo/huayang/impl/HuayangPluginNewDownloaderImpl;Z)Z
    //   95: pop
    //   96: goto +5 -> 101
    //   99: aload_1
    //   100: athrow
    //   101: goto -2 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	2
    //   34	1	1	localObject	Object
    //   38	62	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	7	34	finally
    //   39	67	34	finally
    //   0	7	38	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangPluginNewDownloaderImpl.2
 * JD-Core Version:    0.7.0.1
 */