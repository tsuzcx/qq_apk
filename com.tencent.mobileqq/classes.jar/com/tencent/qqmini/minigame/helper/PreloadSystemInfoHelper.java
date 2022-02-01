package com.tencent.qqmini.minigame.helper;

import android.app.Activity;
import android.content.Context;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/helper/PreloadSystemInfoHelper;", "", "()V", "mBenchmarkLevel", "", "mNotchHeight", "getDeviceBenchmarkLevel", "getNotchHeight", "activity", "Landroid/app/Activity;", "preload", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class PreloadSystemInfoHelper
{
  public static final PreloadSystemInfoHelper a = new PreloadSystemInfoHelper();
  private static volatile int b = -1;
  private static volatile int c = -1;
  
  @JvmStatic
  public static final int a()
  {
    if (c == -1) {
      c = DeviceUtil.getDeviceBenchmarkLevel();
    }
    return c;
  }
  
  @JvmStatic
  public static final void a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    ThreadManager.executeOnComputationThreadPool((Runnable)new PreloadSystemInfoHelper.preload.1(new WeakReference(paramActivity)));
  }
  
  @JvmStatic
  public static final int b(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (b == -1) {
      b = ImmersiveUtils.getNotchHeight((Context)paramActivity, paramActivity);
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.helper.PreloadSystemInfoHelper
 * JD-Core Version:    0.7.0.1
 */