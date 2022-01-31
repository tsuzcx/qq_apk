package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STCommon$STReqItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field protoType = PBField.initUInt32(0);
  public final PBStringField reqData = PBField.initString("");
  public final PBBytesField reqPbData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField strCmd = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "strCmd", "protoType", "reqData", "reqPbData" }, new Object[] { "", Integer.valueOf(0), "", localByteStringMicro }, STReqItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.apollo.STCommon.STReqItem
 * JD-Core Version:    0.7.0.1
 */