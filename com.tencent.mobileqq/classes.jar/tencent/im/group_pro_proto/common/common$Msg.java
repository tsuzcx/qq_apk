package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import tencent.im.msg.im_msg_body.MsgBody;

public final class common$Msg
  extends MessageMicro<Msg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "head", "ctrl_head", "body", "ext_info" }, new Object[] { null, null, null, null }, Msg.class);
  public im_msg_body.MsgBody body = new im_msg_body.MsgBody();
  public common.MsgCtrlHead ctrl_head = new common.MsgCtrlHead();
  public common.ExtInfo ext_info = new common.ExtInfo();
  public common.MsgHead head = new common.MsgHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.common.common.Msg
 * JD-Core Version:    0.7.0.1
 */