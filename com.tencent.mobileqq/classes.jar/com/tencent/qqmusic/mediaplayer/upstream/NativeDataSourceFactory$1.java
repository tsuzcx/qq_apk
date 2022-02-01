package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.util.Logger;

final class NativeDataSourceFactory$1
  implements INativeDataSource
{
  NativeDataSourceFactory$1(String paramString) {}
  
  public AudioFormat.AudioType getAudioType()
  {
    return null;
  }
  
  public long getNativeInstance()
  {
    if (NativeDataSourceFactory.access$000()) {
      try
      {
        long l = NativeDataSourceFactory.localFile(this.val$filePath, 0);
        return l;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("NativeDataSourceFactory", "[getNativeInstance] failed to create native data source!", localThrowable);
        return 0L;
      }
    }
    Logger.w("NativeDataSourceFactory", "[getNativeInstance] so not loaded properly!");
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.NativeDataSourceFactory.1
 * JD-Core Version:    0.7.0.1
 */