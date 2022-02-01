package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.image.ProxyDrawable;

class BubblePopupWindow$MyClipDrawable
  extends ProxyDrawable
{
  int jdField_a_of_type_Int;
  int b;
  
  public BubblePopupWindow$MyClipDrawable(BubblePopupWindow paramBubblePopupWindow, Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (this.b > this.jdField_a_of_type_Int)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(this.jdField_a_of_type_Int, 0, this.b, localRect.height());
      this.mCurrDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.BubblePopupWindow.MyClipDrawable
 * JD-Core Version:    0.7.0.1
 */