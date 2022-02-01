package com.tencent.mobileqq.qqaudio.audioplayer;

import android.media.AudioManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AudioDeviceStatus
{
  protected boolean a = true;
  protected volatile boolean b = false;
  protected volatile boolean c = false;
  protected volatile boolean d = false;
  protected volatile AudioDeviceStatus.AudioDeviceStatusResult e = null;
  AudioPlayerHelper.AudioPlayerParameter[] f;
  private volatile boolean g = false;
  private boolean h = false;
  
  private AudioPlayerHelper.AudioPlayerParameter a(int paramInt)
  {
    if (this.f == null) {
      this.f = AudioPlayerHelper.a();
    }
    AudioPlayerHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = this.f;
    AudioPlayerHelper.AudioPlayerParameter localAudioPlayerParameter2 = arrayOfAudioPlayerParameter[0];
    AudioPlayerHelper.AudioPlayerParameter localAudioPlayerParameter1 = localAudioPlayerParameter2;
    if (paramInt >= 0)
    {
      localAudioPlayerParameter1 = localAudioPlayerParameter2;
      if (paramInt < arrayOfAudioPlayerParameter.length) {
        localAudioPlayerParameter1 = arrayOfAudioPlayerParameter[paramInt];
      }
    }
    return localAudioPlayerParameter1;
  }
  
  public int a()
  {
    return 31;
  }
  
  public AudioDeviceStatus.AudioDeviceStatusResult a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if ((paramInt == 8) || (paramInt == 16)) {
            d(paramBoolean);
          }
        }
        else {
          c(paramBoolean);
        }
      }
      else {
        b(paramBoolean);
      }
    }
    else {
      a(paramBoolean);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAudioDeviceStatusChanged changeType = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramBoolean);
    a(localStringBuilder.toString());
    return this.e;
  }
  
  public void a(AudioManager paramAudioManager)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnBluetoothSCODisconnected isBluetoothA2dpOn = ");
    localStringBuilder.append(paramAudioManager.isBluetoothA2dpOn());
    a(localStringBuilder.toString());
    if ((this.g) && (!paramAudioManager.isBluetoothA2dpOn())) {
      this.g = false;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (!StringUtil.isEmpty(paramString)) {
        localStringBuilder.append(paramString);
      }
      paramString = new StringBuilder();
      paramString.append("\n mCurDeviceStatus = ");
      paramString.append(this.e.a);
      localStringBuilder.append(paramString.toString());
      paramString = new StringBuilder();
      paramString.append("\n  userLoudSpeakerStatus = ");
      paramString.append(this.a);
      localStringBuilder.append(paramString.toString());
      paramString = new StringBuilder();
      paramString.append("\n  mNearToEar = ");
      paramString.append(this.c);
      localStringBuilder.append(paramString.toString());
      paramString = new StringBuilder();
      paramString.append("\n  wiredHeadsetConnect = ");
      paramString.append(this.b);
      localStringBuilder.append(paramString.toString());
      paramString = new StringBuilder();
      paramString.append("\n  blueHeadsetConnect = ");
      paramString.append(this.g);
      localStringBuilder.append(paramString.toString());
      paramString = new StringBuilder();
      paramString.append("\n  mblueHeadsetSCOConnect = ");
      paramString.append(this.d);
      localStringBuilder.append(paramString.toString());
      QLog.d("AudioPlayer_DeviceStatus", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    j();
  }
  
  public void b()
  {
    this.e = new AudioDeviceStatus.AudioDeviceStatusResult(a(0), 0);
    this.b = AudioDeviceHelper.a(BaseApplication.getContext());
    this.g = AudioDeviceHelper.b(BaseApplication.getContext());
    this.a = AudioDeviceHelper.a(MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.d = AudioDeviceHelper.d(BaseApplication.getContext());
    j();
    a("init ");
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.c != paramBoolean) {
      this.c = paramBoolean;
    }
    j();
  }
  
  public void c()
  {
    if (!this.h)
    {
      e(AudioDeviceHelper.d(BaseApplication.getContext()));
      this.h = true;
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
    j();
  }
  
  protected void d(boolean paramBoolean)
  {
    this.g = AudioDeviceHelper.b(BaseApplication.getContext());
    this.d = AudioDeviceHelper.d(BaseApplication.getContext());
    j();
  }
  
  public boolean d()
  {
    return this.a;
  }
  
  public void e(boolean paramBoolean)
  {
    this.d = paramBoolean;
    j();
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return this.c;
  }
  
  public AudioPlayerHelper.AudioPlayerParameter h()
  {
    if ((this.e != null) && (this.e.a() != null))
    {
      a("getCurrentProperParam");
      return this.e.a();
    }
    return a(0);
  }
  
  public AudioDeviceStatus.AudioDeviceStatusResult i()
  {
    if (this.e == null) {
      new AudioDeviceStatus.AudioDeviceStatusResult(a(0), 0);
    }
    return this.e;
  }
  
  protected void j()
  {
    Object localObject = i();
    int i;
    if ((AudioDeviceHelper.b) && (this.d)) {
      i = 4;
    } else if (this.b) {
      i = 2;
    } else if (this.g) {
      i = 3;
    } else if ((this.a) && (!this.c)) {
      i = 0;
    } else {
      i = 1;
    }
    if (localObject == null) {
      return;
    }
    AudioDeviceStatus.AudioDeviceStatusResult localAudioDeviceStatusResult = new AudioDeviceStatus.AudioDeviceStatusResult(a(i), i, true);
    if (!((AudioDeviceStatus.AudioDeviceStatusResult)localObject).a(localAudioDeviceStatusResult)) {
      this.e = localAudioDeviceStatusResult;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCurrentStatus end nextStatusType = ");
    ((StringBuilder)localObject).append(i);
    a(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceStatus
 * JD-Core Version:    0.7.0.1
 */