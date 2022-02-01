package com.tencent.mobileqq.qqaudio.audioplayer.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService.IAudioDeviceListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class AudioDeviceServiceImpl
  extends BroadcastReceiver
  implements IAudioDeviceService
{
  private static final String TAG = "AudioDeviceServiceImpl";
  private List<IAudioDeviceService.IAudioDeviceListener> audioDeviceListenerList = new ArrayList();
  private boolean isA2DpBluetoothHeadsetType = false;
  private boolean isBlueToothHeadsetEnable = false;
  private boolean isNearEar = false;
  private boolean isRingerModeNotNormal = false;
  private boolean isWiredHeadsetEnable = false;
  private WeakReference<AppRuntime> mApp;
  private AudioSenorManager senorManager;
  
  private void bindApp(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("$bindApp, app = ");
      ((StringBuilder)localObject).append(paramAppRuntime);
      QLog.d("AudioDeviceServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mApp;
    if ((localObject != null) && (((WeakReference)localObject).get() == paramAppRuntime)) {
      return;
    }
    localObject = this.mApp;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      unBindApp();
    }
    this.mApp = new WeakReference(paramAppRuntime);
  }
  
  private void notifyAllDeviceStatusChanged(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyAllDeviceStatusChanged: changedType=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" changedValue=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AudioDeviceServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.audioDeviceListenerList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      IAudioDeviceService.IAudioDeviceListener localIAudioDeviceListener = (IAudioDeviceService.IAudioDeviceListener)((Iterator)localObject).next();
      if ((localIAudioDeviceListener.c() & paramInt) == paramInt)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyAllDeviceStatusChanged: audioDeviceListener=");
        localStringBuilder.append(localIAudioDeviceListener.getClass());
        QLog.d("AudioDeviceServiceImpl", 2, localStringBuilder.toString());
        localIAudioDeviceListener.a(paramInt, paramBoolean);
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    BaseApplication localBaseApplication = paramAppRuntime.getApp();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
    if (Build.VERSION.SDK_INT >= 11)
    {
      localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
      localIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    }
    localBaseApplication.registerReceiver(this, localIntentFilter);
    this.senorManager = new AudioSenorManager(paramAppRuntime);
    this.senorManager.a(this);
    bindApp(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    this.audioDeviceListenerList.clear();
    this.senorManager.a();
    this.senorManager = null;
    unBindApp();
  }
  
  public void onNearToEarStatusChanged(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNearToEarStatusChanged: senorIsNear=");
      localStringBuilder.append(bool);
      localStringBuilder.append(" | isRingerMode_not_normal =");
      localStringBuilder.append(this.isRingerModeNotNormal);
      QLog.d("AudioDeviceServiceImpl", 2, localStringBuilder.toString());
    }
    if (bool != this.isNearEar)
    {
      this.isNearEar = bool;
      notifyAllDeviceStatusChanged(2, bool);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    if ((str != null) && (str.equals("android.intent.action.HEADSET_PLUG")))
    {
      if (paramIntent.hasExtra("state"))
      {
        if (paramIntent.getIntExtra("state", 0) != 1) {
          bool1 = false;
        }
        if (this.isWiredHeadsetEnable != bool1)
        {
          this.isWiredHeadsetEnable = bool1;
          notifyAllDeviceStatusChanged(4, bool1);
        }
      }
    }
    else
    {
      int i;
      if ("android.media.RINGER_MODE_CHANGED".equals(str))
      {
        paramContext = (AudioManager)paramContext.getSystemService("audio");
        try
        {
          i = paramContext.getRingerMode();
        }
        catch (Throwable paramContext)
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("onReceive getRingerMode error:");
            paramIntent.append(paramContext.getMessage());
            QLog.d("AudioDeviceServiceImpl", 2, paramIntent.toString());
          }
          i = 2;
        }
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("currentRingerMode:");
          paramContext.append(i);
          QLog.d("AudioDeviceServiceImpl", 2, paramContext.toString());
        }
        if (i != 2) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool1 != this.isRingerModeNotNormal)
        {
          this.isRingerModeNotNormal = bool1;
          if (bool1)
          {
            paramContext = this.mApp;
            if (paramContext != null)
            {
              paramContext = (AppRuntime)paramContext.get();
              if (paramContext != null) {
                AudioDeviceHelper.a(false, paramContext);
              }
            }
            notifyAllDeviceStatusChanged(1, false);
          }
        }
      }
      else if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(str))
      {
        i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        if ((i == 2) || (i == 0))
        {
          if (i == 2) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          if (bool1 != this.isBlueToothHeadsetEnable)
          {
            this.isBlueToothHeadsetEnable = bool1;
            notifyAllDeviceStatusChanged(8, bool1);
          }
          if (i == 0)
          {
            bool1 = ((AudioManager)paramContext.getSystemService("audio")).isBluetoothA2dpOn();
            bool2 = AudioDeviceHelper.a();
            if (QLog.isColorLevel())
            {
              paramContext = new StringBuilder();
              paramContext.append("BluetoothHeadset.STATE_DISCONNECTED: isSysA2dpOn=");
              paramContext.append(bool1);
              paramContext.append("| isAppA2dpOn = ");
              paramContext.append(bool2);
              QLog.d("AudioPlayer", 2, paramContext.toString());
            }
          }
        }
      }
      else if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(str))
      {
        i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        if ((i == 2) || (i == 0))
        {
          if (i == 2) {
            bool1 = bool3;
          } else {
            bool1 = false;
          }
          if (bool1 != this.isA2DpBluetoothHeadsetType)
          {
            this.isA2DpBluetoothHeadsetType = bool1;
            notifyAllDeviceStatusChanged(16, bool1);
          }
          if (i == 0)
          {
            bool1 = ((AudioManager)paramContext.getSystemService("audio")).isBluetoothA2dpOn();
            bool2 = AudioDeviceHelper.a();
            if (QLog.isColorLevel())
            {
              paramContext = new StringBuilder();
              paramContext.append("BluetoothA2dp.STATE_DISCONNECTED: isSysA2dpOn=");
              paramContext.append(bool1);
              paramContext.append("| isAppA2dpOn = ");
              paramContext.append(bool2);
              QLog.d("AudioPlayer", 2, paramContext.toString());
            }
          }
        }
      }
    }
  }
  
  public void registerAudioDeviceListener(IAudioDeviceService.IAudioDeviceListener paramIAudioDeviceListener)
  {
    if (paramIAudioDeviceListener == null)
    {
      QLog.e("AudioDeviceServiceImpl", 2, "registerAudioDeviceListener listener is null");
      return;
    }
    if (this.audioDeviceListenerList.contains(paramIAudioDeviceListener))
    {
      QLog.e("AudioDeviceServiceImpl", 2, "registerAudioDeviceListener listener is contains");
      return;
    }
    this.audioDeviceListenerList.add(paramIAudioDeviceListener);
  }
  
  public void unBindApp()
  {
    try
    {
      if ((this.mApp != null) && (this.mApp.get() != null)) {
        ((AppRuntime)this.mApp.get()).getApp().unregisterReceiver(this);
      }
      this.mApp = null;
      if (QLog.isColorLevel())
      {
        QLog.d("AudioDeviceServiceImpl", 2, "$unBindApp");
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceServiceImpl", 2, "", localException);
      }
    }
  }
  
  public void unRegisterAudioDeviceListener(IAudioDeviceService.IAudioDeviceListener paramIAudioDeviceListener)
  {
    if (paramIAudioDeviceListener == null)
    {
      QLog.e("AudioDeviceServiceImpl", 2, "unRegisterAudioDeviceListener listener is null");
      return;
    }
    if (this.audioDeviceListenerList.contains(paramIAudioDeviceListener))
    {
      this.audioDeviceListenerList.remove(paramIAudioDeviceListener);
      return;
    }
    QLog.e("AudioDeviceServiceImpl", 2, "unRegisterAudioDeviceListener listener is not contains");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.impl.AudioDeviceServiceImpl
 * JD-Core Version:    0.7.0.1
 */