package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;

class TraeAudioManager$TraeAudioManagerLooper$2
  extends Handler
{
  TraeAudioManager$TraeAudioManagerLooper$2(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper) {}
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      localObject1 = (HashMap)paramMessage.obj;
    }
    catch (Exception localException)
    {
      Object localObject1;
      label11:
      StringBuilder localStringBuilder;
      Object localObject2;
      break label11;
    }
    localObject1 = null;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TraeAudioManagerLooper msg ");
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append(":");
      localStringBuilder.append(this.this$1.msgToText(paramMessage.what));
      localStringBuilder.append(" _enabled:");
      if (this.this$1._enabled) {
        localObject2 = "Y";
      } else {
        localObject2 = "N";
      }
      localStringBuilder.append((String)localObject2);
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    if (paramMessage.what == 32772)
    {
      this.this$1.startService((HashMap)localObject1);
      return;
    }
    if (!this.this$1._enabled)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "******* disabled ,skip msg******");
      }
      paramMessage = new Intent();
      this.this$1.this$0.sendResBroadcast(paramMessage, (HashMap)localObject1, 1);
      return;
    }
    switch (paramMessage.what)
    {
    case 32792: 
    default: 
      return;
    case 32793: 
      this.this$1.this$0.InternalNotifyDeviceListUpdate();
      return;
    case 32790: 
      this.this$1.abandonAudioFocus();
      return;
    case 32788: 
      paramMessage = (Integer)((HashMap)localObject1).get("PARAM_STREAMTYPE");
      if (paramMessage == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
        }
      }
      else
      {
        this.this$1.this$0._streamType = paramMessage.intValue();
        this.this$1.InternalNotifyStreamTypeUpdate(paramMessage.intValue());
        return;
      }
      break;
    case 32787: 
      if (this.this$1.this$0.InternalConnectDevice(this.this$1.this$0.sessionConnectedDev, null, false) != 0)
      {
        paramMessage = (String)((HashMap)localObject1).get("PARAM_DEVICE");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" plugout dev:");
        ((StringBuilder)localObject1).append(paramMessage);
        ((StringBuilder)localObject1).append(" sessionConnectedDev:");
        ((StringBuilder)localObject1).append(this.this$1.this$0.sessionConnectedDev);
        ((StringBuilder)localObject1).append(" connected fail,auto switch!");
        QLog.w("TRAE", 2, ((StringBuilder)localObject1).toString());
        this.this$1.this$0.InternalConnectDevice(this.this$1.this$0._deviceConfigManager.getAvailabledHighestPriorityDevice(), null, false);
        return;
      }
      break;
    case 32786: 
      paramMessage = (String)((HashMap)localObject1).get("PARAM_DEVICE");
      if (this.this$1.this$0.InternalConnectDevice(paramMessage, null, false) != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" plugin dev:");
          ((StringBuilder)localObject1).append(paramMessage);
          ((StringBuilder)localObject1).append(" sessionConnectedDev:");
          ((StringBuilder)localObject1).append(this.this$1.this$0.sessionConnectedDev);
          ((StringBuilder)localObject1).append(" connected fail,auto switch!");
          QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject1).toString());
        }
        this.this$1.this$0.InternalConnectDevice(this.this$1.this$0._deviceConfigManager.getAvailabledHighestPriorityDevice(), null, false);
        return;
      }
      break;
    case 32785: 
    case 32789: 
      paramMessage = this.this$1.this$0._deviceConfigManager.getAvailabledHighestPriorityDevice();
      localObject1 = this.this$1.this$0._deviceConfigManager.getConnectedDevice();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" highestDev");
        ((StringBuilder)localObject2).append(paramMessage);
        QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject2).toString());
      }
      if (TraeAudioManager.IsUpdateSceneFlag)
      {
        if ((TraeAudioManager.IsMusicScene) && (!this.this$1.this$0.IsBluetoothA2dpExisted))
        {
          this.this$1.this$0.InternalConnectDevice(this.this$1.this$0._deviceConfigManager.getAvailabledHighestPriorityDevice("DEVICE_BLUETOOTHHEADSET"), null, true);
          return;
        }
        this.this$1.this$0.InternalConnectDevice(paramMessage, null, true);
        return;
      }
      if ((!"DEVICE_BLUETOOTHHEADSET".equals(localObject1)) && (paramMessage.equals(localObject1)))
      {
        this.this$1.this$0.InternalNotifyDeviceListUpdate();
        return;
      }
      this.this$1.this$0.InternalConnectDevice(paramMessage, null, false);
      return;
    case 32784: 
      this.this$1.InternalGetStreamType((HashMap)localObject1);
      return;
    case 32783: 
      this.this$1.InternalStopRing((HashMap)localObject1);
      return;
    case 32782: 
      this.this$1.InternalStartRing((HashMap)localObject1);
      return;
    case 32781: 
      this.this$1.InternalVoicecallPostprocess((HashMap)localObject1);
      return;
    case 32780: 
      this.this$1.InternalVoicecallPreprocess((HashMap)localObject1);
      return;
    case 32779: 
      this.this$1.this$0.InternalSessionGetConnectingDevice((HashMap)localObject1);
      return;
    case 32778: 
      this.this$1.this$0.InternalSessionGetConnectedDevice((HashMap)localObject1);
      return;
    case 32777: 
      this.this$1.this$0.InternalSessionIsDeviceChangabled((HashMap)localObject1);
      return;
    case 32776: 
      this.this$1.this$0.InternalSessionEarAction((HashMap)localObject1);
      return;
    case 32775: 
      this.this$1.this$0.InternalSessionConnectDevice((HashMap)localObject1);
      return;
    case 32774: 
      this.this$1.InternalSessionGetDeviceList((HashMap)localObject1);
      return;
    case 32773: 
      this.this$1.stopService();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.TraeAudioManagerLooper.2
 * JD-Core Version:    0.7.0.1
 */