package tencent.im.login;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class GatewayVerify$ReqBodySelfPhoneLogin
  extends MessageMicro<ReqBodySelfPhoneLogin>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_support_auxinfo_check = PBField.initBool(false);
  public final PBBytesField bytes_phone_token = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 88 }, new String[] { "bytes_phone_token", "bool_support_auxinfo_check" }, new Object[] { localByteStringMicro, Boolean.valueOf(false) }, ReqBodySelfPhoneLogin.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBodySelfPhoneLogin
 * JD-Core Version:    0.7.0.1
 */