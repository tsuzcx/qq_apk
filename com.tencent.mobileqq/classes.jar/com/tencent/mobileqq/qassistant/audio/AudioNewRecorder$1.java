package com.tencent.mobileqq.qassistant.audio;

import baja;
import balr;

public class AudioNewRecorder$1
  implements Runnable
{
  public AudioNewRecorder$1(baja parambaja, balr parambalr) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   4: invokestatic 28	baja:a	(Lbaja;)Landroid/media/AudioRecord;
    //   7: ifnull +17 -> 24
    //   10: aload_0
    //   11: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   14: invokestatic 28	baja:a	(Lbaja;)Landroid/media/AudioRecord;
    //   17: invokevirtual 34	android/media/AudioRecord:getState	()I
    //   20: iconst_1
    //   21: if_icmpeq +11 -> 32
    //   24: ldc 36
    //   26: ldc 38
    //   28: invokestatic 43	bakl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: return
    //   32: aload_0
    //   33: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   36: invokestatic 28	baja:a	(Lbaja;)Landroid/media/AudioRecord;
    //   39: invokevirtual 46	android/media/AudioRecord:startRecording	()V
    //   42: aload_0
    //   43: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   46: invokestatic 49	baja:a	(Lbaja;)I
    //   49: newarray byte
    //   51: astore_1
    //   52: aload_0
    //   53: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   56: getfield 52	baja:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: invokevirtual 58	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   62: ifeq +86 -> 148
    //   65: bipush 253
    //   67: aload_0
    //   68: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   71: invokestatic 28	baja:a	(Lbaja;)Landroid/media/AudioRecord;
    //   74: aload_1
    //   75: iconst_0
    //   76: aload_0
    //   77: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   80: invokestatic 49	baja:a	(Lbaja;)I
    //   83: invokevirtual 62	android/media/AudioRecord:read	([BII)I
    //   86: if_icmpeq -34 -> 52
    //   89: aload_0
    //   90: getfield 16	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:a	Lbalr;
    //   93: aload_1
    //   94: iconst_0
    //   95: aload_1
    //   96: arraylength
    //   97: invokeinterface 67 4 0
    //   102: goto -50 -> 52
    //   105: astore_1
    //   106: ldc 69
    //   108: new 71	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   115: ldc 74
    //   117: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 43	bakl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   137: invokevirtual 87	baja:a	()V
    //   140: aload_0
    //   141: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   144: invokevirtual 90	baja:b	()V
    //   147: return
    //   148: aload_0
    //   149: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   152: invokevirtual 87	baja:a	()V
    //   155: aload_0
    //   156: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   159: invokevirtual 90	baja:b	()V
    //   162: return
    //   163: astore_1
    //   164: aload_0
    //   165: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   168: invokevirtual 87	baja:a	()V
    //   171: aload_0
    //   172: getfield 14	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:this$0	Lbaja;
    //   175: invokevirtual 90	baja:b	()V
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	1
    //   51	45	1	arrayOfByte	byte[]
    //   105	16	1	localException	java.lang.Exception
    //   163	16	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	52	105	java/lang/Exception
    //   52	102	105	java/lang/Exception
    //   32	52	163	finally
    //   52	102	163	finally
    //   106	133	163	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewRecorder.1
 * JD-Core Version:    0.7.0.1
 */