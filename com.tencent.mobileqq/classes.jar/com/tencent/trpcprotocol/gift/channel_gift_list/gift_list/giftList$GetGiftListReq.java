package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class giftList$GetGiftListReq
  extends MessageMicro<GetGiftListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "GiftListId", "AttachInfo" }, new Object[] { "", "" }, GetGiftListReq.class);
  public final PBStringField AttachInfo = PBField.initString("");
  public final PBStringField GiftListId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GetGiftListReq
 * JD-Core Version:    0.7.0.1
 */