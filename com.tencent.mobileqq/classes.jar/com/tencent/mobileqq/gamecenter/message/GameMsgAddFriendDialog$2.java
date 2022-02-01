package com.tencent.mobileqq.gamecenter.message;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.BaseActivity;

class GameMsgAddFriendDialog$2
  implements Animation.AnimationListener
{
  GameMsgAddFriendDialog$2(GameMsgAddFriendDialog paramGameMsgAddFriendDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    GameMsgAddFriendDialog.a(Float.valueOf(1.0F), GameMsgAddFriendDialog.a(this.a).getWindow());
    GameMsgAddFriendDialog.a(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgAddFriendDialog.2
 * JD-Core Version:    0.7.0.1
 */