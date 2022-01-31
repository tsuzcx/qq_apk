package com.tencent.tav.player;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
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
  public static String time = "time";
  private Player.AVPlayerActionAtItemEnd actionAtItemEnd;
  private Asset asset;
  private int bgColor = -16777216;
  private PlayerItem currentItem;
  private ErrorMsg errMsg;
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
    if (this.mPlayThread == null) {
      return CMTime.CMTimeZero;
    }
    return this.mPlayThread.getPosition();
  }
  
  /* Error */
  public CMTime duration()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 106	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   6: ifnonnull +11 -> 17
    //   9: getstatic 149	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 106	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   21: invokevirtual 158	com/tencent/tav/asset/Asset:getDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   24: astore_1
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	Player
    //   12	13	1	localCMTime	CMTime
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
    //   17	25	28	finally
  }
  
  public void enAbleAudioFocus(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mAudioFocuser == null) {
        this.mAudioFocuser = new AudioFocusHelper(paramContext, this);
      }
    }
    while (this.mAudioFocuser == null) {
      return;
    }
    this.mAudioFocuser.release();
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
    if (this.mPlayThread == null) {
      return null;
    }
    return this.mPlayThread.getGlViewportRect();
  }
  
  public float getRate()
  {
    return this.rate;
  }
  
  @Nullable
  public RenderContextParams getRenderContextParams()
  {
    if (this.mPlayThread != null) {
      return this.mPlayThread.getRenderContextParams();
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
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      IPlayer.PlayerStatus localPlayerStatus = this.mPlayerStatus;
      paramMessage = (PlayerStatusMsg)paramMessage.obj;
      this.mPlayerStatus = paramMessage.getPlayerStatus();
      if ((localPlayerStatus != IPlayer.PlayerStatus.PLAYING) || ((this.mPlayerStatus != IPlayer.PlayerStatus.FINISHED) && (this.mPlayerStatus != IPlayer.PlayerStatus.ERROR)) || (!this.loop)) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        if ((this.mPlayThread.hasMessage(3)) || (this.mPlayThread.hasMessage(6)) || (this.mPlayThread.hasMessage(4)) || (this.mPlayThread.hasMessage(11)) || (this.mMainHandler.hasMessages(1)))
        {
          return true;
          this.mPosition = ((CMTime)paramMessage.obj);
          if ((this.mPlayerListener != null) && (!this.mMainHandler.hasMessages(2))) {
            this.mPlayerListener.onPositionChanged(this.mPosition);
          }
          if ((this.mPlayRange == null) || (this.mPosition.smallThan(this.mPlayRange.getEnd())) || (!isPlaying())) {
            continue;
          }
          if (this.loop)
          {
            if (this.mPlayerListener != null) {
              this.mPlayerListener.onStatusChanged(IPlayer.PlayerStatus.REPLAY);
            }
            seekToTime(this.mPlayRange.getStart());
            continue;
          }
          pause();
          continue;
        }
        if ((this.mPlayRange != null) && (this.mPlayRange.getDuration().getValue() > 0L))
        {
          seekToTime(this.mPlayRange.getStart());
          if (this.mPlayerListener != null) {
            this.mPlayerListener.onStatusChanged(IPlayer.PlayerStatus.REPLAY);
          }
          play();
          continue;
        }
        seekToTime(CMTime.CMTimeZero);
      }
      finally {}
      continue;
      if (this.mPlayerListener != null) {
        this.mPlayerListener.onStatusChanged(this.mPlayerStatus);
      }
      if (this.mPlayerStatus == IPlayer.PlayerStatus.ERROR) {
        this.errMsg = new ErrorMsg(-1, paramMessage.getErrorMsg());
      }
    }
  }
  
  /* Error */
  public boolean isPlaying()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/tencent/tav/player/Player:mPlayerStatus	Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   6: astore_2
    //   7: getstatic 216	com/tencent/tav/player/IPlayer$PlayerStatus:PLAYING	Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   10: astore_3
    //   11: aload_2
    //   12: aload_3
    //   13: if_acmpne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	Player
    //   17	7	1	bool	boolean
    //   6	6	2	localPlayerStatus1	IPlayer.PlayerStatus
    //   27	4	2	localObject	Object
    //   10	3	3	localPlayerStatus2	IPlayer.PlayerStatus
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
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
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/player/Player:released	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   18: iconst_3
    //   19: ldc 128
    //   21: invokevirtual 134	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   24: goto -13 -> 11
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	Player
    //   6	2	1	bool	boolean
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   14	24	27	finally
  }
  
  /* Error */
  public void play()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/player/Player:released	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 241	com/tencent/tav/player/Player:mPlayRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   18: ifnull +28 -> 46
    //   21: aload_0
    //   22: getfield 241	com/tencent/tav/player/Player:mPlayRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   25: aload_0
    //   26: invokevirtual 289	com/tencent/tav/player/Player:currentTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   29: invokevirtual 292	com/tencent/tav/coremedia/CMTimeRange:containsTime	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   32: ifne +14 -> 46
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 241	com/tencent/tav/player/Player:mPlayRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   40: invokevirtual 264	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   43: invokevirtual 267	com/tencent/tav/player/Player:seekToTime	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   46: aload_0
    //   47: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   50: iconst_2
    //   51: ldc 128
    //   53: invokevirtual 134	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 162	com/tencent/tav/player/Player:mAudioFocuser	Lcom/tencent/tav/player/AudioFocusHelper;
    //   60: ifnull -49 -> 11
    //   63: aload_0
    //   64: getfield 162	com/tencent/tav/player/Player:mAudioFocuser	Lcom/tencent/tav/player/AudioFocusHelper;
    //   67: invokevirtual 295	com/tencent/tav/player/AudioFocusHelper:requestFocus	()V
    //   70: goto -59 -> 11
    //   73: astore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	Player
    //   6	2	1	bool	boolean
    //   73	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	73	finally
    //   14	46	73	finally
    //   46	70	73	finally
  }
  
  /* Error */
  public CMTime position()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   6: ifnonnull +11 -> 17
    //   9: getstatic 149	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   21: invokevirtual 152	com/tencent/tav/player/PlayerThread:getPosition	()Lcom/tencent/tav/coremedia/CMTime;
    //   24: astore_1
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	Player
    //   12	13	1	localCMTime	CMTime
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
    //   17	25	28	finally
  }
  
  public void prepare(PlayerPrepareListener paramPlayerPrepareListener)
  {
    if (this.mPlayerStatus != IPlayer.PlayerStatus.IDLE) {}
  }
  
  public void readSnapShootBitmap(OnReadSnapShootListener paramOnReadSnapShootListener)
  {
    if (this.mPlayThread == null) {
      return;
    }
    this.mPlayThread.sendMessage(24, paramOnReadSnapShootListener, "readSnapShootBitmap");
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
    this.mLastSeekTargetTimeUs = this.mSeekTargetTimeUs;
    this.mPlayThread.updatePositionRightAway(this.mSeekTargetTimeUs);
    this.mPlayThread.sendMessage(5, this.mSeekTargetTimeUs, "main");
  }
  
  public void seekToTime(CMTime paramCMTime, Callback paramCallback)
  {
    seekToTime(paramCMTime, CMTime.CMTimeZero, CMTime.CMTimeZero, paramCallback);
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
  }
  
  public void setGetTavExtraListener(OnGetTavExtraListener paramOnGetTavExtraListener)
  {
    if (this.mPlayThread != null) {
      this.mPlayThread.sendMessage(25, paramOnGetTavExtraListener, "setGetTavExtraListener");
    }
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
    if (this.mPlayThread != null) {
      this.mPlayThread.setRenderContextParams(paramRenderContextParams);
    }
  }
  
  /* Error */
  public void setVolume(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/player/Player:released	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   18: bipush 7
    //   20: fload_1
    //   21: invokestatic 368	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   24: ldc 128
    //   26: invokevirtual 304	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   29: goto -18 -> 11
    //   32: astore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_3
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	Player
    //   0	37	1	paramFloat	float
    //   6	2	2	bool	boolean
    //   32	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   14	29	32	finally
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/player/Player:released	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   18: iconst_4
    //   19: iconst_1
    //   20: invokestatic 374	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   23: ldc 128
    //   25: invokevirtual 304	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   28: goto -17 -> 11
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	Player
    //   6	2	1	bool	boolean
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   14	28	31	finally
  }
  
  /* Error */
  public void update(@android.support.annotation.NonNull PlayerItem paramPlayerItem, CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/player/Player:released	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: putfield 85	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 104	com/tencent/tav/player/PlayerItem:getAsset	()Lcom/tencent/tav/asset/Asset;
    //   24: putfield 106	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   27: aload_0
    //   28: getfield 85	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   31: invokevirtual 378	com/tencent/tav/player/PlayerItem:updateDecoderTrack	()V
    //   34: aload_0
    //   35: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   38: aload_2
    //   39: invokevirtual 333	com/tencent/tav/player/PlayerThread:updatePositionRightAway	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   42: aload_0
    //   43: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   46: bipush 11
    //   48: new 380	com/tencent/tav/player/UpdateCompositionMessage
    //   51: dup
    //   52: aload_1
    //   53: aload_0
    //   54: getfield 125	com/tencent/tav/player/Player:onCompositionUpdateListener	Lcom/tencent/tav/player/OnCompositionUpdateListener;
    //   57: invokespecial 383	com/tencent/tav/player/UpdateCompositionMessage:<init>	(Lcom/tencent/tav/player/PlayerItem;Lcom/tencent/tav/player/OnCompositionUpdateListener;)V
    //   60: ldc_w 385
    //   63: invokevirtual 304	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   66: aload_0
    //   67: getstatic 149	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   70: putfield 330	com/tencent/tav/player/Player:mLastSeekTargetTimeUs	Lcom/tencent/tav/coremedia/CMTime;
    //   73: goto -62 -> 11
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	Player
    //   0	81	1	paramPlayerItem	PlayerItem
    //   0	81	2	paramCMTime	CMTime
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	76	finally
    //   14	73	76	finally
  }
  
  /* Error */
  public void update(@android.support.annotation.NonNull PlayerItem paramPlayerItem, CMTime paramCMTime, OnCompositionUpdateListener paramOnCompositionUpdateListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/player/Player:released	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: putfield 85	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 104	com/tencent/tav/player/PlayerItem:getAsset	()Lcom/tencent/tav/asset/Asset;
    //   26: putfield 106	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   29: aload_0
    //   30: getfield 85	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   33: invokevirtual 378	com/tencent/tav/player/PlayerItem:updateDecoderTrack	()V
    //   36: aload_0
    //   37: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   40: aload_2
    //   41: invokevirtual 333	com/tencent/tav/player/PlayerThread:updatePositionRightAway	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   44: aload_0
    //   45: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   48: bipush 11
    //   50: new 380	com/tencent/tav/player/UpdateCompositionMessage
    //   53: dup
    //   54: aload_1
    //   55: new 389	com/tencent/tav/player/Player$1
    //   58: dup
    //   59: aload_0
    //   60: aload_3
    //   61: invokespecial 392	com/tencent/tav/player/Player$1:<init>	(Lcom/tencent/tav/player/Player;Lcom/tencent/tav/player/OnCompositionUpdateListener;)V
    //   64: invokespecial 383	com/tencent/tav/player/UpdateCompositionMessage:<init>	(Lcom/tencent/tav/player/PlayerItem;Lcom/tencent/tav/player/OnCompositionUpdateListener;)V
    //   67: ldc_w 385
    //   70: invokevirtual 304	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getstatic 149	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   77: putfield 330	com/tencent/tav/player/Player:mLastSeekTargetTimeUs	Lcom/tencent/tav/coremedia/CMTime;
    //   80: goto -67 -> 13
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	Player
    //   0	88	1	paramPlayerItem	PlayerItem
    //   0	88	2	paramCMTime	CMTime
    //   0	88	3	paramOnCompositionUpdateListener	OnCompositionUpdateListener
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	83	finally
    //   16	80	83	finally
  }
  
  /* Error */
  public void updateAllProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/player/Player:released	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   18: bipush 20
    //   20: ldc 128
    //   22: invokevirtual 134	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   25: goto -14 -> 11
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	Player
    //   6	2	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   14	25	28	finally
  }
  
  /* Error */
  public void updateAudioClipsProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/player/Player:released	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   18: bipush 22
    //   20: ldc 128
    //   22: invokevirtual 134	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   25: goto -14 -> 11
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	Player
    //   6	2	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   14	25	28	finally
  }
  
  /* Error */
  public void updateAudioVolumeProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/player/Player:released	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   18: bipush 23
    //   20: ldc 128
    //   22: invokevirtual 134	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   25: goto -14 -> 11
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	Player
    //   6	2	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   14	25	28	finally
  }
  
  /* Error */
  public void updateProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/tav/player/Player:released	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 116	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   18: bipush 10
    //   20: ldc 128
    //   22: invokevirtual 134	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   25: goto -14 -> 11
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	Player
    //   6	2	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   14	25	28	finally
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
    if (this.currentItem == null) {
      return 0;
    }
    return (int)this.currentItem.getPresentationSize().height;
  }
  
  public int videoWidth()
  {
    if (this.currentItem == null) {
      return 0;
    }
    return (int)this.currentItem.getPresentationSize().width;
  }
  
  public void waitForRelease(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.player.Player
 * JD-Core Version:    0.7.0.1
 */