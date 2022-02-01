package com.tencent.mobileqq.fragment;

import android.os.Handler;
import com.tencent.mobileqq.managers.TroopAssistantManager;

class QQSettingChatOperationFragment$1$1
  implements Runnable
{
  QQSettingChatOperationFragment$1$1(QQSettingChatOperationFragment.1 param1) {}
  
  public void run()
  {
    this.a.a.b();
    TroopAssistantManager.a().r(QQSettingChatOperationFragment.a(this.a.a));
    this.a.a.d.sendEmptyMessageDelayed(0, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.1.1
 * JD-Core Version:    0.7.0.1
 */