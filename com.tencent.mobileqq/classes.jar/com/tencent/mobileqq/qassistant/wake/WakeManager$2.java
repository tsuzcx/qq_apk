package com.tencent.mobileqq.qassistant.wake;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;

class WakeManager$2
  implements Runnable
{
  WakeManager$2(WakeManager paramWakeManager, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    try
    {
      new QQAssistantGuider(this.a).show();
      return;
    }
    catch (Exception localException)
    {
      AssistantUtils.a("HelloQQWake", "show guider error: " + localException.getMessage());
      QQAssistantGuider.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager.2
 * JD-Core Version:    0.7.0.1
 */