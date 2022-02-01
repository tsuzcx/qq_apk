package com.tencent.mobileqq.troop.homework.entry.ui.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.widget.ActionSheet;

public class HwkTimePicker
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private HwkTimePicker.OnConfirmBtnClickListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker$OnConfirmBtnClickListener;
  private HwkTimePicker.OnDismissListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker$OnDismissListener;
  private HwkTimePicker.OnItemSelectedListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker$OnItemSelectedListener;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private int jdField_b_of_type_Int;
  private HwkTimePicker.OnItemSelectedListener jdField_b_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker$OnItemSelectedListener;
  private int c;
  
  public HwkTimePicker(Context paramContext, IphonePickerView.PickerViewAdapter paramPickerViewAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = paramPickerViewAdapter;
  }
  
  public IphonePickerView.PickerViewAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561132, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setCloseAutoRead(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131361999);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new HwkTimePicker.1(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.registerWatchDisMissActionListener(new HwkTimePicker.2(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          this.c = paramInt2;
        }
      }
      else {
        this.jdField_b_of_type_Int = paramInt2;
      }
    }
    else {
      this.jdField_a_of_type_Int = paramInt2;
    }
    IphonePickerView localIphonePickerView = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    if (localIphonePickerView != null) {
      localIphonePickerView.setSelection(paramInt1, paramInt2);
    }
  }
  
  public void a(HwkTimePicker.OnConfirmBtnClickListener paramOnConfirmBtnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker$OnConfirmBtnClickListener = paramOnConfirmBtnClickListener;
  }
  
  public void a(HwkTimePicker.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker$OnDismissListener = paramOnDismissListener;
  }
  
  public void b()
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimePicker
 * JD-Core Version:    0.7.0.1
 */