package com.tencent.qapmsdk.memory.leakdetect;

import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;

class AndroidOV4FragmentWatcher
{
  @RequiresApi(26)
  private FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks = new AndroidOV4FragmentWatcher.1(this);
  
  @RequiresApi(26)
  void registerCallbacks(Activity paramActivity)
  {
    ((FragmentActivity)paramActivity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.AndroidOV4FragmentWatcher
 * JD-Core Version:    0.7.0.1
 */