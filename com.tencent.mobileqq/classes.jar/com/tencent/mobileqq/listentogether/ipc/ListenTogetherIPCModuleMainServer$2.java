package com.tencent.mobileqq.listentogether.ipc;

import arsh;
import auxb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class ListenTogetherIPCModuleMainServer$2
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$2(arsh paramarsh) {}
  
  public void run()
  {
    auxb localauxb = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if ((localauxb != null) && (localauxb.a())) {
      localauxb.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.2
 * JD-Core Version:    0.7.0.1
 */