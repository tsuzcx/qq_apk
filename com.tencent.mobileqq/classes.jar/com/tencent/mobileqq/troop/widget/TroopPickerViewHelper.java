package com.tencent.mobileqq.troop.widget;

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
  private TroopPickerViewHelper.DateAdapter jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper$DateAdapter;
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
      View localView = paramActivity.getLayoutInflater().inflate(2131560680, null);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(paramActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setCloseAutoRead(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131379138));
      WheelPickerLayout.ViewStyle localViewStyle = new WheelPickerLayout.ViewStyle();
      paramActivity = paramActivity.getResources();
      localViewStyle.jdField_a_of_type_Int = 33;
      localViewStyle.b = 23;
      localViewStyle.c = paramActivity.getColor(2131167151);
      localViewStyle.d = 17;
      localViewStyle.e = 23;
      localViewStyle.f = paramActivity.getColor(2131167056);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper$DateAdapter = new TroopPickerViewHelper.DateAdapter(this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper$DateAdapter, localViewStyle);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new TroopPickerViewHelper.1(this));
      paramActivity = localView.findViewById(2131363894);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new TroopPickerViewHelper.2(this, paramOnConfirmListener));
      }
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      paramActivity = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper$DateAdapter.a(this.jdField_a_of_type_Long);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(i);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper$DateAdapter.a(paramActivity);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopPickerViewHelper
 * JD-Core Version:    0.7.0.1
 */