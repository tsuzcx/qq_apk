package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$GroupInfoChange
  extends MessageMicro<GroupInfoChange>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_group_honor_switch", "uint32_group_member_level_switch" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GroupInfoChange.class);
  public final PBUInt32Field uint32_group_honor_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member_level_switch = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.GroupInfoChange
 * JD-Core Version:    0.7.0.1
 */