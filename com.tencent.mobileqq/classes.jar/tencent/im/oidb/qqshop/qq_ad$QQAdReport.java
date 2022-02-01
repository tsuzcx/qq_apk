package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad$QQAdReport
  extends MessageMicro<QQAdReport>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field act_time = PBField.initUInt32(0);
  public final PBUInt32Field action_id = PBField.initUInt32(0);
  public final PBStringField ad_id = PBField.initString("");
  public final PBUInt64Field ad_puin = PBField.initUInt64(0L);
  public final PBStringField antispam_info = PBField.initString("");
  public final PBStringField click_source = PBField.initString("");
  public final PBUInt32Field client_id = PBField.initUInt32(0);
  public final PBUInt32Field feeds_index = PBField.initUInt32(0);
  public final PBStringField feeds_video_attachment = PBField.initString("");
  public final PBBoolField get_back = PBField.initBool(false);
  public final PBStringField hardware_addr = PBField.initString("");
  public final PBStringField imei = PBField.initString("");
  public final PBBoolField is_impression = PBField.initBool(true);
  public final PBBoolField is_installed = PBField.initBool(false);
  public final PBUInt32Field msg_floor = PBField.initUInt32(0);
  public final PBStringField msgid = PBField.initString("");
  public final PBUInt32Field net_type = PBField.initUInt32(0);
  public final PBUInt32Field platform_id = PBField.initUInt32(0);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBStringField q_user_agent = PBField.initString("");
  public final PBStringField referer = PBField.initString("");
  public final PBStringField resolution = PBField.initString("");
  public final PBStringField sns_uid = PBField.initString("");
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field stay_time = PBField.initUInt32(0);
  public final PBStringField trace_id = PBField.initString("");
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBStringField user_agent = PBField.initString("");
  public final PBStringField version = PBField.initString("");
  public final PBStringField view_id = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 88, 96, 106, 112, 122, 130, 138, 146, 152, 160, 168, 176, 184, 192, 202, 210, 218, 224, 232, 240 }, new String[] { "type", "view_id", "trace_id", "act_time", "sns_uid", "resolution", "referer", "user_agent", "q_user_agent", "feeds_index", "is_impression", "is_installed", "feeds_video_attachment", "platform_id", "imei", "click_source", "antispam_info", "hardware_addr", "stay_time", "net_type", "client_id", "action_id", "msg_floor", "puin", "version", "ad_id", "msgid", "get_back", "ad_puin", "source" }, new Object[] { localInteger, "", "", localInteger, "", "", "", "", "", localInteger, Boolean.valueOf(true), localBoolean, "", localInteger, "", "", "", "", localInteger, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L), "", "", "", localBoolean, Long.valueOf(0L), localInteger }, QQAdReport.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad.QQAdReport
 * JD-Core Version:    0.7.0.1
 */