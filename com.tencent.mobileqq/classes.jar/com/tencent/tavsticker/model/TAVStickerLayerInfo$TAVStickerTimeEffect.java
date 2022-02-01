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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVStickerTimeEffect {sourceVideoTimeRange : ");
    Object localObject = this.sourceVideoTimeRange;
    String str = "null";
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start : ");
      ((StringBuilder)localObject).append(this.sourceVideoTimeRange.getStartUs());
      ((StringBuilder)localObject).append(", duration : ");
      ((StringBuilder)localObject).append(this.sourceVideoTimeRange.getDurationUs());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", timeRange : ");
    localObject = str;
    if (this.timeRange != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start : ");
      ((StringBuilder)localObject).append(this.timeRange.getStartUs());
      ((StringBuilder)localObject).append(", duration : ");
      ((StringBuilder)localObject).append(this.timeRange.getDurationUs());
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", reversed : ");
    localStringBuilder.append(this.reversed);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerTimeEffect
 * JD-Core Version:    0.7.0.1
 */