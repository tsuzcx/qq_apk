package com.tencent.mobileqq.mediafocus;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class MediaFocusIpcClient$1
  implements EIPClientConnectListener
{
  MediaFocusIpcClient$1(MediaFocusIpcClient paramMediaFocusIpcClient) {}
  
  public void connectFailed()
  {
    MediaFocusIpcClient.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      MediaFocusIpcClient.a(this.a, paramEIPCConnection.procName);
    }
    MediaFocusIpcClient.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "connectSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusIpcClient.1
 * JD-Core Version:    0.7.0.1
 */