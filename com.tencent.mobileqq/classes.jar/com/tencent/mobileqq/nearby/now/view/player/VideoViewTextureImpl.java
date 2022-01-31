package com.tencent.mobileqq.nearby.now.view.player;

import afea;
import afeb;
import afec;
import afed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class VideoViewTextureImpl
  implements IVideoView
{
  public TextureVideoView a;
  
  public VideoViewTextureImpl(Context paramContext)
  {
    this.a = new TextureVideoView(paramContext.getApplicationContext());
  }
  
  public int a()
  {
    if (this.a == null) {
      return 0;
    }
    return (int)(this.a.getCurrentPosition() / (this.a.getDuration() + 0.1D) * 100.0D);
  }
  
  public long a()
  {
    return this.a.getCurrentPosition();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(long paramLong)
  {
    this.a.seekTo((int)paramLong);
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    this.a.setOnCompletionListener(new afea(this, paramOnCompletionListener));
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener) {}
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    this.a.setOnErrorListener(new afeb(this, paramOnErrorListener, null));
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    this.a.setOnInfoListener(new afec(this, paramOnInfoListener));
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    TextureVideoView localTextureVideoView = this.a;
    if (paramOnPreparedListener == null) {}
    for (paramOnPreparedListener = null;; paramOnPreparedListener = new afed(this, paramOnPreparedListener))
    {
      localTextureVideoView.setOnPreparedListener(paramOnPreparedListener);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (FileCacheUtils.a(new File(paramString2))) {
        paramString1 = paramString2;
      }
    }
    this.a.setVideoPath(paramString1);
  }
  
  public boolean a()
  {
    return this.a.isPlaying();
  }
  
  public void b()
  {
    this.a.start();
  }
  
  public void c()
  {
    this.a.pause();
  }
  
  public void d()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.VideoViewTextureImpl
 * JD-Core Version:    0.7.0.1
 */