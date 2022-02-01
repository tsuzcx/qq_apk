package com.tencent.mobileqq.qassistant.audio;

import com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.utils.VadHelper;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;

public class VoiceBeanProcessor
{
  private VoiceBeanProcessor.PttEncodeListener a;
  private AudioCompositeProcessor b;
  private VadHelper c;
  private boolean d = false;
  
  public VoiceBeanProcessor(RecordParams.RecorderParam paramRecorderParam)
  {
    try
    {
      if (this.b == null)
      {
        this.a = new VoiceBeanProcessor.PttEncodeListener();
        this.b = new AudioCompositeProcessor();
        this.b.a(new SilkCodecWrapper(BaseApplication.getContext()));
        this.b.a(paramRecorderParam.a, paramRecorderParam.b, paramRecorderParam.c);
        this.b.a(this.a);
      }
      if ((this.c == null) || (this.c.a))
      {
        this.c = new VadHelper();
        if (this.d) {
          this.c.c();
        } else {
          this.c.d();
        }
        this.c.a();
        return;
      }
    }
    catch (IOException paramRecorderParam)
    {
      paramRecorderParam.printStackTrace();
    }
  }
  
  /* Error */
  public com.tencent.mobileqq.qassistant.data.VoiceEncodeResult a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   5: lstore 4
    //   7: new 86	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 87	java/util/ArrayList:<init>	()V
    //   14: astore 8
    //   16: iconst_0
    //   17: istore_2
    //   18: iload_2
    //   19: aload_1
    //   20: arraylength
    //   21: if_icmpge +43 -> 64
    //   24: aload_1
    //   25: arraylength
    //   26: iload_2
    //   27: isub
    //   28: sipush 6400
    //   31: invokestatic 93	java/lang/Math:min	(II)I
    //   34: istore_3
    //   35: aload_0
    //   36: getfield 23	com/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor:b	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   39: aload_1
    //   40: iload_2
    //   41: iload_3
    //   42: invokevirtual 96	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	([BII)Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData;
    //   45: astore 9
    //   47: iload_2
    //   48: iload_3
    //   49: iadd
    //   50: istore_2
    //   51: aload 8
    //   53: aload 9
    //   55: invokeinterface 102 2 0
    //   60: pop
    //   61: goto -43 -> 18
    //   64: aload 8
    //   66: invokeinterface 106 1 0
    //   71: astore_1
    //   72: iconst_0
    //   73: istore_2
    //   74: aload_1
    //   75: invokeinterface 112 1 0
    //   80: ifeq +21 -> 101
    //   83: iload_2
    //   84: aload_1
    //   85: invokeinterface 116 1 0
    //   90: checkcast 118	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData
    //   93: getfield 119	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:a	I
    //   96: iadd
    //   97: istore_2
    //   98: goto -24 -> 74
    //   101: iload_2
    //   102: newarray byte
    //   104: astore_1
    //   105: aload 8
    //   107: invokeinterface 106 1 0
    //   112: astore 8
    //   114: iconst_0
    //   115: istore_2
    //   116: aload 8
    //   118: invokeinterface 112 1 0
    //   123: ifeq +42 -> 165
    //   126: aload 8
    //   128: invokeinterface 116 1 0
    //   133: checkcast 118	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData
    //   136: astore 9
    //   138: aload 9
    //   140: getfield 122	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:c	[B
    //   143: iconst_0
    //   144: aload_1
    //   145: iload_2
    //   146: aload 9
    //   148: getfield 119	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:a	I
    //   151: invokestatic 126	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   154: iload_2
    //   155: aload 9
    //   157: getfield 119	com/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor$ProcessData:a	I
    //   160: iadd
    //   161: istore_2
    //   162: goto -46 -> 116
    //   165: invokestatic 84	java/lang/System:currentTimeMillis	()J
    //   168: lstore 6
    //   170: new 128	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   177: astore 8
    //   179: aload 8
    //   181: ldc 131
    //   183: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 8
    //   189: lload 6
    //   191: lload 4
    //   193: lsub
    //   194: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: ldc 140
    //   200: aload 8
    //   202: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 149	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_0
    //   209: getfield 28	com/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor:a	Lcom/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor$PttEncodeListener;
    //   212: ifnull +51 -> 263
    //   215: aload_0
    //   216: getfield 28	com/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor:a	Lcom/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor$PttEncodeListener;
    //   219: invokevirtual 152	com/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor$PttEncodeListener:a	()I
    //   222: istore_2
    //   223: goto +3 -> 226
    //   226: new 154	com/tencent/mobileqq/qassistant/data/VoiceEncodeResult
    //   229: dup
    //   230: aload_1
    //   231: iload_2
    //   232: invokespecial 157	com/tencent/mobileqq/qassistant/data/VoiceEncodeResult:<init>	([BI)V
    //   235: astore_1
    //   236: aload_0
    //   237: monitorexit
    //   238: aload_1
    //   239: areturn
    //   240: astore_1
    //   241: goto +12 -> 253
    //   244: astore_1
    //   245: aload_1
    //   246: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   249: aload_0
    //   250: monitorexit
    //   251: aconst_null
    //   252: areturn
    //   253: aload_0
    //   254: monitorexit
    //   255: goto +5 -> 260
    //   258: aload_1
    //   259: athrow
    //   260: goto -2 -> 258
    //   263: sipush 2000
    //   266: istore_2
    //   267: goto -41 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	VoiceBeanProcessor
    //   0	270	1	paramArrayOfByte	byte[]
    //   17	250	2	i	int
    //   34	16	3	j	int
    //   5	187	4	l1	long
    //   168	22	6	l2	long
    //   14	187	8	localObject	Object
    //   45	111	9	localProcessData	com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData
    // Exception table:
    //   from	to	target	type
    //   2	16	240	finally
    //   18	47	240	finally
    //   51	61	240	finally
    //   64	72	240	finally
    //   74	98	240	finally
    //   101	114	240	finally
    //   116	162	240	finally
    //   165	223	240	finally
    //   226	236	240	finally
    //   245	249	240	finally
    //   2	16	244	java/io/IOException
    //   18	47	244	java/io/IOException
    //   51	61	244	java/io/IOException
    //   64	72	244	java/io/IOException
    //   74	98	244	java/io/IOException
    //   101	114	244	java/io/IOException
    //   116	162	244	java/io/IOException
    //   165	223	244	java/io/IOException
    //   226	236	244	java/io/IOException
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor:b	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 23	com/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor:b	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   13: invokevirtual 158	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	()V
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield 23	com/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor:b	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   21: aload_0
    //   22: getfield 62	com/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor:c	Lcom/tencent/mobileqq/utils/VadHelper;
    //   25: ifnull +27 -> 52
    //   28: aload_0
    //   29: getfield 62	com/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor:c	Lcom/tencent/mobileqq/utils/VadHelper;
    //   32: invokevirtual 160	com/tencent/mobileqq/utils/VadHelper:b	()V
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 62	com/tencent/mobileqq/qassistant/audio/VoiceBeanProcessor:c	Lcom/tencent/mobileqq/utils/VadHelper;
    //   40: goto +12 -> 52
    //   43: astore_1
    //   44: goto +11 -> 55
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	VoiceBeanProcessor
    //   43	1	1	localObject	Object
    //   47	11	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	21	43	finally
    //   21	40	43	finally
    //   48	52	43	finally
    //   2	21	47	java/io/IOException
    //   21	40	47	java/io/IOException
  }
  
  public boolean b(byte[] paramArrayOfByte)
  {
    try
    {
      boolean bool = this.c.a(paramArrayOfByte, this.d);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceBeanProcessor
 * JD-Core Version:    0.7.0.1
 */