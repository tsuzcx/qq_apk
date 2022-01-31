package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CSDataHighwayHead$LoginSigHead
  extends MessageMicro<LoginSigHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_loginsig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_loginsig_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_loginsig_type", "bytes_loginsig" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, LoginSigHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead
 * JD-Core Version:    0.7.0.1
 */