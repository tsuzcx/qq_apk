package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo
  extends MessageMicro<AdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "product_type", "display_info", "report_info", "dest_info", "app_info", "exp_info", "ext", "ext_json", "cps_rsp_info", "wechat_app_info" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, "", null, null }, AdInfo.class);
  public QqAdGetProtos.QQAdGetRsp.AdInfo.AppInfo app_info = new QqAdGetProtos.QQAdGetRsp.AdInfo.AppInfo();
  public final PBRepeatMessageField<QqAdGetProtos.QQAdGetRsp.AdInfo.CpsRspInfo> cps_rsp_info = PBField.initRepeatMessage(QqAdGetProtos.QQAdGetRsp.AdInfo.CpsRspInfo.class);
  public QqAdGetProtos.QQAdGetRsp.AdInfo.DestInfo dest_info = new QqAdGetProtos.QQAdGetRsp.AdInfo.DestInfo();
  public QqAdGetProtos.QQAdGetRsp.AdInfo.DisplayInfo display_info = new QqAdGetProtos.QQAdGetRsp.AdInfo.DisplayInfo();
  public QqAdGetProtos.QQAdGetRsp.AdInfo.ExpInfo exp_info = new QqAdGetProtos.QQAdGetRsp.AdInfo.ExpInfo();
  public QqAdGetProtos.QQAdGetRsp.AdInfo.Ext ext = new QqAdGetProtos.QQAdGetRsp.AdInfo.Ext();
  public final PBStringField ext_json = PBField.initString("");
  public final PBUInt32Field product_type = PBField.initUInt32(0);
  public QqAdGetProtos.QQAdGetRsp.AdInfo.ReportInfo report_info = new QqAdGetProtos.QQAdGetRsp.AdInfo.ReportInfo();
  public QqAdGetProtos.QQAdGetRsp.AdInfo.WeChatAppInfo wechat_app_info = new QqAdGetProtos.QQAdGetRsp.AdInfo.WeChatAppInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo
 * JD-Core Version:    0.7.0.1
 */