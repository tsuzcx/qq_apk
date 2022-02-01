package tencent.im.sso2sns.cmd0x3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class sso2sns_0x3_blocklist$RspBody
  extends MessageMicro<RspBody>
{
  public static final int MSG_BODY_ADD_BLOCKLIST_FIELD_NUMBER = 2;
  public static final int MSG_BODY_DEL_BLOCKLIST_FIELD_NUMBER = 3;
  public static final int MSG_BODY_GET_BLOCKLIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_body_get_blocklist", "msg_body_add_blocklist", "msg_body_del_blocklist" }, new Object[] { null, null, null }, RspBody.class);
  public sso2sns_0x3_blocklist.RspBodyAddBlockList msg_body_add_blocklist = new sso2sns_0x3_blocklist.RspBodyAddBlockList();
  public sso2sns_0x3_blocklist.RspBodyDelBlockList msg_body_del_blocklist = new sso2sns_0x3_blocklist.RspBodyDelBlockList();
  public sso2sns_0x3_blocklist.RspBodyGetBlockList msg_body_get_blocklist = new sso2sns_0x3_blocklist.RspBodyGetBlockList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.RspBody
 * JD-Core Version:    0.7.0.1
 */