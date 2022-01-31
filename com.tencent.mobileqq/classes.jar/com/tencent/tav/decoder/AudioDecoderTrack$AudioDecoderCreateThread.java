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
    //   0: aload_0
    //   1: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   4: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   7: ifnull +43 -> 50
    //   10: aload_0
    //   11: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   14: aload_0
    //   15: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   18: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   21: invokevirtual 67	java/util/ArrayList:size	()I
    //   24: if_icmpge +26 -> 50
    //   27: aload_0
    //   28: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   31: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   34: ifne +16 -> 50
    //   37: aload_0
    //   38: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   41: getfield 33	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   44: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +35 -> 82
    //   50: invokestatic 80	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   53: new 18	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   60: ldc 82
    //   62: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_0
    //   66: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   69: getfield 33	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   72: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 88	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: return
    //   82: new 90	com/tencent/tav/decoder/AudioDecoder
    //   85: dup
    //   86: aload_0
    //   87: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   90: getfield 33	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   93: invokespecial 91	com/tencent/tav/decoder/AudioDecoder:<init>	(Ljava/lang/String;)V
    //   96: astore_2
    //   97: aload_2
    //   98: astore_1
    //   99: aload_2
    //   100: aload_0
    //   101: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   104: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   107: aload_0
    //   108: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   111: invokevirtual 95	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   114: checkcast 97	com/tencent/tav/decoder/DecoderTrackSegment
    //   117: invokevirtual 101	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   120: aload_0
    //   121: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   124: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   127: aload_0
    //   128: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   131: invokevirtual 95	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   134: checkcast 97	com/tencent/tav/decoder/DecoderTrackSegment
    //   137: invokevirtual 105	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   140: invokeinterface 111 3 0
    //   145: aload_2
    //   146: astore_1
    //   147: aload_0
    //   148: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   151: new 113	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper
    //   154: dup
    //   155: aconst_null
    //   156: invokespecial 116	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:<init>	(Lcom/tencent/tav/decoder/AudioDecoderTrack$1;)V
    //   159: invokestatic 120	com/tencent/tav/decoder/AudioDecoderTrack:access$1102	(Lcom/tencent/tav/decoder/AudioDecoderTrack;Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   162: pop
    //   163: aload_2
    //   164: astore_1
    //   165: aload_0
    //   166: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   169: invokestatic 124	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   172: aload_2
    //   173: putfield 128	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   176: aload_2
    //   177: astore_1
    //   178: aload_0
    //   179: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   182: invokestatic 124	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   185: aload_0
    //   186: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   189: putfield 129	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   192: aload_2
    //   193: astore_1
    //   194: aload_0
    //   195: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   198: invokestatic 124	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   201: aload_0
    //   202: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   205: putfield 130	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   208: aload_2
    //   209: astore_1
    //   210: invokestatic 80	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   213: new 18	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   220: ldc 132
    //   222: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   229: getfield 33	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   232: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 135	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   245: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   248: ifeq -167 -> 81
    //   251: invokestatic 80	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   254: ldc 137
    //   256: invokestatic 88	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_2
    //   260: ifnull +9 -> 269
    //   263: aload_2
    //   264: invokeinterface 140 1 0
    //   269: aload_0
    //   270: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   273: invokestatic 124	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   276: ifnull -195 -> 81
    //   279: aload_0
    //   280: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   283: invokestatic 124	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   286: invokestatic 144	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   289: return
    //   290: astore_1
    //   291: return
    //   292: astore_3
    //   293: aconst_null
    //   294: astore_2
    //   295: aload_2
    //   296: astore_1
    //   297: aload_3
    //   298: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   301: aload_2
    //   302: ifnull +11 -> 313
    //   305: aload_2
    //   306: astore_1
    //   307: aload_2
    //   308: invokeinterface 140 1 0
    //   313: aload_0
    //   314: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   317: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   320: ifeq -239 -> 81
    //   323: invokestatic 80	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   326: ldc 137
    //   328: invokestatic 88	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload_2
    //   332: ifnull +9 -> 341
    //   335: aload_2
    //   336: invokeinterface 140 1 0
    //   341: aload_0
    //   342: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   345: invokestatic 124	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   348: ifnull -267 -> 81
    //   351: aload_0
    //   352: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   355: invokestatic 124	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   358: invokestatic 144	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   361: return
    //   362: astore_1
    //   363: return
    //   364: astore_2
    //   365: aconst_null
    //   366: astore_1
    //   367: aload_0
    //   368: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   371: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   374: ifeq +41 -> 415
    //   377: invokestatic 80	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   380: ldc 137
    //   382: invokestatic 88	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload_1
    //   386: ifnull +9 -> 395
    //   389: aload_1
    //   390: invokeinterface 140 1 0
    //   395: aload_0
    //   396: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   399: invokestatic 124	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   402: ifnull +13 -> 415
    //   405: aload_0
    //   406: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   409: invokestatic 124	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   412: invokestatic 144	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   415: aload_2
    //   416: athrow
    //   417: astore_1
    //   418: goto -149 -> 269
    //   421: astore_1
    //   422: goto -109 -> 313
    //   425: astore_1
    //   426: goto -85 -> 341
    //   429: astore_1
    //   430: goto -35 -> 395
    //   433: astore_1
    //   434: goto -19 -> 415
    //   437: astore_2
    //   438: goto -71 -> 367
    //   441: astore_3
    //   442: goto -147 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	AudioDecoderCreateThread
    //   98	112	1	localAudioDecoder1	AudioDecoder
    //   290	1	1	localException1	java.lang.Exception
    //   296	11	1	localAudioDecoder2	AudioDecoder
    //   362	1	1	localException2	java.lang.Exception
    //   366	24	1	localObject1	Object
    //   417	1	1	localException3	java.lang.Exception
    //   421	1	1	localException4	java.lang.Exception
    //   425	1	1	localException5	java.lang.Exception
    //   429	1	1	localException6	java.lang.Exception
    //   433	1	1	localException7	java.lang.Exception
    //   96	240	2	localAudioDecoder3	AudioDecoder
    //   364	52	2	localObject2	Object
    //   437	1	2	localObject3	Object
    //   292	6	3	localException8	java.lang.Exception
    //   441	1	3	localException9	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   269	289	290	java/lang/Exception
    //   82	97	292	java/lang/Exception
    //   341	361	362	java/lang/Exception
    //   82	97	364	finally
    //   263	269	417	java/lang/Exception
    //   307	313	421	java/lang/Exception
    //   335	341	425	java/lang/Exception
    //   389	395	429	java/lang/Exception
    //   395	415	433	java/lang/Exception
    //   99	145	437	finally
    //   147	163	437	finally
    //   165	176	437	finally
    //   178	192	437	finally
    //   194	208	437	finally
    //   210	241	437	finally
    //   297	301	437	finally
    //   307	313	437	finally
    //   99	145	441	java/lang/Exception
    //   147	163	441	java/lang/Exception
    //   165	176	441	java/lang/Exception
    //   178	192	441	java/lang/Exception
    //   194	208	441	java/lang/Exception
    //   210	241	441	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack.AudioDecoderCreateThread
 * JD-Core Version:    0.7.0.1
 */