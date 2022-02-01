package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WirelessMibao$CWirelessMibaoReq
  extends MessageMicro
{
  public static final int CMD_FIELD_NUMBER = 7;
  public static final int GUID_FIELD_NUMBER = 5;
  public static final int IMEI_FIELD_NUMBER = 6;
  public static final int IP_FIELD_NUMBER = 2;
  public static final int KSID_FIELD_NUMBER = 4;
  public static final int TIME_FIELD_NUMBER = 3;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBBytesField guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField imei = PBField.initString("");
  public final PBUInt32Field ip = PBField.initUInt32(0);
  public final PBBytesField ksid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field time = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56 }, new String[] { "uin", "ip", "time", "ksid", "guid", "imei", "cmd" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, "", localInteger }, CWirelessMibaoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.WirelessMibao.CWirelessMibaoReq
 * JD-Core Version:    0.7.0.1
 */