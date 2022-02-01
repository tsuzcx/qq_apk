package com.tencent.timi.game.test.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.live.impl.danmuku.TestDanmakuFragment;

class TimiGameMainTestFragment$7
  implements View.OnClickListener
{
  TimiGameMainTestFragment$7(TimiGameMainTestFragment paramTimiGameMainTestFragment) {}
  
  public void onClick(View paramView)
  {
    QPublicFragmentActivity.start(this.a.getActivity(), TestDanmakuFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.test.impl.TimiGameMainTestFragment.7
 * JD-Core Version:    0.7.0.1
 */