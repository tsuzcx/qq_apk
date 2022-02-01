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
  
  public void a()
  {
    super.a();
    if (MobileQQ.sProcessId == 1)
    {
      MemoryManager.a().b();
      return;
    }
    MemoryClearManager.a().d();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.QAPMCellingValueWrapper
 * JD-Core Version:    0.7.0.1
 */