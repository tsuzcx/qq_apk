package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class giftList$GetGiftListRsp
  extends MessageMicro<GetGiftListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField AttachInfo = PBField.initString("");
  public final PBRepeatMessageField<giftList.GroupGiftItem> GiftList = PBField.initRepeatMessage(giftList.GroupGiftItem.class);
  public final PBBoolField HasMore = PBField.initBool(false);
  public final PBInt64Field Ret = PBField.initInt64(0L);
  public final PBUInt64Field Total = PBField.initUInt64(0L);
  public final PBUInt32Field duration = PBField.initUInt32(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "Ret", "AttachInfo", "HasMore", "GiftList", "duration", "Total" }, new Object[] { localLong, "", Boolean.valueOf(false), null, Integer.valueOf(0), localLong }, GetGiftListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GetGiftListRsp
 * JD-Core Version:    0.7.0.1
 */