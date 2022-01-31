package com.tencent.mobileqq.listentogether.ipc;

import android.text.TextUtils;
import atjc;
import awon;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.music.SongInfo;

public class ListenTogetherIPCModuleMainServer$1
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$1(atjc paramatjc, String paramString1, String paramString2) {}
  
  public void run()
  {
    awon localawon = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localawon != null)
    {
      localawon.a(this.a);
      if ((!localawon.b()) && (!TextUtils.isEmpty(this.b)))
      {
        SongInfo localSongInfo = new SongInfo();
        localSongInfo.e = this.b;
        localawon.a(localSongInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.1
 * JD-Core Version:    0.7.0.1
 */