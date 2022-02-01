package com.tencent.mobileqq.listentogether.player;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QQMusicPlayClient$IncomingHandler
  extends Handler
{
  private final WeakReference<QQMusicPlayClient> a;
  
  QQMusicPlayClient$IncomingHandler(QQMusicPlayClient paramQQMusicPlayClient, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramQQMusicPlayClient);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQMusicPlayClient localQQMusicPlayClient = (QQMusicPlayClient)this.a.get();
    if (localQQMusicPlayClient == null)
    {
      super.handleMessage(paramMessage);
      return;
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 15)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                super.handleMessage(paramMessage);
                return;
              }
              paramMessage = paramMessage.getData();
              paramMessage.setClassLoader(ISong.class.getClassLoader());
              paramMessage = (ISong)paramMessage.getParcelable("key_song");
              if (QLog.isColorLevel()) {
                QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PLAY_SONG_CHANGE] %s", new Object[] { paramMessage.a() }));
              }
              QQMusicPlayClient.a(localQQMusicPlayClient, paramMessage);
              return;
            }
            paramMessage = paramMessage.getData();
            bool1 = paramMessage.getBoolean("key_focus_state", false);
            boolean bool2 = paramMessage.getBoolean("key_focus_transient", false);
            if (QLog.isColorLevel()) {
              QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_FOCUS_STATE_CHANGE] %b_%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
            }
            QQMusicPlayClient.a(localQQMusicPlayClient, bool1, bool2);
            return;
          }
          boolean bool1 = paramMessage.getData().getBoolean("key_net_state", false);
          if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_NET_STATE_CHANGE] %b", new Object[] { Boolean.valueOf(bool1) }));
          }
          QQMusicPlayClient.a(localQQMusicPlayClient, bool1);
          return;
        }
        paramMessage = paramMessage.getData();
        String str = paramMessage.getString("key_id");
        i = paramMessage.getInt("key_play_state", -1);
        if (QLog.isColorLevel()) {
          QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PLAY_STATE_CHANGE] %s %s", new Object[] { str, Const.a(i) }));
        }
        QQMusicPlayClient.a(localQQMusicPlayClient, str, i);
        if ((i == 4) && (QQMusicPlayClient.a(localQQMusicPlayClient))) {
          QQMusicPlayClient.a(localQQMusicPlayClient);
        }
      }
      else
      {
        paramMessage = paramMessage.getData();
        i = paramMessage.getInt("key_position", -1);
        int j = paramMessage.getInt("key_duration", -1);
        paramMessage = paramMessage.getString("key_id");
        if (((i <= 0) || (j <= 0)) && (QLog.isColorLevel())) {
          QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PROGRESS_CHANGE] [%d/%d] %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramMessage }));
        }
        QQMusicPlayClient.a(localQQMusicPlayClient, paramMessage, i, j);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->handleMessage[MSG_FROM_SERVICE]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayClient.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */