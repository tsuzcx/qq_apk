package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.glue.viola.ViolaColorNote;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ReportUtil$2
  implements Runnable
{
  ReportUtil$2(ColorNote paramColorNote, long paramLong) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = ViolaColorNote.b(this.a);
      if (localJSONObject != null)
      {
        if (localJSONObject.length() == 0) {
          return;
        }
        long l1 = NetConnInfoCenter.getServerTime();
        long l2 = this.b;
        PublicAccountReportUtils.a(null, null, "0X800A732", "0X800A732", 0, 0, "", "", "", new VideoR5.Builder(localJSONObject.toString()).i(l1 - l2).b().a(), false);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleViolaRemainTimeReport: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("ReportUtil", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil.2
 * JD-Core Version:    0.7.0.1
 */