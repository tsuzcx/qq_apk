package com.tencent.ttpic.voicechanger.common.audio;

class AudioRecorderCompat$SimpleRecordThread
  extends Thread
{
  private static final String TAG = "SimpleRecordThread";
  
  public AudioRecorderCompat$SimpleRecordThread(AudioRecorderCompat paramAudioRecorderCompat, String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 8
    //   2: new 26	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   9: aload_0
    //   10: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
    //   13: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 38
    //   18: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   31: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   34: astore 4
    //   36: aload 4
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   43: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   46: iconst_1
    //   47: newarray int
    //   49: dup
    //   50: iconst_0
    //   51: iconst_4
    //   52: iastore
    //   53: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:equalState	([I)Z
    //   56: ifeq +94 -> 150
    //   59: ldc 8
    //   61: ldc 61
    //   63: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc 8
    //   68: new 26	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   75: aload_0
    //   76: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
    //   79: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 66
    //   84: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   91: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   94: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   107: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   110: invokevirtual 74	java/lang/Object:wait	()V
    //   113: ldc 8
    //   115: new 26	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   122: aload_0
    //   123: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
    //   126: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 76
    //   131: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   138: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   141: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload 4
    //   152: monitorexit
    //   153: aload_0
    //   154: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   157: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   160: astore 4
    //   162: aload 4
    //   164: monitorenter
    //   165: aload_0
    //   166: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   169: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   172: iconst_1
    //   173: newarray int
    //   175: dup
    //   176: iconst_0
    //   177: bipush 16
    //   179: iastore
    //   180: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:equalState	([I)Z
    //   183: ifeq +148 -> 331
    //   186: ldc 8
    //   188: ldc 78
    //   190: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   197: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   200: invokevirtual 88	android/media/AudioRecord:getRecordingState	()I
    //   203: iconst_3
    //   204: if_icmpne +43 -> 247
    //   207: ldc 8
    //   209: new 26	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   216: ldc 90
    //   218: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   225: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   228: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_0
    //   238: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   241: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   244: invokevirtual 93	android/media/AudioRecord:stop	()V
    //   247: ldc 8
    //   249: new 26	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   256: aload_0
    //   257: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
    //   260: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 66
    //   265: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   272: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   275: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_0
    //   285: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   288: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   291: invokevirtual 74	java/lang/Object:wait	()V
    //   294: ldc 8
    //   296: new 26	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   303: aload_0
    //   304: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
    //   307: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc 76
    //   312: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   319: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   322: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 4
    //   333: monitorexit
    //   334: aload_0
    //   335: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   338: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   341: iconst_2
    //   342: newarray int
    //   344: dup
    //   345: iconst_0
    //   346: bipush 32
    //   348: iastore
    //   349: dup
    //   350: iconst_1
    //   351: iconst_1
    //   352: iastore
    //   353: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:equalState	([I)Z
    //   356: ifeq +159 -> 515
    //   359: ldc 8
    //   361: ldc 95
    //   363: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_0
    //   367: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   370: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   373: invokevirtual 88	android/media/AudioRecord:getRecordingState	()I
    //   376: iconst_3
    //   377: if_icmpne +43 -> 420
    //   380: ldc 8
    //   382: new 26	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   389: ldc 90
    //   391: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_0
    //   395: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   398: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   401: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: aload_0
    //   411: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   414: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   417: invokevirtual 93	android/media/AudioRecord:stop	()V
    //   420: aload_0
    //   421: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   424: invokevirtual 98	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onRecordStop	()V
    //   427: aload_0
    //   428: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   431: aconst_null
    //   432: putfield 102	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mOnErrorListener	Lcom/tencent/ttpic/voicechanger/common/audio/OnErrorListener;
    //   435: ldc 8
    //   437: new 26	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   444: aload_0
    //   445: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
    //   448: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: ldc 104
    //   453: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: return
    //   463: astore 5
    //   465: ldc 8
    //   467: ldc 106
    //   469: aload 5
    //   471: iconst_0
    //   472: anewarray 71	java/lang/Object
    //   475: invokestatic 110	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   478: goto -365 -> 113
    //   481: astore 5
    //   483: aload 4
    //   485: monitorexit
    //   486: aload 5
    //   488: athrow
    //   489: astore 5
    //   491: ldc 8
    //   493: ldc 106
    //   495: aload 5
    //   497: iconst_0
    //   498: anewarray 71	java/lang/Object
    //   501: invokestatic 110	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   504: goto -210 -> 294
    //   507: astore 5
    //   509: aload 4
    //   511: monitorexit
    //   512: aload 5
    //   514: athrow
    //   515: aload_0
    //   516: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   519: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   522: iconst_1
    //   523: newarray int
    //   525: dup
    //   526: iconst_0
    //   527: bipush 8
    //   529: iastore
    //   530: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:equalState	([I)Z
    //   533: ifeq +437 -> 970
    //   536: ldc 8
    //   538: ldc 112
    //   540: invokestatic 115	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: aload_0
    //   544: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   547: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   550: invokevirtual 88	android/media/AudioRecord:getRecordingState	()I
    //   553: iconst_1
    //   554: if_icmpne +215 -> 769
    //   557: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   560: lstore_2
    //   561: aload_0
    //   562: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   565: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   568: invokevirtual 124	android/media/AudioRecord:startRecording	()V
    //   571: ldc 8
    //   573: new 26	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   580: ldc 126
    //   582: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   588: lload_2
    //   589: lsub
    //   590: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   593: ldc 131
    //   595: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_0
    //   599: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   602: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   605: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload_0
    //   615: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   618: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   621: invokevirtual 88	android/media/AudioRecord:getRecordingState	()I
    //   624: iconst_1
    //   625: if_icmpne +69 -> 694
    //   628: ldc 8
    //   630: ldc 133
    //   632: invokestatic 136	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload_0
    //   636: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   639: iconst_5
    //   640: invokevirtual 140	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onRecordError	(I)V
    //   643: aload_0
    //   644: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   647: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   650: iconst_1
    //   651: invokevirtual 143	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   654: goto -627 -> 27
    //   657: astore 4
    //   659: ldc 8
    //   661: ldc 145
    //   663: aload 4
    //   665: iconst_0
    //   666: anewarray 71	java/lang/Object
    //   669: invokestatic 110	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   672: aload_0
    //   673: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   676: iconst_5
    //   677: invokevirtual 140	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onRecordError	(I)V
    //   680: aload_0
    //   681: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   684: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   687: iconst_1
    //   688: invokevirtual 143	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   691: goto -664 -> 27
    //   694: aload_0
    //   695: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   698: getfield 149	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mHasDelaySet	Z
    //   701: ifne +68 -> 769
    //   704: aload_0
    //   705: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   708: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   711: lload_2
    //   712: lsub
    //   713: l2i
    //   714: putfield 153	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mDelay	I
    //   717: ldc 8
    //   719: new 26	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   726: ldc 155
    //   728: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload_0
    //   732: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   735: getfield 153	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mDelay	I
    //   738: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   741: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: aload_0
    //   748: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   751: aload_0
    //   752: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   755: getfield 153	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mDelay	I
    //   758: invokevirtual 161	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onDelaySet	(I)V
    //   761: aload_0
    //   762: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   765: iconst_1
    //   766: putfield 149	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mHasDelaySet	Z
    //   769: aload_0
    //   770: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   773: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   776: aload_0
    //   777: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   780: getfield 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
    //   783: iconst_0
    //   784: getstatic 168	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_INPUT_BUFFER_SIZE	I
    //   787: invokevirtual 172	android/media/AudioRecord:read	([BII)I
    //   790: istore_1
    //   791: aload_0
    //   792: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   795: invokestatic 176	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$200	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;)Z
    //   798: ifeq +76 -> 874
    //   801: aload_0
    //   802: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   805: aload_0
    //   806: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   809: getfield 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
    //   812: iload_1
    //   813: invokestatic 182	com/tencent/ttpic/util/AudioUtil:getPcmDB16Bit	([BI)I
    //   816: invokestatic 186	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$302	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;I)I
    //   819: pop
    //   820: aload_0
    //   821: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   824: aload_0
    //   825: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   828: getfield 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
    //   831: iload_1
    //   832: invokestatic 190	com/tencent/ttpic/util/AudioUtil:pcm16BitToShort	([BI)[S
    //   835: invokestatic 194	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$402	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;[S)[S
    //   838: pop
    //   839: aload_0
    //   840: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   843: invokestatic 198	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$400	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;)[S
    //   846: ifnull +28 -> 874
    //   849: aload_0
    //   850: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   853: invokestatic 198	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$400	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;)[S
    //   856: aload_0
    //   857: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   860: invokestatic 198	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$400	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;)[S
    //   863: arraylength
    //   864: aload_0
    //   865: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   868: invokestatic 202	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$500	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;)Lcom/tencent/ttpic/logic/watermark/FFTData;
    //   871: invokestatic 206	com/tencent/ttpic/util/AudioUtil:getPcmFFTFromShortBuffer	([SILcom/tencent/ttpic/logic/watermark/FFTData;)V
    //   874: iload_1
    //   875: bipush 253
    //   877: if_icmpeq +13 -> 890
    //   880: iload_1
    //   881: bipush 254
    //   883: if_icmpeq +7 -> 890
    //   886: iload_1
    //   887: ifgt +50 -> 937
    //   890: ldc 8
    //   892: new 26	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   899: ldc 208
    //   901: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: iload_1
    //   905: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   908: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 136	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   914: aload_0
    //   915: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   918: bipush 6
    //   920: invokevirtual 140	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onRecordError	(I)V
    //   923: aload_0
    //   924: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   927: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   930: iconst_1
    //   931: invokevirtual 143	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   934: goto -907 -> 27
    //   937: aload_0
    //   938: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   941: astore 4
    //   943: aload 4
    //   945: aload 4
    //   947: getfield 211	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mHasRecordLength	I
    //   950: iload_1
    //   951: iadd
    //   952: putfield 211	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mHasRecordLength	I
    //   955: aload_0
    //   956: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   959: aload_0
    //   960: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   963: getfield 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
    //   966: iload_1
    //   967: invokevirtual 215	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onRecording	([BI)V
    //   970: ldc 8
    //   972: new 26	java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   979: ldc 217
    //   981: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload_0
    //   985: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
    //   988: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   991: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   994: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokestatic 115	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   1000: goto -973 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1003	0	this	SimpleRecordThread
    //   790	177	1	i	int
    //   560	152	2	l	long
    //   657	7	4	localSecurityException	java.lang.SecurityException
    //   941	5	4	localAudioRecorderCompat	AudioRecorderCompat
    //   463	7	5	localInterruptedException1	java.lang.InterruptedException
    //   481	6	5	localObject1	java.lang.Object
    //   489	7	5	localInterruptedException2	java.lang.InterruptedException
    //   507	6	5	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   103	113	463	java/lang/InterruptedException
    //   39	103	481	finally
    //   103	113	481	finally
    //   113	150	481	finally
    //   150	153	481	finally
    //   465	478	481	finally
    //   483	486	481	finally
    //   284	294	489	java/lang/InterruptedException
    //   165	247	507	finally
    //   247	284	507	finally
    //   284	294	507	finally
    //   294	331	507	finally
    //   331	334	507	finally
    //   491	504	507	finally
    //   509	512	507	finally
    //   561	571	657	java/lang/SecurityException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.SimpleRecordThread
 * JD-Core Version:    0.7.0.1
 */