package com.tencent.tkd.topicsdk.framework;

import com.tencent.tkd.topicsdk.interfaces.ILogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/TLog;", "", "()V", "mLogger", "Lcom/tencent/tkd/topicsdk/interfaces/ILogger;", "d", "", "tag", "", "msg", "throwable", "", "e", "i", "init", "logger", "w", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class TLog
{
  public static final TLog a;
  private static ILogger a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkFrameworkTLog = new TLog();
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    ILogger localILogger = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLogger");
    }
    localILogger.c(paramString1, paramString2, null);
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    ILogger localILogger = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLogger");
    }
    localILogger.d(paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "throwable");
    ILogger localILogger = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLogger");
    }
    localILogger.a(paramString, "", paramThrowable);
  }
  
  @JvmStatic
  public static final void b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    ILogger localILogger = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLogger");
    }
    localILogger.a(paramString1, paramString2, null);
  }
  
  @JvmStatic
  public static final void b(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    ILogger localILogger = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLogger");
    }
    localILogger.b(paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  public static final void b(@NotNull String paramString, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "throwable");
    ILogger localILogger = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLogger");
    }
    localILogger.b(paramString, "", paramThrowable);
  }
  
  @JvmStatic
  public static final void c(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    ILogger localILogger = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLogger");
    }
    localILogger.d(paramString1, paramString2, null);
  }
  
  @JvmStatic
  public static final void d(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    ILogger localILogger = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLogger");
    }
    localILogger.b(paramString1, paramString2, null);
  }
  
  public final void a(@NotNull ILogger paramILogger)
  {
    Intrinsics.checkParameterIsNotNull(paramILogger, "logger");
    jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger = paramILogger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.TLog
 * JD-Core Version:    0.7.0.1
 */