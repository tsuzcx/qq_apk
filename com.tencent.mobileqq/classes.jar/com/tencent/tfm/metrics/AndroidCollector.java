package com.tencent.tfm.metrics;

import android.os.Message;
import com.tencent.tfm.metrics.api.Reporter;
import com.tencent.tfm.metrics.bean.LogItem;

public class AndroidCollector
  implements ICollector
{
  private static final int MESSAGE_PUSH = 0;
  private static final int MESSAGE_REPORT = 1;
  private AndroidCollector.CollectorHandler handler;
  private long reportInterval = 10000L;
  private Reporter reporter;
  
  AndroidCollector()
  {
    new AndroidCollector.1(this, "tfm_metrics").start();
  }
  
  public void push(LogItem paramLogItem)
  {
    if ((paramLogItem == null) || (this.handler == null)) {
      return;
    }
    Message localMessage = this.handler.obtainMessage();
    localMessage.what = 0;
    localMessage.obj = paramLogItem;
    this.handler.sendMessage(localMessage);
  }
  
  public void setReporter(Reporter paramReporter)
  {
    this.reporter = paramReporter;
  }
  
  public void updateReportInterval(long paramLong)
  {
    this.reportInterval = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.AndroidCollector
 * JD-Core Version:    0.7.0.1
 */