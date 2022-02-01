package com.tencent.tav.extractor;

import android.content.res.AssetFileDescriptor;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;

abstract interface IAssetExtractorDelegate
{
  public abstract boolean advance();
  
  public abstract long getSampleTime();
  
  public abstract int getSampleTrackIndex();
  
  public abstract int getTrackCount();
  
  @NonNull
  public abstract MediaFormat getTrackFormat(int paramInt);
  
  public abstract int readSampleData(@NonNull ByteBuffer paramByteBuffer, int paramInt);
  
  public abstract void release();
  
  public abstract void seekTo(long paramLong, int paramInt);
  
  public abstract void selectTrack(int paramInt);
  
  public abstract void setDataSource(@NonNull AssetFileDescriptor paramAssetFileDescriptor);
  
  public abstract void setDataSource(@NonNull FileDescriptor paramFileDescriptor);
  
  public abstract void setDataSource(@NonNull String paramString);
  
  public abstract void unselectTrack(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.extractor.IAssetExtractorDelegate
 * JD-Core Version:    0.7.0.1
 */