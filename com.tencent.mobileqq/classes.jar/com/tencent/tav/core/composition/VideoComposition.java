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
    Object localObject1;
    if (localObject2 != null)
    {
      localObject3 = ((List)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = (AssetTrack)((Iterator)localObject3).next();
        if (this.frameDuration == null)
        {
          this.frameDuration = new CMTime(1L, (int)((AssetTrack)localObject1).getNominalFrameRate());
        }
        else
        {
          if (this.frameDuration.timeScale > ((AssetTrack)localObject1).getNominalFrameRate()) {}
          for (localObject1 = this.frameDuration;; localObject1 = new CMTime(1L, (int)((AssetTrack)localObject1).getNominalFrameRate()))
          {
            this.frameDuration = ((CMTime)localObject1);
            break;
          }
        }
      }
    }
    if ((this.frameDuration == null) || (this.frameDuration.timeScale == 0)) {
      this.frameDuration = new CMTime(1L, 30);
    }
    if ((this.asset instanceof Composition)) {
      this.renderSize = this.asset.getNaturalSize();
    }
    for (;;)
    {
      this.instructions = new ArrayList();
      if ((localObject2 == null) || ((this.asset instanceof Composition))) {
        break;
      }
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
        MutableVideoCompositionLayerInstruction localMutableVideoCompositionLayerInstruction = new MutableVideoCompositionLayerInstruction();
        ((MutableVideoCompositionLayerInstruction)localMutableVideoCompositionLayerInstruction).setTrackID(((AssetTrack)localObject2).getTrackID());
        ((MutableVideoCompositionLayerInstruction)localMutableVideoCompositionLayerInstruction).setTransformRampFromStartTransform(null, null, ((VideoCompositionInstruction)localObject3).timeRange);
        ((MutableVideoCompositionLayerInstruction)localMutableVideoCompositionLayerInstruction).setCropRectangleRampFromStartCropRectangle(null, null, ((VideoCompositionInstruction)localObject3).timeRange);
        ((MutableVideoCompositionLayerInstruction)localMutableVideoCompositionLayerInstruction).setOpacityRampFromStartOpacity(1.0F, 1.0F, ((VideoCompositionInstruction)localObject3).timeRange);
        ((VideoCompositionInstruction)localObject3).layerInstructions.add(localMutableVideoCompositionLayerInstruction);
      }
      if (localObject2 != null)
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
    }
    this.renderScale = 1.0F;
  }
  
  public static VideoCompositionInstruction findInstruction(VideoComposition paramVideoComposition, CMTime paramCMTime)
  {
    Object localObject = null;
    VideoCompositionInstruction localVideoCompositionInstruction = null;
    if (paramVideoComposition.getInstructions() == null)
    {
      localObject = localVideoCompositionInstruction;
      return localObject;
    }
    Iterator localIterator = paramVideoComposition.getInstructions().iterator();
    paramVideoComposition = (VideoComposition)localObject;
    CMTimeRange localCMTimeRange;
    do
    {
      do
      {
        do
        {
          localObject = paramVideoComposition;
          if (!localIterator.hasNext()) {
            break;
          }
          localVideoCompositionInstruction = (VideoCompositionInstruction)localIterator.next();
          localObject = paramVideoComposition;
          if (localVideoCompositionInstruction.getTimeRange() != null) {
            if (paramVideoComposition != null)
            {
              localObject = paramVideoComposition;
              if (!paramVideoComposition.getTimeRange().getEnd().smallThan(localVideoCompositionInstruction.getTimeRange().getEnd())) {}
            }
            else
            {
              localObject = localVideoCompositionInstruction;
            }
          }
          localCMTimeRange = localVideoCompositionInstruction.getTimeRange();
          paramVideoComposition = (VideoComposition)localObject;
        } while (localCMTimeRange == null);
        paramVideoComposition = (VideoComposition)localObject;
      } while (localCMTimeRange.getStartUs() > paramCMTime.getTimeUs());
      paramVideoComposition = (VideoComposition)localObject;
    } while (localCMTimeRange.getEndUs() <= paramCMTime.getTimeUs());
    return localVideoCompositionInstruction;
  }
  
  @NonNull
  public VideoCompositing getCustomVideoCompositor()
  {
    if (this.customVideoCompositorClass != null) {
      try
      {
        VideoCompositing localVideoCompositing = (VideoCompositing)this.customVideoCompositorClass.newInstance();
        return localVideoCompositing;
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        return new VideoCompositor();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
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
    return "MutableVideoComposition{, frameDuration=" + this.frameDuration + ", renderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", instructions=" + this.instructions + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoComposition
 * JD-Core Version:    0.7.0.1
 */