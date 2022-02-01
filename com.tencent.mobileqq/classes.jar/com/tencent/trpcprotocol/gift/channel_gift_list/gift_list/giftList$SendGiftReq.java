package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class giftList$SendGiftReq
  extends MessageMicro<SendGiftReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField AuthKey = PBField.initString("");
  public final PBUInt64Field ChannelId = PBField.initUInt64(0L);
  public final PBUInt32Field GiftId = PBField.initUInt32(0);
  public final PBUInt64Field GroupId = PBField.initUInt64(0L);
  public final PBUInt64Field RecverTinyid = PBField.initUInt64(0L);
  public final PBEnumField SendType = PBField.initEnum(0);
  public final PBUInt64Field SenderTinyid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "SenderTinyid", "RecverTinyid", "GiftId", "SendType", "ChannelId", "GroupId", "AuthKey" }, new Object[] { localLong, localLong, localInteger, localInteger, localLong, localLong, "" }, SendGiftReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.SendGiftReq
 * JD-Core Version:    0.7.0.1
 */