package tencent.im.wireless_reg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CaptchaVerifyInfo$captchaVerifyInfo
  extends MessageMicro<captchaVerifyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ticket = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_randstr = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_ticket", "str_randstr" }, new Object[] { localByteStringMicro, "" }, captchaVerifyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.wireless_reg.CaptchaVerifyInfo.captchaVerifyInfo
 * JD-Core Version:    0.7.0.1
 */