package tencent.im.oidb.cmd0x875;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x875$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_seq", "rpt_msg_interact_list", "uint32_isend" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x875.UserFollowState> rpt_msg_interact_list = PBField.initRepeatMessage(oidb_0x875.UserFollowState.class);
  public final PBUInt32Field uint32_isend = PBField.initUInt32(0);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x875.oidb_0x875.RspBody
 * JD-Core Version:    0.7.0.1
 */