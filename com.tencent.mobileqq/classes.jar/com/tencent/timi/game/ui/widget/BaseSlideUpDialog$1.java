package com.tencent.timi.game.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseSlideUpDialog$1
  implements View.OnClickListener
{
  BaseSlideUpDialog$1(BaseSlideUpDialog paramBaseSlideUpDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.BaseSlideUpDialog.1
 * JD-Core Version:    0.7.0.1
 */