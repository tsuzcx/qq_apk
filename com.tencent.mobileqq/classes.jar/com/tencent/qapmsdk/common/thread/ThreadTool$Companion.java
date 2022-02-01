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
    Intrinsics.checkParameterIsNotNull(paramThread, "thread");
    try
    {
      Object localObject;
      if (SystemProduct.Companion.isDalvikVm())
      {
        paramThread = Reflect.Companion.getThreadPrivateField(paramThread, "vmThread");
        if (paramThread != null)
        {
          localObject = Reflect.Companion.getInstancePrivateField(paramThread, "vmData");
          paramThread = localObject;
          if (!(localObject instanceof Long)) {
            paramThread = null;
          }
          paramThread = (Long)paramThread;
          if (paramThread != null) {
            return ((Number)paramThread).longValue();
          }
          paramThread = (Void)null;
        }
      }
      else
      {
        localObject = Reflect.Companion.getThreadPrivateField(paramThread, "nativePeer");
        paramThread = localObject;
        if (!(localObject instanceof Long)) {
          paramThread = null;
        }
        paramThread = (Long)paramThread;
        if (paramThread != null)
        {
          long l = ((Number)paramThread).longValue();
          return l;
        }
      }
    }
    catch (Throwable paramThread)
    {
      Logger.INSTANCE.exception("QAPM_common_ThreadTool", "getNativeThreadAddress", paramThread);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.thread.ThreadTool.Companion
 * JD-Core Version:    0.7.0.1
 */