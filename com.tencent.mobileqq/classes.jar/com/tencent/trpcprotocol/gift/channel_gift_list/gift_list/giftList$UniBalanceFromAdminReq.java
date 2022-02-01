package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class giftList$UniBalanceFromAdminReq
  extends MessageMicro<UniBalanceFromAdminReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "appid", "Authkey", "DomainID" }, new Object[] { "", "", Integer.valueOf(0) }, UniBalanceFromAdminReq.class);
  public final PBStringField Authkey = PBField.initString("");
  public final PBUInt32Field DomainID = PBField.initUInt32(0);
  public final PBStringField appid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.UniBalanceFromAdminReq
 * JD-Core Version:    0.7.0.1
 */