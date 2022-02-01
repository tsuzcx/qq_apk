package com.tencent.tav.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.VideoDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoCompositionDecoderTrack
  implements IDecoderTrack
{
  private static final String TAG = "VideoComDecoderTrack";
  private static final int WAIT_TIME = 200;
  private Asset asset;
  private AssetExtension assetExtension;
  private List<AssetTrack> assetTrackList = new ArrayList();
  private boolean asynced = true;
  private List<IDecoderTrack> decoderTrackList = new ArrayList();
  private CMTime frameDuration = new CMTime(1L, 30);
  private int frameRate = 30;
  private CMSampleState lastSampleState = new CMSampleState();
  private VideoCompositionRenderContext renderContext;
  private int trackId;
  private VideoCompositing videoCompositing;
  private VideoComposition videoComposition;
  
  public VideoCompositionDecoderTrack(Asset paramAsset, AssetExtension paramAssetExtension, int paramInt)
  {
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    this.trackId = paramInt;
  }
  
  @NonNull
  private AsynchronousVideoCompositionRequest createVideoCompositionRequest(CMTime paramCMTime)
  {
    AsynchronousVideoCompositionRequest localAsynchronousVideoCompositionRequest = new AsynchronousVideoCompositionRequest(this, this.assetExtension);
    localAsynchronousVideoCompositionRequest.setRenderContext(this.renderContext);
    localAsynchronousVideoCompositionRequest.setCompositionTime(paramCMTime);
    VideoComposition localVideoComposition = this.videoComposition;
    if (localVideoComposition != null) {
      localAsynchronousVideoCompositionRequest.setVideoCompositionInstruction(VideoComposition.findInstruction(localVideoComposition, paramCMTime));
    }
    return localAsynchronousVideoCompositionRequest;
  }
  
  private CMSampleBuffer getSampleFromRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    try
    {
      if (paramAsynchronousVideoCompositionRequest.getStatus() == -2147483648) {
        waitForRequestFinish(200);
      }
      if (paramAsynchronousVideoCompositionRequest.getStatus() != 0)
      {
        this.lastSampleState = CMSampleState.fromError(-3L);
        paramAsynchronousVideoCompositionRequest = new StringBuilder();
        paramAsynchronousVideoCompositionRequest.append("readSample: failed 1 ");
        paramAsynchronousVideoCompositionRequest.append(this.lastSampleState);
        Logger.e("VideoComDecoderTrack", paramAsynchronousVideoCompositionRequest.toString());
        return new CMSampleBuffer(CMSampleState.fromError(-3L));
      }
      this.lastSampleState = paramAsynchronousVideoCompositionRequest.getComposedSampleBuffer().getState();
      return paramAsynchronousVideoCompositionRequest.getComposedSampleBuffer();
    }
    finally {}
  }
  
  @Nullable
  private CMSampleBuffer readSampleToRequest(CMTime paramCMTime, AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext())
    {
      IDecoderTrack localIDecoderTrack = (IDecoderTrack)localIterator.next();
      CMSampleBuffer localCMSampleBuffer = localIDecoderTrack.readSample(paramCMTime);
      if (localCMSampleBuffer.getState().stateMatchingTo(new long[] { -3L, -2L, -100L }))
      {
        this.lastSampleState = new CMSampleState(localCMSampleBuffer.getTime());
        paramCMTime = new StringBuilder();
        paramCMTime.append("readSample: failed 0 ");
        paramCMTime.append(localCMSampleBuffer.getTime());
        Logger.e("VideoComDecoderTrack", paramCMTime.toString());
        return new CMSampleBuffer(localCMSampleBuffer.getState(), (TextureInfo)null);
      }
      if (localCMSampleBuffer.getState().stateMatchingTo(new long[] { -1L }))
      {
        if (this.decoderTrackList.size() <= 1)
        {
          Logger.d("VideoComDecoderTrack", "readSample: finish 1");
          return localCMSampleBuffer;
        }
      }
      else {
        paramAsynchronousVideoCompositionRequest.appendCMSampleBuffer(localCMSampleBuffer, localIDecoderTrack.getTrackId());
      }
    }
    return null;
  }
  
  /* Error */
  private void waitForRequestFinish(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: i2l
    //   4: lstore_2
    //   5: aload_0
    //   6: lload_2
    //   7: invokevirtual 221	java/lang/Object:wait	(J)V
    //   10: goto +15 -> 25
    //   13: astore 4
    //   15: goto +13 -> 28
    //   18: astore 4
    //   20: aload 4
    //   22: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: monitorexit
    //   30: aload 4
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	VideoCompositionDecoderTrack
    //   0	33	1	paramInt	int
    //   4	3	2	l	long
    //   13	1	4	localObject	Object
    //   18	13	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	10	13	finally
    //   20	25	13	finally
    //   25	27	13	finally
    //   28	30	13	finally
    //   5	10	18	java/lang/Exception
  }
  
  public void addTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      this.assetTrackList.add(paramAssetTrack);
      return;
    }
    finally
    {
      paramAssetTrack = finally;
      throw paramAssetTrack;
    }
  }
  
  public void asyncReadNextSample(CMTime paramCMTime)
  {
    if (!this.asynced) {
      return;
    }
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).asyncReadNextSample(paramCMTime);
    }
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).clipRangeAndClearRange(paramCMTimeRange);
    }
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleState.getTime();
  }
  
  public CMTime getDuration()
  {
    Object localObject = CMTime.CMTimeZero;
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext())
    {
      CMTime localCMTime = ((IDecoderTrack)localIterator.next()).getDuration();
      if (localCMTime.bigThan((CMTime)localObject)) {
        localObject = localCMTime;
      }
    }
    return localObject;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public int getFrameRate()
  {
    return this.frameRate;
  }
  
  public VideoCompositionRenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public int getTrackId()
  {
    return this.trackId;
  }
  
  public VideoCompositing getVideoCompositing()
  {
    return this.videoCompositing;
  }
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  public CMSampleBuffer readSample()
  {
    if ((!this.lastSampleState.stateMatchingTo(new long[] { -100L })) && (!this.lastSampleState.isInvalid())) {
      return readSample(this.lastSampleState.getTime().add(this.frameDuration));
    }
    return readSample(CMTime.CMTimeZero);
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("readSample:[targetTime ");
    ((StringBuilder)localObject).append(paramCMTime);
    ((StringBuilder)localObject).append("]");
    ((StringBuilder)localObject).append(this.videoCompositing);
    Logger.v("VideoComDecoderTrack", ((StringBuilder)localObject).toString());
    if (this.videoCompositing == null)
    {
      this.lastSampleState = CMSampleState.fromError(-3L);
      paramCMTime = new StringBuilder();
      paramCMTime.append("readSample: failed 2 ");
      paramCMTime.append(this.lastSampleState);
      Logger.v("VideoComDecoderTrack", paramCMTime.toString());
      return new CMSampleBuffer(CMSampleState.fromError(-3L));
    }
    localObject = paramCMTime;
    if (paramCMTime.getValue() < 0L) {
      localObject = this.lastSampleState.getTime().add(this.frameDuration);
    }
    paramCMTime = createVideoCompositionRequest((CMTime)localObject);
    localObject = readSampleToRequest((CMTime)localObject, paramCMTime);
    if (localObject != null) {
      return localObject;
    }
    if (paramCMTime.getSourceTrackIDs().size() == 0)
    {
      Logger.v("VideoComDecoderTrack", "readSample: finish 2");
      return new CMSampleBuffer(CMSampleState.fromError(-1L));
    }
    Logger.v("VideoComDecoderTrack", "readSample: startVideoCompositionRequest ");
    this.videoCompositing.startVideoCompositionRequest(paramCMTime);
    Logger.v("VideoComDecoderTrack", "readSample: startVideoCompositionRequest finish ");
    return getSampleFromRequest(paramCMTime);
  }
  
  public void release()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release:start ");
    ((StringBuilder)localObject).append(this);
    Logger.d("VideoComDecoderTrack", ((StringBuilder)localObject).toString());
    localObject = this.decoderTrackList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IDecoderTrack)((Iterator)localObject).next()).release();
    }
    this.decoderTrackList.clear();
    this.assetTrackList.clear();
    this.videoComposition = null;
    this.videoCompositing = null;
    this.renderContext = null;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release:finish ");
    ((StringBuilder)localObject).append(this);
    Logger.d("VideoComDecoderTrack", ((StringBuilder)localObject).toString());
  }
  
  public void removeTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      this.assetTrackList.remove(paramAssetTrack);
      return;
    }
    finally
    {
      paramAssetTrack = finally;
      throw paramAssetTrack;
    }
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seekTo:[timeUs ");
    ((StringBuilder)localObject).append(paramCMTime);
    ((StringBuilder)localObject).append("] [needRead ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append("] [quickSeek ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append("]");
    Logger.d("VideoComDecoderTrack", ((StringBuilder)localObject).toString());
    localObject = this.decoderTrackList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IDecoderTrack)((Iterator)localObject).next()).seekTo(paramCMTime, false, paramBoolean2);
    }
    if (paramCMTime.bigThan(this.frameDuration)) {
      this.lastSampleState = new CMSampleState(paramCMTime.sub(this.frameDuration));
    } else {
      this.lastSampleState = new CMSampleState(paramCMTime);
    }
    if (paramBoolean1) {
      return readSample();
    }
    return null;
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType) {}
  
  public void setFrameDuration(CMTime paramCMTime)
  {
    this.frameDuration = paramCMTime;
  }
  
  public void setFrameRate(int paramInt)
  {
    this.frameRate = paramInt;
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).setFrameRate(paramInt);
    }
  }
  
  public void setRenderContext(VideoCompositionRenderContext paramVideoCompositionRenderContext)
  {
    this.renderContext = paramVideoCompositionRenderContext;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList) {}
  
  public void setVideoCompositing(VideoCompositing paramVideoCompositing)
  {
    this.videoCompositing = paramVideoCompositing;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start:[start] ");
    ((StringBuilder)localObject).append(paramCMTimeRange);
    ((StringBuilder)localObject).append(" size - ");
    ((StringBuilder)localObject).append(this.assetTrackList.size());
    Logger.d("VideoComDecoderTrack", ((StringBuilder)localObject).toString());
    this.renderContext = new VideoCompositionRenderContext((RenderContext)paramSurfaceCreator);
    this.renderContext.setVideoComposition(this.videoComposition);
    Iterator localIterator = this.assetTrackList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (AssetTrack)localIterator.next();
      if (((AssetTrack)localObject).getMediaType() == 1)
      {
        VideoDecoderTrack localVideoDecoderTrack = new VideoDecoderTrack((AssetTrack)localObject);
        this.decoderTrackList.add(localVideoDecoderTrack);
        if (paramCMTimeRange != null)
        {
          localVideoDecoderTrack.start(paramSurfaceCreator, paramCMTimeRange);
        }
        else
        {
          localObject = ((AssetTrack)localObject).getTimeRange();
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = new CMTimeRange(((CMTimeRange)localObject).getStart(), ((CMTimeRange)localObject).getDuration());
          }
          localVideoDecoderTrack.start(paramSurfaceCreator, (CMTimeRange)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.VideoCompositionDecoderTrack
 * JD-Core Version:    0.7.0.1
 */