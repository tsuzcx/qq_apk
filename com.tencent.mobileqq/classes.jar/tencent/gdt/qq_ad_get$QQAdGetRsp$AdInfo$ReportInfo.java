package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
  extends MessageMicro<ReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "exposure_url", "click_url", "effect_url", "landing_page_report_url", "negative_feedback_url", "trace_info", "video_report_url", "thirdparty_monitor_urls", "original_exposure_url", "complaint_url", "neg_fb_items" }, new Object[] { "", "", "", "", "", null, "", null, "", "", null }, ReportInfo.class);
  public final PBStringField click_url = PBField.initString("");
  public final PBStringField complaint_url = PBField.initString("");
  public final PBStringField effect_url = PBField.initString("");
  public final PBStringField exposure_url = PBField.initString("");
  public final PBStringField landing_page_report_url = PBField.initString("");
  public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem> neg_fb_items = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem.class);
  public final PBStringField negative_feedback_url = PBField.initString("");
  public final PBStringField original_exposure_url = PBField.initString("");
  public qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls thirdparty_monitor_urls = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls();
  public qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo trace_info = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
  public final PBStringField video_report_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo
 * JD-Core Version:    0.7.0.1
 */