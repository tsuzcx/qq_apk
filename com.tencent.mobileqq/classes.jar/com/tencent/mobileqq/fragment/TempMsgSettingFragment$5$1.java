package com.tencent.mobileqq.fragment;

import android.view.View;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Map;

class TempMsgSettingFragment$5$1
  implements ActionSheet.OnButtonClickListener
{
  TempMsgSettingFragment$5$1(TempMsgSettingFragment.5 param5, TempMsgManager paramTempMsgManager, short paramShort, int paramInt, View paramView, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFragmentTempMsgSettingFragment$5.a.a, "dc00898", "", "", this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.a(paramInt), this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.a(paramInt), this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.b(this.jdField_a_of_type_Short), 0, "", "", "", "");
    int i = this.jdField_a_of_type_Int;
    if (paramInt != i)
    {
      this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.a(this.jdField_a_of_type_Short, paramInt, i, true);
      paramView = this.jdField_a_of_type_AndroidViewView;
      if ((paramView instanceof QFormSimpleItem)) {
        ((QFormSimpleItem)paramView).setRightText((CharSequence)TempMsgSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentTempMsgSettingFragment$5.a).get(Integer.valueOf(paramInt)));
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TempMsgSettingFragment.5.1
 * JD-Core Version:    0.7.0.1
 */