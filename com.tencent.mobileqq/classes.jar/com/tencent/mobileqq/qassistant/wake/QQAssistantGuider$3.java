package com.tencent.mobileqq.qassistant.wake;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQAssistantGuider$3
  implements View.OnClickListener
{
  QQAssistantGuider$3(QQAssistantGuider paramQQAssistantGuider) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B44C", "0X800B44C", 0, 0, "", "", "", "");
    try
    {
      AssistantSwitchImpl.a(AssistantUtils.a(), false);
      WakeManager.a().a(false);
      this.a.a = -1;
      this.a.d = false;
      this.a.dismiss();
      QQToast.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131695295), 1).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AssistantUtils.a("HelloQQWake", "QQAssistantGuider cardHandler.setQQAssistantSwitch:" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.QQAssistantGuider.3
 * JD-Core Version:    0.7.0.1
 */