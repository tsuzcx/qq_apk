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
            if (QQMusicPlayService.k() == 2) {
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
            if (QQMusicPlayService.l() == null) {
              break label1416;
            }
            QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.e(), QQMusicPlayService.b(), QQMusicPlayService.n());
            return;
          case 12: 
            localObject2 = (QQMusicPlayService.ReleaseObject)paramMessage.obj;
            if (localObject2 == null) {
              return;
            }
            if (QQMusicPlayService.l() == null) {
              paramMessage = "null";
            } else {
              paramMessage = QQMusicPlayService.l().a();
            }
            QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("--->handleMessage[MSG_FROM_SERVICE_RELEASE] [%s]", new Object[] { paramMessage }));
            QQMusicPlayService.f((QQMusicPlayService)localObject1).clear();
            if (((QQMusicPlayService.ReleaseObject)localObject2).a != null)
            {
              ((QQMusicPlayService.ReleaseObject)localObject2).a.release();
              if (QQMusicPlayService.h() == ((QQMusicPlayService.ReleaseObject)localObject2).a) {
                QQMusicPlayService.a(null);
              }
            }
            getLooper().quit();
            return;
          case 10: 
          case 11: 
            if (QQMusicPlayService.h() == null)
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
            if ((QQMusicPlayService.h() != null) && (QQMusicPlayService.h().isPlaying()))
            {
              QQMusicPlayService.h().stop();
              QQMusicPlayReport.b(QQMusicPlayService.i(), QQMusicPlayService.j());
            }
            ((AudioManager)((QQMusicPlayService)localObject1).getSystemService("audio")).abandonAudioFocus(QQMusicPlayService.g((QQMusicPlayService)localObject1));
            QQMusicPlayService.a((QQMusicPlayService)localObject1, true);
            QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.e(), 4);
            ((QQMusicPlayService)localObject1).stopSelf();
            return;
          case 9: 
            QQMusicPlayService.b((QQMusicPlayService)localObject1, paramMessage.getData().getBoolean("key_mute", false));
            if (QLog.isColorLevel()) {
              QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_MUTE_PLAY] %b", new Object[] { Boolean.valueOf(QQMusicPlayService.b((QQMusicPlayService)localObject1)) }));
            }
            if (QQMusicPlayService.h() == null) {
              break label1416;
            }
            if (!QQMusicPlayService.b((QQMusicPlayService)localObject1)) {
              break label1436;
            }
            f = 0.0F;
            QQMusicPlayService.h().setVolume(f, f);
            return;
          case 8: 
            if (QQMusicPlayService.h() == null)
            {
              if (!QLog.isColorLevel()) {
                break label1441;
              }
              QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_RESUME_PLAY], sPlayer is null");
              return;
            }
            QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage[MSG_FROM_CLIENT_RESUME_PLAY]");
            if ((QQMusicPlayService.k() == 3) && (QQMusicPlayService.h() != null))
            {
              QQMusicPlayService.a((QQMusicPlayService)localObject1, false);
              paramMessage = (AudioManager)((QQMusicPlayService)localObject1).getSystemService("audio");
              i = paramMessage.requestAudioFocus(QQMusicPlayService.g((QQMusicPlayService)localObject1), 3, 1);
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
                QQMusicPlayService.h().start();
                QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.e(), 2);
                return;
              }
              QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.e(), 7);
              if (QQMusicPlayService.a((QQMusicPlayService)localObject1) == null) {
                break label1416;
              }
              QQMusicPlayService.a((QQMusicPlayService)localObject1).sendEmptyMessage(11);
              return;
            }
            if (QQMusicPlayService.k() == 6)
            {
              if (!NetworkUtil.isNetworkAvailable(((QQMusicPlayService)localObject1).getApplicationContext())) {
                break label1416;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QQMusicPlay.QQMusicPlayService", 2, String.format("resume from network interrupt, start play %s", new Object[] { QQMusicPlayService.l() }));
              }
              QQMusicPlayService.a((QQMusicPlayService)localObject1, false);
              QQMusicPlayService.b((QQMusicPlayService)localObject1, QQMusicPlayService.l());
              return;
            }
            if (QQMusicPlayService.k() != 5) {
              break label1416;
            }
            QQMusicPlayService.a((QQMusicPlayService)localObject1, false);
            QQMusicPlayService.b((QQMusicPlayService)localObject1, QQMusicPlayService.l());
            return;
          case 7: 
            if (QQMusicPlayService.h() == null)
            {
              if (!QLog.isColorLevel()) {
                break label1442;
              }
              QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_PAUSE_PLAY], sPlayer is null");
              return;
            }
            QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage[MSG_FROM_CLIENT_PAUSE_PLAY]");
            if ((QQMusicPlayService.k() != 2) && ((QQMusicPlayService.k() != 1) || (QQMusicPlayService.h() == null))) {
              break label1416;
            }
            ((AudioManager)((QQMusicPlayService)localObject1).getSystemService("audio")).abandonAudioFocus(QQMusicPlayService.g((QQMusicPlayService)localObject1));
            if (QQMusicPlayService.h().isPlaying()) {
              QQMusicPlayService.h().pause();
            }
            QQMusicPlayService.a((QQMusicPlayService)localObject1, true);
            QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.e(), 3);
            return;
          }
          if (QQMusicPlayService.h() == null)
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
          if ((paramMessage != null) && (paramMessage.c() != null) && (paramMessage.c().size() != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_START_PLAY] [%s]", new Object[] { paramMessage }));
            }
            if ((paramMessage.equals(QQMusicPlayService.l())) && ((QQMusicPlayService.k() == 2) || (QQMusicPlayService.k() == 1)))
            {
              int m = QQMusicPlayService.b();
              if (m < 0) {
                i = -1;
              } else {
                i = Math.abs(m - paramMessage.e());
              }
              int j = k;
              if (QQMusicPlayService.k() == 2) {
                if (m >= 0)
                {
                  j = k;
                  if (Math.abs(m - paramMessage.e()) <= 3000) {}
                }
                else
                {
                  QQMusicPlayService.m();
                  QQMusicPlayService.a((QQMusicPlayService)localObject1, paramMessage.e());
                  j = 1;
                }
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("player start play player seek: ");
              ((StringBuilder)localObject2).append(m);
              ((StringBuilder)localObject2).append(" music seek: ");
              ((StringBuilder)localObject2).append(paramMessage.e());
              ((StringBuilder)localObject2).append(" currentTime: ");
              ((StringBuilder)localObject2).append(System.currentTimeMillis());
              QLog.i("ListenTogether.Seek", 1, ((StringBuilder)localObject2).toString());
              if (j != 0) {
                QQMusicPlayReport.a(i, NetworkUtil.getNetworkType((Context)localObject1));
              }
            }
            else
            {
              if (QQMusicPlayService.h().isPlaying())
              {
                if (QLog.isColorLevel()) {
                  QLog.i("QQMusicPlay.QQMusicPlayService", 2, "------------stopped-------------");
                }
                QQMusicPlayService.h().stop();
                QQMusicPlayReport.b(QQMusicPlayService.i(), QQMusicPlayService.j());
              }
              QQMusicPlayService.a((QQMusicPlayService)localObject1, QQMusicPlayService.e(), 0);
              QQMusicPlayService.a((QQMusicPlayService)localObject1, false);
              QQMusicPlayService.a((QQMusicPlayService)localObject1, paramMessage);
              QQMusicPlayService.b((QQMusicPlayService)localObject1, paramMessage);
              if (paramMessage.e() > 0) {
                QQMusicPlayService.a((QQMusicPlayService)localObject1, paramMessage.e());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */