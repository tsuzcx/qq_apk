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
    QLog.w("TraeAudioManager", 2, "bluetoothHeadsetSwitchThread _quit _stopBluetoothSco");
    _stopBluetoothSco();
  }
  
  public void _run()
  {
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag))
    {
      if (!TraeAudioManager.enableDeviceSwitchFlag)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "connect bluetoothHeadset: disableDeviceSwitchFlag");
        }
        return;
      }
      this.this$0._deviceConfigManager.getBluetoothName();
    }
    try
    {
      if (TraeAudioManager.access$000(this.this$0) == 8)
      {
        QLog.w("TraeAudioManager", 2, "bluetoothHeadsetSwitchThread SCO_DISCONNECTED sleep 5000");
        Thread.sleep(5000L);
      }
      else
      {
        QLog.w("TraeAudioManager", 2, "bluetoothHeadsetSwitchThread sleep 1000");
        Thread.sleep(1000L);
      }
    }
    catch (InterruptedException localInterruptedException3)
    {
      try
      {
        boolean bool;
        int i;
        StringBuilder localStringBuilder;
        this.this$0._bluetooth_sco_connect.wait(4000L);
        if (TraeAudioManager.access$000(this.this$0) != 7) {
          break label374;
        }
        QLog.w("TraeAudioManager", 2, "bluetoothHeadsetSwitchThread bluetoothState ==  Bluetooth_State.SCO_CONNECTED 2");
        updateStatus();
        break label469;
        if (j > 3) {
          break label469;
        }
        if (i == 0) {
          break label454;
        }
        _stopBluetoothSco();
      }
      catch (InterruptedException localInterruptedException3)
      {
        try
        {
          for (;;)
          {
            int j;
            Thread.sleep(4000L);
            TraeAudioManager.access$002(this.this$0, 6);
            synchronized (this.this$0._bluetooth_sco_connect)
            {
              this.this$0._bluetooth_sco_connect[0] = false;
              _startBluetoothSco();
              QLog.w("TraeAudioManager", 2, "bluetoothHeadsetSwitchThread retry start sco");
            }
            j += 1;
            continue;
            localObject4 = finally;
            throw localObject4;
            if (TraeAudioManager.access$000(this.this$0) != 7)
            {
              QLog.e("TraeAudioManager", 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
              this.this$0._deviceConfigManager.setVisible(getDeviceName(), false);
              this.this$0._deviceConfigManager.resetNullConnecting();
              processDeviceConnectRes(10);
              this.this$0.checkAutoDeviceListUpdate(false);
            }
            return;
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("connect bluetoothHeadset: do nothing, IsMusicScene:");
              ((StringBuilder)???).append(TraeAudioManager.IsMusicScene);
              ((StringBuilder)???).append(" ,IsUpdateSceneFlag:");
              ((StringBuilder)???).append(TraeAudioManager.IsUpdateSceneFlag);
              QLog.w("TraeAudioManager", 2, ((StringBuilder)???).toString());
            }
            updateStatus();
            return;
            localInterruptedException1 = localInterruptedException1;
          }
          localInterruptedException3 = localInterruptedException3;
        }
        catch (InterruptedException localInterruptedException2)
        {
          break label396;
        }
      }
    }
    TraeAudioManager.access$002(this.this$0, 4);
    bool = this._running;
    j = 1;
    if (bool)
    {
      TraeAudioManager.access$002(this.this$0, 6);
      synchronized (this.this$0._bluetooth_sco_connect)
      {
        this.this$0._bluetooth_sco_connect[0] = false;
        _startBluetoothSco();
        QLog.w("TraeAudioManager", 2, "bluetoothHeadsetSwitchThread _startBluetoothSco");
        i = 1;
      }
    }
    i = 0;
    if (this._running)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bluetoothHeadsetSwitchThread i:");
      localStringBuilder.append(j);
      localStringBuilder.append(" sco:");
      if (this.this$0._am.isBluetoothScoOn()) {
        ??? = "Y";
      } else {
        ??? = "N";
      }
      localStringBuilder.append((String)???);
      localStringBuilder.append(" :");
      localStringBuilder.append(this.this$0._deviceConfigManager.getBluetoothName());
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
      if (TraeAudioManager.access$000(this.this$0) == 7)
      {
        QLog.w("TraeAudioManager", 2, "bluetoothHeadsetSwitchThread bluetoothState ==  Bluetooth_State.SCO_CONNECTED 1");
        updateStatus();
      }
      else
      {
        synchronized (this.this$0._bluetooth_sco_connect)
        {
          int k = this.this$0._bluetooth_sco_connect[0];
          if (k != 0) {}
        }
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
    try
    {
      this.this$0._am.stopBluetoothSco();
      this.this$0._am.setBluetoothScoOn(false);
      return;
    }
    catch (Exception localException) {}
  }
  
  public String getDeviceName()
  {
    return "DEVICE_BLUETOOTHHEADSET";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.bluetoothHeadsetSwitchThread
 * JD-Core Version:    0.7.0.1
 */