package com.tencent.rmonitor.common.logcat;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/logcat/LogcatManager;", "", "()V", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class LogcatManager
{
  public static final LogcatManager.Companion a = new LogcatManager.Companion(null);
  private static final Lazy b = LazyKt.lazy((Function0)LogcatManager.Companion.javaLog.2.INSTANCE);
  private static final Lazy c = LazyKt.lazy((Function0)LogcatManager.Companion.nativeLog.2.INSTANCE);
  
  @JvmStatic
  @Nullable
  public static final ILogcat a(int paramInt)
  {
    return a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.logcat.LogcatManager
 * JD-Core Version:    0.7.0.1
 */