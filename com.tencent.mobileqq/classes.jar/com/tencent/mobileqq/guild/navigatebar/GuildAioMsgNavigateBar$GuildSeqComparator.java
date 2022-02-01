package com.tencent.mobileqq.guild.navigatebar;

import java.util.Comparator;

class GuildAioMsgNavigateBar$GuildSeqComparator
  implements Comparator<Long>
{
  public int a(Long paramLong1, Long paramLong2)
  {
    if (paramLong1.longValue() - paramLong2.longValue() > 0L) {
      return -1;
    }
    if (paramLong1.longValue() - paramLong2.longValue() < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateBar.GuildSeqComparator
 * JD-Core Version:    0.7.0.1
 */