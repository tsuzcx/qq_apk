package com.tencent.rfw.barrage.core;

import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.util.RFWBarrageUtils;
import java.io.Serializable;
import java.util.Comparator;

public class RFWBarrageComparator
  implements Serializable, Comparator<RFWBaseBarrage>
{
  public int compare(RFWBaseBarrage paramRFWBaseBarrage1, RFWBaseBarrage paramRFWBaseBarrage2)
  {
    return RFWBarrageUtils.a(paramRFWBaseBarrage1, paramRFWBaseBarrage2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageComparator
 * JD-Core Version:    0.7.0.1
 */