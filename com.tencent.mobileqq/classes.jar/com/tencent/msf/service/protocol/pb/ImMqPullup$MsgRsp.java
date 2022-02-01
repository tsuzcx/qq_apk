package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ImMqPullup$MsgRsp
  extends MessageMicro
{
  public static final int COMMAND_FIELD_NUMBER = 1;
  public static final int UINT32_ITV_FIELD_NUMBER = 3;
  public static final int UINT32_RET_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField command = PBField.initEnum(1);
  public final PBUInt32Field uint32_itv = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "command", "uint32_ret", "uint32_itv" }, new Object[] { Integer.valueOf(1), localInteger, localInteger }, MsgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.ImMqPullup.MsgRsp
 * JD-Core Version:    0.7.0.1
 */