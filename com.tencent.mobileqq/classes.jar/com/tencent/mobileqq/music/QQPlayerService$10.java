package com.tencent.mobileqq.music;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import com.tencent.qphone.base.util.QLog;

class QQPlayerService$10
  extends IQQPlayerService.Stub
{
  QQPlayerService$10(QQPlayerService paramQQPlayerService) {}
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayState");
    }
    return QQPlayerService.a();
  }
  
  public Intent a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayBarIntent ");
    }
    return QQPlayerService.a();
  }
  
  public Bundle a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getExtras ");
    }
    return QQPlayerService.a();
  }
  
  public SongInfo a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSong");
    }
    return QQPlayerService.b();
  }
  
  public String a()
  {
    return QQPlayerService.a();
  }
  
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
    QQPlayerService.a(this.a);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : setPlayMode");
    }
    QQPlayerService.a(paramInt);
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
    if (QQPlayerService.a(this.a) == null) {
      try
      {
        if (QQPlayerService.a(this.a) == null) {
          QQPlayerService.a(this.a, new RemoteCallbackList());
        }
      }
      finally {}
    }
    QQPlayerService.a(this.a).register(paramIQQPlayerCallback);
  }
  
  public void a(String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIDL : startPlay sCallback = ");
      localStringBuilder.append(QQPlayerService.a());
      localStringBuilder.append(",startIndex");
      localStringBuilder.append(paramInt);
      QLog.d("QQPlayerService", 2, localStringBuilder.toString());
    }
    if (QQPlayerService.a() != null)
    {
      QQPlayerService.a(QQPlayerService.a());
      QQPlayerService.b(null);
    }
    QQPlayerService.a(this.a, paramString, paramArrayOfSongInfo, paramInt);
  }
  
  public boolean a()
  {
    return QQPlayerService.a();
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
  
  public SongInfo[] a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayList");
    }
    return QQPlayerService.a();
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayMode");
    }
    return QQPlayerService.b();
  }
  
  public SongInfo b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getNextSong");
    }
    return QQPlayerService.d();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : resume");
    }
    QQPlayerService.b(this.a);
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
    QQPlayerService.b(paramInt);
  }
  
  public void b(IQQPlayerCallback paramIQQPlayerCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : unRegisterCallback");
    }
    if ((paramIQQPlayerCallback != null) && (QQPlayerService.a(this.a) != null)) {
      QQPlayerService.a(this.a).unregister(paramIQQPlayerCallback);
    }
  }
  
  public int c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getDuration");
    }
    return QQPlayerService.d();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : stop");
    }
    QQPlayerService.c(this.a);
  }
  
  public int d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSongPosition");
    }
    return QQPlayerService.e();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : playNext");
    }
    QQPlayerService.b(this.a);
  }
  
  public int e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSongIndex");
    }
    return QQPlayerService.g();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : playPrev");
    }
    QQPlayerService.a(this.a);
  }
  
  public int f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayListCount");
    }
    return QQPlayerService.c();
  }
  
  public int g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentPlayPosition");
    }
    return QQPlayerService.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.10
 * JD-Core Version:    0.7.0.1
 */