package com.tencent.mobileqq.flashshow.player;

import com.tencent.mobileqq.flashshow.utils.FSProtoUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReporter;
import java.util.ArrayList;
import java.util.List;

class FSVideoReporter$2
  implements Runnable
{
  FSVideoReporter$2(FSVideoReporter paramFSVideoReporter) {}
  
  public void run()
  {
    if (FSVideoReporter.a(this.this$0) != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("flushVideoReportEvents event size:");
      ((StringBuilder)localObject).append(FSVideoReporter.a(this.this$0).size());
      QLog.d("FSVideoReporter", 1, ((StringBuilder)localObject).toString());
      localObject = new ArrayList(FSVideoReporter.a(this.this$0));
      QCircleReporter.getInstance().flushVideoReportByByte(FSProtoUtils.a((List)localObject));
      FSVideoReporter.a(this.this$0).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.FSVideoReporter.2
 * JD-Core Version:    0.7.0.1
 */