package tencent.im.oidb.cc_sso_report_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cc_sso_report_svr$ReportInfoReq
  extends MessageMicro<ReportInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "basic_info", "video_info", "play_info", "ext_info" }, new Object[] { null, null, null, null }, ReportInfoReq.class);
  public cc_sso_report_svr.BasicInfo basic_info = new cc_sso_report_svr.BasicInfo();
  public final PBRepeatMessageField<cc_sso_report_svr.KeyVal> ext_info = PBField.initRepeatMessage(cc_sso_report_svr.KeyVal.class);
  public cc_sso_report_svr.PlayInfo play_info = new cc_sso_report_svr.PlayInfo();
  public cc_sso_report_svr.VideoInfo video_info = new cc_sso_report_svr.VideoInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoReq
 * JD-Core Version:    0.7.0.1
 */