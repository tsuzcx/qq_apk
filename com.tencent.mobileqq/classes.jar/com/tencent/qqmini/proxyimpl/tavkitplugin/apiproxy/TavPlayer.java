package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Surface;
import com.tencent.qqmini.proxyimpl.tavkitplugin.ITAVReleaseAble;
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

class TavPlayer
  implements ITAVReleaseAble
{
  private final String a;
  private Context b;
  private AudioManager c;
  private boolean d;
  private boolean e;
  private Player f;
  private TAVComposition g;
  private int h;
  private int i;
  private IPlayer.PlayerListener j;
  private boolean k;
  private CMTimeRange l;
  private float m;
  private CMTime n;
  private OnCompositionUpdateListener o;
  private Surface p;
  private boolean q;
  private boolean r;
  private float s;
  private int t;
  private boolean u;
  private AudioManager.OnAudioFocusChangeListener v;
  
  TavPlayer()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WS_TavPlayer@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.a = localStringBuilder.toString();
    this.d = true;
    this.e = true;
    this.k = false;
    this.m = 1.0F;
    this.n = CMTime.CMTimeZero;
    this.q = true;
    this.r = true;
    this.s = 1.0F;
    this.t = -16777216;
    this.u = false;
    this.v = new TavPlayer.4(this);
  }
  
  @NonNull
  private Player a(PlayerItem paramPlayerItem, CMTime paramCMTime, boolean paramBoolean)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("newPlayer() called with: playerItem = [");
    localStringBuilder.append(paramPlayerItem);
    localStringBuilder.append("], position = [");
    localStringBuilder.append(paramCMTime);
    localStringBuilder.append("], autoPlay = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
    Log.d(this.a, "newVersion, onSurfaceTextureAvailable: use surfaceTexture");
    paramPlayerItem = new Player(paramPlayerItem);
    paramPlayerItem.setPlayerListener(this.j);
    paramPlayerItem.setLoop(this.k);
    paramPlayerItem.setRate(this.s);
    paramPlayerItem.setBgColor(this.t);
    paramPlayerItem.setPlayRange(this.l);
    paramPlayerItem.setVolume(this.m);
    paramPlayerItem.seekToTime(paramCMTime);
    new PlayerLayer(this.p, this.h, this.i).setPlayer(paramPlayerItem);
    if ((paramBoolean) && (e())) {
      paramPlayerItem.play();
    }
    paramCMTime = this.o;
    if (paramCMTime != null) {
      paramCMTime.onUpdated(paramPlayerItem, true);
    }
    this.u = false;
    return paramPlayerItem;
  }
  
  @NonNull
  private PlayerItem a(TAVComposition paramTAVComposition)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildPlayerItem() called with: tavComposition = [");
    localStringBuilder.append(paramTAVComposition);
    localStringBuilder.append("]");
    Logger.d((String)localObject, localStringBuilder.toString());
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition);
    paramTAVComposition.setVideoTracksMerge(this.q);
    paramTAVComposition.setAudioTracksMerge(this.r);
    paramTAVComposition = paramTAVComposition.buildSource();
    localObject = new PlayerItem(paramTAVComposition.getAsset());
    ((PlayerItem)localObject).setVideoComposition(paramTAVComposition.getVideoComposition());
    ((PlayerItem)localObject).setAudioMix(paramTAVComposition.getAudioMix());
    return localObject;
  }
  
  private void a(IPlayer.PlayerListener paramPlayerListener)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayerListener() called with: playerListener = [");
    localStringBuilder.append(paramPlayerListener);
    localStringBuilder.append("],player = ");
    localStringBuilder.append(this.f);
    Logger.d((String)localObject, localStringBuilder.toString());
    this.j = paramPlayerListener;
    localObject = this.f;
    if (localObject != null) {
      ((Player)localObject).setPlayerListener(paramPlayerListener);
    }
  }
  
  private boolean e()
  {
    Context localContext = this.b;
    if (localContext == null) {
      return true;
    }
    if (this.c == null) {
      this.c = ((AudioManager)localContext.getSystemService("audio"));
    }
    return this.c.requestAudioFocus(this.v, 3, 1) == 1;
  }
  
  private void f()
  {
    AudioManager localAudioManager = this.c;
    if (localAudioManager == null) {
      return;
    }
    localAudioManager.abandonAudioFocus(this.v);
  }
  
  public void a()
  {
    try
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release: player = ");
      localStringBuilder.append(this.f);
      Logger.d(str, localStringBuilder.toString());
      if (this.f != null)
      {
        this.n = this.f.position();
        f();
        this.f.release();
        this.f = null;
      }
      this.u = false;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Player localPlayer = this.f;
    if (localPlayer != null) {
      localPlayer.updateViewport(paramInt1, paramInt2);
    }
  }
  
  public void a(Surface paramSurface, int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    this.p = paramSurface;
    a(this.g, this.n, this.e, this.o);
  }
  
  public void a(TavPlayer.PlayerListener paramPlayerListener)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayerListener() called with: playerListener = [");
    localStringBuilder.append(paramPlayerListener);
    localStringBuilder.append("],player = ");
    localStringBuilder.append(this.f);
    Logger.d(str, localStringBuilder.toString());
    a(new TavPlayer.2(this, paramPlayerListener));
  }
  
  public void a(CMTime paramCMTime)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekToTime() called with: cmTime = [");
    localStringBuilder.append(paramCMTime);
    localStringBuilder.append("],player = ");
    localStringBuilder.append(this.f);
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = this.f;
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
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateComposition() called with: tavComposition = [");
    localStringBuilder.append(paramTAVComposition);
    localStringBuilder.append("], position = [");
    localStringBuilder.append(paramCMTime);
    localStringBuilder.append("], autoPlay = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    Logger.d((String)localObject, localStringBuilder.toString());
    this.g = paramTAVComposition;
    this.n = paramCMTime;
    this.o = paramOnCompositionUpdateListener;
    if (paramTAVComposition == null)
    {
      this.u = false;
      return;
    }
    this.e = paramBoolean;
    if (this.p == null)
    {
      this.u = false;
      return;
    }
    paramTAVComposition = a(paramTAVComposition);
    localObject = this.f;
    if ((localObject != null) && (!((Player)localObject).isReleased()))
    {
      localObject = this.f;
      if (paramOnCompositionUpdateListener == null) {
        paramOnCompositionUpdateListener = new TavPlayer.3(this, paramCMTime);
      }
      ((Player)localObject).update(paramTAVComposition, paramCMTime, paramOnCompositionUpdateListener);
      this.o = null;
      return;
    }
    this.f = a(paramTAVComposition, paramCMTime, paramBoolean);
  }
  
  public void a(TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    a(paramTAVComposition, CMTime.CMTimeZero, paramBoolean);
  }
  
  public void b()
  {
    a();
    this.p = null;
  }
  
  public void c()
  {
    try
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause: player = ");
      localStringBuilder.append(this.f);
      Logger.d(str, localStringBuilder.toString());
      if (this.f != null)
      {
        f();
        this.f.pause();
      }
      else
      {
        this.e = false;
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    try
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play: player = ");
      localStringBuilder.append(this.f);
      Logger.d(str, localStringBuilder.toString());
      if (this.f != null)
      {
        if (e()) {
          this.f.play();
        }
      }
      else {
        this.e = true;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer
 * JD-Core Version:    0.7.0.1
 */