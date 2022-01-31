package tencent.im.oidb.oidb_0x8e6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8e6$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint32_level", "uint32_can_vote_free_user_count", "uint32_can_vote_free_count", "uint32_remain_total", "int32_consume_total", "rpt_vote_result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
  public final PBInt32Field int32_consume_total = PBField.initInt32(0);
  public final PBRepeatMessageField<oidb_0x8e6.VoteResult> rpt_vote_result = PBField.initRepeatMessage(oidb_0x8e6.VoteResult.class);
  public final PBUInt32Field uint32_can_vote_free_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_can_vote_free_user_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_remain_total = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.RspBody
 * JD-Core Version:    0.7.0.1
 */