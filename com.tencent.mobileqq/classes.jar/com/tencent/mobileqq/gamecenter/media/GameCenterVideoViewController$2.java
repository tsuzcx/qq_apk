package com.tencent.mobileqq.gamecenter.media;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameCenterVideoViewController$2
  implements CompoundButton.OnCheckedChangeListener
{
  GameCenterVideoViewController$2(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    GameCenterVideoViewController.access$000(this.a).setShown(paramBoolean);
    if (GameCenterVideoViewController.access$100(this.a) != null) {
      GameCenterVideoViewController.access$100(this.a).a(paramBoolean, GameCenterVideoViewController.access$200(this.a));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.2
 * JD-Core Version:    0.7.0.1
 */