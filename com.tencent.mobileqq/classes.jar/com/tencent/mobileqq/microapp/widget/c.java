package com.tencent.mobileqq.microapp.widget;

import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

final class c
  implements DatePicker.OnDateChangedListener
{
  c(b paramb) {}
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    b.a(this.a, paramInt1);
    b.b(this.a, paramInt2);
    b.c(this.a, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.c
 * JD-Core Version:    0.7.0.1
 */