package com.tencent.tmassistant.st;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantbase.util.ab;

class f
  extends Handler
{
  f(SDKReportManager2 paramSDKReportManager2, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ab.c("SDKReportManager2", ">>mPostHandler handleMessage enter");
    if (paramMessage.what == 1)
    {
      ab.c("SDKReportManager2", ">>mPostHandler msg = MSG_POST_REPORT");
      SDKReportManager2.access$000(this.a);
    }
    else if (paramMessage.what == 2)
    {
      ab.c("SDKReportManager2", ">>mPostHandler msg = MSG_BATCH_REPORT");
      SDKReportManager2.access$100(this.a);
    }
    ab.c("SDKReportManager2", ">>mPostHandler handleMessage exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.st.f
 * JD-Core Version:    0.7.0.1
 */