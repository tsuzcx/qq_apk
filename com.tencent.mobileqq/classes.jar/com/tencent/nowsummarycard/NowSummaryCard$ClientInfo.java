package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowSummaryCard$ClientInfo
  extends MessageMicro<ClientInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField client_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField imei = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "client_version", "platform", "imei" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ClientInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.ClientInfo
 * JD-Core Version:    0.7.0.1
 */