package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FlashChatSso$TSsoReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "i32_cmd", "i32_implat", "str_qq_ver" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, TSsoReq.class);
  public final PBInt32Field i32_cmd = PBField.initInt32(0);
  public final PBInt32Field i32_implat = PBField.initInt32(0);
  public final PBStringField str_qq_ver = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatSso.TSsoReq
 * JD-Core Version:    0.7.0.1
 */