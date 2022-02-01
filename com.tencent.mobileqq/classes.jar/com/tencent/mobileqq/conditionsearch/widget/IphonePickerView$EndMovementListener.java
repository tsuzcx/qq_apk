package com.tencent.mobileqq.conditionsearch.widget;

import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.OnEndMovementListener;

class IphonePickerView$EndMovementListener
  implements VerticalGallery.OnEndMovementListener
{
  private int b;
  
  public IphonePickerView$EndMovementListener(IphonePickerView paramIphonePickerView, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void onEndMovement(VerticalGallery paramVerticalGallery)
  {
    int i = IphonePickerView.c(this.a)[this.b].getSelectedItemPosition();
    if (IphonePickerView.a(this.a) != null) {
      IphonePickerView.a(this.a).onItemSelected(this.b, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.EndMovementListener
 * JD-Core Version:    0.7.0.1
 */