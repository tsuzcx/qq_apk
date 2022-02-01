package com.tencent.mobileqq.ecshop.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/utils/AppUtils;", "", "()V", "getAppRunTime", "Lmqq/app/AppRuntime;", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AppUtils
{
  public static final AppUtils a = new AppUtils();
  
  @JvmStatic
  @NotNull
  public static final AppRuntime a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "MobileQQ.sMobileQQ.waitAppRuntime(null)");
    return localAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.utils.AppUtils
 * JD-Core Version:    0.7.0.1
 */