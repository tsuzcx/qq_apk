package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0xe5$MsgBody$S2CSMSEventPush
  extends MessageMicro<S2CSMSEventPush>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint32_type", "str_phone_num", "uint64_timestamp", "str_sms_id", "str_event_msg" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), "", "" }, S2CSMSEventPush.class);
  public final PBStringField str_event_msg = PBField.initString("");
  public final PBStringField str_phone_num = PBField.initString("");
  public final PBStringField str_sms_id = PBField.initString("");
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CSMSEventPush
 * JD-Core Version:    0.7.0.1
 */