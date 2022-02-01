package com.tencent.mobileqq.settings.message;

import android.os.Handler;
import com.tencent.mobileqq.managers.TroopAssistantManager;

class ChatHistorySettingFragment$3$1
  implements Runnable
{
  ChatHistorySettingFragment$3$1(ChatHistorySettingFragment.3 param3) {}
  
  public void run()
  {
    this.a.a.b();
    TroopAssistantManager.a().j(ChatHistorySettingFragment.a(this.a.a));
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */