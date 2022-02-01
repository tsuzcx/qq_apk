package com.tencent.mobileqq.qwallet.ipc.impl;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class QWalletIPCConnector$1
  implements EIPCOnGetConnectionListener
{
  QWalletIPCConnector$1(QWalletIPCConnector paramQWalletIPCConnector) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      QWalletIPCConnector.a(this.a, paramEIPCConnection.procName);
    }
    QWalletIPCConnector.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      QWalletIPCConnector.a(this.a, paramEIPCConnection.procName);
    }
    QWalletIPCConnector.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCConnector.1
 * JD-Core Version:    0.7.0.1
 */