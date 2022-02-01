package com.tencent.mobileqq.listentogether.player;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class QQMusicPlayClient$1
  implements ServiceConnection
{
  QQMusicPlayClient$1(QQMusicPlayClient paramQQMusicPlayClient) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format(" --->onServiceConnected %s", new Object[] { ??? }));
    }
    if (QQMusicPlayClient.a(this.a) != null)
    {
      QQMusicPlayClient.a(this.a, new Messenger(paramIBinder));
      ??? = Message.obtain(null, 1);
      ???.setData(new Bundle());
      ???.replyTo = QQMusicPlayClient.a(this.a);
      try
      {
        QQMusicPlayClient.b(this.a).send(???);
      }
      catch (Throwable ???)
      {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 1, "onServiceConnected sendToService Throwable===>", ???);
      }
      catch (RemoteException ???)
      {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 1, "onServiceConnected sendToService exception===>", ???);
      }
      synchronized (this.a)
      {
        QQMusicPlayClient.a(this.a).set(1);
        ??? = this.a;
        QQMusicPlayClient.a(???, QQMusicPlayClient.a(???).get());
        return;
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (this.a)
    {
      QQMusicPlayClient.a(this.a).set(-1);
      QQMusicPlayClient.a(this.a, null);
      ??? = this.a;
      QQMusicPlayClient.a(???, QQMusicPlayClient.a(???).get());
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->onServiceDisconnected %s", new Object[] { paramComponentName }));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayClient.1
 * JD-Core Version:    0.7.0.1
 */