package com.tencent.ttpic.voicechanger.common.audio;

public class AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat
  extends Thread
{
  protected static final String TAG = "SimpleRecordThread";
  
  public AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat(AudioRecorderAndChangerForKitKat paramAudioRecorderAndChangerForKitKat, String paramString)
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
    //   10: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
    //   13: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 38
    //   18: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   31: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   34: astore 4
    //   36: aload 4
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   43: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   46: iconst_1
    //   47: newarray int
    //   49: dup
    //   50: iconst_0
    //   51: iconst_4
    //   52: iastore
    //   53: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:equalState	([I)Z
    //   56: ifeq +94 -> 150
    //   59: ldc 8
    //   61: ldc 61
    //   63: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc 8
    //   68: new 26	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   75: aload_0
    //   76: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
    //   79: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 66
    //   84: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   91: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   94: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   107: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   110: invokevirtual 74	java/lang/Object:wait	()V
    //   113: ldc 8
    //   115: new 26	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   122: aload_0
    //   123: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
    //   126: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 76
    //   131: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   138: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   141: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload 4
    //   152: monitorexit
    //   153: aload_0
    //   154: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   157: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   160: astore 4
    //   162: aload 4
    //   164: monitorenter
    //   165: aload_0
    //   166: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   169: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   172: iconst_1
    //   173: newarray int
    //   175: dup
    //   176: iconst_0
    //   177: bipush 16
    //   179: iastore
    //   180: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:equalState	([I)Z
    //   183: ifeq +148 -> 331
    //   186: ldc 8
    //   188: ldc 78
    //   190: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   197: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
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
    //   222: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   225: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   228: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_0
    //   238: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   241: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   244: invokevirtual 93	android/media/AudioRecord:stop	()V
    //   247: ldc 8
    //   249: new 26	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   256: aload_0
    //   257: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
    //   260: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 66
    //   265: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   272: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   275: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_0
    //   285: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   288: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   291: invokevirtual 74	java/lang/Object:wait	()V
    //   294: ldc 8
    //   296: new 26	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   303: aload_0
    //   304: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
    //   307: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc 76
    //   312: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   319: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   322: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 4
    //   333: monitorexit
    //   334: aload_0
    //   335: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   338: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
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
    //   353: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:equalState	([I)Z
    //   356: ifeq +159 -> 515
    //   359: ldc 8
    //   361: ldc 95
    //   363: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_0
    //   367: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   370: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
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
    //   395: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   398: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   401: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: aload_0
    //   411: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   414: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   417: invokevirtual 93	android/media/AudioRecord:stop	()V
    //   420: aload_0
    //   421: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   424: invokevirtual 98	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onRecordStop	()V
    //   427: aload_0
    //   428: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   431: aconst_null
    //   432: putfield 102	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mOnErrorListener	Lcom/tencent/ttpic/voicechanger/common/audio/OnErrorListener;
    //   435: ldc 8
    //   437: new 26	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   444: aload_0
    //   445: invokevirtual 32	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
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
    //   516: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   519: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   522: iconst_1
    //   523: newarray int
    //   525: dup
    //   526: iconst_0
    //   527: bipush 8
    //   529: iastore
    //   530: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:equalState	([I)Z
    //   533: ifeq +354 -> 887
    //   536: ldc 8
    //   538: ldc 112
    //   540: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: aload_0
    //   544: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   547: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   550: invokevirtual 88	android/media/AudioRecord:getRecordingState	()I
    //   553: iconst_1
    //   554: if_icmpne +215 -> 769
    //   557: invokestatic 118	java/lang/System:currentTimeMillis	()J
    //   560: lstore_2
    //   561: aload_0
    //   562: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   565: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   568: invokevirtual 121	android/media/AudioRecord:startRecording	()V
    //   571: ldc 8
    //   573: new 26	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   580: ldc 123
    //   582: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokestatic 118	java/lang/System:currentTimeMillis	()J
    //   588: lload_2
    //   589: lsub
    //   590: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   593: ldc 128
    //   595: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_0
    //   599: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   602: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   605: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload_0
    //   615: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   618: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   621: invokevirtual 88	android/media/AudioRecord:getRecordingState	()I
    //   624: iconst_1
    //   625: if_icmpne +69 -> 694
    //   628: ldc 8
    //   630: ldc 130
    //   632: invokestatic 133	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload_0
    //   636: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   639: iconst_5
    //   640: invokevirtual 137	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onRecordError	(I)V
    //   643: aload_0
    //   644: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   647: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   650: iconst_1
    //   651: invokevirtual 140	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   654: goto -627 -> 27
    //   657: astore 4
    //   659: ldc 8
    //   661: ldc 142
    //   663: aload 4
    //   665: iconst_0
    //   666: anewarray 71	java/lang/Object
    //   669: invokestatic 110	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   672: aload_0
    //   673: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   676: iconst_5
    //   677: invokevirtual 137	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onRecordError	(I)V
    //   680: aload_0
    //   681: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   684: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   687: iconst_1
    //   688: invokevirtual 140	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   691: goto -664 -> 27
    //   694: aload_0
    //   695: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   698: getfield 146	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mHasDelaySet	Z
    //   701: ifne +68 -> 769
    //   704: aload_0
    //   705: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   708: invokestatic 118	java/lang/System:currentTimeMillis	()J
    //   711: lload_2
    //   712: lsub
    //   713: l2i
    //   714: putfield 150	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mDelay	I
    //   717: ldc 8
    //   719: new 26	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   726: ldc 152
    //   728: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload_0
    //   732: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   735: getfield 150	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mDelay	I
    //   738: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   741: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 47	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: aload_0
    //   748: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   751: aload_0
    //   752: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   755: getfield 150	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mDelay	I
    //   758: invokevirtual 158	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onDelaySet	(I)V
    //   761: aload_0
    //   762: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   765: iconst_1
    //   766: putfield 146	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mHasDelaySet	Z
    //   769: aload_0
    //   770: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   773: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   776: aload_0
    //   777: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   780: getfield 162	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBuffer	[B
    //   783: iconst_0
    //   784: getstatic 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_INPUT_BUFFER_SIZE	I
    //   787: invokevirtual 169	android/media/AudioRecord:read	([BII)I
    //   790: istore_1
    //   791: iload_1
    //   792: bipush 253
    //   794: if_icmpeq +13 -> 807
    //   797: iload_1
    //   798: bipush 254
    //   800: if_icmpeq +7 -> 807
    //   803: iload_1
    //   804: ifgt +50 -> 854
    //   807: ldc 8
    //   809: new 26	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   816: ldc 171
    //   818: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: iload_1
    //   822: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   825: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 133	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: aload_0
    //   832: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   835: bipush 6
    //   837: invokevirtual 137	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onRecordError	(I)V
    //   840: aload_0
    //   841: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   844: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   847: iconst_1
    //   848: invokevirtual 140	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   851: goto -824 -> 27
    //   854: aload_0
    //   855: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   858: astore 4
    //   860: aload 4
    //   862: aload 4
    //   864: getfield 174	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mHasRecordLength	I
    //   867: iload_1
    //   868: iadd
    //   869: putfield 174	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mHasRecordLength	I
    //   872: aload_0
    //   873: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   876: aload_0
    //   877: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   880: getfield 162	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBuffer	[B
    //   883: iload_1
    //   884: invokevirtual 178	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onRecording	([BI)V
    //   887: ldc 8
    //   889: new 26	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   896: ldc 180
    //   898: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: aload_0
    //   902: getfield 14	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
    //   905: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   908: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   911: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   917: goto -890 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	920	0	this	SimpleRecordThreadForKitKat
    //   790	94	1	i	int
    //   560	152	2	l	long
    //   657	7	4	localSecurityException	java.lang.SecurityException
    //   858	5	4	localAudioRecorderAndChangerForKitKat	AudioRecorderAndChangerForKitKat
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
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat.SimpleRecordThreadForKitKat
 * JD-Core Version:    0.7.0.1
 */