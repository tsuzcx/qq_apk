package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$diyThemeInfo
  extends MessageMicro<diyThemeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uin32_drawer_tab_id", "uin32_message_tab_id", "uin32_aio_tab_id", "uin32_freind_tab_id", "uin32_dynamics_tab_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, diyThemeInfo.class);
  public final PBUInt32Field uin32_aio_tab_id = PBField.initUInt32(0);
  public final PBUInt32Field uin32_drawer_tab_id = PBField.initUInt32(0);
  public final PBUInt32Field uin32_dynamics_tab_id = PBField.initUInt32(0);
  public final PBUInt32Field uin32_freind_tab_id = PBField.initUInt32(0);
  public final PBUInt32Field uin32_message_tab_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.diyThemeInfo
 * JD-Core Version:    0.7.0.1
 */