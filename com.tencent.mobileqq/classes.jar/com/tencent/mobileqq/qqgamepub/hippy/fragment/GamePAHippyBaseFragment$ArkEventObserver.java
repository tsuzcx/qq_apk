package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap.ArkEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class GamePAHippyBaseFragment$ArkEventObserver
  implements Observer
{
  private GamePAHippyBaseFragment$ArkEventObserver(GamePAHippyBaseFragment paramGamePAHippyBaseFragment) {}
  
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
        QLog.d("GamePAHippyBaseFragment", 1, paramObservable.toString());
        if ("gc_ark_notify_hippy".equals(((IArkPubicEventWrap.ArkEvent)paramObject).b))
        {
          GamePAHippyBaseFragment.a(this.a, ((IArkPubicEventWrap.ArkEvent)paramObject).c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment.ArkEventObserver
 * JD-Core Version:    0.7.0.1
 */