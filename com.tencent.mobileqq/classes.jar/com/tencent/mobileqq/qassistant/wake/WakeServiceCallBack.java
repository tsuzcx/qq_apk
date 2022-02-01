package com.tencent.mobileqq.qassistant.wake;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantManager;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.statistics.ReportController;

public class WakeServiceCallBack
{
  public static WakeServiceCallBack a()
  {
    return WakeServiceCallBack.WakeServiceCallBackHolder.a();
  }
  
  public void a()
  {
    AssistantUtils.a("HelloQQWake", "WakeService onWake hello qq");
    Object localObject = AssistantUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (VoiceAssistantManager)((QQAppInterface)localObject).getManager(QQManagerFactory.VOICE_ASSISTANT_MANAGER);
      if (localObject != null) {
        ((VoiceAssistantManager)localObject).a(2);
      }
      ReportController.b(null, "dc00898", "", "", "0X800B167", "0X800B167", CommandUtils.a(), 0, "", "", "", "");
    } while (!WakeDialog.a);
    ReportController.b(null, "dc00898", "", "", "0X800B4FA", "0X800B4FA", CommandUtils.a(), 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeServiceCallBack
 * JD-Core Version:    0.7.0.1
 */