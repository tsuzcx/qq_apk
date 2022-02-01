package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ThemeAuth$ThemeFileInfo
  extends MessageMicro<ThemeFileInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_file_path", "str_file_md5" }, new Object[] { "", "" }, ThemeFileInfo.class);
  public final PBStringField str_file_md5 = PBField.initString("");
  public final PBStringField str_file_path = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.ThemeFileInfo
 * JD-Core Version:    0.7.0.1
 */