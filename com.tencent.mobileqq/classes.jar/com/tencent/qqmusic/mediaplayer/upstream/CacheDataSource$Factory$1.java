package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;

final class CacheDataSource$Factory$1
  extends FileDataSource
{
  CacheDataSource$Factory$1(String paramString, File paramFile)
  {
    super(paramString);
  }
  
  public void close()
  {
    try
    {
      super.close();
      label4:
      if (!this.val$bufferFile.delete())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("failed to delete buffer file: ");
        localStringBuilder.append(this.val$bufferFile);
        Logger.w("CacheDataSource", localStringBuilder.toString());
      }
      return;
    }
    catch (IOException localIOException)
    {
      break label4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.1
 * JD-Core Version:    0.7.0.1
 */