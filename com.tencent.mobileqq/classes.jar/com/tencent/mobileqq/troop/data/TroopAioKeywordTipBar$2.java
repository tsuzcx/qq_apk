package com.tencent.mobileqq.troop.data;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;

class TroopAioKeywordTipBar$2
  implements Animation.AnimationListener
{
  TroopAioKeywordTipBar$2(TroopAioKeywordTipBar paramTroopAioKeywordTipBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (TroopAioKeywordTipBar.c(this.a) != null) {
      TroopAioKeywordTipBar.c(this.a).a.clearAnimation();
    }
    TroopAioKeywordTipBar.d(this.a);
    if ((TroopAioKeywordTipBar.b(this.a) != null) && (!TroopAioKeywordTipBar.b(this.a).isSend())) {
      ((TroopAioKeywordTipManager)this.a.D.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER)).a(this.a.D.getCurrentAccountUin(), TroopAioKeywordTipBar.b(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(TroopAioKeywordTipBar.e(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.2
 * JD-Core Version:    0.7.0.1
 */