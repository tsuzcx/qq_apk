package com.tencent.ttpic.model;

import com.tencent.filter.BaseFilter;

public class TotalScoreActItem
  extends SingleScoreActItem
{
  public TotalScoreActItem(CaptureActItem paramCaptureActItem, BaseFilter paramBaseFilter)
  {
    super(paramCaptureActItem, paramBaseFilter);
  }
  
  protected int getScore(CanvasItem paramCanvasItem)
  {
    return this.captureActItem.getTotalScore();
  }
  
  protected int[] getScoreTexture(CanvasItem paramCanvasItem)
  {
    return this.captureActItem.getTotalScoreTexture();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.TotalScoreActItem
 * JD-Core Version:    0.7.0.1
 */