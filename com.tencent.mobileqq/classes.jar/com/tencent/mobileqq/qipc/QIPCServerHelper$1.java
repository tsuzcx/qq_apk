package com.tencent.mobileqq.qipc;

import eipc.EIPCServer;

class QIPCServerHelper$1
  implements Runnable
{
  QIPCServerHelper$1(QIPCServerHelper paramQIPCServerHelper) {}
  
  public void run()
  {
    EIPCServer localEIPCServer = QIPCServerHelper.getInstance().getServer();
    if (localEIPCServer != null) {
      localEIPCServer.sendMsgToRemoteModule(1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerHelper.1
 * JD-Core Version:    0.7.0.1
 */