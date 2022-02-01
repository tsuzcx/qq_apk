package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener;
import com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

class CommonPlayer$BufferListener
  implements CacheDataSource.Listener
{
  private CommonPlayer$BufferListener(CommonPlayer paramCommonPlayer) {}
  
  public void onBufferEnded()
  {
    Logger.i("CommonPlayer", CommonPlayer.access$1000(this.this$0, "buffer ended."));
  }
  
  public void onBufferStarted(long paramLong)
  {
    Logger.i("CommonPlayer", CommonPlayer.access$1000(this.this$0, "buffer started."));
  }
  
  public void onBytesTransferError(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onBytesTransferred(long paramLong1, long paramLong2) {}
  
  public void onBytesTransferring(long paramLong1, long paramLong2) {}
  
  public long onStreamingError(IOException paramIOException)
  {
    Logger.e("CommonPlayer", CommonPlayer.access$1000(this.this$0, "streaming error!"), paramIOException);
    return -1L;
  }
  
  public void onStreamingFinished()
  {
    Logger.i("CommonPlayer", CommonPlayer.access$1000(this.this$0, "streaming finished"));
  }
  
  public void onTransferEnd() {}
  
  public void onTransferStart() {}
  
  public void onUpStreamTransfer(long paramLong1, long paramLong2)
  {
    if ((this.this$0.getPlayerState() != 2) && (this.this$0.getPlayerState() != 4)) {
      return;
    }
    double d1 = paramLong1;
    double d2 = paramLong2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    int i = (int)Math.round(d1 / d2 * 100.0D);
    if (i == CommonPlayer.access$1100(this.this$0)) {
      return;
    }
    CommonPlayer.access$1102(this.this$0, i);
    ListPlayerListenerCallback localListPlayerListenerCallback = CommonPlayer.access$100(this.this$0);
    CommonPlayer localCommonPlayer = this.this$0;
    localListPlayerListenerCallback.onBufferingUpdate(localCommonPlayer, CommonPlayer.access$1100(localCommonPlayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer.BufferListener
 * JD-Core Version:    0.7.0.1
 */