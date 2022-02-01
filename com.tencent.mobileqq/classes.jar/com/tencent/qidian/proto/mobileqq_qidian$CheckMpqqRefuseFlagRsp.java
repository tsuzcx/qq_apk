package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_qidian$CheckMpqqRefuseFlagRsp
  extends MessageMicro<CheckMpqqRefuseFlagRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBUInt32Field uint32_is_refuse = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_result", "uint32_is_refuse" }, new Object[] { localInteger, localInteger }, CheckMpqqRefuseFlagRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.CheckMpqqRefuseFlagRsp
 * JD-Core Version:    0.7.0.1
 */