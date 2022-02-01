package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.DataRangeTracker;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

class CacheDataSource$LoaderListener
  implements Loader.Listener
{
  private long loadedPosition = -9223372036854775808L;
  
  private CacheDataSource$LoaderListener(CacheDataSource paramCacheDataSource) {}
  
  public void onLoadCancelled(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onLoadCancelled] enter. terminated: ");
      localStringBuilder.append(paramBoolean);
      Logger.i("CacheDataSource", localStringBuilder.toString());
      if (!paramBoolean) {
        try
        {
          if (CacheDataSource.access$200(this.this$0)) {
            break label97;
          }
          CacheDataSource.access$300(this.this$0).abandonLock();
        }
        catch (IllegalStateException localIllegalStateException)
        {
          onLoadError(new IOException("failed to start load after cancelling", localIllegalStateException));
          CacheDataSource.access$300(this.this$0).abandonLock();
        }
      } else {
        CacheDataSource.access$300(this.this$0).abandonLock();
      }
      label97:
      return;
    }
    finally {}
  }
  
  public void onLoadCompleted()
  {
    CacheDataSource.access$402(this.this$0, -9223372036854775808L);
    CacheDataSource.access$502(this.this$0, null);
    CacheDataSource.access$602(this.this$0, true);
    CacheDataSource.access$300(this.this$0).abandonLock();
    if (CacheDataSource.access$700(this.this$0) != null) {
      CacheDataSource.access$700(this.this$0).onStreamingFinished();
    }
  }
  
  public void onLoadError(IOException paramIOException)
  {
    Logger.e("CacheDataSource", "[onLoadError] enter.", paramIOException);
    long l2 = this.loadedPosition;
    long l1 = l2;
    if (l2 == -9223372036854775808L) {
      l1 = 0L;
    }
    CacheDataSource localCacheDataSource = this.this$0;
    localCacheDataSource.pendingRestartPositionByte = this.loadedPosition;
    if (CacheDataSource.access$700(localCacheDataSource) != null)
    {
      l2 = CacheDataSource.access$700(this.this$0).onStreamingError(paramIOException);
      if (l2 >= 0L)
      {
        CacheDataSource.access$900(this.this$0, l1, l2);
        this.this$0.pendingRestartPositionByte = -9223372036854775808L;
        return;
      }
      CacheDataSource.access$402(this.this$0, -9223372036854775808L);
      CacheDataSource.access$502(this.this$0, null);
      CacheDataSource.access$300(this.this$0).abandonLock();
      return;
    }
    CacheDataSource.access$402(this.this$0, -9223372036854775808L);
    CacheDataSource.access$502(this.this$0, null);
    CacheDataSource.access$300(this.this$0).abandonLock();
  }
  
  public void onLoadProgress(long paramLong1, long paramLong2)
  {
    this.loadedPosition = paramLong2;
    CacheDataSource.access$300(this.this$0).addRange(paramLong1, paramLong2);
    Loader localLoader = CacheDataSource.access$800(this.this$0);
    CacheDataSource.Listener localListener = CacheDataSource.access$700(this.this$0);
    if ((localListener != null) && (localLoader != null))
    {
      CacheDataSource.access$300(this.this$0).setFileTotalSize(localLoader.getUpstreamSize());
      localListener.onUpStreamTransfer(paramLong2, localLoader.getUpstreamSize());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.LoaderListener
 * JD-Core Version:    0.7.0.1
 */