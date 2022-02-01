package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import java.util.HashMap;

abstract class TraeAudioManager$switchThread
  extends Thread
{
  boolean[] _exited = { false };
  HashMap<String, Object> _params = null;
  boolean _running = true;
  long _usingtime = 0L;
  
  TraeAudioManager$switchThread(TraeAudioManager paramTraeAudioManager)
  {
    if (QLog.isColorLevel())
    {
      paramTraeAudioManager = new StringBuilder();
      paramTraeAudioManager.append("construct switchThread:");
      paramTraeAudioManager.append(getDeviceName());
      QLog.w("TraeAudioManager", 2, paramTraeAudioManager.toString());
    }
  }
  
  public abstract void _quit();
  
  public abstract void _run();
  
  public abstract String getDeviceName();
  
  void processDeviceConnectRes(int paramInt)
  {
    this.this$0.InternalNotifyDeviceChangableUpdate();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getDeviceName());
    ((StringBuilder)localObject).append(" err:");
    ((StringBuilder)localObject).append(paramInt);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    if (this._params == null)
    {
      this.this$0.InternalNotifyDeviceListUpdate();
      return;
    }
    localObject = this.this$0;
    ((TraeAudioManager)localObject).sessionConnectedDev = ((TraeAudioManager)localObject)._deviceConfigManager.getConnectedDevice();
    localObject = (Long)this._params.get("PARAM_SESSIONID");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" sessonID:");
      localStringBuilder.append(localObject);
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && (((Long)localObject).longValue() != -9223372036854775808L))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)this._params.get("PARAM_DEVICE"));
      if (this.this$0.sendResBroadcast((Intent)localObject, this._params, paramInt) == 0) {
        this.this$0.InternalNotifyDeviceListUpdate();
      }
      AudioDeviceInterface.LogTraceExit();
      return;
    }
    this.this$0.InternalNotifyDeviceListUpdate();
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "processDeviceConnectRes sid null,don't send res");
    }
  }
  
  public void quit()
  {
    AudioDeviceInterface.LogTraceEntry(getDeviceName());
    this._running = false;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(" quit:");
      ((StringBuilder)???).append(getDeviceName());
      ((StringBuilder)???).append(" _running:");
      ((StringBuilder)???).append(this._running);
      QLog.w("TraeAudioManager", 2, ((StringBuilder)???).toString());
    }
    interrupt();
    _quit();
    synchronized (this._exited)
    {
      int i = this._exited[0];
      if (i != 0) {}
    }
    try
    {
      this._exited.wait(10000L);
      label104:
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label104;
    }
  }
  
  public void run()
  {
    AudioDeviceInterface.LogTraceEntry(getDeviceName());
    this.this$0._deviceConfigManager.setConnecting(getDeviceName());
    this.this$0.InternalNotifyDeviceChangableUpdate();
    _run();
    synchronized (this._exited)
    {
      this._exited[0] = true;
      this._exited.notifyAll();
      AudioDeviceInterface.LogTraceExit();
      return;
    }
  }
  
  public void setDeviceConnectParam(HashMap<String, Object> paramHashMap)
  {
    this._params = paramHashMap;
  }
  
  void updateStatus()
  {
    this.this$0._deviceConfigManager.setConnected(getDeviceName());
    processDeviceConnectRes(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.switchThread
 * JD-Core Version:    0.7.0.1
 */