package com.tencent.sharp.jni;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;

class DeviceSwitchThread$BluetoothHeadsetSwitchThread
  extends DeviceSwitchThread
{
  DeviceSwitchThread$BluetoothHeadsetSwitchThread(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  private void f()
  {
    int i = 0;
    for (;;)
    {
      if (this.b)
      {
        int j = i + 1;
        if (i < 5)
        {
          Object localObject;
          if (QLog.isColorLevel())
          {
            String str = DeviceSwitchThread.a();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("real try connect bluetooth, i[");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append("], bluetooth state[");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper.a());
            ((StringBuilder)localObject).append("]");
            QLog.i(str, 2, ((StringBuilder)localObject).toString());
          }
          if (this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper.a() == 5)
          {
            d();
            if (QLog.isColorLevel()) {
              QLog.i(DeviceSwitchThread.a(), 2, "connect success in first time");
            }
          }
          else
          {
            try
            {
              Thread.sleep(3000L);
              if (this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper.a() == 5)
              {
                d();
                if (QLog.isColorLevel()) {
                  QLog.i(DeviceSwitchThread.a(), 2, "connect success after wait 3s]");
                }
              }
              else
              {
                c();
                try
                {
                  Thread.sleep(1000L);
                  b();
                  i = j;
                }
                catch (InterruptedException localInterruptedException1)
                {
                  if (!QLog.isColorLevel()) {
                    return;
                  }
                }
                localObject = DeviceSwitchThread.a();
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("BluetoothHeadsetSwitchThread wait another 1s InterruptedException[");
                localStringBuilder.append(localInterruptedException1.getMessage());
                localStringBuilder.append("]");
                QLog.d((String)localObject, 2, localStringBuilder.toString());
                return;
              }
            }
            catch (InterruptedException localInterruptedException2)
            {
              StringBuilder localStringBuilder;
              if (QLog.isColorLevel())
              {
                localObject = DeviceSwitchThread.a();
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("BluetoothHeadsetSwitchThread wait 3s InterruptedException[");
                localStringBuilder.append(localInterruptedException2.getMessage());
                localStringBuilder.append("]");
                QLog.d((String)localObject, 2, localStringBuilder.toString());
              }
            }
          }
        }
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper == null)
    {
      QLog.e(DeviceSwitchThread.a(), 1, "mBluetoothHelper is null");
      return;
    }
    Object localObject;
    StringBuilder localStringBuilder;
    try
    {
      Thread.sleep(1000L);
    }
    catch (InterruptedException localInterruptedException1)
    {
      if (QLog.isColorLevel())
      {
        localObject = DeviceSwitchThread.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("BluetoothHeadsetSwitchThread wait 1s InterruptedException[");
        localStringBuilder.append(localInterruptedException1.getMessage());
        localStringBuilder.append("]");
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper.a() != 1) {
        break;
      }
      j = i + 1;
      if (i >= 10) {
        break;
      }
      try
      {
        Thread.sleep(1000L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        if (QLog.isColorLevel())
        {
          localObject = DeviceSwitchThread.a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("BluetoothHeadsetSwitchThread wait device InterruptedException[");
          localStringBuilder.append(localInterruptedException2.getMessage());
          localStringBuilder.append("]");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      String str = DeviceSwitchThread.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("wait remote bluetooth connect, retryCount[");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("]");
      QLog.i(str, 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper.a() != 1)
    {
      if (this.b)
      {
        this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper.a(4);
        b();
      }
      f();
      if (this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper.a() != 5)
      {
        if (QLog.isColorLevel()) {
          QLog.e(DeviceSwitchThread.a(), 2, "BluetoothHeadsetSwitchThread sco fail");
        }
        this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a(this.jdField_a_of_type_JavaLangString, false);
        if (this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread$IDeviceConnectStatusListener != null) {
          this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread$IDeviceConnectStatusListener.a(this.jdField_a_of_type_JavaLangString, 7);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i(DeviceSwitchThread.a(), 2, "try connect bluetooth when state == BluetoothState.HEADSET_UNAVAILABLE");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.sharp.jni.DeviceSwitchThread.BluetoothHeadsetSwitchThread
 * JD-Core Version:    0.7.0.1
 */