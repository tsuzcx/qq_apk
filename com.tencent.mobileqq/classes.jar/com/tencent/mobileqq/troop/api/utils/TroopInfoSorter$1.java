package com.tencent.mobileqq.troop.api.utils;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

final class TroopInfoSorter$1
  implements Comparator<Entity>
{
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    boolean bool = paramEntity1 instanceof TroopInfo;
    String str = "-";
    int j = 0;
    int i;
    if (bool)
    {
      paramEntity1 = (TroopInfo)paramEntity1;
      paramEntity2 = (TroopInfo)paramEntity2;
      j = paramEntity1.mComparePartInt;
      i = paramEntity2.mComparePartInt;
      paramEntity1 = paramEntity1.mCompareSpell;
      paramEntity2 = paramEntity2.mCompareSpell;
    }
    else
    {
      paramEntity2 = "-";
      i = 0;
      paramEntity1 = str;
    }
    return TroopInfoSorter.a(j, paramEntity1, i, paramEntity2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopInfoSorter.1
 * JD-Core Version:    0.7.0.1
 */