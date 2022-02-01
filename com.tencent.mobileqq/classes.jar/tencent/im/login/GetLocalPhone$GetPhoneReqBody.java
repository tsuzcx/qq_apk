package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetLocalPhone$GetPhoneReqBody
  extends MessageMicro<GetPhoneReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_phone_data_type = PBField.initInt32(0);
  public final PBInt64Field int64_timestamp = PBField.initInt64(0L);
  public final PBInt32Field int_device_id_type = PBField.initInt32(0);
  public final PBInt32Field int_user_id_type = PBField.initInt32(0);
  public final PBRepeatMessageField<GetLocalPhone.LocalPhoneCodeData> rpt_local_code_data = PBField.initRepeatMessage(GetLocalPhone.LocalPhoneCodeData.class);
  public final PBStringField str_app_class = PBField.initString("");
  public final PBStringField str_app_sub_id = PBField.initString("");
  public final PBStringField str_app_sub_id_ext = PBField.initString("");
  public final PBStringField str_cell_ip = PBField.initString("");
  public final PBStringField str_device_id = PBField.initString("");
  public final PBStringField str_mask_phone = PBField.initString("");
  public final PBStringField str_msg_id = PBField.initString("");
  public final PBStringField str_process_cookies = PBField.initString("");
  public final PBStringField str_seq_no = PBField.initString("");
  public final PBStringField str_user_id = PBField.initString("");
  public final PBStringField str_user_ip = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 64, 74, 80, 90, 98, 106, 112, 122, 130 }, new String[] { "str_app_class", "str_app_sub_id", "str_app_sub_id_ext", "str_msg_id", "str_seq_no", "int_user_id_type", "str_user_id", "int_device_id_type", "str_device_id", "int32_phone_data_type", "rpt_local_code_data", "str_cell_ip", "str_user_ip", "int64_timestamp", "str_process_cookies", "str_mask_phone" }, new Object[] { "", "", "", "", "", localInteger, "", localInteger, "", localInteger, null, "", "", Long.valueOf(0L), "", "" }, GetPhoneReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.GetPhoneReqBody
 * JD-Core Version:    0.7.0.1
 */