package com.tencent.rmonitor.common.lifecycle;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/lifecycle/ActivityInfo;", "", "()V", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ActivityInfo
{
  public static final ActivityInfo.Companion a = new ActivityInfo.Companion(null);
  
  @JvmStatic
  @Nullable
  public static final Object a(@Nullable Application paramApplication)
  {
    return a.a(paramApplication);
  }
  
  @JvmStatic
  @NotNull
  public static final String a()
  {
    return a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.lifecycle.ActivityInfo
 * JD-Core Version:    0.7.0.1
 */