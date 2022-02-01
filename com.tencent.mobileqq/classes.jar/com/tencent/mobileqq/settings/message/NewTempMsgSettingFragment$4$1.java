package com.tencent.mobileqq.settings.message;

import android.view.View;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Map;

class NewTempMsgSettingFragment$4$1
  implements ActionSheet.OnButtonClickListener
{
  NewTempMsgSettingFragment$4$1(NewTempMsgSettingFragment.4 param4, TempMsgManager paramTempMsgManager, short paramShort, int paramInt, View paramView, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewTempMsgSettingFragment$4.a.a, "dc00898", "", "", this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.a(paramInt), this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.a(paramInt), this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.b(this.jdField_a_of_type_Short), 0, "", "", "", "");
    int i = this.jdField_a_of_type_Int;
    if (paramInt != i)
    {
      this.jdField_a_of_type_ComTencentMobileqqManagersTempMsgManager.a(this.jdField_a_of_type_Short, paramInt, i, true);
      paramView = this.jdField_a_of_type_AndroidViewView;
      if ((paramView instanceof QFormSimpleItem)) {
        ((QFormSimpleItem)paramView).setRightText((CharSequence)NewTempMsgSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewTempMsgSettingFragment$4.a).get(Integer.valueOf(paramInt)));
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NewTempMsgSettingFragment.4.1
 * JD-Core Version:    0.7.0.1
 */