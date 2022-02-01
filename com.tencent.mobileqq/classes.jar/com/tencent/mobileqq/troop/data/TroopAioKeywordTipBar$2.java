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
    if (TroopAioKeywordTipBar.a(this.a) != null) {
      TroopAioKeywordTipBar.a(this.a).a.clearAnimation();
    }
    TroopAioKeywordTipBar.a(this.a);
    if ((TroopAioKeywordTipBar.a(this.a) != null) && (!TroopAioKeywordTipBar.a(this.a).isSend())) {
      ((TroopAioKeywordTipManager)this.a.a.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER)).a(this.a.a.getCurrentAccountUin(), TroopAioKeywordTipBar.a(this.a).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(TroopAioKeywordTipBar.a(this.a).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.2
 * JD-Core Version:    0.7.0.1
 */