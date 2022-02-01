package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_grey_interface$GreyInterfaceReq
  extends MessageMicro<GreyInterfaceReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field clientType = PBField.initUInt32(0);
  public final PBStringField deviceType = PBField.initString("");
  public final PBUInt32Field key = PBField.initUInt32(0);
  public final PBStringField strVersion = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48 }, new String[] { "uin", "version", "deviceType", "clientType", "strVersion", "key" }, new Object[] { Long.valueOf(0L), localInteger, "", localInteger, "", localInteger }, GreyInterfaceReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_grey_interface.GreyInterfaceReq
 * JD-Core Version:    0.7.0.1
 */