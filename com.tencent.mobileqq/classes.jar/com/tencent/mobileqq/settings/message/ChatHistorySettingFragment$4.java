package com.tencent.mobileqq.settings.message;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatHistorySettingFragment$4
  implements ActionSheet.OnButtonClickListener
{
  ChatHistorySettingFragment$4(ChatHistorySettingFragment paramChatHistorySettingFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReportController.a(ChatHistorySettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageChatHistorySettingFragment), "0X800B879");
    if (!this.jdField_a_of_type_ComTencentMobileqqSettingsMessageChatHistorySettingFragment.getActivity().isFinishing())
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      ChatHistorySettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageChatHistorySettingFragment, true);
    }
    ThreadManagerV2.excute(new ChatHistorySettingFragment.4.1(this), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.4
 * JD-Core Version:    0.7.0.1
 */