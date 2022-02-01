package com.tencent.mobileqq.listentogether.lyrics;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class LyricsController$6
  implements Application.ActivityLifecycleCallbacks
{
  LyricsController$6(LyricsController paramLyricsController) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityDestroyed: ");
      localStringBuilder.append(paramActivity.getClass().getName());
      QLog.d("LyricsController", 2, localStringBuilder.toString());
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
      QLog.d("LyricsController", 2, localStringBuilder.toString());
    }
    if ((this.a.f) && (!this.a.e))
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.a.x);
      ThreadManager.getUIHandlerV2().postDelayed(this.a.x, 1000L);
      return;
    }
    if (LyricsController.c(this.a))
    {
      LyricsController.a(this.a, false);
      paramActivity = this.a;
      paramActivity.c = true;
      paramActivity.a(true);
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
      QLog.d("LyricsController", 2, localStringBuilder.toString());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStopped: ");
      localStringBuilder.append(paramActivity.getClass().getName());
      QLog.d("LyricsController", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.6
 * JD-Core Version:    0.7.0.1
 */