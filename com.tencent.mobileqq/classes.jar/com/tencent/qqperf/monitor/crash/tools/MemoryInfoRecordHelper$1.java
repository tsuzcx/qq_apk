package com.tencent.qqperf.monitor.crash.tools;

import java.util.Comparator;
import java.util.Map.Entry;

final class MemoryInfoRecordHelper$1
  implements Comparator<Map.Entry<String, Long>>
{
  public int a(Map.Entry<String, Long> paramEntry1, Map.Entry<String, Long> paramEntry2)
  {
    return -((Long)paramEntry1.getValue()).compareTo((Long)paramEntry2.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.MemoryInfoRecordHelper.1
 * JD-Core Version:    0.7.0.1
 */