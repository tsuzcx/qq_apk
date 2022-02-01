package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x978$FollowStatusInfo
  extends MessageMicro<FollowStatusInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "enum_follow_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, FollowStatusInfo.class);
  public final PBEnumField enum_follow_status = PBField.initEnum(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x978.oidb_cmd0x978.FollowStatusInfo
 * JD-Core Version:    0.7.0.1
 */