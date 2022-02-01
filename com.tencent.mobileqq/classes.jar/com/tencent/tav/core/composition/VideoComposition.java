package com.tencent.tav.core.composition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.Composition;
import com.tencent.tav.core.VideoCompositor;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VideoComposition
{
  private static final String TAG = "VideoComposition";
  private Asset asset;
  @Nullable
  private Class<? extends VideoCompositing> customVideoCompositorClass;
  private CMTime frameDuration = new CMTime(1L, 30);
  private List<? extends VideoCompositionInstruction> instructions;
  private VideoComposition.RenderLayoutMode renderLayoutMode;
  private float renderScale;
  private CGSize renderSize;
  private int sourceTrackIDForFrameTiming;
  
  public VideoComposition() {}
  
  public VideoComposition(Asset paramAsset)
  {
    this.asset = paramAsset;
    this.instructions = new ArrayList();
    fillSourceProperty();
  }
  
  private void fillSourceProperty()
  {
    Object localObject2 = this.asset.tracksWithMediaType(1);
    this.frameDuration = null;
    this.renderSize = null;
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      localObject3 = ((List)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = (AssetTrack)((Iterator)localObject3).next();
        localObject4 = this.frameDuration;
        if (localObject4 == null)
        {
          this.frameDuration = new CMTime(1L, (int)((AssetTrack)localObject1).getNominalFrameRate());
        }
        else
        {
          if (((CMTime)localObject4).timeScale > ((AssetTrack)localObject1).getNominalFrameRate()) {
            localObject1 = this.frameDuration;
          } else {
            localObject1 = new CMTime(1L, (int)((AssetTrack)localObject1).getNominalFrameRate());
          }
          this.frameDuration = ((CMTime)localObject1);
        }
      }
    }
    Object localObject1 = this.frameDuration;
    if ((localObject1 == null) || (((CMTime)localObject1).timeScale == 0)) {
      this.frameDuration = new CMTime(1L, 30);
    }
    localObject1 = this.asset;
    if ((localObject1 instanceof Composition))
    {
      this.renderSize = ((Asset)localObject1).getNaturalSize();
    }
    else if (localObject2 != null)
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (AssetTrack)((Iterator)localObject1).next();
        if (this.renderSize == null) {
          this.renderSize = ((AssetTrack)localObject3).getNaturalSize();
        } else if (((AssetTrack)localObject3).getNaturalSize() != null) {
          this.renderSize = new CGSize(Math.max(this.renderSize.width, ((AssetTrack)localObject3).getNaturalSize().width), Math.max(this.renderSize.height, ((AssetTrack)localObject3).getNaturalSize().height));
        }
      }
    }
    this.instructions = new ArrayList();
    if ((localObject2 != null) && (!(this.asset instanceof Composition)))
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AssetTrack)((Iterator)localObject1).next();
        localObject3 = new VideoCompositionInstruction();
        ((VideoCompositionInstruction)localObject3).backgroundColor = -16777216;
        ((VideoCompositionInstruction)localObject3).enablePostProcessing = true;
        ((VideoCompositionInstruction)localObject3).passthroughTrackID = ((AssetTrack)localObject2).getTrackID();
        ((VideoCompositionInstruction)localObject3).timeRange = new CMTimeRange(CMTime.CMTimeZero, ((AssetTrack)localObject2).getDuration());
        ((VideoCompositionInstruction)localObject3).requiredSourceTrackIDs = Arrays.asList(new Integer[] { Integer.valueOf(((AssetTrack)localObject2).getTrackID()) });
        localObject4 = new MutableVideoCompositionLayerInstruction();
        MutableVideoCompositionLayerInstruction localMutableVideoCompositionLayerInstruction = (MutableVideoCompositionLayerInstruction)localObject4;
        localMutableVideoCompositionLayerInstruction.setTrackID(((AssetTrack)localObject2).getTrackID());
        localMutableVideoCompositionLayerInstruction.setTransformRampFromStartTransform(null, null, ((VideoCompositionInstruction)localObject3).timeRange);
        localMutableVideoCompositionLayerInstruction.setCropRectangleRampFromStartCropRectangle(null, null, ((VideoCompositionInstruction)localObject3).timeRange);
        localMutableVideoCompositionLayerInstruction.setOpacityRampFromStartOpacity(1.0F, 1.0F, ((VideoCompositionInstruction)localObject3).timeRange);
        ((VideoCompositionInstruction)localObject3).layerInstructions.add(localObject4);
      }
    }
    this.renderScale = 1.0F;
  }
  
  public static VideoCompositionInstruction findInstruction(VideoComposition paramVideoComposition, CMTime paramCMTime)
  {
    Object localObject2 = paramVideoComposition.getInstructions();
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    Iterator localIterator = paramVideoComposition.getInstructions().iterator();
    paramVideoComposition = (VideoComposition)localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (VideoCompositionInstruction)localIterator.next();
      localObject1 = paramVideoComposition;
      if (((VideoCompositionInstruction)localObject2).getTimeRange() != null) {
        if (paramVideoComposition != null)
        {
          localObject1 = paramVideoComposition;
          if (!paramVideoComposition.getTimeRange().getEnd().smallThan(((VideoCompositionInstruction)localObject2).getTimeRange().getEnd())) {}
        }
        else
        {
          localObject1 = localObject2;
        }
      }
      CMTimeRange localCMTimeRange = ((VideoCompositionInstruction)localObject2).getTimeRange();
      paramVideoComposition = (VideoComposition)localObject1;
      if (localCMTimeRange != null)
      {
        paramVideoComposition = (VideoComposition)localObject1;
        if (localCMTimeRange.getStartUs() <= paramCMTime.getTimeUs())
        {
          paramVideoComposition = (VideoComposition)localObject1;
          if (localCMTimeRange.getEndUs() > paramCMTime.getTimeUs()) {
            return localObject2;
          }
        }
      }
    }
    return paramVideoComposition;
  }
  
  @NonNull
  public VideoCompositing getCustomVideoCompositor()
  {
    Object localObject = this.customVideoCompositorClass;
    if (localObject != null) {
      try
      {
        localObject = (VideoCompositing)((Class)localObject).newInstance();
        return localObject;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return new VideoCompositor();
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        return new VideoCompositor();
      }
    }
    return new VideoCompositor();
  }
  
  public Class<? extends VideoCompositing> getCustomVideoCompositorClass()
  {
    return this.customVideoCompositorClass;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public <T extends VideoCompositionInstruction> List<T> getInstructions()
  {
    return this.instructions;
  }
  
  public VideoComposition.RenderLayoutMode getRenderLayoutMode()
  {
    return this.renderLayoutMode;
  }
  
  public float getRenderScale()
  {
    return this.renderScale;
  }
  
  public CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public int getSourceTrackIDForFrameTiming()
  {
    return this.sourceTrackIDForFrameTiming;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutableVideoComposition{, frameDuration=");
    localStringBuilder.append(this.frameDuration);
    localStringBuilder.append(", renderSize=");
    localStringBuilder.append(this.renderSize);
    localStringBuilder.append(", renderLayoutMode=");
    localStringBuilder.append(this.renderLayoutMode);
    localStringBuilder.append(", instructions=");
    localStringBuilder.append(this.instructions);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoComposition
 * JD-Core Version:    0.7.0.1
 */