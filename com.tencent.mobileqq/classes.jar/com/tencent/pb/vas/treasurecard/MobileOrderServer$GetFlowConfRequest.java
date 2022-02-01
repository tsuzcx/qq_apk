package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class MobileOrderServer$GetFlowConfRequest
  extends MessageMicro<GetFlowConfRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field BizType = PBField.initInt32(0);
  public final PBInt32Field appid = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "BizType" }, new Object[] { localInteger, localInteger }, GetFlowConfRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vas.treasurecard.MobileOrderServer.GetFlowConfRequest
 * JD-Core Version:    0.7.0.1
 */