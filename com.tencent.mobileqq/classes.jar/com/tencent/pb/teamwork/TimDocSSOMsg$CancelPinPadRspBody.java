package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TimDocSSOMsg$CancelPinPadRspBody
  extends MessageMicro<CancelPinPadRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_list_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "uint32_retcode", "bytes_pad_url", "uint32_list_type", "uint32_domainid", "bytes_localpadid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, CancelPinPadRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.CancelPinPadRspBody
 * JD-Core Version:    0.7.0.1
 */