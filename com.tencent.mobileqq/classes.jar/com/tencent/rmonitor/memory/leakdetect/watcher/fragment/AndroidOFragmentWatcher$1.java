package com.tencent.rmonitor.memory.leakdetect.watcher.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentManager.FragmentLifecycleCallbacks;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;

class AndroidOFragmentWatcher$1
  extends FragmentManager.FragmentLifecycleCallbacks
{
  AndroidOFragmentWatcher$1(AndroidOFragmentWatcher paramAndroidOFragmentWatcher) {}
  
  public void onFragmentDestroyed(FragmentManager paramFragmentManager, Fragment paramFragment)
  {
    AndroidOFragmentWatcher.a(this.a).a(paramFragment, "");
  }
  
  public void onFragmentViewDestroyed(FragmentManager paramFragmentManager, Fragment paramFragment)
  {
    if (paramFragment.getView() != null) {
      AndroidOFragmentWatcher.a(this.a).a(paramFragment.getView(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.fragment.AndroidOFragmentWatcher.1
 * JD-Core Version:    0.7.0.1
 */