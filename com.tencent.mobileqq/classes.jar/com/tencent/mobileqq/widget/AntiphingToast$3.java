package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

class AntiphingToast$3
  extends TimerTask
{
  AntiphingToast$3(AntiphingToast paramAntiphingToast) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    this.this$0.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AntiphingToast.3
 * JD-Core Version:    0.7.0.1
 */