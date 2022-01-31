package com.tencent.mobileqq.listentogether.ipc;

import android.text.TextUtils;
import aqwp;
import atza;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.music.SongInfo;

public class ListenTogetherIPCModuleMainServer$1
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$1(aqwp paramaqwp, String paramString1, String paramString2) {}
  
  public void run()
  {
    atza localatza = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localatza != null)
    {
      localatza.a(this.a);
      if ((!localatza.b()) && (!TextUtils.isEmpty(this.b)))
      {
        SongInfo localSongInfo = new SongInfo();
        localSongInfo.d = this.b;
        localatza.a(localSongInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.1
 * JD-Core Version:    0.7.0.1
 */