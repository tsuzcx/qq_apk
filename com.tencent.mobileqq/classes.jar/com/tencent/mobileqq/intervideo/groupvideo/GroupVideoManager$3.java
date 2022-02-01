package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Bundle;
import java.util.concurrent.Future;

class GroupVideoManager$3
  implements Runnable
{
  GroupVideoManager$3(GroupVideoManager paramGroupVideoManager, Future paramFuture, long paramLong, Bundle paramBundle) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:a	Ljava/util/concurrent/Future;
    //   4: ldc2_w 32
    //   7: getstatic 39	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   10: invokeinterface 45 4 0
    //   15: checkcast 47	com/tencent/mobileqq/intervideo/IVPluginManager
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +38 -> 58
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 18	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Lcom/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager;
    //   28: invokestatic 52	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager:a	(Lcom/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   34: aload_0
    //   35: getfield 22	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:b	J
    //   38: aload_0
    //   39: getfield 24	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:c	Landroid/os/Bundle;
    //   42: new 60	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3$1
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 63	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3$1:<init>	(Lcom/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3;)V
    //   50: invokeinterface 66 6 0
    //   55: goto +34 -> 89
    //   58: ldc 68
    //   60: iconst_1
    //   61: ldc 70
    //   63: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: goto +23 -> 89
    //   69: astore_1
    //   70: goto +29 -> 99
    //   73: astore_1
    //   74: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +12 -> 89
    //   80: ldc 68
    //   82: iconst_1
    //   83: ldc 82
    //   85: aload_1
    //   86: invokestatic 86	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   89: aload_0
    //   90: getfield 18	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Lcom/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager;
    //   93: iconst_0
    //   94: invokestatic 89	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager:a	(Lcom/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager;Z)Z
    //   97: pop
    //   98: return
    //   99: aload_0
    //   100: getfield 18	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Lcom/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager;
    //   103: iconst_0
    //   104: invokestatic 89	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager:a	(Lcom/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager;Z)Z
    //   107: pop
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	3
    //   18	6	1	localIVPluginManager	com.tencent.mobileqq.intervideo.IVPluginManager
    //   69	1	1	localObject	Object
    //   73	36	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	19	69	finally
    //   23	55	69	finally
    //   58	66	69	finally
    //   74	89	69	finally
    //   0	19	73	java/lang/Exception
    //   23	55	73	java/lang/Exception
    //   58	66	73	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.3
 * JD-Core Version:    0.7.0.1
 */