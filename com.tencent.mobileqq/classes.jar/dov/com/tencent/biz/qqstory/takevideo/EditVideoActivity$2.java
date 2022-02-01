package dov.com.tencent.biz.qqstory.takevideo;

class EditVideoActivity$2
  implements Runnable
{
  EditVideoActivity$2(EditVideoActivity paramEditVideoActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 29	bnky:c	()Z
    //   3: pop
    //   4: ldc 31
    //   6: aload_0
    //   7: getfield 12	dov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2:this$0	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoActivity;
    //   10: invokevirtual 37	dov/com/tencent/biz/qqstory/takevideo/EditVideoActivity:getApplicationContext	()Landroid/content/Context;
    //   13: invokestatic 43	com/tencent/mobileqq/shortvideo/VideoEnvironment:loadAVCodecSo	(Ljava/lang/String;Landroid/content/Context;)I
    //   16: ifeq +25 -> 41
    //   19: ldc 45
    //   21: ldc 47
    //   23: invokestatic 53	ykq:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: invokestatic 59	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   29: new 61	dov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2$1
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 64	dov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2$1:<init>	(Ldov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2;)V
    //   37: invokevirtual 70	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   40: pop
    //   41: iconst_1
    //   42: invokestatic 76	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:nativeSetPlayStepFrameCount	(I)V
    //   45: iconst_1
    //   46: invokestatic 79	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:nativeSetPlayGapFrameCount	(I)V
    //   49: invokestatic 84	ykw:a	()Z
    //   52: ifeq +25 -> 77
    //   55: invokestatic 88	com/tencent/mobileqq/shortvideo/VideoEnvironment:getAVCodecVersion	()I
    //   58: istore_1
    //   59: iload_1
    //   60: bipush 21
    //   62: if_icmplt +15 -> 77
    //   65: iconst_3
    //   66: invokestatic 92	com/tencent/mobileqq/shortvideo/hwcodec/VideoSourceHelper:nativeSetMaxPhotoFrameCount	(I)I
    //   69: pop
    //   70: ldc 45
    //   72: ldc 94
    //   74: invokestatic 97	ykq:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: return
    //   78: astore_2
    //   79: ldc 45
    //   81: iconst_1
    //   82: ldc 99
    //   84: aload_2
    //   85: invokestatic 105	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   88: goto -39 -> 49
    //   91: astore_2
    //   92: ldc 45
    //   94: ldc 47
    //   96: aload_2
    //   97: invokestatic 108	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: invokestatic 59	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   103: new 110	dov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2$2
    //   106: dup
    //   107: aload_0
    //   108: invokespecial 111	dov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2$2:<init>	(Ldov/com/tencent/biz/qqstory/takevideo/EditVideoActivity$2;)V
    //   111: invokevirtual 70	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   114: pop
    //   115: return
    //   116: astore_2
    //   117: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq -43 -> 77
    //   123: ldc 45
    //   125: iconst_2
    //   126: ldc 116
    //   128: aload_2
    //   129: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	2
    //   58	5	1	i	int
    //   78	7	2	localThrowable	java.lang.Throwable
    //   91	6	2	localException	java.lang.Exception
    //   116	13	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   41	49	78	java/lang/Throwable
    //   0	41	91	java/lang/Exception
    //   41	49	91	java/lang/Exception
    //   49	59	91	java/lang/Exception
    //   65	77	91	java/lang/Exception
    //   79	88	91	java/lang/Exception
    //   117	132	91	java/lang/Exception
    //   65	77	116	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity.2
 * JD-Core Version:    0.7.0.1
 */