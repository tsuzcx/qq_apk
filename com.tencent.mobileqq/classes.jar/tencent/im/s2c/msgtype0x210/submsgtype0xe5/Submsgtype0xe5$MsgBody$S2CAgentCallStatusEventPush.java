package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0xe5$MsgBody$S2CAgentCallStatusEventPush
  extends MessageMicro<S2CAgentCallStatusEventPush>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_callid = PBField.initString("");
  public final PBUInt32Field uint32_call_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ring_asr = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_kfext = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint32_type", "uint32_call_status", "uint32_ring_asr", "str_callid", "uint64_from_kfext", "uint32_timestamp" }, new Object[] { localInteger, localInteger, localInteger, "", Long.valueOf(0L), localInteger }, S2CAgentCallStatusEventPush.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CAgentCallStatusEventPush
 * JD-Core Version:    0.7.0.1
 */