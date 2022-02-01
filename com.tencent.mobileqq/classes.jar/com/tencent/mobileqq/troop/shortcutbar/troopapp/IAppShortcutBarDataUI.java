package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarLifeCycle;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import java.util.ArrayList;

public abstract class IAppShortcutBarDataUI
  implements IShortcutBarLifeCycle
{
  public abstract void a(ArrayList<ShortcutBarInfo> paramArrayList, boolean paramBoolean);
  
  public abstract void e();
  
  public abstract boolean f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.IAppShortcutBarDataUI
 * JD-Core Version:    0.7.0.1
 */