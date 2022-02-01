package com.tencent.rmonitor.memory.leakdetect.watcher.fragment;

import com.tencent.rmonitor.base.config.data.MemoryLeakPluginConfig;
import com.tencent.rmonitor.common.lifecycle.IActivityStateCallback;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.memory.MemoryConfigHelper;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;
import com.tencent.rmonitor.memory.leakdetect.watcher.BaseObjectWatcher;

public class FragmentWatcher
  extends BaseObjectWatcher
{
  private final IFragmentWatcher[] b;
  private final IActivityStateCallback c = new FragmentWatcher.1(this);
  
  public FragmentWatcher(MemoryLeakInspector paramMemoryLeakInspector)
  {
    this(paramMemoryLeakInspector, a(paramMemoryLeakInspector));
  }
  
  public FragmentWatcher(MemoryLeakInspector paramMemoryLeakInspector, IFragmentWatcher[] paramArrayOfIFragmentWatcher)
  {
    super(paramMemoryLeakInspector);
    this.b = paramArrayOfIFragmentWatcher;
  }
  
  private static IFragmentWatcher[] a(MemoryLeakInspector paramMemoryLeakInspector)
  {
    if (AndroidVersion.e()) {
      return new IFragmentWatcher[] { new AndroidOFragmentWatcher(paramMemoryLeakInspector), new AndroidV4FragmentWatcher(paramMemoryLeakInspector) };
    }
    return new IFragmentWatcher[] { new AndroidV4FragmentWatcher(paramMemoryLeakInspector) };
  }
  
  public boolean a()
  {
    LifecycleCallback.a(this.c);
    return true;
  }
  
  public void b()
  {
    LifecycleCallback.b(this.c);
  }
  
  public boolean c()
  {
    return MemoryConfigHelper.d().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.fragment.FragmentWatcher
 * JD-Core Version:    0.7.0.1
 */