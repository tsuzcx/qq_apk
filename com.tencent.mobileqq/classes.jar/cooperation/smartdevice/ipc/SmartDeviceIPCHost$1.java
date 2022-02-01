package cooperation.smartdevice.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class SmartDeviceIPCHost$1
  extends Handler
{
  SmartDeviceIPCHost$1(SmartDeviceIPCHost paramSmartDeviceIPCHost, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = this.a;
      paramMessage.b = null;
      paramMessage.c = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.smartdevice.ipc.SmartDeviceIPCHost.1
 * JD-Core Version:    0.7.0.1
 */