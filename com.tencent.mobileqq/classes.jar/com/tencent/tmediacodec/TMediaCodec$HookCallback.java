package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/TMediaCodec$HookCallback;", "Landroid/media/MediaCodec$Callback;", "tMediaCodec", "Lcom/tencent/tmediacodec/TMediaCodec;", "callback", "Lcom/tencent/tmediacodec/TMediaCodec$Callback;", "(Lcom/tencent/tmediacodec/TMediaCodec;Lcom/tencent/tmediacodec/TMediaCodec$Callback;)V", "getCallback", "()Lcom/tencent/tmediacodec/TMediaCodec$Callback;", "getTMediaCodec", "()Lcom/tencent/tmediacodec/TMediaCodec;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
@TargetApi(21)
public final class TMediaCodec$HookCallback
  extends MediaCodec.Callback
{
  @Nullable
  private final TMediaCodec.Callback callback;
  @NotNull
  private final TMediaCodec tMediaCodec;
  
  public TMediaCodec$HookCallback(@NotNull TMediaCodec paramTMediaCodec, @Nullable TMediaCodec.Callback paramCallback)
  {
    this.tMediaCodec = paramTMediaCodec;
    this.callback = paramCallback;
  }
  
  @Nullable
  public final TMediaCodec.Callback getCallback()
  {
    return this.callback;
  }
  
  @NotNull
  public final TMediaCodec getTMediaCodec()
  {
    return this.tMediaCodec;
  }
  
  public void onError(@NotNull MediaCodec paramMediaCodec, @NotNull MediaCodec.CodecException paramCodecException)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaCodec, "codec");
    Intrinsics.checkParameterIsNotNull(paramCodecException, "e");
    paramMediaCodec = this.callback;
    if (paramMediaCodec != null) {
      paramMediaCodec.onError(this.tMediaCodec, paramCodecException);
    }
  }
  
  public void onInputBufferAvailable(@NotNull MediaCodec paramMediaCodec, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaCodec, "codec");
    paramMediaCodec = this.callback;
    if (paramMediaCodec != null) {
      paramMediaCodec.onInputBufferAvailable(this.tMediaCodec, paramInt);
    }
  }
  
  public void onOutputBufferAvailable(@NotNull MediaCodec paramMediaCodec, int paramInt, @NotNull MediaCodec.BufferInfo paramBufferInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaCodec, "codec");
    Intrinsics.checkParameterIsNotNull(paramBufferInfo, "info");
    paramMediaCodec = this.callback;
    if (paramMediaCodec != null) {
      paramMediaCodec.onOutputBufferAvailable(this.tMediaCodec, paramInt, paramBufferInfo);
    }
  }
  
  public void onOutputFormatChanged(@NotNull MediaCodec paramMediaCodec, @NotNull MediaFormat paramMediaFormat)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaCodec, "codec");
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    paramMediaCodec = this.callback;
    if (paramMediaCodec != null) {
      paramMediaCodec.onOutputFormatChanged(this.tMediaCodec, paramMediaFormat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.TMediaCodec.HookCallback
 * JD-Core Version:    0.7.0.1
 */