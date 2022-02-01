package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FlashChatSso$TSsoRsp
  extends MessageMicro<TSsoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "i32_ret", "str_msg", "st_cmd0x1_rsp" }, new Object[] { Integer.valueOf(0), "", null }, TSsoRsp.class);
  public final PBInt32Field i32_ret = PBField.initInt32(0);
  public FlashChatSso.TSsoCmd0x1Rsp st_cmd0x1_rsp = new FlashChatSso.TSsoCmd0x1Rsp();
  public final PBStringField str_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatSso.TSsoRsp
 * JD-Core Version:    0.7.0.1
 */