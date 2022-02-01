package tencent.im.s2c.msgtype0x210.submsgtype0x111;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x111$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<SubMsgType0x111.MayKnowPerson> rpt_msg_add_recommend_persons = PBField.initRepeatMessage(SubMsgType0x111.MayKnowPerson.class);
  public final PBRepeatField<Long> rpt_uint64_del_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_type", "rpt_msg_add_recommend_persons", "rpt_uint64_del_uins" }, new Object[] { localLong, null, localLong }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111.MsgBody
 * JD-Core Version:    0.7.0.1
 */