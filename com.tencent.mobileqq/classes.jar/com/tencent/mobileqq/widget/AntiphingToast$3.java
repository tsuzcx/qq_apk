package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import bcjr;
import java.util.TimerTask;

public class AntiphingToast$3
  extends TimerTask
{
  public AntiphingToast$3(bcjr parambcjr) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    this.this$0.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AntiphingToast.3
 * JD-Core Version:    0.7.0.1
 */