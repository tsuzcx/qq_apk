package com.tencent.mobileqq.qwallet.ipc.impl;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class QWalletIPCConnector$2
  implements EIPClientConnectListener
{
  QWalletIPCConnector$2(QWalletIPCConnector paramQWalletIPCConnector, long paramLong) {}
  
  public void connectFailed()
  {
    QWalletIPCConnector.a(this.b, false);
    QWalletIPCConnector.b(this.b, false);
    synchronized (QWalletIPCConnector.a(this.b))
    {
      QWalletIPCConnector.a(this.b).notifyAll();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("connectFailed:");
        ((StringBuilder)???).append(QWalletIPCConnector.b(this.b));
        QLog.d("QWalletIPCConnector", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      QWalletIPCConnector.a(this.b, ???.procName);
    }
    QWalletIPCConnector.a(this.b, true);
    QWalletIPCConnector.b(this.b, false);
    synchronized (QWalletIPCConnector.a(this.b))
    {
      QWalletIPCConnector.a(this.b).notifyAll();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("connectSuccess:");
        ???.append(QWalletIPCConnector.b(this.b));
        ???.append("|");
        ???.append(l - this.a);
        QLog.d("QWalletIPCConnector", 2, ???.toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCConnector.2
 * JD-Core Version:    0.7.0.1
 */