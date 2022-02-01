package com.tencent.mobileqq.widget.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class SimpleMonthAdapter
  extends RecyclerView.Adapter<SimpleMonthAdapter.ViewHolder>
  implements SimpleMonthView.OnDayClickListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final TypedArray jdField_a_of_type_AndroidContentResTypedArray;
  private CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  private final DatePickerController jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController;
  private HashMap<String, ArrayList<MessageRecord>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public SimpleMonthAdapter(Context paramContext, DatePickerController paramDatePickerController, TypedArray paramTypedArray)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController = paramDatePickerController;
    this.jdField_a_of_type_AndroidContentResTypedArray = paramTypedArray;
    if (this.jdField_a_of_type_AndroidContentResTypedArray.getBoolean(8, false)) {
      a(new CalendarDay(System.currentTimeMillis()));
    }
  }
  
  public SimpleMonthAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new SimpleMonthAdapter.ViewHolder(new SimpleMonthView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentResTypedArray), this);
  }
  
  public void a(int paramInt1, int paramInt2, ArrayList<MessageRecord> paramArrayList)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localHashMap.put(localStringBuilder.toString(), paramArrayList);
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
    Object localObject3 = new HashMap();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController.a();
    CalendarDay localCalendarDay1 = new CalendarDay(System.currentTimeMillis());
    CalendarDay localCalendarDay2 = new CalendarDay(localCalendarDay1.year, localCalendarDay1.month, 1);
    Object localObject1 = localObject2;
    if (((CalendarDay)localObject2).getTimeInMillis() > localCalendarDay2.getTimeInMillis()) {
      localObject1 = new CalendarDay(localCalendarDay1.year, localCalendarDay1.month - 1, 1);
    }
    int i = (((CalendarDay)localObject1).month + paramInt) % 12;
    int j = ((CalendarDay)localObject1).year + (((CalendarDay)localObject1).month + paramInt) / 12;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
    if (localObject2 != null)
    {
      ((HashMap)localObject3).put("selected_begin_year", Integer.valueOf(((CalendarDay)localObject2).year));
      ((HashMap)localObject3).put("selected_begin_month", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month));
      ((HashMap)localObject3).put("selected_begin_day", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.day));
    }
    localSimpleMonthView.b();
    ((HashMap)localObject3).put("year", Integer.valueOf(j));
    ((HashMap)localObject3).put("month", Integer.valueOf(i));
    ((HashMap)localObject3).put("week_start", Integer.valueOf(Calendar.getInstance().getFirstDayOfWeek()));
    localSimpleMonthView.setMonthParams((HashMap)localObject3);
    localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(j);
    ((StringBuilder)localObject3).append("-");
    ((StringBuilder)localObject3).append(i);
    localSimpleMonthView.setMessageRecords((ArrayList)((HashMap)localObject2).get(((StringBuilder)localObject3).toString()));
    localSimpleMonthView.setStartAndEndDate((CalendarDay)localObject1, localCalendarDay1);
    localSimpleMonthView.invalidate();
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController.a(localSimpleMonthView, j, i);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.SimpleMonthAdapter
 * JD-Core Version:    0.7.0.1
 */