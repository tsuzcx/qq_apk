package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.ref.WeakReference;

class TPSystemMediaPlayer$EventHandler
  extends Handler
{
  private WeakReference<TPSystemMediaPlayer> mWeakRef;
  
  public TPSystemMediaPlayer$EventHandler(Looper paramLooper, TPSystemMediaPlayer paramTPSystemMediaPlayer)
  {
    super(paramLooper);
    this.mWeakRef = new WeakReference(paramTPSystemMediaPlayer);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "EventHandler msg msg.what: " + paramMessage.what + ", value: " + paramMessage.what + ", arg1: " + paramMessage.arg1 + ", arg2: " + paramMessage.arg2);
    if ((TPSystemMediaPlayer)this.mWeakRef.get() == null)
    {
      TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "mWeakRef is null");
      return;
    }
    int i = paramMessage.what;
    TPLogUtil.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "eventHandler unknow msg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.EventHandler
 * JD-Core Version:    0.7.0.1
 */