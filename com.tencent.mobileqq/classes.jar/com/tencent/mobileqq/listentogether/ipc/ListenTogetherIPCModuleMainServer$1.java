package com.tencent.mobileqq.listentogether.ipc;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController;

class ListenTogetherIPCModuleMainServer$1
  implements Runnable
{
  ListenTogetherIPCModuleMainServer$1(ListenTogetherIPCModuleMainServer paramListenTogetherIPCModuleMainServer, String paramString1, String paramString2) {}
  
  public void run()
  {
    ProfileMusicBoxController localProfileMusicBoxController = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).l();
    if (localProfileMusicBoxController != null)
    {
      localProfileMusicBoxController.a(this.a);
      if ((!localProfileMusicBoxController.o()) && (!TextUtils.isEmpty(this.b)))
      {
        SongInfo localSongInfo = new SongInfo();
        localSongInfo.g = this.b;
        localProfileMusicBoxController.a(localSongInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.1
 * JD-Core Version:    0.7.0.1
 */