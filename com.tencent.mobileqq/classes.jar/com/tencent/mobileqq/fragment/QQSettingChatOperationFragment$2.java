package com.tencent.mobileqq.fragment;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QQSettingChatOperationFragment$2
  implements ActionSheet.OnButtonClickListener
{
  QQSettingChatOperationFragment$2(QQSettingChatOperationFragment paramQQSettingChatOperationFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ReportController.b(QQSettingChatOperationFragment.a(this.b), "CliOper", "", "", "Setting_tab", "Clk_clean_msg", 0, 0, "0", "0", "", "");
    ReportController.b(QQSettingChatOperationFragment.a(this.b), "dc00898", "", "", "0X800A0C3", "0X800A0C3", 0, 0, "", "", "", "");
    if (!this.b.getBaseActivity().isFinishing())
    {
      this.a.cancel();
      QQSettingChatOperationFragment.a(this.b, true);
    }
    ThreadManagerV2.excute(new QQSettingChatOperationFragment.2.1(this), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.2
 * JD-Core Version:    0.7.0.1
 */