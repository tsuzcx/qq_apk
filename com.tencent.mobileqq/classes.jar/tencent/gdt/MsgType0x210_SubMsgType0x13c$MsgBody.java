package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MsgType0x210_SubMsgType0x13c$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "str_traceid", "str_msg_id", "uint64_msg_time_ms" }, new Object[] { "", "", Long.valueOf(0L) }, MsgBody.class);
  public final PBStringField str_msg_id = PBField.initString("");
  public final PBStringField str_traceid = PBField.initString("");
  public final PBUInt64Field uint64_msg_time_ms = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.MsgType0x210_SubMsgType0x13c.MsgBody
 * JD-Core Version:    0.7.0.1
 */