package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import yyw;
import yyx;

class GameActivity$26$1
  implements Runnable
{
  GameActivity$26$1(GameActivity.26 param26) {}
  
  public void run()
  {
    GameActivity.access$3900(this.this$1.this$0);
    yyw.a().a(this.this$1.this$0, new yyx());
    MiniGameAdBannerPopup.checkShouldShow(this.this$1.this$0, this.this$1.this$0.mGameAppConfig);
    if ((GameActivity.access$4000(this.this$1.this$0) != null) && (GameActivity.access$4000(this.this$1.this$0).getCapsuleButton() != null))
    {
      GameActivity.access$4000(this.this$1.this$0).getCapsuleButton().showKingCardTips();
      GameActivity.access$4000(this.this$1.this$0).getCapsuleButton().updateRedDotVisible();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.26.1
 * JD-Core Version:    0.7.0.1
 */