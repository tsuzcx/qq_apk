package com.tencent.mobileqq.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QQSettingChatOperationFragment$2
  implements ActionSheet.OnButtonClickListener
{
  QQSettingChatOperationFragment$2(QQSettingChatOperationFragment paramQQSettingChatOperationFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReportController.b(QQSettingChatOperationFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentQQSettingChatOperationFragment), "CliOper", "", "", "Setting_tab", "Clk_clean_msg", 0, 0, "0", "0", "", "");
    ReportController.b(QQSettingChatOperationFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentQQSettingChatOperationFragment), "dc00898", "", "", "0X800A0C3", "0X800A0C3", 0, 0, "", "", "", "");
    if (!this.jdField_a_of_type_ComTencentMobileqqFragmentQQSettingChatOperationFragment.getActivity().isFinishing())
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      QQSettingChatOperationFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentQQSettingChatOperationFragment, true);
    }
    ThreadManagerV2.excute(new QQSettingChatOperationFragment.2.1(this), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.2
 * JD-Core Version:    0.7.0.1
 */