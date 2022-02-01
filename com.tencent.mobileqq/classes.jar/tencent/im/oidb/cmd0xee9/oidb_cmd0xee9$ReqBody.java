package tencent.im.oidb.cmd0xee9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xee9$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "client_info", "rpt_acount_info", "msg_user_option" }, new Object[] { null, null, null }, ReqBody.class);
  public oidb_cmd0xee9.ClientInfo client_info = new oidb_cmd0xee9.ClientInfo();
  public oidb_cmd0xee9.UserInfoOption msg_user_option = new oidb_cmd0xee9.UserInfoOption();
  public final PBRepeatMessageField<oidb_cmd0xee9.AccountInfo> rpt_acount_info = PBField.initRepeatMessage(oidb_cmd0xee9.AccountInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.ReqBody
 * JD-Core Version:    0.7.0.1
 */