package com.tencent.tmediacodec.codec;

import android.media.MediaCodec;
import com.tencent.tmediacodec.util.TUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/tmediacodec/codec/CodecWrapper;", "codec", "Landroid/media/MediaCodec;", "mineType", "format", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class ReuseCodecWrapper$Companion
{
  @NotNull
  public final CodecWrapper create(@NotNull MediaCodec paramMediaCodec, @NotNull String paramString, @NotNull FormatWrapper paramFormatWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaCodec, "codec");
    Intrinsics.checkParameterIsNotNull(paramString, "mineType");
    Intrinsics.checkParameterIsNotNull(paramFormatWrapper, "format");
    if (TUtils.INSTANCE.isVideo(paramString)) {
      return (CodecWrapper)new VideoCodecWrapper(paramMediaCodec, paramFormatWrapper);
    }
    return (CodecWrapper)new AudioCodecWrapper(paramMediaCodec, paramFormatWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper.Companion
 * JD-Core Version:    0.7.0.1
 */