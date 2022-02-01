package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;

public class TAVStickerLayerInfo$TAVStickerTimeEffect
{
  private boolean reversed = false;
  private CMTimeRange sourceVideoTimeRange = CMTimeRange.CMTimeRangeInvalid;
  private CMTimeRange timeRange = CMTimeRange.CMTimeRangeInvalid;
  
  public TAVStickerLayerInfo$TAVStickerTimeEffect(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2, boolean paramBoolean)
  {
    if (paramCMTimeRange1 != null) {
      this.sourceVideoTimeRange = paramCMTimeRange1;
    }
    if (paramCMTimeRange2 != null) {
      this.timeRange = paramCMTimeRange2;
    }
    this.reversed = paramBoolean;
  }
  
  public CMTimeRange getSourceVideoTimeRange()
  {
    return this.sourceVideoTimeRange;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public boolean isReversed()
  {
    return this.reversed;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TAVStickerTimeEffect {sourceVideoTimeRange : ");
    if (this.sourceVideoTimeRange != null)
    {
      str = "start : " + this.sourceVideoTimeRange.getStartUs() + ", duration : " + this.sourceVideoTimeRange.getDurationUs();
      localStringBuilder = localStringBuilder.append(str).append(", timeRange : ");
      if (this.timeRange == null) {
        break label152;
      }
    }
    label152:
    for (String str = "start : " + this.timeRange.getStartUs() + ", duration : " + this.timeRange.getDurationUs();; str = "null")
    {
      return str + ", reversed : " + this.reversed + "}";
      str = "null";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerTimeEffect
 * JD-Core Version:    0.7.0.1
 */