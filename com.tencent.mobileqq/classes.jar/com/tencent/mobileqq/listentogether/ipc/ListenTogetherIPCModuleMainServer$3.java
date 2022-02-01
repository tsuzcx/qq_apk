package com.tencent.mobileqq.listentogether.ipc;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController;

class ListenTogetherIPCModuleMainServer$3
  implements Runnable
{
  ListenTogetherIPCModuleMainServer$3(ListenTogetherIPCModuleMainServer paramListenTogetherIPCModuleMainServer) {}
  
  public void run()
  {
    ProfileMusicBoxController localProfileMusicBoxController = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localProfileMusicBoxController != null) {
      localProfileMusicBoxController.o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.3
 * JD-Core Version:    0.7.0.1
 */