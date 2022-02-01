package com.tencent.mobileqq.ptt.player;

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
import azch;
import azci;
import bjng;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AmrPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Handler.Callback, azch
{
  private int jdField_a_of_type_Int = -1;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private azci jdField_a_of_type_Azci;
  private bjng jdField_a_of_type_Bjng;
  private AmrPlayer.AmrPlayerThread jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread;
  Runnable jdField_a_of_type_JavaLangRunnable = new AmrPlayer.1(this);
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public AmrPlayer()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_Bjng = new bjng(Looper.getMainLooper(), this);
  }
  
  public AmrPlayer(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(paramContext, paramInt);
    this.jdField_a_of_type_Bjng = new bjng(this);
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
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread = new AmrPlayer.AmrPlayerThread(this, null);
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread.start();
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
  
  public void a(azci paramazci)
  {
    this.jdField_a_of_type_Azci = paramazci;
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
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
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
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread = null;
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
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (this.jdField_a_of_type_Azci != null)
      {
        this.jdField_a_of_type_Azci.a(this, 0, 0);
        paramMessage = new HashMap();
        paramMessage.put("param_succ_flag", "0");
        paramMessage.put("errCode", "0");
        paramMessage.put("param_version", Build.VERSION.SDK_INT + "");
        paramMessage.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttAmrPlaryerError", true, 0L, 0L, paramMessage, null);
      }
    }
    while ((paramMessage.what != 2) || (this.jdField_a_of_type_Azci == null)) {
      return true;
    }
    this.jdField_a_of_type_Azci.a();
    return true;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onCompletion");
    }
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread = null;
    if (this.jdField_a_of_type_Azci != null) {
      this.jdField_a_of_type_Azci.a();
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr onError");
    }
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerAmrPlayer$AmrPlayerThread = null;
    if (this.jdField_a_of_type_Azci != null) {
      this.jdField_a_of_type_Azci.a(this, paramInt1, paramInt2);
    }
    paramMediaPlayer = new HashMap();
    paramMediaPlayer.put("param_succ_flag", "0");
    paramMediaPlayer.put("errCode", paramInt1 + "");
    paramMediaPlayer.put("param_version", Build.VERSION.SDK_INT + "");
    paramMediaPlayer.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttAmrPlaryerError", true, 0L, 0L, paramMediaPlayer, null);
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
 * Qualified Name:     com.tencent.mobileqq.ptt.player.AmrPlayer
 * JD-Core Version:    0.7.0.1
 */