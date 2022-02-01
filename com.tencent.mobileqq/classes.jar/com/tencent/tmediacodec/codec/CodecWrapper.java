package com.tencent.tmediacodec.codec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;

public abstract interface CodecWrapper
{
  public abstract void attachThread();
  
  @TargetApi(26)
  public abstract void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler);
  
  public abstract void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt);
  
  public abstract int dequeueInputBuffer(long paramLong);
  
  public abstract int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo paramBufferInfo, long paramLong);
  
  public abstract void flush();
  
  @NonNull
  public abstract MediaCodec getMediaCodec();
  
  public abstract void prepareToReUse();
  
  public abstract void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
  
  public abstract void release();
  
  public abstract void releaseOutputBuffer(int paramInt, long paramLong);
  
  public abstract void releaseOutputBuffer(int paramInt, boolean paramBoolean);
  
  public abstract void reset();
  
  @NonNull
  public abstract ReuseHelper.ReuseType setCanReuseType(@NonNull FormatWrapper paramFormatWrapper);
  
  public abstract void setCodecCallback(@Nullable CodecCallback paramCodecCallback);
  
  @TargetApi(23)
  public abstract void setOutputSurface(@NonNull Surface paramSurface);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.CodecWrapper
 * JD-Core Version:    0.7.0.1
 */