package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmotionBatchForwardOption$1
  implements View.OnClickListener
{
  EmotionBatchForwardOption$1(EmotionBatchForwardOption paramEmotionBatchForwardOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.A != null)
    {
      this.a.A.hideSoftInputFromWindow();
      EmotionBatchForwardOption localEmotionBatchForwardOption = this.a;
      EmotionBatchForwardOption.a(localEmotionBatchForwardOption, localEmotionBatchForwardOption.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.EmotionBatchForwardOption.1
 * JD-Core Version:    0.7.0.1
 */