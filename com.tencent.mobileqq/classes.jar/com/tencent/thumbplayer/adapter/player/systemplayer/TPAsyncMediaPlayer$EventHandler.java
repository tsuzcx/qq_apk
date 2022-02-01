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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("EventHandler msg msg.what: ");
    ((StringBuilder)localObject).append(paramMessage.what);
    ((StringBuilder)localObject).append(", value: ");
    ((StringBuilder)localObject).append(paramMessage.what);
    ((StringBuilder)localObject).append(", arg1: ");
    ((StringBuilder)localObject).append(paramMessage.arg1);
    ((StringBuilder)localObject).append(", arg2: ");
    ((StringBuilder)localObject).append(paramMessage.arg2);
    TPLogUtil.i("TPThumbPlayer[TPAsyncMediaPlayer.java]", ((StringBuilder)localObject).toString());
    localObject = (TPAsyncMediaPlayer)this.mWeakRef.get();
    if (localObject == null)
    {
      TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", "mWeakRef is null");
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      TPLogUtil.i("TPThumbPlayer[TPAsyncMediaPlayer.java]", "eventHandler unknow msg");
      return;
    case 9: 
      ((TPAsyncMediaPlayer)localObject).handleSetPlaybackParams(paramMessage);
      return;
    case 8: 
      ((TPAsyncMediaPlayer)localObject).handleRelease();
      return;
    case 7: 
      ((TPAsyncMediaPlayer)localObject).handleReset();
      return;
    case 6: 
      ((TPAsyncMediaPlayer)localObject).handleStop();
      return;
    case 5: 
      ((TPAsyncMediaPlayer)localObject).handleSeekToByMode(paramMessage);
      return;
    case 4: 
      ((TPAsyncMediaPlayer)localObject).handleSeekTo(paramMessage);
      return;
    case 3: 
      ((TPAsyncMediaPlayer)localObject).handlePause();
      return;
    case 2: 
      ((TPAsyncMediaPlayer)localObject).handleStart();
      return;
    }
    ((TPAsyncMediaPlayer)localObject).handleSetSurface(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPAsyncMediaPlayer.EventHandler
 * JD-Core Version:    0.7.0.1
 */