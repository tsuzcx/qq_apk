package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.os.Parcel;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

final class ReportUtil$1
  implements Runnable
{
  ReportUtil$1(byte[] paramArrayOfByte, long paramLong) {}
  
  public void run()
  {
    VideoInfo localVideoInfo;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(this.a, 0, this.a.length);
      localParcel.setDataPosition(0);
      localVideoInfo = new VideoInfo(localParcel);
      try
      {
        localParcel.recycle();
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      localVideoInfo = null;
    }
    if (localVideoInfo == null) {
      return;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = this.b;
    PublicAccountReportUtils.a(null, null, "0X800A732", "0X800A732", 0, 0, "", "", "", new VideoR5.Builder(localVideoInfo).k(localVideoInfo.l).n(3).o(localVideoInfo.av).i(l1 - l2).b().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil.1
 * JD-Core Version:    0.7.0.1
 */