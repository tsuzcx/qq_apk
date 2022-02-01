package com.tencent.qcircle.tavcut.player;

import android.animation.Animator;
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
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
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
  private final String TAG;
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  private AudioManager audioManager;
  private int backColor;
  private Context context;
  private boolean isAllowInterrupt;
  private boolean isAutoPlay;
  private boolean loopPlay;
  private TextureView mContentView;
  private TAVCutVideoView mPlayerLayout;
  private MoviePlayer.onVideoProgressListener mProgressListener;
  private RenderContextParams mRenderContextParams;
  private boolean needNewComposition;
  private CMTimeRange playRange;
  private volatile boolean playReady;
  private Player player;
  private List<MoviePlayer.OnPlayerLifeCycleListener> playerLifeCycleListeners;
  private List<IPlayer.PlayerListener> playerListeners;
  private CMTime position;
  private int rotation;
  private float scaleRatio;
  private CMTime seekTime;
  private Surface surface;
  private int surfaceHeight;
  private List<MoviePlayer.SurfaceTextureChangeListener> surfaceTextureChangeListeners;
  private int surfaceWidth;
  private TAVComposition tavComposition;
  private boolean updatingPlayItem;
  private float volume;
  
  public MoviePlayer()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MoviePlayer@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.isAllowInterrupt = true;
    this.isAutoPlay = true;
    this.loopPlay = false;
    this.volume = 1.0F;
    this.position = CMTime.CMTimeZero;
    this.backColor = -16777216;
    this.playerLifeCycleListeners = new ArrayList();
    this.playerListeners = new ArrayList();
    this.surfaceTextureChangeListeners = new ArrayList();
    this.updatingPlayItem = false;
    this.needNewComposition = false;
    this.audioFocusChangeListener = new MoviePlayer.3(this);
  }
  
  private void abandonAudioFocus()
  {
    AudioManager localAudioManager = this.audioManager;
    if (localAudioManager == null) {
      return;
    }
    localAudioManager.abandonAudioFocus(this.audioFocusChangeListener);
  }
  
  @NonNull
  private PlayerItem buildPlayerItem(TAVComposition paramTAVComposition)
  {
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildPlayerItem() called with: tavComposition = [");
    localStringBuilder.append(paramTAVComposition);
    localStringBuilder.append("]");
    Logger.d((String)localObject, localStringBuilder.toString());
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition).buildSource();
    localObject = new PlayerItem(paramTAVComposition.getAsset());
    ((PlayerItem)localObject).setVideoComposition(paramTAVComposition.getVideoComposition());
    ((PlayerItem)localObject).setAudioMix(paramTAVComposition.getAudioMix());
    return localObject;
  }
  
  @NonNull
  private Player newPlayer(PlayerItem paramPlayerItem, CMTime paramCMTime, boolean paramBoolean)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("newPlayer() called with: playerItem = [");
    localStringBuilder.append(paramPlayerItem);
    localStringBuilder.append("], position = [");
    localStringBuilder.append(paramCMTime);
    localStringBuilder.append("], autoPlay = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
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
    Object localObject = this.surfaceTextureChangeListeners;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.surfaceTextureChangeListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MoviePlayer.SurfaceTextureChangeListener)((Iterator)localObject).next()).onTextureChange(paramSurfaceTexture);
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
    Context localContext = this.context;
    if (localContext == null) {
      return true;
    }
    if (this.audioManager == null) {
      this.audioManager = ((AudioManager)localContext.getSystemService("audio"));
    }
    return this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 1) == 1;
  }
  
  private void startRotatePlayerContainer(int paramInt1, int paramInt2, CGSize paramCGSize, int paramInt3)
  {
    Object localObject = this.player;
    if (localObject == null) {
      return;
    }
    if (((Player)localObject).getGlViewport() == null) {
      return;
    }
    float f3 = this.surfaceWidth;
    float f4 = this.surfaceHeight;
    if (f3 != 0.0F)
    {
      if (f4 == 0.0F) {
        return;
      }
      if (paramCGSize.equals(CGSize.CGSizeZero)) {
        return;
      }
      float f1 = paramCGSize.width;
      float f2 = paramCGSize.height;
      if (f1 != 0.0F)
      {
        if (f2 == 0.0F) {
          return;
        }
        f1 /= f2;
        if (f1 < f3 / f4)
        {
          f2 = f4 * f1;
          f1 = f4;
        }
        else
        {
          f1 = f3 / f1;
          f2 = f3;
        }
        f1 = Math.min(f4 / f2, f3 / f1);
        this.scaleRatio = f1;
        paramCGSize = new AnimatorSet();
        long l;
        ObjectAnimator localObjectAnimator1;
        ObjectAnimator localObjectAnimator2;
        if (paramInt2 == 90)
        {
          localObject = ObjectAnimator.ofFloat(this.mPlayerLayout, "rotation", new float[] { -paramInt1, -90.0F });
          l = paramInt3;
          localObject = ((ObjectAnimator)localObject).setDuration(l);
          localObjectAnimator1 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleX", new float[] { 1.0F, f1 }).setDuration(l);
          localObjectAnimator2 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleY", new float[] { 1.0F, f1 }).setDuration(l);
          paramCGSize.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
        }
        else if (paramInt2 == 180)
        {
          localObject = ObjectAnimator.ofFloat(this.mPlayerLayout, "rotation", new float[] { -paramInt1, -180.0F });
          l = paramInt3;
          localObject = ((ObjectAnimator)localObject).setDuration(l);
          localObjectAnimator1 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleX", new float[] { f1, 1.0F }).setDuration(l);
          localObjectAnimator2 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleY", new float[] { f1, 1.0F }).setDuration(l);
          paramCGSize.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
        }
        else if (paramInt2 == 270)
        {
          localObject = ObjectAnimator.ofFloat(this.mPlayerLayout, "rotation", new float[] { -paramInt1, -270.0F });
          l = paramInt3;
          localObject = ((ObjectAnimator)localObject).setDuration(l);
          localObjectAnimator1 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleX", new float[] { 1.0F, f1 }).setDuration(l);
          localObjectAnimator2 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleY", new float[] { 1.0F, f1 }).setDuration(l);
          paramCGSize.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
        }
        else if (paramInt2 == 0)
        {
          localObject = ObjectAnimator.ofFloat(this.mPlayerLayout, "rotation", new float[] { -paramInt1, 0.0F });
          l = paramInt3;
          localObject = ((ObjectAnimator)localObject).setDuration(l);
          localObjectAnimator1 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleX", new float[] { f1, 1.0F }).setDuration(l);
          localObjectAnimator2 = ObjectAnimator.ofFloat(this.mPlayerLayout, "scaleY", new float[] { f1, 1.0F }).setDuration(l);
          paramCGSize.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
        }
        paramCGSize.start();
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
  
  public IPlayer.PlayerStatus getCurrentStatus()
  {
    try
    {
      if (this.player == null)
      {
        localPlayerStatus = IPlayer.PlayerStatus.ERROR;
        return localPlayerStatus;
      }
      IPlayer.PlayerStatus localPlayerStatus = this.player.currentStatus();
      return localPlayerStatus;
    }
    finally {}
  }
  
  public CMTime getDuration()
  {
    Player localPlayer = this.player;
    if (localPlayer != null) {
      return localPlayer.duration();
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
  
  public CMTime getPosition()
  {
    try
    {
      if (this.player != null)
      {
        localCMTime = this.player.position();
        return localCMTime;
      }
      CMTime localCMTime = CMTime.CMTimeInvalid;
      return localCMTime;
    }
    finally {}
  }
  
  public CGRect getRealRenderSize()
  {
    Player localPlayer = this.player;
    if (localPlayer == null) {
      return null;
    }
    return localPlayer.getGlViewport();
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
  
  public boolean isPlaying()
  {
    try
    {
      if (this.player != null)
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isPlaying:");
        localStringBuilder.append(this.player.isPlaying());
        Logger.d(str, localStringBuilder.toString());
        boolean bool = this.player.isPlaying();
        return bool;
      }
      return false;
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
      if (this.player != null)
      {
        bool = this.player.isReleased();
        if (!bool)
        {
          bool = false;
          break label31;
        }
      }
      boolean bool = true;
      label31:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    if (this.updatingPlayItem) {
      return;
    }
    Object localObject = this.playerListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IPlayer.PlayerListener)((Iterator)localObject).next()).onPositionChanged(paramCMTime);
    }
    localObject = this.mProgressListener;
    if (localObject != null) {
      ((MoviePlayer.onVideoProgressListener)localObject).updateVideoProgress(paramCMTime.getTimeUs() / 1000L);
    }
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    Iterator localIterator = this.playerListeners.iterator();
    while (localIterator.hasNext()) {
      ((IPlayer.PlayerListener)localIterator.next()).onStatusChanged(paramPlayerStatus);
    }
  }
  
  public void pause()
  {
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause: player = ");
      localStringBuilder.append(this.player);
      Logger.d(str, localStringBuilder.toString());
      if (this.player != null)
      {
        abandonAudioFocus();
        this.player.pause();
      }
      else
      {
        this.isAutoPlay = false;
      }
      return;
    }
    finally {}
  }
  
  public void play()
  {
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play: player = ");
      localStringBuilder.append(this.player);
      Logger.d(str, localStringBuilder.toString());
      if (this.player != null)
      {
        if (requestAudioFocus()) {
          this.player.play();
        }
      }
      else {
        this.isAutoPlay = true;
      }
      return;
    }
    finally {}
  }
  
  public void readSnapShootBitmap(OnReadSnapShootListener paramOnReadSnapShootListener)
  {
    this.player.readSnapShootBitmap(paramOnReadSnapShootListener);
  }
  
  public void refresh()
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
      return;
    }
    finally {}
  }
  
  public void release()
  {
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release: player = ");
      localStringBuilder.append(this.player);
      Logger.d(str, localStringBuilder.toString());
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
    TAVComposition localTAVComposition = this.tavComposition;
    CGSize localCGSize1 = localCGSize2;
    if (localTAVComposition != null)
    {
      localCGSize1 = localCGSize2;
      if (localTAVComposition.getRenderSize() != null) {
        localCGSize1 = this.tavComposition.getRenderSize();
      }
    }
    if (paramBoolean)
    {
      paramInt = this.rotation;
      startRotatePlayerContainer(paramInt - 90, paramInt, localCGSize1, 300);
      return;
    }
    paramInt = this.rotation;
    startRotatePlayerContainer(paramInt, paramInt, localCGSize1, 0);
  }
  
  public void seekToTime(CMTime paramCMTime)
  {
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekToTime() called with: cmTime = [");
    localStringBuilder.append(paramCMTime);
    localStringBuilder.append("],player = ");
    localStringBuilder.append(this.player);
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = paramCMTime;
    if (paramCMTime.smallThan(CMTime.CMTimeZero)) {
      localObject = CMTime.CMTimeZero;
    }
    this.seekTime = ((CMTime)localObject);
    paramCMTime = this.player;
    if (paramCMTime != null) {
      paramCMTime.seekToTime((CMTime)localObject);
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
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.setBgColor(paramInt);
    }
  }
  
  public void setLoopPlay(boolean paramBoolean)
  {
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLoopPlay() called with: loopPlay = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("],player = ");
      localStringBuilder.append(this.player);
      Logger.d(str, localStringBuilder.toString());
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
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPlayRange() called with: playRange = [");
      localStringBuilder.append(paramCMTimeRange);
      localStringBuilder.append("],player = ");
      localStringBuilder.append(this.player);
      Logger.d(str, localStringBuilder.toString());
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
    paramRenderContextParams = this.player;
    if (paramRenderContextParams != null) {
      paramRenderContextParams.setRenderContextParams(this.mRenderContextParams);
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
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVolume() called with: volume = [");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append("],player = ");
      localStringBuilder.append(this.player);
      Logger.d(str, localStringBuilder.toString());
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
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateComposition() called with: tavComposition = [");
    localStringBuilder.append(paramTAVComposition);
    localStringBuilder.append("], position = [");
    localStringBuilder.append(paramCMTime);
    localStringBuilder.append("], autoPlay = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    Logger.d((String)localObject, localStringBuilder.toString());
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
    localObject = this.player;
    if ((localObject != null) && (!((Player)localObject).isReleased()))
    {
      this.updatingPlayItem = true;
      this.player.update(paramTAVComposition, paramCMTime, new MoviePlayer.2(this, paramBoolean));
      return;
    }
    this.player = newPlayer(paramTAVComposition, this.seekTime, paramBoolean);
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    updateComposition(paramTAVComposition, CMTime.CMTimeZero, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.player.MoviePlayer
 * JD-Core Version:    0.7.0.1
 */