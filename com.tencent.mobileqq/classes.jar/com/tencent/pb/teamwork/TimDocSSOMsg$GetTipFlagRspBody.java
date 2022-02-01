package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TimDocSSOMsg$GetTipFlagRspBody
  extends MessageMicro<GetTipFlagRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_retcode", "uint32_flag" }, new Object[] { localInteger, localInteger }, GetTipFlagRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.GetTipFlagRspBody
 * JD-Core Version:    0.7.0.1
 */