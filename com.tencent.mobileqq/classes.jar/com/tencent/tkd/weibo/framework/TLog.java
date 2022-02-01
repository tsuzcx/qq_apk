package com.tencent.tkd.weibo.framework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/framework/TLog;", "", "()V", "mLogger", "Lcom/tencent/tkd/weibo/framework/ILogger;", "d", "", "tag", "", "msg", "throwable", "", "e", "i", "init", "logger", "w", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TLog
{
  private static ILogger a;
  public static final TLog a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboFrameworkTLog = new TLog();
  }
  
  public final void a(@NotNull ILogger paramILogger)
  {
    Intrinsics.checkParameterIsNotNull(paramILogger, "logger");
    jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger = paramILogger;
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    ILogger localILogger = jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLogger");
    }
    localILogger.b(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.TLog
 * JD-Core Version:    0.7.0.1
 */