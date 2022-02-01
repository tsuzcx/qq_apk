package com.tencent.qapmsdk.common.thread;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.Reflect;
import com.tencent.qapmsdk.common.util.Reflect.Companion;
import com.tencent.qapmsdk.common.util.SystemProduct;
import com.tencent.qapmsdk.common.util.SystemProduct.Companion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/thread/ThreadTool$Companion;", "", "()V", "TAG", "", "builderThreadLocal", "Ljava/lang/ThreadLocal;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getNativeThreadAddress", "", "thread", "Ljava/lang/Thread;", "getReuseStringBuilder", "common_release"}, k=1, mv={1, 1, 15})
public final class ThreadTool$Companion
{
  @JvmStatic
  public final long getNativeThreadAddress(@NotNull Thread paramThread)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Intrinsics.checkParameterIsNotNull(paramThread, "thread");
    try
    {
      if (!SystemProduct.Companion.isDalvikVm()) {
        break label80;
      }
      paramThread = Reflect.Companion.getThreadPrivateField(paramThread, "vmThread");
      if (paramThread == null) {
        break label140;
      }
      paramThread = Reflect.Companion.getInstancePrivateField(paramThread, "vmData");
      if ((paramThread instanceof Long)) {
        break label137;
      }
      paramThread = localObject1;
    }
    catch (Throwable paramThread)
    {
      for (;;)
      {
        long l;
        Logger.INSTANCE.exception("QAPM_common_ThreadTool", "getNativeThreadAddress", paramThread);
        break;
      }
    }
    paramThread = (Long)paramThread;
    if (paramThread != null) {
      return ((Number)paramThread).longValue();
    }
    paramThread = (Void)null;
    break label140;
    label80:
    paramThread = Reflect.Companion.getThreadPrivateField(paramThread, "nativePeer");
    if (!(paramThread instanceof Long))
    {
      paramThread = localObject2;
      paramThread = (Long)paramThread;
      if (paramThread == null) {
        break label140;
      }
      l = ((Number)paramThread).longValue();
      return l;
    }
    label137:
    label140:
    return -1L;
  }
  
  @JvmStatic
  @NotNull
  public final StringBuilder getReuseStringBuilder()
  {
    StringBuilder localStringBuilder = (StringBuilder)ThreadTool.access$getBuilderThreadLocal$cp().get();
    if (localStringBuilder != null)
    {
      localStringBuilder = localStringBuilder.delete(0, localStringBuilder.length());
      if (localStringBuilder != null) {
        return localStringBuilder;
      }
    }
    localStringBuilder = new StringBuilder(1024);
    ThreadTool.access$getBuilderThreadLocal$cp().set(localStringBuilder);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.thread.ThreadTool.Companion
 * JD-Core Version:    0.7.0.1
 */