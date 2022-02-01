package tencent.im.s2c.msgtype0x210.submsgtype0x65;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x65$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_cmd", "msg_expired_pkg" }, new Object[] { Integer.valueOf(0), null }, MsgBody.class);
  public SubMsgType0x65.MsgExpiredPkg msg_expired_pkg = new SubMsgType0x65.MsgExpiredPkg();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x65.SubMsgType0x65.MsgBody
 * JD-Core Version:    0.7.0.1
 */