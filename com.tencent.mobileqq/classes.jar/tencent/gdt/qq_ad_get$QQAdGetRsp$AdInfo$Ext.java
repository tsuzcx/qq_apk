package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$Ext
  extends MessageMicro<Ext>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56 }, new String[] { "mini_program_preload", "no_clkcgi_jump", "landing_page_style", "market_deep_link", "disable_auto_download", "market_package_name", "render_pos_type" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), "", Boolean.valueOf(false), "", Integer.valueOf(0) }, Ext.class);
  public final PBBoolField disable_auto_download = PBField.initBool(false);
  public final PBInt32Field landing_page_style = PBField.initInt32(0);
  public final PBStringField market_deep_link = PBField.initString("");
  public final PBStringField market_package_name = PBField.initString("");
  public final PBUInt32Field mini_program_preload = PBField.initUInt32(0);
  public final PBBoolField no_clkcgi_jump = PBField.initBool(false);
  public final PBEnumField render_pos_type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext
 * JD-Core Version:    0.7.0.1
 */