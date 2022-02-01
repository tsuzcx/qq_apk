package com.tencent.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.HardCodeUtil;
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 0;
        }
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(1, this.b + 1895);
        localCalendar.set(2, this.c);
        localCalendar.set(5, 1);
        return localCalendar.getActualMaximum(5);
      }
      return 12;
    }
    return jdField_a_of_type_Int - 1895 + 1;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return "";
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt2 + 1);
        localStringBuilder.append(HardCodeUtil.a(2131714779));
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2 + 1);
      localStringBuilder.append(HardCodeUtil.a(2131714778));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2 + 1895);
    localStringBuilder.append(HardCodeUtil.a(2131714777));
    return localStringBuilder.toString();
  }
  
  public void onConfirmBtClicked()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetTimePickerView$TimePickerListener;
    if (localObject != null)
    {
      IphonePickerView localIphonePickerView = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
      if (localIphonePickerView != null) {
        ((TimePickerView.TimePickerListener)localObject).a(localIphonePickerView.a(0) + 1895, this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1) + 1, this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2) + 1);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = null;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          this.d = paramInt2;
        }
      }
      else {
        this.c = paramInt2;
      }
    }
    else {
      this.b = paramInt2;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.TimePickerView
 * JD-Core Version:    0.7.0.1
 */