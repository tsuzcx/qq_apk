package com.tencent.mobileqq.qassistant.audio;

import com.tencent.mobileqq.qassistant.listener.IRecordStreamListener;

class AudioNewRecorder$1
  implements Runnable
{
  AudioNewRecorder$1(AudioNewRecorder paramAudioNewRecorder, IRecordStreamListener paramIRecordStreamListener) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   4: invokestatic 28	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Landroid/media/AudioRecord;
    //   7: ifnull +225 -> 232
    //   10: aload_0
    //   11: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   14: invokestatic 28	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Landroid/media/AudioRecord;
    //   17: invokevirtual 34	android/media/AudioRecord:getState	()I
    //   20: iconst_1
    //   21: if_icmpeq +6 -> 27
    //   24: goto +208 -> 232
    //   27: aload_0
    //   28: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   31: invokestatic 28	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Landroid/media/AudioRecord;
    //   34: invokevirtual 37	android/media/AudioRecord:startRecording	()V
    //   37: aload_0
    //   38: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   41: invokestatic 40	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)I
    //   44: newarray byte
    //   46: astore 4
    //   48: goto +192 -> 240
    //   51: aload_0
    //   52: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   55: getfield 43	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   58: invokevirtual 49	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   61: ifeq +139 -> 200
    //   64: aload_0
    //   65: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   68: invokestatic 28	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)Landroid/media/AudioRecord;
    //   71: aload 4
    //   73: iconst_0
    //   74: aload_0
    //   75: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   78: invokestatic 40	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	(Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;)I
    //   81: invokevirtual 53	android/media/AudioRecord:read	([BII)I
    //   84: istore_3
    //   85: iload_3
    //   86: ifle +21 -> 107
    //   89: aload_0
    //   90: getfield 16	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:a	Lcom/tencent/mobileqq/qassistant/listener/IRecordStreamListener;
    //   93: aload 4
    //   95: iconst_0
    //   96: aload 4
    //   98: arraylength
    //   99: invokeinterface 58 4 0
    //   104: goto +136 -> 240
    //   107: iload_1
    //   108: iconst_1
    //   109: iadd
    //   110: istore_2
    //   111: new 60	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   118: astore 5
    //   120: aload 5
    //   122: ldc 63
    //   124: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 5
    //   130: iload_3
    //   131: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: ldc 72
    //   137: aload 5
    //   139: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 81	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: iload_2
    //   146: istore_1
    //   147: iload_2
    //   148: iconst_5
    //   149: if_icmplt -98 -> 51
    //   152: goto +48 -> 200
    //   155: astore 4
    //   157: goto +58 -> 215
    //   160: astore 4
    //   162: new 60	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   169: astore 5
    //   171: aload 5
    //   173: ldc 83
    //   175: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 5
    //   181: aload 4
    //   183: invokevirtual 86	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   186: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: ldc 72
    //   192: aload 5
    //   194: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 81	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload_0
    //   201: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   204: invokevirtual 88	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	()V
    //   207: aload_0
    //   208: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   211: invokevirtual 91	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:b	()V
    //   214: return
    //   215: aload_0
    //   216: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   219: invokevirtual 88	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:a	()V
    //   222: aload_0
    //   223: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lcom/tencent/mobileqq/qassistant/audio/AudioNewRecorder;
    //   226: invokevirtual 91	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder:b	()V
    //   229: aload 4
    //   231: athrow
    //   232: ldc 93
    //   234: ldc 95
    //   236: invokestatic 81	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: return
    //   240: iconst_0
    //   241: istore_1
    //   242: goto -191 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	1
    //   107	135	1	i	int
    //   110	40	2	j	int
    //   84	47	3	k	int
    //   46	51	4	arrayOfByte	byte[]
    //   155	1	4	localObject	Object
    //   160	70	4	localException	java.lang.Exception
    //   118	75	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   27	48	155	finally
    //   51	85	155	finally
    //   89	104	155	finally
    //   111	145	155	finally
    //   162	200	155	finally
    //   27	48	160	java/lang/Exception
    //   51	85	160	java/lang/Exception
    //   89	104	160	java/lang/Exception
    //   111	145	160	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewRecorder.1
 * JD-Core Version:    0.7.0.1
 */