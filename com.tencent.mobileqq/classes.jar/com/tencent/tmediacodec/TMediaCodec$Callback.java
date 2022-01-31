package com.tencent.tmediacodec;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/TMediaCodec$Callback;", "", "()V", "onError", "", "codec", "Lcom/tencent/tmediacodec/TMediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract class TMediaCodec$Callback
{
  public abstract void onError(@NonNull @NotNull TMediaCodec paramTMediaCodec, @NonNull @NotNull MediaCodec.CodecException paramCodecException);
  
  public abstract void onInputBufferAvailable(@NonNull @NotNull TMediaCodec paramTMediaCodec, int paramInt);
  
  public abstract void onOutputBufferAvailable(@NonNull @NotNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull @NotNull MediaCodec.BufferInfo paramBufferInfo);
  
  public abstract void onOutputFormatChanged(@NonNull @NotNull TMediaCodec paramTMediaCodec, @NonNull @NotNull MediaFormat paramMediaFormat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.TMediaCodec.Callback
 * JD-Core Version:    0.7.0.1
 */