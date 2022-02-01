package com.tencent.mobileqq.qqaudio.audioplayer;

import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.SystemClock;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class AudioBluetoothSCOHelper
{
  Application a;
  AudioBluetoothSCOHelper.AudioBluetoothSCOReceiver b;
  WeakReference<AudioPlayerBase> c;
  
  public AudioBluetoothSCOHelper(Application paramApplication)
  {
    this.a = paramApplication;
  }
  
  private AudioPlayerBase b()
  {
    WeakReference localWeakReference = this.c;
    if (localWeakReference == null) {
      return null;
    }
    return (AudioPlayerBase)localWeakReference.get();
  }
  
  @TargetApi(14)
  public int a(String paramString, int paramInt)
  {
    if (AudioDeviceHelper.c != -1) {
      return 1;
    }
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    AudioPlayerBase localAudioPlayerBase = b();
    if (localAudioPlayerBase == null) {
      return 0;
    }
    if (localBluetoothAdapter == null)
    {
      AudioDeviceHelper.c = 0;
      return 1;
    }
    if ((localBluetoothAdapter.isEnabled()) && (localBluetoothAdapter.getProfileConnectionState(1) == 2) && (localBluetoothAdapter.getProfileConnectionState(2) != 2))
    {
      paramString = new AudioBluetoothSCOHelper.1(this, localAudioPlayerBase, paramString, paramInt, localBluetoothAdapter);
      localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
      return 2;
    }
    AudioDeviceHelper.c = 0;
    return 1;
  }
  
  public void a()
  {
    if (this.b != null) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unregister sco receiver:  ");
        localStringBuilder.append(SystemClock.uptimeMillis());
        QLog.d("AudioPlayer_SCOHelper", 2, localStringBuilder.toString());
      }
    }
    try
    {
      this.a.unregisterReceiver(this.b);
      label57:
      this.b = null;
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    if ((paramAudioPlayerBase == null) && (QLog.isColorLevel())) {
      QLog.d("AudioPlayer_SCOHelper", 2, "setAudioPlayer audioPlayer is null");
    }
    this.c = new WeakReference(paramAudioPlayerBase);
  }
  
  public int b(String paramString, int paramInt)
  {
    if (this.a == null) {
      return 0;
    }
    paramString = new AudioBluetoothSCOHelper.AudioBluetoothSCOReceiver(this, paramString, paramInt, null);
    this.b = paramString;
    this.a.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    paramString = b();
    if ((paramString != null) && (paramString.i() != null))
    {
      paramString.i().startBluetoothSco();
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_SCOHelper", 2, "tryStartBluetoothSCO return: Check_SCO_Result_Check_Access_Need_Return");
      }
      return 2;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioBluetoothSCOHelper
 * JD-Core Version:    0.7.0.1
 */