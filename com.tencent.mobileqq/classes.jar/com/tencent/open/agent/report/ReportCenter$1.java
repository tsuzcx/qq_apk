package com.tencent.open.agent.report;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ReportCenter$1
  extends Handler
{
  ReportCenter$1(ReportCenter paramReportCenter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 1000)
    {
      if (i == 1001)
      {
        localObject = this.a;
        boolean bool;
        if (((paramMessage.obj instanceof Boolean)) && (((Boolean)paramMessage.obj).booleanValue())) {
          bool = true;
        } else {
          bool = false;
        }
        ((ReportCenter)localObject).a(bool);
      }
    }
    else
    {
      ReportCenter localReportCenter = this.a;
      if (paramMessage.obj == null) {
        localObject = null;
      } else {
        localObject = (String)paramMessage.obj;
      }
      localReportCenter.a((String)localObject);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.1
 * JD-Core Version:    0.7.0.1
 */