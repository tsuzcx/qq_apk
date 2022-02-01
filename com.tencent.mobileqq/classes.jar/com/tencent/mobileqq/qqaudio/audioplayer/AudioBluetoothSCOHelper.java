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
  Application jdField_a_of_type_AndroidAppApplication;
  AudioBluetoothSCOHelper.AudioBluetoothSCOReceiver jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper$AudioBluetoothSCOReceiver;
  WeakReference<AudioPlayerBase> jdField_a_of_type_MqqUtilWeakReference;
  
  public AudioBluetoothSCOHelper(Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  private AudioPlayerBase a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    return (AudioPlayerBase)localWeakReference.get();
  }
  
  @TargetApi(14)
  public int a(String paramString, int paramInt)
  {
    if (AudioDeviceHelper.a != -1) {
      return 1;
    }
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    AudioPlayerBase localAudioPlayerBase = a();
    if (localAudioPlayerBase == null) {
      return 0;
    }
    if (localBluetoothAdapter == null)
    {
      AudioDeviceHelper.a = 0;
      return 1;
    }
    if ((localBluetoothAdapter.isEnabled()) && (localBluetoothAdapter.getProfileConnectionState(1) == 2) && (localBluetoothAdapter.getProfileConnectionState(2) != 2))
    {
      paramString = new AudioBluetoothSCOHelper.1(this, localAudioPlayerBase, paramString, paramInt, localBluetoothAdapter);
      localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
      return 2;
    }
    AudioDeviceHelper.a = 0;
    return 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper$AudioBluetoothSCOReceiver != null) {
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
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper$AudioBluetoothSCOReceiver);
      label57:
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper$AudioBluetoothSCOReceiver = null;
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
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAudioPlayerBase);
  }
  
  public int b(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppApplication == null) {
      return 0;
    }
    paramString = new AudioBluetoothSCOHelper.AudioBluetoothSCOReceiver(this, paramString, paramInt, null);
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper$AudioBluetoothSCOReceiver = paramString;
    this.jdField_a_of_type_AndroidAppApplication.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    paramString = a();
    if ((paramString != null) && (paramString.a() != null))
    {
      paramString.a().startBluetoothSco();
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_SCOHelper", 2, "tryStartBluetoothSCO return: Check_SCO_Result_Check_Access_Need_Return");
      }
      return 2;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioBluetoothSCOHelper
 * JD-Core Version:    0.7.0.1
 */