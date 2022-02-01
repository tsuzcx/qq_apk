package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.OnEndMovementListener;

class WheelPickerLayout$EndMovementListener
  implements VerticalGallery.OnEndMovementListener
{
  private int b;
  
  public WheelPickerLayout$EndMovementListener(WheelPickerLayout paramWheelPickerLayout, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void onEndMovement(VerticalGallery paramVerticalGallery)
  {
    int i = WheelPickerLayout.c(this.a)[this.b].getSelectedItemPosition();
    if (WheelPickerLayout.d(this.a) != null) {
      WheelPickerLayout.d(this.a).a(this.b, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout.EndMovementListener
 * JD-Core Version:    0.7.0.1
 */