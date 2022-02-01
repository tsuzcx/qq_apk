package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MobileOrderServer$GetFlowConfReply
  extends MessageMicro<GetFlowConfReply>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field BizType = PBField.initInt32(0);
  public final PBStringField JumpUrl = PBField.initString("");
  public final PBInt32Field RetCode = PBField.initInt32(0);
  public final PBStringField RetMsg = PBField.initString("");
  public final PBStringField Tips = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "RetCode", "RetMsg", "JumpUrl", "Tips", "BizType" }, new Object[] { localInteger, "", "", "", localInteger }, GetFlowConfReply.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vas.treasurecard.MobileOrderServer.GetFlowConfReply
 * JD-Core Version:    0.7.0.1
 */