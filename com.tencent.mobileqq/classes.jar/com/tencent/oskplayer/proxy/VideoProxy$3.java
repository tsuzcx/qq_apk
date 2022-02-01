package com.tencent.oskplayer.proxy;

import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.FileDataSource;

class VideoProxy$3
  extends FileDataSource
{
  VideoProxy$3(VideoProxy paramVideoProxy) {}
  
  public FileType getFileType()
  {
    return FileType.getFileType(PlayerConfig.CONTENT_TYPE_HLS_PLAYLIST);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.3
 * JD-Core Version:    0.7.0.1
 */