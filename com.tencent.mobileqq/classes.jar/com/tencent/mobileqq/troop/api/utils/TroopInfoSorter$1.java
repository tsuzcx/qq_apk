package com.tencent.mobileqq.troop.api.utils;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

final class TroopInfoSorter$1
  implements Comparator<Entity>
{
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    int i = 0;
    Object localObject = "-";
    String str = "-";
    int j;
    if ((paramEntity1 instanceof TroopInfo))
    {
      paramEntity1 = (TroopInfo)paramEntity1;
      localObject = (TroopInfo)paramEntity2;
      j = paramEntity1.mComparePartInt;
      i = ((TroopInfo)localObject).mComparePartInt;
      paramEntity2 = paramEntity1.mCompareSpell;
      paramEntity1 = ((TroopInfo)localObject).mCompareSpell;
    }
    for (;;)
    {
      return TroopInfoSorter.a(j, paramEntity2, i, paramEntity1);
      j = 0;
      paramEntity1 = str;
      paramEntity2 = (Entity)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopInfoSorter.1
 * JD-Core Version:    0.7.0.1
 */