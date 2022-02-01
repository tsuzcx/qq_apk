package com.tencent.thumbplayer.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TPThreadSwitch$EventHandler
  extends Handler
{
  private TPThreadSwitch$EventHandler(TPThreadSwitch paramTPThreadSwitch, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TPThreadSwitch.access$100(this.this$0, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPThreadSwitch.EventHandler
 * JD-Core Version:    0.7.0.1
 */