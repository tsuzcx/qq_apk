package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.AppletsHandler;

class MiniAppDesktop$4
  implements Runnable
{
  MiniAppDesktop$4(MiniAppDesktop paramMiniAppDesktop, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.val$app == null) {}
    AppletsHandler localAppletsHandler;
    do
    {
      return;
      localAppletsHandler = (AppletsHandler)this.val$app.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
    } while (localAppletsHandler == null);
    localAppletsHandler.a();
    localAppletsHandler.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDesktop.4
 * JD-Core Version:    0.7.0.1
 */