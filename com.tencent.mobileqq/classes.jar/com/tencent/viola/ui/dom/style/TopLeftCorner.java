package com.tencent.viola.ui.dom.style;

import android.graphics.RectF;
import android.support.annotation.NonNull;

public class TopLeftCorner
  extends BorderCorner
{
  protected void prepareOval()
  {
    if (hasInnerCorner())
    {
      setOvalLeft(getPreBorderWidth() / 2.0F);
      setOvalTop(getPostBorderWidth() / 2.0F);
      setOvalRight(getOuterCornerRadius() * 2.0F - getPreBorderWidth() / 2.0F);
      setOvalBottom(getOuterCornerRadius() * 2.0F - getPostBorderWidth() / 2.0F);
      return;
    }
    setOvalLeft(getOuterCornerRadius() / 2.0F);
    setOvalTop(getOuterCornerRadius() / 2.0F);
    setOvalRight(getOuterCornerRadius() * 1.5F);
    setOvalBottom(getOuterCornerRadius() * 1.5F);
  }
  
  protected void prepareRoundCorner()
  {
    if (hasOuterCorner())
    {
      setRoundCornerStartX(getPreBorderWidth() / 2.0F);
      setRoundCornerStartY(getOuterCornerRadius());
      setRoundCornerEndX(getOuterCornerRadius());
      setRoundCornerEndY(getPostBorderWidth() / 2.0F);
      return;
    }
    float f1 = getPreBorderWidth() / 2.0F;
    float f2 = getPostBorderWidth() / 2.0F;
    setRoundCornerStartX(f1);
    setRoundCornerStartY(f2);
    setRoundCornerEndX(f1);
    setRoundCornerEndY(f2);
  }
  
  void set(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull RectF paramRectF)
  {
    set(paramFloat1, paramFloat2, paramFloat3, paramRectF, 225.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.TopLeftCorner
 * JD-Core Version:    0.7.0.1
 */