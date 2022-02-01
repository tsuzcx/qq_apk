package com.tencent.mobileqq.listentogether.ipc;

import awnf;
import baad;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class ListenTogetherIPCModuleMainServer$2
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$2(awnf paramawnf) {}
  
  public void run()
  {
    baad localbaad = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if ((localbaad != null) && (localbaad.a())) {
      localbaad.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.2
 * JD-Core Version:    0.7.0.1
 */