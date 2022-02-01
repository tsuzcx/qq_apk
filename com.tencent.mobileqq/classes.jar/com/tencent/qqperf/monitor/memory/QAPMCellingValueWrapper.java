package com.tencent.qqperf.monitor.memory;

import com.tencent.qqperf.monitor.base.AbstractMagnifierItem;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import mqq.app.MobileQQ;

public class QAPMCellingValueWrapper
  extends AbstractMagnifierItem
{
  public String a()
  {
    return "ceilingvalue";
  }
  
  public void d()
  {
    super.d();
    if (MobileQQ.sProcessId == 1)
    {
      MemoryManager.a().c();
      return;
    }
    MemoryClearManager.b().f();
  }
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.QAPMCellingValueWrapper
 * JD-Core Version:    0.7.0.1
 */