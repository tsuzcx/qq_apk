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
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.IDLE))
    {
      if (this.mThrowException) {
        throw new IllegalStateException("StateMediaPlayer constructor setMediaPlayerState IDLE error " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "StateMediaPlayer constructor setMediaPlayerState IDLE error " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mThrowException = paramBoolean;
    this.mMode = 3;
    initMode();
  }
  
  private void initMode()
  {
    boolean bool = true;
    if ((this.mMode & 0x1) == 1) {}
    for (;;)
    {
      this.mIsSurfaceRequired = bool;
      return;
      bool = false;
    }
  }
  
  /* Error */
  public boolean checkState(StateMediaPlayer.StateMediaPlayerOperation paramStateMediaPlayerOperation)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: iconst_2
    //   6: ldc 10
    //   8: new 62	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   15: aload_0
    //   16: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc 111
    //   21: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc 113
    //   30: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   37: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 94	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 121	com/tencent/oskplayer/player/StateMediaPlayer$5:$SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerOperation	[I
    //   49: aload_1
    //   50: invokevirtual 127	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerOperation:ordinal	()I
    //   53: iaload
    //   54: istore_2
    //   55: iload_2
    //   56: tableswitch	default:+84 -> 140, 1:+90->146, 2:+146->202, 3:+192->248, 4:+258->314, 5:+258->314, 6:+324->380, 7:+390->446, 8:+390->446, 9:+456->512, 10:+456->512, 11:+512->568, 12:+568->624, 13:+568->624, 14:+654->710, 15:+683->739, 16:+712->768, 17:+712->768
    //   141: istore_3
    //   142: aload_0
    //   143: monitorexit
    //   144: iload_3
    //   145: ireturn
    //   146: aload_0
    //   147: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   150: getstatic 130	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   153: if_acmpeq -13 -> 140
    //   156: aload_0
    //   157: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   160: getstatic 133	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STARTED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   163: if_acmpeq -23 -> 140
    //   166: aload_0
    //   167: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   170: getstatic 136	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ACTIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   173: if_acmpeq -33 -> 140
    //   176: aload_0
    //   177: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   180: getstatic 139	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PASSIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   183: if_acmpeq -43 -> 140
    //   186: aload_0
    //   187: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   190: getstatic 142	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PLAYBACK_COMPLETED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   193: if_acmpeq -53 -> 140
    //   196: iload 4
    //   198: istore_3
    //   199: goto -57 -> 142
    //   202: aload_0
    //   203: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   206: getstatic 136	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ACTIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   209: if_acmpeq -69 -> 140
    //   212: aload_0
    //   213: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   216: getstatic 139	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PASSIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   219: if_acmpeq -79 -> 140
    //   222: aload_0
    //   223: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   226: getstatic 133	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STARTED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   229: if_acmpeq -89 -> 140
    //   232: aload_0
    //   233: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   236: getstatic 142	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PLAYBACK_COMPLETED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   239: if_acmpeq -99 -> 140
    //   242: iload 4
    //   244: istore_3
    //   245: goto -103 -> 142
    //   248: aload_0
    //   249: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   252: getstatic 130	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   255: if_acmpeq -115 -> 140
    //   258: aload_0
    //   259: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   262: getstatic 133	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STARTED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   265: if_acmpeq -125 -> 140
    //   268: aload_0
    //   269: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   272: getstatic 145	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STOPPED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   275: if_acmpeq -135 -> 140
    //   278: aload_0
    //   279: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   282: getstatic 136	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ACTIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   285: if_acmpeq -145 -> 140
    //   288: aload_0
    //   289: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   292: getstatic 139	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PASSIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   295: if_acmpeq -155 -> 140
    //   298: aload_0
    //   299: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   302: getstatic 142	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PLAYBACK_COMPLETED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   305: if_acmpeq -165 -> 140
    //   308: iload 4
    //   310: istore_3
    //   311: goto -169 -> 142
    //   314: aload_0
    //   315: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   318: getstatic 130	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   321: if_acmpeq -181 -> 140
    //   324: aload_0
    //   325: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   328: getstatic 133	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STARTED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   331: if_acmpeq -191 -> 140
    //   334: aload_0
    //   335: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   338: getstatic 136	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ACTIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   341: if_acmpeq -201 -> 140
    //   344: aload_0
    //   345: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   348: getstatic 139	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PASSIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   351: if_acmpeq -211 -> 140
    //   354: aload_0
    //   355: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   358: getstatic 145	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STOPPED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   361: if_acmpeq -221 -> 140
    //   364: aload_0
    //   365: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   368: getstatic 142	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PLAYBACK_COMPLETED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   371: if_acmpeq -231 -> 140
    //   374: iload 4
    //   376: istore_3
    //   377: goto -235 -> 142
    //   380: aload_0
    //   381: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   384: getstatic 130	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   387: if_acmpeq -247 -> 140
    //   390: aload_0
    //   391: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   394: getstatic 133	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STARTED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   397: if_acmpeq -257 -> 140
    //   400: aload_0
    //   401: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   404: getstatic 136	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ACTIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   407: if_acmpeq -267 -> 140
    //   410: aload_0
    //   411: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   414: getstatic 139	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PASSIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   417: if_acmpeq -277 -> 140
    //   420: aload_0
    //   421: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   424: getstatic 145	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STOPPED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   427: if_acmpeq -287 -> 140
    //   430: aload_0
    //   431: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   434: getstatic 142	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PLAYBACK_COMPLETED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   437: if_acmpeq -297 -> 140
    //   440: iload 4
    //   442: istore_3
    //   443: goto -301 -> 142
    //   446: aload_0
    //   447: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   450: getstatic 130	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   453: if_acmpeq -313 -> 140
    //   456: aload_0
    //   457: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   460: getstatic 133	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STARTED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   463: if_acmpeq -323 -> 140
    //   466: aload_0
    //   467: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   470: getstatic 136	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ACTIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   473: if_acmpeq -333 -> 140
    //   476: aload_0
    //   477: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   480: getstatic 139	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PASSIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   483: if_acmpeq -343 -> 140
    //   486: aload_0
    //   487: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   490: getstatic 145	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STOPPED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   493: if_acmpeq -353 -> 140
    //   496: aload_0
    //   497: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   500: getstatic 142	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PLAYBACK_COMPLETED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   503: if_acmpeq -363 -> 140
    //   506: iload 4
    //   508: istore_3
    //   509: goto -367 -> 142
    //   512: aload_0
    //   513: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   516: getstatic 148	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:INITIALIZED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   519: if_acmpeq -379 -> 140
    //   522: aload_0
    //   523: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   526: getstatic 130	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   529: if_acmpeq -389 -> 140
    //   532: aload_0
    //   533: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   536: getstatic 133	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STARTED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   539: if_acmpeq -399 -> 140
    //   542: aload_0
    //   543: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   546: getstatic 136	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ACTIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   549: if_acmpeq -409 -> 140
    //   552: aload_0
    //   553: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   556: getstatic 139	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PASSIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   559: if_acmpeq -419 -> 140
    //   562: iload 4
    //   564: istore_3
    //   565: goto -423 -> 142
    //   568: aload_0
    //   569: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   572: getstatic 130	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   575: if_acmpeq -435 -> 140
    //   578: aload_0
    //   579: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   582: getstatic 133	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STARTED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   585: if_acmpeq -445 -> 140
    //   588: aload_0
    //   589: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   592: getstatic 136	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ACTIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   595: if_acmpeq -455 -> 140
    //   598: aload_0
    //   599: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   602: getstatic 139	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PASSIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   605: if_acmpeq -465 -> 140
    //   608: aload_0
    //   609: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   612: getstatic 142	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PLAYBACK_COMPLETED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   615: if_acmpeq -475 -> 140
    //   618: iload 4
    //   620: istore_3
    //   621: goto -479 -> 142
    //   624: aload_0
    //   625: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   628: getstatic 54	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:IDLE	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   631: if_acmpeq -491 -> 140
    //   634: aload_0
    //   635: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   638: getstatic 148	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:INITIALIZED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   641: if_acmpeq -501 -> 140
    //   644: aload_0
    //   645: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   648: getstatic 145	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STOPPED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   651: if_acmpeq -511 -> 140
    //   654: aload_0
    //   655: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   658: getstatic 130	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   661: if_acmpeq -521 -> 140
    //   664: aload_0
    //   665: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   668: getstatic 133	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:STARTED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   671: if_acmpeq -531 -> 140
    //   674: aload_0
    //   675: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   678: getstatic 136	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ACTIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   681: if_acmpeq -541 -> 140
    //   684: aload_0
    //   685: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   688: getstatic 139	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PASSIVE_PAUSED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   691: if_acmpeq -551 -> 140
    //   694: aload_0
    //   695: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   698: getstatic 142	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PLAYBACK_COMPLETED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   701: if_acmpeq -561 -> 140
    //   704: iload 4
    //   706: istore_3
    //   707: goto -565 -> 142
    //   710: iload 4
    //   712: istore_3
    //   713: aload_0
    //   714: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   717: getstatic 151	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARING	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   720: if_acmpeq -578 -> 142
    //   723: aload_0
    //   724: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   727: getstatic 54	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:IDLE	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   730: if_acmpne -590 -> 140
    //   733: iload 4
    //   735: istore_3
    //   736: goto -594 -> 142
    //   739: iload 4
    //   741: istore_3
    //   742: aload_0
    //   743: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   746: getstatic 151	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARING	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   749: if_acmpeq -607 -> 142
    //   752: aload_0
    //   753: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   756: getstatic 154	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:RELEASED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   759: if_acmpne -619 -> 140
    //   762: iload 4
    //   764: istore_3
    //   765: goto -623 -> 142
    //   768: iload 4
    //   770: istore_3
    //   771: aload_0
    //   772: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   775: getstatic 154	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:RELEASED	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   778: if_acmpeq -636 -> 142
    //   781: aload_0
    //   782: getfield 115	com/tencent/oskplayer/player/StateMediaPlayer:mMediaPlayerState	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   785: astore_1
    //   786: getstatic 54	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:IDLE	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   789: astore 5
    //   791: aload_1
    //   792: aload 5
    //   794: if_acmpne -654 -> 140
    //   797: iload 4
    //   799: istore_3
    //   800: goto -658 -> 142
    //   803: astore_1
    //   804: aload_0
    //   805: monitorexit
    //   806: aload_1
    //   807: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	this	StateMediaPlayer
    //   0	808	1	paramStateMediaPlayerOperation	StateMediaPlayer.StateMediaPlayerOperation
    //   54	2	2	i	int
    //   141	659	3	bool1	boolean
    //   1	797	4	bool2	boolean
    //   789	4	5	localStateMediaPlayerInternalState	StateMediaPlayer.StateMediaPlayerInternalState
    // Exception table:
    //   from	to	target	type
    //   5	55	803	finally
    //   146	196	803	finally
    //   202	242	803	finally
    //   248	308	803	finally
    //   314	374	803	finally
    //   380	440	803	finally
    //   446	506	803	finally
    //   512	562	803	finally
    //   568	618	803	finally
    //   624	704	803	finally
    //   713	733	803	finally
    //   742	762	803	finally
    //   771	791	803	finally
  }
  
  public int getAudioSessionId()
  {
    return this.mInternalMediaPlayer.getAudioSessionId();
  }
  
  public long getCurrentPosition()
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETCURRENTPOSITION))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call getCurrentPosition in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call getCurrentPosition in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    return this.mInternalMediaPlayer.getCurrentPosition();
  }
  
  public String getDataSource()
  {
    if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call getDataSource in illegalState " + getMediaPlayerState());
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call getDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    return this.mInternalMediaPlayer.getDataSource();
  }
  
  public long getDuration()
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_GETDURATION))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call getDuration in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call getDuration in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
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
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call getVideoHeight in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call getVideoHeight in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
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
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call getVideoWidth in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call getVideoWidth in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
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
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call isPlaying in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call isPlaying in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
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
      if (setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED)) {
        return;
      }
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call pause in illegalState " + getMediaPlayerState() + this);
      }
    }
    catch (IMediaPlayer.InternalOperationException localInternalOperationException)
    {
      PlayerUtils.log(4, "StateMediaPlayer", "caught " + localInternalOperationException);
      throw localInternalOperationException;
    }
    PlayerUtils.log(5, "StateMediaPlayer", "call pause in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
  }
  
  /* Error */
  public void prepareAsync()
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 151	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:PREPARING	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   4: invokevirtual 58	com/tencent/oskplayer/player/StateMediaPlayer:setMediaPlayerState	(Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;)Z
    //   7: ifne +87 -> 94
    //   10: aload_0
    //   11: getfield 43	com/tencent/oskplayer/player/StateMediaPlayer:mThrowException	Z
    //   14: ifeq +37 -> 51
    //   17: new 167	com/tencent/oskplayer/player/StateMediaPlayerException
    //   20: dup
    //   21: new 62	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   28: ldc 250
    //   30: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: invokevirtual 73	com/tencent/oskplayer/player/StateMediaPlayer:getMediaPlayerState	()Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   37: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 170	com/tencent/oskplayer/player/StateMediaPlayerException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: iconst_5
    //   52: ldc 10
    //   54: new 62	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   61: ldc 250
    //   63: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: invokevirtual 73	com/tencent/oskplayer/player/StateMediaPlayer:getMediaPlayerState	()Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   70: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: ldc 85
    //   79: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokestatic 90	com/tencent/oskplayer/util/PlayerUtils:getStackTrace	()Ljava/lang/String;
    //   85: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 94	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 41	com/tencent/oskplayer/player/StateMediaPlayer:mPrepareLock	Ljava/lang/Object;
    //   98: astore_1
    //   99: aload_1
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 49	com/tencent/oskplayer/player/StateMediaPlayer:mInternalMediaPlayer	Ltv/danmaku/ijk/media/player/IMediaPlayer;
    //   105: invokeinterface 252 1 0
    //   110: aload_1
    //   111: monitorexit
    //   112: return
    //   113: astore_2
    //   114: aload_1
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    //   118: astore_1
    //   119: iconst_5
    //   120: ldc 10
    //   122: new 62	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   129: ldc 254
    //   131: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: aload_1
    //   139: invokestatic 258	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   142: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 94	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   151: aload_0
    //   152: getstatic 261	com/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState:ERROR	Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;
    //   155: invokevirtual 58	com/tencent/oskplayer/player/StateMediaPlayer:setMediaPlayerState	(Lcom/tencent/oskplayer/player/StateMediaPlayer$StateMediaPlayerInternalState;)Z
    //   158: pop
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	StateMediaPlayer
    //   118	42	1	localIllegalStateException	IllegalStateException
    //   113	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   101	112	113	finally
    //   114	116	113	finally
    //   94	101	118	java/lang/IllegalStateException
    //   116	118	118	java/lang/IllegalStateException
  }
  
  public void release()
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.RELEASED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call release in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call release in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mInternalMediaPlayer.release();
  }
  
  public void reset()
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.IDLE))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call reset in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call reset in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mInternalMediaPlayer.reset();
  }
  
  public void seekTo(long paramLong)
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SEEKTO))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call seekTo in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call seekTo in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mInternalMediaPlayer.seekTo(paramLong);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.IDLE) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call setAudioStreamType in illegalState " + getMediaPlayerState());
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call setAudioStreamType in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mInternalMediaPlayer.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mInternalMediaPlayer.setDataSource(paramContext, paramUri);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mInternalMediaPlayer.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mInternalMediaPlayer.setDataSource(paramFileDescriptor);
  }
  
  public void setDataSource(String paramString)
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call setDataSource in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call setDataSource in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    if (!sVideoUrlValidator.isValid(paramString))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("VideoUrlValidationError " + paramString + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "VideoUrlValidationError " + paramString + this + "\n: stack\n" + PlayerUtils.getStackTrace());
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
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call setLooping in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call setLooping in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mInternalMediaPlayer.setLooping(paramBoolean);
  }
  
  protected boolean setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState paramStateMediaPlayerInternalState)
  {
    boolean bool = false;
    try
    {
      StateMediaPlayer.StateMediaPlayerInternalState localStateMediaPlayerInternalState1 = this.mMediaPlayerState;
      StateMediaPlayer.StateMediaPlayerInternalState localStateMediaPlayerInternalState2 = StateMediaPlayer.StateMediaPlayerInternalState.RELEASED;
      if (localStateMediaPlayerInternalState1 == localStateMediaPlayerInternalState2) {}
      for (;;)
      {
        return bool;
        switch (StateMediaPlayer.5.$SwitchMap$com$tencent$oskplayer$player$StateMediaPlayer$StateMediaPlayerInternalState[paramStateMediaPlayerInternalState.ordinal()])
        {
        case 1: 
          if (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PREPARING) {}
          break;
        case 10: 
        case 11: 
          if (this.mMediaPlayerState != null) {}
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          label102:
          for (int i = -1;; i = this.mMediaPlayerState.ordinal())
          {
            this.mMediaPlayerState = paramStateMediaPlayerInternalState;
            if (this.mStateChangeListener != null) {
              this.mStateChangeListener.onStateChange(i, this.mMediaPlayerState.ordinal());
            }
            PlayerUtils.log(4, "StateMediaPlayer", "setMediaPlayerState " + this + " MediaPlayerState=" + this.mMediaPlayerState);
            bool = true;
            break;
            if (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.IDLE) {
              break label102;
            }
            break;
            if ((this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.STOPPED)) {
              break label102;
            }
            break;
            if (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PREPARING) {
              break label102;
            }
            break;
            if ((this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.STARTED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED)) {
              break label102;
            }
            break;
            if ((this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.STARTED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED)) {
              break label102;
            }
            break;
            if ((this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.STARTED)) {
              break label102;
            }
            break;
            if ((this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.STARTED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.STOPPED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED)) {
              break label102;
            }
            break;
            if ((this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.STARTED) || (this.mMediaPlayerState == StateMediaPlayer.StateMediaPlayerInternalState.ERROR)) {
              break label102;
            }
            break;
          }
        }
      }
    }
    finally {}
  }
  
  public void setMode(int paramInt)
  {
    this.mMode = paramInt;
    if ((this.mInternalMediaPlayer instanceof SegmentMediaPlayer)) {
      ((SegmentMediaPlayer)this.mInternalMediaPlayer).setPlayMode(this.mMode);
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
    if ((this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.IDLE) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.INITIALIZED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PREPARED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STARTED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.ACTIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PASSIVE_PAUSED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.STOPPED) && (this.mMediaPlayerState != StateMediaPlayer.StateMediaPlayerInternalState.PLAYBACK_COMPLETED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call setOnTimedTextListener in illegalState " + getMediaPlayerState());
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call setOnTimedTextListener in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
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
    PlayerUtils.log(4, "StateMediaPlayer", "setSurface " + this);
    if (paramSurface != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.mHasValidSurface = bool;
      this.mInternalMediaPlayer.setSurface(paramSurface);
      return;
    }
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    if (!checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_SETVOLUME))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call setVolume in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call setVolume in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mInternalMediaPlayer.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.mInternalMediaPlayer.setWakeMode(paramContext, paramInt);
  }
  
  public void start()
  {
    if ((this.mIsSurfaceRequired) && (!this.mHasValidSurface))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call start without a valid surface " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call start without a valid surface " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    try
    {
      this.mInternalMediaPlayer.start();
      if (setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.STARTED)) {
        break label233;
      }
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call start in illegalState " + getMediaPlayerState() + this);
      }
    }
    catch (IMediaPlayer.InternalOperationException localInternalOperationException)
    {
      PlayerUtils.log(4, "StateMediaPlayer", "caught " + localInternalOperationException);
      throw localInternalOperationException;
    }
    PlayerUtils.log(5, "StateMediaPlayer", "call start in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    label233:
    this.mAlreadyStart = true;
  }
  
  public void stop()
  {
    if (!setMediaPlayerState(StateMediaPlayer.StateMediaPlayerInternalState.STOPPED))
    {
      if (this.mThrowException) {
        throw new StateMediaPlayerException("call stop in illegalState " + getMediaPlayerState() + this);
      }
      PlayerUtils.log(5, "StateMediaPlayer", "call stop in illegalState " + getMediaPlayerState() + this + "\n: stack\n" + PlayerUtils.getStackTrace());
    }
    this.mInternalMediaPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.oskplayer.player.StateMediaPlayer
 * JD-Core Version:    0.7.0.1
 */