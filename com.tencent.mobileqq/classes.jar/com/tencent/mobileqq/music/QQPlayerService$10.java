package com.tencent.mobileqq.music;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import com.tencent.qphone.base.util.QLog;

class QQPlayerService$10
  extends IQQPlayerService.Stub
{
  QQPlayerService$10(QQPlayerService paramQQPlayerService) {}
  
  public String a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIDL : generateToken : callerType=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",id=");
      localStringBuilder.append(paramString);
      QLog.d("QQPlayerService", 2, localStringBuilder.toString());
    }
    return QQPlayerService.a(paramInt, paramString);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : pause");
    }
    QQPlayerService.c(this.a);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : setPlayMode");
    }
    QQPlayerService.b(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIDL : setPlayBarIntent: ");
      localStringBuilder.append(paramIntent.toString());
      QLog.d("QQPlayerService", 2, localStringBuilder.toString());
    }
    QQPlayerService.a(paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : setExtras ");
    }
    QQPlayerService.a(paramBundle);
  }
  
  public void a(IQQPlayerCallback paramIQQPlayerCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : registerCallback");
    }
    if (paramIQQPlayerCallback == null) {
      return;
    }
    if (QQPlayerService.e(this.a) == null) {
      try
      {
        if (QQPlayerService.e(this.a) == null) {
          QQPlayerService.a(this.a, new RemoteCallbackList());
        }
      }
      finally {}
    }
    QQPlayerService.e(this.a).register(paramIQQPlayerCallback);
  }
  
  public void a(String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIDL : startPlay sCallback = ");
      localStringBuilder.append(QQPlayerService.x());
      localStringBuilder.append(",startIndex");
      localStringBuilder.append(paramInt);
      QLog.d("QQPlayerService", 2, localStringBuilder.toString());
    }
    if (QQPlayerService.x() != null)
    {
      QQPlayerService.a(QQPlayerService.x());
      QQPlayerService.b(null);
    }
    QQPlayerService.a(this.a, paramString, paramArrayOfSongInfo, paramInt);
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIDL : isPlayingMySong : token=");
      localStringBuilder.append(paramString);
      QLog.d("QQPlayerService", 2, localStringBuilder.toString());
    }
    return QQPlayerService.a(paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : resume");
    }
    QQPlayerService.d(this.a);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIDL : seekTo ");
      localStringBuilder.append(paramInt);
      QLog.d("QQPlayerService", 2, localStringBuilder.toString());
    }
    QQPlayerService.c(paramInt);
  }
  
  public void b(IQQPlayerCallback paramIQQPlayerCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : unRegisterCallback");
    }
    if ((paramIQQPlayerCallback != null) && (QQPlayerService.e(this.a) != null)) {
      QQPlayerService.e(this.a).unregister(paramIQQPlayerCallback);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : stop");
    }
    QQPlayerService.e(this.a);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : playNext");
    }
    QQPlayerService.b(this.a);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : playPrev");
    }
    QQPlayerService.a(this.a);
  }
  
  public boolean f()
  {
    return QQPlayerService.b();
  }
  
  public int g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayState");
    }
    return QQPlayerService.c();
  }
  
  public int h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayMode");
    }
    return QQPlayerService.d();
  }
  
  public int i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getDuration");
    }
    return QQPlayerService.i();
  }
  
  public int j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSongPosition");
    }
    return QQPlayerService.j();
  }
  
  public SongInfo k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSong");
    }
    return QQPlayerService.g();
  }
  
  public SongInfo l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getNextSong");
    }
    return QQPlayerService.q();
  }
  
  public int m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSongIndex");
    }
    return QQPlayerService.l();
  }
  
  public int n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayListCount");
    }
    return QQPlayerService.f();
  }
  
  public SongInfo[] o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayList");
    }
    return QQPlayerService.e();
  }
  
  public Intent p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayBarIntent ");
    }
    return QQPlayerService.m();
  }
  
  public Bundle q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getExtras ");
    }
    return QQPlayerService.n();
  }
  
  public String r()
  {
    return QQPlayerService.o();
  }
  
  public int s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentPlayPosition");
    }
    return QQPlayerService.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.10
 * JD-Core Version:    0.7.0.1
 */