package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;

class AppShortcutBarProcessor$2
  extends TroopRedDotObserver
{
  AppShortcutBarProcessor$2(AppShortcutBarProcessor paramAppShortcutBarProcessor) {}
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (!paramString.equals(AppShortcutBarProcessor.c(this.a))) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarProcessor.2
 * JD-Core Version:    0.7.0.1
 */