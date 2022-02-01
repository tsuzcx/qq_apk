package com.tencent.rfw.barrage.core;

import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class RFWBarrageMeasureManager$2
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = new ArrayList(this.a).iterator();
    while (localIterator.hasNext())
    {
      RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)localIterator.next();
      RFWBarrageMeasureManager.a(RFWBarrageMeasureManager.a(this.this$0), localRFWBaseBarrage);
      RFWBarrageMeasureManager.IMeasureCallback localIMeasureCallback = this.b;
      if (localIMeasureCallback != null) {
        localIMeasureCallback.a(localRFWBaseBarrage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */