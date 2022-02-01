package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenterV2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePAHippyFragmentV2$2
  implements View.OnClickListener
{
  GamePAHippyFragmentV2$2(GamePAHippyFragmentV2 paramGamePAHippyFragmentV2) {}
  
  public void onClick(View paramView)
  {
    ((QQGameHippyPresenterV2)this.a.a).v();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2.2
 * JD-Core Version:    0.7.0.1
 */