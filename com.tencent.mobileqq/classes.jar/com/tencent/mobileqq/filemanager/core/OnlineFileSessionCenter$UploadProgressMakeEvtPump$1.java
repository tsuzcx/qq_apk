package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import android.os.Message;
import aqyj;
import aqyo;
import java.util.TimerTask;

public class OnlineFileSessionCenter$UploadProgressMakeEvtPump$1
  extends TimerTask
{
  public OnlineFileSessionCenter$UploadProgressMakeEvtPump$1(aqyo paramaqyo) {}
  
  public void run()
  {
    if (aqyo.a(this.a) == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    this.a.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.UploadProgressMakeEvtPump.1
 * JD-Core Version:    0.7.0.1
 */