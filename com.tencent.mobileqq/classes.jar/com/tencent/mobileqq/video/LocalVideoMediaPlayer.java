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
  private int jdField_a_of_type_Int = 0;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private IMediaPlayer.OnCompletionListener jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnCompletionListener;
  private IMediaPlayer.OnPlayStateListener jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPlayStateListener;
  private IMediaPlayer.OnPreparedListener jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPreparedListener;
  private int b = 0;
  
  public LocalVideoMediaPlayer()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer construct");
    }
  }
  
  public static String a(int paramInt)
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
  
  private void b(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LocalVideoMediaPlayer changePlayState ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("LocalVideoMediaPlayer", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPlayStateListener;
    if (localObject != null) {
      ((IMediaPlayer.OnPlayStateListener)localObject).a(this.jdField_a_of_type_Int);
    }
  }
  
  public int a()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LocalVideoMediaPlayer getPlayState ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      return this.jdField_a_of_type_Int;
    }
    return 3;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer start");
    }
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.start();
      b(1);
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
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
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
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.setDisplay(paramSurfaceHolder);
    }
  }
  
  public void a(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setCompletionListener ");
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnCompletionListener = paramOnCompletionListener;
  }
  
  public void a(IMediaPlayer.OnPlayStateListener paramOnPlayStateListener)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setPlayStateListener ");
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPlayStateListener = paramOnPlayStateListener;
  }
  
  public void a(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setPreparedListener ");
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPreparedListener = paramOnPreparedListener;
  }
  
  public boolean a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer resume");
    }
    if (a() == 2) {
      a();
    }
    return a() == 1;
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
    this.b = paramInt;
    try
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("#play#, msec=");
        localStringBuilder.append(paramInt);
        QLog.d("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
      }
      c();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new ReportMediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      return true;
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("#play#, msec=");
      localStringBuilder.append(paramInt);
      QLog.e("LocalVideoMediaPlayer", 2, localStringBuilder.toString(), paramString);
      d();
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LocalVideoMediaPlayer getCurrentPosition ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition());
        QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
      }
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getCurrentPosition -1");
    }
    return -1;
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer pause");
    }
    if (b())
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      b(2);
    }
  }
  
  public boolean b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer isPlaying ");
    }
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      return localMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LocalVideoMediaPlayer getDuration ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration());
        QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
      }
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getDuration -1");
    }
    return -1;
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer release");
    }
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    b(0);
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LocalVideoMediaPlayer getVideoWidth ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth());
        QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
      }
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoWidth -1");
    }
    return -1;
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer reset ");
    }
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.reset();
      b(0);
    }
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LocalVideoMediaPlayer getVideoHeight ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight());
        QLog.i("LocalVideoMediaPlayer", 2, localStringBuilder.toString());
      }
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoHeight -1");
    }
    return -1;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer onCompletion ");
    }
    b(0);
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnCompletionListener;
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
    b(3);
    d();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer onPrepared ");
    }
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqVideoIMediaPlayer$OnPreparedListener;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a(this);
    }
    a();
    int i = this.b;
    if (i > 0) {
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.video.LocalVideoMediaPlayer
 * JD-Core Version:    0.7.0.1
 */