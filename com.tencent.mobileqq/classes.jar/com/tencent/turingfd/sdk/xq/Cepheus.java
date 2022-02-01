package com.tencent.turingfd.sdk.xq;

import android.app.Activity;
import java.util.Set;

public final class Cepheus
  extends Eridanus
{
  public void a(Activity paramActivity, String paramString)
  {
    if ((Crux.ph.contains(paramActivity.getClass().getName())) || (Crux.oh)) {
      Crux.a(paramActivity);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Crux.nh.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity, "onActivityResumed");
    Crux.nh.onActivityResumed(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cepheus
 * JD-Core Version:    0.7.0.1
 */