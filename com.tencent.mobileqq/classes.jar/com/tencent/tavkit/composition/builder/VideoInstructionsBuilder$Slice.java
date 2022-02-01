package com.tencent.tavkit.composition.builder;

import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.video.TAVVideoCompositionLayerInstruction;
import java.util.List;

class VideoInstructionsBuilder$Slice
{
  private List<TAVVideoCompositionLayerInstruction> layerInstructions;
  private CMTimeRange timeRange;
  
  VideoInstructionsBuilder$Slice(CMTimeRange paramCMTimeRange, List<TAVVideoCompositionLayerInstruction> paramList)
  {
    this.timeRange = paramCMTimeRange;
    this.layerInstructions = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.VideoInstructionsBuilder.Slice
 * JD-Core Version:    0.7.0.1
 */