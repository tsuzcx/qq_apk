package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

class OnlineFileSessionCenter$UploadProgressMakeEvtPump$1
  extends TimerTask
{
  OnlineFileSessionCenter$UploadProgressMakeEvtPump$1(OnlineFileSessionCenter.UploadProgressMakeEvtPump paramUploadProgressMakeEvtPump) {}
  
  public void run()
  {
    if (OnlineFileSessionCenter.UploadProgressMakeEvtPump.a(this.a) == null) {
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