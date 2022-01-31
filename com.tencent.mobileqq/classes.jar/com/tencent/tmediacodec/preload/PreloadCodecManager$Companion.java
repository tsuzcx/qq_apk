package com.tencent.tmediacodec.preload;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/preload/PreloadCodecManager$Companion;", "", "()V", "TAG", "", "isInvalideMimeType", "", "sampleMimeType", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class PreloadCodecManager$Companion
{
  public final boolean isInvalideMimeType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "sampleMimeType");
    return (Intrinsics.areEqual(paramString, "video/avc")) || (Intrinsics.areEqual(paramString, "video/hevc"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.preload.PreloadCodecManager.Companion
 * JD-Core Version:    0.7.0.1
 */