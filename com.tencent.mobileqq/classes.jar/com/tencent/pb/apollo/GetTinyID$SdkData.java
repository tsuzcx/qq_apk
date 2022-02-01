package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetTinyID$SdkData
  extends MessageMicro<SdkData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sdk_app_token = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField cmlb_test = PBField.initBool(false);
  public final PBStringField tinyid = PBField.initString("");
  public final PBUInt32Field uint32_sdk_app_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 72, 82 }, new String[] { "uint32_sdk_app_id", "bytes_sdk_app_token", "cmlb_test", "tinyid" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Boolean.valueOf(false), "" }, SdkData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apollo.GetTinyID.SdkData
 * JD-Core Version:    0.7.0.1
 */