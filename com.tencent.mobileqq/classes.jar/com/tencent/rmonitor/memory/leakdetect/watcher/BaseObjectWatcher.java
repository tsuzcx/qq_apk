package com.tencent.rmonitor.memory.leakdetect.watcher;

import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;

public abstract class BaseObjectWatcher
  implements IObjectWatcher
{
  protected final MemoryLeakInspector a;
  
  public BaseObjectWatcher(MemoryLeakInspector paramMemoryLeakInspector)
  {
    this.a = paramMemoryLeakInspector;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.BaseObjectWatcher
 * JD-Core Version:    0.7.0.1
 */