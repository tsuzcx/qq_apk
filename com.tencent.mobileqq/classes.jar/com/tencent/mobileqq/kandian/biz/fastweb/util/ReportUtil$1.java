package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.os.Parcel;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;

final class ReportUtil$1
  implements Runnable
{
  ReportUtil$1(byte[] paramArrayOfByte, long paramLong) {}
  
  public void run()
  {
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
      localParcel.setDataPosition(0);
      localObject = new VideoInfo(localParcel);
      try
      {
        localParcel.recycle();
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = this.jdField_a_of_type_Long;
    Object localObject = new VideoR5.Builder((VideoInfo)localObject).j(((VideoInfo)localObject).g).n(3).o(((VideoInfo)localObject).u).i(l1 - l2).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A732", "0X800A732", 0, 0, "", "", "", (String)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil.1
 * JD-Core Version:    0.7.0.1
 */