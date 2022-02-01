package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.remote.ToServiceMsg;

class g$b
  implements Runnable
{
  public ToServiceMsg a;
  
  g$b(g paramg, ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   4: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   7: ifnull +33 -> 40
    //   10: aload_0
    //   11: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   14: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   17: getfield 34	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   20: ifnull +20 -> 40
    //   23: aload_0
    //   24: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   27: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   30: getfield 34	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   33: iconst_3
    //   34: invokeinterface 40 2 0
    //   39: pop
    //   40: invokestatic 46	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   43: invokevirtual 50	java/lang/Thread:getName	()Ljava/lang/String;
    //   46: astore_2
    //   47: aload_0
    //   48: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   51: invokestatic 53	com/tencent/mobileqq/msf/core/g:b	(Lcom/tencent/mobileqq/msf/core/g;)Ljava/util/concurrent/ThreadPoolExecutor;
    //   54: invokevirtual 59	java/util/concurrent/ThreadPoolExecutor:getActiveCount	()I
    //   57: istore_1
    //   58: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +47 -> 108
    //   64: new 67	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   71: astore_3
    //   72: aload_3
    //   73: ldc 70
    //   75: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: aload_2
    //   81: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_3
    //   86: ldc 76
    //   88: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: iload_1
    //   94: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: ldc 81
    //   100: iconst_2
    //   101: aload_3
    //   102: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_0
    //   109: getfield 19	com/tencent/mobileqq/msf/core/g$b:a	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   112: astore_2
    //   113: aload_2
    //   114: ifnonnull +44 -> 158
    //   117: aload_0
    //   118: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   121: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   124: ifnull +33 -> 157
    //   127: aload_0
    //   128: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   131: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   134: getfield 34	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   137: ifnull +20 -> 157
    //   140: aload_0
    //   141: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   144: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   147: getfield 34	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   150: iconst_3
    //   151: invokeinterface 91 2 0
    //   156: pop
    //   157: return
    //   158: aload_0
    //   159: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   162: invokestatic 95	com/tencent/mobileqq/msf/core/g:c	(Lcom/tencent/mobileqq/msf/core/g;)Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   165: aload_0
    //   166: getfield 19	com/tencent/mobileqq/msf/core/g$b:a	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   169: invokevirtual 101	java/util/concurrent/ConcurrentLinkedQueue:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: invokestatic 106	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   176: aload_0
    //   177: getfield 19	com/tencent/mobileqq/msf/core/g$b:a	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   180: invokevirtual 109	com/tencent/mobileqq/a/a/a:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   183: aload_0
    //   184: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   187: aload_0
    //   188: getfield 19	com/tencent/mobileqq/msf/core/g$b:a	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   191: invokevirtual 112	com/tencent/mobileqq/msf/core/g:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   194: pop
    //   195: aload_0
    //   196: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   199: aload_0
    //   200: getfield 19	com/tencent/mobileqq/msf/core/g$b:a	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   203: invokevirtual 114	com/tencent/mobileqq/msf/core/g:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   206: aload_0
    //   207: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   210: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   213: ifnull +77 -> 290
    //   216: aload_0
    //   217: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   220: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   223: getfield 34	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   226: ifnull +64 -> 290
    //   229: goto +44 -> 273
    //   232: astore_2
    //   233: goto +58 -> 291
    //   236: astore_2
    //   237: aload_2
    //   238: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   241: ldc 81
    //   243: iconst_1
    //   244: ldc 119
    //   246: aload_2
    //   247: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   250: aload_0
    //   251: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   254: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   257: ifnull +33 -> 290
    //   260: aload_0
    //   261: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   264: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   267: getfield 34	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   270: ifnull +20 -> 290
    //   273: aload_0
    //   274: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   277: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   280: getfield 34	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   283: iconst_3
    //   284: invokeinterface 91 2 0
    //   289: pop
    //   290: return
    //   291: aload_0
    //   292: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   295: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   298: ifnull +33 -> 331
    //   301: aload_0
    //   302: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   305: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   308: getfield 34	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   311: ifnull +20 -> 331
    //   314: aload_0
    //   315: getfield 14	com/tencent/mobileqq/msf/core/g$b:b	Lcom/tencent/mobileqq/msf/core/g;
    //   318: invokestatic 28	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/g;)Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   321: getfield 34	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   324: iconst_3
    //   325: invokeinterface 91 2 0
    //   330: pop
    //   331: aload_2
    //   332: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	b
    //   57	37	1	i	int
    //   46	68	2	localObject1	Object
    //   232	1	2	localObject2	Object
    //   236	96	2	localException	java.lang.Exception
    //   71	31	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	40	232	finally
    //   40	108	232	finally
    //   108	113	232	finally
    //   158	206	232	finally
    //   237	250	232	finally
    //   0	40	236	java/lang/Exception
    //   40	108	236	java/lang/Exception
    //   108	113	236	java/lang/Exception
    //   158	206	236	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.g.b
 * JD-Core Version:    0.7.0.1
 */