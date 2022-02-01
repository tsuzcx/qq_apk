package com.tencent.mobileqq.settings.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupMigrateFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistorySettingFragment$2
  implements View.OnClickListener
{
  ChatHistorySettingFragment$2(ChatHistorySettingFragment paramChatHistorySettingFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.a(ChatHistorySettingFragment.a(this.a), "0X800B875");
    QPublicFragmentActivity.startForResult(this.a.getBaseActivity(), MsgBackupMigrateFragment.class, 1000);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.2
 * JD-Core Version:    0.7.0.1
 */