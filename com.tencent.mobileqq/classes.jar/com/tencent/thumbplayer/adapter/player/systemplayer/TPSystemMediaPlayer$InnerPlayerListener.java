package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.log.TPBaseLogger;

class TPSystemMediaPlayer$InnerPlayerListener
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener
{
  private TPSystemMediaPlayer$InnerPlayerListener(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  private int heightToCgiHeight(int paramInt)
  {
    if (TPSystemMediaPlayer.access$3000(this.this$0) > 0) {
      paramInt = TPSystemMediaPlayer.access$3000(this.this$0);
    }
    return paramInt;
  }
  
  private int widthToCgiWidth(int paramInt)
  {
    if (TPSystemMediaPlayer.access$2900(this.this$0) > 0) {
      paramInt = TPSystemMediaPlayer.access$2900(this.this$0);
    }
    return paramInt;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (TPSystemMediaPlayer.access$1800(this.this$0)) {
      TPSystemMediaPlayer.access$500(this.this$0).warn("onCompletion, unknown err.");
    }
    do
    {
      return;
      TPSystemMediaPlayer.access$500(this.this$0).info("onCompletion.");
      TPSystemMediaPlayer.access$302(this.this$0, TPSystemMediaPlayer.PlayerState.COMPLETE);
      TPSystemMediaPlayer.access$600(this.this$0);
      TPSystemMediaPlayer.access$2000(this.this$0);
      paramMediaPlayer = TPSystemMediaPlayer.access$2100(this.this$0);
    } while (paramMediaPlayer == null);
    paramMediaPlayer.onCompletion();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    int j = 2000;
    if ((TPSystemMediaPlayer.access$300(this.this$0) == TPSystemMediaPlayer.PlayerState.COMPLETE) || (TPSystemMediaPlayer.access$300(this.this$0) == TPSystemMediaPlayer.PlayerState.STOPPED) || (TPSystemMediaPlayer.access$300(this.this$0) == TPSystemMediaPlayer.PlayerState.RELEASE) || (TPSystemMediaPlayer.access$300(this.this$0) == TPSystemMediaPlayer.PlayerState.IDLE) || (TPSystemMediaPlayer.access$300(this.this$0) == TPSystemMediaPlayer.PlayerState.ERROR))
    {
      TPSystemMediaPlayer.access$500(this.this$0).info("onError, illegal state:" + TPSystemMediaPlayer.access$300(this.this$0) + ", what:" + paramInt1 + ", extra:" + paramInt2);
      return true;
    }
    TPSystemMediaPlayer.access$500(this.this$0).info("onError, what: " + paramInt1 + ", extra: " + paramInt2);
    TPSystemMediaPlayer.access$700(this.this$0);
    TPSystemMediaPlayer.access$2000(this.this$0);
    TPSystemMediaPlayer.access$302(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
    int i = j;
    switch (paramInt2)
    {
    default: 
      i = j;
      switch (paramInt1)
      {
      default: 
        i = j;
      }
      break;
    }
    for (;;)
    {
      TPSystemMediaPlayer.access$600(this.this$0);
      paramMediaPlayer = TPSystemMediaPlayer.access$800(this.this$0);
      if (paramMediaPlayer == null) {
        break;
      }
      paramMediaPlayer.onError(i, TPSystemMediaPlayer.access$900(paramInt1), paramInt2, 0L);
      return true;
      i = 2001;
      continue;
      i = 2001;
    }
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    TPSystemMediaPlayer.access$500(this.this$0).info("mediaplayer, onInfo. what:" + paramInt1 + ", extra:" + paramInt2);
    switch (paramInt1)
    {
    default: 
      paramInt1 = -1;
      if (paramInt1 != -1)
      {
        if ((200 != paramInt1) && (201 != paramInt1)) {
          break label325;
        }
        if (!TPSystemMediaPlayer.access$2200(this.this$0))
        {
          if (200 != paramInt1) {
            break label306;
          }
          TPSystemMediaPlayer.access$1202(this.this$0, true);
          TPSystemMediaPlayer.access$2300(this.this$0);
          label134:
          if (TPSystemMediaPlayer.access$2400(this.this$0) != null) {
            TPSystemMediaPlayer.access$2400(this.this$0).onInfo(paramInt1, 0L, 0L, null);
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (paramInt1 == 106)
      {
        paramInt1 = widthToCgiWidth(paramMediaPlayer.getVideoWidth());
        paramInt2 = heightToCgiHeight(paramMediaPlayer.getVideoHeight());
        if (((paramInt2 != TPSystemMediaPlayer.access$2500(this.this$0)) || (paramInt1 != TPSystemMediaPlayer.access$2600(this.this$0))) && (paramInt2 > 0) && (paramInt1 > 0))
        {
          TPSystemMediaPlayer.access$2502(this.this$0, paramInt2);
          TPSystemMediaPlayer.access$2602(this.this$0, paramInt1);
          if (TPSystemMediaPlayer.access$2700(this.this$0) != null) {
            TPSystemMediaPlayer.access$2700(this.this$0).onVideoSizeChanged(TPSystemMediaPlayer.access$2600(this.this$0), TPSystemMediaPlayer.access$2500(this.this$0));
          }
        }
      }
      return true;
      paramInt1 = 200;
      break;
      paramInt1 = 201;
      break;
      paramInt1 = 106;
      break;
      TPSystemMediaPlayer.access$1602(this.this$0, true);
      paramInt1 = -1;
      break;
      label306:
      TPSystemMediaPlayer.access$1202(this.this$0, false);
      TPSystemMediaPlayer.access$1300(this.this$0);
      break label134;
      label325:
      if (TPSystemMediaPlayer.access$2400(this.this$0) != null) {
        TPSystemMediaPlayer.access$2400(this.this$0).onInfo(paramInt1, 0L, 0L, null);
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (TPSystemMediaPlayer.access$300(this.this$0) != TPSystemMediaPlayer.PlayerState.PREPARING)
    {
      TPSystemMediaPlayer.access$500(this.this$0).info("onPrepared() is called in a wrong situation, mState = " + TPSystemMediaPlayer.access$300(this.this$0));
      return;
    }
    TPSystemMediaPlayer.access$1402(this.this$0, TPSystemMediaPlayer.PlayerState.PREPARED);
    long l = TPSystemMediaPlayer.access$1500(this.this$0).getDuration();
    if (l <= 0L) {
      TPSystemMediaPlayer.access$1602(this.this$0, true);
    }
    TPSystemMediaPlayer.access$500(this.this$0).info("onPrepared() , mStartPositionMs=" + TPSystemMediaPlayer.access$1700(this.this$0) + ", duration:" + l + ", mIsLive:" + TPSystemMediaPlayer.access$1800(this.this$0));
    TPSystemMediaPlayer.access$700(this.this$0);
    TPSystemMediaPlayer.access$1900(this.this$0);
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (TPSystemMediaPlayer.access$1500(this.this$0) == null) {}
    do
    {
      return;
      TPSystemMediaPlayer.access$500(this.this$0).info("onSeekComplete().");
    } while ((TPSystemMediaPlayer.PlayerState.PREPARED == TPSystemMediaPlayer.access$300(this.this$0)) || (TPSystemMediaPlayer.access$2800(this.this$0) == null));
    TPSystemMediaPlayer.access$2800(this.this$0).onSeekComplete();
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      TPSystemMediaPlayer.access$500(this.this$0).error("onVideoSizeChanged() size error, width:" + paramInt1 + " height:" + paramInt2);
      return;
    }
    paramInt1 = widthToCgiWidth(paramInt1);
    paramInt2 = heightToCgiHeight(paramInt2);
    try
    {
      if (((paramInt1 != TPSystemMediaPlayer.access$2600(this.this$0)) || (paramInt2 != TPSystemMediaPlayer.access$2500(this.this$0))) && (paramInt2 > 0) && (paramInt1 > 0)) {
        TPSystemMediaPlayer.access$2700(this.this$0).onVideoSizeChanged(paramInt1, paramInt2);
      }
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        TPSystemMediaPlayer.access$500(this.this$0).warn(paramMediaPlayer.toString());
      }
    }
    TPSystemMediaPlayer.access$2602(this.this$0, paramInt1);
    TPSystemMediaPlayer.access$2502(this.this$0, paramInt2);
    TPSystemMediaPlayer.access$500(this.this$0).info("onVideoSizeChanged(), width:" + paramInt1 + " height:" + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.InnerPlayerListener
 * JD-Core Version:    0.7.0.1
 */