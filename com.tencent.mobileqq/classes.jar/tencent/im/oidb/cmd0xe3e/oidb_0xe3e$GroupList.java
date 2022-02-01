package tencent.im.oidb.cmd0xe3e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe3e$GroupList
  extends MessageMicro<GroupList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_group_code", "uint32_common_friend_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GroupList.class);
  public final PBUInt32Field uint32_common_friend_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3e.oidb_0xe3e.GroupList
 * JD-Core Version:    0.7.0.1
 */