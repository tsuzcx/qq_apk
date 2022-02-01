package com.tencent.mobileqq.listentogether;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.IQQMusicPlayClient;
import com.tencent.qphone.base.util.QLog;

class ListenTogetherManager$10
  implements Handler.Callback
{
  ListenTogetherManager$10(ListenTogetherManager paramListenTogetherManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1001) {
      return true;
    }
    paramMessage = this.a.a();
    if (paramMessage != null)
    {
      paramMessage.a = (SystemClock.elapsedRealtime() - paramMessage.c + paramMessage.a);
      paramMessage.c = SystemClock.elapsedRealtime();
      boolean bool = ListenTogetherManager.a(this.a).a(paramMessage);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSG_TYPE_TIME_SYNC seek is: ");
      localStringBuilder.append(paramMessage.a);
      localStringBuilder.append(" currentTime: ");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(" result: ");
      localStringBuilder.append(bool);
      QLog.i("ListenTogether.Seek", 1, localStringBuilder.toString());
    }
    else
    {
      QLog.i("ListenTogether.Manager", 1, "MSG_TYPE_TIME_SYNC startPlay musicInfo is null.");
    }
    ListenTogetherManager.a(this.a).removeMessages(1001);
    ListenTogetherManager.a(this.a).sendEmptyMessageDelayed(1001, ListenTogetherDPC.a().a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.10
 * JD-Core Version:    0.7.0.1
 */