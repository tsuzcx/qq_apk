package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$DiyThemeDetail
  extends MessageMicro<DiyThemeDetail>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_bg_preview_url = PBField.initString("");
  public final PBStringField str_bg_thumbnail_url = PBField.initString("");
  public final PBStringField str_bg_url = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBUInt32Field uin32_feetype = PBField.initUInt32(0);
  public final PBUInt32Field uin32_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "uin32_id", "str_name", "uin32_feetype", "str_bg_url", "str_bg_thumbnail_url", "str_bg_preview_url" }, new Object[] { localInteger, "", localInteger, "", "", "" }, DiyThemeDetail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.DiyThemeDetail
 * JD-Core Version:    0.7.0.1
 */