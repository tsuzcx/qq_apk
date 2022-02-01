package com.tencent.mobileqq.qqaudio.audioplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AmrPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Handler.Callback, IAudioFilePlayer
{
  protected MediaPlayer a;
  protected int b = -1;
  protected String c;
  protected IAudioFilePlayerListener d;
  protected AmrPlayer.AmrPlayerThread e;
  protected WeakReferenceHandler f;
  protected AtomicBoolean g = new AtomicBoolean(false);
  Runnable h = new AmrPlayer.1(this);
  
  public AmrPlayer()
  {
    this.a = new MediaPlayer();
    this.f = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public AmrPlayer(Context paramContext, int paramInt)
  {
    this.a = MediaPlayer.create(paramContext, paramInt);
    this.f = new WeakReferenceHandler(this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr start");
    }
    this.a.setOnCompletionListener(this);
    this.a.setOnPreparedListener(this);
    this.a.setOnErrorListener(this);
    if (this.e == null)
    {
      this.e = new AmrPlayer.AmrPlayerThread(this);
      this.e.start();
    }
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr setStreamType");
    }
    this.a.setAudioStreamType(paramInt);
  }
  
  public void a(int paramInt, byte paramByte) {}
  
  public void a(IAudioFilePlayerListener paramIAudioFilePlayerListener)
  {
    this.d = paramIAudioFilePlayerListener;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr setDataSource");
    }
    this.c = paramString;
    this.a.setDataSource(paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr reStart");
    }
    this.a.setOnCompletionListener(this);
    this.a.setOnPreparedListener(this);
    this.a.setOnErrorListener(this);
    Runnable localRunnable = this.h;
    if (localRunnable != null) {
      ThreadManager.post(localRunnable, 5, null, false);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr seekTo");
    }
    this.b = paramInt;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr stop");
    }
    this.a.stop();
    this.g.set(false);
    this.e = null;
  }
  
  protected void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_succ_flag", "0");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("errCode", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append("");
    localHashMap.put("param_version", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.MODEL);
    localHashMap.put("param_deviceName", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttAmrPlaryerError", true, 0L, 0L, localHashMap, null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr reset");
    }
    this.a.reset();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr release");
    }
    this.g.set(false);
    this.a.release();
  }
  
  public boolean f()
  {
    MediaPlayer localMediaPlayer = this.a;
    return (localMediaPlayer != null) && (localMediaPlayer.isPlaying());
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr pause");
    }
    this.a.pause();
  }
  
  public int h()
  {
    if (!this.g.get()) {
      return 0;
    }
    return this.a.getCurrentPosition();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      IAudioFilePlayerListener localIAudioFilePlayerListener = this.d;
      if (localIAudioFilePlayerListener != null)
      {
        localIAudioFilePlayerListener.a(this, 8, 0, (String)paramMessage.obj);
        c(0);
        return true;
      }
    }
    else if (paramMessage.what == 2)
    {
      paramMessage = this.d;
      if (paramMessage != null) {
        paramMessage.a();
      }
    }
    return true;
  }
  
  public int i()
  {
    if (!this.g.get()) {
      return 0;
    }
    return this.a.getDuration();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr prepare");
    }
    this.a.prepare();
    this.g.set(true);
  }
  
  protected void k()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playAmr AmrPlayerThread ");
      localStringBuilder.append(this.c);
      QLog.d("AmrPlayer", 2, localStringBuilder.toString());
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread onPlayThreadStart");
      }
      this.d.j();
      if (QLog.isColorLevel()) {
        QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread start");
      }
      this.a.start();
      int i = this.b - 1000;
      this.b = i;
      if (i > 0)
      {
        this.a.seekTo(this.b);
        return;
      }
    }
    catch (Exception localException)
    {
      if (this.d != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.obj = localException.toString();
        this.f.sendMessage(localMessage);
      }
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onCompletion");
    }
    this.e = null;
    paramMediaPlayer = this.d;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a();
    }
    this.g.set(false);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onError");
    }
    this.e = null;
    paramMediaPlayer = this.d;
    if (paramMediaPlayer != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error (");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(")");
      paramMediaPlayer.a(this, 9, 0, localStringBuilder.toString());
    }
    c(paramInt1);
    this.g.set(false);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onPrepared");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AmrPlayer
 * JD-Core Version:    0.7.0.1
 */