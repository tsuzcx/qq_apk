package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.AppletsHandler;

class QQMessagePageMiniAppEntryManager$2
  implements Runnable
{
  QQMessagePageMiniAppEntryManager$2(QQMessagePageMiniAppEntryManager paramQQMessagePageMiniAppEntryManager, QQAppInterface paramQQAppInterface) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager.2
 * JD-Core Version:    0.7.0.1
 */