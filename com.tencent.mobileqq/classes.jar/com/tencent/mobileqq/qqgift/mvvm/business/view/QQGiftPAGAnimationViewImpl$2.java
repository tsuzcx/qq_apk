package com.tencent.mobileqq.qqgift.mvvm.business.view;

import com.tencent.mobileqq.qqgift.utils.PagLoader.PagLoadListener;
import com.tencent.mobileqq.qqgift.utils.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class QQGiftPAGAnimationViewImpl$2
  implements PagLoader.PagLoadListener
{
  QQGiftPAGAnimationViewImpl$2(QQGiftPAGAnimationViewImpl paramQQGiftPAGAnimationViewImpl) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.i("QQGiftPAGAnimationViewImpl", 1, "loadPag success");
      ThreadManager.a(new QQGiftPAGAnimationViewImpl.2.1(this));
      return;
    }
    QLog.e("QQGiftPAGAnimationViewImpl", 1, "loadPag failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPAGAnimationViewImpl.2
 * JD-Core Version:    0.7.0.1
 */