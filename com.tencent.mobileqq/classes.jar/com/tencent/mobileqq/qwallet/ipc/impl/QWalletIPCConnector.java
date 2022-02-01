package com.tencent.mobileqq.qwallet.ipc.impl;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

public class QWalletIPCConnector
{
  private static volatile QWalletIPCConnector a;
  private boolean b = false;
  private boolean c = false;
  private String d;
  private Object e = new Object();
  
  public static QWalletIPCConnector a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QWalletIPCConnector();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c()
  {
    this.c = true;
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "begin connect:");
    }
    QIPCClientHelper.getInstance().getClient().addListener(new QWalletIPCConnector.1(this));
    long l = System.currentTimeMillis();
    QIPCClientHelper.getInstance().getClient().connect(new QWalletIPCConnector.2(this, l));
  }
  
  public void b()
  {
    if ((!this.b) && (!this.c)) {
      c();
    }
    if (!this.b) {
      synchronized (this.e)
      {
        boolean bool = this.b;
        if (!bool) {
          try
          {
            this.e.wait(500L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCConnector
 * JD-Core Version:    0.7.0.1
 */