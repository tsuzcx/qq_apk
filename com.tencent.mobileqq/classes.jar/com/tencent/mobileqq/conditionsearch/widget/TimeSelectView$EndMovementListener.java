package com.tencent.mobileqq.conditionsearch.widget;

import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.OnEndMovementListener;

class TimeSelectView$EndMovementListener
  implements VerticalGallery.OnEndMovementListener
{
  private int b;
  
  public TimeSelectView$EndMovementListener(TimeSelectView paramTimeSelectView, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void onEndMovement(VerticalGallery paramVerticalGallery)
  {
    int i = TimeSelectView.c(this.a)[this.b].getSelectedItemPosition();
    if (TimeSelectView.a(this.a) != null) {
      TimeSelectView.a(this.a).a(this.b, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.EndMovementListener
 * JD-Core Version:    0.7.0.1
 */