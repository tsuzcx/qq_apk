package com.tencent.qqmusic.mediaplayer;

import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;

class CommonPlayer$OpenedResources
{
  @Nullable
  private File bufferFile;
  @Nullable
  private CacheDataSource dataSource;
  
  void release()
  {
    Object localObject = this.bufferFile;
    if ((localObject != null) && (!((File)localObject).delete()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[release] failed to delete buffer file: ");
      ((StringBuilder)localObject).append(this.bufferFile);
      Logger.w("CommonPlayer", ((StringBuilder)localObject).toString());
    }
    localObject = this.dataSource;
    if (localObject != null) {
      ((CacheDataSource)localObject).setListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer.OpenedResources
 * JD-Core Version:    0.7.0.1
 */