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
  
  public void G_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, "guard: onApplicationForeground()");
    }
  }
  
  public void H_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, "guard: onApplicationBackground()");
    }
    this.a.c();
  }
  
  public void a(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "guard: onBackgroundTimeTick()", Long.valueOf(paramLong) });
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "guard: onScreensStateChanged()", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "guard: onLiteTimeTick()", Long.valueOf(paramLong) });
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "guard: onBackgroundUnguardTimeTick()", Long.valueOf(paramLong) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.preload.BackgroundListenerAdapter
 * JD-Core Version:    0.7.0.1
 */