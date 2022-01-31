package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.view.Surface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/IMediaCodec;", "", "configure", "", "format", "Landroid/media/MediaFormat;", "surface", "Landroid/view/Surface;", "crypto", "Landroid/media/MediaCrypto;", "flags", "", "descrambler", "Landroid/media/MediaDescrambler;", "release", "releaseOutputBuffer", "index", "render", "", "renderTimestampNs", "", "reset", "start", "stop", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract interface IMediaCodec
{
  @TargetApi(26)
  public abstract void configure(@NotNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler);
  
  public abstract void configure(@NotNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt);
  
  public abstract void release();
  
  @TargetApi(21)
  public abstract void releaseOutputBuffer(int paramInt, long paramLong);
  
  public abstract void releaseOutputBuffer(int paramInt, boolean paramBoolean);
  
  public abstract void reset();
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.IMediaCodec
 * JD-Core Version:    0.7.0.1
 */