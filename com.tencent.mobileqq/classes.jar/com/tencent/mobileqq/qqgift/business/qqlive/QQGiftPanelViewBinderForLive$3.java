package com.tencent.mobileqq.qqgift.business.qqlive;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqgift.mvvm.business.SingleEventWrapper;
import com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelPageAdapter;

class QQGiftPanelViewBinderForLive$3
  implements Observer<SingleEventWrapper<Boolean>>
{
  QQGiftPanelViewBinderForLive$3(QQGiftPanelViewBinderForLive paramQQGiftPanelViewBinderForLive) {}
  
  public void a(SingleEventWrapper<Boolean> paramSingleEventWrapper)
  {
    paramSingleEventWrapper = (Boolean)paramSingleEventWrapper.a();
    if ((paramSingleEventWrapper != null) && (paramSingleEventWrapper.booleanValue()) && (QQGiftPanelViewBinderForLive.a(this.a) != null)) {
      QQGiftPanelViewBinderForLive.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewBinderForLive.3
 * JD-Core Version:    0.7.0.1
 */