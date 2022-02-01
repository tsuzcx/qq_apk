package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Surface;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;

public class TavPlayer
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private CMTime jdField_a_of_type_ComTencentTavCoremediaCMTime;
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerListener jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerListener;
  private OnCompositionUpdateListener jdField_a_of_type_ComTencentTavPlayerOnCompositionUpdateListener;
  private Player jdField_a_of_type_ComTencentTavPlayerPlayer;
  private TAVComposition jdField_a_of_type_ComTencentTavkitCompositionTAVComposition;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public TavPlayer()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WS_TavPlayer@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentTavCoremediaCMTime = CMTime.CMTimeZero;
    this.d = true;
    this.e = true;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_c_of_type_Int = -16777216;
    this.f = false;
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new TavPlayer.4(this);
  }
  
  @NonNull
  private Player a(PlayerItem paramPlayerItem, CMTime paramCMTime, boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("newPlayer() called with: playerItem = [");
    localStringBuilder.append(paramPlayerItem);
    localStringBuilder.append("], position = [");
    localStringBuilder.append(paramCMTime);
    localStringBuilder.append("], autoPlay = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
    Log.d(this.jdField_a_of_type_JavaLangString, "newVersion, onSurfaceTextureAvailable: use surfaceTexture");
    paramPlayerItem = new Player(paramPlayerItem);
    paramPlayerItem.setPlayerListener(this.jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerListener);
    paramPlayerItem.setLoop(this.jdField_c_of_type_Boolean);
    paramPlayerItem.setRate(this.jdField_b_of_type_Float);
    paramPlayerItem.setBgColor(this.jdField_c_of_type_Int);
    paramPlayerItem.setPlayRange(this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange);
    paramPlayerItem.setVolume(this.jdField_a_of_type_Float);
    paramPlayerItem.seekToTime(paramCMTime);
    new PlayerLayer(this.jdField_a_of_type_AndroidViewSurface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int).setPlayer(paramPlayerItem);
    if ((paramBoolean) && (a())) {
      paramPlayerItem.play();
    }
    paramCMTime = this.jdField_a_of_type_ComTencentTavPlayerOnCompositionUpdateListener;
    if (paramCMTime != null) {
      paramCMTime.onUpdated(paramPlayerItem, true);
    }
    this.f = false;
    return paramPlayerItem;
  }
  
  @NonNull
  private PlayerItem a(TAVComposition paramTAVComposition)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildPlayerItem() called with: tavComposition = [");
    localStringBuilder.append(paramTAVComposition);
    localStringBuilder.append("]");
    Logger.d((String)localObject, localStringBuilder.toString());
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition);
    paramTAVComposition.setVideoTracksMerge(this.d);
    paramTAVComposition.setAudioTracksMerge(this.e);
    paramTAVComposition = paramTAVComposition.buildSource();
    localObject = new PlayerItem(paramTAVComposition.getAsset());
    ((PlayerItem)localObject).setVideoComposition(paramTAVComposition.getVideoComposition());
    ((PlayerItem)localObject).setAudioMix(paramTAVComposition.getAudioMix());
    return localObject;
  }
  
  private void a(IPlayer.PlayerListener paramPlayerListener)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayerListener() called with: playerListener = [");
    localStringBuilder.append(paramPlayerListener);
    localStringBuilder.append("],player = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTavPlayerPlayer);
    Logger.d((String)localObject, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerListener = paramPlayerListener;
    localObject = this.jdField_a_of_type_ComTencentTavPlayerPlayer;
    if (localObject != null) {
      ((Player)localObject).setPlayerListener(paramPlayerListener);
    }
  }
  
  private boolean a()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if (localContext == null) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)localContext.getSystemService("audio"));
    }
    return this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1) == 1;
  }
  
  private void d()
  {
    AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localAudioManager == null) {
      return;
    }
    localAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
  }
  
  public void a()
  {
    Player localPlayer = this.jdField_a_of_type_ComTencentTavPlayerPlayer;
    if ((localPlayer != null) && (!localPlayer.isReleased()))
    {
      this.jdField_a_of_type_ComTencentTavCoremediaCMTime = this.jdField_a_of_type_ComTencentTavPlayerPlayer.position();
      this.jdField_a_of_type_ComTencentTavPlayerPlayer.release();
    }
    this.jdField_a_of_type_AndroidViewSurface = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Player localPlayer = this.jdField_a_of_type_ComTencentTavPlayerPlayer;
    if (localPlayer != null) {
      localPlayer.updateViewport(paramInt1, paramInt2);
    }
  }
  
  public void a(Surface paramSurface, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    a(this.jdField_a_of_type_ComTencentTavkitCompositionTAVComposition, this.jdField_a_of_type_ComTencentTavCoremediaCMTime, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentTavPlayerOnCompositionUpdateListener);
  }
  
  public void a(TavPlayer.PlayerListener paramPlayerListener)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayerListener() called with: playerListener = [");
    localStringBuilder.append(paramPlayerListener);
    localStringBuilder.append("],player = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTavPlayerPlayer);
    Logger.d(str, localStringBuilder.toString());
    a(new TavPlayer.2(this, paramPlayerListener));
  }
  
  public void a(CMTime paramCMTime)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekToTime() called with: cmTime = [");
    localStringBuilder.append(paramCMTime);
    localStringBuilder.append("],player = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTavPlayerPlayer);
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentTavPlayerPlayer;
    if (localObject != null) {
      ((Player)localObject).seekToTime(paramCMTime);
    }
  }
  
  public void a(TAVComposition paramTAVComposition, CMTime paramCMTime, boolean paramBoolean)
  {
    a(paramTAVComposition, paramCMTime, paramBoolean, null);
  }
  
  public void a(TAVComposition paramTAVComposition, CMTime paramCMTime, boolean paramBoolean, OnCompositionUpdateListener paramOnCompositionUpdateListener)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateComposition() called with: tavComposition = [");
    localStringBuilder.append(paramTAVComposition);
    localStringBuilder.append("], position = [");
    localStringBuilder.append(paramCMTime);
    localStringBuilder.append("], autoPlay = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    Logger.d((String)localObject, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentTavkitCompositionTAVComposition = paramTAVComposition;
    this.jdField_a_of_type_ComTencentTavCoremediaCMTime = paramCMTime;
    this.jdField_a_of_type_ComTencentTavPlayerOnCompositionUpdateListener = paramOnCompositionUpdateListener;
    if (paramTAVComposition == null)
    {
      this.f = false;
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidViewSurface == null)
    {
      this.f = false;
      return;
    }
    paramTAVComposition = a(paramTAVComposition);
    localObject = this.jdField_a_of_type_ComTencentTavPlayerPlayer;
    if ((localObject != null) && (!((Player)localObject).isReleased()))
    {
      localObject = this.jdField_a_of_type_ComTencentTavPlayerPlayer;
      if (paramOnCompositionUpdateListener == null) {
        paramOnCompositionUpdateListener = new TavPlayer.3(this, paramCMTime);
      }
      ((Player)localObject).update(paramTAVComposition, paramCMTime, paramOnCompositionUpdateListener);
      this.jdField_a_of_type_ComTencentTavPlayerOnCompositionUpdateListener = null;
      return;
    }
    this.jdField_a_of_type_ComTencentTavPlayerPlayer = a(paramTAVComposition, paramCMTime, paramBoolean);
  }
  
  public void a(TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    a(paramTAVComposition, CMTime.CMTimeZero, paramBoolean);
  }
  
  public void b()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause: player = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentTavPlayerPlayer);
      Logger.d(str, localStringBuilder.toString());
      if (this.jdField_a_of_type_ComTencentTavPlayerPlayer != null)
      {
        d();
        this.jdField_a_of_type_ComTencentTavPlayerPlayer.pause();
      }
      else
      {
        this.jdField_b_of_type_Boolean = false;
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play: player = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentTavPlayerPlayer);
      Logger.d(str, localStringBuilder.toString());
      if (this.jdField_a_of_type_ComTencentTavPlayerPlayer != null)
      {
        if (a()) {
          this.jdField_a_of_type_ComTencentTavPlayerPlayer.play();
        }
      }
      else {
        this.jdField_b_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer
 * JD-Core Version:    0.7.0.1
 */