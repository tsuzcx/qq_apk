package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import com.tencent.tav.core.ExportConfig;
import java.nio.ByteBuffer;

public abstract interface IMediaMux
{
  public abstract int addTrack(@NonNull MediaFormat paramMediaFormat);
  
  public abstract int audioTrackIndex();
  
  public abstract boolean ignoreHeader();
  
  public abstract boolean isMuxerStarted();
  
  public abstract boolean prepare(@NonNull String paramString, int paramInt);
  
  public abstract void release();
  
  public abstract void setExportConfig(@NonNull ExportConfig paramExportConfig);
  
  public abstract boolean start();
  
  public abstract void stop();
  
  public abstract int videoTrackIndex();
  
  public abstract void writeSampleData(int paramInt, @NonNull ByteBuffer paramByteBuffer, @NonNull MediaCodec.BufferInfo paramBufferInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.IMediaMux
 * JD-Core Version:    0.7.0.1
 */