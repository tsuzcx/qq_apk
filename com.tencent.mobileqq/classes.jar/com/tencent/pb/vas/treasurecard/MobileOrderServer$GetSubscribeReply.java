package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileOrderServer$GetSubscribeReply
  extends MessageMicro<GetSubscribeReply>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field IsFlowFree = PBField.initInt32(0);
  public final PBRepeatMessageField<MobileOrderServer.SubscribeItem> ItemList = PBField.initRepeatMessage(MobileOrderServer.SubscribeItem.class);
  public final PBStringField MaxExpiredTime = PBField.initString("");
  public final PBUInt32Field NextReqTime = PBField.initUInt32(0);
  public final PBInt32Field RetCode = PBField.initInt32(0);
  public final PBStringField RetMsg = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48 }, new String[] { "RetMsg", "RetCode", "IsFlowFree", "ItemList", "MaxExpiredTime", "NextReqTime" }, new Object[] { "", localInteger, localInteger, null, "", localInteger }, GetSubscribeReply.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vas.treasurecard.MobileOrderServer.GetSubscribeReply
 * JD-Core Version:    0.7.0.1
 */