package com.tencent.viola.ui.dom.style;

import android.graphics.RectF;
import android.support.annotation.NonNull;

public class BottomLeftCorner
  extends BorderCorner
{
  protected void prepareOval()
  {
    if (hasInnerCorner())
    {
      setOvalLeft(getPostBorderWidth() / 2.0F);
      setOvalTop(getBorderBox().height() - (getOuterCornerRadius() * 2.0F - getPreBorderWidth() / 2.0F));
      setOvalRight(getOuterCornerRadius() * 2.0F - getPostBorderWidth() / 2.0F);
      setOvalBottom(getBorderBox().height() - getPreBorderWidth() / 2.0F);
      return;
    }
    setOvalLeft(getOuterCornerRadius() / 2.0F);
    setOvalTop(getBorderBox().height() - getOuterCornerRadius() * 1.5F);
    setOvalRight(getOuterCornerRadius() * 1.5F);
    setOvalBottom(getBorderBox().height() - getOuterCornerRadius() / 2.0F);
  }
  
  protected void prepareRoundCorner()
  {
    if (hasOuterCorner())
    {
      setRoundCornerStartX(getOuterCornerRadius());
      setRoundCornerStartY(getBorderBox().height() - getPreBorderWidth() / 2.0F);
      setRoundCornerEndX(getPostBorderWidth() / 2.0F);
      setRoundCornerEndY(getBorderBox().height() - getOuterCornerRadius());
      return;
    }
    float f1 = getPostBorderWidth() / 2.0F;
    float f2 = getBorderBox().height() - getPreBorderWidth() / 2.0F;
    setRoundCornerStartX(f1);
    setRoundCornerStartY(f2);
    setRoundCornerEndX(f1);
    setRoundCornerEndY(f2);
  }
  
  void set(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull RectF paramRectF)
  {
    set(paramFloat1, paramFloat2, paramFloat3, paramRectF, 135.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.BottomLeftCorner
 * JD-Core Version:    0.7.0.1
 */