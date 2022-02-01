package com.tencent.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService.Stub;

class QQDeviceInfo$1$1
  implements ServiceConnection
{
  QQDeviceInfo$1$1(QQDeviceInfo.1 param1) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramComponentName = OpenDeviceIdentifierService.Stub.a(paramIBinder);
      try
      {
        QQDeviceInfo.access$002(paramComponentName.a());
        QQDeviceInfo.access$100("huawei_oaid", QQDeviceInfo.access$000());
        if (QLog.isColorLevel())
        {
          paramComponentName = QQDeviceInfo.TAG;
          paramIBinder = new StringBuilder();
          paramIBinder.append("huawei oaid = ");
          paramIBinder.append(QQDeviceInfo.access$000());
          QLog.d(paramComponentName, 2, paramIBinder.toString());
          return;
        }
      }
      catch (SecurityException paramComponentName)
      {
        paramComponentName.printStackTrace();
        QLog.e(QQDeviceInfo.TAG, 2, paramComponentName, new Object[0]);
        return;
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      QLog.e(QQDeviceInfo.TAG, 2, "get huawei oaid throw e", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.QQDeviceInfo.1.1
 * JD-Core Version:    0.7.0.1
 */