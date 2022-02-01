package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad$QQAdGetRsp$AdInfo
  extends MessageMicro<AdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 34, 42, 50, 58, 82, 98, 104, 114, 154, 160, 170, 178, 186, 194, 202, 210, 216, 226, 234, 250, 258, 266, 272, 288, 306, 314 }, new String[] { "img", "img_s", "txt", "desc", "rl", "apurl", "traceid", "product_id", "product_type", "via", "landing_page", "price", "button_txt", "view_id", "customized_invoke_url", "corporation_name", "corporate_image_name", "corporate_logo", "ad_uin", "ext", "video_url", "title_list", "image_list", "url_list", "aid", "creative_size", "button_url", "app_download_schema" }, new Object[] { "", "", "", "", "", "", "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "", "", "", Integer.valueOf(0), "", "", "", "", "", Long.valueOf(0L), Integer.valueOf(0), "", "" }, AdInfo.class);
  public final PBUInt32Field ad_uin = PBField.initUInt32(0);
  public final PBUInt64Field aid = PBField.initUInt64(0L);
  public final PBStringField app_download_schema = PBField.initString("");
  public final PBStringField apurl = PBField.initString("");
  public final PBStringField button_txt = PBField.initString("");
  public final PBStringField button_url = PBField.initString("");
  public final PBStringField corporate_image_name = PBField.initString("");
  public final PBStringField corporate_logo = PBField.initString("");
  public final PBStringField corporation_name = PBField.initString("");
  public final PBUInt32Field creative_size = PBField.initUInt32(0);
  public final PBStringField customized_invoke_url = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField ext = PBField.initString("");
  public final PBRepeatField<String> image_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField img = PBField.initString("");
  public final PBStringField img_s = PBField.initString("");
  public final PBStringField landing_page = PBField.initString("");
  public final PBUInt32Field price = PBField.initUInt32(0);
  public final PBStringField product_id = PBField.initString("");
  public final PBInt32Field product_type = PBField.initInt32(0);
  public final PBStringField rl = PBField.initString("");
  public final PBRepeatField<String> title_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField traceid = PBField.initString("");
  public final PBStringField txt = PBField.initString("");
  public final PBRepeatField<String> url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField via = PBField.initString("");
  public final PBStringField video_url = PBField.initString("");
  public final PBStringField view_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.AdInfo
 * JD-Core Version:    0.7.0.1
 */