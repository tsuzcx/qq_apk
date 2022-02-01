package com.tencent.mobileqq.troop.adapter.contact;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.Comparator;

public class TroopCompator
  implements Comparator<TroopListItemWithMask>
{
  private long a(TroopListItemWithMask paramTroopListItemWithMask)
  {
    if ((paramTroopListItemWithMask.b instanceof TroopInfo)) {
      return ((TroopInfo)paramTroopListItemWithMask.b).lastMsgTime;
    }
    if ((paramTroopListItemWithMask.b instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramTroopListItemWithMask.b).lastMsgTime;
    }
    return 0L;
  }
  
  private int b(TroopListItemWithMask paramTroopListItemWithMask)
  {
    if ((a(paramTroopListItemWithMask) != 0L) && (paramTroopListItemWithMask.a != 4)) {
      return paramTroopListItemWithMask.a;
    }
    return paramTroopListItemWithMask.a + 3;
  }
  
  public int a(TroopListItemWithMask paramTroopListItemWithMask1, TroopListItemWithMask paramTroopListItemWithMask2)
  {
    if ((paramTroopListItemWithMask1 == null) && (paramTroopListItemWithMask2 == null)) {
      return 0;
    }
    if (paramTroopListItemWithMask1 == null) {
      return -1;
    }
    if (paramTroopListItemWithMask2 == null) {
      return 1;
    }
    if (b(paramTroopListItemWithMask1) == b(paramTroopListItemWithMask2)) {
      return (int)(a(paramTroopListItemWithMask2) - a(paramTroopListItemWithMask1));
    }
    return b(paramTroopListItemWithMask1) - b(paramTroopListItemWithMask2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.contact.TroopCompator
 * JD-Core Version:    0.7.0.1
 */