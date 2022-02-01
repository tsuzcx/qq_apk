package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$GroupInfoChange
  extends MessageMicro<GroupInfoChange>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_appeal_deadline = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_class_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flagext3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flagext4 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_honor_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_info_ext_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member_level_switch = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 56, 64, 72 }, new String[] { "uint32_group_honor_switch", "uint32_group_member_level_switch", "uint32_group_flagext4", "uint32_appeal_deadline", "uint32_group_flag", "uint32_group_flagext3", "uint32_group_class_ext", "uint32_group_info_ext_seq" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, GroupInfoChange.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.GroupInfoChange
 * JD-Core Version:    0.7.0.1
 */