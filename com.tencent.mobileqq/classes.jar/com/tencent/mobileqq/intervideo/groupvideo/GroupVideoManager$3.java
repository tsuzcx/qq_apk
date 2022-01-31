package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Bundle;
import atad;
import java.util.concurrent.Future;

public class GroupVideoManager$3
  implements Runnable
{
  public GroupVideoManager$3(atad paramatad, Future paramFuture, long paramLong, Bundle paramBundle) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:jdField_a_of_type_JavaUtilConcurrentFuture	Ljava/util/concurrent/Future;
    //   4: ldc2_w 30
    //   7: getstatic 37	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   10: invokeinterface 43 4 0
    //   15: checkcast 45	aszg
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +45 -> 65
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 16	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Latad;
    //   28: invokestatic 50	atad:a	(Latad;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: invokevirtual 56	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   34: aload_0
    //   35: getfield 20	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:jdField_a_of_type_Long	J
    //   38: aload_0
    //   39: getfield 22	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   42: new 58	atag
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 61	atag:<init>	(Lcom/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3;)V
    //   50: invokeinterface 64 6 0
    //   55: aload_0
    //   56: getfield 16	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Latad;
    //   59: iconst_0
    //   60: invokestatic 67	atad:a	(Latad;Z)Z
    //   63: pop
    //   64: return
    //   65: ldc 69
    //   67: iconst_1
    //   68: ldc 71
    //   70: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: goto -18 -> 55
    //   76: astore_1
    //   77: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +12 -> 92
    //   83: ldc 69
    //   85: iconst_1
    //   86: ldc 83
    //   88: aload_1
    //   89: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: getfield 16	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Latad;
    //   96: iconst_0
    //   97: invokestatic 67	atad:a	(Latad;Z)Z
    //   100: pop
    //   101: return
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 16	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager$3:this$0	Latad;
    //   107: iconst_0
    //   108: invokestatic 67	atad:a	(Latad;Z)Z
    //   111: pop
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	3
    //   18	6	1	localaszg	aszg
    //   76	13	1	localException	java.lang.Exception
    //   102	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	19	76	java/lang/Exception
    //   23	55	76	java/lang/Exception
    //   65	73	76	java/lang/Exception
    //   0	19	102	finally
    //   23	55	102	finally
    //   65	73	102	finally
    //   77	92	102	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.3
 * JD-Core Version:    0.7.0.1
 */