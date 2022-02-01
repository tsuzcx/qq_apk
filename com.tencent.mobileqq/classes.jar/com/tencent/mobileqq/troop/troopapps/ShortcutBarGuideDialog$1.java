package com.tencent.mobileqq.troop.troopapps;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShortcutBarGuideDialog$1
  implements View.OnClickListener
{
  ShortcutBarGuideDialog$1(ShortcutBarGuideDialog paramShortcutBarGuideDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.ShortcutBarGuideDialog.1
 * JD-Core Version:    0.7.0.1
 */