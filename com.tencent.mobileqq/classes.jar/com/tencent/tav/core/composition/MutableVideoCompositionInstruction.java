package com.tencent.tav.core.composition;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Iterator;
import java.util.List;

public class MutableVideoCompositionInstruction
  extends VideoCompositionInstruction
{
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setEnablePostProcessing(boolean paramBoolean)
  {
    this.enablePostProcessing = paramBoolean;
  }
  
  public void setLayerInstructions(@NonNull List<VideoCompositionLayerInstruction> paramList)
  {
    this.layerInstructions.clear();
    this.layerInstructions.addAll(paramList);
    this.requiredSourceTrackIDs.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCompositionLayerInstruction localVideoCompositionLayerInstruction = (VideoCompositionLayerInstruction)paramList.next();
      this.requiredSourceTrackIDs.add(Integer.valueOf(localVideoCompositionLayerInstruction.getTrackID()));
    }
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.composition.MutableVideoCompositionInstruction
 * JD-Core Version:    0.7.0.1
 */