package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ColorNoteSmallScreenService$2
  implements Application.ActivityLifecycleCallbacks
{
  ColorNoteSmallScreenService$2(ColorNoteSmallScreenService paramColorNoteSmallScreenService) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityDestroyed: ");
      localStringBuilder.append(paramActivity.getClass().getName());
      QLog.d("ColorNoteSmallScreenService", 2, localStringBuilder.toString());
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResumed: ");
      localStringBuilder.append(paramActivity.getClass().getName());
      QLog.d("ColorNoteSmallScreenService", 2, localStringBuilder.toString());
    }
    if (this.a.f)
    {
      paramActivity = this.a;
      paramActivity.f = false;
      paramActivity.d = true;
      paramActivity.a().removeCallbacks(this.a.b);
      this.a.a().postDelayed(this.a.b, 200L);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStarted: ");
      localStringBuilder.append(paramActivity.getClass().getName());
      QLog.d("ColorNoteSmallScreenService", 2, localStringBuilder.toString());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStopped: ");
      localStringBuilder.append(paramActivity.getClass().getName());
      QLog.d("ColorNoteSmallScreenService", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService.2
 * JD-Core Version:    0.7.0.1
 */