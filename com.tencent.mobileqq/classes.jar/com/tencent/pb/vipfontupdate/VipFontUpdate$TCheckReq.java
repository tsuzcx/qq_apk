package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipFontUpdate$TCheckReq
  extends MessageMicro<TCheckReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "i32_type", "i32_font_id", "str_message_test" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, TCheckReq.class);
  public final PBInt32Field i32_font_id = PBField.initInt32(0);
  public final PBInt32Field i32_type = PBField.initInt32(0);
  public final PBStringField str_message_test = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TCheckReq
 * JD-Core Version:    0.7.0.1
 */