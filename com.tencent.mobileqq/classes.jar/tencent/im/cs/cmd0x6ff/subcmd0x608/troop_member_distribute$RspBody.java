package tencent.im.cs.cmd0x6ff.subcmd0x608;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class troop_member_distribute$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public troop_member_distribute.GenderNumber msg_gender_number = new troop_member_distribute.GenderNumber();
  public final PBRepeatMessageField<troop_member_distribute.OStatisticInfo> rpt_msg_statistic = PBField.initRepeatMessage(troop_member_distribute.OStatisticInfo.class);
  public final PBUInt32Field uint32_group_max_member = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "uint32_result", "uint64_group_code", "uint32_group_max_member", "uint32_group_member", "rpt_msg_statistic", "msg_gender_number" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localInteger, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.RspBody
 * JD-Core Version:    0.7.0.1
 */