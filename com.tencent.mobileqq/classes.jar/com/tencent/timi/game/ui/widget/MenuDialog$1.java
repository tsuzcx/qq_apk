package com.tencent.timi.game.ui.widget;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MenuDialog$1
  implements View.OnClickListener
{
  MenuDialog$1(MenuDialog paramMenuDialog) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (MenuDialog.a(this.a) != null) {
      MenuDialog.a(this.a).onClick(this.a, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.MenuDialog.1
 * JD-Core Version:    0.7.0.1
 */