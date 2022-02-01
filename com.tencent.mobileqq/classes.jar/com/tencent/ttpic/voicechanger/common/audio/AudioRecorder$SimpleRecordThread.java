package com.tencent.ttpic.voicechanger.common.audio;

class AudioRecorder$SimpleRecordThread
  extends Thread
{
  private static final String TAG = "SimpleRecordThread";
  
  public AudioRecorder$SimpleRecordThread(AudioRecorder paramAudioRecorder, String paramString)
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
    //   10: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
    //   13: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 38
    //   18: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   31: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   34: astore 4
    //   36: aload 4
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   43: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   46: iconst_1
    //   47: newarray int
    //   49: dup
    //   50: iconst_0
    //   51: iconst_2
    //   52: iastore
    //   53: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:equalState	([I)Z
    //   56: ifeq +87 -> 143
    //   59: ldc 8
    //   61: new 26	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   68: aload_0
    //   69: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
    //   72: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 61
    //   77: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   84: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   87: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   100: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   103: invokevirtual 69	java/lang/Object:wait	()V
    //   106: ldc 8
    //   108: new 26	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   115: aload_0
    //   116: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
    //   119: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 71
    //   124: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   131: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   134: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload 4
    //   145: monitorexit
    //   146: aload_0
    //   147: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   150: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   153: astore 4
    //   155: aload 4
    //   157: monitorenter
    //   158: aload_0
    //   159: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   162: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   165: iconst_1
    //   166: newarray int
    //   168: dup
    //   169: iconst_0
    //   170: bipush 8
    //   172: iastore
    //   173: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:equalState	([I)Z
    //   176: ifeq +141 -> 317
    //   179: aload_0
    //   180: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   183: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
    //   186: invokevirtual 81	android/media/AudioRecord:getRecordingState	()I
    //   189: iconst_3
    //   190: if_icmpne +43 -> 233
    //   193: ldc 8
    //   195: new 26	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   202: ldc 83
    //   204: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_0
    //   208: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   211: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   214: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 86	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_0
    //   224: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   227: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
    //   230: invokevirtual 89	android/media/AudioRecord:stop	()V
    //   233: ldc 8
    //   235: new 26	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   242: aload_0
    //   243: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
    //   246: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc 61
    //   251: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   258: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   261: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_0
    //   271: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   274: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   277: invokevirtual 69	java/lang/Object:wait	()V
    //   280: ldc 8
    //   282: new 26	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   289: aload_0
    //   290: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
    //   293: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc 71
    //   298: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   305: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   308: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload 4
    //   319: monitorexit
    //   320: aload_0
    //   321: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   324: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   327: iconst_2
    //   328: newarray int
    //   330: dup
    //   331: iconst_0
    //   332: bipush 16
    //   334: iastore
    //   335: dup
    //   336: iconst_1
    //   337: iconst_0
    //   338: iastore
    //   339: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:equalState	([I)Z
    //   342: ifeq +153 -> 495
    //   345: aload_0
    //   346: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   349: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
    //   352: invokevirtual 81	android/media/AudioRecord:getRecordingState	()I
    //   355: iconst_3
    //   356: if_icmpne +43 -> 399
    //   359: ldc 8
    //   361: new 26	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   368: ldc 83
    //   370: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_0
    //   374: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   377: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   380: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 86	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload_0
    //   390: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   393: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
    //   396: invokevirtual 89	android/media/AudioRecord:stop	()V
    //   399: aload_0
    //   400: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   403: invokevirtual 92	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onRecordStop	()V
    //   406: aload_0
    //   407: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   410: aconst_null
    //   411: invokestatic 96	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$702	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;Lcom/tencent/ttpic/voicechanger/common/audio/OnErrorListener;)Lcom/tencent/ttpic/voicechanger/common/audio/OnErrorListener;
    //   414: pop
    //   415: ldc 8
    //   417: new 26	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   424: aload_0
    //   425: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
    //   428: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc 98
    //   433: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: return
    //   443: astore 5
    //   445: ldc 8
    //   447: ldc 100
    //   449: aload 5
    //   451: iconst_0
    //   452: anewarray 66	java/lang/Object
    //   455: invokestatic 104	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   458: goto -352 -> 106
    //   461: astore 5
    //   463: aload 4
    //   465: monitorexit
    //   466: aload 5
    //   468: athrow
    //   469: astore 5
    //   471: ldc 8
    //   473: ldc 100
    //   475: aload 5
    //   477: iconst_0
    //   478: anewarray 66	java/lang/Object
    //   481: invokestatic 104	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   484: goto -204 -> 280
    //   487: astore 5
    //   489: aload 4
    //   491: monitorexit
    //   492: aload 5
    //   494: athrow
    //   495: aload_0
    //   496: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   499: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   502: iconst_1
    //   503: newarray int
    //   505: dup
    //   506: iconst_0
    //   507: iconst_4
    //   508: iastore
    //   509: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:equalState	([I)Z
    //   512: ifeq -485 -> 27
    //   515: aload_0
    //   516: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   519: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
    //   522: invokevirtual 81	android/media/AudioRecord:getRecordingState	()I
    //   525: iconst_1
    //   526: if_icmpne +217 -> 743
    //   529: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   532: lstore_2
    //   533: aload_0
    //   534: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   537: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
    //   540: invokevirtual 113	android/media/AudioRecord:startRecording	()V
    //   543: ldc 8
    //   545: new 26	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   552: ldc 115
    //   554: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   560: lload_2
    //   561: lsub
    //   562: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   565: ldc 120
    //   567: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload_0
    //   571: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   574: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   577: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   580: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 86	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload_0
    //   587: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   590: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
    //   593: invokevirtual 81	android/media/AudioRecord:getRecordingState	()I
    //   596: iconst_1
    //   597: if_icmpne +69 -> 666
    //   600: ldc 8
    //   602: ldc 122
    //   604: invokestatic 125	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: aload_0
    //   608: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   611: iconst_5
    //   612: invokevirtual 129	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onRecordError	(I)V
    //   615: aload_0
    //   616: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   619: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   622: iconst_0
    //   623: invokevirtual 132	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   626: goto -599 -> 27
    //   629: astore 4
    //   631: ldc 8
    //   633: ldc 134
    //   635: aload 4
    //   637: iconst_0
    //   638: anewarray 66	java/lang/Object
    //   641: invokestatic 104	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   644: aload_0
    //   645: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   648: iconst_5
    //   649: invokevirtual 129	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onRecordError	(I)V
    //   652: aload_0
    //   653: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   656: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   659: iconst_0
    //   660: invokevirtual 132	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   663: goto -636 -> 27
    //   666: aload_0
    //   667: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   670: invokestatic 138	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$800	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Z
    //   673: ifne +70 -> 743
    //   676: aload_0
    //   677: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   680: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   683: lload_2
    //   684: lsub
    //   685: l2i
    //   686: invokestatic 142	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$902	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;I)I
    //   689: pop
    //   690: ldc 8
    //   692: new 26	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   699: ldc 144
    //   701: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload_0
    //   705: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   708: invokestatic 148	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$900	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)I
    //   711: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   714: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload_0
    //   721: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   724: aload_0
    //   725: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   728: invokestatic 148	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$900	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)I
    //   731: invokevirtual 154	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onDelaySet	(I)V
    //   734: aload_0
    //   735: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   738: iconst_1
    //   739: invokestatic 158	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$802	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;Z)Z
    //   742: pop
    //   743: aload_0
    //   744: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   747: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
    //   750: aload_0
    //   751: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   754: invokestatic 162	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$1000	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)[B
    //   757: iconst_0
    //   758: getstatic 168	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_INPUT_BUFFER_SIZE	I
    //   761: invokevirtual 172	android/media/AudioRecord:read	([BII)I
    //   764: istore_1
    //   765: iload_1
    //   766: bipush 253
    //   768: if_icmpeq +13 -> 781
    //   771: iload_1
    //   772: bipush 254
    //   774: if_icmpeq +7 -> 781
    //   777: iload_1
    //   778: ifgt +50 -> 828
    //   781: ldc 8
    //   783: new 26	java/lang/StringBuilder
    //   786: dup
    //   787: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   790: ldc 174
    //   792: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: iload_1
    //   796: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   799: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 125	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: aload_0
    //   806: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   809: bipush 6
    //   811: invokevirtual 129	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onRecordError	(I)V
    //   814: aload_0
    //   815: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   818: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   821: iconst_0
    //   822: invokevirtual 132	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   825: goto -798 -> 27
    //   828: aload_0
    //   829: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   832: aload_0
    //   833: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   836: invokestatic 177	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$1100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)I
    //   839: iload_1
    //   840: iadd
    //   841: invokestatic 180	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$1102	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;I)I
    //   844: pop
    //   845: aload_0
    //   846: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   849: aload_0
    //   850: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
    //   853: invokestatic 162	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$1000	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)[B
    //   856: iload_1
    //   857: invokevirtual 184	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onRecording	([BI)V
    //   860: goto -833 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	863	0	this	SimpleRecordThread
    //   764	93	1	i	int
    //   532	152	2	l	long
    //   629	7	4	localSecurityException	java.lang.SecurityException
    //   443	7	5	localInterruptedException1	java.lang.InterruptedException
    //   461	6	5	localObject1	java.lang.Object
    //   469	7	5	localInterruptedException2	java.lang.InterruptedException
    //   487	6	5	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   96	106	443	java/lang/InterruptedException
    //   39	96	461	finally
    //   96	106	461	finally
    //   106	143	461	finally
    //   143	146	461	finally
    //   445	458	461	finally
    //   463	466	461	finally
    //   270	280	469	java/lang/InterruptedException
    //   158	233	487	finally
    //   233	270	487	finally
    //   270	280	487	finally
    //   280	317	487	finally
    //   317	320	487	finally
    //   471	484	487	finally
    //   489	492	487	finally
    //   533	543	629	java/lang/SecurityException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorder.SimpleRecordThread
 * JD-Core Version:    0.7.0.1
 */