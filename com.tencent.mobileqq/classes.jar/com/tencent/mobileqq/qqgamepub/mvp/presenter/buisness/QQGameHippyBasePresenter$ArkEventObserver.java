package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap.ArkEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class QQGameHippyBasePresenter$ArkEventObserver
  implements Observer
{
  private QQGameHippyBasePresenter$ArkEventObserver(QQGameHippyBasePresenter paramQQGameHippyBasePresenter) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    try
    {
      if ((paramObject instanceof IArkPubicEventWrap.ArkEvent))
      {
        paramObservable = new StringBuilder();
        paramObservable.append("ark transfer data:");
        paramObservable.append(((IArkPubicEventWrap.ArkEvent)paramObject).c);
        paramObservable.append(",appName:");
        paramObservable.append(((IArkPubicEventWrap.ArkEvent)paramObject).a);
        paramObservable.append(",eventName:");
        paramObservable.append(((IArkPubicEventWrap.ArkEvent)paramObject).b);
        QLog.d("QQGamePub_QQGameHippyBasePresenter", 1, paramObservable.toString());
        if ("gc_ark_notify_hippy".equals(((IArkPubicEventWrap.ArkEvent)paramObject).b))
        {
          QQGameHippyBasePresenter.a(this.a, ((IArkPubicEventWrap.ArkEvent)paramObject).c);
          return;
        }
      }
    }
    catch (Throwable paramObservable)
    {
      paramObservable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter.ArkEventObserver
 * JD-Core Version:    0.7.0.1
 */