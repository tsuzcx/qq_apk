package com.tencent.tavkit.composition.builder;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.video.TAVVideoCompositionLayerInstruction;
import java.util.Comparator;

class VideoInstructionsBuilder$2
  implements Comparator<TAVVideoCompositionLayerInstruction>
{
  VideoInstructionsBuilder$2(VideoInstructionsBuilder paramVideoInstructionsBuilder) {}
  
  public int compare(TAVVideoCompositionLayerInstruction paramTAVVideoCompositionLayerInstruction1, TAVVideoCompositionLayerInstruction paramTAVVideoCompositionLayerInstruction2)
  {
    if (paramTAVVideoCompositionLayerInstruction1.getTimeRange().getStart().smallThan(paramTAVVideoCompositionLayerInstruction2.getTimeRange().getStart())) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.VideoInstructionsBuilder.2
 * JD-Core Version:    0.7.0.1
 */