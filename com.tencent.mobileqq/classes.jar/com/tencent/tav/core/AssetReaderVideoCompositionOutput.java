package com.tencent.tav.core;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
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
    Object localObject = null;
    if (!this.decoderStarted)
    {
      this.decoderStarted = true;
      if ((this.assetReader == null) || (this.assetReader.getTimeRange() == null)) {
        break label106;
      }
    }
    label106:
    for (CMTimeRange localCMTimeRange = new CMTimeRange(this.assetReader.getTimeRange().getStart(), this.assetReader.getTimeRange().getDuration());; localCMTimeRange = null)
    {
      this.videoDecoderTrack.setFrameRate(this.frameRate);
      IDecoderTrack localIDecoderTrack = this.videoDecoderTrack;
      if (this.contextCreate == null) {}
      for (;;)
      {
        localIDecoderTrack.start((IDecoderTrack.SurfaceCreator)localObject, localCMTimeRange);
        return;
        localObject = this.contextCreate.renderContext();
      }
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
  
  /* Error */
  @android.support.annotation.NonNull
  public com.tencent.tav.coremedia.CMSampleBuffer nextSampleBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 98	com/tencent/tav/core/AssetReaderVideoCompositionOutput:videoDecoderTrack	Lcom/tencent/tav/decoder/IDecoderTrack;
    //   6: ifnull +71 -> 77
    //   9: aload_0
    //   10: invokespecial 133	com/tencent/tav/core/AssetReaderVideoCompositionOutput:tryStartDecoder	()V
    //   13: aload_0
    //   14: getfield 98	com/tencent/tav/core/AssetReaderVideoCompositionOutput:videoDecoderTrack	Lcom/tencent/tav/decoder/IDecoderTrack;
    //   17: ifnonnull +47 -> 64
    //   20: new 135	com/tencent/tav/coremedia/CMSampleBuffer
    //   23: dup
    //   24: getstatic 141	com/tencent/tav/decoder/VideoDecoder:SAMPLE_TIME_UNSTART	Lcom/tencent/tav/coremedia/CMTime;
    //   27: invokespecial 144	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   30: astore_1
    //   31: aload_1
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 147	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   37: invokevirtual 153	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   40: lconst_0
    //   41: lcmp
    //   42: iflt +18 -> 60
    //   45: aload_0
    //   46: getfield 98	com/tencent/tav/core/AssetReaderVideoCompositionOutput:videoDecoderTrack	Lcom/tencent/tav/decoder/IDecoderTrack;
    //   49: aload_1
    //   50: invokevirtual 147	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   53: invokeinterface 156 2 0
    //   58: aload_1
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: areturn
    //   64: aload_0
    //   65: getfield 98	com/tencent/tav/core/AssetReaderVideoCompositionOutput:videoDecoderTrack	Lcom/tencent/tav/decoder/IDecoderTrack;
    //   68: invokeinterface 159 1 0
    //   73: astore_1
    //   74: goto -43 -> 31
    //   77: new 135	com/tencent/tav/coremedia/CMSampleBuffer
    //   80: dup
    //   81: getstatic 141	com/tencent/tav/decoder/VideoDecoder:SAMPLE_TIME_UNSTART	Lcom/tencent/tav/coremedia/CMTime;
    //   84: invokespecial 144	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   87: astore_2
    //   88: goto -28 -> 60
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	AssetReaderVideoCompositionOutput
    //   30	44	1	localCMSampleBuffer1	com.tencent.tav.coremedia.CMSampleBuffer
    //   91	4	1	localObject	Object
    //   32	56	2	localCMSampleBuffer2	com.tencent.tav.coremedia.CMSampleBuffer
    // Exception table:
    //   from	to	target	type
    //   2	31	91	finally
    //   33	58	91	finally
    //   64	74	91	finally
    //   77	88	91	finally
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
    if (localIterator.hasNext())
    {
      AssetTrack localAssetTrack = (AssetTrack)localIterator.next();
      if ((localAssetTrack == null) || (!localAssetTrack.isEnabled())) {
        break label187;
      }
      paramAssetReader.addTrack(localAssetTrack);
      if ((localAssetTrack.getNominalFrameRate() <= 0.0F) || (this.frameRate >= 0)) {
        break label187;
      }
      i = (int)Math.min(localAssetTrack.getNominalFrameRate(), i);
    }
    label187:
    for (;;)
    {
      break;
      if (i > 0) {}
      for (;;)
      {
        paramAssetReader.setVideoComposition(this.videoComposition);
        paramAssetReader.setVideoCompositing(this.videoCompositing);
        paramAssetReader.setFrameRate(i);
        paramAssetReader.setFrameDuration(new CMTime(1L, i));
        this.contextCreate = paramIContextCreate;
        if (!this.revertMode) {
          break;
        }
        this.videoDecoderTrack = new CachedVideoDecoderTrack(paramAssetReader, true);
        return;
        i = 30;
      }
      this.videoDecoderTrack = paramAssetReader;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderVideoCompositionOutput
 * JD-Core Version:    0.7.0.1
 */