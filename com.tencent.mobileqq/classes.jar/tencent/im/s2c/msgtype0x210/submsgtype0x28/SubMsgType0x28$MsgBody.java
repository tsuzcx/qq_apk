package tencent.im.s2c.msgtype0x210.submsgtype0x28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x28$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_sub_cmd", "msg_rsp_followlist", "msg_rsp_typelist" }, new Object[] { Integer.valueOf(0), null, null }, MsgBody.class);
  public SubMsgType0x28.RspFollowList msg_rsp_followlist = new SubMsgType0x28.RspFollowList();
  public SubMsgType0x28.RspTypeList msg_rsp_typelist = new SubMsgType0x28.RspTypeList();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.MsgBody
 * JD-Core Version:    0.7.0.1
 */