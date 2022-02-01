package com.tencent.qapmsdk.common.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/ByteArrayPool$Companion;", "", "()V", "BUF_COMPARATOR", "Ljava/util/Comparator;", "", "genericInstance", "Lcom/tencent/qapmsdk/common/util/ByteArrayPool;", "genericInstance$annotations", "getGenericInstance", "()Lcom/tencent/qapmsdk/common/util/ByteArrayPool;", "setGenericInstance", "(Lcom/tencent/qapmsdk/common/util/ByteArrayPool;)V", "common_release"}, k=1, mv={1, 1, 15})
public final class ByteArrayPool$Companion
{
  @NotNull
  public final ByteArrayPool getGenericInstance()
  {
    return ByteArrayPool.access$getGenericInstance$cp();
  }
  
  public final void setGenericInstance(@NotNull ByteArrayPool paramByteArrayPool)
  {
    Intrinsics.checkParameterIsNotNull(paramByteArrayPool, "<set-?>");
    ByteArrayPool.access$setGenericInstance$cp(paramByteArrayPool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.ByteArrayPool.Companion
 * JD-Core Version:    0.7.0.1
 */