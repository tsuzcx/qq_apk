package com.tencent.mobileqq.nearby.now.view.player;

import android.view.View;

public abstract interface IVideoView
{
  public abstract View a();
  
  public abstract void a(long paramLong);
  
  public abstract void a(IVideoView.OnCompletionListener paramOnCompletionListener);
  
  public abstract void a(IVideoView.OnDownloadListener paramOnDownloadListener);
  
  public abstract void a(IVideoView.OnErrorListener paramOnErrorListener);
  
  public abstract void a(IVideoView.OnInfoListener paramOnInfoListener);
  
  public abstract void a(IVideoView.OnPreparedListener paramOnPreparedListener);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, long paramLong);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract long d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract long g();
  
  public abstract int h();
  
  public abstract boolean i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.IVideoView
 * JD-Core Version:    0.7.0.1
 */