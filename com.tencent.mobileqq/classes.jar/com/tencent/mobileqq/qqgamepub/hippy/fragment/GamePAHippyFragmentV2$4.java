package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePAHippyFragmentV2$4
  implements View.OnClickListener
{
  GamePAHippyFragmentV2$4(GamePAHippyFragmentV2 paramGamePAHippyFragmentV2) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a;
    ((GamePAHippyFragmentV2)localObject).b(((GamePAHippyFragmentV2)localObject).a);
    localObject = this.a.getQBaseActivity();
    if (localObject != null) {
      ((QBaseActivity)localObject).finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2.4
 * JD-Core Version:    0.7.0.1
 */