package com.tencent.mobileqq.magicface.model;

import android.media.AudioRecord;

public class RecordVolume
  implements Runnable
{
  private RecordVolume.RecordVolumeListener a;
  private AudioRecord b;
  private int c;
  private volatile boolean d = false;
  
  public RecordVolume(RecordVolume.RecordVolumeListener paramRecordVolumeListener)
  {
    this.a = paramRecordVolumeListener;
  }
  
  public void a()
  {
    this.d = false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 33	com/tencent/mobileqq/utils/RecordParams:a	I
    //   3: istore 5
    //   5: aload_0
    //   6: iload 5
    //   8: iconst_2
    //   9: iconst_2
    //   10: invokestatic 39	android/media/AudioRecord:getMinBufferSize	(III)I
    //   13: putfield 41	com/tencent/mobileqq/magicface/model/RecordVolume:c	I
    //   16: aload_0
    //   17: new 35	android/media/AudioRecord
    //   20: dup
    //   21: iconst_1
    //   22: iload 5
    //   24: iconst_2
    //   25: iconst_2
    //   26: aload_0
    //   27: getfield 41	com/tencent/mobileqq/magicface/model/RecordVolume:c	I
    //   30: invokespecial 44	android/media/AudioRecord:<init>	(IIIII)V
    //   33: putfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   36: aload_0
    //   37: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   40: invokevirtual 49	android/media/AudioRecord:startRecording	()V
    //   43: aload_0
    //   44: getfield 41	com/tencent/mobileqq/magicface/model/RecordVolume:c	I
    //   47: newarray short
    //   49: astore 12
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 21	com/tencent/mobileqq/magicface/model/RecordVolume:d	Z
    //   56: aload_0
    //   57: getfield 21	com/tencent/mobileqq/magicface/model/RecordVolume:d	Z
    //   60: istore 9
    //   62: iload 9
    //   64: ifeq +199 -> 263
    //   67: aload_0
    //   68: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   71: astore 13
    //   73: aload_0
    //   74: getfield 41	com/tencent/mobileqq/magicface/model/RecordVolume:c	I
    //   77: istore 6
    //   79: iconst_0
    //   80: istore 5
    //   82: aload 13
    //   84: aload 12
    //   86: iconst_0
    //   87: iload 6
    //   89: invokevirtual 53	android/media/AudioRecord:read	([SII)I
    //   92: istore 6
    //   94: lconst_0
    //   95: lstore 10
    //   97: iload 5
    //   99: aload 12
    //   101: arraylength
    //   102: if_icmpge +37 -> 139
    //   105: aload 12
    //   107: iload 5
    //   109: saload
    //   110: istore 7
    //   112: aload 12
    //   114: iload 5
    //   116: saload
    //   117: istore 8
    //   119: lload 10
    //   121: iload 7
    //   123: iload 8
    //   125: imul
    //   126: i2l
    //   127: ladd
    //   128: lstore 10
    //   130: iload 5
    //   132: iconst_1
    //   133: iadd
    //   134: istore 5
    //   136: goto -39 -> 97
    //   139: iload 6
    //   141: ifeq +103 -> 244
    //   144: lload 10
    //   146: lconst_0
    //   147: lcmp
    //   148: ifeq +96 -> 244
    //   151: lload 10
    //   153: l2d
    //   154: dstore_1
    //   155: iload 6
    //   157: i2d
    //   158: dstore_3
    //   159: dload_1
    //   160: invokestatic 59	java/lang/Double:isNaN	(D)Z
    //   163: pop
    //   164: dload_3
    //   165: invokestatic 59	java/lang/Double:isNaN	(D)Z
    //   168: pop
    //   169: dload_1
    //   170: dload_3
    //   171: ddiv
    //   172: dstore_1
    //   173: dload_1
    //   174: invokestatic 65	java/lang/Math:log10	(D)D
    //   177: ldc2_w 66
    //   180: dmul
    //   181: dstore_1
    //   182: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +38 -> 223
    //   188: new 75	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   195: astore 13
    //   197: aload 13
    //   199: ldc 78
    //   201: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 13
    //   207: dload_1
    //   208: invokevirtual 85	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: ldc 87
    //   214: iconst_2
    //   215: aload 13
    //   217: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_0
    //   224: getfield 23	com/tencent/mobileqq/magicface/model/RecordVolume:a	Lcom/tencent/mobileqq/magicface/model/RecordVolume$RecordVolumeListener;
    //   227: ifnull +17 -> 244
    //   230: aload_0
    //   231: getfield 23	com/tencent/mobileqq/magicface/model/RecordVolume:a	Lcom/tencent/mobileqq/magicface/model/RecordVolume$RecordVolumeListener;
    //   234: dload_1
    //   235: invokestatic 99	java/lang/Math:round	(D)J
    //   238: l2i
    //   239: invokeinterface 104 2 0
    //   244: ldc2_w 105
    //   247: invokestatic 112	java/lang/Thread:sleep	(J)V
    //   250: goto -194 -> 56
    //   253: astore 13
    //   255: aload 13
    //   257: invokevirtual 115	java/lang/InterruptedException:printStackTrace	()V
    //   260: goto -204 -> 56
    //   263: aload_0
    //   264: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   267: astore 12
    //   269: aload 12
    //   271: ifnull +205 -> 476
    //   274: aload 12
    //   276: invokevirtual 119	android/media/AudioRecord:getRecordingState	()I
    //   279: iconst_3
    //   280: if_icmpne +60 -> 340
    //   283: aload_0
    //   284: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   287: invokevirtual 122	android/media/AudioRecord:stop	()V
    //   290: goto +50 -> 340
    //   293: astore 12
    //   295: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +42 -> 340
    //   301: new 75	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   308: astore 13
    //   310: aload 13
    //   312: ldc 124
    //   314: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 13
    //   320: aload 12
    //   322: invokevirtual 127	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   325: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: ldc 129
    //   331: iconst_2
    //   332: aload 13
    //   334: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload_0
    //   341: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   344: invokevirtual 132	android/media/AudioRecord:release	()V
    //   347: aload_0
    //   348: aconst_null
    //   349: putfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   352: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +121 -> 476
    //   358: goto +110 -> 468
    //   361: astore 12
    //   363: goto +114 -> 477
    //   366: astore 12
    //   368: aload 12
    //   370: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   373: aload_0
    //   374: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   377: astore 12
    //   379: aload 12
    //   381: ifnull +95 -> 476
    //   384: aload 12
    //   386: invokevirtual 119	android/media/AudioRecord:getRecordingState	()I
    //   389: iconst_3
    //   390: if_icmpne +60 -> 450
    //   393: aload_0
    //   394: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   397: invokevirtual 122	android/media/AudioRecord:stop	()V
    //   400: goto +50 -> 450
    //   403: astore 12
    //   405: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +42 -> 450
    //   411: new 75	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   418: astore 13
    //   420: aload 13
    //   422: ldc 124
    //   424: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 13
    //   430: aload 12
    //   432: invokevirtual 127	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   435: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: ldc 129
    //   441: iconst_2
    //   442: aload 13
    //   444: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aload_0
    //   451: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   454: invokevirtual 132	android/media/AudioRecord:release	()V
    //   457: aload_0
    //   458: aconst_null
    //   459: putfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   462: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq +11 -> 476
    //   468: ldc 129
    //   470: iconst_2
    //   471: ldc 135
    //   473: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: return
    //   477: aload_0
    //   478: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   481: astore 13
    //   483: aload 13
    //   485: ifnull +95 -> 580
    //   488: aload 13
    //   490: invokevirtual 119	android/media/AudioRecord:getRecordingState	()I
    //   493: iconst_3
    //   494: if_icmpne +60 -> 554
    //   497: aload_0
    //   498: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   501: invokevirtual 122	android/media/AudioRecord:stop	()V
    //   504: goto +50 -> 554
    //   507: astore 13
    //   509: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +42 -> 554
    //   515: new 75	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   522: astore 14
    //   524: aload 14
    //   526: ldc 124
    //   528: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 14
    //   534: aload 13
    //   536: invokevirtual 127	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   539: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: ldc 129
    //   545: iconst_2
    //   546: aload 14
    //   548: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: aload_0
    //   555: getfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   558: invokevirtual 132	android/media/AudioRecord:release	()V
    //   561: aload_0
    //   562: aconst_null
    //   563: putfield 46	com/tencent/mobileqq/magicface/model/RecordVolume:b	Landroid/media/AudioRecord;
    //   566: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq +11 -> 580
    //   572: ldc 129
    //   574: iconst_2
    //   575: ldc 135
    //   577: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: goto +6 -> 586
    //   583: aload 12
    //   585: athrow
    //   586: goto -3 -> 583
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	RecordVolume
    //   154	81	1	d1	double
    //   158	13	3	d2	double
    //   3	132	5	i	int
    //   77	79	6	j	int
    //   110	16	7	k	int
    //   117	9	8	m	int
    //   60	3	9	bool	boolean
    //   95	57	10	l	long
    //   49	226	12	localObject1	Object
    //   293	28	12	localException1	java.lang.Exception
    //   361	1	12	localObject2	Object
    //   366	3	12	localException2	java.lang.Exception
    //   377	8	12	localAudioRecord	AudioRecord
    //   403	181	12	localException3	java.lang.Exception
    //   71	145	13	localObject3	Object
    //   253	3	13	localInterruptedException	java.lang.InterruptedException
    //   308	181	13	localObject4	Object
    //   507	28	13	localException4	java.lang.Exception
    //   522	25	14	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   67	79	253	java/lang/InterruptedException
    //   82	94	253	java/lang/InterruptedException
    //   97	105	253	java/lang/InterruptedException
    //   173	223	253	java/lang/InterruptedException
    //   223	244	253	java/lang/InterruptedException
    //   244	250	253	java/lang/InterruptedException
    //   274	290	293	java/lang/Exception
    //   0	56	361	finally
    //   56	62	361	finally
    //   67	79	361	finally
    //   82	94	361	finally
    //   97	105	361	finally
    //   173	223	361	finally
    //   223	244	361	finally
    //   244	250	361	finally
    //   255	260	361	finally
    //   368	373	361	finally
    //   0	56	366	java/lang/Exception
    //   56	62	366	java/lang/Exception
    //   67	79	366	java/lang/Exception
    //   82	94	366	java/lang/Exception
    //   97	105	366	java/lang/Exception
    //   173	223	366	java/lang/Exception
    //   223	244	366	java/lang/Exception
    //   244	250	366	java/lang/Exception
    //   255	260	366	java/lang/Exception
    //   384	400	403	java/lang/Exception
    //   488	504	507	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.RecordVolume
 * JD-Core Version:    0.7.0.1
 */