package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$SubCmd0x1RspAuth
  extends MessageMicro<SubCmd0x1RspAuth>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66, 72, 82, 88, 98 }, new String[] { "int32_result", "uint32_theme_id", "str_download_url", "str_version", "uint32_size", "int32_is_sound_theme", "int32_suit_id", "str_err_msg", "uint32_diy_theme_flag", "rsp_diy_theme_info", "int32_disable_download", "rsp_diy_theme_detail" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null, Integer.valueOf(0), null }, SubCmd0x1RspAuth.class);
  public final PBInt32Field int32_disable_download = PBField.initInt32(0);
  public final PBInt32Field int32_is_sound_theme = PBField.initInt32(0);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBInt32Field int32_suit_id = PBField.initInt32(0);
  public ThemeAuth.RspDiyThemeDetail rsp_diy_theme_detail = new ThemeAuth.RspDiyThemeDetail();
  public ThemeAuth.RspDiyThemeInfo rsp_diy_theme_info = new ThemeAuth.RspDiyThemeInfo();
  public final PBStringField str_download_url = PBField.initString("");
  public final PBStringField str_err_msg = PBField.initString("");
  public final PBStringField str_version = PBField.initString("");
  public final PBUInt32Field uint32_diy_theme_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.SubCmd0x1RspAuth
 * JD-Core Version:    0.7.0.1
 */