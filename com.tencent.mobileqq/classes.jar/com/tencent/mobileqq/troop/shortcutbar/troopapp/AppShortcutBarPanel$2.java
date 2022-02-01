package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AppShortcutBarPanel$2
  implements View.OnClickListener
{
  AppShortcutBarPanel$2(AppShortcutBarPanel paramAppShortcutBarPanel) {}
  
  public void onClick(View paramView)
  {
    if (AppShortcutBarPanel.a(this.a) != null) {
      AppShortcutBarPanel.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel.2
 * JD-Core Version:    0.7.0.1
 */