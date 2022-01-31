package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STCommon$STRspItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField errMsg = PBField.initString("");
  public final PBUInt32Field protoType = PBField.initUInt32(0);
  public final PBInt64Field ret = PBField.initInt64(0L);
  public final PBStringField rspData = PBField.initString("");
  public final PBBytesField rspPbData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField strCmd = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50 }, new String[] { "strCmd", "ret", "errMsg", "protoType", "rspData", "rspPbData" }, new Object[] { "", Long.valueOf(0L), "", Integer.valueOf(0), "", localByteStringMicro }, STRspItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.apollo.STCommon.STRspItem
 * JD-Core Version:    0.7.0.1
 */