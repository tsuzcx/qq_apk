package com.tencent.ttpic.videoshelf.filter;

import com.tencent.ttpic.videoshelf.model.template.MaskBlock;
import java.util.Comparator;

class VideoShelfMergeFilter$1MaskBlockComparetor
  implements Comparator<MaskBlock>
{
  VideoShelfMergeFilter$1MaskBlockComparetor(VideoShelfMergeFilter paramVideoShelfMergeFilter) {}
  
  public int compare(MaskBlock paramMaskBlock1, MaskBlock paramMaskBlock2)
  {
    return paramMaskBlock2.getZIndex() - paramMaskBlock1.getZIndex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.filter.VideoShelfMergeFilter.1MaskBlockComparetor
 * JD-Core Version:    0.7.0.1
 */