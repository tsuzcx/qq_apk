package com.tencent.mobileqq.troop.adapter.contact;

import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import java.util.Comparator;

public class CommonlyUsedTroopCompator
  implements Comparator<CommonlyUsedTroop>
{
  public int a(CommonlyUsedTroop paramCommonlyUsedTroop1, CommonlyUsedTroop paramCommonlyUsedTroop2)
  {
    if (paramCommonlyUsedTroop1.addedTimestamp < paramCommonlyUsedTroop2.addedTimestamp) {
      return 1;
    }
    if (paramCommonlyUsedTroop1.addedTimestamp > paramCommonlyUsedTroop2.addedTimestamp) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.contact.CommonlyUsedTroopCompator
 * JD-Core Version:    0.7.0.1
 */