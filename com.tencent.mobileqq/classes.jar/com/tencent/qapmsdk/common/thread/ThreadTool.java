package com.tencent.qapmsdk.common.thread;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/thread/ThreadTool;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class ThreadTool
{
  public static final ThreadTool.Companion Companion = new ThreadTool.Companion(null);
  private static final String TAG = "QAPM_common_ThreadTool";
  private static final ThreadLocal<StringBuilder> builderThreadLocal = new ThreadLocal();
  
  @JvmStatic
  public static final long getNativeThreadAddress(@NotNull Thread paramThread)
  {
    return Companion.getNativeThreadAddress(paramThread);
  }
  
  @JvmStatic
  @NotNull
  public static final StringBuilder getReuseStringBuilder()
  {
    return Companion.getReuseStringBuilder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.thread.ThreadTool
 * JD-Core Version:    0.7.0.1
 */