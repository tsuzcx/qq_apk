package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class CommonPlayer$CorePlayerCallback
  implements PlayerCallback
{
  private final IDataSource mDataSource;
  private final IDataSourceFactory mFactory;
  
  private CommonPlayer$CorePlayerCallback(CommonPlayer paramCommonPlayer, IDataSourceFactory paramIDataSourceFactory, IDataSource paramIDataSource)
  {
    this.mFactory = paramIDataSourceFactory;
    this.mDataSource = paramIDataSource;
  }
  
  public void playThreadStart(CorePlayer paramCorePlayer) {}
  
  public void playerEnded(CorePlayer paramCorePlayer)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerEnded() callback ended");
      this.this$0.TransferStateTo(7);
      CommonPlayer.access$100(this.this$0).onCompletion(this.this$0);
      return;
    }
    Logger.i("CommonPlayer", "different playerEnded");
  }
  
  public void playerException(CorePlayer paramCorePlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      paramCorePlayer = new StringBuilder();
      paramCorePlayer.append("playerException() callback exception what = ");
      paramCorePlayer.append(paramInt1);
      paramCorePlayer.append(",extra = ");
      paramCorePlayer.append(paramInt2);
      paramCorePlayer.append(" mAudioPlayer:");
      paramCorePlayer.append(CommonPlayer.access$000(this.this$0));
      Logger.e("CommonPlayer", paramCorePlayer.toString());
      if (CommonPlayer.access$000(this.this$0) != null)
      {
        int i = CommonPlayer.access$000(this.this$0).getPlayerState();
        paramCorePlayer = new StringBuilder();
        paramCorePlayer.append("handleMessage state = ");
        paramCorePlayer.append(i);
        Logger.e("CommonPlayer", paramCorePlayer.toString());
        paramCorePlayer = new StringBuilder();
        paramCorePlayer.append("handleMessage isInit = ");
        paramCorePlayer.append(CommonPlayer.access$000(this.this$0).isInit());
        paramCorePlayer.append(",isStartDecode = ");
        paramCorePlayer.append(CommonPlayer.access$000(this.this$0).hasDecodeData());
        paramCorePlayer.append(",decodeSuccess = ");
        paramCorePlayer.append(CommonPlayer.access$000(this.this$0).hasDecodeDataSuccess());
        Logger.e("CommonPlayer", paramCorePlayer.toString());
      }
      if ((CommonPlayer.access$200(this.this$0)) && (paramInt1 == 91))
      {
        CommonPlayer.access$202(this.this$0, false);
        paramCorePlayer = this.mFactory;
        if (paramCorePlayer != null) {
          try
          {
            this.this$0.setDataSource(paramCorePlayer);
            this.this$0.prepare();
            return;
          }
          catch (Exception paramCorePlayer)
          {
            Logger.e("CommonPlayer", "retry nativeDecoder", paramCorePlayer);
            CommonPlayer.access$300(this.this$0, paramInt1, paramInt2, paramInt3);
            return;
          }
        }
        paramCorePlayer = this.mDataSource;
        if (paramCorePlayer != null)
        {
          CommonPlayer.access$400(this.this$0, paramCorePlayer);
          this.this$0.prepare();
          return;
        }
        CommonPlayer.access$300(this.this$0, paramInt1, paramInt2, paramInt3);
        return;
      }
      CommonPlayer.access$300(this.this$0, paramInt1, paramInt2, paramInt3);
      return;
    }
    Logger.i("CommonPlayer", "different playerException");
  }
  
  public void playerPaused(CorePlayer paramCorePlayer)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerPaused() callback paused");
      return;
    }
    Logger.i("CommonPlayer", "different playerPaused");
  }
  
  public void playerPrepared(CorePlayer paramCorePlayer)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerPrepared() callback prepared");
      this.this$0.TransferStateTo(2);
      CommonPlayer.access$100(this.this$0).onPrepared(this.this$0);
      return;
    }
    Logger.i("CommonPlayer", "different playerPrepared");
  }
  
  public void playerSeekCompletion(CorePlayer paramCorePlayer, int paramInt)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerSeekCompletion() callback seek completion");
      CommonPlayer.access$100(this.this$0).onSeekComplete(this.this$0, paramInt);
      return;
    }
    Logger.i("CommonPlayer", "different playerSeekCompletion");
  }
  
  public void playerStarted(CorePlayer paramCorePlayer)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerStarted() callback started");
      CommonPlayer.access$100(this.this$0).onStarted(this.this$0);
      return;
    }
    Logger.i("CommonPlayer", "different playerStarted");
  }
  
  public void playerStopped(CorePlayer paramCorePlayer)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerStopped() callback stopped");
      return;
    }
    Logger.i("CommonPlayer", "different playerStopped");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer.CorePlayerCallback
 * JD-Core Version:    0.7.0.1
 */