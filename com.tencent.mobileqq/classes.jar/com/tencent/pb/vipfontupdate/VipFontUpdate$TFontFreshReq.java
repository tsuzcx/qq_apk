package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipFontUpdate$TFontFreshReq
  extends MessageMicro<TFontFreshReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field i32_cpu_freq = initInt32(0);
  public final PBInt32Field i32_cpu_num = initInt32(0);
  public final PBInt32Field i32_local_font_id = initInt32(0);
  public final PBInt32Field i32_os_type = initInt32(0);
  public final PBInt32Field i32_total_mem = initInt32(0);
  public final PBInt32Field i32_version = initInt32(0);
  public final PBStringField str_brand = initString("");
  public final PBStringField str_model = initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64 }, new String[] { "i32_local_font_id", "i32_cpu_freq", "i32_cpu_num", "i32_total_mem", "str_brand", "str_model", "i32_os_type", "i32_version" }, new Object[] { localInteger, localInteger, localInteger, localInteger, "", "", localInteger, localInteger }, TFontFreshReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontFreshReq
 * JD-Core Version:    0.7.0.1
 */