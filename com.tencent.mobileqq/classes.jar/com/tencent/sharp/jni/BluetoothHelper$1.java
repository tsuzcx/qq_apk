package com.tencent.sharp.jni;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class BluetoothHelper$1
  implements Runnable
{
  BluetoothHelper$1(BluetoothHelper paramBluetoothHelper) {}
  
  public void run()
  {
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (BluetoothHelper.a(this.this$0) != null) {
      try
      {
        List localList = BluetoothHelper.a(this.this$0).getConnectedDevices();
      }
      catch (Exception localException)
      {
        localObject2 = BluetoothHelper.a();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onServiceConnected run exception[");
        ((StringBuilder)localObject3).append(localException.getMessage());
        ((StringBuilder)localObject3).append("]");
        QLog.e((String)localObject2, 1, ((StringBuilder)localObject3).toString());
      }
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      int i = 0;
      while (i < localObject1.size())
      {
        localObject2 = (BluetoothDevice)localObject1.get(i);
        int j = BluetoothHelper.a(this.this$0).getConnectionState((BluetoothDevice)localObject2);
        if (j == 2) {
          BluetoothHelper.a(this.this$0).a(((BluetoothDevice)localObject2).getName());
        }
        if (QLog.isColorLevel())
        {
          localObject3 = BluetoothHelper.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onServiceConnected, device name[");
          localStringBuilder.append(((BluetoothDevice)localObject2).getName());
          localStringBuilder.append("], connection state[");
          localStringBuilder.append(j);
          localStringBuilder.append("]");
          QLog.w((String)localObject3, 2, localStringBuilder.toString());
        }
        i += 1;
      }
    }
    if (BluetoothHelper.a(this.this$0) != null)
    {
      if ((!TextUtils.isEmpty(BluetoothHelper.a(this.this$0).a())) && (this.this$0.a()))
      {
        BluetoothHelper.a(this.this$0).a("DEVICE_BLUETOOTH_HEADSET", true);
        BluetoothHelper.a(this.this$0, 2);
        BluetoothHelper.a(this.this$0).a(true);
        return;
      }
      BluetoothHelper.a(this.this$0).a("DEVICE_BLUETOOTH_HEADSET", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.sharp.jni.BluetoothHelper.1
 * JD-Core Version:    0.7.0.1
 */