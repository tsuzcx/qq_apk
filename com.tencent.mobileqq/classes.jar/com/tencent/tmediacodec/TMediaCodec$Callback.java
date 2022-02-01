package com.tencent.tmediacodec;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.support.annotation.NonNull;

public abstract class TMediaCodec$Callback
{
  public abstract void onError(@NonNull TMediaCodec paramTMediaCodec, @NonNull MediaCodec.CodecException paramCodecException);
  
  public abstract void onInputBufferAvailable(@NonNull TMediaCodec paramTMediaCodec, int paramInt);
  
  public abstract void onOutputBufferAvailable(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo);
  
  public abstract void onOutputFormatChanged(@NonNull TMediaCodec paramTMediaCodec, @NonNull MediaFormat paramMediaFormat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.TMediaCodec.Callback
 * JD-Core Version:    0.7.0.1
 */