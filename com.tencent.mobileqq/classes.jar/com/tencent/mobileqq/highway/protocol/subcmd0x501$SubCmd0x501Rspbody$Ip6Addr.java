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
  public static final int BYTES_IP6_FIELD_NUMBER = 2;
  public static final int UINT32_AREA_FIELD_NUMBER = 4;
  public static final int UINT32_PORT_FIELD_NUMBER = 3;
  public static final int UINT32_SAME_ISP_FIELD_NUMBER = 5;
  public static final int UINT32_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_area = PBField.initUInt32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_same_isp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "uint32_type", "bytes_ip6", "uint32_port", "uint32_area", "uint32_same_isp" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Ip6Addr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.Ip6Addr
 * JD-Core Version:    0.7.0.1
 */