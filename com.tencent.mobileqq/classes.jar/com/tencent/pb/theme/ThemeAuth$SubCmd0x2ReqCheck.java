package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$SubCmd0x2ReqCheck
  extends MessageMicro<SubCmd0x2ReqCheck>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_theme_id", "str_theme_version" }, new Object[] { Integer.valueOf(0), "" }, SubCmd0x2ReqCheck.class);
  public final PBStringField str_theme_version = PBField.initString("");
  public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.SubCmd0x2ReqCheck
 * JD-Core Version:    0.7.0.1
 */