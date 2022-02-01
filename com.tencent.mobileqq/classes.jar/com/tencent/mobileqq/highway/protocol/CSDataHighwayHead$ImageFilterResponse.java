package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CSDataHighwayHead$ImageFilterResponse
  extends MessageMicro<ImageFilterResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cost_time = PBField.initUInt32(0);
  public final PBBytesField image_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field ret_code = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret_code", "image_data", "cost_time" }, new Object[] { localInteger, localByteStringMicro, localInteger }, ImageFilterResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.ImageFilterResponse
 * JD-Core Version:    0.7.0.1
 */