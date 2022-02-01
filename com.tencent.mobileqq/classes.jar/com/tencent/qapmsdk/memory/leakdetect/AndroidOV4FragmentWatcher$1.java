package com.tencent.qapmsdk.memory.leakdetect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;

class AndroidOV4FragmentWatcher$1
  extends FragmentManager.FragmentLifecycleCallbacks
{
  AndroidOV4FragmentWatcher$1(AndroidOV4FragmentWatcher paramAndroidOV4FragmentWatcher) {}
  
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
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.AndroidOV4FragmentWatcher.1
 * JD-Core Version:    0.7.0.1
 */