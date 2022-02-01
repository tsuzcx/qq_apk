package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class WhitelistPolicy
  implements IDetectionPolicy
{
  private static final Set<Activity> WHITELIST = Collections.newSetFromMap(new WeakHashMap());
  
  void addWhitelist(Activity paramActivity)
  {
    if (paramActivity != null) {
      WHITELIST.add(paramActivity);
    }
  }
  
  public boolean isAbleToDetect(Activity paramActivity)
  {
    return WHITELIST.contains(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.detection.WhitelistPolicy
 * JD-Core Version:    0.7.0.1
 */