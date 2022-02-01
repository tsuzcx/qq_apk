package com.tencent.mobileqq.qassistant.audio;

class AudioNewRecorder$2
  implements Runnable
{
  AudioNewRecorder$2(AudioNewRecorder paramAudioNewRecorder) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   4: invokestatic 25	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Landroid/media/AudioRecord;
    //   7: ifnull +198 -> 205
    //   10: aload_0
    //   11: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   14: invokestatic 25	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Landroid/media/AudioRecord;
    //   17: invokevirtual 31	android/media/AudioRecord:getState	()I
    //   20: iconst_1
    //   21: if_icmpeq +6 -> 27
    //   24: goto +181 -> 205
    //   27: aload_0
    //   28: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   31: invokestatic 35	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:c	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Lcom/tencent/mobileqq/qassistant/listener/IRecordEventListener;
    //   34: ifnull +18 -> 52
    //   37: aload_0
    //   38: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   41: invokestatic 35	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:c	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Lcom/tencent/mobileqq/qassistant/listener/IRecordEventListener;
    //   44: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   47: invokeinterface 47 3 0
    //   52: aload_0
    //   53: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   56: invokestatic 25	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Landroid/media/AudioRecord;
    //   59: invokevirtual 50	android/media/AudioRecord:startRecording	()V
    //   62: aload_0
    //   63: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   66: invokestatic 35	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:c	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Lcom/tencent/mobileqq/qassistant/listener/IRecordEventListener;
    //   69: astore_3
    //   70: iconst_0
    //   71: istore_2
    //   72: aload_3
    //   73: ifnull +140 -> 213
    //   76: aload_0
    //   77: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   80: invokestatic 35	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:c	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Lcom/tencent/mobileqq/qassistant/listener/IRecordEventListener;
    //   83: invokeinterface 52 1 0
    //   88: istore_2
    //   89: aload_0
    //   90: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   93: invokestatic 35	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:c	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Lcom/tencent/mobileqq/qassistant/listener/IRecordEventListener;
    //   96: invokeinterface 54 1 0
    //   101: istore_1
    //   102: goto +3 -> 105
    //   105: aload_0
    //   106: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   109: iload_2
    //   110: iload_1
    //   111: invokestatic 57	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;II)V
    //   114: goto +28 -> 142
    //   117: astore_3
    //   118: goto +71 -> 189
    //   121: astore_3
    //   122: aload_0
    //   123: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   126: invokestatic 35	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:c	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Lcom/tencent/mobileqq/qassistant/listener/IRecordEventListener;
    //   129: aload_3
    //   130: invokevirtual 61	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   133: invokeinterface 64 2 0
    //   138: aload_3
    //   139: invokevirtual 67	java/lang/InterruptedException:printStackTrace	()V
    //   142: aload_0
    //   143: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   146: invokevirtual 69	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	()V
    //   149: aload_0
    //   150: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   153: invokevirtual 71	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:b	()V
    //   156: aload_0
    //   157: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   160: invokestatic 35	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:c	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Lcom/tencent/mobileqq/qassistant/listener/IRecordEventListener;
    //   163: ifnull +25 -> 188
    //   166: aload_0
    //   167: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   170: invokestatic 35	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:c	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Lcom/tencent/mobileqq/qassistant/listener/IRecordEventListener;
    //   173: aload_0
    //   174: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   177: getfield 74	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:b	Ljava/util/concurrent/atomic/AtomicLong;
    //   180: invokevirtual 79	java/util/concurrent/atomic/AtomicLong:get	()J
    //   183: invokeinterface 81 3 0
    //   188: return
    //   189: aload_0
    //   190: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   193: invokevirtual 69	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	()V
    //   196: aload_0
    //   197: getfield 12	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$2:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   200: invokevirtual 71	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:b	()V
    //   203: aload_3
    //   204: athrow
    //   205: ldc 83
    //   207: ldc 85
    //   209: invokestatic 90	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: return
    //   213: iconst_0
    //   214: istore_1
    //   215: goto -110 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	2
    //   101	114	1	i	int
    //   71	39	2	j	int
    //   69	4	3	localIRecordEventListener	com.tencent.mobileqq.qassistant.listener.IRecordEventListener
    //   117	1	3	localObject	Object
    //   121	83	3	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   27	52	117	finally
    //   52	70	117	finally
    //   76	102	117	finally
    //   105	114	117	finally
    //   122	142	117	finally
    //   27	52	121	java/lang/InterruptedException
    //   52	70	121	java/lang/InterruptedException
    //   76	102	121	java/lang/InterruptedException
    //   105	114	121	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewRecorder.2
 * JD-Core Version:    0.7.0.1
 */