package com.tencent.tav.decoder;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
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
  private CMTime lastSampleTime = CMTime.CMTimeInvalid;
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
    //   3: invokevirtual 180	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   6: astore 8
    //   8: getstatic 53	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   11: new 182	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   18: ldc 185
    //   20: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload 8
    //   25: getfield 194	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   28: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 196
    //   33: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: iconst_5
    //   47: istore_3
    //   48: aconst_null
    //   49: astore 5
    //   51: aload 5
    //   53: ifnonnull +584 -> 637
    //   56: iload_3
    //   57: ifle +580 -> 637
    //   60: iload_3
    //   61: iconst_1
    //   62: isub
    //   63: istore_3
    //   64: aload_0
    //   65: getfield 101	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   68: ifnull +206 -> 274
    //   71: aload_0
    //   72: getfield 101	com/tencent/tav/decoder/AudioDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;
    //   75: invokestatic 211	com/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread:access$000	(Lcom/tencent/tav/decoder/AudioDecoderTrack$AudioDecoderCreateThread;)I
    //   78: istore 4
    //   80: iload 4
    //   82: aload_0
    //   83: getfield 80	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   86: invokevirtual 215	java/util/ArrayList:size	()I
    //   89: if_icmpge +158 -> 247
    //   92: aload_0
    //   93: getfield 80	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   96: iload 4
    //   98: invokevirtual 219	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   101: checkcast 176	com/tencent/tav/decoder/DecoderTrackSegment
    //   104: invokevirtual 180	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   107: aload 8
    //   109: invokestatic 145	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   112: ifeq +135 -> 247
    //   115: aload_0
    //   116: getfield 103	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   119: astore 6
    //   121: aload 6
    //   123: monitorenter
    //   124: aload_0
    //   125: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   128: ifnull +116 -> 244
    //   131: aload_0
    //   132: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   135: getfield 225	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   138: aload 8
    //   140: invokestatic 145	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   143: ifeq +101 -> 244
    //   146: aload_0
    //   147: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   150: getfield 229	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   153: ifnull +91 -> 244
    //   156: aload_0
    //   157: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   160: getfield 229	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   163: astore_2
    //   164: aload_0
    //   165: getfield 80	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   168: aload_0
    //   169: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   172: getfield 230	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   175: invokevirtual 219	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   178: aload_1
    //   179: if_acmpeq +17 -> 196
    //   182: aload_2
    //   183: aload_1
    //   184: invokevirtual 234	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   187: aload_1
    //   188: invokevirtual 238	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   191: invokeinterface 244 3 0
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   201: getstatic 53	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   204: new 182	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   211: ldc 246
    //   213: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_2
    //   217: invokeinterface 249 1 0
    //   222: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload 6
    //   237: monitorexit
    //   238: aload_2
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_1
    //   243: areturn
    //   244: aload 6
    //   246: monitorexit
    //   247: aload_1
    //   248: invokevirtual 234	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   251: astore 6
    //   253: aload 6
    //   255: ifnonnull +249 -> 504
    //   258: aconst_null
    //   259: astore_1
    //   260: goto -20 -> 240
    //   263: astore_1
    //   264: aload 6
    //   266: monitorexit
    //   267: aload_1
    //   268: athrow
    //   269: astore_1
    //   270: aload_0
    //   271: monitorexit
    //   272: aload_1
    //   273: athrow
    //   274: getstatic 53	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   277: new 182	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   284: ldc 251
    //   286: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 8
    //   291: getfield 194	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   294: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: iconst_0
    //   301: anewarray 4	java/lang/Object
    //   304: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload_0
    //   308: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   311: ifnull -64 -> 247
    //   314: aload_0
    //   315: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   318: getfield 225	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   321: aload 8
    //   323: invokestatic 145	com/tencent/tav/decoder/AudioDecoderTrack:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   326: ifeq -79 -> 247
    //   329: aload_0
    //   330: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   333: getfield 229	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   336: ifnull -89 -> 247
    //   339: aload_0
    //   340: getfield 103	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   343: astore 6
    //   345: aload 6
    //   347: monitorenter
    //   348: aload_0
    //   349: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   352: ifnull +146 -> 498
    //   355: aload_0
    //   356: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   359: getfield 225	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   362: aload 8
    //   364: if_acmpne +134 -> 498
    //   367: aload_0
    //   368: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   371: getfield 229	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   374: ifnull +124 -> 498
    //   377: aload_0
    //   378: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   381: getfield 229	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IDecoder;
    //   384: astore_2
    //   385: aload_0
    //   386: getfield 80	com/tencent/tav/decoder/AudioDecoderTrack:segments	Ljava/util/ArrayList;
    //   389: aload_0
    //   390: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   393: getfield 230	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   396: invokevirtual 219	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   399: aload_1
    //   400: if_acmpeq +17 -> 417
    //   403: aload_2
    //   404: aload_1
    //   405: invokevirtual 234	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   408: aload_1
    //   409: invokevirtual 238	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   412: invokeinterface 244 3 0
    //   417: getstatic 53	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   420: new 182	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   427: ldc 246
    //   429: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_2
    //   433: invokeinterface 249 1 0
    //   438: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: ldc 253
    //   443: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_0
    //   447: getfield 89	com/tencent/tav/decoder/AudioDecoderTrack:segmentIndex	I
    //   450: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   453: ldc_w 258
    //   456: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_0
    //   460: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   463: getfield 230	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:segmentIndex	I
    //   466: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   469: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: iconst_0
    //   473: anewarray 4	java/lang/Object
    //   476: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   479: aload_0
    //   480: aconst_null
    //   481: putfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   484: aload 6
    //   486: monitorexit
    //   487: aload_2
    //   488: astore_1
    //   489: goto -249 -> 240
    //   492: astore_1
    //   493: aload 6
    //   495: monitorexit
    //   496: aload_1
    //   497: athrow
    //   498: aload 6
    //   500: monitorexit
    //   501: goto -254 -> 247
    //   504: new 260	com/tencent/tav/decoder/AudioDecoder
    //   507: dup
    //   508: aload 8
    //   510: getfield 194	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   513: invokespecial 263	com/tencent/tav/decoder/AudioDecoder:<init>	(Ljava/lang/String;)V
    //   516: astore 6
    //   518: aload 6
    //   520: aload_1
    //   521: invokevirtual 234	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   524: aload_2
    //   525: invokeinterface 244 3 0
    //   530: getstatic 53	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   533: new 182	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   540: ldc_w 265
    //   543: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 8
    //   548: getfield 194	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   551: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: iconst_0
    //   558: anewarray 4	java/lang/Object
    //   561: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   564: aload 6
    //   566: astore 5
    //   568: goto -517 -> 51
    //   571: astore 7
    //   573: aload 6
    //   575: astore 5
    //   577: aload 7
    //   579: astore 6
    //   581: getstatic 53	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   584: new 182	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 267
    //   594: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 6
    //   599: invokevirtual 270	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   602: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload 6
    //   607: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 277	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: aload 5
    //   618: ifnull +10 -> 628
    //   621: aload 5
    //   623: invokeinterface 280 1 0
    //   628: aconst_null
    //   629: astore 5
    //   631: goto -580 -> 51
    //   634: astore_1
    //   635: aload_1
    //   636: athrow
    //   637: aload 5
    //   639: astore_1
    //   640: goto -400 -> 240
    //   643: astore 5
    //   645: goto -17 -> 628
    //   648: astore 6
    //   650: goto -69 -> 581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	AudioDecoderTrack
    //   0	653	1	paramDecoderTrackSegment	DecoderTrackSegment
    //   0	653	2	paramCMTime	CMTime
    //   47	17	3	i	int
    //   78	19	4	j	int
    //   49	589	5	localObject1	Object
    //   643	1	5	localException1	Exception
    //   119	487	6	localObject2	Object
    //   648	1	6	localException2	Exception
    //   571	7	7	localException3	Exception
    //   6	541	8	localDecoderAssetTrack	DecoderAssetTrack
    // Exception table:
    //   from	to	target	type
    //   124	196	263	finally
    //   196	238	263	finally
    //   244	247	263	finally
    //   264	267	263	finally
    //   2	46	269	finally
    //   64	124	269	finally
    //   247	253	269	finally
    //   267	269	269	finally
    //   274	348	269	finally
    //   496	498	269	finally
    //   504	518	269	finally
    //   518	564	269	finally
    //   581	616	269	finally
    //   635	637	269	finally
    //   348	417	492	finally
    //   417	487	492	finally
    //   493	496	492	finally
    //   498	501	492	finally
    //   518	564	571	java/lang/Exception
    //   621	628	634	finally
    //   621	628	643	java/lang/Exception
    //   504	518	648	java/lang/Exception
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
          paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
          return paramCMTime;
        }
        paramCMTime = IDecoder.SAMPLE_TIME_FINISH;
        this.isEmptyFrame = false;
        if (this.segmentIndex != -1) {
          break;
        }
        if (Logger.LOG_VERBOSE) {
          Logger.e(TAG, "doReadSample: segmentIndex == -1");
        }
        if (this.lastSampleTime.smallThan(IDecoder.SAMPLE_TIME_FINISH))
        {
          paramCMTime = new CMSampleBuffer(AudioDecoder.SAMPLE_TIME_UNSTART);
          return paramCMTime;
        }
      }
      finally {}
      paramCMTime = new CMSampleBuffer(VideoDecoder.SAMPLE_TIME_FINISH);
    }
    Object localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    CMTime localCMTime2 = this.lastSampleTime.clone();
    CMTime localCMTime1;
    if (this.currentDecoder == null)
    {
      localCMTime1 = localCMTime2.add(this.frameDuration);
      if (localCMTime2.equalsTo(CMTime.CMTimeInvalid)) {
        localCMTime1 = CMTime.CMTimeZero;
      }
      if (!localCMTime1.smallThan(this.currentSegmentStartTime.add(((DecoderTrackSegment)localObject1).getScaledDuration()))) {
        break label656;
      }
      this.isEmptyFrame = true;
      if (Logger.LOG_VERBOSE) {
        Logger.d(TAG, "doReadSample: return emptyBuffer currentDecoder == null");
      }
      paramCMTime = new CMSampleBuffer(localCMTime1, outputBuffer());
      return paramCMTime;
    }
    label645:
    label656:
    for (;;)
    {
      if (paramCMTime.equalsTo(IDecoder.SAMPLE_TIME_FINISH))
      {
        localObject1 = ((DecoderTrackSegment)localObject1).getScaledDuration().add(this.currentSegmentStartTime);
        localCMTime1 = localCMTime2.add(this.frameDuration);
        if (((CMTime)localObject1).bigThan(localCMTime1))
        {
          if (this.currentDecoder == null) {}
          for (paramCMTime = getEmptyAudioBuffer();; paramCMTime = this.currentDecoder.outputBuffer())
          {
            if (Logger.LOG_VERBOSE) {
              Logger.i(TAG, "doReadSample: finish && !end", new Object[0]);
            }
            localObject1 = paramCMTime;
            if (paramCMTime == null) {
              localObject1 = getEmptyAudioBuffer();
            }
            paramCMTime = new CMSampleBuffer(localCMTime1, (ByteBuffer)localObject1);
            return paramCMTime;
            if (localCMTime2.sub(this.currentSegmentStartTime).multi(this._speed).bigThan(((DecoderTrackSegment)localObject1).getScaledDuration().multi(this._speed)))
            {
              paramCMTime = IDecoder.SAMPLE_TIME_FINISH;
              break;
            }
            paramCMTime = this.currentDecoder.readSample(CMTime.CMTimeInvalid);
            break;
          }
        }
        if (!nextSegment(true))
        {
          if (Logger.LOG_VERBOSE) {
            Logger.i(TAG, "doReadSample: finish && end && next failed", new Object[0]);
          }
          localObject1 = AudioDecoder.SAMPLE_TIME_FINISH;
          if (this.currentDecoder == null) {}
          for (paramCMTime = localObject3;; paramCMTime = this.currentDecoder.outputBuffer())
          {
            paramCMTime = new CMSampleBuffer((CMTime)localObject1, paramCMTime);
            return paramCMTime;
          }
        }
        localObject1 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
        break;
      }
      if (paramCMTime.getTimeUs() >= 0L)
      {
        localCMTime1 = paramCMTime.sub(((DecoderTrackSegment)localObject1).getDecoderStartTime()).divide(this._speed);
        paramCMTime = localCMTime1;
        if (localCMTime1.getTimeUs() > ((DecoderTrackSegment)localObject1).getScaledDuration().getTimeUs()) {
          paramCMTime = ((DecoderTrackSegment)localObject1).getScaledDuration();
        }
        localObject1 = paramCMTime.add(this.currentSegmentStartTime);
        if (Logger.LOG_VERBOSE) {
          Logger.i(TAG, "doReadSample: [success] " + localObject1, new Object[0]);
        }
        if (this.currentDecoder != null) {
          break label645;
        }
      }
      for (paramCMTime = localObject2;; paramCMTime = this.currentDecoder.outputBuffer())
      {
        paramCMTime = new CMSampleBuffer((CMTime)localObject1, paramCMTime);
        return paramCMTime;
        if ((paramCMTime.getValue() != AudioDecoder.SAMPLE_TIME_ERROR.getValue()) && (paramCMTime.getValue() != AudioDecoder.SAMPLE_TIME_UNSTART.getValue()))
        {
          paramCMTime = new CMSampleBuffer(localCMTime2);
          return paramCMTime;
        }
        paramCMTime = new CMSampleBuffer(paramCMTime);
        return paramCMTime;
      }
    }
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
    this.lastSampleTime = this.currentSegmentStartTime;
    if (this.lastSampleTime.equalsTo(CMTime.CMTimeZero)) {
      this.lastSampleTime = CMTime.CMTimeInvalid;
    }
    Object localObject2 = (DecoderTrackSegment)this.segments.get(this.segmentIndex);
    IDecoder localIDecoder;
    if (((DecoderTrackSegment)localObject2).getVideoAsset() != null) {
      synchronized (this.currentDecoderLock)
      {
        if ((this.currentDecoder != null) && (this.currentDecoder.getSourcePath() != null))
        {
          new AudioDecoderTrack.ReleaseDecoderThread(this.currentDecoder).start();
          this.currentDecoder = null;
        }
        if (paramBoolean)
        {
          ??? = ((DecoderTrackSegment)this.segments.get(this.segmentIndex)).getDecoderStartTime();
          localIDecoder = createDecoder((DecoderTrackSegment)localObject2, (CMTime)???);
        }
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
          break label427;
        }
        paramBoolean = true;
        Logger.d((String)???, paramBoolean + " " + this._speed);
        return true;
        localObject3 = finally;
        throw localObject3;
        ??? = CMTime.CMTimeInvalid;
      }
      Logger.e(TAG, "nextSegment: videoAsset is null");
      synchronized (this.currentDecoderLock)
      {
        if (this.currentDecoder != null)
        {
          new AudioDecoderTrack.ReleaseDecoderThread(this.currentDecoder).start();
          this.currentDecoder = null;
        }
      }
      label427:
      paramBoolean = false;
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
  
  public void clearTimeRanges()
  {
    release();
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
    return this.lastSampleTime;
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
    if (Logger.LOG_VERBOSE) {
      Logger.d(TAG, "readSample: [start]" + paramCMTime);
    }
    if (this.isReleased)
    {
      Logger.e(TAG, "readSample: [error] has released");
      paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
    }
    do
    {
      return paramCMTime;
      synchronized (AudioDecoderTrack.DecoderThread.access$100(this.decoderThread))
      {
        if ((AudioDecoderTrack.DecoderThread.access$200(this.decoderThread) != null) && (AudioDecoderTrack.CacheBuffer.access$300(AudioDecoderTrack.DecoderThread.access$200(this.decoderThread)) == this.lastSampleTime))
        {
          paramCMTime = AudioDecoderTrack.CacheBuffer.access$400(AudioDecoderTrack.DecoderThread.access$200(this.decoderThread));
          this.lastSampleTime = AudioDecoderTrack.CacheBuffer.access$300(AudioDecoderTrack.DecoderThread.access$200(this.decoderThread));
          createNextDecoder(this.segmentIndex);
          if (Logger.LOG_VERBOSE) {
            Logger.d(TAG, "readSample: [success] hit asyncRead - " + this.lastSampleTime);
          }
          return paramCMTime;
        }
      }
      ??? = doReadSample(paramCMTime);
      if ((((CMSampleBuffer)???).getSampleByteBuffer() != null) && (this._speed > 0.1F) && (this._speed < 16.0F))
      {
        if (Logger.LOG_VERBOSE) {
          Logger.i(TAG, "readSample: processFrame [volume " + this.volume + "] [_speed " + this._speed + "]", new Object[0]);
        }
        ((CMSampleBuffer)???).setSampleByteBuffer(processFrame(((CMSampleBuffer)???).getSampleByteBuffer(), this.volume, this._speed, getAudioInfo()));
        if (Logger.LOG_VERBOSE) {
          Logger.i(TAG, "readSample: processFrame finish [volume " + this.volume + "] [_speed " + this._speed + "]", new Object[0]);
        }
      }
      this.lastSampleTime = ((CMSampleBuffer)???).getTime();
      createNextDecoder(this.segmentIndex);
      paramCMTime = (CMTime)???;
    } while (!Logger.LOG_VERBOSE);
    Logger.d(TAG, "readSample: [success]  - " + this.lastSampleTime);
    return ???;
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 53	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   5: ldc_w 618
    //   8: invokestatic 337	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 114	com/tencent/tav/decoder/AudioDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderThread;
    //   15: invokevirtual 619	com/tencent/tav/decoder/AudioDecoderTrack$DecoderThread:release	()V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 107	com/tencent/tav/decoder/AudioDecoderTrack:isReleased	Z
    //   23: aload_0
    //   24: getfield 149	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   27: ifnull +15 -> 42
    //   30: aload_0
    //   31: getfield 149	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   34: invokevirtual 620	com/tencent/tav/decoder/AudioDecoder:release	()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 149	com/tencent/tav/decoder/AudioDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/AudioDecoder;
    //   42: aload_0
    //   43: getfield 103	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   46: astore_1
    //   47: aload_1
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   53: ifnull +15 -> 68
    //   56: aload_0
    //   57: getfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   60: invokestatic 624	com/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper:access$600	(Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;)V
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 138	com/tencent/tav/decoder/AudioDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/AudioDecoderTrack$DecoderWrapper;
    //   68: aload_1
    //   69: monitorexit
    //   70: getstatic 53	com/tencent/tav/decoder/AudioDecoderTrack:TAG	Ljava/lang/String;
    //   73: ldc_w 626
    //   76: invokestatic 337	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public CMTime sampleTime()
  {
    return this.lastSampleTime;
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Logger.LOG_VERBOSE) {
      Logger.d(TAG, "seekTo:[timeUs " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    }
    if (this.isReleased)
    {
      Logger.e(TAG, "seekTo: [failed] has released");
      return new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
    }
    synchronized (AudioDecoderTrack.DecoderThread.access$100(this.decoderThread))
    {
      AudioDecoderTrack.DecoderThread.access$202(this.decoderThread, null);
      if (!this.started)
      {
        Logger.e(TAG, "seekTo: [failed] un started");
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
      this.lastSampleTime = paramCMTime;
      Logger.e(TAG, "seekTo: [failed] currentDecoder == null ");
      return null;
    }
    this.currentDecoder.seekTo(localDecoderTrackSegment.getDecoderStartTime().add((CMTime)???));
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleTime = paramCMTime.sub(this.frameDuration);; this.lastSampleTime = paramCMTime)
    {
      if (Logger.LOG_VERBOSE) {
        Logger.d(TAG, "seekTo: [success] [lastSampleTime " + this.lastSampleTime + "]");
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack
 * JD-Core Version:    0.7.0.1
 */