package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.decoder.logger.Logger;

class AudioDecoderTrack$AudioDecoderCreateThread
  extends Thread
{
  DecoderAssetTrack extractor;
  private Surface outputSurface;
  private int segmentIndex = 0;
  
  private AudioDecoderTrack$AudioDecoderCreateThread(AudioDecoderTrack paramAudioDecoderTrack, DecoderAssetTrack paramDecoderAssetTrack, Surface paramSurface, int paramInt)
  {
    super("AudioDCreateThread " + paramDecoderAssetTrack.assetPath);
    this.extractor = paramDecoderAssetTrack;
    this.outputSurface = paramSurface;
    this.segmentIndex = paramInt;
  }
  
  /* Error */
  private void createDecoder()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   8: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   11: ifnull +43 -> 54
    //   14: aload_0
    //   15: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   18: aload_0
    //   19: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   22: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   25: invokevirtual 67	java/util/ArrayList:size	()I
    //   28: if_icmpge +26 -> 54
    //   31: aload_0
    //   32: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   35: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   38: ifne +16 -> 54
    //   41: aload_0
    //   42: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   45: getfield 33	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   48: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifeq +35 -> 86
    //   54: invokestatic 80	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   57: new 18	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   64: ldc 82
    //   66: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   73: getfield 33	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   76: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 88	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: return
    //   86: aload_0
    //   87: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   90: aload_0
    //   91: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   94: invokestatic 92	com/tencent/tav/decoder/AudioDecoderTrack:access$1500	(Lcom/tencent/tav/decoder/AudioDecoderTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Lcom/tencent/tav/decoder/IAudioDecoder;
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +124 -> 223
    //   102: aload_3
    //   103: astore_1
    //   104: aload_3
    //   105: astore_2
    //   106: aload_3
    //   107: aload_0
    //   108: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   111: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   114: aload_0
    //   115: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   118: invokevirtual 96	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   121: checkcast 98	com/tencent/tav/decoder/DecoderTrackSegment
    //   124: invokevirtual 102	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   127: aload_0
    //   128: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   131: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   134: aload_0
    //   135: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   138: invokevirtual 96	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   141: checkcast 98	com/tencent/tav/decoder/DecoderTrackSegment
    //   144: invokevirtual 106	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   147: invokeinterface 112 3 0
    //   152: aload_3
    //   153: astore_1
    //   154: aload_3
    //   155: astore_2
    //   156: aload_0
    //   157: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   160: new 114	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper
    //   163: dup
    //   164: aconst_null
    //   165: invokespecial 117	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:<init>	(Lcom/tencent/tav/decoder/AudioDecoderTrack$1;)V
    //   168: invokestatic 121	com/tencent/tav/decoder/AudioDecoderTrack:access$1102	(Lcom/tencent/tav/decoder/AudioDecoderTrack;Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   171: pop
    //   172: aload_3
    //   173: astore_1
    //   174: aload_3
    //   175: astore_2
    //   176: aload_0
    //   177: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   180: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   183: aload_3
    //   184: putfield 129	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IAudioDecoder;
    //   187: aload_3
    //   188: astore_1
    //   189: aload_3
    //   190: astore_2
    //   191: aload_0
    //   192: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   195: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   198: aload_0
    //   199: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   202: putfield 130	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   205: aload_3
    //   206: astore_1
    //   207: aload_3
    //   208: astore_2
    //   209: aload_0
    //   210: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   213: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   216: aload_0
    //   217: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   220: putfield 131	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   223: aload_3
    //   224: astore_1
    //   225: aload_3
    //   226: astore_2
    //   227: invokestatic 80	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   230: new 18	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   237: ldc 133
    //   239: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_0
    //   243: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   246: getfield 33	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   249: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 136	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   262: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   265: ifeq -180 -> 85
    //   268: invokestatic 80	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   271: ldc 138
    //   273: invokestatic 136	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_3
    //   277: ifnull +9 -> 286
    //   280: aload_3
    //   281: invokeinterface 141 1 0
    //   286: aload_0
    //   287: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   290: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   293: ifnull -208 -> 85
    //   296: aload_0
    //   297: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   300: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   303: invokestatic 145	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   306: return
    //   307: astore_1
    //   308: return
    //   309: astore_3
    //   310: aload_1
    //   311: astore_2
    //   312: aload_3
    //   313: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   316: aload_1
    //   317: ifnull +11 -> 328
    //   320: aload_1
    //   321: astore_2
    //   322: aload_1
    //   323: invokeinterface 141 1 0
    //   328: aload_0
    //   329: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   332: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   335: ifeq -250 -> 85
    //   338: invokestatic 80	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   341: ldc 138
    //   343: invokestatic 136	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: aload_1
    //   347: ifnull +9 -> 356
    //   350: aload_1
    //   351: invokeinterface 141 1 0
    //   356: aload_0
    //   357: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   360: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   363: ifnull -278 -> 85
    //   366: aload_0
    //   367: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   370: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   373: invokestatic 145	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   376: return
    //   377: astore_1
    //   378: return
    //   379: astore_1
    //   380: aload_0
    //   381: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   384: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   387: ifeq +41 -> 428
    //   390: invokestatic 80	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   393: ldc 138
    //   395: invokestatic 136	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_2
    //   399: ifnull +9 -> 408
    //   402: aload_2
    //   403: invokeinterface 141 1 0
    //   408: aload_0
    //   409: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   412: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   415: ifnull +13 -> 428
    //   418: aload_0
    //   419: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   422: invokestatic 125	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   425: invokestatic 145	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   428: aload_1
    //   429: athrow
    //   430: astore_1
    //   431: goto -145 -> 286
    //   434: astore_2
    //   435: goto -107 -> 328
    //   438: astore_1
    //   439: goto -83 -> 356
    //   442: astore_2
    //   443: goto -35 -> 408
    //   446: astore_2
    //   447: goto -19 -> 428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	AudioDecoderCreateThread
    //   3	222	1	localObject1	Object
    //   307	44	1	localException1	java.lang.Exception
    //   377	1	1	localException2	java.lang.Exception
    //   379	50	1	localObject2	Object
    //   430	1	1	localException3	java.lang.Exception
    //   438	1	1	localException4	java.lang.Exception
    //   1	402	2	localObject3	Object
    //   434	1	2	localException5	java.lang.Exception
    //   442	1	2	localException6	java.lang.Exception
    //   446	1	2	localException7	java.lang.Exception
    //   97	184	3	localIAudioDecoder	IAudioDecoder
    //   309	4	3	localException8	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   286	306	307	java/lang/Exception
    //   86	98	309	java/lang/Exception
    //   106	152	309	java/lang/Exception
    //   156	172	309	java/lang/Exception
    //   176	187	309	java/lang/Exception
    //   191	205	309	java/lang/Exception
    //   209	223	309	java/lang/Exception
    //   227	258	309	java/lang/Exception
    //   356	376	377	java/lang/Exception
    //   86	98	379	finally
    //   106	152	379	finally
    //   156	172	379	finally
    //   176	187	379	finally
    //   191	205	379	finally
    //   209	223	379	finally
    //   227	258	379	finally
    //   312	316	379	finally
    //   322	328	379	finally
    //   280	286	430	java/lang/Exception
    //   322	328	434	java/lang/Exception
    //   350	356	438	java/lang/Exception
    //   402	408	442	java/lang/Exception
    //   408	428	446	java/lang/Exception
  }
  
  public void run()
  {
    ??? = AudioDecoderTrack.access$700();
    StringBuilder localStringBuilder = new StringBuilder().append("AudioDecoderCreateThread start - ").append(this.extractor.assetPath).append(" - ");
    if (this.outputSurface != null) {}
    for (boolean bool = true;; bool = false)
    {
      Logger.d((String)???, bool);
      if (!AudioDecoderTrack.access$800(this.this$0)) {
        break;
      }
      AudioDecoderTrack.access$902(this.this$0, null);
      return;
    }
    for (;;)
    {
      synchronized (AudioDecoderTrack.access$1000(this.this$0))
      {
        if ((AudioDecoderTrack.access$1100(this.this$0) != null) && (AudioDecoderTrack.access$1200(AudioDecoderTrack.access$1100(this.this$0).extractor, this.extractor)))
        {
          AudioDecoderTrack.access$902(this.this$0, null);
          if (!AudioDecoderTrack.access$800(this.this$0)) {}
        }
      }
      synchronized (AudioDecoderTrack.access$1000(this.this$0))
      {
        if (AudioDecoderTrack.access$1100(this.this$0) != null)
        {
          AudioDecoderTrack.DecoderWrapper.access$600(AudioDecoderTrack.access$1100(this.this$0));
          AudioDecoderTrack.access$1102(this.this$0, null);
        }
        Logger.d(AudioDecoderTrack.access$700(), "AudioDecoderCreateThread finish - " + this.extractor.assetPath);
        return;
        if (AudioDecoderTrack.access$1100(this.this$0) != null)
        {
          Logger.d(AudioDecoderTrack.access$700(), "AudioDecoderCreateThread create - " + this.extractor.assetPath);
          if ((AudioDecoderTrack.access$1100(this.this$0).decoder != null) && (AudioDecoderTrack.access$1100(this.this$0).decoder != AudioDecoderTrack.access$1300(this.this$0)))
          {
            AudioDecoderTrack.DecoderWrapper.access$600(AudioDecoderTrack.access$1100(this.this$0));
            AudioDecoderTrack.access$1102(this.this$0, null);
          }
          createDecoder();
          continue;
          localObject2 = finally;
          throw localObject2;
        }
        createDecoder();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack.AudioDecoderCreateThread
 * JD-Core Version:    0.7.0.1
 */