package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class mobileqq_dynamic_search$ExtensionRequestInfo
  extends MessageMicro<ExtensionRequestInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField action = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFloatField latitude = PBField.initFloat(0.0F);
  public final PBFloatField longitude = PBField.initFloat(0.0F);
  public final PBInt32Field radius = PBField.initInt32(0);
  public final PBBytesField region = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 29, 32, 42, 50 }, new String[] { "action", "latitude", "longitude", "radius", "city", "region" }, new Object[] { localByteStringMicro1, Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, ExtensionRequestInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ExtensionRequestInfo
 * JD-Core Version:    0.7.0.1
 */