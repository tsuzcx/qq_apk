package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetLocalPhone$GetUrlRspBody
  extends MessageMicro<GetUrlRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_msg_id", "str_seq_no", "rpt_local_phone_url" }, new Object[] { "", "", null }, GetUrlRspBody.class);
  public final PBRepeatMessageField<GetLocalPhone.LocalPhoneUploadUrl> rpt_local_phone_url = PBField.initRepeatMessage(GetLocalPhone.LocalPhoneUploadUrl.class);
  public final PBStringField str_msg_id = PBField.initString("");
  public final PBStringField str_seq_no = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.GetUrlRspBody
 * JD-Core Version:    0.7.0.1
 */