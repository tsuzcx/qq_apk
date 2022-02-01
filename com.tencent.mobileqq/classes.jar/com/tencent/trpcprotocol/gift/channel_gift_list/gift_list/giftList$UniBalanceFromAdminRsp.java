package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class giftList$UniBalanceFromAdminRsp
  extends MessageMicro<UniBalanceFromAdminRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField RechargeUrl = PBField.initString("");
  public final PBInt64Field Ret = PBField.initInt64(0L);
  public final PBStringField RetMsg = PBField.initString("");
  public final PBUInt64Field balance = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "balance", "RechargeUrl", "Ret", "RetMsg" }, new Object[] { localLong, "", localLong, "" }, UniBalanceFromAdminRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.UniBalanceFromAdminRsp
 * JD-Core Version:    0.7.0.1
 */