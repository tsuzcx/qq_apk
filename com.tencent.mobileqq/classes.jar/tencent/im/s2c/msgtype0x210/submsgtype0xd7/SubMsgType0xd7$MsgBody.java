package tencent.im.s2c.msgtype0x210.submsgtype0xd7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xd7$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint32_type", "uint32_msgbox_unread_count", "uint32_unread_count", "msg_content", "uint64_timestamp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L) }, MsgBody.class);
  public SubMsgType0xd7.Content msg_content = new SubMsgType0xd7.Content();
  public final PBUInt32Field uint32_msgbox_unread_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xd7.SubMsgType0xd7.MsgBody
 * JD-Core Version:    0.7.0.1
 */