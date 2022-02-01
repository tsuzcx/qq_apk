package com.tencent.mobileqq.gamecenter.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgAppContainer$2
  implements View.OnClickListener
{
  GameMsgAppContainer$2(GameMsgAppContainer paramGameMsgAppContainer) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgAppContainer.2
 * JD-Core Version:    0.7.0.1
 */