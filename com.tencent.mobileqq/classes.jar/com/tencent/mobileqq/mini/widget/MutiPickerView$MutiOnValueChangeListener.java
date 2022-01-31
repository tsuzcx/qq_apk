package com.tencent.mobileqq.mini.widget;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class MutiPickerView$MutiOnValueChangeListener
  implements NumberPicker.OnValueChangeListener
{
  private int index;
  
  public MutiPickerView$MutiOnValueChangeListener(MutiPickerView paramMutiPickerView, int paramInt)
  {
    this.index = paramInt;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    if ((MutiPickerView.access$000(this.this$0) != null) && (MutiPickerView.access$000(this.this$0).length > this.index))
    {
      MutiPickerView.access$000(this.this$0)[this.index] = paramInt2;
      MutiPickerView.access$100(this.this$0).onValChange(this.index, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MutiPickerView.MutiOnValueChangeListener
 * JD-Core Version:    0.7.0.1
 */