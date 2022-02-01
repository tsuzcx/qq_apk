package com.tencent.mobileqq.winkpublish.player.timer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class FSVideoTimerManager$1
  extends Handler
{
  FSVideoTimerManager$1(FSVideoTimerManager paramFSVideoTimerManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        FSVideoTimerManager.a(this.a);
        return;
      }
      FSVideoTimerManager.b(this.a, (IFSVideoTimerListener)paramMessage.obj);
      return;
    }
    FSVideoTimerManager.a(this.a, (IFSVideoTimerListener)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.timer.FSVideoTimerManager.1
 * JD-Core Version:    0.7.0.1
 */