package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MobileOrderServer$GetIfSignReply
  extends MessageMicro<GetIfSignReply>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "RetCode", "RetMsg", "sign" }, new Object[] { Integer.valueOf(0), "", "" }, GetIfSignReply.class);
  public final PBInt32Field RetCode = PBField.initInt32(0);
  public final PBStringField RetMsg = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vas.treasurecard.MobileOrderServer.GetIfSignReply
 * JD-Core Version:    0.7.0.1
 */