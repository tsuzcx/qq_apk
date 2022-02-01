package com.tencent.tkd.topicsdk.common;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/SystemBarTintUtil;", "", "()V", "NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME", "", "NAV_BAR_HEIGHT_RES_NAME", "SHOW_NAV_BAR_RES_NAME", "mHasNavBar", "", "sNavBarOverride", "getInternalDimensionSize", "res", "Landroid/content/res/Resources;", "key", "getNavigationBarHeight", "context", "Landroid/content/Context;", "getStatusBarHeight", "hasNavBar", "", "initNavBarOverride", "", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class SystemBarTintUtil
{
  private static int a;
  public static final SystemBarTintUtil a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkCommonSystemBarTintUtil = new SystemBarTintUtil();
    jdField_a_of_type_Int = -1;
  }
  
  public final int a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.SystemBarTintUtil
 * JD-Core Version:    0.7.0.1
 */