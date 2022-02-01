package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo$ReportInfo
  extends MessageMicro<ReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "exposure_url", "click_url", "effect_url", "landing_page_report_url", "negative_feedback_url", "trace_info", "video_report_url", "thirdparty_monitor_urls" }, new Object[] { "", "", "", "", "", null, "", null }, ReportInfo.class);
  public final PBStringField click_url = PBField.initString("");
  public final PBStringField effect_url = PBField.initString("");
  public final PBStringField exposure_url = PBField.initString("");
  public final PBStringField landing_page_report_url = PBField.initString("");
  public final PBStringField negative_feedback_url = PBField.initString("");
  public QqAdGetProtos.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls thirdparty_monitor_urls = new QqAdGetProtos.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls();
  public QqAdGetProtos.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo trace_info = new QqAdGetProtos.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
  public final PBStringField video_report_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo.ReportInfo
 * JD-Core Version:    0.7.0.1
 */