package com.tencent.rfw.barrage.core;

import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.tool.RFWSortedLinkedList.TimeComparator;

class RFWBarrageDataSource$1
  implements RFWSortedLinkedList.TimeComparator<RFWBaseBarrage>
{
  RFWBarrageDataSource$1(RFWBarrageDataSource paramRFWBarrageDataSource) {}
  
  public int a(RFWBaseBarrage paramRFWBaseBarrage, long paramLong)
  {
    if (paramRFWBaseBarrage == null) {
      return -1;
    }
    paramLong = paramRFWBaseBarrage.x() - paramLong;
    if (paramLong == 0L) {
      return 0;
    }
    if (paramLong > 0L) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageDataSource.1
 * JD-Core Version:    0.7.0.1
 */