package com.tencent.mobileqq.musicgene;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.IQQPlayerService.Stub;
import com.tencent.mobileqq.music.SongInfo;
import java.util.HashMap;

class MusicPlayerActivity$2
  implements ServiceConnection
{
  MusicPlayerActivity$2(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    MusicPlayerActivity.a(this.a, IQQPlayerService.Stub.a(paramIBinder));
    try
    {
      MusicPlayerActivity.a(this.a).a(MusicPlayerActivity.e(this.a));
      paramComponentName = MusicPlayerActivity.a(this.a).k();
      paramIBinder = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramComponentName, -1L);
      if (paramComponentName != null)
      {
        String str = MusicPlayerActivity.a(this.a, paramComponentName);
        if (MusicPlayerActivity.b().containsKey(str)) {
          MusicPlayerActivity.a(this.a, (MusicPlayerActivity.SimpleSongInfo)MusicPlayerActivity.b().get(str), paramIBinder);
        } else {
          MusicPlayerActivity.a(this.a, paramComponentName.e, paramComponentName.j, paramComponentName.g, paramIBinder, false, false);
        }
        int i = MusicPlayerActivity.a(this.a).g();
        Message.obtain(MusicPlayerActivity.b(this.a), 50, i, 0).sendToTarget();
        MusicPlayerActivity.c(this.a).a(this.a.app.getLongAccountUin(), paramComponentName.e, paramComponentName.j, paramComponentName.i, String.valueOf(paramComponentName.a), paramComponentName.f, MusicPlayerActivity.a(this.a).i());
      }
      return;
    }
    catch (Exception paramComponentName) {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = MusicPlayerActivity.a(this.a);
    if (paramComponentName != null) {}
    try
    {
      paramComponentName.b(MusicPlayerActivity.e(this.a));
      return;
    }
    catch (RemoteException paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.2
 * JD-Core Version:    0.7.0.1
 */