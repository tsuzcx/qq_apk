package com.tencent.mobileqq.qassistant.wake;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;

class QQAssistantGuider$5
  implements View.OnClickListener
{
  QQAssistantGuider$5(QQAssistantGuider paramQQAssistantGuider, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B44D", "0X800B44D", 2, 0, "", "", "", "");
    try
    {
      AssistantSwitchImpl.a(AssistantUtils.c(), true);
      WakeManager.a().a(true);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQAssistantGuider cardHandler.setQQAssistantSwitch:");
      localStringBuilder.append(localException.getMessage());
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
    }
    if (!this.a)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B44E", "0X800B44E", 1, 0, "", "", "", "");
      this.c.e.requestPermissions(new QQAssistantGuider.5.1(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
    }
    if (!this.b)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B44E", "0X800B44E", 2, 0, "", "", "", "");
      ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).requestPermission(this.c.e);
    }
    QQAssistantGuider localQQAssistantGuider = this.c;
    localQQAssistantGuider.g = -1;
    if (!this.a) {
      localQQAssistantGuider.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.QQAssistantGuider.5
 * JD-Core Version:    0.7.0.1
 */