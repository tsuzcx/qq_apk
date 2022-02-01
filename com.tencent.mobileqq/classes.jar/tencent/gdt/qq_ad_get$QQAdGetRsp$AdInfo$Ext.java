package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$Ext
  extends MessageMicro<Ext>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField disable_auto_download = PBField.initBool(false);
  public final PBBoolField disable_video_on_top = PBField.initBool(false);
  public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> exp_map = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.ExpParam.class);
  public final PBBoolField is_app_preorder = PBField.initBool(false);
  public final PBInt32Field landing_page_style = PBField.initInt32(0);
  public final PBStringField market_deep_link = PBField.initString("");
  public final PBStringField market_package_name = PBField.initString("");
  public final PBUInt32Field mini_program_preload = PBField.initUInt32(0);
  public final PBBoolField no_clkcgi_jump = PBField.initBool(false);
  public final PBUInt32Field relation_target = PBField.initUInt32(0);
  public final PBEnumField render_pos_type = PBField.initEnum(0);
  public final PBRepeatField<String> screenshot_url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public qq_ad_get.QQAdGetRsp.AdInfo.SkAdNetwork sk_ad_network = new qq_ad_get.QQAdGetRsp.AdInfo.SkAdNetwork();
  public qq_ad_get.QQAdGetRsp.AdInfo.OfflinePageInfo xj_offline = new qq_ad_get.QQAdGetRsp.AdInfo.OfflinePageInfo();
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 66, 74, 80, 90, 98, 104, 112 }, new String[] { "mini_program_preload", "no_clkcgi_jump", "landing_page_style", "market_deep_link", "disable_auto_download", "market_package_name", "render_pos_type", "exp_map", "xj_offline", "relation_target", "screenshot_url_list", "sk_ad_network", "is_app_preorder", "disable_video_on_top" }, new Object[] { localInteger, localBoolean, localInteger, "", localBoolean, "", localInteger, null, null, localInteger, "", null, localBoolean, localBoolean }, Ext.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext
 * JD-Core Version:    0.7.0.1
 */