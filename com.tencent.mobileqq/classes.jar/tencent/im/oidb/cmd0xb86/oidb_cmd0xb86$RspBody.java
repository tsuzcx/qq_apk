package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xb86$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 82 }, new String[] { "msg_user_info", "msg_modify_flag", "str_notify" }, new Object[] { null, null, "" }, RspBody.class);
  public oidb_cmd0xb86.UserInfoModifyFlag msg_modify_flag = new oidb_cmd0xb86.UserInfoModifyFlag();
  public oidb_cmd0xb86.UserInfo msg_user_info = new oidb_cmd0xb86.UserInfo();
  public final PBStringField str_notify = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.RspBody
 * JD-Core Version:    0.7.0.1
 */