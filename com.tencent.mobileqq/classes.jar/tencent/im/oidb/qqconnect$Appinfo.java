package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqconnect$Appinfo
  extends MessageMicro<Appinfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField android_pack_name = PBField.initString("");
  public final PBUInt32Field app_class = PBField.initUInt32(0);
  public final PBStringField app_key = PBField.initString("");
  public final PBStringField app_name = PBField.initString("");
  public final PBUInt32Field app_state = PBField.initUInt32(0);
  public final PBUInt32Field app_subclass = PBField.initUInt32(0);
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBStringField app_url = PBField.initString("");
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt64Field auth_time = PBField.initUInt64(0L);
  public final PBUInt64Field developer_uin = PBField.initUInt64(0L);
  public final PBStringField icon_middle_url = PBField.initString("");
  public final PBStringField icon_mini_url = PBField.initString("");
  public final PBStringField icon_small_url = PBField.initString("");
  public final PBStringField icon_url = PBField.initString("");
  public final PBStringField iphone_url_scheme = PBField.initString("");
  public final PBInt32Field is_hatchery = PBField.initInt32(0);
  public qqconnect.MiniAppInfo mini_app_info = new qqconnect.MiniAppInfo();
  public qqconnect.MobileAppInfo mobile_app_info = new qqconnect.MobileAppInfo();
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt32Field qqconnect_feature = PBField.initUInt32(0);
  public final PBStringField remark = PBField.initString("");
  public final PBStringField source_url = PBField.initString("");
  public qqconnect.TemplateMsgConfig template_msg_config = new qqconnect.TemplateMsgConfig();
  public qqconnect.TencentDocsAppinfo tencent_docs_appinfo = new qqconnect.TencentDocsAppinfo();
  public final PBRepeatField<Long> test_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField universal_link = PBField.initString("");
  public qqconnect.WebAppInfo web_app_info = new qqconnect.WebAppInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 66, 74, 82, 90, 98, 106, 168, 176, 184, 194, 202, 208, 218, 226, 232, 240, 248, 802, 810, 818, 826 }, new String[] { "appid", "app_type", "platform", "app_name", "app_key", "app_state", "iphone_url_scheme", "android_pack_name", "icon_url", "source_url", "icon_small_url", "icon_middle_url", "tencent_docs_appinfo", "developer_uin", "app_class", "app_subclass", "remark", "icon_mini_url", "auth_time", "app_url", "universal_link", "qqconnect_feature", "is_hatchery", "test_uin_list", "template_msg_config", "mini_app_info", "web_app_info", "mobile_app_info" }, new Object[] { localInteger, localInteger, localInteger, "", "", localInteger, "", "", "", "", "", "", null, localLong, localInteger, localInteger, "", "", localLong, "", "", localInteger, localInteger, localLong, null, null, null, null }, Appinfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.Appinfo
 * JD-Core Version:    0.7.0.1
 */