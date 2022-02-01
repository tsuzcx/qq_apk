package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

class q
{
  private DexLoader a = null;
  private Object b = null;
  
  public q(DexLoader paramDexLoader, Context paramContext)
  {
    this.a = paramDexLoader;
    this.b = this.a.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public void a(float paramFloat)
  {
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setVolume", new Class[] { Float.TYPE }, new Object[] { Float.valueOf(paramFloat) });
  }
  
  public void a(int paramInt)
  {
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "subtitle", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong)
  {
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[] { Long.TYPE }, new Object[] { Long.valueOf(paramLong) });
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[] { SurfaceTexture.class }, new Object[] { paramSurfaceTexture });
  }
  
  public void a(TbsMediaPlayer.TbsMediaPlayerListener paramTbsMediaPlayerListener)
  {
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[] { Object.class }, new Object[] { paramTbsMediaPlayerListener });
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
  }
  
  public boolean a()
  {
    return this.b != null;
  }
  
  public float b()
  {
    Float localFloat = (Float)this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "getVolume", new Class[0], new Object[0]);
    if (localFloat != null) {
      return localFloat.floatValue();
    }
    return 0.0F;
  }
  
  public void b(int paramInt)
  {
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "audio", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void c()
  {
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
  }
  
  public void d()
  {
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
  }
  
  public void e()
  {
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "close", new Class[0], new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.q
 * JD-Core Version:    0.7.0.1
 */