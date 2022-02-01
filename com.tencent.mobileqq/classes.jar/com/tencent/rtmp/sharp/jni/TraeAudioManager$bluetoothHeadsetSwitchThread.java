package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Build.VERSION;

class TraeAudioManager$bluetoothHeadsetSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$bluetoothHeadsetSwitchThread(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  @TargetApi(8)
  public void _quit()
  {
    if (this.this$0._am == null) {
      return;
    }
    _stopBluetoothSco();
  }
  
  public void _run()
  {
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag)) {
      if (!TraeAudioManager.enableDeviceSwitchFlag)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "connect bluetoothHeadset: disableDeviceSwitchFlag");
        }
        return;
      }
    }
    try
    {
      Thread.sleep(1000L);
      _startBluetoothSco();
      i = 0;
      if (this._running == true)
      {
        j = i + 1;
        if (i < 10)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("bluetoothHeadsetSwitchThread i:");
            localStringBuilder.append(j);
            localStringBuilder.append(" sco:");
            if (this.this$0._am.isBluetoothScoOn()) {
              localObject = "Y";
            } else {
              localObject = "N";
            }
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(" :");
            localStringBuilder.append(this.this$0._deviceConfigManager.getBluetoothName());
            QLog.w("TRAE", 2, localStringBuilder.toString());
          }
          if (this.this$0._am.isBluetoothScoOn()) {
            updateStatus();
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException1)
    {
      try
      {
        Object localObject;
        for (;;)
        {
          int j;
          Thread.sleep(1000L);
          label194:
          int i = j;
        }
        if (!this.this$0._am.isBluetoothScoOn())
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
          }
          this.this$0._deviceConfigManager.setVisible(getDeviceName(), false);
          processDeviceConnectRes(10);
          this.this$0.checkAutoDeviceListUpdate();
        }
        return;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("connect bluetoothHeadset: do nothing, IsMusicScene:");
          ((StringBuilder)localObject).append(TraeAudioManager.IsMusicScene);
          ((StringBuilder)localObject).append(" ,IsUpdateSceneFlag:");
          ((StringBuilder)localObject).append(TraeAudioManager.IsUpdateSceneFlag);
          QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
        }
        updateStatus();
        return;
        localInterruptedException1 = localInterruptedException1;
      }
      catch (InterruptedException localInterruptedException2)
      {
        break label194;
      }
    }
  }
  
  @TargetApi(8)
  void _startBluetoothSco()
  {
    this.this$0._am.setBluetoothScoOn(true);
    if (Build.VERSION.SDK_INT > 8) {
      this.this$0._am.startBluetoothSco();
    }
  }
  
  @TargetApi(8)
  void _stopBluetoothSco()
  {
    if (Build.VERSION.SDK_INT > 8) {
      this.this$0._am.stopBluetoothSco();
    }
    this.this$0._am.setBluetoothScoOn(false);
  }
  
  public String getDeviceName()
  {
    return "DEVICE_BLUETOOTHHEADSET";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.bluetoothHeadsetSwitchThread
 * JD-Core Version:    0.7.0.1
 */