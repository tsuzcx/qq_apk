package com.tencent.mobileqq.webview.swift.component;

import bcfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class SwiftBrowserStatistics$1
  implements Runnable
{
  public SwiftBrowserStatistics$1(bcfo parambcfo) {}
  
  public void run()
  {
    Object localObject2 = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject2 != null)
    {
      localObject1 = (TicketManager)((AppRuntime)localObject2).getManager(2);
      localObject2 = ((AppRuntime)localObject2).getAccount();
      if (localObject1 == null) {
        break label50;
      }
    }
    label50:
    for (Object localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);; localObject1 = "")
    {
      QLog.doReportLogSelf(AppSetting.a(), "FeedbackReport", "", (String)localObject2, (String)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.1
 * JD-Core Version:    0.7.0.1
 */