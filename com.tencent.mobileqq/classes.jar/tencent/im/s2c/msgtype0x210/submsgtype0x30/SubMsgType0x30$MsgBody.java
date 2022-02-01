package tencent.im.s2c.msgtype0x210.submsgtype0x30;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x30$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sub_cmd", "msg_s2c_blocklist_notify" }, new Object[] { Integer.valueOf(0), null }, MsgBody.class);
  public SubMsgType0x30.BlockListNotify msg_s2c_blocklist_notify = new SubMsgType0x30.BlockListNotify();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.MsgBody
 * JD-Core Version:    0.7.0.1
 */