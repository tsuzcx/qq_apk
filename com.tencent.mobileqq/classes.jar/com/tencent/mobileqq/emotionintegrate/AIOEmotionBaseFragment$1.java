package com.tencent.mobileqq.emotionintegrate;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOEmotionBaseFragment$1
  implements View.OnClickListener
{
  AIOEmotionBaseFragment$1(AIOEmotionBaseFragment paramAIOEmotionBaseFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */