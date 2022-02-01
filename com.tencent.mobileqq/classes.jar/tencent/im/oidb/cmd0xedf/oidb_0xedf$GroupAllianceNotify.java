package tencent.im.oidb.cmd0xedf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xedf$GroupAllianceNotify
  extends MessageMicro<GroupAllianceNotify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint64_alliance_id", "uint64_alliance_owner", "uint64_leader_group_code", "st_apply_alliance", "uint32_result" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0) }, GroupAllianceNotify.class);
  public oidb_0xedf.ApplyAlliance st_apply_alliance = new oidb_0xedf.ApplyAlliance();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_alliance_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_alliance_owner = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_leader_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xedf.oidb_0xedf.GroupAllianceNotify
 * JD-Core Version:    0.7.0.1
 */