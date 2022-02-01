package cooperation.smartdevice.ipc;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class SmartDeviceIPCHost$4
  implements Runnable
{
  SmartDeviceIPCHost$4(SmartDeviceIPCHost paramSmartDeviceIPCHost) {}
  
  public void run()
  {
    for (;;)
    {
      Bundle localBundle;
      if (!this.this$0.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        localBundle = (Bundle)this.this$0.jdField_a_of_type_JavaUtilArrayList.remove(0);
        if (localBundle != null) {}
      }
      else
      {
        return;
      }
      String str = localBundle.getString("notify_cmd");
      try
      {
        localBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "qq->plugin post to main thread doPostCachedMsg strNotifyCmd:" + str + " thread:" + Thread.currentThread());
        }
        this.this$0.jdField_a_of_type_CooperationSmartdeviceIpcISmartDeviceService.a("com.qqsmartdevice.action.notify", localBundle);
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService.transfer failed strNotifyCmd:" + str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.smartdevice.ipc.SmartDeviceIPCHost.4
 * JD-Core Version:    0.7.0.1
 */