package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.image.ProxyDrawable;

class BubblePopupWindow$MyClipDrawable
  extends ProxyDrawable
{
  int clipLeft;
  int clipRight;
  
  public BubblePopupWindow$MyClipDrawable(BubblePopupWindow paramBubblePopupWindow, Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (this.clipRight > this.clipLeft)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(this.clipLeft, 0, this.clipRight, localRect.height());
      this.mCurrDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
  
  public void setClipRange(int paramInt1, int paramInt2)
  {
    this.clipLeft = paramInt1;
    this.clipRight = paramInt2;
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.BubblePopupWindow.MyClipDrawable
 * JD-Core Version:    0.7.0.1
 */