package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.TimerTask;

class CacheDataSource$2
  extends TimerTask
{
  CacheDataSource$2(CacheDataSource paramCacheDataSource, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[scheduleRestart] restart loading from position: ");
    localStringBuilder.append(this.val$restartPosition);
    Logger.i("CacheDataSource", localStringBuilder.toString());
    CacheDataSource.access$100(this.this$0, this.val$restartPosition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.2
 * JD-Core Version:    0.7.0.1
 */