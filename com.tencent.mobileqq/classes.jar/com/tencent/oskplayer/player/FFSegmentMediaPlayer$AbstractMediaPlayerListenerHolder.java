package com.tencent.oskplayer.player;

import com.tencent.oskplayer.util.PlayerUtils;
import java.lang.ref.WeakReference;
import tv.danmaku.ijk.media.player.AbstractMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.InternalOperationException;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener;

class FFSegmentMediaPlayer$AbstractMediaPlayerListenerHolder
  implements IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPreparedListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnVideoSizeChangedListener
{
  public final WeakReference<AbstractMediaPlayer> mWeakMediaPlayer;
  
  public FFSegmentMediaPlayer$AbstractMediaPlayerListenerHolder(FFSegmentMediaPlayer paramFFSegmentMediaPlayer, AbstractMediaPlayer paramAbstractMediaPlayer)
  {
    this.mWeakMediaPlayer = new WeakReference(paramAbstractMediaPlayer);
  }
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    if ((AbstractMediaPlayer)this.mWeakMediaPlayer.get() == null) {
      return;
    }
    PlayerUtils.log(3, "FFSegmentMediaPlayer", "onBufferingUpdate");
    FFSegmentMediaPlayer.access$000(this.this$0, paramInt);
  }
  
  public void onCompletion(IMediaPlayer paramIMediaPlayer)
  {
    paramIMediaPlayer = (AbstractMediaPlayer)this.mWeakMediaPlayer.get();
    if (paramIMediaPlayer == null) {
      return;
    }
    if (FFSegmentMediaPlayer.access$100(this.this$0))
    {
      PlayerUtils.log(4, "FFSegmentMediaPlayer", "looping play start");
      FFSegmentMediaPlayer.access$202(this.this$0, true);
      FFSegmentMediaPlayer.access$302(this.this$0, true);
      paramIMediaPlayer.seekTo(0L);
      try
      {
        paramIMediaPlayer.start();
        if (FFSegmentMediaPlayer.access$400(this.this$0) == null) {
          return;
        }
        FFSegmentMediaPlayer.access$500(this.this$0).onLoopStart(this.this$0);
        return;
      }
      catch (IMediaPlayer.InternalOperationException paramIMediaPlayer)
      {
        PlayerUtils.log(6, "FFSegmentMediaPlayer", paramIMediaPlayer.toString());
        return;
      }
    }
    else
    {
      PlayerUtils.log(4, "FFSegmentMediaPlayer", "onCompletion");
      FFSegmentMediaPlayer.access$600(this.this$0);
    }
  }
  
  public boolean onError(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    paramIMediaPlayer = (AbstractMediaPlayer)this.mWeakMediaPlayer.get();
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "onError");
    FFSegmentMediaPlayer.access$702(this.this$0, -1);
    FFSegmentMediaPlayer.access$802(this.this$0, -1);
    return (paramIMediaPlayer != null) && (FFSegmentMediaPlayer.access$900(this.this$0, paramInt1, paramInt2));
  }
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((AbstractMediaPlayer)this.mWeakMediaPlayer.get() == null) {
      return false;
    }
    paramIMediaPlayer = new StringBuilder();
    paramIMediaPlayer.append("onInfo what=");
    paramIMediaPlayer.append(paramInt1);
    paramIMediaPlayer.append(",extra=");
    paramIMediaPlayer.append(paramInt2);
    PlayerUtils.log(3, "FFSegmentMediaPlayer", paramIMediaPlayer.toString());
    if ((FFSegmentMediaPlayer.access$200(this.this$0)) && (paramInt1 == 701)) {
      return false;
    }
    if ((FFSegmentMediaPlayer.access$200(this.this$0)) && (paramInt1 == 702))
    {
      FFSegmentMediaPlayer.access$202(this.this$0, false);
      return false;
    }
    return FFSegmentMediaPlayer.access$1000(this.this$0, paramInt1, paramInt2);
  }
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    if ((AbstractMediaPlayer)this.mWeakMediaPlayer.get() == null) {
      return;
    }
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "onPrepared");
    FFSegmentMediaPlayer.access$702(this.this$0, 2);
    if (FFSegmentMediaPlayer.access$800(this.this$0) == 3) {
      this.this$0.start();
    }
    FFSegmentMediaPlayer.access$1100(this.this$0);
  }
  
  public void onSeekComplete(IMediaPlayer paramIMediaPlayer)
  {
    if ((AbstractMediaPlayer)this.mWeakMediaPlayer.get() == null) {
      return;
    }
    if (!FFSegmentMediaPlayer.access$300(this.this$0))
    {
      this.this$0.notifyOnSeekComplete();
      return;
    }
    FFSegmentMediaPlayer.access$302(this.this$0, false);
  }
  
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((AbstractMediaPlayer)this.mWeakMediaPlayer.get() == null) {
      return;
    }
    PlayerUtils.log(4, "FFSegmentMediaPlayer", "onVideoSizeChanged");
    FFSegmentMediaPlayer.access$1200(this.this$0, paramInt1, paramInt2, 1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.player.FFSegmentMediaPlayer.AbstractMediaPlayerListenerHolder
 * JD-Core Version:    0.7.0.1
 */