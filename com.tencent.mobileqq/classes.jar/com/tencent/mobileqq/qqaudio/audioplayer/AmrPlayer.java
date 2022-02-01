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
    return (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
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
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
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
    localHashMap.put("errCode", paramInt + "");
    localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
    localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
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
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread " + this.jdField_a_of_type_JavaLangString);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread onPlayThreadStart");
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener.c();
      if (QLog.isColorLevel()) {
        QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread start");
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      int i = this.jdField_a_of_type_Int - 1000;
      this.jdField_a_of_type_Int = i;
      if (i > 0) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener == null) {}
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = localException.toString();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener.a(this, 8, 0, (String)paramMessage.obj);
        c(0);
      }
    }
    while ((paramMessage.what != 2) || (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener == null)) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener.a();
    return true;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onCompletion");
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAmrPlayer$AmrPlayerThread = null;
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener.a();
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onError");
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAmrPlayer$AmrPlayerThread = null;
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayerListener.a(this, 9, 0, "what = " + paramInt1 + " extra=" + paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AmrPlayer
 * JD-Core Version:    0.7.0.1
 */