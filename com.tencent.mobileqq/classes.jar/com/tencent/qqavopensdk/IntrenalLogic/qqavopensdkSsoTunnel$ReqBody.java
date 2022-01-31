package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqavopensdkSsoTunnel$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int BYTES_REQBODY_FIELD_NUMBER = 2;
  public static final int MSG_SDK_DATA_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_reqbody = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqavopensdkSsoTunnel.SdkData msg_sdk_data = new qqavopensdkSsoTunnel.SdkData();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_sdk_data", "bytes_reqbody" }, new Object[] { null, localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.ReqBody
 * JD-Core Version:    0.7.0.1
 */