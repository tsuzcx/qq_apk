package com.tencent.tmediacodec.codec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/codec/CodecWrapper;", "", "configure", "", "format", "Landroid/media/MediaFormat;", "surface", "Landroid/view/Surface;", "crypto", "Landroid/media/MediaCrypto;", "flags", "", "descrambler", "Landroid/media/MediaDescrambler;", "dequeueInputBuffer", "timeoutUs", "", "dequeueOutputBuffer", "info", "Landroid/media/MediaCodec$BufferInfo;", "flush", "getMediaCodec", "Landroid/media/MediaCodec;", "prepareToReUse", "queueInputBuffer", "index", "offset", "size", "presentationTimeUs", "release", "releaseOutputBuffer", "render", "", "renderTimestampNs", "reset", "setCanReuseType", "Lcom/tencent/tmediacodec/reuse/ReuseHelper$ReuseType;", "newFormat", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "setCodecCallback", "codecCallback", "Lcom/tencent/tmediacodec/callback/CodecCallback;", "setOutputSurface", "start", "stop", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract interface CodecWrapper
{
  @TargetApi(26)
  public abstract void configure(@NotNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler);
  
  public abstract void configure(@NotNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt);
  
  public abstract int dequeueInputBuffer(long paramLong);
  
  public abstract int dequeueOutputBuffer(@NotNull MediaCodec.BufferInfo paramBufferInfo, long paramLong);
  
  public abstract void flush();
  
  @NotNull
  public abstract MediaCodec getMediaCodec();
  
  public abstract void prepareToReUse();
  
  public abstract void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
  
  public abstract void release();
  
  public abstract void releaseOutputBuffer(int paramInt, long paramLong);
  
  public abstract void releaseOutputBuffer(int paramInt, boolean paramBoolean);
  
  public abstract void reset();
  
  @NotNull
  public abstract ReuseHelper.ReuseType setCanReuseType(@NotNull FormatWrapper paramFormatWrapper);
  
  public abstract void setCodecCallback(@Nullable CodecCallback paramCodecCallback);
  
  @TargetApi(23)
  public abstract void setOutputSurface(@NonNull @NotNull Surface paramSurface);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.CodecWrapper
 * JD-Core Version:    0.7.0.1
 */