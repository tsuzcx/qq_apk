package com.tencent.mobileqq.richmedia.capture.data;

import android.util.Pair;
import java.util.Comparator;

class SegmentKeeper$SortComparator
  implements Comparator
{
  private SegmentKeeper$SortComparator(SegmentKeeper paramSegmentKeeper) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Pair)paramObject1;
    paramObject2 = (Pair)paramObject2;
    if (((Long)paramObject1.first).longValue() > ((Long)paramObject2.first).longValue()) {
      return 1;
    }
    if (paramObject1.first == paramObject2.first) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper.SortComparator
 * JD-Core Version:    0.7.0.1
 */