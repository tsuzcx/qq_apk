package tencent.im.oidb.cmd0xdcc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xdcc$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "rpt_msg_recommend_card", "rpt_msg_entry_delay", "uint64_group_id", "uint32_timestamp" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0xdcc.EntryDelay> rpt_msg_entry_delay = PBField.initRepeatMessage(oidb_cmd0xdcc.EntryDelay.class);
  public final PBRepeatMessageField<oidb_cmd0xdcc.RecommendCard> rpt_msg_recommend_card = PBField.initRepeatMessage(oidb_cmd0xdcc.RecommendCard.class);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.RspBody
 * JD-Core Version:    0.7.0.1
 */