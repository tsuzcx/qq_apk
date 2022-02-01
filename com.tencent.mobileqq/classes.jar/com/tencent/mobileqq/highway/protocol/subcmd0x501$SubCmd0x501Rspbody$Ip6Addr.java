package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$Ip6Addr
  extends MessageMicro<Ip6Addr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_area = PBField.initUInt32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_same_isp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "uint32_type", "bytes_ip6", "uint32_port", "uint32_area", "uint32_same_isp" }, new Object[] { localInteger, localByteStringMicro, localInteger, localInteger, localInteger }, Ip6Addr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.Ip6Addr
 * JD-Core Version:    0.7.0.1
 */