package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

class TbsMediaPlayerWizard
{
  private static final String TBS_PROXY_CLASS_NAME = "com.tencent.tbs.player.TbsMediaPlayerProxy";
  private DexLoader mDexLoader = null;
  private Object mPlayerProxy = null;
  
  public TbsMediaPlayerWizard(DexLoader paramDexLoader, Context paramContext)
  {
    this.mDexLoader = paramDexLoader;
    this.mPlayerProxy = this.mDexLoader.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public void audio(int paramInt)
  {
    this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "audio", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void close()
  {
    this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "close", new Class[0], new Object[0]);
  }
  
  public float getVolume()
  {
    Float localFloat = (Float)this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "getVolume", new Class[0], new Object[0]);
    if (localFloat != null) {
      return localFloat.floatValue();
    }
    return 0.0F;
  }
  
  public boolean isAvailable()
  {
    return this.mPlayerProxy != null;
  }
  
  public void pause()
  {
    this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
  }
  
  public void play()
  {
    this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
  }
  
  public void seek(long paramLong)
  {
    this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[] { Long.TYPE }, new Object[] { Long.valueOf(paramLong) });
  }
  
  public void setPlayerListener(TbsMediaPlayer.TbsMediaPlayerListener paramTbsMediaPlayerListener)
  {
    this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[] { Object.class }, new Object[] { paramTbsMediaPlayerListener });
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[] { SurfaceTexture.class }, new Object[] { paramSurfaceTexture });
  }
  
  public void setVolume(float paramFloat)
  {
    this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setVolume", new Class[] { Float.TYPE }, new Object[] { Float.valueOf(paramFloat) });
  }
  
  public void startPlay(String paramString, Bundle paramBundle)
  {
    this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
  }
  
  public void subtitle(int paramInt)
  {
    this.mDexLoader.invokeMethod(this.mPlayerProxy, "com.tencent.tbs.player.TbsMediaPlayerProxy", "subtitle", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaPlayerWizard
 * JD-Core Version:    0.7.0.1
 */