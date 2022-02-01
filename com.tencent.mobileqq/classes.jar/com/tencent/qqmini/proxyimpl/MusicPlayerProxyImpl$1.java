package com.tencent.qqmini.proxyimpl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.IQQPlayerService.Stub;
import com.tencent.qphone.base.util.QLog;

class MusicPlayerProxyImpl$1
  implements ServiceConnection
{
  MusicPlayerProxyImpl$1(MusicPlayerProxyImpl paramMusicPlayerProxyImpl) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    MusicPlayerProxyImpl.a(this.a, IQQPlayerService.Stub.a(paramIBinder));
    try
    {
      if (MusicPlayerProxyImpl.a(this.a) != null) {
        MusicPlayerProxyImpl.a(this.a).a(MusicPlayerProxyImpl.b(this.a));
      }
      if (paramIBinder != null)
      {
        paramIBinder.linkToDeath(new MusicPlayerProxyImpl.1.1(this, paramIBinder), 0);
        return;
      }
    }
    catch (Exception paramComponentName)
    {
      paramIBinder = new StringBuilder();
      paramIBinder.append("onServiceConnected ");
      paramIBinder.append(paramComponentName);
      QLog.i("MusicPlayerProxyImpl", 2, paramIBinder.toString());
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceDisconnected ");
    localStringBuilder.append(paramComponentName);
    QLog.i("MusicPlayerProxyImpl", 2, localStringBuilder.toString());
    try
    {
      if (MusicPlayerProxyImpl.a(this.a) != null)
      {
        MusicPlayerProxyImpl.a(this.a).b(MusicPlayerProxyImpl.b(this.a));
        MusicPlayerProxyImpl.a(this.a, null);
        return;
      }
    }
    catch (Exception paramComponentName)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceDisconnected ");
      localStringBuilder.append(paramComponentName);
      QLog.i("MusicPlayerProxyImpl", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MusicPlayerProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */