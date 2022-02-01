package com.tencent.tav.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AssetReaderVideoCompositionOutput
  extends AssetReaderOutput
{
  private AssetExtension assetExtension;
  private AssetReader assetReader;
  private IContextCreate contextCreate;
  @Nullable
  private VideoCompositing customVideoCompositor = new VideoCompositor();
  private boolean decoderStarted = false;
  private int frameRate = -1;
  private boolean revertMode = false;
  private VideoCompositing videoCompositing;
  @Nullable
  private VideoComposition videoComposition;
  private IDecoderTrack videoDecoderTrack;
  @Nullable
  private Map<String, Object> videoSettings;
  private List<AssetTrack> videoTracks;
  
  public AssetReaderVideoCompositionOutput(List<AssetTrack> paramList, Map<String, Object> paramMap, AssetExtension paramAssetExtension)
  {
    this.videoTracks = paramList;
    this.videoSettings = paramMap;
    this.assetExtension = paramAssetExtension;
    this.mediaType = 1;
    if ((paramMap != null) && (paramMap.containsKey("frame-rate"))) {
      this.frameRate = ((Integer)paramMap.get("frame-rate")).intValue();
    }
  }
  
  private void tryStartDecoder()
  {
    if (!this.decoderStarted)
    {
      this.decoderStarted = true;
      this.videoDecoderTrack.setFrameRate(this.frameRate);
      Object localObject1 = this.contextCreate;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((IContextCreate)localObject1).renderContext();
      }
      Object localObject2 = this.assetReader;
      if ((localObject2 != null) && (((AssetReader)localObject2).getTimeRange() != null))
      {
        localObject2 = this.assetReader.getTimeRange().getStart();
        if (((CMTime)localObject2).equals(CMTime.CMTimeZero))
        {
          this.videoDecoderTrack.start((IDecoderTrack.SurfaceCreator)localObject1, this.assetReader.getTimeRange());
          return;
        }
        this.videoDecoderTrack.start((IDecoderTrack.SurfaceCreator)localObject1);
        this.videoDecoderTrack.seekTo((CMTime)localObject2, false, false);
        return;
      }
      this.videoDecoderTrack.start((IDecoderTrack.SurfaceCreator)localObject1);
    }
  }
  
  @Nullable
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  @Nullable
  public Map<String, Object> getVideoSettings()
  {
    return this.videoSettings;
  }
  
  public List<AssetTrack> getVideoTracks()
  {
    return this.videoTracks;
  }
  
  public void markConfigurationAsFinal() {}
  
  @NonNull
  public CMSampleBuffer nextSampleBuffer()
  {
    try
    {
      if (this.videoDecoderTrack != null)
      {
        tryStartDecoder();
        if (this.videoDecoderTrack == null) {
          localCMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-100L));
        } else {
          localCMSampleBuffer = this.videoDecoderTrack.readSample();
        }
        if (localCMSampleBuffer.getTime().getTimeUs() >= 0L) {
          this.videoDecoderTrack.asyncReadNextSample(localCMSampleBuffer.getTime());
        }
        return localCMSampleBuffer;
      }
      CMSampleBuffer localCMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-100L));
      return localCMSampleBuffer;
    }
    finally {}
  }
  
  void release()
  {
    try
    {
      if (this.videoDecoderTrack != null) {
        this.videoDecoderTrack.release();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void resetForReadingTimeRanges(List<CMTimeRange> paramList) {}
  
  public void setVideoCompositing(VideoCompositing paramVideoCompositing)
  {
    this.videoCompositing = paramVideoCompositing;
  }
  
  public void setVideoComposition(@Nullable VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
  
  public void setVideoRevertMode(boolean paramBoolean)
  {
    this.revertMode = paramBoolean;
  }
  
  void start(@Nullable IContextCreate paramIContextCreate, AssetReader paramAssetReader)
  {
    this.assetReader = paramAssetReader;
    paramAssetReader = new VideoCompositionDecoderTrack(paramAssetReader.getAsset(), this.assetExtension, 1);
    int i = this.frameRate;
    Iterator localIterator = this.videoTracks.iterator();
    while (localIterator.hasNext())
    {
      AssetTrack localAssetTrack = (AssetTrack)localIterator.next();
      if ((localAssetTrack != null) && (localAssetTrack.isEnabled()))
      {
        paramAssetReader.addTrack(localAssetTrack);
        if ((localAssetTrack.getNominalFrameRate() > 0.0F) && (this.frameRate < 0)) {
          i = (int)Math.min(localAssetTrack.getNominalFrameRate(), i);
        }
      }
    }
    if (i <= 0) {
      i = 30;
    }
    paramAssetReader.setVideoComposition(this.videoComposition);
    paramAssetReader.setVideoCompositing(this.videoCompositing);
    paramAssetReader.setFrameRate(i);
    paramAssetReader.setFrameDuration(new CMTime(1L, i));
    this.contextCreate = paramIContextCreate;
    if (this.revertMode)
    {
      this.videoDecoderTrack = new CachedVideoDecoderTrack(paramAssetReader, true);
      return;
    }
    this.videoDecoderTrack = paramAssetReader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderVideoCompositionOutput
 * JD-Core Version:    0.7.0.1
 */