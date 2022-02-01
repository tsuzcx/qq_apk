package com.tencent.qqmini.miniapp.widget;

import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

class DatePickerView$1
  implements DatePicker.OnDateChangedListener
{
  DatePickerView$1(DatePickerView paramDatePickerView) {}
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramDatePicker != null)
    {
      DatePickerView.access$002(this.this$0, paramDatePicker.getYear());
      DatePickerView.access$102(this.this$0, paramDatePicker.getMonth());
      DatePickerView.access$202(this.this$0, paramDatePicker.getDayOfMonth());
      return;
    }
    DatePickerView.access$002(this.this$0, paramInt1);
    DatePickerView.access$102(this.this$0, paramInt2);
    DatePickerView.access$202(this.this$0, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.DatePickerView.1
 * JD-Core Version:    0.7.0.1
 */