package com.tencent.mobileqq.qqguildsdk.util;

import java.util.Map.Entry;
import java.util.function.Predicate;

final class GProUtil$1
  implements Predicate<Map.Entry<String, Long>>
{
  public boolean a(Map.Entry<String, Long> paramEntry)
  {
    return System.currentTimeMillis() - ((Long)paramEntry.getValue()).longValue() > 5000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.util.GProUtil.1
 * JD-Core Version:    0.7.0.1
 */