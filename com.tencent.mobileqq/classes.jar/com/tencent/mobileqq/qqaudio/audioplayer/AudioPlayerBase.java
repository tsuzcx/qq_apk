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
  public static int b = -999;
  public static boolean c = false;
  protected Timer d;
  protected float e = SonicHelper.a;
  protected long f = -1L;
  protected IAudioFilePlayer g;
  protected AudioManager h;
  protected Application i;
  protected String j;
  protected volatile AudioPlayerHelper.AudioPlayerParameter k;
  protected volatile int l = b;
  protected volatile int m;
  protected boolean n;
  public int o;
  protected boolean p = true;
  protected boolean q = false;
  protected AudioPlayerBase.AudioPlayerListener r;
  protected Handler s = new AudioPlayerBase.1(this);
  
  public AudioPlayerBase(Context paramContext, AudioPlayerBase.AudioPlayerListener paramAudioPlayerListener)
  {
    this.i = ((Application)paramContext.getApplicationContext());
    this.h = ((AudioManager)this.i.getSystemService("audio"));
    this.r = paramAudioPlayerListener;
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
  
  public void a()
  {
    d();
    AudioPlayerBase.AudioPlayerListener localAudioPlayerListener = this.r;
    if (localAudioPlayerListener != null) {
      localAudioPlayerListener.a(this);
    }
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
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
    this.o = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    d();
    paramIAudioFilePlayer = new StringBuilder();
    paramIAudioFilePlayer.append("onError: ");
    paramIAudioFilePlayer.append(paramInt1);
    QLog.e("AudioPlayer", 2, paramIAudioFilePlayer.toString());
    paramIAudioFilePlayer = this.r;
    if (paramIAudioFilePlayer != null) {
      paramIAudioFilePlayer.a(this, -2);
    }
    if ((this.g instanceof SilkPlayer)) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    a(0, paramInt2, paramInt1, paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = -1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        i1 = 0;
      }
      AudioDeviceHelper.c = i1;
    }
    else
    {
      if (!paramBoolean1) {
        i1 = 0;
      }
      AudioDeviceHelper.c = i1;
    }
    AudioDeviceHelper.d = false;
  }
  
  public boolean a(String paramString)
  {
    return a(paramString, 0);
  }
  
  protected abstract boolean a(String paramString, int paramInt);
  
  public abstract void b();
  
  public void b(int paramInt)
  {
    AudioPlayerBase.AudioPlayerListener localAudioPlayerListener = this.r;
    if (localAudioPlayerListener != null) {
      try
      {
        localAudioPlayerListener.d(this, h());
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
  
  protected abstract AudioPlayerHelper.AudioPlayerParameter c();
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public boolean c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "seekPlay ", new Exception());
    }
    return a(paramString, paramInt);
  }
  
  public void d()
  {
    try
    {
      this.s.removeMessages(1000);
      f();
      if (this.g != null)
      {
        if (this.g.f()) {
          this.g.c();
        }
        this.g.d();
        this.g.e();
        this.e = SonicHelper.a;
        this.f = -1L;
        this.j = null;
        this.g = null;
        this.l = b;
        ThreadManager.post(this, 8, null, false);
      }
      return;
    }
    finally {}
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "replay ", new Exception());
    }
    String str = this.j;
    if (str != null) {
      a(str, paramInt);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  protected void e()
  {
    if ((this.g instanceof AmrPlayer))
    {
      f();
      this.d = new Timer();
      this.d.schedule(new AudioPlayerBase.2(this), 0L, 100L);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  protected void f()
  {
    Timer localTimer = this.d;
    if (localTimer != null) {
      localTimer.cancel();
    }
  }
  
  public int g()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.g;
    if (localIAudioFilePlayer == null) {
      return 0;
    }
    return localIAudioFilePlayer.i();
  }
  
  public int h()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.g;
    if (localIAudioFilePlayer == null) {
      return 0;
    }
    return localIAudioFilePlayer.h();
  }
  
  public AudioManager i()
  {
    return this.h;
  }
  
  public void j()
  {
    this.n = this.h.isSpeakerphoneOn();
    this.k = c();
    this.h.setMode(this.k.a);
    this.h.setSpeakerphoneOn(this.k.c);
    if (this.l != b) {
      this.k.b = this.l;
    }
    Object localObject1 = this.r;
    if (localObject1 != null) {
      ((AudioPlayerBase.AudioPlayerListener)localObject1).b(this, this.k.b);
    }
    localObject1 = this.i;
    int i1 = 1;
    QQAudioUtils.a((Context)localObject1, true);
    localObject1 = this.g;
    if (localObject1 != null)
    {
      ((IAudioFilePlayer)localObject1).a(this.k.b);
      try
      {
        this.g.j();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.e("AudioPlayer", 2, "mPlayer.prepare error", localThrowable);
        if (!(this.g instanceof SilkPlayer)) {
          i1 = 0;
        }
        a(0, i1, 3, localThrowable.toString());
        return;
      }
    }
    i1 = this.h.getStreamVolume(this.k.b);
    int i2 = this.h.getStreamMaxVolume(this.k.b);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("currentVolume=");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(" maxVolume=");
      ((StringBuilder)localObject2).append(i2);
      QLog.d("AudioPlayer", 2, ((StringBuilder)localObject2).toString());
    }
    if (i1 / i2 < 0.18F)
    {
      this.m = 0;
      this.s.sendEmptyMessageDelayed(1000, 200L);
    }
    else
    {
      this.m = 1;
      this.s.removeMessages(1000);
    }
    Object localObject2 = this.r;
    if (localObject2 != null) {
      ((AudioPlayerBase.AudioPlayerListener)localObject2).c(this, this.m);
    }
    if ((this.g instanceof SilkPlayer)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    a(1, i1, 0, "");
    e();
  }
  
  public String k()
  {
    return this.j;
  }
  
  protected void l()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.g;
    if (localIAudioFilePlayer != null)
    {
      if (localIAudioFilePlayer.f()) {
        this.g.c();
      }
      this.g.d();
      this.g.e();
      this.g = null;
    }
  }
  
  public boolean m()
  {
    IAudioFilePlayer localIAudioFilePlayer = this.g;
    return (localIAudioFilePlayer != null) && (localIAudioFilePlayer.f());
  }
  
  public void n() {}
  
  public void o() {}
  
  public void p()
  {
    if ((c) && (this.h.isBluetoothScoOn()))
    {
      this.h.setBluetoothScoOn(false);
      this.h.stopBluetoothSco();
      c = false;
    }
  }
  
  public void q()
  {
    p();
  }
  
  protected boolean r()
  {
    if (!FileUtils.fileExistsAndNotEmpty(this.j))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file not found, ");
        ((StringBuilder)localObject).append(this.j);
        QLog.d("AudioPlayer", 2, ((StringBuilder)localObject).toString());
      }
      d();
      Object localObject = this.r;
      if (localObject != null)
      {
        ((AudioPlayerBase.AudioPlayerListener)localObject).a(this, -1);
        a(0, 1, 1, "ERROR_FILE_NOT_FOUND");
        if (this.f > 0L) {
          b((float)(NetConnInfoCenter.getServerTime() - this.f) / 3600.0F);
        }
      }
      return false;
    }
    return true;
  }
  
  public void run()
  {
    try
    {
      this.h.setMode(0);
      this.h.setSpeakerphoneOn(this.n);
      QQAudioUtils.a(this.i, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
 * JD-Core Version:    0.7.0.1
 */