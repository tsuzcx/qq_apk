package com.tencent.qqmini.miniapp.widget;

import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

class TimePickerView$1
  implements TimePicker.OnTimeChangedListener
{
  TimePickerView$1(TimePickerView paramTimePickerView) {}
  
  public void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    TimePickerView.access$002(this.this$0, paramInt1);
    TimePickerView.access$102(this.this$0, paramInt2);
    if (paramInt1 == TimePickerView.access$200(this.this$0).getMinValue())
    {
      TimePickerView.access$400(this.this$0).setMinValue(TimePickerView.access$300(this.this$0));
      TimePickerView.access$400(this.this$0).setMaxValue(59);
      return;
    }
    if (paramInt1 == TimePickerView.access$200(this.this$0).getMaxValue())
    {
      TimePickerView.access$400(this.this$0).setMinValue(0);
      TimePickerView.access$400(this.this$0).setMaxValue(TimePickerView.access$500(this.this$0));
      return;
    }
    TimePickerView.access$400(this.this$0).setMinValue(0);
    TimePickerView.access$400(this.this$0).setMaxValue(59);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.TimePickerView.1
 * JD-Core Version:    0.7.0.1
 */