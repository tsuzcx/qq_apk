package com.tencent.mobileqq.gamecenter.ui;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class GameMsgAddFriendDialog$2
  implements Animation.AnimationListener
{
  GameMsgAddFriendDialog$2(GameMsgAddFriendDialog paramGameMsgAddFriendDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    GameMsgAddFriendDialog.a(Float.valueOf(1.0F), GameMsgAddFriendDialog.a(this.a).getWindow());
    GameMsgAddFriendDialog.b(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.GameMsgAddFriendDialog.2
 * JD-Core Version:    0.7.0.1
 */