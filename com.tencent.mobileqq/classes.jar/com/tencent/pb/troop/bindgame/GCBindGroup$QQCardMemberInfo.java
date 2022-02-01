package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GCBindGroup$QQCardMemberInfo
  extends MessageMicro<QQCardMemberInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "game_name", "level_name", "level_icon", "game_font_color", "game_background_color", "game_url", "desc_info" }, new Object[] { "", "", "", "", "", "", "" }, QQCardMemberInfo.class);
  public final PBRepeatField<String> desc_info = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField game_background_color = PBField.initString("");
  public final PBStringField game_font_color = PBField.initString("");
  public final PBStringField game_name = PBField.initString("");
  public final PBStringField game_url = PBField.initString("");
  public final PBStringField level_icon = PBField.initString("");
  public final PBStringField level_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.troop.bindgame.GCBindGroup.QQCardMemberInfo
 * JD-Core Version:    0.7.0.1
 */