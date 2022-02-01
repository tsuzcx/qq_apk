package com.tencent.mobileqq.settings.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistorySettingFragment$1
  implements View.OnClickListener
{
  ChatHistorySettingFragment$1(ChatHistorySettingFragment paramChatHistorySettingFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.a(ChatHistorySettingFragment.a(this.a), "0X800B876");
    MsgBackupAuthProcessor.a().a(1);
    QPublicFragmentActivity.startForResult(this.a.getActivity(), MsgBackupPCAuthFragment.class, 1000);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.1
 * JD-Core Version:    0.7.0.1
 */