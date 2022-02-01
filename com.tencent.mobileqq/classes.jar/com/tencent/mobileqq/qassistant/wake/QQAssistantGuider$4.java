package com.tencent.mobileqq.qassistant.wake;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQAssistantGuider$4
  implements View.OnClickListener
{
  QQAssistantGuider$4(QQAssistantGuider paramQQAssistantGuider) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B44D", "0X800B44D", 1, 0, "", "", "", "");
    QQAssistantGuider localQQAssistantGuider = this.a;
    localQQAssistantGuider.a = -1;
    localQQAssistantGuider.dismiss();
    try
    {
      AssistantSwitchImpl.a(AssistantUtils.a(), true);
      WakeManager.a().a(true);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQAssistantGuider cardHandler.setQQAssistantSwitch:");
      localStringBuilder.append(localException.getMessage());
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.QQAssistantGuider.4
 * JD-Core Version:    0.7.0.1
 */