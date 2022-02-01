package com.tencent.mobileqq.listentogether.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.List;

class QQMusicPlayService$IncomingHandler
  extends Handler
{
  private final WeakReference<QQMusicPlayService> a;
  
  QQMusicPlayService$IncomingHandler(QQMusicPlayService paramQQMusicPlayService, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramQQMusicPlayService);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = (QQMusicPlayService)this.a.get();
    if (localObject1 == null)
    {
      super.handleMessage(paramMessage);
      return;
    }
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        int k = 0;
        if (i != 1)
        {
          Object localObject2;
          switch (i)
          {
          default: 
            super.handleMessage(paramMessage);
            return;
          case 14: 
            if (QQMusicPlayService.e() == 2) {
              QQMusicPlayService.a((QQMusicPlayService)localObject1).sendEmptyMessageDelayed(14, 500L);
            } else {
              QQMusicPlayService.a((QQMusicPlayService)localObject1).removeMessages(14);
            }
          case 13: 
            if ((QLog.isColorLevel()) && (paramMessage.what == 13))
            {
              if (paramMessage.what != 13) {
                break label1417;
              }
              bool = true;
              QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_SYNC_PROGRESS=%b]", new Object[] { Boolean.valueOf(bool) }));
            }
            if (QQMusicPlayService.b() == null) {
              break label1416;
            }
            QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.b(), QQMusicPlayService.b(), QQMusicPlayService.g());
            return;
          case 12: 
            localObject2 = (QQMusicPlayService.ReleaseObject)paramMessage.obj;
            if (localObject2 == null) {
              return;
            }
            if (QQMusicPlayService.b() == null) {
              paramMessage = "null";
            } else {
              paramMessage = QQMusicPlayService.b().a();
            }
            QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("--->handleMessage[MSG_FROM_SERVICE_RELEASE] [%s]", new Object[] { paramMessage }));
            QQMusicPlayService.a((QQMusicPlayService)localObject1).clear();
            if (((QQMusicPlayService.ReleaseObject)localObject2).a != null)
            {
              ((QQMusicPlayService.ReleaseObject)localObject2).a.release();
              if (QQMusicPlayService.a() == ((QQMusicPlayService.ReleaseObject)localObject2).a) {
                QQMusicPlayService.a(null);
              }
            }
            getLooper().quit();
            return;
          case 10: 
          case 11: 
            if (QQMusicPlayService.a() == null)
            {
              if (!QLog.isColorLevel()) {
                break label1429;
              }
              if (paramMessage.what != 10) {
                break label1423;
              }
              bool = true;
              QLog.e("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_STOP_PLAY=%b],sPlayer is null", new Object[] { Boolean.valueOf(bool) }));
              return;
            }
            if (paramMessage.what != 10) {
              break label1430;
            }
            bool = true;
            QLog.d("QQMusicPlay.QQMusicPlayService", 1, String.format("--->handleMessage[MSG_FROM_CLIENT_STOP_PLAY=%b]", new Object[] { Boolean.valueOf(bool) }));
            if ((QQMusicPlayService.a() != null) && (QQMusicPlayService.a().isPlaying()))
            {
              QQMusicPlayService.a().stop();
              QQMusicPlayReport.b(QQMusicPlayService.b(), QQMusicPlayService.d());
            }
            ((AudioManager)((QQMusicPlayService)localObject1).getSystemService("audio")).abandonAudioFocus(QQMusicPlayService.a((QQMusicPlayService)localObject1));
            QQMusicPlayService.a((QQMusicPlayService)localObject1, true);
            QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.b(), 4);
            ((QQMusicPlayService)localObject1).stopSelf();
            return;
          case 9: 
            QQMusicPlayService.b((QQMusicPlayService)localObject1, paramMessage.getData().getBoolean("key_mute", false));
            if (QLog.isColorLevel()) {
              QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_MUTE_PLAY] %b", new Object[] { Boolean.valueOf(QQMusicPlayService.a((QQMusicPlayService)localObject1)) }));
            }
            if (QQMusicPlayService.a() == null) {
              break label1416;
            }
            if (!QQMusicPlayService.a((QQMusicPlayService)localObject1)) {
              break label1436;
            }
            f = 0.0F;
            QQMusicPlayService.a().setVolume(f, f);
            return;
          case 8: 
            if (QQMusicPlayService.a() == null)
            {
              if (!QLog.isColorLevel()) {
                break label1441;
              }
              QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_RESUME_PLAY], sPlayer is null");
              return;
            }
            QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage[MSG_FROM_CLIENT_RESUME_PLAY]");
            if ((QQMusicPlayService.e() == 3) && (QQMusicPlayService.a() != null))
            {
              QQMusicPlayService.a((QQMusicPlayService)localObject1, false);
              paramMessage = (AudioManager)((QQMusicPlayService)localObject1).getSystemService("audio");
              i = paramMessage.requestAudioFocus(QQMusicPlayService.a((QQMusicPlayService)localObject1), 3, 1);
              bool = paramMessage.isMusicActive();
              if (QLog.isColorLevel())
              {
                paramMessage = new StringBuilder();
                paramMessage.append("resumePlay requestAudioFocus,result:");
                paramMessage.append(i);
                paramMessage.append(" isMusicActive:");
                paramMessage.append(bool);
                QLog.d("QQMusicPlay.QQMusicPlayService", 2, paramMessage.toString());
              }
              if (i == 1)
              {
                QQMusicPlayService.a().start();
                QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.b(), 2);
                return;
              }
              QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.b(), 7);
              if (QQMusicPlayService.a((QQMusicPlayService)localObject1) == null) {
                break label1416;
              }
              QQMusicPlayService.a((QQMusicPlayService)localObject1).sendEmptyMessage(11);
              return;
            }
            if (QQMusicPlayService.e() == 6)
            {
              if (!NetworkUtil.isNetworkAvailable(((QQMusicPlayService)localObject1).getApplicationContext())) {
                break label1416;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QQMusicPlay.QQMusicPlayService", 2, String.format("resume from network interrupt, start play %s", new Object[] { QQMusicPlayService.b() }));
              }
              QQMusicPlayService.a((QQMusicPlayService)localObject1, false);
              QQMusicPlayService.b((QQMusicPlayService)localObject1, QQMusicPlayService.b());
              return;
            }
            if (QQMusicPlayService.e() != 5) {
              break label1416;
            }
            QQMusicPlayService.a((QQMusicPlayService)localObject1, false);
            QQMusicPlayService.b((QQMusicPlayService)localObject1, QQMusicPlayService.b());
            return;
          case 7: 
            if (QQMusicPlayService.a() == null)
            {
              if (!QLog.isColorLevel()) {
                break label1442;
              }
              QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_PAUSE_PLAY], sPlayer is null");
              return;
            }
            QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage[MSG_FROM_CLIENT_PAUSE_PLAY]");
            if ((QQMusicPlayService.e() != 2) && ((QQMusicPlayService.e() != 1) || (QQMusicPlayService.a() == null))) {
              break label1416;
            }
            ((AudioManager)((QQMusicPlayService)localObject1).getSystemService("audio")).abandonAudioFocus(QQMusicPlayService.a((QQMusicPlayService)localObject1));
            if (QQMusicPlayService.a().isPlaying()) {
              QQMusicPlayService.a().pause();
            }
            QQMusicPlayService.a((QQMusicPlayService)localObject1, true);
            QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.b(), 3);
            return;
          }
          if (QQMusicPlayService.a() == null)
          {
            if (!QLog.isColorLevel()) {
              break label1443;
            }
            QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_START_PLAY], sPlayer is null");
            return;
          }
          paramMessage = paramMessage.getData();
          paramMessage.setClassLoader(ISong.class.getClassLoader());
          paramMessage = (ISong)paramMessage.getParcelable("key_song");
          if ((paramMessage != null) && (paramMessage.a() != null) && (paramMessage.a().size() != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_START_PLAY] [%s]", new Object[] { paramMessage }));
            }
            if ((paramMessage.equals(QQMusicPlayService.b())) && ((QQMusicPlayService.e() == 2) || (QQMusicPlayService.e() == 1)))
            {
              int m = QQMusicPlayService.b();
              if (m < 0) {
                i = -1;
              } else {
                i = Math.abs(m - paramMessage.a());
              }
              int j = k;
              if (QQMusicPlayService.e() == 2) {
                if (m >= 0)
                {
                  j = k;
                  if (Math.abs(m - paramMessage.a()) <= 3000) {}
                }
                else
                {
                  QQMusicPlayService.f();
                  QQMusicPlayService.a((QQMusicPlayService)localObject1, paramMessage.a());
                  j = 1;
                }
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("player start play player seek: ");
              ((StringBuilder)localObject2).append(m);
              ((StringBuilder)localObject2).append(" music seek: ");
              ((StringBuilder)localObject2).append(paramMessage.a());
              ((StringBuilder)localObject2).append(" currentTime: ");
              ((StringBuilder)localObject2).append(System.currentTimeMillis());
              QLog.i("ListenTogether.Seek", 1, ((StringBuilder)localObject2).toString());
              if (j != 0) {
                QQMusicPlayReport.a(i, NetworkUtil.getNetworkType((Context)localObject1));
              }
            }
            else
            {
              if (QQMusicPlayService.a().isPlaying())
              {
                if (QLog.isColorLevel()) {
                  QLog.i("QQMusicPlay.QQMusicPlayService", 2, "------------stopped-------------");
                }
                QQMusicPlayService.a().stop();
                QQMusicPlayReport.b(QQMusicPlayService.b(), QQMusicPlayService.d());
              }
              QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.b(), 0);
              QQMusicPlayService.a((QQMusicPlayService)localObject1, false);
              QQMusicPlayService.a((QQMusicPlayService)localObject1, paramMessage);
              QQMusicPlayService.b((QQMusicPlayService)localObject1, paramMessage);
              if (paramMessage.a() > 0) {
                QQMusicPlayService.a((QQMusicPlayService)localObject1, paramMessage.a());
              }
            }
          }
          else
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_START_PLAY] err url is null [%s]", new Object[] { paramMessage }));
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT]");
          }
          paramMessage = paramMessage.replyTo;
          if (paramMessage != null)
          {
            QQMusicPlayService.a((QQMusicPlayService)localObject1, paramMessage);
            localObject1 = Message.obtain(null, 0);
            ((Message)localObject1).setData(new Bundle());
            try
            {
              paramMessage.send((Message)localObject1);
              return;
            }
            catch (RemoteException paramMessage)
            {
              if (!QLog.isColorLevel()) {
                break label1416;
              }
            }
            QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT] sendToClient excepiton", paramMessage);
            return;
          }
        }
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage exception==>", paramMessage);
      }
      label1416:
      return;
      label1417:
      boolean bool = false;
      continue;
      label1423:
      bool = false;
      continue;
      label1429:
      return;
      label1430:
      bool = false;
      continue;
      label1436:
      float f = 1.0F;
    }
    label1441:
    return;
    label1442:
    return;
    label1443:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */