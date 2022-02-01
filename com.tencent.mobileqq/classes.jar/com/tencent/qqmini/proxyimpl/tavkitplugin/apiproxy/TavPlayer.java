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
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new TavPlayer.4(this);
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private CMTime jdField_a_of_type_ComTencentTavCoremediaCMTime = CMTime.CMTimeZero;
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerListener jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerListener;
  private OnCompositionUpdateListener jdField_a_of_type_ComTencentTavPlayerOnCompositionUpdateListener;
  private Player jdField_a_of_type_ComTencentTavPlayerPlayer;
  private TAVComposition jdField_a_of_type_ComTencentTavkitCompositionTAVComposition;
  private final String jdField_a_of_type_JavaLangString = "WS_TavPlayer@" + Integer.toHexString(hashCode());
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 1.0F;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = -16777216;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = true;
  private boolean e = true;
  private boolean f = false;
  
  @NonNull
  private Player a(PlayerItem paramPlayerItem, CMTime paramCMTime, boolean paramBoolean)
  {
    Logger.d(this.jdField_a_of_type_JavaLangString, "newPlayer() called with: playerItem = [" + paramPlayerItem + "], position = [" + paramCMTime + "], autoPlay = [" + paramBoolean + "]");
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
    if (this.jdField_a_of_type_ComTencentTavPlayerOnCompositionUpdateListener != null) {
      this.jdField_a_of_type_ComTencentTavPlayerOnCompositionUpdateListener.onUpdated(paramPlayerItem, true);
    }
    this.f = false;
    return paramPlayerItem;
  }
  
  @NonNull
  private PlayerItem a(TAVComposition paramTAVComposition)
  {
    Logger.d(this.jdField_a_of_type_JavaLangString, "buildPlayerItem() called with: tavComposition = [" + paramTAVComposition + "]");
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition);
    paramTAVComposition.setVideoTracksMerge(this.d);
    paramTAVComposition.setAudioTracksMerge(this.e);
    paramTAVComposition = paramTAVComposition.buildSource();
    PlayerItem localPlayerItem = new PlayerItem(paramTAVComposition.getAsset());
    localPlayerItem.setVideoComposition(paramTAVComposition.getVideoComposition());
    localPlayerItem.setAudioMix(paramTAVComposition.getAudioMix());
    return localPlayerItem;
  }
  
  private void a(IPlayer.PlayerListener paramPlayerListener)
  {
    Logger.d(this.jdField_a_of_type_JavaLangString, "setPlayerListener() called with: playerListener = [" + paramPlayerListener + "],player = " + this.jdField_a_of_type_ComTencentTavPlayerPlayer);
    this.jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerListener = paramPlayerListener;
    if (this.jdField_a_of_type_ComTencentTavPlayerPlayer != null) {
      this.jdField_a_of_type_ComTencentTavPlayerPlayer.setPlayerListener(paramPlayerListener);
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1) == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      return;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentTavPlayerPlayer != null) && (!this.jdField_a_of_type_ComTencentTavPlayerPlayer.isReleased()))
    {
      this.jdField_a_of_type_ComTencentTavCoremediaCMTime = this.jdField_a_of_type_ComTencentTavPlayerPlayer.position();
      this.jdField_a_of_type_ComTencentTavPlayerPlayer.release();
    }
    this.jdField_a_of_type_AndroidViewSurface = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentTavPlayerPlayer != null) {
      this.jdField_a_of_type_ComTencentTavPlayerPlayer.updateViewport(paramInt1, paramInt2);
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
    Logger.d(this.jdField_a_of_type_JavaLangString, "setPlayerListener() called with: playerListener = [" + paramPlayerListener + "],player = " + this.jdField_a_of_type_ComTencentTavPlayerPlayer);
    a(new TavPlayer.2(this, paramPlayerListener));
  }
  
  public void a(CMTime paramCMTime)
  {
    Logger.d(this.jdField_a_of_type_JavaLangString, "seekToTime() called with: cmTime = [" + paramCMTime + "],player = " + this.jdField_a_of_type_ComTencentTavPlayerPlayer);
    if (this.jdField_a_of_type_ComTencentTavPlayerPlayer != null) {
      this.jdField_a_of_type_ComTencentTavPlayerPlayer.seekToTime(paramCMTime);
    }
  }
  
  public void a(TAVComposition paramTAVComposition, CMTime paramCMTime, boolean paramBoolean)
  {
    a(paramTAVComposition, paramCMTime, paramBoolean, null);
  }
  
  public void a(TAVComposition paramTAVComposition, CMTime paramCMTime, boolean paramBoolean, OnCompositionUpdateListener paramOnCompositionUpdateListener)
  {
    Logger.d(this.jdField_a_of_type_JavaLangString, "updateComposition() called with: tavComposition = [" + paramTAVComposition + "], position = [" + paramCMTime + "], autoPlay = [" + paramBoolean + "]");
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
    if ((this.jdField_a_of_type_ComTencentTavPlayerPlayer == null) || (this.jdField_a_of_type_ComTencentTavPlayerPlayer.isReleased()))
    {
      this.jdField_a_of_type_ComTencentTavPlayerPlayer = a(paramTAVComposition, paramCMTime, paramBoolean);
      return;
    }
    Player localPlayer = this.jdField_a_of_type_ComTencentTavPlayerPlayer;
    if (paramOnCompositionUpdateListener != null) {}
    for (;;)
    {
      localPlayer.update(paramTAVComposition, paramCMTime, paramOnCompositionUpdateListener);
      this.jdField_a_of_type_ComTencentTavPlayerOnCompositionUpdateListener = null;
      return;
      paramOnCompositionUpdateListener = new TavPlayer.3(this, paramCMTime);
    }
  }
  
  public void a(TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    a(paramTAVComposition, CMTime.CMTimeZero, paramBoolean);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 53	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: new 30	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 307
    //   16: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 90	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:jdField_a_of_type_ComTencentTavPlayerPlayer	Lcom/tencent/tav/player/Player;
    //   23: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 111	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 90	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:jdField_a_of_type_ComTencentTavPlayerPlayer	Lcom/tencent/tav/player/Player;
    //   36: ifnull +17 -> 53
    //   39: aload_0
    //   40: invokespecial 309	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:d	()V
    //   43: aload_0
    //   44: getfield 90	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:jdField_a_of_type_ComTencentTavPlayerPlayer	Lcom/tencent/tav/player/Player;
    //   47: invokevirtual 312	com/tencent/tav/player/Player:pause	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 57	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:jdField_b_of_type_Boolean	Z
    //   58: goto -8 -> 50
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	TavPlayer
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	61	finally
    //   53	58	61	finally
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 53	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: new 30	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 314
    //   16: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 90	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:jdField_a_of_type_ComTencentTavPlayerPlayer	Lcom/tencent/tav/player/Player;
    //   23: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 111	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 90	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:jdField_a_of_type_ComTencentTavPlayerPlayer	Lcom/tencent/tav/player/Player;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: invokespecial 172	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:a	()Z
    //   43: ifeq +10 -> 53
    //   46: aload_0
    //   47: getfield 90	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:jdField_a_of_type_ComTencentTavPlayerPlayer	Lcom/tencent/tav/player/Player;
    //   50: invokevirtual 175	com/tencent/tav/player/Player:play	()V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: iconst_1
    //   58: putfield 57	com/tencent/qqmini/proxyimpl/tavkitplugin/apiproxy/TavPlayer:jdField_b_of_type_Boolean	Z
    //   61: goto -8 -> 53
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	TavPlayer
    //   64	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	64	finally
    //   56	61	64	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer
 * JD-Core Version:    0.7.0.1
 */