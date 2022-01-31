package com.tencent.mobileqq.listentogether.ipc;

import arsh;
import auxb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class ListenTogetherIPCModuleMainServer$3
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$3(arsh paramarsh) {}
  
  public void run()
  {
    auxb localauxb = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localauxb != null) {
      localauxb.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.3
 * JD-Core Version:    0.7.0.1
 */