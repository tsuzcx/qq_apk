package com.tencent.tmediacodec.codec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import com.tencent.tmediacodec.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/codec/DirectCodecWrapper;", "Lcom/tencent/tmediacodec/codec/CodecWrapper;", "codec", "Landroid/media/MediaCodec;", "(Landroid/media/MediaCodec;)V", "getCodec", "()Landroid/media/MediaCodec;", "configure", "", "format", "Landroid/media/MediaFormat;", "surface", "Landroid/view/Surface;", "crypto", "Landroid/media/MediaCrypto;", "flags", "", "descrambler", "Landroid/media/MediaDescrambler;", "dequeueInputBuffer", "timeoutUs", "", "dequeueOutputBuffer", "info", "Landroid/media/MediaCodec$BufferInfo;", "flush", "getMediaCodec", "prepareToReUse", "queueInputBuffer", "index", "offset", "size", "presentationTimeUs", "release", "releaseOutputBuffer", "render", "", "renderTimestampNs", "reset", "setCanReuseType", "Lcom/tencent/tmediacodec/reuse/ReuseHelper$ReuseType;", "newFormat", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "setCodecCallback", "codecCallback", "Lcom/tencent/tmediacodec/callback/CodecCallback;", "setOutputSurface", "start", "stop", "Companion", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class DirectCodecWrapper
  implements CodecWrapper
{
  public static final DirectCodecWrapper.Companion Companion = new DirectCodecWrapper.Companion(null);
  @NotNull
  public static final String TAG = "DirectCodecWrapper";
  @NotNull
  private final MediaCodec codec;
  
  public DirectCodecWrapper(@NotNull MediaCodec paramMediaCodec)
  {
    this.codec = paramMediaCodec;
  }
  
  @TargetApi(26)
  public void configure(@NotNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    this.codec.configure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler);
  }
  
  public void configure(@NotNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    this.codec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
  }
  
  public int dequeueInputBuffer(long paramLong)
  {
    return this.codec.dequeueInputBuffer(paramLong);
  }
  
  public int dequeueOutputBuffer(@NotNull MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferInfo, "info");
    return this.codec.dequeueOutputBuffer(paramBufferInfo, paramLong);
  }
  
  public void flush()
  {
    this.codec.flush();
  }
  
  @NotNull
  public final MediaCodec getCodec()
  {
    return this.codec;
  }
  
  @NotNull
  public MediaCodec getMediaCodec()
  {
    return this.codec;
  }
  
  public void prepareToReUse()
  {
    LogUtils.w$default(LogUtils.INSTANCE, "DirectCodecWrapper", "DirectCodecWrapper prepareToReUse ignore...", null, 4, null);
  }
  
  public void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    this.codec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
  }
  
  public void release()
  {
    this.codec.release();
  }
  
  @TargetApi(21)
  public void releaseOutputBuffer(int paramInt, long paramLong)
  {
    this.codec.releaseOutputBuffer(paramInt, paramLong);
  }
  
  public void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    this.codec.releaseOutputBuffer(paramInt, paramBoolean);
  }
  
  @TargetApi(21)
  public void reset()
  {
    this.codec.reset();
  }
  
  @NotNull
  public ReuseHelper.ReuseType setCanReuseType(@NotNull FormatWrapper paramFormatWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramFormatWrapper, "newFormat");
    LogUtils.w$default(LogUtils.INSTANCE, "DirectCodecWrapper", "setCanReuseType setCodecCallback ignore...", null, 4, null);
    return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
  }
  
  public void setCodecCallback(@Nullable CodecCallback paramCodecCallback)
  {
    LogUtils.w$default(LogUtils.INSTANCE, "DirectCodecWrapper", "DirectCodecWrapper setCodecCallback ignore...", null, 4, null);
  }
  
  @TargetApi(23)
  public void setOutputSurface(@NotNull Surface paramSurface)
  {
    Intrinsics.checkParameterIsNotNull(paramSurface, "surface");
    this.codec.setOutputSurface(paramSurface);
  }
  
  public void start()
  {
    this.codec.start();
  }
  
  public void stop()
  {
    this.codec.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.DirectCodecWrapper
 * JD-Core Version:    0.7.0.1
 */