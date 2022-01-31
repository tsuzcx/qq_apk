package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FlashChatSso$TSsoCmd0x1Rsp
  extends MessageMicro<TSsoCmd0x1Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "item" }, new Object[] { null }, TSsoCmd0x1Rsp.class);
  public final PBRepeatMessageField<FlashChatSso.TItem> item = PBField.initRepeatMessage(FlashChatSso.TItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatSso.TSsoCmd0x1Rsp
 * JD-Core Version:    0.7.0.1
 */