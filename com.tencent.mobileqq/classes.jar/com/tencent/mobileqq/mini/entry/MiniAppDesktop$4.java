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
    Object localObject = this.val$app;
    if (localObject == null) {
      return;
    }
    localObject = (AppletsHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
    if (localObject != null)
    {
      ((AppletsHandler)localObject).a();
      ((AppletsHandler)localObject).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDesktop.4
 * JD-Core Version:    0.7.0.1
 */