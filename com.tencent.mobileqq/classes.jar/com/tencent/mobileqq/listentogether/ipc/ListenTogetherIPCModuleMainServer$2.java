package com.tencent.mobileqq.listentogether.ipc;

import aqwp;
import atza;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class ListenTogetherIPCModuleMainServer$2
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$2(aqwp paramaqwp) {}
  
  public void run()
  {
    atza localatza = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if ((localatza != null) && (localatza.a())) {
      localatza.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.2
 * JD-Core Version:    0.7.0.1
 */