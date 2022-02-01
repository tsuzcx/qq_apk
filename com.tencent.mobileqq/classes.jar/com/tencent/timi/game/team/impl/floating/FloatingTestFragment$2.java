package com.tencent.timi.game.team.impl.floating;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FloatingTestFragment$2
  implements View.OnClickListener
{
  FloatingTestFragment$2(FloatingTestFragment paramFloatingTestFragment) {}
  
  public void onClick(View paramView)
  {
    FloatingTestFragment.a(this.a).b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.FloatingTestFragment.2
 * JD-Core Version:    0.7.0.1
 */