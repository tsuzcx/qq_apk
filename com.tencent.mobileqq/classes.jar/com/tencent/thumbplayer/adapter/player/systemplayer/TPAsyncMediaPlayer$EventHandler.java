package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.ref.WeakReference;

class TPAsyncMediaPlayer$EventHandler
  extends Handler
{
  private WeakReference<TPAsyncMediaPlayer> mWeakRef;
  
  public TPAsyncMediaPlayer$EventHandler(Looper paramLooper, TPAsyncMediaPlayer paramTPAsyncMediaPlayer)
  {
    super(paramLooper);
    this.mWeakRef = new WeakReference(paramTPAsyncMediaPlayer);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TPLogUtil.i("TPThumbPlayer[TPAsyncMediaPlayer.java]", "EventHandler msg msg.what: " + paramMessage.what + ", value: " + paramMessage.what + ", arg1: " + paramMessage.arg1 + ", arg2: " + paramMessage.arg2);
    TPAsyncMediaPlayer localTPAsyncMediaPlayer = (TPAsyncMediaPlayer)this.mWeakRef.get();
    if (localTPAsyncMediaPlayer == null)
    {
      TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", "mWeakRef is null");
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      TPLogUtil.i("TPThumbPlayer[TPAsyncMediaPlayer.java]", "eventHandler unknow msg");
      return;
    case 1: 
      localTPAsyncMediaPlayer.handleSetSurface(paramMessage);
      return;
    case 2: 
      localTPAsyncMediaPlayer.handleStart();
      return;
    case 3: 
      localTPAsyncMediaPlayer.handlePause();
      return;
    case 4: 
      localTPAsyncMediaPlayer.handleSeekTo(paramMessage);
      return;
    case 5: 
      localTPAsyncMediaPlayer.handleSeekToByMode(paramMessage);
      return;
    case 6: 
      localTPAsyncMediaPlayer.handleStop();
      return;
    case 7: 
      localTPAsyncMediaPlayer.handleReset();
      return;
    case 8: 
      localTPAsyncMediaPlayer.handleRelease();
      return;
    }
    localTPAsyncMediaPlayer.handleSetPlaybackParams(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPAsyncMediaPlayer.EventHandler
 * JD-Core Version:    0.7.0.1
 */