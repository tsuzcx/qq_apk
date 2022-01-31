package com.tencent.tmassistant.st;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantbase.util.ac;

class f
  extends Handler
{
  f(SDKReportManager2 paramSDKReportManager2, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ac.c("SDKReportManager2", ">>mPostHandler handleMessage enter");
    if (paramMessage.what == 1)
    {
      ac.c("SDKReportManager2", ">>mPostHandler msg = MSG_POST_REPORT");
      SDKReportManager2.access$000(this.a);
    }
    for (;;)
    {
      ac.c("SDKReportManager2", ">>mPostHandler handleMessage exit");
      return;
      if (paramMessage.what == 2)
      {
        ac.c("SDKReportManager2", ">>mPostHandler msg = MSG_BATCH_REPORT");
        SDKReportManager2.access$100(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.st.f
 * JD-Core Version:    0.7.0.1
 */