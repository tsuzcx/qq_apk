package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xd69$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "cmd_type", "msg_get_list_body", "msg_get_unread_num_body", "msg_report_body", "msg_check_body" }, new Object[] { Integer.valueOf(1), null, null, null, null }, RspBody.class);
  public final PBEnumField cmd_type = PBField.initEnum(1);
  public oidb_cmd0xd69.CheckRspBody msg_check_body = new oidb_cmd0xd69.CheckRspBody();
  public oidb_cmd0xd69.GetListRspBody msg_get_list_body = new oidb_cmd0xd69.GetListRspBody();
  public oidb_cmd0xd69.GetUnreadNumRspBody msg_get_unread_num_body = new oidb_cmd0xd69.GetUnreadNumRspBody();
  public oidb_cmd0xd69.ReportRspBody msg_report_body = new oidb_cmd0xd69.ReportRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.RspBody
 * JD-Core Version:    0.7.0.1
 */