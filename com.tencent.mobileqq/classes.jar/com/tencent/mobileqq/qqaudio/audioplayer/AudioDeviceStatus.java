package com.tencent.mobileqq.qqaudio.audioplayer;

import android.media.AudioManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AudioDeviceStatus
{
  protected volatile AudioDeviceStatus.AudioDeviceStatusResult a;
  protected boolean a;
  AudioPlayerHelper.AudioPlayerParameter[] a;
  protected volatile boolean b = false;
  protected volatile boolean c = false;
  protected volatile boolean d = false;
  private volatile boolean e = false;
  private boolean f = false;
  
  public AudioDeviceStatus()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus$AudioDeviceStatusResult = null;
  }
  
  private AudioPlayerHelper.AudioPlayerParameter a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter = AudioPlayerHelper.a();
    }
    AudioPlayerHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter;
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
  
  public AudioDeviceStatus.AudioDeviceStatusResult a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus$AudioDeviceStatusResult == null) {
      new AudioDeviceStatus.AudioDeviceStatusResult(a(0), 0);
    }
    return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus$AudioDeviceStatusResult;
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
    return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus$AudioDeviceStatusResult;
  }
  
  public AudioPlayerHelper.AudioPlayerParameter a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus$AudioDeviceStatusResult != null) && (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus$AudioDeviceStatusResult.a() != null))
    {
      a("getCurrentProperParam");
      return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus$AudioDeviceStatusResult.a();
    }
    return a(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus$AudioDeviceStatusResult = new AudioDeviceStatus.AudioDeviceStatusResult(a(0), 0);
    this.b = AudioDeviceHelper.a(BaseApplication.getContext());
    this.e = AudioDeviceHelper.b(BaseApplication.getContext());
    this.jdField_a_of_type_Boolean = AudioDeviceHelper.a(MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.d = AudioDeviceHelper.d(BaseApplication.getContext());
    c();
    a("init ");
  }
  
  public void a(AudioManager paramAudioManager)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnBluetoothSCODisconnected isBluetoothA2dpOn = ");
    localStringBuilder.append(paramAudioManager.isBluetoothA2dpOn());
    a(localStringBuilder.toString());
    if ((this.e) && (!paramAudioManager.isBluetoothA2dpOn())) {
      this.e = false;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (!StringUtil.a(paramString)) {
        localStringBuilder.append(paramString);
      }
      paramString = new StringBuilder();
      paramString.append("\n mCurDeviceStatus = ");
      paramString.append(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus$AudioDeviceStatusResult.a);
      localStringBuilder.append(paramString.toString());
      paramString = new StringBuilder();
      paramString.append("\n  userLoudSpeakerStatus = ");
      paramString.append(this.jdField_a_of_type_Boolean);
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
      paramString.append(this.e);
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
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (!this.f)
    {
      e(AudioDeviceHelper.d(BaseApplication.getContext()));
      this.f = true;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.c != paramBoolean) {
      this.c = paramBoolean;
    }
    c();
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  protected void c()
  {
    Object localObject = a();
    int i;
    if ((AudioDeviceHelper.jdField_a_of_type_Boolean) && (this.d)) {
      i = 4;
    } else if (this.b) {
      i = 2;
    } else if (this.e) {
      i = 3;
    } else if ((this.jdField_a_of_type_Boolean) && (!this.c)) {
      i = 0;
    } else {
      i = 1;
    }
    if (localObject == null) {
      return;
    }
    AudioDeviceStatus.AudioDeviceStatusResult localAudioDeviceStatusResult = new AudioDeviceStatus.AudioDeviceStatusResult(a(i), i, true);
    if (!((AudioDeviceStatus.AudioDeviceStatusResult)localObject).a(localAudioDeviceStatusResult)) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus$AudioDeviceStatusResult = localAudioDeviceStatusResult;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCurrentStatus end nextStatusType = ");
    ((StringBuilder)localObject).append(i);
    a(((StringBuilder)localObject).toString());
  }
  
  protected void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
    c();
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  protected void d(boolean paramBoolean)
  {
    this.e = AudioDeviceHelper.b(BaseApplication.getContext());
    this.d = AudioDeviceHelper.d(BaseApplication.getContext());
    c();
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public void e(boolean paramBoolean)
  {
    this.d = paramBoolean;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceStatus
 * JD-Core Version:    0.7.0.1
 */