package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;

public abstract interface IMediaCodec
{
  @TargetApi(26)
  public abstract void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler);
  
  public abstract void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt);
  
  public abstract void release();
  
  @TargetApi(21)
  public abstract void releaseOutputBuffer(int paramInt, long paramLong);
  
  public abstract void releaseOutputBuffer(int paramInt, boolean paramBoolean);
  
  public abstract void reset();
  
  public abstract void setParameters(@Nullable Bundle paramBundle);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.IMediaCodec
 * JD-Core Version:    0.7.0.1
 */