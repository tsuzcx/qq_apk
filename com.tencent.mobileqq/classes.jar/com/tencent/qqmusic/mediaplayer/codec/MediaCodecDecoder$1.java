package com.tencent.qqmusic.mediaplayer.codec;

import android.media.MediaDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

class MediaCodecDecoder$1
  extends MediaDataSource
{
  MediaCodecDecoder$1(MediaCodecDecoder paramMediaCodecDecoder, IDataSource paramIDataSource) {}
  
  public void close() {}
  
  public long getSize()
  {
    return this.val$dataSource.getSize();
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.val$dataSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder.1
 * JD-Core Version:    0.7.0.1
 */