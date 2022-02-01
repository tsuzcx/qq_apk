package com.tencent.mobileqq.gamecenter.hippy;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePAHippyFragmentV2$4
  implements View.OnClickListener
{
  GamePAHippyFragmentV2$4(GamePAHippyFragmentV2 paramGamePAHippyFragmentV2) {}
  
  public void onClick(View paramView)
  {
    this.a.a(this.a.a);
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePAHippyFragmentV2.4
 * JD-Core Version:    0.7.0.1
 */