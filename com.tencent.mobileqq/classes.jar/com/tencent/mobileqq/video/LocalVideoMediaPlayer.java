package com.tencent.mobileqq.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;

public class LocalVideoMediaPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, IMediaPlayer
{
  private MediaPlayer a;
  private int b = 0;
  private int c = 0;
  private IMediaPlayer.OnCompletionListener d;
  private IMediaPlayer.OnPreparedListener e;
  private IMediaPlayer.OnPlayStateListener f;
  
  public LocalVideoMediaPlayer()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer construct");
    }
  }
  
  public static String b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "null";
          }
          return " error ";
        }
        return " pause ";
      }
      return " playing ";
    }
    return " idle ";
  }
  
  private void c(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LocalVideoMediaPlayer changePlayState ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("LocalVideoMediaPlayer", 2, ((StringBuilder)localObject).toString());
    }
    this.b = paramInt;
    Object localObject = this.f;
    if (localObject != null) {
      ((IMediaPlayer.OnPlayStateListener)localObject).a(this.b);
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer start");
    }
    MediaPlayer localMediaPlayer = this.a;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.start();
      c(1);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LocalVideoMediaPlayer seek to ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("LocalVideoMediaPlayer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null) {}
    try
    {
      ((MediaPlayer)localObject).seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label52:
      break label52;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mMediaPlayer seekTo ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" IllegalStateException");
    QLog.e("LocalVideoMediaPlayer", 2, ((StringBuilder)localObject).toString());
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setDisplay ");
    }
    MediaPlayer localMediaPlayer = this.a;
    if (localMediaPlayer != null) {
      localMediaPlayer.setDisplay(paramSurfaceHolder);
    }
  }
  
  public void a(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setCompletionListener ");
    }
    this.d = paramOnCompletionListener;
  }
  
  public void a(IMediaPlayer.OnPlayStateListener paramOnPlayStateListener)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setPlayStateListener ");
    }
    this.f = paramOnPlayStateListener;
  }
  
  public void a(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setPreparedListener ");
    }
    this.e = paramOnPreparedListener;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("LocalVideoMediaPlayer play ");
      localStringBuilder.append(paramInt);
      QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
    }
    this.c = paramInt;
    try
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("#play#, msec=");
        localStringBuilder.append(paramInt);
        QLog.d("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
      }
      f();
      this.a = new ReportMediaPlayer();
      this.a.setAudioStreamType(3);
      this.a.setOnCompletionListener(this);
      this.a.setOnErrorListener(this);
      this.a.setOnPreparedListener(this);
      this.a.setDataSource(paramString);
      this.a.prepareAsync();
      return true;
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("#play#, msec=");
      localStringBuilder.append(paramInt);
      QLog.e("LocalVideoMediaPlayer", 2, localStringBuilder.toString(), paramString);
      k();
    }
    return false;
  }
  
  public boolean b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer resume");
    }
    if (c() == 2) {
      a();
    }
    return c() == 1;
  }
  
  public int c()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LocalVideoMediaPlayer getPlayState ");
      localStringBuilder.append(this.b);
      QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
    }
    if (this.a != null) {
      return this.b;
    }
    return 3;
  }
  
  public boolean d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer isPlaying ");
    }
    MediaPlayer localMediaPlayer = this.a;
    if (localMediaPlayer != null) {
      return localMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer pause");
    }
    if (d())
    {
      this.a.pause();
      c(2);
    }
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer release");
    }
    MediaPlayer localMediaPlayer = this.a;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.a.release();
      this.a = null;
    }
    c(0);
  }
  
  public int g()
  {
    if (this.a != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LocalVideoMediaPlayer getCurrentPosition ");
        localStringBuilder.append(this.a.getCurrentPosition());
        QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
      }
      return this.a.getCurrentPosition();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getCurrentPosition -1");
    }
    return -1;
  }
  
  public int h()
  {
    if (this.a != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LocalVideoMediaPlayer getDuration ");
        localStringBuilder.append(this.a.getDuration());
        QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
      }
      return this.a.getDuration();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getDuration -1");
    }
    return -1;
  }
  
  public int i()
  {
    if (this.a != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LocalVideoMediaPlayer getVideoWidth ");
        localStringBuilder.append(this.a.getVideoWidth());
        QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
      }
      return this.a.getVideoWidth();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoWidth -1");
    }
    return -1;
  }
  
  public int j()
  {
    if (this.a != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LocalVideoMediaPlayer getVideoHeight ");
        localStringBuilder.append(this.a.getVideoHeight());
        QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
      }
      return this.a.getVideoHeight();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoHeight -1");
    }
    return -1;
  }
  
  public void k()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer reset ");
    }
    MediaPlayer localMediaPlayer = this.a;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.reset();
      c(0);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer onCompletion ");
    }
    c(0);
    paramMediaPlayer = this.d;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a(this);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("mMediaPlayer onError what=");
    paramMediaPlayer.append(paramInt1);
    paramMediaPlayer.append(",extra=");
    paramMediaPlayer.append(paramInt2);
    QLog.e("LocalVideoMediaPlayer", 2, paramMediaPlayer.toString());
    c(3);
    k();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer onPrepared ");
    }
    paramMediaPlayer = this.e;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a(this);
    }
    a();
    int i = this.c;
    if (i > 0) {
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.video.LocalVideoMediaPlayer
 * JD-Core Version:    0.7.0.1
 */