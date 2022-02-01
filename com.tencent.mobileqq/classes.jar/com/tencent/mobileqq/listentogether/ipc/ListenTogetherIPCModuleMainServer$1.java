package com.tencent.mobileqq.listentogether.ipc;

import android.text.TextUtils;
import awnf;
import baad;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.music.SongInfo;

public class ListenTogetherIPCModuleMainServer$1
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$1(awnf paramawnf, String paramString1, String paramString2) {}
  
  public void run()
  {
    baad localbaad = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localbaad != null)
    {
      localbaad.a(this.a);
      if ((!localbaad.b()) && (!TextUtils.isEmpty(this.b)))
      {
        SongInfo localSongInfo = new SongInfo();
        localSongInfo.e = this.b;
        localbaad.a(localSongInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.1
 * JD-Core Version:    0.7.0.1
 */