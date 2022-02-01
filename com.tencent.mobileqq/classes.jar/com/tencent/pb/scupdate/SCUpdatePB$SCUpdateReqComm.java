package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SCUpdatePB$SCUpdateReqComm
  extends MessageMicro<SCUpdateReqComm>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBInt64Field cookie = PBField.initInt64(0L);
  public final PBUInt32Field force = PBField.initUInt32(0);
  public final PBBytesField from = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field network = PBField.initInt32(0);
  public final PBBytesField osrelease = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field plat = PBField.initUInt32(0);
  public final PBBytesField qver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 64, 72 }, new String[] { "plat", "qver", "osrelease", "network", "from", "cookie", "appid", "uid", "force" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, SCUpdateReqComm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.SCUpdateReqComm
 * JD-Core Version:    0.7.0.1
 */