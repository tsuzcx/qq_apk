package com.tencent.tavkit.composition.video;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.tav.core.composition.VideoCompositionInstruction;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TAVVideoCompositionInstruction
  extends VideoCompositionInstruction
{
  private static final String TAG = "TAVVideoCompositionInst";
  @NonNull
  private List<List<TAVVideoCompositionLayerInstruction>> channelLayers;
  private TAVVideoEffect globalVideoEffect;
  @NonNull
  private List<TAVVideoCompositionLayerInstruction> overlayLayers;
  private TAVVideoEffect sourceVideoEffect;
  @NonNull
  private final CMTimeRange timeRange;
  private TAVVideoMixEffect videoMixEffect;
  
  public TAVVideoCompositionInstruction(List<Integer> paramList, @NonNull CMTimeRange paramCMTimeRange)
  {
    this.requiredSourceTrackIDs = paramList;
    this.timeRange = paramCMTimeRange;
    this.enablePostProcessing = false;
    this.backgroundColor = -16777216;
    this.channelLayers = new ArrayList();
    this.overlayLayers = new ArrayList();
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  @NotNull
  List<List<TAVVideoCompositionLayerInstruction>> getChannelLayers()
  {
    return this.channelLayers;
  }
  
  TAVVideoEffect getGlobalVideoEffect()
  {
    return this.globalVideoEffect;
  }
  
  public List<TAVVideoCompositionLayerInstruction> getLayerInstructions()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.channelLayers.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll((List)localIterator.next());
    }
    localArrayList.addAll(this.overlayLayers);
    return localArrayList;
  }
  
  @NotNull
  List<TAVVideoCompositionLayerInstruction> getOverlayLayers()
  {
    return this.overlayLayers;
  }
  
  public int getPassthroughTrackID()
  {
    Log.e("TAVVideoCompositionInst", "getPassthroughTrackID: 方法未实现");
    return -1;
  }
  
  TAVVideoEffect getSourceVideoEffect()
  {
    return this.sourceVideoEffect;
  }
  
  @NonNull
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  TAVVideoMixEffect getVideoMixEffect()
  {
    return this.videoMixEffect;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setChannelLayers(List<List<TAVVideoCompositionLayerInstruction>> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.channelLayers = paramList;
  }
  
  public void setEnablePostProcessing(boolean paramBoolean)
  {
    this.enablePostProcessing = paramBoolean;
  }
  
  public void setGlobalVideoEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    this.globalVideoEffect = paramTAVVideoEffect;
  }
  
  public void setOverlayLayers(List<TAVVideoCompositionLayerInstruction> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.overlayLayers = paramList;
      this.requiredSourceTrackIDs.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoCompositionLayerInstruction localVideoCompositionLayerInstruction = (VideoCompositionLayerInstruction)paramList.next();
        this.requiredSourceTrackIDs.add(Integer.valueOf(localVideoCompositionLayerInstruction.getTrackID()));
      }
    }
  }
  
  public void setSourceVideoEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    this.sourceVideoEffect = paramTAVVideoEffect;
  }
  
  public void setVideoMixEffect(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    this.videoMixEffect = paramTAVVideoMixEffect;
  }
  
  public String toString()
  {
    return "TAVVideoCompositionInstruction{timeRange=" + this.timeRange.toSimpleString() + ", backgroundColor=" + this.backgroundColor + ", overlayLayers=" + this.overlayLayers + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoCompositionInstruction
 * JD-Core Version:    0.7.0.1
 */