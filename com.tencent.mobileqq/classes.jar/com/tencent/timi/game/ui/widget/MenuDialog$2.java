package com.tencent.timi.game.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MenuDialog$2
  implements View.OnClickListener
{
  MenuDialog$2(MenuDialog paramMenuDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.MenuDialog.2
 * JD-Core Version:    0.7.0.1
 */