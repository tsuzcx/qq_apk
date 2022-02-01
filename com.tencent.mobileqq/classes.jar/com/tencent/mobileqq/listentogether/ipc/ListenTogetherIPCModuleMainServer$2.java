package com.tencent.mobileqq.listentogether.ipc;

import awgm;
import aztn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class ListenTogetherIPCModuleMainServer$2
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$2(awgm paramawgm) {}
  
  public void run()
  {
    aztn localaztn = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if ((localaztn != null) && (localaztn.a())) {
      localaztn.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.2
 * JD-Core Version:    0.7.0.1
 */