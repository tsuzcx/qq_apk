package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import ypc;
import ypd;

class GameActivity$24$1
  implements Runnable
{
  GameActivity$24$1(GameActivity.24 param24) {}
  
  public void run()
  {
    GameActivity.access$3700(this.this$1.this$0);
    ypc.a().a(this.this$1.this$0, new ypd());
    MiniGameAdBannerPopup.checkShouldShow(this.this$1.this$0, this.this$1.this$0.gameConfig);
    if ((GameActivity.access$3800(this.this$1.this$0) != null) && (GameActivity.access$3800(this.this$1.this$0).getCapsuleButton() != null))
    {
      GameActivity.access$3800(this.this$1.this$0).getCapsuleButton().showKingCardTips();
      GameActivity.access$3800(this.this$1.this$0).getCapsuleButton().updateRedDotVisible();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.24.1
 * JD-Core Version:    0.7.0.1
 */