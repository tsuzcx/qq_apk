package com.tencent.mobileqq.qqlive.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameListAdapter$1
  implements View.OnClickListener
{
  GameListAdapter$1(GameListAdapter paramGameListAdapter, GameItem paramGameItem, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (GameListAdapter.a(this.c) != null) {
      GameListAdapter.a(this.c).a(paramView, this.a, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */