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
    }
    catch (Exception paramMessage)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mediaPlayerExceptionHook, HookCallback, ");
      localStringBuilder.append(Log.getStackTraceString(paramMessage));
      TPLogUtil.e("TPSystemMediaPlayer", localStringBuilder.toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.HookCallback
 * JD-Core Version:    0.7.0.1
 */