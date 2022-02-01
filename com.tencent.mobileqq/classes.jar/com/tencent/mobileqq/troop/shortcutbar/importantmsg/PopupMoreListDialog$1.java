package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PopupMoreListDialog$1
  implements View.OnClickListener
{
  PopupMoreListDialog$1(PopupMoreListDialog paramPopupMoreListDialog) {}
  
  public void onClick(View paramView)
  {
    if (PopupMoreListDialog.a(this.a).isShowing()) {
      this.a.e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.PopupMoreListDialog.1
 * JD-Core Version:    0.7.0.1
 */