package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.lang.ref.WeakReference;

public class VideoTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static IVideoOuterStatusListener f;
  final Runnable a = new VideoTextureView.6(this);
  private MediaPlayer b;
  private Surface c;
  private VideoTextureView.WeakHandler d;
  private WeakReference<Context> e;
  private int g = 0;
  private String h = "https://www.w3schools.com/html/movie.mp4";
  
  public VideoTextureView(Context paramContext)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    this.e = new WeakReference(paramContext);
    this.d = new VideoTextureView.WeakHandler(paramContext);
  }
  
  private void b()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((MediaPlayer)localObject).isPlaying()) {
        this.b.stop();
      }
      this.b.release();
      this.b = null;
    }
    localObject = this.d;
    if (localObject != null) {
      ((VideoTextureView.WeakHandler)localObject).removeCallbacks(this.a);
    }
  }
  
  public void a(String paramString)
  {
    MediaPlayer localMediaPlayer = this.b;
    if (localMediaPlayer == null) {
      return;
    }
    try
    {
      localMediaPlayer.setDataSource(paramString);
      this.b.setAudioStreamType(3);
      this.b.setOnPreparedListener(new VideoTextureView.2(this));
      this.b.prepareAsync();
      this.b.setOnCompletionListener(new VideoTextureView.3(this));
      this.b.setOnSeekCompleteListener(new VideoTextureView.4(this));
      this.b.setOnErrorListener(new VideoTextureView.5(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.c = new Surface(paramSurfaceTexture);
    if (this.b == null) {
      this.b = new ReportMediaPlayer();
    }
    this.b.setSurface(this.c);
    a(this.h);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setVideoPath(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView
 * JD-Core Version:    0.7.0.1
 */