package com.tencent.tav.core.composition;

import android.support.annotation.Nullable;
import com.tencent.tav.core.compositing.IVideoCompositionInstruction;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class VideoCompositionInstruction
  implements IVideoCompositionInstruction
{
  @Nullable
  protected int backgroundColor;
  protected boolean enablePostProcessing;
  protected List<VideoCompositionLayerInstruction> layerInstructions = new ArrayList();
  protected int passthroughTrackID = -1;
  protected List<Integer> requiredSourceTrackIDs = new ArrayList();
  protected CMTimeRange timeRange;
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public List<? extends VideoCompositionLayerInstruction> getLayerInstructions()
  {
    return this.layerInstructions;
  }
  
  public int getPassthroughTrackID()
  {
    return this.passthroughTrackID;
  }
  
  public List<Integer> getRequiredSourceTrackIDs()
  {
    return this.requiredSourceTrackIDs;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public boolean isEnablePostProcessing()
  {
    return this.enablePostProcessing;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoCompositionInstruction
 * JD-Core Version:    0.7.0.1
 */