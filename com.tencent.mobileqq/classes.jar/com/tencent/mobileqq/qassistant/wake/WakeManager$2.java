package com.tencent.mobileqq.qassistant.wake;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;

class WakeManager$2
  implements Runnable
{
  WakeManager$2(WakeManager paramWakeManager, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    try
    {
      new QQAssistantGuider(this.a).show();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show guider error: ");
      localStringBuilder.append(localException.getMessage());
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
      QQAssistantGuider.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager.2
 * JD-Core Version:    0.7.0.1
 */