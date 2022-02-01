package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$RspDiyThemeInfo
  extends MessageMicro<RspDiyThemeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 56, 66, 72, 82 }, new String[] { "uin32_drawer_tab_id", "str_drawer_tab_url", "uin32_message_tab_id", "str_message_tab_url", "uin32_aio_tab_id", "str_aio_tab_url", "uin32_friend_tab_id", "str_friend_tab_url", "uin32_dynamic_tab_id", "str_dynamic_tab_url" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "" }, RspDiyThemeInfo.class);
  public final PBStringField str_aio_tab_url = PBField.initString("");
  public final PBStringField str_drawer_tab_url = PBField.initString("");
  public final PBStringField str_dynamic_tab_url = PBField.initString("");
  public final PBStringField str_friend_tab_url = PBField.initString("");
  public final PBStringField str_message_tab_url = PBField.initString("");
  public final PBUInt32Field uin32_aio_tab_id = PBField.initUInt32(0);
  public final PBUInt32Field uin32_drawer_tab_id = PBField.initUInt32(0);
  public final PBUInt32Field uin32_dynamic_tab_id = PBField.initUInt32(0);
  public final PBUInt32Field uin32_friend_tab_id = PBField.initUInt32(0);
  public final PBUInt32Field uin32_message_tab_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.RspDiyThemeInfo
 * JD-Core Version:    0.7.0.1
 */