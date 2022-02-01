package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetLocalPhone$MaskPhoneData
  extends MessageMicro<MaskPhoneData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_mask_phone", "str_process_cookies", "str_terms_wording" }, new Object[] { "", "", "" }, MaskPhoneData.class);
  public final PBStringField str_mask_phone = PBField.initString("");
  public final PBStringField str_process_cookies = PBField.initString("");
  public final PBStringField str_terms_wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.MaskPhoneData
 * JD-Core Version:    0.7.0.1
 */