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
    if (TPSystemMediaPlayer.access$3200(this.this$0) > 0) {
      paramInt = TPSystemMediaPlayer.access$3200(this.this$0);
    }
    return paramInt;
  }
  
  private int widthToCgiWidth(int paramInt)
  {
    if (TPSystemMediaPlayer.access$3100(this.this$0) > 0) {
      paramInt = TPSystemMediaPlayer.access$3100(this.this$0);
    }
    return paramInt;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (TPSystemMediaPlayer.access$2100(this.this$0))
    {
      TPSystemMediaPlayer.access$900(this.this$0).warn("onCompletion, unknown err.");
      return;
    }
    TPSystemMediaPlayer.access$900(this.this$0).info("onCompletion.");
    TPSystemMediaPlayer.access$402(this.this$0, TPSystemMediaPlayer.PlayerState.COMPLETE);
    TPSystemMediaPlayer.access$1000(this.this$0);
    TPSystemMediaPlayer.access$2300(this.this$0);
    paramMediaPlayer = TPSystemMediaPlayer.access$2400(this.this$0);
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onCompletion();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((TPSystemMediaPlayer.access$400(this.this$0) != TPSystemMediaPlayer.PlayerState.COMPLETE) && (TPSystemMediaPlayer.access$400(this.this$0) != TPSystemMediaPlayer.PlayerState.STOPPED) && (TPSystemMediaPlayer.access$400(this.this$0) != TPSystemMediaPlayer.PlayerState.RELEASE) && (TPSystemMediaPlayer.access$400(this.this$0) != TPSystemMediaPlayer.PlayerState.IDLE) && (TPSystemMediaPlayer.access$400(this.this$0) != TPSystemMediaPlayer.PlayerState.ERROR))
    {
      paramMediaPlayer = TPSystemMediaPlayer.access$900(this.this$0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError, what: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", extra: ");
      localStringBuilder.append(paramInt2);
      paramMediaPlayer.info(localStringBuilder.toString());
      TPSystemMediaPlayer.access$1100(this.this$0);
      TPSystemMediaPlayer.access$2300(this.this$0);
      TPSystemMediaPlayer.access$402(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
      if ((paramInt2 != -1010) && (paramInt2 != -1007)) {
        if (paramInt2 != -110)
        {
          switch (paramInt2)
          {
          default: 
            if ((paramInt1 == 1) || (paramInt1 != 100)) {
              break;
            }
          }
        }
        else
        {
          i = 2001;
          break label223;
        }
      }
      int i = 2000;
      label223:
      TPSystemMediaPlayer.access$1000(this.this$0);
      paramMediaPlayer = TPSystemMediaPlayer.access$1200(this.this$0);
      if (paramMediaPlayer != null) {
        paramMediaPlayer.onError(i, TPSystemMediaPlayer.access$700(paramInt1), paramInt2, 0L);
      }
      return true;
    }
    paramMediaPlayer = TPSystemMediaPlayer.access$900(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError, illegal state:");
    localStringBuilder.append(TPSystemMediaPlayer.access$400(this.this$0));
    localStringBuilder.append(", what:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", extra:");
    localStringBuilder.append(paramInt2);
    paramMediaPlayer.info(localStringBuilder.toString());
    return true;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    TPBaseLogger localTPBaseLogger = TPSystemMediaPlayer.access$900(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mediaplayer, onInfo. what:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", extra:");
    localStringBuilder.append(paramInt2);
    localTPBaseLogger.info(localStringBuilder.toString());
    if (paramInt1 != 3)
    {
      if (paramInt1 != 801) {
        if (paramInt1 != 701) {
          if (paramInt1 == 702) {}
        }
      }
      for (;;)
      {
        paramInt1 = -1;
        break;
        paramInt1 = 201;
        break;
        paramInt1 = 200;
        break;
        TPSystemMediaPlayer.access$1902(this.this$0, true);
      }
    }
    paramInt1 = 106;
    if (paramInt1 != -1) {
      if ((200 != paramInt1) && (201 != paramInt1))
      {
        if (TPSystemMediaPlayer.access$600(this.this$0) != null) {
          TPSystemMediaPlayer.access$600(this.this$0).onInfo(paramInt1, 0L, 0L, null);
        }
      }
      else if (!TPSystemMediaPlayer.access$2500(this.this$0))
      {
        if (200 == paramInt1)
        {
          TPSystemMediaPlayer.access$1502(this.this$0, true);
          TPSystemMediaPlayer.access$2600(this.this$0);
        }
        else
        {
          TPSystemMediaPlayer.access$1502(this.this$0, false);
          TPSystemMediaPlayer.access$1600(this.this$0);
        }
        if (TPSystemMediaPlayer.access$600(this.this$0) != null) {
          TPSystemMediaPlayer.access$600(this.this$0).onInfo(paramInt1, 0L, 0L, null);
        }
      }
    }
    if (paramInt1 == 106)
    {
      paramInt1 = widthToCgiWidth(paramMediaPlayer.getVideoWidth());
      paramInt2 = heightToCgiHeight(paramMediaPlayer.getVideoHeight());
      if (((paramInt2 != TPSystemMediaPlayer.access$2700(this.this$0)) || (paramInt1 != TPSystemMediaPlayer.access$2800(this.this$0))) && (paramInt2 > 0) && (paramInt1 > 0))
      {
        TPSystemMediaPlayer.access$2702(this.this$0, paramInt2);
        TPSystemMediaPlayer.access$2802(this.this$0, paramInt1);
        if (TPSystemMediaPlayer.access$2900(this.this$0) != null) {
          TPSystemMediaPlayer.access$2900(this.this$0).onVideoSizeChanged(TPSystemMediaPlayer.access$2800(this.this$0), TPSystemMediaPlayer.access$2700(this.this$0));
        }
      }
    }
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (TPSystemMediaPlayer.access$400(this.this$0) != TPSystemMediaPlayer.PlayerState.PREPARING)
    {
      paramMediaPlayer = TPSystemMediaPlayer.access$900(this.this$0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPrepared() is called in a wrong situation, mState = ");
      localStringBuilder.append(TPSystemMediaPlayer.access$400(this.this$0));
      paramMediaPlayer.info(localStringBuilder.toString());
      return;
    }
    TPSystemMediaPlayer.access$1702(this.this$0, TPSystemMediaPlayer.PlayerState.PREPARED);
    long l = TPSystemMediaPlayer.access$1800(this.this$0).getDuration();
    if (l <= 0L) {
      TPSystemMediaPlayer.access$1902(this.this$0, true);
    }
    paramMediaPlayer = TPSystemMediaPlayer.access$900(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPrepared() , mStartPositionMs=");
    localStringBuilder.append(TPSystemMediaPlayer.access$2000(this.this$0));
    localStringBuilder.append(", duration:");
    localStringBuilder.append(l);
    localStringBuilder.append(", mIsLive:");
    localStringBuilder.append(TPSystemMediaPlayer.access$2100(this.this$0));
    paramMediaPlayer.info(localStringBuilder.toString());
    TPSystemMediaPlayer.access$1100(this.this$0);
    TPSystemMediaPlayer.access$2200(this.this$0);
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (TPSystemMediaPlayer.access$1800(this.this$0) == null) {
      return;
    }
    TPSystemMediaPlayer.access$900(this.this$0).info("onSeekComplete().");
    if ((TPSystemMediaPlayer.PlayerState.PREPARED != TPSystemMediaPlayer.access$400(this.this$0)) && (TPSystemMediaPlayer.access$3000(this.this$0) != null)) {
      TPSystemMediaPlayer.access$3000(this.this$0).onSeekComplete();
    }
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      paramInt1 = widthToCgiWidth(paramInt1);
      paramInt2 = heightToCgiHeight(paramInt2);
      try
      {
        if (((paramInt1 != TPSystemMediaPlayer.access$2800(this.this$0)) || (paramInt2 != TPSystemMediaPlayer.access$2700(this.this$0))) && (paramInt2 > 0) && (paramInt1 > 0)) {
          TPSystemMediaPlayer.access$2900(this.this$0).onVideoSizeChanged(paramInt1, paramInt2);
        }
      }
      catch (Exception paramMediaPlayer)
      {
        TPSystemMediaPlayer.access$900(this.this$0).warn(paramMediaPlayer.toString());
      }
      TPSystemMediaPlayer.access$2802(this.this$0, paramInt1);
      TPSystemMediaPlayer.access$2702(this.this$0, paramInt2);
      paramMediaPlayer = TPSystemMediaPlayer.access$900(this.this$0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoSizeChanged(), width:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" height:");
      localStringBuilder.append(paramInt2);
      paramMediaPlayer.info(localStringBuilder.toString());
      return;
    }
    paramMediaPlayer = TPSystemMediaPlayer.access$900(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoSizeChanged() size error, width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" height:");
    localStringBuilder.append(paramInt2);
    paramMediaPlayer.error(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.InnerPlayerListener
 * JD-Core Version:    0.7.0.1
 */