package com.tencent.tav.extractor;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import java.io.FileDescriptor;
import java.io.IOException;

public class ApiAssetExtractorDelegate
  implements IAssetExtractorDelegate
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
  
  /* Error */
  public long getSampleTime()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/tencent/tav/extractor/ApiAssetExtractorDelegate:released	Z
    //   6: ifne +15 -> 21
    //   9: aload_0
    //   10: getfield 21	com/tencent/tav/extractor/ApiAssetExtractorDelegate:mediaExtractor	Landroid/media/MediaExtractor;
    //   13: invokevirtual 30	android/media/MediaExtractor:getSampleTime	()J
    //   16: lstore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: lload_1
    //   20: lreturn
    //   21: ldc2_w 31
    //   24: lstore_1
    //   25: goto -8 -> 17
    //   28: astore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	ApiAssetExtractorDelegate
    //   16	9	1	l	long
    //   28	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	28	finally
  }
  
  /* Error */
  public int getSampleTrackIndex()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/tencent/tav/extractor/ApiAssetExtractorDelegate:released	Z
    //   6: ifne +15 -> 21
    //   9: aload_0
    //   10: getfield 21	com/tencent/tav/extractor/ApiAssetExtractorDelegate:mediaExtractor	Landroid/media/MediaExtractor;
    //   13: invokevirtual 36	android/media/MediaExtractor:getSampleTrackIndex	()I
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_m1
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	ApiAssetExtractorDelegate
    //   16	7	1	i	int
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  /* Error */
  public final int getTrackCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/tencent/tav/extractor/ApiAssetExtractorDelegate:released	Z
    //   6: ifne +15 -> 21
    //   9: aload_0
    //   10: getfield 21	com/tencent/tav/extractor/ApiAssetExtractorDelegate:mediaExtractor	Landroid/media/MediaExtractor;
    //   13: invokevirtual 39	android/media/MediaExtractor:getTrackCount	()I
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	ApiAssetExtractorDelegate
    //   16	7	1	i	int
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
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
  
  /* Error */
  public int readSampleData(@NonNull java.nio.ByteBuffer paramByteBuffer, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/tencent/tav/extractor/ApiAssetExtractorDelegate:released	Z
    //   6: ifne +17 -> 23
    //   9: aload_0
    //   10: getfield 21	com/tencent/tav/extractor/ApiAssetExtractorDelegate:mediaExtractor	Landroid/media/MediaExtractor;
    //   13: aload_1
    //   14: iload_2
    //   15: invokevirtual 49	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   18: istore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: iconst_m1
    //   24: istore_2
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	ApiAssetExtractorDelegate
    //   0	33	1	paramByteBuffer	java.nio.ByteBuffer
    //   0	33	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	19	28	finally
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
  
  @TargetApi(24)
  public final void setDataSource(@NonNull AssetFileDescriptor paramAssetFileDescriptor)
  {
    try
    {
      this.mediaExtractor.setDataSource(paramAssetFileDescriptor);
      return;
    }
    catch (IOException paramAssetFileDescriptor)
    {
      for (;;)
      {
        paramAssetFileDescriptor.printStackTrace();
      }
    }
    finally {}
  }
  
  public final void setDataSource(@NonNull FileDescriptor paramFileDescriptor)
  {
    try
    {
      this.mediaExtractor.setDataSource(paramFileDescriptor, 0L, 576460752303423487L);
      return;
    }
    catch (IOException paramFileDescriptor)
    {
      for (;;)
      {
        paramFileDescriptor.printStackTrace();
      }
    }
    finally {}
  }
  
  public final void setDataSource(@NonNull String paramString)
  {
    try
    {
      this.mediaExtractor.setDataSource(paramString);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.extractor.ApiAssetExtractorDelegate
 * JD-Core Version:    0.7.0.1
 */