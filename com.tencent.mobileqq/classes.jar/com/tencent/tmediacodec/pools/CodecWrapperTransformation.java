package com.tencent.tmediacodec.pools;

import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/pools/CodecWrapperTransformation;", "", "clearAndReleaseAll", "", "obtainCodecWrapper", "Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;", "format", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "removeFromRunning", "codecWrapper", "transToRunning", "transTokeep", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract interface CodecWrapperTransformation
{
  public abstract void clearAndReleaseAll();
  
  @Nullable
  public abstract ReuseCodecWrapper obtainCodecWrapper(@NotNull FormatWrapper paramFormatWrapper);
  
  public abstract void removeFromRunning(@NotNull ReuseCodecWrapper paramReuseCodecWrapper);
  
  public abstract void transToRunning(@NotNull ReuseCodecWrapper paramReuseCodecWrapper);
  
  public abstract void transTokeep(@NotNull ReuseCodecWrapper paramReuseCodecWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperTransformation
 * JD-Core Version:    0.7.0.1
 */