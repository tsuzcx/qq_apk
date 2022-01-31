package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqavopensdkSsoTunnel$SdkData
  extends MessageMicro
{
  public static final int BYTES_SDK_APP_TOKEN_FIELD_NUMBER = 2;
  public static final int CMLB_TEST_FIELD_NUMBER = 9;
  public static final int TINYID_FIELD_NUMBER = 10;
  public static final int UINT32_SDK_APP_ID_FIELD_NUMBER = 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.SdkData
 * JD-Core Version:    0.7.0.1
 */