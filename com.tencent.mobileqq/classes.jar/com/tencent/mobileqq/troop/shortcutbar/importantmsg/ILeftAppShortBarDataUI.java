package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarLifeCycle;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import java.util.ArrayList;

public abstract class ILeftAppShortBarDataUI
  implements IShortcutBarLifeCycle
{
  public abstract void a(ArrayList<ShortcutBarInfo> paramArrayList);
  
  public abstract boolean a();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ILeftAppShortBarDataUI
 * JD-Core Version:    0.7.0.1
 */