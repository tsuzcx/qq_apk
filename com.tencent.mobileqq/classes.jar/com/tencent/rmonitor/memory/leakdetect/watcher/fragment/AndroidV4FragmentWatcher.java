package com.tencent.rmonitor.memory.leakdetect.watcher.fragment;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;
import com.tencent.rmonitor.common.util.ClassUtil;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;

public class AndroidV4FragmentWatcher
  implements IFragmentWatcher
{
  private final MemoryLeakInspector a;
  private final FragmentManager.FragmentLifecycleCallbacks b = new AndroidV4FragmentWatcher.1(this);
  
  public AndroidV4FragmentWatcher(MemoryLeakInspector paramMemoryLeakInspector)
  {
    this.a = paramMemoryLeakInspector;
  }
  
  public boolean a(Activity paramActivity)
  {
    return (ClassUtil.a("android.support.v4.app.FragmentActivity")) && (ClassUtil.a("android.support.v4.app.Fragment")) && (ClassUtil.a(paramActivity, "android.support.v4.app.FragmentActivity"));
  }
  
  public void b(Activity paramActivity)
  {
    if ((paramActivity instanceof FragmentActivity)) {
      ((FragmentActivity)paramActivity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.b, true);
    }
  }
  
  public void c(Activity paramActivity)
  {
    if ((paramActivity instanceof FragmentActivity)) {
      ((FragmentActivity)paramActivity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.fragment.AndroidV4FragmentWatcher
 * JD-Core Version:    0.7.0.1
 */