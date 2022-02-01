package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VaProfileGate$GetVipCareRsp
  extends MessageMicro<GetVipCareRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_buss = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notice = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_buss", "uint32_notice" }, new Object[] { localInteger, localInteger }, GetVipCareRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.GetVipCareRsp
 * JD-Core Version:    0.7.0.1
 */