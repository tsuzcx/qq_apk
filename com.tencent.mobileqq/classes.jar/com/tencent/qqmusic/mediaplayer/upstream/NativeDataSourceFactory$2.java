package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.util.Logger;

final class NativeDataSourceFactory$2
  implements INativeDataSource
{
  NativeDataSourceFactory$2(String paramString, int paramInt) {}
  
  public AudioFormat.AudioType getAudioType()
  {
    return null;
  }
  
  public long getNativeInstance()
  {
    if (NativeDataSourceFactory.access$000()) {}
    for (;;)
    {
      try
      {
        String str = this.val$filePath;
        if (this.val$needWrite <= 0) {
          break label55;
        }
        i = 1;
        long l = NativeDataSourceFactory.localFile(str, i);
        return l;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("NativeDataSourceFactory", "[getNativeInstance] failed to create native data source!", localThrowable);
        return 0L;
      }
      Logger.w("NativeDataSourceFactory", "[getNativeInstance] so not loaded properly!");
      return 0L;
      label55:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.NativeDataSourceFactory.2
 * JD-Core Version:    0.7.0.1
 */