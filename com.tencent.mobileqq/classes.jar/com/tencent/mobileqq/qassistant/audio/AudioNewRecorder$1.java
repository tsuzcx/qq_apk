package com.tencent.mobileqq.qassistant.audio;

import azdl;
import azga;

public class AudioNewRecorder$1
  implements Runnable
{
  public AudioNewRecorder$1(azdl paramazdl, azga paramazga) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   4: invokestatic 28	azdl:a	(Lazdl;)Landroid/media/AudioRecord;
    //   7: ifnull +17 -> 24
    //   10: aload_0
    //   11: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   14: invokestatic 28	azdl:a	(Lazdl;)Landroid/media/AudioRecord;
    //   17: invokevirtual 34	android/media/AudioRecord:getState	()I
    //   20: iconst_1
    //   21: if_icmpeq +11 -> 32
    //   24: ldc 36
    //   26: ldc 38
    //   28: invokestatic 43	azeu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: return
    //   32: ldc 36
    //   34: new 45	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   41: ldc 48
    //   43: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   50: invokestatic 28	azdl:a	(Lazdl;)Landroid/media/AudioRecord;
    //   53: invokevirtual 34	android/media/AudioRecord:getState	()I
    //   56: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 43	azeu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   69: invokestatic 28	azdl:a	(Lazdl;)Landroid/media/AudioRecord;
    //   72: invokevirtual 62	android/media/AudioRecord:startRecording	()V
    //   75: aload_0
    //   76: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   79: invokestatic 65	azdl:a	(Lazdl;)I
    //   82: newarray byte
    //   84: astore_1
    //   85: aload_0
    //   86: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   89: getfield 68	azdl:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   92: invokevirtual 74	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   95: ifeq +86 -> 181
    //   98: bipush 253
    //   100: aload_0
    //   101: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   104: invokestatic 28	azdl:a	(Lazdl;)Landroid/media/AudioRecord;
    //   107: aload_1
    //   108: iconst_0
    //   109: aload_0
    //   110: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   113: invokestatic 65	azdl:a	(Lazdl;)I
    //   116: invokevirtual 78	android/media/AudioRecord:read	([BII)I
    //   119: if_icmpeq -34 -> 85
    //   122: aload_0
    //   123: getfield 16	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:a	Lazga;
    //   126: aload_1
    //   127: iconst_0
    //   128: aload_1
    //   129: arraylength
    //   130: invokeinterface 83 4 0
    //   135: goto -50 -> 85
    //   138: astore_1
    //   139: ldc 85
    //   141: new 45	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   148: ldc 87
    //   150: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: invokevirtual 90	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 43	azeu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_0
    //   167: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   170: invokevirtual 92	azdl:a	()V
    //   173: aload_0
    //   174: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   177: invokevirtual 95	azdl:b	()V
    //   180: return
    //   181: aload_0
    //   182: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   185: invokevirtual 92	azdl:a	()V
    //   188: aload_0
    //   189: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   192: invokevirtual 95	azdl:b	()V
    //   195: return
    //   196: astore_1
    //   197: aload_0
    //   198: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   201: invokevirtual 92	azdl:a	()V
    //   204: aload_0
    //   205: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lazdl;
    //   208: invokevirtual 95	azdl:b	()V
    //   211: aload_1
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	1
    //   84	45	1	arrayOfByte	byte[]
    //   138	16	1	localException	java.lang.Exception
    //   196	16	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   65	85	138	java/lang/Exception
    //   85	135	138	java/lang/Exception
    //   65	85	196	finally
    //   85	135	196	finally
    //   139	166	196	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewRecorder.1
 * JD-Core Version:    0.7.0.1
 */