package com.tencent.mobileqq.settings.message;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatHistorySettingFragment$4
  implements ActionSheet.OnButtonClickListener
{
  ChatHistorySettingFragment$4(ChatHistorySettingFragment paramChatHistorySettingFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ReportController.a(ChatHistorySettingFragment.a(this.b), "0X800B879");
    if (!this.b.getBaseActivity().isFinishing())
    {
      this.a.cancel();
      ChatHistorySettingFragment.a(this.b, true);
    }
    ThreadManagerV2.excute(new ChatHistorySettingFragment.4.1(this), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.4
 * JD-Core Version:    0.7.0.1
 */