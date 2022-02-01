package com.tencent.mobileqq.troop.data;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopAioKeywordTipBar$3
  implements Animation.AnimationListener
{
  TroopAioKeywordTipBar$3(TroopAioKeywordTipBar paramTroopAioKeywordTipBar, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (TroopAioKeywordTipBar.c(this.b) != null)
    {
      TroopAioKeywordTipBar.c(this.b).a.clearAnimation();
      TroopAioKeywordTipBar.c(this.b).a.setVisibility(8);
    }
    TroopAioKeywordTipBar.b(this.b, false);
    TroopAioKeywordTipBar.a(this.b, null);
    TroopAioKeywordTipBar.a(this.b, null);
    TroopAioKeywordTipBar.a(this.b, -1);
    if ((!this.a) && (!TroopAioKeywordTipBar.f(this.b)))
    {
      ThreadManager.getUIHandler().post(TroopAioKeywordTipBar.g(this.b));
      TroopAioKeywordTipBar.c(this.b, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.3
 * JD-Core Version:    0.7.0.1
 */