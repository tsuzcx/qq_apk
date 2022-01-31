package com.tencent.qqmini.proxyimpl;

import aljq;
import android.app.Activity;
import bdwy;
import bjwq;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.QLog;

class KingCardProxyImpl$1
  implements Runnable
{
  KingCardProxyImpl$1(KingCardProxyImpl paramKingCardProxyImpl, Activity paramActivity, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void run()
  {
    if (!KingCardProxyImpl.access$000(this.this$0))
    {
      bjwq.a().a(this.val$activity, this.val$moreView, KingCardProxyImpl.access$100(this.this$0), 1, 14.0F, 5.0D, 10.0D, 3000L, -16578534, false, true, 0, null, 0);
      KingCardProxyImpl.access$200(this.this$0);
    }
    for (;;)
    {
      this.val$moreView.addAnimatorListener(new KingCardProxyImpl.1.1(this));
      KingCardProxyImpl.access$300(this.this$0).a(this.val$moreView, MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE, aljq.ci + MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE.hashCode() + ".zip", true);
      return;
      QLog.i("KingCardProxyImpl", 1, "showKingCardTips, guide had been showed, not show this time");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.KingCardProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */