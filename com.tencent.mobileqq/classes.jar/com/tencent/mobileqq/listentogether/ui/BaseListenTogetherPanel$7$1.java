package com.tencent.mobileqq.listentogether.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseListenTogetherPanel$7$1
  implements View.OnClickListener
{
  BaseListenTogetherPanel$7$1(BaseListenTogetherPanel.7 param7) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.7.1
 * JD-Core Version:    0.7.0.1
 */