package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetLocalPhone$EncryptPhoneData
  extends MessageMicro<EncryptPhoneData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18 }, new String[] { "str_encypt_phone" }, new Object[] { "" }, EncryptPhoneData.class);
  public final PBStringField str_encypt_phone = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.EncryptPhoneData
 * JD-Core Version:    0.7.0.1
 */