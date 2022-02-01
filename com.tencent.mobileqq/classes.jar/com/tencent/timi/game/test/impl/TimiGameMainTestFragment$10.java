package com.tencent.timi.game.test.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.team.impl.floating.FloatingTestFragment;

class TimiGameMainTestFragment$10
  implements View.OnClickListener
{
  TimiGameMainTestFragment$10(TimiGameMainTestFragment paramTimiGameMainTestFragment) {}
  
  public void onClick(View paramView)
  {
    QPublicFragmentActivity.start(this.a.getActivity(), FloatingTestFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.test.impl.TimiGameMainTestFragment.10
 * JD-Core Version:    0.7.0.1
 */