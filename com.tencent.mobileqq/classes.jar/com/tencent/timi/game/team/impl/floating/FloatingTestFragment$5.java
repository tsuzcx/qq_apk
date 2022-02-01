package com.tencent.timi.game.team.impl.floating;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FloatingTestFragment$5
  implements View.OnClickListener
{
  FloatingTestFragment$5(FloatingTestFragment paramFloatingTestFragment) {}
  
  public void onClick(View paramView)
  {
    FloatingTestFragment.b(this.a).setTeamStateWithAnim("游戏中");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.FloatingTestFragment.5
 * JD-Core Version:    0.7.0.1
 */