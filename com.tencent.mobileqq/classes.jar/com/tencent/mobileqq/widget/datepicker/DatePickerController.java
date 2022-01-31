package com.tencent.mobileqq.widget.datepicker;

import com.tencent.mobileqq.data.MessageRecord;

public abstract interface DatePickerController
{
  public abstract CalendarDay a();
  
  public abstract void a(CalendarDay paramCalendarDay, MessageRecord paramMessageRecord);
  
  public abstract void a(SimpleMonthView paramSimpleMonthView, int paramInt1, int paramInt2);
  
  public abstract CalendarDay b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.DatePickerController
 * JD-Core Version:    0.7.0.1
 */