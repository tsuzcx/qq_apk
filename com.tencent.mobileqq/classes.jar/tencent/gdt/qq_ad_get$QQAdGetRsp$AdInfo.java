package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo
  extends MessageMicro<AdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "product_type", "display_info", "report_info", "dest_info", "app_info", "exp_info", "ext", "ext_json", "cps_rsp_info", "wechat_app_info" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, "", null, null }, AdInfo.class);
  public qq_ad_get.QQAdGetRsp.AdInfo.AppInfo app_info = new qq_ad_get.QQAdGetRsp.AdInfo.AppInfo();
  public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo.CpsRspInfo> cps_rsp_info = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.CpsRspInfo.class);
  public qq_ad_get.QQAdGetRsp.AdInfo.DestInfo dest_info = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo display_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
  public qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo exp_info = new qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo();
  public qq_ad_get.QQAdGetRsp.AdInfo.Ext ext = new qq_ad_get.QQAdGetRsp.AdInfo.Ext();
  public final PBStringField ext_json = PBField.initString("");
  public final PBUInt32Field product_type = PBField.initUInt32(0);
  public qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo report_info = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
  public qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo wechat_app_info = new qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo
 * JD-Core Version:    0.7.0.1
 */