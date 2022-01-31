package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$SubCmd0x1ReqAuth
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_op_type", "uint32_theme_id", "str_theme_version", "str_theme_density_type", "rpt_msg_topic_file_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", null }, SubCmd0x1ReqAuth.class);
  public final PBRepeatMessageField rpt_msg_topic_file_info = PBField.initRepeatMessage(ThemeAuth.ThemeFileInfo.class);
  public final PBStringField str_theme_density_type = PBField.initString("");
  public final PBStringField str_theme_version = PBField.initString("");
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.SubCmd0x1ReqAuth
 * JD-Core Version:    0.7.0.1
 */