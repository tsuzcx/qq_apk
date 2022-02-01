package com.tencent.mobileqq.nearby.now.view.player.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnCompletionListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnDownloadListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnErrorListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnInfoListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnPreparedListener;
import java.io.File;

public class VideoViewTextureImpl
  implements IVideoView
{
  TextureVideoView a;
  
  public VideoViewTextureImpl(Context paramContext)
  {
    this.a = new TextureVideoView(paramContext.getApplicationContext());
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.a.seekTo((int)paramLong);
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    this.a.setOnCompletionListener(new VideoViewTextureImpl.1(this, paramOnCompletionListener));
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener) {}
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    this.a.setOnErrorListener(new VideoViewTextureImpl.2(this, paramOnErrorListener, null));
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    this.a.setOnInfoListener(new VideoViewTextureImpl.3(this, paramOnInfoListener));
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    TextureVideoView localTextureVideoView = this.a;
    if (paramOnPreparedListener == null) {
      paramOnPreparedListener = null;
    } else {
      paramOnPreparedListener = new VideoViewTextureImpl.4(this, paramOnPreparedListener);
    }
    localTextureVideoView.setOnPreparedListener(paramOnPreparedListener);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString2)) || (!FileCacheUtils.a(new File(paramString2)))) {
      paramString2 = paramString3;
    }
    this.a.setVideoPath(paramString2);
  }
  
  public void b()
  {
    this.a.b();
  }
  
  public void c()
  {
    this.a.start();
  }
  
  public long d()
  {
    return this.a.getCurrentPosition();
  }
  
  public void e()
  {
    this.a.pause();
  }
  
  public void f()
  {
    c();
  }
  
  public long g()
  {
    return this.a.getDuration();
  }
  
  public int h()
  {
    TextureVideoView localTextureVideoView = this.a;
    if (localTextureVideoView == null) {
      return 0;
    }
    double d1 = localTextureVideoView.getCurrentPosition();
    double d2 = this.a.getDuration();
    Double.isNaN(d2);
    Double.isNaN(d1);
    return (int)(d1 / (d2 + 0.1D) * 100.0D);
  }
  
  public boolean i()
  {
    return this.a.isPlaying();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTextureImpl
 * JD-Core Version:    0.7.0.1
 */