package com.tencent.mobileqq.widget.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class SimpleMonthAdapter
  extends RecyclerView.Adapter
  implements SimpleMonthView.OnDayClickListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final TypedArray jdField_a_of_type_AndroidContentResTypedArray;
  private CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  private final DatePickerController jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public SimpleMonthAdapter(Context paramContext, DatePickerController paramDatePickerController, TypedArray paramTypedArray)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController = paramDatePickerController;
    this.jdField_a_of_type_AndroidContentResTypedArray = paramTypedArray;
    if (this.jdField_a_of_type_AndroidContentResTypedArray.getBoolean(14, false)) {
      a(new CalendarDay(System.currentTimeMillis()));
    }
  }
  
  public SimpleMonthAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new SimpleMonthAdapter.ViewHolder(new SimpleMonthView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentResTypedArray), this);
  }
  
  public void a(int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "-" + paramInt2, paramArrayList);
    notifyDataSetChanged();
  }
  
  protected void a(CalendarDay paramCalendarDay)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = paramCalendarDay;
    notifyDataSetChanged();
  }
  
  public void a(SimpleMonthAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    SimpleMonthView localSimpleMonthView = paramViewHolder.a;
    HashMap localHashMap = new HashMap();
    paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController.a();
    CalendarDay localCalendarDay1 = new CalendarDay(System.currentTimeMillis());
    CalendarDay localCalendarDay2 = new CalendarDay(localCalendarDay1.year, localCalendarDay1.month, 1);
    if (paramViewHolder.getTimeInMillis() > localCalendarDay2.getTimeInMillis()) {
      paramViewHolder = new CalendarDay(localCalendarDay1.year, localCalendarDay1.month - 1, 1);
    }
    for (;;)
    {
      int i = (paramViewHolder.month + paramInt) % 12;
      int j = paramViewHolder.year;
      paramInt = (paramViewHolder.month + paramInt) / 12 + j;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay != null)
      {
        localHashMap.put("selected_begin_year", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year));
        localHashMap.put("selected_begin_month", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month));
        localHashMap.put("selected_begin_day", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.day));
      }
      localSimpleMonthView.b();
      localHashMap.put("year", Integer.valueOf(paramInt));
      localHashMap.put("month", Integer.valueOf(i));
      localHashMap.put("week_start", Integer.valueOf(Calendar.getInstance().getFirstDayOfWeek()));
      localSimpleMonthView.setMonthParams(localHashMap);
      localSimpleMonthView.setMessageRecords((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramInt + "-" + i));
      localSimpleMonthView.setStartAndEndDate(paramViewHolder, localCalendarDay1);
      localSimpleMonthView.invalidate();
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController.a(localSimpleMonthView, paramInt, i);
      return;
    }
  }
  
  public void a(SimpleMonthView paramSimpleMonthView, CalendarDay paramCalendarDay, Object paramObject)
  {
    if ((paramCalendarDay != null) && (paramObject != null) && ((paramObject instanceof MessageRecord)))
    {
      a(paramCalendarDay);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController.a(paramCalendarDay, (MessageRecord)paramObject);
    }
  }
  
  public int getItemCount()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController.a().year * 12 + this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController.a().month;
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController.b().year * 12 + this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController.b().month;
    if (i == j) {
      return 2;
    }
    return j - i + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.SimpleMonthAdapter
 * JD-Core Version:    0.7.0.1
 */