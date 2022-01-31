package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;

public class TAVStickerLayerInfo$TAVStickerTimeEffect
{
  private CMTimeRange mSourceVideoTimeRange = CMTimeRange.CMTimeRangeInvalid;
  private CMTimeRange mTimeRange = CMTimeRange.CMTimeRangeInvalid;
  private boolean reversed = false;
  
  public TAVStickerLayerInfo$TAVStickerTimeEffect(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2, boolean paramBoolean)
  {
    if (paramCMTimeRange1 != null) {
      this.mSourceVideoTimeRange = paramCMTimeRange1;
    }
    if (paramCMTimeRange2 != null) {
      this.mTimeRange = paramCMTimeRange2;
    }
    this.reversed = paramBoolean;
  }
  
  public CMTimeRange getSourceVideoTimeRange()
  {
    return this.mSourceVideoTimeRange;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.mTimeRange;
  }
  
  public boolean isReversed()
  {
    return this.reversed;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TAVStickerTimeEffect {mSourceVideoTimeRange : ");
    if (this.mSourceVideoTimeRange != null)
    {
      str = "start : " + this.mSourceVideoTimeRange.getStartUs() + ", duration : " + this.mSourceVideoTimeRange.getDurationUs();
      localStringBuilder = localStringBuilder.append(str).append(", mTimeRange : ");
      if (this.mTimeRange == null) {
        break label152;
      }
    }
    label152:
    for (String str = "start : " + this.mTimeRange.getStartUs() + ", duration : " + this.mTimeRange.getDurationUs();; str = "null")
    {
      return str + ", reversed : " + this.reversed + "}";
      str = "null";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerTimeEffect
 * JD-Core Version:    0.7.0.1
 */