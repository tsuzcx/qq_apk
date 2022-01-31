package com.tencent.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.Calendar;

public class TimePickerView
  implements DialogInterface.OnDismissListener, IphonePickerView.IphonePickListener, IphonePickerView.PickerViewAdapter
{
  static int jdField_a_of_type_Int = 2014;
  IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  TimePickerView.TimePickerListener jdField_a_of_type_ComTencentWidgetTimePickerView$TimePickerListener;
  int b;
  int c;
  int d;
  
  public int getColumnCount()
  {
    return 3;
  }
  
  public int getRowCount(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return jdField_a_of_type_Int - 1895 + 1;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.b + 1895);
    localCalendar.set(2, this.c);
    localCalendar.set(5, 1);
    return localCalendar.getActualMaximum(5);
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return paramInt2 + 1895 + "年";
    case 1: 
      return paramInt2 + 1 + "月";
    }
    return paramInt2 + 1 + "日";
  }
  
  public void onConfirmBtClicked()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetTimePickerView$TimePickerListener != null) && (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)) {
      this.jdField_a_of_type_ComTencentWidgetTimePickerView$TimePickerListener.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0) + 1895, this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1) + 1, this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2) + 1);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = null;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
      }
      return;
      this.b = paramInt2;
      continue;
      this.c = paramInt2;
      continue;
      this.d = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.TimePickerView
 * JD-Core Version:    0.7.0.1
 */