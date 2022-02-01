package com.tencent.mobileqq.troop.shortcutbar;

import java.util.ArrayList;
import java.util.Comparator;

class ShortBarDataProvider$1
  implements Comparator<ArrayList<ShortcutBarInfo>>
{
  ShortBarDataProvider$1(ShortBarDataProvider paramShortBarDataProvider) {}
  
  public int a(ArrayList<ShortcutBarInfo> paramArrayList1, ArrayList<ShortcutBarInfo> paramArrayList2)
  {
    return ((ShortcutBarInfo)paramArrayList2.get(0)).a() - ((ShortcutBarInfo)paramArrayList1.get(0)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.ShortBarDataProvider.1
 * JD-Core Version:    0.7.0.1
 */