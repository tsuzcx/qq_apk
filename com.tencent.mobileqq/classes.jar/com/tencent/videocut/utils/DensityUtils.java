package com.tencent.videocut.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/DensityUtils;", "", "()V", "dp2px", "", "dpValue", "", "px2dp", "pxValue", "px2sp", "context", "Landroid/content/Context;", "pxVal", "sp2px", "spVal", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class DensityUtils
{
  @NotNull
  public static final DensityUtils a = new DensityUtils();
  
  public final int a(float paramFloat)
  {
    Resources localResources = Resources.getSystem();
    Intrinsics.checkNotNullExpressionValue(localResources, "Resources.getSystem()");
    return (int)(paramFloat * localResources.getDisplayMetrics().density + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.DensityUtils
 * JD-Core Version:    0.7.0.1
 */