package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@TargetApi(21)
public final class TMediaCodec$HookCallback
  extends MediaCodec.Callback
{
  @Nullable
  private final TMediaCodec.Callback callback;
  @NonNull
  private final TMediaCodec tMediaCodec;
  
  public TMediaCodec$HookCallback(@NonNull TMediaCodec paramTMediaCodec, @Nullable TMediaCodec.Callback paramCallback)
  {
    this.tMediaCodec = paramTMediaCodec;
    this.callback = paramCallback;
  }
  
  @Nullable
  public final TMediaCodec.Callback getCallback()
  {
    return this.callback;
  }
  
  @NonNull
  public final TMediaCodec getTMediaCodec()
  {
    return this.tMediaCodec;
  }
  
  public void onError(@NonNull MediaCodec paramMediaCodec, @NonNull MediaCodec.CodecException paramCodecException)
  {
    paramMediaCodec = this.callback;
    if (paramMediaCodec != null) {
      paramMediaCodec.onError(this.tMediaCodec, paramCodecException);
    }
  }
  
  public void onInputBufferAvailable(@NonNull MediaCodec paramMediaCodec, int paramInt)
  {
    paramMediaCodec = this.callback;
    if (paramMediaCodec != null) {
      paramMediaCodec.onInputBufferAvailable(this.tMediaCodec, paramInt);
    }
  }
  
  public void onOutputBufferAvailable(@NonNull MediaCodec paramMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo)
  {
    paramMediaCodec = this.callback;
    if (paramMediaCodec != null) {
      paramMediaCodec.onOutputBufferAvailable(this.tMediaCodec, paramInt, paramBufferInfo);
    }
  }
  
  public void onOutputFormatChanged(@NonNull MediaCodec paramMediaCodec, @NonNull MediaFormat paramMediaFormat)
  {
    paramMediaCodec = this.callback;
    if (paramMediaCodec != null) {
      paramMediaCodec.onOutputFormatChanged(this.tMediaCodec, paramMediaFormat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.TMediaCodec.HookCallback
 * JD-Core Version:    0.7.0.1
 */