package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_imagent$ImAgentPackage
  extends MessageMicro<ImAgentPackage>
{
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int MSG_SEND_REQ_FIELD_NUMBER = 11;
  public static final int MSG_SEND_RESP_FIELD_NUMBER = 12;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 90, 98 }, new String[] { "head", "msg_send_req", "msg_send_resp" }, new Object[] { null, null, null }, ImAgentPackage.class);
  public im_imagent.ImAgentHead head = new im_imagent.ImAgentHead();
  public im_msg.MsgSendReq msg_send_req = new im_msg.MsgSendReq();
  public im_msg.MsgSendResp msg_send_resp = new im_msg.MsgSendResp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_imagent.ImAgentPackage
 * JD-Core Version:    0.7.0.1
 */