package tencent.im.s2c.msgtype0x210.submsgtype0xc9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc9$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint32_type", "uint64_from_uin", "uint64_action_uin", "source", "rpt_msg_business_msg", "bool_new_friend" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, Boolean.valueOf(false) }, MsgBody.class);
  public final PBBoolField bool_new_friend = PBField.initBool(false);
  public final PBRepeatMessageField rpt_msg_business_msg = PBField.initRepeatMessage(submsgtype0xc9.BusinessMsg.class);
  public final PBEnumField source = PBField.initEnum(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_action_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc9.submsgtype0xc9.MsgBody
 * JD-Core Version:    0.7.0.1
 */