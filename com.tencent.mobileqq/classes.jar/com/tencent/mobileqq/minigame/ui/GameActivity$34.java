package com.tencent.mobileqq.minigame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameActivity$34
  implements View.OnClickListener
{
  GameActivity$34(GameActivity paramGameActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.quitDebugSocket();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.34
 * JD-Core Version:    0.7.0.1
 */