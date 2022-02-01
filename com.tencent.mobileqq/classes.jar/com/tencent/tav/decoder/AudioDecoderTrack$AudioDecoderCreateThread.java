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
    super(paramAudioDecoderTrack.toString());
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
    //   7: ifnull +410 -> 417
    //   10: aload_0
    //   11: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   14: aload_0
    //   15: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   18: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   21: invokevirtual 67	java/util/ArrayList:size	()I
    //   24: if_icmpge +393 -> 417
    //   27: aload_0
    //   28: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   31: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   34: ifne +383 -> 417
    //   37: aload_0
    //   38: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   41: getfield 33	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   44: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +6 -> 53
    //   50: goto +367 -> 417
    //   53: aload_0
    //   54: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   57: aload_0
    //   58: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   61: invokestatic 81	com/tencent/tav/decoder/AudioDecoderTrack:access$1500	(Lcom/tencent/tav/decoder/AudioDecoderTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Lcom/tencent/tav/decoder/IAudioDecoder;
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +114 -> 180
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   76: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   79: aload_0
    //   80: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   83: invokevirtual 85	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   86: checkcast 87	com/tencent/tav/decoder/DecoderTrackSegment
    //   89: invokevirtual 91	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   92: aload_0
    //   93: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   96: invokestatic 61	com/tencent/tav/decoder/AudioDecoderTrack:access$1400	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Ljava/util/ArrayList;
    //   99: aload_0
    //   100: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   103: invokevirtual 85	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   106: checkcast 87	com/tencent/tav/decoder/DecoderTrackSegment
    //   109: invokevirtual 95	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   112: invokeinterface 101 3 0
    //   117: aload_2
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   123: new 103	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper
    //   126: dup
    //   127: aconst_null
    //   128: invokespecial 106	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:<init>	(Lcom/tencent/tav/decoder/AudioDecoderTrack$1;)V
    //   131: invokestatic 110	com/tencent/tav/decoder/AudioDecoderTrack:access$1102	(Lcom/tencent/tav/decoder/AudioDecoderTrack;Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   134: pop
    //   135: aload_2
    //   136: astore_1
    //   137: aload_0
    //   138: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   141: invokestatic 114	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   144: aload_2
    //   145: putfield 118	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IAudioDecoder;
    //   148: aload_2
    //   149: astore_1
    //   150: aload_0
    //   151: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   154: invokestatic 114	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   157: aload_0
    //   158: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   161: putfield 119	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   164: aload_2
    //   165: astore_1
    //   166: aload_0
    //   167: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   170: invokestatic 114	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   173: aload_0
    //   174: getfield 42	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:segmentIndex	I
    //   177: putfield 120	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   180: aload_2
    //   181: astore_1
    //   182: invokestatic 123	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   185: astore_3
    //   186: aload_2
    //   187: astore_1
    //   188: new 18	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   195: astore 4
    //   197: aload_2
    //   198: astore_1
    //   199: aload 4
    //   201: ldc 125
    //   203: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_2
    //   208: astore_1
    //   209: aload 4
    //   211: aload_0
    //   212: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   215: getfield 33	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   218: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_2
    //   223: astore_1
    //   224: aload_3
    //   225: aload 4
    //   227: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 131	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_0
    //   234: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   237: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   240: ifeq +121 -> 361
    //   243: invokestatic 123	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   246: ldc 133
    //   248: invokestatic 131	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload_2
    //   252: ifnull +9 -> 261
    //   255: aload_2
    //   256: invokeinterface 136 1 0
    //   261: aload_0
    //   262: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   265: invokestatic 114	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   268: ifnull +93 -> 361
    //   271: aload_0
    //   272: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   275: astore_1
    //   276: aload_1
    //   277: invokestatic 114	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   280: invokestatic 140	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   283: return
    //   284: astore_3
    //   285: goto +12 -> 297
    //   288: astore_1
    //   289: aconst_null
    //   290: astore_2
    //   291: goto +76 -> 367
    //   294: astore_3
    //   295: aconst_null
    //   296: astore_2
    //   297: aload_2
    //   298: astore_1
    //   299: aload_3
    //   300: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   303: aload_2
    //   304: ifnull +11 -> 315
    //   307: aload_2
    //   308: astore_1
    //   309: aload_2
    //   310: invokeinterface 136 1 0
    //   315: aload_0
    //   316: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   319: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   322: ifeq +39 -> 361
    //   325: invokestatic 123	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   328: ldc 133
    //   330: invokestatic 131	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_2
    //   334: ifnull +9 -> 343
    //   337: aload_2
    //   338: invokeinterface 136 1 0
    //   343: aload_0
    //   344: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   347: invokestatic 114	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   350: ifnull +11 -> 361
    //   353: aload_0
    //   354: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   357: astore_1
    //   358: goto -82 -> 276
    //   361: return
    //   362: astore_3
    //   363: aload_1
    //   364: astore_2
    //   365: aload_3
    //   366: astore_1
    //   367: aload_0
    //   368: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   371: invokestatic 71	com/tencent/tav/decoder/AudioDecoderTrack:access$800	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Z
    //   374: ifeq +41 -> 415
    //   377: invokestatic 123	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   380: ldc 133
    //   382: invokestatic 131	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload_2
    //   386: ifnull +9 -> 395
    //   389: aload_2
    //   390: invokeinterface 136 1 0
    //   395: aload_0
    //   396: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   399: invokestatic 114	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   402: ifnull +13 -> 415
    //   405: aload_0
    //   406: getfield 16	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:this$0	Lcom/tencent/tav/decoder/AudioDecoderTrack;
    //   409: invokestatic 114	com/tencent/tav/decoder/AudioDecoderTrack:access$1100	(Lcom/tencent/tav/decoder/AudioDecoderTrack;)Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   412: invokestatic 140	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   415: aload_1
    //   416: athrow
    //   417: invokestatic 123	com/tencent/tav/decoder/AudioDecoderTrack:access$700	()Ljava/lang/String;
    //   420: astore_1
    //   421: new 18	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   428: astore_2
    //   429: aload_2
    //   430: ldc 145
    //   432: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_2
    //   437: aload_0
    //   438: getfield 44	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   441: getfield 33	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   444: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload_1
    //   449: aload_2
    //   450: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 148	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: return
    //   457: astore_1
    //   458: goto -197 -> 261
    //   461: astore_1
    //   462: return
    //   463: astore_1
    //   464: goto -149 -> 315
    //   467: astore_1
    //   468: goto -125 -> 343
    //   471: astore_2
    //   472: goto -77 -> 395
    //   475: astore_2
    //   476: goto -61 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	AudioDecoderCreateThread
    //   70	207	1	localObject1	Object
    //   288	1	1	localObject2	Object
    //   298	151	1	localObject3	Object
    //   457	1	1	localException1	java.lang.Exception
    //   461	1	1	localException2	java.lang.Exception
    //   463	1	1	localException3	java.lang.Exception
    //   467	1	1	localException4	java.lang.Exception
    //   64	386	2	localObject4	Object
    //   471	1	2	localException5	java.lang.Exception
    //   475	1	2	localException6	java.lang.Exception
    //   185	40	3	str	String
    //   284	1	3	localException7	java.lang.Exception
    //   294	6	3	localException8	java.lang.Exception
    //   362	4	3	localObject5	Object
    //   195	31	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   71	117	284	java/lang/Exception
    //   119	135	284	java/lang/Exception
    //   137	148	284	java/lang/Exception
    //   150	164	284	java/lang/Exception
    //   166	180	284	java/lang/Exception
    //   182	186	284	java/lang/Exception
    //   188	197	284	java/lang/Exception
    //   199	207	284	java/lang/Exception
    //   209	222	284	java/lang/Exception
    //   224	233	284	java/lang/Exception
    //   53	65	288	finally
    //   53	65	294	java/lang/Exception
    //   71	117	362	finally
    //   119	135	362	finally
    //   137	148	362	finally
    //   150	164	362	finally
    //   166	180	362	finally
    //   182	186	362	finally
    //   188	197	362	finally
    //   199	207	362	finally
    //   209	222	362	finally
    //   224	233	362	finally
    //   299	303	362	finally
    //   309	315	362	finally
    //   255	261	457	java/lang/Exception
    //   261	276	461	java/lang/Exception
    //   276	283	461	java/lang/Exception
    //   343	358	461	java/lang/Exception
    //   309	315	463	java/lang/Exception
    //   337	343	467	java/lang/Exception
    //   389	395	471	java/lang/Exception
    //   395	415	475	java/lang/Exception
  }
  
  public void run()
  {
    ??? = AudioDecoderTrack.access$700();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("AudioDecoderCreateThread start - ");
    ((StringBuilder)localObject2).append(this.extractor.assetPath);
    ((StringBuilder)localObject2).append(" - ");
    boolean bool;
    if (this.outputSurface != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    Logger.d((String)???, ((StringBuilder)localObject2).toString());
    if (AudioDecoderTrack.access$800(this.this$0))
    {
      AudioDecoderTrack.access$902(this.this$0, null);
      return;
    }
    synchronized (AudioDecoderTrack.access$1000(this.this$0))
    {
      if ((AudioDecoderTrack.access$1100(this.this$0) == null) || (!AudioDecoderTrack.access$1200(AudioDecoderTrack.access$1100(this.this$0).extractor, this.extractor))) {
        if (AudioDecoderTrack.access$1100(this.this$0) != null)
        {
          localObject2 = AudioDecoderTrack.access$700();
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("AudioDecoderCreateThread create - ");
          localStringBuilder2.append(this.extractor.assetPath);
          Logger.d((String)localObject2, localStringBuilder2.toString());
          if ((AudioDecoderTrack.access$1100(this.this$0).decoder != null) && (AudioDecoderTrack.access$1100(this.this$0).decoder != AudioDecoderTrack.access$1300(this.this$0)))
          {
            AudioDecoderTrack.DecoderWrapper.access$600(AudioDecoderTrack.access$1100(this.this$0));
            AudioDecoderTrack.access$1102(this.this$0, null);
          }
          createDecoder();
        }
        else
        {
          createDecoder();
        }
      }
      AudioDecoderTrack.access$902(this.this$0, null);
      if (AudioDecoderTrack.access$800(this.this$0)) {
        synchronized (AudioDecoderTrack.access$1000(this.this$0))
        {
          if (AudioDecoderTrack.access$1100(this.this$0) != null)
          {
            AudioDecoderTrack.DecoderWrapper.access$600(AudioDecoderTrack.access$1100(this.this$0));
            AudioDecoderTrack.access$1102(this.this$0, null);
          }
        }
      }
      ??? = AudioDecoderTrack.access$700();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("AudioDecoderCreateThread finish - ");
      localStringBuilder1.append(this.extractor.assetPath);
      Logger.d((String)???, localStringBuilder1.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack.AudioDecoderCreateThread
 * JD-Core Version:    0.7.0.1
 */