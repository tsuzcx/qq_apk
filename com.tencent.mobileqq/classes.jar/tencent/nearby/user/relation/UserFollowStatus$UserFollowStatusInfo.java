package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserFollowStatus$UserFollowStatusInfo
  extends MessageMicro<UserFollowStatusInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "dst_uin", "follow_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, UserFollowStatusInfo.class);
  public final PBUInt64Field dst_uin = PBField.initUInt64(0L);
  public final PBEnumField follow_status = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.nearby.user.relation.UserFollowStatus.UserFollowStatusInfo
 * JD-Core Version:    0.7.0.1
 */