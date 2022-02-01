package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetLocalPhone$GetPhoneRspBody
  extends MessageMicro<GetPhoneRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "str_msg_id", "str_seq_no", "int32_phone_data_type", "msg_mask_phone_data", "msg_encrypt_phone_data" }, new Object[] { "", "", Integer.valueOf(0), null, null }, GetPhoneRspBody.class);
  public final PBInt32Field int32_phone_data_type = PBField.initInt32(0);
  public GetLocalPhone.EncryptPhoneData msg_encrypt_phone_data = new GetLocalPhone.EncryptPhoneData();
  public GetLocalPhone.MaskPhoneData msg_mask_phone_data = new GetLocalPhone.MaskPhoneData();
  public final PBStringField str_msg_id = PBField.initString("");
  public final PBStringField str_seq_no = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.GetPhoneRspBody
 * JD-Core Version:    0.7.0.1
 */