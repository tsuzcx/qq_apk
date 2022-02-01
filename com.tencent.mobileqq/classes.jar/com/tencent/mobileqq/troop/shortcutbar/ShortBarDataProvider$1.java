package com.tencent.mobileqq.troop.shortcutbar;

import java.util.ArrayList;
import java.util.Comparator;

class ShortBarDataProvider$1
  implements Comparator<ArrayList<ShortcutBarInfo>>
{
  ShortBarDataProvider$1(ShortBarDataProvider paramShortBarDataProvider) {}
  
  public int a(ArrayList<ShortcutBarInfo> paramArrayList1, ArrayList<ShortcutBarInfo> paramArrayList2)
  {
    return ((ShortcutBarInfo)paramArrayList2.get(0)).c() - ((ShortcutBarInfo)paramArrayList1.get(0)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.ShortBarDataProvider.1
 * JD-Core Version:    0.7.0.1
 */