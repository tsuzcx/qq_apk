package com.tencent.mobileqq.emotionintegrate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOEmotionBaseFragment$2
  implements View.OnClickListener
{
  AIOEmotionBaseFragment$2(AIOEmotionBaseFragment paramAIOEmotionBaseFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a("0X8009980");
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */