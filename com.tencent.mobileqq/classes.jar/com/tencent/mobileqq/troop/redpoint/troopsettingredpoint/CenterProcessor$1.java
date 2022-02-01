package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import com.tencent.TMG.utils.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class CenterProcessor$1
  implements Runnable
{
  CenterProcessor$1(CenterProcessor paramCenterProcessor) {}
  
  public void run()
  {
    Iterator localIterator = CenterProcessor.a(this.this$0).entrySet().iterator();
    while (localIterator.hasNext())
    {
      AbsBaseProcessor localAbsBaseProcessor = (AbsBaseProcessor)((Map.Entry)localIterator.next()).getValue();
      if (localAbsBaseProcessor != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(localAbsBaseProcessor.a(), 0, "destroy()");
        }
        localAbsBaseProcessor.c();
      }
    }
    CenterProcessor.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.CenterProcessor.1
 * JD-Core Version:    0.7.0.1
 */