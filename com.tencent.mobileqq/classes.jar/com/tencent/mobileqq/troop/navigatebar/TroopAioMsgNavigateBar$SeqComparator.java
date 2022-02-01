package com.tencent.mobileqq.troop.navigatebar;

import java.util.Comparator;

class TroopAioMsgNavigateBar$SeqComparator
  implements Comparator<Long>
{
  public int a(Long paramLong1, Long paramLong2)
  {
    int i = 0;
    if (paramLong1.longValue() - paramLong2.longValue() > 0L) {
      i = 1;
    }
    while (paramLong1.longValue() - paramLong2.longValue() >= 0L) {
      return i;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar.SeqComparator
 * JD-Core Version:    0.7.0.1
 */