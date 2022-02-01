package com.tencent.mobileqq.kandian.biz.fastweb.event;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ItemShowDispatcher$CheckAndStartWebProcessRunnable
  implements Runnable
{
  private WeakReference<QQAppInterface> a;
  
  public ItemShowDispatcher$CheckAndStartWebProcessRunnable(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist())
    {
      if (QLog.isColorLevel()) {
        QLog.d(ItemShowDispatcher.a(), 2, "checkWebProcess WebProcess Already Exist.");
      }
      return;
    }
    Object localObject = this.a;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (IWebProcessManagerService)((QQAppInterface)this.a.get()).getRuntimeService(IWebProcessManagerService.class, "");
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(ItemShowDispatcher.a(), 2, "checkWebProcess start preload web process");
        }
        ((IWebProcessManagerService)localObject).startWebProcess(-1, null);
      }
      if (QLog.isColorLevel()) {
        QLog.d(ItemShowDispatcher.a(), 2, "checkWebProcess enter preload web process");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher.CheckAndStartWebProcessRunnable
 * JD-Core Version:    0.7.0.1
 */