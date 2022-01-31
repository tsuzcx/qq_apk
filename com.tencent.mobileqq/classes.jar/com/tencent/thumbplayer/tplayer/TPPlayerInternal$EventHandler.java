package com.tencent.thumbplayer.tplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TPPlayerInternal$EventHandler
  extends Handler
{
  TPPlayerInternal$EventHandler(TPPlayerInternal paramTPPlayerInternal, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TPPlayerInternal.access$000(this.this$0, paramMessage, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayerInternal.EventHandler
 * JD-Core Version:    0.7.0.1
 */