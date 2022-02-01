package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$SubCmd0x3ReqSet
  extends MessageMicro<SubCmd0x3ReqSet>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_theme_id", "uint32_suit_id", "uint32_diy_theme_flag", "diy_theme_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, SubCmd0x3ReqSet.class);
  public ThemeAuth.diyThemeInfo diy_theme_info = new ThemeAuth.diyThemeInfo();
  public final PBUInt32Field uint32_diy_theme_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_suit_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.SubCmd0x3ReqSet
 * JD-Core Version:    0.7.0.1
 */