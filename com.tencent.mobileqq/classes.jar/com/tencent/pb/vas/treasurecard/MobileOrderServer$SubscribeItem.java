package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MobileOrderServer$SubscribeItem
  extends MessageMicro<SubscribeItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ProductID", "ProductName" }, new Object[] { "", "" }, SubscribeItem.class);
  public final PBStringField ProductID = PBField.initString("");
  public final PBStringField ProductName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vas.treasurecard.MobileOrderServer.SubscribeItem
 * JD-Core Version:    0.7.0.1
 */