package tencent.im.s2c.msgtype0x210.submsgtype0xab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xab$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField string_reward_id = PBField.initString("");
  public final PBUInt32Field uint32_reward_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_gc = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_uin", "uint64_gc", "string_reward_id", "uint32_reward_status" }, new Object[] { localLong, localLong, "", Integer.valueOf(0) }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xab.SubMsgType0xab.MsgBody
 * JD-Core Version:    0.7.0.1
 */