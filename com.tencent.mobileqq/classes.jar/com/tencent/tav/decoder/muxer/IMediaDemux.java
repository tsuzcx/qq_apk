package com.tencent.tav.decoder.muxer;

import android.support.annotation.NonNull;
import com.tencent.tav.core.ExportConfig;
import java.nio.ByteBuffer;

public abstract interface IMediaDemux
{
  public abstract int audioTrackIndex();
  
  public abstract boolean ignoreHeader();
  
  public abstract boolean isMuxerStarted();
  
  public abstract boolean prepare(@NonNull String paramString);
  
  public abstract int readSampleData(@NonNull ByteBuffer paramByteBuffer, int paramInt);
  
  public abstract void release();
  
  public abstract void seekTo(long paramLong, int paramInt);
  
  public abstract boolean selectTrack(int paramInt);
  
  public abstract void setExportConfig(@NonNull ExportConfig paramExportConfig);
  
  public abstract void stop();
  
  public abstract int videoTrackIndex();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.IMediaDemux
 * JD-Core Version:    0.7.0.1
 */