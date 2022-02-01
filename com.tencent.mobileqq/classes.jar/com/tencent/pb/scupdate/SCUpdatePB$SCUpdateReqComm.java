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
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 64, 72 }, new String[] { "plat", "qver", "osrelease", "network", "from", "cookie", "appid", "uid", "force" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localByteStringMicro3, localLong, localInteger, localLong, localInteger }, SCUpdateReqComm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.SCUpdateReqComm
 * JD-Core Version:    0.7.0.1
 */