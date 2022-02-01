package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class giftList$SendGiftRsp
  extends MessageMicro<SendGiftRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "Ret", "Retmsg" }, new Object[] { Integer.valueOf(0), "" }, SendGiftRsp.class);
  public final PBInt32Field Ret = PBField.initInt32(0);
  public final PBStringField Retmsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.SendGiftRsp
 * JD-Core Version:    0.7.0.1
 */