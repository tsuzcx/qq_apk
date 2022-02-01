package com.tencent.videocut.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/ScreenUtils;", "", "()V", "screenWidth", "", "getScreenWidth$annotations", "getScreenWidth", "()I", "getDisplayHeight", "context", "Landroid/content/Context;", "getDisplayWidth", "getFullScreenHeight", "getFullScreenWidth", "getMiSupplementHeight", "getScreenHeight", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class ScreenUtils
{
  @NotNull
  public static final ScreenUtils a = new ScreenUtils();
  
  public static final int a()
  {
    Resources localResources = Resources.getSystem();
    Intrinsics.checkNotNullExpressionValue(localResources, "Resources.getSystem()");
    return localResources.getDisplayMetrics().widthPixels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.ScreenUtils
 * JD-Core Version:    0.7.0.1
 */