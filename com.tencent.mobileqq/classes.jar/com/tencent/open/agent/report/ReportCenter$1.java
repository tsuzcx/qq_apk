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
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    case 1000: 
      ReportCenter localReportCenter = this.a;
      if (paramMessage.obj == null) {}
      for (localObject = null;; localObject = (String)paramMessage.obj)
      {
        localReportCenter.a((String)localObject);
        break;
      }
    }
    Object localObject = this.a;
    if (((paramMessage.obj instanceof Boolean)) && (((Boolean)paramMessage.obj).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      ((ReportCenter)localObject).a(bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.1
 * JD-Core Version:    0.7.0.1
 */