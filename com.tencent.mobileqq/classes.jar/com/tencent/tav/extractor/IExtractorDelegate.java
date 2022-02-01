package com.tencent.tav.extractor;

import android.media.MediaFormat;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;

public abstract interface IExtractorDelegate
{
  public abstract boolean advance();
  
  public abstract long getSampleTime();
  
  public abstract int getSampleTrackIndex();
  
  public abstract int getTrackCount();
  
  @NonNull
  public abstract MediaFormat getTrackFormat(int paramInt);
  
  public abstract boolean needMirror();
  
  public abstract int readSampleData(@NonNull ByteBuffer paramByteBuffer, int paramInt);
  
  public abstract void release();
  
  public abstract void seekTo(long paramLong, int paramInt);
  
  public abstract void selectTrack(int paramInt);
  
  public abstract void setDataSource(@NonNull String paramString);
  
  public abstract void unselectTrack(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.extractor.IExtractorDelegate
 * JD-Core Version:    0.7.0.1
 */