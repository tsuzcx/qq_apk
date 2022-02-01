package com.tencent.qqperf.monitor.crash.tools;

import java.util.Comparator;
import java.util.Map.Entry;

final class LooperMessagePrinterHelper$1
  implements Comparator<Map.Entry<String, Integer>>
{
  public int a(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    return -((Integer)paramEntry1.getValue()).compareTo((Integer)paramEntry2.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.LooperMessagePrinterHelper.1
 * JD-Core Version:    0.7.0.1
 */