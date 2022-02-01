package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;

class AppShortcutBarProcessor$2
  extends TroopBusinessObserver
{
  AppShortcutBarProcessor$2(AppShortcutBarProcessor paramAppShortcutBarProcessor) {}
  
  public void onTroopAppHasNew(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (!paramString.equals(AppShortcutBarProcessor.a(this.a))) || (AppShortcutBarProcessor.a(this.a) == null) || (AppShortcutBarProcessor.a(this.a).I)) {
      return;
    }
    if (this.a.a != null)
    {
      this.a.a.a(4);
      this.a.a.c(75);
      this.a.a.a();
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarProcessor.2
 * JD-Core Version:    0.7.0.1
 */