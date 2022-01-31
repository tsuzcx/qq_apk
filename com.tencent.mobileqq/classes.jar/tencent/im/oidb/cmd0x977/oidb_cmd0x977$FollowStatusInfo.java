package tencent.im.oidb.cmd0x977;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x977$FollowStatusInfo
  extends MessageMicro<FollowStatusInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 82, 88, 96, 106, 112 }, new String[] { "uint64_uin", "enum_status", "enum_account_type", "enum_fans_status", "msg_topic_info", "enum_forbid_idol_status", "enum_forbid_fans_status", "user_info", "uint32_is_being_followed" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(-1), Integer.valueOf(-1), null, Integer.valueOf(0) }, FollowStatusInfo.class);
  public final PBEnumField enum_account_type = PBField.initEnum(1);
  public final PBEnumField enum_fans_status = PBField.initEnum(0);
  public final PBEnumField enum_forbid_fans_status = PBField.initEnum(-1);
  public final PBEnumField enum_forbid_idol_status = PBField.initEnum(-1);
  public final PBEnumField enum_status = PBField.initEnum(0);
  public oidb_cmd0x977.FollowTopicInfo msg_topic_info = new oidb_cmd0x977.FollowTopicInfo();
  public final PBUInt32Field uint32_is_being_followed = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  public oidb_cmd0x977.KdUserInfo user_info = new oidb_cmd0x977.KdUserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowStatusInfo
 * JD-Core Version:    0.7.0.1
 */