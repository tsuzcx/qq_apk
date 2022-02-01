package com.tencent.rmonitor.common.lifecycle;

import android.app.Activity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/lifecycle/IActivityStateCallback;", "", "onBackground", "", "activity", "Landroid/app/Activity;", "onCreate", "onDestroy", "onForeground", "onResume", "onStop", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IActivityStateCallback
{
  public abstract void a(@NotNull Activity paramActivity);
  
  public abstract void b(@NotNull Activity paramActivity);
  
  public abstract void c(@NotNull Activity paramActivity);
  
  public abstract void d(@NotNull Activity paramActivity);
  
  public abstract void e(@NotNull Activity paramActivity);
  
  public abstract void f(@NotNull Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.lifecycle.IActivityStateCallback
 * JD-Core Version:    0.7.0.1
 */