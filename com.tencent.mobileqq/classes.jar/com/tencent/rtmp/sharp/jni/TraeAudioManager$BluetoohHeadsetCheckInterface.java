package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;

abstract class TraeAudioManager$BluetoohHeadsetCheckInterface
{
  TraeAudioManager$BluetoohHeadsetCheckInterface(TraeAudioManager paramTraeAudioManager) {}
  
  abstract void _addAction(IntentFilter paramIntentFilter);
  
  abstract void _onReceive(Context paramContext, Intent paramIntent);
  
  public void addAction(IntentFilter paramIntentFilter)
  {
    paramIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
    paramIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
    _addAction(paramIntentFilter);
  }
  
  String getBTActionStateChangedExtraString(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
      break;
    case 13: 
      str = "STATE_TURNING_OFF";
      break;
    case 12: 
      str = "STATE_ON";
      break;
    case 11: 
      str = "STATE_TURNING_ON";
      break;
    case 10: 
      str = "STATE_OFF";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  String getBTAdapterConnectionState(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            str = "unknow";
          } else {
            str = "STATE_DISCONNECTING";
          }
        }
        else {
          str = "STATE_CONNECTED";
        }
      }
      else {
        str = "STATE_CONNECTING";
      }
    }
    else {
      str = "STATE_DISCONNECTED";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  String getBTHeadsetAudioState(int paramInt)
  {
    Object localObject;
    if (paramInt != 10)
    {
      if (paramInt != 12)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unknow:");
        ((StringBuilder)localObject).append(paramInt);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "STATE_AUDIO_CONNECTED";
      }
    }
    else {
      localObject = "STATE_AUDIO_DISCONNECTED";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  String getBTHeadsetConnectionState(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            str = "unknow";
          } else {
            str = "STATE_DISCONNECTING";
          }
        }
        else {
          str = "STATE_CONNECTED";
        }
      }
      else {
        str = "STATE_CONNECTING";
      }
    }
    else {
      str = "STATE_DISCONNECTED";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  String getSCOAudioStateExtraString(int paramInt)
  {
    String str;
    if (paramInt != -1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            str = "unknow";
          } else {
            str = "SCO_AUDIO_STATE_CONNECTING";
          }
        }
        else {
          str = "SCO_AUDIO_STATE_CONNECTED";
        }
      }
      else {
        str = "SCO_AUDIO_STATE_DISCONNECTED";
      }
    }
    else {
      str = "SCO_AUDIO_STATE_ERROR";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public abstract boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager);
  
  public abstract String interfaceDesc();
  
  public abstract boolean isConnected();
  
  public void onReceive(Context paramContext, Intent paramIntent, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("BT ACTION_STATE_CHANGED|   EXTRA_STATE ");
        paramContext.append(getBTActionStateChangedExtraString(i));
        QLog.w("TraeAudioManager", 2, paramContext.toString());
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE ");
        paramContext.append(getBTActionStateChangedExtraString(j));
        QLog.w("TraeAudioManager", 2, paramContext.toString());
      }
      if (i == 10)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "    BT off");
        }
        paramDeviceConfigManager.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        return;
      }
      if ((i == 12) && (QLog.isColorLevel())) {
        QLog.w("TraeAudioManager", 2, "BT OFF-->ON,Visiable it...");
      }
    }
    else
    {
      if (("android.bluetooth.device.action.ACL_CONNECTED".equals(paramIntent.getAction())) && (Build.VERSION.SDK_INT < 11)) {
        return;
      }
      if (("android.bluetooth.device.action.ACL_DISCONNECTED".equals(paramIntent.getAction())) && (Build.VERSION.SDK_INT < 11)) {
        return;
      }
      _onReceive(paramContext, paramIntent);
    }
  }
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckInterface
 * JD-Core Version:    0.7.0.1
 */