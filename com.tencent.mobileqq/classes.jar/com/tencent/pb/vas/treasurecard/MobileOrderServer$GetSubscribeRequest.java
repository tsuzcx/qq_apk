package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MobileOrderServer$GetSubscribeRequest
  extends MessageMicro<GetSubscribeRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "appid", "UserCode" }, new Object[] { Integer.valueOf(0), "" }, GetSubscribeRequest.class);
  public final PBStringField UserCode = PBField.initString("");
  public final PBInt32Field appid = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vas.treasurecard.MobileOrderServer.GetSubscribeRequest
 * JD-Core Version:    0.7.0.1
 */