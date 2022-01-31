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
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPSystemMediaPlayer$InnerPlayerListener
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener
{
  private TPSystemMediaPlayer$InnerPlayerListener(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    TPSystemMediaPlayer.access$2602(this.this$0, paramInt);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onCompletion, : ");
    TPSystemMediaPlayer.access$202(this.this$0, TPSystemMediaPlayer.PlayerState.COMPLETE);
    TPSystemMediaPlayer.access$1700(this.this$0);
    if (TPSystemMediaPlayer.access$1800(this.this$0) != null) {
      TPSystemMediaPlayer.access$1800(this.this$0).onCompletion();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    int j = 2000;
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onError, : " + paramInt1 + ", extra: " + paramInt2);
    TPSystemMediaPlayer.access$600(this.this$0);
    TPSystemMediaPlayer.access$1700(this.this$0);
    TPSystemMediaPlayer.access$202(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
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
      if (TPSystemMediaPlayer.access$700(this.this$0) != null) {
        TPSystemMediaPlayer.access$700(this.this$0).onError(i, TPSystemMediaPlayer.access$800(this.this$0, paramInt1), paramInt2, 0L);
      }
      return true;
      i = 2001;
      continue;
      i = 2001;
    }
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      paramInt1 = -1;
      if (paramInt1 != -1)
      {
        if ((200 != paramInt1) && (201 != paramInt1)) {
          break label270;
        }
        if (!TPSystemMediaPlayer.access$1900(this.this$0))
        {
          if (200 != paramInt1) {
            break label253;
          }
          TPSystemMediaPlayer.access$2000(this.this$0);
          label89:
          if (TPSystemMediaPlayer.access$1400(this.this$0) != null) {
            TPSystemMediaPlayer.access$1400(this.this$0).onInfo(paramInt1, 0L, 0L, null);
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (paramInt1 == 106)
      {
        paramInt1 = paramMediaPlayer.getVideoWidth();
        paramInt2 = paramMediaPlayer.getVideoHeight();
        if (((paramInt2 != TPSystemMediaPlayer.access$2100(this.this$0)) || (paramInt1 != TPSystemMediaPlayer.access$2200(this.this$0))) && (paramInt2 > 0) && (paramInt1 > 0))
        {
          TPSystemMediaPlayer.access$2102(this.this$0, paramInt2);
          TPSystemMediaPlayer.access$2202(this.this$0, paramInt1);
          if (TPSystemMediaPlayer.access$2300(this.this$0) != null) {
            TPSystemMediaPlayer.access$2300(this.this$0).onVideoSizeChanged(TPSystemMediaPlayer.access$2200(this.this$0), TPSystemMediaPlayer.access$2100(this.this$0));
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
      TPSystemMediaPlayer.access$1202(this.this$0, true);
      paramInt1 = -1;
      break;
      label253:
      if (201 != paramInt1) {
        break label89;
      }
      TPSystemMediaPlayer.access$1100(this.this$0);
      break label89;
      label270:
      if (TPSystemMediaPlayer.access$1400(this.this$0) != null) {
        TPSystemMediaPlayer.access$1400(this.this$0).onInfo(paramInt1, 0L, 0L, null);
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (TPSystemMediaPlayer.access$200(this.this$0) != TPSystemMediaPlayer.PlayerState.PREPARING) {
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared() is called in a wrong situation, mState = " + TPSystemMediaPlayer.access$200(this.this$0));
    }
    do
    {
      return;
      TPSystemMediaPlayer.access$202(this.this$0, TPSystemMediaPlayer.PlayerState.PREPARED);
      TPSystemMediaPlayer.access$600(this.this$0);
      TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared() , mStartPositionMs=" + TPSystemMediaPlayer.access$400(this.this$0));
      if ((TPSystemMediaPlayer.access$400(this.this$0) > 0) && (!TPSystemMediaPlayer.access$1200(this.this$0))) {
        TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onPrepared(), and seekto:" + TPSystemMediaPlayer.access$400(this.this$0));
      }
      try
      {
        paramMediaPlayer.seekTo(TPSystemMediaPlayer.access$400(this.this$0));
        TPSystemMediaPlayer.access$302(this.this$0, true);
        if (TPSystemMediaPlayer.access$1300(this.this$0))
        {
          this.this$0.start();
          if (TPSystemMediaPlayer.access$1400(this.this$0) != null) {
            TPSystemMediaPlayer.access$1400(this.this$0).onInfo(3, TPSystemMediaPlayer.access$1500(this.this$0), 0L, null);
          }
          TPSystemMediaPlayer.access$1302(this.this$0, false);
          return;
        }
      }
      catch (Exception paramMediaPlayer)
      {
        for (;;)
        {
          TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", paramMediaPlayer);
        }
      }
    } while (TPSystemMediaPlayer.access$1600(this.this$0) == null);
    TPSystemMediaPlayer.access$1600(this.this$0).onPrepared();
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (TPSystemMediaPlayer.access$500(this.this$0) == null) {
      return;
    }
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onSeekComplete(), and position:" + TPSystemMediaPlayer.access$2400(this.this$0));
    if ((TPSystemMediaPlayer.PlayerState.PAUSED == TPSystemMediaPlayer.access$200(this.this$0)) && (paramMediaPlayer != null)) {}
    try
    {
      paramMediaPlayer.pause();
      if ((!TPSystemMediaPlayer.access$300(this.this$0)) && (TPSystemMediaPlayer.PlayerState.PREPARED != TPSystemMediaPlayer.access$200(this.this$0)) && (TPSystemMediaPlayer.access$2500(this.this$0) != null)) {
        TPSystemMediaPlayer.access$2500(this.this$0).onSeekComplete();
      }
      TPSystemMediaPlayer.access$302(this.this$0, false);
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", paramMediaPlayer);
      }
    }
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "onVideoSizeChanged() size error, width:" + paramInt1 + " height:" + paramInt2);
      return;
    }
    try
    {
      if ((paramInt1 != TPSystemMediaPlayer.access$2200(this.this$0)) || (paramInt2 != TPSystemMediaPlayer.access$2100(this.this$0))) {
        TPSystemMediaPlayer.access$2300(this.this$0).onVideoSizeChanged(paramInt1, paramInt2);
      }
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        TPLogUtil.w("TPThumbPlayer[TPSystemMediaPlayer.java]", paramMediaPlayer.toString());
      }
    }
    TPSystemMediaPlayer.access$2202(this.this$0, paramInt1);
    TPSystemMediaPlayer.access$2102(this.this$0, paramInt2);
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "onVideoSizeChanged(), width:" + paramInt1 + " height:" + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.InnerPlayerListener
 * JD-Core Version:    0.7.0.1
 */