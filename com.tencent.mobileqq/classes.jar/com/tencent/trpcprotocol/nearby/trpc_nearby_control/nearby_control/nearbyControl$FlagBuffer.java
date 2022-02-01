package com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearbyControl$FlagBuffer
  extends MessageMicro<FlagBuffer>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField bufferMd5 = PBField.initString("");
  public final PBUInt32Field bufferType = PBField.initUInt32(0);
  public final PBStringField customizeKey = PBField.initString("");
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBUInt32Field indexId = PBField.initUInt32(0);
  public final PBUInt32Field subcode = PBField.initUInt32(0);
  public final PBUInt64Field timeStamp = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58, 64 }, new String[] { "indexId", "flag", "buffer", "bufferType", "timeStamp", "bufferMd5", "customizeKey", "subcode" }, new Object[] { localInteger, localInteger, localByteStringMicro, localInteger, Long.valueOf(0L), "", "", localInteger }, FlagBuffer.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.FlagBuffer
 * JD-Core Version:    0.7.0.1
 */