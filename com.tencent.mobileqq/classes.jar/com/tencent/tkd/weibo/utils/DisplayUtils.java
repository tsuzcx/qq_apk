package com.tencent.tkd.weibo.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/utils/DisplayUtils;", "", "()V", "dip2px", "", "context", "Landroid/content/Context;", "dpValue", "", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class DisplayUtils
{
  public static final DisplayUtils a = new DisplayUtils();
  
  public final int a(@NotNull Context paramContext, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    return (int)(paramContext.getDisplayMetrics().density * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.DisplayUtils
 * JD-Core Version:    0.7.0.1
 */