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
import com.tencent.tav.decoder.factory.AVDecoderFactory;
import com.tencent.tav.decoder.factory.IDecoderFactory;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.ExtractorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class VideoDecoderTrack
  implements IDecoderTrack
{
  public static boolean DELAY_RELEASE_DECODER_ON_PLAY_FINISH = true;
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
  private IVideoDecoder delayReleaseDecoder;
  private CMTime duration = CMTime.CMTimeZero;
  private CMTime frameDuration = new CMTime(1L, 44);
  private int frameRate = 44;
  private int index;
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
    int i;
    if (getFrameRate() > 0) {
      i = getFrameRate();
    } else {
      i = (int)paramAssetTrack.getNominalFrameRate();
    }
    setFrameRate(i);
    setVolume(paramAssetTrack.getPreferredVolume());
    setDecodeType(IDecoder.DecodeType.Video);
    if (paramAssetTrack.getTimeRange() != null) {
      clipRangeAndClearRange(paramAssetTrack.getTimeRange().clone());
    }
  }
  
  private void checkReleaseDelayDecoder()
  {
    if (!DELAY_RELEASE_DECODER_ON_PLAY_FINISH) {
      return;
    }
    if (this.delayReleaseDecoder == null) {
      return;
    }
    synchronized (this.currentDecoderLock)
    {
      IVideoDecoder localIVideoDecoder = this.delayReleaseDecoder;
      this.delayReleaseDecoder = null;
      if ((localIVideoDecoder instanceof ImageDecoder))
      {
        localIVideoDecoder.release(true);
        return;
      }
      ThreadPool.execute(new VideoDecoderTrack.1(this, localIVideoDecoder));
      return;
    }
  }
  
  private void clipRangeAndRemoveRange(CMTimeRange paramCMTimeRange)
  {
    if ((paramCMTimeRange != null) && (paramCMTimeRange.getDurationUs() > 0L))
    {
      if (this.segments.size() == 0) {
        return;
      }
      CMTime localCMTime2 = paramCMTimeRange.getStart();
      CMTime localCMTime1 = paramCMTimeRange.getEnd();
      int k = findSegmentIndexAt(localCMTime2, false);
      if (k == -1) {
        return;
      }
      int j = findSegmentIndexAt(localCMTime1, false);
      int i;
      if (j == -1)
      {
        i = this.segments.size() - 1;
      }
      else
      {
        i = j;
        if (getSegmentStartTime(j) == localCMTime1) {
          i = j - 1;
        }
      }
      CMTime localCMTime3 = getSegmentStartTime(k);
      localCMTime2 = getSegmentStartTime(i);
      DecoderTrackSegment localDecoderTrackSegment1 = getSegment(k);
      DecoderTrackSegment localDecoderTrackSegment2 = getSegment(i);
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
      if (getSegmentStartTime(i + 1).smallThan(paramCMTimeRange.getEnd()))
      {
        paramCMTimeRange = new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1.sub(localDecoderTrackSegment2.getScaledDuration().add(localCMTime2))), null);
        this.segments.add(paramCMTimeRange);
      }
    }
  }
  
  private IVideoDecoder createDecoder(@NonNull DecoderTrackSegment paramDecoderTrackSegment, CMTime paramCMTime)
  {
    try
    {
      localDecoderAssetTrack = paramDecoderTrackSegment.getVideoAsset();
      if (localDecoderAssetTrack == null) {
        return null;
      }
      localObject1 = TAG;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("createDecoder - ");
      ((StringBuilder)???).append(localDecoderAssetTrack.assetPath);
      ((StringBuilder)???).append(" - ");
      localObject3 = this.surfaceCreator;
      bool3 = false;
      bool2 = false;
      if (localObject3 == null) {
        break label881;
      }
      bool1 = true;
    }
    finally
    {
      for (;;)
      {
        DecoderAssetTrack localDecoderAssetTrack;
        Object localObject1;
        Object localObject3;
        boolean bool3;
        boolean bool2;
        int i;
        for (;;)
        {
          label690:
          label854:
          throw paramDecoderTrackSegment;
        }
        label881:
        boolean bool1 = false;
      }
    }
    ((StringBuilder)???).append(bool1);
    Logger.i((String)localObject1, ((StringBuilder)???).toString());
    localObject1 = null;
    i = 5;
    while ((localObject1 == null) && (i > 0))
    {
      i -= 1;
      int j;
      if (this.decoderCreateThread != null)
      {
        j = VideoDecoderTrack.DecoderCreateThread.access$100(this.decoderCreateThread);
        if ((j < this.segments.size()) && (ExtractorUtils.isSameExtractor(getSegment(j).getVideoAsset(), localDecoderAssetTrack)))
        {
          ??? = TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("check  decoder 1 - ");
          ((StringBuilder)localObject3).append(localDecoderAssetTrack.assetPath);
          Logger.i((String)???, ((StringBuilder)localObject3).toString());
          synchronized (this.nextDecoderLock)
          {
            if ((this.nextDecoder != null) && (ExtractorUtils.isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack)) && (this.nextDecoder.decoder != null))
            {
              paramCMTime = this.nextDecoder.decoder;
              if (getSegment(this.nextDecoder.segmentIndex) != paramDecoderTrackSegment) {
                paramCMTime.start(paramDecoderTrackSegment.getTimeRange(), paramDecoderTrackSegment.getDecoderStartTime());
              }
              this.nextDecoder = null;
              paramDecoderTrackSegment = TAG;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("hint decoder - ");
              bool1 = bool2;
              if (this.surfaceCreator == null) {
                bool1 = true;
              }
              ((StringBuilder)localObject1).append(bool1);
              ((StringBuilder)localObject1).append("  ");
              ((StringBuilder)localObject1).append(paramCMTime.getSourcePath());
              Logger.i(paramDecoderTrackSegment, ((StringBuilder)localObject1).toString());
              return paramCMTime;
            }
          }
        }
      }
      else
      {
        ??? = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("check  decoder - ");
        ((StringBuilder)localObject3).append(localDecoderAssetTrack.assetPath);
        Logger.i((String)???, ((StringBuilder)localObject3).toString());
        if ((this.nextDecoder != null) && (ExtractorUtils.isSameExtractor(this.nextDecoder.extractor, localDecoderAssetTrack)) && (this.nextDecoder.decoder != null)) {
          synchronized (this.nextDecoderLock)
          {
            if ((this.nextDecoder != null) && (this.nextDecoder.extractor == localDecoderAssetTrack) && (this.nextDecoder.decoder != null))
            {
              paramCMTime = this.nextDecoder.decoder;
              if (getSegment(this.nextDecoder.segmentIndex) != paramDecoderTrackSegment) {
                paramCMTime.start(paramDecoderTrackSegment.getTimeRange(), paramDecoderTrackSegment.getDecoderStartTime());
              }
              this.nextDecoder = null;
              paramDecoderTrackSegment = TAG;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("hint decoder - ");
              bool1 = bool3;
              if (this.surfaceCreator == null) {
                bool1 = true;
              }
              ((StringBuilder)localObject1).append(bool1);
              ((StringBuilder)localObject1).append("  ");
              ((StringBuilder)localObject1).append(paramCMTime.getSourcePath());
              Logger.i(paramDecoderTrackSegment, ((StringBuilder)localObject1).toString());
              return paramCMTime;
            }
          }
        }
      }
      try
      {
        if (this.surfaceCreator != null)
        {
          ??? = localDecoderAssetTrack.size;
          j = localDecoderAssetTrack.preferRotation;
          if (??? != null)
          {
            ??? = this.surfaceCreator.createOutputSurface((int)((CGSize)???).width, (int)((CGSize)???).height, j);
            break label690;
          }
        }
        ??? = null;
        try
        {
          localObject3 = createVideoDecoder(newDecoderParams(localDecoderAssetTrack, (Surface)???), paramDecoderTrackSegment);
          if (localObject3 != null)
          {
            localObject1 = localObject3;
            ((IVideoDecoder)localObject3).start(paramDecoderTrackSegment.getTimeRange(), paramCMTime);
          }
          localObject1 = localObject3;
          String str = TAG;
          localObject1 = localObject3;
          StringBuilder localStringBuilder = new StringBuilder();
          localObject1 = localObject3;
          localStringBuilder.append("createDecoder new Decoder success - ");
          localObject1 = localObject3;
          localStringBuilder.append(localDecoderAssetTrack.assetPath);
          localObject1 = localObject3;
          Logger.i(str, localStringBuilder.toString());
          localObject1 = localObject3;
        }
        catch (Exception localException2) {}
        Logger.e(TAG, " createDecoder:", localException3);
      }
      catch (Exception localException3)
      {
        ??? = null;
      }
      free((Surface)???);
      if (localObject1 != null) {}
      try
      {
        try
        {
          ((IVideoDecoder)localObject1).release(true);
          free(((IVideoDecoder)localObject1).outputSurface());
        }
        finally {}
      }
      catch (Exception localException1)
      {
        break label854;
      }
      localObject1 = null;
    }
    return localObject1;
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
        return;
      }
    }
    catch (Exception paramDecoderAssetTrack)
    {
      Logger.e(TAG, "createNextDecoder: try start DecoderCreateThread", paramDecoderAssetTrack);
    }
  }
  
  private void createNextDecoder(int paramInt)
  {
    Object localObject = this.segments;
    if (localObject != null)
    {
      if (!PRE_READ) {
        return;
      }
      int i = paramInt + 1;
      if (i >= ((ArrayList)localObject).size()) {
        return;
      }
      if (this.decoderCreateThread == null)
      {
        localObject = getSegment(i).getVideoAsset();
        if (localObject != null)
        {
          VideoDecoderTrack.DecoderWrapper localDecoderWrapper = this.nextDecoder;
          if ((localDecoderWrapper == null) || (!ExtractorUtils.isSameExtractor(localDecoderWrapper.extractor, (DecoderAssetTrack)localObject))) {
            createDecoder((DecoderAssetTrack)localObject, i);
          }
        }
        else
        {
          localObject = this.nextDecoder;
          if ((localObject != null) && (((VideoDecoderTrack.DecoderWrapper)localObject).segmentIndex != paramInt))
          {
            this.nextDecoder.decoder.start(getSegment(paramInt).getTimeRange());
            this.nextDecoder.segmentIndex = paramInt;
          }
        }
      }
    }
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
    TextureInfo localTextureInfo;
    if (paramVideoTexture == null) {
      localTextureInfo = null;
    } else {
      localTextureInfo = paramVideoTexture.getTextureInfo();
    }
    paramCMSampleState = new CacheSampleBuffer(paramCMSampleState, localTextureInfo, paramBoolean);
    paramCMSampleState.setTexture(paramVideoTexture);
    return paramCMSampleState;
  }
  
  private CMSampleBuffer createSampleBuffer(@NonNull CMSampleState paramCMSampleState, boolean paramBoolean)
  {
    Object localObject = this.currentDecoder;
    if ((localObject instanceof VideoDecoder)) {
      return createSampleBuffer(paramCMSampleState, this.surfaceCreator.videoTextureForSurface(this._outputSurface), paramBoolean);
    }
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IVideoDecoder)localObject).getTextureInfo();
    }
    return createSampleBuffer(paramCMSampleState, (TextureInfo)localObject, paramBoolean);
  }
  
  @NonNull
  private CMSampleBuffer createSampleBuffer(boolean paramBoolean)
  {
    Object localObject = this.currentFrame;
    if (localObject != null) {
      return createSampleBuffer(this.lastSampleState, ((CMSampleBuffer)localObject).getTextureInfo(), paramBoolean);
    }
    CMSampleState localCMSampleState = this.lastSampleState;
    localObject = this.currentDecoder;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IVideoDecoder)localObject).getTextureInfo();
    }
    return createSampleBuffer(localCMSampleState, (TextureInfo)localObject, paramBoolean);
  }
  
  private IVideoDecoder createVideoDecoder(IVideoDecoder.Params paramParams, DecoderTrackSegment paramDecoderTrackSegment)
  {
    paramParams = AVDecoderFactory.getInstance().createVideoDecoder(paramParams);
    if ((SeekTimeStore.ENABLE) && ((paramParams instanceof VideoDecoder)))
    {
      boolean bool;
      if (this.index == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramDecoderTrackSegment = new VideoDecoderQuickSeekHelper(bool, paramDecoderTrackSegment, getSegmentStartTime(this.segmentIndex).getTimeUs());
      ((VideoDecoder)paramParams).setVideoDecoderSeekHelper(paramDecoderTrackSegment);
    }
    return paramParams;
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
          return paramCMTime;
        }
        if (this.segmentIndex == -1)
        {
          if (this.lastSampleState.getStateCode() >= -1L) {
            paramCMTime = createSampleBuffer(-1L);
          } else {
            paramCMTime = createSampleBuffer(-100L);
          }
          return paramCMTime;
        }
        localObject2 = getCurrentSegment();
        localObject1 = CMSampleState.fromError(-1L);
        i = 0;
        logVerbose("doReadSample: step 2 ");
        localObject3 = this.currentDecoder;
        bool = true;
        if (localObject3 == null)
        {
          this.lastSampleState = new CMSampleState(this.lastSampleState.getTime().add(this.frameDuration));
          localObject3 = this.currentSegmentStartTime.add(((DecoderTrackSegment)localObject2).getScaledDuration());
          if (this.lastSampleState.getTime().smallThan((CMTime)localObject3))
          {
            if (this.surfaceCreator == null)
            {
              paramCMTime = createSampleBuffer(this.lastSampleState);
              return paramCMTime;
            }
            paramCMTime = createSampleBuffer(this.lastSampleState, this.surfaceCreator.videoTextureForSurface(this._outputSurface), false);
            return paramCMTime;
          }
        }
        else
        {
          localObject1 = paramCMTime.sub(this.currentSegmentStartTime).multi(this._speed).limitMin(CMTime.CMTimeZero);
          if ((float)((CMTime)localObject1).getTimeUs() > (float)((DecoderTrackSegment)localObject2).getScaledDuration().getTimeUs() * this._speed)
          {
            localObject1 = CMSampleState.fromError(-1L);
          }
          else
          {
            localObject1 = ((CMTime)localObject1).add(((DecoderTrackSegment)localObject2).getDecoderStartTime());
            ((CMTime)localObject1).setFlag(paramCMTime.getFlag());
            if (this.currentDecoder == null) {
              localObject1 = CMSampleState.fromError(-100L);
            } else {
              localObject1 = this.currentDecoder.readSample((CMTime)localObject1);
            }
          }
        }
      }
      finally
      {
        Object localObject2;
        Object localObject1;
        Object localObject3;
        boolean bool;
        continue;
        throw paramCMTime;
        continue;
        int i = 1;
        continue;
        paramBoolean = false;
        continue;
      }
      if ((!((CMSampleState)localObject1).stateMatchingTo(new long[] { -1L })) && (!((CMSampleState)localObject1).getTime().bigThan(((DecoderTrackSegment)localObject2).getTimeRange().getDuration())))
      {
        if (((CMSampleState)localObject1).getStateCode() >= 0L)
        {
          logVerbose("doReadSample: step 3 ");
          localObject3 = ((CMSampleState)localObject1).getTime().sub(((DecoderTrackSegment)localObject2).getDecoderStartTime());
          localObject1 = localObject3;
          if (((CMTime)localObject3).bigThan(((DecoderTrackSegment)localObject2).getTimeRange().getDuration())) {
            localObject1 = ((DecoderTrackSegment)localObject2).getTimeRange().getDuration();
          }
          localObject1 = new CMSampleState(this.currentSegmentStartTime.add(((CMTime)localObject1).divide(this._speed)));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("readSample: currentTime = ");
          ((StringBuilder)localObject2).append(paramCMTime);
          ((StringBuilder)localObject2).append("  sampleState = ");
          ((StringBuilder)localObject2).append(localObject1);
          logVerbose(((StringBuilder)localObject2).toString());
          paramCMTime = createSampleBuffer((CMSampleState)localObject1, true);
          return paramCMTime;
        }
        if (!((CMSampleState)localObject1).stateMatchingTo(new long[] { -3L }))
        {
          paramCMTime = createSampleBuffer(this.lastSampleState);
          return paramCMTime;
        }
        paramCMTime = createSampleBuffer((CMSampleState)localObject1);
        return paramCMTime;
      }
      if (((DecoderTrackSegment)localObject2).getScaledDuration().add(this.currentSegmentStartTime).sub(this.frameDuration).bigThan(paramCMTime))
      {
        if ((i == 0) || (this.currentDecoder == null) || (!this.currentDecoder.isLastFrameValid())) {
          continue;
        }
        paramBoolean = bool;
        paramCMTime = createSampleBuffer(new CMSampleState(paramCMTime), paramBoolean);
        return paramCMTime;
      }
      if (paramBoolean)
      {
        Logger.d(TAG, "async read finish , skip it!");
        return null;
      }
      if (!nextSegment(true))
      {
        if (DELAY_RELEASE_DECODER_ON_PLAY_FINISH) {
          freeCurrentDecoder();
        }
        paramCMTime = createSampleBuffer(CMSampleState.fromError(-1L), false);
        return paramCMTime;
      }
      localObject2 = getCurrentSegment();
    }
  }
  
  private void doReleaseCurrentDecoder()
  {
    IVideoDecoder localIVideoDecoder = this.currentDecoder;
    if (localIVideoDecoder != null)
    {
      if (localIVideoDecoder.getSourcePath() == null) {
        return;
      }
      localIVideoDecoder = this.currentDecoder;
      this.currentDecoder = null;
      if ((localIVideoDecoder instanceof ImageDecoder))
      {
        localIVideoDecoder.release(true);
        return;
      }
      ThreadPool.execute(new VideoDecoderTrack.2(this, localIVideoDecoder));
    }
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    CMTime localCMTime1 = CMTime.CMTimeZero;
    Iterator localIterator = this.segments.iterator();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (!localIterator.hasNext()) {
        break;
      }
      CMTime localCMTime2 = ((DecoderTrackSegment)localIterator.next()).getScaledDuration();
      if ((paramCMTime.compare(localCMTime1) >= 0) && (paramCMTime.smallThan(localCMTime1.add(localCMTime2))))
      {
        j = 1;
        break;
      }
      localCMTime1 = localCMTime1.add(localCMTime2);
      i += 1;
    }
    int m = j;
    k = i;
    if (j == 0)
    {
      m = j;
      k = i;
      if (paramCMTime.equalsTo(localCMTime1))
      {
        m = j;
        k = i;
        if (i > 0)
        {
          m = j;
          k = i;
          if (paramBoolean)
          {
            k = i - 1;
            m = 1;
          }
        }
      }
    }
    if (m != 0) {
      return k;
    }
    return -1;
  }
  
  private void free(Surface paramSurface)
  {
    if (paramSurface != null) {
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
  }
  
  private void freeCurrentDecoder()
  {
    checkReleaseDelayDecoder();
    this.delayReleaseDecoder = this.currentDecoder;
    this.currentDecoder = null;
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
  
  private boolean needSwitchNextFrame(@Nullable CMSampleBuffer paramCMSampleBuffer1, CMSampleBuffer paramCMSampleBuffer2, @NonNull CMTime paramCMTime)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramCMSampleBuffer1 != null)
    {
      bool1 = bool2;
      if (paramCMSampleBuffer1.getTextureInfo() != null)
      {
        bool1 = bool2;
        if (!paramCMSampleBuffer1.getTextureInfo().isReleased())
        {
          bool1 = bool2;
          if (paramCMSampleBuffer2 != null)
          {
            if (paramCMSampleBuffer2.getTime().smallThan(CMTime.CMTimeZero)) {
              return true;
            }
            long l = paramCMSampleBuffer2.getTime().getTimeUs();
            if (Math.abs(paramCMTime.getTimeUs()) >= Math.abs(l)) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  @NotNull
  private IVideoDecoder.Params newDecoderParams(DecoderAssetTrack paramDecoderAssetTrack, Surface paramSurface)
  {
    IVideoDecoder.Params localParams = new IVideoDecoder.Params();
    localParams.sourceType = paramDecoderAssetTrack.sourceType;
    localParams.filePath = paramDecoderAssetTrack.assetPath;
    localParams.outputSize = ImageDecoder.IMAGE_DECODE_SIZE;
    localParams.outputSurface = paramSurface;
    localParams.extraInfo = paramDecoderAssetTrack.extraInfo;
    paramDecoderAssetTrack = this.surfaceCreator;
    if (paramDecoderAssetTrack != null) {
      localParams.videoTexture = paramDecoderAssetTrack.videoTextureForSurface(paramSurface);
    }
    return localParams;
  }
  
  private boolean nextSegment(boolean paramBoolean)
  {
    ??? = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("nextSegment:");
    ((StringBuilder)localObject2).append(paramBoolean);
    Logger.d((String)???, ((StringBuilder)localObject2).toString());
    this.segmentIndex += 1;
    this._outputSurface = null;
    int i = this.segmentIndex;
    int j = this.segments.size();
    boolean bool = false;
    if (i >= j)
    {
      this.segmentIndex = -1;
      return false;
    }
    this.currentSegmentStartTime = getSegmentStartTime(this.segmentIndex);
    this.lastSampleState = new CMSampleState(this.currentSegmentStartTime);
    localObject2 = getCurrentSegment();
    if (((DecoderTrackSegment)localObject2).getVideoAsset() != null)
    {
      releaseCurrentDecoder();
      if (paramBoolean) {
        ??? = getCurrentSegment().getDecoderStartTime();
      } else {
        ??? = CMTime.CMTimeInvalid;
      }
      IVideoDecoder localIVideoDecoder = createDecoder((DecoderTrackSegment)localObject2, (CMTime)???);
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
      }
    }
    Logger.d(TAG, "nextSegment: videoAsset is null");
    releaseCurrentDecoder();
    if (localObject3.getScaledDuration().getTimeUs() > 0L) {
      this._speed = ((float)localObject3.getTimeRange().getDurationUs() * 1.0F / (float)localObject3.getScaledDuration().getTimeUs());
    }
    ??? = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nextSegment:");
    paramBoolean = bool;
    if (this.currentDecoder == null) {
      paramBoolean = true;
    }
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ");
    localStringBuilder.append(this._speed);
    Logger.d((String)???, localStringBuilder.toString());
    return true;
  }
  
  private void release(Surface paramSurface)
  {
    if (paramSurface != null) {
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
    Object localObject = this.nextFrame;
    if (localObject == null) {
      return null;
    }
    this.currentFrame = createSampleBuffer(((CMSampleBuffer)localObject).getState(), this.nextFrame.getTextureInfo(), this.nextFrame.isNewFrame());
    if (this.nextFrame.isNewFrame())
    {
      localObject = this.nextFrame;
      if ((localObject instanceof CacheSampleBuffer))
      {
        localObject = ((CacheSampleBuffer)localObject).getTexture();
        if ((localObject != null) && (!Thread.currentThread().getName().equals("VideoDecoder")))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("readSample: awaitNewImage: ");
          localStringBuilder.append(this.nextFrame.getTime());
          logVerbose(localStringBuilder.toString());
          try
          {
            ((VideoTexture)localObject).awaitNewImage();
          }
          catch (Throwable localThrowable)
          {
            Logger.e(TAG, "readSample: videoTexture.awaitNewImage() error", localThrowable);
            return createSampleBuffer(CMSampleState.fromError(-3L, "DecoderThread.NAME:VideoDecoder", localThrowable));
          }
        }
      }
    }
    this.nextFrame = createSampleBuffer(new CMSampleState());
    if (this.currentFrame.getTime().smallThan(CMTime.CMTimeZero))
    {
      this.lastSampleState = this.currentFrame.getState();
      return createSampleBuffer(this.currentFrame.getState());
    }
    return null;
  }
  
  private void tryReleaseDecoder(IVideoDecoder paramIVideoDecoder)
  {
    if (paramIVideoDecoder != null) {
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
  }
  
  private boolean unNeedReDecoderNextFrame(CMTime paramCMTime)
  {
    CMSampleBuffer localCMSampleBuffer = this.nextFrame;
    boolean bool = true;
    int i;
    if ((localCMSampleBuffer != null) && (localCMSampleBuffer.getTime().bigThan(paramCMTime))) {
      i = 1;
    } else {
      i = 0;
    }
    paramCMTime = this.nextFrame;
    int j;
    if ((paramCMTime != null) && (this.currentFrame != null) && (paramCMTime.getTime().bigThan(this.currentFrame.getTime()))) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == 0)
    {
      if (j != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public void asyncReadNextSample(CMTime arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 788	com/tencent/tav/decoder/VideoDecoderTrack:unNeedReDecoderNextFrame	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: getfield 105	com/tencent/tav/decoder/VideoDecoderTrack:isReleased	Z
    //   19: istore_2
    //   20: iload_2
    //   21: ifeq +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: new 497	com/tencent/tav/coremedia/CMSampleBuffer
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 789	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   36: putfield 107	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   39: aload_0
    //   40: getfield 118	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   43: astore_1
    //   44: aload_1
    //   45: monitorenter
    //   46: aload_0
    //   47: getfield 118	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   50: invokevirtual 792	com/tencent/tav/decoder/VideoDecoderTrack$DecoderThread:action	()V
    //   53: aload_1
    //   54: monitorexit
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: astore_3
    //   59: aload_1
    //   60: monitorexit
    //   61: aload_3
    //   62: athrow
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	VideoDecoderTrack
    //   7	14	2	bool	boolean
    //   58	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   46	55	58	finally
    //   59	61	58	finally
    //   2	8	63	finally
    //   15	20	63	finally
    //   27	46	63	finally
    //   61	63	63	finally
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    if ((paramCMTimeRange != null) && (paramCMTimeRange.getDurationUs() > 0L))
    {
      if (this.segments.size() == 0) {
        return;
      }
      CMTime localCMTime1 = paramCMTimeRange.getStart();
      CMTime localCMTime2 = paramCMTimeRange.getEnd();
      CMTime localCMTime3 = segmentsDuration();
      clipRangeAndRemoveRange(paramCMTimeRange);
      if (localCMTime1.getValue() != 0L) {
        this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, localCMTime1), null));
      }
      if (localCMTime2.getTimeUs() < localCMTime3.getTimeUs()) {
        this.segments.add(new DecoderTrackSegment(new CMTimeRange(localCMTime2, new CMTime(localCMTime3.getTimeSeconds() - localCMTime2.getTimeSeconds())), null));
      }
    }
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
  
  public CMSampleBuffer readCurrentSample()
  {
    return createSampleBuffer(false);
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("readSample: start expectFrameTime = ");
    ((StringBuilder)localObject1).append(paramCMTime);
    logVerbose(((StringBuilder)localObject1).toString());
    if (this.isReleased)
    {
      releaseCurrentDecoder();
      return createSampleBuffer(CMSampleState.fromError(-100L));
    }
    if (paramCMTime.bigThan(getDuration()))
    {
      if (DELAY_RELEASE_DECODER_ON_PLAY_FINISH) {
        freeCurrentDecoder();
      } else {
        releaseCurrentDecoder();
      }
      return createSampleBuffer(CMSampleState.fromError(-1L));
    }
    localObject1 = this.currentFrame;
    if ((localObject1 != null) && (((CMSampleBuffer)localObject1).getTime().getTimeUs() >= 0L) && (this.currentFrame.getTextureInfo() != null) && (!this.currentFrame.getTime().smallThan(paramCMTime)))
    {
      this.lastSampleState = new CMSampleState(paramCMTime);
      return createSampleBuffer(this.lastSampleState, this.currentFrame.getTextureInfo(), false);
    }
    logVerbose("readSample: step 1 ");
    localObject1 = paramCMTime.sub(this.frameDuration).add(new CMTime(1L, paramCMTime.timeScale));
    ((CMTime)localObject1).setFlag(paramCMTime.getFlag());
    if (findSegmentIndexAt(paramCMTime, false) == this.segmentIndex)
    {
      ??? = this.nextFrame;
      if ((??? != null) && (((CMSampleBuffer)???).getState().getStateCode() >= 0L) && (this.decodeType == IDecoder.DecodeType.Video)) {
        synchronized (this.nextFrameDecoderLock)
        {
          if ((this.nextFrame == null) || (this.nextFrame.getState().getStateCode() < -1L) || ((this.nextFrame.getTextureInfo() == null) && (this.nextFrame.getSampleByteBuffer() == null)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("readSample:");
            localStringBuilder.append(localObject1);
            localStringBuilder.append(" nextFrame not hit time");
            logVerbose(localStringBuilder.toString());
            this.nextFrame = doReadSample((CMTime)localObject1);
          }
        }
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("readSample:");
    ((StringBuilder)???).append(localObject1);
    ((StringBuilder)???).append(" nextFrame not hit");
    logVerbose(((StringBuilder)???).toString());
    if (findSegmentIndexAt(paramCMTime, false) != this.segmentIndex) {
      this.nextFrame = doReadSample(paramCMTime);
    } else {
      this.nextFrame = doReadSample((CMTime)localObject1);
    }
    paramCMTime = this.nextFrame.getTime();
    createNextDecoder(this.segmentIndex);
    this.lastSampleState = new CMSampleState(paramCMTime);
    boolean bool = needSwitchNextFrame(this.currentFrame, this.nextFrame, paramCMTime);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("readSample: needSwitch: ");
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append(" expectFrameTime = ");
    ((StringBuilder)localObject1).append(paramCMTime);
    ((StringBuilder)localObject1).append(" currentFrame = ");
    paramCMTime = this.currentFrame;
    if (paramCMTime == null) {
      paramCMTime = CMTime.CMTimeZero;
    } else {
      paramCMTime = paramCMTime.getTime();
    }
    ((StringBuilder)localObject1).append(paramCMTime);
    ((StringBuilder)localObject1).append("  nextFrame = ");
    ((StringBuilder)localObject1).append(this.nextFrame);
    logVerbose(((StringBuilder)localObject1).toString());
    if (bool)
    {
      paramCMTime = switchToNextFrame();
      if (paramCMTime != null) {
        return paramCMTime;
      }
    }
    checkReleaseDelayDecoder();
    return createSampleBuffer(bool);
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/tencent/tav/decoder/VideoDecoderTrack:decoderThread	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderThread;
    //   6: invokevirtual 853	com/tencent/tav/decoder/VideoDecoderTrack$DecoderThread:release	()V
    //   9: getstatic 262	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   12: astore_1
    //   13: new 372	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc_w 855
    //   25: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: aload_0
    //   31: invokevirtual 617	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_1
    //   36: aload_2
    //   37: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 629	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 105	com/tencent/tav/decoder/VideoDecoderTrack:isReleased	Z
    //   48: aload_0
    //   49: getfield 76	com/tencent/tav/decoder/VideoDecoderTrack:segments	Ljava/util/ArrayList;
    //   52: invokevirtual 858	java/util/ArrayList:clear	()V
    //   55: aload_0
    //   56: invokespecial 654	com/tencent/tav/decoder/VideoDecoderTrack:checkReleaseDelayDecoder	()V
    //   59: aload_0
    //   60: getfield 212	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   63: ifnull +31 -> 94
    //   66: aload_0
    //   67: getfield 212	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   70: iconst_1
    //   71: invokeinterface 286 2 0
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 212	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   81: invokeinterface 470 1 0
    //   86: invokespecial 860	com/tencent/tav/decoder/VideoDecoderTrack:release	(Landroid/view/Surface;)V
    //   89: aload_0
    //   90: aconst_null
    //   91: putfield 212	com/tencent/tav/decoder/VideoDecoderTrack:currentDecoder	Lcom/tencent/tav/decoder/IVideoDecoder;
    //   94: aload_0
    //   95: getfield 99	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoderLock	Ljava/lang/Object;
    //   98: astore_1
    //   99: aload_1
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   105: ifnull +15 -> 120
    //   108: aload_0
    //   109: getfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   112: invokestatic 864	com/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper:access$400	(Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;)V
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 206	com/tencent/tav/decoder/VideoDecoderTrack:nextDecoder	Lcom/tencent/tav/decoder/VideoDecoderTrack$DecoderWrapper;
    //   120: aload_1
    //   121: monitorexit
    //   122: aload_0
    //   123: getfield 109	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   126: ifnull +23 -> 149
    //   129: aload_0
    //   130: getfield 109	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   133: invokevirtual 534	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   136: ifnull +13 -> 149
    //   139: aload_0
    //   140: getfield 109	com/tencent/tav/decoder/VideoDecoderTrack:currentFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   143: invokevirtual 534	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   146: invokevirtual 865	com/tencent/tav/coremedia/TextureInfo:release	()V
    //   149: aload_0
    //   150: getfield 107	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   153: ifnull +39 -> 192
    //   156: aload_0
    //   157: getfield 107	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   160: instanceof 513
    //   163: ifeq +29 -> 192
    //   166: aload_0
    //   167: getfield 107	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   170: checkcast 513	com/tencent/tav/decoder/CacheSampleBuffer
    //   173: invokevirtual 749	com/tencent/tav/decoder/CacheSampleBuffer:getTexture	()Lcom/tencent/tav/decoder/VideoTexture;
    //   176: ifnull +16 -> 192
    //   179: aload_0
    //   180: getfield 107	com/tencent/tav/decoder/VideoDecoderTrack:nextFrame	Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   183: checkcast 513	com/tencent/tav/decoder/CacheSampleBuffer
    //   186: invokevirtual 749	com/tencent/tav/decoder/CacheSampleBuffer:getTexture	()Lcom/tencent/tav/decoder/VideoTexture;
    //   189: invokevirtual 866	com/tencent/tav/decoder/VideoTexture:release	()V
    //   192: getstatic 262	com/tencent/tav/decoder/VideoDecoderTrack:TAG	Ljava/lang/String;
    //   195: ldc_w 868
    //   198: invokestatic 629	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_0
    //   202: monitorexit
    //   203: return
    //   204: astore_2
    //   205: aload_1
    //   206: monitorexit
    //   207: aload_2
    //   208: athrow
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	VideoDecoderTrack
    //   209	4	1	localObject2	Object
    //   20	17	2	localStringBuilder	StringBuilder
    //   204	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   101	120	204	finally
    //   120	122	204	finally
    //   205	207	204	finally
    //   2	94	209	finally
    //   94	101	209	finally
    //   122	149	209	finally
    //   149	192	209	finally
    //   192	201	209	finally
    //   207	209	209	finally
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("seekTo:[time ");
    ((StringBuilder)???).append(paramCMTime);
    ((StringBuilder)???).append("] [needRead ");
    ((StringBuilder)???).append(paramBoolean1);
    ((StringBuilder)???).append("] [quickSeek ");
    ((StringBuilder)???).append(paramBoolean2);
    ((StringBuilder)???).append("]");
    logVerbose(((StringBuilder)???).toString());
    for (;;)
    {
      synchronized (this.nextFrameDecoderLock)
      {
        this.currentFrame = null;
        this.nextFrame = null;
        try
        {
          if ((this.started) && (!this.isReleased))
          {
            int i = findSegmentIndexAt(paramCMTime, true);
            if (i == -1)
            {
              this.segmentIndex = -1;
              paramCMTime = TAG;
              ??? = new StringBuilder();
              ((StringBuilder)???).append("seekTo: [failed] [index ");
              ((StringBuilder)???).append(i);
              ((StringBuilder)???).append("]");
              Logger.w(paramCMTime, ((StringBuilder)???).toString());
              return null;
            }
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
            if (paramCMTime.bigThan(this.frameDuration)) {
              this.lastSampleState = new CMSampleState(paramCMTime.sub(this.frameDuration));
            } else {
              this.lastSampleState = new CMSampleState(paramCMTime);
            }
            if (paramBoolean1)
            {
              paramCMTime = readSample();
              this.currentFrame = null;
              this.nextFrame = null;
              ??? = new StringBuilder();
              ((StringBuilder)???).append("seekTo: [success] [lastSampleState ");
              ((StringBuilder)???).append(this.lastSampleState);
              ((StringBuilder)???).append("] [sampleBuffer ");
              ((StringBuilder)???).append(paramCMTime);
              ((StringBuilder)???).append("]");
              logVerbose(((StringBuilder)???).toString());
              return paramCMTime;
            }
          }
          else
          {
            paramCMTime = TAG;
            ??? = new StringBuilder();
            ((StringBuilder)???).append("seekTo: [failed] [started ");
            ((StringBuilder)???).append(this.started);
            ((StringBuilder)???).append("] [isReleased ");
            ((StringBuilder)???).append(this.isReleased);
            ((StringBuilder)???).append("]");
            Logger.e(paramCMTime, ((StringBuilder)???).toString(), new RuntimeException());
            return null;
          }
        }
        finally {}
      }
      paramCMTime = null;
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
  
  public void setTrackIndex(int paramInt)
  {
    this.index = paramInt;
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
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoDecoderTrack start:");
    localStringBuilder.append(paramCMTimeRange);
    Logger.d(str, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack
 * JD-Core Version:    0.7.0.1
 */