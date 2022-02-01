package com.tencent.tav.decoder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.ExtractorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class VideoDecoderTrack
  implements IDecoderTrack
{
  public static boolean PRE_READ = true;
  private static String TAG = "VDecoderTrack";
  private Surface _outputSurface;
  private float _speed = 1.0F;
  @Nullable
  private IVideoDecoder currentDecoder;
  private final Object currentDecoderLock = new Object();
  private CMSampleBuffer currentFrame = null;
  private CMTime currentSegmentStartTime = CMTime.CMTimeZero;
  private IDecoder.DecodeType decodeType = IDecoder.DecodeType.Video;
  private VideoDecoderTrack.DecoderCreateThread decoderCreateThread = null;
  private final VideoDecoderTrack.DecoderThread decoderThread = new VideoDecoderTrack.DecoderThread(this, null);
  private CMTime duration = CMTime.CMTimeZero;
  private CMTime frameDuration = new CMTime(1L, 44);
  private int frameRate = 44;
  private boolean isReleased = false;
  private CMSampleState lastSampleState = new CMSampleState();
  private VideoDecoderTrack.DecoderWrapper nextDecoder;
  private final Object nextDecoderLock = new Object();
  private CMSampleBuffer nextFrame = null;
  private final Object nextFrameDecoderLock = new Object();
  private int segmentIndex = -1;
  private ArrayList<DecoderTrackSegment> segments = new ArrayList();
  private boolean started = false;
  private IDecoderTrack.SurfaceCreator surfaceCreator = null;
  private int trackId;
  
  public VideoDecoderTrack(AssetTrack paramAssetTrack)
  {
    this.trackId = paramAssetTrack.getTrackID();
    Object localObject = paramAssetTrack.getSegments();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new DecoderTrackSegment(paramAssetTrack, (AssetTrackSegment)((Iterator)localObject).next()));
    }
    setTrackSegments(localArrayList);
    if (getFrameRate() > 0) {}
    for (int i = getFrameRate();; i = (int)paramAssetTrack.getNominalFrameRate())
    {
      setFrameRate(i);
      setVolume(paramAssetTrack.getPreferredVolume());
      setDecodeType(IDecoder.DecodeType.Video);
      if (paramAssetTrack.getTimeRange() != null) {
        clipRangeAndClearRange(paramAssetTrack.getTimeRange().clone());
      }
      return;
    }
  }
  
  private void clipRangeAndRemoveRange(CMTimeRange paramCMTimeRange)
  {
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDurationUs() <= 0L) || (this.segments.size() == 0)) {}
    CMTime localCMTime2;
    CMTime localCMTime1;
    int i;
    DecoderTrackSegment localDecoderTrackSegment2;
    do
    {
      int k;
      do
      {
        return;
        localCMTime2 = paramCMTimeRange.getStart();
        localCMTime1 = paramCMTimeRange.getEnd();
        k = findSegmentIndexAt(localCMTime2, false);
      } while (k == -1);
      int j = findSegmentIndexAt(localCMTime1, false);
      if (j == -1) {
        i = this.segments.size() - 1;
      }
      for (;;)
      {
        CMTime localCMTime3 = getSegmentStartTime(k);
        localCMTime2 = getSegmentStartTime(i);
        DecoderTrackSegment localDecoderTrackSegment1 = getSegment(k);
        localDecoderTrackSegment2 = getSegment(i);
        CMTime localCMTime4;
        float f;
        if ((localDecoderTrackSegment2.getTimeRange().getDurationUs() > 0L) && (!getSegmentStartTime(i + 1).smallThan(paramCMTimeRange.getEnd())))
        {
          localCMTime4 = paramCMTimeRange.getEnd().sub(localCMTime2);
          f = (float)localDecoderTrackSegment2.getScaledDuration().getTimeUs() * 1.0F / (float)localDecoderTrackSegment2.getTimeRange().getDurationUs();
          localDecoderTrackSegment2.setTimeRange(new CMTimeRange(localDecoderTrackSegment2.getTimeRange().getStart(), localCMTime4.divide(f)));
          localDecoderTrackSegment2.setScaledDuration(localCMTime4);
        }
        if (localDecoderTrackSegment1.getTimeRange().getDurationUs() > 0L)
        {
          f = (float)localDecoderTrackSegment1.getScaledDuration().getTimeUs() * 1.0F / (float)localDecoderTrackSegment1.getTimeRange().getDurationUs();
          localCMTime3 = paramCMTimeRange.getStart().sub(localCMTime3);
          localCMTime4 = localCMTime3.divide(f);
          localDecoderTrackSegment1.setTimeRange(new CMTimeRange(localDecoderTrackSegment1.getTimeRange().getStart().add(localCMTime4), localDecoderTrackSegment1.getTimeRange().getDuration().sub(localCMTime4)));
          localDecoderTrackSegment1.setScaledDuration(localDecoderTrackSegment1.getScaledDuration().sub(localCMTime3));
        }
        j = this.segments.size() - 1;
        while (j >= 0)
        {
          if ((j > i) || (j < k)) {
            this.segments.remove(j);
          }
          j -= 1;
        }
        i = j;
        if (getSegmentStartTime(j) == localCMTime1) {
          i = j - 1;
        }
      }
    } while (!getSegmentStartTime(i + 1).smallThan(paramCMTimeRange.getEnd()));
    paramCMTimeRange = new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1.sub(localDecoderTrackSegment2.getScaledDuration().add(localCMTime2))), null);
    this.segments.add(paramCMTimeRange);
  }
  
  /* Error */
  private IVideoDecoder createDecoder(@NonNull DecoderTrackSegment paramDecoderTrackSegment, CMTime paramCMTime)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokevirtual 339	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   12: astore 11
    //   14: aload 11
    //   16: ifnonnull +10 -> 26
    //   19: aload 7
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: getstatic 55	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   29: astore 7
    //   31: new 341	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 344
    //   41: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload 11
    //   46: getfield 353	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   49: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 355
    //   55: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: astore 8
    //   60: aload_0
    //   61: getfield 120	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   64: ifnull +271 -> 335
    //   67: iconst_1
    //   68: istore 5
    //   70: aload 7
    //   72: aload 8
    //   74: iload 5
    //   76: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   79: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 367	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: iconst_5
    //   86: istore_3
    //   87: aconst_null
    //   88: astore 7
    //   90: aload 7
    //   92: ifnonnull +695 -> 787
    //   95: iload_3
    //   96: ifle +691 -> 787
    //   99: aload_0
    //   100: getfield 97	com/tencent/tav/decoder/VideoDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;
    //   103: ifnull +390 -> 493
    //   106: aload_0
    //   107: getfield 97	com/tencent/tav/decoder/VideoDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;
    //   110: invokestatic 373	com/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread:access$100	(Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;)I
    //   113: istore 4
    //   115: iload 4
    //   117: aload_0
    //   118: getfield 76	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   121: invokevirtual 273	java/util/ArrayList:size	()I
    //   124: if_icmpge +226 -> 350
    //   127: aload_0
    //   128: iload 4
    //   130: invokespecial 226	com/tencent/tav/decoder/VideoDecoderTrack:getSegment	(I)Lcom/tencent/tav/decoder/DecoderTrackSegment;
    //   133: invokevirtual 339	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   136: aload 11
    //   138: invokestatic 379	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   141: ifeq +209 -> 350
    //   144: getstatic 55	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   147: new 341	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 381
    //   157: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 11
    //   162: getfield 353	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   165: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 367	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: getfield 99	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   178: astore 8
    //   180: aload 8
    //   182: monitorenter
    //   183: aload_0
    //   184: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   187: ifnull +160 -> 347
    //   190: aload_0
    //   191: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   194: getfield 387	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   197: aload 11
    //   199: invokestatic 379	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   202: ifeq +145 -> 347
    //   205: aload_0
    //   206: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   209: getfield 390	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   212: ifnull +135 -> 347
    //   215: aload_0
    //   216: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   219: getfield 390	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   222: astore_2
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   228: getfield 391	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:segmentIndex	I
    //   231: invokespecial 226	com/tencent/tav/decoder/VideoDecoderTrack:getSegment	(I)Lcom/tencent/tav/decoder/DecoderTrackSegment;
    //   234: aload_1
    //   235: if_acmpeq +17 -> 252
    //   238: aload_2
    //   239: aload_1
    //   240: invokevirtual 289	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   243: aload_1
    //   244: invokevirtual 394	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   247: invokeinterface 400 3 0
    //   252: aload_0
    //   253: aconst_null
    //   254: putfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   257: getstatic 55	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   260: astore_1
    //   261: new 341	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 402
    //   271: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: astore 7
    //   276: aload_0
    //   277: getfield 120	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   280: ifnonnull +61 -> 341
    //   283: iload 6
    //   285: istore 5
    //   287: aload_1
    //   288: aload 7
    //   290: iload 5
    //   292: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   295: ldc_w 404
    //   298: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_2
    //   302: invokeinterface 407 1 0
    //   307: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 367	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 8
    //   318: monitorexit
    //   319: aload_2
    //   320: astore_1
    //   321: goto -299 -> 22
    //   324: astore_1
    //   325: aload 8
    //   327: monitorexit
    //   328: aload_1
    //   329: athrow
    //   330: astore_1
    //   331: aload_0
    //   332: monitorexit
    //   333: aload_1
    //   334: athrow
    //   335: iconst_0
    //   336: istore 5
    //   338: goto -268 -> 70
    //   341: iconst_0
    //   342: istore 5
    //   344: goto -57 -> 287
    //   347: aload 8
    //   349: monitorexit
    //   350: aload_0
    //   351: getfield 120	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   354: ifnull +451 -> 805
    //   357: aload 11
    //   359: getfield 410	com/tencent/tav/decoder/DecoderAssetTrack:size	Lcom/tencent/tav/coremedia/CGSize;
    //   362: astore 8
    //   364: aload 11
    //   366: getfield 413	com/tencent/tav/decoder/DecoderAssetTrack:preferRotation	I
    //   369: istore 4
    //   371: aload 8
    //   373: ifnull +432 -> 805
    //   376: aload_0
    //   377: getfield 120	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   380: aload 8
    //   382: getfield 418	com/tencent/tav/coremedia/CGSize:width	F
    //   385: f2i
    //   386: aload 8
    //   388: getfield 421	com/tencent/tav/coremedia/CGSize:height	F
    //   391: f2i
    //   392: iload 4
    //   394: invokeinterface 427 4 0
    //   399: astore 9
    //   401: aload 7
    //   403: astore 8
    //   405: aload_0
    //   406: aload 11
    //   408: aload 9
    //   410: invokespecial 220	com/tencent/tav/decoder/VideoDecoderTrack:newDecoderParams	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Landroid/view/Surface;)Lcom/tencent/tav/decoder/IVideoDecoder$Params;
    //   413: astore 10
    //   415: aload 7
    //   417: astore 8
    //   419: invokestatic 433	com/tencent/tav/decoder/factory/AVDecoderFactory:getInstance	()Lcom/tencent/tav/decoder/factory/IDecoderFactory;
    //   422: aload 10
    //   424: invokeinterface 439 2 0
    //   429: astore 7
    //   431: aload 7
    //   433: ifnull +19 -> 452
    //   436: aload 7
    //   438: astore 8
    //   440: aload 7
    //   442: aload_1
    //   443: invokevirtual 289	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   446: aload_2
    //   447: invokeinterface 400 3 0
    //   452: aload 7
    //   454: astore 8
    //   456: getstatic 55	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   459: new 341	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   466: ldc_w 441
    //   469: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload 11
    //   474: getfield 353	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   477: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 367	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: iload_3
    //   487: iconst_1
    //   488: isub
    //   489: istore_3
    //   490: goto -400 -> 90
    //   493: getstatic 55	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   496: new 341	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 443
    //   506: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 11
    //   511: getfield 353	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   514: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 367	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: aload_0
    //   524: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   527: ifnull -177 -> 350
    //   530: aload_0
    //   531: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   534: getfield 387	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   537: aload 11
    //   539: invokestatic 379	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   542: ifeq -192 -> 350
    //   545: aload_0
    //   546: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   549: getfield 390	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   552: ifnull -202 -> 350
    //   555: aload_0
    //   556: getfield 99	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   559: astore 8
    //   561: aload 8
    //   563: monitorenter
    //   564: aload_0
    //   565: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   568: ifnull +145 -> 713
    //   571: aload_0
    //   572: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   575: getfield 387	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   578: aload 11
    //   580: if_acmpne +133 -> 713
    //   583: aload_0
    //   584: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   587: getfield 390	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   590: ifnull +123 -> 713
    //   593: aload_0
    //   594: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   597: getfield 390	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   600: astore_2
    //   601: aload_0
    //   602: aload_0
    //   603: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   606: getfield 391	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:segmentIndex	I
    //   609: invokespecial 226	com/tencent/tav/decoder/VideoDecoderTrack:getSegment	(I)Lcom/tencent/tav/decoder/DecoderTrackSegment;
    //   612: aload_1
    //   613: if_acmpeq +17 -> 630
    //   616: aload_2
    //   617: aload_1
    //   618: invokevirtual 289	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   621: aload_1
    //   622: invokevirtual 394	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   625: invokeinterface 400 3 0
    //   630: aload_0
    //   631: aconst_null
    //   632: putfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   635: getstatic 55	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   638: astore_1
    //   639: new 341	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 402
    //   649: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: astore 7
    //   654: aload_0
    //   655: getfield 120	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   658: ifnonnull +49 -> 707
    //   661: iconst_1
    //   662: istore 5
    //   664: aload_1
    //   665: aload 7
    //   667: iload 5
    //   669: invokevirtual 358	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   672: ldc_w 404
    //   675: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload_2
    //   679: invokeinterface 407 1 0
    //   684: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 367	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: aload 8
    //   695: monitorexit
    //   696: aload_2
    //   697: astore_1
    //   698: goto -676 -> 22
    //   701: astore_1
    //   702: aload 8
    //   704: monitorexit
    //   705: aload_1
    //   706: athrow
    //   707: iconst_0
    //   708: istore 5
    //   710: goto -46 -> 664
    //   713: aload 8
    //   715: monitorexit
    //   716: goto -366 -> 350
    //   719: astore 7
    //   721: aload 8
    //   723: astore 10
    //   725: aload 7
    //   727: astore 8
    //   729: getstatic 55	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   732: ldc_w 445
    //   735: aload 8
    //   737: invokestatic 449	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   740: aload_0
    //   741: aload 9
    //   743: invokespecial 252	com/tencent/tav/decoder/VideoDecoderTrack:free	(Landroid/view/Surface;)V
    //   746: aload 10
    //   748: ifnull +22 -> 770
    //   751: aload 10
    //   753: iconst_1
    //   754: invokeinterface 453 2 0
    //   759: aload_0
    //   760: aload 10
    //   762: invokeinterface 457 1 0
    //   767: invokespecial 252	com/tencent/tav/decoder/VideoDecoderTrack:free	(Landroid/view/Surface;)V
    //   770: aconst_null
    //   771: astore 7
    //   773: goto -287 -> 486
    //   776: astore 7
    //   778: aconst_null
    //   779: astore 7
    //   781: goto -295 -> 486
    //   784: astore_1
    //   785: aload_1
    //   786: athrow
    //   787: aload 7
    //   789: astore_1
    //   790: goto -768 -> 22
    //   793: astore 8
    //   795: aconst_null
    //   796: astore 9
    //   798: aload 7
    //   800: astore 10
    //   802: goto -73 -> 729
    //   805: aconst_null
    //   806: astore 9
    //   808: goto -407 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	811	0	this	VideoDecoderTrack
    //   0	811	1	paramDecoderTrackSegment	DecoderTrackSegment
    //   0	811	2	paramCMTime	CMTime
    //   86	404	3	i	int
    //   113	280	4	j	int
    //   68	641	5	bool1	boolean
    //   1	283	6	bool2	boolean
    //   4	662	7	localObject1	Object
    //   719	7	7	localException1	Exception
    //   771	1	7	localObject2	Object
    //   776	1	7	localException2	Exception
    //   779	20	7	localObject3	Object
    //   58	678	8	localObject4	Object
    //   793	1	8	localException3	Exception
    //   399	408	9	localSurface	Surface
    //   413	388	10	localObject5	Object
    //   12	567	11	localDecoderAssetTrack	DecoderAssetTrack
    // Exception table:
    //   from	to	target	type
    //   183	252	324	finally
    //   252	283	324	finally
    //   287	319	324	finally
    //   325	328	324	finally
    //   347	350	324	finally
    //   8	14	330	finally
    //   26	67	330	finally
    //   70	85	330	finally
    //   99	183	330	finally
    //   328	330	330	finally
    //   350	371	330	finally
    //   376	401	330	finally
    //   405	415	330	finally
    //   419	431	330	finally
    //   440	452	330	finally
    //   456	486	330	finally
    //   493	564	330	finally
    //   705	707	330	finally
    //   729	746	330	finally
    //   785	787	330	finally
    //   564	630	701	finally
    //   630	661	701	finally
    //   664	696	701	finally
    //   702	705	701	finally
    //   713	716	701	finally
    //   405	415	719	java/lang/Exception
    //   419	431	719	java/lang/Exception
    //   440	452	719	java/lang/Exception
    //   456	486	719	java/lang/Exception
    //   751	770	776	java/lang/Exception
    //   751	770	784	finally
    //   350	371	793	java/lang/Exception
    //   376	401	793	java/lang/Exception
  }
  
  private void createDecoder(DecoderAssetTrack paramDecoderAssetTrack, int paramInt)
  {
    try
    {
      if ((this.surfaceCreator != null) && (paramDecoderAssetTrack.size != null))
      {
        CGSize localCGSize = paramDecoderAssetTrack.size;
        int i = paramDecoderAssetTrack.preferRotation;
        this.decoderCreateThread = new VideoDecoderTrack.DecoderCreateThread(this, paramDecoderAssetTrack, this.surfaceCreator.createOutputSurface((int)localCGSize.width, (int)localCGSize.height, i), paramInt, null);
        this.decoderCreateThread.start();
      }
      return;
    }
    catch (Exception paramDecoderAssetTrack)
    {
      Logger.e(TAG, "createNextDecoder: try start DecoderCreateThread", paramDecoderAssetTrack);
    }
  }
  
  private void createNextDecoder(int paramInt)
  {
    if ((this.segments == null) || (!PRE_READ)) {}
    do
    {
      int i;
      DecoderAssetTrack localDecoderAssetTrack;
      do
      {
        do
        {
          return;
          i = paramInt + 1;
        } while ((i >= this.segments.size()) || (this.decoderCreateThread != null));
        localDecoderAssetTrack = getSegment(i).getVideoAsset();
        if (localDecoderAssetTrack == null) {
          break;
        }
      } while ((this.nextDecoder != null) && (ExtractorUtils.isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack)));
      createDecoder(localDecoderAssetTrack, i);
      return;
    } while ((this.nextDecoder == null) || (this.nextDecoder.segmentIndex == paramInt));
    this.nextDecoder.decoder.start(getSegment(paramInt).getTimeRange());
    this.nextDecoder.segmentIndex = paramInt;
  }
  
  private CMSampleBuffer createSampleBuffer(long paramLong)
  {
    return createSampleBuffer(CMSampleState.fromError(paramLong));
  }
  
  private CMSampleBuffer createSampleBuffer(CMSampleState paramCMSampleState)
  {
    return new CMSampleBuffer(paramCMSampleState);
  }
  
  private CMSampleBuffer createSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    return new CMSampleBuffer(paramCMSampleState, paramTextureInfo, paramBoolean);
  }
  
  private CMSampleBuffer createSampleBuffer(CMSampleState paramCMSampleState, VideoTexture paramVideoTexture, boolean paramBoolean)
  {
    if (paramVideoTexture == null) {}
    for (TextureInfo localTextureInfo = null;; localTextureInfo = paramVideoTexture.getTextureInfo())
    {
      paramCMSampleState = new CacheSampleBuffer(paramCMSampleState, localTextureInfo, paramBoolean);
      paramCMSampleState.setTexture(paramVideoTexture);
      return paramCMSampleState;
    }
  }
  
  private CMSampleBuffer createSampleBuffer(@NonNull CMSampleState paramCMSampleState, boolean paramBoolean)
  {
    if ((this.currentDecoder instanceof VideoDecoder)) {
      return createSampleBuffer(paramCMSampleState, this.surfaceCreator.videoTextureForSurface(this._outputSurface), paramBoolean);
    }
    if (this.currentDecoder == null) {}
    for (TextureInfo localTextureInfo = null;; localTextureInfo = this.currentDecoder.getTextureInfo()) {
      return createSampleBuffer(paramCMSampleState, localTextureInfo, paramBoolean);
    }
  }
  
  @NonNull
  private CMSampleBuffer createSampleBuffer(boolean paramBoolean)
  {
    if (this.currentFrame != null) {
      return createSampleBuffer(this.lastSampleState, this.currentFrame.getTextureInfo(), paramBoolean);
    }
    CMSampleState localCMSampleState = this.lastSampleState;
    if (this.currentDecoder == null) {}
    for (TextureInfo localTextureInfo = null;; localTextureInfo = this.currentDecoder.getTextureInfo()) {
      return createSampleBuffer(localCMSampleState, localTextureInfo, paramBoolean);
    }
  }
  
  private CMSampleBuffer doReadSample(@NonNull CMTime paramCMTime)
  {
    try
    {
      paramCMTime = doReadSample(paramCMTime, false);
      return paramCMTime;
    }
    finally
    {
      paramCMTime = finally;
      throw paramCMTime;
    }
  }
  
  private CMSampleBuffer doReadSample(@NonNull CMTime paramCMTime, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        logVerbose("doReadSample: step 1 ");
        if (this.isReleased)
        {
          paramCMTime = createSampleBuffer(-100L);
          return paramCMTime;
        }
        if (paramCMTime == null)
        {
          paramCMTime = createSampleBuffer(-3L);
          continue;
        }
        if (this.segmentIndex == -1)
        {
          if (this.lastSampleState.getStateCode() >= -1L)
          {
            paramCMTime = createSampleBuffer(-1L);
            continue;
          }
          paramCMTime = createSampleBuffer(-100L);
          continue;
        }
        DecoderTrackSegment localDecoderTrackSegment = getCurrentSegment();
        Object localObject = CMSampleState.fromError(-1L);
        int i = 0;
        logVerbose("doReadSample: step 2 ");
        CMTime localCMTime;
        if (this.currentDecoder == null)
        {
          this.lastSampleState = new CMSampleState(this.lastSampleState.getTime().add(this.frameDuration));
          localCMTime = this.currentSegmentStartTime.add(localDecoderTrackSegment.getScaledDuration());
          if (this.lastSampleState.getTime().smallThan(localCMTime))
          {
            if (this.surfaceCreator == null)
            {
              paramCMTime = createSampleBuffer(this.lastSampleState);
              continue;
            }
            paramCMTime = createSampleBuffer(this.lastSampleState, this.surfaceCreator.videoTextureForSurface(this._outputSurface), false);
          }
        }
        else
        {
          localObject = paramCMTime.sub(this.currentSegmentStartTime).multi(this._speed).limitMin(CMTime.CMTimeZero);
          if ((float)((CMTime)localObject).getTimeUs() <= (float)localDecoderTrackSegment.getScaledDuration().getTimeUs() * this._speed) {
            continue;
          }
          localObject = CMSampleState.fromError(-1L);
        }
        if ((((CMSampleState)localObject).stateMatchingTo(new long[] { -1L })) || (((CMSampleState)localObject).getTime().bigThan(localDecoderTrackSegment.getTimeRange().getDuration())))
        {
          if (localDecoderTrackSegment.getScaledDuration().add(this.currentSegmentStartTime).sub(this.frameDuration).bigThan(paramCMTime))
          {
            if ((i == 0) || (this.currentDecoder == null) || (!this.currentDecoder.isLastFrameValid())) {
              break label653;
            }
            paramBoolean = true;
            paramCMTime = createSampleBuffer(new CMSampleState(paramCMTime), paramBoolean);
            continue;
            localObject = ((CMTime)localObject).add(localDecoderTrackSegment.getDecoderStartTime());
            if (this.currentDecoder == null) {
              localObject = CMSampleState.fromError(-100L);
            } else {
              localObject = this.currentDecoder.readSample((CMTime)localObject);
            }
          }
          else
          {
            if (paramBoolean)
            {
              Logger.d(TAG, "async read finish , skip it!");
              paramCMTime = null;
              continue;
            }
            if (!nextSegment(true))
            {
              paramCMTime = createSampleBuffer(CMSampleState.fromError(-1L), false);
              continue;
            }
            localDecoderTrackSegment = getCurrentSegment();
            continue;
          }
        }
        else
        {
          if (((CMSampleState)localObject).getStateCode() >= 0L)
          {
            logVerbose("doReadSample: step 3 ");
            localCMTime = ((CMSampleState)localObject).getTime().sub(localDecoderTrackSegment.getDecoderStartTime());
            localObject = localCMTime;
            if (localCMTime.bigThan(localDecoderTrackSegment.getTimeRange().getDuration())) {
              localObject = localDecoderTrackSegment.getTimeRange().getDuration();
            }
            localObject = new CMSampleState(this.currentSegmentStartTime.add(((CMTime)localObject).divide(this._speed)));
            logVerbose("readSample: currentTime = " + paramCMTime + "  sampleState = " + localObject);
            paramCMTime = createSampleBuffer((CMSampleState)localObject, true);
            continue;
          }
          if (!((CMSampleState)localObject).stateMatchingTo(new long[] { -3L }))
          {
            paramCMTime = createSampleBuffer(this.lastSampleState);
            continue;
          }
          paramCMTime = createSampleBuffer((CMSampleState)localObject);
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label653:
      paramBoolean = false;
    }
  }
  
  private void doReleaseCurrentDecoder()
  {
    if ((this.currentDecoder == null) || (this.currentDecoder.getSourcePath() == null)) {
      return;
    }
    IVideoDecoder localIVideoDecoder = this.currentDecoder;
    this.currentDecoder = null;
    if ((localIVideoDecoder instanceof ImageDecoder))
    {
      localIVideoDecoder.release(true);
      return;
    }
    ThreadPool.execute(new VideoDecoderTrack.1(this, localIVideoDecoder));
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
  
  private void free(Surface paramSurface)
  {
    if (paramSurface != null) {}
    try
    {
      this.surfaceCreator.free(paramSurface);
      return;
    }
    catch (Exception paramSurface)
    {
      paramSurface.printStackTrace();
    }
  }
  
  private DecoderTrackSegment getCurrentSegment()
  {
    return getSegment(this.segmentIndex);
  }
  
  private DecoderTrackSegment getSegment(int paramInt)
  {
    return (DecoderTrackSegment)this.segments.get(paramInt);
  }
  
  private CMTime getSegmentStartTime(int paramInt)
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while ((i < paramInt) && (i < this.segments.size()))
    {
      localCMTime = CMTime.add(localCMTime, getSegment(i).getScaledDuration());
      i += 1;
    }
    return localCMTime;
  }
  
  private void logVerbose(String paramString)
  {
    Logger.v(TAG, paramString);
  }
  
  private boolean needSwitchNextFrame(@Nullable CMSampleBuffer paramCMSampleBuffer1, @NonNull CMSampleBuffer paramCMSampleBuffer2, @NonNull CMTime paramCMTime)
  {
    if ((paramCMSampleBuffer1 == null) || (paramCMSampleBuffer1.getTextureInfo() == null) || (paramCMSampleBuffer1.getTextureInfo().isReleased()) || (paramCMSampleBuffer2.getTime().smallThan(CMTime.CMTimeZero))) {}
    long l;
    do
    {
      return true;
      l = paramCMSampleBuffer2.getTime().getTimeUs();
    } while (Math.abs(paramCMTime.getTimeUs()) >= Math.abs(l));
    return false;
  }
  
  @NotNull
  private IVideoDecoder.Params newDecoderParams(DecoderAssetTrack paramDecoderAssetTrack, Surface paramSurface)
  {
    IVideoDecoder.Params localParams = new IVideoDecoder.Params();
    localParams.sourceType = paramDecoderAssetTrack.sourceType;
    localParams.filePath = paramDecoderAssetTrack.assetPath;
    localParams.outputSize = ImageDecoder.IMAGE_DECODE_SIZE;
    localParams.outputSurface = paramSurface;
    return localParams;
  }
  
  private boolean nextSegment(boolean paramBoolean)
  {
    Logger.d(TAG, "nextSegment:" + paramBoolean);
    this.segmentIndex += 1;
    this._outputSurface = null;
    if (this.segmentIndex >= this.segments.size())
    {
      this.segmentIndex = -1;
      return false;
    }
    this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
    this.lastSampleState = new CMSampleState(this.currentSegmentStartTime);
    Object localObject2 = getCurrentSegment();
    IVideoDecoder localIVideoDecoder;
    if (((DecoderTrackSegment)localObject2).getVideoAsset() != null)
    {
      releaseCurrentDecoder();
      if (paramBoolean)
      {
        ??? = getCurrentSegment().getDecoderStartTime();
        localIVideoDecoder = createDecoder((DecoderTrackSegment)localObject2, (CMTime)???);
      }
    }
    for (;;)
    {
      synchronized (this.currentDecoderLock)
      {
        this.currentDecoder = localIVideoDecoder;
        if ((this.currentDecoder != null) && (this.currentDecoder.hasTrack()))
        {
          if (paramBoolean) {
            this.currentDecoder.seekTo(((DecoderTrackSegment)localObject2).getDecoderStartTime());
          }
          this._outputSurface = this.currentDecoder.outputSurface();
        }
        if (((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs() > 0L) {
          this._speed = ((float)((DecoderTrackSegment)localObject2).getTimeRange().getDurationUs() * 1.0F / (float)((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs());
        }
        ??? = TAG;
        localObject2 = new StringBuilder().append("nextSegment:");
        if (this.currentDecoder != null) {
          break label306;
        }
        paramBoolean = true;
        Logger.d((String)???, paramBoolean + " " + this._speed);
        return true;
        ??? = CMTime.CMTimeInvalid;
      }
      Logger.d(TAG, "nextSegment: videoAsset is null");
      releaseCurrentDecoder();
      continue;
      label306:
      paramBoolean = false;
    }
  }
  
  private void release(Surface paramSurface)
  {
    if (paramSurface != null) {}
    try
    {
      paramSurface.release();
      return;
    }
    catch (Exception paramSurface)
    {
      paramSurface.printStackTrace();
    }
  }
  
  private void releaseCurrentDecoder()
  {
    if (this.currentDecoder == null) {
      return;
    }
    synchronized (this.currentDecoderLock)
    {
      doReleaseCurrentDecoder();
      return;
    }
  }
  
  private CMTime segmentsDuration()
  {
    return getSegmentStartTime(this.segments.size());
  }
  
  @Nullable
  private CMSampleBuffer switchToNextFrame()
  {
    this.currentFrame = createSampleBuffer(this.nextFrame.getState(), this.nextFrame.getTextureInfo(), this.nextFrame.isNewFrame());
    VideoTexture localVideoTexture;
    if ((this.nextFrame.isNewFrame()) && ((this.nextFrame instanceof CacheSampleBuffer)))
    {
      localVideoTexture = ((CacheSampleBuffer)this.nextFrame).getTexture();
      if ((localVideoTexture != null) && (!Thread.currentThread().getName().equals("VideoDecoder"))) {
        logVerbose("readSample: awaitNewImage: " + this.nextFrame.getTime());
      }
    }
    try
    {
      localVideoTexture.awaitNewImage();
      this.nextFrame = createSampleBuffer(new CMSampleState());
      if (this.currentFrame.getTime().smallThan(CMTime.CMTimeZero))
      {
        this.lastSampleState = this.currentFrame.getState();
        return createSampleBuffer(this.currentFrame.getState());
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e(TAG, "readSample: videoTexture.awaitNewImage() error", localThrowable);
      return createSampleBuffer(CMSampleState.fromError(-3L));
    }
    return null;
  }
  
  private void tryReleaseDecoder(IVideoDecoder paramIVideoDecoder)
  {
    if (paramIVideoDecoder != null) {}
    try
    {
      paramIVideoDecoder.release(true);
      free(paramIVideoDecoder.outputSurface());
      return;
    }
    catch (Exception paramIVideoDecoder)
    {
      Log.e(TAG, "tryReleaseDecoder Exception, ignore", paramIVideoDecoder);
    }
  }
  
  private boolean unNeedReDecoderNextFrame(CMTime paramCMTime)
  {
    boolean bool = false;
    int i;
    if ((this.nextFrame != null) && (this.nextFrame.getTime().bigThan(paramCMTime)))
    {
      i = 1;
      if ((this.nextFrame == null) || (this.currentFrame == null) || (!this.nextFrame.getTime().bigThan(this.currentFrame.getTime()))) {
        break label81;
      }
    }
    label81:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  /* Error */
  public void asyncReadNextSample(CMTime arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 727	com/tencent/tav/decoder/VideoDecoderTrack:unNeedReDecoderNextFrame	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: getfield 105	com/tencent/tav/decoder/VideoDecoderTrack:isReleased	Z
    //   19: ifne -7 -> 12
    //   22: aload_0
    //   23: new 482	com/tencent/tav/coremedia/CMSampleBuffer
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 728	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   31: putfield 107	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   34: aload_0
    //   35: getfield 118	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   38: astore_1
    //   39: aload_1
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield 118	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   45: invokevirtual 731	com/tencent/tav/decoder/VideoDecoderTrack$DecoderThread:action	()V
    //   48: aload_1
    //   49: monitorexit
    //   50: goto -38 -> 12
    //   53: astore_3
    //   54: aload_1
    //   55: monitorexit
    //   56: aload_3
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	VideoDecoderTrack
    //   7	2	2	bool	boolean
    //   53	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   41	50	53	finally
    //   54	56	53	finally
    //   2	8	58	finally
    //   15	41	58	finally
    //   56	58	58	finally
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
      localCMTime3 = segmentsDuration();
      clipRangeAndRemoveRange(paramCMTimeRange);
      if (localCMTime1.getValue() != 0L) {
        this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1), null));
      }
    } while (localCMTime2.getTimeUs() >= localCMTime3.getTimeUs());
    this.segments.add(new DecoderTrackSegment(new CMTimeRange(localCMTime2, new CMTime(localCMTime3.getTimeSeconds() - localCMTime2.getTimeSeconds())), null));
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
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public int getFrameRate()
  {
    return this.frameRate;
  }
  
  public int getTrackId()
  {
    return this.trackId;
  }
  
  public CMSampleBuffer readSample()
  {
    if (this.lastSampleState.isInvalid()) {
      return readSample(CMTime.CMTimeZero);
    }
    return readSample(this.lastSampleState.getTime().add(this.frameDuration));
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    logVerbose("readSample: start expectFrameTime = " + paramCMTime);
    if (this.isReleased)
    {
      releaseCurrentDecoder();
      paramCMTime = createSampleBuffer(CMSampleState.fromError(-100L));
      return paramCMTime;
    }
    if (paramCMTime.bigThan(getDuration()))
    {
      releaseCurrentDecoder();
      return createSampleBuffer(CMSampleState.fromError(-1L));
    }
    if ((this.currentFrame != null) && (this.currentFrame.getTime().getTimeUs() >= 0L) && (this.currentFrame.getTextureInfo() != null) && (!this.currentFrame.getTime().smallThan(paramCMTime)))
    {
      this.lastSampleState = new CMSampleState(paramCMTime);
      return createSampleBuffer(this.lastSampleState, this.currentFrame.getTextureInfo(), false);
    }
    logVerbose("readSample: step 1 ");
    CMTime localCMTime = paramCMTime.sub(this.frameDuration).add(new CMTime(1L, paramCMTime.timeScale));
    if ((findSegmentIndexAt(paramCMTime, false) == this.segmentIndex) && (this.nextFrame != null) && (this.nextFrame.getState().getStateCode() >= 0L) && (this.decodeType == IDecoder.DecodeType.Video)) {}
    for (;;)
    {
      synchronized (this.nextFrameDecoderLock)
      {
        if ((this.nextFrame == null) || (this.nextFrame.getState().getStateCode() < -1L) || ((this.nextFrame.getTextureInfo() == null) && (this.nextFrame.getSampleByteBuffer() == null)))
        {
          logVerbose("readSample:" + localCMTime + " nextFrame not hit time");
          this.nextFrame = doReadSample(localCMTime);
        }
        createNextDecoder(this.segmentIndex);
        this.lastSampleState = new CMSampleState(paramCMTime);
        boolean bool = needSwitchNextFrame(this.currentFrame, this.nextFrame, paramCMTime);
        ??? = new StringBuilder().append("readSample: needSwitch: ").append(bool).append(" expectFrameTime = ").append(paramCMTime).append(" currentFrame = ");
        if (this.currentFrame != null) {
          break label519;
        }
        paramCMTime = CMTime.CMTimeZero;
        logVerbose(paramCMTime + "  nextFrame = " + this.nextFrame);
        if (bool)
        {
          ??? = switchToNextFrame();
          paramCMTime = (CMTime)???;
          if (??? != null) {
            break;
          }
        }
        return createSampleBuffer(bool);
      }
      logVerbose("readSample:" + localCMTime + " nextFrame not hit");
      if (findSegmentIndexAt(paramCMTime, false) != this.segmentIndex)
      {
        this.nextFrame = doReadSample(paramCMTime);
      }
      else
      {
        this.nextFrame = doReadSample(localCMTime);
        continue;
        label519:
        paramCMTime = this.currentFrame.getTime();
      }
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   6: invokevirtual 791	com/tencent/tav/decoder/VideoDecoderTrack$DecoderThread:release	()V
    //   9: getstatic 55	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   12: new 341	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 793
    //   22: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 572	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 105	com/tencent/tav/decoder/VideoDecoderTrack:isReleased	Z
    //   40: aload_0
    //   41: getfield 76	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   44: invokevirtual 796	java/util/ArrayList:clear	()V
    //   47: aload_0
    //   48: getfield 212	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   51: ifnull +31 -> 82
    //   54: aload_0
    //   55: getfield 212	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   58: iconst_1
    //   59: invokeinterface 453 2 0
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 212	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   69: invokeinterface 457 1 0
    //   74: invokespecial 798	com/tencent/tav/decoder/VideoDecoderTrack:release	(Landroid/view/Surface;)V
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 212	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   82: aload_0
    //   83: getfield 99	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   86: astore_1
    //   87: aload_1
    //   88: monitorenter
    //   89: aload_0
    //   90: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   93: ifnull +15 -> 108
    //   96: aload_0
    //   97: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   100: invokestatic 802	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:access$400	(Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;)V
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   108: aload_1
    //   109: monitorexit
    //   110: aload_0
    //   111: getfield 109	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   114: ifnull +23 -> 137
    //   117: aload_0
    //   118: getfield 109	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   121: invokevirtual 519	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   124: ifnull +13 -> 137
    //   127: aload_0
    //   128: getfield 109	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   131: invokevirtual 519	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   134: invokevirtual 803	com/tencent/tav/coremedia/TextureInfo:release	()V
    //   137: aload_0
    //   138: getfield 107	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   141: ifnull +39 -> 180
    //   144: aload_0
    //   145: getfield 107	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   148: instanceof 492
    //   151: ifeq +29 -> 180
    //   154: aload_0
    //   155: getfield 107	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   158: checkcast 492	com/tencent/tav/decoder/CacheSampleBuffer
    //   161: invokevirtual 693	com/tencent/tav/decoder/CacheSampleBuffer:getTexture	()Lcom/tencent/tav/decoder/VideoTexture;
    //   164: ifnull +16 -> 180
    //   167: aload_0
    //   168: getfield 107	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   171: checkcast 492	com/tencent/tav/decoder/CacheSampleBuffer
    //   174: invokevirtual 693	com/tencent/tav/decoder/CacheSampleBuffer:getTexture	()Lcom/tencent/tav/decoder/VideoTexture;
    //   177: invokevirtual 804	com/tencent/tav/decoder/VideoTexture:release	()V
    //   180: getstatic 55	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   183: ldc_w 806
    //   186: invokestatic 572	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_0
    //   190: monitorexit
    //   191: return
    //   192: astore_2
    //   193: aload_1
    //   194: monitorexit
    //   195: aload_2
    //   196: athrow
    //   197: astore_1
    //   198: aload_0
    //   199: monitorexit
    //   200: aload_1
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	VideoDecoderTrack
    //   197	4	1	localObject2	Object
    //   192	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   89	108	192	finally
    //   108	110	192	finally
    //   193	195	192	finally
    //   2	82	197	finally
    //   82	89	197	finally
    //   110	137	197	finally
    //   137	180	197	finally
    //   180	189	197	finally
    //   195	197	197	finally
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    logVerbose("seekTo:[time " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    synchronized (this.nextFrameDecoderLock)
    {
      this.currentFrame = null;
      this.nextFrame = null;
    }
    int i;
    try
    {
      if ((!this.started) || (this.isReleased))
      {
        Logger.e(TAG, "seekTo: [failed] [started " + this.started + "] [isReleased " + this.isReleased + "]", new RuntimeException());
        return null;
        paramCMTime = finally;
        throw paramCMTime;
      }
      i = findSegmentIndexAt(paramCMTime, true);
      if (i == -1)
      {
        this.segmentIndex = -1;
        Logger.w(TAG, "seekTo: [failed] [index " + i + "]");
        return null;
      }
    }
    finally {}
    ??? = getSegmentStartTime(i);
    if ((this.segmentIndex != i) || (this.currentDecoder == null))
    {
      this.segmentIndex = (i - 1);
      nextSegment(false);
    }
    ??? = paramCMTime.sub((CMTime)???).multi(this._speed);
    DecoderTrackSegment localDecoderTrackSegment = getCurrentSegment();
    if (this.currentDecoder == null)
    {
      this.lastSampleState = new CMSampleState(paramCMTime);
      Logger.w(TAG, "seekTo: [failed] [currentDecoder == null]");
      return null;
    }
    this.currentDecoder.seekTo(localDecoderTrackSegment.getDecoderStartTime().add((CMTime)???), paramBoolean2);
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleState = new CMSampleState(paramCMTime.sub(this.frameDuration));; this.lastSampleState = new CMSampleState(paramCMTime))
    {
      paramCMTime = localObject1;
      if (paramBoolean1) {
        paramCMTime = readSample();
      }
      this.currentFrame = null;
      this.nextFrame = null;
      logVerbose("seekTo: [success] [lastSampleState " + this.lastSampleState + "] [sampleBuffer " + paramCMTime + "]");
      return paramCMTime;
    }
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType)
  {
    this.decodeType = paramDecodeType;
  }
  
  public void setFrameRate(int paramInt)
  {
    this.frameRate = paramInt;
    this.frameDuration = new CMTime(600 / paramInt, 600);
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList)
  {
    if (this.segments == null) {
      this.segments = new ArrayList();
    }
    this.segments.clear();
    this.segments.addAll(paramList);
  }
  
  public void setVolume(float paramFloat) {}
  
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
    Logger.d(TAG, "VideoDecoderTrack start:" + paramCMTimeRange);
    if (this.segments.size() == 0)
    {
      release();
      return;
    }
    this.isReleased = false;
    this.started = true;
    this.surfaceCreator = paramSurfaceCreator;
    this.segmentIndex = -1;
    this.decoderThread.start();
    clipRangeAndRemoveRange(paramCMTimeRange);
    nextSegment(true);
    Logger.d(TAG, "VideoDecoderTrack start finish:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack
 * JD-Core Version:    0.7.0.1
 */