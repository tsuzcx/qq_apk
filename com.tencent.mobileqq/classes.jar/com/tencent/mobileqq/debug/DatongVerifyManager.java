package com.tencent.mobileqq.debug;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/debug/DatongVerifyManager;", "", "()V", "SP_KEY", "", "verifyClazz", "Ljava/lang/Class;", "setAppId", "", "appId", "setVerifyOn", "verifyOn", "", "showVerifyToggleDialog", "activity", "Landroid/app/Activity;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DatongVerifyManager
{
  public static final DatongVerifyManager a = new DatongVerifyManager();
  private static Class<?> b;
  
  static
  {
    Object localObject2;
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(Class.forName("com.tencent.qqlive.module.videoreport.validation.VideoReportVerify"));
    }
    catch (Throwable localThrowable)
    {
      localObject3 = Result.Companion;
      localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
    }
    Object localObject3 = localObject2;
    if (Result.isFailure-impl(localObject2)) {
      localObject3 = null;
    }
    b = (Class)localObject3;
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject = b;
    if (localObject != null) {
      localObject = ((Class)localObject).getDeclaredMethod("setVerifyOn", new Class[] { Boolean.TYPE });
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((Method)localObject).invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Object localObject = b;
    if (localObject != null) {
      localObject = ((Class)localObject).getDeclaredMethod("setAppId", new Class[] { String.class });
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((Method)localObject).invoke(null, new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.DatongVerifyManager
 * JD-Core Version:    0.7.0.1
 */