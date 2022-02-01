package com.tencent.mobileqq.settings.message;

import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.DeleteRecordDialog.OnDeleteRecordDialogClickListener;

class ChatHistorySettingFragment$3
  implements DeleteRecordDialog.OnDeleteRecordDialogClickListener
{
  ChatHistorySettingFragment$3(ChatHistorySettingFragment paramChatHistorySettingFragment) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    ReportController.a(ChatHistorySettingFragment.a(this.a), "0X800B87A");
    if (!this.a.getActivity().isFinishing()) {
      ChatHistorySettingFragment.a(this.a, true);
    }
    ThreadManagerV2.excute(new ChatHistorySettingFragment.3.1(this), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.3
 * JD-Core Version:    0.7.0.1
 */