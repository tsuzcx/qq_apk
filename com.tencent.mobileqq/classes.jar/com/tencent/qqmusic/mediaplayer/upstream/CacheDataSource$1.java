package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Looper;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;

class CacheDataSource$1
  implements Loader.Factory
{
  CacheDataSource$1(Looper paramLooper, IDataSource paramIDataSource, IDataSink paramIDataSink) {}
  
  public Loader createLoader(Loader.Listener paramListener)
  {
    return new CacheDataSource.1.1(this, this.val$eventLooper, new DummyUriLoader(null), paramListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.1
 * JD-Core Version:    0.7.0.1
 */