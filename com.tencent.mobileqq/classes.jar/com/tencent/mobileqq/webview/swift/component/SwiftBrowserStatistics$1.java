package com.tencent.mobileqq.webview.swift.component;

import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

class SwiftBrowserStatistics$1
  implements Runnable
{
  SwiftBrowserStatistics$1(SwiftBrowserStatistics paramSwiftBrowserStatistics) {}
  
  public void run()
  {
    Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject2 != null)
    {
      Object localObject1 = (TicketManager)((AppRuntime)localObject2).getManager(2);
      localObject2 = ((AppRuntime)localObject2).getAccount();
      if (localObject1 != null) {
        localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);
      } else {
        localObject1 = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 2, new Object[] { Integer.valueOf(AppSetting.a()), "FeedbackReport", "", localObject2, localObject1 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.1
 * JD-Core Version:    0.7.0.1
 */