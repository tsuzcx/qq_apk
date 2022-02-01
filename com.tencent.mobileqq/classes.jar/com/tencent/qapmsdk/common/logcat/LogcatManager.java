package com.tencent.qapmsdk.common.logcat;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logcat/LogcatManager;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class LogcatManager
{
  public static final LogcatManager.Companion Companion = new LogcatManager.Companion(null);
  public static final int JAVA = 1;
  public static final int NATIVE = 2;
  private static final Lazy javaLog$delegate = LazyKt.lazy((Function0)LogcatManager.Companion.javaLog.2.INSTANCE);
  private static final Lazy nativeLog$delegate = LazyKt.lazy((Function0)LogcatManager.Companion.nativeLog.2.INSTANCE);
  
  @JvmStatic
  @Nullable
  public static final ILogcat initLogcat(int paramInt)
  {
    return Companion.initLogcat(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logcat.LogcatManager
 * JD-Core Version:    0.7.0.1
 */