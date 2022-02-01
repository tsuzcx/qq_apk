package com.tencent.mobileqq.emoticon;

class EPRecommendTask$1
  implements Runnable
{
  EPRecommendTask$1(EPRecommendTask paramEPRecommendTask) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 27	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +65 -> 72
    //   10: new 35	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   17: astore 5
    //   19: aload 5
    //   21: ldc 38
    //   23: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 5
    //   29: aload_0
    //   30: getfield 12	com/tencent/mobileqq/emoticon/EPRecommendTask$1:this$0	Lcom/tencent/mobileqq/emoticon/EPRecommendTask;
    //   33: getfield 48	com/tencent/mobileqq/emoticon/EPRecommendTask:b	Ljava/lang/String;
    //   36: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 5
    //   42: ldc 50
    //   44: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 5
    //   50: aload_0
    //   51: getfield 12	com/tencent/mobileqq/emoticon/EPRecommendTask$1:this$0	Lcom/tencent/mobileqq/emoticon/EPRecommendTask;
    //   54: getfield 53	com/tencent/mobileqq/emoticon/EPRecommendTask:c	Ljava/lang/String;
    //   57: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc 55
    //   63: iconst_2
    //   64: aload 5
    //   66: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_0
    //   73: getfield 12	com/tencent/mobileqq/emoticon/EPRecommendTask$1:this$0	Lcom/tencent/mobileqq/emoticon/EPRecommendTask;
    //   76: getfield 67	com/tencent/mobileqq/emoticon/EPRecommendTask:a	Lmqq/util/WeakReference;
    //   79: invokevirtual 73	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   82: checkcast 75	com/tencent/common/app/business/BaseQQAppInterface
    //   85: astore 5
    //   87: aload 5
    //   89: ifnonnull +4 -> 93
    //   92: return
    //   93: aload 5
    //   95: ldc 77
    //   97: iconst_1
    //   98: aload_0
    //   99: getfield 12	com/tencent/mobileqq/emoticon/EPRecommendTask$1:this$0	Lcom/tencent/mobileqq/emoticon/EPRecommendTask;
    //   102: getfield 81	com/tencent/mobileqq/emoticon/EPRecommendTask:e	Lcom/tencent/mobileqq/vas/updatesystem/callback/CallBacker;
    //   105: invokestatic 86	com/tencent/mobileqq/vas/updatesystem/VasUpdateUtil:a	(Lmqq/app/AppRuntime;Ljava/lang/String;ZLcom/tencent/mobileqq/vas/updatesystem/callback/CallBacker;)Lorg/json/JSONObject;
    //   108: astore 5
    //   110: aload_0
    //   111: getfield 12	com/tencent/mobileqq/emoticon/EPRecommendTask$1:this$0	Lcom/tencent/mobileqq/emoticon/EPRecommendTask;
    //   114: aload 5
    //   116: invokevirtual 89	com/tencent/mobileqq/emoticon/EPRecommendTask:a	(Lorg/json/JSONObject;)V
    //   119: goto +25 -> 144
    //   122: goto +22 -> 144
    //   125: astore 5
    //   127: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +14 -> 144
    //   133: ldc 91
    //   135: iconst_2
    //   136: aload 5
    //   138: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   141: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: invokestatic 27	java/lang/System:currentTimeMillis	()J
    //   147: lstore_3
    //   148: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +61 -> 212
    //   154: new 35	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   161: astore 5
    //   163: aload 5
    //   165: ldc 96
    //   167: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 5
    //   173: lload_3
    //   174: lload_1
    //   175: lsub
    //   176: invokevirtual 99	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 5
    //   182: ldc 50
    //   184: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 5
    //   190: aload_0
    //   191: getfield 12	com/tencent/mobileqq/emoticon/EPRecommendTask$1:this$0	Lcom/tencent/mobileqq/emoticon/EPRecommendTask;
    //   194: getfield 53	com/tencent/mobileqq/emoticon/EPRecommendTask:c	Ljava/lang/String;
    //   197: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc 55
    //   203: iconst_2
    //   204: aload 5
    //   206: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: return
    //   213: astore 5
    //   215: goto -93 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	1
    //   3	172	1	l1	long
    //   147	27	3	l2	long
    //   17	98	5	localObject	Object
    //   125	12	5	localException	java.lang.Exception
    //   161	44	5	localStringBuilder	java.lang.StringBuilder
    //   213	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   72	87	125	java/lang/Exception
    //   93	119	125	java/lang/Exception
    //   72	87	213	java/lang/OutOfMemoryError
    //   93	119	213	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPRecommendTask.1
 * JD-Core Version:    0.7.0.1
 */