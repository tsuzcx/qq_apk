package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFontUpdate$TPosterFontInfo
  extends MessageMicro<TPosterFontInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "i32_font_id", "u64_ts" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, TPosterFontInfo.class);
  public final PBInt32Field i32_font_id = PBField.initInt32(0);
  public final PBUInt64Field u64_ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TPosterFontInfo
 * JD-Core Version:    0.7.0.1
 */