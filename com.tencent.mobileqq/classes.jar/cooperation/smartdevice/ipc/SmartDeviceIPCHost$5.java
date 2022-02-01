package cooperation.smartdevice.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;

class SmartDeviceIPCHost$5
  extends RemoteCommand
{
  SmartDeviceIPCHost$5(SmartDeviceIPCHost paramSmartDeviceIPCHost, String paramString)
  {
    super(paramString);
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(getClass().getClassLoader());
    paramBundle = this.a.b(paramBundle);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramOnInvokeFinishLinstener != null) {
      paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.smartdevice.ipc.SmartDeviceIPCHost.5
 * JD-Core Version:    0.7.0.1
 */