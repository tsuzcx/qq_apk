package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MobileOrderServer$GetIfSignRequest
  extends MessageMicro<GetIfSignRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "appid", "signContent" }, new Object[] { Integer.valueOf(0), "" }, GetIfSignRequest.class);
  public final PBInt32Field appid = PBField.initInt32(0);
  public final PBStringField signContent = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vas.treasurecard.MobileOrderServer.GetIfSignRequest
 * JD-Core Version:    0.7.0.1
 */