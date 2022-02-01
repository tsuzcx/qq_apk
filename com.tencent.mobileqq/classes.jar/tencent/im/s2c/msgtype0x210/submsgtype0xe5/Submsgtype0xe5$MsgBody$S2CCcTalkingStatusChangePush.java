package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Submsgtype0xe5$MsgBody$S2CCcTalkingStatusChangePush
  extends MessageMicro<S2CCcTalkingStatusChangePush>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_talking_status", "str_callid" }, new Object[] { Integer.valueOf(0), "" }, S2CCcTalkingStatusChangePush.class);
  public final PBStringField str_callid = PBField.initString("");
  public final PBUInt32Field uint32_talking_status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CCcTalkingStatusChangePush
 * JD-Core Version:    0.7.0.1
 */