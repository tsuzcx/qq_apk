package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CSDataHighwayHead$ImageFilterRequest
  extends MessageMicro<ImageFilterRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field client_ip = PBField.initUInt32(0);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBBytesField image_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField session_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public CSDataHighwayHead.FilterStyle style = new CSDataHighwayHead.FilterStyle();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 58 }, new String[] { "session_id", "client_ip", "uin", "style", "width", "height", "image_data" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, ImageFilterRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.ImageFilterRequest
 * JD-Core Version:    0.7.0.1
 */