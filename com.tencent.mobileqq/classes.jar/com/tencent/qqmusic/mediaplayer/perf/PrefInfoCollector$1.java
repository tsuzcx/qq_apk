package com.tencent.qqmusic.mediaplayer.perf;

import java.util.Comparator;
import java.util.Map.Entry;

class PrefInfoCollector$1
  implements Comparator<Map.Entry<String, Long>>
{
  PrefInfoCollector$1(PrefInfoCollector paramPrefInfoCollector) {}
  
  public int compare(Map.Entry<String, Long> paramEntry1, Map.Entry<String, Long> paramEntry2)
  {
    if (((String)paramEntry1.getKey()).charAt(0) > ((String)paramEntry2.getKey()).charAt(0)) {
      return 1;
    }
    if (((String)paramEntry1.getKey()).charAt(0) == ((String)paramEntry2.getKey()).charAt(0)) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector.1
 * JD-Core Version:    0.7.0.1
 */