package com.tencent.tav.decoder.decodecache;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.ITexturePool;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CachedVideoDecoderTrack
  implements IDecoderTrack
{
  private static final String TAG = "CachedVideoTrack";
  private CacheSegment currentFrameSegment;
  private CMSampleState lastSampleState = new CMSampleState();
  final Object nextFrameDecoderLock = new Object();
  private CacheSegment nextFrameSegment;
  RenderContext renderContext;
  boolean revert;
  private SegmentDecoderThread segmentDecoder;
  private int segmentSize = 60;
  CMTimeRange validTimeRange;
  
  public CachedVideoDecoderTrack(IDecoderTrack paramIDecoderTrack, boolean paramBoolean)
  {
    this.revert = paramBoolean;
    this.segmentDecoder = new SegmentDecoderThread(this, paramIDecoderTrack);
  }
  
  private void clearCurrentFrameSegment()
  {
    CacheSegment localCacheSegment = this.currentFrameSegment;
    if (localCacheSegment != null)
    {
      localCacheSegment.clear();
      this.currentFrameSegment = null;
    }
  }
  
  private CMSampleBuffer decoderFrame(CMTime paramCMTime)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.segmentDecoder.decoderSegment(paramCMTime, localCountDownLatch);
    try
    {
      localCountDownLatch.await(5L, TimeUnit.SECONDS);
    }
    catch (InterruptedException paramCMTime)
    {
      paramCMTime.printStackTrace();
    }
    return this.segmentDecoder.seekSampleBuffer;
  }
  
  /* Error */
  private CMSampleBuffer decoderSegment(CMTime paramCMTime)
  {
    // Byte code:
    //   0: new 93	com/tencent/tav/decoder/decodecache/RequestStatus
    //   3: dup
    //   4: invokespecial 94	com/tencent/tav/decoder/decodecache/RequestStatus:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   13: astore 4
    //   15: iconst_0
    //   16: istore_3
    //   17: aload 4
    //   19: ifnull +421 -> 440
    //   22: aload 4
    //   24: getfield 99	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   27: ifnull +413 -> 440
    //   30: aload_0
    //   31: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   34: getfield 99	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   37: aload_1
    //   38: invokevirtual 105	com/tencent/tav/coremedia/CMTimeRange:containsTime	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   41: ifeq +399 -> 440
    //   44: aload_0
    //   45: getfield 36	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameDecoderLock	Ljava/lang/Object;
    //   48: astore 4
    //   50: aload 4
    //   52: monitorenter
    //   53: aload_0
    //   54: invokespecial 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:clearCurrentFrameSegment	()V
    //   57: aload_0
    //   58: new 56	com/tencent/tav/decoder/decodecache/CacheSegment
    //   61: dup
    //   62: aload_0
    //   63: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   66: getfield 99	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   69: invokespecial 110	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   72: putfield 54	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   75: aload_0
    //   76: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   79: getfield 114	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   82: invokeinterface 120 1 0
    //   87: astore 6
    //   89: aload 6
    //   91: invokeinterface 126 1 0
    //   96: ifeq +27 -> 123
    //   99: aload 6
    //   101: invokeinterface 130 1 0
    //   106: checkcast 132	com/tencent/tav/decoder/decodecache/CacheFrame
    //   109: astore 7
    //   111: aload_0
    //   112: getfield 54	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   115: aload 7
    //   117: invokevirtual 136	com/tencent/tav/decoder/decodecache/CacheSegment:pushFrame	(Lcom/tencent/tav/decoder/decodecache/CacheFrame;)V
    //   120: goto -31 -> 89
    //   123: aload_0
    //   124: getfield 54	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   127: aload_1
    //   128: invokevirtual 140	com/tencent/tav/decoder/decodecache/CacheSegment:popFrame	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/decoder/decodecache/CacheFrame;
    //   131: astore 6
    //   133: aload 6
    //   135: ifnull +214 -> 349
    //   138: new 142	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   145: astore 5
    //   147: aload 5
    //   149: ldc 145
    //   151: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: iload_3
    //   156: istore_2
    //   157: aload 6
    //   159: getfield 152	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   162: ifnull +18 -> 180
    //   165: iload_3
    //   166: istore_2
    //   167: aload 6
    //   169: getfield 152	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   172: invokevirtual 158	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   175: ifnull +5 -> 180
    //   178: iconst_1
    //   179: istore_2
    //   180: aload 5
    //   182: iload_2
    //   183: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 5
    //   189: ldc 163
    //   191: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 6
    //   197: getfield 152	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   200: ifnull +657 -> 857
    //   203: aload 6
    //   205: getfield 152	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   208: invokevirtual 166	com/tencent/tav/coremedia/CMSampleBuffer:isNewFrame	()Z
    //   211: invokestatic 172	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   214: astore_1
    //   215: goto +3 -> 218
    //   218: aload 5
    //   220: aload_1
    //   221: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 5
    //   227: ldc 177
    //   229: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 5
    //   235: aload 6
    //   237: getfield 181	com/tencent/tav/decoder/decodecache/CacheFrame:realFrameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   240: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 5
    //   246: ldc 163
    //   248: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 5
    //   254: aload 6
    //   256: getfield 184	com/tencent/tav/decoder/decodecache/CacheFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   259: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 10
    //   265: aload 5
    //   267: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 194	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload_0
    //   274: new 56	com/tencent/tav/decoder/decodecache/CacheSegment
    //   277: dup
    //   278: new 101	com/tencent/tav/coremedia/CMTimeRange
    //   281: dup
    //   282: aload_0
    //   283: getfield 54	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   286: invokevirtual 198	com/tencent/tav/decoder/decodecache/CacheSegment:getLastFrameTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   289: aload_0
    //   290: invokevirtual 201	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:getFrameDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   293: aload_0
    //   294: getfield 34	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentSize	I
    //   297: i2f
    //   298: invokevirtual 207	com/tencent/tav/coremedia/CMTime:multi	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   301: invokespecial 210	com/tencent/tav/coremedia/CMTimeRange:<init>	(Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V
    //   304: invokespecial 110	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   307: putfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   310: aload_0
    //   311: getfield 50	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   314: aload_0
    //   315: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   318: aconst_null
    //   319: invokevirtual 213	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:decoderSegment	(Lcom/tencent/tav/decoder/decodecache/CacheSegment;Lcom/tencent/tav/decoder/decodecache/RequestStatus;)V
    //   322: aload_0
    //   323: new 38	com/tencent/tav/coremedia/CMSampleState
    //   326: dup
    //   327: aload 6
    //   329: getfield 184	com/tencent/tav/decoder/decodecache/CacheFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   332: invokespecial 216	com/tencent/tav/coremedia/CMSampleState:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   335: putfield 41	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:lastSampleState	Lcom/tencent/tav/coremedia/CMSampleState;
    //   338: aload 6
    //   340: getfield 152	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   343: astore_1
    //   344: aload 4
    //   346: monitorexit
    //   347: aload_1
    //   348: areturn
    //   349: new 142	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   356: astore 6
    //   358: aload 6
    //   360: ldc 218
    //   362: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 6
    //   368: aload_0
    //   369: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   372: getfield 114	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   375: invokeinterface 222 1 0
    //   380: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 6
    //   386: ldc 163
    //   388: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 6
    //   394: aload_0
    //   395: getfield 54	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   398: getfield 114	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   401: invokeinterface 222 1 0
    //   406: invokevirtual 225	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: ldc 10
    //   412: aload 6
    //   414: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 228	com/tencent/tav/decoder/logger/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: aload 4
    //   422: monitorexit
    //   423: aload_0
    //   424: getfield 50	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   427: iconst_1
    //   428: putfield 231	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:cancel	Z
    //   431: goto +84 -> 515
    //   434: astore_1
    //   435: aload 4
    //   437: monitorexit
    //   438: aload_1
    //   439: athrow
    //   440: new 142	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   447: astore 6
    //   449: aload 6
    //   451: ldc 233
    //   453: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload_0
    //   458: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   461: astore 4
    //   463: aload 4
    //   465: ifnonnull +10 -> 475
    //   468: ldc 235
    //   470: astore 4
    //   472: goto +10 -> 482
    //   475: aload 4
    //   477: getfield 99	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   480: astore 4
    //   482: aload 6
    //   484: aload 4
    //   486: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 6
    //   492: ldc 163
    //   494: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 6
    //   500: aload_1
    //   501: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: ldc 10
    //   507: aload 6
    //   509: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 228	com/tencent/tav/decoder/logger/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload_0
    //   516: getfield 36	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameDecoderLock	Ljava/lang/Object;
    //   519: astore 4
    //   521: aload 4
    //   523: monitorenter
    //   524: aload_0
    //   525: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   528: ifnull +10 -> 538
    //   531: aload_0
    //   532: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   535: invokevirtual 59	com/tencent/tav/decoder/decodecache/CacheSegment:clear	()V
    //   538: aload_0
    //   539: new 56	com/tencent/tav/decoder/decodecache/CacheSegment
    //   542: dup
    //   543: new 101	com/tencent/tav/coremedia/CMTimeRange
    //   546: dup
    //   547: aload_1
    //   548: aload_0
    //   549: invokevirtual 201	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:getFrameDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   552: aload_0
    //   553: getfield 34	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentSize	I
    //   556: i2f
    //   557: invokevirtual 207	com/tencent/tav/coremedia/CMTime:multi	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   560: invokespecial 210	com/tencent/tav/coremedia/CMTimeRange:<init>	(Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V
    //   563: invokespecial 110	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   566: putfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   569: aload_0
    //   570: getfield 50	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   573: aload_0
    //   574: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   577: aload 5
    //   579: invokevirtual 213	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:decoderSegment	(Lcom/tencent/tav/decoder/decodecache/CacheSegment;Lcom/tencent/tav/decoder/decodecache/RequestStatus;)V
    //   582: aload 4
    //   584: monitorexit
    //   585: aload 5
    //   587: monitorenter
    //   588: aload 5
    //   590: invokevirtual 238	com/tencent/tav/decoder/decodecache/RequestStatus:getFinish	()Z
    //   593: ifne +23 -> 616
    //   596: aload 5
    //   598: ldc2_w 239
    //   601: invokevirtual 244	java/lang/Object:wait	(J)V
    //   604: goto +12 -> 616
    //   607: astore_1
    //   608: goto +232 -> 840
    //   611: astore_1
    //   612: aload_1
    //   613: invokevirtual 87	java/lang/InterruptedException:printStackTrace	()V
    //   616: aload 5
    //   618: monitorexit
    //   619: aload_0
    //   620: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   623: getfield 114	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   626: invokeinterface 222 1 0
    //   631: ifne +17 -> 648
    //   634: new 154	com/tencent/tav/coremedia/CMSampleBuffer
    //   637: dup
    //   638: ldc2_w 245
    //   641: invokestatic 250	com/tencent/tav/coremedia/CMSampleState:fromError	(J)Lcom/tencent/tav/coremedia/CMSampleState;
    //   644: invokespecial 253	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMSampleState;)V
    //   647: areturn
    //   648: aload_0
    //   649: invokespecial 107	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:clearCurrentFrameSegment	()V
    //   652: aload_0
    //   653: new 56	com/tencent/tav/decoder/decodecache/CacheSegment
    //   656: dup
    //   657: aload_0
    //   658: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   661: getfield 99	com/tencent/tav/decoder/decodecache/CacheSegment:segmentTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   664: invokespecial 110	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   667: putfield 54	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   670: aload_0
    //   671: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   674: getfield 114	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   677: invokeinterface 120 1 0
    //   682: astore_1
    //   683: aload_1
    //   684: invokeinterface 126 1 0
    //   689: ifeq +26 -> 715
    //   692: aload_1
    //   693: invokeinterface 130 1 0
    //   698: checkcast 132	com/tencent/tav/decoder/decodecache/CacheFrame
    //   701: astore 4
    //   703: aload_0
    //   704: getfield 54	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   707: aload 4
    //   709: invokevirtual 136	com/tencent/tav/decoder/decodecache/CacheSegment:pushFrame	(Lcom/tencent/tav/decoder/decodecache/CacheFrame;)V
    //   712: goto -29 -> 683
    //   715: aload_0
    //   716: getfield 36	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameDecoderLock	Ljava/lang/Object;
    //   719: astore_1
    //   720: aload_1
    //   721: monitorenter
    //   722: aload_0
    //   723: new 56	com/tencent/tav/decoder/decodecache/CacheSegment
    //   726: dup
    //   727: new 101	com/tencent/tav/coremedia/CMTimeRange
    //   730: dup
    //   731: aload_0
    //   732: getfield 54	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   735: invokevirtual 198	com/tencent/tav/decoder/decodecache/CacheSegment:getLastFrameTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   738: aload_0
    //   739: invokevirtual 201	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:getFrameDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   742: aload_0
    //   743: getfield 34	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentSize	I
    //   746: i2f
    //   747: invokevirtual 207	com/tencent/tav/coremedia/CMTime:multi	(F)Lcom/tencent/tav/coremedia/CMTime;
    //   750: invokespecial 210	com/tencent/tav/coremedia/CMTimeRange:<init>	(Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V
    //   753: invokespecial 110	com/tencent/tav/decoder/decodecache/CacheSegment:<init>	(Lcom/tencent/tav/coremedia/CMTimeRange;)V
    //   756: putfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   759: aload_0
    //   760: getfield 50	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:segmentDecoder	Lcom/tencent/tav/decoder/decodecache/SegmentDecoderThread;
    //   763: aload_0
    //   764: getfield 96	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:nextFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   767: aconst_null
    //   768: invokevirtual 213	com/tencent/tav/decoder/decodecache/SegmentDecoderThread:decoderSegment	(Lcom/tencent/tav/decoder/decodecache/CacheSegment;Lcom/tencent/tav/decoder/decodecache/RequestStatus;)V
    //   771: aload_1
    //   772: monitorexit
    //   773: aload_0
    //   774: getfield 54	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   777: astore_1
    //   778: aload_1
    //   779: ifnull +52 -> 831
    //   782: aload_1
    //   783: getfield 114	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   786: invokeinterface 222 1 0
    //   791: ifle +40 -> 831
    //   794: aload_0
    //   795: getfield 54	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:currentFrameSegment	Lcom/tencent/tav/decoder/decodecache/CacheSegment;
    //   798: getfield 114	com/tencent/tav/decoder/decodecache/CacheSegment:cacheFrameList	Ljava/util/List;
    //   801: iconst_0
    //   802: invokeinterface 257 2 0
    //   807: checkcast 132	com/tencent/tav/decoder/decodecache/CacheFrame
    //   810: astore_1
    //   811: aload_0
    //   812: new 38	com/tencent/tav/coremedia/CMSampleState
    //   815: dup
    //   816: aload_1
    //   817: getfield 184	com/tencent/tav/decoder/decodecache/CacheFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   820: invokespecial 216	com/tencent/tav/coremedia/CMSampleState:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   823: putfield 41	com/tencent/tav/decoder/decodecache/CachedVideoDecoderTrack:lastSampleState	Lcom/tencent/tav/coremedia/CMSampleState;
    //   826: aload_1
    //   827: getfield 152	com/tencent/tav/decoder/decodecache/CacheFrame:sampleBuffer	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   830: areturn
    //   831: aconst_null
    //   832: areturn
    //   833: astore 4
    //   835: aload_1
    //   836: monitorexit
    //   837: aload 4
    //   839: athrow
    //   840: aload 5
    //   842: monitorexit
    //   843: aload_1
    //   844: athrow
    //   845: astore_1
    //   846: aload 4
    //   848: monitorexit
    //   849: goto +5 -> 854
    //   852: aload_1
    //   853: athrow
    //   854: goto -2 -> 852
    //   857: ldc_w 259
    //   860: astore_1
    //   861: goto -643 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	864	0	this	CachedVideoDecoderTrack
    //   0	864	1	paramCMTime	CMTime
    //   156	27	2	bool1	boolean
    //   16	150	3	bool2	boolean
    //   13	695	4	localObject1	Object
    //   833	14	4	localObject2	Object
    //   7	834	5	localObject3	Object
    //   87	421	6	localObject4	Object
    //   109	7	7	localCacheFrame	CacheFrame
    // Exception table:
    //   from	to	target	type
    //   53	89	434	finally
    //   89	120	434	finally
    //   123	133	434	finally
    //   138	155	434	finally
    //   157	165	434	finally
    //   167	178	434	finally
    //   180	215	434	finally
    //   218	347	434	finally
    //   349	423	434	finally
    //   435	438	434	finally
    //   588	604	607	finally
    //   612	616	607	finally
    //   616	619	607	finally
    //   840	843	607	finally
    //   588	604	611	java/lang/InterruptedException
    //   722	773	833	finally
    //   835	837	833	finally
    //   524	538	845	finally
    //   538	585	845	finally
    //   846	849	845	finally
  }
  
  public void asyncReadNextSample(CMTime paramCMTime) {}
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    this.segmentDecoder.decoderTrack.clipRangeAndClearRange(paramCMTimeRange);
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleState.getTime();
  }
  
  public CMTime getDuration()
  {
    return this.segmentDecoder.decoderTrack.getDuration();
  }
  
  public CMTime getFrameDuration()
  {
    return this.segmentDecoder.decoderTrack.getFrameDuration();
  }
  
  public int getFrameRate()
  {
    return this.segmentDecoder.decoderTrack.getFrameRate();
  }
  
  public int getTrackId()
  {
    return this.segmentDecoder.decoderTrack.getTrackId();
  }
  
  public CMSampleBuffer readSample()
  {
    if (this.lastSampleState.isInvalid()) {
      return readSample(CMTime.CMTimeZero);
    }
    if (this.lastSampleState.getTime().smallThan(CMTime.CMTimeZero)) {
      return new CMSampleBuffer(this.lastSampleState);
    }
    return readSample(this.lastSampleState.getTime().add(getFrameDuration()));
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    if (paramCMTime.smallThan(CMTime.CMTimeZero)) {
      return readSample();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("readSample: targetTime = ");
    ((StringBuilder)localObject).append(paramCMTime);
    Logger.v("CachedVideoTrack", ((StringBuilder)localObject).toString());
    localObject = this.currentFrameSegment;
    if (localObject != null)
    {
      localObject = ((CacheSegment)localObject).popFrame(paramCMTime);
      if (localObject != null)
      {
        this.lastSampleState = new CMSampleState(((CacheFrame)localObject).frameTime);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readSample: hint currentSegment ");
        boolean bool;
        if ((((CacheFrame)localObject).sampleBuffer != null) && (((CacheFrame)localObject).sampleBuffer.getTextureInfo() != null)) {
          bool = true;
        } else {
          bool = false;
        }
        localStringBuilder.append(bool);
        localStringBuilder.append("  ");
        if (((CacheFrame)localObject).sampleBuffer != null) {
          paramCMTime = Boolean.valueOf(((CacheFrame)localObject).sampleBuffer.isNewFrame());
        } else {
          paramCMTime = "null";
        }
        localStringBuilder.append(paramCMTime);
        localStringBuilder.append(" time = ");
        localStringBuilder.append(((CacheFrame)localObject).realFrameTime);
        localStringBuilder.append("  ");
        localStringBuilder.append(((CacheFrame)localObject).frameTime);
        Logger.v("CachedVideoTrack", localStringBuilder.toString());
        return ((CacheFrame)localObject).sampleBuffer;
      }
    }
    if (!paramCMTime.smallThan(getDuration()))
    {
      this.lastSampleState = CMSampleState.fromError(-1L);
      return new CMSampleBuffer(CMSampleState.fromError(-1L));
    }
    localObject = decoderSegment(paramCMTime);
    if (localObject != null)
    {
      paramCMTime = new StringBuilder();
      paramCMTime.append("readSample: hint currentSegment - ");
      paramCMTime.append(((CMSampleBuffer)localObject).getTime());
      Logger.v("CachedVideoTrack", paramCMTime.toString());
      return localObject;
    }
    if (paramCMTime.bigThan(getDuration()))
    {
      this.lastSampleState = CMSampleState.fromError(-1L);
      return new CMSampleBuffer(CMSampleState.fromError(-1L));
    }
    this.lastSampleState = CMSampleState.fromError(-3L);
    return new CMSampleBuffer(CMSampleState.fromError(-3L));
  }
  
  public void release()
  {
    ??? = this.currentFrameSegment;
    if (??? != null) {
      ((CacheSegment)???).clear();
    }
    ??? = this.nextFrameSegment;
    if (??? != null) {
      ((CacheSegment)???).clear();
    }
    synchronized (this.nextFrameDecoderLock)
    {
      if (this.segmentDecoder != null)
      {
        this.segmentDecoder.release();
        this.segmentDecoder = null;
      }
      return;
    }
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seekTo: PlayerThreadMain ");
    ((StringBuilder)localObject).append(paramCMTime);
    Logger.v("CachedVideoTrack", ((StringBuilder)localObject).toString());
    if (paramCMTime.bigThan(getFrameDuration())) {
      this.lastSampleState = new CMSampleState(paramCMTime.sub(getFrameDuration()));
    } else {
      this.lastSampleState = new CMSampleState(paramCMTime);
    }
    localObject = this.currentFrameSegment;
    if (localObject != null)
    {
      ((CacheSegment)localObject).clear();
      this.currentFrameSegment = null;
    }
    localObject = this.nextFrameSegment;
    if (localObject != null)
    {
      ((CacheSegment)localObject).clear();
      this.nextFrameSegment = null;
    }
    if (paramBoolean1)
    {
      long l = paramCMTime.getTimeUs() / getFrameDuration().getTimeUs();
      int i;
      if (paramCMTime.getTimeUs() % getFrameDuration().getTimeUs() > 0L) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = decoderFrame(new CMTime((float)((l + i) * getFrameDuration().getTimeUs()) / 1000000.0F));
      if (localObject == null) {
        paramCMTime = CMSampleState.fromError(-1L);
      } else {
        paramCMTime = ((CMSampleBuffer)localObject).getState();
      }
      this.lastSampleState = paramCMTime;
      return localObject;
    }
    return null;
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.segmentDecoder.decoderTrack.setDecodeType(paramDecodeType);
  }
  
  public void setFrameRate(int paramInt)
  {
    this.segmentDecoder.decoderTrack.setFrameRate(paramInt);
  }
  
  public void setMaxFrameCacheSize(int paramInt)
  {
    if (paramInt > 0)
    {
      this.segmentSize = paramInt;
      SegmentDecoderThread localSegmentDecoderThread = this.segmentDecoder;
      if (localSegmentDecoderThread != null) {
        localSegmentDecoderThread.texturePool.setMaxCacheLength(paramInt);
      }
    }
  }
  
  public void setRevert(boolean paramBoolean)
  {
    this.revert = paramBoolean;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    this.segmentDecoder.decoderTrack.setTrackSegments(paramList);
  }
  
  public void setVolume(float paramFloat)
  {
    this.segmentDecoder.decoderTrack.setVolume(paramFloat);
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
    this.validTimeRange = paramCMTimeRange;
    this.renderContext = ((RenderContext)paramSurfaceCreator);
    this.segmentDecoder.startForReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack
 * JD-Core Version:    0.7.0.1
 */