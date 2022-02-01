package com.tencent.oskplayer.player;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo.SegmentInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
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
import tv.danmaku.ijk.media.player.pragma.DebugLog;

public class SegmentMediaPlayer
  implements ISegmentMediaPlayer, IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPreparedListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnVideoSizeChangedListener
{
  public static final int ERROR_SET_NEXT_MEDIA_PLAYER_FAILED = 20001;
  private static final String LOG_TAG = "SegmentMediaPlayer";
  private static final int MSG_INIT_NEXT_PLAYER = 0;
  private static final int MSG_RELEASE_OLD_PLAYER = 1;
  private static final int MSG_SEEK_TO = 2;
  private static final int SURFACE_TYPE_DISPLAY = 0;
  private static final int SURFACE_TYPE_SURFACE = 1;
  private Context context;
  private StateMediaPlayer currentPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
  private int currentSegment;
  private int defaultPlayMode = 3;
  private Handler handler;
  private boolean isAllowLooping;
  private boolean isLooping;
  private volatile boolean isReleasing;
  private volatile boolean isSeeking;
  private float leftVolume;
  private long mLastCurrentPosition = 0L;
  private int mPlayMode = this.defaultPlayMode;
  private volatile boolean needStartAfterPrepared;
  private volatile boolean needStopAfterPrepared = false;
  private StateMediaPlayer nextPlayer;
  private IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
  private IMediaPlayer.OnCompletionListener onCompletionListener;
  private IMediaPlayer.OnErrorListener onErrorListener;
  private IMediaPlayer.OnInfoListener onInfoListener;
  private IMediaPlayer.OnLoopStartListener onLoopStartListener;
  private IMediaPlayer.OnPreparedListener onPreparedListener;
  private IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
  private IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener;
  private List<String> proxyUrls;
  private float rightVolume;
  private boolean screenOnWhilePlaying = true;
  private volatile long seekAfterPrepared;
  private HandlerThread segmentPlayerThread;
  private List<String> sourceUrls;
  private SegmentVideoInfo.StreamInfo streamInfo;
  private boolean strictMode = false;
  private Surface surface;
  private SurfaceHolder surfaceHolder;
  private int surfaceType;
  private int totalSegment;
  private int wakeMode;
  
  public SegmentMediaPlayer()
  {
    this.currentPlayer.setMode(this.mPlayMode);
    this.segmentPlayerThread = getRealTimeThread();
    this.handler = new SegmentMediaPlayer.1(this, this.segmentPlayerThread.getLooper());
  }
  
  private void doRelease()
  {
    try
    {
      if (this.currentPlayer != null)
      {
        PlayerUtils.log(4, "SegmentMediaPlayer", "currentPlayer is release");
        this.currentPlayer.release();
        this.currentPlayer = null;
      }
      if (this.nextPlayer != null)
      {
        PlayerUtils.log(4, "SegmentMediaPlayer", "nextPlayer is release");
        this.nextPlayer.release();
        this.nextPlayer = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        PlayerUtils.log(5, "SegmentMediaPlayer", "failed release. msg=" + localException.getMessage());
      }
    }
    finally {}
  }
  
  private HandlerThread getRealTimeThread()
  {
    HandlerThread localHandlerThread = new HandlerThread("SegmentMediaPlayer_RealTime_HandlerThread", -2);
    if (!localHandlerThread.isAlive()) {
      localHandlerThread.start();
    }
    return localHandlerThread;
  }
  
  private void handleReleaseOldPlayer(IMediaPlayer paramIMediaPlayer)
  {
    if (paramIMediaPlayer != null) {
      paramIMediaPlayer.release();
    }
  }
  
  private void handleSeekTo(long paramLong)
  {
    boolean bool2 = false;
    if ((this.streamInfo == null) || (this.streamInfo.segmentInfos == null)) {
      return;
    }
    PlayerUtils.log(4, "SegmentMediaPlayer", "seekTo position=" + paramLong);
    int i = this.streamInfo.getSegmentIndex(paramLong);
    PlayerUtils.log(4, "SegmentMediaPlayer", "seekTo segment index=" + i);
    if (i < 0)
    {
      PlayerUtils.log(5, "SegmentMediaPlayer", "seekTo position out of bound! seek to 0");
      paramLong = 0L;
      i = 0;
    }
    for (;;)
    {
      for (;;)
      {
        SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)this.streamInfo.segmentInfos.get(i);
        if (localSegmentInfo == null) {
          break;
        }
        long l = paramLong - localSegmentInfo.offset;
        PlayerUtils.log(4, "SegmentMediaPlayer", "seekTo segment realPosition=" + l + " url=" + localSegmentInfo.url);
        if (i == this.currentSegment)
        {
          if (this.currentPlayer == null) {
            break;
          }
          PlayerUtils.log(4, "SegmentMediaPlayer", "seekTo currentPlayer");
          try
          {
            this.currentPlayer.seekTo(l);
            return;
          }
          catch (Exception localException)
          {
            PlayerUtils.log(5, "SegmentMediaPlayer", "seekTo exception: " + PlayerUtils.getPrintableStackTrace(localException));
            return;
          }
        }
        boolean bool1 = bool2;
        if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_ISPLAYING)) {
          if ((this.currentPlayer == null) || (!this.currentPlayer.isPlaying()))
          {
            bool1 = bool2;
            if (!this.isSeeking) {}
          }
          else
          {
            bool1 = true;
          }
        }
        PlayerUtils.log(4, "SegmentMediaPlayer", "currentPlayer isPlaying=" + bool1);
        this.currentSegment = i;
        try
        {
          init(true);
          if (this.currentPlayer == null) {
            break;
          }
          this.seekAfterPrepared = l;
          this.needStartAfterPrepared = bool1;
          this.isSeeking = true;
          PlayerUtils.log(4, "SegmentMediaPlayer", "prepare currentPlayer. realPosition=" + l + " url=" + localException.url);
          this.currentPlayer.prepareAsync();
          return;
        }
        catch (IOException localIOException)
        {
          PlayerUtils.log(6, "SegmentMediaPlayer", "failed seeking to segment=" + i + " position=" + paramLong + " exception:" + PlayerUtils.getPrintableStackTrace(localIOException));
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          PlayerUtils.log(6, "SegmentMediaPlayer", "failed. IllegalStateException when seeking to segment=" + i + " position=" + paramLong + " exception=" + PlayerUtils.getPrintableStackTrace(localIllegalStateException));
          return;
        }
      }
    }
  }
  
  private void handleSetupNextPlayer()
  {
    if (hasNext()) {
      try
      {
        if (this.streamInfo == null) {
          return;
        }
        SegmentVideoInfo.SegmentInfo localSegmentInfo = this.streamInfo.getSegment(this.currentSegment + 1);
        if (localSegmentInfo != null)
        {
          PlayerUtils.log(4, "SegmentMediaPlayer", "init next mediaplayer");
          this.nextPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
          this.nextPlayer.setMode(this.mPlayMode);
          String str = (String)this.proxyUrls.get(this.currentSegment + 1);
          PlayerUtils.log(4, "SegmentMediaPlayer", "setup next mediaplayer url=" + localSegmentInfo.url + " proxyurl=" + str);
          this.nextPlayer.setDataSource(str);
          this.nextPlayer.setOnPreparedListener(this);
          this.nextPlayer.setOnInfoListener(this);
          this.nextPlayer.setOnCompletionListener(this);
          this.nextPlayer.setOnBufferingUpdateListener(this);
          this.nextPlayer.setOnErrorListener(this);
          if (this.context != null) {
            this.nextPlayer.setWakeMode(this.context, this.wakeMode);
          }
          if (PlayerConfig.g().isDebugVersion()) {
            PlayerUtils.log(3, "SegmentMediaPlayer", "nextPlayer setVolume, leftVolume=" + this.leftVolume + " rightVolume=" + this.rightVolume + toString());
          }
          this.nextPlayer.setVolume(this.leftVolume, this.rightVolume);
          this.nextPlayer.setScreenOnWhilePlaying(this.screenOnWhilePlaying);
          if (this.isAllowLooping) {
            this.nextPlayer.setLooping(false);
          }
          this.nextPlayer.prepareAsync();
          return;
        }
      }
      catch (Exception localException)
      {
        PlayerUtils.log(6, "SegmentMediaPlayer", "setup next mediaplayer error. exception:" + PlayerUtils.getPrintableStackTrace(localException));
      }
    }
  }
  
  private boolean hasNext()
  {
    return this.currentSegment + 1 < this.totalSegment;
  }
  
  private void init(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        doRelease();
        PlayerUtils.log(4, "SegmentMediaPlayer", "init: currentSegment=" + this.currentSegment);
        SegmentVideoInfo.SegmentInfo localSegmentInfo = this.streamInfo.getSegment(this.currentSegment);
        if (localSegmentInfo == null)
        {
          PlayerUtils.log(6, "SegmentMediaPlayer", "init: segment==null currentSegment=" + this.currentSegment);
          return;
        }
        if (this.currentPlayer == null)
        {
          this.currentPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
          this.currentPlayer.setMode(this.mPlayMode);
        }
        String str = (String)this.proxyUrls.get(this.currentSegment);
        PlayerUtils.log(4, "SegmentMediaPlayer", "init: currentSegment=" + this.currentSegment + " url=" + localSegmentInfo.url + " proxyUrl=" + str);
        this.currentPlayer.setDataSource(str);
        if (PlayerUtils.isHLSStream(str))
        {
          this.isAllowLooping = false;
          initCurrentPlayer();
        }
        else
        {
          this.isAllowLooping = true;
        }
      }
      finally {}
    }
  }
  
  private void initCurrentPlayer()
  {
    PlayerUtils.log(4, "SegmentMediaPlayer", "initCurrentPlayer...");
    if (this.currentPlayer == null) {
      return;
    }
    this.currentPlayer.setOnPreparedListener(this);
    this.currentPlayer.setOnInfoListener(this);
    this.currentPlayer.setOnCompletionListener(this);
    this.currentPlayer.setOnSeekCompleteListener(this);
    this.currentPlayer.setOnBufferingUpdateListener(this);
    this.currentPlayer.setOnVideoSizeChangedListener(this);
    this.currentPlayer.setOnErrorListener(this);
    if (this.context != null) {
      this.currentPlayer.setWakeMode(this.context, this.wakeMode);
    }
    if (PlayerConfig.g().isDebugVersion()) {
      PlayerUtils.log(3, "SegmentMediaPlayer", "currentPlayer setVolume, leftVolume=" + this.leftVolume + " rightVolume=" + this.rightVolume + toString());
    }
    this.currentPlayer.setVolume(this.leftVolume, this.rightVolume);
    this.currentPlayer.setScreenOnWhilePlaying(this.screenOnWhilePlaying);
    this.currentPlayer.setLooping(false);
    if (this.isAllowLooping) {
      this.currentPlayer.setLooping(false);
    }
    setDisplaySurface(this.currentPlayer);
  }
  
  private void removeDisplaySurface(IMediaPlayer paramIMediaPlayer)
  {
    if (paramIMediaPlayer == null) {}
    do
    {
      return;
      if (this.surfaceType == 0)
      {
        paramIMediaPlayer.setDisplay(null);
        return;
      }
    } while (this.surfaceType != 1);
    paramIMediaPlayer.setSurface(null);
  }
  
  private void setDisplaySurface(IMediaPlayer paramIMediaPlayer)
  {
    if (paramIMediaPlayer == null) {}
    do
    {
      return;
      if (this.surfaceType == 0)
      {
        paramIMediaPlayer.setDisplay(this.surfaceHolder);
        return;
      }
    } while (this.surfaceType != 1);
    paramIMediaPlayer.setSurface(this.surface);
  }
  
  public int getAudioSessionId()
  {
    return 0;
  }
  
  public long getCurrentPosition()
  {
    long l1 = 0L;
    if (this.streamInfo == null) {
      return 0L;
    }
    if ((this.currentPlayer == null) || (!this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTPOSITION))) {
      return this.mLastCurrentPosition;
    }
    for (;;)
    {
      try
      {
        localObject = this.currentPlayer;
        if (localObject != null) {
          continue;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Object localObject;
        int i;
        long l2;
        PlayerUtils.log(5, "SegmentMediaPlayer", "getCurrentPosition illegal state");
        continue;
        this.mLastCurrentPosition = l1;
      }
      localObject = this.streamInfo.segmentInfos;
      i = 0;
      if (i >= this.currentSegment) {
        continue;
      }
      l1 += ((SegmentVideoInfo.SegmentInfo)((ArrayList)localObject).get(i)).duration;
      i += 1;
      continue;
      l2 = this.currentPlayer.getCurrentPosition();
      l1 = l2;
    }
    return l1;
  }
  
  public String getCurrentProxySegmentUrl()
  {
    if (this.proxyUrls != null) {
      return (String)this.proxyUrls.get(this.currentSegment);
    }
    PlayerUtils.log(5, "SegmentMediaPlayer", "illegal on calling getCurrentSegmentVideoUrl, must call setDataSource first " + PlayerUtils.getStackTrace());
    return null;
  }
  
  public String getCurrentSegmentUrl()
  {
    if (this.sourceUrls != null) {
      return (String)this.sourceUrls.get(this.currentSegment);
    }
    PlayerUtils.log(5, "SegmentMediaPlayer", "illegal on calling getCurrentSegmentVideoUrl, must call setDataSource first " + PlayerUtils.getStackTrace());
    return null;
  }
  
  public String getDataSource()
  {
    return null;
  }
  
  public long getDuration()
  {
    if (this.streamInfo != null) {
      return this.streamInfo.getTotalDuration();
    }
    return 0L;
  }
  
  public MediaInfo getMediaInfo()
  {
    return null;
  }
  
  public int getScore()
  {
    return 0;
  }
  
  public int getSegmentCount()
  {
    return this.totalSegment;
  }
  
  public ITrackInfo[] getTrackInfo()
  {
    return new ITrackInfo[0];
  }
  
  /* Error */
  public int getVideoHeight()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   13: invokevirtual 486	com/tencent/oskplayer/player/StateMediaPlayer:getVideoHeight	()I
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	SegmentMediaPlayer
    //   16	7	1	i	int
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public int getVideoSarDen()
  {
    return 0;
  }
  
  public int getVideoSarNum()
  {
    return 0;
  }
  
  /* Error */
  public int getVideoWidth()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   13: invokevirtual 491	com/tencent/oskplayer/player/StateMediaPlayer:getVideoWidth	()I
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	SegmentMediaPlayer
    //   16	7	1	i	int
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public boolean isLooping()
  {
    return this.isLooping;
  }
  
  public boolean isPlayable()
  {
    return false;
  }
  
  public boolean isPlaying()
  {
    try
    {
      if ((this.currentPlayer != null) && (!this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_ISPLAYING))) {
        return false;
      }
      if (this.currentPlayer != null)
      {
        boolean bool = this.currentPlayer.isPlaying();
        if (bool) {
          return true;
        }
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      PlayerUtils.log(5, "SegmentMediaPlayer", PlayerUtils.getPrintableStackTrace(localIllegalStateException));
    }
    return false;
  }
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.isReleasing;
        if (bool) {
          return;
        }
        int i;
        if ((this.nextPlayer != null) && (paramIMediaPlayer == this.nextPlayer.getInternalMediaPlayer()))
        {
          i = this.currentSegment + 1;
          int j = paramInt;
          if (this.streamInfo != null)
          {
            paramIMediaPlayer = this.streamInfo.getSegment(i);
            j = paramInt;
            if (paramIMediaPlayer != null) {
              j = paramInt + (int)(paramIMediaPlayer.offset * 100.0D / this.streamInfo.getTotalDuration());
            }
          }
          if (this.onBufferingUpdateListener != null) {
            this.onBufferingUpdateListener.onBufferingUpdate(this, j);
          }
        }
        else
        {
          i = this.currentSegment;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void onCompletion(IMediaPlayer paramIMediaPlayer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	com/tencent/oskplayer/player/SegmentMediaPlayer:isReleasing	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: iconst_3
    //   15: ldc 27
    //   17: ldc_w 510
    //   20: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 316	com/tencent/oskplayer/player/SegmentMediaPlayer:hasNext	()Z
    //   27: ifeq +293 -> 320
    //   30: aload_0
    //   31: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   34: ifnull -23 -> 11
    //   37: aload_0
    //   38: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   41: ifnull -30 -> 11
    //   44: iconst_4
    //   45: ldc 27
    //   47: ldc_w 512
    //   50: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: getfield 435	com/tencent/oskplayer/player/SegmentMediaPlayer:surfaceType	I
    //   57: ifne +198 -> 255
    //   60: iconst_3
    //   61: ldc 27
    //   63: ldc_w 514
    //   66: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   73: aconst_null
    //   74: invokevirtual 515	com/tencent/oskplayer/player/StateMediaPlayer:setDisplay	(Landroid/view/SurfaceHolder;)V
    //   77: iconst_3
    //   78: ldc 27
    //   80: ldc_w 517
    //   83: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   90: aload_0
    //   91: getfield 445	com/tencent/oskplayer/player/SegmentMediaPlayer:surfaceHolder	Landroid/view/SurfaceHolder;
    //   94: invokevirtual 515	com/tencent/oskplayer/player/StateMediaPlayer:setDisplay	(Landroid/view/SurfaceHolder;)V
    //   97: getstatic 520	com/tencent/oskplayer/player/SegmentMediaPlayer:SUPPORT_NEXT_MEDIA	Z
    //   100: ifne +30 -> 130
    //   103: ldc 27
    //   105: ldc_w 522
    //   108: invokestatic 528	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   111: pop
    //   112: aload_0
    //   113: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   116: getstatic 531	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerOperation:OP_START	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerOperation;
    //   119: invokevirtual 280	com/tencent/oskplayer/player/StateMediaPlayer:checkState	(Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerOperation;)Z
    //   122: ifne +173 -> 295
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 298	com/tencent/oskplayer/player/SegmentMediaPlayer:needStartAfterPrepared	Z
    //   130: invokestatic 371	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   133: invokevirtual 374	com/tencent/oskplayer/PlayerConfig:isDebugVersion	()Z
    //   136: ifeq +52 -> 188
    //   139: iconst_3
    //   140: ldc 27
    //   142: new 182	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 533
    //   152: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: getfield 378	com/tencent/oskplayer/player/SegmentMediaPlayer:leftVolume	F
    //   159: invokevirtual 381	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   162: ldc_w 383
    //   165: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: getfield 385	com/tencent/oskplayer/player/SegmentMediaPlayer:rightVolume	F
    //   172: invokevirtual 381	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: invokevirtual 386	java/lang/Object:toString	()Ljava/lang/String;
    //   179: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   188: aload_0
    //   189: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   192: astore_1
    //   193: aload_0
    //   194: aload_0
    //   195: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   198: putfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   201: aload_0
    //   202: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   205: iconst_1
    //   206: aload_1
    //   207: invokestatic 539	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   210: invokevirtual 542	android/os/Message:sendToTarget	()V
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 259	com/tencent/oskplayer/player/SegmentMediaPlayer:currentSegment	I
    //   218: iconst_1
    //   219: iadd
    //   220: putfield 259	com/tencent/oskplayer/player/SegmentMediaPlayer:currentSegment	I
    //   223: aload_0
    //   224: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   227: ifnull -216 -> 11
    //   230: aload_0
    //   231: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   234: iconst_0
    //   235: invokevirtual 547	android/os/Handler:removeMessages	(I)V
    //   238: aload_0
    //   239: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   242: iconst_0
    //   243: invokevirtual 551	android/os/Handler:sendEmptyMessage	(I)Z
    //   246: pop
    //   247: goto -236 -> 11
    //   250: astore_1
    //   251: aload_0
    //   252: monitorexit
    //   253: aload_1
    //   254: athrow
    //   255: iconst_3
    //   256: ldc 27
    //   258: ldc_w 553
    //   261: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   264: aload_0
    //   265: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   268: aconst_null
    //   269: invokevirtual 554	com/tencent/oskplayer/player/StateMediaPlayer:setSurface	(Landroid/view/Surface;)V
    //   272: iconst_3
    //   273: ldc 27
    //   275: ldc_w 556
    //   278: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   285: aload_0
    //   286: getfield 447	com/tencent/oskplayer/player/SegmentMediaPlayer:surface	Landroid/view/Surface;
    //   289: invokevirtual 554	com/tencent/oskplayer/player/StateMediaPlayer:setSurface	(Landroid/view/Surface;)V
    //   292: goto -195 -> 97
    //   295: aload_0
    //   296: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   299: invokevirtual 557	com/tencent/oskplayer/player/StateMediaPlayer:start	()V
    //   302: goto -172 -> 130
    //   305: astore_1
    //   306: bipush 6
    //   308: ldc 27
    //   310: aload_1
    //   311: invokevirtual 558	tv/danmaku/ijk/media/player/IMediaPlayer$InternalOperationException:toString	()Ljava/lang/String;
    //   314: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   317: goto -187 -> 130
    //   320: aload_0
    //   321: getfield 395	com/tencent/oskplayer/player/SegmentMediaPlayer:isAllowLooping	Z
    //   324: ifeq +61 -> 385
    //   327: aload_0
    //   328: getfield 493	com/tencent/oskplayer/player/SegmentMediaPlayer:isLooping	Z
    //   331: ifeq +54 -> 385
    //   334: aload_0
    //   335: getfield 145	com/tencent/oskplayer/player/SegmentMediaPlayer:isReleasing	Z
    //   338: ifne -327 -> 11
    //   341: aload_0
    //   342: lconst_0
    //   343: invokevirtual 559	com/tencent/oskplayer/player/SegmentMediaPlayer:seekTo	(J)V
    //   346: aload_0
    //   347: invokevirtual 560	com/tencent/oskplayer/player/SegmentMediaPlayer:start	()V
    //   350: aload_0
    //   351: getfield 562	com/tencent/oskplayer/player/SegmentMediaPlayer:onLoopStartListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnLoopStartListener;
    //   354: ifnull -343 -> 11
    //   357: aload_0
    //   358: getfield 562	com/tencent/oskplayer/player/SegmentMediaPlayer:onLoopStartListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnLoopStartListener;
    //   361: aload_0
    //   362: invokeinterface 567 2 0
    //   367: goto -356 -> 11
    //   370: astore_1
    //   371: bipush 6
    //   373: ldc 27
    //   375: aload_1
    //   376: invokevirtual 558	tv/danmaku/ijk/media/player/IMediaPlayer$InternalOperationException:toString	()Ljava/lang/String;
    //   379: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   382: goto -371 -> 11
    //   385: iconst_3
    //   386: ldc 27
    //   388: ldc_w 569
    //   391: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   394: aload_0
    //   395: getfield 571	com/tencent/oskplayer/player/SegmentMediaPlayer:onCompletionListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;
    //   398: ifnull -387 -> 11
    //   401: aload_0
    //   402: getfield 571	com/tencent/oskplayer/player/SegmentMediaPlayer:onCompletionListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;
    //   405: aload_0
    //   406: invokeinterface 573 2 0
    //   411: goto -400 -> 11
    //   414: astore_1
    //   415: goto -202 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	SegmentMediaPlayer
    //   0	418	1	paramIMediaPlayer	IMediaPlayer
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	250	finally
    //   14	97	250	finally
    //   97	130	250	finally
    //   130	188	250	finally
    //   188	201	250	finally
    //   201	213	250	finally
    //   213	247	250	finally
    //   255	292	250	finally
    //   295	302	250	finally
    //   306	317	250	finally
    //   320	346	250	finally
    //   346	367	250	finally
    //   371	382	250	finally
    //   385	411	250	finally
    //   295	302	305	tv/danmaku/ijk/media/player/IMediaPlayer$InternalOperationException
    //   346	367	370	tv/danmaku/ijk/media/player/IMediaPlayer$InternalOperationException
    //   201	213	414	java/lang/Exception
  }
  
  /* Error */
  public boolean onError(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 145	com/tencent/oskplayer/player/SegmentMediaPlayer:isReleasing	Z
    //   9: istore 5
    //   11: iload 5
    //   13: ifeq +8 -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 4
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   25: ifnull +82 -> 107
    //   28: new 182	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 577
    //   38: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_2
    //   42: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: ldc_w 579
    //   48: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_3
    //   52: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc_w 581
    //   58: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 259	com/tencent/oskplayer/player/SegmentMediaPlayer:currentSegment	I
    //   65: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc_w 583
    //   71: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: astore 6
    //   76: aload_1
    //   77: aload_0
    //   78: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   81: invokevirtual 500	com/tencent/oskplayer/player/StateMediaPlayer:getInternalMediaPlayer	()Ltv/danmaku/ijk/media/player/IMediaPlayer;
    //   84: if_acmpne +47 -> 131
    //   87: ldc_w 584
    //   90: astore_1
    //   91: bipush 6
    //   93: ldc 27
    //   95: aload 6
    //   97: aload_1
    //   98: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield 586	com/tencent/oskplayer/player/SegmentMediaPlayer:onErrorListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;
    //   111: ifnull -95 -> 16
    //   114: aload_0
    //   115: getfield 586	com/tencent/oskplayer/player/SegmentMediaPlayer:onErrorListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;
    //   118: aload_0
    //   119: iload_2
    //   120: iload_3
    //   121: invokeinterface 588 4 0
    //   126: istore 4
    //   128: goto -112 -> 16
    //   131: ldc_w 589
    //   134: astore_1
    //   135: goto -44 -> 91
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	SegmentMediaPlayer
    //   0	143	1	paramIMediaPlayer	IMediaPlayer
    //   0	143	2	paramInt1	int
    //   0	143	3	paramInt2	int
    //   1	126	4	bool1	boolean
    //   9	3	5	bool2	boolean
    //   74	22	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	11	138	finally
    //   21	87	138	finally
    //   91	107	138	finally
    //   107	128	138	finally
  }
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.isReleasing;
        if (bool) {
          return true;
        }
        if (paramIMediaPlayer == null) {
          continue;
        }
        if ((!PlayerConfig.g().isDebugVersion()) || (this.currentPlayer == null)) {
          break label152;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("onInfo what=").append(paramInt1).append(" extra=").append(paramInt2).append(" mp==");
        if (paramIMediaPlayer != this.currentPlayer.getInternalMediaPlayer()) {
          break label133;
        }
        paramIMediaPlayer = "currentPlayer";
        PlayerUtils.log(3, "SegmentMediaPlayer", paramIMediaPlayer);
      }
      finally {}
      if (this.onInfoListener != null)
      {
        this.onInfoListener.onInfo(this, paramInt1, paramInt2);
        continue;
        label133:
        paramIMediaPlayer = "nextPlayer";
        continue;
        PlayerUtils.log(4, "SegmentMediaPlayer", "--------------- mediaplayer start rendering -----------------");
        continue;
        label152:
        switch (paramInt1)
        {
        }
      }
    }
  }
  
  /* Error */
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	com/tencent/oskplayer/player/SegmentMediaPlayer:isReleasing	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: aload_0
    //   16: getfield 97	com/tencent/oskplayer/player/SegmentMediaPlayer:screenOnWhilePlaying	Z
    //   19: invokeinterface 600 2 0
    //   24: aload_0
    //   25: getfield 395	com/tencent/oskplayer/player/SegmentMediaPlayer:isAllowLooping	Z
    //   28: ifeq +10 -> 38
    //   31: aload_1
    //   32: iconst_0
    //   33: invokeinterface 601 2 0
    //   38: aload_1
    //   39: aload_0
    //   40: getfield 378	com/tencent/oskplayer/player/SegmentMediaPlayer:leftVolume	F
    //   43: aload_0
    //   44: getfield 385	com/tencent/oskplayer/player/SegmentMediaPlayer:rightVolume	F
    //   47: invokeinterface 602 3 0
    //   52: aload_0
    //   53: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   56: ifnull +353 -> 409
    //   59: aload_1
    //   60: aload_0
    //   61: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   64: invokevirtual 500	com/tencent/oskplayer/player/StateMediaPlayer:getInternalMediaPlayer	()Ltv/danmaku/ijk/media/player/IMediaPlayer;
    //   67: if_acmpne +342 -> 409
    //   70: iconst_3
    //   71: ldc 27
    //   73: new 182	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 604
    //   83: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: getfield 259	com/tencent/oskplayer/player/SegmentMediaPlayer:currentSegment	I
    //   90: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: ldc_w 606
    //   96: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 296	com/tencent/oskplayer/player/SegmentMediaPlayer:seekAfterPrepared	J
    //   103: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   106: ldc_w 608
    //   109: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 298	com/tencent/oskplayer/player/SegmentMediaPlayer:needStartAfterPrepared	Z
    //   116: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   119: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield 217	com/tencent/oskplayer/player/SegmentMediaPlayer:streamInfo	Lcom/tencent/oskplayer/model/SegmentVideoInfo$StreamInfo;
    //   129: ifnull +108 -> 237
    //   132: aload_0
    //   133: getfield 217	com/tencent/oskplayer/player/SegmentMediaPlayer:streamInfo	Lcom/tencent/oskplayer/model/SegmentVideoInfo$StreamInfo;
    //   136: aload_0
    //   137: getfield 259	com/tencent/oskplayer/player/SegmentMediaPlayer:currentSegment	I
    //   140: invokevirtual 320	com/tencent/oskplayer/model/SegmentVideoInfo$StreamInfo:getSegment	(I)Lcom/tencent/oskplayer/model/SegmentVideoInfo$SegmentInfo;
    //   143: astore 4
    //   145: aload 4
    //   147: ifnull +90 -> 237
    //   150: aload_1
    //   151: invokeinterface 610 1 0
    //   156: l2i
    //   157: istore_2
    //   158: iload_2
    //   159: ifle +78 -> 237
    //   162: aload 4
    //   164: getfield 457	com/tencent/oskplayer/model/SegmentVideoInfo$SegmentInfo:duration	I
    //   167: iload_2
    //   168: if_icmpeq +69 -> 237
    //   171: iconst_2
    //   172: ldc 27
    //   174: new 182	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 612
    //   184: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: getfield 259	com/tencent/oskplayer/player/SegmentMediaPlayer:currentSegment	I
    //   191: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc_w 614
    //   197: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 4
    //   202: getfield 457	com/tencent/oskplayer/model/SegmentVideoInfo$SegmentInfo:duration	I
    //   205: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: ldc_w 616
    //   211: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_2
    //   215: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   224: aload 4
    //   226: iload_2
    //   227: putfield 457	com/tencent/oskplayer/model/SegmentVideoInfo$SegmentInfo:duration	I
    //   230: aload_0
    //   231: getfield 217	com/tencent/oskplayer/player/SegmentMediaPlayer:streamInfo	Lcom/tencent/oskplayer/model/SegmentVideoInfo$StreamInfo;
    //   234: invokevirtual 619	com/tencent/oskplayer/model/SegmentVideoInfo$StreamInfo:updateDuration	()V
    //   237: aload_0
    //   238: getfield 298	com/tencent/oskplayer/player/SegmentMediaPlayer:needStartAfterPrepared	Z
    //   241: istore_3
    //   242: iload_3
    //   243: ifeq +113 -> 356
    //   246: aload_1
    //   247: invokeinterface 620 1 0
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 298	com/tencent/oskplayer/player/SegmentMediaPlayer:needStartAfterPrepared	Z
    //   257: aload_0
    //   258: getfield 285	com/tencent/oskplayer/player/SegmentMediaPlayer:isSeeking	Z
    //   261: istore_3
    //   262: aload_0
    //   263: getfield 296	com/tencent/oskplayer/player/SegmentMediaPlayer:seekAfterPrepared	J
    //   266: lconst_0
    //   267: lcmp
    //   268: ifeq +109 -> 377
    //   271: aload_1
    //   272: aload_0
    //   273: getfield 296	com/tencent/oskplayer/player/SegmentMediaPlayer:seekAfterPrepared	J
    //   276: invokeinterface 621 3 0
    //   281: aload_0
    //   282: lconst_0
    //   283: putfield 296	com/tencent/oskplayer/player/SegmentMediaPlayer:seekAfterPrepared	J
    //   286: aload_0
    //   287: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   290: ifnull +20 -> 310
    //   293: aload_0
    //   294: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   297: iconst_0
    //   298: invokevirtual 547	android/os/Handler:removeMessages	(I)V
    //   301: aload_0
    //   302: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   305: iconst_0
    //   306: invokevirtual 551	android/os/Handler:sendEmptyMessage	(I)Z
    //   309: pop
    //   310: aload_0
    //   311: getfield 623	com/tencent/oskplayer/player/SegmentMediaPlayer:onPreparedListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;
    //   314: ifnull -303 -> 11
    //   317: iload_3
    //   318: ifne -307 -> 11
    //   321: aload_0
    //   322: getfield 623	com/tencent/oskplayer/player/SegmentMediaPlayer:onPreparedListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;
    //   325: aload_0
    //   326: invokeinterface 625 2 0
    //   331: goto -320 -> 11
    //   334: astore_1
    //   335: aload_0
    //   336: monitorexit
    //   337: aload_1
    //   338: athrow
    //   339: astore 4
    //   341: bipush 6
    //   343: ldc 27
    //   345: aload 4
    //   347: invokevirtual 558	tv/danmaku/ijk/media/player/IMediaPlayer$InternalOperationException:toString	()Ljava/lang/String;
    //   350: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   353: goto -101 -> 252
    //   356: aload_0
    //   357: getfield 99	com/tencent/oskplayer/player/SegmentMediaPlayer:needStopAfterPrepared	Z
    //   360: ifeq -103 -> 257
    //   363: aload_1
    //   364: invokeinterface 628 1 0
    //   369: aload_0
    //   370: iconst_0
    //   371: putfield 99	com/tencent/oskplayer/player/SegmentMediaPlayer:needStopAfterPrepared	Z
    //   374: goto -117 -> 257
    //   377: aload_0
    //   378: getfield 285	com/tencent/oskplayer/player/SegmentMediaPlayer:isSeeking	Z
    //   381: ifeq -95 -> 286
    //   384: aload_0
    //   385: iconst_0
    //   386: putfield 285	com/tencent/oskplayer/player/SegmentMediaPlayer:isSeeking	Z
    //   389: aload_0
    //   390: getfield 630	com/tencent/oskplayer/player/SegmentMediaPlayer:onSeekCompleteListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;
    //   393: ifnull -107 -> 286
    //   396: aload_0
    //   397: getfield 630	com/tencent/oskplayer/player/SegmentMediaPlayer:onSeekCompleteListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;
    //   400: aload_0
    //   401: invokeinterface 633 2 0
    //   406: goto -120 -> 286
    //   409: aload_0
    //   410: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   413: ifnull -402 -> 11
    //   416: aload_1
    //   417: aload_0
    //   418: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   421: invokevirtual 500	com/tencent/oskplayer/player/StateMediaPlayer:getInternalMediaPlayer	()Ltv/danmaku/ijk/media/player/IMediaPlayer;
    //   424: if_acmpne -413 -> 11
    //   427: iconst_3
    //   428: ldc 27
    //   430: ldc_w 635
    //   433: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   436: getstatic 520	com/tencent/oskplayer/player/SegmentMediaPlayer:SUPPORT_NEXT_MEDIA	Z
    //   439: ifeq +35 -> 474
    //   442: aload_0
    //   443: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   446: astore_1
    //   447: aload_1
    //   448: ifnull +26 -> 474
    //   451: iconst_3
    //   452: ldc 27
    //   454: ldc_w 637
    //   457: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   460: aload_0
    //   461: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   464: aload_0
    //   465: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   468: invokevirtual 500	com/tencent/oskplayer/player/StateMediaPlayer:getInternalMediaPlayer	()Ltv/danmaku/ijk/media/player/IMediaPlayer;
    //   471: invokevirtual 639	com/tencent/oskplayer/player/StateMediaPlayer:setNextMediaPlayer	(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V
    //   474: invokestatic 371	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   477: invokevirtual 374	com/tencent/oskplayer/PlayerConfig:isDebugVersion	()Z
    //   480: ifeq +52 -> 532
    //   483: iconst_3
    //   484: ldc 27
    //   486: new 182	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 641
    //   496: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_0
    //   500: getfield 378	com/tencent/oskplayer/player/SegmentMediaPlayer:leftVolume	F
    //   503: invokevirtual 381	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   506: ldc_w 383
    //   509: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_0
    //   513: getfield 385	com/tencent/oskplayer/player/SegmentMediaPlayer:rightVolume	F
    //   516: invokevirtual 381	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   519: aload_0
    //   520: invokevirtual 386	java/lang/Object:toString	()Ljava/lang/String;
    //   523: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   532: aload_0
    //   533: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   536: aload_0
    //   537: getfield 378	com/tencent/oskplayer/player/SegmentMediaPlayer:leftVolume	F
    //   540: aload_0
    //   541: getfield 385	com/tencent/oskplayer/player/SegmentMediaPlayer:rightVolume	F
    //   544: invokevirtual 390	com/tencent/oskplayer/player/StateMediaPlayer:setVolume	(FF)V
    //   547: aload_0
    //   548: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   551: aload_0
    //   552: getfield 97	com/tencent/oskplayer/player/SegmentMediaPlayer:screenOnWhilePlaying	Z
    //   555: invokevirtual 393	com/tencent/oskplayer/player/StateMediaPlayer:setScreenOnWhilePlaying	(Z)V
    //   558: aload_0
    //   559: getfield 395	com/tencent/oskplayer/player/SegmentMediaPlayer:isAllowLooping	Z
    //   562: ifeq -551 -> 11
    //   565: aload_0
    //   566: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   569: iconst_0
    //   570: invokevirtual 398	com/tencent/oskplayer/player/StateMediaPlayer:setLooping	(Z)V
    //   573: goto -562 -> 11
    //   576: astore_1
    //   577: bipush 6
    //   579: ldc 27
    //   581: new 182	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 643
    //   591: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_1
    //   595: invokevirtual 646	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   604: aload_0
    //   605: getfield 586	com/tencent/oskplayer/player/SegmentMediaPlayer:onErrorListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;
    //   608: ifnull -134 -> 474
    //   611: aload_0
    //   612: getfield 586	com/tencent/oskplayer/player/SegmentMediaPlayer:onErrorListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;
    //   615: aload_0
    //   616: sipush 20001
    //   619: iconst_0
    //   620: invokeinterface 588 4 0
    //   625: pop
    //   626: goto -152 -> 474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	this	SegmentMediaPlayer
    //   0	629	1	paramIMediaPlayer	IMediaPlayer
    //   157	70	2	i	int
    //   6	312	3	bool	boolean
    //   143	82	4	localSegmentInfo	SegmentVideoInfo.SegmentInfo
    //   339	7	4	localInternalOperationException	IMediaPlayer.InternalOperationException
    // Exception table:
    //   from	to	target	type
    //   2	7	334	finally
    //   14	38	334	finally
    //   38	145	334	finally
    //   150	158	334	finally
    //   162	237	334	finally
    //   237	242	334	finally
    //   246	252	334	finally
    //   252	257	334	finally
    //   257	286	334	finally
    //   286	310	334	finally
    //   310	317	334	finally
    //   321	331	334	finally
    //   341	353	334	finally
    //   356	374	334	finally
    //   377	406	334	finally
    //   409	447	334	finally
    //   451	474	334	finally
    //   474	532	334	finally
    //   532	573	334	finally
    //   577	626	334	finally
    //   246	252	339	tv/danmaku/ijk/media/player/IMediaPlayer$InternalOperationException
    //   451	474	576	java/lang/Exception
  }
  
  /* Error */
  public void onSeekComplete(IMediaPlayer paramIMediaPlayer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	com/tencent/oskplayer/player/SegmentMediaPlayer:isReleasing	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: iconst_3
    //   15: ldc 27
    //   17: ldc_w 648
    //   20: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 285	com/tencent/oskplayer/player/SegmentMediaPlayer:isSeeking	Z
    //   28: aload_0
    //   29: getfield 630	com/tencent/oskplayer/player/SegmentMediaPlayer:onSeekCompleteListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;
    //   32: ifnull -21 -> 11
    //   35: aload_0
    //   36: getfield 630	com/tencent/oskplayer/player/SegmentMediaPlayer:onSeekCompleteListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;
    //   39: aload_0
    //   40: invokeinterface 633 2 0
    //   45: goto -34 -> 11
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	SegmentMediaPlayer
    //   0	53	1	paramIMediaPlayer	IMediaPlayer
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	48	finally
    //   14	45	48	finally
  }
  
  /* Error */
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	com/tencent/oskplayer/player/SegmentMediaPlayer:isReleasing	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 652	com/tencent/oskplayer/player/SegmentMediaPlayer:onVideoSizeChangedListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;
    //   20: ifnull -7 -> 13
    //   23: aload_0
    //   24: getfield 652	com/tencent/oskplayer/player/SegmentMediaPlayer:onVideoSizeChangedListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;
    //   27: aload_0
    //   28: iload_2
    //   29: iload_3
    //   30: invokeinterface 654 4 0
    //   35: goto -22 -> 13
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	SegmentMediaPlayer
    //   0	43	1	paramIMediaPlayer	IMediaPlayer
    //   0	43	2	paramInt1	int
    //   0	43	3	paramInt2	int
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	38	finally
    //   16	35	38	finally
  }
  
  public void pause()
  {
    if (this.currentPlayer != null) {
      if (!this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_PAUSE)) {
        throw new IMediaPlayer.InternalOperationException("pause failed, current media state = " + this.currentPlayer.getMediaPlayerState());
      }
    }
    try
    {
      this.currentPlayer.pause();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      PlayerUtils.log(6, "SegmentMediaPlayer", "pause error: " + PlayerUtils.getPrintableStackTrace(localIllegalStateException));
    }
  }
  
  public void prepareAsync()
  {
    if (this.currentPlayer != null) {
      this.currentPlayer.prepareAsync();
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 145	com/tencent/oskplayer/player/SegmentMediaPlayer:isReleasing	Z
    //   7: aload_0
    //   8: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   11: ifnull +27 -> 38
    //   14: aload_0
    //   15: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   18: iconst_0
    //   19: invokevirtual 547	android/os/Handler:removeMessages	(I)V
    //   22: aload_0
    //   23: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   26: iconst_2
    //   27: invokevirtual 547	android/os/Handler:removeMessages	(I)V
    //   30: aload_0
    //   31: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   34: iconst_1
    //   35: invokevirtual 547	android/os/Handler:removeMessages	(I)V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   43: aload_0
    //   44: getfield 127	com/tencent/oskplayer/player/SegmentMediaPlayer:segmentPlayerThread	Landroid/os/HandlerThread;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +16 -> 65
    //   52: aload_0
    //   53: getfield 127	com/tencent/oskplayer/player/SegmentMediaPlayer:segmentPlayerThread	Landroid/os/HandlerThread;
    //   56: invokevirtual 673	android/os/HandlerThread:quit	()Z
    //   59: pop
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 127	com/tencent/oskplayer/player/SegmentMediaPlayer:segmentPlayerThread	Landroid/os/HandlerThread;
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 623	com/tencent/oskplayer/player/SegmentMediaPlayer:onPreparedListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield 571	com/tencent/oskplayer/player/SegmentMediaPlayer:onCompletionListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 504	com/tencent/oskplayer/player/SegmentMediaPlayer:onBufferingUpdateListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 652	com/tencent/oskplayer/player/SegmentMediaPlayer:onVideoSizeChangedListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 630	com/tencent/oskplayer/player/SegmentMediaPlayer:onSeekCompleteListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;
    //   90: aload_0
    //   91: aconst_null
    //   92: putfield 594	com/tencent/oskplayer/player/SegmentMediaPlayer:onInfoListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;
    //   95: aload_0
    //   96: invokespecial 404	com/tencent/oskplayer/player/SegmentMediaPlayer:doRelease	()V
    //   99: aload_0
    //   100: monitorexit
    //   101: return
    //   102: astore_1
    //   103: iconst_5
    //   104: ldc 27
    //   106: ldc_w 675
    //   109: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   112: goto -47 -> 65
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	SegmentMediaPlayer
    //   47	2	1	localHandlerThread	HandlerThread
    //   102	1	1	localException	Exception
    //   115	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	65	102	java/lang/Exception
    //   2	38	115	finally
    //   38	48	115	finally
    //   52	65	115	finally
    //   65	99	115	finally
    //   103	112	115	finally
  }
  
  public void reset()
  {
    if (this.currentPlayer != null)
    {
      PlayerUtils.log(4, "SegmentMediaPlayer", "currentPlayer is reset");
      if (!this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RESET)) {
        break label73;
      }
      this.currentPlayer.reset();
    }
    for (;;)
    {
      if (this.nextPlayer != null)
      {
        PlayerUtils.log(4, "SegmentMediaPlayer", "nextPlayer is reset");
        if (!this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RESET)) {
          break;
        }
        this.nextPlayer.reset();
      }
      return;
      label73:
      if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RELEASE)) {
        this.currentPlayer.release();
      }
      this.currentPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
      this.currentPlayer.setMode(this.mPlayMode);
    }
    if (this.nextPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RELEASE)) {
      this.nextPlayer.release();
    }
    this.nextPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
    this.nextPlayer.setMode(this.mPlayMode);
  }
  
  /* Error */
  public void seekTo(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: iconst_4
    //   15: ldc 27
    //   17: new 182	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 690
    //   27: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: lload_1
    //   31: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   34: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   44: iconst_2
    //   45: invokevirtual 547	android/os/Handler:removeMessages	(I)V
    //   48: aload_0
    //   49: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   52: aload_0
    //   53: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   56: iconst_2
    //   57: lload_1
    //   58: invokestatic 696	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: invokevirtual 700	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   64: invokevirtual 704	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   67: pop
    //   68: goto -57 -> 11
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	SegmentMediaPlayer
    //   0	76	1	paramLong	long
    //   6	2	3	localHandler	Handler
    //   71	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	71	finally
    //   14	68	71	finally
  }
  
  public void setAudioStreamType(int paramInt)
  {
    if (this.currentPlayer != null) {
      this.currentPlayer.setAudioStreamType(paramInt);
    }
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo)
  {
    setDataSource(paramStreamInfo, 0);
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo, int paramInt)
  {
    this.streamInfo = paramStreamInfo;
    this.currentSegment = 0;
    this.totalSegment = 0;
    this.seekAfterPrepared = 0L;
    if (paramStreamInfo != null)
    {
      this.currentSegment = paramStreamInfo.getSegmentIndex(paramInt);
      if (this.currentSegment < 0)
      {
        this.currentSegment = 0;
        throw new IOException("invalid segment index");
      }
      this.totalSegment = paramStreamInfo.getCount();
      paramStreamInfo = paramStreamInfo.segmentInfos;
      this.sourceUrls = new ArrayList();
      if (paramStreamInfo != null)
      {
        paramStreamInfo = paramStreamInfo.iterator();
        while (paramStreamInfo.hasNext())
        {
          SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)paramStreamInfo.next();
          this.sourceUrls.add(localSegmentInfo.url);
        }
      }
      this.proxyUrls = VideoManager.getInstance().getUrl(this.sourceUrls);
      init(false);
    }
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setDataSource(String paramString)
  {
    setDataSource(new SegmentVideoInfo.StreamInfo(paramString, 0));
  }
  
  public void setDataSource(IMediaDataSource paramIMediaDataSource)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    this.surfaceType = 0;
    this.surfaceHolder = paramSurfaceHolder;
    this.surface = null;
    if (this.currentPlayer != null) {
      this.currentPlayer.setDisplay(this.surfaceHolder);
    }
  }
  
  public void setKeepInBackground(boolean paramBoolean) {}
  
  public void setLogEnabled(boolean paramBoolean) {}
  
  public void setLooping(boolean paramBoolean)
  {
    this.isLooping = paramBoolean;
  }
  
  public void setNextMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    throw new UnsupportedOperationException("setNextMediaPlayer is not supported");
  }
  
  public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.onBufferingUpdateListener = paramOnBufferingUpdateListener;
  }
  
  public void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.onCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.onErrorListener = paramOnErrorListener;
  }
  
  public void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.onInfoListener = paramOnInfoListener;
  }
  
  public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener paramOnLoopStartListener)
  {
    this.onLoopStartListener = paramOnLoopStartListener;
  }
  
  public void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.onPreparedListener = paramOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.onSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener paramOnTimedTextListener)
  {
    if (this.currentPlayer != null) {
      this.currentPlayer.setOnTimedTextListener(paramOnTimedTextListener);
    }
  }
  
  public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.onVideoSizeChangedListener = paramOnVideoSizeChangedListener;
  }
  
  void setPlayMode(int paramInt)
  {
    this.mPlayMode = paramInt;
    if (this.currentPlayer != null) {
      this.currentPlayer.setMode(this.mPlayMode);
    }
    if (this.nextPlayer != null) {
      this.nextPlayer.setMode(this.mPlayMode);
    }
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    this.screenOnWhilePlaying = paramBoolean;
  }
  
  public void setSeekParameters(SeekParameters paramSeekParameters)
  {
    DebugLog.w("SegmentMediaPlayer", "setSeekParameters is not supported");
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.surfaceType = 1;
    this.surfaceHolder = null;
    this.surface = paramSurface;
    if (this.currentPlayer != null)
    {
      PlayerUtils.log(4, "SegmentMediaPlayer", "setSurface " + this);
      this.currentPlayer.setSurface(paramSurface);
    }
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.leftVolume = paramFloat1;
    this.rightVolume = paramFloat2;
    if (this.currentPlayer != null) {
      if (PlayerConfig.g().isDebugVersion()) {
        PlayerUtils.log(3, "SegmentMediaPlayer", "set current setVolume, leftVolume=" + paramFloat1 + " rightVolume=" + paramFloat2 + toString());
      }
    }
    try
    {
      if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETVOLUME)) {
        this.currentPlayer.setVolume(paramFloat1, paramFloat2);
      }
      if (this.nextPlayer != null) {
        if (PlayerConfig.g().isDebugVersion()) {
          PlayerUtils.log(3, "SegmentMediaPlayer", "set next setVolume, leftVolume=" + paramFloat1 + " rightVolume=" + paramFloat2 + toString());
        }
      }
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      for (;;)
      {
        try
        {
          if (this.nextPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETVOLUME)) {
            this.nextPlayer.setVolume(paramFloat1, paramFloat2);
          }
          return;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          PlayerUtils.log(6, "SegmentMediaPlayer", "cant set volume to " + paramFloat1 + "," + paramFloat2 + localIllegalStateException2);
        }
        localIllegalStateException1 = localIllegalStateException1;
        PlayerUtils.log(6, "SegmentMediaPlayer", "cant set volume to " + paramFloat1 + "," + paramFloat2 + localIllegalStateException1);
      }
    }
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.context = paramContext;
    this.wakeMode = paramInt;
    if (this.currentPlayer != null) {
      this.currentPlayer.setWakeMode(paramContext, paramInt);
    }
  }
  
  public void start()
  {
    if (this.currentPlayer != null) {
      if (!this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_START)) {
        throw new IMediaPlayer.InternalOperationException("start failed, current media state = " + this.currentPlayer.getMediaPlayerState());
      }
    }
    try
    {
      this.currentPlayer.start();
      this.needStopAfterPrepared = false;
      return;
    }
    catch (Exception localException)
    {
      PlayerUtils.log(6, "SegmentMediaPlayer", "start error: " + PlayerUtils.getPrintableStackTrace(localException));
    }
  }
  
  public void stop()
  {
    if (!this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_STOP))
    {
      PlayerUtils.log(5, "SegmentMediaPlayer", "stop failed cause of state illegal");
      this.needStopAfterPrepared = true;
    }
    while (this.currentPlayer == null) {
      return;
    }
    this.currentPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.player.SegmentMediaPlayer
 * JD-Core Version:    0.7.0.1
 */