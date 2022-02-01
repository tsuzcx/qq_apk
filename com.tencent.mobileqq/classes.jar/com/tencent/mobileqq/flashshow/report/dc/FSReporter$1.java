package com.tencent.mobileqq.flashshow.report.dc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class FSReporter$1
  extends Handler
{
  FSReporter$1(FSReporter paramFSReporter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 4097)
    {
      if (i != 4098) {
        return;
      }
      FSReporter.b(this.a);
      return;
    }
    FSReporter.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSReporter.1
 * JD-Core Version:    0.7.0.1
 */