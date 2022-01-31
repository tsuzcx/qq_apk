package com.tencent.mobileqq.minigame.ui;

import aath;
import aati;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;

class GameActivity$27$1
  implements Runnable
{
  GameActivity$27$1(GameActivity.27 param27) {}
  
  public void run()
  {
    GameActivity.access$4500(this.this$1.this$0);
    aath.a().a(this.this$1.this$0, new aati());
    MiniGameAdBannerPopup.checkShouldShow(this.this$1.this$0, this.this$1.this$0.mGameAppConfig);
    if ((GameActivity.access$4600(this.this$1.this$0) != null) && (GameActivity.access$4600(this.this$1.this$0).getCapsuleButton() != null))
    {
      GameActivity.access$4600(this.this$1.this$0).getCapsuleButton().showKingCardTips();
      GameActivity.access$4600(this.this$1.this$0).getCapsuleButton().updateRedDotVisible();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.27.1
 * JD-Core Version:    0.7.0.1
 */