package com.tencent.mobileqq.studyroom.utils;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class StudyRoomQShadowLauncher$enter$1
  implements Runnable
{
  StudyRoomQShadowLauncher$enter$1(StudyRoomQShadowLauncher paramStudyRoomQShadowLauncher) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   4: ldc 36
    //   6: invokestatic 42	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:a	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   13: invokestatic 45	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:a	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Ljava/util/concurrent/CountDownLatch;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +7 -> 25
    //   21: aload_2
    //   22: invokevirtual 50	java/util/concurrent/CountDownLatch:countDown	()V
    //   25: aload_0
    //   26: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   29: new 47	java/util/concurrent/CountDownLatch
    //   32: dup
    //   33: iconst_1
    //   34: invokespecial 53	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   37: invokestatic 56	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:a	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;Ljava/util/concurrent/CountDownLatch;)V
    //   40: aload_0
    //   41: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   44: invokestatic 60	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:b	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   47: iconst_0
    //   48: invokevirtual 66	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   51: aload_0
    //   52: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   55: iconst_0
    //   56: ldc 68
    //   58: ldc 70
    //   60: aconst_null
    //   61: aconst_null
    //   62: bipush 24
    //   64: aconst_null
    //   65: invokestatic 73	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:a	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;ILjava/lang/Object;)V
    //   68: aload_0
    //   69: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   72: invokestatic 77	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:c	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Z
    //   75: ifeq +19 -> 94
    //   78: aload_0
    //   79: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   82: ldc 79
    //   84: invokestatic 42	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:a	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;Ljava/lang/String;)V
    //   87: aload_0
    //   88: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   91: invokestatic 82	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:d	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)V
    //   94: aload_0
    //   95: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   98: invokestatic 85	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:e	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Z
    //   101: ifne +15 -> 116
    //   104: aload_0
    //   105: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   108: invokestatic 88	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:f	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Z
    //   111: istore_1
    //   112: iload_1
    //   113: ifne -104 -> 9
    //   116: aload_0
    //   117: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   120: invokestatic 92	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:h	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Lcom/tencent/mobileqq/studyroom/utils/UITimer;
    //   123: ifnull +131 -> 254
    //   126: aload_0
    //   127: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   130: invokestatic 95	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:g	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Lcom/tencent/mobileqq/studyroom/utils/UITimer;
    //   133: invokevirtual 99	com/tencent/mobileqq/studyroom/utils/UITimer:a	()V
    //   136: goto +118 -> 254
    //   139: astore_2
    //   140: goto +152 -> 292
    //   143: astore_2
    //   144: ldc 101
    //   146: iconst_1
    //   147: ldc 103
    //   149: aload_2
    //   150: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_0
    //   154: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   157: invokestatic 112	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:i	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Landroid/os/Handler;
    //   160: new 114	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1$2
    //   163: dup
    //   164: aload_0
    //   165: aload_2
    //   166: invokespecial 117	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1$2:<init>	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1;Ljava/lang/Throwable;)V
    //   169: checkcast 6	java/lang/Runnable
    //   172: invokevirtual 123	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   175: pop
    //   176: aload_0
    //   177: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   180: bipush 7
    //   182: invokestatic 126	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:a	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;I)V
    //   185: aload_0
    //   186: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   189: invokestatic 92	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:h	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Lcom/tencent/mobileqq/studyroom/utils/UITimer;
    //   192: ifnull +62 -> 254
    //   195: goto -69 -> 126
    //   198: astore_2
    //   199: ldc 101
    //   201: iconst_1
    //   202: ldc 128
    //   204: aload_2
    //   205: checkcast 34	java/lang/Throwable
    //   208: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: aload_0
    //   212: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   215: invokestatic 112	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:i	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Landroid/os/Handler;
    //   218: new 130	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1$1
    //   221: dup
    //   222: aload_0
    //   223: invokespecial 133	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1$1:<init>	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1;)V
    //   226: checkcast 6	java/lang/Runnable
    //   229: invokevirtual 123	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   232: pop
    //   233: aload_0
    //   234: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   237: iconst_1
    //   238: invokestatic 126	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:a	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;I)V
    //   241: aload_0
    //   242: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   245: invokestatic 92	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:h	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Lcom/tencent/mobileqq/studyroom/utils/UITimer;
    //   248: ifnull +6 -> 254
    //   251: goto -125 -> 126
    //   254: new 135	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   261: astore_2
    //   262: aload_2
    //   263: ldc 138
    //   265: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_2
    //   270: aload_0
    //   271: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   274: invokestatic 85	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:e	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Z
    //   277: invokevirtual 145	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: ldc 101
    //   283: iconst_1
    //   284: aload_2
    //   285: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: return
    //   292: aload_0
    //   293: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   296: invokestatic 92	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:h	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Lcom/tencent/mobileqq/studyroom/utils/UITimer;
    //   299: ifnull +13 -> 312
    //   302: aload_0
    //   303: getfield 26	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$enter$1:this$0	Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;
    //   306: invokestatic 95	com/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher:g	(Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;)Lcom/tencent/mobileqq/studyroom/utils/UITimer;
    //   309: invokevirtual 99	com/tencent/mobileqq/studyroom/utils/UITimer:a	()V
    //   312: goto +5 -> 317
    //   315: aload_2
    //   316: athrow
    //   317: goto -2 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	1
    //   111	2	1	bool	boolean
    //   16	6	2	localCountDownLatch	java.util.concurrent.CountDownLatch
    //   139	1	2	localObject	Object
    //   143	23	2	localThrowable	java.lang.Throwable
    //   198	7	2	localInterruptedException	java.lang.InterruptedException
    //   261	55	2	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	9	139	finally
    //   9	17	139	finally
    //   21	25	139	finally
    //   25	94	139	finally
    //   94	112	139	finally
    //   144	185	139	finally
    //   199	241	139	finally
    //   0	9	143	java/lang/Throwable
    //   9	17	143	java/lang/Throwable
    //   21	25	143	java/lang/Throwable
    //   25	94	143	java/lang/Throwable
    //   94	112	143	java/lang/Throwable
    //   0	9	198	java/lang/InterruptedException
    //   9	17	198	java/lang/InterruptedException
    //   21	25	198	java/lang/InterruptedException
    //   25	94	198	java/lang/InterruptedException
    //   94	112	198	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.enter.1
 * JD-Core Version:    0.7.0.1
 */