package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.glue.viola.ViolaColorNote;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
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
      Object localObject = ViolaColorNote.b(this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote);
      if (localObject != null)
      {
        if (((JSONObject)localObject).length() == 0) {
          return;
        }
        long l1 = NetConnInfoCenter.getServerTime();
        long l2 = this.jdField_a_of_type_Long;
        localObject = new VideoR5.Builder(((JSONObject)localObject).toString()).i(l1 - l2).a().a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A732", "0X800A732", 0, 0, "", "", "", (String)localObject, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil.2
 * JD-Core Version:    0.7.0.1
 */