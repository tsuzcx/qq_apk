package com.tencent.tav.player;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.RenderContextParams;

public class Player
  implements Handler.Callback, IPlayer
{
  private static final int DEFAULT_MAX_CACHE_SIZE = 60;
  public static final String TAG = "PlayerThreadMain";
  public static final int TYPE_PROGRESS = 2;
  public static final int TYPE_STATES = 1;
  public static final int TYPE_VIEWPORT_UPDATE = 3;
  public static String time = "time";
  private Player.AVPlayerActionAtItemEnd actionAtItemEnd;
  private Asset asset;
  private int bgColor = -16777216;
  private PlayerItem currentItem;
  private ErrorMsg errMsg;
  private boolean ignorePreparePosition = false;
  private boolean loop = false;
  private AudioFocusHelper mAudioFocuser;
  private boolean mHasPostedSeek;
  private CMTime mLastSeekTargetTimeUs;
  Handler mMainHandler;
  private CMTimeRange mPlayRange;
  private PlayerThread mPlayThread;
  private IPlayer.PlayerListener mPlayerListener;
  private IPlayer.PlayerStatus mPlayerStatus = IPlayer.PlayerStatus.IDLE;
  private CMTime mPosition;
  private CMTime mSeekTargetTimeUs;
  private boolean muted;
  private OnCompositionUpdateListener onCompositionUpdateListener;
  private PlayerLayer playerLayer;
  private float rate;
  private volatile boolean released = false;
  private Player.PlayerStatus status;
  @Nullable
  private OnViewportUpdateListener viewportUpdateListener;
  private float volume;
  
  public Player(PlayerItem paramPlayerItem)
  {
    this.currentItem = paramPlayerItem;
    this.mMainHandler = new Handler(Looper.getMainLooper(), this);
    this.asset = this.currentItem.getAsset();
    this.currentItem.start(this);
    this.mPlayThread = this.currentItem.getPlayerThreadMain();
  }
  
  public Player(String paramString)
  {
    this(new PlayerItem(paramString));
  }
  
  private void checkAndReady()
  {
    try
    {
      if (this.mPlayerStatus == IPlayer.PlayerStatus.IDLE) {
        this.mPlayThread.sendMessage(1, "main");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void bindLayer(PlayerLayer paramPlayerLayer)
  {
    this.playerLayer = paramPlayerLayer;
    this.currentItem.bindLayer(paramPlayerLayer);
  }
  
  public IPlayer.PlayerStatus currentStatus()
  {
    try
    {
      IPlayer.PlayerStatus localPlayerStatus = this.mPlayerStatus;
      return localPlayerStatus;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMTime currentTime()
  {
    PlayerThread localPlayerThread = this.mPlayThread;
    if (localPlayerThread == null) {
      return CMTime.CMTimeZero;
    }
    return localPlayerThread.getPosition();
  }
  
  public CMTime duration()
  {
    try
    {
      CMTime localCMTime;
      if (this.asset == null) {
        localCMTime = CMTime.CMTimeZero;
      } else {
        localCMTime = this.asset.getDuration();
      }
      return localCMTime;
    }
    finally {}
  }
  
  public void enAbleAudioFocus(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mAudioFocuser == null) {
        this.mAudioFocuser = new AudioFocusHelper(paramContext, this);
      }
    }
    else
    {
      paramContext = this.mAudioFocuser;
      if (paramContext != null) {
        paramContext.release();
      }
    }
  }
  
  public int getBgColor()
  {
    return this.bgColor;
  }
  
  public PlayerItem getCurrentItem()
  {
    return this.currentItem;
  }
  
  public ErrorMsg getErrMsg()
  {
    return this.errMsg;
  }
  
  @Nullable
  public CGRect getGlViewport()
  {
    PlayerThread localPlayerThread = this.mPlayThread;
    if (localPlayerThread == null) {
      return null;
    }
    return localPlayerThread.getGlViewportRect();
  }
  
  public float getRate()
  {
    return this.rate;
  }
  
  @Nullable
  public RenderContextParams getRenderContextParams()
  {
    PlayerThread localPlayerThread = this.mPlayThread;
    if (localPlayerThread != null) {
      return localPlayerThread.getRenderContextParams();
    }
    return null;
  }
  
  public Player.PlayerStatus getStatus()
  {
    return this.status;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.released) {
      return false;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return false;
        }
        if ((this.viewportUpdateListener != null) && ((paramMessage.obj instanceof CGRect)))
        {
          paramMessage = (CGRect)paramMessage.obj;
          this.viewportUpdateListener.onViewportUpdate(paramMessage.clone());
          return true;
        }
      }
      else
      {
        this.mPosition = ((CMTime)paramMessage.obj);
        if ((this.mPlayerListener != null) && (!this.mMainHandler.hasMessages(2))) {
          this.mPlayerListener.onPositionChanged(this.mPosition);
        }
        paramMessage = this.mPlayRange;
        if ((paramMessage != null) && (!this.mPosition.smallThan(paramMessage.getEnd())) && (isPlaying()))
        {
          if (this.loop)
          {
            paramMessage = this.mPlayerListener;
            if (paramMessage != null) {
              paramMessage.onStatusChanged(IPlayer.PlayerStatus.REPLAY);
            }
            seekToTime(this.mPlayRange.getStart());
            return true;
          }
          pause();
          return true;
        }
      }
    }
    else
    {
      Object localObject = this.mPlayerStatus;
      paramMessage = (PlayerStatusMsg)paramMessage.obj;
      this.mPlayerStatus = paramMessage.getPlayerStatus();
      if ((localObject == IPlayer.PlayerStatus.PLAYING) && ((this.mPlayerStatus == IPlayer.PlayerStatus.FINISHED) || (this.mPlayerStatus == IPlayer.PlayerStatus.ERROR)) && (this.loop)) {
        try
        {
          if ((!this.mPlayThread.hasMessage(3)) && (!this.mPlayThread.hasMessage(6)) && (!this.mPlayThread.hasMessage(4)) && (!this.mPlayThread.hasMessage(11)) && (!this.mMainHandler.hasMessages(1)))
          {
            if ((this.mPlayRange != null) && (this.mPlayRange.getDuration().getValue() > 0L)) {
              seekToTime(this.mPlayRange.getStart());
            } else {
              seekToTime(CMTime.CMTimeZero);
            }
            if (this.mPlayerListener != null) {
              this.mPlayerListener.onStatusChanged(IPlayer.PlayerStatus.REPLAY);
            }
            play();
            return true;
          }
          return true;
        }
        finally {}
      }
      localObject = this.mPlayerListener;
      if (localObject != null) {
        ((IPlayer.PlayerListener)localObject).onStatusChanged(this.mPlayerStatus);
      }
      if (this.mPlayerStatus == IPlayer.PlayerStatus.ERROR) {
        this.errMsg = new ErrorMsg(-1, paramMessage.getErrorMsg());
      }
    }
    return true;
  }
  
  public boolean isIgnorePreparePosition()
  {
    return this.ignorePreparePosition;
  }
  
  public boolean isPlaying()
  {
    try
    {
      IPlayer.PlayerStatus localPlayerStatus1 = this.mPlayerStatus;
      IPlayer.PlayerStatus localPlayerStatus2 = IPlayer.PlayerStatus.PLAYING;
      boolean bool;
      if (localPlayerStatus1 == localPlayerStatus2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isReleased()
  {
    try
    {
      boolean bool = this.released;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void pause()
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      this.mPlayThread.sendMessage(3, "main");
      return;
    }
    finally {}
  }
  
  public void play()
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      if ((this.mPlayRange != null) && (!this.mPlayRange.containsTime(currentTime()))) {
        seekToTime(this.mPlayRange.getStart());
      }
      this.mPlayThread.sendMessage(2, "main");
      if (this.mAudioFocuser != null) {
        this.mAudioFocuser.requestFocus();
      }
      return;
    }
    finally {}
  }
  
  public CMTime position()
  {
    try
    {
      CMTime localCMTime;
      if (this.mPlayThread == null) {
        localCMTime = CMTime.CMTimeZero;
      } else {
        localCMTime = this.mPlayThread.getPosition();
      }
      return localCMTime;
    }
    finally {}
  }
  
  public boolean post(Runnable paramRunnable)
  {
    if (this.released) {
      return false;
    }
    return this.mPlayThread.post(paramRunnable);
  }
  
  public void prepare(PlayerPrepareListener paramPlayerPrepareListener)
  {
    paramPlayerPrepareListener = this.mPlayerStatus;
    paramPlayerPrepareListener = IPlayer.PlayerStatus.IDLE;
  }
  
  public void readSnapShootBitmap(OnReadSnapShootListener paramOnReadSnapShootListener)
  {
    PlayerThread localPlayerThread = this.mPlayThread;
    if (localPlayerThread == null) {
      return;
    }
    localPlayerThread.sendMessage(24, paramOnReadSnapShootListener, "readSnapShootBitmap");
  }
  
  public boolean refresh()
  {
    if (this.released) {
      return false;
    }
    return this.mPlayThread.refresh();
  }
  
  public void release()
  {
    try
    {
      release(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void release(Runnable paramRunnable)
  {
    try
    {
      if (!this.released)
      {
        this.released = true;
        this.mMainHandler.removeCallbacksAndMessages(null);
        this.mMainHandler = null;
        this.mPlayThread.sendMessage(4, "main");
        this.mPlayThread.sendMessage(6, paramRunnable, "main");
        this.mPlayThread = null;
        if (this.mAudioFocuser != null) {
          this.mAudioFocuser.release();
        }
        if (this.currentItem != null) {
          this.currentItem.release();
        }
        this.currentItem = null;
      }
      return;
    }
    finally {}
  }
  
  public void replaceCurrentItemWithPlayerItem(PlayerItem paramPlayerItem)
  {
    update(paramPlayerItem, position());
  }
  
  public void seekToTime(CMTime paramCMTime)
  {
    seekToTime(paramCMTime, null);
  }
  
  public void seekToTime(CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3)
  {
    seekToTime(paramCMTime1, paramCMTime2, paramCMTime3, null);
  }
  
  public void seekToTime(CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3, Callback paramCallback)
  {
    if (this.released) {
      return;
    }
    this.mSeekTargetTimeUs = paramCMTime1;
    paramCMTime1 = this.mSeekTargetTimeUs;
    this.mLastSeekTargetTimeUs = paramCMTime1;
    this.mPlayThread.updatePositionRightAway(paramCMTime1);
    this.mPlayThread.sendMessage(5, this.mSeekTargetTimeUs, paramCallback, "main");
  }
  
  public void seekToTime(CMTime paramCMTime, Callback paramCallback)
  {
    seekToTime(paramCMTime, CMTime.CMTimeZero, CMTime.CMTimeZero, paramCallback);
  }
  
  public void setAudioRevertMode(boolean paramBoolean)
  {
    if ((this.mPlayerStatus != IPlayer.PlayerStatus.PLAYING) && (this.mPlayerStatus != IPlayer.PlayerStatus.PAUSED))
    {
      PlayerItem localPlayerItem = this.currentItem;
      if (localPlayerItem != null) {
        localPlayerItem.setAudioRevertMode(paramBoolean);
      }
    }
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
  }
  
  public void setGetTavExtraListener(OnGetTavExtraListener paramOnGetTavExtraListener)
  {
    PlayerThread localPlayerThread = this.mPlayThread;
    if (localPlayerThread != null) {
      localPlayerThread.sendMessage(25, paramOnGetTavExtraListener, "setGetTavExtraListener");
    }
  }
  
  public void setIgnorePreparePosition(boolean paramBoolean)
  {
    this.ignorePreparePosition = paramBoolean;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    try
    {
      this.loop = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setOnCompositionUpdateListener(OnCompositionUpdateListener paramOnCompositionUpdateListener)
  {
    this.onCompositionUpdateListener = paramOnCompositionUpdateListener;
  }
  
  public void setPlayRange(CMTimeRange paramCMTimeRange)
  {
    try
    {
      this.mPlayRange = paramCMTimeRange;
      if ((paramCMTimeRange != null) && (!paramCMTimeRange.containsTime(currentTime())) && (isPlaying())) {
        seekToTime(paramCMTimeRange.getStart());
      }
      return;
    }
    finally {}
  }
  
  public void setPlayerListener(IPlayer.PlayerListener paramPlayerListener)
  {
    this.mPlayerListener = paramPlayerListener;
  }
  
  public void setRate(float paramFloat)
  {
    setRate(paramFloat, 60);
  }
  
  public void setRate(float paramFloat, int paramInt)
  {
    if ((this.mPlayerStatus != IPlayer.PlayerStatus.PLAYING) && (this.mPlayerStatus != IPlayer.PlayerStatus.PAUSED))
    {
      this.rate = paramFloat;
      this.currentItem.setRate(paramFloat, paramInt);
    }
  }
  
  public void setRateAtTimeAndHostTime(float paramFloat, CMTime paramCMTime1, CMTime paramCMTime2) {}
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    PlayerThread localPlayerThread = this.mPlayThread;
    if (localPlayerThread != null) {
      localPlayerThread.setRenderContextParams(paramRenderContextParams);
    }
  }
  
  public void setVideoRevertMode(boolean paramBoolean)
  {
    if ((this.mPlayerStatus != IPlayer.PlayerStatus.PLAYING) && (this.mPlayerStatus != IPlayer.PlayerStatus.PAUSED))
    {
      PlayerItem localPlayerItem = this.currentItem;
      if (localPlayerItem != null) {
        localPlayerItem.setVideoRevertMode(paramBoolean);
      }
    }
  }
  
  public void setViewportUpdateListener(OnViewportUpdateListener paramOnViewportUpdateListener)
  {
    this.viewportUpdateListener = paramOnViewportUpdateListener;
  }
  
  public void setVolume(float paramFloat)
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      this.mPlayThread.sendMessage(7, Float.valueOf(paramFloat), "main");
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      this.mPlayThread.sendMessage(4, Boolean.valueOf(true), "main");
      return;
    }
    finally {}
  }
  
  public void update(@NonNull PlayerItem paramPlayerItem, CMTime paramCMTime)
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      this.currentItem = paramPlayerItem;
      this.asset = paramPlayerItem.getAsset();
      this.currentItem.updateDecoderTrack();
      this.mPlayThread.updatePositionRightAway(paramCMTime);
      this.mPlayThread.sendMessage(11, new UpdateCompositionMessage(paramPlayerItem, this.onCompositionUpdateListener), "update clips");
      this.mLastSeekTargetTimeUs = CMTime.CMTimeZero;
      return;
    }
    finally {}
  }
  
  public void update(@NonNull PlayerItem paramPlayerItem, CMTime paramCMTime, OnCompositionUpdateListener paramOnCompositionUpdateListener)
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      this.currentItem = paramPlayerItem;
      this.asset = paramPlayerItem.getAsset();
      this.currentItem.updateDecoderTrack();
      this.mPlayThread.updatePositionRightAway(paramCMTime);
      this.mPlayThread.sendMessage(11, new UpdateCompositionMessage(paramPlayerItem, new Player.1(this, paramOnCompositionUpdateListener)), "update clips");
      this.mLastSeekTargetTimeUs = CMTime.CMTimeZero;
      return;
    }
    finally {}
  }
  
  public void updateAllProperties()
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      this.mPlayThread.sendMessage(20, "main");
      return;
    }
    finally {}
  }
  
  public void updateAudioClipsProperties()
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      this.mPlayThread.sendMessage(22, "main");
      return;
    }
    finally {}
  }
  
  public void updateAudioVolumeProperties()
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      this.mPlayThread.sendMessage(23, "main");
      return;
    }
    finally {}
  }
  
  public void updateProperties()
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      this.mPlayThread.sendMessage(10, "main");
      return;
    }
    finally {}
  }
  
  public void updateViewport(int paramInt1, int paramInt2)
  {
    if (this.released) {
      return;
    }
    this.mPlayThread.sendMessage(21, new CGSize(paramInt1, paramInt2), "main");
  }
  
  public int videoHeight()
  {
    PlayerItem localPlayerItem = this.currentItem;
    if (localPlayerItem == null) {
      return 0;
    }
    return (int)localPlayerItem.getPresentationSize().height;
  }
  
  public int videoWidth()
  {
    PlayerItem localPlayerItem = this.currentItem;
    if (localPlayerItem == null) {
      return 0;
    }
    return (int)localPlayerItem.getPresentationSize().width;
  }
  
  public void waitForRelease(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.Player
 * JD-Core Version:    0.7.0.1
 */