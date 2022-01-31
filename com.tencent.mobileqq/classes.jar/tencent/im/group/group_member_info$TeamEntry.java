package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_member_info$TeamEntry
  extends MessageMicro<TeamEntry>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rpt_uint64_depid", "rpt_uint64_self_depid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, TeamEntry.class);
  public final PBRepeatField<Long> rpt_uint64_depid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_self_depid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.group.group_member_info.TeamEntry
 * JD-Core Version:    0.7.0.1
 */