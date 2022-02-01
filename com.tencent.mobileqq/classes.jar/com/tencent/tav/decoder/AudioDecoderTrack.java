package com.tencent.tav.decoder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.factory.AVDecoderFactory;
import com.tencent.tav.decoder.factory.IDecoderFactory;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AudioDecoderTrack
  implements IDecoderTrack
{
  private static String TAG = "AudioDecoderTrack";
  private float _speed = 1.0F;
  private AudioInfo audioInfo = new AudioInfo();
  private AudioMixer audioMixer = new AudioMixer();
  private AudioDecoder currentDecoder;
  private final Object currentDecoderLock = new Object();
  private CMTime currentSegmentStartTime = CMTime.CMTimeZero;
  private IDecoder.DecodeType decodeType = IDecoder.DecodeType.Audio;
  private AudioDecoderTrack.AudioDecoderCreateThread decoderCreateThread = null;
  private final AudioDecoderTrack.DecoderThread decoderThread = new AudioDecoderTrack.DecoderThread(this);
  private CMTime duration = CMTime.CMTimeZero;
  private ByteBuffer emptyAudioBuffer;
  private CMTime frameDuration = new CMTime(92880L, 1000000);
  private int frameRate = 11;
  private boolean isEmptyFrame = false;
  private boolean isReleased = false;
  @NonNull
  private CMSampleState lastSampleState = new CMSampleState();
  private AudioDecoderTrack.DecoderWrapper nextDecoder;
  private final Object nextDecoderLock = new Object();
  private boolean preRead = false;
  private int segmentIndex = -1;
  private ArrayList<DecoderTrackSegment> segments = new ArrayList();
  private boolean started = false;
  private int trackID = -1;
  private float volume = 1.0F;
  
  /* Error */
  private IDecoder createDecoder(@NonNull DecoderTrackSegment paramDecoderTrackSegment, CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 188	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   6: astore 7
    //   8: getstatic 55	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   11: new 190	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   18: ldc 193
    //   20: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload 7
    //   25: getfield 202	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   28: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 204
    //   33: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 213	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: iconst_5
    //   43: istore_3
    //   44: aconst_null
    //   45: astore 5
    //   47: aload 5
    //   49: ifnonnull +569 -> 618
    //   52: iload_3
    //   53: ifle +565 -> 618
    //   56: iload_3
    //   57: iconst_1
    //   58: isub
    //   59: istore_3
    //   60: aload_0
    //   61: getfield 103	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   64: ifnull +202 -> 266
    //   67: aload_0
    //   68: getfield 103	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   71: invokestatic 219	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:access$000	(Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;)I
    //   74: istore 4
    //   76: iload 4
    //   78: aload_0
    //   79: getfield 82	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   82: invokevirtual 223	java/util/ArrayList:size	()I
    //   85: if_icmpge +154 -> 239
    //   88: aload_0
    //   89: getfield 82	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   92: iload 4
    //   94: invokevirtual 227	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   97: checkcast 184	com/tencent/tav/decoder/DecoderTrackSegment
    //   100: invokevirtual 188	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   103: aload 7
    //   105: invokestatic 147	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   108: ifeq +131 -> 239
    //   111: aload_0
    //   112: getfield 105	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   115: astore 6
    //   117: aload 6
    //   119: monitorenter
    //   120: aload_0
    //   121: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   124: ifnull +112 -> 236
    //   127: aload_0
    //   128: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   131: getfield 233	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   134: aload 7
    //   136: invokestatic 147	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   139: ifeq +97 -> 236
    //   142: aload_0
    //   143: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   146: getfield 237	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IAudioDecoder;
    //   149: ifnull +87 -> 236
    //   152: aload_0
    //   153: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   156: getfield 237	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IAudioDecoder;
    //   159: astore_2
    //   160: aload_0
    //   161: getfield 82	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   164: aload_0
    //   165: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   168: getfield 238	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   171: invokevirtual 227	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   174: aload_1
    //   175: if_acmpeq +17 -> 192
    //   178: aload_2
    //   179: aload_1
    //   180: invokevirtual 242	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   183: aload_1
    //   184: invokevirtual 246	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   187: invokeinterface 252 3 0
    //   192: aload_0
    //   193: aconst_null
    //   194: putfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   197: getstatic 55	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   200: new 190	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   207: ldc 254
    //   209: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_2
    //   213: invokeinterface 257 1 0
    //   218: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 213	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload 6
    //   229: monitorexit
    //   230: aload_2
    //   231: astore_1
    //   232: aload_0
    //   233: monitorexit
    //   234: aload_1
    //   235: areturn
    //   236: aload 6
    //   238: monitorexit
    //   239: aload_1
    //   240: invokevirtual 242	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   243: astore 6
    //   245: aload 6
    //   247: ifnonnull +243 -> 490
    //   250: aconst_null
    //   251: astore_1
    //   252: goto -20 -> 232
    //   255: astore_1
    //   256: aload 6
    //   258: monitorexit
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: aload_0
    //   263: monitorexit
    //   264: aload_1
    //   265: athrow
    //   266: getstatic 55	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   269: new 190	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 259
    //   279: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 7
    //   284: getfield 202	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   287: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 213	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_0
    //   297: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   300: ifnull -61 -> 239
    //   303: aload_0
    //   304: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   307: getfield 233	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   310: aload 7
    //   312: invokestatic 147	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   315: ifeq -76 -> 239
    //   318: aload_0
    //   319: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   322: getfield 237	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IAudioDecoder;
    //   325: ifnull -86 -> 239
    //   328: aload_0
    //   329: getfield 105	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   332: astore 6
    //   334: aload 6
    //   336: monitorenter
    //   337: aload_0
    //   338: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   341: ifnull +143 -> 484
    //   344: aload_0
    //   345: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   348: getfield 233	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   351: aload 7
    //   353: if_acmpne +131 -> 484
    //   356: aload_0
    //   357: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   360: getfield 237	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IAudioDecoder;
    //   363: ifnull +121 -> 484
    //   366: aload_0
    //   367: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   370: getfield 237	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IAudioDecoder;
    //   373: astore_2
    //   374: aload_0
    //   375: getfield 82	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   378: aload_0
    //   379: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   382: getfield 238	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   385: invokevirtual 227	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   388: aload_1
    //   389: if_acmpeq +17 -> 406
    //   392: aload_2
    //   393: aload_1
    //   394: invokevirtual 242	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   397: aload_1
    //   398: invokevirtual 246	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   401: invokeinterface 252 3 0
    //   406: getstatic 55	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   409: new 190	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   416: ldc 254
    //   418: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_2
    //   422: invokeinterface 257 1 0
    //   427: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc_w 261
    //   433: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload_0
    //   437: getfield 91	com/tencent/tav/decoder/AudioDecoderTrack:segmentIndex	I
    //   440: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   443: ldc_w 266
    //   446: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_0
    //   450: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   453: getfield 238	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   456: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 213	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: aload_0
    //   466: aconst_null
    //   467: putfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   470: aload 6
    //   472: monitorexit
    //   473: aload_2
    //   474: astore_1
    //   475: goto -243 -> 232
    //   478: astore_1
    //   479: aload 6
    //   481: monitorexit
    //   482: aload_1
    //   483: athrow
    //   484: aload 6
    //   486: monitorexit
    //   487: goto -248 -> 239
    //   490: aload_0
    //   491: aload 7
    //   493: invokespecial 159	com/tencent/tav/decoder/AudioDecoderTrack:newDecoder	(Lcom/tencent/tav/decoder/DecoderAssetTrack;)Lcom/tencent/tav/decoder/IAudioDecoder;
    //   496: astore 6
    //   498: aload 6
    //   500: ifnull +53 -> 553
    //   503: aload 6
    //   505: astore 5
    //   507: aload 6
    //   509: aload_1
    //   510: invokevirtual 242	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   513: aload_2
    //   514: invokeinterface 252 3 0
    //   519: aload 6
    //   521: astore 5
    //   523: getstatic 55	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   526: new 190	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 268
    //   536: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload 7
    //   541: getfield 202	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   544: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 213	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: aload 6
    //   555: astore 5
    //   557: goto -510 -> 47
    //   560: astore 6
    //   562: getstatic 55	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   565: new 190	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   572: ldc_w 270
    //   575: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload 6
    //   580: invokevirtual 273	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   583: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload 6
    //   588: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 279	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload 5
    //   599: ifnull +10 -> 609
    //   602: aload 5
    //   604: invokeinterface 282 1 0
    //   609: aconst_null
    //   610: astore 5
    //   612: goto -565 -> 47
    //   615: astore_1
    //   616: aload_1
    //   617: athrow
    //   618: aload 5
    //   620: astore_1
    //   621: goto -389 -> 232
    //   624: astore 5
    //   626: goto -17 -> 609
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	this	AudioDecoderTrack
    //   0	629	1	paramDecoderTrackSegment	DecoderTrackSegment
    //   0	629	2	paramCMTime	CMTime
    //   43	17	3	i	int
    //   74	19	4	j	int
    //   45	574	5	localObject1	Object
    //   624	1	5	localException1	Exception
    //   115	439	6	localObject2	Object
    //   560	27	6	localException2	Exception
    //   6	534	7	localDecoderAssetTrack	DecoderAssetTrack
    // Exception table:
    //   from	to	target	type
    //   120	192	255	finally
    //   192	230	255	finally
    //   236	239	255	finally
    //   256	259	255	finally
    //   2	42	261	finally
    //   60	120	261	finally
    //   239	245	261	finally
    //   259	261	261	finally
    //   266	337	261	finally
    //   482	484	261	finally
    //   490	498	261	finally
    //   507	519	261	finally
    //   523	553	261	finally
    //   562	597	261	finally
    //   616	618	261	finally
    //   337	406	478	finally
    //   406	473	478	finally
    //   479	482	478	finally
    //   484	487	478	finally
    //   490	498	560	java/lang/Exception
    //   507	519	560	java/lang/Exception
    //   523	553	560	java/lang/Exception
    //   602	609	615	finally
    //   602	609	624	java/lang/Exception
  }
  
  private void createNextDecoder(int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (this.segments != null)
        {
          bool = this.preRead;
          if (bool) {}
        }
        else
        {
          return;
        }
        int i = paramInt + 1;
        if ((i >= this.segments.size()) || (this.decoderCreateThread != null)) {
          continue;
        }
        DecoderAssetTrack localDecoderAssetTrack = ((DecoderTrackSegment)this.segments.get(i)).getVideoAsset();
        if (localDecoderAssetTrack != null)
        {
          if (this.nextDecoder != null)
          {
            bool = isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack);
            if (bool) {
              continue;
            }
          }
          try
          {
            this.decoderCreateThread = new AudioDecoderTrack.AudioDecoderCreateThread(this, localDecoderAssetTrack, null, i, null);
            this.decoderCreateThread.start();
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          continue;
        }
        if (this.nextDecoder == null) {
          continue;
        }
      }
      finally {}
      if ((paramInt >= 0) && (paramInt < this.segments.size()) && (this.nextDecoder.segmentIndex != paramInt))
      {
        this.nextDecoder.decoder.start(((DecoderTrackSegment)this.segments.get(paramInt)).getTimeRange());
        this.nextDecoder.segmentIndex = paramInt;
      }
    }
  }
  
  private CMSampleBuffer doReadSample(CMTime paramCMTime)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        if (this.isReleased)
        {
          Logger.e(TAG, "doReadSample: has released");
          paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
          return paramCMTime;
        }
        paramCMTime = CMSampleState.fromError(-1L);
        this.isEmptyFrame = false;
        if (this.segmentIndex != -1) {
          break;
        }
        Logger.i(TAG, "doReadSample: segmentIndex == -1");
        if (this.lastSampleState.getStateCode() < -1L)
        {
          paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-100L));
          return paramCMTime;
        }
      }
      finally {}
      paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
    }
    Object localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    CMTime localCMTime;
    if (this.currentDecoder == null)
    {
      localCMTime = this.lastSampleState.getTime().add(this.frameDuration);
      if (this.lastSampleState.isInvalid()) {
        localCMTime = CMTime.CMTimeZero;
      }
      if (!localCMTime.smallThan(this.currentSegmentStartTime.add(((DecoderTrackSegment)localObject1).getScaledDuration()))) {
        break label645;
      }
      this.isEmptyFrame = true;
      Logger.v(TAG, "doReadSample: return emptyBuffer currentDecoder == null");
      paramCMTime = new CMSampleBuffer(localCMTime, outputBuffer());
      return paramCMTime;
    }
    label645:
    for (;;)
    {
      if (paramCMTime.getStateCode() == -1L)
      {
        localObject1 = ((DecoderTrackSegment)localObject1).getScaledDuration().add(this.currentSegmentStartTime);
        localCMTime = this.lastSampleState.getTime().add(this.frameDuration);
        if (((CMTime)localObject1).bigThan(localCMTime))
        {
          if (this.currentDecoder == null) {}
          for (paramCMTime = getEmptyAudioBuffer();; paramCMTime = this.currentDecoder.outputBuffer())
          {
            Logger.v(TAG, "doReadSample: finish && !end");
            localObject1 = paramCMTime;
            if (paramCMTime == null) {
              localObject1 = getEmptyAudioBuffer();
            }
            paramCMTime = new CMSampleBuffer(localCMTime, (ByteBuffer)localObject1);
            return paramCMTime;
            if (this.lastSampleState.getTime().sub(this.currentSegmentStartTime).multi(this._speed).bigThan(((DecoderTrackSegment)localObject1).getScaledDuration().multi(this._speed)))
            {
              paramCMTime = CMSampleState.fromError(-1L);
              break;
            }
            paramCMTime = this.currentDecoder.readSample(CMTime.CMTimeInvalid);
            break;
          }
        }
        if (!nextSegment(true))
        {
          Logger.v(TAG, "doReadSample: finish && end && next failed");
          localObject1 = CMSampleState.fromError(-1L);
          if (this.currentDecoder == null) {}
          for (paramCMTime = localObject3;; paramCMTime = this.currentDecoder.outputBuffer())
          {
            paramCMTime = new CMSampleBuffer((CMSampleState)localObject1, paramCMTime);
            return paramCMTime;
          }
        }
        localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
        break;
      }
      if (paramCMTime.getStateCode() >= 0L)
      {
        localCMTime = paramCMTime.getTime().sub(((DecoderTrackSegment)localObject1).getDecoderStartTime()).divide(this._speed);
        paramCMTime = localCMTime;
        if (localCMTime.getTimeUs() > ((DecoderTrackSegment)localObject1).getScaledDuration().getTimeUs()) {
          paramCMTime = ((DecoderTrackSegment)localObject1).getScaledDuration();
        }
        localObject1 = new CMSampleState(paramCMTime.add(this.currentSegmentStartTime));
        Logger.v(TAG, "doReadSample: [success] " + localObject1);
        if (this.currentDecoder != null) {
          break label634;
        }
      }
      label634:
      for (paramCMTime = localObject2;; paramCMTime = this.currentDecoder.outputBuffer())
      {
        paramCMTime = new CMSampleBuffer((CMSampleState)localObject1, paramCMTime);
        return paramCMTime;
        if ((paramCMTime.getStateCode() != -3L) && (paramCMTime.getStateCode() != -100L))
        {
          paramCMTime = new CMSampleBuffer(this.lastSampleState);
          return paramCMTime;
        }
        paramCMTime = new CMSampleBuffer(paramCMTime);
        return paramCMTime;
      }
    }
  }
  
  private void doReleaseCurrentDecoder()
  {
    if ((this.currentDecoder == null) || (this.currentDecoder.getSourcePath() == null)) {
      return;
    }
    AudioDecoder localAudioDecoder = this.currentDecoder;
    this.currentDecoder = null;
    ThreadPool.execute(new AudioDecoderTrack.1(this, localAudioDecoder));
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    CMTime localCMTime1 = CMTime.CMTimeZero;
    Iterator localIterator = this.segments.iterator();
    int i = 0;
    CMTime localCMTime2;
    if (localIterator.hasNext())
    {
      localCMTime2 = ((DecoderTrackSegment)localIterator.next()).getScaledDuration();
      if ((paramCMTime.compare(localCMTime1) < 0) || (!paramCMTime.smallThan(localCMTime1.add(localCMTime2)))) {}
    }
    for (int j = 1;; j = 0)
    {
      if ((j == 0) && (paramCMTime == localCMTime1) && (i > 0) && (paramBoolean))
      {
        i -= 1;
        j = 1;
      }
      for (;;)
      {
        if (j != 0)
        {
          return i;
          localCMTime1 = localCMTime1.add(localCMTime2);
          i += 1;
          break;
        }
        return -1;
      }
    }
  }
  
  private CMTime getSegmentStartTime(int paramInt)
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while (i < paramInt)
    {
      localCMTime = CMTime.add(localCMTime, ((DecoderTrackSegment)this.segments.get(i)).getScaledDuration());
      i += 1;
    }
    return localCMTime;
  }
  
  private static boolean isSameExtractor(DecoderAssetTrack paramDecoderAssetTrack1, DecoderAssetTrack paramDecoderAssetTrack2)
  {
    return (paramDecoderAssetTrack1 != null) && (paramDecoderAssetTrack2 != null) && (paramDecoderAssetTrack1.assetPath != null) && (paramDecoderAssetTrack1.assetPath.equals(paramDecoderAssetTrack2.assetPath));
  }
  
  @Nullable
  private IAudioDecoder newDecoder(DecoderAssetTrack paramDecoderAssetTrack)
  {
    IVideoDecoder.Params localParams = new IVideoDecoder.Params();
    localParams.sourceType = paramDecoderAssetTrack.sourceType;
    localParams.filePath = paramDecoderAssetTrack.assetPath;
    return AVDecoderFactory.getInstance().createAudioDecoder(localParams);
  }
  
  private boolean nextSegment(boolean paramBoolean)
  {
    Logger.d(TAG, "nextSegment:" + paramBoolean);
    this.segmentIndex += 1;
    if (this.segmentIndex >= this.segments.size())
    {
      this.segmentIndex = -1;
      return false;
    }
    this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
    this.lastSampleState = new CMSampleState(this.currentSegmentStartTime);
    if (this.lastSampleState.getTime().equalsTo(CMTime.CMTimeZero)) {
      this.lastSampleState = new CMSampleState();
    }
    Object localObject2 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    IDecoder localIDecoder;
    if (((DecoderTrackSegment)localObject2).getVideoAsset() != null)
    {
      releaseCurrentDecoder();
      if (paramBoolean)
      {
        ??? = ((DecoderTrackSegment)this.segments.get(this.segmentIndex)).getDecoderStartTime();
        localIDecoder = createDecoder((DecoderTrackSegment)localObject2, (CMTime)???);
      }
    }
    for (;;)
    {
      synchronized (this.currentDecoderLock)
      {
        this.currentDecoder = ((AudioDecoder)localIDecoder);
        if (this.audioMixer != null) {
          this.audioMixer.release();
        }
        this.audioMixer = new AudioMixer();
        if ((this.currentDecoder != null) && (this.currentDecoder.hasTrack()) && (paramBoolean)) {
          this.currentDecoder.seekTo(((DecoderTrackSegment)localObject2).getDecoderStartTime());
        }
        if (((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs() > 0L) {
          this._speed = ((float)((DecoderTrackSegment)localObject2).getTimeRange().getDurationUs() * 1.0F / (float)((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs());
        }
        ??? = TAG;
        localObject2 = new StringBuilder().append("nextSegment:");
        if (this.currentDecoder != null) {
          break label359;
        }
        paramBoolean = true;
        Logger.d((String)???, paramBoolean + " " + this._speed);
        return true;
        ??? = CMTime.CMTimeInvalid;
      }
      Logger.d(TAG, "nextSegment: videoAsset is null");
      releaseCurrentDecoder();
      continue;
      label359:
      paramBoolean = false;
    }
  }
  
  private void releaseCurrentDecoder()
  {
    synchronized (this.currentDecoderLock)
    {
      doReleaseCurrentDecoder();
      return;
    }
  }
  
  public void asyncReadNextSample(CMTime arg1)
  {
    if (AudioDecoderTrack.DecoderThread.access$200(this.decoderThread) == null) {
      synchronized (this.decoderThread)
      {
        if (AudioDecoderTrack.DecoderThread.access$200(this.decoderThread) == null) {
          this.decoderThread.action();
        }
        return;
      }
    }
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0)) {}
    CMTime localCMTime2;
    CMTime localCMTime3;
    do
    {
      return;
      CMTime localCMTime1 = paramCMTimeRange.getStart();
      localCMTime2 = paramCMTimeRange.getEnd();
      localCMTime3 = duration();
      clipRangeAndRemoveRange(paramCMTimeRange);
      if (localCMTime1.getValue() != 0L) {
        this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1), null));
      }
    } while (localCMTime2.getTimeUs() >= localCMTime3.getTimeUs());
    this.segments.add(new DecoderTrackSegment(new CMTimeRange(localCMTime2, new CMTime(localCMTime3.getTimeSeconds() - localCMTime2.getTimeSeconds())), null));
  }
  
  public void clipRangeAndRemoveRange(CMTimeRange paramCMTimeRange)
  {
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0)) {}
    Object localObject;
    CMTime localCMTime1;
    int k;
    do
    {
      return;
      localObject = paramCMTimeRange.getStart();
      localCMTime1 = paramCMTimeRange.getEnd();
      k = findSegmentIndexAt((CMTime)localObject, false);
    } while (k == -1);
    int i = findSegmentIndexAt(localCMTime1, false);
    if (i == -1) {
      i = this.segments.size() - 1;
    }
    for (;;)
    {
      localCMTime1 = getSegmentStartTime(k);
      CMTime localCMTime2 = getSegmentStartTime(i);
      localObject = (DecoderTrackSegment)this.segments.get(k);
      DecoderTrackSegment localDecoderTrackSegment = (DecoderTrackSegment)this.segments.get(i);
      localCMTime2 = paramCMTimeRange.getEnd().sub(localCMTime2);
      float f = (float)localDecoderTrackSegment.getScaledDuration().getTimeUs() * 1.0F / (float)localDecoderTrackSegment.getTimeRange().getDurationUs();
      localDecoderTrackSegment.setTimeRange(new CMTimeRange(localDecoderTrackSegment.getTimeRange().getStart(), localCMTime2.divide(f)));
      localDecoderTrackSegment.setScaledDuration(localCMTime2);
      f = (float)((DecoderTrackSegment)localObject).getScaledDuration().getTimeUs() * 1.0F / (float)((DecoderTrackSegment)localObject).getTimeRange().getDurationUs();
      paramCMTimeRange = paramCMTimeRange.getStart().sub(localCMTime1);
      localCMTime1 = paramCMTimeRange.divide(f);
      ((DecoderTrackSegment)localObject).setTimeRange(new CMTimeRange(((DecoderTrackSegment)localObject).getTimeRange().getStart().add(localCMTime1), ((DecoderTrackSegment)localObject).getTimeRange().getDuration().sub(localCMTime1)));
      ((DecoderTrackSegment)localObject).setScaledDuration(((DecoderTrackSegment)localObject).getScaledDuration().sub(paramCMTimeRange));
      int j = this.segments.size() - 1;
      while (j >= 0)
      {
        if ((j > i) || (j < k)) {
          this.segments.remove(j);
        }
        j -= 1;
      }
      break;
      if (getSegmentStartTime(i) == localCMTime1) {
        i -= 1;
      }
    }
  }
  
  public CMTime duration()
  {
    return getSegmentStartTime(this.segments.size());
  }
  
  public AudioInfo getAudioInfo()
  {
    if (this.currentDecoder != null) {
      return this.currentDecoder.getAudioInfo();
    }
    return this.audioInfo;
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleState.getTime();
  }
  
  public CMTime getDuration()
  {
    if (this.duration == CMTime.CMTimeZero)
    {
      CMTime localCMTime = CMTime.CMTimeZero;
      Iterator localIterator = this.segments.iterator();
      while (localIterator.hasNext()) {
        localCMTime = localCMTime.add(((DecoderTrackSegment)localIterator.next()).getScaledDuration());
      }
      this.duration = localCMTime;
    }
    return this.duration;
  }
  
  public ByteBuffer getEmptyAudioBuffer()
  {
    if (this.emptyAudioBuffer == null)
    {
      long l = this.audioInfo.channelCount * this.audioInfo.sampleRate * this.frameDuration.getTimeUs() / 1000000L;
      this.emptyAudioBuffer = ByteBuffer.allocate((int)l * 2);
      this.emptyAudioBuffer.order(ByteOrder.LITTLE_ENDIAN);
      short[] arrayOfShort = new short[(int)l];
      int i = 0;
      while (i < l)
      {
        arrayOfShort[i] = 0;
        i += 1;
      }
      this.emptyAudioBuffer.asShortBuffer().put(arrayOfShort, 0, (int)l);
    }
    this.emptyAudioBuffer.position(0);
    return this.emptyAudioBuffer;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public int getFrameRate()
  {
    return this.frameRate;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  public int getTrackId()
  {
    return this.trackID;
  }
  
  public ByteBuffer outputBuffer()
  {
    if (this.isEmptyFrame) {
      return getEmptyAudioBuffer();
    }
    if (this.currentDecoder == null) {
      return null;
    }
    return this.currentDecoder.outputBuffer();
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    try
    {
      if (this.audioMixer.getDestAudioChannelCount() != paramAudioInfo.channelCount)
      {
        this.audioMixer.release();
        this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
      }
      paramByteBuffer = this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
      return paramByteBuffer;
    }
    finally {}
  }
  
  public CMSampleBuffer readSample()
  {
    return readSample(CMTime.CMTimeInvalid);
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    Logger.v(TAG, "readSample: [start]" + paramCMTime);
    if (this.isReleased)
    {
      Logger.e(TAG, "readSample: [error] has released");
      return new CMSampleBuffer(CMSampleState.fromError(-1L));
    }
    synchronized (AudioDecoderTrack.DecoderThread.access$100(this.decoderThread))
    {
      if ((AudioDecoderTrack.DecoderThread.access$200(this.decoderThread) != null) && (AudioDecoderTrack.CacheBuffer.access$300(AudioDecoderTrack.DecoderThread.access$200(this.decoderThread)) == this.lastSampleState.getTime()))
      {
        paramCMTime = AudioDecoderTrack.CacheBuffer.access$400(AudioDecoderTrack.DecoderThread.access$200(this.decoderThread));
        this.lastSampleState = new CMSampleState(AudioDecoderTrack.CacheBuffer.access$300(AudioDecoderTrack.DecoderThread.access$200(this.decoderThread)));
        createNextDecoder(this.segmentIndex);
        Logger.v(TAG, "readSample: [success] hit asyncRead - " + this.lastSampleState);
        return paramCMTime;
      }
    }
    paramCMTime = doReadSample(paramCMTime);
    if ((paramCMTime.getSampleByteBuffer() != null) && (this._speed > 0.1F) && (this._speed < 16.0F))
    {
      Logger.v(TAG, "readSample: processFrame [volume " + this.volume + "] [_speed " + this._speed + "]");
      paramCMTime.setSampleByteBuffer(processFrame(paramCMTime.getSampleByteBuffer(), this.volume, this._speed, getAudioInfo()));
      Logger.v(TAG, "readSample: processFrame finish [volume " + this.volume + "] [_speed " + this._speed + "]");
    }
    this.lastSampleState = paramCMTime.getState();
    createNextDecoder(this.segmentIndex);
    Logger.v(TAG, "readSample: [success]  - " + this.lastSampleState);
    return paramCMTime;
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 55	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   5: ldc_w 669
    //   8: invokestatic 213	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 116	com/tencent/tav/decoder/AudioDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderThread;
    //   15: invokevirtual 670	com/tencent/tav/decoder/AudioDecoderTrack$DecoderThread:release	()V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 109	com/tencent/tav/decoder/AudioDecoderTrack:isReleased	Z
    //   23: aload_0
    //   24: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   27: ifnull +15 -> 42
    //   30: aload_0
    //   31: getfield 151	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   34: invokevirtual 671	com/tencent/tav/decoder/AudioDecoder:release	()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 151	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   42: aload_0
    //   43: getfield 105	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   46: astore_1
    //   47: aload_1
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   53: ifnull +15 -> 68
    //   56: aload_0
    //   57: getfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   60: invokestatic 675	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 140	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   68: aload_1
    //   69: monitorexit
    //   70: getstatic 55	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   73: ldc_w 677
    //   76: invokestatic 213	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_2
    //   83: aload_1
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	AudioDecoderTrack
    //   87	4	1	localObject2	Object
    //   82	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	68	82	finally
    //   68	70	82	finally
    //   83	85	82	finally
    //   2	42	87	finally
    //   42	49	87	finally
    //   70	79	87	finally
    //   85	87	87	finally
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    Logger.v(TAG, "seekTo:[time " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    if (this.isReleased)
    {
      Logger.e(TAG, "seekTo: [failed] has released");
      return new CMSampleBuffer(CMSampleState.fromError(-1L));
    }
    synchronized (AudioDecoderTrack.DecoderThread.access$100(this.decoderThread))
    {
      AudioDecoderTrack.DecoderThread.access$202(this.decoderThread, null);
      if (!this.started)
      {
        Logger.d(TAG, "seekTo: [failed] un started");
        return null;
      }
    }
    int i = findSegmentIndexAt(paramCMTime, true);
    if (i == -1)
    {
      this.segmentIndex = -1;
      Logger.e(TAG, "seekTo: [failed] segmentIndex = -1");
      return null;
    }
    ??? = getSegmentStartTime(i);
    if ((this.segmentIndex != i) || (this.currentDecoder == null))
    {
      this.segmentIndex = (i - 1);
      nextSegment(false);
    }
    ??? = paramCMTime.sub((CMTime)???).multi(this._speed);
    DecoderTrackSegment localDecoderTrackSegment = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    if (this.currentDecoder == null)
    {
      this.lastSampleState = new CMSampleState(paramCMTime);
      Logger.d(TAG, "seekTo: [failed] currentDecoder == null ");
      return null;
    }
    this.currentDecoder.seekTo(localDecoderTrackSegment.getDecoderStartTime().add((CMTime)???));
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleState = new CMSampleState(paramCMTime.sub(this.frameDuration));; this.lastSampleState = new CMSampleState(paramCMTime))
    {
      Logger.v(TAG, "seekTo: [success] [lastSampleState " + this.lastSampleState + "]");
      return null;
    }
  }
  
  public void setAudioInfo(@NonNull AudioInfo paramAudioInfo)
  {
    this.audioInfo = paramAudioInfo.clone();
    if (this.emptyAudioBuffer != null) {
      this.emptyAudioBuffer = null;
    }
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.decodeType = paramDecodeType;
  }
  
  public void setFrameRate(int paramInt)
  {
    this.frameDuration = this.frameDuration.divide(paramInt / this.frameRate);
    this.frameRate = paramInt;
  }
  
  public void setTrackID(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    if (this.segments == null) {
      this.segments = new ArrayList();
    }
    this.segments.clear();
    this.segments.addAll(paramList);
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
  }
  
  public float speed()
  {
    return this._speed;
  }
  
  public void start()
  {
    start(null);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    start(paramSurfaceCreator, null);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    if (this.segments.size() == 0)
    {
      release();
      return;
    }
    this.isReleased = false;
    this.decoderThread.start();
    this.started = true;
    this.segmentIndex = -1;
    clipRangeAndRemoveRange(paramCMTimeRange);
    nextSegment(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack
 * JD-Core Version:    0.7.0.1
 */