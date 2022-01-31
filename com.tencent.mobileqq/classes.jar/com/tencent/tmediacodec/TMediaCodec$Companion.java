package com.tencent.tmediacodec;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/TMediaCodec$Companion;", "", "()V", "ERROR_CODEC_NULL", "", "TAG", "", "createByCodecName", "Lcom/tencent/tmediacodec/TMediaCodec;", "name", "createDecoderByType", "type", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class TMediaCodec$Companion
{
  @JvmStatic
  @NotNull
  public final TMediaCodec createByCodecName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return new TMediaCodec(paramString, null);
  }
  
  @JvmStatic
  @NotNull
  public final TMediaCodec createDecoderByType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    return new TMediaCodec(paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.TMediaCodec.Companion
 * JD-Core Version:    0.7.0.1
 */