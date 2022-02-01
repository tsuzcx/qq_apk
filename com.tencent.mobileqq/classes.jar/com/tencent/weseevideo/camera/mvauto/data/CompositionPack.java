package com.tencent.weseevideo.camera.mvauto.data;

import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVComposition;

public class CompositionPack
{
  private TAVComposition mComposition;
  private CMTimeRange mTimeRange;
  private int useTemplate = 0;
  
  public TAVComposition getComposition()
  {
    return this.mComposition;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.mTimeRange;
  }
  
  public int getUseTemplate()
  {
    return this.useTemplate;
  }
  
  public void setComposition(TAVComposition paramTAVComposition)
  {
    this.mComposition = paramTAVComposition;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.mTimeRange = paramCMTimeRange;
  }
  
  public void setUseTemplate(int paramInt)
  {
    this.useTemplate = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.camera.mvauto.data.CompositionPack
 * JD-Core Version:    0.7.0.1
 */