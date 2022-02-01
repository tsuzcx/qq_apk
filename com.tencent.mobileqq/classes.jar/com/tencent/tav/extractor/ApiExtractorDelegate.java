package com.tencent.tav.extractor;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;

public class ApiExtractorDelegate
  implements IExtractorDelegate
{
  private MediaExtractor mediaExtractor = new MediaExtractor();
  private boolean released = false;
  
  public boolean advance()
  {
    try
    {
      if (!this.released) {
        this.mediaExtractor.advance();
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getSampleTime()
  {
    try
    {
      if (!this.released)
      {
        long l = this.mediaExtractor.getSampleTime();
        return l;
      }
      return -1L;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getSampleTrackIndex()
  {
    try
    {
      if (!this.released)
      {
        int i = this.mediaExtractor.getSampleTrackIndex();
        return i;
      }
      return -1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int getTrackCount()
  {
    try
    {
      if (!this.released)
      {
        int i = this.mediaExtractor.getTrackCount();
        return i;
      }
      return 0;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @NonNull
  public MediaFormat getTrackFormat(int paramInt)
  {
    try
    {
      MediaFormat localMediaFormat = this.mediaExtractor.getTrackFormat(paramInt);
      return localMediaFormat;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean needMirror()
  {
    return true;
  }
  
  public int readSampleData(@NonNull ByteBuffer paramByteBuffer, int paramInt)
  {
    try
    {
      if (!this.released)
      {
        paramInt = this.mediaExtractor.readSampleData(paramByteBuffer, paramInt);
        return paramInt;
      }
      return -1;
    }
    finally
    {
      paramByteBuffer = finally;
      throw paramByteBuffer;
    }
  }
  
  public final void release()
  {
    try
    {
      this.mediaExtractor.release();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void seekTo(long paramLong, int paramInt)
  {
    try
    {
      if (!this.released) {
        this.mediaExtractor.seekTo(paramLong, paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void selectTrack(int paramInt)
  {
    try
    {
      if (!this.released) {
        this.mediaExtractor.selectTrack(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void setDataSource(@NonNull java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/tav/extractor/ApiExtractorDelegate:mediaExtractor	Landroid/media/MediaExtractor;
    //   6: aload_1
    //   7: invokevirtual 68	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   10: goto +12 -> 22
    //   13: astore_1
    //   14: goto +11 -> 25
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	ApiExtractorDelegate
    //   0	29	1	paramString	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
    //   18	22	13	finally
    //   2	10	17	java/io/IOException
  }
  
  public void unselectTrack(int paramInt)
  {
    try
    {
      if (!this.released) {
        this.mediaExtractor.unselectTrack(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.extractor.ApiExtractorDelegate
 * JD-Core Version:    0.7.0.1
 */