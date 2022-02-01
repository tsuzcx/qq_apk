package com.tencent.mobileqq.troop.navigatebar;

import java.util.Comparator;

class TroopAioMsgNavigateBar$SeqComparator
  implements Comparator<Long>
{
  public int a(Long paramLong1, Long paramLong2)
  {
    if (paramLong1.longValue() - paramLong2.longValue() > 0L) {
      return 1;
    }
    if (paramLong1.longValue() - paramLong2.longValue() < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar.SeqComparator
 * JD-Core Version:    0.7.0.1
 */