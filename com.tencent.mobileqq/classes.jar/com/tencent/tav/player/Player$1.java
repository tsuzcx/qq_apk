package com.tencent.tav.player;

class Player$1
  implements OnCompositionUpdateListener
{
  Player$1(Player paramPlayer, OnCompositionUpdateListener paramOnCompositionUpdateListener) {}
  
  public void onUpdated(Player paramPlayer, boolean paramBoolean)
  {
    OnCompositionUpdateListener localOnCompositionUpdateListener = this.val$updateListener;
    if (localOnCompositionUpdateListener != null) {
      localOnCompositionUpdateListener.onUpdated(paramPlayer, paramBoolean);
    }
    if (Player.access$000(this.this$0) != null) {
      Player.access$000(this.this$0).onUpdated(paramPlayer, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.player.Player.1
 * JD-Core Version:    0.7.0.1
 */