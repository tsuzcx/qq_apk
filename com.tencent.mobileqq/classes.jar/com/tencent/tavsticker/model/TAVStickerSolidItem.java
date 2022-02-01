package com.tencent.tavsticker.model;

import org.libpag.PAGSolidLayer;

public class TAVStickerSolidItem
  extends TAVStickerLayerItem
{
  private int color;
  
  public TAVStickerSolidItem(PAGSolidLayer paramPAGSolidLayer)
  {
    super(paramPAGSolidLayer);
    if (paramPAGSolidLayer != null) {
      this.color = paramPAGSolidLayer.solidColor();
    }
  }
  
  public int getColor()
  {
    return this.color;
  }
  
  public void setColor(int paramInt)
  {
    this.color = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerSolidItem
 * JD-Core Version:    0.7.0.1
 */