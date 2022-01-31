package com.tencent.tmassistant.st;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantbase.util.r;

class c
  extends Handler
{
  c(SDKReportManager2 paramSDKReportManager2, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    r.c("SDKReportManager2", ">>mPostHandler handleMessage enter");
    if (paramMessage.what == 1)
    {
      r.c("SDKReportManager2", ">>mPostHandler msg = MSG_POST_REPORT");
      SDKReportManager2.access$000(this.a);
    }
    for (;;)
    {
      r.c("SDKReportManager2", ">>mPostHandler handleMessage exit");
      return;
      if (paramMessage.what == 2)
      {
        r.c("SDKReportManager2", ">>mPostHandler msg = MSG_BATCH_REPORT");
        SDKReportManager2.access$100(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.st.c
 * JD-Core Version:    0.7.0.1
 */