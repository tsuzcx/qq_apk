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
    while (!this.this$0.d.isEmpty())
    {
      Bundle localBundle = (Bundle)this.this$0.d.remove(0);
      if (localBundle == null) {
        return;
      }
      String str = localBundle.getString("notify_cmd");
      try
      {
        localBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("qq->plugin post to main thread doPostCachedMsg strNotifyCmd:");
          localStringBuilder2.append(str);
          localStringBuilder2.append(" thread:");
          localStringBuilder2.append(Thread.currentThread());
          QLog.d("SmartDeviceIPCHost", 2, localStringBuilder2.toString());
        }
        this.this$0.b.b("com.qqsmartdevice.action.notify", localBundle);
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("mSmartDeviceService.transfer failed strNotifyCmd:");
        localStringBuilder1.append(str);
        QLog.d("SmartDeviceIPCHost", 2, localStringBuilder1.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.smartdevice.ipc.SmartDeviceIPCHost.4
 * JD-Core Version:    0.7.0.1
 */