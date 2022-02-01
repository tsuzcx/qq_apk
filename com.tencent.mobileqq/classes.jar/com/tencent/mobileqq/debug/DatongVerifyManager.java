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
  public static final DatongVerifyManager a;
  private static Class<?> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqDebugDatongVerifyManager = new DatongVerifyManager();
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(Class.forName("com.tencent.qqlive.module.videoreport.validation.VideoReportVerify"));
      localObject3 = localObject1;
      if (Result.isFailure-impl(localObject1)) {
        localObject3 = null;
      }
      jdField_a_of_type_JavaLangClass = (Class)localObject3;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject3 = Result.Companion;
        Object localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
      }
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject = jdField_a_of_type_JavaLangClass;
    if (localObject != null) {}
    for (localObject = ((Class)localObject).getDeclaredMethod("setVerifyOn", new Class[] { Boolean.TYPE });; localObject = null)
    {
      if (localObject != null) {
        ((Method)localObject).invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
      }
      return;
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Object localObject = jdField_a_of_type_JavaLangClass;
    if (localObject != null) {}
    for (localObject = ((Class)localObject).getDeclaredMethod("setAppId", new Class[] { String.class });; localObject = null)
    {
      if (localObject != null) {
        ((Method)localObject).invoke(null, new Object[] { paramString });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.DatongVerifyManager
 * JD-Core Version:    0.7.0.1
 */