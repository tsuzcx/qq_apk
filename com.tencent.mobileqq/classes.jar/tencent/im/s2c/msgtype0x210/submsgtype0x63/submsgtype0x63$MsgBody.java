package tencent.im.s2c.msgtype0x210.submsgtype0x63;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x63$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_roomid", "uint32_seq", "str_url", "str_data" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "" }, MsgBody.class);
  public final PBStringField str_data = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_roomid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x63.submsgtype0x63.MsgBody
 * JD-Core Version:    0.7.0.1
 */