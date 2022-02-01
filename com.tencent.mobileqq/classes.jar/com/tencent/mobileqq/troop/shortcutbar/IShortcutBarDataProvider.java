package com.tencent.mobileqq.troop.shortcutbar;

import java.util.ArrayList;

public abstract class IShortcutBarDataProvider
  implements IShortcutBarLifeCycle
{
  public void a(int paramInt, ArrayList<ShortcutBarInfo> paramArrayList)
  {
    a(paramInt, paramArrayList, false);
  }
  
  public abstract void a(int paramInt, ArrayList<ShortcutBarInfo> paramArrayList, boolean paramBoolean);
  
  public abstract void a(Object paramObject);
  
  public abstract void b(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.IShortcutBarDataProvider
 * JD-Core Version:    0.7.0.1
 */