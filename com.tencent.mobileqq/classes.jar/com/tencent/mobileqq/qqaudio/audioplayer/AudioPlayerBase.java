package com.tencent.mobileqq.qqaudio.audioplayer;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Timer;

public abstract class AudioPlayerBase
  implements IAudioFilePlayerListener, Runnable
{
  public static int a = -999;
  public static boolean a = false;
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
  protected volatile int b;
  protected boolean b;
  protected volatile int c;
  protected boolean c;
  public int d;
  protected boolean d;
  
  public AudioPlayerBase(Context paramContext, AudioPlayerBase.AudioPlayerListener paramAudioPlayerListener)
  {
    this.jdField_a_of_type_Float = SonicHelper.jdField_a_of_type_Float;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new AudioPlayerBase.1(this);
    this.jdField_a_of_type_AndroidAppApplication = ((Application)paramContext.getApplicationContext());
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener = paramAudioPlayerListener;
  }
  
  public static void b(float paramFloat)
  {
    HashMap localHashMap = new HashMap();
    if ((paramFloat >= 0.0F) && (paramFloat < 24.0F)) {
      localHashMap.put("errorCode", String.valueOf(0));
    } else if ((paramFloat >= 24.0F) && (paramFloat < 168.0F)) {
      localHashMap.put("errorCode", String.valueOf(1));
    } else if ((paramFloat >= 168.0F) && (paramFloat < 360.0F)) {
      localHashMap.put("errorCode", String.valueOf(2));
    } else if (paramFloat > 360.0F) {
      localHashMap.put("errorCode", String.valueOf(3));
    }
    localHashMap.put("hour", String.valueOf(paramFloat));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pttPlayFileNotFind", true, 0L, 0L, localHashMap, "");
  }
  
  public int a()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    if (localIAudioFilePlayer == null) {
      return 0;
    }
    return localIAudioFilePlayer.b();
  }
  
  public AudioManager a()
  {
    return this.jdField_a_of_type_AndroidMediaAudioManager;
  }
  
  protected abstract AudioPlayerHelper.AudioPlayerParameter a();
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    c();
    AudioPlayerBase.AudioPlayerListener localAudioPlayerListener = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener;
    if (localAudioPlayerListener != null) {
      localAudioPlayerListener.a(this);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPlaySpeed: ");
      localStringBuilder.append(paramFloat);
      QLog.i("AudioPlayer", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    c();
    paramIAudioFilePlayer = new StringBuilder();
    paramIAudioFilePlayer.append("onError: ");
    paramIAudioFilePlayer.append(paramInt1);
    QLog.e("AudioPlayer", 2, paramIAudioFilePlayer.toString());
    paramIAudioFilePlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener;
    if (paramIAudioFilePlayer != null) {
      paramIAudioFilePlayer.a(this, -2);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer instanceof SilkPlayer)) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    a(0, paramInt2, paramInt1, paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        i = 0;
      }
      AudioDeviceHelper.jdField_a_of_type_Int = i;
    }
    else
    {
      if (!paramBoolean1) {
        i = 0;
      }
      AudioDeviceHelper.jdField_a_of_type_Int = i;
    }
    AudioDeviceHelper.jdField_b_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    return (localIAudioFilePlayer != null) && (localIAudioFilePlayer.a());
  }
  
  public boolean a(String paramString)
  {
    return a(paramString, 0);
  }
  
  protected abstract boolean a(String paramString, int paramInt);
  
  public int b()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    if (localIAudioFilePlayer == null) {
      return 0;
    }
    return localIAudioFilePlayer.a();
  }
  
  public abstract void b();
  
  public void b(int paramInt)
  {
    AudioPlayerBase.AudioPlayerListener localAudioPlayerListener = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener;
    if (localAudioPlayerListener != null) {
      try
      {
        localAudioPlayerListener.d(this, b());
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startProgressTimer e= ");
          localStringBuilder.append(localException);
          QLog.e("AudioPlayer", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  protected boolean b()
  {
    if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file not found, ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.d("AudioPlayer", 2, ((StringBuilder)localObject).toString());
      }
      c();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener;
      if (localObject != null)
      {
        ((AudioPlayerBase.AudioPlayerListener)localObject).a(this, -1);
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
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      e();
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
        this.jdField_b_of_type_Int = jdField_a_of_type_Int;
        ThreadManager.post(this, 8, null, false);
      }
      return;
    }
    finally {}
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer instanceof AmrPlayer))
    {
      e();
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new AudioPlayerBase.2(this), 0L, 100L);
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "replay ", new Exception());
    }
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {
      a(str, paramInt);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  protected void e()
  {
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (localTimer != null) {
      localTimer.cancel();
    }
  }
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn();
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter = a();
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_a_of_type_Boolean);
    if (this.jdField_b_of_type_Int != jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener;
    if (localObject1 != null) {
      ((AudioPlayerBase.AudioPlayerListener)localObject1).b(this, this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_b_of_type_Int);
    }
    localObject1 = this.jdField_a_of_type_AndroidAppApplication;
    int i = 1;
    QQAudioUtils.a((Context)localObject1, true);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    if (localObject1 != null)
    {
      ((IAudioFilePlayer)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_b_of_type_Int);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.g();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.e("AudioPlayer", 2, "mPlayer.prepare error", localThrowable);
        if (!(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer instanceof SilkPlayer)) {
          i = 0;
        }
        a(0, i, 3, localThrowable.toString());
        return;
      }
    }
    i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_b_of_type_Int);
    int j = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.jdField_b_of_type_Int);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("currentVolume=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" maxVolume=");
      ((StringBuilder)localObject2).append(j);
      QLog.d("AudioPlayer", 2, ((StringBuilder)localObject2).toString());
    }
    if (i / j < 0.18F)
    {
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
    }
    else
    {
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener;
    if (localObject2 != null) {
      ((AudioPlayerBase.AudioPlayerListener)localObject2).c(this, this.jdField_c_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer instanceof SilkPlayer)) {
      i = 1;
    } else {
      i = 0;
    }
    a(1, i, 0, "");
    d();
  }
  
  protected void g()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer;
    if (localIAudioFilePlayer != null)
    {
      if (localIAudioFilePlayer.a()) {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.d();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer = null;
    }
  }
  
  public void h() {}
  
  public void i() {}
  
  public void j()
  {
    if ((jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()))
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
      this.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
      jdField_a_of_type_Boolean = false;
    }
  }
  
  public void k()
  {
    j();
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.jdField_b_of_type_Boolean);
      QQAudioUtils.a(this.jdField_a_of_type_AndroidAppApplication, false);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPlayer", 2, localException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
 * JD-Core Version:    0.7.0.1
 */