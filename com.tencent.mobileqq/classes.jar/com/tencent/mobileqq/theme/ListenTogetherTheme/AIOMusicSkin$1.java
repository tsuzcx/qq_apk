package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

class AIOMusicSkin$1
  implements View.OnClickListener
{
  AIOMusicSkin$1(AIOMusicSkin paramAIOMusicSkin) {}
  
  public void onClick(View paramView)
  {
    AIOMusicSkin.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.1
 * JD-Core Version:    0.7.0.1
 */