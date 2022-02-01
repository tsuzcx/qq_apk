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
  protected int a;
  protected MediaPlayer a;
  protected AmrPlayer.AmrPlayerThread a;
  protected IAudioFilePlayerListener a;
  protected WeakReferenceHandler a;
  Runnable a;
  protected String a;
  protected AtomicBoolean a;
  
  public AmrPlayer()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangRunnable = new AmrPlayer.1(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public AmrPlayer(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangRunnable = new AmrPlayer.1(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(paramContext, paramInt);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
  }
  
  public int a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr start");
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAmrPlayer$AmrPlayerThread == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAmrPlayer$AmrPlayerThread = new AmrPlayer.AmrPlayerThread(this);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAmrPlayer$AmrPlayerThread.start();
    }
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr setStreamType");
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(paramInt);
  }
  
  public void a(int paramInt, byte paramByte) {}
  
  public void a(IAudioFilePlayerListener paramIAudioFilePlayerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener = paramIAudioFilePlayerListener;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr setDataSource");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
  }
  
  public boolean a()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    return (localMediaPlayer != null) && (localMediaPlayer.isPlaying());
  }
  
  public int b()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr reStart");
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null) {
      ThreadManager.post(localRunnable, 5, null, false);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr seekTo");
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr stop");
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAmrPlayer$AmrPlayerThread = null;
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
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr release");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr pause");
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr prepare");
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  protected void h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playAmr AmrPlayerThread ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("AmrPlayer", 2, localStringBuilder.toString());
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread onPlayThreadStart");
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener.f();
      if (QLog.isColorLevel()) {
        QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread start");
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      int i = this.jdField_a_of_type_Int - 1000;
      this.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
        return;
      }
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.obj = localException.toString();
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      IAudioFilePlayerListener localIAudioFilePlayerListener = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener;
      if (localIAudioFilePlayerListener != null)
      {
        localIAudioFilePlayerListener.a(this, 8, 0, (String)paramMessage.obj);
        c(0);
        return true;
      }
    }
    else if (paramMessage.what == 2)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener;
      if (paramMessage != null) {
        paramMessage.a();
      }
    }
    return true;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onCompletion");
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAmrPlayer$AmrPlayerThread = null;
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a();
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onError");
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAmrPlayer$AmrPlayerThread = null;
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener;
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
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onPrepared");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AmrPlayer
 * JD-Core Version:    0.7.0.1
 */