package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipFontUpdate$TFontFreshReq
  extends MessageMicro<TFontFreshReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64 }, new String[] { "i32_local_font_id", "i32_cpu_freq", "i32_cpu_num", "i32_total_mem", "str_brand", "str_model", "i32_os_type", "i32_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0) }, TFontFreshReq.class);
  public final PBInt32Field i32_cpu_freq = PBField.initInt32(0);
  public final PBInt32Field i32_cpu_num = PBField.initInt32(0);
  public final PBInt32Field i32_local_font_id = PBField.initInt32(0);
  public final PBInt32Field i32_os_type = PBField.initInt32(0);
  public final PBInt32Field i32_total_mem = PBField.initInt32(0);
  public final PBInt32Field i32_version = PBField.initInt32(0);
  public final PBStringField str_brand = PBField.initString("");
  public final PBStringField str_model = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontFreshReq
 * JD-Core Version:    0.7.0.1
 */