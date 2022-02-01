package com.tencent.rmonitor.memory.leakdetect.watcher;

import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;
import com.tencent.rmonitor.memory.leakdetect.watcher.activity.ActivityIceWatcher;
import com.tencent.rmonitor.memory.leakdetect.watcher.activity.ActivityWatcher;
import com.tencent.rmonitor.memory.leakdetect.watcher.fragment.FragmentWatcher;

public class AppWatcher
  extends BaseObjectWatcher
{
  private final IObjectWatcher[] b;
  
  public AppWatcher(MemoryLeakInspector paramMemoryLeakInspector)
  {
    this(paramMemoryLeakInspector, new IObjectWatcher[] { new ActivityWatcher(paramMemoryLeakInspector), new ActivityIceWatcher(paramMemoryLeakInspector), new FragmentWatcher(paramMemoryLeakInspector) });
  }
  
  public AppWatcher(MemoryLeakInspector paramMemoryLeakInspector, IObjectWatcher[] paramArrayOfIObjectWatcher)
  {
    super(paramMemoryLeakInspector);
    this.b = paramArrayOfIObjectWatcher;
  }
  
  public boolean a()
  {
    IObjectWatcher[] arrayOfIObjectWatcher = this.b;
    int j = arrayOfIObjectWatcher.length;
    int i = 0;
    while (i < j)
    {
      IObjectWatcher localIObjectWatcher = arrayOfIObjectWatcher[i];
      if (localIObjectWatcher.c()) {
        localIObjectWatcher.a();
      }
      i += 1;
    }
    return true;
  }
  
  public void b()
  {
    IObjectWatcher[] arrayOfIObjectWatcher = this.b;
    int j = arrayOfIObjectWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfIObjectWatcher[i].b();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.AppWatcher
 * JD-Core Version:    0.7.0.1
 */