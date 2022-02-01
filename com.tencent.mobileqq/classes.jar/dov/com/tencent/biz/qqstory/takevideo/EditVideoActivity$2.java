package dov.com.tencent.biz.qqstory.takevideo;

class EditVideoActivity$2
  implements Runnable
{
  EditVideoActivity$2(EditVideoActivity paramEditVideoActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 29	dov/com/qq/im/ae/download/AEResUtil:e	()Z
    //   3: pop
    //   4: invokestatic 35	com/tencent/mobileqq/shortvideo/VideoEnvironment:loadAVCodecSo	()I
    //   7: ifeq +25 -> 32
    //   10: ldc 37
    //   12: ldc 39
    //   14: invokestatic 44	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: invokestatic 50	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   20: new 52	dov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2$1
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 55	dov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2$1:<init>	(Ldov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2;)V
    //   28: invokevirtual 61	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   31: pop
    //   32: iconst_1
    //   33: invokestatic 67	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:nativeSetPlayStepFrameCount	(I)V
    //   36: iconst_1
    //   37: invokestatic 70	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:nativeSetPlayGapFrameCount	(I)V
    //   40: invokestatic 75	com/tencent/biz/qqstory/support/report/VideoEditReport:a	()Z
    //   43: ifeq +25 -> 68
    //   46: invokestatic 78	com/tencent/mobileqq/shortvideo/VideoEnvironment:getAVCodecVersion	()I
    //   49: istore_1
    //   50: iload_1
    //   51: bipush 21
    //   53: if_icmplt +15 -> 68
    //   56: iconst_3
    //   57: invokestatic 82	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:nativeSetMaxPhotoFrameCount	(I)I
    //   60: pop
    //   61: ldc 37
    //   63: ldc 84
    //   65: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: return
    //   69: astore_2
    //   70: ldc 37
    //   72: iconst_1
    //   73: ldc 89
    //   75: aload_2
    //   76: invokestatic 95	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   79: goto -39 -> 40
    //   82: astore_2
    //   83: ldc 37
    //   85: ldc 39
    //   87: aload_2
    //   88: invokestatic 99	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: invokestatic 50	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   94: new 101	dov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2$2
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 102	dov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2$2:<init>	(Ldov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2;)V
    //   102: invokevirtual 61	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   105: pop
    //   106: return
    //   107: astore_2
    //   108: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq -43 -> 68
    //   114: ldc 37
    //   116: iconst_2
    //   117: ldc 107
    //   119: aload_2
    //   120: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   123: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	2
    //   49	5	1	i	int
    //   69	7	2	localThrowable	java.lang.Throwable
    //   82	6	2	localException	java.lang.Exception
    //   107	13	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   32	40	69	java/lang/Throwable
    //   0	32	82	java/lang/Exception
    //   32	40	82	java/lang/Exception
    //   40	50	82	java/lang/Exception
    //   56	68	82	java/lang/Exception
    //   70	79	82	java/lang/Exception
    //   108	123	82	java/lang/Exception
    //   56	68	107	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity.2
 * JD-Core Version:    0.7.0.1
 */