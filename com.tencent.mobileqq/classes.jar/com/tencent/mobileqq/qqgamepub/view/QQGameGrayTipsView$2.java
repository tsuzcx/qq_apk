package com.tencent.mobileqq.qqgamepub.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.AppSubscribeInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGameSubscribeBusEvent;
import com.tencent.mobileqq.qroute.QRoute;

class QQGameGrayTipsView$2
  extends AnimatorListenerAdapter
{
  QQGameGrayTipsView$2(QQGameGrayTipsView paramQQGameGrayTipsView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isInValidGameAppId(QQGameGrayTipsView.c(this.a).gameAppId))
    {
      paramAnimator = new QQGameSubscribeBusEvent(5);
      QQGamePubSubscribe.AppSubscribeInfo localAppSubscribeInfo = new QQGamePubSubscribe.AppSubscribeInfo();
      localAppSubscribeInfo.appid.set(Integer.parseInt(QQGameGrayTipsView.c(this.a).gameAppId));
      paramAnimator.subscribeInfo = localAppSubscribeInfo;
      SimpleEventBus.getInstance().dispatchEvent(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.QQGameGrayTipsView.2
 * JD-Core Version:    0.7.0.1
 */