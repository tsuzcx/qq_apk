package com.tencent.qapmsdk.common.activty;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/activty/ActivityInfo;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class ActivityInfo
{
  public static final ActivityInfo.Companion Companion = new ActivityInfo.Companion(null);
  private static final String TAG = "QAPM_common_ActivityInfo";
  
  @JvmStatic
  @Nullable
  public static final Object getCurrentActivity(@Nullable Application paramApplication)
  {
    return Companion.getCurrentActivity(paramApplication);
  }
  
  @JvmStatic
  @NotNull
  public static final String getCurrentActivityName()
  {
    return Companion.getCurrentActivityName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.activty.ActivityInfo
 * JD-Core Version:    0.7.0.1
 */