package com.tencent.mobileqq.troop.widget;

import ajgd;
import ajge;
import ajgf;
import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;

public class TroopPickerViewHelper
{
  private int jdField_a_of_type_Int = 15;
  private long jdField_a_of_type_Long;
  private ajgf jdField_a_of_type_Ajgf;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int b = 6;
  private int c = 22;
  private int d = 30;
  
  public TroopPickerViewHelper(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Activity paramActivity, TroopPickerViewHelper.OnConfirmListener paramOnConfirmListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2130969922, null);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(paramActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131368444));
      WheelPickerLayout.ViewStyle localViewStyle = new WheelPickerLayout.ViewStyle();
      paramActivity = paramActivity.getResources();
      localViewStyle.jdField_a_of_type_Int = 33;
      localViewStyle.b = 23;
      localViewStyle.c = paramActivity.getColor(2131494269);
      localViewStyle.d = 17;
      localViewStyle.e = 23;
      localViewStyle.f = paramActivity.getColor(2131494207);
      this.jdField_a_of_type_Ajgf = new ajgf(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Ajgf, localViewStyle);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new ajgd(this));
      paramActivity = localView.findViewById(2131364259);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new ajge(this, paramOnConfirmListener));
      }
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Ajgf.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Ajgf.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopPickerViewHelper
 * JD-Core Version:    0.7.0.1
 */