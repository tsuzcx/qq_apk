package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xd69$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "cmd_type", "msg_get_list_body", "msg_delete_body", "msg_check_body" }, new Object[] { Integer.valueOf(1), null, null, null }, ReqBody.class);
  public final PBEnumField cmd_type = PBField.initEnum(1);
  public oidb_cmd0xd69.CheckReqBody msg_check_body = new oidb_cmd0xd69.CheckReqBody();
  public oidb_cmd0xd69.DeleteReqBody msg_delete_body = new oidb_cmd0xd69.DeleteReqBody();
  public oidb_cmd0xd69.GetListReqBody msg_get_list_body = new oidb_cmd0xd69.GetListReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.ReqBody
 * JD-Core Version:    0.7.0.1
 */