package com.tencent.viola.ui.dom.style;

import android.graphics.RectF;
import android.support.annotation.NonNull;

public class BottomRightCorner
  extends BorderCorner
{
  protected void prepareOval()
  {
    if (hasInnerCorner())
    {
      setOvalLeft(getBorderBox().width() - (getOuterCornerRadius() * 2.0F - getPreBorderWidth() / 2.0F));
      setOvalTop(getBorderBox().height() - (getOuterCornerRadius() * 2.0F - getPostBorderWidth() / 2.0F));
      setOvalRight(getBorderBox().width() - getPreBorderWidth() / 2.0F);
      setOvalBottom(getBorderBox().height() - getPostBorderWidth() / 2.0F);
      return;
    }
    setOvalLeft(getBorderBox().width() - getOuterCornerRadius() * 1.5F);
    setOvalTop(getBorderBox().height() - getOuterCornerRadius() * 1.5F);
    setOvalRight(getBorderBox().width() - getOuterCornerRadius() / 2.0F);
    setOvalBottom(getBorderBox().height() - getOuterCornerRadius() / 2.0F);
  }
  
  protected void prepareRoundCorner()
  {
    if (hasOuterCorner())
    {
      setRoundCornerStartX(getBorderBox().width() - getPreBorderWidth() / 2.0F);
      setRoundCornerStartY(getBorderBox().height() - getOuterCornerRadius());
      setRoundCornerEndX(getBorderBox().width() - getOuterCornerRadius());
      setRoundCornerEndY(getBorderBox().height() - getPostBorderWidth() / 2.0F);
      return;
    }
    float f1 = getBorderBox().width() - getPreBorderWidth() / 2.0F;
    float f2 = getBorderBox().height() - getPostBorderWidth() / 2.0F;
    setRoundCornerStartX(f1);
    setRoundCornerStartY(f2);
    setRoundCornerEndX(f1);
    setRoundCornerEndY(f2);
  }
  
  void set(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull RectF paramRectF)
  {
    set(paramFloat1, paramFloat2, paramFloat3, paramRectF, 45.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.BottomRightCorner
 * JD-Core Version:    0.7.0.1
 */