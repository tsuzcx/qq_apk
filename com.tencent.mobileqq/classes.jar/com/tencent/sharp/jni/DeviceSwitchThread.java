package com.tencent.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DeviceSwitchThread
  extends Thread
{
  private static final String i = "DeviceSwitchThread";
  protected AudioManager a;
  protected final String b;
  protected DeviceConfigManager c = DeviceConfigManager.a();
  protected DeviceSwitchThread.IDeviceConnectStatusListener d;
  protected BluetoothHelper e;
  protected boolean f;
  protected volatile boolean g = true;
  protected CountDownLatch h = new CountDownLatch(1);
  
  public DeviceSwitchThread(Context paramContext, String paramString)
  {
    this.a = ((AudioManager)paramContext.getSystemService("audio"));
    this.b = paramString;
    this.f = BaseApplicationImpl.processName.endsWith(":video");
  }
  
  public static DeviceSwitchThread a(Context paramContext, String paramString)
  {
    if ("DEVICE_EARPHONE".equals(paramString)) {
      return new DeviceSwitchThread.EarphoneSwitchThread(paramContext, paramString);
    }
    if ("DEVICE_SPEAKERPHONE".equals(paramString)) {
      return new DeviceSwitchThread.SpeakerSwitchThread(paramContext, paramString);
    }
    if ("DEVICE_WIRED_HEADSET".equals(paramString)) {
      return new DeviceSwitchThread.WiredHeadsetSwitchThread(paramContext, paramString);
    }
    if ("DEVICE_BLUETOOTH_HEADSET".equals(paramString)) {
      return new DeviceSwitchThread.BluetoothHeadsetSwitchThread(paramContext, paramString);
    }
    return null;
  }
  
  public void a()
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = i;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("quit thread, mDeviceName[");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    this.g = false;
    interrupt();
    if ("DEVICE_BLUETOOTH_HEADSET".equals(this.b))
    {
      localObject1 = this.e;
      if (localObject1 != null) {
        ((BluetoothHelper)localObject1).a = true;
      }
      c();
    }
    try
    {
      this.h.await(1000L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localObject2 = i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wait thread quit exception[");
      localStringBuilder.append(localInterruptedException.getMessage());
      localStringBuilder.append("]");
      QLog.e((String)localObject2, 1, localStringBuilder.toString());
    }
  }
  
  public void a(DeviceSwitchThread.IDeviceConnectStatusListener paramIDeviceConnectStatusListener, BluetoothHelper paramBluetoothHelper)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = i;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start thread, mDeviceName[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("]");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      this.d = paramIDeviceConnectStatusListener;
      this.e = paramBluetoothHelper;
      super.start();
      return;
    }
    finally {}
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSpeakerPhone, speakerOn[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    try
    {
      if (this.a.isSpeakerphoneOn() == paramBoolean) {
        break label76;
      }
      this.a.setSpeakerphoneOn(paramBoolean);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label67:
      label76:
      break label67;
    }
    QLog.e(i, 1, "setSpeakerphoneOn npe");
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "startBluetoothSco");
    }
    try
    {
      this.a.setBluetoothScoOn(true);
      this.a.startBluetoothSco();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label31:
      break label31;
    }
    QLog.e(i, 1, "startBluetoothSco npe");
  }
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setWiredHeadset, on[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    try
    {
      this.a.setWiredHeadsetOn(paramBoolean);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label56:
      break label56;
    }
    QLog.e(i, 1, "setWiredHeadset npe");
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "stopBluetoothSco");
    }
    try
    {
      this.a.stopBluetoothSco();
      this.a.setBluetoothScoOn(false);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label31:
      break label31;
    }
    QLog.e(i, 1, "stopBluetoothSco npe");
  }
  
  protected void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchSuccess, mDeviceName[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.c.g(this.b);
    Object localObject = this.d;
    if (localObject != null) {
      ((DeviceSwitchThread.IDeviceConnectStatusListener)localObject).a(this.b, 0);
    }
  }
  
  protected abstract void e();
  
  public void run()
  {
    DeviceSwitchThread.IDeviceConnectStatusListener localIDeviceConnectStatusListener = this.d;
    if (localIDeviceConnectStatusListener != null) {
      localIDeviceConnectStatusListener.a(this.b);
    }
    e();
    this.h.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.DeviceSwitchThread
 * JD-Core Version:    0.7.0.1
 */