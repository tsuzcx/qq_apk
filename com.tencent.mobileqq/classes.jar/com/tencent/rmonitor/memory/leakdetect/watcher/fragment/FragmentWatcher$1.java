package com.tencent.rmonitor.memory.leakdetect.watcher.fragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.common.lifecycle.SimpleActivityStateCallback;
import org.jetbrains.annotations.NotNull;

class FragmentWatcher$1
  extends SimpleActivityStateCallback
{
  FragmentWatcher$1(FragmentWatcher paramFragmentWatcher) {}
  
  public void a(@NonNull Activity paramActivity)
  {
    IFragmentWatcher[] arrayOfIFragmentWatcher = FragmentWatcher.a(this.a);
    int j = arrayOfIFragmentWatcher.length;
    int i = 0;
    while (i < j)
    {
      IFragmentWatcher localIFragmentWatcher = arrayOfIFragmentWatcher[i];
      if (localIFragmentWatcher.a(paramActivity)) {
        localIFragmentWatcher.b(paramActivity);
      }
      i += 1;
    }
  }
  
  public void b(@NotNull Activity paramActivity)
  {
    IFragmentWatcher[] arrayOfIFragmentWatcher = FragmentWatcher.a(this.a);
    int j = arrayOfIFragmentWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfIFragmentWatcher[i].c(paramActivity);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.fragment.FragmentWatcher.1
 * JD-Core Version:    0.7.0.1
 */