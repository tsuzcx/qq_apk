package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$IpAddr
  extends MessageMicro<IpAddr>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 40 }, new String[] { "uint32_type", "uint32_ip", "uint32_port", "uint32_area", "uint32_same_isp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, IpAddr.class);
  public final PBUInt32Field uint32_area = PBField.initUInt32(0);
  public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_same_isp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpAddr
 * JD-Core Version:    0.7.0.1
 */