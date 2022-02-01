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
  
  /* Error */
  private void doRelease()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   6: ifnull +23 -> 29
    //   9: iconst_4
    //   10: ldc 27
    //   12: ldc 167
    //   14: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   21: invokevirtual 176	com/tencent/oskplayer/player/StateMediaPlayer:release	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   29: aload_0
    //   30: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   33: ifnull +65 -> 98
    //   36: iconst_4
    //   37: ldc 27
    //   39: ldc 180
    //   41: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   48: invokevirtual 176	com/tencent/oskplayer/player/StateMediaPlayer:release	()V
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   56: goto +42 -> 98
    //   59: astore_1
    //   60: goto +41 -> 101
    //   63: astore_1
    //   64: new 182	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   71: astore_2
    //   72: aload_2
    //   73: ldc 185
    //   75: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_2
    //   80: aload_1
    //   81: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: iconst_5
    //   89: ldc 27
    //   91: aload_2
    //   92: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	SegmentMediaPlayer
    //   59	1	1	localObject	Object
    //   63	41	1	localException	Exception
    //   71	21	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	29	59	finally
    //   29	56	59	finally
    //   64	98	59	finally
    //   2	29	63	java/lang/Exception
    //   29	56	63	java/lang/Exception
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
    Object localObject1 = this.streamInfo;
    if (localObject1 != null)
    {
      if (((SegmentVideoInfo.StreamInfo)localObject1).segmentInfos == null) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("seekTo position=");
      ((StringBuilder)localObject1).append(paramLong);
      PlayerUtils.log(4, "SegmentMediaPlayer", ((StringBuilder)localObject1).toString());
      int j = this.streamInfo.getSegmentIndex(paramLong);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("seekTo segment index=");
      ((StringBuilder)localObject1).append(j);
      PlayerUtils.log(4, "SegmentMediaPlayer", ((StringBuilder)localObject1).toString());
      boolean bool2 = false;
      int i = j;
      if (j < 0)
      {
        PlayerUtils.log(5, "SegmentMediaPlayer", "seekTo position out of bound! seek to 0");
        paramLong = 0L;
        i = 0;
      }
      localObject1 = (SegmentVideoInfo.SegmentInfo)this.streamInfo.segmentInfos.get(i);
      if (localObject1 == null) {
        return;
      }
      long l = paramLong - ((SegmentVideoInfo.SegmentInfo)localObject1).offset;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("seekTo segment realPosition=");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(" url=");
      ((StringBuilder)localObject2).append(((SegmentVideoInfo.SegmentInfo)localObject1).url);
      PlayerUtils.log(4, "SegmentMediaPlayer", ((StringBuilder)localObject2).toString());
      if (i == this.currentSegment)
      {
        if (this.currentPlayer != null)
        {
          PlayerUtils.log(4, "SegmentMediaPlayer", "seekTo currentPlayer");
          try
          {
            this.currentPlayer.seekTo(l);
            return;
          }
          catch (Exception localException)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("seekTo exception: ");
            ((StringBuilder)localObject2).append(PlayerUtils.getPrintableStackTrace(localException));
            PlayerUtils.log(5, "SegmentMediaPlayer", ((StringBuilder)localObject2).toString());
          }
        }
        return;
      }
      boolean bool1 = bool2;
      if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_ISPLAYING))
      {
        localObject2 = this.currentPlayer;
        if ((localObject2 == null) || (!((StateMediaPlayer)localObject2).isPlaying()))
        {
          bool1 = bool2;
          if (!this.isSeeking) {}
        }
        else
        {
          bool1 = true;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("currentPlayer isPlaying=");
      ((StringBuilder)localObject2).append(bool1);
      PlayerUtils.log(4, "SegmentMediaPlayer", ((StringBuilder)localObject2).toString());
      this.currentSegment = i;
      try
      {
        init(true);
        if (this.currentPlayer != null)
        {
          this.seekAfterPrepared = l;
          this.needStartAfterPrepared = bool1;
          this.isSeeking = true;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("prepare currentPlayer. realPosition=");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append(" url=");
          ((StringBuilder)localObject2).append(localException.url);
          PlayerUtils.log(4, "SegmentMediaPlayer", ((StringBuilder)localObject2).toString());
          this.currentPlayer.prepareAsync();
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("failed. IllegalStateException when seeking to segment=");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" position=");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append(" exception=");
        ((StringBuilder)localObject2).append(PlayerUtils.getPrintableStackTrace(localIllegalStateException));
        PlayerUtils.log(6, "SegmentMediaPlayer", ((StringBuilder)localObject2).toString());
        return;
      }
      catch (IOException localIOException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("failed seeking to segment=");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" position=");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append(" exception:");
        ((StringBuilder)localObject2).append(PlayerUtils.getPrintableStackTrace(localIOException));
        PlayerUtils.log(6, "SegmentMediaPlayer", ((StringBuilder)localObject2).toString());
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
        Object localObject1 = this.streamInfo.getSegment(this.currentSegment + 1);
        if (localObject1 == null) {
          return;
        }
        PlayerUtils.log(4, "SegmentMediaPlayer", "init next mediaplayer");
        this.nextPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
        this.nextPlayer.setMode(this.mPlayMode);
        localObject2 = (String)this.proxyUrls.get(this.currentSegment + 1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setup next mediaplayer url=");
        localStringBuilder.append(((SegmentVideoInfo.SegmentInfo)localObject1).url);
        localStringBuilder.append(" proxyurl=");
        localStringBuilder.append((String)localObject2);
        PlayerUtils.log(4, "SegmentMediaPlayer", localStringBuilder.toString());
        this.nextPlayer.setDataSource((String)localObject2);
        this.nextPlayer.setOnPreparedListener(this);
        this.nextPlayer.setOnInfoListener(this);
        this.nextPlayer.setOnCompletionListener(this);
        this.nextPlayer.setOnBufferingUpdateListener(this);
        this.nextPlayer.setOnErrorListener(this);
        if (this.context != null) {
          this.nextPlayer.setWakeMode(this.context, this.wakeMode);
        }
        if (PlayerConfig.g().isDebugVersion())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("nextPlayer setVolume, leftVolume=");
          ((StringBuilder)localObject1).append(this.leftVolume);
          ((StringBuilder)localObject1).append(" rightVolume=");
          ((StringBuilder)localObject1).append(this.rightVolume);
          ((StringBuilder)localObject1).append(toString());
          PlayerUtils.log(3, "SegmentMediaPlayer", ((StringBuilder)localObject1).toString());
        }
        this.nextPlayer.setVolume(this.leftVolume, this.rightVolume);
        this.nextPlayer.setScreenOnWhilePlaying(this.screenOnWhilePlaying);
        if (this.isAllowLooping) {
          this.nextPlayer.setLooping(false);
        }
        this.nextPlayer.prepareAsync();
        return;
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setup next mediaplayer error. exception:");
        ((StringBuilder)localObject2).append(PlayerUtils.getPrintableStackTrace(localException));
        PlayerUtils.log(6, "SegmentMediaPlayer", ((StringBuilder)localObject2).toString());
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
    try
    {
      doRelease();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("init: currentSegment=");
      ((StringBuilder)localObject1).append(this.currentSegment);
      PlayerUtils.log(4, "SegmentMediaPlayer", ((StringBuilder)localObject1).toString());
      localObject1 = this.streamInfo.getSegment(this.currentSegment);
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("init: segment==null currentSegment=");
        ((StringBuilder)localObject1).append(this.currentSegment);
        PlayerUtils.log(6, "SegmentMediaPlayer", ((StringBuilder)localObject1).toString());
        return;
      }
      if (this.currentPlayer == null)
      {
        this.currentPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
        this.currentPlayer.setMode(this.mPlayMode);
      }
      String str = (String)this.proxyUrls.get(this.currentSegment);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init: currentSegment=");
      localStringBuilder.append(this.currentSegment);
      localStringBuilder.append(" url=");
      localStringBuilder.append(((SegmentVideoInfo.SegmentInfo)localObject1).url);
      localStringBuilder.append(" proxyUrl=");
      localStringBuilder.append(str);
      PlayerUtils.log(4, "SegmentMediaPlayer", localStringBuilder.toString());
      this.currentPlayer.setDataSource(str);
      if (PlayerUtils.isHLSStream(str)) {
        this.isAllowLooping = false;
      } else {
        this.isAllowLooping = true;
      }
      initCurrentPlayer();
      return;
    }
    finally {}
  }
  
  private void initCurrentPlayer()
  {
    PlayerUtils.log(4, "SegmentMediaPlayer", "initCurrentPlayer...");
    Object localObject = this.currentPlayer;
    if (localObject == null) {
      return;
    }
    ((StateMediaPlayer)localObject).setOnPreparedListener(this);
    this.currentPlayer.setOnInfoListener(this);
    this.currentPlayer.setOnCompletionListener(this);
    this.currentPlayer.setOnSeekCompleteListener(this);
    this.currentPlayer.setOnBufferingUpdateListener(this);
    this.currentPlayer.setOnVideoSizeChangedListener(this);
    this.currentPlayer.setOnErrorListener(this);
    localObject = this.context;
    if (localObject != null) {
      this.currentPlayer.setWakeMode((Context)localObject, this.wakeMode);
    }
    if (PlayerConfig.g().isDebugVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("currentPlayer setVolume, leftVolume=");
      ((StringBuilder)localObject).append(this.leftVolume);
      ((StringBuilder)localObject).append(" rightVolume=");
      ((StringBuilder)localObject).append(this.rightVolume);
      ((StringBuilder)localObject).append(toString());
      PlayerUtils.log(3, "SegmentMediaPlayer", ((StringBuilder)localObject).toString());
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
    if (paramIMediaPlayer == null) {
      return;
    }
    int i = this.surfaceType;
    if (i == 0)
    {
      paramIMediaPlayer.setDisplay(null);
      return;
    }
    if (i == 1) {
      paramIMediaPlayer.setSurface(null);
    }
  }
  
  private void setDisplaySurface(IMediaPlayer paramIMediaPlayer)
  {
    if (paramIMediaPlayer == null) {
      return;
    }
    int i = this.surfaceType;
    if (i == 0)
    {
      paramIMediaPlayer.setDisplay(this.surfaceHolder);
      return;
    }
    if (i == 1) {
      paramIMediaPlayer.setSurface(this.surface);
    }
  }
  
  public int getAudioSessionId()
  {
    return 0;
  }
  
  public long getCurrentPosition()
  {
    Object localObject = this.streamInfo;
    long l1 = 0L;
    if (localObject == null) {
      return 0L;
    }
    localObject = this.currentPlayer;
    if ((localObject != null) && (((StateMediaPlayer)localObject).checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTPOSITION))) {}
    try
    {
      if (this.currentPlayer == null) {
        break label74;
      }
      long l2 = this.currentPlayer.getCurrentPosition();
      l1 = l2;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label65:
      int i;
      break label65;
    }
    PlayerUtils.log(5, "SegmentMediaPlayer", "getCurrentPosition illegal state");
    label74:
    localObject = this.streamInfo.segmentInfos;
    i = 0;
    while (i < this.currentSegment)
    {
      l1 += ((SegmentVideoInfo.SegmentInfo)((ArrayList)localObject).get(i)).duration;
      i += 1;
    }
    this.mLastCurrentPosition = l1;
    return l1;
    return this.mLastCurrentPosition;
  }
  
  public String getCurrentProxySegmentUrl()
  {
    Object localObject = this.proxyUrls;
    if (localObject != null) {
      return (String)((List)localObject).get(this.currentSegment);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("illegal on calling getCurrentSegmentVideoUrl, must call setDataSource first ");
    ((StringBuilder)localObject).append(PlayerUtils.getStackTrace());
    PlayerUtils.log(5, "SegmentMediaPlayer", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public String getCurrentSegmentUrl()
  {
    Object localObject = this.sourceUrls;
    if (localObject != null) {
      return (String)((List)localObject).get(this.currentSegment);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("illegal on calling getCurrentSegmentVideoUrl, must call setDataSource first ");
    ((StringBuilder)localObject).append(PlayerUtils.getStackTrace());
    PlayerUtils.log(5, "SegmentMediaPlayer", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public String getDataSource()
  {
    return null;
  }
  
  public long getDuration()
  {
    SegmentVideoInfo.StreamInfo localStreamInfo = this.streamInfo;
    if (localStreamInfo != null) {
      return localStreamInfo.getTotalDuration();
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
  
  public int getVideoHeight()
  {
    try
    {
      if (this.currentPlayer != null)
      {
        int i = this.currentPlayer.getVideoHeight();
        return i;
      }
      return 0;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getVideoSarDen()
  {
    return 0;
  }
  
  public int getVideoSarNum()
  {
    return 0;
  }
  
  public int getVideoWidth()
  {
    try
    {
      if (this.currentPlayer != null)
      {
        int i = this.currentPlayer.getVideoWidth();
        return i;
      }
      return 0;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    boolean bool2 = false;
    try
    {
      if ((this.currentPlayer != null) && (!this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_ISPLAYING))) {
        return false;
      }
      boolean bool1 = bool2;
      if (this.currentPlayer != null)
      {
        boolean bool3 = this.currentPlayer.isPlaying();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      PlayerUtils.log(5, "SegmentMediaPlayer", PlayerUtils.getPrintableStackTrace(localIllegalStateException));
    }
    return false;
  }
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    try
    {
      boolean bool = this.isReleasing;
      if (bool) {
        return;
      }
      int i;
      if ((this.nextPlayer != null) && (paramIMediaPlayer == this.nextPlayer.getInternalMediaPlayer())) {
        i = this.currentSegment + 1;
      } else {
        i = this.currentSegment;
      }
      int j = paramInt;
      if (this.streamInfo != null)
      {
        paramIMediaPlayer = this.streamInfo.getSegment(i);
        j = paramInt;
        if (paramIMediaPlayer != null)
        {
          i = paramIMediaPlayer.offset;
          double d1 = i;
          Double.isNaN(d1);
          i = this.streamInfo.getTotalDuration();
          double d2 = i;
          Double.isNaN(d2);
          j = paramInt + (int)(d1 * 100.0D / d2);
        }
      }
      if (this.onBufferingUpdateListener != null) {
        this.onBufferingUpdateListener.onBufferingUpdate(this, j);
      }
      return;
    }
    finally {}
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
    //   17: ldc_w 516
    //   20: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 316	com/tencent/oskplayer/player/SegmentMediaPlayer:hasNext	()Z
    //   27: ifeq +300 -> 327
    //   30: aload_0
    //   31: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   34: ifnull +389 -> 423
    //   37: aload_0
    //   38: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   41: ifnull +382 -> 423
    //   44: iconst_4
    //   45: ldc 27
    //   47: ldc_w 518
    //   50: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: getfield 435	com/tencent/oskplayer/player/SegmentMediaPlayer:surfaceType	I
    //   57: ifne +43 -> 100
    //   60: iconst_3
    //   61: ldc 27
    //   63: ldc_w 520
    //   66: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   73: aconst_null
    //   74: invokevirtual 521	com/tencent/oskplayer/player/StateMediaPlayer:setDisplay	(Landroid/view/SurfaceHolder;)V
    //   77: iconst_3
    //   78: ldc 27
    //   80: ldc_w 523
    //   83: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   90: aload_0
    //   91: getfield 445	com/tencent/oskplayer/player/SegmentMediaPlayer:surfaceHolder	Landroid/view/SurfaceHolder;
    //   94: invokevirtual 521	com/tencent/oskplayer/player/StateMediaPlayer:setDisplay	(Landroid/view/SurfaceHolder;)V
    //   97: goto +40 -> 137
    //   100: iconst_3
    //   101: ldc 27
    //   103: ldc_w 525
    //   106: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   113: aconst_null
    //   114: invokevirtual 526	com/tencent/oskplayer/player/StateMediaPlayer:setSurface	(Landroid/view/Surface;)V
    //   117: iconst_3
    //   118: ldc 27
    //   120: ldc_w 528
    //   123: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   126: aload_0
    //   127: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   130: aload_0
    //   131: getfield 447	com/tencent/oskplayer/player/SegmentMediaPlayer:surface	Landroid/view/Surface;
    //   134: invokevirtual 526	com/tencent/oskplayer/player/StateMediaPlayer:setSurface	(Landroid/view/Surface;)V
    //   137: getstatic 531	com/tencent/oskplayer/player/SegmentMediaPlayer:SUPPORT_NEXT_MEDIA	Z
    //   140: ifne +55 -> 195
    //   143: ldc 27
    //   145: ldc_w 533
    //   148: invokestatic 539	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   151: pop
    //   152: aload_0
    //   153: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   156: getstatic 542	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerOperation:OP_START	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerOperation;
    //   159: invokevirtual 280	com/tencent/oskplayer/player/StateMediaPlayer:checkState	(Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerOperation;)Z
    //   162: ifne +11 -> 173
    //   165: aload_0
    //   166: iconst_1
    //   167: putfield 298	com/tencent/oskplayer/player/SegmentMediaPlayer:needStartAfterPrepared	Z
    //   170: goto +25 -> 195
    //   173: aload_0
    //   174: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   177: invokevirtual 543	com/tencent/oskplayer/player/StateMediaPlayer:start	()V
    //   180: goto +15 -> 195
    //   183: astore_1
    //   184: bipush 6
    //   186: ldc 27
    //   188: aload_1
    //   189: invokevirtual 544	tv/danmaku/ijk/media/player/IMediaPlayer$InternalOperationException:toString	()Ljava/lang/String;
    //   192: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   195: invokestatic 371	com/tencent/oskplayer/PlayerConfig:g	()Lcom/tencent/oskplayer/PlayerConfig;
    //   198: invokevirtual 374	com/tencent/oskplayer/PlayerConfig:isDebugVersion	()Z
    //   201: ifeq +64 -> 265
    //   204: new 182	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   211: astore_1
    //   212: aload_1
    //   213: ldc_w 546
    //   216: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_1
    //   221: aload_0
    //   222: getfield 378	com/tencent/oskplayer/player/SegmentMediaPlayer:leftVolume	F
    //   225: invokevirtual 381	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_1
    //   230: ldc_w 383
    //   233: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_1
    //   238: aload_0
    //   239: getfield 385	com/tencent/oskplayer/player/SegmentMediaPlayer:rightVolume	F
    //   242: invokevirtual 381	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_1
    //   247: aload_0
    //   248: invokevirtual 386	java/lang/Object:toString	()Ljava/lang/String;
    //   251: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: iconst_3
    //   256: ldc 27
    //   258: aload_1
    //   259: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   265: aload_0
    //   266: getfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   269: astore_1
    //   270: aload_0
    //   271: aload_0
    //   272: getfield 178	com/tencent/oskplayer/player/SegmentMediaPlayer:nextPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   275: putfield 117	com/tencent/oskplayer/player/SegmentMediaPlayer:currentPlayer	Lcom/tencent/oskplayer/player/StateMediaPlayer;
    //   278: aload_0
    //   279: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   282: iconst_1
    //   283: aload_1
    //   284: invokestatic 552	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   287: invokevirtual 555	android/os/Message:sendToTarget	()V
    //   290: aload_0
    //   291: aload_0
    //   292: getfield 259	com/tencent/oskplayer/player/SegmentMediaPlayer:currentSegment	I
    //   295: iconst_1
    //   296: iadd
    //   297: putfield 259	com/tencent/oskplayer/player/SegmentMediaPlayer:currentSegment	I
    //   300: aload_0
    //   301: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   304: ifnull +119 -> 423
    //   307: aload_0
    //   308: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   311: iconst_0
    //   312: invokevirtual 560	android/os/Handler:removeMessages	(I)V
    //   315: aload_0
    //   316: getfield 140	com/tencent/oskplayer/player/SegmentMediaPlayer:handler	Landroid/os/Handler;
    //   319: iconst_0
    //   320: invokevirtual 564	android/os/Handler:sendEmptyMessage	(I)Z
    //   323: pop
    //   324: goto +99 -> 423
    //   327: aload_0
    //   328: getfield 395	com/tencent/oskplayer/player/SegmentMediaPlayer:isAllowLooping	Z
    //   331: ifeq +66 -> 397
    //   334: aload_0
    //   335: getfield 493	com/tencent/oskplayer/player/SegmentMediaPlayer:isLooping	Z
    //   338: ifeq +59 -> 397
    //   341: aload_0
    //   342: getfield 145	com/tencent/oskplayer/player/SegmentMediaPlayer:isReleasing	Z
    //   345: istore_2
    //   346: iload_2
    //   347: ifeq +6 -> 353
    //   350: aload_0
    //   351: monitorexit
    //   352: return
    //   353: aload_0
    //   354: lconst_0
    //   355: invokevirtual 565	com/tencent/oskplayer/player/SegmentMediaPlayer:seekTo	(J)V
    //   358: aload_0
    //   359: invokevirtual 566	com/tencent/oskplayer/player/SegmentMediaPlayer:start	()V
    //   362: aload_0
    //   363: getfield 568	com/tencent/oskplayer/player/SegmentMediaPlayer:onLoopStartListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnLoopStartListener;
    //   366: ifnull +57 -> 423
    //   369: aload_0
    //   370: getfield 568	com/tencent/oskplayer/player/SegmentMediaPlayer:onLoopStartListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnLoopStartListener;
    //   373: aload_0
    //   374: invokeinterface 573 2 0
    //   379: goto +44 -> 423
    //   382: astore_1
    //   383: bipush 6
    //   385: ldc 27
    //   387: aload_1
    //   388: invokevirtual 544	tv/danmaku/ijk/media/player/IMediaPlayer$InternalOperationException:toString	()Ljava/lang/String;
    //   391: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   394: goto +29 -> 423
    //   397: iconst_3
    //   398: ldc 27
    //   400: ldc_w 575
    //   403: invokestatic 173	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: getfield 577	com/tencent/oskplayer/player/SegmentMediaPlayer:onCompletionListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;
    //   410: ifnull +13 -> 423
    //   413: aload_0
    //   414: getfield 577	com/tencent/oskplayer/player/SegmentMediaPlayer:onCompletionListener	Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;
    //   417: aload_0
    //   418: invokeinterface 579 2 0
    //   423: aload_0
    //   424: monitorexit
    //   425: return
    //   426: astore_1
    //   427: aload_0
    //   428: monitorexit
    //   429: aload_1
    //   430: athrow
    //   431: astore_1
    //   432: goto -142 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	SegmentMediaPlayer
    //   0	435	1	paramIMediaPlayer	IMediaPlayer
    //   6	341	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   173	180	183	tv/danmaku/ijk/media/player/IMediaPlayer$InternalOperationException
    //   358	379	382	tv/danmaku/ijk/media/player/IMediaPlayer$InternalOperationException
    //   2	7	426	finally
    //   14	97	426	finally
    //   100	137	426	finally
    //   137	170	426	finally
    //   173	180	426	finally
    //   184	195	426	finally
    //   195	265	426	finally
    //   265	278	426	finally
    //   278	290	426	finally
    //   290	324	426	finally
    //   327	346	426	finally
    //   353	358	426	finally
    //   358	379	426	finally
    //   383	394	426	finally
    //   397	423	426	finally
    //   278	290	431	java/lang/Exception
  }
  
  public boolean onError(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.isReleasing;
        if (bool) {
          return true;
        }
        if (this.currentPlayer != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onError: what=");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(" extra=");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(" currentSegment=");
          localStringBuilder.append(this.currentSegment);
          localStringBuilder.append(" mp==");
          if (paramIMediaPlayer == this.currentPlayer.getInternalMediaPlayer())
          {
            paramIMediaPlayer = "currentPlayer";
            localStringBuilder.append(paramIMediaPlayer);
            PlayerUtils.log(6, "SegmentMediaPlayer", localStringBuilder.toString());
          }
        }
        else
        {
          if (this.onErrorListener != null)
          {
            bool = this.onErrorListener.onError(this, paramInt1, paramInt2);
            return bool;
          }
          return true;
        }
      }
      finally {}
      paramIMediaPlayer = "nextPlayer";
    }
  }
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    label130:
    try
    {
      boolean bool = this.isReleasing;
      if (bool) {
        return true;
      }
      if (paramIMediaPlayer == null) {
        return true;
      }
      if ((!PlayerConfig.g().isDebugVersion()) || (this.currentPlayer == null)) {
        break label175;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInfo what=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" extra=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" mp==");
      if (paramIMediaPlayer != this.currentPlayer.getInternalMediaPlayer()) {
        break label168;
      }
      paramIMediaPlayer = "currentPlayer";
      localStringBuilder.append(paramIMediaPlayer);
      PlayerUtils.log(3, "SegmentMediaPlayer", localStringBuilder.toString());
    }
    finally {}
    PlayerUtils.log(4, "SegmentMediaPlayer", "--------------- mediaplayer start rendering -----------------");
    for (;;)
    {
      if (this.onInfoListener != null) {
        this.onInfoListener.onInfo(this, paramInt1, paramInt2);
      }
      return true;
      label168:
      paramIMediaPlayer = "nextPlayer";
      break;
      label175:
      if (paramInt1 == 3) {
        break label130;
      }
    }
  }
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    try
    {
      boolean bool = this.isReleasing;
      if (bool) {
        return;
      }
      paramIMediaPlayer.setScreenOnWhilePlaying(this.screenOnWhilePlaying);
      if (this.isAllowLooping) {
        paramIMediaPlayer.setLooping(false);
      }
      paramIMediaPlayer.setVolume(this.leftVolume, this.rightVolume);
      if ((this.currentPlayer != null) && (paramIMediaPlayer == this.currentPlayer.getInternalMediaPlayer()))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPrepared mp == currentPlayer, playing segment=");
        ((StringBuilder)localObject).append(this.currentSegment);
        ((StringBuilder)localObject).append(" seekAfterPrepared=");
        ((StringBuilder)localObject).append(this.seekAfterPrepared);
        ((StringBuilder)localObject).append(" needStartAfterPrepared=");
        ((StringBuilder)localObject).append(this.needStartAfterPrepared);
        PlayerUtils.log(3, "SegmentMediaPlayer", ((StringBuilder)localObject).toString());
        if (this.streamInfo != null)
        {
          localObject = this.streamInfo.getSegment(this.currentSegment);
          if (localObject != null)
          {
            int i = (int)paramIMediaPlayer.getDuration();
            if ((i > 0) && (((SegmentVideoInfo.SegmentInfo)localObject).duration != i))
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("fix segment duration. segment=");
              localStringBuilder2.append(this.currentSegment);
              localStringBuilder2.append(" segment.duration=");
              localStringBuilder2.append(((SegmentVideoInfo.SegmentInfo)localObject).duration);
              localStringBuilder2.append("real duration=");
              localStringBuilder2.append(i);
              PlayerUtils.log(2, "SegmentMediaPlayer", localStringBuilder2.toString());
              ((SegmentVideoInfo.SegmentInfo)localObject).duration = i;
              this.streamInfo.updateDuration();
            }
          }
        }
        bool = this.needStartAfterPrepared;
        if (bool)
        {
          try
          {
            paramIMediaPlayer.start();
          }
          catch (IMediaPlayer.InternalOperationException localInternalOperationException)
          {
            PlayerUtils.log(6, "SegmentMediaPlayer", localInternalOperationException.toString());
          }
          this.needStartAfterPrepared = false;
        }
        else if (this.needStopAfterPrepared)
        {
          paramIMediaPlayer.stop();
          this.needStopAfterPrepared = false;
        }
        bool = this.isSeeking;
        if (this.seekAfterPrepared != 0L)
        {
          paramIMediaPlayer.seekTo(this.seekAfterPrepared);
          this.seekAfterPrepared = 0L;
        }
        else if (this.isSeeking)
        {
          this.isSeeking = false;
          if (this.onSeekCompleteListener != null) {
            this.onSeekCompleteListener.onSeekComplete(this);
          }
        }
        if (this.handler != null)
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessage(0);
        }
        if ((this.onPreparedListener != null) && (!bool)) {
          this.onPreparedListener.onPrepared(this);
        }
      }
      else if ((this.nextPlayer != null) && (paramIMediaPlayer == this.nextPlayer.getInternalMediaPlayer()))
      {
        PlayerUtils.log(3, "SegmentMediaPlayer", "onPrepared mp == nextPlayer");
        if (SUPPORT_NEXT_MEDIA)
        {
          paramIMediaPlayer = this.currentPlayer;
          if (paramIMediaPlayer != null) {
            try
            {
              PlayerUtils.log(3, "SegmentMediaPlayer", "setNextMediaPlayer");
              this.currentPlayer.setNextMediaPlayer(this.nextPlayer.getInternalMediaPlayer());
            }
            catch (Exception paramIMediaPlayer)
            {
              StringBuilder localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("failed setNextMediaPlayer:");
              localStringBuilder1.append(paramIMediaPlayer);
              PlayerUtils.log(6, "SegmentMediaPlayer", localStringBuilder1.toString());
              if (this.onErrorListener != null) {
                this.onErrorListener.onError(this, 20001, 0);
              }
            }
          }
        }
        if (PlayerConfig.g().isDebugVersion())
        {
          paramIMediaPlayer = new StringBuilder();
          paramIMediaPlayer.append("nextPlayer onPrepared setVolume, leftVolume=");
          paramIMediaPlayer.append(this.leftVolume);
          paramIMediaPlayer.append(" rightVolume=");
          paramIMediaPlayer.append(this.rightVolume);
          paramIMediaPlayer.append(toString());
          PlayerUtils.log(3, "SegmentMediaPlayer", paramIMediaPlayer.toString());
        }
        this.nextPlayer.setVolume(this.leftVolume, this.rightVolume);
        this.nextPlayer.setScreenOnWhilePlaying(this.screenOnWhilePlaying);
        if (this.isAllowLooping) {
          this.nextPlayer.setLooping(false);
        }
      }
      return;
    }
    finally {}
  }
  
  public void onSeekComplete(IMediaPlayer paramIMediaPlayer)
  {
    try
    {
      boolean bool = this.isReleasing;
      if (bool) {
        return;
      }
      PlayerUtils.log(3, "SegmentMediaPlayer", "onSeekComplete.");
      this.isSeeking = false;
      if (this.onSeekCompleteListener != null) {
        this.onSeekCompleteListener.onSeekComplete(this);
      }
      return;
    }
    finally {}
  }
  
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    try
    {
      boolean bool = this.isReleasing;
      if (bool) {
        return;
      }
      if (this.onVideoSizeChangedListener != null) {
        this.onVideoSizeChangedListener.onVideoSizeChanged(this, paramInt1, paramInt2);
      }
      return;
    }
    finally {}
  }
  
  public void pause()
  {
    StateMediaPlayer localStateMediaPlayer = this.currentPlayer;
    if (localStateMediaPlayer != null)
    {
      if (localStateMediaPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_PAUSE)) {
        try
        {
          this.currentPlayer.pause();
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("pause error: ");
          localStringBuilder2.append(PlayerUtils.getPrintableStackTrace(localIllegalStateException));
          PlayerUtils.log(6, "SegmentMediaPlayer", localStringBuilder2.toString());
          return;
        }
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("pause failed, current media state = ");
      localStringBuilder1.append(this.currentPlayer.getMediaPlayerState());
      throw new IMediaPlayer.InternalOperationException(localStringBuilder1.toString());
    }
  }
  
  public void prepareAsync()
  {
    StateMediaPlayer localStateMediaPlayer = this.currentPlayer;
    if (localStateMediaPlayer != null) {
      localStateMediaPlayer.prepareAsync();
    }
  }
  
  public void release()
  {
    label68:
    try
    {
      this.isReleasing = true;
      if (this.handler != null)
      {
        this.handler.removeMessages(0);
        this.handler.removeMessages(2);
        this.handler.removeMessages(1);
      }
      this.handler = null;
      HandlerThread localHandlerThread = this.segmentPlayerThread;
      if (localHandlerThread == null) {}
    }
    finally {}
    try
    {
      this.segmentPlayerThread.quit();
      this.segmentPlayerThread = null;
    }
    catch (Exception localException)
    {
      break label68;
    }
    PlayerUtils.log(5, "SegmentMediaPlayer", "release segmentPlayerThread error");
    this.onPreparedListener = null;
    this.onCompletionListener = null;
    this.onBufferingUpdateListener = null;
    this.onVideoSizeChangedListener = null;
    this.onSeekCompleteListener = null;
    this.onInfoListener = null;
    doRelease();
  }
  
  public void reset()
  {
    if (this.currentPlayer != null)
    {
      PlayerUtils.log(4, "SegmentMediaPlayer", "currentPlayer is reset");
      if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RESET))
      {
        this.currentPlayer.reset();
      }
      else
      {
        if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RELEASE)) {
          this.currentPlayer.release();
        }
        this.currentPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
        this.currentPlayer.setMode(this.mPlayMode);
      }
    }
    if (this.nextPlayer != null)
    {
      PlayerUtils.log(4, "SegmentMediaPlayer", "nextPlayer is reset");
      if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RESET))
      {
        this.nextPlayer.reset();
        return;
      }
      if (this.nextPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RELEASE)) {
        this.nextPlayer.release();
      }
      this.nextPlayer = new StateMediaPlayer(new AndroidMediaPlayer(), this.strictMode);
      this.nextPlayer.setMode(this.mPlayMode);
    }
  }
  
  public void seekTo(long paramLong)
  {
    try
    {
      Object localObject1 = this.handler;
      if (localObject1 == null) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("seekTo ");
      ((StringBuilder)localObject1).append(paramLong);
      PlayerUtils.log(4, "SegmentMediaPlayer", ((StringBuilder)localObject1).toString());
      this.handler.removeMessages(2);
      this.handler.sendMessage(this.handler.obtainMessage(2, Long.valueOf(paramLong)));
      return;
    }
    finally {}
  }
  
  public void setAudioStreamType(int paramInt)
  {
    StateMediaPlayer localStateMediaPlayer = this.currentPlayer;
    if (localStateMediaPlayer != null) {
      localStateMediaPlayer.setAudioStreamType(paramInt);
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
      if (this.currentSegment >= 0)
      {
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
        return;
      }
      this.currentSegment = 0;
      throw new IOException("invalid segment index");
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
    paramSurfaceHolder = this.currentPlayer;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.setDisplay(this.surfaceHolder);
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
    StateMediaPlayer localStateMediaPlayer = this.currentPlayer;
    if (localStateMediaPlayer != null) {
      localStateMediaPlayer.setOnTimedTextListener(paramOnTimedTextListener);
    }
  }
  
  public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.onVideoSizeChangedListener = paramOnVideoSizeChangedListener;
  }
  
  void setPlayMode(int paramInt)
  {
    this.mPlayMode = paramInt;
    StateMediaPlayer localStateMediaPlayer = this.currentPlayer;
    if (localStateMediaPlayer != null) {
      localStateMediaPlayer.setMode(this.mPlayMode);
    }
    localStateMediaPlayer = this.nextPlayer;
    if (localStateMediaPlayer != null) {
      localStateMediaPlayer.setMode(this.mPlayMode);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSurface ");
      localStringBuilder.append(this);
      PlayerUtils.log(4, "SegmentMediaPlayer", localStringBuilder.toString());
      this.currentPlayer.setSurface(paramSurface);
    }
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.leftVolume = paramFloat1;
    this.rightVolume = paramFloat2;
    StringBuilder localStringBuilder3;
    if (this.currentPlayer != null)
    {
      if (PlayerConfig.g().isDebugVersion())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("set current setVolume, leftVolume=");
        localStringBuilder1.append(paramFloat1);
        localStringBuilder1.append(" rightVolume=");
        localStringBuilder1.append(paramFloat2);
        localStringBuilder1.append(toString());
        PlayerUtils.log(3, "SegmentMediaPlayer", localStringBuilder1.toString());
      }
      try
      {
        if (this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETVOLUME)) {
          this.currentPlayer.setVolume(paramFloat1, paramFloat2);
        }
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("cant set volume to ");
        localStringBuilder3.append(paramFloat1);
        localStringBuilder3.append(",");
        localStringBuilder3.append(paramFloat2);
        localStringBuilder3.append(localIllegalStateException1);
        PlayerUtils.log(6, "SegmentMediaPlayer", localStringBuilder3.toString());
      }
    }
    if (this.nextPlayer != null)
    {
      if (PlayerConfig.g().isDebugVersion())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("set next setVolume, leftVolume=");
        localStringBuilder2.append(paramFloat1);
        localStringBuilder2.append(" rightVolume=");
        localStringBuilder2.append(paramFloat2);
        localStringBuilder2.append(toString());
        PlayerUtils.log(3, "SegmentMediaPlayer", localStringBuilder2.toString());
      }
      try
      {
        if (this.nextPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETVOLUME))
        {
          this.nextPlayer.setVolume(paramFloat1, paramFloat2);
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("cant set volume to ");
        localStringBuilder3.append(paramFloat1);
        localStringBuilder3.append(",");
        localStringBuilder3.append(paramFloat2);
        localStringBuilder3.append(localIllegalStateException2);
        PlayerUtils.log(6, "SegmentMediaPlayer", localStringBuilder3.toString());
      }
    }
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.context = paramContext;
    this.wakeMode = paramInt;
    StateMediaPlayer localStateMediaPlayer = this.currentPlayer;
    if (localStateMediaPlayer != null) {
      localStateMediaPlayer.setWakeMode(paramContext, paramInt);
    }
  }
  
  public void start()
  {
    StateMediaPlayer localStateMediaPlayer = this.currentPlayer;
    if (localStateMediaPlayer != null)
    {
      if (localStateMediaPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_START)) {
        try
        {
          this.currentPlayer.start();
          this.needStopAfterPrepared = false;
          return;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("start error: ");
          localStringBuilder2.append(PlayerUtils.getPrintableStackTrace(localException));
          PlayerUtils.log(6, "SegmentMediaPlayer", localStringBuilder2.toString());
          return;
        }
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("start failed, current media state = ");
      localStringBuilder1.append(this.currentPlayer.getMediaPlayerState());
      throw new IMediaPlayer.InternalOperationException(localStringBuilder1.toString());
    }
  }
  
  public void stop()
  {
    if (!this.currentPlayer.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_STOP))
    {
      PlayerUtils.log(5, "SegmentMediaPlayer", "stop failed cause of state illegal");
      this.needStopAfterPrepared = true;
      return;
    }
    StateMediaPlayer localStateMediaPlayer = this.currentPlayer;
    if (localStateMediaPlayer != null) {
      localStateMediaPlayer.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.SegmentMediaPlayer
 * JD-Core Version:    0.7.0.1
 */