package com.tencent.tmediacodec.pools;

import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tmediacodec/pools/CodecWrapperManager$1", "Lcom/tencent/tmediacodec/pools/PoolActionCallback;", "onErase", "", "codecWrapper", "Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class CodecWrapperManager$1
  implements PoolActionCallback
{
  public void onErase(@NotNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramReuseCodecWrapper, "codecWrapper");
    LogUtils.INSTANCE.d("CodecWrapperManager", "onErase codecWrapper:" + paramReuseCodecWrapper);
    paramReuseCodecWrapper.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperManager.1
 * JD-Core Version:    0.7.0.1
 */