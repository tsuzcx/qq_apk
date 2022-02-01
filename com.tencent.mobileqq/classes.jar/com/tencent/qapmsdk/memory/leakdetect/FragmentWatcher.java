package com.tencent.qapmsdk.memory.leakdetect;

import com.tencent.qapmsdk.common.activty.LifecycleCallback;
import com.tencent.qapmsdk.common.util.AndroidVersion;

public class FragmentWatcher
{
  private static final String ANDROIDX_FRAGMENT_CLASS = "androidx.fragment.app.Fragment";
  private static final String ANDROID_V4_ACTIVITY_CLASS = "android.support.v4.app.FragmentActivity";
  private static final String ANDROID_V4_FRAGMENT_CLASS = "android.support.v4.app.Fragment";
  
  public static void startFragmentInspect()
  {
    if (AndroidVersion.isO()) {
      LifecycleCallback.INSTANCE.register(new FragmentWatcher.1());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.FragmentWatcher
 * JD-Core Version:    0.7.0.1
 */