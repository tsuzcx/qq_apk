package com.tencent.rmonitor.common.logcat;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/logcat/LogcatManager$Companion;", "", "()V", "JAVA", "", "NATIVE", "javaLog", "Lcom/tencent/rmonitor/common/logcat/LogcatFromJava;", "getJavaLog", "()Lcom/tencent/rmonitor/common/logcat/LogcatFromJava;", "javaLog$delegate", "Lkotlin/Lazy;", "nativeLog", "Lcom/tencent/rmonitor/common/logcat/LogcatFromNative;", "getNativeLog", "()Lcom/tencent/rmonitor/common/logcat/LogcatFromNative;", "nativeLog$delegate", "initLogcat", "Lcom/tencent/rmonitor/common/logcat/ILogcat;", "type", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class LogcatManager$Companion
{
  private final LogcatFromJava a()
  {
    Lazy localLazy = LogcatManager.a();
    Object localObject = LogcatManager.a;
    localObject = a[0];
    return (LogcatFromJava)localLazy.getValue();
  }
  
  private final LogcatFromNative b()
  {
    Lazy localLazy = LogcatManager.b();
    Object localObject = LogcatManager.a;
    localObject = a[1];
    return (LogcatFromNative)localLazy.getValue();
  }
  
  @JvmStatic
  @Nullable
  public final ILogcat a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return (ILogcat)((Companion)this).a();
      }
      return (ILogcat)((Companion)this).b();
    }
    return (ILogcat)((Companion)this).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.logcat.LogcatManager.Companion
 * JD-Core Version:    0.7.0.1
 */