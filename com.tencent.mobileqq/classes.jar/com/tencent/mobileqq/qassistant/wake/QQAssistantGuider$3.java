package com.tencent.mobileqq.qassistant.wake;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class QQAssistantGuider$3
  implements View.OnClickListener
{
  QQAssistantGuider$3(QQAssistantGuider paramQQAssistantGuider) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B44C", "0X800B44C", 0, 0, "", "", "", "");
    try
    {
      AssistantSwitchImpl.a(AssistantUtils.c(), false);
      WakeManager.a().a(false);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQAssistantGuider cardHandler.setQQAssistantSwitch:");
      localStringBuilder.append(localException.getMessage());
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
    }
    QQAssistantGuider localQQAssistantGuider = this.a;
    localQQAssistantGuider.g = -1;
    localQQAssistantGuider.d = false;
    localQQAssistantGuider.dismiss();
    QQToast.makeText(MobileQQ.sMobileQQ, 2, MobileQQ.sMobileQQ.getString(2131893039), 1).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.QQAssistantGuider.3
 * JD-Core Version:    0.7.0.1
 */