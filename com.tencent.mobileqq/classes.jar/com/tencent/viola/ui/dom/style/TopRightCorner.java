package com.tencent.viola.ui.dom.style;

import android.graphics.RectF;
import android.support.annotation.NonNull;

public class TopRightCorner
  extends BorderCorner
{
  protected void prepareOval()
  {
    if (hasInnerCorner())
    {
      setOvalLeft(getBorderBox().width() - (getOuterCornerRadius() * 2.0F - getPostBorderWidth() / 2.0F));
      setOvalTop(getPreBorderWidth() / 2.0F);
      setOvalRight(getBorderBox().width() - getPostBorderWidth() / 2.0F);
      setOvalBottom(getOuterCornerRadius() * 2.0F - getPreBorderWidth() / 2.0F);
      return;
    }
    setOvalLeft(getBorderBox().width() - getOuterCornerRadius() * 1.5F);
    setOvalTop(getOuterCornerRadius() / 2.0F);
    setOvalRight(getBorderBox().width() - getOuterCornerRadius() / 2.0F);
    setOvalBottom(getOuterCornerRadius() * 1.5F);
  }
  
  protected void prepareRoundCorner()
  {
    if (hasOuterCorner())
    {
      setRoundCornerStartX(getBorderBox().width() - getOuterCornerRadius());
      setRoundCornerStartY(getPreBorderWidth() / 2.0F);
      setRoundCornerEndX(getBorderBox().width() - getPostBorderWidth() / 2.0F);
      setRoundCornerEndY(getOuterCornerRadius());
      return;
    }
    float f1 = getBorderBox().width() - getPostBorderWidth() / 2.0F;
    float f2 = getPreBorderWidth() / 2.0F;
    setRoundCornerStartX(f1);
    setRoundCornerStartY(f2);
    setRoundCornerEndX(f1);
    setRoundCornerEndY(f2);
  }
  
  void set(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull RectF paramRectF)
  {
    set(paramFloat1, paramFloat2, paramFloat3, paramRectF, 315.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.TopRightCorner
 * JD-Core Version:    0.7.0.1
 */