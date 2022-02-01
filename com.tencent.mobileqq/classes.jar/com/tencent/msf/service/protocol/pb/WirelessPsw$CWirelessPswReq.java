package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WirelessPsw$CWirelessPswReq
  extends MessageMicro
{
  public static final int CMD_FIELD_NUMBER = 5;
  public static final int IP_FIELD_NUMBER = 2;
  public static final int KSID_FIELD_NUMBER = 4;
  public static final int TIME_FIELD_NUMBER = 3;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBUInt32Field ip = PBField.initUInt32(0);
  public final PBBytesField ksid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field time = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uin", "ip", "time", "ksid", "cmd" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localByteStringMicro, localInteger }, CWirelessPswReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.WirelessPsw.CWirelessPswReq
 * JD-Core Version:    0.7.0.1
 */