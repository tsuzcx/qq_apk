package com.tencent.mobileqq.listentogether.ipc;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController;

class ListenTogetherIPCModuleMainServer$2
  implements Runnable
{
  ListenTogetherIPCModuleMainServer$2(ListenTogetherIPCModuleMainServer paramListenTogetherIPCModuleMainServer) {}
  
  public void run()
  {
    ProfileMusicBoxController localProfileMusicBoxController = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if ((localProfileMusicBoxController != null) && (localProfileMusicBoxController.a())) {
      localProfileMusicBoxController.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.2
 * JD-Core Version:    0.7.0.1
 */