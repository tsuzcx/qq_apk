package tencent.im.login;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$UinInfo
  extends MessageMicro<UinInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_encrypt_uin = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_image_url = PBField.initString("");
  public final PBStringField str_mask_uin = PBField.initString("");
  public final PBStringField str_nick = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_mask_uin", "str_nick", "str_image_url", "bytes_encrypt_uin" }, new Object[] { "", "", "", localByteStringMicro }, UinInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.UinInfo
 * JD-Core Version:    0.7.0.1
 */