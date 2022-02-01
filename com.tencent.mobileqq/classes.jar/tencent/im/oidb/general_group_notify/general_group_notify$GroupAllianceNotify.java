package tencent.im.oidb.general_group_notify;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class general_group_notify$GroupAllianceNotify
  extends MessageMicro<GroupAllianceNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_alliance_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_alliance_owner_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public general_group_notify.ApplyAlliance st_apply_alliance = new general_group_notify.ApplyAlliance();
  public final PBUInt32Field uint32_alliance_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_alliance_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_alliance_owner = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_leader_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 58, 64 }, new String[] { "uint32_alliance_notify_type", "uint64_alliance_id", "bytes_alliance_name", "uint64_alliance_owner", "bytes_alliance_owner_name", "uint64_leader_group_code", "st_apply_alliance", "uint32_result" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L), null, Integer.valueOf(0) }, GroupAllianceNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.general_group_notify.general_group_notify.GroupAllianceNotify
 * JD-Core Version:    0.7.0.1
 */