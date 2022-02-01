package com.tencent.mobileqq.qwallet.ipc.impl;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

public class QWalletIPCConnector
{
  private static volatile QWalletIPCConnector jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public static QWalletIPCConnector a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector == null) {
          jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector = new QWalletIPCConnector();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQwalletIpcImplQWalletIPCConnector;
  }
  
  private void b()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "begin connect:");
    }
    QIPCClientHelper.getInstance().getClient().addListener(new QWalletIPCConnector.1(this));
    long l = System.currentTimeMillis();
    QIPCClientHelper.getInstance().getClient().connect(new QWalletIPCConnector.2(this, l));
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
      b();
    }
    if (!this.jdField_a_of_type_Boolean) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait(500L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCConnector
 * JD-Core Version:    0.7.0.1
 */