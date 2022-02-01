package tencent.im.oidb.cmd0xaf6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xaf6$GroupMember
  extends MessageMicro<GroupMember>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "uins" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GroupMember.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaf6.cmd0xaf6.GroupMember
 * JD-Core Version:    0.7.0.1
 */