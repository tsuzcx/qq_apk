package com.tencent.mobileqq.qqlive.player;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public class IlivePlayerWrapper
{
  private static int f = 1;
  public Handler a;
  public HandlerThread b;
  private ITPPlayer c;
  private final AtomicBoolean d = new AtomicBoolean();
  private final AtomicBoolean e = new AtomicBoolean();
  private ITPPlayerListener.IOnPreparedListener g;
  private ITPPlayerListener.IOnInfoListener h;
  private ITPPlayerListener.IOnErrorListener i;
  private ITPPlayerListener.IOnCompletionListener j;
  private ITPPlayerListener.IOnSeekCompleteListener k;
  private ITPPlayerListener.IOnVideoSizeChangedListener l;
  private ITPPlayerListener.IOnStopAsyncCompleteListener m;
  private ITPPlayerListener.IOnStateChangeListener n;
  private final Context o;
  
  public IlivePlayerWrapper(Context paramContext)
  {
    this.o = paramContext;
    paramContext = new StringBuilder();
    paramContext.append("TP-player-thread-");
    int i1 = f;
    f = i1 + 1;
    paramContext.append(i1);
    this.b = new HandlerThread(paramContext.toString());
    this.b.start();
    this.a = new Handler(this.b.getLooper());
    a(new IlivePlayerWrapper.1(this));
  }
  
  private void a(Runnable paramRunnable)
  {
    this.a.post(new IlivePlayerWrapper.RunnableWrapper(paramRunnable));
  }
  
  private void h()
  {
    this.c = TPPlayerFactory.createTPPlayer(this.o, this.b.getLooper(), Looper.getMainLooper());
    this.c.setOnPreparedListener(new IlivePlayerWrapper.2(this));
    this.c.setOnInfoListener(new IlivePlayerWrapper.3(this));
    this.c.setOnErrorListener(new IlivePlayerWrapper.4(this));
    this.c.setOnSeekCompleteListener(new IlivePlayerWrapper.5(this));
    this.c.setOnCompletionListener(new IlivePlayerWrapper.6(this));
    this.c.setOnStopAsyncCompleteListener(new IlivePlayerWrapper.7(this));
    this.c.setOnVideoSizeChangedListener(new IlivePlayerWrapper.8(this));
    this.c.setOnPlayerStateChangeListener(new IlivePlayerWrapper.9(this));
  }
  
  private void i()
  {
    this.d.set(false);
    this.e.set(false);
  }
  
  public void a(Surface paramSurface)
  {
    a(new IlivePlayerWrapper.11(this, paramSurface));
  }
  
  public void a(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.j = paramIOnCompletionListener;
  }
  
  public void a(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    this.i = paramIOnErrorListener;
  }
  
  public void a(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    this.h = paramIOnInfoListener;
  }
  
  public void a(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    this.g = paramIOnPreparedListener;
  }
  
  public void a(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.k = paramIOnSeekCompleteListener;
  }
  
  public void a(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    this.n = paramIOnStateChangeListener;
  }
  
  public void a(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener)
  {
    this.m = paramIOnStopAsyncCompleteListener;
  }
  
  public void a(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.l = paramIOnVideoSizeChangedListener;
  }
  
  public void a(TPOptionalParam paramTPOptionalParam)
  {
    a(new IlivePlayerWrapper.23(this, paramTPOptionalParam));
  }
  
  public void a(String paramString)
  {
    if (a())
    {
      QLog.e("CachePlayer", 1, "CachePlayer load url media wait CachePlayer prepare ");
      return;
    }
    a(new IlivePlayerWrapper.10(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    a(new IlivePlayerWrapper.18(this, paramBoolean));
  }
  
  public boolean a()
  {
    return this.e.get();
  }
  
  public boolean b()
  {
    return this.d.get();
  }
  
  public void c()
  {
    a(new IlivePlayerWrapper.12(this));
  }
  
  public void d()
  {
    i();
    a(new IlivePlayerWrapper.13(this));
  }
  
  public void e()
  {
    i();
    a(new IlivePlayerWrapper.14(this));
  }
  
  public void f()
  {
    i();
    a(new IlivePlayerWrapper.15(this));
  }
  
  public void g()
  {
    a(new IlivePlayerWrapper.22(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.IlivePlayerWrapper
 * JD-Core Version:    0.7.0.1
 */