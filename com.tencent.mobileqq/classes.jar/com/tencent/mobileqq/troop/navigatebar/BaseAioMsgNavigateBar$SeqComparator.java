package com.tencent.mobileqq.troop.navigatebar;

import java.util.Comparator;

public class BaseAioMsgNavigateBar$SeqComparator
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBar.SeqComparator
 * JD-Core Version:    0.7.0.1
 */