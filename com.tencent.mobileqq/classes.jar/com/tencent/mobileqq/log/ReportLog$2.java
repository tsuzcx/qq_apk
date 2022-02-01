package com.tencent.mobileqq.log;

import android.os.Handler;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

final class ReportLog$2
  implements IHttpCommunicatorListener
{
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    ReportLog.a().sendEmptyMessage(10000001);
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    ReportLog.a = false;
    ReportLog.a().sendEmptyMessage(10000001);
  }
  
  public void handleRedirect(String paramString) {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.log.ReportLog.2
 * JD-Core Version:    0.7.0.1
 */