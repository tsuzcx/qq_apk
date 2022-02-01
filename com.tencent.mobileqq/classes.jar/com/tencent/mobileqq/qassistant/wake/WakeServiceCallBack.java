package com.tencent.mobileqq.qassistant.wake;

import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class WakeServiceCallBack
{
  public static WakeServiceCallBack a()
  {
    return WakeServiceCallBack.WakeServiceCallBackHolder.a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getWakeManagerTag(), 2, "WakeService onWake hello qq");
    }
    Object localObject = MobileQQ.sMobileQQ;
    IVoiceAssistantCore localIVoiceAssistantCore = null;
    localObject = ((MobileQQ)localObject).waitAppRuntime(null);
    if (localObject != null) {
      localIVoiceAssistantCore = (IVoiceAssistantCore)((AppRuntime)localObject).getRuntimeService(IVoiceAssistantCore.class, "");
    }
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.sendMessage(2);
    }
    ReportController.b(null, "dc00898", "", "", "0X800B167", "0X800B167", ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getReportType(), 0, "", "", "", "");
    if (((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getWakeDialogWakeReport()) {
      ReportController.b(null, "dc00898", "", "", "0X800B4FA", "0X800B4FA", ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getReportType(), 0, "", "", "", "");
    }
  }
  
  public void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeServiceCallBack
 * JD-Core Version:    0.7.0.1
 */