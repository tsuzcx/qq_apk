package com.tencent.mobileqq.listentogether.ipc;

import android.text.TextUtils;
import arsh;
import auxb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.music.SongInfo;

public class ListenTogetherIPCModuleMainServer$1
  implements Runnable
{
  public ListenTogetherIPCModuleMainServer$1(arsh paramarsh, String paramString1, String paramString2) {}
  
  public void run()
  {
    auxb localauxb = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localauxb != null)
    {
      localauxb.a(this.a);
      if ((!localauxb.b()) && (!TextUtils.isEmpty(this.b)))
      {
        SongInfo localSongInfo = new SongInfo();
        localSongInfo.d = this.b;
        localauxb.a(localSongInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer.1
 * JD-Core Version:    0.7.0.1
 */