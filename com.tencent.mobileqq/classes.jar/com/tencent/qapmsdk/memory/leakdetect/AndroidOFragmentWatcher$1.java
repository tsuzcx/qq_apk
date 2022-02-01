package com.tencent.qapmsdk.memory.leakdetect;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentManager.FragmentLifecycleCallbacks;

class AndroidOFragmentWatcher$1
  extends FragmentManager.FragmentLifecycleCallbacks
{
  AndroidOFragmentWatcher$1(AndroidOFragmentWatcher paramAndroidOFragmentWatcher) {}
  
  public void onFragmentDestroyed(FragmentManager paramFragmentManager, Fragment paramFragment)
  {
    super.onFragmentDestroyed(paramFragmentManager, paramFragment);
    LeakInspector.startInspect(paramFragment, "");
  }
  
  public void onFragmentViewDestroyed(FragmentManager paramFragmentManager, Fragment paramFragment)
  {
    super.onFragmentViewDestroyed(paramFragmentManager, paramFragment);
    if (paramFragment.getView() != null) {
      LeakInspector.startInspect(paramFragment.getView(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.AndroidOFragmentWatcher.1
 * JD-Core Version:    0.7.0.1
 */