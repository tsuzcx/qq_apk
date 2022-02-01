package tencent.im.oidb.cmd0xe95;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xe95$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 122 }, new String[] { "msg_send_write_together_msg_rsp", "msg_base_info" }, new Object[] { null, null }, RspBody.class);
  public oidb_0xe95.BaseInfo msg_base_info = new oidb_0xe95.BaseInfo();
  public oidb_0xe95.SendWriteTogetherMsgRsp msg_send_write_together_msg_rsp = new oidb_0xe95.SendWriteTogetherMsgRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe95.oidb_0xe95.RspBody
 * JD-Core Version:    0.7.0.1
 */