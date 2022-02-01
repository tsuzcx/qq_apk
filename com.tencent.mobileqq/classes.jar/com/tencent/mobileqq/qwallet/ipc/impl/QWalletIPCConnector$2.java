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
    QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector, false);
    QWalletIPCConnector.b(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector, false);
    synchronized (QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector))
    {
      QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector).notifyAll();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("connectFailed:");
        ((StringBuilder)???).append(QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector));
        QLog.d("QWalletIPCConnector", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector, ???.procName);
    }
    QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector, true);
    QWalletIPCConnector.b(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector, false);
    synchronized (QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector))
    {
      QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector).notifyAll();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("connectSuccess:");
        ???.append(QWalletIPCConnector.a(this.jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector));
        ???.append("|");
        ???.append(l - this.jdField_a_of_type_Long);
        QLog.d("QWalletIPCConnector", 2, ???.toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCConnector.2
 * JD-Core Version:    0.7.0.1
 */