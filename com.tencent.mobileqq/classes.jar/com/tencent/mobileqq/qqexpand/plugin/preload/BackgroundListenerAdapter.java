package com.tencent.mobileqq.qqexpand.plugin.preload;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.qphone.base.util.QLog;

class BackgroundListenerAdapter
  implements IGuardInterface
{
  private final IBackgroundListener a;
  
  public BackgroundListenerAdapter(@NonNull IBackgroundListener paramIBackgroundListener)
  {
    this.a = paramIBackgroundListener;
  }
  
  public void onApplicationBackground()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, "guard: onApplicationBackground()");
    }
    this.a.c();
  }
  
  public void onApplicationForeground()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, "guard: onApplicationForeground()");
    }
  }
  
  public void onBackgroundTimeTick(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "guard: onBackgroundTimeTick()", Long.valueOf(paramLong) });
    }
  }
  
  public void onBackgroundUnguardTimeTick(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "guard: onBackgroundUnguardTimeTick()", Long.valueOf(paramLong) });
    }
  }
  
  public void onLiteTimeTick(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "guard: onLiteTimeTick()", Long.valueOf(paramLong) });
    }
  }
  
  public void onScreensStateChanged(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "guard: onScreensStateChanged()", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.preload.BackgroundListenerAdapter
 * JD-Core Version:    0.7.0.1
 */