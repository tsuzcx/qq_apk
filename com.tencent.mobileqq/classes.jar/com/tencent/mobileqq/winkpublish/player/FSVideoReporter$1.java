package com.tencent.mobileqq.winkpublish.player;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

class FSVideoReporter$1
  implements Runnable
{
  FSVideoReporter$1(FSVideoReporter paramFSVideoReporter, Object paramObject, long paramLong, String paramString, List paramList) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(11003);
    if (this.a == null)
    {
      QLog.w("QCircleVideoReporter", 1, "reportVideoEvent feed is null");
      return;
    }
    localSingleDcData.report_data.addAll(FSVideoReporter.a(this.b, this.c, this.a));
    List localList = this.d;
    if ((localList != null) && (!localList.isEmpty())) {
      localSingleDcData.report_data.addAll(this.d);
    }
    FSVideoReporter.a(this.this$0).add(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.FSVideoReporter.1
 * JD-Core Version:    0.7.0.1
 */