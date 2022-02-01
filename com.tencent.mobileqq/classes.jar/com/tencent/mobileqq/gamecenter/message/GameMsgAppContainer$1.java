package com.tencent.mobileqq.gamecenter.message;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class GameMsgAppContainer$1
  implements View.OnAttachStateChangeListener
{
  GameMsgAppContainer$1(GameMsgAppContainer paramGameMsgAppContainer) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    if (GameMsgAppContainer.a(this.a)) {
      return;
    }
    GameMsgAppContainer.a(this.a, true);
    GameMsgAppContainer.a(this.a);
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgAppContainer.1
 * JD-Core Version:    0.7.0.1
 */