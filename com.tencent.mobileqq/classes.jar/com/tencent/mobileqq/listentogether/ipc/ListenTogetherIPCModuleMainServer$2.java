package com.tencent.mobileqq.listentogether.ipc;

import arsf;
import auwz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class ListenTogetherIPCModuleMainServer$2
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$2(arsf paramarsf) {}
  
  public void run()
  {
    auwz localauwz = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if ((localauwz != null) && (localauwz.a())) {
      localauwz.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.2
 * JD-Core Version:    0.7.0.1
 */