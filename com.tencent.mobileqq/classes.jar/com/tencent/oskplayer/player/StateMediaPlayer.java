package com.tencent.oskplayer.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.VideoUrlValidator;
import java.io.FileDescriptor;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.InternalOperationException;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

public class StateMediaPlayer
  implements IMediaPlayer
{
  public static final String LOG_TAG = "StateMediaPlayer";
  protected static final VideoUrlValidator sVideoUrlValidator = new VideoUrlValidator();
  private boolean mAlreadyStart = false;
  private boolean mHasValidSurface = false;
  protected IMediaPlayer mInternalMediaPlayer;
  private boolean mIsSurfaceRequired;
  protected StateMediaPlayer.StateMediaPlayerInternalState mMediaPlayerState;
  private int mMode;
  private final Object mPrepareLock = new Object();
  private StateMediaPlayer.StateChangeListener mStateChangeListener;
  protected boolean mThrowException = false;
  
  public StateMediaPlayer(IMediaPlayer paramIMediaPlayer, boolean paramBoolean)
  {
    this.mInternalMediaPlayer = paramIMediaPlayer;
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.IDLE)) {
      if (!this.mThrowException)
      {
        paramIMediaPlayer = new StringBuilder();
        paramIMediaPlayer.append("StateMediaPlayer constructor setMediaPlayerState IDLE error ");
        paramIMediaPlayer.append(getMediaPlayerState());
        paramIMediaPlayer.append(this);
        paramIMediaPlayer.append("\n: stack\n");
        paramIMediaPlayer.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", paramIMediaPlayer.toString());
      }
      else
      {
        paramIMediaPlayer = new StringBuilder();
        paramIMediaPlayer.append("StateMediaPlayer constructor setMediaPlayerState IDLE error ");
        paramIMediaPlayer.append(getMediaPlayerState());
        paramIMediaPlayer.append(this);
        throw new IllegalStateException(paramIMediaPlayer.toString());
      }
    }
    this.mThrowException = paramBoolean;
    this.mMode = 3;
    initMode();
  }
  
  private void initMode()
  {
    int i = this.mMode;
    boolean bool = true;
    if ((i & 0x1) != 1) {
      bool = false;
    }
    this.mIsSurfaceRequired = bool;
  }
  
  public boolean checkState(StateMediaPlayer.StateMediaPlayerOperation paramStateMediaPlayerOperation)
  {
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" > checkState operation=");
        ((StringBuilder)localObject).append(paramStateMediaPlayerOperation);
        ((StringBuilder)localObject).append(", currentState=");
        ((StringBuilder)localObject).append(this.mMediaPlayerState);
        PlayerUtils.log(2, "StateMediaPlayer", ((StringBuilder)localObject).toString());
        switch (StateMediaPlayer.5.$SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation[paramStateMediaPlayerOperation.ordinal()])
        {
        case 16: 
        case 17: 
          if (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.RELEASED)
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.IDLE;
            if (paramStateMediaPlayerOperation != localObject) {
              break;
            }
          }
          else
          {
            return false;
          }
        case 15: 
          if (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARING)
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.RELEASED;
            if (paramStateMediaPlayerOperation != localObject) {
              break;
            }
          }
          else
          {
            return false;
          }
        case 14: 
          if (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARING)
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.IDLE;
            if (paramStateMediaPlayerOperation != localObject) {
              break;
            }
          }
          else
          {
            return false;
          }
        case 12: 
        case 13: 
          if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.IDLE) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED))
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
            if (paramStateMediaPlayerOperation != localObject) {
              return false;
            }
          }
        case 11: 
          if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED))
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
            if (paramStateMediaPlayerOperation != localObject) {
              return false;
            }
          }
        case 9: 
        case 10: 
          if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED))
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED;
            if (paramStateMediaPlayerOperation != localObject) {
              return false;
            }
          }
        case 7: 
        case 8: 
          if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED))
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
            if (paramStateMediaPlayerOperation != localObject) {
              return false;
            }
          }
        case 6: 
          if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED))
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
            if (paramStateMediaPlayerOperation != localObject) {
              return false;
            }
          }
        case 4: 
        case 5: 
          if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED))
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
            if (paramStateMediaPlayerOperation != localObject) {
              return false;
            }
          }
        case 3: 
          if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED))
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
            if (paramStateMediaPlayerOperation != localObject) {
              return false;
            }
          }
        case 2: 
          if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED))
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
            if (paramStateMediaPlayerOperation != localObject) {
              return false;
            }
          }
        case 1: 
          if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED))
          {
            paramStateMediaPlayerOperation = this.mMediaPlayerState;
            localObject = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
            if (paramStateMediaPlayerOperation != localObject) {
              return false;
            }
          }
          return true;
        }
      }
      finally {}
    }
  }
  
  public int getAudioSessionId()
  {
    return this.mInternalMediaPlayer.getAudioSessionId();
  }
  
  public long getCurrentPosition()
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTPOSITION))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getCurrentPosition in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getCurrentPosition in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    return this.mInternalMediaPlayer.getCurrentPosition();
  }
  
  public String getDataSource()
  {
    if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getDataSource in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getDataSource in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    return this.mInternalMediaPlayer.getDataSource();
  }
  
  public long getDuration()
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETDURATION))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getDuration in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getDuration in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    return this.mInternalMediaPlayer.getDuration();
  }
  
  public IMediaPlayer getInternalMediaPlayer()
  {
    return this.mInternalMediaPlayer;
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.mInternalMediaPlayer.getMediaInfo();
  }
  
  public StateMediaPlayer.StateMediaPlayerInternalState getMediaPlayerState()
  {
    try
    {
      StateMediaPlayer.StateMediaPlayerInternalState localStateMediaPlayerInternalState = this.mMediaPlayerState;
      return localStateMediaPlayerInternalState;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getScore()
  {
    return this.mInternalMediaPlayer.getScore();
  }
  
  public ITrackInfo[] getTrackInfo()
  {
    return this.mInternalMediaPlayer.getTrackInfo();
  }
  
  public int getVideoHeight()
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETVIDEOHEIGHT))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getVideoHeight in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getVideoHeight in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    return this.mInternalMediaPlayer.getVideoHeight();
  }
  
  public int getVideoSarDen()
  {
    return this.mInternalMediaPlayer.getVideoSarDen();
  }
  
  public int getVideoSarNum()
  {
    return this.mInternalMediaPlayer.getVideoSarNum();
  }
  
  public int getVideoWidth()
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETVIDEOWIDTH))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getVideoWidth in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getVideoWidth in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    return this.mInternalMediaPlayer.getVideoWidth();
  }
  
  public boolean isInIdleState()
  {
    return getMediaPlayerState() == StateMediaPlayer.StateMediaPlayerInternalState.IDLE;
  }
  
  public boolean isLooping()
  {
    return this.mInternalMediaPlayer.isLooping();
  }
  
  public boolean isPaused()
  {
    return getMediaPlayerState() == StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED;
  }
  
  public boolean isPlayable()
  {
    return this.mInternalMediaPlayer.isPlayable();
  }
  
  public boolean isPlaying()
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_ISPLAYING))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call isPlaying in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call isPlaying in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    return this.mInternalMediaPlayer.isPlaying();
  }
  
  public void markValidSurface()
  {
    this.mHasValidSurface = true;
  }
  
  public void pause()
  {
    try
    {
      this.mInternalMediaPlayer.pause();
      if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED))
      {
        if (!this.mThrowException)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("call pause in illegalState ");
          localStringBuilder1.append(getMediaPlayerState());
          localStringBuilder1.append(this);
          localStringBuilder1.append("\n: stack\n");
          localStringBuilder1.append(PlayerUtils.getStackTrace());
          PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder1.toString());
          return;
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("call pause in illegalState ");
        localStringBuilder1.append(getMediaPlayerState());
        localStringBuilder1.append(this);
        throw new StateMediaPlayerException(localStringBuilder1.toString());
      }
      return;
    }
    catch (IMediaPlayer.InternalOperationException localInternalOperationException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("caught ");
      localStringBuilder2.append(localInternalOperationException);
      PlayerUtils.log(4, "StateMediaPlayer", localStringBuilder2.toString());
      throw localInternalOperationException;
    }
  }
  
  /* Error */
  public void prepareAsync()
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 133	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARING	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   4: invokevirtual 58	com/tencent/oskplayer/player/StateMediaPlayer:setMediaPlayerState	(Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;)Z
    //   7: ifne +110 -> 117
    //   10: aload_0
    //   11: getfield 43	com/tencent/oskplayer/player/StateMediaPlayer:mThrowException	Z
    //   14: ifne +61 -> 75
    //   17: new 60	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc 250
    //   28: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: aload_0
    //   34: invokevirtual 71	com/tencent/oskplayer/player/StateMediaPlayer:getMediaPlayerState	()Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   37: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_1
    //   42: aload_0
    //   43: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_1
    //   48: ldc 76
    //   50: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_1
    //   55: invokestatic 82	com/tencent/oskplayer/util/PlayerUtils:getStackTrace	()Ljava/lang/String;
    //   58: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: iconst_5
    //   63: ldc 10
    //   65: aload_1
    //   66: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 89	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   72: goto +45 -> 117
    //   75: new 60	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   82: astore_1
    //   83: aload_1
    //   84: ldc 250
    //   86: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: aload_0
    //   92: invokevirtual 71	com/tencent/oskplayer/player/StateMediaPlayer:getMediaPlayerState	()Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   95: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_1
    //   100: aload_0
    //   101: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: new 169	com/tencent/oskplayer/player/StateMediaPlayerException
    //   108: dup
    //   109: aload_1
    //   110: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokespecial 170	com/tencent/oskplayer/player/StateMediaPlayerException:<init>	(Ljava/lang/String;)V
    //   116: athrow
    //   117: aload_0
    //   118: getfield 41	com/tencent/oskplayer/player/StateMediaPlayer:mPrepareLock	Ljava/lang/Object;
    //   121: astore_1
    //   122: aload_1
    //   123: monitorenter
    //   124: aload_0
    //   125: getfield 49	com/tencent/oskplayer/player/StateMediaPlayer:mInternalMediaPlayer	Ltv/danmaku/ijk/media/player/IMediaPlayer;
    //   128: invokeinterface 252 1 0
    //   133: aload_1
    //   134: monitorexit
    //   135: return
    //   136: astore_2
    //   137: aload_1
    //   138: monitorexit
    //   139: aload_2
    //   140: athrow
    //   141: astore_1
    //   142: new 60	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   149: astore_2
    //   150: aload_2
    //   151: ldc 254
    //   153: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_2
    //   158: aload_0
    //   159: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_2
    //   164: aload_1
    //   165: invokestatic 258	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   168: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: iconst_5
    //   173: ldc 10
    //   175: aload_2
    //   176: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 89	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: getstatic 261	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ERROR	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   186: invokevirtual 58	com/tencent/oskplayer/player/StateMediaPlayer:setMediaPlayerState	(Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;)Z
    //   189: pop
    //   190: aload_1
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	StateMediaPlayer
    //   141	50	1	localIllegalStateException	IllegalStateException
    //   136	4	2	localObject2	Object
    //   149	27	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   124	135	136	finally
    //   137	139	136	finally
    //   117	124	141	java/lang/IllegalStateException
    //   139	141	141	java/lang/IllegalStateException
  }
  
  public void release()
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.RELEASED))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call release in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call release in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    this.mInternalMediaPlayer.release();
  }
  
  public void reset()
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.IDLE))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call reset in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call reset in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    this.mInternalMediaPlayer.reset();
  }
  
  public void seekTo(long paramLong)
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SEEKTO))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call seekTo in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call seekTo in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    this.mInternalMediaPlayer.seekTo(paramLong);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.IDLE) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setAudioStreamType in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setAudioStreamType in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    this.mInternalMediaPlayer.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED)) {
      if (!this.mThrowException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setDataSource in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append("call setDataSource in illegalState ");
        paramContext.append(getMediaPlayerState());
        paramContext.append(this);
        throw new StateMediaPlayerException(paramContext.toString());
      }
    }
    this.mInternalMediaPlayer.setDataSource(paramContext, paramUri);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED)) {
      if (!this.mThrowException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setDataSource in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append("call setDataSource in illegalState ");
        paramContext.append(getMediaPlayerState());
        paramContext.append(this);
        throw new StateMediaPlayerException(paramContext.toString());
      }
    }
    this.mInternalMediaPlayer.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED)) {
      if (!this.mThrowException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setDataSource in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        paramFileDescriptor = new StringBuilder();
        paramFileDescriptor.append("call setDataSource in illegalState ");
        paramFileDescriptor.append(getMediaPlayerState());
        paramFileDescriptor.append(this);
        throw new StateMediaPlayerException(paramFileDescriptor.toString());
      }
    }
    this.mInternalMediaPlayer.setDataSource(paramFileDescriptor);
  }
  
  public void setDataSource(String paramString)
  {
    StringBuilder localStringBuilder;
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED)) {
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setDataSource in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("call setDataSource in illegalState ");
        paramString.append(getMediaPlayerState());
        paramString.append(this);
        throw new StateMediaPlayerException(paramString.toString());
      }
    }
    if (!sVideoUrlValidator.isValid(paramString)) {
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoUrlValidationError ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoUrlValidationError ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    this.mInternalMediaPlayer.setDataSource(paramString);
  }
  
  public void setDataSource(IMediaDataSource paramIMediaDataSource)
  {
    this.mInternalMediaPlayer.setDataSource(paramIMediaDataSource);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    this.mInternalMediaPlayer.setDisplay(paramSurfaceHolder);
  }
  
  public void setKeepInBackground(boolean paramBoolean)
  {
    this.mInternalMediaPlayer.setKeepInBackground(paramBoolean);
  }
  
  public void setLogEnabled(boolean paramBoolean)
  {
    this.mInternalMediaPlayer.setLogEnabled(paramBoolean);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETLOOPING))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setLooping in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setLooping in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    this.mInternalMediaPlayer.setLooping(paramBoolean);
  }
  
  protected boolean setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState paramStateMediaPlayerInternalState)
  {
    try
    {
      StateMediaPlayer.StateMediaPlayerInternalState localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
      StateMediaPlayer.StateMediaPlayerInternalState localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.RELEASED;
      if (localStateMediaPlayerInternalState1 == localStateMediaPlayerInternalState2) {
        return false;
      }
      int i = StateMediaPlayer.5.$SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[paramStateMediaPlayerInternalState.ordinal()];
      switch (i)
      {
      default: 
        return false;
      case 9: 
        if (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED)
        {
          localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
          localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.ERROR;
          if (localStateMediaPlayerInternalState1 != localStateMediaPlayerInternalState2) {
            return false;
          }
        }
        break;
      case 8: 
        if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED))
        {
          localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
          localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
          if (localStateMediaPlayerInternalState1 != localStateMediaPlayerInternalState2) {
            return false;
          }
        }
        break;
      case 7: 
        if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED))
        {
          localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
          localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.STARTED;
          if (localStateMediaPlayerInternalState1 != localStateMediaPlayerInternalState2) {
            return false;
          }
        }
        break;
      case 6: 
        if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED))
        {
          localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
          localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
          if (localStateMediaPlayerInternalState1 != localStateMediaPlayerInternalState2) {
            return false;
          }
        }
        break;
      case 5: 
        if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED))
        {
          localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
          localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED;
          if (localStateMediaPlayerInternalState1 != localStateMediaPlayerInternalState2) {
            return false;
          }
        }
        break;
      case 4: 
        localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
        localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.PREPARING;
        if (localStateMediaPlayerInternalState1 != localStateMediaPlayerInternalState2) {
          return false;
        }
        break;
      case 3: 
        if (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED)
        {
          localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
          localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.STOPPED;
          if (localStateMediaPlayerInternalState1 != localStateMediaPlayerInternalState2) {
            return false;
          }
        }
        break;
      case 2: 
        localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
        localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.IDLE;
        if (localStateMediaPlayerInternalState1 != localStateMediaPlayerInternalState2) {
          return false;
        }
        break;
      case 1: 
        localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
        localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.PREPARING;
        if (localStateMediaPlayerInternalState1 == localStateMediaPlayerInternalState2) {
          return false;
        }
        break;
      }
      if (this.mMediaPlayerState == null) {
        i = -1;
      } else {
        i = this.mMediaPlayerState.ordinal();
      }
      this.mMediaPlayerState = paramStateMediaPlayerInternalState;
      if (this.mStateChangeListener != null) {
        this.mStateChangeListener.onStateChange(i, this.mMediaPlayerState.ordinal());
      }
      paramStateMediaPlayerInternalState = new StringBuilder();
      paramStateMediaPlayerInternalState.append("setMediaPlayerState ");
      paramStateMediaPlayerInternalState.append(this);
      paramStateMediaPlayerInternalState.append(" MediaPlayerState=");
      paramStateMediaPlayerInternalState.append(this.mMediaPlayerState);
      PlayerUtils.log(4, "StateMediaPlayer", paramStateMediaPlayerInternalState.toString());
      return true;
    }
    finally {}
  }
  
  public void setMode(int paramInt)
  {
    this.mMode = paramInt;
    IMediaPlayer localIMediaPlayer = this.mInternalMediaPlayer;
    if ((localIMediaPlayer instanceof SegmentMediaPlayer)) {
      ((SegmentMediaPlayer)localIMediaPlayer).setPlayMode(this.mMode);
    }
    initMode();
  }
  
  public void setNextMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    this.mInternalMediaPlayer.setNextMediaPlayer(paramIMediaPlayer);
  }
  
  public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.mInternalMediaPlayer.setOnBufferingUpdateListener(paramOnBufferingUpdateListener);
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mInternalMediaPlayer.setOnCompletionListener(new StateMediaPlayer.2(this, paramOnCompletionListener));
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mInternalMediaPlayer.setOnErrorListener(new StateMediaPlayer.3(this, paramOnErrorListener));
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mInternalMediaPlayer.setOnInfoListener(new StateMediaPlayer.4(this, paramOnInfoListener));
  }
  
  public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    this.mInternalMediaPlayer.setOnLoopStartListener(paramOnLoopStartListener);
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.mInternalMediaPlayer.setOnPreparedListener(new StateMediaPlayer.1(this, paramOnPreparedListener));
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mInternalMediaPlayer.setOnSeekCompleteListener(paramOnSeekCompleteListener);
  }
  
  public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener paramOnTimedTextListener)
  {
    if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.IDLE) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED)) {
      if (!this.mThrowException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setOnTimedTextListener in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        paramOnTimedTextListener = new StringBuilder();
        paramOnTimedTextListener.append("call setOnTimedTextListener in illegalState ");
        paramOnTimedTextListener.append(getMediaPlayerState());
        throw new StateMediaPlayerException(paramOnTimedTextListener.toString());
      }
    }
    this.mInternalMediaPlayer.setOnTimedTextListener(paramOnTimedTextListener);
  }
  
  public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mInternalMediaPlayer.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.mInternalMediaPlayer.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setSeekParameters(SeekParameters paramSeekParameters)
  {
    this.mInternalMediaPlayer.setSeekParameters(paramSeekParameters);
  }
  
  public void setStateChangeListener(StateMediaPlayer.StateChangeListener paramStateChangeListener)
  {
    this.mStateChangeListener = paramStateChangeListener;
  }
  
  public void setStrictMode(boolean paramBoolean)
  {
    this.mThrowException = paramBoolean;
  }
  
  public void setSurface(Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSurface ");
    localStringBuilder.append(this);
    PlayerUtils.log(4, "StateMediaPlayer", localStringBuilder.toString());
    boolean bool;
    if (paramSurface != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.mHasValidSurface = bool;
    this.mInternalMediaPlayer.setSurface(paramSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETVOLUME))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setVolume in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call setVolume in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    this.mInternalMediaPlayer.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.mInternalMediaPlayer.setWakeMode(paramContext, paramInt);
  }
  
  public void start()
  {
    StringBuilder localStringBuilder1;
    if ((this.mIsSurfaceRequired) && (!this.mHasValidSurface)) {
      if (!this.mThrowException)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("call start without a valid surface ");
        localStringBuilder1.append(getMediaPlayerState());
        localStringBuilder1.append(this);
        localStringBuilder1.append("\n: stack\n");
        localStringBuilder1.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder1.toString());
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("call start without a valid surface ");
        localStringBuilder1.append(getMediaPlayerState());
        localStringBuilder1.append(this);
        throw new StateMediaPlayerException(localStringBuilder1.toString());
      }
    }
    try
    {
      this.mInternalMediaPlayer.start();
      if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.STARTED)) {
        if (!this.mThrowException)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("call start in illegalState ");
          localStringBuilder1.append(getMediaPlayerState());
          localStringBuilder1.append(this);
          localStringBuilder1.append("\n: stack\n");
          localStringBuilder1.append(PlayerUtils.getStackTrace());
          PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder1.toString());
        }
        else
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("call start in illegalState ");
          localStringBuilder1.append(getMediaPlayerState());
          localStringBuilder1.append(this);
          throw new StateMediaPlayerException(localStringBuilder1.toString());
        }
      }
      this.mAlreadyStart = true;
      return;
    }
    catch (IMediaPlayer.InternalOperationException localInternalOperationException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("caught ");
      localStringBuilder2.append(localInternalOperationException);
      PlayerUtils.log(4, "StateMediaPlayer", localStringBuilder2.toString());
      throw localInternalOperationException;
    }
  }
  
  public void stop()
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.STOPPED))
    {
      StringBuilder localStringBuilder;
      if (!this.mThrowException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call stop in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        localStringBuilder.append("\n: stack\n");
        localStringBuilder.append(PlayerUtils.getStackTrace());
        PlayerUtils.log(5, "StateMediaPlayer", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call stop in illegalState ");
        localStringBuilder.append(getMediaPlayerState());
        localStringBuilder.append(this);
        throw new StateMediaPlayerException(localStringBuilder.toString());
      }
    }
    this.mInternalMediaPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateMediaPlayer
 * JD-Core Version:    0.7.0.1
 */