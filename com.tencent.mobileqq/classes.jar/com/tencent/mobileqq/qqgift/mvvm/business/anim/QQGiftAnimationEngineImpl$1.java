package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import com.tencent.mobileqq.qqgift.callback.IQQGiftEngineAnimationListener;
import java.util.Iterator;
import java.util.List;

class QQGiftAnimationEngineImpl$1
  implements IQQGiftEngineAnimationListener
{
  QQGiftAnimationEngineImpl$1(QQGiftAnimationEngineImpl paramQQGiftAnimationEngineImpl) {}
  
  public void onAnimationEnd(GiftAnimData paramGiftAnimData)
  {
    Iterator localIterator = this.a.g.iterator();
    while (localIterator.hasNext()) {
      ((IQQGiftEngineAnimationListener)localIterator.next()).onAnimationEnd(paramGiftAnimData);
    }
    QQGiftAnimationEngineImpl.a(this.a);
  }
  
  public void onAnimationStart(GiftAnimData paramGiftAnimData)
  {
    this.a.a.setVisibility(0);
    Object localObject = this.a;
    ((QQGiftAnimationEngineImpl)localObject).e = true;
    localObject = ((QQGiftAnimationEngineImpl)localObject).g.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IQQGiftEngineAnimationListener)((Iterator)localObject).next()).onAnimationStart(paramGiftAnimData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.QQGiftAnimationEngineImpl.1
 * JD-Core Version:    0.7.0.1
 */