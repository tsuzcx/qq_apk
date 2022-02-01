package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetLocalPhone$PlainPhoneData
  extends MessageMicro<PlainPhoneData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_plain_phone" }, new Object[] { "" }, PlainPhoneData.class);
  public final PBStringField str_plain_phone = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.PlainPhoneData
 * JD-Core Version:    0.7.0.1
 */