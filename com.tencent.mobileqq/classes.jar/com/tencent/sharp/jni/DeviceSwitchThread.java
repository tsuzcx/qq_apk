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
  private static final String b = "DeviceSwitchThread";
  protected AudioManager a;
  protected BluetoothHelper a;
  protected DeviceConfigManager a;
  protected DeviceSwitchThread.IDeviceConnectStatusListener a;
  protected final String a;
  protected CountDownLatch a;
  protected boolean a;
  protected volatile boolean b;
  
  public DeviceSwitchThread(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager = DeviceConfigManager.a();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = BaseApplicationImpl.processName.endsWith(":video");
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
      localObject1 = jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("quit thread, mDeviceName[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_b_of_type_Boolean = false;
    interrupt();
    if ("DEVICE_BLUETOOTH_HEADSET".equals(this.jdField_a_of_type_JavaLangString))
    {
      localObject1 = this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper;
      if (localObject1 != null) {
        ((BluetoothHelper)localObject1).jdField_a_of_type_Boolean = true;
      }
      c();
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localObject2 = jdField_b_of_type_JavaLangString;
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
        String str = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start thread, mDeviceName[");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("]");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread$IDeviceConnectStatusListener = paramIDeviceConnectStatusListener;
      this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper = paramBluetoothHelper;
      super.start();
      return;
    }
    finally {}
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSpeakerPhone, speakerOn[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn() == paramBoolean) {
        break label76;
      }
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(paramBoolean);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label67:
      label76:
      break label67;
    }
    QLog.e(jdField_b_of_type_JavaLangString, 1, "setSpeakerphoneOn npe");
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "startBluetoothSco");
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(true);
      this.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label31:
      break label31;
    }
    QLog.e(jdField_b_of_type_JavaLangString, 1, "startBluetoothSco npe");
  }
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setWiredHeadset, on[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setWiredHeadsetOn(paramBoolean);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label56:
      break label56;
    }
    QLog.e(jdField_b_of_type_JavaLangString, 1, "setWiredHeadset npe");
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "stopBluetoothSco");
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      label31:
      break label31;
    }
    QLog.e(jdField_b_of_type_JavaLangString, 1, "stopBluetoothSco npe");
  }
  
  protected void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchSuccess, mDeviceName[");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c(this.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread$IDeviceConnectStatusListener;
    if (localObject != null) {
      ((DeviceSwitchThread.IDeviceConnectStatusListener)localObject).a(this.jdField_a_of_type_JavaLangString, 0);
    }
  }
  
  protected abstract void e();
  
  public void run()
  {
    DeviceSwitchThread.IDeviceConnectStatusListener localIDeviceConnectStatusListener = this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread$IDeviceConnectStatusListener;
    if (localIDeviceConnectStatusListener != null) {
      localIDeviceConnectStatusListener.a(this.jdField_a_of_type_JavaLangString);
    }
    e();
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.sharp.jni.DeviceSwitchThread
 * JD-Core Version:    0.7.0.1
 */