package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class BlacklistPolicy
  implements IDetectionPolicy
{
  private static final Set<Activity> BLACKLIST = Collections.newSetFromMap(new WeakHashMap());
  
  void addBlacklist(Activity paramActivity)
  {
    if (paramActivity != null) {
      BLACKLIST.add(paramActivity);
    }
  }
  
  public boolean isAbleToDetect(Activity paramActivity)
  {
    return !BLACKLIST.contains(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.detection.BlacklistPolicy
 * JD-Core Version:    0.7.0.1
 */