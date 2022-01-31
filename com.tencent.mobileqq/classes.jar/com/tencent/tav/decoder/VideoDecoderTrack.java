package com.tencent.tav.decoder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.ExtractorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoDecoderTrack
  implements IDecoderTrack
{
  public static boolean LOG_VERBOSE = false;
  public static boolean PRE_READ = true;
  private static String TAG = "VDecoderTrack";
  private Surface _outputSurface;
  private float _speed = 1.0F;
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
  private CMTime lastSampleTime = CMTime.CMTimeInvalid;
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
    //   9: invokevirtual 334	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   12: astore 11
    //   14: aload 11
    //   16: ifnonnull +10 -> 26
    //   19: aload 7
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: getstatic 54	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   29: astore 7
    //   31: new 336	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 339
    //   41: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload 11
    //   46: getfield 348	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   49: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 350
    //   55: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: astore 8
    //   60: aload_0
    //   61: getfield 121	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   64: ifnull +283 -> 347
    //   67: iconst_1
    //   68: istore 5
    //   70: aload 7
    //   72: aload 8
    //   74: iload 5
    //   76: invokevirtual 353	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   79: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 362	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: iconst_5
    //   90: istore_3
    //   91: aconst_null
    //   92: astore 7
    //   94: aload 7
    //   96: ifnonnull +769 -> 865
    //   99: iload_3
    //   100: ifle +765 -> 865
    //   103: aload_0
    //   104: getfield 98	com/tencent/tav/decoder/VideoDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;
    //   107: ifnull +409 -> 516
    //   110: aload_0
    //   111: getfield 98	com/tencent/tav/decoder/VideoDecoderTrack:decoderCreateThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;
    //   114: invokestatic 368	com/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread:access$100	(Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderCreateThread;)I
    //   117: istore 4
    //   119: iload 4
    //   121: aload_0
    //   122: getfield 77	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   125: invokevirtual 268	java/util/ArrayList:size	()I
    //   128: if_icmpge +234 -> 362
    //   131: aload_0
    //   132: iload 4
    //   134: invokespecial 221	com/tencent/tav/decoder/VideoDecoderTrack:getSegment	(I)Lcom/tencent/tav/decoder/DecoderTrackSegment;
    //   137: invokevirtual 334	com/tencent/tav/decoder/DecoderTrackSegment:getVideoAsset	()Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   140: aload 11
    //   142: invokestatic 374	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   145: ifeq +217 -> 362
    //   148: getstatic 54	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   151: new 336	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 376
    //   161: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 11
    //   166: getfield 348	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   169: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 362	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: getfield 100	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   186: astore 8
    //   188: aload 8
    //   190: monitorenter
    //   191: aload_0
    //   192: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   195: ifnull +164 -> 359
    //   198: aload_0
    //   199: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   202: getfield 382	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   205: aload 11
    //   207: invokestatic 374	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   210: ifeq +149 -> 359
    //   213: aload_0
    //   214: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   217: getfield 385	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   220: ifnull +139 -> 359
    //   223: aload_0
    //   224: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   227: getfield 385	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   230: astore_2
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   236: getfield 386	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:segmentIndex	I
    //   239: invokespecial 221	com/tencent/tav/decoder/VideoDecoderTrack:getSegment	(I)Lcom/tencent/tav/decoder/DecoderTrackSegment;
    //   242: aload_1
    //   243: if_acmpeq +17 -> 260
    //   246: aload_2
    //   247: aload_1
    //   248: invokevirtual 284	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   251: aload_1
    //   252: invokevirtual 389	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   255: invokeinterface 395 3 0
    //   260: aload_0
    //   261: aconst_null
    //   262: putfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   265: getstatic 54	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   268: astore_1
    //   269: new 336	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 397
    //   279: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: astore 7
    //   284: aload_0
    //   285: getfield 121	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   288: ifnonnull +65 -> 353
    //   291: iload 6
    //   293: istore 5
    //   295: aload_1
    //   296: aload 7
    //   298: iload 5
    //   300: invokevirtual 353	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   303: ldc_w 399
    //   306: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_2
    //   310: invokeinterface 402 1 0
    //   315: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 362	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: aload 8
    //   330: monitorexit
    //   331: aload_2
    //   332: astore_1
    //   333: goto -311 -> 22
    //   336: astore_1
    //   337: aload 8
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    //   342: astore_1
    //   343: aload_0
    //   344: monitorexit
    //   345: aload_1
    //   346: athrow
    //   347: iconst_0
    //   348: istore 5
    //   350: goto -280 -> 70
    //   353: iconst_0
    //   354: istore 5
    //   356: goto -61 -> 295
    //   359: aload 8
    //   361: monitorexit
    //   362: aload_0
    //   363: getfield 121	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   366: ifnull +526 -> 892
    //   369: aload 11
    //   371: getfield 405	com/tencent/tav/decoder/DecoderAssetTrack:size	Lcom/tencent/tav/coremedia/CGSize;
    //   374: astore 8
    //   376: aload 11
    //   378: getfield 408	com/tencent/tav/decoder/DecoderAssetTrack:preferRotation	I
    //   381: istore 4
    //   383: aload 8
    //   385: ifnull +507 -> 892
    //   388: aload_0
    //   389: getfield 121	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   392: aload 8
    //   394: getfield 413	com/tencent/tav/coremedia/CGSize:width	F
    //   397: f2i
    //   398: aload 8
    //   400: getfield 416	com/tencent/tav/coremedia/CGSize:height	F
    //   403: f2i
    //   404: iload 4
    //   406: invokeinterface 422 4 0
    //   411: astore 8
    //   413: aload 7
    //   415: astore 9
    //   417: aload 11
    //   419: getfield 425	com/tencent/tav/decoder/DecoderAssetTrack:sourceType	I
    //   422: iconst_3
    //   423: if_icmpne +327 -> 750
    //   426: aload 7
    //   428: astore 9
    //   430: new 427	com/tencent/tav/decoder/ImageDecoder
    //   433: dup
    //   434: invokespecial 428	com/tencent/tav/decoder/ImageDecoder:<init>	()V
    //   437: astore 7
    //   439: aload 7
    //   441: aload 11
    //   443: getfield 348	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   446: getstatic 431	com/tencent/tav/decoder/ImageDecoder:IMAGE_DECODE_SIZE	Lcom/tencent/tav/coremedia/CGSize;
    //   449: aconst_null
    //   450: invokeinterface 435 4 0
    //   455: aload 7
    //   457: astore 9
    //   459: aload 7
    //   461: aload_1
    //   462: invokevirtual 284	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   465: aload_2
    //   466: invokeinterface 395 3 0
    //   471: aload 7
    //   473: astore 9
    //   475: getstatic 54	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   478: new 336	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   485: ldc_w 437
    //   488: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload 11
    //   493: getfield 348	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   496: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: iconst_0
    //   503: anewarray 4	java/lang/Object
    //   506: invokestatic 362	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   509: iload_3
    //   510: iconst_1
    //   511: isub
    //   512: istore_3
    //   513: goto -419 -> 94
    //   516: getstatic 54	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   519: new 336	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 439
    //   529: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 11
    //   534: getfield 348	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   537: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: iconst_0
    //   544: anewarray 4	java/lang/Object
    //   547: invokestatic 362	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   550: aload_0
    //   551: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   554: ifnull -192 -> 362
    //   557: aload_0
    //   558: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   561: getfield 382	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   564: aload 11
    //   566: invokestatic 374	com/tencent/tav/extractor/ExtractorUtils:isSameExtractor	(Lcom/tencent/tav/decoder/DecoderAssetTrack;Lcom/tencent/tav/decoder/DecoderAssetTrack;)Z
    //   569: ifeq -207 -> 362
    //   572: aload_0
    //   573: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   576: getfield 385	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   579: ifnull -217 -> 362
    //   582: aload_0
    //   583: getfield 100	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   586: astore 8
    //   588: aload 8
    //   590: monitorenter
    //   591: aload_0
    //   592: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   595: ifnull +149 -> 744
    //   598: aload_0
    //   599: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   602: getfield 382	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:extractor	Lcom/tencent/tav/decoder/DecoderAssetTrack;
    //   605: aload 11
    //   607: if_acmpne +137 -> 744
    //   610: aload_0
    //   611: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   614: getfield 385	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   617: ifnull +127 -> 744
    //   620: aload_0
    //   621: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   624: getfield 385	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:decoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   627: astore_2
    //   628: aload_0
    //   629: aload_0
    //   630: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   633: getfield 386	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:segmentIndex	I
    //   636: invokespecial 221	com/tencent/tav/decoder/VideoDecoderTrack:getSegment	(I)Lcom/tencent/tav/decoder/DecoderTrackSegment;
    //   639: aload_1
    //   640: if_acmpeq +17 -> 657
    //   643: aload_2
    //   644: aload_1
    //   645: invokevirtual 284	com/tencent/tav/decoder/DecoderTrackSegment:getTimeRange	()Lcom/tencent/tav/coremedia/CMTimeRange;
    //   648: aload_1
    //   649: invokevirtual 389	com/tencent/tav/decoder/DecoderTrackSegment:getDecoderStartTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   652: invokeinterface 395 3 0
    //   657: aload_0
    //   658: aconst_null
    //   659: putfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   662: getstatic 54	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   665: astore_1
    //   666: new 336	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   673: ldc_w 397
    //   676: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: astore 7
    //   681: aload_0
    //   682: getfield 121	com/tencent/tav/decoder/VideoDecoderTrack:surfaceCreator	Lcom/tencent/tav/decoder/IDecoderTrack$SurfaceCreator;
    //   685: ifnonnull +53 -> 738
    //   688: iconst_1
    //   689: istore 5
    //   691: aload_1
    //   692: aload 7
    //   694: iload 5
    //   696: invokevirtual 353	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   699: ldc_w 399
    //   702: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload_2
    //   706: invokeinterface 402 1 0
    //   711: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: iconst_0
    //   718: anewarray 4	java/lang/Object
    //   721: invokestatic 362	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   724: aload 8
    //   726: monitorexit
    //   727: aload_2
    //   728: astore_1
    //   729: goto -707 -> 22
    //   732: astore_1
    //   733: aload 8
    //   735: monitorexit
    //   736: aload_1
    //   737: athrow
    //   738: iconst_0
    //   739: istore 5
    //   741: goto -50 -> 691
    //   744: aload 8
    //   746: monitorexit
    //   747: goto -385 -> 362
    //   750: aload 7
    //   752: astore 9
    //   754: new 441	com/tencent/tav/decoder/VideoDecoder
    //   757: dup
    //   758: aload 11
    //   760: getfield 348	com/tencent/tav/decoder/DecoderAssetTrack:assetPath	Ljava/lang/String;
    //   763: aload 8
    //   765: invokespecial 444	com/tencent/tav/decoder/VideoDecoder:<init>	(Ljava/lang/String;Landroid/view/Surface;)V
    //   768: astore 7
    //   770: goto -315 -> 455
    //   773: astore 10
    //   775: aload 7
    //   777: astore 9
    //   779: aload 10
    //   781: astore 7
    //   783: getstatic 54	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   786: new 336	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   793: ldc_w 446
    //   796: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload 7
    //   801: invokevirtual 449	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   804: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: aload 7
    //   809: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   812: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   815: invokestatic 456	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   818: aload_0
    //   819: aload 8
    //   821: invokespecial 215	com/tencent/tav/decoder/VideoDecoderTrack:free	(Landroid/view/Surface;)V
    //   824: aload 9
    //   826: ifnull +22 -> 848
    //   829: aload 9
    //   831: iconst_1
    //   832: invokeinterface 460 2 0
    //   837: aload_0
    //   838: aload 9
    //   840: invokeinterface 464 1 0
    //   845: invokespecial 215	com/tencent/tav/decoder/VideoDecoderTrack:free	(Landroid/view/Surface;)V
    //   848: aconst_null
    //   849: astore 7
    //   851: goto -342 -> 509
    //   854: astore 7
    //   856: aconst_null
    //   857: astore 7
    //   859: goto -350 -> 509
    //   862: astore_1
    //   863: aload_1
    //   864: athrow
    //   865: aload 7
    //   867: astore_1
    //   868: goto -846 -> 22
    //   871: astore 7
    //   873: goto -90 -> 783
    //   876: astore 8
    //   878: aload 7
    //   880: astore 9
    //   882: aload 8
    //   884: astore 7
    //   886: aconst_null
    //   887: astore 8
    //   889: goto -106 -> 783
    //   892: aconst_null
    //   893: astore 8
    //   895: goto -482 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	898	0	this	VideoDecoderTrack
    //   0	898	1	paramDecoderTrackSegment	DecoderTrackSegment
    //   0	898	2	paramCMTime	CMTime
    //   90	423	3	i	int
    //   117	288	4	j	int
    //   68	672	5	bool1	boolean
    //   1	291	6	bool2	boolean
    //   4	846	7	localObject1	Object
    //   854	1	7	localException1	Exception
    //   857	9	7	localObject2	Object
    //   871	8	7	localException2	Exception
    //   884	1	7	localObject3	Object
    //   58	762	8	localObject4	Object
    //   876	7	8	localException3	Exception
    //   887	7	8	localObject5	Object
    //   415	466	9	localObject6	Object
    //   773	7	10	localException4	Exception
    //   12	747	11	localDecoderAssetTrack	DecoderAssetTrack
    // Exception table:
    //   from	to	target	type
    //   191	260	336	finally
    //   260	291	336	finally
    //   295	331	336	finally
    //   337	340	336	finally
    //   359	362	336	finally
    //   8	14	342	finally
    //   26	67	342	finally
    //   70	89	342	finally
    //   103	191	342	finally
    //   340	342	342	finally
    //   362	383	342	finally
    //   388	413	342	finally
    //   417	426	342	finally
    //   430	439	342	finally
    //   439	455	342	finally
    //   459	471	342	finally
    //   475	509	342	finally
    //   516	591	342	finally
    //   736	738	342	finally
    //   754	770	342	finally
    //   783	824	342	finally
    //   863	865	342	finally
    //   591	657	732	finally
    //   657	688	732	finally
    //   691	727	732	finally
    //   733	736	732	finally
    //   744	747	732	finally
    //   439	455	773	java/lang/Exception
    //   829	848	854	java/lang/Exception
    //   829	848	862	finally
    //   417	426	871	java/lang/Exception
    //   430	439	871	java/lang/Exception
    //   459	471	871	java/lang/Exception
    //   475	509	871	java/lang/Exception
    //   754	770	871	java/lang/Exception
    //   362	383	876	java/lang/Exception
    //   388	413	876	java/lang/Exception
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
  
  private CMSampleBuffer createSampleBuffer(CMTime paramCMTime)
  {
    return new CMSampleBuffer(paramCMTime);
  }
  
  private CMSampleBuffer createSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    return new CMSampleBuffer(paramCMTime, paramTextureInfo, paramBoolean);
  }
  
  private CMSampleBuffer createSampleBuffer(CMTime paramCMTime, VideoTexture paramVideoTexture, boolean paramBoolean)
  {
    if (paramVideoTexture == null) {}
    for (TextureInfo localTextureInfo = null;; localTextureInfo = paramVideoTexture.getTextureInfo())
    {
      paramCMTime = new CacheSampleBuffer(paramCMTime, localTextureInfo, paramBoolean);
      paramCMTime.setTexture(paramVideoTexture);
      return paramCMTime;
    }
  }
  
  private CMSampleBuffer createSampleBuffer(@NonNull CMTime paramCMTime, boolean paramBoolean)
  {
    if ((this.currentDecoder instanceof VideoDecoder)) {
      return createSampleBuffer(paramCMTime, this.surfaceCreator.videoTextureForSurface(this._outputSurface), paramBoolean);
    }
    if (this.currentDecoder == null) {}
    for (TextureInfo localTextureInfo = null;; localTextureInfo = this.currentDecoder.getTextureInfo()) {
      return createSampleBuffer(paramCMTime, localTextureInfo, paramBoolean);
    }
  }
  
  @NonNull
  private CMSampleBuffer createSampleBuffer(boolean paramBoolean)
  {
    if (this.currentFrame != null) {
      return createSampleBuffer(this.lastSampleTime, this.currentFrame.getTextureInfo(), paramBoolean);
    }
    CMTime localCMTime = this.lastSampleTime;
    if (this.currentDecoder == null) {}
    for (TextureInfo localTextureInfo = null;; localTextureInfo = this.currentDecoder.getTextureInfo()) {
      return createSampleBuffer(localCMTime, localTextureInfo, paramBoolean);
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
          paramCMTime = createSampleBuffer(IDecoder.SAMPLE_TIME_UNSTART);
          return paramCMTime;
        }
        if (paramCMTime == null)
        {
          paramCMTime = createSampleBuffer(IDecoder.SAMPLE_TIME_ERROR);
          continue;
        }
        if (this.segmentIndex == -1)
        {
          if (!this.lastSampleTime.smallThan(IDecoder.SAMPLE_TIME_FINISH))
          {
            paramCMTime = createSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
            continue;
          }
          paramCMTime = createSampleBuffer(VideoDecoder.SAMPLE_TIME_UNSTART);
          continue;
        }
        DecoderTrackSegment localDecoderTrackSegment = getCurrentSegment();
        Object localObject = VideoDecoder.SAMPLE_TIME_FINISH;
        int i = 0;
        logVerbose("doReadSample: step 2 ");
        CMTime localCMTime;
        if (this.currentDecoder == null)
        {
          this.lastSampleTime = this.lastSampleTime.add(this.frameDuration);
          localCMTime = this.currentSegmentStartTime.add(localDecoderTrackSegment.getScaledDuration());
          if (this.lastSampleTime.smallThan(localCMTime))
          {
            if (this.surfaceCreator == null)
            {
              paramCMTime = createSampleBuffer(this.lastSampleTime);
              continue;
            }
            paramCMTime = createSampleBuffer(this.lastSampleTime, this.surfaceCreator.videoTextureForSurface(this._outputSurface), false);
          }
        }
        else
        {
          localObject = paramCMTime.sub(this.currentSegmentStartTime).multi(this._speed).limitMin(CMTime.CMTimeZero);
          if ((float)((CMTime)localObject).getTimeUs() <= (float)localDecoderTrackSegment.getScaledDuration().getTimeUs() * this._speed) {
            continue;
          }
          localObject = VideoDecoder.SAMPLE_TIME_FINISH;
        }
        if ((((CMTime)localObject).equalsTo(VideoDecoder.SAMPLE_TIME_FINISH)) || (((CMTime)localObject).bigThan(localDecoderTrackSegment.getTimeRange().getDuration())))
        {
          if (localDecoderTrackSegment.getScaledDuration().add(this.currentSegmentStartTime).sub(this.frameDuration).bigThan(paramCMTime))
          {
            if ((i == 0) || (this.currentDecoder == null) || (!this.currentDecoder.isLastFrameValid())) {
              break label595;
            }
            paramBoolean = true;
            paramCMTime = createSampleBuffer(paramCMTime, paramBoolean);
            continue;
            localObject = ((CMTime)localObject).add(localDecoderTrackSegment.getDecoderStartTime());
            if (this.currentDecoder == null) {
              localObject = IDecoder.SAMPLE_TIME_UNSTART;
            } else {
              localObject = this.currentDecoder.readSample((CMTime)localObject);
            }
          }
          else
          {
            if (paramBoolean)
            {
              Logger.e(TAG, "async read finish , skip it!");
              paramCMTime = null;
              continue;
            }
            if (!nextSegment(true))
            {
              paramCMTime = createSampleBuffer(VideoDecoder.SAMPLE_TIME_FINISH, false);
              continue;
            }
            localDecoderTrackSegment = getCurrentSegment();
            continue;
          }
        }
        else
        {
          if (((CMTime)localObject).getTimeUs() >= 0L)
          {
            logVerbose("doReadSample: step 3 ");
            localCMTime = ((CMTime)localObject).sub(localDecoderTrackSegment.getDecoderStartTime());
            localObject = localCMTime;
            if (localCMTime.bigThan(localDecoderTrackSegment.getTimeRange().getDuration())) {
              localObject = localDecoderTrackSegment.getTimeRange().getDuration();
            }
            localObject = this.currentSegmentStartTime.add(((CMTime)localObject).divide(this._speed));
            logVerbose("readSample: currentTime = " + paramCMTime + "  sampleTime = " + localObject);
            paramCMTime = createSampleBuffer((CMTime)localObject, true);
            continue;
          }
          if (!((CMTime)localObject).equalsTo(VideoDecoder.SAMPLE_TIME_ERROR))
          {
            paramCMTime = createSampleBuffer(this.lastSampleTime);
            continue;
          }
          paramCMTime = createSampleBuffer((CMTime)localObject);
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label595:
      paramBoolean = false;
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
    if (LOG_VERBOSE) {
      Logger.d(TAG, paramString);
    }
  }
  
  private boolean needSwitchNextFrame(@Nullable CMSampleBuffer paramCMSampleBuffer1, @NonNull CMSampleBuffer paramCMSampleBuffer2, @NonNull CMTime paramCMTime)
  {
    if ((paramCMSampleBuffer1 == null) || (paramCMSampleBuffer2.getTime().smallThan(CMTime.CMTimeZero))) {}
    long l;
    do
    {
      return true;
      l = paramCMSampleBuffer2.getTime().getTimeUs();
    } while (Math.abs(paramCMTime.getTimeUs()) >= Math.abs(l));
    return false;
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
    this.lastSampleTime = this.currentSegmentStartTime;
    Object localObject2 = getCurrentSegment();
    IVideoDecoder localIVideoDecoder;
    if (((DecoderTrackSegment)localObject2).getVideoAsset() != null) {
      synchronized (this.currentDecoderLock)
      {
        if ((this.currentDecoder != null) && (this.currentDecoder.getSourcePath() != null))
        {
          new VideoDecoderTrack.ReleaseDecoderThread(this, this.currentDecoder).start();
          this.currentDecoder = null;
        }
        if (paramBoolean)
        {
          ??? = getCurrentSegment().getDecoderStartTime();
          localIVideoDecoder = createDecoder((DecoderTrackSegment)localObject2, (CMTime)???);
        }
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
          break label385;
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
          new VideoDecoderTrack.ReleaseDecoderThread(this, this.currentDecoder).start();
          this.currentDecoder = null;
        }
      }
      label385:
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
  
  private void releaseDecoder()
  {
    if (this.currentDecoder == null) {
      return;
    }
    synchronized (this.currentDecoderLock)
    {
      if ((this.currentDecoder != null) && (this.currentDecoder.getSourcePath() != null))
      {
        new VideoDecoderTrack.ReleaseDecoderThread(this, this.currentDecoder).start();
        this.currentDecoder = null;
      }
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
    this.currentFrame = createSampleBuffer(this.nextFrame.getTime(), this.nextFrame.getTextureInfo(), this.nextFrame.isNewFrame());
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
      this.nextFrame = createSampleBuffer(CMTime.CMTimeInvalid);
      if (this.currentFrame.getTime().smallThan(CMTime.CMTimeZero))
      {
        this.lastSampleTime = this.currentFrame.getTime();
        return createSampleBuffer(this.currentFrame.getTime());
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e(TAG, "readSample: videoTexture.awaitNewImage() error", localThrowable);
      return createSampleBuffer(IDecoder.SAMPLE_TIME_ERROR);
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
    //   4: invokespecial 678	com/tencent/tav/decoder/VideoDecoderTrack:unNeedReDecoderNextFrame	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: getfield 106	com/tencent/tav/decoder/VideoDecoderTrack:isReleased	Z
    //   19: ifne -7 -> 12
    //   22: aload_0
    //   23: new 485	com/tencent/tav/coremedia/CMSampleBuffer
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 487	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   31: putfield 108	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   34: aload_0
    //   35: getfield 119	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   38: astore_1
    //   39: aload_1
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield 119	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   45: invokevirtual 681	com/tencent/tav/decoder/VideoDecoderTrack$DecoderThread:action	()V
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
    if (this.lastSampleTime == CMTime.CMTimeInvalid) {
      return readSample(CMTime.CMTimeZero);
    }
    return readSample(this.lastSampleTime.add(this.frameDuration));
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    logVerbose("readSample: start expectFrameTime = " + paramCMTime);
    if (this.isReleased)
    {
      releaseDecoder();
      ??? = createSampleBuffer(IDecoder.SAMPLE_TIME_UNSTART);
      return ???;
    }
    if (paramCMTime.bigThan(getDuration()))
    {
      releaseDecoder();
      return createSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
    }
    if ((this.currentFrame != null) && (this.currentFrame.getTime().getTimeUs() >= 0L) && (this.currentFrame.getTextureInfo() != null) && (!this.currentFrame.getTime().smallThan(paramCMTime)))
    {
      this.lastSampleTime = paramCMTime;
      return createSampleBuffer(this.lastSampleTime, this.currentFrame.getTextureInfo(), false);
    }
    logVerbose("readSample: step 1 ");
    Object localObject2 = paramCMTime.sub(this.frameDuration).add(new CMTime(1L, paramCMTime.timeScale));
    if ((findSegmentIndexAt(paramCMTime, false) == this.segmentIndex) && (this.nextFrame != null) && (this.nextFrame.getTime().getTimeUs() >= 0L) && (this.decodeType == IDecoder.DecodeType.Video)) {}
    for (;;)
    {
      synchronized (this.nextFrameDecoderLock)
      {
        if ((this.nextFrame == null) || (this.nextFrame.getTime().getTimeUs() < IDecoder.SAMPLE_TIME_FINISH.getTimeUs()) || ((this.nextFrame.getTextureInfo() == null) && (this.nextFrame.getSampleByteBuffer() == null)))
        {
          logVerbose("readSample:" + localObject2 + " nextFrame not hit time");
          this.nextFrame = doReadSample((CMTime)localObject2);
        }
        logVerbose("readSample: step 2 ");
        boolean bool = needSwitchNextFrame(this.currentFrame, this.nextFrame, paramCMTime);
        localObject2 = new StringBuilder().append("readSample: needSwitch: ").append(bool).append(" expectFrameTime = ").append(paramCMTime).append(" currentFrame = ");
        if (this.currentFrame != null) {
          break label528;
        }
        ??? = CMTime.CMTimeZero;
        logVerbose(??? + "  nextFrame = " + this.nextFrame);
        if (bool)
        {
          localObject2 = switchToNextFrame();
          ??? = localObject2;
          if (localObject2 != null) {
            break;
          }
        }
        logVerbose("readSample: step 3 ");
        createNextDecoder(this.segmentIndex);
        this.lastSampleTime = paramCMTime;
        logVerbose("readSample: step 4 ");
        return createSampleBuffer(bool);
      }
      logVerbose("readSample:" + localObject2 + " nextFrame not hit");
      if (findSegmentIndexAt(paramCMTime, false) != this.segmentIndex)
      {
        this.nextFrame = doReadSample(paramCMTime);
      }
      else
      {
        this.nextFrame = doReadSample((CMTime)localObject2);
        continue;
        label528:
        ??? = this.currentFrame.getTime();
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
    //   3: getfield 119	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   6: invokevirtual 746	com/tencent/tav/decoder/VideoDecoderTrack$DecoderThread:release	()V
    //   9: getstatic 54	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   12: new 336	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 748
    //   22: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 593	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 106	com/tencent/tav/decoder/VideoDecoderTrack:isReleased	Z
    //   40: aload_0
    //   41: getfield 77	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   44: invokevirtual 751	java/util/ArrayList:clear	()V
    //   47: aload_0
    //   48: getfield 207	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   51: ifnull +31 -> 82
    //   54: aload_0
    //   55: getfield 207	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   58: iconst_1
    //   59: invokeinterface 460 2 0
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 207	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   69: invokeinterface 464 1 0
    //   74: invokespecial 753	com/tencent/tav/decoder/VideoDecoderTrack:release	(Landroid/view/Surface;)V
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 207	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   82: aload_0
    //   83: getfield 100	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   86: astore_1
    //   87: aload_1
    //   88: monitorenter
    //   89: aload_0
    //   90: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   93: ifnull +15 -> 108
    //   96: aload_0
    //   97: getfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   100: invokestatic 757	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:access$300	(Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;)V
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 258	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   108: aload_1
    //   109: monitorexit
    //   110: aload_0
    //   111: getfield 110	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   114: ifnull +23 -> 137
    //   117: aload_0
    //   118: getfield 110	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   121: invokevirtual 518	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   124: ifnull +13 -> 137
    //   127: aload_0
    //   128: getfield 110	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   131: invokevirtual 518	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   134: invokevirtual 760	com/tencent/tav/coremedia/TextureInfo:release	()V
    //   137: aload_0
    //   138: getfield 108	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   141: ifnull +39 -> 180
    //   144: aload_0
    //   145: getfield 108	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   148: instanceof 494
    //   151: ifeq +29 -> 180
    //   154: aload_0
    //   155: getfield 108	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   158: checkcast 494	com/tencent/tav/decoder/CacheSampleBuffer
    //   161: invokevirtual 644	com/tencent/tav/decoder/CacheSampleBuffer:getTexture	()Lcom/tencent/tav/decoder/VideoTexture;
    //   164: ifnull +16 -> 180
    //   167: aload_0
    //   168: getfield 108	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   171: checkcast 494	com/tencent/tav/decoder/CacheSampleBuffer
    //   174: invokevirtual 644	com/tencent/tav/decoder/CacheSampleBuffer:getTexture	()Lcom/tencent/tav/decoder/VideoTexture;
    //   177: invokevirtual 761	com/tencent/tav/decoder/VideoTexture:release	()V
    //   180: getstatic 54	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   183: ldc_w 763
    //   186: invokestatic 593	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    logVerbose("seekTo:[timeUs " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
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
        Logger.e(TAG, "seekTo: [failed] [started " + this.started + "] [isReleased " + this.isReleased + "]");
        return null;
        paramCMTime = finally;
        throw paramCMTime;
      }
      i = findSegmentIndexAt(paramCMTime, true);
      if (i == -1)
      {
        this.segmentIndex = -1;
        Logger.e(TAG, "seekTo: [failed] [index " + i + "]");
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
      this.lastSampleTime = paramCMTime;
      Logger.e(TAG, "seekTo: [failed] [currentDecoder == null]");
      return null;
    }
    this.currentDecoder.seekTo(localDecoderTrackSegment.getDecoderStartTime().add((CMTime)???), paramBoolean2);
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleTime = paramCMTime.sub(this.frameDuration);; this.lastSampleTime = paramCMTime)
    {
      paramCMTime = localObject1;
      if (paramBoolean1) {
        paramCMTime = readSample();
      }
      this.currentFrame = null;
      this.nextFrame = null;
      logVerbose("seekTo: [success] [lastSampleTime " + this.lastSampleTime + "] [sampleBuffer " + paramCMTime + "]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack
 * JD-Core Version:    0.7.0.1
 */