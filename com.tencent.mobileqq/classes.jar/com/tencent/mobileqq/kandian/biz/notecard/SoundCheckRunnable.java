package com.tencent.mobileqq.kandian.biz.notecard;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;

public class SoundCheckRunnable
  implements Runnable
{
  private static String a = "SoundCheckRunnable";
  private int b = AudioRecord.getMinBufferSize(8000, 2, 2);
  private AudioRecord c = new AudioRecord(1, 8000, 2, 2, this.b);
  private SoundCheckRunnable.OnSoundActionListener d;
  private Handler e = new Handler(Looper.getMainLooper());
  private float f = 1.0F;
  private boolean g = true;
  
  public void a()
  {
    this.g = false;
  }
  
  public void a(SoundCheckRunnable.OnSoundActionListener paramOnSoundActionListener)
  {
    this.d = paramOnSoundActionListener;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:c	Landroid/media/AudioRecord;
    //   4: invokevirtual 75	android/media/AudioRecord:startRecording	()V
    //   7: aload_0
    //   8: getfield 53	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:b	I
    //   11: newarray byte
    //   13: astore 10
    //   15: new 77	java/util/LinkedList
    //   18: dup
    //   19: invokespecial 78	java/util/LinkedList:<init>	()V
    //   22: astore 11
    //   24: lconst_0
    //   25: lstore 6
    //   27: aload_0
    //   28: getfield 45	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:g	Z
    //   31: ifeq +266 -> 297
    //   34: ldc2_w 79
    //   37: invokestatic 86	java/lang/Thread:sleep	(J)V
    //   40: goto +10 -> 50
    //   43: astore 12
    //   45: aload 12
    //   47: invokevirtual 89	java/lang/InterruptedException:printStackTrace	()V
    //   50: aload_0
    //   51: getfield 58	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:c	Landroid/media/AudioRecord;
    //   54: astore 12
    //   56: aload_0
    //   57: getfield 53	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:b	I
    //   60: istore_2
    //   61: iconst_0
    //   62: istore_1
    //   63: aload 12
    //   65: aload 10
    //   67: iconst_0
    //   68: iload_2
    //   69: invokevirtual 93	android/media/AudioRecord:read	([BII)I
    //   72: istore_3
    //   73: aload 10
    //   75: arraylength
    //   76: istore 4
    //   78: iconst_0
    //   79: istore_2
    //   80: iload_1
    //   81: iload 4
    //   83: if_icmpge +24 -> 107
    //   86: aload 10
    //   88: iload_1
    //   89: baload
    //   90: istore 5
    //   92: iload_2
    //   93: iload 5
    //   95: iload 5
    //   97: imul
    //   98: iadd
    //   99: istore_2
    //   100: iload_1
    //   101: iconst_1
    //   102: iadd
    //   103: istore_1
    //   104: goto -24 -> 80
    //   107: iload_2
    //   108: iload_3
    //   109: iconst_1
    //   110: iadd
    //   111: idiv
    //   112: istore_1
    //   113: aload 11
    //   115: iload_1
    //   116: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokevirtual 103	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   122: pop
    //   123: lload 6
    //   125: iload_1
    //   126: i2l
    //   127: ladd
    //   128: lstore 8
    //   130: lload 8
    //   132: lstore 6
    //   134: aload 11
    //   136: invokevirtual 107	java/util/LinkedList:size	()I
    //   139: bipush 10
    //   141: if_icmple +20 -> 161
    //   144: lload 8
    //   146: aload 11
    //   148: invokevirtual 111	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   151: checkcast 95	java/lang/Integer
    //   154: invokevirtual 114	java/lang/Integer:intValue	()I
    //   157: i2l
    //   158: lsub
    //   159: lstore 6
    //   161: lload 6
    //   163: aload 11
    //   165: invokevirtual 107	java/util/LinkedList:size	()I
    //   168: i2l
    //   169: ldiv
    //   170: l2i
    //   171: istore_2
    //   172: getstatic 120	java/lang/System:out	Ljava/io/PrintStream;
    //   175: astore 12
    //   177: new 122	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   184: astore 13
    //   186: aload 13
    //   188: ldc 125
    //   190: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 13
    //   196: iload_1
    //   197: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 13
    //   203: ldc 134
    //   205: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 13
    //   211: iload_2
    //   212: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 13
    //   218: ldc 136
    //   220: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 13
    //   226: aload_0
    //   227: getfield 43	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:f	F
    //   230: ldc 137
    //   232: fmul
    //   233: invokevirtual 140	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 12
    //   239: aload 13
    //   241: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokevirtual 150	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   247: iload_2
    //   248: i2f
    //   249: aload_0
    //   250: getfield 43	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:f	F
    //   253: ldc 137
    //   255: fmul
    //   256: fcmpl
    //   257: ifle -230 -> 27
    //   260: aload_0
    //   261: getfield 66	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:d	Lcom/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable$OnSoundActionListener;
    //   264: astore 12
    //   266: aload 12
    //   268: ifnull +21 -> 289
    //   271: aload_0
    //   272: getfield 41	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:e	Landroid/os/Handler;
    //   275: new 152	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable$1
    //   278: dup
    //   279: aload_0
    //   280: aload 12
    //   282: invokespecial 155	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable$1:<init>	(Lcom/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable;Lcom/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable$OnSoundActionListener;)V
    //   285: invokevirtual 159	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   288: pop
    //   289: aload 11
    //   291: invokevirtual 162	java/util/LinkedList:clear	()V
    //   294: goto -270 -> 24
    //   297: aload_0
    //   298: getfield 58	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:c	Landroid/media/AudioRecord;
    //   301: invokevirtual 165	android/media/AudioRecord:stop	()V
    //   304: aload_0
    //   305: getfield 58	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:c	Landroid/media/AudioRecord;
    //   308: invokevirtual 168	android/media/AudioRecord:release	()V
    //   311: return
    //   312: astore 10
    //   314: invokestatic 173	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   317: ifeq +15 -> 332
    //   320: getstatic 175	com/tencent/mobileqq/kandian/biz/notecard/SoundCheckRunnable:a	Ljava/lang/String;
    //   323: iconst_1
    //   324: aload 10
    //   326: invokevirtual 176	java/lang/Exception:toString	()Ljava/lang/String;
    //   329: invokestatic 179	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: return
    //   333: astore 10
    //   335: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	SoundCheckRunnable
    //   62	135	1	i	int
    //   60	188	2	j	int
    //   72	39	3	k	int
    //   76	8	4	m	int
    //   90	8	5	n	int
    //   25	137	6	l1	long
    //   128	17	8	l2	long
    //   13	74	10	arrayOfByte	byte[]
    //   312	13	10	localException1	java.lang.Exception
    //   333	1	10	localException2	java.lang.Exception
    //   22	268	11	localLinkedList	java.util.LinkedList
    //   43	3	12	localInterruptedException	java.lang.InterruptedException
    //   54	227	12	localObject	Object
    //   184	56	13	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	40	43	java/lang/InterruptedException
    //   0	7	312	java/lang/Exception
    //   297	311	333	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.notecard.SoundCheckRunnable
 * JD-Core Version:    0.7.0.1
 */