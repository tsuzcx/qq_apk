package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.widget.immersive.SystemBarCompact;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/ActivityExtUtils;", "", "()V", "setTransparentStatusBar", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ActivityExtUtils
{
  public static final ActivityExtUtils a = new ActivityExtUtils();
  
  @JvmStatic
  public static final void a(@NotNull QBaseActivity paramQBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "$this$setTransparentStatusBar");
    if (paramQBaseActivity.mSystemBarComp == null)
    {
      paramQBaseActivity.setImmersiveStatus(0);
      return;
    }
    paramQBaseActivity.mSystemBarComp.setStatusBarDrawable(null);
    paramQBaseActivity.mSystemBarComp.setStatusBarColor(0);
    paramQBaseActivity.mSystemBarComp.setStatusColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ActivityExtUtils
 * JD-Core Version:    0.7.0.1
 */