package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class follow_user$FollowUserReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uin", "dst_uin", "follow_type", "source" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1) }, FollowUserReq.class);
  public final PBUInt64Field dst_uin = PBField.initUInt64(0L);
  public final PBEnumField follow_type = PBField.initEnum(0);
  public final PBEnumField source = PBField.initEnum(1);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.nearby.user.relation.follow_user.FollowUserReq
 * JD-Core Version:    0.7.0.1
 */