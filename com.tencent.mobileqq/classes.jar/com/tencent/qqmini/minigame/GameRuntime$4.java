package com.tencent.qqmini.minigame;

import com.tencent.qqmini.sdk.action.UpdateUIAction;

class GameRuntime$4
  implements Runnable
{
  GameRuntime$4(GameRuntime paramGameRuntime) {}
  
  public void run()
  {
    GameRuntime.access$100(this.this$0).showKingCardTips();
    UpdateUIAction.updateRedDot(this.this$0);
    if (this.this$0.isLoadingAdShowing())
    {
      this.this$0.pauseEngineOnly();
      return;
    }
    GameRuntime.access$100(this.this$0).checkPayForFriendLogic(GameRuntime.access$300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.4
 * JD-Core Version:    0.7.0.1
 */