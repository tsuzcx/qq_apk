package com.tencent.tavkit.component;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;

public class TAVPlayer
{
  public static final int VIDEO_PLAYER_HEIGHT = 960;
  public static final int VIDEO_PLAYER_WIDTH = 540;
  private final String TAG;
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  private AudioManager audioManager;
  private boolean audioTracksMerge;
  private int bgColor;
  private OnCompositionUpdateListener compositionUpdateListener;
  private Context context;
  private boolean isAllowInterrupt;
  private boolean isAutoPlay;
  private boolean isResetting;
  private boolean loopPlay;
  @Nullable
  private FrameLayout mPlayerLayout;
  private CMTimeRange playRange;
  private Player player;
  private IPlayer.PlayerListener playerListener;
  private CMTime position;
  private TAVPlayer.PostUpdateThread postUpdateThread;
  private float rate;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  private TAVComposition tavComposition;
  private boolean videoTracksMerge;
  private float volume;
  
  public TAVPlayer()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameTemplatePlayer@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.isAllowInterrupt = true;
    this.isAutoPlay = true;
    this.loopPlay = false;
    this.volume = 1.0F;
    this.position = CMTime.CMTimeZero;
    this.videoTracksMerge = true;
    this.audioTracksMerge = true;
    this.rate = 1.0F;
    this.bgColor = -16777216;
    this.isResetting = false;
    this.audioFocusChangeListener = new TAVPlayer.4(this);
  }
  
  public TAVPlayer(Surface paramSurface, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameTemplatePlayer@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.isAllowInterrupt = true;
    this.isAutoPlay = true;
    this.loopPlay = false;
    this.volume = 1.0F;
    this.position = CMTime.CMTimeZero;
    this.videoTracksMerge = true;
    this.audioTracksMerge = true;
    this.rate = 1.0F;
    this.bgColor = -16777216;
    this.isResetting = false;
    this.audioFocusChangeListener = new TAVPlayer.4(this);
    onSurfaceCreate(paramSurface, paramInt1, paramInt2);
  }
  
  public TAVPlayer(FrameLayout paramFrameLayout)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameTemplatePlayer@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.isAllowInterrupt = true;
    this.isAutoPlay = true;
    this.loopPlay = false;
    this.volume = 1.0F;
    this.position = CMTime.CMTimeZero;
    this.videoTracksMerge = true;
    this.audioTracksMerge = true;
    this.rate = 1.0F;
    this.bgColor = -16777216;
    this.isResetting = false;
    this.audioFocusChangeListener = new TAVPlayer.4(this);
    this.context = paramFrameLayout.getContext();
    this.mPlayerLayout = paramFrameLayout;
    initContentView();
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
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition);
    paramTAVComposition.setVideoTracksMerge(this.videoTracksMerge);
    paramTAVComposition.setAudioTracksMerge(this.audioTracksMerge);
    paramTAVComposition = paramTAVComposition.buildSource();
    localObject = new PlayerItem(paramTAVComposition.getAsset());
    ((PlayerItem)localObject).setVideoComposition(paramTAVComposition.getVideoComposition());
    ((PlayerItem)localObject).setAudioMix(paramTAVComposition.getAudioMix());
    return localObject;
  }
  
  private void initContentView()
  {
    Object localObject = this.mPlayerLayout;
    if (localObject == null) {
      return;
    }
    ((FrameLayout)localObject).removeAllViews();
    localObject = new TextureView(this.context);
    ((TextureView)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.mPlayerLayout.addView((View)localObject);
    ((TextureView)localObject).setSurfaceTextureListener(new TAVPlayer.1(this));
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
    Log.d(this.TAG, "newVersion, onSurfaceTextureAvailable: use surfaceTexture");
    paramPlayerItem = new Player(paramPlayerItem);
    paramPlayerItem.setPlayerListener(this.playerListener);
    paramPlayerItem.setLoop(this.loopPlay);
    paramPlayerItem.setRate(this.rate);
    paramPlayerItem.setBgColor(this.bgColor);
    paramPlayerItem.setPlayRange(this.playRange);
    paramPlayerItem.setVolume(this.volume);
    paramPlayerItem.seekToTime(paramCMTime);
    new PlayerLayer(this.surface, this.surfaceWidth, this.surfaceHeight).setPlayer(paramPlayerItem);
    if ((paramBoolean) && (requestAudioFocus())) {
      paramPlayerItem.play();
    }
    paramCMTime = this.compositionUpdateListener;
    if (paramCMTime != null) {
      paramCMTime.onUpdated(paramPlayerItem, true);
    }
    this.isResetting = false;
    return paramPlayerItem;
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
  
  private void setPlayerListener(IPlayer.PlayerListener paramPlayerListener)
  {
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayerListener() called with: playerListener = [");
    localStringBuilder.append(paramPlayerListener);
    localStringBuilder.append("],player = ");
    localStringBuilder.append(this.player);
    Logger.d((String)localObject, localStringBuilder.toString());
    this.playerListener = paramPlayerListener;
    localObject = this.player;
    if (localObject != null) {
      ((Player)localObject).setPlayerListener(paramPlayerListener);
    }
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
    try
    {
      if (this.player != null)
      {
        localCMTime = this.player.duration();
        return localCMTime;
      }
      CMTime localCMTime = CMTime.CMTimeZero;
      return localCMTime;
    }
    finally {}
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
  
  public boolean isPlaying()
  {
    try
    {
      if (this.player != null)
      {
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
  
  public boolean isResetting()
  {
    return this.isResetting;
  }
  
  public void onSurfaceCreate(Surface paramSurface, int paramInt1, int paramInt2)
  {
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.surface = paramSurface;
    updateComposition(this.tavComposition, this.position, this.isAutoPlay, this.compositionUpdateListener);
  }
  
  public void onSurfaceDestory()
  {
    Player localPlayer = this.player;
    if ((localPlayer != null) && (!localPlayer.isReleased()))
    {
      this.position = this.player.position();
      this.player.release();
    }
    this.surface = null;
  }
  
  public void onSurfaceSizeChanged(int paramInt1, int paramInt2)
  {
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.updateViewport(paramInt1, paramInt2);
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
  
  public void postUpdate(@NonNull TAVPlayer.ICompositionBuilder paramICompositionBuilder, boolean paramBoolean)
  {
    try
    {
      if (this.postUpdateThread == null)
      {
        this.postUpdateThread = new TAVPlayer.PostUpdateThread(this, "PostUpdateThread", null);
        this.postUpdateThread.start();
      }
      TAVPlayer.PostUpdateThread.access$400(this.postUpdateThread, paramICompositionBuilder, paramBoolean);
      return;
    }
    finally {}
  }
  
  public void postUpdate(TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    try
    {
      postUpdate(new TAVPlayer.5(this, paramTAVComposition), paramBoolean);
      return;
    }
    finally
    {
      paramTAVComposition = finally;
      throw paramTAVComposition;
    }
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
        this.position = this.player.position();
        abandonAudioFocus();
        this.player.release();
        this.player = null;
      }
      if (this.postUpdateThread != null)
      {
        this.postUpdateThread.quit();
        this.postUpdateThread = null;
      }
      this.isResetting = false;
      return;
    }
    finally {}
  }
  
  public void reset()
  {
    try
    {
      Log.d(this.TAG, "reset() called");
      this.isResetting = true;
      initContentView();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    localObject = this.player;
    if (localObject != null) {
      ((Player)localObject).seekToTime(paramCMTime);
    }
  }
  
  public void setAllowInterrupt(boolean paramBoolean)
  {
    this.isAllowInterrupt = paramBoolean;
  }
  
  public void setAudioTracksMerge(boolean paramBoolean)
  {
    this.audioTracksMerge = paramBoolean;
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
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
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
  
  public void setPlayerListener(TAVPlayer.PlayerListener paramPlayerListener)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayerListener() called with: playerListener = [");
    localStringBuilder.append(paramPlayerListener);
    localStringBuilder.append("],player = ");
    localStringBuilder.append(this.player);
    Logger.d(str, localStringBuilder.toString());
    setPlayerListener(new TAVPlayer.2(this, paramPlayerListener));
  }
  
  public void setRate(float paramFloat)
  {
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLoopPlay() called with: loopPlay = [");
      localStringBuilder.append(this.loopPlay);
      localStringBuilder.append("],player = ");
      localStringBuilder.append(this.player);
      Logger.d(str, localStringBuilder.toString());
      this.rate = paramFloat;
      if (this.player != null) {
        this.player.setRate(paramFloat);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setVideoTracksMerge(boolean paramBoolean)
  {
    this.videoTracksMerge = paramBoolean;
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
  
  public void stop()
  {
    try
    {
      Logger.d(this.TAG, "stop() called");
      if (this.player != null)
      {
        abandonAudioFocus();
        this.player.stop();
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
    updateComposition(paramTAVComposition, paramCMTime, paramBoolean, null);
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, CMTime paramCMTime, boolean paramBoolean, OnCompositionUpdateListener paramOnCompositionUpdateListener)
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
    this.compositionUpdateListener = paramOnCompositionUpdateListener;
    if (paramTAVComposition == null)
    {
      this.isResetting = false;
      return;
    }
    if (this.surface == null)
    {
      this.isAutoPlay = paramBoolean;
      this.isResetting = false;
      return;
    }
    paramTAVComposition = buildPlayerItem(paramTAVComposition);
    localObject = this.player;
    if ((localObject != null) && (!((Player)localObject).isReleased()))
    {
      localObject = this.player;
      if (paramOnCompositionUpdateListener == null) {
        paramOnCompositionUpdateListener = new TAVPlayer.3(this, paramCMTime, paramBoolean);
      }
      ((Player)localObject).update(paramTAVComposition, paramCMTime, paramOnCompositionUpdateListener);
      this.compositionUpdateListener = null;
      return;
    }
    this.player = newPlayer(paramTAVComposition, paramCMTime, paramBoolean);
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    updateComposition(paramTAVComposition, CMTime.CMTimeZero, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer
 * JD-Core Version:    0.7.0.1
 */