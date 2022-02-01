package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFontUpdate$TDiyFontRsp$TDiyFontRspInfo
  extends MessageMicro<TDiyFontRspInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "u64_uin", "i32_font_id", "u32_diy_font_timestamp", "str_diy_font_config" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, TDiyFontRspInfo.class);
  public final PBInt32Field i32_font_id = PBField.initInt32(0);
  public final PBStringField str_diy_font_config = PBField.initString("");
  public final PBUInt32Field u32_diy_font_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo
 * JD-Core Version:    0.7.0.1
 */