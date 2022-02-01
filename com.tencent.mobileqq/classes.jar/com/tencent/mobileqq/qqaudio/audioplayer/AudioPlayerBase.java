package com.tencent.mobileqq.qqaudio.audioplayer;

import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

public abstract class AudioPlayerBase
  implements IAudioFilePlayerListener, Runnable
{
  public static int a;
  public static final List<Integer> a;
  public static int b;
  public static boolean b;
  public static volatile boolean c;
  public static boolean d;
  protected float a;
  protected long a;
  protected Application a;
  protected AudioManager a;
  protected Handler a;
  protected AudioPlayerBase.AudioPlayerListener a;
  protected volatile AudioPlayerHelper.AudioPlayerParameter a;
  protected IAudioFilePlayer a;
  protected String a;
  protected Timer a;
  protected volatile int c;
  protected volatile int d;
  public int e;
  protected boolean e;
  protected boolean f = true;
  protected boolean g = false;
  
  static
  {
    jdField_a_of_type_Int = -999;
    jdField_b_of_type_Boolean = true;
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(1796) });
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
  }
  
  public AudioPlayerBase(Context paramContext, AudioPlayerBase.AudioPlayerListener paramAudioPlayerListener)
  {
    this.jdField_a_of_type_Float = SonicHelper.jdField_a_of_type_Float;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidOsHandler = new AudioPlayerBase.1(this);
    this.jdField_a_of_type_AndroidAppApplication = ((Application)paramContext.getApplicationContext());
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener = paramAudioPlayerListener;
  }
  
  @TargetApi(14)
  public static boolean a(AudioManager paramAudioManager)
  {
    if (!jdField_b_of_type_Boolean) {}
    BluetoothAdapter localBluetoothAdapter;
    do
    {
      do
      {
        return false;
      } while (Build.VERSION.SDK_INT < 14);
      localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    } while ((localBluetoothAdapter == null) || (!localBluetoothAdapter.isEnabled()) || (localBluetoothAdapter.getProfileConnectionState(1) != 2) || (localBluetoothAdapter.getProfileConnectionState(2) == 2) || (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(jdField_b_of_type_Int))) || (jdField_c_of_type_Boolean) || (paramAudioManager.isBluetoothScoOn()) || (!paramAudioManager.isBluetoothScoAvailableOffCall()));
    return true;
  }
  
  public static void b(float paramFloat)
  {
    HashMap localHashMap = new HashMap();
    if ((paramFloat >= 0.0F) && (paramFloat < 24.0F)) {
      localHashMap.put("errorCode", String.valueOf(0));
    }
    for (;;)
    {
      localHashMap.put("hour", String.valueOf(paramFloat));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pttPlayFileNotFind", true, 0L, 0L, localHashMap, "");
      return;
      if ((paramFloat >= 24.0F) && (paramFloat < 168.0F)) {
        localHashMap.put("errorCode", String.valueOf(1));
      } else if ((paramFloat >= 168.0F) && (paramFloat < 360.0F)) {
        localHashMap.put("errorCode", String.valueOf(2));
      } else if (paramFloat > 360.0F) {
        localHashMap.put("errorCode", String.valueOf(3));
      }
    }
  }
  
  public AudioManager a()
  {
    return this.jdField_a_of_type_AndroidMediaAudioManager;
  }
  
  protected abstract AudioPlayerHelper.AudioPlayerParameter a();
  
  public IAudioFilePlayer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener.a(this);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (QLog.isColorLevel()) {
      QLog.i("AudioPlayer", 2, "setPlaySpeed: " + paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "replay ", new Exception());
    }
    if (this.jdField_a_of_type_JavaLangString != null) {
      a(this.jdField_a_of_type_JavaLangString, paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("issilk", String.valueOf(paramInt2));
    localHashMap.put("isSuccess", String.valueOf(paramInt1));
    localHashMap.put("errorCode", String.valueOf(paramInt3));
    localHashMap.put("errormsg", paramString);
    localHashMap.put("busiType", this.jdField_e_of_type_Int + "");
    localHashMap.put("filePath", this.jdField_a_of_type_JavaLangString);
    paramString = new StringBuilder();
    if (this.f) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localHashMap.put("isfromLocal", paramInt1 + "");
      paramString = new StringBuilder();
      paramInt1 = i;
      if (this.g) {
        paramInt1 = 1;
      }
      localHashMap.put("isfromBlueTooth", paramInt1 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pttplaysuc", true, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    d();
    QLog.e("AudioPlayer", 2, "onError: " + paramInt1);
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener.a(this, -2);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer instanceof SilkPlayer)) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      a(0, paramInt2, paramInt1, paramString);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        i = 0;
      }
      AudioPlayer.jdField_b_of_type_Int = i;
      AudioPlayer.jdField_c_of_type_Boolean = false;
      return;
    }
    if (paramBoolean1) {}
    for (;;)
    {
      AudioPlayer.jdField_b_of_type_Int = i;
      break;
      i = 0;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a());
  }
  
  public boolean a(String paramString)
  {
    return a(paramString, 0);
  }
  
  protected abstract boolean a(String paramString, int paramInt);
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.b();
  }
  
  public void b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  protected boolean b()
  {
    if (!FileUtils.b(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer", 2, "file not found, " + this.jdField_a_of_type_JavaLangString);
      }
      d();
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener.a(this, -1);
        a(0, 1, 1, "ERROR_FILE_NOT_FOUND");
        if (this.jdField_a_of_type_Long > 0L) {
          b((float)(NetConnInfoCenter.getServerTime() - this.jdField_a_of_type_Long) / 3600.0F);
        }
      }
      return false;
    }
    return true;
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "seekPlay ", new Exception());
    }
    return a(paramString, paramInt);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a();
  }
  
  public void c()
  {
    i = 1;
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn();
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter = a();
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_a_of_type_Boolean);
    if (this.jdField_c_of_type_Int != jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener.b(this, this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_b_of_type_Int);
    }
    QQAudioUtils.a(this.jdField_a_of_type_AndroidAppApplication, true);
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_b_of_type_Int);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.g();
      i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_b_of_type_Int);
      int j = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer", 2, "currentVolume=" + i + " maxVolume=" + j);
      }
      if (i / j >= 0.18F) {
        break label327;
      }
      this.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        QLog.e("AudioPlayer", 2, "mPlayer.prepare error", localThrowable);
        if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer instanceof SilkPlayer)) {}
        for (;;)
        {
          a(0, i, 3, localThrowable.toString());
          return;
          i = 0;
        }
        this.jdField_d_of_type_Int = 1;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        continue;
        i = 0;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener.c(this, this.jdField_d_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer instanceof SilkPlayer))
    {
      i = 1;
      a(1, i, 0, "");
      i();
      return;
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener.d(this, c());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioPlayer", 2, "startProgressTimer e= " + localException);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void d()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      j();
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a()) {
          this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.c();
        }
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.d();
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.e();
        this.jdField_a_of_type_Float = SonicHelper.jdField_a_of_type_Float;
        this.jdField_a_of_type_Long = -1L;
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = null;
        this.jdField_c_of_type_Int = jdField_a_of_type_Int;
        ThreadManager.post(this, 8, null, false);
      }
      return;
    }
    finally {}
  }
  
  public void d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public abstract void e();
  
  public void f() {}
  
  public void g() {}
  
  public void h()
  {
    l();
  }
  
  protected void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer instanceof AmrPlayer))
    {
      j();
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new AudioPlayerBase.2(this), 0L, 100L);
    }
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a()) {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.d();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = null;
    }
  }
  
  public void l()
  {
    if ((jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()))
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
      this.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
      jdField_d_of_type_Boolean = false;
    }
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.jdField_e_of_type_Boolean);
      QQAudioUtils.a(this.jdField_a_of_type_AndroidAppApplication, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioPlayer", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
 * JD-Core Version:    0.7.0.1
 */