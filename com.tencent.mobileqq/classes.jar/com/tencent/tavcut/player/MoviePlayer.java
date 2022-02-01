package com.tencent.tavcut.player;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.support.annotation.NonNull;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.OnReadSnapShootListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MoviePlayer
  implements IPlayer.PlayerListener
{
  public static final int VIDEO_PLAYER_HEIGHT = 1280;
  public static final int VIDEO_PLAYER_WIDTH = 720;
  private final String TAG = "MoviePlayer@" + Integer.toHexString(hashCode());
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new MoviePlayer.3(this);
  private AudioManager audioManager;
  private int backColor = -16777216;
  private Context context;
  private boolean isAllowInterrupt = true;
  private boolean isAutoPlay = true;
  private boolean loopPlay = false;
  private TextureView mContentView;
  private TAVCutVideoView mPlayerLayout;
  private MoviePlayer.onVideoProgressListener mProgressListener;
  private RenderContextParams mRenderContextParams;
  private boolean needNewComposition = false;
  private CMTimeRange playRange;
  private volatile boolean playReady;
  private Player player;
  private List<MoviePlayer.OnPlayerLifeCycleListener> playerLifeCycleListeners = new ArrayList();
  private List<IPlayer.PlayerListener> playerListeners = new ArrayList();
  private CMTime position = CMTime.CMTimeZero;
  private int rotation;
  private float scaleRatio;
  private CMTime seekTime;
  private Surface surface;
  private int surfaceHeight;
  private List<MoviePlayer.SurfaceTextureChangeListener> surfaceTextureChangeListeners = new ArrayList();
  private int surfaceWidth;
  private TAVComposition tavComposition;
  private boolean updatingPlayItem = false;
  private float volume = 1.0F;
  
  private void abandonAudioFocus()
  {
    if (this.audioManager == null) {
      return;
    }
    this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
  }
  
  @NonNull
  private PlayerItem buildPlayerItem(TAVComposition paramTAVComposition)
  {
    Logger.d(this.TAG, "buildPlayerItem() called with: tavComposition = [" + paramTAVComposition + "]");
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition).buildSource();
    PlayerItem localPlayerItem = new PlayerItem(paramTAVComposition.getAsset());
    localPlayerItem.setVideoComposition(paramTAVComposition.getVideoComposition());
    localPlayerItem.setAudioMix(paramTAVComposition.getAudioMix());
    return localPlayerItem;
  }
  
  @NonNull
  private Player newPlayer(PlayerItem paramPlayerItem, CMTime paramCMTime, boolean paramBoolean)
  {
    Logger.d(this.TAG, "newPlayer() called with: playerItem = [" + paramPlayerItem + "], position = [" + paramCMTime + "], autoPlay = [" + paramBoolean + "]");
    paramPlayerItem = new Player(paramPlayerItem);
    paramPlayerItem.setPlayerListener(this);
    paramPlayerItem.setLoop(this.loopPlay);
    paramPlayerItem.setPlayRange(this.playRange);
    paramPlayerItem.setVolume(getVolume());
    paramPlayerItem.seekToTime(paramCMTime);
    paramPlayerItem.setRenderContextParams(this.mRenderContextParams);
    paramPlayerItem.setBgColor(this.backColor);
    new PlayerLayer(this.surface, this.surfaceWidth, this.surfaceHeight).setPlayer(paramPlayerItem);
    if ((paramBoolean) && (requestAudioFocus())) {
      paramPlayerItem.play();
    }
    return paramPlayerItem;
  }
  
  private void notifySurfaceTextureChange(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.surfaceTextureChangeListeners != null) && (this.surfaceTextureChangeListeners.size() > 0))
    {
      Iterator localIterator = this.surfaceTextureChangeListeners.iterator();
      while (localIterator.hasNext()) {
        ((MoviePlayer.SurfaceTextureChangeListener)localIterator.next()).onTextureChange(paramSurfaceTexture);
      }
    }
  }
  
  private void onPlayerDestroy()
  {
    Iterator localIterator = this.playerLifeCycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((MoviePlayer.OnPlayerLifeCycleListener)localIterator.next()).onPlayerDestroy();
    }
  }
  
  private void onPlayerItemChanged()
  {
    Iterator localIterator = this.playerLifeCycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((MoviePlayer.OnPlayerLifeCycleListener)localIterator.next()).onPlayerItemChanged();
    }
  }
  
  private void onPlayerReady()
  {
    Iterator localIterator = this.playerLifeCycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((MoviePlayer.OnPlayerLifeCycleListener)localIterator.next()).onPlayerReady();
    }
  }
  
  private boolean requestAudioFocus()
  {
    if (this.context == null) {
      return true;
    }
    if (this.audioManager == null) {
      this.audioManager = ((AudioManager)this.context.getSystemService("audio"));
    }
    if (this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 1) == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void startRotatePlayerContainer(int paramInt1, int paramInt2, CGSize paramCGSize, int paramInt3)
  {
    if (this.player == null) {}
    float f3;
    float f4;
    float f1;
    float f2;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.player.getGlViewport() == null);
        f3 = this.surfaceWidth;
        f4 = this.surfaceHeight;
      } while ((f3 == 0.0F) || (f4 == 0.0F) || (paramCGSize.equals(CGSize.CGSizeZero)));
      f1 = paramCGSize.width;
      f2 = paramCGSize.height;
    } while ((f1 == 0.0F) || (f2 == 0.0F));
    f1 /= f2;
    ObjectAnimator localObjectAnimator1;
    ObjectAnimator localObjectAnimator2;
    ObjectAnimator localObjectAnimator3;
    if (f1 < f3 / f4)
    {
      f2 = f1 * f4;
      f1 = f4;
      f1 = Math.min(f4 / f2, f3 / f1);
      this.scaleRatio = f1;
      paramCGSize = new AnimatorSet();
      if (paramInt2 != 90) {
        break label275;
      }
      localObjectAnimator1 = ObjectAnimator.ofFloat(this.mPlayerLayout, "rotation", new float[] { -paramInt1, -90.0F }).setDuration(paramInt3);
      localObjectAnimator2 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleX", new float[] { 1.0F, f1 }).setDuration(paramInt3);
      localObjectAnimator3 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleY", new float[] { 1.0F, f1 }).setDuration(paramInt3);
      paramCGSize.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    }
    for (;;)
    {
      paramCGSize.start();
      return;
      f1 = f3 / f1;
      f2 = f3;
      break;
      label275:
      if (paramInt2 == 180)
      {
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.mPlayerLayout, "rotation", new float[] { -paramInt1, -180.0F }).setDuration(paramInt3);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleX", new float[] { f1, 1.0F }).setDuration(paramInt3);
        localObjectAnimator3 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleY", new float[] { f1, 1.0F }).setDuration(paramInt3);
        paramCGSize.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
      }
      else if (paramInt2 == 270)
      {
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.mPlayerLayout, "rotation", new float[] { -paramInt1, -270.0F }).setDuration(paramInt3);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleX", new float[] { 1.0F, f1 }).setDuration(paramInt3);
        localObjectAnimator3 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleY", new float[] { 1.0F, f1 }).setDuration(paramInt3);
        paramCGSize.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
      }
      else if (paramInt2 == 0)
      {
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.mPlayerLayout, "rotation", new float[] { -paramInt1, 0.0F }).setDuration(paramInt3);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleX", new float[] { f1, 1.0F }).setDuration(paramInt3);
        localObjectAnimator3 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleY", new float[] { f1, 1.0F }).setDuration(paramInt3);
        paramCGSize.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
      }
    }
  }
  
  public void addOnPlayerLifeCycleListener(MoviePlayer.OnPlayerLifeCycleListener paramOnPlayerLifeCycleListener)
  {
    if (paramOnPlayerLifeCycleListener == null) {
      return;
    }
    this.playerLifeCycleListeners.add(paramOnPlayerLifeCycleListener);
  }
  
  public void addPlayerListener(IPlayer.PlayerListener paramPlayerListener)
  {
    if (paramPlayerListener == null) {
      return;
    }
    this.playerListeners.add(paramPlayerListener);
  }
  
  public void addTextureChangeListener(MoviePlayer.SurfaceTextureChangeListener paramSurfaceTextureChangeListener)
  {
    if (paramSurfaceTextureChangeListener == null) {
      return;
    }
    this.surfaceTextureChangeListeners.add(paramSurfaceTextureChangeListener);
  }
  
  public void bindView(TAVCutVideoView paramTAVCutVideoView)
  {
    this.context = paramTAVCutVideoView.getContext();
    this.mPlayerLayout = paramTAVCutVideoView;
    this.mContentView = new TextureView(this.context);
    this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.mPlayerLayout.removeAllViews();
    this.mPlayerLayout.addView(this.mContentView);
    this.mContentView.setSurfaceTextureListener(new MoviePlayer.1(this));
  }
  
  /* Error */
  public IPlayer.PlayerStatus getCurrentStatus()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   6: ifnonnull +11 -> 17
    //   9: getstatic 472	com/tencent/tav/player/IPlayer$PlayerStatus:ERROR	Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   21: invokevirtual 475	com/tencent/tav/player/Player:currentStatus	()Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   24: astore_1
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	MoviePlayer
    //   12	13	1	localPlayerStatus	IPlayer.PlayerStatus
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
    //   17	25	28	finally
  }
  
  public CMTime getDuration()
  {
    if (this.player != null) {
      return this.player.duration();
    }
    return CMTime.CMTimeInvalid;
  }
  
  public boolean getLoopPlay()
  {
    return this.loopPlay;
  }
  
  public CMTimeRange getPlayRange()
  {
    return this.playRange;
  }
  
  public TAVCutVideoView getPlayerLayout()
  {
    return this.mPlayerLayout;
  }
  
  /* Error */
  public CMTime getPosition()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   13: invokevirtual 491	com/tencent/tav/player/Player:position	()Lcom/tencent/tav/coremedia/CMTime;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: getstatic 483	com/tencent/tav/coremedia/CMTime:CMTimeInvalid	Lcom/tencent/tav/coremedia/CMTime;
    //   24: astore_1
    //   25: goto -8 -> 17
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	MoviePlayer
    //   16	9	1	localCMTime	CMTime
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	28	finally
    //   21	25	28	finally
  }
  
  public CGRect getRealRenderSize()
  {
    if (this.player == null) {
      return null;
    }
    return this.player.getGlViewport();
  }
  
  public int getRotation()
  {
    return this.rotation;
  }
  
  public float getScaleRatio()
  {
    return this.scaleRatio;
  }
  
  public TAVComposition getTavComposition()
  {
    return this.tavComposition;
  }
  
  public TextureView getTextureView()
  {
    return this.mContentView;
  }
  
  public float getVolume()
  {
    try
    {
      float f = this.volume;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isPlayReady()
  {
    return this.playReady;
  }
  
  /* Error */
  public boolean isPlaying()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   6: ifnull +48 -> 54
    //   9: aload_0
    //   10: getfield 88	com/tencent/tavcut/player/MoviePlayer:TAG	Ljava/lang/String;
    //   13: new 65	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 504
    //   23: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   30: invokevirtual 506	com/tencent/tav/player/Player:isPlaying	()Z
    //   33: invokevirtual 256	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 208	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   46: invokevirtual 506	com/tencent/tav/player/Player:isPlaying	()Z
    //   49: istore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: iconst_0
    //   55: istore_1
    //   56: goto -6 -> 50
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	MoviePlayer
    //   49	7	1	bool	boolean
    //   59	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	59	finally
  }
  
  /* Error */
  public boolean isReleased()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   13: invokevirtual 509	com/tencent/tav/player/Player:isReleased	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	MoviePlayer
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    if (this.updatingPlayItem) {}
    do
    {
      return;
      Iterator localIterator = this.playerListeners.iterator();
      while (localIterator.hasNext()) {
        ((IPlayer.PlayerListener)localIterator.next()).onPositionChanged(paramCMTime);
      }
    } while (this.mProgressListener == null);
    this.mProgressListener.updateVideoProgress(paramCMTime.getTimeUs() / 1000L);
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    Iterator localIterator = this.playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((IPlayer.PlayerListener)localIterator.next()).onStatusChanged(paramPlayerStatus);
    }
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 88	com/tencent/tavcut/player/MoviePlayer:TAG	Ljava/lang/String;
    //   6: new 65	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 533
    //   16: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   23: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 208	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   36: ifnull +17 -> 53
    //   39: aload_0
    //   40: invokespecial 535	com/tencent/tavcut/player/MoviePlayer:abandonAudioFocus	()V
    //   43: aload_0
    //   44: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   47: invokevirtual 537	com/tencent/tav/player/Player:pause	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 92	com/tencent/tavcut/player/MoviePlayer:isAutoPlay	Z
    //   58: goto -8 -> 50
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	MoviePlayer
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	61	finally
    //   53	58	61	finally
  }
  
  /* Error */
  public void play()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 88	com/tencent/tavcut/player/MoviePlayer:TAG	Ljava/lang/String;
    //   6: new 65	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 539
    //   16: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   23: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 208	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: invokespecial 310	com/tencent/tavcut/player/MoviePlayer:requestAudioFocus	()Z
    //   43: ifeq +10 -> 53
    //   46: aload_0
    //   47: getfield 192	com/tencent/tavcut/player/MoviePlayer:player	Lcom/tencent/tav/player/Player;
    //   50: invokevirtual 313	com/tencent/tav/player/Player:play	()V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: iconst_1
    //   58: putfield 92	com/tencent/tavcut/player/MoviePlayer:isAutoPlay	Z
    //   61: goto -8 -> 53
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	MoviePlayer
    //   64	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	64	finally
    //   56	61	64	finally
  }
  
  public void readSnapShootBitmap(OnReadSnapShootListener paramOnReadSnapShootListener)
  {
    this.player.readSnapShootBitmap(paramOnReadSnapShootListener);
  }
  
  public void refresh()
  {
    for (;;)
    {
      try
      {
        Player localPlayer = this.player;
        if (localPlayer == null) {
          return;
        }
        if (this.player.duration().equalsTo(getPosition())) {
          this.player.seekToTime(getPosition().sub(new CMTime(1L, 1000)));
        } else {
          this.player.seekToTime(getPosition());
        }
      }
      finally {}
    }
  }
  
  public void release()
  {
    try
    {
      Logger.d(this.TAG, "release: player = " + this.player);
      if (this.player != null)
      {
        abandonAudioFocus();
        this.player.release();
        this.seekTime = null;
        this.player = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void removeOnPlayerLifeCyclerListener(MoviePlayer.OnPlayerLifeCycleListener paramOnPlayerLifeCycleListener)
  {
    if (paramOnPlayerLifeCycleListener == null) {
      return;
    }
    this.playerLifeCycleListeners.remove(paramOnPlayerLifeCycleListener);
  }
  
  public void removePlayerListener(IPlayer.PlayerListener paramPlayerListener)
  {
    if (paramPlayerListener == null) {
      return;
    }
    this.playerListeners.remove(paramPlayerListener);
  }
  
  public void reset(boolean paramBoolean)
  {
    try
    {
      this.needNewComposition = paramBoolean;
      this.seekTime = null;
      bindView(this.mPlayerLayout);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void rotate(int paramInt, boolean paramBoolean)
  {
    this.rotation = paramInt;
    CGSize localCGSize2 = CGSize.CGSizeZero;
    CGSize localCGSize1 = localCGSize2;
    if (this.tavComposition != null)
    {
      localCGSize1 = localCGSize2;
      if (this.tavComposition.getRenderSize() != null) {
        localCGSize1 = this.tavComposition.getRenderSize();
      }
    }
    if (paramBoolean)
    {
      startRotatePlayerContainer(this.rotation - 90, this.rotation, localCGSize1, 300);
      return;
    }
    startRotatePlayerContainer(this.rotation, this.rotation, localCGSize1, 0);
  }
  
  public void seekToTime(CMTime paramCMTime)
  {
    Logger.d(this.TAG, "seekToTime() called with: cmTime = [" + paramCMTime + "],player = " + this.player);
    CMTime localCMTime = paramCMTime;
    if (paramCMTime.smallThan(CMTime.CMTimeZero)) {
      localCMTime = CMTime.CMTimeZero;
    }
    this.seekTime = localCMTime;
    if (this.player != null) {
      this.player.seekToTime(localCMTime);
    }
  }
  
  public void setAllowInterrupt(boolean paramBoolean)
  {
    this.isAllowInterrupt = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    try
    {
      this.isAutoPlay = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setBackColor(int paramInt)
  {
    this.backColor = paramInt;
    if (this.player != null) {
      this.player.setBgColor(paramInt);
    }
  }
  
  public void setLoopPlay(boolean paramBoolean)
  {
    try
    {
      Logger.d(this.TAG, "setLoopPlay() called with: loopPlay = [" + paramBoolean + "],player = " + this.player);
      this.loopPlay = paramBoolean;
      if (this.player != null) {
        this.player.setLoop(paramBoolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setPlayRange(CMTimeRange paramCMTimeRange)
  {
    try
    {
      Logger.d(this.TAG, "setPlayRange() called with: playRange = [" + paramCMTimeRange + "],player = " + this.player);
      this.playRange = paramCMTimeRange;
      if (this.player != null) {
        this.player.setPlayRange(paramCMTimeRange);
      }
      return;
    }
    finally
    {
      paramCMTimeRange = finally;
      throw paramCMTimeRange;
    }
  }
  
  public void setPlayerListener(IPlayer.PlayerListener paramPlayerListener)
  {
    addPlayerListener(paramPlayerListener);
  }
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.mRenderContextParams = paramRenderContextParams;
    if (this.player != null) {
      this.player.setRenderContextParams(this.mRenderContextParams);
    }
  }
  
  public void setSource(String paramString)
  {
    paramString = new TAVClip(new URLAsset(paramString));
    TAVComposition localTAVComposition = new TAVComposition();
    localTAVComposition.addAudioChannel(Arrays.asList(new TAVClip[] { paramString }));
    localTAVComposition.addVideoChannel(Arrays.asList(new TAVClip[] { paramString }));
    updateComposition(localTAVComposition, false);
  }
  
  public void setVideoProgressListener(MoviePlayer.onVideoProgressListener paramonVideoProgressListener)
  {
    this.mProgressListener = paramonVideoProgressListener;
  }
  
  public void setVolume(float paramFloat)
  {
    try
    {
      Logger.d(this.TAG, "setVolume() called with: volume = [" + paramFloat + "],player = " + this.player);
      this.volume = paramFloat;
      if (this.player != null) {
        this.player.setVolume(paramFloat);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, CMTime paramCMTime, boolean paramBoolean)
  {
    Logger.d(this.TAG, "updateComposition() called with: tavComposition = [" + paramTAVComposition + "], position = [" + paramCMTime + "], autoPlay = [" + paramBoolean + "]");
    this.tavComposition = paramTAVComposition;
    this.position = paramCMTime;
    if (paramTAVComposition == null) {
      return;
    }
    if (this.surface == null)
    {
      this.isAutoPlay = paramBoolean;
      return;
    }
    paramTAVComposition = buildPlayerItem(paramTAVComposition);
    if (this.seekTime == null) {
      this.seekTime = paramCMTime;
    }
    if ((this.player == null) || (this.player.isReleased()))
    {
      this.player = newPlayer(paramTAVComposition, this.seekTime, paramBoolean);
      return;
    }
    this.updatingPlayItem = true;
    this.player.update(paramTAVComposition, paramCMTime, new MoviePlayer.2(this, paramBoolean));
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    updateComposition(paramTAVComposition, CMTime.CMTimeZero, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.player.MoviePlayer
 * JD-Core Version:    0.7.0.1
 */