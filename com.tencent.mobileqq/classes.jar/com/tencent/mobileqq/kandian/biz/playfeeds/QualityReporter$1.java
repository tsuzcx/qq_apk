package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.BasicInfo;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.PlayInfo;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoReq;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.VideoInfo;

final class QualityReporter$1
  implements Runnable
{
  QualityReporter$1(AbsReadInJoyVideoReportData paramAbsReadInJoyVideoReportData) {}
  
  public void run()
  {
    cc_sso_report_svr.ReportInfoReq localReportInfoReq = new cc_sso_report_svr.ReportInfoReq();
    localReportInfoReq.basic_info.channel.set(0);
    localReportInfoReq.basic_info.platform.set(1);
    localReportInfoReq.basic_info.version.set("8.8.17.5770");
    localReportInfoReq.basic_info.setHasFlag(true);
    localReportInfoReq.video_info.busitype.set(this.a.g);
    localReportInfoReq.video_info.file_size.set(this.a.M);
    localReportInfoReq.video_info.video_duration.set(this.a.Q);
    Object localObject = localReportInfoReq.video_info.encode_type;
    int i;
    if (this.a.T) {
      i = 2;
    } else {
      i = 1;
    }
    ((PBUInt32Field)localObject).set(i);
    localReportInfoReq.video_info.weight.set(this.a.O);
    localReportInfoReq.video_info.height.set(this.a.P);
    localReportInfoReq.video_info.rate.set(String.valueOf(this.a.L));
    localReportInfoReq.video_info.setHasFlag(true);
    localReportInfoReq.play_info.genurl_duration.set(this.a.x);
    localReportInfoReq.play_info.genurl_errcode.set(this.a.y);
    localReportInfoReq.play_info.prepare_duration.set(this.a.o);
    localReportInfoReq.play_info.play_duration.set(this.a.h);
    localReportInfoReq.play_info.play_errcode.set(this.a.k);
    localReportInfoReq.play_info.skipframe_cnt.set(this.a.X);
    localReportInfoReq.play_info.setHasFlag(true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportVideoQulity: vid=");
      ((StringBuilder)localObject).append(this.a.f);
      QLog.d("QualityReporter", 2, ((StringBuilder)localObject).toString());
    }
    QualityReporter.a(localReportInfoReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.QualityReporter.1
 * JD-Core Version:    0.7.0.1
 */