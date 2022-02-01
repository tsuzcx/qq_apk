package com.tencent.mobileqq.mediafocus;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class MediaFocusIpcClient$2
  implements EIPCOnGetConnectionListener
{
  MediaFocusIpcClient$2(MediaFocusIpcClient paramMediaFocusIpcClient) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      MediaFocusIpcClient.a(this.a, paramEIPCConnection.procName);
    }
    MediaFocusIpcClient.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      MediaFocusIpcClient.a(this.a, paramEIPCConnection.procName);
    }
    MediaFocusIpcClient.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusIpcClient.2
 * JD-Core Version:    0.7.0.1
 */