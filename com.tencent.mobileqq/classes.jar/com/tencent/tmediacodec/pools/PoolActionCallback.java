package com.tencent.tmediacodec.pools;

import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/pools/PoolActionCallback;", "", "onErase", "", "codecWrapper", "Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract interface PoolActionCallback
{
  public abstract void onErase(@NotNull ReuseCodecWrapper paramReuseCodecWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.PoolActionCallback
 * JD-Core Version:    0.7.0.1
 */