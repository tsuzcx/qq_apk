package com.tencent.qqmini.minigame.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VConsoleLogManager$1
  implements View.OnClickListener
{
  VConsoleLogManager$1(VConsoleLogManager paramVConsoleLogManager) {}
  
  public void onClick(View paramView)
  {
    VConsoleLogManager.access$000(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.VConsoleLogManager.1
 * JD-Core Version:    0.7.0.1
 */