package com.tencent.mobileqq.listentogether.ipc;

import atjc;
import awon;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class ListenTogetherIPCModuleMainServer$3
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$3(atjc paramatjc) {}
  
  public void run()
  {
    awon localawon = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localawon != null) {
      localawon.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.3
 * JD-Core Version:    0.7.0.1
 */