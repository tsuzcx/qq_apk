package com.tencent.rmonitor.memory.leakdetect.watcher.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentManager.FragmentLifecycleCallbacks;
import android.support.annotation.RequiresApi;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;

public class AndroidOFragmentWatcher
  implements IFragmentWatcher
{
  private final MemoryLeakInspector a;
  @RequiresApi(26)
  private final FragmentManager.FragmentLifecycleCallbacks b = new AndroidOFragmentWatcher.1(this);
  
  public AndroidOFragmentWatcher(MemoryLeakInspector paramMemoryLeakInspector)
  {
    this.a = paramMemoryLeakInspector;
  }
  
  public boolean a(Activity paramActivity)
  {
    return AndroidVersion.e();
  }
  
  @RequiresApi(26)
  public void b(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.getFragmentManager().registerFragmentLifecycleCallbacks(this.b, true);
    }
  }
  
  @RequiresApi(26)
  public void c(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.getFragmentManager().unregisterFragmentLifecycleCallbacks(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.fragment.AndroidOFragmentWatcher
 * JD-Core Version:    0.7.0.1
 */