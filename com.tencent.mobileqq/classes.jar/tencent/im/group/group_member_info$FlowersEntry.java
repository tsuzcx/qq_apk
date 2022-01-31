package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_member_info$FlowersEntry
  extends MessageMicro<FlowersEntry>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_flower_count" }, new Object[] { Long.valueOf(0L) }, FlowersEntry.class);
  public final PBUInt64Field uint64_flower_count = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.group.group_member_info.FlowersEntry
 * JD-Core Version:    0.7.0.1
 */