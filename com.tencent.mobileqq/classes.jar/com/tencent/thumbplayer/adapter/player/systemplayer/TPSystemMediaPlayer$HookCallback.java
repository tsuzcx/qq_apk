package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPSystemMediaPlayer$HookCallback
  implements Handler.Callback
{
  private Handler impl;
  
  TPSystemMediaPlayer$HookCallback(Handler paramHandler)
  {
    this.impl = paramHandler;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      this.impl.handleMessage(paramMessage);
      return true;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        TPLogUtil.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "mediaPlayerExceptionHook, HookCallback, " + Log.getStackTraceString(paramMessage));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.HookCallback
 * JD-Core Version:    0.7.0.1
 */