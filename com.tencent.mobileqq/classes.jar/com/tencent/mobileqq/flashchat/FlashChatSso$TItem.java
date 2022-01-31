package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FlashChatSso$TItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66 }, new String[] { "i32_id", "uint32_feetype", "string_name", "string_icon_url", "string_app_name", "string_main_view", "string_ver", "string_bg_color" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "" }, TItem.class);
  public final PBInt32Field i32_id = PBField.initInt32(0);
  public final PBStringField string_app_name = PBField.initString("");
  public final PBStringField string_bg_color = PBField.initString("");
  public final PBStringField string_icon_url = PBField.initString("");
  public final PBStringField string_main_view = PBField.initString("");
  public final PBStringField string_name = PBField.initString("");
  public final PBStringField string_ver = PBField.initString("");
  public final PBUInt32Field uint32_feetype = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatSso.TItem
 * JD-Core Version:    0.7.0.1
 */